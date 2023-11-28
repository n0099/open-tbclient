package com.kwad.components.offline.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.c.a.i;
import com.kwad.sdk.components.p;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements com.kwad.components.core.n.a.d.c {
    public final ITkOfflineCompo acF;

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    public b(@NonNull ITkOfflineCompo iTkOfflineCompo) {
        this.acF = iTkOfflineCompo;
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final p a(Context context, String str, int i, int i2, boolean z) {
        IOfflineCompoTachikomaContext context2 = this.acF.getContext(context, str, i, i2, z);
        if (context2 == null) {
            return null;
        }
        return new i(context2);
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i) {
        return this.acF.checkStyleTemplateById(context, str, str2, str3, i);
    }

    @Override // com.kwad.sdk.components.a
    public final Class<b> getComponentsType() {
        return b.class;
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final ITkOfflineCompo.TKState getState() {
        return this.acF.getState();
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final void onDestroy() {
        this.acF.onDestroy();
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return this.acF.priority();
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final String getJsBaseDir(Context context, String str) {
        return this.acF.getJsBaseDir(context, str);
    }

    public final void onConfigRefresh(Context context, @NonNull JSONObject jSONObject) {
        this.acF.onConfigRefresh(context, jSONObject);
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i, TKDownloadListener tKDownloadListener) {
        this.acF.loadTkFileByTemplateId(context, str, str2, str3, i, tKDownloadListener);
    }
}
