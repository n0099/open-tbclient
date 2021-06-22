package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes7.dex */
public class bc implements ar {

    /* renamed from: a  reason: collision with root package name */
    public static String f41125a = "content://com.vivo.vms.IdProvider/IdentifierId/";

    /* renamed from: b  reason: collision with root package name */
    public static String f41126b = f41125a + "OAID";

    /* renamed from: c  reason: collision with root package name */
    public static String f41127c = f41125a + "VAID_";

    /* renamed from: d  reason: collision with root package name */
    public static String f41128d = f41125a + "AAID_";

    /* renamed from: e  reason: collision with root package name */
    public static String f41129e = f41125a + "OAIDSTATUS";

    /* renamed from: f  reason: collision with root package name */
    public static String f41130f = "persist.sys.identifierid.supported";

    /* renamed from: a  reason: collision with other field name */
    public Context f145a;

    public bc(Context context) {
        this.f145a = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r10 != null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r10 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str) {
        Throwable th;
        Cursor cursor;
        String str2 = null;
        try {
            cursor = this.f145a.getContentResolver().query(Uri.parse(str), null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        str2 = cursor.getString(cursor.getColumnIndex("value"));
                    }
                } catch (Exception unused) {
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public static boolean a(Context context) {
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(f41125a).getAuthority(), 128);
            if (resolveContentProvider != null) {
                if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return null;
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return "1".equals(s.a(f41130f, "0"));
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo135b() {
        return a(f41126b);
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return null;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return null;
    }
}
