package com.bytedance.sdk.openadsdk.f.a;

import androidx.annotation.NonNull;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private l f7126a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a(l lVar) {
        return new h(lVar);
    }

    private h(l lVar) {
        this.f7126a = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public <T> T a(@NonNull String str, @NonNull Type type) throws JSONException {
        a(str);
        return (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) ? (T) new JSONObject(str) : (T) this.f7126a.a(str, type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public <T> String a(T t) {
        String obj;
        if (t == null) {
            return "{}";
        }
        if ((t instanceof JSONObject) || (t instanceof JSONArray)) {
            obj = t.toString();
        } else {
            obj = this.f7126a.a(t);
        }
        a(obj);
        return obj;
    }

    private static void a(String str) {
        if (!str.startsWith("{") || !str.endsWith("}")) {
            i.a(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n " + str));
        }
    }
}
