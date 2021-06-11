package d.a.j0.q;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f44181a;

    public b(Context context) {
        this.f44181a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i2, String str) {
        String str2;
        Uri parse;
        Cursor query;
        StringBuilder sb;
        String str3;
        if (i2 != 0) {
            if (i2 == 1) {
                sb = new StringBuilder();
                str3 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
            } else if (i2 != 2) {
                parse = null;
                query = this.f44181a.getContentResolver().query(parse, null, null, null, null);
                if (query != null) {
                    r0 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                    query.close();
                }
                return r0;
            } else {
                sb = new StringBuilder();
                str3 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
            }
            sb.append(str3);
            sb.append(str);
            str2 = sb.toString();
        } else {
            str2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
        }
        parse = Uri.parse(str2);
        query = this.f44181a.getContentResolver().query(parse, null, null, null, null);
        if (query != null) {
        }
        return r0;
    }
}
