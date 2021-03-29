package d.j.b.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f66197g = null;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f66198h = false;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f66203e;

    /* renamed from: f  reason: collision with root package name */
    public BroadcastReceiver f66204f;

    /* renamed from: a  reason: collision with root package name */
    public a f66199a = new a("udid");

    /* renamed from: b  reason: collision with root package name */
    public a f66200b = new a("oaid");

    /* renamed from: d  reason: collision with root package name */
    public a f66202d = new a("vaid");

    /* renamed from: c  reason: collision with root package name */
    public a f66201c = new a("aaid");

    public static c a(Cursor cursor) {
        String str;
        c cVar = new c(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else if (!cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                cVar.f66194a = cursor.getString(columnIndex);
            } else {
                e("parseValue fail, index < 0.");
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                cVar.f66195b = cursor.getInt(columnIndex2);
            } else {
                e("parseCode fail, index < 0.");
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                cVar.f66196c = cursor.getLong(columnIndex3);
            } else {
                e("parseExpired fail, index < 0.");
            }
            return cVar;
        } else {
            str = "parseValue fail, cursor is closed.";
        }
        e(str);
        return cVar;
    }

    public static final d b() {
        if (f66197g == null) {
            synchronized (d.class) {
                f66197g = new d();
            }
        }
        return f66197g;
    }

    public static void e(String str) {
        if (f66198h) {
            Log.d("OpenIdManager", str);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x00b3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0029 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c(Context context, a aVar) {
        String str;
        Cursor cursor;
        boolean f2;
        StringBuilder sb;
        Cursor cursor2 = 0;
        r0 = null;
        r0 = null;
        String str2 = null;
        Cursor cursor3 = null;
        if (aVar == null) {
            return null;
        }
        if (aVar.d()) {
            return aVar.f66191b;
        }
        e("queryId : " + aVar.f66192c);
        try {
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{aVar.f66192c}, null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            str = null;
        }
        try {
        } catch (Exception e3) {
            e = e3;
            str = str2;
            cursor3 = cursor;
            e("queryId, Exception : " + e.getMessage());
            if (cursor3 == null) {
                cursor2 = str;
                return cursor2;
            }
            cursor = cursor3;
            str2 = str;
            cursor.close();
            return str2;
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            if (cursor2 != 0) {
                cursor2.close();
            }
            throw th;
        }
        if (cursor == null) {
            if (f(context, false)) {
                f2 = f(context, true);
                sb = new StringBuilder();
                sb.append("forceQuery isSupported : ");
                sb.append(f2);
                e(sb.toString());
            }
            if (cursor == null) {
            }
            cursor.close();
            return str2;
        }
        c a2 = a(cursor);
        str2 = a2.f66194a;
        aVar.c(str2);
        aVar.b(a2.f66196c);
        aVar.a(a2.f66195b);
        e(aVar.f66192c + " errorCode : " + aVar.f66193d);
        if (a2.f66195b != 1000) {
            d(context);
            if (!f(context, false)) {
                f2 = f(context, true);
                sb = new StringBuilder();
                sb.append("not support, forceQuery isSupported: ");
                sb.append(f2);
                e(sb.toString());
            }
        }
        if (cursor == null) {
            return str2;
        }
        cursor.close();
        return str2;
    }

    public final synchronized void d(Context context) {
        if (this.f66204f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        com.meizu.flyme.openidsdk.d dVar = new com.meizu.flyme.openidsdk.d();
        this.f66204f = dVar;
        context.registerReceiver(dVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
        if (r8 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
        if (r8 == null) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(Context context, boolean z) {
        Throwable th;
        Cursor cursor;
        PackageManager packageManager;
        Boolean bool = this.f66203e;
        if (bool == null || z) {
            if (!((context == null || (packageManager = context.getPackageManager()) == null || packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) ? false : true)) {
                e("is not Supported, for isLegalProvider : false");
                this.f66203e = Boolean.FALSE;
                return false;
            }
            String str = null;
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                if (cursor != null) {
                    try {
                        try {
                            str = a(cursor).f66194a;
                        } catch (Exception e2) {
                            e = e2;
                            e("querySupport, Exception : " + e.getMessage());
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
            cursor.close();
            e("querySupport, result : " + str);
            Boolean valueOf = Boolean.valueOf("0".equals(str));
            this.f66203e = valueOf;
            return valueOf.booleanValue();
        }
        return bool.booleanValue();
    }

    public a g(String str) {
        if ("oaid".equals(str)) {
            return this.f66200b;
        }
        if ("vaid".equals(str)) {
            return this.f66202d;
        }
        if ("aaid".equals(str)) {
            return this.f66201c;
        }
        if ("udid".equals(str)) {
            return this.f66199a;
        }
        return null;
    }
}
