package com.meizu.cloud.pushsdk.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import java.io.ByteArrayOutputStream;
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
/* loaded from: classes6.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f35315b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f35316c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public byte[] f35318d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f35319e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f35320f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f35321g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f35322h;

    /* renamed from: i  reason: collision with root package name */
    public PublicKey f35323i;
    public SharedPreferences j;
    public SharedPreferences k;
    public Context m;
    public long l = 0;

    /* renamed from: a  reason: collision with root package name */
    public String f35317a = "88&*5a9*4&a122ek";

    public a(Context context) {
        this.m = context;
        this.j = context.getSharedPreferences("com.x.y.1", 0);
        this.k = context.getSharedPreferences("com.x.y.2", 0);
        Integer.parseInt(this.j.getString("keyTimeout", "0"));
        this.j.getLong("createDate", 0L);
        e();
        byte[] bArr = this.f35318d;
        if (bArr != null && (bArr == null || bArr.length != 0)) {
            byte[] bArr2 = this.f35319e;
            if (bArr2 == null || (bArr2 != null && bArr2.length == 0)) {
                PublicKey b2 = b(this.m);
                this.f35323i = b2;
                if (b2 != null) {
                    h();
                    return;
                }
                return;
            }
            return;
        }
        PublicKey b3 = b(this.m);
        this.f35323i = b3;
        if (b3 != null) {
            f();
            return;
        }
        this.j.edit().clear().apply();
        try {
            d();
            PublicKey b4 = b(this.m);
            this.f35323i = b4;
            if (b4 != null) {
                f();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static a a() {
        a aVar = f35315b;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("KeyMgr is not initialised - invoke at least once with parameterised init/get");
    }

    private String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                try {
                    int read = inputStream.read();
                    if (read == -1) {
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                        try {
                            byteArrayOutputStream.close();
                            return byteArrayOutputStream2;
                        } catch (IOException unused) {
                            return byteArrayOutputStream2;
                        }
                    }
                    byteArrayOutputStream.write(read);
                } catch (IOException unused2) {
                    return null;
                }
            } catch (IOException unused3) {
                byteArrayOutputStream.close();
                return null;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                }
                throw th;
            }
        }
    }

    public static void a(Context context) {
        if (f35315b == null) {
            synchronized (f35316c) {
                if (f35315b == null) {
                    f35315b = new a(context);
                }
            }
        }
    }

    private PublicKey b(Context context) {
        b("load publicKey from preference");
        String string = this.k.getString("publicKey", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(string, 2)));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private void b(String str) {
        d.j.a.a.a.a("HttpKeyMgr", str);
    }

    private void c(String str) {
        d.j.a.a.a.b("HttpKeyMgr", str);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, IF, INVOKE, IF, NOP, INVOKE, INVOKE, IF, NOP] complete} */
    private void d() throws IOException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://norma-external-collect.meizu.com/android/exchange/getpublickey.do").openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            try {
                httpURLConnection.setRequestMethod("GET");
            } catch (ProtocolException e2) {
                e2.printStackTrace();
            }
            httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
            InputStream inputStream = null;
            try {
                int responseCode = httpURLConnection.getResponseCode();
                b("code = " + responseCode);
                inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    String a2 = a(inputStream);
                    b("body = " + a2);
                    if (!TextUtils.isEmpty(a2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(a2);
                            if (jSONObject.getInt("code") == 200) {
                                String string = jSONObject.getString("value");
                                SharedPreferences.Editor edit = this.k.edit();
                                edit.putString("publicKey", string);
                                edit.apply();
                            }
                        } catch (Exception e3) {
                            c("downloadPublicKey message error " + e3.getMessage());
                        }
                    }
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        } catch (MalformedURLException unused2) {
        }
    }

    private void e() {
        b("loadKeys");
        String string = this.j.getString("sKey64", "");
        b("saved sKey64: " + string);
        if (!TextUtils.isEmpty(string)) {
            this.f35322h = string.getBytes();
        }
        String string2 = this.j.getString("aKey64", "");
        b("saved aKey64: " + string2);
        if (!TextUtils.isEmpty(string2)) {
            byte[] bytes = string2.getBytes();
            this.f35321g = bytes;
            this.f35319e = Base64.decode(bytes, 2);
        }
        String string3 = this.j.getString("rKey64", "");
        b("saved rKey64: " + string3);
        if (TextUtils.isEmpty(string3)) {
            return;
        }
        byte[] bytes2 = string3.getBytes();
        this.f35320f = bytes2;
        this.f35318d = Base64.decode(bytes2, 2);
        b("saved rKey: " + new String(this.f35318d));
    }

    private void f() {
        g();
        h();
    }

    private void g() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            byte[] encoded = keyGenerator.generateKey().getEncoded();
            this.f35318d = encoded;
            this.f35320f = Base64.encode(encoded, 2);
            b("***** rKey64: " + new String(this.f35320f));
            SharedPreferences.Editor edit = this.j.edit();
            edit.putString("rKey64", new String(this.f35320f));
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void h() {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.f35323i);
            byte[] doFinal = cipher.doFinal(this.f35318d);
            this.f35319e = doFinal;
            this.f35321g = Base64.encode(doFinal, 2);
            b("***** aKey64: " + new String(this.f35321g));
            SharedPreferences.Editor edit = this.j.edit();
            edit.putString("aKey64", new String(this.f35321g));
            edit.apply();
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
        } catch (BadPaddingException e4) {
            e4.printStackTrace();
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
        } catch (NoSuchPaddingException e6) {
            e6.printStackTrace();
        }
    }

    public void a(String str) {
        this.f35322h = str.getBytes();
        SharedPreferences.Editor edit = this.j.edit();
        edit.putString("sKey64", new String(this.f35322h));
        edit.apply();
    }

    public byte[] a(byte[] bArr) {
        String str;
        byte[] bArr2 = this.f35318d;
        if (bArr2 == null || (bArr2 != null && bArr2.length == 0)) {
            str = "rKey null!";
        } else if (bArr != null && (bArr == null || bArr.length != 0)) {
            b(">>>>>>>>>> encrypt input >>>>>>>>>>\n" + new String(Base64.encode(bArr, 2)));
            b("<<<<<<<<<< encrypt input <<<<<<<<<<");
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, new SecretKeySpec(this.f35318d, "AES"), new IvParameterSpec(this.f35318d));
                byte[] doFinal = cipher.doFinal(bArr);
                b(">>>>>>>>>> encrypt output >>>>>>>>>>\n" + new String(Base64.encode(doFinal, 2)));
                b("<<<<<<<<<< encrypt output <<<<<<<<<<");
                return doFinal;
            } catch (InvalidAlgorithmParameterException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvalidKeyException e3) {
                e3.printStackTrace();
                return null;
            } catch (NoSuchAlgorithmException e4) {
                e4.printStackTrace();
                return null;
            } catch (BadPaddingException e5) {
                e5.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e6) {
                e6.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e7) {
                e7.printStackTrace();
                return null;
            }
        } else {
            str = "input null!";
        }
        c(str);
        return null;
    }

    public byte[] b() {
        return this.f35321g;
    }

    public byte[] c() {
        return this.f35322h;
    }
}
