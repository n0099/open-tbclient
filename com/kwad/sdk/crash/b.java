package com.kwad.sdk.crash;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.b f72972a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f72973b;

    /* renamed from: c  reason: collision with root package name */
    public final f f72974c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f72975d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f72976e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f72977f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f72978g;

    /* renamed from: h  reason: collision with root package name */
    public final e f72979h;

    /* renamed from: i  reason: collision with root package name */
    public final String f72980i;

    /* renamed from: j  reason: collision with root package name */
    public final String f72981j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* renamed from: com.kwad.sdk.crash.b$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f72982a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f72983b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f72984c;

        /* renamed from: d  reason: collision with root package name */
        public Context f72985d;

        /* renamed from: e  reason: collision with root package name */
        public e f72986e;

        /* renamed from: f  reason: collision with root package name */
        public String f72987f;

        /* renamed from: g  reason: collision with root package name */
        public String f72988g;

        /* renamed from: h  reason: collision with root package name */
        public String f72989h;

        /* renamed from: i  reason: collision with root package name */
        public String f72990i;

        /* renamed from: j  reason: collision with root package name */
        public String f72991j;
        public String k;
        public String l;
        public String m;
        public int n;
        public String o;
        public int p;
        public String q;
        public String r;
        public String s;
        public String t;
        public f u;
        public String[] v;

        public a() {
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
            this.f72984c = false;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.n = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                this.f72985d = context;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
                this.f72986e = eVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
                this.u = fVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f72987f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, strArr)) == null) {
                this.v = strArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new b(this, null) : (b) invokeV.objValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.p = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f72989h = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, strArr)) == null) {
                this.f72983b = strArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.f72982a = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.f72990i = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.k = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.l = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.m = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
                this.o = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
                this.q = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.r = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                this.s = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
                this.t = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72972a = new com.kwad.sdk.crash.model.b();
        this.f72973b = new com.kwad.sdk.crash.model.a();
        this.f72977f = aVar.f72984c;
        this.f72978g = aVar.f72985d;
        this.f72979h = aVar.f72986e;
        this.f72980i = aVar.f72987f;
        this.f72981j = aVar.f72988g;
        this.k = aVar.f72989h;
        this.l = aVar.f72990i;
        this.m = aVar.f72991j;
        this.n = aVar.k;
        this.f72973b.f73020a = aVar.q;
        this.f72973b.f73021b = aVar.r;
        this.f72973b.f73023d = aVar.t;
        this.f72973b.f73022c = aVar.s;
        this.f72972a.f73027d = aVar.o;
        this.f72972a.f73028e = aVar.p;
        this.f72972a.f73025b = aVar.m;
        this.f72972a.f73026c = aVar.n;
        this.f72972a.f73024a = aVar.l;
        this.f72972a.f73029f = aVar.f72982a;
        this.f72974c = aVar.u;
        this.f72975d = aVar.v;
        this.f72976e = aVar.f72983b;
    }

    public /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f72979h : (e) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f72977f : invokeV.booleanValue;
    }
}
