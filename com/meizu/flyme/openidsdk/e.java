package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
/* loaded from: classes15.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f11374b;
    public static volatile e pYx;
    public Boolean g;
    public BroadcastReceiver h;
    public a pYy = new a("udid");
    public a pYz = new a("oaid");
    public a pYB = new a("vaid");
    public a pYA = new a("aaid");

    public static c D(Cursor cursor) {
        c cVar = new c(null, 0);
        if (cursor == null) {
            a("parseValue fail, cursor is null.");
        } else if (cursor.isClosed()) {
            a("parseValue fail, cursor is closed.");
        } else {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                cVar.f11372a = cursor.getString(columnIndex);
            } else {
                a("parseValue fail, index < 0.");
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                cVar.f11373b = cursor.getInt(columnIndex2);
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
        if (f11374b) {
            Log.d("OpenIdManager", str);
        }
    }

    public static final e eCA() {
        if (pYx == null) {
            synchronized (e.class) {
                pYx = new e();
            }
        }
        return pYx;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00a2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x00f5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x002e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00eb  */
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
        String str;
        StringBuilder append;
        String str2 = null;
        if (aVar == null) {
            return null;
        }
        if (aVar.a()) {
            return aVar.f11371b;
        }
        a("queryId : " + aVar.c);
        Uri parse = Uri.parse("content://com.meizu.flyme.openidsdk/");
        try {
            try {
                parse = context.getContentResolver().query(parse, null, null, new String[]{aVar.c}, null);
                try {
                } catch (Exception e) {
                    e = e;
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
            e = e2;
            str = null;
            parse = 0;
        } catch (Throwable th2) {
            th = th2;
            parse = 0;
            if (parse != 0) {
            }
            throw th;
        }
        if (parse != 0) {
            c D = D(parse);
            str2 = D.f11372a;
            try {
                aVar.a(str2);
                aVar.a(D.c);
                aVar.a(D.f11373b);
                a(aVar.c + " errorCode : " + aVar.d);
                if (D.f11373b != 1000) {
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
                e = e3;
                str = str2;
                parse = parse;
                a("queryId, Exception : " + e.getMessage());
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
        if (this.h == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
            this.h = new d();
            context.registerReceiver(this.h, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
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
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a6, code lost:
        if (r0 == null) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, boolean z) {
        Throwable th;
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
            } catch (Throwable th2) {
                th = th2;
                cursor2 = "content://com.meizu.flyme.openidsdk/";
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursor != null) {
            try {
                String str2 = D(cursor).f11372a;
                cursor.close();
                str = str2;
            } catch (Exception e2) {
                e = e2;
                a("querySupport, Exception : " + e.getMessage());
            }
            a("querySupport, result : " + str);
            this.g = Boolean.valueOf("0".equals(str));
            return this.g.booleanValue();
        }
    }

    public a aaf(String str) {
        if ("oaid".equals(str)) {
            return this.pYz;
        }
        if ("vaid".equals(str)) {
            return this.pYB;
        }
        if ("aaid".equals(str)) {
            return this.pYA;
        }
        if ("udid".equals(str)) {
            return this.pYy;
        }
        return null;
    }
}
