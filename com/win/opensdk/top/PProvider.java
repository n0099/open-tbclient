package com.win.opensdk.top;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.win.opensdk.bp;
import com.win.opensdk.bx;
import com.win.opensdk.ca;
import com.win.opensdk.p;
import com.win.opensdk.v;
import org.json.JSONException;
import org.json.JSONStringer;
/* loaded from: classes14.dex */
public class PProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public Context f8173a;

    public final void a() {
        if (bp.g(this.f8173a) == 0) {
            v.f(this.f8173a);
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
        this.f8173a = getContext();
        Context context = this.f8173a;
        if (context != null) {
            if (bp.g(context) == 0) {
                v.f(this.f8173a);
            }
        } else {
            new Handler(Looper.getMainLooper()).post(new p(this));
        }
        try {
            if (bp.t(getContext())) {
                bx iT = ca.iT(this.f8173a);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                try {
                    iT.qlo = new JSONStringer().object();
                    iT.hD("e", "hbt").P("dr", currentTimeMillis2);
                } catch (JSONException e) {
                }
                iT.a();
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
