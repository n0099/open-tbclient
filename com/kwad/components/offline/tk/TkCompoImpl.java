package com.kwad.components.offline.tk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.offline.init.DefaultOfflineCompo;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaView;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.tk.kwai.d;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.h;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class TkCompoImpl extends DefaultOfflineCompo implements com.kwad.components.core.offline.api.kwai.a {
    public final ITkOfflineCompo mOfflineCompo;

    public TkCompoImpl(@NonNull ITkOfflineCompo iTkOfflineCompo) {
        super(iTkOfflineCompo);
        this.mOfflineCompo = iTkOfflineCompo;
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public StyleTemplate findStyleTemplateFromConfigById(String str) {
        return this.mOfflineCompo.findStyleTemplateFromConfigById(str);
    }

    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        return TkCompoImpl.class;
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public String getJsBaseDir(Context context, String str) {
        return this.mOfflineCompo.getJsBaseDir(context, str);
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public ITkOfflineCompo.TKState getState() {
        return this.mOfflineCompo.getState();
    }

    public String getTKVersion() {
        return this.mOfflineCompo.getTKVersion();
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public h getView(Context context, String str, int i, int i2) {
        IOfflineCompoTachikomaView view2 = this.mOfflineCompo.getView(context, str, i, i2);
        if (view2 == null) {
            return null;
        }
        return new d(view2);
    }

    @Override // com.kwad.components.core.offline.init.DefaultOfflineCompo, com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public StyleTemplate loadTkFileByTemplateId(Context context, String str) {
        return this.mOfflineCompo.loadTkFileByTemplateId(context, str);
    }

    public void onConfigRefresh(Context context, @NonNull JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mOfflineCompo.onConfigRefresh(context, jSONObject);
        }
    }
}
