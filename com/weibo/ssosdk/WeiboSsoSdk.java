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
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class WeiboSsoSdk {
    private static WeiboSsoSdk pDh;
    private static b pDi;
    private volatile ReentrantLock pDg = new ReentrantLock(true);
    private boolean pDj = true;
    private a pDk;
    private int pDl;

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, int i2);

    static {
        System.loadLibrary("wind");
    }

    private WeiboSsoSdk() throws Exception {
        if (pDi == null || !pDi.eCp()) {
            throw new Exception("config error");
        }
        this.pDl = 0;
        new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(86400000L);
                        WeiboSsoSdk.eCm().cc((WeiboSsoSdk.this.pDk == null || TextUtils.isEmpty(WeiboSsoSdk.this.pDk.zi())) ? WeiboSsoSdk.this.eCo() : WeiboSsoSdk.this.pDk.zi(), 2);
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
        new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(60000L);
                    if (WeiboSsoSdk.this.pDj) {
                        WeiboSsoSdk.this.cc((WeiboSsoSdk.this.pDk == null || TextUtils.isEmpty(WeiboSsoSdk.this.pDk.zi())) ? WeiboSsoSdk.this.eCo() : WeiboSsoSdk.this.pDk.zi(), 2);
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
                if (bVar.eCp() && pDi == null) {
                    pDi = (b) bVar.clone();
                    com.weibo.ssosdk.a.init(pDi.getApplicationContext());
                    z = true;
                }
            }
        }
        return z;
    }

    public static synchronized WeiboSsoSdk eCm() throws Exception {
        WeiboSsoSdk weiboSsoSdk;
        synchronized (WeiboSsoSdk.class) {
            if (pDh == null) {
                pDh = new WeiboSsoSdk();
            }
            weiboSsoSdk = pDh;
        }
        return weiboSsoSdk;
    }

    /* loaded from: classes12.dex */
    public static final class a {
        private String mAid;
        private String pDn;

        public String zi() {
            return this.mAid;
        }

        static a ZX(String str) throws Exception {
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("retcode", "");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (!optString.equals("20000000") || jSONObject2 == null) {
                    throw new Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
                }
                aVar.mAid = jSONObject2.optString("aid", "");
                aVar.pDn = jSONObject2.optString("sub", "");
                return aVar;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private String ZV(String str) {
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
    public void cc(String str, int i) throws Exception {
        String str2;
        if (!TextUtils.isEmpty(pDi.Bo(false))) {
            if (!this.pDg.tryLock()) {
                this.pDg.lock();
                this.pDg.unlock();
                return;
            }
            this.pDj = false;
            String mfp = com.weibo.ssosdk.a.getMfp(pDi.getApplicationContext());
            try {
                str2 = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                str2 = "";
            }
            String ZV = ZV(riseWind(pDi.Bo(true), pDi.getApplicationContext().getPackageName(), str2, mfp, pDi.Bn(true), pDi.Bm(true), pDi.Bl(true), pDi.Bk(true), pDi.Bp(true), pDi.Bj(true), i, this.pDl));
            this.pDl++;
            if (ZV != null) {
                try {
                    a ZX = a.ZX(ZV);
                    if (ZX != null && !TextUtils.isEmpty(ZX.zi())) {
                        ZW(ZX.zi());
                    }
                    if (i == 1) {
                        this.pDk = ZX;
                    }
                    this.pDg.unlock();
                    return;
                } catch (Exception e2) {
                    this.pDg.unlock();
                    throw e2;
                }
            }
            this.pDg.unlock();
            throw new Exception("network error.");
        }
    }

    public a eCn() throws Exception {
        if (this.pDk == null) {
            Thread thread = new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WeiboSsoSdk.this.cc("", 1);
                    } catch (Exception e) {
                    }
                }
            });
            thread.start();
            thread.join();
        }
        if (this.pDk == null) {
            throw new Exception("visitor login failed");
        }
        return this.pDk;
    }

    public String zi() throws Exception {
        String eCo = eCo();
        if (TextUtils.isEmpty(eCo)) {
            if (this.pDk == null || TextUtils.isEmpty(this.pDk.zi())) {
                Thread thread = new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            WeiboSsoSdk.this.cc("", 1);
                        } catch (Exception e) {
                        }
                    }
                });
                thread.start();
                thread.join();
            }
            if (this.pDk == null) {
                throw new Exception("visitor login failed");
            }
            return this.pDk.zi();
        }
        return eCo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [378=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public String eCo() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(RL(1));
        } catch (Exception e) {
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str = new String(bArr);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    return str;
                } catch (IOException e2) {
                    return str;
                }
            }
            return str;
        } catch (Exception e3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    private File RL(int i) {
        return new File(pDi.getApplicationContext().getFilesDir(), "weibo_sso_sdk_aid" + i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [406=4] */
    private synchronized void ZW(String str) {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(RL(1));
                try {
                    fileOutputStream.write(str.getBytes());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable th) {
                    fileOutputStream2 = fileOutputStream;
                    th = th;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
