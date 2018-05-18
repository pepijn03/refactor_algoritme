package analysis.context;

import ait.CodeContext;
import analysis.MethodAnalyzer.ClassMethodFinder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodInterfaceDeclaration implements IContextDetector {

    private ClassMethodFinder _analyzer = null;
    private String _methodName = null;
    private Map<String,List<String>> _parameterMap = new HashMap<>();

    public MethodInterfaceDeclaration(ClassMethodFinder cmf, String methodName) {
        this._analyzer = cmf;
        this._methodName = methodName;
    }

    public MethodInterfaceDeclaration(ContextConfiguration cc) {
        this._analyzer = cc.getCMFAnalyzer();
        this._methodName = cc.getMethodName();
    }

    public boolean detect() throws Exception {
        boolean result = false;

        if(_analyzer != null)
        {
            if(_analyzer.isMethodDeclaredFirstTimeInInterface(_methodName))
            {
                _parameterMap.put("$interface", Arrays.asList(_analyzer.methodDefinedInInterface()));
                result = true;
            }
        }
        else
        {
            throw(new Exception("Analyzer = null"));
        }

        return result;
    }

    @Override
    public Map<String,List<String>> getParameterMap() {
        return _parameterMap;
    }

    @Override
    public CodeContext.CodeContextEnum getType() {
        return CodeContext.CodeContextEnum.MethodInterfaceDeclaration;
    }
}