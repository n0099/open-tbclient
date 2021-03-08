package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
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
/* loaded from: classes3.dex */
public class c {
    private static volatile c qnc = null;
    private ConcurrentHashMap c = new ConcurrentHashMap(10);
    private Context d;
    private e qnb;

    private c(Context context) {
        this.qnb = null;
        try {
            this.d = context;
            this.qnb = new e(this.d);
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    private String a(HashMap hashMap) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
            objectOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(hashMap);
            String str = new String(Base64.encode(com.yxcorp.kuaishou.addfp.android.b.a.a(byteArrayOutputStream.toByteArray(), "20212102sjcudiab".getBytes()), 0));
            try {
                objectOutputStream.close();
                return str;
            } catch (IOException e) {
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                return "";
            } finally {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            }
        }
    }

    public static void a(Context context, String str) {
        FileWriter fileWriter;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            File file = new File(com.yxcorp.kuaishou.addfp.android.b.a.w(context, false), new String(Base64.decode("Lm91a2R0ZnQ=", 0)));
            new File(file.getParent()).mkdirs();
            fileWriter = new FileWriter(file, false);
        } catch (Throwable th) {
            th = th;
            fileWriter = null;
        }
        try {
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
            try {
                fileWriter.close();
            } catch (IOException e) {
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (Throwable th3) {
                FileWriter fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (IOException e3) {
                    }
                }
                throw th3;
            }
        }
    }

    public static c iZ(Context context) {
        if (qnc == null) {
            synchronized (c.class) {
                if (qnc == null) {
                    qnc = new c(context);
                }
            }
        }
        return qnc;
    }

    public final synchronized Pair a() {
        Pair create;
        byte[] bArr;
        try {
            if (this.c != null) {
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.c.get("cache_e"))) {
                    create = Pair.create(Pair.create(Boolean.TRUE, sb.toString()), this.c);
                }
            }
            this.c.clear();
            String b = this.qnb.b();
            if (!TextUtils.isEmpty(b)) {
                try {
                    bArr = Base64.decode(b, 0);
                } catch (Throwable th) {
                    bArr = null;
                }
                if (bArr == null) {
                    try {
                        bArr = Base64.decode(b, 8);
                    } catch (Throwable th2) {
                    }
                }
                JSONObject jSONObject = new JSONObject(new String(com.yxcorp.kuaishou.addfp.android.b.a.b(bArr, "20212102sjcudiab".getBytes())));
                this.c.put("cache_e", jSONObject.optString("cache_e", ""));
                this.c.put("cache_m", jSONObject.optString("cache_m", ""));
                this.c.put("c_time", Long.toString(jSONObject.optLong("c_time", 0L)));
            }
            if (this.c != null && this.c.size() > 0) {
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.c.get("cache_e"))) {
                    create = Pair.create(Pair.create(Boolean.TRUE, sb2.toString()), this.c);
                }
            }
            create = Pair.create(Pair.create(Boolean.TRUE, "8"), null);
        }
        return create;
    }

    public final synchronized void a(String str, String str2) {
        byte[] bArr;
        LinkedHashMap linkedHashMap = null;
        synchronized (this) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.c.put("c_time", Long.toString(currentTimeMillis));
                this.c.put("cache_e", str);
                this.c.put("cache_m", str2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("c_time", currentTimeMillis);
                jSONObject.put("cache_e", str);
                jSONObject.put("cache_m", str2);
                byte[] a2 = com.yxcorp.kuaishou.addfp.android.b.a.a(jSONObject.toString().getBytes(), "20212102sjcudiab".getBytes());
                try {
                    bArr = Base64.encode(a2, 0);
                } catch (Throwable th) {
                    bArr = null;
                }
                if (bArr == null) {
                    try {
                        bArr = Base64.encode(a2, 8);
                    } catch (Throwable th2) {
                    }
                }
                if (bArr != null) {
                    this.qnb.a(new String(bArr));
                }
            } catch (Throwable th3) {
            }
            try {
                String a3 = d.a(this.d, "k_w_o_d_out_dtt");
                if (TextUtils.isEmpty(a3)) {
                    com.yxcorp.kuaishou.addfp.android.b.a.a();
                    if (com.yxcorp.kuaishou.addfp.android.b.e.d(this.d, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                        a3 = b("Lm91a2R0ZnQ=");
                    }
                }
                if (!TextUtils.isEmpty(a3) && (linkedHashMap = aca(a3)) != null) {
                    String b = b.qna.b();
                    if (!TextUtils.isEmpty(b)) {
                        if (linkedHashMap.containsKey(b)) {
                            linkedHashMap.remove(b);
                        }
                        linkedHashMap.put(b.qna.b(), str);
                    }
                }
                if (linkedHashMap == null || linkedHashMap.size() == 0) {
                    linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(b.qna.b(), str);
                }
                String a4 = a(linkedHashMap);
                if (!TextUtils.isEmpty(a4)) {
                    d.a(this.d, "k_w_o_d_out_dtt", a4);
                    com.yxcorp.kuaishou.addfp.android.b.a.a();
                    if (com.yxcorp.kuaishou.addfp.android.b.e.d(this.d, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                        a(this.d, a4);
                    }
                }
            } catch (Throwable th4) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th4);
            }
        }
    }

    public final LinkedHashMap aca(String str) {
        ObjectInputStream objectInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(com.yxcorp.kuaishou.addfp.android.b.a.b(Base64.decode(str.getBytes(), 0), "20212102sjcudiab".getBytes())));
                try {
                    LinkedHashMap linkedHashMap = (LinkedHashMap) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                        return linkedHashMap;
                    } catch (IOException e) {
                        return linkedHashMap;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        return new LinkedHashMap();
                    } catch (Throwable th2) {
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = null;
        }
        return new LinkedHashMap();
    }

    public final String b(String str) {
        try {
            File file = new File(com.yxcorp.kuaishou.addfp.android.b.a.w(this.d, false), new String(Base64.decode(str, 0)));
            if (file.exists()) {
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
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return "";
    }
}
