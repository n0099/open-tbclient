package com.google.ar.core;

import com.baidu.tieba.ilb;
import com.google.ar.core.Session;
/* loaded from: classes9.dex */
public enum af extends Session.c {
    public af(String str, int i, int i2, Class cls) {
        super(str, 2, 1095893249, cls, (byte) 0);
    }

    @Override // com.google.ar.core.Session.c
    public final ilb a(long j, Session session) {
        return new Plane(j, session);
    }
}
