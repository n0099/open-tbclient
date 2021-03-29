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
    public static WeiboSsoSdk f39601e;

    /* renamed from: f  reason: collision with root package name */
    public static d.p.a.c f39602f;

    /* renamed from: a  reason: collision with root package name */
    public volatile ReentrantLock f39603a = new ReentrantLock(true);

    /* renamed from: b  reason: collision with root package name */
    public boolean f39604b = true;

    /* renamed from: c  reason: collision with root package name */
    public d f39605c;

    /* renamed from: d  reason: collision with root package name */
    public int f39606d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Thread.sleep(86400000L);
                    WeiboSsoSdk.i().l((WeiboSsoSdk.this.f39605c == null || TextUtils.isEmpty(WeiboSsoSdk.this.f39605c.a())) ? WeiboSsoSdk.this.k() : WeiboSsoSdk.this.f39605c.a(), 2);
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
                if (WeiboSsoSdk.this.f39604b) {
                    WeiboSsoSdk.this.l((WeiboSsoSdk.this.f39605c == null || TextUtils.isEmpty(WeiboSsoSdk.this.f39605c.a())) ? WeiboSsoSdk.this.k() : WeiboSsoSdk.this.f39605c.a(), 2);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.p.a.b f39609e;

        public c(d.p.a.b bVar) {
            this.f39609e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                WeiboSsoSdk.this.l("", 1);
            } catch (Exception unused) {
            }
            if (WeiboSsoSdk.this.f39605c == null) {
                WeiboSsoSdk.this.f39605c = new d();
            }
            this.f39609e.handler(WeiboSsoSdk.this.f39605c);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f39611a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f39612b = "";

        public static d c(String str) throws Exception {
            d dVar = new d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("retcode", "");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (optString.equals("20000000") && jSONObject2 != null) {
                    dVar.f39611a = jSONObject2.optString("aid", "");
                    dVar.f39612b = jSONObject2.optString("sub", "");
                    return dVar;
                }
                throw new Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
            } catch (Exception e2) {
                throw e2;
            }
        }

        public String a() {
            return this.f39611a;
        }

        public String b() {
            return this.f39612b;
        }
    }

    static {
        System.loadLibrary("wind");
    }

    public WeiboSsoSdk() throws Exception {
        d.p.a.c cVar = f39602f;
        if (cVar != null && cVar.n()) {
            this.f39606d = 0;
            new Thread(new a()).start();
            new Thread(new b()).start();
            return;
        }
        throw new Exception("config error");
    }

    public static synchronized WeiboSsoSdk i() throws Exception {
        WeiboSsoSdk weiboSsoSdk;
        synchronized (WeiboSsoSdk.class) {
            if (f39601e == null) {
                f39601e = new WeiboSsoSdk();
            }
            weiboSsoSdk = f39601e;
        }
        return weiboSsoSdk;
    }

    public static synchronized boolean j(d.p.a.c cVar) {
        synchronized (WeiboSsoSdk.class) {
            if (cVar == null) {
                return false;
            }
            if (cVar.n()) {
                if (f39602f == null) {
                    d.p.a.c cVar2 = (d.p.a.c) cVar.clone();
                    f39602f = cVar2;
                    d.p.a.a.w(cVar2.b());
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, int i2);

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

    public final File h(int i) {
        File filesDir = f39602f.b().getFilesDir();
        return new File(filesDir, "weibo_sso_sdk_aid" + i);
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

    public final void l(String str, int i) throws Exception {
        String str2;
        if (TextUtils.isEmpty(f39602f.a(false))) {
            return;
        }
        if (!this.f39603a.tryLock()) {
            this.f39603a.lock();
            this.f39603a.unlock();
            return;
        }
        this.f39604b = false;
        String n = d.p.a.a.n(f39602f.b());
        try {
            str2 = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = "";
        }
        String g2 = g(riseWind(f39602f.a(true), f39602f.b().getPackageName(), str2, n, f39602f.d(true), f39602f.e(true), f39602f.h(true), f39602f.g(true), f39602f.f(true), f39602f.c(true), i, this.f39606d));
        this.f39606d++;
        if (g2 != null) {
            try {
                d c2 = d.c(g2);
                if (c2 != null && !TextUtils.isEmpty(c2.a())) {
                    f(c2.a());
                }
                if (i == 1) {
                    this.f39605c = c2;
                }
                this.f39603a.unlock();
                return;
            } catch (Exception e2) {
                this.f39603a.unlock();
                throw e2;
            }
        }
        this.f39603a.unlock();
        throw new Exception("network error.");
    }

    public void m(d.p.a.b bVar) {
        d dVar = this.f39605c;
        if (dVar != null && !TextUtils.isEmpty(dVar.a()) && !TextUtils.isEmpty(this.f39605c.b())) {
            bVar.handler(this.f39605c);
        } else {
            Executors.newSingleThreadExecutor().execute(new c(bVar));
        }
    }
}
