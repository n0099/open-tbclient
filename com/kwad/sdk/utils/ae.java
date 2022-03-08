package com.kwad.sdk.utils;

import android.database.Cursor;
import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: classes8.dex */
public class ae {
    public static void a() {
    }

    public static void a(@Nullable Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean a(@Nullable List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }
}
