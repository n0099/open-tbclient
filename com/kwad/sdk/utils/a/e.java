package com.kwad.sdk.utils.a;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.a.c;
import com.kwad.sdk.utils.q;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes10.dex */
public final class e {
    public static ExecutorService aQx = Executors.newSingleThreadExecutor();
    public static boolean aLH = Mm();

    public static boolean Mm() {
        d.setExecutor(aQx);
        d.a(new c.d() { // from class: com.kwad.sdk.utils.a.e.1
            @Override // com.kwad.sdk.utils.a.c.d
            public final void a(String str, Exception exc) {
                com.kwad.sdk.core.e.c.w("Ks_UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(exc));
            }

            @Override // com.kwad.sdk.utils.a.c.d
            public final void e(String str, Throwable th) {
                com.kwad.sdk.core.e.c.e("Ks_UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(th));
            }

            @Override // com.kwad.sdk.utils.a.c.d
            public final void i(String str, String str2) {
                com.kwad.sdk.core.e.c.i("Ks_UnionKv", "name:" + str + " msg:" + str2);
            }
        });
        aLH = true;
        return true;
    }

    public static c av(@NonNull Context context, String str) {
        if (!aLH) {
            Mm();
        }
        return new c.a(q.N(context, "ks_union"), str).Mk();
    }
}
