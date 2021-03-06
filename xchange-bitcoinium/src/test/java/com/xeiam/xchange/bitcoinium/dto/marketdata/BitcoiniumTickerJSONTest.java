package com.xeiam.xchange.bitcoinium.dto.marketdata;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xeiam.xchange.bitcoinium.dto.marketdata.BitcoiniumTicker;

/**
 * Test BitcoiniumTicker JSON parsing
 */
public class BitcoiniumTickerJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is = BitcoiniumTickerJSONTest.class.getResourceAsStream("/marketdata/example-ticker-data.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    BitcoiniumTicker bitcoiniumTicker = mapper.readValue(is, BitcoiniumTicker.class);

    // Verify that the example data was unmarshalled correctly
    assertThat(bitcoiniumTicker.getLast()).isEqualTo(new BigDecimal("516.8"));
    assertThat(bitcoiniumTicker.getHigh()).isEqualTo(new BigDecimal("523.09"));
    assertThat(bitcoiniumTicker.getLow()).isEqualTo(new BigDecimal("508.28"));
    assertThat(bitcoiniumTicker.getVolume()).isEqualTo(new BigDecimal("3522"));
  }

}
