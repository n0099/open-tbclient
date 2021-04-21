package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final a f31995a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31996b;

    public b(a aVar, String str) {
        this.f31995a = aVar;
        this.f31996b = str;
    }

    public static Runnable a(a aVar, String str) {
        return new b(aVar, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f31995a.a(this.f31996b);
    }
}
