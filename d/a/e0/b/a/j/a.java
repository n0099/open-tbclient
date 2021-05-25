package d.a.e0.b.a.j;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import d.a.e0.b.a.b;
import d.a.e0.b.a.c;
/* loaded from: classes2.dex */
public class a extends d.a.e0.b.a.i.a {
    public a() {
        super(0, 100);
    }

    @Override // d.a.e0.b.a.i.a
    public Bundle d(String str, String str2, Bundle bundle) {
        if ("_get_service_handler".equals(str)) {
            return b.a();
        }
        return null;
    }

    @Override // d.a.e0.b.a.i.a
    public boolean e(String str, String str2, Bundle bundle) {
        return "_get_service_handler".equals(str);
    }

    @Override // d.a.e0.b.a.i.a
    public int f(int i2, Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // d.a.e0.b.a.i.a
    public void g(Uri uri, int i2) {
        if (i2 == 3) {
            return;
        }
        super.g(uri, i2);
    }

    @Override // d.a.e0.b.a.i.a
    public void h(UriMatcher uriMatcher, String str) {
        uriMatcher.addURI(str, "ipc_manager/method/get_service_handler", 1);
    }

    @Override // d.a.e0.b.a.i.a
    public String i(int i2, Uri uri) {
        return null;
    }

    @Override // d.a.e0.b.a.i.a
    public Uri j(int i2, Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // d.a.e0.b.a.i.a
    public boolean n() {
        return false;
    }

    @Override // d.a.e0.b.a.i.a
    public Cursor r(int i2, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (i2 == 1) {
            return new c(b.a());
        }
        return null;
    }

    @Override // d.a.e0.b.a.i.a
    public int t(int i2, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
