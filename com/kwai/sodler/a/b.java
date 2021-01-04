package com.kwai.sodler.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.download.e;
import com.kwai.sodler.lib.a.b;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.a.g;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.c;
import com.kwai.sodler.lib.h;
import com.kwai.sodler.lib.j;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f11294a = false;

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (!f11294a) {
                j.a().a(context, new c.a().a("sodler").a(3).a(false).a());
                j.a().d().a(new g.a() { // from class: com.kwai.sodler.a.b.1
                    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                    @Override // com.kwai.sodler.lib.a.g.a
                    public void a(@NonNull f fVar, File file) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Log.d("Sodler.helper", "==============start download:" + fVar);
                        try {
                            e.a(fVar.q(), file, null, 0);
                            if (!TextUtils.isEmpty(fVar.p()) && !TextUtils.equals(com.kwai.sodler.lib.c.a.f(file), fVar.p())) {
                                throw new PluginError.UpdateError("file md5 not equal", -4);
                            }
                            a.a((InputStream) null);
                            a.a((OutputStream) null);
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            j.a h = j.a().h();
                            if (h != null) {
                                h.a("sodler_download", String.valueOf(currentTimeMillis2));
                            }
                        } catch (Throwable th) {
                            try {
                                throw new PluginError.UpdateError(th.getMessage(), -4);
                            } catch (Throwable th2) {
                                a.a((InputStream) null);
                                a.a((OutputStream) null);
                                throw th2;
                            }
                        }
                    }
                });
                f11294a = true;
            }
        }
    }

    public static void a(b.a aVar) {
        if (aVar != null) {
            j.a().f().a(aVar);
        }
    }

    public static void a(String str, com.kwai.sodler.lib.ext.b bVar) {
        h hVar = new h(null, str);
        hVar.a(bVar);
        j.a().a(hVar, 16);
    }
}
