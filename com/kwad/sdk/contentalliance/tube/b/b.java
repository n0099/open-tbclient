package com.kwad.sdk.contentalliance.tube.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.g.a.c;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class b extends d {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public f f5944a;
        public long b;
        public boolean c;

        public a(f fVar, long j, boolean z) {
            this.f5944a = fVar;
            this.b = j;
            this.c = z;
        }
    }

    public b(@NonNull a aVar) {
        JSONArray jSONArray = new JSONArray();
        o.a(jSONArray, aVar.f5944a.toJson());
        a("impInfo", jSONArray);
        a(URLPackage.KEY_TUBE_ID, aVar.b);
        a("showTrendTube", aVar.c);
        a("contentInfo", new c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.o();
    }
}
