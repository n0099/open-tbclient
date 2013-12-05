package javassist;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends l {

    /* renamed from: a  reason: collision with root package name */
    private l f3023a;
    private l d;
    private l e;

    @Override // javassist.l
    protected void a(StringBuffer stringBuffer) {
    }

    @Override // javassist.l
    public int b() {
        return 0;
    }

    @Override // javassist.l
    public String i() {
        return null;
    }

    @Override // javassist.l
    public String e() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        super(jVar);
        this.f3023a = this;
        this.d = this;
        this.e = this;
        this.e.b = this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l a() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l d() {
        return this.f3023a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l f() {
        return this.f3023a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l g() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l h() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l k() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar) {
        lVar.b = this.f3023a.b;
        this.f3023a.b = lVar;
        if (this.f3023a == this.d) {
            this.d = lVar;
            if (this.f3023a == this.e) {
                this.e = lVar;
            }
        }
        this.f3023a = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(l lVar) {
        lVar.b = this.d.b;
        this.d.b = lVar;
        if (this.d == this.e) {
            this.e = lVar;
        }
        this.d = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(l lVar) {
        lVar.b = this;
        this.e.b = lVar;
        this.e = lVar;
    }
}
