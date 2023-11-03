package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.vivo.identifier.DataBaseOperation;
import com.vivo.identifier.IdentifierIdClient;
/* loaded from: classes10.dex */
public class be implements at {
    public static String a = "content://com.vivo.vms.IdProvider/IdentifierId/";
    public static String b = a + "OAID";
    public static String c = a + "VAID_";
    public static String d = a + "AAID_";
    public static String e = a + DataBaseOperation.OAIDSTATUS_FLAG;
    public static String f = IdentifierIdClient.SYS_IDENTIFIERID_SUPPORTED;

    /* renamed from: a  reason: collision with other field name */
    public Context f140a;

    public be(Context context) {
        this.f140a = context;
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
            cursor = this.f140a.getContentResolver().query(Uri.parse(str), null, null, null, null);
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
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(a).getAuthority(), 128);
            if (resolveContentProvider != null) {
                if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public String mo271a() {
        return a(b);
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public boolean mo272a() {
        return "1".equals(r.a(f, "0"));
    }
}
