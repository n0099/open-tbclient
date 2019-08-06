package com.weibo.ssosdk;

import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes2.dex */
public class WeiboSsoSdk {
    private static WeiboSsoSdk ksf;
    private static b ksg;
    private volatile ReentrantLock kse = new ReentrantLock(true);
    private boolean ksh = true;
    private a ksi;
    private int ksj;

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, int i2);

    static {
        System.loadLibrary("wind");
    }

    private WeiboSsoSdk() throws Exception {
        if (ksg == null || !ksg.cNG()) {
            throw new Exception("config error");
        }
        this.ksj = 0;
        new Thread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(86400000L);
                        WeiboSsoSdk.cND().bx((WeiboSsoSdk.this.ksi == null || TextUtils.isEmpty(WeiboSsoSdk.this.ksi.getAid())) ? WeiboSsoSdk.this.cNF() : WeiboSsoSdk.this.ksi.getAid(), 2);
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
                    if (WeiboSsoSdk.this.ksh) {
                        WeiboSsoSdk.this.bx((WeiboSsoSdk.this.ksi == null || TextUtils.isEmpty(WeiboSsoSdk.this.ksi.getAid())) ? WeiboSsoSdk.this.cNF() : WeiboSsoSdk.this.ksi.getAid(), 2);
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
                if (bVar.cNG() && ksg == null) {
                    ksg = (b) bVar.clone();
                    com.weibo.ssosdk.a.init(ksg.getApplicationContext());
                    z = true;
                }
            }
        }
        return z;
    }

    public static synchronized WeiboSsoSdk cND() throws Exception {
        WeiboSsoSdk weiboSsoSdk;
        synchronized (WeiboSsoSdk.class) {
            if (ksf == null) {
                ksf = new WeiboSsoSdk();
            }
            weiboSsoSdk = ksf;
        }
        return weiboSsoSdk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Id(String str) {
        Log.d("WeiboSsoSdk", str);
    }

    private static void Ic(String str) {
        Log.e("WeiboSsoSdk", str);
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private String ksl;
        private String mAid;

        public String getAid() {
            return this.mAid;
        }

        static a Ig(String str) throws Exception {
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("retcode", "");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (!optString.equals("20000000") || jSONObject2 == null) {
                    WeiboSsoSdk.Id("load aid error!");
                    throw new Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
                }
                aVar.mAid = jSONObject2.optString("aid", "");
                aVar.ksl = jSONObject2.optString("sub", "");
                return aVar;
            } catch (Exception e) {
                WeiboSsoSdk.Id("loadAidFromNet JSONException Msg : " + e.getMessage());
                throw e;
            }
        }
    }

    private String Ie(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://login.sina.com.cn/visitor/signin").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(1000);
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
    public void bx(String str, int i) throws Exception {
        String str2;
        if (!TextUtils.isEmpty(ksg.sQ(false))) {
            if (!this.kse.tryLock()) {
                Ic("tryLock : false, waiting for result");
                this.kse.lock();
                this.kse.unlock();
                return;
            }
            this.ksh = false;
            String mfp = com.weibo.ssosdk.a.getMfp(ksg.getApplicationContext());
            try {
                str2 = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                str2 = "";
            }
            String Ie = Ie(riseWind(ksg.sQ(true), ksg.getApplicationContext().getPackageName(), str2, mfp, ksg.sP(true), ksg.sO(true), ksg.sN(true), ksg.sM(true), ksg.sR(true), ksg.sL(true), i, this.ksj));
            this.ksj++;
            if (Ie != null) {
                try {
                    a Ig = a.Ig(Ie);
                    if (Ig != null && !TextUtils.isEmpty(Ig.getAid())) {
                        If(Ig.getAid());
                    }
                    if (i == 1) {
                        this.ksi = Ig;
                    }
                    this.kse.unlock();
                    return;
                } catch (Exception e2) {
                    this.kse.unlock();
                    throw e2;
                }
            }
            this.kse.unlock();
            throw new Exception("network error.");
        }
    }

    public a cNE() throws Exception {
        Ic("visitorLogin");
        if (this.ksi == null) {
            bx("", 1);
        }
        return this.ksi;
    }

    public String getAid() throws Exception {
        Ic("visitorLogin");
        String cNF = cNF();
        if (TextUtils.isEmpty(cNF)) {
            if (this.ksi == null || TextUtils.isEmpty(this.ksi.getAid())) {
                bx("", 1);
            }
            return this.ksi.getAid();
        }
        return cNF;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [348=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public String cNF() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(ED(1));
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

    private File ED(int i) {
        return new File(ksg.getApplicationContext().getFilesDir(), "weibo_sso_sdk_aid" + i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [376=4] */
    private synchronized void If(String str) {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(ED(1));
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
