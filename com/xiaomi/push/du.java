package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class du {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static final class a extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77498a;

        /* renamed from: a  reason: collision with other field name */
        public long f252a;

        /* renamed from: a  reason: collision with other field name */
        public String f253a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f254a;

        /* renamed from: b  reason: collision with root package name */
        public int f77499b;

        /* renamed from: b  reason: collision with other field name */
        public String f255b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f256b;

        /* renamed from: c  reason: collision with root package name */
        public int f77500c;

        /* renamed from: c  reason: collision with other field name */
        public String f257c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f258c;

        /* renamed from: d  reason: collision with root package name */
        public int f77501d;

        /* renamed from: d  reason: collision with other field name */
        public String f259d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f260d;

        /* renamed from: e  reason: collision with root package name */
        public int f77502e;

        /* renamed from: e  reason: collision with other field name */
        public String f261e;

        /* renamed from: e  reason: collision with other field name */
        public boolean f262e;

        /* renamed from: f  reason: collision with root package name */
        public String f77503f;

        /* renamed from: f  reason: collision with other field name */
        public boolean f263f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f77504g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f77505h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f77506i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f77507j;
        public boolean k;

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
            this.f77498a = 0;
            this.f252a = 0L;
            this.f253a = "";
            this.f255b = "";
            this.f257c = "";
            this.f259d = "";
            this.f261e = "";
            this.f77499b = 1;
            this.f77500c = 0;
            this.f77501d = 0;
            this.f77503f = "";
            this.f77502e = -1;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f77502e < 0) {
                    b();
                }
                return this.f77502e;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f252a : invokeV.longValue;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.f263f = false;
                this.f259d = "";
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f254a = true;
                this.f77498a = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                this.f256b = true;
                this.f252a = j2;
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
                    int m160a = bVar.m160a();
                    switch (m160a) {
                        case 0:
                            return this;
                        case 8:
                            a(bVar.m169b());
                            break;
                        case 16:
                            a(bVar.m170b());
                            break;
                        case 26:
                            a(bVar.m163a());
                            break;
                        case 34:
                            b(bVar.m163a());
                            break;
                        case 42:
                            c(bVar.m163a());
                            break;
                        case 50:
                            d(bVar.m163a());
                            break;
                        case 58:
                            e(bVar.m163a());
                            break;
                        case 64:
                            b(bVar.m169b());
                            break;
                        case 72:
                            c(bVar.m169b());
                            break;
                        case 80:
                            d(bVar.m169b());
                            break;
                        case 90:
                            f(bVar.m163a());
                            break;
                        default:
                            if (a(bVar, m160a)) {
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
                this.f258c = true;
                this.f253a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f253a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
                if (a()) {
                    cVar.m198a(1, c());
                }
                if (b()) {
                    cVar.m212b(2, a());
                }
                if (m258c()) {
                    cVar.m202a(3, a());
                }
                if (m260d()) {
                    cVar.m202a(4, b());
                }
                if (m262e()) {
                    cVar.m202a(5, m257c());
                }
                if (m264f()) {
                    cVar.m202a(6, m259d());
                }
                if (g()) {
                    cVar.m202a(7, m261e());
                }
                if (h()) {
                    cVar.m198a(8, d());
                }
                if (i()) {
                    cVar.m198a(9, e());
                }
                if (j()) {
                    cVar.m198a(10, f());
                }
                if (k()) {
                    cVar.m202a(11, m263f());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f254a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                int a2 = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
                if (b()) {
                    a2 += com.xiaomi.push.c.b(2, a());
                }
                if (m258c()) {
                    a2 += com.xiaomi.push.c.a(3, a());
                }
                if (m260d()) {
                    a2 += com.xiaomi.push.c.a(4, b());
                }
                if (m262e()) {
                    a2 += com.xiaomi.push.c.a(5, m257c());
                }
                if (m264f()) {
                    a2 += com.xiaomi.push.c.a(6, m259d());
                }
                if (g()) {
                    a2 += com.xiaomi.push.c.a(7, m261e());
                }
                if (h()) {
                    a2 += com.xiaomi.push.c.a(8, d());
                }
                if (i()) {
                    a2 += com.xiaomi.push.c.a(9, e());
                }
                if (j()) {
                    a2 += com.xiaomi.push.c.a(10, f());
                }
                if (k()) {
                    a2 += com.xiaomi.push.c.a(11, m263f());
                }
                this.f77502e = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                this.f77505h = true;
                this.f77499b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.f260d = true;
                this.f255b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f255b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f256b : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f77498a : invokeV.intValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                this.f77506i = true;
                this.f77500c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                this.f262e = true;
                this.f257c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m257c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f257c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m258c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f258c : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f77499b : invokeV.intValue;
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
                this.f77507j = true;
                this.f77501d = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
                this.f263f = true;
                this.f259d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m259d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f259d : (String) invokeV.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m260d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f260d : invokeV.booleanValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f77500c : invokeV.intValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
                this.f77504g = true;
                this.f261e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m261e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f261e : (String) invokeV.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m262e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f262e : invokeV.booleanValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f77501d : invokeV.intValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
                this.k = true;
                this.f77503f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m263f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f77503f : (String) invokeV.objValue;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m264f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f263f : invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f77504g : invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f77505h : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f77506i : invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f77507j : invokeV.booleanValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.k : invokeV.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class b extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77508a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f264a;

        /* renamed from: b  reason: collision with root package name */
        public int f77509b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f265b;

        /* renamed from: c  reason: collision with root package name */
        public int f77510c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f266c;

        /* renamed from: d  reason: collision with root package name */
        public int f77511d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f267d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f77512e;

        public b() {
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
            this.f265b = false;
            this.f77508a = 0;
            this.f77509b = 0;
            this.f77510c = 0;
            this.f77511d = -1;
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
                if (this.f77511d < 0) {
                    b();
                }
                return this.f77511d;
            }
            return invokeV.intValue;
        }

        public b a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f266c = true;
                this.f77508a = i2;
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
                int m160a = bVar.m160a();
                if (m160a == 0) {
                    return this;
                }
                if (m160a == 8) {
                    a(bVar.m166a());
                } else if (m160a == 24) {
                    a(bVar.m169b());
                } else if (m160a == 32) {
                    b(bVar.m169b());
                } else if (m160a == 40) {
                    c(bVar.m169b());
                } else if (!a(bVar, m160a)) {
                    return this;
                }
            }
        }

        public b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f264a = true;
                this.f265b = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                if (b()) {
                    cVar.m203a(1, a());
                }
                if (m265c()) {
                    cVar.m198a(3, c());
                }
                if (m266d()) {
                    cVar.m198a(4, d());
                }
                if (m267e()) {
                    cVar.m198a(5, e());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f265b : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (m265c()) {
                    a2 += com.xiaomi.push.c.a(3, c());
                }
                if (m266d()) {
                    a2 += com.xiaomi.push.c.a(4, d());
                }
                if (m267e()) {
                    a2 += com.xiaomi.push.c.a(5, e());
                }
                this.f77511d = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        public b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.f267d = true;
                this.f77509b = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f264a : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f77508a : invokeV.intValue;
        }

        public b c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.f77512e = true;
                this.f77510c = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m265c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f266c : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f77509b : invokeV.intValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m266d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f267d : invokeV.booleanValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f77510c : invokeV.intValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m267e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f77512e : invokeV.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class c extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77513a;

        /* renamed from: a  reason: collision with other field name */
        public String f268a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f269a;

        /* renamed from: b  reason: collision with root package name */
        public String f77514b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f270b;

        /* renamed from: c  reason: collision with root package name */
        public String f77515c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f271c;

        /* renamed from: d  reason: collision with root package name */
        public String f77516d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f272d;

        /* renamed from: e  reason: collision with root package name */
        public String f77517e;

        /* renamed from: e  reason: collision with other field name */
        public boolean f273e;

        /* renamed from: f  reason: collision with root package name */
        public String f77518f;

        /* renamed from: f  reason: collision with other field name */
        public boolean f274f;

        public c() {
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
            this.f268a = "";
            this.f77514b = "";
            this.f77515c = "";
            this.f77516d = "";
            this.f77517e = "";
            this.f77518f = "";
            this.f77513a = -1;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f77513a < 0) {
                    b();
                }
                return this.f77513a;
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
                int m160a = bVar.m160a();
                if (m160a == 0) {
                    return this;
                }
                if (m160a == 10) {
                    a(bVar.m163a());
                } else if (m160a == 18) {
                    b(bVar.m163a());
                } else if (m160a == 26) {
                    c(bVar.m163a());
                } else if (m160a == 34) {
                    d(bVar.m163a());
                } else if (m160a == 42) {
                    e(bVar.m163a());
                } else if (m160a == 50) {
                    f(bVar.m163a());
                } else if (!a(bVar, m160a)) {
                    return this;
                }
            }
        }

        public c a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f269a = true;
                this.f268a = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f268a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                if (a()) {
                    cVar.m202a(1, a());
                }
                if (b()) {
                    cVar.m202a(2, b());
                }
                if (m268c()) {
                    cVar.m202a(3, c());
                }
                if (m269d()) {
                    cVar.m202a(4, d());
                }
                if (m270e()) {
                    cVar.m202a(5, e());
                }
                if (m271f()) {
                    cVar.m202a(6, f());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f269a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (b()) {
                    a2 += com.xiaomi.push.c.a(2, b());
                }
                if (m268c()) {
                    a2 += com.xiaomi.push.c.a(3, c());
                }
                if (m269d()) {
                    a2 += com.xiaomi.push.c.a(4, d());
                }
                if (m270e()) {
                    a2 += com.xiaomi.push.c.a(5, e());
                }
                if (m271f()) {
                    a2 += com.xiaomi.push.c.a(6, f());
                }
                this.f77513a = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        public c b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f270b = true;
                this.f77514b = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f77514b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f270b : invokeV.booleanValue;
        }

        public c c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.f271c = true;
                this.f77515c = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f77515c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m268c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f271c : invokeV.booleanValue;
        }

        public c d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.f272d = true;
                this.f77516d = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f77516d : (String) invokeV.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m269d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f272d : invokeV.booleanValue;
        }

        public c e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.f273e = true;
                this.f77517e = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f77517e : (String) invokeV.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m270e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f273e : invokeV.booleanValue;
        }

        public c f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                this.f274f = true;
                this.f77518f = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f77518f : (String) invokeV.objValue;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m271f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f274f : invokeV.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class d extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77519a;

        /* renamed from: a  reason: collision with other field name */
        public String f275a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f276a;

        /* renamed from: b  reason: collision with root package name */
        public String f77520b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f277b;

        /* renamed from: c  reason: collision with root package name */
        public String f77521c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f278c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f77522d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f77523e;

        public d() {
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
            this.f277b = false;
            this.f275a = "";
            this.f77520b = "";
            this.f77521c = "";
            this.f77519a = -1;
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
                if (this.f77519a < 0) {
                    b();
                }
                return this.f77519a;
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
                int m160a = bVar.m160a();
                if (m160a == 0) {
                    return this;
                }
                if (m160a == 8) {
                    a(bVar.m166a());
                } else if (m160a == 18) {
                    a(bVar.m163a());
                } else if (m160a == 26) {
                    b(bVar.m163a());
                } else if (m160a == 34) {
                    c(bVar.m163a());
                } else if (!a(bVar, m160a)) {
                    return this;
                }
            }
        }

        public d a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f278c = true;
                this.f275a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f276a = true;
                this.f277b = z;
                return this;
            }
            return (d) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f275a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                if (b()) {
                    cVar.m203a(1, a());
                }
                if (m272c()) {
                    cVar.m202a(2, a());
                }
                if (d()) {
                    cVar.m202a(3, b());
                }
                if (e()) {
                    cVar.m202a(4, c());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f277b : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (m272c()) {
                    a2 += com.xiaomi.push.c.a(2, a());
                }
                if (d()) {
                    a2 += com.xiaomi.push.c.a(3, b());
                }
                if (e()) {
                    a2 += com.xiaomi.push.c.a(4, c());
                }
                this.f77519a = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        public d b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f77522d = true;
                this.f77520b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f77520b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f276a : invokeV.booleanValue;
        }

        public d c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f77523e = true;
                this.f77521c = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f77521c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m272c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f278c : invokeV.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f77522d : invokeV.booleanValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f77523e : invokeV.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class e extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77524a;

        /* renamed from: a  reason: collision with other field name */
        public b f279a;

        /* renamed from: a  reason: collision with other field name */
        public String f280a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f281a;

        /* renamed from: b  reason: collision with root package name */
        public int f77525b;

        /* renamed from: b  reason: collision with other field name */
        public String f282b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f283b;

        /* renamed from: c  reason: collision with root package name */
        public int f77526c;

        /* renamed from: c  reason: collision with other field name */
        public String f284c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f285c;

        /* renamed from: d  reason: collision with root package name */
        public int f77527d;

        /* renamed from: d  reason: collision with other field name */
        public String f286d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f287d;

        /* renamed from: e  reason: collision with root package name */
        public String f77528e;

        /* renamed from: e  reason: collision with other field name */
        public boolean f288e;

        /* renamed from: f  reason: collision with root package name */
        public String f77529f;

        /* renamed from: f  reason: collision with other field name */
        public boolean f289f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f77530g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f77531h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f77532i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f77533j;

        public e() {
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
            this.f77524a = 0;
            this.f280a = "";
            this.f282b = "";
            this.f284c = "";
            this.f77525b = 0;
            this.f286d = "";
            this.f77528e = "";
            this.f77529f = "";
            this.f279a = null;
            this.f77526c = 0;
            this.f77527d = -1;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f77527d < 0) {
                    b();
                }
                return this.f77527d;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f279a : (b) invokeV.objValue;
        }

        public e a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f281a = true;
                this.f77524a = i2;
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
                    int m160a = bVar.m160a();
                    switch (m160a) {
                        case 0:
                            return this;
                        case 8:
                            a(bVar.c());
                            break;
                        case 18:
                            a(bVar.m163a());
                            break;
                        case 26:
                            b(bVar.m163a());
                            break;
                        case 34:
                            c(bVar.m163a());
                            break;
                        case 40:
                            b(bVar.m169b());
                            break;
                        case 50:
                            d(bVar.m163a());
                            break;
                        case 58:
                            e(bVar.m163a());
                            break;
                        case 66:
                            f(bVar.m163a());
                            break;
                        case 74:
                            b bVar2 = new b();
                            bVar.a(bVar2);
                            a(bVar2);
                            break;
                        case 80:
                            c(bVar.m169b());
                            break;
                        default:
                            if (a(bVar, m160a)) {
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
                    this.f77532i = true;
                    this.f279a = bVar;
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
                this.f283b = true;
                this.f280a = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f280a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
                if (a()) {
                    cVar.m211b(1, c());
                }
                if (b()) {
                    cVar.m202a(2, a());
                }
                if (m274c()) {
                    cVar.m202a(3, b());
                }
                if (m276d()) {
                    cVar.m202a(4, m273c());
                }
                if (m278e()) {
                    cVar.m198a(5, d());
                }
                if (m279f()) {
                    cVar.m202a(6, m275d());
                }
                if (g()) {
                    cVar.m202a(7, m277e());
                }
                if (h()) {
                    cVar.m202a(8, f());
                }
                if (i()) {
                    cVar.m201a(9, (com.xiaomi.push.e) a());
                }
                if (j()) {
                    cVar.m198a(10, e());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f281a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                int b2 = a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
                if (b()) {
                    b2 += com.xiaomi.push.c.a(2, a());
                }
                if (m274c()) {
                    b2 += com.xiaomi.push.c.a(3, b());
                }
                if (m276d()) {
                    b2 += com.xiaomi.push.c.a(4, m273c());
                }
                if (m278e()) {
                    b2 += com.xiaomi.push.c.a(5, d());
                }
                if (m279f()) {
                    b2 += com.xiaomi.push.c.a(6, m275d());
                }
                if (g()) {
                    b2 += com.xiaomi.push.c.a(7, m277e());
                }
                if (h()) {
                    b2 += com.xiaomi.push.c.a(8, f());
                }
                if (i()) {
                    b2 += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) a());
                }
                if (j()) {
                    b2 += com.xiaomi.push.c.a(10, e());
                }
                this.f77527d = b2;
                return b2;
            }
            return invokeV.intValue;
        }

        public e b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.f288e = true;
                this.f77525b = i2;
                return this;
            }
            return (e) invokeI.objValue;
        }

        public e b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f285c = true;
                this.f282b = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f282b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f283b : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f77524a : invokeV.intValue;
        }

        public e c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                this.f77533j = true;
                this.f77526c = i2;
                return this;
            }
            return (e) invokeI.objValue;
        }

        public e c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.f287d = true;
                this.f284c = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m273c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f284c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m274c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f285c : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f77525b : invokeV.intValue;
        }

        public e d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                this.f289f = true;
                this.f286d = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m275d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f286d : (String) invokeV.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m276d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f287d : invokeV.booleanValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f77526c : invokeV.intValue;
        }

        public e e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
                this.f77530g = true;
                this.f77528e = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m277e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f77528e : (String) invokeV.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m278e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f288e : invokeV.booleanValue;
        }

        public e f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
                this.f77531h = true;
                this.f77529f = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f77529f : (String) invokeV.objValue;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m279f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f289f : invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f77530g : invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f77531h : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f77532i : invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f77533j : invokeV.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class f extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77534a;

        /* renamed from: a  reason: collision with other field name */
        public b f290a;

        /* renamed from: a  reason: collision with other field name */
        public String f291a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f292a;

        /* renamed from: b  reason: collision with root package name */
        public String f77535b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f293b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f77536c;

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
            this.f291a = "";
            this.f77535b = "";
            this.f290a = null;
            this.f77534a = -1;
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
                if (this.f77534a < 0) {
                    b();
                }
                return this.f77534a;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f290a : (b) invokeV.objValue;
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
                int m160a = bVar.m160a();
                if (m160a == 0) {
                    return this;
                }
                if (m160a == 10) {
                    a(bVar.m163a());
                } else if (m160a == 18) {
                    b(bVar.m163a());
                } else if (m160a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m160a)) {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
                if (bVar != null) {
                    this.f77536c = true;
                    this.f290a = bVar;
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
                this.f292a = true;
                this.f291a = str;
                return this;
            }
            return (f) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f291a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
                if (a()) {
                    cVar.m202a(1, a());
                }
                if (b()) {
                    cVar.m202a(2, b());
                }
                if (c()) {
                    cVar.m201a(3, (com.xiaomi.push.e) a());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f292a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (b()) {
                    a2 += com.xiaomi.push.c.a(2, b());
                }
                if (c()) {
                    a2 += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) a());
                }
                this.f77534a = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        public f b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.f293b = true;
                this.f77535b = str;
                return this;
            }
            return (f) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f77535b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f293b : invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f77536c : invokeV.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class g extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77537a;

        /* renamed from: a  reason: collision with other field name */
        public String f294a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f295a;

        /* renamed from: b  reason: collision with root package name */
        public String f77538b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f296b;

        /* renamed from: c  reason: collision with root package name */
        public String f77539c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f297c;

        public g() {
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
            this.f294a = "";
            this.f77538b = "";
            this.f77539c = "";
            this.f77537a = -1;
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
                if (this.f77537a < 0) {
                    b();
                }
                return this.f77537a;
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
                int m160a = bVar.m160a();
                if (m160a == 0) {
                    return this;
                }
                if (m160a == 10) {
                    a(bVar.m163a());
                } else if (m160a == 18) {
                    b(bVar.m163a());
                } else if (m160a == 26) {
                    c(bVar.m163a());
                } else if (!a(bVar, m160a)) {
                    return this;
                }
            }
        }

        public g a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f295a = true;
                this.f294a = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f294a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                if (a()) {
                    cVar.m202a(1, a());
                }
                if (b()) {
                    cVar.m202a(2, b());
                }
                if (m280c()) {
                    cVar.m202a(3, c());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f295a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (b()) {
                    a2 += com.xiaomi.push.c.a(2, b());
                }
                if (m280c()) {
                    a2 += com.xiaomi.push.c.a(3, c());
                }
                this.f77537a = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        public g b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f296b = true;
                this.f77538b = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f77538b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f296b : invokeV.booleanValue;
        }

        public g c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.f297c = true;
                this.f77539c = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f77539c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m280c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f297c : invokeV.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class h extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77540a;

        /* renamed from: a  reason: collision with other field name */
        public String f298a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f299a;

        /* renamed from: b  reason: collision with root package name */
        public int f77541b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f300b;

        public h() {
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
            this.f77540a = 0;
            this.f298a = "";
            this.f77541b = -1;
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
                if (this.f77541b < 0) {
                    b();
                }
                return this.f77541b;
            }
            return invokeV.intValue;
        }

        public h a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f299a = true;
                this.f77540a = i2;
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
                int m160a = bVar.m160a();
                if (m160a == 0) {
                    return this;
                }
                if (m160a == 8) {
                    a(bVar.m169b());
                } else if (m160a == 18) {
                    a(bVar.m163a());
                } else if (!a(bVar, m160a)) {
                    return this;
                }
            }
        }

        public h a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f300b = true;
                this.f298a = str;
                return this;
            }
            return (h) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f298a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                if (a()) {
                    cVar.m198a(1, c());
                }
                if (b()) {
                    cVar.m202a(2, a());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f299a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int a2 = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
                if (b()) {
                    a2 += com.xiaomi.push.c.a(2, a());
                }
                this.f77541b = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f300b : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f77540a : invokeV.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class i extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77542a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f301a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f302a;

        public i() {
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
            this.f301a = com.xiaomi.push.a.f77330a;
            this.f77542a = -1;
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
                if (this.f77542a < 0) {
                    b();
                }
                return this.f77542a;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f301a : (com.xiaomi.push.a) invokeV.objValue;
        }

        public i a(com.xiaomi.push.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.f302a = true;
                this.f301a = aVar;
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
                int m160a = bVar.m160a();
                if (m160a == 0) {
                    return this;
                }
                if (m160a == 10) {
                    a(bVar.m162a());
                } else if (!a(bVar, m160a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) && a()) {
                cVar.m200a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f302a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                this.f77542a = a2;
                return a2;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class j extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77543a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f303a;

        /* renamed from: a  reason: collision with other field name */
        public b f304a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f305a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f77544b;

        public j() {
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
            this.f303a = com.xiaomi.push.a.f77330a;
            this.f304a = null;
            this.f77543a = -1;
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
                if (this.f77543a < 0) {
                    b();
                }
                return this.f77543a;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f303a : (com.xiaomi.push.a) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f304a : (b) invokeV.objValue;
        }

        public j a(com.xiaomi.push.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
                this.f305a = true;
                this.f303a = aVar;
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
                int m160a = bVar.m160a();
                if (m160a == 0) {
                    return this;
                }
                if (m160a == 10) {
                    a(bVar.m162a());
                } else if (m160a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m160a)) {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
                if (bVar != null) {
                    this.f77544b = true;
                    this.f304a = bVar;
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
                    cVar.m200a(1, a());
                }
                if (b()) {
                    cVar.m201a(2, (com.xiaomi.push.e) a());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f305a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (b()) {
                    a2 += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) a());
                }
                this.f77543a = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f77544b : invokeV.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class k extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f77545a;

        /* renamed from: a  reason: collision with other field name */
        public long f306a;

        /* renamed from: a  reason: collision with other field name */
        public String f307a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f308a;

        /* renamed from: b  reason: collision with root package name */
        public int f77546b;

        /* renamed from: b  reason: collision with other field name */
        public long f309b;

        /* renamed from: b  reason: collision with other field name */
        public String f310b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f311b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f77547c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f77548d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f77549e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f77550f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f77551g;

        public k() {
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
            this.f307a = "";
            this.f310b = "";
            this.f306a = 0L;
            this.f309b = 0L;
            this.f77550f = false;
            this.f77545a = 0;
            this.f77546b = -1;
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
                if (this.f77546b < 0) {
                    b();
                }
                return this.f77546b;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f306a : invokeV.longValue;
        }

        public k a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f77551g = true;
                this.f77545a = i2;
                return this;
            }
            return (k) invokeI.objValue;
        }

        public k a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                this.f77547c = true;
                this.f306a = j2;
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
                int m160a = bVar.m160a();
                if (m160a == 0) {
                    return this;
                }
                if (m160a == 10) {
                    a(bVar.m163a());
                } else if (m160a == 18) {
                    b(bVar.m163a());
                } else if (m160a == 24) {
                    a(bVar.m161a());
                } else if (m160a == 32) {
                    b(bVar.m161a());
                } else if (m160a == 40) {
                    a(bVar.m166a());
                } else if (m160a == 48) {
                    a(bVar.m169b());
                } else if (!a(bVar, m160a)) {
                    return this;
                }
            }
        }

        public k a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f308a = true;
                this.f307a = str;
                return this;
            }
            return (k) invokeL.objValue;
        }

        public k a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f77549e = true;
                this.f77550f = z;
                return this;
            }
            return (k) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f307a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
                if (a()) {
                    cVar.m202a(1, a());
                }
                if (b()) {
                    cVar.m202a(2, b());
                }
                if (m281c()) {
                    cVar.m199a(3, a());
                }
                if (d()) {
                    cVar.m199a(4, b());
                }
                if (f()) {
                    cVar.m203a(5, e());
                }
                if (g()) {
                    cVar.m198a(6, c());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f308a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (b()) {
                    a2 += com.xiaomi.push.c.a(2, b());
                }
                if (m281c()) {
                    a2 += com.xiaomi.push.c.a(3, a());
                }
                if (d()) {
                    a2 += com.xiaomi.push.c.a(4, b());
                }
                if (f()) {
                    a2 += com.xiaomi.push.c.a(5, e());
                }
                if (g()) {
                    a2 += com.xiaomi.push.c.a(6, c());
                }
                this.f77546b = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f309b : invokeV.longValue;
        }

        public k b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j2)) == null) {
                this.f77548d = true;
                this.f309b = j2;
                return this;
            }
            return (k) invokeJ.objValue;
        }

        public k b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.f311b = true;
                this.f310b = str;
                return this;
            }
            return (k) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f310b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f311b : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f77545a : invokeV.intValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m281c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f77547c : invokeV.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f77548d : invokeV.booleanValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f77550f : invokeV.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f77549e : invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f77551g : invokeV.booleanValue;
        }
    }
}
