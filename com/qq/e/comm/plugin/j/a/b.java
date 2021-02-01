package com.qq.e.comm.plugin.j.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMConnection;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.j.d;
import com.qq.e.comm.plugin.util.ab;
/* loaded from: classes15.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private int f12154a;

    /* renamed from: b  reason: collision with root package name */
    private int f12155b;

    public b(int i) {
        this.f12155b = i;
    }

    private boolean a(Context context) {
        return ab.a(context);
    }

    @Override // com.qq.e.comm.plugin.j.a.c
    public long a() {
        return IMConnection.RETRY_DELAY_TIMES;
    }

    @Override // com.qq.e.comm.plugin.j.a.c
    public boolean a(int i) {
        int i2 = this.f12154a + 1;
        this.f12154a = i2;
        return i2 < 30 && d.a(i) && !d.c(i) && !d.d(i);
    }

    @Override // com.qq.e.comm.plugin.j.a.c
    public boolean b() {
        return a(GDTADManager.getInstance().getAppContext()) && this.f12155b < GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue();
    }
}
