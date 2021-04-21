package d.b.c0.b.a.i;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public ContentProvider f43226a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43227b;

    /* renamed from: c  reason: collision with root package name */
    public final int f43228c;

    public a(int i, int i2) {
        this.f43227b = i;
        this.f43228c = i2;
    }

    public ContentProviderResult[] a(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        int size = arrayList.size();
        ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
        for (int i = 0; i < size; i++) {
            contentProviderResultArr[i] = arrayList.get(i).apply(this.f43226a, contentProviderResultArr, i);
        }
        return contentProviderResultArr;
    }

    public void b(ContentProvider contentProvider) {
        if (this.f43226a == null) {
            this.f43226a = contentProvider;
        }
    }

    public int c(int i, Uri uri, ContentValues[] contentValuesArr) {
        int length = contentValuesArr.length;
        for (ContentValues contentValues : contentValuesArr) {
            j(i, uri, contentValues);
        }
        return length;
    }

    public Bundle d(String str, String str2, Bundle bundle) {
        return null;
    }

    public boolean e(String str, String str2, Bundle bundle) {
        return false;
    }

    public abstract int f(int i, Uri uri, String str, String[] strArr);

    public void g(Uri uri, int i) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }

    public abstract void h(UriMatcher uriMatcher, String str);

    public abstract String i(int i, Uri uri);

    public abstract Uri j(int i, Uri uri, ContentValues contentValues);

    public final int k() {
        return this.f43228c;
    }

    public final int l() {
        return this.f43227b;
    }

    public void m(Configuration configuration) {
    }

    public abstract boolean n();

    public AssetFileDescriptor o(int i, Uri uri, String str) throws FileNotFoundException {
        q(i, uri, str);
        throw null;
    }

    public AssetFileDescriptor p(int i, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        o(i, uri, str);
        throw null;
    }

    public ParcelFileDescriptor q(int i, Uri uri, String str) throws FileNotFoundException {
        throw new FileNotFoundException("No files supported by provider at " + uri);
    }

    public abstract Cursor r(int i, Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    public Cursor s(int i, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return r(i, uri, strArr, str, strArr2, str2);
    }

    public abstract int t(int i, Uri uri, ContentValues contentValues, String str, String[] strArr);
}
