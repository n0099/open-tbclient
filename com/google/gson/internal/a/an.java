package com.google.gson.internal.a;

import java.sql.Timestamp;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class an implements com.google.gson.ab {
    @Override // com.google.gson.ab
    public com.google.gson.aa a(com.google.gson.e eVar, com.google.gson.b.a aVar) {
        if (aVar.a() != Timestamp.class) {
            return null;
        }
        return new ao(this, eVar.a(Date.class));
    }
}
