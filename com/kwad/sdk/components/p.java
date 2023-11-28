package com.kwad.sdk.components;

import android.view.View;
import java.util.Map;
/* loaded from: classes10.dex */
public interface p {
    void a(i iVar);

    void a(n nVar);

    void a(String str, String str2, o oVar);

    l aR(String str);

    void b(com.kwad.sdk.core.webview.c.g gVar);

    void c(com.kwad.sdk.core.webview.c.a aVar);

    Object execute(String str);

    int getUniqId();

    View getView();

    void onDestroy();

    void setCustomEnv(Map<String, Object> map);
}
