package com.kwad.sdk.utils.kwai;

import android.os.Environment;
import android.util.Log;
import com.kwad.sdk.utils.kwai.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public final class e {
    public static ExecutorService aql = Executors.newSingleThreadExecutor();
    public static final String aqm = Environment.getDataDirectory().getPath() + "/data/com.kwad.kwadsdk/ks_union/";
    public static boolean anC = Bs();

    public static boolean Bs() {
        d.setExecutor(aql);
        d.a(new c.d() { // from class: com.kwad.sdk.utils.kwai.e.1
            @Override // com.kwad.sdk.utils.kwai.c.d
            public final void a(String str, Exception exc) {
                com.kwad.sdk.core.e.b.w("Ks_UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(exc));
            }

            @Override // com.kwad.sdk.utils.kwai.c.d
            public final void b(String str, Exception exc) {
                com.kwad.sdk.core.e.b.e("Ks_UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(exc));
            }

            @Override // com.kwad.sdk.utils.kwai.c.d
            public final void i(String str, String str2) {
                com.kwad.sdk.core.e.b.i("Ks_UnionKv", "name:" + str + " msg:" + str2);
            }
        });
        anC = true;
        return true;
    }

    public static c ej(String str) {
        if (!anC) {
            Bs();
        }
        return new c.a(aqm, str).Bq();
    }
}
