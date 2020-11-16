package com.google.ar.core;

import com.google.ar.core.Session;
/* loaded from: classes5.dex */
enum ag extends Session.c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(String str, int i, int i2, Class cls) {
        super(str, 3, 1095893250, cls, (byte) 0);
    }

    @Override // com.google.ar.core.Session.c
    public final k a(long j, Session session) {
        return new Point(j, session);
    }
}
