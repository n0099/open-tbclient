package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
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
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public e f60100b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap f60101c;

    /* renamed from: d  reason: collision with root package name */
    public Context f60102d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-28101696, "Lcom/yxcorp/kuaishou/addfp/android/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-28101696, "Lcom/yxcorp/kuaishou/addfp/android/a/c;");
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60100b = null;
        this.f60101c = new ConcurrentHashMap(10);
        try {
            this.f60102d = context;
            this.f60100b = new e(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (c.class) {
                    if (a == null) {
                        a = new c(context);
                    }
                }
            }
            return a;
        }
        return (c) invokeL.objValue;
    }

    private String a(HashMap hashMap) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, hashMap)) == null) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectOutputStream.writeObject(hashMap);
                String str = new String(Base64.encode(com.yxcorp.kuaishou.addfp.android.b.b.a(byteArrayOutputStream.toByteArray(), "20212102sjcudiab".getBytes()), 0));
                try {
                    objectOutputStream.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                try {
                    th.printStackTrace();
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                            return "";
                        } catch (IOException unused2) {
                            return "";
                        }
                    }
                    return "";
                } catch (Throwable th3) {
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, String str) {
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        FileWriter fileWriter2 = null;
        try {
            File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(context, false), new String(Base64.decode("Lm91a2R0ZnQ=", 0)));
            new File(file.getParent()).mkdirs();
            fileWriter = new FileWriter(file, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
            try {
                fileWriter.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            try {
                th.printStackTrace();
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Throwable th3) {
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th3;
            }
        }
    }

    public final synchronized Pair a() {
        InterceptResult invokeV;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                try {
                    if (this.f60101c != null) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty((String) this.f60101c.get("cache_e"))) {
                            return Pair.create(Pair.create(Boolean.TRUE, sb.toString()), this.f60101c);
                        }
                    }
                    this.f60101c.clear();
                    String b2 = this.f60100b.b();
                    if (!TextUtils.isEmpty(b2)) {
                        try {
                            bArr = Base64.decode(b2, 0);
                        } catch (Throwable unused) {
                            bArr = null;
                        }
                        if (bArr == null) {
                            try {
                                bArr = Base64.decode(b2, 8);
                            } catch (Throwable unused2) {
                            }
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(new String(com.yxcorp.kuaishou.addfp.android.b.b.b(bArr, "20212102sjcudiab".getBytes())));
                            this.f60101c.put("cache_e", jSONObject.optString("cache_e", ""));
                            this.f60101c.put("cache_m", jSONObject.optString("cache_m", ""));
                            this.f60101c.put("c_time", Long.toString(jSONObject.optLong("c_time", 0L)));
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    if (this.f60101c != null && this.f60101c.size() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (!TextUtils.isEmpty((String) this.f60101c.get("cache_e"))) {
                            return Pair.create(Pair.create(Boolean.TRUE, sb2.toString()), this.f60101c);
                        }
                    }
                    return Pair.create(Pair.create(Boolean.TRUE, "8"), null);
                }
            }
        }
        return (Pair) invokeV.objValue;
    }

    public final LinkedHashMap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
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
                    } catch (Throwable th) {
                        th = th;
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
        return (LinkedHashMap) invokeL.objValue;
    }

    public final synchronized void a(String str, String str2) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            synchronized (this) {
                LinkedHashMap linkedHashMap = null;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f60101c.put("c_time", Long.toString(currentTimeMillis));
                    this.f60101c.put("cache_e", str);
                    this.f60101c.put("cache_m", str2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("c_time", currentTimeMillis);
                    jSONObject.put("cache_e", str);
                    jSONObject.put("cache_m", str2);
                    byte[] a2 = com.yxcorp.kuaishou.addfp.android.b.b.a(jSONObject.toString().getBytes(), "20212102sjcudiab".getBytes());
                    try {
                        bArr = Base64.encode(a2, 0);
                    } catch (Throwable unused) {
                        bArr = null;
                    }
                    if (bArr == null) {
                        try {
                            bArr = Base64.encode(a2, 8);
                        } catch (Throwable unused2) {
                        }
                    }
                    if (bArr != null) {
                        this.f60100b.a(new String(bArr));
                    }
                } catch (Throwable unused3) {
                }
                try {
                    String a3 = d.a(this.f60102d, "k_w_o_d_out_dtt");
                    if (TextUtils.isEmpty(a3)) {
                        com.yxcorp.kuaishou.addfp.android.b.b.a();
                        if (com.yxcorp.kuaishou.addfp.android.b.e.b(this.f60102d, new String[]{s.f53810i, "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                            a3 = b("Lm91a2R0ZnQ=");
                        }
                    }
                    if (!TextUtils.isEmpty(a3) && (linkedHashMap = a(a3)) != null) {
                        String b2 = b.a.b();
                        if (!TextUtils.isEmpty(b2)) {
                            if (linkedHashMap.containsKey(b2)) {
                                linkedHashMap.remove(b2);
                            }
                            linkedHashMap.put(b.a.b(), str);
                        }
                    }
                    if (linkedHashMap == null || linkedHashMap.size() == 0) {
                        linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put(b.a.b(), str);
                    }
                    String a4 = a(linkedHashMap);
                    if (!TextUtils.isEmpty(a4)) {
                        d.a(this.f60102d, "k_w_o_d_out_dtt", a4);
                        com.yxcorp.kuaishou.addfp.android.b.b.a();
                        if (com.yxcorp.kuaishou.addfp.android.b.e.b(this.f60102d, new String[]{s.f53810i, "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                            a(this.f60102d, a4);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(this.f60102d, false), new String(Base64.decode(str, 0)));
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
}
