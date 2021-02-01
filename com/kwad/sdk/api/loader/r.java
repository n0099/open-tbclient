package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import com.kwad.sdk.api.loader.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class r {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        if (Math.abs(System.currentTimeMillis() - q.b(context, "lastUpdateTime")) < q.b(context, "interval") * 1000) {
            return;
        }
        k.a("https://open.e.kuaishou.com/rest/e/v3/open/sdk").a(new k.c<Boolean>() { // from class: com.kwad.sdk.api.loader.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.api.loader.k.c
            public void a(Boolean bool) {
                Log.d("Updater", "checkAndUpdate result: " + bool);
            }

            @Override // com.kwad.sdk.api.loader.k.c
            public void a(Throwable th) {
            }
        });
    }
}
