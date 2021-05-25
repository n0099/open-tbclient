package d.a.l0.a.i1.e;

import android.database.Cursor;
/* loaded from: classes3.dex */
public final class a {
    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }
}
