package analysis;

import java.util.List;

public interface IVariableFlowInfoMarking {
    void setVariableFlowList(List<VariableFlowTable> lst);
    List<VariableFlowTable> getVariableFlowList();
}