package d.a.l;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.l.b.a;
import d.a.l.b.b;
import d.a.l.f;
import d.a.l.g.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f43370g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f43371a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0625a f43372b;

    /* renamed from: c  reason: collision with root package name */
    public volatile FileLock f43373c;

    /* renamed from: d  reason: collision with root package name */
    public volatile RandomAccessFile f43374d;

    /* renamed from: e  reason: collision with root package name */
    public b f43375e;

    /* renamed from: f  reason: collision with root package name */
    public f f43376f;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: g  reason: collision with root package name */
        public static final String[] f43377g;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f43378a;

        /* renamed from: b  reason: collision with root package name */
        public String f43379b;

        /* renamed from: c  reason: collision with root package name */
        public String f43380c;

        /* renamed from: d  reason: collision with root package name */
        public long f43381d;

        /* renamed from: e  reason: collision with root package name */
        public String f43382e;

        /* renamed from: f  reason: collision with root package name */
        public int f43383f;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1496325382, "Ld/a/l/l$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1496325382, "Ld/a/l/l$a;");
                    return;
                }
            }
            f43377g = new String[]{"V", "O", "0"};
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f43383f = 1;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43378a : (String) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                if (this.f43383f == aVar.f43383f && this.f43378a.equals(aVar.f43378a) && this.f43379b.equals(aVar.f43379b) && this.f43380c.equals(aVar.f43380c)) {
                    String str = this.f43382e;
                    String str2 = aVar.f43382e;
                    if (str == str2) {
                        return true;
                    }
                    if (str != null && str.equals(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43382e : (String) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Arrays.hashCode(new Object[]{this.f43378a, this.f43379b, this.f43380c, this.f43382e, Integer.valueOf(this.f43383f)}) : invokeV.intValue;
        }

        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43379b : (String) invokeV.objValue;
        }

        public j l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                j jVar = new j();
                jVar.f43364a = this.f43378a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f43379b);
                if ("V".equals(this.f43379b)) {
                    sb.append(this.f43380c);
                }
                if (!TextUtils.isEmpty(this.f43382e)) {
                    sb.append(this.f43382e);
                }
                jVar.f43365b = sb.toString().trim();
                return jVar;
            }
            return (j) invokeV.objValue;
        }

        public String m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("dik", this.f43378a);
                    jSONObject.put("v270fk", this.f43379b);
                    jSONObject.put("cck", this.f43380c);
                    jSONObject.put("vsk", this.f43383f);
                    jSONObject.put("ctk", this.f43381d);
                    jSONObject.put("ek", this.f43382e);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    d.a.l.i.c.c(e2);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                String str = this.f43379b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f43378a);
                sb.append("|");
                sb.append(str);
                if ("V".equals(str)) {
                    sb.append(this.f43380c);
                }
                if (!TextUtils.isEmpty(this.f43382e)) {
                    sb.append(this.f43382e);
                }
                return sb.toString().trim();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-153512169, "Ld/a/l/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-153512169, "Ld/a/l/l;");
        }
    }

    public l(Context context, d.a.l.g.a aVar, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f43371a = context.getApplicationContext();
        a.C0625a b2 = aVar.e().b("bohrium");
        this.f43372b = b2;
        b2.d();
        this.f43376f = fVar;
        h(aVar);
    }

    public static a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("dik", "");
                String optString2 = jSONObject.optString("cck", "");
                long optLong = jSONObject.optLong("ctk", 0L);
                int optInt = jSONObject.optInt("vsk", 1);
                String optString3 = jSONObject.optString("ek", "");
                String optString4 = jSONObject.optString("v270fk", "V");
                if (!TextUtils.isEmpty(optString)) {
                    a aVar = new a();
                    aVar.f43378a = optString;
                    aVar.f43380c = optString2;
                    aVar.f43381d = optLong;
                    aVar.f43383f = optInt;
                    aVar.f43382e = optString3;
                    aVar.f43379b = optString4;
                    return aVar;
                }
            } catch (Exception e2) {
                d.a.l.i.c.c(e2);
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static a e(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    String m = m(str);
                    long currentTimeMillis = System.currentTimeMillis();
                    a aVar = new a();
                    aVar.f43378a = str;
                    aVar.f43380c = m;
                    aVar.f43381d = currentTimeMillis;
                    aVar.f43383f = 1;
                    aVar.f43382e = str3;
                    aVar.f43379b = str2;
                    return aVar;
                } catch (Exception e2) {
                    d.a.l.i.c.c(e2);
                }
            }
            return null;
        }
        return (a) invokeLLL.objValue;
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                return new d.a.l.i.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(new d.a.l.a.a().a(str.getBytes("UTF-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (new File(this.f43372b.f(), "libbh.so").exists()) {
                return c(g(true));
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    public a b(j jVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar)) == null) {
            if (jVar != null) {
                a aVar = new a();
                aVar.f43381d = System.currentTimeMillis();
                aVar.f43383f = 1;
                try {
                    boolean z = false;
                    aVar.f43379b = jVar.f43365b.substring(0, 1);
                    aVar.f43378a = jVar.f43364a;
                    aVar.f43380c = m(jVar.f43364a);
                    String[] strArr = a.f43377g;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = true;
                            break;
                        } else if (strArr[i2].equals(aVar.f43379b)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (str = jVar.f43365b) != null && str.length() >= 2) {
                        aVar.f43382e = jVar.f43365b.substring(1);
                    }
                    return aVar;
                } catch (Exception unused) {
                    return null;
                }
            }
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        return (a) invokeL.objValue;
    }

    public a d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            d.a.l.b.a a2 = this.f43375e.a(str2);
            a.g gVar = new a.g();
            gVar.f43251a = true;
            a.h b2 = a2.b(str, gVar);
            if (b2 == null || !b2.c()) {
                return null;
            }
            return b2.f43252a;
        }
        return (a) invokeLL.objValue;
    }

    public final String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
            return TextUtils.isEmpty(string) ? "" : string;
        }
        return (String) invokeL.objValue;
    }

    public final String g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? this.f43372b.c("libbh.so", z) : (String) invokeZ.objValue;
    }

    public final void h(d.a.l.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            b bVar = new b(new c());
            a.b bVar2 = new a.b();
            bVar2.f43246a = this.f43371a;
            bVar2.f43247b = aVar;
            a.d dVar = new a.d();
            for (d.a.l.b.a aVar2 : bVar.b()) {
                aVar2.d(bVar2);
                aVar2.e(dVar);
            }
            this.f43375e = bVar;
        }
    }

    public void i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            a.e eVar = new a.e();
            for (d.a.l.b.a aVar2 : this.f43375e.b()) {
                aVar2.a(eVar, aVar);
            }
        }
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (aVar == null || TextUtils.isEmpty(aVar.f43378a)) {
                throw new NullPointerException("content should not be null");
            }
            if (!z2) {
                try {
                    if (new File(this.f43372b.f(), "libbh.so").exists() && (c2 = c(g(true))) != null) {
                        String n = c2.n();
                        if (!TextUtils.isEmpty(n) && n.equals(aVar.n())) {
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return this.f43372b.e("libbh.so", aVar.m(), z);
        }
        return invokeCommon.booleanValue;
    }

    public a k(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            String f2 = f(this.f43371a);
            if (Build.VERSION.SDK_INT < 23) {
                String uuid = UUID.randomUUID().toString();
                if (f43370g) {
                    Log.d("CuidV270Manager", "uuid: " + uuid);
                }
                str2 = str + f2 + uuid;
            } else {
                str2 = "com.baidu" + f2;
            }
            String b2 = f.c.b(str2.getBytes(), true);
            a aVar = new a();
            aVar.f43381d = System.currentTimeMillis();
            aVar.f43383f = 1;
            aVar.f43378a = b2;
            aVar.f43379b = "V";
            aVar.f43380c = m(b2);
            aVar.f43382e = null;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public synchronized boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                File g2 = this.f43372b.g(".lock");
                if (!g2.exists()) {
                    try {
                        g2.createNewFile();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                RandomAccessFile randomAccessFile = null;
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(g2, "rw");
                    for (int i2 = 0; i2 < 100; i2++) {
                        try {
                            try {
                                this.f43373c = randomAccessFile2.getChannel().lock();
                                this.f43374d = randomAccessFile2;
                                return true;
                            } catch (OverlappingFileLockException unused) {
                                Thread.sleep(100L);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            randomAccessFile = randomAccessFile2;
                            d.a.l.i.c.c(e);
                            if (this.f43373c == null) {
                                d.a.l.i.c.b(randomAccessFile);
                            }
                            return false;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                if (this.f43373c != null) {
                    try {
                        this.f43373c.release();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    this.f43373c = null;
                }
                d.a.l.i.c.b(this.f43374d);
                this.f43374d = null;
            }
        }
    }

    public a o() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            a.g gVar = new a.g();
            gVar.f43251a = true;
            List<d.a.l.b.a> b2 = this.f43375e.b();
            Collections.sort(b2, d.a.l.b.a.f43241e);
            List<e> h2 = this.f43376f.h(this.f43371a);
            if (h2 != null) {
                for (e eVar : h2) {
                    if (!eVar.f43349d && eVar.f43348c) {
                        for (d.a.l.b.a aVar2 : b2) {
                            a.h b3 = aVar2.b(eVar.f43346a.packageName, gVar);
                            if (b3 != null && b3.c() && (aVar = b3.f43252a) != null) {
                                return aVar;
                            }
                        }
                        continue;
                    }
                }
                return null;
            }
            return null;
        }
        return (a) invokeV.objValue;
    }
}
