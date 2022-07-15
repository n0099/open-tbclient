package com.kwad.sdk.core.config.item;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c extends b<Integer> {
    public c() {
        super("batchReportCacheType", 2);
    }

    public static int a(@Nullable Context context) {
        SharedPreferences sharedPreferences;
        com.kwad.sdk.core.d.b.a("batchReportCacheType", "loadBatchReportCacheType");
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
            return 2;
        }
        return sharedPreferences.getInt("batchReportCacheType", 2);
    }

    public static void a(@Nullable Context context, int i) {
        SharedPreferences sharedPreferences;
        com.kwad.sdk.core.d.b.a("batchReportCacheType", "saveBatchReportCacheType");
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("batchReportCacheType", i);
        edit.apply();
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences.Editor editor) {
        a(KsAdSDK.getContext(), b().intValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        a((c) Integer.valueOf(a(KsAdSDK.getContext())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        a((c) (jSONObject != null ? Integer.valueOf(jSONObject.optInt(a(), c().intValue())) : c()));
    }
}
