package com.win.opensdk;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
/* loaded from: classes7.dex */
public class h extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37115a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f37116b;

    public h(PBSplash pBSplash, String str) {
        this.f37116b = pBSplash;
        this.f37115a = str;
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
            PBSplash pBSplash = this.f37116b;
            PBSplashListener pBSplashListener = pBSplash.f36978e;
            if (pBSplashListener != null && !pBSplash.j) {
                pBSplashListener.onFail(PBError.NO_RESUOURCE);
                this.f37116b.f36982i = true;
            }
        } else {
            PBSplash pBSplash2 = this.f37116b;
            PBSplashListener pBSplashListener2 = pBSplash2.f36978e;
            if (pBSplashListener2 != null && !pBSplash2.j) {
                pBSplash2.m = bArr;
                pBSplashListener2.onLoaded();
                this.f37116b.f36982i = true;
            }
        }
        if (bArr != null) {
            PBSplash pBSplash3 = this.f37116b;
            if (pBSplash3.j) {
                StringBuilder sb = new StringBuilder();
                context = this.f37116b.f36974a;
                sb.append(z.a(context));
                sb.append(File.separator);
                sb.append("win");
                sb.append(File.separator);
                sb.append(z.c(this.f37115a));
                sb.append(".gif");
                pBSplash3.p = new File(sb.toString());
                new Thread(new Z0(bArr, this.f37116b.p.getPath())).start();
            }
        }
    }
}
