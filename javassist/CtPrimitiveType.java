package javassist;
/* loaded from: classes.dex */
public final class CtPrimitiveType extends h {

    /* renamed from: a  reason: collision with root package name */
    private char f2907a;
    private String n;
    private String o;
    private String p;
    private int q;
    private int r;
    private int s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CtPrimitiveType(String str, char c, String str2, String str3, String str4, int i, int i2, int i3) {
        super(str);
        this.f2907a = c;
        this.n = str2;
        this.o = str3;
        this.p = str4;
        this.q = i;
        this.r = i2;
        this.s = i3;
    }

    @Override // javassist.h
    public boolean m() {
        return true;
    }

    @Override // javassist.h
    public int c() {
        return 17;
    }

    public char y() {
        return this.f2907a;
    }

    public String z() {
        return this.n;
    }

    public String A() {
        return this.o;
    }

    public String B() {
        return this.p;
    }

    public int C() {
        return this.q;
    }

    public int D() {
        return this.s;
    }
}
