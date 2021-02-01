package com.qq.e.comm.plugin.i;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.qq.e.ads.dfa.GDTApk;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.comm.pi.DFA;
/* loaded from: classes15.dex */
public final class c implements DFA {

    /* renamed from: a  reason: collision with root package name */
    private IGDTApkListener f12097a;

    /* renamed from: b  reason: collision with root package name */
    private b f12098b = new b();
    private HandlerThread c = new HandlerThread("GDTApkDelegate");
    private Handler d;

    public c(final IGDTApkListener iGDTApkListener) {
        this.f12097a = iGDTApkListener;
        this.c.start();
        this.d = new Handler(this.c.getLooper()) { // from class: com.qq.e.comm.plugin.i.c.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                c.this.f12098b.a(iGDTApkListener);
                c.this.d.removeCallbacks(null);
            }
        };
    }

    @Override // com.qq.e.comm.pi.DFA
    public final void loadGDTApk() {
        if (this.d != null) {
            this.d.sendEmptyMessage(0);
        }
    }

    @Override // com.qq.e.comm.pi.DFA
    public final void startInstall(Context context, GDTApk gDTApk) {
        if (this.f12098b != null) {
            this.f12098b.a(context, gDTApk, this.f12097a);
        }
    }
}
