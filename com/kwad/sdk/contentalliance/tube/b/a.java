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
    public static class C0371a {

        /* renamed from: a  reason: collision with root package name */
        public long f33761a;

        /* renamed from: b  reason: collision with root package name */
        public long f33762b;

        /* renamed from: c  reason: collision with root package name */
        public int f33763c;

        /* renamed from: d  reason: collision with root package name */
        public f f33764d;

        public C0371a(f fVar, long j, long j2, int i2) {
            this.f33761a = j;
            this.f33762b = j2;
            this.f33763c = i2;
            this.f33764d = fVar;
        }
    }

    public a(@NonNull C0371a c0371a) {
        JSONArray jSONArray = new JSONArray();
        f fVar = c0371a.f33764d;
        if (fVar != null) {
            o.a(jSONArray, fVar.toJson());
        }
        a("impInfo", jSONArray);
        a(URLPackage.KEY_TUBE_ID, c0371a.f33761a);
        a("photoId", c0371a.f33762b);
        a("count", c0371a.f33763c);
        a("contentInfo", new c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.p();
    }
}
