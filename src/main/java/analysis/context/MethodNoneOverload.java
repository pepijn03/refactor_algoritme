package analysis.context;

import aig.CodeContext;

public class MethodNoneOverload extends ContextDetector {

         MethodOverload _mo = null;

        public MethodNoneOverload(ContextConfiguration cc)    {

            super(cc);
            _mo = new MethodOverload(cc);
        }

        @Override
        public boolean detect() throws Exception {
            return !_mo.detect();
        }

        @Override
        public CodeContext.CodeContextEnum getType() {
            return CodeContext.CodeContextEnum.MethodNoneOverload;
        }
}
