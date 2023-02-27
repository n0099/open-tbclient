package com.kwad.components.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.o;
import java.io.File;
/* loaded from: classes8.dex */
public final class b {
    public static synchronized boolean a(Context context, com.kwad.sdk.e.kwai.b bVar) {
        synchronized (b.class) {
            String str = bVar.aiv;
            File file = new File(str);
            if (o.I(file)) {
                if (!TextUtils.isEmpty(bVar.aix)) {
                    String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
                    if (fileMD5 != null && fileMD5.length() > 10) {
                        fileMD5 = fileMD5.substring(0, 10);
                    }
                    if (!ax.V(fileMD5, bVar.aix)) {
                        o.X(file);
                        return false;
                    }
                }
                com.kwad.components.a.b.b.a(bVar, 2);
                try {
                    com.kwad.components.a.b.a.q(str, com.kwad.components.a.b.a.h(context, bVar.aiu));
                    o.X(file);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    com.kwad.components.a.b.b.a(bVar, 0, 2, e.getMessage());
                    return false;
                }
            }
            return false;
        }
    }
}
