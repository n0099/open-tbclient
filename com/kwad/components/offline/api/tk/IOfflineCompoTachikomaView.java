package com.kwad.components.offline.api.tk;

import android.view.View;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler;
/* loaded from: classes7.dex */
public interface IOfflineCompoTachikomaView {
    void execute(String str, String str2, IOfflineTKRenderListener iOfflineTKRenderListener);

    View getView();

    void onDestroy();

    void registerJsBridge(IOfflineCompoBridgeHandler iOfflineCompoBridgeHandler);
}
