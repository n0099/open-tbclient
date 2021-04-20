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
    public static class C0385a {

        /* renamed from: a  reason: collision with root package name */
        public long f33440a;

        /* renamed from: b  reason: collision with root package name */
        public long f33441b;

        /* renamed from: c  reason: collision with root package name */
        public int f33442c;

        /* renamed from: d  reason: collision with root package name */
        public f f33443d;

        public C0385a(f fVar, long j, long j2, int i) {
            this.f33440a = j;
            this.f33441b = j2;
            this.f33442c = i;
            this.f33443d = fVar;
        }
    }

    public a(@NonNull C0385a c0385a) {
        JSONArray jSONArray = new JSONArray();
        f fVar = c0385a.f33443d;
        if (fVar != null) {
            o.a(jSONArray, fVar.toJson());
        }
        a("impInfo", jSONArray);
        a(URLPackage.KEY_TUBE_ID, c0385a.f33440a);
        a("photoId", c0385a.f33441b);
        a("count", c0385a.f33442c);
        a("contentInfo", new c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.p();
    }
}
