package com.kwad.sdk.collector.model.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.collector.model.b<b> {
    public static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public long f39244b;

    /* renamed from: c  reason: collision with root package name */
    public String f39245c;

    /* renamed from: d  reason: collision with root package name */
    public String f39246d;

    /* renamed from: e  reason: collision with root package name */
    public long f39247e;

    public b(long j, String str, String str2) {
        this.f39244b = -1L;
        this.f39244b = j;
        this.f39245c = str;
        this.f39246d = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (bVar == null) {
            return 1;
        }
        int i = ((this.f39247e - com.kwad.sdk.collector.model.c.c(bVar)) > 0L ? 1 : ((this.f39247e - com.kwad.sdk.collector.model.c.c(bVar)) == 0L ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i > 0 ? 1 : -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @NonNull
    /* renamed from: a */
    public b clone() {
        b bVar = new b(this.f39244b, this.f39245c, this.f39246d);
        com.kwad.sdk.collector.model.c.a(bVar, this.f39247e);
        return bVar;
    }

    public String a(long j) {
        return a.format(new Date(j));
    }

    public String b() {
        return this.f39245c;
    }

    public void b(long j) {
        this.f39244b = j;
    }

    public String c() {
        return this.f39246d;
    }

    public void c(long j) {
        this.f39247e = j;
    }

    public long d() {
        return this.f39247e;
    }

    @Override // com.kwad.sdk.collector.model.b
    public void destroy() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        long j = this.f39244b;
        if (j != bVar.f39244b) {
            return false;
        }
        if (j == 0) {
            j = 1;
        }
        if (this.f39247e / j == bVar.f39247e / j && ae.a(this.f39245c, bVar.f39245c)) {
            return ae.a(this.f39246d, bVar.f39246d);
        }
        return false;
    }

    public int hashCode() {
        long j = this.f39244b;
        if (j == 0) {
            j = 1;
        }
        long j2 = this.f39244b / j;
        String str = this.f39245c;
        int hashCode = (str != null ? str.hashCode() : 1) * 31;
        String str2 = this.f39246d;
        return ((hashCode + (str2 != null ? str2.hashCode() : 1)) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "name", this.f39245c);
        t.a(jSONObject, "packageName", this.f39246d);
        t.a(jSONObject, "lastRunningTime", this.f39247e);
        return jSONObject;
    }

    public String toString() {
        return "AppRunningInfo{packageName='" + com.kwad.sdk.collector.model.c.b(this) + "', lastRunningTime=" + a(com.kwad.sdk.collector.model.c.c(this)) + '}';
    }
}
