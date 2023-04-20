package com.google.ar.core;

import com.baidu.tieba.psa;
import com.google.ar.core.Session;
/* loaded from: classes8.dex */
public enum ai extends Session.c {
    public ai(String str, int i, int i2, Class cls) {
        super(str, 5, 1095893253, cls, (byte) 0);
    }

    @Override // com.google.ar.core.Session.c
    public final psa a(long j, Session session) {
        return session.c.a(j, session);
    }
}
