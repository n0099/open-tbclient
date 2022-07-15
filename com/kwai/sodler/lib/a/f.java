package com.kwai.sodler.lib.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class f<P extends a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public int d;
    public int e;
    public StringBuffer f;
    public String g;
    public String h;
    public boolean i;
    public P j;
    public com.kwai.sodler.lib.ext.b k;
    public e l;
    public Throwable m;
    public long n;
    public String o;
    public String p;
    public List<com.kwai.sodler.lib.c.a> q;
    public com.kwai.sodler.lib.c.b r;
    public final byte[] s;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = -1;
        this.c = 0;
        this.s = new byte[0];
        this.f = new StringBuffer(String.valueOf(-1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(com.kwai.sodler.lib.c.b bVar) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = bVar;
        this.a = bVar.a;
        this.b = bVar.b;
    }

    private List<com.kwai.sodler.lib.c.a> a(String str, String str2) {
        InterceptResult invokeLL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(this.l.f().b(str));
                if (file.exists() && (list = file.list()) != null && list.length != 0) {
                    for (String str3 : list) {
                        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || !str2.equals(str3) || !this.l.f().c(str, str3)) {
                            this.l.f().a(str, str3);
                        } else {
                            com.kwai.sodler.lib.c.a aVar = new com.kwai.sodler.lib.c.a();
                            aVar.a = str;
                            aVar.b = str3;
                            aVar.c = true;
                            arrayList.add(aVar);
                        }
                    }
                    Collections.sort(arrayList);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public final f a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            synchronized (this.s) {
                this.e = i;
            }
            return b(String.valueOf(i));
        }
        return (f) invokeI.objValue;
    }

    public final f a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
            this.l = eVar;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public final f a(@NonNull Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th)) == null) {
            this.m = th;
            return b(th.getLocalizedMessage());
        }
        return (f) invokeL.objValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    @Deprecated
    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.n = j;
        }
    }

    public final void a(P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, p) == null) {
            this.j = p;
        }
    }

    public final void a(com.kwai.sodler.lib.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public final void a(com.kwai.sodler.lib.ext.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.b = str;
        }
    }

    public final e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l : (e) invokeV.objValue;
    }

    public final f b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                StringBuffer stringBuffer = this.f;
                stringBuffer.append(" --> ");
                stringBuffer.append(str);
            }
            return this;
        }
        return (f) invokeL.objValue;
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || i <= 0) {
            return;
        }
        this.d = i;
    }

    public final int c() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this.s) {
                i = this.e;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.g = str;
        }
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f.toString() : (String) invokeV.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.h = str;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this.s) {
                a(-7);
            }
        }
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.o = str;
        }
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.p = str;
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.e == -7 : invokeV.booleanValue;
    }

    public abstract P g(String str);

    @Nullable
    public final Throwable g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.m : (Throwable) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            a(-1);
            this.q = null;
            int i = this.c + 1;
            this.c = i;
            return i <= this.d;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.c : invokeV.intValue;
    }

    @Nullable
    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? !TextUtils.isEmpty(this.g) ? this.g : this.h : (String) invokeV.objValue;
    }

    @Nullable
    public final P m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.j : (P) invokeV.objValue;
    }

    @Nullable
    public final com.kwai.sodler.lib.ext.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.k : (com.kwai.sodler.lib.ext.b) invokeV.objValue;
    }

    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    @Nullable
    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    @Nullable
    public final List<com.kwai.sodler.lib.c.a> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.q : (List) invokeV.objValue;
    }

    @Nullable
    public final com.kwai.sodler.lib.c.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.r : (com.kwai.sodler.lib.c.b) invokeV.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            String i = i();
            if (TextUtils.isEmpty(i) || this.q != null) {
                return;
            }
            this.q = a(i, a());
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            a(-3);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return "PluginRequest{mId='" + this.a + "'}";
        }
        return (String) invokeV.objValue;
    }
}
