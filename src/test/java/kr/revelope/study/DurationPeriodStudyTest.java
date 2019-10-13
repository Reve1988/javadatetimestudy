package kr.revelope.study;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DurationPeriodStudyTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(DurationPeriodStudyTest.class);

	private DurationPeriodStudy durationPeriodStudy = new DurationPeriodStudy();

	@Test
	public void LocalDateTime으로_Duration_생성하기() {
		LocalDateTime startDateTime = LocalDateTime.of(LocalDate.of(2019, 10, 1), LocalTime.MIDNIGHT);
		LocalDateTime endDateTime = LocalDateTime.of(LocalDate.of(2019, 10, 2), LocalTime.NOON);

		Duration duration = Duration.between(startDateTime, endDateTime);

		LOGGER.info("두 날짜시간 간격 : {}분", duration.toMinutes());
		LOGGER.info("두 날짜시간 간격  : {}시간", duration.toHours());
		LOGGER.info("두 날짜시간 간격  : {}일", duration.toDays());
	}

	@Test
	public void LocalDateTime으로_Period_생성하기() {
		LocalDate startDate = LocalDate.of(2019, 9, 1);
		LocalDate endDate = LocalDate.of(2020, 11, 2);

		Period period = Period.between(startDate, endDate);

		LOGGER.info("두 날짜 간격 : {}일", period.getDays());
		LOGGER.info("두 날짜 간격  : {}월", period.getMonths());
		LOGGER.info("두 날짜 간격  : {}년", period.getYears());
	}

	@Test
	public void Duation_Period_연산하기() {
		testGetDurationString(
			LocalDateTime.of(2019, 10, 1, 22, 1, 45),
			LocalDateTime.of(2019, 10, 1, 22, 2, 1),
			"16초"
		);
		testGetDurationString(
			LocalDateTime.of(2019, 9, 30, 10, 0, 0),
			LocalDateTime.of(2019, 10, 1, 22, 25, 55),
			"1일 12시간 25분 55초"
		);
		testGetDurationString(
			LocalDateTime.of(2019, 9, 30, 10, 0, 0),
			LocalDateTime.of(2020, 4, 5, 1, 15, 22),
			"6개월 6일 15시간 15분 22초"
		);
		testGetDurationString(
			LocalDateTime.of(2019, 9, 30, 10, 0, 0),
			LocalDateTime.of(2030, 5, 12, 1, 50, 30),
			"10년 7개월 12일 15시간 50분 30초"
		);
	}

	private void testGetDurationString(LocalDateTime startDateTime, LocalDateTime endDateTime, String expected) {
		String result = durationPeriodStudy.getDurationString(startDateTime, endDateTime);

		LOGGER.info("소요 시간 : {}", result);
		assertThat(result, is(expected));
	}
}
