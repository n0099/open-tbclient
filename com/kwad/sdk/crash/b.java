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
    public final com.kwad.sdk.crash.model.b a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f58134b;

    /* renamed from: c  reason: collision with root package name */
    public final f f58135c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f58136d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f58137e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f58138f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f58139g;

    /* renamed from: h  reason: collision with root package name */
    public final e f58140h;

    /* renamed from: i  reason: collision with root package name */
    public final String f58141i;

    /* renamed from: j  reason: collision with root package name */
    public final String f58142j;

    /* renamed from: k  reason: collision with root package name */
    public final String f58143k;
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
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f58144b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f58145c;

        /* renamed from: d  reason: collision with root package name */
        public Context f58146d;

        /* renamed from: e  reason: collision with root package name */
        public e f58147e;

        /* renamed from: f  reason: collision with root package name */
        public String f58148f;

        /* renamed from: g  reason: collision with root package name */
        public String f58149g;

        /* renamed from: h  reason: collision with root package name */
        public String f58150h;

        /* renamed from: i  reason: collision with root package name */
        public String f58151i;

        /* renamed from: j  reason: collision with root package name */
        public String f58152j;

        /* renamed from: k  reason: collision with root package name */
        public String f58153k;
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
            this.f58145c = false;
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
                this.f58146d = context;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
                this.f58147e = eVar;
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
                this.f58148f = str;
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
                this.f58150h = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, strArr)) == null) {
                this.f58144b = strArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.a = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.f58151i = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f58153k = str;
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
        this.a = new com.kwad.sdk.crash.model.b();
        this.f58134b = new com.kwad.sdk.crash.model.a();
        this.f58138f = aVar.f58145c;
        this.f58139g = aVar.f58146d;
        this.f58140h = aVar.f58147e;
        this.f58141i = aVar.f58148f;
        this.f58142j = aVar.f58149g;
        this.f58143k = aVar.f58150h;
        this.l = aVar.f58151i;
        this.m = aVar.f58152j;
        this.n = aVar.f58153k;
        this.f58134b.a = aVar.q;
        this.f58134b.f58174b = aVar.r;
        this.f58134b.f58176d = aVar.t;
        this.f58134b.f58175c = aVar.s;
        this.a.f58179d = aVar.o;
        this.a.f58180e = aVar.p;
        this.a.f58177b = aVar.m;
        this.a.f58178c = aVar.n;
        this.a.a = aVar.l;
        this.a.f58181f = aVar.a;
        this.f58135c = aVar.u;
        this.f58136d = aVar.v;
        this.f58137e = aVar.f58144b;
    }

    public /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58140h : (e) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58138f : invokeV.booleanValue;
    }
}
