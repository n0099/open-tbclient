package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
/* loaded from: classes11.dex */
public class e {
    public static boolean b;
    public static volatile e oCd;
    public Boolean g;
    public BroadcastReceiver oCi;
    public a oCe = new a("udid");
    public a oCf = new a("oaid");
    public a oCh = new a("vaid");
    public a oCg = new a("aaid");

    public static c A(Cursor cursor) {
        c cVar = new c(null, 0);
        if (cursor == null) {
            a("parseValue fail, cursor is null.");
        } else if (cursor.isClosed()) {
            a("parseValue fail, cursor is closed.");
        } else {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                cVar.f4450a = cursor.getString(columnIndex);
            } else {
                a("parseValue fail, index < 0.");
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                cVar.b = cursor.getInt(columnIndex2);
            } else {
                a("parseCode fail, index < 0.");
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                cVar.c = cursor.getLong(columnIndex3);
            } else {
                a("parseExpired fail, index < 0.");
            }
        }
        return cVar;
    }

    public static void a(String str) {
        if (b) {
            Log.d("OpenIdManager", str);
        }
    }

    public static final e eiK() {
        if (oCd == null) {
            synchronized (e.class) {
                oCd = new e();
            }
        }
        return oCd;
    }

    public a Wz(String str) {
        if ("oaid".equals(str)) {
            return this.oCf;
        }
        if ("vaid".equals(str)) {
            return this.oCh;
        }
        if ("aaid".equals(str)) {
            return this.oCg;
        }
        if ("udid".equals(str)) {
            return this.oCe;
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00a2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x00f8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x002e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(Context context, a aVar) {
        Exception exc;
        String str;
        StringBuilder append;
        String str2 = null;
        if (aVar == null) {
            return null;
        }
        if (aVar.a()) {
            return aVar.b;
        }
        a("queryId : " + aVar.c);
        Uri parse = Uri.parse("content://com.meizu.flyme.openidsdk/");
        try {
            try {
                parse = context.getContentResolver().query(parse, null, null, new String[]{aVar.c}, null);
                try {
                } catch (Exception e) {
                    exc = e;
                    str = str2;
                    parse = parse;
                }
            } catch (Throwable th) {
                th = th;
                if (parse != 0) {
                    parse.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            exc = e2;
            parse = 0;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            parse = 0;
            if (parse != 0) {
            }
            throw th;
        }
        if (parse != 0) {
            c A = A(parse);
            str2 = A.f4450a;
            try {
                aVar.a(str2);
                aVar.a(A.c);
                aVar.a(A.b);
                a(aVar.c + " errorCode : " + aVar.d);
                if (A.b != 1000) {
                    a(context);
                    if (!a(context, false)) {
                        append = new StringBuilder().append("not support, forceQuery isSupported: ").append(a(context, true));
                    }
                }
                str = str2;
                if (parse == 0) {
                    return str;
                }
            } catch (Exception e3) {
                exc = e3;
                str = str2;
                parse = parse;
                a("queryId, Exception : " + exc.getMessage());
                if (parse == 0) {
                    return str;
                }
                parse.close();
                return str;
            }
            parse.close();
            return str;
        } else if (!a(context, false)) {
            str = null;
            if (parse == 0) {
            }
            parse.close();
            return str;
        } else {
            append = new StringBuilder().append("forceQuery isSupported : ").append(a(context, true));
        }
        a(append.toString());
        str = str2;
        if (parse == 0) {
        }
        parse.close();
        return str;
    }

    public final synchronized void a(Context context) {
        if (this.oCi == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
            this.oCi = new d();
            context.registerReceiver(this.oCi, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
        if (r0 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0087, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a7, code lost:
        if (r0 == null) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, boolean z) {
        Exception e;
        Cursor cursor;
        String str;
        PackageManager packageManager;
        boolean z2 = true;
        Cursor cursor2 = null;
        Boolean bool = this.g;
        if (bool != null && !z) {
            return bool.booleanValue();
        }
        if (context == null || (packageManager = context.getPackageManager()) == null || packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) {
            z2 = false;
        }
        if (!z2) {
            a("is not Supported, for isLegalProvider : false");
            this.g = false;
            return false;
        }
        try {
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
            } catch (Throwable th) {
                cursor2 = "content://com.meizu.flyme.openidsdk/";
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursor != null) {
            try {
                String str2 = A(cursor).f4450a;
                cursor.close();
                str = str2;
            } catch (Exception e3) {
                e = e3;
                a("querySupport, Exception : " + e.getMessage());
            }
            a("querySupport, result : " + str);
            this.g = Boolean.valueOf("0".equals(str));
            return this.g.booleanValue();
        }
    }
}
