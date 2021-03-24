package com.win.opensdk;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
/* loaded from: classes7.dex */
public class h extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39938a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f39939b;

    public h(PBSplash pBSplash, String str) {
        this.f39939b = pBSplash;
        this.f39938a = str;
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        String str = ((String[]) objArr)[0];
        if (str != null) {
            try {
                return G.d(str);
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
            PBSplash pBSplash = this.f39939b;
            PBSplashListener pBSplashListener = pBSplash.f39763e;
            if (pBSplashListener != null && !pBSplash.j) {
                pBSplashListener.onFail(PBError.NO_RESUOURCE);
                this.f39939b.i = true;
            }
        } else {
            PBSplash pBSplash2 = this.f39939b;
            PBSplashListener pBSplashListener2 = pBSplash2.f39763e;
            if (pBSplashListener2 != null && !pBSplash2.j) {
                pBSplash2.m = bArr;
                pBSplashListener2.onLoaded();
                this.f39939b.i = true;
            }
        }
        if (bArr != null) {
            PBSplash pBSplash3 = this.f39939b;
            if (pBSplash3.j) {
                StringBuilder sb = new StringBuilder();
                context = this.f39939b.f39759a;
                sb.append(G.a(context));
                sb.append(File.separator);
                sb.append("win");
                sb.append(File.separator);
                sb.append(G.c(this.f39938a));
                sb.append(".gif");
                pBSplash3.p = new File(sb.toString());
                new Thread(new C1(bArr, this.f39939b.p.getPath())).start();
            }
        }
    }
}
