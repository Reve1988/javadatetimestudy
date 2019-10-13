package kr.revelope.study;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemporalAdjustersStudyTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(TemporalAdjustersStudyTest.class);

	@Test
	public void temporalAdjusters_활용하기() {
		LocalDate now = LocalDate.now();

		LOGGER.info("이번달 첫째날 : {}", now.with(TemporalAdjusters.firstDayOfMonth()));
		LOGGER.info("이번달 마지막날 : {}", now.with(TemporalAdjusters.lastDayOfMonth()));
		LOGGER.info("저번주 금요일 : {}", now.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)));
		LOGGER.info("다음주 월요일 : {}", now.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
		LOGGER.info("내년 2월 마지막날 : {}", now.plusYears(1).withMonth(2).with(TemporalAdjusters.lastDayOfMonth()));
	}
}