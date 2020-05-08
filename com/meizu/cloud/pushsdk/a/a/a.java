package com.meizu.cloud.pushsdk.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.sapi2.utils.h;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private static a b;
    private static final Object c = new Object();
    private byte[] d;
    private byte[] e;
    private byte[] f;
    private byte[] g;
    private byte[] h;
    private PublicKey i;
    private SharedPreferences j;
    private SharedPreferences k;
    private Context m;
    private long l = 0;
    String a = "88&*5a9*4&a122ek";

    private a(Context context) {
        this.m = context;
        this.j = context.getSharedPreferences("com.x.y.1", 0);
        this.k = context.getSharedPreferences("com.x.y.2", 0);
        Integer.parseInt(this.j.getString("keyTimeout", "0"));
        this.j.getLong("createDate", 0L);
        e();
        if (this.d != null && (this.d == null || this.d.length != 0)) {
            if (this.e == null || (this.e != null && this.e.length == 0)) {
                this.i = b(this.m);
                if (this.i != null) {
                    h();
                    return;
                }
                return;
            }
            return;
        }
        this.i = b(this.m);
        if (this.i != null) {
            f();
            return;
        }
        this.j.edit().clear().apply();
        try {
            d();
            this.i = b(this.m);
            if (this.i != null) {
                f();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static a a() {
        if (b == null) {
            throw new IllegalStateException("KeyMgr is not initialised - invoke at least once with parameterised init/get");
        }
        return b;
    }

    private String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String str = null;
        while (true) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            } catch (IOException e) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
                throw th;
            }
        }
        str = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e4) {
        }
        return str;
    }

    public static void a(Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new a(context);
                }
            }
        }
    }

    private PublicKey b(Context context) {
        b("load publicKey from preference");
        String string = this.k.getString("publicKey", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(string, 2)));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private void b(String str) {
        com.meizu.cloud.a.a.d("HttpKeyMgr", str);
    }

    private void c(String str) {
        com.meizu.cloud.a.a.e("HttpKeyMgr", str);
    }

    private void d() throws IOException {
        InputStream inputStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://norma-external-collect.meizu.com/android/exchange/getpublickey.do").openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            try {
                httpURLConnection.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            DataOutputStream dataOutputStream = null;
            try {
                b("code = " + httpURLConnection.getResponseCode());
                inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    try {
                        String a = a(inputStream);
                        b("body = " + a);
                        if (!TextUtils.isEmpty(a)) {
                            try {
                                JSONObject jSONObject = new JSONObject(a);
                                if (jSONObject.getInt("code") == 200) {
                                    String string = jSONObject.getString("value");
                                    SharedPreferences.Editor edit = this.k.edit();
                                    edit.putString("publicKey", string);
                                    edit.apply();
                                }
                            } catch (Exception e2) {
                                c("downloadPublicKey message error " + e2.getMessage());
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (0 != 0) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (0 != 0) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e5) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (MalformedURLException e7) {
        }
    }

    private void e() {
        b("loadKeys");
        String string = this.j.getString("sKey64", "");
        b("saved sKey64: " + string);
        if (!TextUtils.isEmpty(string)) {
            this.h = string.getBytes();
        }
        String string2 = this.j.getString("aKey64", "");
        b("saved aKey64: " + string2);
        if (!TextUtils.isEmpty(string2)) {
            this.g = string2.getBytes();
            this.e = Base64.decode(this.g, 2);
        }
        String string3 = this.j.getString("rKey64", "");
        b("saved rKey64: " + string3);
        if (TextUtils.isEmpty(string3)) {
            return;
        }
        this.f = string3.getBytes();
        this.d = Base64.decode(this.f, 2);
        b("saved rKey: " + new String(this.d));
    }

    private void f() {
        g();
        h();
    }

    private void g() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(h.q);
            keyGenerator.init(128);
            this.d = keyGenerator.generateKey().getEncoded();
            this.f = Base64.encode(this.d, 2);
            b("***** rKey64: " + new String(this.f));
            SharedPreferences.Editor edit = this.j.edit();
            edit.putString("rKey64", new String(this.f));
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void h() {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.i);
            this.e = cipher.doFinal(this.d);
            this.g = Base64.encode(this.e, 2);
            b("***** aKey64: " + new String(this.g));
            SharedPreferences.Editor edit = this.j.edit();
            edit.putString("aKey64", new String(this.g));
            edit.apply();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (BadPaddingException e3) {
            e3.printStackTrace();
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
        } catch (NoSuchPaddingException e5) {
            e5.printStackTrace();
        }
    }

    public void a(String str) {
        this.h = str.getBytes();
        SharedPreferences.Editor edit = this.j.edit();
        edit.putString("sKey64", new String(this.h));
        edit.apply();
    }

    public byte[] a(byte[] bArr) {
        if (this.d == null || (this.d != null && this.d.length == 0)) {
            c("rKey null!");
            return null;
        } else if (bArr == null || (bArr != null && bArr.length == 0)) {
            c("input null!");
            return null;
        } else {
            b(">>>>>>>>>> encrypt input >>>>>>>>>>\n" + new String(Base64.encode(bArr, 2)));
            b("<<<<<<<<<< encrypt input <<<<<<<<<<");
            try {
                Cipher cipher = Cipher.getInstance(h.p);
                cipher.init(1, new SecretKeySpec(this.d, h.q), new IvParameterSpec(this.d));
                byte[] doFinal = cipher.doFinal(bArr);
                b(">>>>>>>>>> encrypt output >>>>>>>>>>\n" + new String(Base64.encode(doFinal, 2)));
                b("<<<<<<<<<< encrypt output <<<<<<<<<<");
                return doFinal;
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
                return null;
            } catch (InvalidKeyException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
                return null;
            } catch (BadPaddingException e4) {
                e4.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e5) {
                e5.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e6) {
                e6.printStackTrace();
                return null;
            }
        }
    }

    public byte[] b() {
        return this.g;
    }

    public byte[] c() {
        return this.h;
    }
}
