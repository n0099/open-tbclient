package com.repackage;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dz;
import com.repackage.e00;
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
public class uy {
    public static /* synthetic */ Interceptable $ic;
    public static boolean g;
    public static String h;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public e00.a b;
    public volatile FileLock c;
    public volatile RandomAccessFile d;
    public ez e;
    public qy f;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] k;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public long d;
        public String e;
        public boolean f;
        public String g;
        public boolean h;
        public String i;
        public int j;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1937761468, "Lcom/repackage/uy$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1937761468, "Lcom/repackage/uy$a;");
                    return;
                }
            }
            k = new String[]{"V", "O", "0"};
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.h = true;
            this.j = 1;
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = uy.n();
                if (TextUtils.isEmpty(n)) {
                    return;
                }
                this.f = true;
                this.g = n;
            }
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
                if (this.j == aVar.j && this.a.equals(aVar.a) && this.b.equals(aVar.b) && this.c.equals(aVar.c) && this.f == aVar.f && this.g.equals(aVar.g)) {
                    String str = this.e;
                    String str2 = aVar.e;
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

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.i = str;
            }
        }

        public synchronized void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                synchronized (this) {
                    this.h = z;
                }
            }
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Arrays.hashCode(new Object[]{this.a, this.b, this.c, Boolean.valueOf(this.f), this.g, this.e, Integer.valueOf(this.j)}) : invokeV.intValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : invokeV.booleanValue;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public String p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e : (String) invokeV.objValue;
        }

        public String r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                String str = this.b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append("|");
                sb.append(str);
                if ("V".equals(str)) {
                    sb.append(this.c);
                }
                if (!TextUtils.isEmpty(this.e)) {
                    sb.append(this.e);
                }
                return sb.toString().trim();
            }
            return (String) invokeV.objValue;
        }

        public String t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.i : (String) invokeV.objValue;
        }

        public String u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.g : (String) invokeV.objValue;
        }

        public String v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        public synchronized boolean w() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                synchronized (this) {
                    z = this.h;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public String x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("dik", this.a);
                    jSONObject.put("v270fk", this.b);
                    jSONObject.put("cck", this.c);
                    jSONObject.put("vsk", this.j);
                    jSONObject.put("ctk", this.d);
                    jSONObject.put("csk", this.f);
                    if (!TextUtils.isEmpty(this.g)) {
                        jSONObject.put("pmk", this.g);
                    }
                    if (!TextUtils.isEmpty(this.i)) {
                        jSONObject.put("ock", this.i);
                    }
                    jSONObject.put("hrk", this.h);
                    jSONObject.put("ek", this.e);
                    return jSONObject.toString();
                } catch (JSONException e) {
                    h00.c(e);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        public sy y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                sy syVar = new sy();
                syVar.a = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.b);
                if ("V".equals(this.b)) {
                    sb.append(this.c);
                }
                if (!TextUtils.isEmpty(this.e)) {
                    sb.append(this.e);
                }
                syVar.b = sb.toString().trim();
                return syVar;
            }
            return (sy) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964025375, "Lcom/repackage/uy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964025375, "Lcom/repackage/uy;");
        }
    }

    public uy(Context context, e00 e00Var, qy qyVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, e00Var, qyVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.a = context.getApplicationContext();
        e00.a f = e00Var.f().f("bohrium");
        this.b = f;
        f.d();
        this.f = qyVar;
        h(e00Var);
    }

    public static a c(String str, String str2, String str3, boolean z, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, str2, str3, Boolean.valueOf(z), str4})) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    String e = e(str);
                    long currentTimeMillis = System.currentTimeMillis();
                    a aVar = new a();
                    aVar.a = str;
                    aVar.c = e;
                    aVar.d = currentTimeMillis;
                    aVar.j = 1;
                    aVar.e = str3;
                    aVar.b = str2;
                    aVar.f = z;
                    aVar.g = str4;
                    return aVar;
                } catch (Exception e2) {
                    h00.c(e2);
                }
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return new f00("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(new vy().a(str.getBytes("UTF-8")));
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static a l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("dik", "");
                String optString2 = jSONObject.optString("cck", "");
                long optLong = jSONObject.optLong("ctk", 0L);
                int optInt = jSONObject.optInt("vsk", 1);
                boolean optBoolean = jSONObject.optBoolean("csk", false);
                String optString3 = jSONObject.optString("pmk", "");
                boolean optBoolean2 = jSONObject.optBoolean("hrk", true);
                String optString4 = jSONObject.optString("ock", null);
                String optString5 = jSONObject.optString("ek", "");
                String optString6 = jSONObject.optString("v270fk", "V");
                if (!TextUtils.isEmpty(optString)) {
                    a aVar = new a();
                    aVar.a = optString;
                    aVar.c = optString2;
                    aVar.d = optLong;
                    aVar.j = optInt;
                    aVar.e = optString5;
                    aVar.b = optString6;
                    aVar.f = optBoolean;
                    aVar.g = optString3;
                    aVar.h = optBoolean2;
                    aVar.i = optString4;
                    return aVar;
                }
            } catch (Exception e) {
                h00.c(e);
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = h;
            if (str != null) {
                return str;
            }
            if (TextUtils.isEmpty(Build.MODEL)) {
                return "";
            }
            String substring = c00.b(Build.MODEL.getBytes(), false).substring(3, 15);
            h = substring;
            return substring;
        }
        return (String) invokeV.objValue;
    }

    public a a(sy syVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, syVar)) == null) {
            if (syVar != null) {
                a aVar = new a();
                aVar.d = System.currentTimeMillis();
                aVar.j = 1;
                try {
                    boolean z = false;
                    aVar.b = syVar.b.substring(0, 1);
                    aVar.a = syVar.a;
                    aVar.c = e(syVar.a);
                    String[] strArr = a.k;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z = true;
                            break;
                        } else if (strArr[i].equals(aVar.b)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z && (str = syVar.b) != null && str.length() >= 2) {
                        aVar.e = syVar.b.substring(1);
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

    public a b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            dz a2 = this.e.a(str2);
            dz.g gVar = new dz.g();
            gVar.a = true;
            dz.h b = a2.b(str, gVar);
            if (b == null || !b.d()) {
                return null;
            }
            return b.a;
        }
        return (a) invokeLL.objValue;
    }

    public final String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            String string = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            return TextUtils.isEmpty(string) ? "" : string;
        }
        return (String) invokeL.objValue;
    }

    public final String f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) ? this.b.c("libbh.so", z) : (String) invokeZ.objValue;
    }

    public void g(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            dz.e eVar = new dz.e();
            for (dz dzVar : this.e.b()) {
                dzVar.a(eVar, aVar);
            }
        }
    }

    public final void h(e00 e00Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, e00Var) == null) {
            ez ezVar = new ez(new oy());
            dz.b bVar = new dz.b();
            bVar.a = this.a;
            bVar.b = e00Var;
            dz.d dVar = new dz.d();
            for (dz dzVar : ezVar.b()) {
                dzVar.d(bVar);
                dzVar.e(dVar);
            }
            this.e = ezVar;
        }
    }

    public synchronized boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                File b = this.b.b(".lock");
                if (!b.exists()) {
                    try {
                        b.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                RandomAccessFile randomAccessFile = null;
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(b, "rw");
                    for (int i = 0; i < 100; i++) {
                        try {
                            try {
                                this.c = randomAccessFile2.getChannel().lock();
                                this.d = randomAccessFile2;
                                return true;
                            } catch (OverlappingFileLockException unused) {
                                Thread.sleep(100L);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            randomAccessFile = randomAccessFile2;
                            h00.c(e);
                            if (this.c == null) {
                                h00.b(randomAccessFile);
                            }
                            return false;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        a l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (aVar == null || TextUtils.isEmpty(aVar.a)) {
                throw new NullPointerException("content should not be null");
            }
            if (!z2) {
                try {
                    if (new File(this.b.g(), "libbh.so").exists() && (l = l(f(true))) != null) {
                        String r = l.r();
                        boolean z3 = !TextUtils.isEmpty(r) && r.equals(aVar.r());
                        boolean z4 = l.m() && !TextUtils.isEmpty(l.u()) && TextUtils.equals(l.u(), n());
                        if (z3 && z4) {
                            return true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return this.b.e("libbh.so", aVar.x(), z);
        }
        return invokeCommon.booleanValue;
    }

    public a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (new File(this.b.g(), "libbh.so").exists()) {
                return l(f(true));
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    public a m(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            String d = d(this.a);
            if (Build.VERSION.SDK_INT < 23) {
                String uuid = UUID.randomUUID().toString();
                if (g) {
                    Log.d("CuidV270Manager", "uuid: " + uuid);
                }
                str2 = str + d + uuid;
            } else {
                str2 = "com.baidu" + d;
            }
            String b = c00.b(str2.getBytes(), true);
            String n = n();
            a aVar = new a();
            aVar.d = System.currentTimeMillis();
            aVar.j = 1;
            aVar.a = b;
            aVar.b = "V";
            aVar.c = e(b);
            aVar.f = true;
            aVar.g = n;
            aVar.e = null;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public a o(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            dz.g gVar = new dz.g();
            gVar.a = true;
            List<dz> b = this.e.b();
            Collections.sort(b, dz.e);
            List<py> h2 = this.f.h(this.a);
            if (h2 != null) {
                for (py pyVar : h2) {
                    if (!pyVar.d && pyVar.c) {
                        for (dz dzVar : b) {
                            dz.h b2 = dzVar.b(pyVar.a.packageName, gVar);
                            if (b2 != null && b2.d() && (aVar = b2.a) != null && !TextUtils.equals(aVar.n(), str)) {
                                if (!(aVar.m() && !TextUtils.equals(n(), aVar.u()))) {
                                    return b2.a;
                                }
                            }
                        }
                        continue;
                    }
                }
                return null;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                if (this.c != null) {
                    try {
                        this.c.release();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    this.c = null;
                }
                h00.b(this.d);
                this.d = null;
            }
        }
    }
}
