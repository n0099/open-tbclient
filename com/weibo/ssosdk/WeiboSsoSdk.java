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
/* loaded from: classes6.dex */
public class WeiboSsoSdk {
    private static WeiboSsoSdk ntS;
    private static b ntT;
    private volatile ReentrantLock ntR = new ReentrantLock(true);
    private boolean ntU = true;
    private a ntV;
    private int ntW;

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, int i2);

    static {
        System.loadLibrary("wind");
    }

    private WeiboSsoSdk() throws Exception {
        if (ntT == null || !ntT.dIx()) {
            throw new Exception("config error");
        }
        this.ntW = 0;
        new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(86400000L);
                        WeiboSsoSdk.dIt().bO((WeiboSsoSdk.this.ntV == null || TextUtils.isEmpty(WeiboSsoSdk.this.ntV.dIv())) ? WeiboSsoSdk.this.dIw() : WeiboSsoSdk.this.ntV.dIv(), 2);
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
                    if (WeiboSsoSdk.this.ntU) {
                        WeiboSsoSdk.this.bO((WeiboSsoSdk.this.ntV == null || TextUtils.isEmpty(WeiboSsoSdk.this.ntV.dIv())) ? WeiboSsoSdk.this.dIw() : WeiboSsoSdk.this.ntV.dIv(), 2);
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
                if (bVar.dIx() && ntT == null) {
                    ntT = (b) bVar.clone();
                    com.weibo.ssosdk.a.init(ntT.getApplicationContext());
                    z = true;
                }
            }
        }
        return z;
    }

    public static synchronized WeiboSsoSdk dIt() throws Exception {
        WeiboSsoSdk weiboSsoSdk;
        synchronized (WeiboSsoSdk.class) {
            if (ntS == null) {
                ntS = new WeiboSsoSdk();
            }
            weiboSsoSdk = ntS;
        }
        return weiboSsoSdk;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        private String mAid;
        private String ntY;

        public String dIv() {
            return this.mAid;
        }

        static a RB(String str) throws Exception {
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("retcode", "");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (!optString.equals("20000000") || jSONObject2 == null) {
                    throw new Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
                }
                aVar.mAid = jSONObject2.optString("aid", "");
                aVar.ntY = jSONObject2.optString("sub", "");
                return aVar;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private String Rz(String str) {
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
    public void bO(String str, int i) throws Exception {
        String str2;
        if (!TextUtils.isEmpty(ntT.wJ(false))) {
            if (!this.ntR.tryLock()) {
                this.ntR.lock();
                this.ntR.unlock();
                return;
            }
            this.ntU = false;
            String mfp = com.weibo.ssosdk.a.getMfp(ntT.getApplicationContext());
            try {
                str2 = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                str2 = "";
            }
            String Rz = Rz(riseWind(ntT.wJ(true), ntT.getApplicationContext().getPackageName(), str2, mfp, ntT.wI(true), ntT.wH(true), ntT.wG(true), ntT.wF(true), ntT.wK(true), ntT.wE(true), i, this.ntW));
            this.ntW++;
            if (Rz != null) {
                try {
                    a RB = a.RB(Rz);
                    if (RB != null && !TextUtils.isEmpty(RB.dIv())) {
                        RA(RB.dIv());
                    }
                    if (i == 1) {
                        this.ntV = RB;
                    }
                    this.ntR.unlock();
                    return;
                } catch (Exception e2) {
                    this.ntR.unlock();
                    throw e2;
                }
            }
            this.ntR.unlock();
            throw new Exception("network error.");
        }
    }

    public a dIu() throws Exception {
        if (this.ntV == null) {
            Thread thread = new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WeiboSsoSdk.this.bO("", 1);
                    } catch (Exception e) {
                    }
                }
            });
            thread.start();
            thread.join();
        }
        if (this.ntV == null) {
            throw new Exception("visitor login failed");
        }
        return this.ntV;
    }

    public String dIv() throws Exception {
        String dIw = dIw();
        if (TextUtils.isEmpty(dIw)) {
            if (this.ntV == null || TextUtils.isEmpty(this.ntV.dIv())) {
                Thread thread = new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            WeiboSsoSdk.this.bO("", 1);
                        } catch (Exception e) {
                        }
                    }
                });
                thread.start();
                thread.join();
            }
            if (this.ntV == null) {
                throw new Exception("visitor login failed");
            }
            return this.ntV.dIv();
        }
        return dIw;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [378=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public String dIw() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(NA(1));
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

    private File NA(int i) {
        return new File(ntT.getApplicationContext().getFilesDir(), "weibo_sso_sdk_aid" + i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [406=4] */
    private synchronized void RA(String str) {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(NA(1));
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
