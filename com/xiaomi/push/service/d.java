package com.xiaomi.push.service;

import com.xiaomi.push.ie;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f41809a;

    /* renamed from: a  reason: collision with other field name */
    public static b f946a;

    /* loaded from: classes7.dex */
    public interface a {
        boolean a(ie ieVar);
    }

    /* loaded from: classes7.dex */
    public interface b {
    }

    public static void a(b bVar) {
        f946a = bVar;
    }

    public static boolean a(ie ieVar) {
        String str;
        if (f41809a == null || ieVar == null) {
            str = "rc params is null, not cpra";
        } else if (com.xiaomi.push.l.m522a(com.xiaomi.push.t.m622a())) {
            return f41809a.a(ieVar);
        } else {
            str = "rc app not permission to cpra";
        }
        com.xiaomi.channel.commonutils.logger.b.m56a(str);
        return false;
    }
}
