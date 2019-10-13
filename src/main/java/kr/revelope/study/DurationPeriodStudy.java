package kr.revelope.study;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.StringJoiner;

public class DurationPeriodStudy {
	/**
	 * 작업에 소요된 시간을 출력한다.
	 * 소요시간이 없다면 출력하지 않는다.
	 *
	 * ex ) 2년 1개월 5일 10시간 20분 50초
	 * ex ) 1년 4개월 10시간 20분 50초
	 * ex ) 2개월 20분 50초
	 * ex ) 1일 14시간 25분 55초
	 *
	 */
	public String getDurationString(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		Period period = Period.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());
		int years = period.getYears();
		int months = period.getMonths();
		int days = period.getDays();

		Duration duration = Duration.between(startDateTime, endDateTime);
		int hours = (int)(duration.toHours() % 24);
		int minutes = (int)(duration.toMinutes() % 60);
		int seconds = (int)((duration.toMillis() / 1000) % 60);

		return joinIfNotEmptyString(" ",
			appendUnitIfMoreThanZero(years, "년"),
			appendUnitIfMoreThanZero(months, "개월"),
			appendUnitIfMoreThanZero(days, "일"),
			appendUnitIfMoreThanZero(hours, "시간"),
			appendUnitIfMoreThanZero(minutes, "분"),
			appendUnitIfMoreThanZero(seconds, "초")
		);
	}

	private String appendUnitIfMoreThanZero(int number, String unit) {
		return number > 0 ? number + unit : "";
	}

	private String joinIfNotEmptyString(String delimiter, String... elements) {
		StringJoiner joiner = new StringJoiner(delimiter);
		for (String str : elements) {
			if (str == null || str.equals("")) {
				continue;
			}

			joiner.add(str);
		}

		return joiner.toString();
	}
}
