package com.weibo.ssosdk;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class WeiboSsoSdk {

    /* renamed from: e  reason: collision with root package name */
    public static WeiboSsoSdk f40546e;

    /* renamed from: f  reason: collision with root package name */
    public static d.p.a.c f40547f;

    /* renamed from: a  reason: collision with root package name */
    public volatile ReentrantLock f40548a = new ReentrantLock(true);

    /* renamed from: b  reason: collision with root package name */
    public boolean f40549b = true;

    /* renamed from: c  reason: collision with root package name */
    public d f40550c;

    /* renamed from: d  reason: collision with root package name */
    public int f40551d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Thread.sleep(86400000L);
                    WeiboSsoSdk.i().l((WeiboSsoSdk.this.f40550c == null || TextUtils.isEmpty(WeiboSsoSdk.this.f40550c.a())) ? WeiboSsoSdk.this.k() : WeiboSsoSdk.this.f40550c.a(), 2);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(60000L);
                if (WeiboSsoSdk.this.f40549b) {
                    WeiboSsoSdk.this.l((WeiboSsoSdk.this.f40550c == null || TextUtils.isEmpty(WeiboSsoSdk.this.f40550c.a())) ? WeiboSsoSdk.this.k() : WeiboSsoSdk.this.f40550c.a(), 2);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.p.a.b f40554e;

        public c(d.p.a.b bVar) {
            this.f40554e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                WeiboSsoSdk.this.l("", 1);
            } catch (Exception unused) {
            }
            if (WeiboSsoSdk.this.f40550c == null) {
                WeiboSsoSdk.this.f40550c = new d();
            }
            this.f40554e.handler(WeiboSsoSdk.this.f40550c);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f40556a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f40557b = "";

        public static d c(String str) throws Exception {
            d dVar = new d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("retcode", "");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (optString.equals("20000000") && jSONObject2 != null) {
                    dVar.f40556a = jSONObject2.optString("aid", "");
                    dVar.f40557b = jSONObject2.optString("sub", "");
                    return dVar;
                }
                throw new Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
            } catch (Exception e2) {
                throw e2;
            }
        }

        public String a() {
            return this.f40556a;
        }

        public String b() {
            return this.f40557b;
        }
    }

    static {
        System.loadLibrary("wind");
    }

    public WeiboSsoSdk() throws Exception {
        d.p.a.c cVar = f40547f;
        if (cVar != null && cVar.n()) {
            this.f40551d = 0;
            new Thread(new a()).start();
            new Thread(new b()).start();
            return;
        }
        throw new Exception("config error");
    }

    public static synchronized WeiboSsoSdk i() throws Exception {
        WeiboSsoSdk weiboSsoSdk;
        synchronized (WeiboSsoSdk.class) {
            if (f40546e == null) {
                f40546e = new WeiboSsoSdk();
            }
            weiboSsoSdk = f40546e;
        }
        return weiboSsoSdk;
    }

    public static synchronized boolean j(d.p.a.c cVar) {
        synchronized (WeiboSsoSdk.class) {
            if (cVar == null) {
                return false;
            }
            if (cVar.n()) {
                if (f40547f == null) {
                    d.p.a.c cVar2 = (d.p.a.c) cVar.clone();
                    f40547f = cVar2;
                    d.p.a.a.w(cVar2.b());
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, int i3);

    public final synchronized void f(String str) {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(h(1));
            } catch (IOException unused) {
            }
        } catch (Exception unused2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (Exception unused3) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public final String g(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://login.sina.com.cn/visitor/signin").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.flush();
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public final File h(int i2) {
        File filesDir = f40547f.b().getFilesDir();
        return new File(filesDir, "weibo_sso_sdk_aid" + i2);
    }

    public final String k() {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(h(1));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str = new String(bArr);
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return "";
                    } catch (IOException unused3) {
                        return "";
                    }
                }
                return "";
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void l(String str, int i2) throws Exception {
        String str2;
        if (TextUtils.isEmpty(f40547f.a(false))) {
            return;
        }
        if (!this.f40548a.tryLock()) {
            this.f40548a.lock();
            this.f40548a.unlock();
            return;
        }
        this.f40549b = false;
        String n = d.p.a.a.n(f40547f.b());
        try {
            str2 = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = "";
        }
        String g2 = g(riseWind(f40547f.a(true), f40547f.b().getPackageName(), str2, n, f40547f.d(true), f40547f.e(true), f40547f.h(true), f40547f.g(true), f40547f.f(true), f40547f.c(true), i2, this.f40551d));
        this.f40551d++;
        if (g2 != null) {
            try {
                d c2 = d.c(g2);
                if (c2 != null && !TextUtils.isEmpty(c2.a())) {
                    f(c2.a());
                }
                if (i2 == 1) {
                    this.f40550c = c2;
                }
                this.f40548a.unlock();
                return;
            } catch (Exception e2) {
                this.f40548a.unlock();
                throw e2;
            }
        }
        this.f40548a.unlock();
        throw new Exception("network error.");
    }

    public void m(d.p.a.b bVar) {
        d dVar = this.f40550c;
        if (dVar != null && !TextUtils.isEmpty(dVar.a()) && !TextUtils.isEmpty(this.f40550c.b())) {
            bVar.handler(this.f40550c);
        } else {
            Executors.newSingleThreadExecutor().execute(new c(bVar));
        }
    }
}
