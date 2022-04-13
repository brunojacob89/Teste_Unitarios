package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		
		BonusService service = new BonusService();
//		assertThrows(IllegalArgumentException.class,
//										() -> service.calcularBonus(new Funcionario("Bruno", LocalDate.now(), new BigDecimal("25000"))));

		try {
			service.calcularBonus(new Funcionario("Bruno", LocalDate.now(), new BigDecimal("25000")));
			fail("não deu a exception!");
		} catch (Exception e) {

			assertEquals("Funcionário com salário maior do que R$10000 nao pode receber bonus!", e.getMessage());
		}
		
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoDoSalario() {
		
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Bruno", LocalDate.now(), new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonus() {
		
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Bruno", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
