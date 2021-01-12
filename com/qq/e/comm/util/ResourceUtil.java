package com.qq.e.comm.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class ResourceUtil {
    public static int getColorId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "color", context.getPackageName());
    }

    public static int getDrawableId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "drawable", context.getPackageName());
    }

    public static int getId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "id", context.getPackageName());
    }

    public static int getLayoutId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "layout", context.getPackageName());
    }

    public static int getStringId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "string", context.getPackageName());
    }

    public static int getStyleId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "style", context.getPackageName());
    }

    public static int getStyleableFieldId(Context context, String str, String str2) {
        Class<?>[] classes;
        String str3 = str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2;
        try {
            for (Class<?> cls : Class.forName(context.getPackageName() + ".R").getClasses()) {
                if (cls.getSimpleName().equals("styleable")) {
                    Field[] fields = cls.getFields();
                    for (Field field : fields) {
                        if (field.getName().equals(str3)) {
                            return ((Integer) field.get(null)).intValue();
                        }
                    }
                    continue;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return 0;
    }

    public static int[] getStyleableIntArray(Context context, String str) {
        Field[] fields;
        try {
            for (Field field : Class.forName(context.getPackageName() + ".R$styleable").getFields()) {
                if (field.getName().equals(str)) {
                    return (int[]) field.get(null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }
}
