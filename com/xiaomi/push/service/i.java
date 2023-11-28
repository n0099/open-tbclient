package com.xiaomi.push.service;

import com.xiaomi.push.ig;
/* loaded from: classes10.dex */
public class i {
    public static a a;

    /* renamed from: a  reason: collision with other field name */
    public static b f977a;

    /* loaded from: classes10.dex */
    public interface a {
        boolean a(ig igVar);
    }

    /* loaded from: classes10.dex */
    public interface b {
    }

    public static void a(b bVar) {
        f977a = bVar;
    }

    public static boolean a(ig igVar) {
        String str;
        if (a == null || igVar == null) {
            str = "rc params is null, not cpra";
        } else if (com.xiaomi.push.j.m721a(com.xiaomi.push.s.m732a())) {
            return a.a(igVar);
        } else {
            str = "rc app not permission to cpra";
        }
        com.xiaomi.channel.commonutils.logger.b.m190a(str);
        return false;
    }
}
