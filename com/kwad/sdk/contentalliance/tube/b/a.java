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
    public static class C0370a {

        /* renamed from: a  reason: collision with root package name */
        public long f33150a;

        /* renamed from: b  reason: collision with root package name */
        public long f33151b;

        /* renamed from: c  reason: collision with root package name */
        public int f33152c;

        /* renamed from: d  reason: collision with root package name */
        public f f33153d;

        public C0370a(f fVar, long j, long j2, int i) {
            this.f33150a = j;
            this.f33151b = j2;
            this.f33152c = i;
            this.f33153d = fVar;
        }
    }

    public a(@NonNull C0370a c0370a) {
        JSONArray jSONArray = new JSONArray();
        f fVar = c0370a.f33153d;
        if (fVar != null) {
            o.a(jSONArray, fVar.toJson());
        }
        a("impInfo", jSONArray);
        a(URLPackage.KEY_TUBE_ID, c0370a.f33150a);
        a("photoId", c0370a.f33151b);
        a("count", c0370a.f33152c);
        a("contentInfo", new c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.p();
    }
}
