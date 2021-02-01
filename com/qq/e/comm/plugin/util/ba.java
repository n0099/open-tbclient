package com.qq.e.comm.plugin.util;

import com.qq.e.comm.managers.GDTADManager;
/* loaded from: classes15.dex */
public class ba {
    public static void a(long j, int i, String str, com.qq.e.comm.plugin.y.c cVar) {
        com.qq.e.comm.plugin.y.g b2 = new com.qq.e.comm.plugin.y.g(2020001).b(j).b(i);
        b2.a(cVar);
        b2.a(new com.qq.e.comm.plugin.y.d().a("nt", Integer.valueOf(GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue())).a("vu", str));
        com.qq.e.comm.plugin.y.u.a(b2);
    }

    public static void b(long j, int i, String str, com.qq.e.comm.plugin.y.c cVar) {
        com.qq.e.comm.plugin.y.g b2 = new com.qq.e.comm.plugin.y.g(2020002).b(j).b(i);
        b2.a(cVar);
        b2.a(new com.qq.e.comm.plugin.y.d().a("vu", str));
        com.qq.e.comm.plugin.y.u.a(b2);
    }
}
