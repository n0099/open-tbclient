package com.google.ar.core;

import com.baidu.tieba.rwb;
import com.google.ar.core.Session;
/* loaded from: classes9.dex */
public enum ah extends Session.c {
    public ah(String str, int i, int i2, Class cls) {
        super(str, 4, 1095893252, cls, (byte) 0);
    }

    @Override // com.google.ar.core.Session.c
    public final rwb a(long j, Session session) {
        return new AugmentedImage(j, session);
    }
}
