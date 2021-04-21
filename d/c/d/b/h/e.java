package d.c.d.b.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import d.c.d.b.l;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public Context f66797a;

    /* loaded from: classes5.dex */
    public class a implements FilenameFilter {
        public a(e eVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str != null && str.endsWith(".npth");
        }
    }

    public e(Context context) {
        this.f66797a = context;
    }

    public final com.bytedance.tea.crash.c a(String str, JSONObject jSONObject) {
        if (jSONObject == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("launch_")) {
            return com.bytedance.tea.crash.c.LAUNCH;
        }
        if (str.startsWith("anr_")) {
            return com.bytedance.tea.crash.c.ANR;
        }
        if (str.startsWith("java_")) {
            if (jSONObject.optInt("is_dart") == 1) {
                return com.bytedance.tea.crash.c.DART;
            }
            if (jSONObject.optInt("isJava") == 1) {
                return com.bytedance.tea.crash.c.JAVA;
            }
        }
        return null;
    }

    public final void b() {
        try {
            SharedPreferences sharedPreferences = this.f66797a.getSharedPreferences("npth", 0);
            long j = sharedPreferences.getLong("history_time", -1L);
            if (j < 0) {
                sharedPreferences.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j > 86400000) {
                l.e.f(l.i.c(this.f66797a));
                sharedPreferences.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(boolean z) {
        b();
        if (z) {
            e();
        }
    }

    @Nullable
    public final File[] d(File file, String str) {
        if (file.exists()) {
            if (TextUtils.isEmpty(str)) {
                return file.listFiles();
            }
            return file.listFiles(new a(this));
        }
        return null;
    }

    public final void e() {
        File[] d2 = d(l.i.a(this.f66797a), ".npth");
        if (d2 == null) {
            return;
        }
        Arrays.sort(d2, Collections.reverseOrder());
        for (int i = 0; i < d2.length && i < 50; i++) {
            File file = d2[i];
            try {
                if (d.c.d.b.c.b.a().d(file.getAbsolutePath())) {
                    l.e.f(file);
                } else {
                    d.c.d.b.e.c j = l.e.j(file.getAbsolutePath());
                    if (j != null && j.e() != null) {
                        JSONObject e2 = j.e();
                        a(file.getName(), e2);
                        j.e().put("upload_scene", "launch_scan");
                        if (com.bytedance.tea.crash.upload.b.d(j.a(), e2.toString(), j.g()).a() && !l.e.f(file)) {
                            d.c.d.b.c.b.a().c(d.c.d.b.c.a.a.a(file.getAbsolutePath()));
                        }
                    }
                }
            } catch (Exception e3) {
                l.k.c(e3);
            }
        }
    }
}
