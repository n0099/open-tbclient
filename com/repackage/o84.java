package com.repackage;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface o84 {

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, String str2, JSONObject jSONObject);

        void b(String str, int i);

        void onFail(Exception exc);

        void onStart();
    }

    void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, a aVar);

    void j(String str, Map<String, String> map, Map<String, String> map2, a aVar);
}
