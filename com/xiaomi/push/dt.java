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
/* loaded from: classes7.dex */
public final class dt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f225a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f226a;

        /* renamed from: b  reason: collision with root package name */
        public int f44156b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f227b;

        /* renamed from: c  reason: collision with root package name */
        public int f44157c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f228c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f44158d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f44159e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f44160f;

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
            this.f228c = false;
            this.f44156b = 0;
            this.f44160f = false;
            this.f225a = Collections.emptyList();
            this.f44157c = -1;
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
                if (this.f44157c < 0) {
                    b();
                }
                return this.f44157c;
            }
            return invokeV.intValue;
        }

        public a a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.f226a = true;
                this.a = i;
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
                int m199a = bVar.m199a();
                if (m199a == 0) {
                    return this;
                }
                if (m199a == 8) {
                    a(bVar.c());
                } else if (m199a == 16) {
                    a(bVar.m205a());
                } else if (m199a == 24) {
                    b(bVar.m208b());
                } else if (m199a == 32) {
                    b(bVar.m205a());
                } else if (m199a == 42) {
                    a(bVar.m202a());
                } else if (!a(bVar, m199a)) {
                    return this;
                }
            }
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (str != null) {
                    if (this.f225a.isEmpty()) {
                        this.f225a = new ArrayList();
                    }
                    this.f225a.add(str);
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
                this.f227b = true;
                this.f228c = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public List<String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f225a : (List) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
                if (a()) {
                    cVar.m250b(1, c());
                }
                if (m293c()) {
                    cVar.m242a(2, b());
                }
                if (m294d()) {
                    cVar.m237a(3, d());
                }
                if (f()) {
                    cVar.m242a(4, m295e());
                }
                for (String str : a()) {
                    cVar.m241a(5, str);
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f226a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                int i = 0;
                int b2 = a() ? c.b(1, c()) + 0 : 0;
                if (m293c()) {
                    b2 += c.a(2, b());
                }
                if (m294d()) {
                    b2 += c.a(3, d());
                }
                if (f()) {
                    b2 += c.a(4, m295e());
                }
                for (String str : a()) {
                    i += c.a(str);
                }
                int size = b2 + i + (a().size() * 1);
                this.f44157c = size;
                return size;
            }
            return invokeV.intValue;
        }

        public a b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                this.f44158d = true;
                this.f44156b = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.f44159e = true;
                this.f44160f = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f228c : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : invokeV.intValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m293c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f227b : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f44156b : invokeV.intValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m294d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f44158d : invokeV.booleanValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f225a.size() : invokeV.intValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m295e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f44160f : invokeV.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f44159e : invokeV.booleanValue;
        }
    }
}
