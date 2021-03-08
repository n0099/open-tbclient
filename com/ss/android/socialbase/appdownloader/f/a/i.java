package com.ss.android.socialbase.appdownloader.f.a;
/* loaded from: classes6.dex */
public class i extends Exception {

    /* renamed from: a  reason: collision with root package name */
    protected Throwable f7767a;
    protected int b;
    protected int c;

    public i(String str, h hVar, Throwable th) {
        super((str == null ? "" : str + " ") + (hVar == null ? "" : "(position:" + hVar.d() + ") ") + (th == null ? "" : "caused by: " + th));
        this.b = -1;
        this.c = -1;
        if (hVar != null) {
            this.b = hVar.c();
            this.c = hVar.f();
        }
        this.f7767a = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.f7767a == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
            this.f7767a.printStackTrace();
        }
    }
}
