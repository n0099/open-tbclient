package com.qq.e.comm.plugin.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
class h implements Callable<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f11619a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private String f11620b;
    private int c;
    private int d;

    public h(String str) {
        this(str, 0, 0);
    }

    public h(String str, int i, int i2) {
        this.f11620b = "";
        this.f11620b = str;
        this.c = i;
        this.d = i2;
    }

    private Bitmap a(Bitmap bitmap) {
        return (this.c <= 0 || this.d <= 0) ? bitmap : Bitmap.createScaledBitmap(bitmap, this.c, this.d, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap b() {
        HttpURLConnection httpURLConnection;
        Bitmap decodeFile;
        File i = ah.i();
        if (i != null) {
            i.mkdirs();
            String encode = Md5Util.encode(this.f11620b);
            if (f11619a.contains(encode)) {
                return null;
            }
            File file = new File(i, encode);
            if (!file.exists()) {
                try {
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = null;
                }
                try {
                    httpURLConnection = ab.a(c());
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        GDTLogger.d("Icon url resp code" + responseCode);
                        FileUtil.copyTo(httpURLConnection.getInputStream(), file);
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                        if (decodeFile == null) {
                        }
                        return a(decodeFile);
                    } catch (Throwable th3) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th3;
                    }
                }
            }
            decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
            if (decodeFile == null) {
                GDTLogger.report("DecodeIconImageFail\turl:" + this.f11620b + "\tfilemd5:" + Md5Util.encode(file));
            }
            return a(decodeFile);
        }
        return null;
    }

    private HttpURLConnection c() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f11620b).openConnection();
        httpURLConnection.setRequestProperty("User-Agent", com.qq.e.comm.plugin.t.j.f12541a);
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        return httpURLConnection;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Bitmap call() throws Exception {
        HttpURLConnection httpURLConnection;
        Bitmap b2 = b();
        if (b2 != null) {
            return b2;
        }
        try {
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
        }
        try {
            httpURLConnection = ab.a(c());
            if (httpURLConnection.getResponseCode() != 200) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    return null;
                }
                return null;
            }
            Bitmap a2 = a(BitmapFactory.decodeStream(httpURLConnection.getInputStream()));
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                return a2;
            }
            return a2;
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    return null;
                }
                return null;
            } catch (Throwable th3) {
                HttpURLConnection httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th3;
            }
        }
    }
}
