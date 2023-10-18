package com.google.ar.core;

import com.baidu.tieba.oqb;
import com.google.ar.core.Session;
/* loaded from: classes9.dex */
public enum ai extends Session.c {
    public ai(String str, int i, int i2, Class cls) {
        super(str, 5, 1095893253, cls, (byte) 0);
    }

    @Override // com.google.ar.core.Session.c
    public final oqb a(long j, Session session) {
        return session.b.a(j, session);
    }
}
