package d.a.k;

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
import d.a.k.b.a;
import d.a.k.b.b;
import d.a.k.f;
import d.a.k.g.a;
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
/* loaded from: classes8.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f45983g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f45984a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0649a f45985b;

    /* renamed from: c  reason: collision with root package name */
    public volatile FileLock f45986c;

    /* renamed from: d  reason: collision with root package name */
    public volatile RandomAccessFile f45987d;

    /* renamed from: e  reason: collision with root package name */
    public b f45988e;

    /* renamed from: f  reason: collision with root package name */
    public f f45989f;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: g  reason: collision with root package name */
        public static final String[] f45990g;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f45991a;

        /* renamed from: b  reason: collision with root package name */
        public String f45992b;

        /* renamed from: c  reason: collision with root package name */
        public String f45993c;

        /* renamed from: d  reason: collision with root package name */
        public long f45994d;

        /* renamed from: e  reason: collision with root package name */
        public String f45995e;

        /* renamed from: f  reason: collision with root package name */
        public int f45996f;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1524954533, "Ld/a/k/l$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1524954533, "Ld/a/k/l$a;");
                    return;
                }
            }
            f45990g = new String[]{"V", "O", "0"};
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
            this.f45996f = 1;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45991a : (String) invokeV.objValue;
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
                if (this.f45996f == aVar.f45996f && this.f45991a.equals(aVar.f45991a) && this.f45992b.equals(aVar.f45992b) && this.f45993c.equals(aVar.f45993c)) {
                    String str = this.f45995e;
                    String str2 = aVar.f45995e;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f45995e : (String) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Arrays.hashCode(new Object[]{this.f45991a, this.f45992b, this.f45993c, this.f45995e, Integer.valueOf(this.f45996f)}) : invokeV.intValue;
        }

        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45992b : (String) invokeV.objValue;
        }

        public j l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                j jVar = new j();
                jVar.f45977a = this.f45991a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f45992b);
                if ("V".equals(this.f45992b)) {
                    sb.append(this.f45993c);
                }
                if (!TextUtils.isEmpty(this.f45995e)) {
                    sb.append(this.f45995e);
                }
                jVar.f45978b = sb.toString().trim();
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
                    jSONObject.put("dik", this.f45991a);
                    jSONObject.put("v270fk", this.f45992b);
                    jSONObject.put("cck", this.f45993c);
                    jSONObject.put("vsk", this.f45996f);
                    jSONObject.put("ctk", this.f45994d);
                    jSONObject.put("ek", this.f45995e);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    d.a.k.i.c.c(e2);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                String str = this.f45992b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f45991a);
                sb.append("|");
                sb.append(str);
                if ("V".equals(str)) {
                    sb.append(this.f45993c);
                }
                if (!TextUtils.isEmpty(this.f45995e)) {
                    sb.append(this.f45995e);
                }
                return sb.toString().trim();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-153541960, "Ld/a/k/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-153541960, "Ld/a/k/l;");
        }
    }

    public l(Context context, d.a.k.g.a aVar, f fVar) {
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
        this.f45984a = context.getApplicationContext();
        a.C0649a b2 = aVar.e().b("bohrium");
        this.f45985b = b2;
        b2.d();
        this.f45989f = fVar;
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
                    aVar.f45991a = optString;
                    aVar.f45993c = optString2;
                    aVar.f45994d = optLong;
                    aVar.f45996f = optInt;
                    aVar.f45995e = optString3;
                    aVar.f45992b = optString4;
                    return aVar;
                }
            } catch (Exception e2) {
                d.a.k.i.c.c(e2);
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
                    aVar.f45991a = str;
                    aVar.f45993c = m;
                    aVar.f45994d = currentTimeMillis;
                    aVar.f45996f = 1;
                    aVar.f45995e = str3;
                    aVar.f45992b = str2;
                    return aVar;
                } catch (Exception e2) {
                    d.a.k.i.c.c(e2);
                }
            }
            return null;
        }
        return (a) invokeLLL.objValue;
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            try {
                return new d.a.k.i.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(new d.a.k.a.a().a(str.getBytes("UTF-8")));
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
            if (new File(this.f45985b.f(), "libbh.so").exists()) {
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
                aVar.f45994d = System.currentTimeMillis();
                aVar.f45996f = 1;
                try {
                    boolean z = false;
                    aVar.f45992b = jVar.f45978b.substring(0, 1);
                    aVar.f45991a = jVar.f45977a;
                    aVar.f45993c = m(jVar.f45977a);
                    String[] strArr = a.f45990g;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = true;
                            break;
                        } else if (strArr[i2].equals(aVar.f45992b)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (str = jVar.f45978b) != null && str.length() >= 2) {
                        aVar.f45995e = jVar.f45978b.substring(1);
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
            d.a.k.b.a a2 = this.f45988e.a(str2);
            a.g gVar = new a.g();
            gVar.f45864a = true;
            a.h b2 = a2.b(str, gVar);
            if (b2 == null || !b2.c()) {
                return null;
            }
            return b2.f45865a;
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
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? this.f45985b.c("libbh.so", z) : (String) invokeZ.objValue;
    }

    public final void h(d.a.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            b bVar = new b(new c());
            a.b bVar2 = new a.b();
            bVar2.f45859a = this.f45984a;
            bVar2.f45860b = aVar;
            a.d dVar = new a.d();
            for (d.a.k.b.a aVar2 : bVar.b()) {
                aVar2.d(bVar2);
                aVar2.e(dVar);
            }
            this.f45988e = bVar;
        }
    }

    public void i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            a.e eVar = new a.e();
            for (d.a.k.b.a aVar2 : this.f45988e.b()) {
                aVar2.a(eVar, aVar);
            }
        }
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (aVar == null || TextUtils.isEmpty(aVar.f45991a)) {
                throw new NullPointerException("content should not be null");
            }
            if (!z2) {
                try {
                    if (new File(this.f45985b.f(), "libbh.so").exists() && (c2 = c(g(true))) != null) {
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
            return this.f45985b.e("libbh.so", aVar.m(), z);
        }
        return invokeCommon.booleanValue;
    }

    public a k(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            String f2 = f(this.f45984a);
            if (Build.VERSION.SDK_INT < 23) {
                String uuid = UUID.randomUUID().toString();
                if (f45983g) {
                    Log.d("CuidV270Manager", "uuid: " + uuid);
                }
                str2 = str + f2 + uuid;
            } else {
                str2 = "com.baidu" + f2;
            }
            String b2 = f.c.b(str2.getBytes(), true);
            a aVar = new a();
            aVar.f45994d = System.currentTimeMillis();
            aVar.f45996f = 1;
            aVar.f45991a = b2;
            aVar.f45992b = "V";
            aVar.f45993c = m(b2);
            aVar.f45995e = null;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public synchronized boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                File g2 = this.f45985b.g(".lock");
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
                                this.f45986c = randomAccessFile2.getChannel().lock();
                                this.f45987d = randomAccessFile2;
                                return true;
                            } catch (OverlappingFileLockException unused) {
                                Thread.sleep(100L);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            randomAccessFile = randomAccessFile2;
                            d.a.k.i.c.c(e);
                            if (this.f45986c == null) {
                                d.a.k.i.c.b(randomAccessFile);
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
                if (this.f45986c != null) {
                    try {
                        this.f45986c.release();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    this.f45986c = null;
                }
                d.a.k.i.c.b(this.f45987d);
                this.f45987d = null;
            }
        }
    }

    public a o() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            a.g gVar = new a.g();
            gVar.f45864a = true;
            List<d.a.k.b.a> b2 = this.f45988e.b();
            Collections.sort(b2, d.a.k.b.a.f45854e);
            List<e> h2 = this.f45989f.h(this.f45984a);
            if (h2 != null) {
                for (e eVar : h2) {
                    if (!eVar.f45962d && eVar.f45961c) {
                        for (d.a.k.b.a aVar2 : b2) {
                            a.h b3 = aVar2.b(eVar.f45959a.packageName, gVar);
                            if (b3 != null && b3.c() && (aVar = b3.f45865a) != null) {
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
