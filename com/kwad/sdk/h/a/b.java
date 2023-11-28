package com.kwad.sdk.h.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bg;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public String aGS;
    public String aGT;
    public String aGU;
    public long aGV;
    public boolean aGW;
    public String ajv;
    public int loadType;
    public int packageType;
    public String packageUrl;
    public String version;

    public final long Hl() {
        return this.aGV;
    }

    public final boolean isValid() {
        if (!TextUtils.isEmpty(this.aGS) && !TextUtils.isEmpty(this.packageUrl) && !TextUtils.isEmpty(this.version) && !TextUtils.isEmpty(this.aGT)) {
            return true;
        }
        return false;
    }

    public final void ar(long j) {
        this.aGV = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (bg.isEquals(this.aGS, bVar.aGS) && bg.isEquals(this.ajv, bVar.ajv) && bg.isEquals(this.version, bVar.version)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.aGS);
        sb.append("_");
        sb.append(this.ajv);
        sb.append("_");
        sb.append(this.version);
        if (TextUtils.isEmpty(sb.toString())) {
            return super.hashCode();
        }
        return sb.toString().hashCode();
    }

    @Override // com.kwad.sdk.core.response.a.a
    @NonNull
    public String toString() {
        return "PackageInfoBean{packageId='" + this.aGS + "', zipFileName='" + this.aGT + "', zipPath='" + this.aGU + "', startDownloadTime=" + this.aGV + ", packageUrl='" + this.packageUrl + "', version='" + this.version + "', checksum='" + this.ajv + "', loadType=" + this.loadType + ", packageType=" + this.packageType + ", isPublic=" + this.aGW + '}';
    }
}
