package com.weibo.ssosdk;

import android.text.TextUtils;
import com.kwad.sdk.collector.AppStatusRules;
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
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class WeiboSsoSdk {
    private static WeiboSsoSdk pYw;
    private static b pYx;
    private int pYA;
    private volatile ReentrantLock pYv = new ReentrantLock(true);
    private boolean pYy = true;
    private a pYz;

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, int i2);

    static {
        System.loadLibrary("wind");
    }

    private WeiboSsoSdk() throws Exception {
        if (pYx == null || !pYx.eGx()) {
            throw new Exception("config error");
        }
        this.pYA = 0;
        new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(86400000L);
                        WeiboSsoSdk.eGu().cl((WeiboSsoSdk.this.pYz == null || TextUtils.isEmpty(WeiboSsoSdk.this.pYz.uE())) ? WeiboSsoSdk.this.eGw() : WeiboSsoSdk.this.pYz.uE(), 2);
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
        new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(AppStatusRules.DEFAULT_GRANULARITY);
                    if (WeiboSsoSdk.this.pYy) {
                        WeiboSsoSdk.this.cl((WeiboSsoSdk.this.pYz == null || TextUtils.isEmpty(WeiboSsoSdk.this.pYz.uE())) ? WeiboSsoSdk.this.eGw() : WeiboSsoSdk.this.pYz.uE(), 2);
                    }
                } catch (Exception e) {
                }
            }
        }).start();
    }

    public static synchronized boolean a(b bVar) {
        boolean z = false;
        synchronized (WeiboSsoSdk.class) {
            if (bVar != null) {
                if (bVar.eGx() && pYx == null) {
                    pYx = (b) bVar.clone();
                    com.weibo.ssosdk.a.init(pYx.getApplicationContext());
                    z = true;
                }
            }
        }
        return z;
    }

    public static synchronized WeiboSsoSdk eGu() throws Exception {
        WeiboSsoSdk weiboSsoSdk;
        synchronized (WeiboSsoSdk.class) {
            if (pYw == null) {
                pYw = new WeiboSsoSdk();
            }
            weiboSsoSdk = pYw;
        }
        return weiboSsoSdk;
    }

    /* loaded from: classes3.dex */
    public static final class a {
        private String mAid;
        private String pYC;

        public String uE() {
            return this.mAid;
        }

        static a aaz(String str) throws Exception {
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("retcode", "");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (!optString.equals("20000000") || jSONObject2 == null) {
                    throw new Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
                }
                aVar.mAid = jSONObject2.optString("aid", "");
                aVar.pYC = jSONObject2.optString("sub", "");
                return aVar;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private String aax(String str) {
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
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(String str, int i) throws Exception {
        String str2;
        if (!TextUtils.isEmpty(pYx.CA(false))) {
            if (!this.pYv.tryLock()) {
                this.pYv.lock();
                this.pYv.unlock();
                return;
            }
            this.pYy = false;
            String mfp = com.weibo.ssosdk.a.getMfp(pYx.getApplicationContext());
            try {
                str2 = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                str2 = "";
            }
            String aax = aax(riseWind(pYx.CA(true), pYx.getApplicationContext().getPackageName(), str2, mfp, pYx.Cz(true), pYx.Cy(true), pYx.Cx(true), pYx.Cw(true), pYx.CB(true), pYx.Cv(true), i, this.pYA));
            this.pYA++;
            if (aax != null) {
                try {
                    a aaz = a.aaz(aax);
                    if (aaz != null && !TextUtils.isEmpty(aaz.uE())) {
                        aay(aaz.uE());
                    }
                    if (i == 1) {
                        this.pYz = aaz;
                    }
                    this.pYv.unlock();
                    return;
                } catch (Exception e2) {
                    this.pYv.unlock();
                    throw e2;
                }
            }
            this.pYv.unlock();
            throw new Exception("network error.");
        }
    }

    public a eGv() throws Exception {
        if (this.pYz == null) {
            Thread thread = new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WeiboSsoSdk.this.cl("", 1);
                    } catch (Exception e) {
                    }
                }
            });
            thread.start();
            thread.join();
        }
        if (this.pYz == null) {
            throw new Exception("visitor login failed");
        }
        return this.pYz;
    }

    public String uE() throws Exception {
        String eGw = eGw();
        if (TextUtils.isEmpty(eGw)) {
            if (this.pYz == null || TextUtils.isEmpty(this.pYz.uE())) {
                Thread thread = new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            WeiboSsoSdk.this.cl("", 1);
                        } catch (Exception e) {
                        }
                    }
                });
                thread.start();
                thread.join();
            }
            if (this.pYz == null) {
                throw new Exception("visitor login failed");
            }
            return this.pYz.uE();
        }
        return eGw;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [378=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public String eGw() {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream2 = new FileInputStream(RH(1));
        } catch (Exception e) {
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[fileInputStream2.available()];
            fileInputStream2.read(bArr);
            String str = new String(bArr);
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return str;
                } catch (IOException e2) {
                    return str;
                }
            }
            return str;
        } catch (Exception e3) {
            fileInputStream3 = fileInputStream2;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (IOException e4) {
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    private File RH(int i) {
        return new File(pYx.getApplicationContext().getFilesDir(), "weibo_sso_sdk_aid" + i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [406=4] */
    private synchronized void aay(String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (!TextUtils.isEmpty(str)) {
            try {
                fileOutputStream2 = new FileOutputStream(RH(1));
                try {
                    fileOutputStream2.write(str.getBytes());
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileOutputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }
    }
}
