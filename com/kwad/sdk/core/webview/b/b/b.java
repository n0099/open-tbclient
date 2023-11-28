package com.kwad.sdk.core.webview.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.q;
import java.io.File;
/* loaded from: classes10.dex */
public final class b {
    public static synchronized boolean a(Context context, com.kwad.sdk.h.a.b bVar) {
        synchronized (b.class) {
            String str = bVar.aGU;
            File file = new File(str);
            if (!q.L(file)) {
                return false;
            }
            if (!TextUtils.isEmpty(bVar.ajv)) {
                String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
                if (fileMD5 != null && fileMD5.length() > 10) {
                    fileMD5 = fileMD5.substring(0, 10);
                }
                if (!bg.isEquals(fileMD5, bVar.ajv)) {
                    q.aa(file);
                    return false;
                }
            }
            com.kwad.sdk.core.webview.b.c.b.a(bVar, 2);
            try {
                com.kwad.sdk.core.webview.b.c.a.f(context, str, com.kwad.sdk.core.webview.b.c.a.F(context, bVar.aGT));
                q.aa(file);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 2, e.getMessage());
                return false;
            }
        }
    }
}
