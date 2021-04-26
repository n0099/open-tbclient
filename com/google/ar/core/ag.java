package com.google.ar.core;

import com.google.ar.core.Session;
/* loaded from: classes6.dex */
public enum ag extends Session.c {
    public ag(String str, int i2, int i3, Class cls) {
        super(str, 3, 1095893250, cls, (byte) 0);
    }

    @Override // com.google.ar.core.Session.c
    public final d.g.b.a.b a(long j, Session session) {
        return new Point(j, session);
    }
}
