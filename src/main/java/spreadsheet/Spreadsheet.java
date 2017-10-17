package spreadsheet;

import com.google.common.collect.ImmutableSet;
import flow.AssetFlow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.emptySet;
import static java.util.stream.Collectors.toList;

public class Spreadsheet {

    private final String id;
    private final Set<AssetFlow> assetFlows;
    private final Set<Spreadsheet> innerSpreadsheets;


    public Spreadsheet(final String id,
                       final Set<AssetFlow> assetFlows,
                       final Set<Spreadsheet> innerSpreadsheets) {
        this.id = id;
        this.assetFlows = new HashSet<>(assetFlows);
        this.innerSpreadsheets = innerSpreadsheets;
    }

    public Spreadsheet(final String id) {
        this.id = id;
        this.assetFlows = emptySet();
        this.innerSpreadsheets = emptySet();
    }

    public String getId() {
        return id;
    }

    public Set<AssetFlow> getAssetFlows() {
        return ImmutableSet.copyOf(assetFlows);
    }

    public void addAssetFlow(final AssetFlow assetFlow) {
        assetFlows.add(assetFlow);
    }

    public void deleteAssetFlow(final String assetFlowId) {
        // TODO improve it
        final List<AssetFlow> flowToBeDeleted = assetFlows
                                                      .stream()
                                                      .filter(flow -> flow
                                                                            .getId()
                                                                            .equals(assetFlowId))
                                                      .collect(toList());
        assetFlows.removeAll(flowToBeDeleted);
    }

    public void addSpreadsheet(final Spreadsheet spreadsheet) {
        innerSpreadsheets.add(spreadsheet);
    }

    public void deleteSpreadsheet(final String spreadsheetId) {
        final List<Spreadsheet> spreadsheetToBeDeleted = innerSpreadsheets
                                                               .stream()
                                                               .filter(s -> s
                                                                                  .getId()
                                                                                  .equals(spreadsheetId))
                                                               .collect(toList());
        innerSpreadsheets.removeAll(spreadsheetToBeDeleted);
    }
}

