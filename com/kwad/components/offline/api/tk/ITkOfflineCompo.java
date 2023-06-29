package com.kwad.components.offline.api.tk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.SdkConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public interface ITkOfflineCompo extends IOfflineCompo {
    public static final String IMPL = "com.kwad.tachikoma.TkOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.tachikoma";

    /* loaded from: classes10.dex */
    public enum TKState {
        READY,
        SO_FAIL
    }

    StyleTemplate findStyleTemplateFromConfigById(String str);

    String getJsBaseDir(Context context, String str);

    TKState getState();

    String getTKVersion();

    IOfflineCompoTachikomaView getView(Context context, String str, int i, int i2);

    void initReal(Context context, SdkConfig sdkConfig, ITkOfflineCompoInitConfig iTkOfflineCompoInitConfig);

    StyleTemplate loadTkFileByTemplateId(Context context, String str);

    void onConfigRefresh(Context context, @NonNull JSONObject jSONObject);
}
