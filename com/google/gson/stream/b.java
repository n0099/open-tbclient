package com.google.gson.stream;

import com.google.gson.internal.a.g;
import com.google.gson.internal.m;
/* loaded from: classes.dex */
final class b extends m {
    @Override // com.google.gson.internal.m
    public void a(a aVar) {
        JsonToken jsonToken;
        String str;
        int t;
        int u;
        if (aVar instanceof g) {
            ((g) aVar).o();
            return;
        }
        aVar.f();
        jsonToken = aVar.l;
        if (jsonToken != JsonToken.NAME) {
            StringBuilder append = new StringBuilder().append("Expected a name but was ").append(aVar.f()).append(" ").append(" at line ");
            t = aVar.t();
            StringBuilder append2 = append.append(t).append(" column ");
            u = aVar.u();
            throw new IllegalStateException(append2.append(u).toString());
        }
        str = aVar.m;
        aVar.n = str;
        aVar.m = null;
        aVar.l = JsonToken.STRING;
    }
}
