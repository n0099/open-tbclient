package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes7.dex */
public class bc implements ar {

    /* renamed from: a  reason: collision with root package name */
    public static String f40268a = "content://com.vivo.vms.IdProvider/IdentifierId/";

    /* renamed from: b  reason: collision with root package name */
    public static String f40269b = f40268a + "OAID";

    /* renamed from: c  reason: collision with root package name */
    public static String f40270c = f40268a + "VAID_";

    /* renamed from: d  reason: collision with root package name */
    public static String f40271d = f40268a + "AAID_";

    /* renamed from: e  reason: collision with root package name */
    public static String f40272e = f40268a + "OAIDSTATUS";

    /* renamed from: f  reason: collision with root package name */
    public static String f40273f = "persist.sys.identifierid.supported";

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
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(f40268a).getAuthority(), 128);
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
        return "1".equals(s.a(f40273f, "0"));
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo130b() {
        return a(f40269b);
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
