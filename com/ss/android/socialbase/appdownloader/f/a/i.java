package com.ss.android.socialbase.appdownloader.f.a;
/* loaded from: classes4.dex */
public class i extends Exception {

    /* renamed from: a  reason: collision with root package name */
    protected Throwable f13348a;

    /* renamed from: b  reason: collision with root package name */
    protected int f13349b;
    protected int c;

    public i(String str, h hVar, Throwable th) {
        super((str == null ? "" : str + " ") + (hVar == null ? "" : "(position:" + hVar.d() + ") ") + (th == null ? "" : "caused by: " + th));
        this.f13349b = -1;
        this.c = -1;
        if (hVar != null) {
            this.f13349b = hVar.c();
            this.c = hVar.f();
        }
        this.f13348a = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.f13348a == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
            this.f13348a.printStackTrace();
        }
    }
}
