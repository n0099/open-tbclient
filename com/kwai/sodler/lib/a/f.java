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
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public abstract class f<P extends a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f74684a;

    /* renamed from: b  reason: collision with root package name */
    public int f74685b;

    /* renamed from: c  reason: collision with root package name */
    public int f74686c;

    /* renamed from: d  reason: collision with root package name */
    public StringBuffer f74687d;

    /* renamed from: e  reason: collision with root package name */
    public String f74688e;

    /* renamed from: f  reason: collision with root package name */
    public String f74689f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f74690g;

    /* renamed from: h  reason: collision with root package name */
    public P f74691h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.b f74692i;

    /* renamed from: j  reason: collision with root package name */
    public e f74693j;
    public Throwable k;
    public long l;
    public String m;
    public String n;
    public List<com.kwai.sodler.lib.b.a> o;
    public com.kwai.sodler.lib.b.b p;
    public final byte[] q;
    public String r;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f74686c = -1;
        this.f74685b = -2233;
        this.q = new byte[0];
        this.f74687d = new StringBuffer(String.valueOf(-1));
    }

    public abstract a a(String str);

    public f a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            synchronized (this.q) {
                this.f74686c = i2;
            }
            return c(String.valueOf(i2));
        }
        return (f) invokeI.objValue;
    }

    public f a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            this.f74693j = eVar;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(@NonNull Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, th)) == null) {
            this.k = th;
            return c(th.getLocalizedMessage());
        }
        return (f) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    @Deprecated
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.l = j2;
        }
    }

    public void a(P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, p) == null) {
            this.f74691h = p;
        }
    }

    public void a(com.kwai.sodler.lib.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.p = bVar;
        }
    }

    @Deprecated
    public void a(PluginError.UpdateError updateError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, updateError) == null) {
        }
    }

    public void a(com.kwai.sodler.lib.ext.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.f74692i = bVar;
        }
    }

    public e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f74693j : (e) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f74685b = i2;
    }

    public void b(PluginError.UpdateError updateError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, updateError) == null) {
            a(-3);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.r = str;
        }
    }

    public int c() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this.q) {
                i2 = this.f74686c;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public f c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                StringBuffer stringBuffer = this.f74687d;
                stringBuffer.append(" --> ");
                stringBuffer.append(str);
            }
            return this;
        }
        return (f) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f74687d.toString() : (String) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f74688e = str;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this.q) {
                a(-7);
            }
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f74689f = str;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.m = str;
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f74686c == -7 : invokeV.booleanValue;
    }

    @Nullable
    public Throwable g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.k : (Throwable) invokeV.objValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.n = str;
        }
    }

    public List<com.kwai.sodler.lib.b.a> h(@NonNull String str) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            File file = new File(this.f74693j.e().e(str));
            if (!file.exists()) {
                String str2 = "No local plugin, path = " + file.getAbsolutePath();
                return arrayList;
            }
            for (String str3 : file.list()) {
                if (this.f74693j.e().c(str, str3)) {
                    com.kwai.sodler.lib.b.a aVar = new com.kwai.sodler.lib.b.a();
                    aVar.f74695a = str;
                    aVar.f74696b = str3;
                    aVar.f74697c = true;
                    arrayList.add(aVar);
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            int i2 = this.f74685b - 1;
            this.f74685b = i2;
            if (i2 < 0) {
                throw new PluginError.RetryError();
            }
        }
    }

    @Nullable
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f74684a : (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f74690g : invokeV.booleanValue;
    }

    @Nullable
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? !TextUtils.isEmpty(this.f74688e) ? this.f74688e : this.f74689f : (String) invokeV.objValue;
    }

    @Nullable
    public P l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f74691h : (P) invokeV.objValue;
    }

    @Nullable
    public com.kwai.sodler.lib.ext.b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f74692i : (com.kwai.sodler.lib.ext.b) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    @Nullable
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    @Nullable
    public List<com.kwai.sodler.lib.b.a> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.o : (List) invokeV.objValue;
    }

    @Nullable
    public com.kwai.sodler.lib.b.b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.p : (com.kwai.sodler.lib.b.b) invokeV.objValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            String i2 = i();
            if (TextUtils.isEmpty(i2) || this.o != null) {
                return;
            }
            this.o = h(i2);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return "PluginRequest{mId='" + this.f74684a + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
