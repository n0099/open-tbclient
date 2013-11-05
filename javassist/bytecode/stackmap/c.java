package javassist.bytecode.stackmap;
/* loaded from: classes.dex */
class c implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    int f2781a;
    BasicBlock b = null;
    BasicBlock[] c = null;
    boolean d = false;
    int e = 0;
    a f = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        this.f2781a = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof c) {
            return this.f2781a - ((c) obj).f2781a;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(BasicBlock[] basicBlockArr, int i, boolean z) {
        this.c = basicBlockArr;
        this.e = i;
        this.d = z;
    }
}
