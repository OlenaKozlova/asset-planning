package flow;

import com.google.common.collect.ImmutableMap;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

// TODO add hash and equals. Add tests.
public class OneTimeAssetFlow extends AbstractAssetFlow {

    private final LocalDate date;
    private final BigDecimal amount;


    public OneTimeAssetFlow(final String id,
                            final LocalDate date,
                            final BigDecimal amount) {
        super(id);
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public Map<LocalDate, BigDecimal> getTimeSeries() {
        if (getTimeseries().isEmpty()) {
            fillTimeseries();
        }
        return ImmutableMap.copyOf(getTimeSeries());
    }

    @Override
    protected void fillTimeseries() {
        getTimeseries().put(date, amount);
    }

}
