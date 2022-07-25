package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.h;
import com.yxcorp.kuaishou.addfp.android.b.g;
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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d d;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;
    public ConcurrentHashMap b;
    public Context c;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new ConcurrentHashMap(10);
        try {
            this.c = context;
            this.a = new e(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static d a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (d == null) {
                synchronized (d.class) {
                    if (d == null) {
                        d = new d(context);
                    }
                }
            }
            return d;
        }
        return (d) invokeL.objValue;
    }

    private String a(HashMap hashMap) {
        ObjectOutputStream objectOutputStream;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, this, hashMap)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(hashMap);
                String str = new String(Base64.encode(com.yxcorp.kuaishou.addfp.android.b.b.c(byteArrayOutputStream.toByteArray(), "20212102sjcudiab".getBytes()), 0));
                try {
                    objectOutputStream.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
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
            objectOutputStream = null;
        }
    }

    public static void a(Context context, String str) {
        Throwable th;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(context, false), new String(Base64.decode("Lm91a2R0ZnQ=", 0)));
                    new File(file.getParent()).mkdirs();
                    fileWriter = new FileWriter(file, false);
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = null;
                }
                try {
                    fileWriter.write(str);
                    fileWriter.flush();
                    fileWriter.close();
                    fileWriter.close();
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        th.printStackTrace();
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (Throwable th4) {
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th4;
                    }
                }
            } catch (IOException unused2) {
            }
        }
    }

    public synchronized Pair a() {
        InterceptResult invokeV;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.b != null) {
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty((String) this.b.get("cache_e"))) {
                        return Pair.create(Pair.create(Boolean.TRUE, sb.toString()), this.b);
                    }
                }
                this.b.clear();
                String b = this.a.b();
                if (!TextUtils.isEmpty(b)) {
                    try {
                        bArr = Base64.decode(b, 0);
                    } catch (Throwable unused) {
                        bArr = null;
                    }
                    if (bArr == null) {
                        try {
                            bArr = Base64.decode(b, 8);
                        } catch (Throwable unused2) {
                        }
                    }
                    JSONObject jSONObject = new JSONObject(new String(com.yxcorp.kuaishou.addfp.android.b.b.b(bArr, "20212102sjcudiab".getBytes())));
                    this.b.put("cache_e", jSONObject.optString("cache_e", ""));
                    this.b.put("cache_m", jSONObject.optString("cache_m", ""));
                    this.b.put("c_time", Long.toString(jSONObject.optLong("c_time", 0L)));
                }
                ConcurrentHashMap concurrentHashMap = this.b;
                if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    if (!TextUtils.isEmpty((String) this.b.get("cache_e"))) {
                        return Pair.create(Pair.create(Boolean.TRUE, sb2.toString()), this.b);
                    }
                }
                return Pair.create(Pair.create(Boolean.TRUE, "8"), null);
            }
        }
        return (Pair) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(this.c, false), new String(Base64.decode(str, 0)));
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
            th.printStackTrace();
            return "";
        }
    }

    public synchronized void a(String str, String str2) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            synchronized (this) {
                LinkedHashMap linkedHashMap = null;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.b.put("c_time", Long.toString(currentTimeMillis));
                    this.b.put("cache_e", str);
                    this.b.put("cache_m", str2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("c_time", currentTimeMillis);
                    jSONObject.put("cache_e", str);
                    jSONObject.put("cache_m", str2);
                    byte[] c = com.yxcorp.kuaishou.addfp.android.b.b.c(jSONObject.toString().getBytes(), "20212102sjcudiab".getBytes());
                    try {
                        bArr = Base64.encode(c, 0);
                    } catch (Throwable unused) {
                        bArr = null;
                    }
                    if (bArr == null) {
                        try {
                            bArr = Base64.encode(c, 8);
                        } catch (Throwable unused2) {
                        }
                    }
                    if (bArr != null) {
                        this.a.a(new String(bArr));
                    }
                } catch (Throwable unused3) {
                }
                try {
                    String a = com.yxcorp.kuaishou.addfp.c.a.a.a(this.c, "k_w_o_d_out_dtt");
                    if (TextUtils.isEmpty(a) && g.a(this.c, new String[]{h.i, "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                        a = a("Lm91a2R0ZnQ=");
                    }
                    if (!TextUtils.isEmpty(a) && (linkedHashMap = b(a)) != null) {
                        c cVar = b.a;
                        String a2 = cVar.a();
                        if (!TextUtils.isEmpty(a2)) {
                            if (linkedHashMap.containsKey(a2)) {
                                linkedHashMap.remove(a2);
                            }
                            linkedHashMap.put(cVar.a(), str);
                        }
                    }
                    if (linkedHashMap == null || linkedHashMap.size() == 0) {
                        linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put(b.a.a(), str);
                    }
                    String a3 = a(linkedHashMap);
                    if (!TextUtils.isEmpty(a3)) {
                        try {
                            Settings.System.putString(this.c.getContentResolver(), "k_w_o_d_out_dtt", a3);
                        } catch (Throwable unused4) {
                        }
                        if (g.a(this.c, new String[]{h.i, "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                            a(this.c, a3);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public LinkedHashMap b(String str) {
        InterceptResult invokeL;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ObjectInputStream objectInputStream = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(com.yxcorp.kuaishou.addfp.android.b.b.b(Base64.decode(str.getBytes(), 0), "20212102sjcudiab".getBytes())));
                    try {
                        LinkedHashMap linkedHashMap = (LinkedHashMap) objectInputStream2.readObject();
                        try {
                            objectInputStream2.close();
                        } catch (IOException unused) {
                        }
                        return linkedHashMap;
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream = objectInputStream2;
                        try {
                            th.printStackTrace();
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            return new LinkedHashMap();
                        } catch (Throwable th3) {
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            throw th3;
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
            return new LinkedHashMap();
        }
        return (LinkedHashMap) invokeL.objValue;
    }
}
