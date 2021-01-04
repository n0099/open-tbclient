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
    public static class C1056a {

        /* renamed from: a  reason: collision with root package name */
        public long f9217a;

        /* renamed from: b  reason: collision with root package name */
        public long f9218b;
        public int c;
        public f d;

        public C1056a(f fVar, long j, long j2, int i) {
            this.f9217a = j;
            this.f9218b = j2;
            this.c = i;
            this.d = fVar;
        }
    }

    public a(@NonNull C1056a c1056a) {
        JSONArray jSONArray = new JSONArray();
        if (c1056a.d != null) {
            o.a(jSONArray, c1056a.d.toJson());
        }
        a("impInfo", jSONArray);
        a(URLPackage.KEY_TUBE_ID, c1056a.f9217a);
        a("photoId", c1056a.f9218b);
        a("count", c1056a.c);
        a("contentInfo", new c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.p();
    }
}
