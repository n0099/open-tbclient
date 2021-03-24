package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class DiskInfo implements b, Serializable {
    public static final long serialVersionUID = -154725647775465930L;
    public double mDataAvailableGB;
    public double mDataTotalGB;
    public double mExternalStorageAvailableGB;
    public double mExternalStorageTotalGB;

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mDataTotalGB = jSONObject.optDouble("mDataTotalGB");
        this.mDataAvailableGB = jSONObject.optDouble("mDataAvailableGB");
        this.mExternalStorageTotalGB = jSONObject.optDouble("mExternalStorageTotalGB");
        this.mExternalStorageAvailableGB = jSONObject.optDouble("mExternalStorageAvailableGB");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "mDataTotalGB", this.mDataTotalGB);
        o.a(jSONObject, "mDataAvailableGB", this.mDataAvailableGB);
        o.a(jSONObject, "mExternalStorageTotalGB", this.mExternalStorageTotalGB);
        o.a(jSONObject, "mExternalStorageAvailableGB", this.mExternalStorageAvailableGB);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t总存储空间: ");
        sb.append(this.mDataTotalGB);
        sb.append(" (GB)\n");
        sb.append("\t可用存储空间: ");
        sb.append(this.mDataAvailableGB);
        sb.append(" (GB)\n");
        sb.append("\t总SD卡空间: ");
        sb.append(this.mExternalStorageTotalGB);
        sb.append(" (GB)\n");
        sb.append("\t可用SD卡空间: ");
        sb.append(this.mExternalStorageAvailableGB);
        sb.append(" (GB)\n");
        return sb.substring(0);
    }
}
