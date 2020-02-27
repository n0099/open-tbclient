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
/* loaded from: classes5.dex */
public class d {
    private static Gson gson = new GsonBuilder().disableHtmlEscaping().setLenient().create();
    private static final Map<String, String> nWD = Collections.unmodifiableMap(new HashMap());
    private static final Type nWE = new com.google.gson.b.a<Map<String, String>>() { // from class: tv.chushou.zues.utils.d.1
    }.getType();

    @Nullable
    public static <T> T c(String str, Class<T> cls) {
        try {
            return (T) gson.fromJson(str, (Class<Object>) cls);
        } catch (Exception e) {
            tv.chushou.a.a.c.a.dQd().e("JsonUtils", "", e);
            return null;
        }
    }

    @Nullable
    public static <T> T c(String str, Type type) {
        try {
            return (T) gson.fromJson(str, type);
        } catch (Exception e) {
            tv.chushou.a.a.c.a.dQd().e("JsonUtils", "", e);
            return null;
        }
    }

    @Nullable
    public static String toJson(Object obj) {
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            tv.chushou.a.a.c.a.dQd().e("JsonUtils", "", e);
            return null;
        }
    }

    @NonNull
    public static Map<String, String> SU(String str) {
        if (TextUtils.isEmpty(str)) {
            return nWD;
        }
        Map<String, String> map = (Map) c(str, nWE);
        return map == null ? nWD : map;
    }
}
