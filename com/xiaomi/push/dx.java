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
        public long f959a;

        /* renamed from: a  reason: collision with other field name */
        public String f960a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f961a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public String f962b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f963b;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public String f964c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f965c;
        public int d;

        /* renamed from: d  reason: collision with other field name */
        public String f966d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f967d;
        public int e;

        /* renamed from: e  reason: collision with other field name */
        public String f968e;

        /* renamed from: e  reason: collision with other field name */
        public boolean f969e;
        public String f;

        /* renamed from: f  reason: collision with other field name */
        public boolean f970f;
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
            this.f959a = 0L;
            this.f960a = "";
            this.f962b = "";
            this.f964c = "";
            this.f966d = "";
            this.f968e = "";
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f959a : invokeV.longValue;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.f970f = false;
                this.f966d = "";
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.f961a = true;
                this.a = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                this.f963b = true;
                this.f959a = j;
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
                    int m1112a = bVar.m1112a();
                    switch (m1112a) {
                        case 0:
                            return this;
                        case 8:
                            a(bVar.m1121b());
                            break;
                        case 16:
                            a(bVar.m1122b());
                            break;
                        case 26:
                            a(bVar.m1115a());
                            break;
                        case 34:
                            b(bVar.m1115a());
                            break;
                        case 42:
                            c(bVar.m1115a());
                            break;
                        case 50:
                            d(bVar.m1115a());
                            break;
                        case 58:
                            e(bVar.m1115a());
                            break;
                        case 64:
                            b(bVar.m1121b());
                            break;
                        case 72:
                            c(bVar.m1121b());
                            break;
                        case 80:
                            d(bVar.m1121b());
                            break;
                        case 90:
                            f(bVar.m1115a());
                            break;
                        default:
                            if (a(bVar, m1112a)) {
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
                this.f965c = true;
                this.f960a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f960a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
                if (a()) {
                    cVar.m1156a(1, c());
                }
                if (b()) {
                    cVar.m1170b(2, a());
                }
                if (m1216c()) {
                    cVar.m1160a(3, a());
                }
                if (m1218d()) {
                    cVar.m1160a(4, b());
                }
                if (m1220e()) {
                    cVar.m1160a(5, m1215c());
                }
                if (m1222f()) {
                    cVar.m1160a(6, m1217d());
                }
                if (g()) {
                    cVar.m1160a(7, m1219e());
                }
                if (h()) {
                    cVar.m1156a(8, d());
                }
                if (i()) {
                    cVar.m1156a(9, e());
                }
                if (j()) {
                    cVar.m1156a(10, f());
                }
                if (k()) {
                    cVar.m1160a(11, m1221f());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f961a : invokeV.booleanValue;
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
                if (m1216c()) {
                    a += com.xiaomi.push.c.a(3, a());
                }
                if (m1218d()) {
                    a += com.xiaomi.push.c.a(4, b());
                }
                if (m1220e()) {
                    a += com.xiaomi.push.c.a(5, m1215c());
                }
                if (m1222f()) {
                    a += com.xiaomi.push.c.a(6, m1217d());
                }
                if (g()) {
                    a += com.xiaomi.push.c.a(7, m1219e());
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
                    a += com.xiaomi.push.c.a(11, m1221f());
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
                this.f967d = true;
                this.f962b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f962b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f963b : invokeV.booleanValue;
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
                this.f969e = true;
                this.f964c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m1215c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f964c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m1216c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f965c : invokeV.booleanValue;
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
                this.f970f = true;
                this.f966d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m1217d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f966d : (String) invokeV.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m1218d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f967d : invokeV.booleanValue;
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
                this.f968e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m1219e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f968e : (String) invokeV.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m1220e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f969e : invokeV.booleanValue;
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
        public String m1221f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f : (String) invokeV.objValue;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m1222f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f970f : invokeV.booleanValue;
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
        public boolean f971a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f972b;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f973c;
        public int d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f974d;
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
            this.f972b = false;
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
                this.f973c = true;
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
                int m1112a = bVar.m1112a();
                if (m1112a == 0) {
                    return this;
                }
                if (m1112a == 8) {
                    a(bVar.m1118a());
                } else if (m1112a == 24) {
                    a(bVar.m1121b());
                } else if (m1112a == 32) {
                    b(bVar.m1121b());
                } else if (m1112a == 40) {
                    c(bVar.m1121b());
                } else if (!a(bVar, m1112a)) {
                    return this;
                }
            }
        }

        public b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f971a = true;
                this.f972b = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                if (b()) {
                    cVar.m1161a(1, a());
                }
                if (m1223c()) {
                    cVar.m1156a(3, c());
                }
                if (m1224d()) {
                    cVar.m1156a(4, d());
                }
                if (m1225e()) {
                    cVar.m1156a(5, e());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f972b : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (m1223c()) {
                    a += com.xiaomi.push.c.a(3, c());
                }
                if (m1224d()) {
                    a += com.xiaomi.push.c.a(4, d());
                }
                if (m1225e()) {
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
                this.f974d = true;
                this.b = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f971a : invokeV.booleanValue;
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
        public boolean m1223c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f973c : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.b : invokeV.intValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m1224d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f974d : invokeV.booleanValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.c : invokeV.intValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m1225e() {
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
        public String f975a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f976a;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f977b;
        public String c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f978c;
        public String d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f979d;
        public String e;

        /* renamed from: e  reason: collision with other field name */
        public boolean f980e;
        public String f;

        /* renamed from: f  reason: collision with other field name */
        public boolean f981f;

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
            this.f975a = "";
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
                int m1112a = bVar.m1112a();
                if (m1112a == 0) {
                    return this;
                }
                if (m1112a == 10) {
                    a(bVar.m1115a());
                } else if (m1112a == 18) {
                    b(bVar.m1115a());
                } else if (m1112a == 26) {
                    c(bVar.m1115a());
                } else if (m1112a == 34) {
                    d(bVar.m1115a());
                } else if (m1112a == 42) {
                    e(bVar.m1115a());
                } else if (m1112a == 50) {
                    f(bVar.m1115a());
                } else if (!a(bVar, m1112a)) {
                    return this;
                }
            }
        }

        public c a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f976a = true;
                this.f975a = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f975a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                if (a()) {
                    cVar.m1160a(1, a());
                }
                if (b()) {
                    cVar.m1160a(2, b());
                }
                if (m1226c()) {
                    cVar.m1160a(3, c());
                }
                if (m1227d()) {
                    cVar.m1160a(4, d());
                }
                if (m1228e()) {
                    cVar.m1160a(5, e());
                }
                if (m1229f()) {
                    cVar.m1160a(6, f());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f976a : invokeV.booleanValue;
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
                if (m1226c()) {
                    a += com.xiaomi.push.c.a(3, c());
                }
                if (m1227d()) {
                    a += com.xiaomi.push.c.a(4, d());
                }
                if (m1228e()) {
                    a += com.xiaomi.push.c.a(5, e());
                }
                if (m1229f()) {
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
                this.f977b = true;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f977b : invokeV.booleanValue;
        }

        public c c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.f978c = true;
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
        public boolean m1226c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f978c : invokeV.booleanValue;
        }

        public c d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.f979d = true;
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
        public boolean m1227d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f979d : invokeV.booleanValue;
        }

        public c e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.f980e = true;
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
        public boolean m1228e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f980e : invokeV.booleanValue;
        }

        public c f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                this.f981f = true;
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
        public boolean m1229f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f981f : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public String f982a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f983a;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f984b;
        public String c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f985c;
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
            this.f984b = false;
            this.f982a = "";
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
                int m1112a = bVar.m1112a();
                if (m1112a == 0) {
                    return this;
                }
                if (m1112a == 8) {
                    a(bVar.m1118a());
                } else if (m1112a == 18) {
                    a(bVar.m1115a());
                } else if (m1112a == 26) {
                    b(bVar.m1115a());
                } else if (m1112a == 34) {
                    c(bVar.m1115a());
                } else if (!a(bVar, m1112a)) {
                    return this;
                }
            }
        }

        public d a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f985c = true;
                this.f982a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f983a = true;
                this.f984b = z;
                return this;
            }
            return (d) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f982a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                if (b()) {
                    cVar.m1161a(1, a());
                }
                if (m1230c()) {
                    cVar.m1160a(2, a());
                }
                if (d()) {
                    cVar.m1160a(3, b());
                }
                if (e()) {
                    cVar.m1160a(4, c());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f984b : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
                if (m1230c()) {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f983a : invokeV.booleanValue;
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
        public boolean m1230c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f985c : invokeV.booleanValue;
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
        public b f986a;

        /* renamed from: a  reason: collision with other field name */
        public String f987a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f988a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public String f989b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f990b;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public String f991c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f992c;
        public int d;

        /* renamed from: d  reason: collision with other field name */
        public String f993d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f994d;
        public String e;

        /* renamed from: e  reason: collision with other field name */
        public boolean f995e;
        public String f;

        /* renamed from: f  reason: collision with other field name */
        public boolean f996f;
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
            this.f987a = "";
            this.f989b = "";
            this.f991c = "";
            this.b = 0;
            this.f993d = "";
            this.e = "";
            this.f = "";
            this.f986a = null;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f986a : (b) invokeV.objValue;
        }

        public e a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.f988a = true;
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
                    int m1112a = bVar.m1112a();
                    switch (m1112a) {
                        case 0:
                            return this;
                        case 8:
                            a(bVar.c());
                            break;
                        case 18:
                            a(bVar.m1115a());
                            break;
                        case 26:
                            b(bVar.m1115a());
                            break;
                        case 34:
                            c(bVar.m1115a());
                            break;
                        case 40:
                            b(bVar.m1121b());
                            break;
                        case 50:
                            d(bVar.m1115a());
                            break;
                        case 58:
                            e(bVar.m1115a());
                            break;
                        case 66:
                            f(bVar.m1115a());
                            break;
                        case 74:
                            b bVar2 = new b();
                            bVar.a(bVar2);
                            a(bVar2);
                            break;
                        case 80:
                            c(bVar.m1121b());
                            break;
                        default:
                            if (a(bVar, m1112a)) {
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
                    this.f986a = bVar;
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
                this.f990b = true;
                this.f987a = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f987a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
                if (a()) {
                    cVar.m1169b(1, c());
                }
                if (b()) {
                    cVar.m1160a(2, a());
                }
                if (m1232c()) {
                    cVar.m1160a(3, b());
                }
                if (m1234d()) {
                    cVar.m1160a(4, m1231c());
                }
                if (m1236e()) {
                    cVar.m1156a(5, d());
                }
                if (m1237f()) {
                    cVar.m1160a(6, m1233d());
                }
                if (g()) {
                    cVar.m1160a(7, m1235e());
                }
                if (h()) {
                    cVar.m1160a(8, f());
                }
                if (i()) {
                    cVar.m1159a(9, (com.xiaomi.push.e) a());
                }
                if (j()) {
                    cVar.m1156a(10, e());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f988a : invokeV.booleanValue;
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
                if (m1232c()) {
                    b += com.xiaomi.push.c.a(3, b());
                }
                if (m1234d()) {
                    b += com.xiaomi.push.c.a(4, m1231c());
                }
                if (m1236e()) {
                    b += com.xiaomi.push.c.a(5, d());
                }
                if (m1237f()) {
                    b += com.xiaomi.push.c.a(6, m1233d());
                }
                if (g()) {
                    b += com.xiaomi.push.c.a(7, m1235e());
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
                this.f995e = true;
                this.b = i;
                return this;
            }
            return (e) invokeI.objValue;
        }

        public e b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f992c = true;
                this.f989b = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f989b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f990b : invokeV.booleanValue;
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
                this.f994d = true;
                this.f991c = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m1231c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f991c : (String) invokeV.objValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m1232c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f992c : invokeV.booleanValue;
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
                this.f996f = true;
                this.f993d = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m1233d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f993d : (String) invokeV.objValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m1234d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f994d : invokeV.booleanValue;
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
        public String m1235e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.e : (String) invokeV.objValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m1236e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f995e : invokeV.booleanValue;
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
        public boolean m1237f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f996f : invokeV.booleanValue;
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
        public b f997a;

        /* renamed from: a  reason: collision with other field name */
        public String f998a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f999a;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f1000b;
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
            this.f998a = "";
            this.b = "";
            this.f997a = null;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f997a : (b) invokeV.objValue;
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
                int m1112a = bVar.m1112a();
                if (m1112a == 0) {
                    return this;
                }
                if (m1112a == 10) {
                    a(bVar.m1115a());
                } else if (m1112a == 18) {
                    b(bVar.m1115a());
                } else if (m1112a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m1112a)) {
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
                    this.f997a = bVar;
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
                this.f999a = true;
                this.f998a = str;
                return this;
            }
            return (f) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f998a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
                if (a()) {
                    cVar.m1160a(1, a());
                }
                if (b()) {
                    cVar.m1160a(2, b());
                }
                if (c()) {
                    cVar.m1159a(3, (com.xiaomi.push.e) a());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f999a : invokeV.booleanValue;
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
                this.f1000b = true;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1000b : invokeV.booleanValue;
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
        public String f1001a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1002a;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f1003b;
        public String c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f1004c;

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
            this.f1001a = "";
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
                int m1112a = bVar.m1112a();
                if (m1112a == 0) {
                    return this;
                }
                if (m1112a == 10) {
                    a(bVar.m1115a());
                } else if (m1112a == 18) {
                    b(bVar.m1115a());
                } else if (m1112a == 26) {
                    c(bVar.m1115a());
                } else if (!a(bVar, m1112a)) {
                    return this;
                }
            }
        }

        public g a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f1002a = true;
                this.f1001a = str;
                return this;
            }
            return (g) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1001a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                if (a()) {
                    cVar.m1160a(1, a());
                }
                if (b()) {
                    cVar.m1160a(2, b());
                }
                if (m1238c()) {
                    cVar.m1160a(3, c());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1002a : invokeV.booleanValue;
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
                if (m1238c()) {
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
                this.f1003b = true;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1003b : invokeV.booleanValue;
        }

        public g c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.f1004c = true;
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
        public boolean m1238c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1004c : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class h extends com.xiaomi.push.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public String f1005a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1006a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f1007b;

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
            this.f1005a = "";
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
                this.f1006a = true;
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
                int m1112a = bVar.m1112a();
                if (m1112a == 0) {
                    return this;
                }
                if (m1112a == 8) {
                    a(bVar.m1121b());
                } else if (m1112a == 18) {
                    a(bVar.m1115a());
                } else if (!a(bVar, m1112a)) {
                    return this;
                }
            }
        }

        public h a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f1007b = true;
                this.f1005a = str;
                return this;
            }
            return (h) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1005a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                if (a()) {
                    cVar.m1156a(1, c());
                }
                if (b()) {
                    cVar.m1160a(2, a());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1006a : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f1007b : invokeV.booleanValue;
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
        public com.xiaomi.push.a f1008a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1009a;

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
            this.f1008a = com.xiaomi.push.a.a;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1008a : (com.xiaomi.push.a) invokeV.objValue;
        }

        public i a(com.xiaomi.push.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.f1009a = true;
                this.f1008a = aVar;
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
                int m1112a = bVar.m1112a();
                if (m1112a == 0) {
                    return this;
                }
                if (m1112a == 10) {
                    a(bVar.m1114a());
                } else if (!a(bVar, m1112a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) && a()) {
                cVar.m1158a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1009a : invokeV.booleanValue;
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
        public com.xiaomi.push.a f1010a;

        /* renamed from: a  reason: collision with other field name */
        public b f1011a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1012a;
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
            this.f1010a = com.xiaomi.push.a.a;
            this.f1011a = null;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1010a : (com.xiaomi.push.a) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1011a : (b) invokeV.objValue;
        }

        public j a(com.xiaomi.push.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
                this.f1012a = true;
                this.f1010a = aVar;
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
                int m1112a = bVar.m1112a();
                if (m1112a == 0) {
                    return this;
                }
                if (m1112a == 10) {
                    a(bVar.m1114a());
                } else if (m1112a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m1112a)) {
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
                    this.f1011a = bVar;
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
                    cVar.m1158a(1, a());
                }
                if (b()) {
                    cVar.m1159a(2, (com.xiaomi.push.e) a());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f1012a : invokeV.booleanValue;
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
        public long f1013a;

        /* renamed from: a  reason: collision with other field name */
        public String f1014a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1015a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public long f1016b;

        /* renamed from: b  reason: collision with other field name */
        public String f1017b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f1018b;
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
            this.f1014a = "";
            this.f1017b = "";
            this.f1013a = 0L;
            this.f1016b = 0L;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1013a : invokeV.longValue;
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
                this.f1013a = j;
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
                int m1112a = bVar.m1112a();
                if (m1112a == 0) {
                    return this;
                }
                if (m1112a == 10) {
                    a(bVar.m1115a());
                } else if (m1112a == 18) {
                    b(bVar.m1115a());
                } else if (m1112a == 24) {
                    a(bVar.m1113a());
                } else if (m1112a == 32) {
                    b(bVar.m1113a());
                } else if (m1112a == 40) {
                    a(bVar.m1118a());
                } else if (m1112a == 48) {
                    a(bVar.m1121b());
                } else if (!a(bVar, m1112a)) {
                    return this;
                }
            }
        }

        public k a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f1015a = true;
                this.f1014a = str;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f1014a : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
                if (a()) {
                    cVar.m1160a(1, a());
                }
                if (b()) {
                    cVar.m1160a(2, b());
                }
                if (m1239c()) {
                    cVar.m1157a(3, a());
                }
                if (d()) {
                    cVar.m1157a(4, b());
                }
                if (f()) {
                    cVar.m1161a(5, e());
                }
                if (g()) {
                    cVar.m1156a(6, c());
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1015a : invokeV.booleanValue;
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
                if (m1239c()) {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1016b : invokeV.longValue;
        }

        public k b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) {
                this.d = true;
                this.f1016b = j;
                return this;
            }
            return (k) invokeJ.objValue;
        }

        public k b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.f1018b = true;
                this.f1017b = str;
                return this;
            }
            return (k) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f1017b : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f1018b : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a : invokeV.intValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m1239c() {
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
