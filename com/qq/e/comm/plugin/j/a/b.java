package com.qq.e.comm.plugin.j.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMConnection;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.j.d;
import com.qq.e.comm.plugin.util.ab;
/* loaded from: classes4.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private int f12452a;

    /* renamed from: b  reason: collision with root package name */
    private int f12453b;

    public b(int i) {
        this.f12453b = i;
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
        int i2 = this.f12452a + 1;
        this.f12452a = i2;
        return i2 < 30 && d.a(i) && !d.c(i) && !d.d(i);
    }

    @Override // com.qq.e.comm.plugin.j.a.c
    public boolean b() {
        return a(GDTADManager.getInstance().getAppContext()) && this.f12453b < GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue();
    }
}
