package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes10.dex */
public final class ae {
    public static String aNK;
    public static boolean aNL;

    public static String ci(Context context) {
        if (TextUtils.isEmpty(aNK) && !aNL && at.KC()) {
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
                aNK = k(cursor);
            } catch (Throwable unused) {
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            aNL = TextUtils.isEmpty(aNK);
            return aNK;
        }
        return aNK;
    }

    public static String k(Cursor cursor) {
        int columnIndex;
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex2 = cursor.getColumnIndex("support");
            if ((columnIndex2 > 0 && cursor.getInt(columnIndex2) == 0) || (columnIndex = cursor.getColumnIndex("detailStyle")) <= 0) {
                return "";
            }
            return cursor.getString(columnIndex);
        }
        com.kwad.sdk.core.e.c.i("MiMarketHelper", "cursor is null");
        return "";
    }
}
