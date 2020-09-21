package com.google.ar.core;

import com.google.ar.core.Session;
/* loaded from: classes24.dex */
enum ah extends Session.c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(String str, int i, int i2, Class cls) {
        super(str, 4, 1095893252, cls, (byte) 0);
    }

    @Override // com.google.ar.core.Session.c
    public final k a(long j, Session session) {
        return new AugmentedImage(j, session);
    }
}
