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
/* loaded from: classes10.dex */
public class WeiboSsoSdk {
    private static WeiboSsoSdk pKy;
    private static b pKz;
    private a pKB;
    private int pKC;
    private volatile ReentrantLock pKx = new ReentrantLock(true);
    private boolean pKA = true;

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, int i2);

    static {
        System.loadLibrary("wind");
    }

    private WeiboSsoSdk() throws Exception {
        if (pKz == null || !pKz.ezR()) {
            throw new Exception("config error");
        }
        this.pKC = 0;
        new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(86400000L);
                        WeiboSsoSdk.ezO().bZ((WeiboSsoSdk.this.pKB == null || TextUtils.isEmpty(WeiboSsoSdk.this.pKB.zZ())) ? WeiboSsoSdk.this.ezQ() : WeiboSsoSdk.this.pKB.zZ(), 2);
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
                    if (WeiboSsoSdk.this.pKA) {
                        WeiboSsoSdk.this.bZ((WeiboSsoSdk.this.pKB == null || TextUtils.isEmpty(WeiboSsoSdk.this.pKB.zZ())) ? WeiboSsoSdk.this.ezQ() : WeiboSsoSdk.this.pKB.zZ(), 2);
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
                if (bVar.ezR() && pKz == null) {
                    pKz = (b) bVar.clone();
                    com.weibo.ssosdk.a.init(pKz.getApplicationContext());
                    z = true;
                }
            }
        }
        return z;
    }

    public static synchronized WeiboSsoSdk ezO() throws Exception {
        WeiboSsoSdk weiboSsoSdk;
        synchronized (WeiboSsoSdk.class) {
            if (pKy == null) {
                pKy = new WeiboSsoSdk();
            }
            weiboSsoSdk = pKy;
        }
        return weiboSsoSdk;
    }

    /* loaded from: classes10.dex */
    public static final class a {
        private String mAid;
        private String pKE;

        public String zZ() {
            return this.mAid;
        }

        static a Zp(String str) throws Exception {
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("retcode", "");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (!optString.equals("20000000") || jSONObject2 == null) {
                    throw new Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
                }
                aVar.mAid = jSONObject2.optString("aid", "");
                aVar.pKE = jSONObject2.optString("sub", "");
                return aVar;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private String Zn(String str) {
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
    public void bZ(String str, int i) throws Exception {
        String str2;
        if (!TextUtils.isEmpty(pKz.AT(false))) {
            if (!this.pKx.tryLock()) {
                this.pKx.lock();
                this.pKx.unlock();
                return;
            }
            this.pKA = false;
            String mfp = com.weibo.ssosdk.a.getMfp(pKz.getApplicationContext());
            try {
                str2 = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                str2 = "";
            }
            String Zn = Zn(riseWind(pKz.AT(true), pKz.getApplicationContext().getPackageName(), str2, mfp, pKz.AS(true), pKz.AR(true), pKz.AQ(true), pKz.AP(true), pKz.AU(true), pKz.AO(true), i, this.pKC));
            this.pKC++;
            if (Zn != null) {
                try {
                    a Zp = a.Zp(Zn);
                    if (Zp != null && !TextUtils.isEmpty(Zp.zZ())) {
                        Zo(Zp.zZ());
                    }
                    if (i == 1) {
                        this.pKB = Zp;
                    }
                    this.pKx.unlock();
                    return;
                } catch (Exception e2) {
                    this.pKx.unlock();
                    throw e2;
                }
            }
            this.pKx.unlock();
            throw new Exception("network error.");
        }
    }

    public a ezP() throws Exception {
        if (this.pKB == null) {
            Thread thread = new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WeiboSsoSdk.this.bZ("", 1);
                    } catch (Exception e) {
                    }
                }
            });
            thread.start();
            thread.join();
        }
        if (this.pKB == null) {
            throw new Exception("visitor login failed");
        }
        return this.pKB;
    }

    public String zZ() throws Exception {
        String ezQ = ezQ();
        if (TextUtils.isEmpty(ezQ)) {
            if (this.pKB == null || TextUtils.isEmpty(this.pKB.zZ())) {
                Thread thread = new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            WeiboSsoSdk.this.bZ("", 1);
                        } catch (Exception e) {
                        }
                    }
                });
                thread.start();
                thread.join();
            }
            if (this.pKB == null) {
                throw new Exception("visitor login failed");
            }
            return this.pKB.zZ();
        }
        return ezQ;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [378=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public String ezQ() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(Ri(1));
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

    private File Ri(int i) {
        return new File(pKz.getApplicationContext().getFilesDir(), "weibo_sso_sdk_aid" + i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [406=4] */
    private synchronized void Zo(String str) {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(Ri(1));
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
