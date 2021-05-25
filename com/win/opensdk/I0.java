package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class I0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f36833a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ K0 f36834b;

    public I0(K0 k0, Info info) {
        this.f36834b = k0;
        this.f36833a = info;
    }

    @Override // java.lang.Runnable
    public void run() {
        L0 l0 = this.f36834b.f36860g;
        if (l0 != null) {
            l0.a(this.f36833a);
        }
    }
}
