package com.xiaomi.push.service;

import com.xiaomi.push.ie;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f41315a;

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
        if (f41315a == null || ieVar == null) {
            str = "rc params is null, not cpra";
        } else if (com.xiaomi.push.l.m521a(com.xiaomi.push.t.m621a())) {
            return f41315a.a(ieVar);
        } else {
            str = "rc app not permission to cpra";
        }
        com.xiaomi.channel.commonutils.logger.b.m55a(str);
        return false;
    }
}
