package com.ss.android.downloadlib.a.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.a.j;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CopyOnWriteArrayList<com.ss.android.downloadlib.a.b.a> hA(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.a.b.a> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = j.a().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    com.ss.android.downloadlib.a.b.a fg = com.ss.android.downloadlib.a.b.a.fg(jSONObject.optJSONObject(keys.next()));
                    if (fg != null) {
                        copyOnWriteArrayList.add(fg);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.a.b.a> copyOnWriteArrayList) {
        if (copyOnWriteArrayList != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                Iterator<com.ss.android.downloadlib.a.b.a> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    com.ss.android.downloadlib.a.b.a next = it.next();
                    if (next != null) {
                        jSONObject.put(String.valueOf(next.b), next.a());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            j.a().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            j.a().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
        }
    }
}
