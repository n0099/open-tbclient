package com.google.ar.core;

import com.baidu.tieba.idb;
import com.google.ar.core.Session;
/* loaded from: classes9.dex */
public enum ag extends Session.c {
    public ag(String str, int i, int i2, Class cls) {
        super(str, 3, 1095893250, cls, (byte) 0);
    }

    @Override // com.google.ar.core.Session.c
    public final idb a(long j, Session session) {
        return new Point(j, session);
    }
}
