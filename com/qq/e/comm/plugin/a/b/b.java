package com.qq.e.comm.plugin.a.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.a.j;
import com.qq.e.comm.plugin.util.ar;
/* loaded from: classes3.dex */
public class b implements d {
    private static final boolean f;

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.a.c f11600a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f11601b;
    private final Intent c;
    private Intent d;
    private Intent e;

    static {
        f = GDTADManager.getInstance().getSM().getInteger("download_pause", 0) == 1;
    }

    public b(Intent intent, com.qq.e.comm.plugin.a.c cVar, Context context) {
        this.c = intent;
        this.f11600a = cVar;
        this.f11601b = context;
    }

    private PendingIntent a(boolean z) {
        if (!f || !z) {
            if (this.e == null) {
                this.e = new Intent(this.c);
                j.a(this.e, true);
            }
            return PendingIntent.getService(this.f11601b, this.f11600a.m(), this.e, 134217728);
        }
        if (this.d == null) {
            this.d = new Intent();
            this.d.setClassName(this.f11601b, ar.a());
            this.d.putExtra(ACTD.DELEGATE_NAME_KEY, "downloadManage");
            this.d.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
        }
        return PendingIntent.getActivity(this.f11601b, 0, this.d, 134217728);
    }

    @Override // com.qq.e.comm.plugin.a.b.d
    public PendingIntent a() {
        return a(true);
    }

    @Override // com.qq.e.comm.plugin.a.b.d
    public PendingIntent b() {
        return a(false);
    }

    @Override // com.qq.e.comm.plugin.a.b.d
    public PendingIntent c() {
        return a(false);
    }

    @Override // com.qq.e.comm.plugin.a.b.d
    public PendingIntent d() {
        return PendingIntent.getActivity(this.f11601b, this.f11600a.m(), this.c, 0);
    }

    @Override // com.qq.e.comm.plugin.a.b.d
    public PendingIntent e() {
        return a(true);
    }
}
