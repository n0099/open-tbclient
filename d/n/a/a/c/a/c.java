package d.n.a.a.c.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.n.a.a.c.b.f;
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
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f72628d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f72629a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap f72630b;

    /* renamed from: c  reason: collision with root package name */
    public Context f72631c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-590059130, "Ld/n/a/a/c/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-590059130, "Ld/n/a/a/c/a/c;");
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
        this.f72629a = null;
        this.f72630b = new ConcurrentHashMap(10);
        try {
            this.f72631c = context;
            this.f72629a = new e(context);
        } catch (Throwable th) {
            d.n.a.a.c.b.c.c(th);
        }
    }

    public static c b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f72628d == null) {
                synchronized (c.class) {
                    if (f72628d == null) {
                        f72628d = new c(context);
                    }
                }
            }
            return f72628d;
        }
        return (c) invokeL.objValue;
    }

    public static void e(Context context, String str) {
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        FileWriter fileWriter2 = null;
        try {
            File file = new File(d.n.a.a.c.b.b.a(context, false), new String(Base64.decode("Lm91a2R0ZnQ=", 0)));
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
                d.n.a.a.c.b.c.c(th);
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
                    if (this.f72630b != null) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty((String) this.f72630b.get("cache_e"))) {
                            return Pair.create(Pair.create(Boolean.TRUE, sb.toString()), this.f72630b);
                        }
                    }
                    this.f72630b.clear();
                    String c2 = this.f72629a.c();
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
                        try {
                            JSONObject jSONObject = new JSONObject(new String(d.n.a.a.c.b.b.f(bArr, "20212102sjcudiab".getBytes())));
                            this.f72630b.put("cache_e", jSONObject.optString("cache_e", ""));
                            this.f72630b.put("cache_m", jSONObject.optString("cache_m", ""));
                            this.f72630b.put("c_time", Long.toString(jSONObject.optLong("c_time", 0L)));
                        } catch (Throwable th) {
                            d.n.a.a.c.b.c.c(th);
                        }
                    }
                    if (this.f72630b != null && this.f72630b.size() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (!TextUtils.isEmpty((String) this.f72630b.get("cache_e"))) {
                            return Pair.create(Pair.create(Boolean.TRUE, sb2.toString()), this.f72630b);
                        }
                    }
                    return Pair.create(Pair.create(Boolean.TRUE, "8"), null);
                }
            }
        }
        return (Pair) invokeV.objValue;
    }

    public final String c(HashMap hashMap) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap)) == null) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectOutputStream.writeObject(hashMap);
                String str = new String(Base64.encode(d.n.a.a.c.b.b.d(byteArrayOutputStream.toByteArray(), "20212102sjcudiab".getBytes()), 0));
                try {
                    objectOutputStream.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                try {
                    d.n.a.a.c.b.c.c(th);
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

    public final LinkedHashMap d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            ObjectInputStream objectInputStream = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(d.n.a.a.c.b.b.f(Base64.decode(str.getBytes(), 0), "20212102sjcudiab".getBytes())));
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
                            d.n.a.a.c.b.c.c(th);
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

    public final synchronized void f(String str, String str2) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            synchronized (this) {
                LinkedHashMap linkedHashMap = null;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f72630b.put("c_time", Long.toString(currentTimeMillis));
                    this.f72630b.put("cache_e", str);
                    this.f72630b.put("cache_m", str2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("c_time", currentTimeMillis);
                    jSONObject.put("cache_e", str);
                    jSONObject.put("cache_m", str2);
                    byte[] d2 = d.n.a.a.c.b.b.d(jSONObject.toString().getBytes(), "20212102sjcudiab".getBytes());
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
                        this.f72629a.a(new String(bArr));
                    }
                } catch (Throwable unused3) {
                }
                try {
                    String c2 = d.c(this.f72631c, "k_w_o_d_out_dtt");
                    if (TextUtils.isEmpty(c2)) {
                        d.n.a.a.c.b.b.b();
                        if (f.g(this.f72631c, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION})) {
                            c2 = g("Lm91a2R0ZnQ=");
                        }
                    }
                    if (!TextUtils.isEmpty(c2) && (linkedHashMap = d(c2)) != null) {
                        String e2 = b.f72627a.e();
                        if (!TextUtils.isEmpty(e2)) {
                            if (linkedHashMap.containsKey(e2)) {
                                linkedHashMap.remove(e2);
                            }
                            linkedHashMap.put(b.f72627a.e(), str);
                        }
                    }
                    if (linkedHashMap == null || linkedHashMap.size() == 0) {
                        linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put(b.f72627a.e(), str);
                    }
                    String c3 = c(linkedHashMap);
                    if (!TextUtils.isEmpty(c3)) {
                        d.d(this.f72631c, "k_w_o_d_out_dtt", c3);
                        d.n.a.a.c.b.b.b();
                        if (f.g(this.f72631c, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION})) {
                            e(this.f72631c, c3);
                        }
                    }
                } catch (Throwable th) {
                    d.n.a.a.c.b.c.c(th);
                }
            }
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            File file = new File(d.n.a.a.c.b.b.a(this.f72631c, false), new String(Base64.decode(str, 0)));
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
            d.n.a.a.c.b.c.c(th);
            return "";
        }
    }
}
