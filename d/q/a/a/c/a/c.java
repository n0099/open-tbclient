package d.q.a.a.c.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f67373d;

    /* renamed from: a  reason: collision with root package name */
    public e f67374a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap f67375b = new ConcurrentHashMap(10);

    /* renamed from: c  reason: collision with root package name */
    public Context f67376c;

    public c(Context context) {
        this.f67374a = null;
        try {
            this.f67376c = context;
            this.f67374a = new e(context);
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public static c b(Context context) {
        if (f67373d == null) {
            synchronized (c.class) {
                if (f67373d == null) {
                    f67373d = new c(context);
                }
            }
        }
        return f67373d;
    }

    public static void e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            File file = new File(d.q.a.a.c.b.a.a(context, false), new String(Base64.decode("Lm91a2R0ZnQ=", 0)));
            new File(file.getParent()).mkdirs();
            FileWriter fileWriter2 = new FileWriter(file, false);
            try {
                fileWriter2.write(str);
                fileWriter2.flush();
                fileWriter2.close();
                try {
                    fileWriter2.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
                fileWriter = fileWriter2;
                try {
                    d.q.a.a.c.b.b.c(th);
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th2) {
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final synchronized Pair a() {
        byte[] bArr;
        try {
            if (this.f67375b != null) {
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.f67375b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb.toString()), this.f67375b);
                }
            }
            this.f67375b.clear();
            String c2 = this.f67374a.c();
            if (!TextUtils.isEmpty(c2)) {
                try {
                    bArr = Base64.decode(c2, 0);
                } catch (Throwable unused) {
                    bArr = null;
                }
                if (bArr == null) {
                    try {
                        bArr = Base64.decode(c2, 8);
                    } catch (Throwable unused2) {
                    }
                }
                JSONObject jSONObject = new JSONObject(new String(d.q.a.a.c.b.a.f(bArr, "20212102sjcudiab".getBytes())));
                this.f67375b.put("cache_e", jSONObject.optString("cache_e", ""));
                this.f67375b.put("cache_m", jSONObject.optString("cache_m", ""));
                this.f67375b.put("c_time", Long.toString(jSONObject.optLong("c_time", 0L)));
            }
            if (this.f67375b != null && this.f67375b.size() > 0) {
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.f67375b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb2.toString()), this.f67375b);
                }
            }
            return Pair.create(Pair.create(Boolean.TRUE, "8"), null);
        }
    }

    public final String c(HashMap hashMap) {
        ObjectOutputStream objectOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream2.writeObject(hashMap);
                String str = new String(Base64.encode(d.q.a.a.c.b.a.d(byteArrayOutputStream.toByteArray(), "20212102sjcudiab".getBytes()), 0));
                try {
                    objectOutputStream2.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Throwable th) {
                th = th;
                objectOutputStream = objectOutputStream2;
                try {
                    d.q.a.a.c.b.b.c(th);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                            return "";
                        } catch (IOException unused2) {
                            return "";
                        }
                    }
                    return "";
                } catch (Throwable th2) {
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final LinkedHashMap d(String str) {
        ObjectInputStream objectInputStream = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(d.q.a.a.c.b.a.f(Base64.decode(str.getBytes(), 0), "20212102sjcudiab".getBytes())));
                try {
                    LinkedHashMap linkedHashMap = (LinkedHashMap) objectInputStream2.readObject();
                    try {
                        objectInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return linkedHashMap;
                } catch (Throwable th) {
                    th = th;
                    objectInputStream = objectInputStream2;
                    try {
                        d.q.a.a.c.b.b.c(th);
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return new LinkedHashMap();
                    } catch (Throwable th2) {
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return new LinkedHashMap();
    }

    public final synchronized void f(String str, String str2) {
        byte[] bArr;
        LinkedHashMap linkedHashMap = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f67375b.put("c_time", Long.toString(currentTimeMillis));
            this.f67375b.put("cache_e", str);
            this.f67375b.put("cache_m", str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("c_time", currentTimeMillis);
            jSONObject.put("cache_e", str);
            jSONObject.put("cache_m", str2);
            byte[] d2 = d.q.a.a.c.b.a.d(jSONObject.toString().getBytes(), "20212102sjcudiab".getBytes());
            try {
                bArr = Base64.encode(d2, 0);
            } catch (Throwable unused) {
                bArr = null;
            }
            if (bArr == null) {
                try {
                    bArr = Base64.encode(d2, 8);
                } catch (Throwable unused2) {
                }
            }
            if (bArr != null) {
                this.f67374a.a(new String(bArr));
            }
        } catch (Throwable unused3) {
        }
        try {
            String c2 = d.c(this.f67376c, "k_w_o_d_out_dtt");
            if (TextUtils.isEmpty(c2)) {
                d.q.a.a.c.b.a.b();
                if (d.q.a.a.c.b.e.g(this.f67376c, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION})) {
                    c2 = g("Lm91a2R0ZnQ=");
                }
            }
            if (!TextUtils.isEmpty(c2) && (linkedHashMap = d(c2)) != null) {
                String e2 = b.f67372a.e();
                if (!TextUtils.isEmpty(e2)) {
                    if (linkedHashMap.containsKey(e2)) {
                        linkedHashMap.remove(e2);
                    }
                    linkedHashMap.put(b.f67372a.e(), str);
                }
            }
            if (linkedHashMap == null || linkedHashMap.size() == 0) {
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(b.f67372a.e(), str);
            }
            String c3 = c(linkedHashMap);
            if (!TextUtils.isEmpty(c3)) {
                d.f(this.f67376c, "k_w_o_d_out_dtt", c3);
                d.q.a.a.c.b.a.b();
                if (d.q.a.a.c.b.e.g(this.f67376c, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION})) {
                    e(this.f67376c, c3);
                }
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final String g(String str) {
        try {
            File file = new File(d.q.a.a.c.b.a.a(this.f67376c, false), new String(Base64.decode(str, 0)));
            if (!file.exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return sb.toString().trim();
                }
                sb.append(readLine);
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return "";
        }
    }
}
