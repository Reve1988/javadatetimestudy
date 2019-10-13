package kr.revelope.study;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDateTimeStudyTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalDateTimeStudyTest.class);

	private LocalDateTimeStudy localDateTimeStudy = new LocalDateTimeStudy();

	@Test
	public void LocalDateTime_생성하기() {
		// 날짜만 추출 (참고 : ISO 8601 국제시간표준출력 읽는 방법 알아보기)
		LocalDate nowDate = LocalDate.now();
		LOGGER.info("nowDate : {}", nowDate);

		// 시간만 추출
		LocalTime nowTime = LocalTime.now();
		LOGGER.info("nowTime : {}", nowTime);

		// 날짜와 시간으로 날짜시간생성
		LocalDateTime localDateTime = LocalDateTime.of(nowDate, nowTime);
		LOGGER.info("localDateTime : {}", localDateTime);

		// 날짜시간 직접 만들기
		LocalDateTime nowDateTime = LocalDateTime.of(2019, 10, 13, 14, 5, 16);
		LOGGER.info("nowDateTime : {}", nowDateTime);

		// 국제표준 날짜시간 생성하기
		ZonedDateTime zonedDateTime = nowDateTime.atZone(ZoneId.of("Asia/Seoul"));
		LOGGER.info("zonedDateTime : {}", zonedDateTime);
		LOGGER.info("AvailableZoneIds : {}", ZoneId.getAvailableZoneIds());
	}

	@Test
	public void LocalDateTime_연산하기() {
		LocalDateTime someDateTime = LocalDateTime.of(2019, 10, 10, 5, 30, 15);
		LOGGER.info("주어진 날짜시간 : {}", someDateTime);

		LocalDateTime result = null;

		asserting(
			"주어진 날짜시간의 정각",
			"2019-10-10T05:00:00",
			localDateTimeStudy.getJustAtTime(someDateTime)
		);
		asserting(
			"주어진 날짜시간의 정확히 한시간 뒤",
			"2019-10-10T06:30:15",
			localDateTimeStudy.addHour(someDateTime)
		);
		asserting(
			"주어진 날짜시간의 1일",
			"2019-10-01T05:30:15",
			localDateTimeStudy.getFirstDayOfMonth(someDateTime)
		);
		asserting(
			"주어진 날짜시간의 1일 자정",
			"2019-10-01T00:00:00",
			localDateTimeStudy.getFirstDayMidnightOfMonth(someDateTime)
		);
		asserting(
			"주어진 날짜시간의 전월 마지막 날짜 정오",
			"2019-09-30T00:00:00",
			localDateTimeStudy.getLastDayMidnightOfPreviousMonth(someDateTime)
		);
		asserting(
			"주어진 날짜시간이 30분보다 작으면 0분 0초, 아니면 30분 0초",
			"2019-10-10T05:30:00",
			localDateTimeStudy.getOnTimeOrHalfTime(someDateTime)
		);
		asserting(
			"주어진 날짜시간이 한국시간[GMT+9](Asia/Seoul)이라고 할 때 영국시간[GMT+1](Europe/London)으로 변환",
			"2019-10-09T21:30:15",
			localDateTimeStudy.changeSeoulTimeToLondon(someDateTime)
		);
	}

	private void asserting(String message, String expected, LocalDateTime result) {
		String resultString = result.format(DateTimeFormatter.ISO_DATE_TIME);
		LOGGER.info(message + " : {}", resultString);
		assertThat(resultString, is(expected));
	}
}
