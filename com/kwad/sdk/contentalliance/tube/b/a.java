package com.kwad.sdk.contentalliance.tube.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.g.a.c;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: com.kwad.sdk.contentalliance.tube.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1084a {

        /* renamed from: a  reason: collision with root package name */
        public long f8920a;

        /* renamed from: b  reason: collision with root package name */
        public long f8921b;
        public int c;
        public f d;

        public C1084a(f fVar, long j, long j2, int i) {
            this.f8920a = j;
            this.f8921b = j2;
            this.c = i;
            this.d = fVar;
        }
    }

    public a(@NonNull C1084a c1084a) {
        JSONArray jSONArray = new JSONArray();
        if (c1084a.d != null) {
            o.a(jSONArray, c1084a.d.toJson());
        }
        a("impInfo", jSONArray);
        a(URLPackage.KEY_TUBE_ID, c1084a.f8920a);
        a("photoId", c1084a.f8921b);
        a("count", c1084a.c);
        a("contentInfo", new c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.p();
    }
}
