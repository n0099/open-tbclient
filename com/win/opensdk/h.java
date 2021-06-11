package com.win.opensdk;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
/* loaded from: classes7.dex */
public class h extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f40723a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40724b;

    public h(PBSplash pBSplash, String str) {
        this.f40724b = pBSplash;
        this.f40723a = str;
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        String str = ((String[]) objArr)[0];
        if (str != null) {
            try {
                return z.d(str);
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        Context context;
        byte[] bArr = (byte[]) obj;
        if (bArr == null) {
            PBSplash pBSplash = this.f40724b;
            PBSplashListener pBSplashListener = pBSplash.f40586e;
            if (pBSplashListener != null && !pBSplash.j) {
                pBSplashListener.onFail(PBError.NO_RESUOURCE);
                this.f40724b.f40590i = true;
            }
        } else {
            PBSplash pBSplash2 = this.f40724b;
            PBSplashListener pBSplashListener2 = pBSplash2.f40586e;
            if (pBSplashListener2 != null && !pBSplash2.j) {
                pBSplash2.m = bArr;
                pBSplashListener2.onLoaded();
                this.f40724b.f40590i = true;
            }
        }
        if (bArr != null) {
            PBSplash pBSplash3 = this.f40724b;
            if (pBSplash3.j) {
                StringBuilder sb = new StringBuilder();
                context = this.f40724b.f40582a;
                sb.append(z.a(context));
                sb.append(File.separator);
                sb.append("win");
                sb.append(File.separator);
                sb.append(z.c(this.f40723a));
                sb.append(".gif");
                pBSplash3.p = new File(sb.toString());
                new Thread(new Z0(bArr, this.f40724b.p.getPath())).start();
            }
        }
    }
}
