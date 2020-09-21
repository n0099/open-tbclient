package tv.chushou.zues.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class d {
    private static final Gson gson;
    private static final Map<String, String> oWP;
    private static final Type oWQ;

    static {
        Gson gson2 = null;
        try {
            gson2 = new GsonBuilder().disableHtmlEscaping().setLenient().create();
        } catch (Throwable th) {
        }
        gson = gson2;
        oWP = Collections.unmodifiableMap(new HashMap());
        oWQ = new com.google.gson.b.a<Map<String, String>>() { // from class: tv.chushou.zues.utils.d.1
        }.getType();
    }

    @Nullable
    public static <T> T c(String str, Class<T> cls) {
        if (gson == null) {
            return null;
        }
        try {
            return (T) gson.fromJson(str, (Class<Object>) cls);
        } catch (Exception e) {
            tv.chushou.a.a.c.a.eqb().e("JsonUtils", "", e);
            return null;
        }
    }

    @Nullable
    public static <T> T c(String str, Type type) {
        if (gson == null) {
            return null;
        }
        try {
            return (T) gson.fromJson(str, type);
        } catch (Exception e) {
            tv.chushou.a.a.c.a.eqb().e("JsonUtils", "", e);
            return null;
        }
    }

    @Nullable
    public static String toJson(Object obj) {
        if (gson == null) {
            return null;
        }
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            tv.chushou.a.a.c.a.eqb().e("JsonUtils", "", e);
            return null;
        }
    }

    @NonNull
    public static Map<String, String> Xx(String str) {
        if (TextUtils.isEmpty(str)) {
            return oWP;
        }
        Map<String, String> map = (Map) c(str, oWQ);
        return map == null ? oWP : map;
    }
}
