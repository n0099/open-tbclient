package com.bytedance.tea.crash.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f5174a;

    public d(Context context) {
        this.f5174a = context;
    }

    public void a(boolean z) {
        a();
        if (z) {
            b();
        }
    }

    private void a() {
        try {
            SharedPreferences sharedPreferences = this.f5174a.getSharedPreferences("npth", 0);
            long j = sharedPreferences.getLong("history_time", -1L);
            if (j < 0) {
                sharedPreferences.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j > 86400000) {
                com.bytedance.tea.crash.g.d.a(com.bytedance.tea.crash.g.h.b(this.f5174a));
                sharedPreferences.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b() {
        File[] k = k(com.bytedance.tea.crash.g.h.a(this.f5174a), ".npth");
        if (k != null) {
            Arrays.sort(k, Collections.reverseOrder());
            for (int i = 0; i < k.length && i < 50; i++) {
                File file = k[i];
                try {
                    if (com.bytedance.tea.crash.b.a.erm().a(file.getAbsolutePath())) {
                        com.bytedance.tea.crash.g.d.a(file);
                    } else {
                        com.bytedance.tea.crash.c.c Zm = com.bytedance.tea.crash.g.d.Zm(file.getAbsolutePath());
                        if (Zm != null && Zm.b() != null) {
                            JSONObject b = Zm.b();
                            A(file.getName(), b);
                            Zm.b().put("upload_scene", "launch_scan");
                            if (com.bytedance.tea.crash.upload.b.L(Zm.a(), b.toString(), Zm.c()).a() && !com.bytedance.tea.crash.g.d.a(file)) {
                                com.bytedance.tea.crash.b.a.erm().a(com.bytedance.tea.crash.b.a.a.Zk(file.getAbsolutePath()));
                            }
                        }
                    }
                } catch (Exception e) {
                    com.bytedance.tea.crash.g.j.b(e);
                }
            }
        }
    }

    private com.bytedance.tea.crash.c A(String str, JSONObject jSONObject) {
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
            return null;
        }
        return null;
    }

    @Nullable
    private File[] k(File file, String str) {
        if (!file.exists()) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return file.listFiles();
        }
        return file.listFiles(new FilenameFilter() { // from class: com.bytedance.tea.crash.e.d.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2 != null && str2.endsWith(".npth");
            }
        });
    }
}
