package com.win.opensdk;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class N extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public O f40562a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f40563b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f40564c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f40565d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ i f40566e;

    public N(File file, Bitmap bitmap, Bitmap.CompressFormat compressFormat, i iVar) {
        this.f40563b = file;
        this.f40564c = bitmap;
        this.f40565d = compressFormat;
        this.f40566e = iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doInBackground(Object[] objArr) {
        IOException e2;
        FileOutputStream fileOutputStream;
        Void[] voidArr = (Void[]) objArr;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(this.f40563b);
                try {
                    try {
                        this.f40564c.compress(this.f40565d, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        e2 = e3;
                        this.f40562a = new O(e2);
                        cancel(true);
                        if (fileOutputStream != null) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    FileOutputStream fileOutputStream3 = fileOutputStream;
                    th = th;
                    fileOutputStream2 = fileOutputStream3;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        } catch (IOException e6) {
            e2 = e6;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        this.f40566e.a();
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        Void r1 = (Void) obj;
        this.f40566e.b();
    }
}
