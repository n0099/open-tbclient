package com.google.ar.core;

import com.google.ar.core.Session;
/* loaded from: classes6.dex */
enum af extends Session.c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public af(String str, int i, int i2, Class cls) {
        super(str, 2, 1095893249, cls, (byte) 0);
    }

    @Override // com.google.ar.core.Session.c
    public final k a(long j, Session session) {
        return new Plane(j, session);
    }
}
