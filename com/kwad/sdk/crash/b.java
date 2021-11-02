package com.kwad.sdk.crash;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.b f65420a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f65421b;

    /* renamed from: c  reason: collision with root package name */
    public final f f65422c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f65423d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f65424e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f65425f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f65426g;

    /* renamed from: h  reason: collision with root package name */
    public final e f65427h;

    /* renamed from: i  reason: collision with root package name */
    public final String f65428i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* renamed from: com.kwad.sdk.crash.b$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f65429a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f65430b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f65431c;

        /* renamed from: d  reason: collision with root package name */
        public Context f65432d;

        /* renamed from: e  reason: collision with root package name */
        public e f65433e;

        /* renamed from: f  reason: collision with root package name */
        public String f65434f;

        /* renamed from: g  reason: collision with root package name */
        public String f65435g;

        /* renamed from: h  reason: collision with root package name */
        public String f65436h;

        /* renamed from: i  reason: collision with root package name */
        public String f65437i;
        public String j;
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
            this.f65431c = false;
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
                this.f65432d = context;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
                this.f65433e = eVar;
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
                this.f65434f = str;
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
                this.f65436h = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, strArr)) == null) {
                this.f65430b = strArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.f65429a = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.f65437i = str;
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
        this.f65420a = new com.kwad.sdk.crash.model.b();
        this.f65421b = new com.kwad.sdk.crash.model.a();
        this.f65425f = aVar.f65431c;
        this.f65426g = aVar.f65432d;
        this.f65427h = aVar.f65433e;
        this.f65428i = aVar.f65434f;
        this.j = aVar.f65435g;
        this.k = aVar.f65436h;
        this.l = aVar.f65437i;
        this.m = aVar.j;
        this.n = aVar.k;
        this.f65421b.f65465a = aVar.q;
        this.f65421b.f65466b = aVar.r;
        this.f65421b.f65468d = aVar.t;
        this.f65421b.f65467c = aVar.s;
        this.f65420a.f65472d = aVar.o;
        this.f65420a.f65473e = aVar.p;
        this.f65420a.f65470b = aVar.m;
        this.f65420a.f65471c = aVar.n;
        this.f65420a.f65469a = aVar.l;
        this.f65420a.f65474f = aVar.f65429a;
        this.f65422c = aVar.u;
        this.f65423d = aVar.v;
        this.f65424e = aVar.f65430b;
    }

    public /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65427h : (e) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65425f : invokeV.booleanValue;
    }
}
