package kr.revelope.study;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class LocalDateTimeStudy {
	/**
	 * 들어온 날짜시간의 정각
	 */
	public LocalDateTime getJustAtTime(LocalDateTime localDateTime) {
		return LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.of(localDateTime.getHour(), 0, 0));
	}

	/**
	 * 들어온 날짜시간의 정확히 한시간 뒤
	 */
	public LocalDateTime addHour(LocalDateTime localDateTime) {
		return localDateTime.plusHours(1);
	}

	/**
	 * 들어온 날짜시간의 1일
	 */
	public LocalDateTime getFirstDayOfMonth(LocalDateTime localDateTime) {
		return localDateTime.withDayOfMonth(1);
	}

	/**
	 * 들어온 날짜시간의 1일 자정
	 */
	public LocalDateTime getFirstDayMidnightOfMonth(LocalDateTime localDateTime) {
		return LocalDateTime.of(localDateTime.toLocalDate().withDayOfMonth(1), LocalTime.MIDNIGHT);
	}

	/**
	 * 들어온 날짜시간의 전월 마지막 날짜 정오
	 */
	public LocalDateTime getLastDayMidnightOfPreviousMonth(LocalDateTime localDateTime) {
		return LocalDateTime.of(localDateTime.withDayOfMonth(1).minusDays(1).toLocalDate(), LocalTime.MIDNIGHT);
	}

	/**
	 * 주어진 날짜시간이 30분보다 작으면 0분 0초, 아니면 30분 0초
	 */
	public LocalDateTime getOnTimeOrHalfTime(LocalDateTime localDateTime) {
		LocalDate localDate = localDateTime.toLocalDate();
		LocalTime localTime = localDateTime.toLocalTime();

		int hour = localTime.getHour();
		int minute = localTime.getMinute() < 30 ? 0 : 30;

		return LocalDateTime.of(localDate, LocalTime.of(hour, minute, 0));
	}

	/**
	 * 주어진 날짜시간이 한국시간(Asia/Seoul)이라고 할 때 영국시간(Europe/London)으로 변환
	 */
	public LocalDateTime changeSeoulTimeToLondon(LocalDateTime localDateTime) {
		return localDateTime
			.atZone(ZoneId.of("Asia/Seoul"))
			.withZoneSameInstant(ZoneId.of("Europe/London"))
			.toLocalDateTime();
	}
}
