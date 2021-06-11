package com.xiaomi.push;
/* loaded from: classes7.dex */
public class fv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fs f41293a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f412a;

    public fv(fs fsVar, String str) {
        this.f41293a = fsVar;
        this.f412a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cs.a().a(this.f412a, true);
    }
}
