package org.chromium.support_lib_boundary;

import android.content.Context;
import android.net.Uri;
import android.webkit.ValueCallback;
import java.util.List;
/* loaded from: classes7.dex */
public interface StaticsBoundaryInterface {
    Uri getSafeBrowsingPrivacyPolicyUrl();

    void initSafeBrowsing(Context context, ValueCallback<Boolean> valueCallback);

    void setSafeBrowsingWhitelist(List<String> list, ValueCallback<Boolean> valueCallback);
}
