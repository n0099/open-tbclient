package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class du {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class a extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71733a;

        /* renamed from: a  reason: collision with other field name */
        public long f253a;

        /* renamed from: a  reason: collision with other field name */
        public String f254a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f255a;

        /* renamed from: b  reason: collision with root package name */
        public int f71734b;

        /* renamed from: b  reason: collision with other field name */
        public String f256b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f257b;

        /* renamed from: c  reason: collision with root package name */
        public int f71735c;

        /* renamed from: c  reason: collision with other field name */
        public String f258c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f259c;

        /* renamed from: d  reason: collision with root package name */
        public int f71736d;

        /* renamed from: d  reason: collision with other field name */
        public String f260d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f261d;

        /* renamed from: e  reason: collision with root package name */
        public int f71737e;

        /* renamed from: e  reason: collision with other field name */
        public String f262e;

        /* renamed from: e  reason: collision with other field name */
        public boolean f263e;

        /* renamed from: f  reason: collision with root package name */
        public String f71738f;

        /* renamed from: f  reason: collision with other field name */
        public boolean f264f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f71739g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f71740h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f71741i;
        public boolean j;
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
            this.f71733a = 0;
            this.f253a = 0L;
            this.f254a = "";
            this.f256b = "";
            this.f258c = "";
            this.f260d = "";
            this.f262e = "";
            this.f71734b = 1;
            this.f71735c = 0;
            this.f71736d = 0;
            this.f71738f = "";
            this.f71737e = -1;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f71737e < 0) {
                    b();
                }
                return this.f71737e;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f253a : invokeV.longValue;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.f264f = false;
                this.f260d = "";
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f255a = true;
                this.f71733a = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                this.f257b = true;
                this.f253a = j;
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
                this.f259c = true;
                this.f254a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f254a : (String) invokeV.objValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f255a : invokeV.booleanValue;
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
                this.f71737e = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                this.f71740h = true;
                this.f71734b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.f261d = true;
                this.f256b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f256b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f257b : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f71733a : invokeV.intValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                this.f71741i = true;
                this.f71735c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                this.f263e = true;
                this.f258c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m257c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f258c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m258c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f259c : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f71734b : invokeV.intValue;
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
                this.j = true;
                this.f71736d = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
                this.f264f = true;
                this.f260d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m259d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f260d : (String) invokeV.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m260d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f261d : invokeV.booleanValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f71735c : invokeV.intValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
                this.f71739g = true;
                this.f262e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m261e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f262e : (String) invokeV.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m262e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f263e : invokeV.booleanValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f71736d : invokeV.intValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
                this.k = true;
                this.f71738f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m263f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f71738f : (String) invokeV.objValue;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m264f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f264f : invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f71739g : invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f71740h : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f71741i : invokeV.booleanValue;
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

    /* loaded from: classes2.dex */
    public static final class b extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71742a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f265a;

        /* renamed from: b  reason: collision with root package name */
        public int f71743b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f266b;

        /* renamed from: c  reason: collision with root package name */
        public int f71744c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f267c;

        /* renamed from: d  reason: collision with root package name */
        public int f71745d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f268d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f71746e;

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
            this.f266b = false;
            this.f71742a = 0;
            this.f71743b = 0;
            this.f71744c = 0;
            this.f71745d = -1;
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
                if (this.f71745d < 0) {
                    b();
                }
                return this.f71745d;
            }
            return invokeV.intValue;
        }

        public b a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f267c = true;
                this.f71742a = i2;
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
                this.f265a = true;
                this.f266b = z;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f266b : invokeV.booleanValue;
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
                this.f71745d = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        public b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.f268d = true;
                this.f71743b = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f265a : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f71742a : invokeV.intValue;
        }

        public b c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.f71746e = true;
                this.f71744c = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m265c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f267c : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f71743b : invokeV.intValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m266d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f268d : invokeV.booleanValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f71744c : invokeV.intValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m267e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f71746e : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71747a;

        /* renamed from: a  reason: collision with other field name */
        public String f269a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f270a;

        /* renamed from: b  reason: collision with root package name */
        public String f71748b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f271b;

        /* renamed from: c  reason: collision with root package name */
        public String f71749c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f272c;

        /* renamed from: d  reason: collision with root package name */
        public String f71750d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f273d;

        /* renamed from: e  reason: collision with root package name */
        public String f71751e;

        /* renamed from: e  reason: collision with other field name */
        public boolean f274e;

        /* renamed from: f  reason: collision with root package name */
        public String f71752f;

        /* renamed from: f  reason: collision with other field name */
        public boolean f275f;

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
            this.f269a = "";
            this.f71748b = "";
            this.f71749c = "";
            this.f71750d = "";
            this.f71751e = "";
            this.f71752f = "";
            this.f71747a = -1;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f71747a < 0) {
                    b();
                }
                return this.f71747a;
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
                this.f270a = true;
                this.f269a = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f269a : (String) invokeV.objValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f270a : invokeV.booleanValue;
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
                this.f71747a = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        public c b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f271b = true;
                this.f71748b = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f71748b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f271b : invokeV.booleanValue;
        }

        public c c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.f272c = true;
                this.f71749c = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f71749c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m268c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f272c : invokeV.booleanValue;
        }

        public c d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.f273d = true;
                this.f71750d = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f71750d : (String) invokeV.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m269d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f273d : invokeV.booleanValue;
        }

        public c e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.f274e = true;
                this.f71751e = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f71751e : (String) invokeV.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m270e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f274e : invokeV.booleanValue;
        }

        public c f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                this.f275f = true;
                this.f71752f = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f71752f : (String) invokeV.objValue;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m271f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f275f : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71753a;

        /* renamed from: a  reason: collision with other field name */
        public String f276a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f277a;

        /* renamed from: b  reason: collision with root package name */
        public String f71754b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f278b;

        /* renamed from: c  reason: collision with root package name */
        public String f71755c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f279c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f71756d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f71757e;

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
            this.f278b = false;
            this.f276a = "";
            this.f71754b = "";
            this.f71755c = "";
            this.f71753a = -1;
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
                if (this.f71753a < 0) {
                    b();
                }
                return this.f71753a;
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
                this.f279c = true;
                this.f276a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f277a = true;
                this.f278b = z;
                return this;
            }
            return (d) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f276a : (String) invokeV.objValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f278b : invokeV.booleanValue;
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
                this.f71753a = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        public d b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f71756d = true;
                this.f71754b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f71754b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f277a : invokeV.booleanValue;
        }

        public d c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f71757e = true;
                this.f71755c = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f71755c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m272c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f279c : invokeV.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f71756d : invokeV.booleanValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f71757e : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class e extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71758a;

        /* renamed from: a  reason: collision with other field name */
        public b f280a;

        /* renamed from: a  reason: collision with other field name */
        public String f281a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f282a;

        /* renamed from: b  reason: collision with root package name */
        public int f71759b;

        /* renamed from: b  reason: collision with other field name */
        public String f283b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f284b;

        /* renamed from: c  reason: collision with root package name */
        public int f71760c;

        /* renamed from: c  reason: collision with other field name */
        public String f285c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f286c;

        /* renamed from: d  reason: collision with root package name */
        public int f71761d;

        /* renamed from: d  reason: collision with other field name */
        public String f287d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f288d;

        /* renamed from: e  reason: collision with root package name */
        public String f71762e;

        /* renamed from: e  reason: collision with other field name */
        public boolean f289e;

        /* renamed from: f  reason: collision with root package name */
        public String f71763f;

        /* renamed from: f  reason: collision with other field name */
        public boolean f290f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f71764g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f71765h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f71766i;
        public boolean j;

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
            this.f71758a = 0;
            this.f281a = "";
            this.f283b = "";
            this.f285c = "";
            this.f71759b = 0;
            this.f287d = "";
            this.f71762e = "";
            this.f71763f = "";
            this.f280a = null;
            this.f71760c = 0;
            this.f71761d = -1;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f71761d < 0) {
                    b();
                }
                return this.f71761d;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f280a : (b) invokeV.objValue;
        }

        public e a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f282a = true;
                this.f71758a = i2;
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
                    this.f71766i = true;
                    this.f280a = bVar;
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
                this.f284b = true;
                this.f281a = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f281a : (String) invokeV.objValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f282a : invokeV.booleanValue;
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
                this.f71761d = b2;
                return b2;
            }
            return invokeV.intValue;
        }

        public e b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.f289e = true;
                this.f71759b = i2;
                return this;
            }
            return (e) invokeI.objValue;
        }

        public e b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f286c = true;
                this.f283b = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f283b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f284b : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f71758a : invokeV.intValue;
        }

        public e c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                this.j = true;
                this.f71760c = i2;
                return this;
            }
            return (e) invokeI.objValue;
        }

        public e c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.f288d = true;
                this.f285c = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m273c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f285c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m274c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f286c : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f71759b : invokeV.intValue;
        }

        public e d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                this.f290f = true;
                this.f287d = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m275d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f287d : (String) invokeV.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m276d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f288d : invokeV.booleanValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f71760c : invokeV.intValue;
        }

        public e e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
                this.f71764g = true;
                this.f71762e = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m277e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f71762e : (String) invokeV.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m278e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f289e : invokeV.booleanValue;
        }

        public e f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
                this.f71765h = true;
                this.f71763f = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f71763f : (String) invokeV.objValue;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m279f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f290f : invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f71764g : invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f71765h : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f71766i : invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.j : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class f extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71767a;

        /* renamed from: a  reason: collision with other field name */
        public b f291a;

        /* renamed from: a  reason: collision with other field name */
        public String f292a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f293a;

        /* renamed from: b  reason: collision with root package name */
        public String f71768b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f294b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f71769c;

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
            this.f292a = "";
            this.f71768b = "";
            this.f291a = null;
            this.f71767a = -1;
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
                if (this.f71767a < 0) {
                    b();
                }
                return this.f71767a;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f291a : (b) invokeV.objValue;
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
                    this.f71769c = true;
                    this.f291a = bVar;
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
                this.f293a = true;
                this.f292a = str;
                return this;
            }
            return (f) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f292a : (String) invokeV.objValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f293a : invokeV.booleanValue;
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
                this.f71767a = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        public f b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.f294b = true;
                this.f71768b = str;
                return this;
            }
            return (f) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f71768b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f294b : invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f71769c : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class g extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71770a;

        /* renamed from: a  reason: collision with other field name */
        public String f295a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f296a;

        /* renamed from: b  reason: collision with root package name */
        public String f71771b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f297b;

        /* renamed from: c  reason: collision with root package name */
        public String f71772c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f298c;

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
            this.f295a = "";
            this.f71771b = "";
            this.f71772c = "";
            this.f71770a = -1;
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
                if (this.f71770a < 0) {
                    b();
                }
                return this.f71770a;
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
                this.f296a = true;
                this.f295a = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f295a : (String) invokeV.objValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f296a : invokeV.booleanValue;
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
                this.f71770a = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        public g b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f297b = true;
                this.f71771b = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f71771b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f297b : invokeV.booleanValue;
        }

        public g c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.f298c = true;
                this.f71772c = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f71772c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m280c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f298c : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class h extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71773a;

        /* renamed from: a  reason: collision with other field name */
        public String f299a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f300a;

        /* renamed from: b  reason: collision with root package name */
        public int f71774b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f301b;

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
            this.f71773a = 0;
            this.f299a = "";
            this.f71774b = -1;
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
                if (this.f71774b < 0) {
                    b();
                }
                return this.f71774b;
            }
            return invokeV.intValue;
        }

        public h a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f300a = true;
                this.f71773a = i2;
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
                this.f301b = true;
                this.f299a = str;
                return this;
            }
            return (h) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f299a : (String) invokeV.objValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f300a : invokeV.booleanValue;
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
                this.f71774b = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f301b : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f71773a : invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class i extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71775a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f302a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f303a;

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
            this.f302a = com.xiaomi.push.a.f71566a;
            this.f71775a = -1;
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
                if (this.f71775a < 0) {
                    b();
                }
                return this.f71775a;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f302a : (com.xiaomi.push.a) invokeV.objValue;
        }

        public i a(com.xiaomi.push.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.f303a = true;
                this.f302a = aVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f303a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                this.f71775a = a2;
                return a2;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class j extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71776a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f304a;

        /* renamed from: a  reason: collision with other field name */
        public b f305a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f306a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f71777b;

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
            this.f304a = com.xiaomi.push.a.f71566a;
            this.f305a = null;
            this.f71776a = -1;
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
                if (this.f71776a < 0) {
                    b();
                }
                return this.f71776a;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f304a : (com.xiaomi.push.a) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f305a : (b) invokeV.objValue;
        }

        public j a(com.xiaomi.push.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
                this.f306a = true;
                this.f304a = aVar;
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
                    this.f71777b = true;
                    this.f305a = bVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f306a : invokeV.booleanValue;
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
                this.f71776a = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f71777b : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class k extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71778a;

        /* renamed from: a  reason: collision with other field name */
        public long f307a;

        /* renamed from: a  reason: collision with other field name */
        public String f308a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f309a;

        /* renamed from: b  reason: collision with root package name */
        public int f71779b;

        /* renamed from: b  reason: collision with other field name */
        public long f310b;

        /* renamed from: b  reason: collision with other field name */
        public String f311b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f312b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f71780c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f71781d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f71782e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f71783f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f71784g;

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
            this.f308a = "";
            this.f311b = "";
            this.f307a = 0L;
            this.f310b = 0L;
            this.f71783f = false;
            this.f71778a = 0;
            this.f71779b = -1;
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
                if (this.f71779b < 0) {
                    b();
                }
                return this.f71779b;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f307a : invokeV.longValue;
        }

        public k a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f71784g = true;
                this.f71778a = i2;
                return this;
            }
            return (k) invokeI.objValue;
        }

        public k a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.f71780c = true;
                this.f307a = j;
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
                this.f309a = true;
                this.f308a = str;
                return this;
            }
            return (k) invokeL.objValue;
        }

        public k a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f71782e = true;
                this.f71783f = z;
                return this;
            }
            return (k) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f308a : (String) invokeV.objValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f309a : invokeV.booleanValue;
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
                this.f71779b = a2;
                return a2;
            }
            return invokeV.intValue;
        }

        @Override // com.xiaomi.push.e
        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f310b : invokeV.longValue;
        }

        public k b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) {
                this.f71781d = true;
                this.f310b = j;
                return this;
            }
            return (k) invokeJ.objValue;
        }

        public k b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.f312b = true;
                this.f311b = str;
                return this;
            }
            return (k) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f311b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f312b : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f71778a : invokeV.intValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m281c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f71780c : invokeV.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f71781d : invokeV.booleanValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f71783f : invokeV.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f71782e : invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f71784g : invokeV.booleanValue;
        }
    }
}
