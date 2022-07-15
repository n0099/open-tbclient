package com.kwad.sdk.e.kwai;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.at;
@KsJson
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public String a;
    public String b;
    public String c;
    public long d;
    public String e;
    public String f;
    public String g;
    public int h;
    public int i;
    public boolean j;

    public final long a() {
        return this.d;
    }

    public final void a(long j) {
        this.d = j;
    }

    public final boolean b() {
        return (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.b)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (at.a(this.a, bVar.a) && at.a(this.g, bVar.g) && at.a(this.f, bVar.f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("_");
        sb.append(this.g);
        sb.append("_");
        sb.append(this.f);
        return TextUtils.isEmpty(sb.toString()) ? super.hashCode() : sb.toString().hashCode();
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    @NonNull
    public String toString() {
        return "PackageInfoBean{packageId='" + this.a + "', zipFileName='" + this.b + "', zipPath='" + this.c + "', startDownloadTime=" + this.d + ", packageUrl='" + this.e + "', version='" + this.f + "', checksum='" + this.g + "', loadType=" + this.h + ", packageType=" + this.i + ", isPublic=" + this.j + '}';
    }
}
