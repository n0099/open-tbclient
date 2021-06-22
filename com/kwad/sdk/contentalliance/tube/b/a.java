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
    public static class C0374a {

        /* renamed from: a  reason: collision with root package name */
        public long f33859a;

        /* renamed from: b  reason: collision with root package name */
        public long f33860b;

        /* renamed from: c  reason: collision with root package name */
        public int f33861c;

        /* renamed from: d  reason: collision with root package name */
        public f f33862d;

        public C0374a(f fVar, long j, long j2, int i2) {
            this.f33859a = j;
            this.f33860b = j2;
            this.f33861c = i2;
            this.f33862d = fVar;
        }
    }

    public a(@NonNull C0374a c0374a) {
        JSONArray jSONArray = new JSONArray();
        f fVar = c0374a.f33862d;
        if (fVar != null) {
            o.a(jSONArray, fVar.toJson());
        }
        a("impInfo", jSONArray);
        a(URLPackage.KEY_TUBE_ID, c0374a.f33859a);
        a("photoId", c0374a.f33860b);
        a("count", c0374a.f33861c);
        a("contentInfo", new c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.p();
    }
}
