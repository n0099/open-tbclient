package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class ac {
    public static String anK;
    public static boolean anL;

    public static String cu(Context context) {
        if (TextUtils.isEmpty(anK) && !anL && ap.zQ()) {
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
                anK = g(cursor);
            } catch (Throwable unused) {
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            anL = TextUtils.isEmpty(anK);
            return anK;
        }
        return anK;
    }

    public static String g(Cursor cursor) {
        int columnIndex;
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.e.b.i("MiMarketHelper", "cursor is null");
            return "";
        }
        cursor.moveToFirst();
        int columnIndex2 = cursor.getColumnIndex("support");
        return ((columnIndex2 <= 0 || cursor.getInt(columnIndex2) != 0) && (columnIndex = cursor.getColumnIndex("detailStyle")) > 0) ? cursor.getString(columnIndex) : "";
    }
}
