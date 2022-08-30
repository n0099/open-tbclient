package com.kwad.sdk.e.kwai;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.ax;
@KsJson
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public String ait;
    public String aiu;
    public String aiv;
    public long aiw;
    public String aix;
    public boolean aiy;
    public int loadType;
    public int packageType;
    public String packageUrl;
    public String version;

    public final void N(long j) {
        this.aiw = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (ax.V(this.ait, bVar.ait) && ax.V(this.aix, bVar.aix) && ax.V(this.version, bVar.version)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.ait);
        sb.append("_");
        sb.append(this.aix);
        sb.append("_");
        sb.append(this.version);
        return TextUtils.isEmpty(sb.toString()) ? super.hashCode() : sb.toString().hashCode();
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.ait) || TextUtils.isEmpty(this.packageUrl) || TextUtils.isEmpty(this.version) || TextUtils.isEmpty(this.aiu)) ? false : true;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    @NonNull
    public String toString() {
        return "PackageInfoBean{packageId='" + this.ait + "', zipFileName='" + this.aiu + "', zipPath='" + this.aiv + "', startDownloadTime=" + this.aiw + ", packageUrl='" + this.packageUrl + "', version='" + this.version + "', checksum='" + this.aix + "', loadType=" + this.loadType + ", packageType=" + this.packageType + ", isPublic=" + this.aiy + '}';
    }

    public final long xo() {
        return this.aiw;
    }
}
