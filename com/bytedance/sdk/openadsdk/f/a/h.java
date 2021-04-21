package com.bytedance.sdk.openadsdk.f.a;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public l f29011a;

    public h(l lVar) {
        this.f29011a = lVar;
    }

    public static h a(l lVar) {
        return new h(lVar);
    }

    @NonNull
    public <T> T a(@NonNull String str, @NonNull Type type) throws JSONException {
        a(str);
        if (!type.equals(JSONObject.class) && (!(type instanceof Class) || !JSONObject.class.isAssignableFrom((Class) type))) {
            return (T) this.f29011a.a(str, type);
        }
        return (T) new JSONObject(str);
    }

    @NonNull
    public <T> String a(T t) {
        String obj;
        if (t == null) {
            return StringUtil.EMPTY_ARRAY;
        }
        if (!(t instanceof JSONObject) && !(t instanceof JSONArray)) {
            obj = this.f29011a.a(t);
        } else {
            obj = t.toString();
        }
        a(obj);
        return obj;
    }

    public static void a(String str) {
        if (str.startsWith(StringUtil.ARRAY_START) && str.endsWith("}")) {
            return;
        }
        i.a(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n " + str));
    }
}
