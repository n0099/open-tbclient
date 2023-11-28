package com.kwad.sdk.components;

import android.content.Intent;
/* loaded from: classes10.dex */
public interface k {
    void a(m mVar);

    void callTKBridge(String str);

    void callbackDismiss();

    void callbackPageStatus(boolean z, String str);

    String getClassName();

    Intent getIntent();

    String getTemplateString();

    String getUrl();

    String getViewKey();
}
