package analysis.context;

import aig.CodeContext;

/**
 * This class is the inverse of MethodExtractNameHiding
 */
public class MethodExtractNoNameHiding extends MethodExtract {

    MethodExtractNameHiding _menh;

    public MethodExtractNoNameHiding(ContextConfiguration cc) {
        super(cc);

        _menh = new MethodExtractNameHiding(cc);
    }

    @Override
    public boolean detect() throws Exception {

        return !_menh.detect();
    }

    @Override
    public CodeContext.CodeContextEnum getType() {
        return CodeContext.CodeContextEnum.MethodExtractNoNameHiding;
    }

}