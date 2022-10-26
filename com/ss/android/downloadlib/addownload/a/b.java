package com.ss.android.downloadlib.addownload.a;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.j;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public CopyOnWriteArrayList a(String str, String str2) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        try {
            String string = j.getContext().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    com.ss.android.downloadlib.addownload.b.a a = com.ss.android.downloadlib.addownload.b.a.a(jSONObject.optJSONObject(keys.next()));
                    if (a != null) {
                        copyOnWriteArrayList.add(a);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    public void a(String str, String str2, CopyOnWriteArrayList copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.ss.android.downloadlib.addownload.b.a aVar = (com.ss.android.downloadlib.addownload.b.a) it.next();
                if (aVar != null) {
                    jSONObject.put(String.valueOf(aVar.b), aVar.a());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        j.getContext().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }

    public void b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            j.getContext().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
        }
    }
}
