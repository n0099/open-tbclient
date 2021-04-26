package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, f> f37294a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    public static String f37295b = null;

    /* renamed from: c  reason: collision with root package name */
    public Context f37296c;

    /* renamed from: d  reason: collision with root package name */
    public String f37297d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f37298e = null;

    /* renamed from: f  reason: collision with root package name */
    public long f37299f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f37300g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37301h = true;

    public f(Context context, String str) {
        this.f37296c = null;
        this.f37297d = null;
        this.f37296c = context.getApplicationContext();
        this.f37297d = str;
        a();
        b();
    }

    private void b() {
        if (this.f37300g != 0) {
            d("update thread is running, return");
            return;
        }
        this.f37300g = 1;
        final Bundle bundle = new Bundle();
        bundle.putString("appid", this.f37297d);
        bundle.putString("appid_for_getting_config", this.f37297d);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        new Thread() { // from class: com.tencent.open.utils.f.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    f.this.a(j.d(HttpUtils.openUrl2(f.this.f37296c, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", bundle).f37321a));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                f.this.f37300g = 0;
            }
        }.start();
    }

    private String c(String str) {
        InputStream open;
        String str2;
        String str3 = "";
        try {
            try {
                if (this.f37297d != null) {
                    str2 = str + "." + this.f37297d;
                } else {
                    str2 = str;
                }
                open = this.f37296c.openFileInput(str2);
            } catch (IOException e2) {
                e2.printStackTrace();
                return "";
            }
        } catch (FileNotFoundException unused) {
            open = this.f37296c.getAssets().open(str);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Charset.forName("UTF-8")));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    open.close();
                    bufferedReader.close();
                }
            } catch (Throwable th) {
                try {
                    open.close();
                    bufferedReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                throw th;
            }
        }
        str3 = stringBuffer.toString();
        open.close();
        bufferedReader.close();
        return str3;
    }

    private void d(String str) {
        if (this.f37301h) {
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", str + "; appid: " + this.f37297d);
        }
    }

    public static f a(Context context, String str) {
        f fVar;
        synchronized (f37294a) {
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                f37295b = str;
            }
            if (str == null) {
                str = f37295b != null ? f37295b : "0";
            }
            fVar = f37294a.get(str);
            if (fVar == null) {
                fVar = new f(context, str);
                f37294a.put(str, fVar);
            }
            com.tencent.open.a.f.a("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return fVar;
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object opt = this.f37298e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        }
        return false;
    }

    private void a() {
        try {
            this.f37298e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.f37298e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.f37297d != null) {
                str = str + "." + this.f37297d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f37296c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        int optInt = this.f37298e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f37299f >= optInt * 3600000) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.f37298e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f37299f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.f37298e.optInt(str);
    }
}
