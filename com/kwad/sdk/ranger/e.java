package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    public static final String TAG = "e";

    public static void a(@NonNull d dVar) {
        try {
            a.a(dVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.e(TAG, Log.getStackTraceString(th));
        }
    }

    public static void dY(final String str) {
        g.schedule(new ay() { // from class: com.kwad.sdk.ranger.e.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    com.kwad.sdk.core.e.c.w(e.TAG, "config is empty");
                    return;
                }
                d fG = e.fG(str2);
                if (fG != null) {
                    String str3 = e.TAG;
                    com.kwad.sdk.core.e.c.d(str3, "config:" + fG.toJson().toString());
                }
                if (fG != null && !fG.IZ()) {
                    e.d(fG);
                }
            }
        }, 0L, TimeUnit.SECONDS);
    }

    public static void e(@NonNull d dVar) {
        List<String> list = dVar.aLC;
        if (list != null && !list.isEmpty()) {
            try {
                RangerHelper.c(dVar);
                RangerHelper.replaceInternal();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.e(TAG, Log.getStackTraceString(th));
            }
        }
    }

    public static void f(d dVar) {
        b.IX().b(dVar);
    }

    public static d fG(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.w(TAG, e);
            return null;
        }
    }

    public static void d(@NonNull d dVar) {
        if (new Random().nextFloat() >= dVar.sampleRate) {
            String str = TAG;
            com.kwad.sdk.core.e.c.d(str, "config.sampleRate：" + dVar.sampleRate + " return");
            return;
        }
        if (dVar.Ja()) {
            e(dVar);
        }
        if (dVar.Jb()) {
            a(dVar);
        }
        if (dVar.Jc()) {
            f(dVar);
        }
    }
}
