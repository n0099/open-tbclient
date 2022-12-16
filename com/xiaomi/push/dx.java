package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class dx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f263a;

        /* renamed from: a  reason: collision with other field name */
        public String f264a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f265a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public String f266b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f267b;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public String f268c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f269c;
        public int d;

        /* renamed from: d  reason: collision with other field name */
        public String f270d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f271d;
        public int e;

        /* renamed from: e  reason: collision with other field name */
        public String f272e;

        /* renamed from: e  reason: collision with other field name */
        public boolean f273e;
        public String f;

        /* renamed from: f  reason: collision with other field name */
        public boolean f274f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;

        public a() {
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
            this.a = 0;
            this.f263a = 0L;
            this.f264a = "";
            this.f266b = "";
            this.f268c = "";
            this.f270d = "";
            this.f272e = "";
            this.b = 1;
            this.c = 0;
            this.d = 0;
            this.f = "";
            this.e = -1;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.e < 0) {
                    b();
                }
                return this.e;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f263a : invokeV.longValue;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.f274f = false;
                this.f270d = "";
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.f265a = true;
                this.a = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                this.f267b = true;
                this.f263a = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
                while (true) {
                    int m184a = bVar.m184a();
                    switch (m184a) {
                        case 0:
                            return this;
                        case 8:
                            a(bVar.m193b());
                            break;
                        case 16:
                            a(bVar.m194b());
                            break;
                        case 26:
                            a(bVar.m187a());
                            break;
                        case 34:
                            b(bVar.m187a());
                            break;
                        case 42:
                            c(bVar.m187a());
                            break;
                        case 50:
                            d(bVar.m187a());
                            break;
                        case 58:
                            e(bVar.m187a());
                            break;
                        case 64:
                            b(bVar.m193b());
                            break;
                        case 72:
                            c(bVar.m193b());
                            break;
                        case 80:
                            d(bVar.m193b());
                            break;
                        case 90:
                            f(bVar.m187a());
                            break;
                        default:
                            if (a(bVar, m184a)) {
                                break;
                            } else {
                                return this;
                            }
                    }
                }
            } else {
                return (a) invokeL.objValue;
            }
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f269c = true;
                this.f264a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f264a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
                if (a()) {
                    cVar.m228a(1, c());
                }
                if (b()) {
                    cVar.m242b(2, a());
                }
                if (m288c()) {
                    cVar.m232a(3, a());
                }
                if (m290d()) {
                    cVar.m232a(4, b());
                }
                if (m292e()) {
                    cVar.m232a(5, m287c());
                }
                if (m294f()) {
                    cVar.m232a(6, m289d());
                }
                if (g()) {
                    cVar.m232a(7, m291e());
                }
                if (h()) {
                    cVar.m228a(8, d());
                }
                if (i()) {
                    cVar.m228a(9, e());
                }
                if (j()) {
                    cVar.m228a(10, f());
                }
                if (k()) {
                    cVar.m232a(11, m293f());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f265a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                int a = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
                if (b()) {
                    a += com.xiaomi.push.c.b(2, a());
                }
                if (m288c()) {
                    a += com.xiaomi.push.c.a(3, a());
                }
                if (m290d()) {
                    a += com.xiaomi.push.c.a(4, b());
                }
                if (m292e()) {
                    a += com.xiaomi.push.c.a(5, m287c());
                }
                if (m294f()) {
                    a += com.xiaomi.push.c.a(6, m289d());
                }
                if (g()) {
                    a += com.xiaomi.push.c.a(7, m291e());
                }
                if (h()) {
                    a += com.xiaomi.push.c.a(8, d());
                }
                if (i()) {
                    a += com.xiaomi.push.c.a(9, e());
                }
                if (j()) {
                    a += com.xiaomi.push.c.a(10, f());
                }
                if (k()) {
                    a += com.xiaomi.push.c.a(11, m293f());
                }
                this.e = a;
                return a;
            }
            return invokeV.intValue;
        }

        public a b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                this.h = true;
                this.b = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.f271d = true;
                this.f266b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f266b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f267b : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.a : invokeV.intValue;
        }

        public a c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
                this.i = true;
                this.c = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                this.f273e = true;
                this.f268c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m287c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f268c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m288c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f269c : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.b : invokeV.intValue;
        }

        public a d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
                this.j = true;
                this.d = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
                this.f274f = true;
                this.f270d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m289d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f270d : (String) invokeV.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m290d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f271d : invokeV.booleanValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.c : invokeV.intValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
                this.g = true;
                this.f272e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m291e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f272e : (String) invokeV.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m292e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f273e : invokeV.booleanValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.d : invokeV.intValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
                this.k = true;
                this.f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m293f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f : (String) invokeV.objValue;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m294f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f274f : invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.g : invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.h : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.i : invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.j : invokeV.booleanValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.k : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f275a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f276b;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f277c;
        public int d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f278d;
        public boolean e;

        public b() {
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
            this.f276b = false;
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = -1;
        }

        public static b a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? (b) new b().a(bArr) : (b) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.d < 0) {
                    b();
                }
                return this.d;
            }
            return invokeV.intValue;
        }

        public b a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.f277c = true;
                this.a = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) != null) {
                return (b) invokeL.objValue;
            }
            while (true) {
                int m184a = bVar.m184a();
                if (m184a == 0) {
                    return this;
                }
                if (m184a == 8) {
                    a(bVar.m190a());
                } else if (m184a == 24) {
                    a(bVar.m193b());
                } else if (m184a == 32) {
                    b(bVar.m193b());
                } else if (m184a == 40) {
                    c(bVar.m193b());
                } else if (!a(bVar, m184a)) {
                    return this;
                }
            }
        }

        public b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f275a = true;
                this.f276b = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                if (b()) {
                    cVar.m233a(1, a());
                }
                if (m295c()) {
                    cVar.m228a(3, c());
                }
                if (m296d()) {
                    cVar.m228a(4, d());
                }
                if (m297e()) {
                    cVar.m228a(5, e());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f276b : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (m295c()) {
                    a += com.xiaomi.push.c.a(3, c());
                }
                if (m296d()) {
                    a += com.xiaomi.push.c.a(4, d());
                }
                if (m297e()) {
                    a += com.xiaomi.push.c.a(5, e());
                }
                this.d = a;
                return a;
            }
            return invokeV.intValue;
        }

        public b b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.f278d = true;
                this.b = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f275a : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a : invokeV.intValue;
        }

        public b c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                this.e = true;
                this.c = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m295c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f277c : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.b : invokeV.intValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m296d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f278d : invokeV.booleanValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.c : invokeV.intValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m297e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.e : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public String f279a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f280a;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f281b;
        public String c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f282c;
        public String d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f283d;
        public String e;

        /* renamed from: e  reason: collision with other field name */
        public boolean f284e;
        public String f;

        /* renamed from: f  reason: collision with other field name */
        public boolean f285f;

        public c() {
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
            this.f279a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.a = -1;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a < 0) {
                    b();
                }
                return this.a;
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) != null) {
                return (c) invokeL.objValue;
            }
            while (true) {
                int m184a = bVar.m184a();
                if (m184a == 0) {
                    return this;
                }
                if (m184a == 10) {
                    a(bVar.m187a());
                } else if (m184a == 18) {
                    b(bVar.m187a());
                } else if (m184a == 26) {
                    c(bVar.m187a());
                } else if (m184a == 34) {
                    d(bVar.m187a());
                } else if (m184a == 42) {
                    e(bVar.m187a());
                } else if (m184a == 50) {
                    f(bVar.m187a());
                } else if (!a(bVar, m184a)) {
                    return this;
                }
            }
        }

        public c a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f280a = true;
                this.f279a = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f279a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                if (a()) {
                    cVar.m232a(1, a());
                }
                if (b()) {
                    cVar.m232a(2, b());
                }
                if (m298c()) {
                    cVar.m232a(3, c());
                }
                if (m299d()) {
                    cVar.m232a(4, d());
                }
                if (m300e()) {
                    cVar.m232a(5, e());
                }
                if (m301f()) {
                    cVar.m232a(6, f());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f280a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (b()) {
                    a += com.xiaomi.push.c.a(2, b());
                }
                if (m298c()) {
                    a += com.xiaomi.push.c.a(3, c());
                }
                if (m299d()) {
                    a += com.xiaomi.push.c.a(4, d());
                }
                if (m300e()) {
                    a += com.xiaomi.push.c.a(5, e());
                }
                if (m301f()) {
                    a += com.xiaomi.push.c.a(6, f());
                }
                this.a = a;
                return a;
            }
            return invokeV.intValue;
        }

        public c b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f281b = true;
                this.b = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f281b : invokeV.booleanValue;
        }

        public c c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.f282c = true;
                this.c = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m298c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f282c : invokeV.booleanValue;
        }

        public c d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.f283d = true;
                this.d = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.d : (String) invokeV.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m299d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f283d : invokeV.booleanValue;
        }

        public c e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.f284e = true;
                this.e = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.e : (String) invokeV.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m300e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f284e : invokeV.booleanValue;
        }

        public c f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                this.f285f = true;
                this.f = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f : (String) invokeV.objValue;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m301f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f285f : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public String f286a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f287a;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f288b;
        public String c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f289c;
        public boolean d;
        public boolean e;

        public d() {
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
            this.f288b = false;
            this.f286a = "";
            this.b = "";
            this.c = "";
            this.a = -1;
        }

        public static d a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? (d) new d().a(bArr) : (d) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a < 0) {
                    b();
                }
                return this.a;
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) != null) {
                return (d) invokeL.objValue;
            }
            while (true) {
                int m184a = bVar.m184a();
                if (m184a == 0) {
                    return this;
                }
                if (m184a == 8) {
                    a(bVar.m190a());
                } else if (m184a == 18) {
                    a(bVar.m187a());
                } else if (m184a == 26) {
                    b(bVar.m187a());
                } else if (m184a == 34) {
                    c(bVar.m187a());
                } else if (!a(bVar, m184a)) {
                    return this;
                }
            }
        }

        public d a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f289c = true;
                this.f286a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f287a = true;
                this.f288b = z;
                return this;
            }
            return (d) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f286a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                if (b()) {
                    cVar.m233a(1, a());
                }
                if (m302c()) {
                    cVar.m232a(2, a());
                }
                if (d()) {
                    cVar.m232a(3, b());
                }
                if (e()) {
                    cVar.m232a(4, c());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f288b : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (m302c()) {
                    a += com.xiaomi.push.c.a(2, a());
                }
                if (d()) {
                    a += com.xiaomi.push.c.a(3, b());
                }
                if (e()) {
                    a += com.xiaomi.push.c.a(4, c());
                }
                this.a = a;
                return a;
            }
            return invokeV.intValue;
        }

        public d b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.d = true;
                this.b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f287a : invokeV.booleanValue;
        }

        public d c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.e = true;
                this.c = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m302c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f289c : invokeV.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.d : invokeV.booleanValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.e : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class e extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public b f290a;

        /* renamed from: a  reason: collision with other field name */
        public String f291a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f292a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public String f293b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f294b;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public String f295c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f296c;
        public int d;

        /* renamed from: d  reason: collision with other field name */
        public String f297d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f298d;
        public String e;

        /* renamed from: e  reason: collision with other field name */
        public boolean f299e;
        public String f;

        /* renamed from: f  reason: collision with other field name */
        public boolean f300f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;

        public e() {
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
            this.a = 0;
            this.f291a = "";
            this.f293b = "";
            this.f295c = "";
            this.b = 0;
            this.f297d = "";
            this.e = "";
            this.f = "";
            this.f290a = null;
            this.c = 0;
            this.d = -1;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.d < 0) {
                    b();
                }
                return this.d;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f290a : (b) invokeV.objValue;
        }

        public e a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.f292a = true;
                this.a = i;
                return this;
            }
            return (e) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
                while (true) {
                    int m184a = bVar.m184a();
                    switch (m184a) {
                        case 0:
                            return this;
                        case 8:
                            a(bVar.c());
                            break;
                        case 18:
                            a(bVar.m187a());
                            break;
                        case 26:
                            b(bVar.m187a());
                            break;
                        case 34:
                            c(bVar.m187a());
                            break;
                        case 40:
                            b(bVar.m193b());
                            break;
                        case 50:
                            d(bVar.m187a());
                            break;
                        case 58:
                            e(bVar.m187a());
                            break;
                        case 66:
                            f(bVar.m187a());
                            break;
                        case 74:
                            b bVar2 = new b();
                            bVar.a(bVar2);
                            a(bVar2);
                            break;
                        case 80:
                            c(bVar.m193b());
                            break;
                        default:
                            if (a(bVar, m184a)) {
                                break;
                            } else {
                                return this;
                            }
                    }
                }
            } else {
                return (e) invokeL.objValue;
            }
        }

        public e a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
                if (bVar != null) {
                    this.i = true;
                    this.f290a = bVar;
                    return this;
                }
                throw null;
            }
            return (e) invokeL.objValue;
        }

        public e a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f294b = true;
                this.f291a = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f291a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
                if (a()) {
                    cVar.m241b(1, c());
                }
                if (b()) {
                    cVar.m232a(2, a());
                }
                if (m304c()) {
                    cVar.m232a(3, b());
                }
                if (m306d()) {
                    cVar.m232a(4, m303c());
                }
                if (m308e()) {
                    cVar.m228a(5, d());
                }
                if (m309f()) {
                    cVar.m232a(6, m305d());
                }
                if (g()) {
                    cVar.m232a(7, m307e());
                }
                if (h()) {
                    cVar.m232a(8, f());
                }
                if (i()) {
                    cVar.m231a(9, (com.xiaomi.push.e) a());
                }
                if (j()) {
                    cVar.m228a(10, e());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f292a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                int b = a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
                if (b()) {
                    b += com.xiaomi.push.c.a(2, a());
                }
                if (m304c()) {
                    b += com.xiaomi.push.c.a(3, b());
                }
                if (m306d()) {
                    b += com.xiaomi.push.c.a(4, m303c());
                }
                if (m308e()) {
                    b += com.xiaomi.push.c.a(5, d());
                }
                if (m309f()) {
                    b += com.xiaomi.push.c.a(6, m305d());
                }
                if (g()) {
                    b += com.xiaomi.push.c.a(7, m307e());
                }
                if (h()) {
                    b += com.xiaomi.push.c.a(8, f());
                }
                if (i()) {
                    b += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) a());
                }
                if (j()) {
                    b += com.xiaomi.push.c.a(10, e());
                }
                this.d = b;
                return b;
            }
            return invokeV.intValue;
        }

        public e b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                this.f299e = true;
                this.b = i;
                return this;
            }
            return (e) invokeI.objValue;
        }

        public e b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f296c = true;
                this.f293b = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f293b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f294b : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a : invokeV.intValue;
        }

        public e c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
                this.j = true;
                this.c = i;
                return this;
            }
            return (e) invokeI.objValue;
        }

        public e c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.f298d = true;
                this.f295c = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m303c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f295c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m304c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f296c : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.b : invokeV.intValue;
        }

        public e d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                this.f300f = true;
                this.f297d = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m305d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f297d : (String) invokeV.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m306d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f298d : invokeV.booleanValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.c : invokeV.intValue;
        }

        public e e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
                this.g = true;
                this.e = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m307e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.e : (String) invokeV.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m308e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f299e : invokeV.booleanValue;
        }

        public e f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
                this.h = true;
                this.f = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f : (String) invokeV.objValue;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m309f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f300f : invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.g : invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.h : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.i : invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.j : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class f extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public b f301a;

        /* renamed from: a  reason: collision with other field name */
        public String f302a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f303a;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f304b;
        public boolean c;

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
            this.f302a = "";
            this.b = "";
            this.f301a = null;
            this.a = -1;
        }

        public static f a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? (f) new f().a(bArr) : (f) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a < 0) {
                    b();
                }
                return this.a;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f301a : (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) != null) {
                return (f) invokeL.objValue;
            }
            while (true) {
                int m184a = bVar.m184a();
                if (m184a == 0) {
                    return this;
                }
                if (m184a == 10) {
                    a(bVar.m187a());
                } else if (m184a == 18) {
                    b(bVar.m187a());
                } else if (m184a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m184a)) {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
                if (bVar != null) {
                    this.c = true;
                    this.f301a = bVar;
                    return this;
                }
                throw null;
            }
            return (f) invokeL.objValue;
        }

        public f a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f303a = true;
                this.f302a = str;
                return this;
            }
            return (f) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f302a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
                if (a()) {
                    cVar.m232a(1, a());
                }
                if (b()) {
                    cVar.m232a(2, b());
                }
                if (c()) {
                    cVar.m231a(3, (com.xiaomi.push.e) a());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f303a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (b()) {
                    a += com.xiaomi.push.c.a(2, b());
                }
                if (c()) {
                    a += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) a());
                }
                this.a = a;
                return a;
            }
            return invokeV.intValue;
        }

        public f b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.f304b = true;
                this.b = str;
                return this;
            }
            return (f) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f304b : invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.c : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class g extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public String f305a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f306a;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f307b;
        public String c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f308c;

        public g() {
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
            this.f305a = "";
            this.b = "";
            this.c = "";
            this.a = -1;
        }

        public static g a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? (g) new g().a(bArr) : (g) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a < 0) {
                    b();
                }
                return this.a;
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) != null) {
                return (g) invokeL.objValue;
            }
            while (true) {
                int m184a = bVar.m184a();
                if (m184a == 0) {
                    return this;
                }
                if (m184a == 10) {
                    a(bVar.m187a());
                } else if (m184a == 18) {
                    b(bVar.m187a());
                } else if (m184a == 26) {
                    c(bVar.m187a());
                } else if (!a(bVar, m184a)) {
                    return this;
                }
            }
        }

        public g a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f306a = true;
                this.f305a = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f305a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                if (a()) {
                    cVar.m232a(1, a());
                }
                if (b()) {
                    cVar.m232a(2, b());
                }
                if (m310c()) {
                    cVar.m232a(3, c());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f306a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (b()) {
                    a += com.xiaomi.push.c.a(2, b());
                }
                if (m310c()) {
                    a += com.xiaomi.push.c.a(3, c());
                }
                this.a = a;
                return a;
            }
            return invokeV.intValue;
        }

        public g b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f307b = true;
                this.b = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f307b : invokeV.booleanValue;
        }

        public g c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.f308c = true;
                this.c = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m310c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f308c : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class h extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public String f309a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f310a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f311b;

        public h() {
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
            this.a = 0;
            this.f309a = "";
            this.b = -1;
        }

        public static h a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? (h) new h().a(bArr) : (h) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.b < 0) {
                    b();
                }
                return this.b;
            }
            return invokeV.intValue;
        }

        public h a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.f310a = true;
                this.a = i;
                return this;
            }
            return (h) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) != null) {
                return (h) invokeL.objValue;
            }
            while (true) {
                int m184a = bVar.m184a();
                if (m184a == 0) {
                    return this;
                }
                if (m184a == 8) {
                    a(bVar.m193b());
                } else if (m184a == 18) {
                    a(bVar.m187a());
                } else if (!a(bVar, m184a)) {
                    return this;
                }
            }
        }

        public h a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f311b = true;
                this.f309a = str;
                return this;
            }
            return (h) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f309a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                if (a()) {
                    cVar.m228a(1, c());
                }
                if (b()) {
                    cVar.m232a(2, a());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f310a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int a = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
                if (b()) {
                    a += com.xiaomi.push.c.a(2, a());
                }
                this.b = a;
                return a;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f311b : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a : invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class i extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f312a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f313a;

        public i() {
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
            this.f312a = com.xiaomi.push.a.a;
            this.a = -1;
        }

        public static i a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? (i) new i().a(bArr) : (i) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a < 0) {
                    b();
                }
                return this.a;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f312a : (com.xiaomi.push.a) invokeV.objValue;
        }

        public i a(com.xiaomi.push.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.f313a = true;
                this.f312a = aVar;
                return this;
            }
            return (i) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, bVar)) != null) {
                return (i) invokeL.objValue;
            }
            while (true) {
                int m184a = bVar.m184a();
                if (m184a == 0) {
                    return this;
                }
                if (m184a == 10) {
                    a(bVar.m186a());
                } else if (!a(bVar, m184a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) && a()) {
                cVar.m230a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f313a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                this.a = a;
                return a;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class j extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f314a;

        /* renamed from: a  reason: collision with other field name */
        public b f315a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f316a;
        public boolean b;

        public j() {
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
            this.f314a = com.xiaomi.push.a.a;
            this.f315a = null;
            this.a = -1;
        }

        public static j a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? (j) new j().a(bArr) : (j) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a < 0) {
                    b();
                }
                return this.a;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f314a : (com.xiaomi.push.a) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f315a : (b) invokeV.objValue;
        }

        public j a(com.xiaomi.push.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
                this.f316a = true;
                this.f314a = aVar;
                return this;
            }
            return (j) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, bVar)) != null) {
                return (j) invokeL.objValue;
            }
            while (true) {
                int m184a = bVar.m184a();
                if (m184a == 0) {
                    return this;
                }
                if (m184a == 10) {
                    a(bVar.m186a());
                } else if (m184a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m184a)) {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
                if (bVar != null) {
                    this.b = true;
                    this.f315a = bVar;
                    return this;
                }
                throw null;
            }
            return (j) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
                if (a()) {
                    cVar.m230a(1, a());
                }
                if (b()) {
                    cVar.m231a(2, (com.xiaomi.push.e) a());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f316a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (b()) {
                    a += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) a());
                }
                this.a = a;
                return a;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class k extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f317a;

        /* renamed from: a  reason: collision with other field name */
        public String f318a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f319a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public long f320b;

        /* renamed from: b  reason: collision with other field name */
        public String f321b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f322b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;

        public k() {
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
            this.f318a = "";
            this.f321b = "";
            this.f317a = 0L;
            this.f320b = 0L;
            this.f = false;
            this.a = 0;
            this.b = -1;
        }

        public static k a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? (k) new k().a(bArr) : (k) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.b < 0) {
                    b();
                }
                return this.b;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f317a : invokeV.longValue;
        }

        public k a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.g = true;
                this.a = i;
                return this;
            }
            return (k) invokeI.objValue;
        }

        public k a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.c = true;
                this.f317a = j;
                return this;
            }
            return (k) invokeJ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, bVar)) != null) {
                return (k) invokeL.objValue;
            }
            while (true) {
                int m184a = bVar.m184a();
                if (m184a == 0) {
                    return this;
                }
                if (m184a == 10) {
                    a(bVar.m187a());
                } else if (m184a == 18) {
                    b(bVar.m187a());
                } else if (m184a == 24) {
                    a(bVar.m185a());
                } else if (m184a == 32) {
                    b(bVar.m185a());
                } else if (m184a == 40) {
                    a(bVar.m190a());
                } else if (m184a == 48) {
                    a(bVar.m193b());
                } else if (!a(bVar, m184a)) {
                    return this;
                }
            }
        }

        public k a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f319a = true;
                this.f318a = str;
                return this;
            }
            return (k) invokeL.objValue;
        }

        public k a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.e = true;
                this.f = z;
                return this;
            }
            return (k) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f318a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
                if (a()) {
                    cVar.m232a(1, a());
                }
                if (b()) {
                    cVar.m232a(2, b());
                }
                if (m311c()) {
                    cVar.m229a(3, a());
                }
                if (d()) {
                    cVar.m229a(4, b());
                }
                if (f()) {
                    cVar.m233a(5, e());
                }
                if (g()) {
                    cVar.m228a(6, c());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f319a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (b()) {
                    a += com.xiaomi.push.c.a(2, b());
                }
                if (m311c()) {
                    a += com.xiaomi.push.c.a(3, a());
                }
                if (d()) {
                    a += com.xiaomi.push.c.a(4, b());
                }
                if (f()) {
                    a += com.xiaomi.push.c.a(5, e());
                }
                if (g()) {
                    a += com.xiaomi.push.c.a(6, c());
                }
                this.b = a;
                return a;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f320b : invokeV.longValue;
        }

        public k b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) {
                this.d = true;
                this.f320b = j;
                return this;
            }
            return (k) invokeJ.objValue;
        }

        public k b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.f322b = true;
                this.f321b = str;
                return this;
            }
            return (k) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f321b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f322b : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a : invokeV.intValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m311c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.c : invokeV.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.d : invokeV.booleanValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f : invokeV.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.e : invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.g : invokeV.booleanValue;
        }
    }
}
