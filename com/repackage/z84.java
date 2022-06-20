package com.repackage;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface z84 {

    /* loaded from: classes7.dex */
    public interface a {
        void b(String str, String str2, JSONObject jSONObject);

        void c(String str, int i);

        void onFail(Exception exc);

        void onStart();
    }

    void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, a aVar);

    void k(String str, Map<String, String> map, Map<String, String> map2, a aVar);
}
