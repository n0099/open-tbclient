package com.kwad.components.core.offline.api.kwai;

import android.content.Context;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.h;
/* loaded from: classes10.dex */
public interface a extends com.kwad.sdk.components.a {
    StyleTemplate findStyleTemplateFromConfigById(String str);

    String getJsBaseDir(Context context, String str);

    ITkOfflineCompo.TKState getState();

    h getView(Context context, String str, int i, int i2);

    StyleTemplate loadTkFileByTemplateId(Context context, String str);
}
