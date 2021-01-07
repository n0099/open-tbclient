package com.kwad.sdk.contentalliance.tube.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.g.a.c;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: com.kwad.sdk.contentalliance.tube.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1097a {

        /* renamed from: a  reason: collision with root package name */
        public long f9218a;

        /* renamed from: b  reason: collision with root package name */
        public long f9219b;
        public int c;
        public f d;

        public C1097a(f fVar, long j, long j2, int i) {
            this.f9218a = j;
            this.f9219b = j2;
            this.c = i;
            this.d = fVar;
        }
    }

    public a(@NonNull C1097a c1097a) {
        JSONArray jSONArray = new JSONArray();
        if (c1097a.d != null) {
            o.a(jSONArray, c1097a.d.toJson());
        }
        a("impInfo", jSONArray);
        a(URLPackage.KEY_TUBE_ID, c1097a.f9218a);
        a("photoId", c1097a.f9219b);
        a("count", c1097a.c);
        a("contentInfo", new c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.p();
    }
}
