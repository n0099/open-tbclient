package javassist;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends h {

    /* renamed from: a  reason: collision with root package name */
    protected c f3020a;
    private h[] n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(String str, c cVar) {
        super(str);
        this.n = null;
        this.f3020a = cVar;
    }

    @Override // javassist.h
    public c a() {
        return this.f3020a;
    }

    @Override // javassist.h
    public boolean b() {
        return true;
    }

    @Override // javassist.h
    public int c() {
        try {
            return 16 | (e().c() & 7);
        } catch (NotFoundException e) {
            return 16;
        }
    }

    @Override // javassist.h
    public h[] d() {
        if (this.n == null) {
            Class<?>[] interfaces = Object[].class.getInterfaces();
            this.n = new h[interfaces.length];
            for (int i = 0; i < interfaces.length; i++) {
                this.n[i] = this.f3020a.c(interfaces[i].getName());
            }
        }
        return this.n;
    }

    @Override // javassist.h
    public boolean a(h hVar) {
        boolean z = false;
        if (super.a(hVar) || hVar.n().equals("java.lang.Object")) {
            return true;
        }
        for (h hVar2 : d()) {
            if (hVar2.a(hVar)) {
                return true;
            }
        }
        if (hVar.b() && e().a(hVar.e())) {
            z = true;
        }
        return z;
    }

    @Override // javassist.h
    public h e() {
        String n = n();
        return this.f3020a.c(n.substring(0, n.length() - 2));
    }

    @Override // javassist.h
    public h f() {
        return this.f3020a.c("java.lang.Object");
    }

    @Override // javassist.h
    public CtMethod a(String str, String str2) {
        return f().a(str, str2);
    }
}
