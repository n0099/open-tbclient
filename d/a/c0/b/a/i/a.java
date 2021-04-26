package d.a.c0.b.a.i;

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
    public ContentProvider f40461a;

    /* renamed from: b  reason: collision with root package name */
    public final int f40462b;

    /* renamed from: c  reason: collision with root package name */
    public final int f40463c;

    public a(int i2, int i3) {
        this.f40462b = i2;
        this.f40463c = i3;
    }

    public ContentProviderResult[] a(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        int size = arrayList.size();
        ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
        for (int i2 = 0; i2 < size; i2++) {
            contentProviderResultArr[i2] = arrayList.get(i2).apply(this.f40461a, contentProviderResultArr, i2);
        }
        return contentProviderResultArr;
    }

    public void b(ContentProvider contentProvider) {
        if (this.f40461a == null) {
            this.f40461a = contentProvider;
        }
    }

    public int c(int i2, Uri uri, ContentValues[] contentValuesArr) {
        int length = contentValuesArr.length;
        for (ContentValues contentValues : contentValuesArr) {
            j(i2, uri, contentValues);
        }
        return length;
    }

    public Bundle d(String str, String str2, Bundle bundle) {
        return null;
    }

    public boolean e(String str, String str2, Bundle bundle) {
        return false;
    }

    public abstract int f(int i2, Uri uri, String str, String[] strArr);

    public void g(Uri uri, int i2) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }

    public abstract void h(UriMatcher uriMatcher, String str);

    public abstract String i(int i2, Uri uri);

    public abstract Uri j(int i2, Uri uri, ContentValues contentValues);

    public final int k() {
        return this.f40463c;
    }

    public final int l() {
        return this.f40462b;
    }

    public void m(Configuration configuration) {
    }

    public abstract boolean n();

    public AssetFileDescriptor o(int i2, Uri uri, String str) throws FileNotFoundException {
        q(i2, uri, str);
        throw null;
    }

    public AssetFileDescriptor p(int i2, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        o(i2, uri, str);
        throw null;
    }

    public ParcelFileDescriptor q(int i2, Uri uri, String str) throws FileNotFoundException {
        throw new FileNotFoundException("No files supported by provider at " + uri);
    }

    public abstract Cursor r(int i2, Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    public Cursor s(int i2, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return r(i2, uri, strArr, str, strArr2, str2);
    }

    public abstract int t(int i2, Uri uri, ContentValues contentValues, String str, String[] strArr);
}
