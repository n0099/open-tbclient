package d.c.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import d.c.b.g1;
/* loaded from: classes5.dex */
public final class c1 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    public t0<Boolean> f64960a = new a(this);

    /* loaded from: classes5.dex */
    public class a extends t0<Boolean> {
        public a(c1 c1Var) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.c.b.t0
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return Boolean.FALSE;
        }
    }

    @Override // d.c.b.g1
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return this.f64960a.b(context).booleanValue();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // d.c.b.g1
    public g1.a b(Context context) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursor == null) {
                return null;
            }
            try {
                g1.a aVar = new g1.a();
                aVar.f64995a = a(cursor);
                if (cursor != null) {
                    cursor.close();
                }
                return aVar;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public final String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }
}
