package com.kwad.sdk.collector.model.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.kwad.sdk.collector.model.b<b> {
    public static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    public long f55745b;

    /* renamed from: c  reason: collision with root package name */
    public String f55746c;

    /* renamed from: d  reason: collision with root package name */
    public String f55747d;

    /* renamed from: e  reason: collision with root package name */
    public long f55748e;

    public b(long j2, String str, String str2) {
        this.f55745b = -1L;
        this.f55745b = j2;
        this.f55746c = str;
        this.f55747d = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (bVar == null) {
            return 1;
        }
        int i2 = ((this.f55748e - com.kwad.sdk.collector.model.c.c(bVar)) > 0L ? 1 : ((this.f55748e - com.kwad.sdk.collector.model.c.c(bVar)) == 0L ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        return i2 > 0 ? 1 : -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @NonNull
    /* renamed from: a */
    public b clone() {
        b bVar = new b(this.f55745b, this.f55746c, this.f55747d);
        com.kwad.sdk.collector.model.c.a(bVar, this.f55748e);
        return bVar;
    }

    public String a(long j2) {
        return a.format(new Date(j2));
    }

    public String b() {
        return this.f55746c;
    }

    public void b(long j2) {
        this.f55745b = j2;
    }

    public String c() {
        return this.f55747d;
    }

    public void c(long j2) {
        this.f55748e = j2;
    }

    public long d() {
        return this.f55748e;
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
        long j2 = this.f55745b;
        if (j2 != bVar.f55745b) {
            return false;
        }
        if (j2 == 0) {
            j2 = 1;
        }
        if (this.f55748e / j2 == bVar.f55748e / j2 && ae.a(this.f55746c, bVar.f55746c)) {
            return ae.a(this.f55747d, bVar.f55747d);
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f55745b;
        if (j2 == 0) {
            j2 = 1;
        }
        long j3 = this.f55745b / j2;
        String str = this.f55746c;
        int hashCode = (str != null ? str.hashCode() : 1) * 31;
        String str2 = this.f55747d;
        return ((hashCode + (str2 != null ? str2.hashCode() : 1)) * 31) + ((int) (j3 ^ (j3 >>> 32)));
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "name", this.f55746c);
        t.a(jSONObject, "packageName", this.f55747d);
        t.a(jSONObject, "lastRunningTime", this.f55748e);
        return jSONObject;
    }

    public String toString() {
        return "AppRunningInfo{packageName='" + com.kwad.sdk.collector.model.c.b(this) + ExtendedMessageFormat.QUOTE + ", lastRunningTime=" + a(com.kwad.sdk.collector.model.c.c(this)) + ExtendedMessageFormat.END_FE;
    }
}
