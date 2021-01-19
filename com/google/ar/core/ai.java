package com.google.ar.core;

import com.google.ar.core.Session;
/* loaded from: classes5.dex */
enum ai extends Session.c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(String str, int i, int i2, Class cls) {
        super(str, 5, 1095893253, cls, (byte) 0);
    }

    @Override // com.google.ar.core.Session.c
    public final k a(long j, Session session) {
        return session.pHy.b(j, session);
    }
}
