package kr.revelope.study;

import java.time.Instant;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstantStudyTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(InstantStudyTest.class);

	private InstantStudy instantStudy = new InstantStudy();

	@Test
	public void Instant_생성하기() {
		// 현재 instant 생성 1
		Instant nowInstant1 = Instant.now();
		LOGGER.info("Instant.now() : {}", nowInstant1);

		// 현재 instnat 생성 2 (1과 동일)
		Instant nowInstant2 = Instant.ofEpochMilli(System.currentTimeMillis());
		LOGGER.info("Instant.ofEpochMilli(currentTimeMillis) : {}", nowInstant2);
	}
}
