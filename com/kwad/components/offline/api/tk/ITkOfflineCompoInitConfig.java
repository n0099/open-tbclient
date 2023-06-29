package com.kwad.components.offline.api.tk;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.soloader.ISoLoader;
/* loaded from: classes10.dex */
public interface ITkOfflineCompoInitConfig extends IOfflineCompoInitConfig {
    String getSpKeyTkSoLoadTimes();

    String getSpNameSoLoadTimes();

    String getTkJsFileDir(Context context, String str);

    String getTkVersion();

    boolean isCanUseTk();

    boolean isLocalDebugEnable();

    boolean isTkCloseCheck();

    ISoLoader soLoader();

    boolean useTkLite();
}
