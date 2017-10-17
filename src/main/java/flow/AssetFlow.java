package flow;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public interface AssetFlow {

    String getId();

    Map<LocalDate, BigDecimal> getTimeSeries ();
}
