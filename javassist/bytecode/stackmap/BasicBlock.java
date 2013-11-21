package javassist.bytecode.stackmap;

import javassist.bytecode.BadBytecode;
/* loaded from: classes.dex */
public class BasicBlock {
    protected int b;
    protected int c = 0;
    protected int d = 0;
    protected BasicBlock[] e;
    protected boolean f;
    protected a g;

    /* loaded from: classes.dex */
    class JsrBytecode extends BadBytecode {
        /* JADX INFO: Access modifiers changed from: package-private */
        public JsrBytecode() {
            super("JSR");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BasicBlock(int i) {
        this.b = i;
    }

    public static BasicBlock a(BasicBlock[] basicBlockArr, int i) {
        for (int i2 = 0; i2 < basicBlockArr.length; i2++) {
            int i3 = basicBlockArr[i2].b;
            if (i3 <= i && i < i3 + basicBlockArr[i2].c) {
                return basicBlockArr[i2];
            }
        }
        throw new BadBytecode("no basic block at " + i);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            name = name.substring(lastIndexOf + 1);
        }
        stringBuffer.append(name);
        stringBuffer.append("[");
        a(stringBuffer);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(StringBuffer stringBuffer) {
        stringBuffer.append("pos=").append(this.b).append(", len=").append(this.c).append(", in=").append(this.d).append(", exit{");
        if (this.e != null) {
            for (int i = 0; i < this.e.length; i++) {
                stringBuffer.append(this.e[i].b).append(",");
            }
        }
        stringBuffer.append("}, {");
        for (a aVar = this.g; aVar != null; aVar = aVar.f2812a) {
            stringBuffer.append("(").append(aVar.b.b).append(", ").append(aVar.c).append("), ");
        }
        stringBuffer.append("}");
    }
}
