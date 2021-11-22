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
/* loaded from: classes2.dex */
public final class dt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71727a;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f249a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f250a;

        /* renamed from: b  reason: collision with root package name */
        public int f71728b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f251b;

        /* renamed from: c  reason: collision with root package name */
        public int f71729c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f252c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f71730d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f71731e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f71732f;

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
            this.f71727a = 0;
            this.f252c = false;
            this.f71728b = 0;
            this.f71732f = false;
            this.f249a = Collections.emptyList();
            this.f71729c = -1;
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
                if (this.f71729c < 0) {
                    b();
                }
                return this.f71729c;
            }
            return invokeV.intValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f250a = true;
                this.f71727a = i2;
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
                int m160a = bVar.m160a();
                if (m160a == 0) {
                    return this;
                }
                if (m160a == 8) {
                    a(bVar.c());
                } else if (m160a == 16) {
                    a(bVar.m166a());
                } else if (m160a == 24) {
                    b(bVar.m169b());
                } else if (m160a == 32) {
                    b(bVar.m166a());
                } else if (m160a == 42) {
                    a(bVar.m163a());
                } else if (!a(bVar, m160a)) {
                    return this;
                }
            }
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (str != null) {
                    if (this.f249a.isEmpty()) {
                        this.f249a = new ArrayList();
                    }
                    this.f249a.add(str);
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
                this.f251b = true;
                this.f252c = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public List<String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f249a : (List) invokeV.objValue;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
                if (a()) {
                    cVar.m211b(1, c());
                }
                if (m254c()) {
                    cVar.m203a(2, b());
                }
                if (m255d()) {
                    cVar.m198a(3, d());
                }
                if (f()) {
                    cVar.m203a(4, m256e());
                }
                for (String str : a()) {
                    cVar.m202a(5, str);
                }
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f250a : invokeV.booleanValue;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                int i2 = 0;
                int b2 = a() ? c.b(1, c()) + 0 : 0;
                if (m254c()) {
                    b2 += c.a(2, b());
                }
                if (m255d()) {
                    b2 += c.a(3, d());
                }
                if (f()) {
                    b2 += c.a(4, m256e());
                }
                for (String str : a()) {
                    i2 += c.a(str);
                }
                int size = b2 + i2 + (a().size() * 1);
                this.f71729c = size;
                return size;
            }
            return invokeV.intValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.f71730d = true;
                this.f71728b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.f71731e = true;
                this.f71732f = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f252c : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f71727a : invokeV.intValue;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m254c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f251b : invokeV.booleanValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f71728b : invokeV.intValue;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m255d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f71730d : invokeV.booleanValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f249a.size() : invokeV.intValue;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m256e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f71732f : invokeV.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f71731e : invokeV.booleanValue;
        }
    }
}
