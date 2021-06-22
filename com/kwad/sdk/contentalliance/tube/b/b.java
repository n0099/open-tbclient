package com.kwad.sdk.contentalliance.tube.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.g.a.c;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class b extends d {

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public f f33863a;

        /* renamed from: b  reason: collision with root package name */
        public long f33864b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f33865c;

        public a(f fVar, long j, boolean z) {
            this.f33863a = fVar;
            this.f33864b = j;
            this.f33865c = z;
        }
    }

    public b(@NonNull a aVar) {
        JSONArray jSONArray = new JSONArray();
        o.a(jSONArray, aVar.f33863a.toJson());
        a("impInfo", jSONArray);
        a(URLPackage.KEY_TUBE_ID, aVar.f33864b);
        a("showTrendTube", aVar.f33865c);
        a("contentInfo", new c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.o();
    }
}
