package com.win.opensdk.top;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.win.opensdk.a1;
import com.win.opensdk.s1;
import com.win.opensdk.z;
/* loaded from: classes7.dex */
public class PProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public Context f40804a;

    public final void a() {
        if (s1.g(this.f40804a) == 0) {
            z.d(this.f40804a);
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
        Context context = getContext();
        this.f40804a = context;
        if (context != null) {
            if (s1.g(context) == 0) {
                z.d(this.f40804a);
                return true;
            }
            return true;
        }
        new Handler(Looper.getMainLooper()).post(new a1(this));
        return true;
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
