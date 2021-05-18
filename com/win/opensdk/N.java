package com.win.opensdk;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class N extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public O f36954a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f36955b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f36956c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f36957d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ i f36958e;

    public N(File file, Bitmap bitmap, Bitmap.CompressFormat compressFormat, i iVar) {
        this.f36955b = file;
        this.f36956c = bitmap;
        this.f36957d = compressFormat;
        this.f36958e = iVar;
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
                fileOutputStream = new FileOutputStream(this.f36955b);
                try {
                    try {
                        this.f36956c.compress(this.f36957d, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        e2 = e3;
                        this.f36954a = new O(e2);
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
        this.f36958e.a();
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        Void r1 = (Void) obj;
        this.f36958e.b();
    }
}
