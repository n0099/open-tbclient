package com.bytedance.tea.crash.upload;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CrashUploadService extends IntentService {
    public CrashUploadService() {
        super("CrashUploadService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            com.bytedance.tea.crash.c cVar = null;
            if (intent.hasExtra(BdStatsConstant.StatsKey.CRASH_TYPE)) {
                cVar = (com.bytedance.tea.crash.c) intent.getSerializableExtra(BdStatsConstant.StatsKey.CRASH_TYPE);
            }
            String stringExtra = intent.getStringExtra("upload_url");
            String stringExtra2 = intent.getStringExtra("crash_json_value");
            String stringExtra3 = intent.getStringExtra("crash_info_file_path");
            String stringExtra4 = intent.getStringExtra("crash_dump_file_path");
            com.bytedance.tea.crash.b.a.esw().a(getApplication());
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra) && !com.bytedance.tea.crash.b.a.esw().a(stringExtra3) && a(stringExtra, stringExtra2, stringExtra4, cVar).a()) {
                if (cVar == com.bytedance.tea.crash.c.NATIVE) {
                    if (!com.bytedance.tea.crash.g.d.c(new File(stringExtra3).getParentFile(), true)) {
                        com.bytedance.tea.crash.b.a.esw().a(com.bytedance.tea.crash.b.a.a.YY(stringExtra3));
                    }
                } else if (!TextUtils.isEmpty(stringExtra3) && !com.bytedance.tea.crash.g.d.a(stringExtra3)) {
                    com.bytedance.tea.crash.b.a.esw().a(com.bytedance.tea.crash.b.a.a.YY(stringExtra3));
                }
            }
        }
    }

    private f a(String str, String str2, String str3, com.bytedance.tea.crash.c cVar) {
        if (cVar == null) {
            return new f(201);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            jSONObject.put("upload_scene", "new_process");
            str2 = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (cVar == com.bytedance.tea.crash.c.NATIVE) {
            return b.aV(str, str2, str3);
        }
        if (cVar == com.bytedance.tea.crash.c.LAUNCH) {
            return b.hi(str, str2);
        }
        return b.L(str, str2, b.a());
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }
}
