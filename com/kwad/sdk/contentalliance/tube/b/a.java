package com.kwad.sdk.contentalliance.tube.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.g.a.c;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class a extends d {

    /* renamed from: com.kwad.sdk.contentalliance.tube.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1080a {

        /* renamed from: a  reason: collision with root package name */
        public long f8918a;

        /* renamed from: b  reason: collision with root package name */
        public long f8919b;
        public int c;
        public f d;

        public C1080a(f fVar, long j, long j2, int i) {
            this.f8918a = j;
            this.f8919b = j2;
            this.c = i;
            this.d = fVar;
        }
    }

    public a(@NonNull C1080a c1080a) {
        JSONArray jSONArray = new JSONArray();
        if (c1080a.d != null) {
            o.a(jSONArray, c1080a.d.toJson());
        }
        a("impInfo", jSONArray);
        a(URLPackage.KEY_TUBE_ID, c1080a.f8918a);
        a("photoId", c1080a.f8919b);
        a("count", c1080a.c);
        a("contentInfo", new c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.p();
    }
}
