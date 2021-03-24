package com.kwad.sdk.core.config.item;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends a<Integer> {
    public b() {
        super("batchReportCacheType", 2);
    }

    public static int a(@Nullable Context context) {
        SharedPreferences sharedPreferences;
        com.kwad.sdk.core.d.a.a("BatchReportCacheTypeConfigItem", "loadBatchReportCacheType");
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
            return 2;
        }
        return sharedPreferences.getInt("batchReportCacheType", 2);
    }

    public static void a(@Nullable Context context, int i) {
        SharedPreferences sharedPreferences;
        com.kwad.sdk.core.d.a.a("BatchReportCacheTypeConfigItem", "saveBatchReportCacheType");
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("batchReportCacheType", i);
        edit.apply();
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        a(KsAdSDK.getContext(), b().intValue());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        a((b) Integer.valueOf(a(KsAdSDK.getContext())));
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        a((b) (jSONObject != null ? Integer.valueOf(jSONObject.optInt(a(), c().intValue())) : c()));
    }
}
