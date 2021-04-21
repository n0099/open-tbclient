package com.kwad.sdk.contentalliance.tube.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.g.a.c;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: com.kwad.sdk.contentalliance.tube.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0388a {

        /* renamed from: a  reason: collision with root package name */
        public long f33535a;

        /* renamed from: b  reason: collision with root package name */
        public long f33536b;

        /* renamed from: c  reason: collision with root package name */
        public int f33537c;

        /* renamed from: d  reason: collision with root package name */
        public f f33538d;

        public C0388a(f fVar, long j, long j2, int i) {
            this.f33535a = j;
            this.f33536b = j2;
            this.f33537c = i;
            this.f33538d = fVar;
        }
    }

    public a(@NonNull C0388a c0388a) {
        JSONArray jSONArray = new JSONArray();
        f fVar = c0388a.f33538d;
        if (fVar != null) {
            o.a(jSONArray, fVar.toJson());
        }
        a("impInfo", jSONArray);
        a(URLPackage.KEY_TUBE_ID, c0388a.f33535a);
        a("photoId", c0388a.f33536b);
        a("count", c0388a.f33537c);
        a("contentInfo", new c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.p();
    }
}
