package com.bytedance.tea.crash.upload;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.tea.crash.c;
import d.b.d.b.c.a.a;
import d.b.d.b.l;
import d.b.d.b.n.e;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CrashUploadService extends IntentService {
    public CrashUploadService() {
        super("CrashUploadService");
    }

    private e a(String str, String str2, String str3, c cVar) {
        if (cVar == null) {
            return new e(201);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            jSONObject.put("upload_scene", "new_process");
            str2 = jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (cVar == c.NATIVE) {
            return b.c(str, str2, str3);
        }
        if (cVar == c.LAUNCH) {
            return b.b(str, str2);
        }
        return b.d(str, str2, b.g());
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    @Override // android.app.IntentService
    public void onHandleIntent(@Nullable Intent intent) {
        if (intent == null) {
            return;
        }
        c cVar = intent.hasExtra("crash_type") ? (c) intent.getSerializableExtra("crash_type") : null;
        String stringExtra = intent.getStringExtra("upload_url");
        String stringExtra2 = intent.getStringExtra("crash_json_value");
        String stringExtra3 = intent.getStringExtra("crash_info_file_path");
        String stringExtra4 = intent.getStringExtra("crash_dump_file_path");
        d.b.d.b.c.b.a().b(getApplication());
        if (TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra) || d.b.d.b.c.b.a().d(stringExtra3) || !a(stringExtra, stringExtra2, stringExtra4, cVar).a()) {
            return;
        }
        if (cVar == c.NATIVE) {
            if (l.e.g(new File(stringExtra3).getParentFile(), true)) {
                return;
            }
            d.b.d.b.c.b.a().c(a.a(stringExtra3));
        } else if (TextUtils.isEmpty(stringExtra3) || l.e.h(stringExtra3)) {
        } else {
            d.b.d.b.c.b.a().c(a.a(stringExtra3));
        }
    }
}
