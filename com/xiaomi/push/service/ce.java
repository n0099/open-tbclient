package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hh;
import com.xiaomi.push.hx;
import com.xiaomi.push.hy;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ig;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.ik;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import com.xiaomi.push.is;
/* loaded from: classes10.dex */
public class ce {
    public static is a(Context context, id idVar) {
        if (idVar.m630b()) {
            return null;
        }
        byte[] m628a = idVar.m628a();
        is a = a(idVar.a(), idVar.f639b);
        if (a != null) {
            ir.a(a, m628a);
        }
        return a;
    }

    public static is a(hh hhVar, boolean z) {
        switch (cf.a[hhVar.ordinal()]) {
            case 1:
                return new ii();
            case 2:
                return new io();
            case 3:
                return new im();
            case 4:
                return new iq();
            case 5:
                return new ik();
            case 6:
                return new hx();
            case 7:
                return new ic();
            case 8:
                return new ij();
            case 9:
                if (z) {
                    return new ig();
                }
                hy hyVar = new hy();
                hyVar.a(true);
                return hyVar;
            case 10:
                return new ic();
            default:
                return null;
        }
    }
}
