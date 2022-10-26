package com.kwad.sdk.core.config.item;

import android.content.Context;
import android.content.SharedPreferences;
import com.kwad.sdk.api.KsAdSDK;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class c extends b {
    public c() {
        super("batchReportCacheType", 2);
    }

    public static int bm(Context context) {
        SharedPreferences sharedPreferences;
        com.kwad.sdk.core.e.b.d("batchReportCacheType", "loadBatchReportCacheType");
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
            return 2;
        }
        return sharedPreferences.getInt("batchReportCacheType", 2);
    }

    public static void d(Context context, int i) {
        SharedPreferences sharedPreferences;
        com.kwad.sdk.core.e.b.d("batchReportCacheType", "saveBatchReportCacheType");
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("batchReportCacheType", i);
        edit.apply();
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        setValue(Integer.valueOf(bm(KsAdSDK.getContext())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        d(KsAdSDK.getContext(), ((Integer) getValue()).intValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void e(JSONObject jSONObject) {
        setValue(jSONObject != null ? Integer.valueOf(jSONObject.optInt(getKey(), ((Integer) sx()).intValue())) : sx());
    }
}
