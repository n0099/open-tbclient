package com.win.opensdk.top;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.win.opensdk.D1;
import com.win.opensdk.G;
import com.win.opensdk.V1;
import com.win.opensdk.Z0;
import com.win.opensdk.a1;
import org.json.JSONException;
import org.json.JSONStringer;
/* loaded from: classes7.dex */
public class PProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public Context f40428a;

    public final void a() {
        if (V1.g(this.f40428a) == 0) {
            G.f(this.f40428a);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        Context context = getContext();
        this.f40428a = context;
        if (context != null) {
            if (V1.g(context) == 0) {
                G.f(this.f40428a);
            }
        } else {
            new Handler(Looper.getMainLooper()).post(new D1(this));
        }
        try {
            if (V1.t(getContext())) {
                Z0 a2 = a1.a(this.f40428a);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                try {
                    a2.f40234b = new JSONStringer().object();
                    a2.a("e", "hbt").a("dr", currentTimeMillis2);
                } catch (JSONException unused) {
                }
                a2.a();
                return true;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
