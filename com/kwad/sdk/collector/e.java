package com.kwad.sdk.collector;

import android.os.Build;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.o;
import java.io.File;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class e {
    public static String bi(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return new String(com.kwad.sdk.core.a.c.tg().encode(l.k(o.R(new File(str)))));
            } catch (IOException e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
        return null;
    }
}
