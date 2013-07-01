package com.google.gson.internal.a;

import java.util.Date;
/* loaded from: classes.dex */
final class f implements com.google.gson.ab {
    @Override // com.google.gson.ab
    public com.google.gson.aa a(com.google.gson.e eVar, com.google.gson.b.a aVar) {
        if (aVar.a() == Date.class) {
            return new e();
        }
        return null;
    }
}
