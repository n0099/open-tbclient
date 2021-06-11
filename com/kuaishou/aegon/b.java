package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final a f32152a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32153b;

    public b(a aVar, String str) {
        this.f32152a = aVar;
        this.f32153b = str;
    }

    public static Runnable a(a aVar, String str) {
        return new b(aVar, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32152a.a(this.f32153b);
    }
}
