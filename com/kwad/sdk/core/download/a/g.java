package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.an;
/* loaded from: classes7.dex */
public class g {
    public static String a(Context context) {
        String str = "";
        if (an.b()) {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
                str = a(query);
                com.kwad.sdk.core.d.a.c("MiMarketHelper", "detailStyle" + str);
                ae.a(query);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.c("MiMarketHelper", "getDetailStyle service not found;");
                com.kwad.sdk.core.d.a.a(e2);
            }
            return str;
        }
        return "";
    }

    public static String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.a.c("MiMarketHelper", "cursor is null");
            return "";
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("support");
        if (columnIndex <= 0 || cursor.getInt(columnIndex) != 0) {
            int columnIndex2 = cursor.getColumnIndex("detailStyle");
            String string = columnIndex2 > 0 ? cursor.getString(columnIndex2) : "";
            if (string != null) {
                if (string.contains("2")) {
                    return "2";
                }
                if (string.contains("3")) {
                    return "3";
                }
                if (string.contains("1")) {
                    return "1";
                }
            }
            return "";
        }
        return "";
    }
}
