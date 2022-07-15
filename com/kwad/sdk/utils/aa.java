package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class aa {
    public static String a;
    public static boolean b;

    public static String a(Context context) {
        if (TextUtils.isEmpty(a) && !b && am.b()) {
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
                a = a(cursor);
            } catch (Throwable unused) {
            }
            com.kwad.sdk.crash.utils.b.a(cursor);
            b = TextUtils.isEmpty(a);
            return a;
        }
        return a;
    }

    public static String a(Cursor cursor) {
        int columnIndex;
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.b.c("MiMarketHelper", "cursor is null");
            return "";
        }
        cursor.moveToFirst();
        int columnIndex2 = cursor.getColumnIndex("support");
        return ((columnIndex2 <= 0 || cursor.getInt(columnIndex2) != 0) && (columnIndex = cursor.getColumnIndex("detailStyle")) > 0) ? cursor.getString(columnIndex) : "";
    }
}
