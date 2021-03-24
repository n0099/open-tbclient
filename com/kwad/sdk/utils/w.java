package com.kwad.sdk.utils;

import android.database.Cursor;
import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: classes6.dex */
public class w {
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

    public static boolean a(@Nullable List list) {
        return (list == null || list.isEmpty()) ? false : true;
    }
}
