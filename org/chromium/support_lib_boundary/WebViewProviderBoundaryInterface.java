package org.chromium.support_lib_boundary;

import android.net.Uri;
import java.lang.reflect.InvocationHandler;
/* loaded from: classes5.dex */
public interface WebViewProviderBoundaryInterface {
    InvocationHandler[] createWebMessageChannel();

    void insertVisualStateCallback(long j, InvocationHandler invocationHandler);

    void postMessageToMainFrame(InvocationHandler invocationHandler, Uri uri);
}
