package javassist.bytecode.analysis;

import javassist.bytecode.stackmap.BasicBlock;
/* loaded from: classes.dex */
public class ControlFlow {

    /* loaded from: classes.dex */
    public class Block extends BasicBlock {

        /* renamed from: a  reason: collision with root package name */
        Block[] f2931a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // javassist.bytecode.stackmap.BasicBlock
        public void a(StringBuffer stringBuffer) {
            super.a(stringBuffer);
            stringBuffer.append(", incoming{");
            for (int i = 0; i < this.f2931a.length; i++) {
                stringBuffer.append(this.f2931a[i].b).append(", ");
            }
            stringBuffer.append("}");
        }
    }
}
