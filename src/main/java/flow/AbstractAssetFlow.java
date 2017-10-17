package flow;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractAssetFlow implements AssetFlow {

    private final Map<LocalDate, BigDecimal> timeseries = new TreeMap<>();
    private final String id;

    protected AbstractAssetFlow(final String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    protected void fillTimeseries() {
    }

    protected Map<LocalDate, BigDecimal> getTimeseries() {
        return timeseries;
    }
}
