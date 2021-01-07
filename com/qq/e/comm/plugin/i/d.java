package com.qq.e.comm.plugin.i;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.aw;
import com.qq.e.comm.plugin.y.g;
import com.qq.e.comm.plugin.y.u;
import java.io.File;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static aw f12399a = new aw(2048, 5, "downloaded_not_installed_limit_num");

    public static boolean a() {
        return f12399a.b();
    }

    public static boolean a(long j, long j2, com.qq.e.comm.plugin.a.c cVar) {
        g gVar = new g(2020035);
        gVar.b(j2 - j);
        com.qq.e.comm.plugin.y.c cVar2 = new com.qq.e.comm.plugin.y.c();
        cVar2.b(cVar.l());
        gVar.a(cVar2);
        u.a(gVar);
        return j2 - j >= ((long) GDTADManager.getInstance().getSM().getInteger("apk_downloaded_inter_time", 43200000));
    }

    public static boolean a(com.qq.e.comm.plugin.a.c cVar) {
        return System.currentTimeMillis() - cVar.d() >= ((long) GDTADManager.getInstance().getSM().getInteger("apk_downloaded_time", 172800000));
    }

    public static boolean a(List<com.qq.e.comm.plugin.a.c> list) {
        return list == null || list.size() == 0;
    }

    public static a b(com.qq.e.comm.plugin.a.c cVar) {
        return new a(cVar.h(), cVar.a(), cVar.b(), cVar.f(), cVar.i(), cVar);
    }

    public static void b(List<com.qq.e.comm.plugin.a.c> list) {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                z = true;
                break;
            } else if (!list.get(i).c()) {
                z = false;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                com.qq.e.comm.plugin.a.c cVar = list.get(i2);
                cVar.a(false);
                l.a().b(cVar);
            }
        }
    }

    public static File c(com.qq.e.comm.plugin.a.c cVar) {
        File h = ah.h();
        if (h == null) {
            return null;
        }
        return com.qq.e.comm.plugin.a.e.a.a(h, cVar);
    }
}
