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
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f7944a;

    public d(Context context) {
        this.f7944a = context;
    }

    public void a(boolean z) {
        a();
        if (z) {
            b();
        }
    }

    private void a() {
        try {
            SharedPreferences sharedPreferences = this.f7944a.getSharedPreferences("npth", 0);
            long j = sharedPreferences.getLong("history_time", -1L);
            if (j < 0) {
                sharedPreferences.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j > 86400000) {
                com.bytedance.tea.crash.g.d.a(com.bytedance.tea.crash.g.h.b(this.f7944a));
                sharedPreferences.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b() {
        File[] l = l(com.bytedance.tea.crash.g.h.a(this.f7944a), ".npth");
        if (l != null) {
            Arrays.sort(l, Collections.reverseOrder());
            for (int i = 0; i < l.length && i < 50; i++) {
                File file = l[i];
                try {
                    if (com.bytedance.tea.crash.b.a.esx().a(file.getAbsolutePath())) {
                        com.bytedance.tea.crash.g.d.a(file);
                    } else {
                        com.bytedance.tea.crash.c.c YZ = com.bytedance.tea.crash.g.d.YZ(file.getAbsolutePath());
                        if (YZ != null && YZ.b() != null) {
                            JSONObject b2 = YZ.b();
                            A(file.getName(), b2);
                            YZ.b().put("upload_scene", "launch_scan");
                            if (com.bytedance.tea.crash.upload.b.L(YZ.a(), b2.toString(), YZ.c()).a() && !com.bytedance.tea.crash.g.d.a(file)) {
                                com.bytedance.tea.crash.b.a.esx().a(com.bytedance.tea.crash.b.a.a.YX(file.getAbsolutePath()));
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
    private File[] l(File file, String str) {
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
