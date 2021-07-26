package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class dt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f40259a;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f244a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f245a;

        /* renamed from: b  reason: collision with root package name */
        public int f40260b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f246b;

        /* renamed from: c  reason: collision with root package name */
        public int f40261c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f247c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f40262d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f40263e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f40264f;

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
            this.f40259a = 0;
            this.f247c = false;
            this.f40260b = 0;
            this.f40264f = false;
            this.f244a = Collections.emptyList();
            this.f40261c = -1;
        }

        public static a a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? (a) new a().a(bArr) : (a) invokeL.objValue;
        }

        public static a b(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) ? new a().a(bVar) : (a) invokeL.objValue;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f40261c < 0) {
                    b();
                }
                return this.f40261c;
            }
            return invokeV.intValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f245a = true;
                this.f40259a = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) != null) {
                return (a) invokeL.objValue;
            }
            while (true) {
                int m157a = bVar.m157a();
                if (m157a == 0) {
                    return this;
                }
                if (m157a == 8) {
                    a(bVar.c());
                } else if (m157a == 16) {
                    a(bVar.m163a());
                } else if (m157a == 24) {
                    b(bVar.m166b());
                } else if (m157a == 32) {
                    b(bVar.m163a());
                } else if (m157a == 42) {
                    a(bVar.m160a());
                } else if (!a(bVar, m157a)) {
                    return this;
                }
            }
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (str != null) {
                    if (this.f244a.isEmpty()) {
                        this.f244a = new ArrayList();
                    }
                    this.f244a.add(str);
                    return this;
                }
                throw null;
            }
            return (a) invokeL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f246b = true;
                this.f247c = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public List<String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f244a : (List) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
                if (a()) {
                    cVar.m208b(1, c());
                }
                if (m251c()) {
                    cVar.m200a(2, b());
                }
                if (m252d()) {
                    cVar.m195a(3, d());
                }
                if (f()) {
                    cVar.m200a(4, m253e());
                }
                for (String str : a()) {
                    cVar.m199a(5, str);
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f245a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                int i2 = 0;
                int b2 = a() ? c.b(1, c()) + 0 : 0;
                if (m251c()) {
                    b2 += c.a(2, b());
                }
                if (m252d()) {
                    b2 += c.a(3, d());
                }
                if (f()) {
                    b2 += c.a(4, m253e());
                }
                for (String str : a()) {
                    i2 += c.a(str);
                }
                int size = b2 + i2 + (a().size() * 1);
                this.f40261c = size;
                return size;
            }
            return invokeV.intValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.f40262d = true;
                this.f40260b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.f40263e = true;
                this.f40264f = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f247c : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f40259a : invokeV.intValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m251c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f246b : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f40260b : invokeV.intValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m252d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f40262d : invokeV.booleanValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f244a.size() : invokeV.intValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m253e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f40264f : invokeV.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f40263e : invokeV.booleanValue;
        }
    }
}
