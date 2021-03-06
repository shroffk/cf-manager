package gov.bnl.channelfinder.report;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Check that the length of the pv names does not exceed 60 chars.
 */
public class PVNamesLengthProcessor implements PVNamesProcessor {

    private Set<String> pvNames;

    @Override
    public String call() {
        List<String> longNames = pvNames.stream().filter(pvName -> {
            return pvName.length() > 60;
        }).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder("PV names violating the 60 char limit: " + longNames.size());
        sb.append(System.lineSeparator());
        sb.append(longNames.stream().collect(Collectors.joining(" ")));
        return sb.toString();
    }

    @Override
    public void setPVNames(Set<String> pvNames) {
        this.pvNames = pvNames;
    }
}
