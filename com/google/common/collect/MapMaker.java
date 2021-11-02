package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.a;
import b.i.d.a.j;
import b.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes2.dex */
public final class MapMaker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f63455a;

    /* renamed from: b  reason: collision with root package name */
    public int f63456b;

    /* renamed from: c  reason: collision with root package name */
    public int f63457c;

    /* renamed from: d  reason: collision with root package name */
    public MapMakerInternalMap.Strength f63458d;

    /* renamed from: e  reason: collision with root package name */
    public MapMakerInternalMap.Strength f63459e;

    /* renamed from: f  reason: collision with root package name */
    public Equivalence<Object> f63460f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class Dummy {
        public static final /* synthetic */ Dummy[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Dummy VALUE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1777408222, "Lcom/google/common/collect/MapMaker$Dummy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1777408222, "Lcom/google/common/collect/MapMaker$Dummy;");
                    return;
                }
            }
            Dummy dummy = new Dummy("VALUE", 0);
            VALUE = dummy;
            $VALUES = new Dummy[]{dummy};
        }

        public Dummy(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Dummy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Dummy) Enum.valueOf(Dummy.class, str) : (Dummy) invokeL.objValue;
        }

        public static Dummy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Dummy[]) $VALUES.clone() : (Dummy[]) invokeV.objValue;
        }
    }

    public MapMaker() {
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
        this.f63456b = -1;
        this.f63457c = -1;
    }

    public MapMaker a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            n.y(this.f63457c == -1, "concurrency level was already set to %s", this.f63457c);
            n.d(i2 > 0);
            this.f63457c = i2;
            return this;
        }
        return (MapMaker) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f63457c;
            if (i2 == -1) {
                return 4;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f63456b;
            if (i2 == -1) {
                return 16;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public Equivalence<Object> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (Equivalence) j.a(this.f63460f, e().defaultEquivalence()) : (Equivalence) invokeV.objValue;
    }

    public MapMakerInternalMap.Strength e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (MapMakerInternalMap.Strength) j.a(this.f63458d, MapMakerInternalMap.Strength.STRONG) : (MapMakerInternalMap.Strength) invokeV.objValue;
    }

    public MapMakerInternalMap.Strength f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (MapMakerInternalMap.Strength) j.a(this.f63459e, MapMakerInternalMap.Strength.STRONG) : (MapMakerInternalMap.Strength) invokeV.objValue;
    }

    public MapMaker g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            n.y(this.f63456b == -1, "initial capacity was already set to %s", this.f63456b);
            n.d(i2 >= 0);
            this.f63456b = i2;
            return this;
        }
        return (MapMaker) invokeI.objValue;
    }

    public MapMaker h(Equivalence<Object> equivalence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, equivalence)) == null) {
            n.A(this.f63460f == null, "key equivalence was already set to %s", this.f63460f);
            n.p(equivalence);
            this.f63460f = equivalence;
            this.f63455a = true;
            return this;
        }
        return (MapMaker) invokeL.objValue;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!this.f63455a) {
                return new ConcurrentHashMap(c(), 0.75f, b());
            }
            return MapMakerInternalMap.create(this);
        }
        return (ConcurrentMap) invokeV.objValue;
    }

    public MapMaker j(MapMakerInternalMap.Strength strength) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, strength)) == null) {
            n.A(this.f63458d == null, "Key strength was already set to %s", this.f63458d);
            n.p(strength);
            this.f63458d = strength;
            if (strength != MapMakerInternalMap.Strength.STRONG) {
                this.f63455a = true;
            }
            return this;
        }
        return (MapMaker) invokeL.objValue;
    }

    public MapMaker k(MapMakerInternalMap.Strength strength) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, strength)) == null) {
            n.A(this.f63459e == null, "Value strength was already set to %s", this.f63459e);
            n.p(strength);
            this.f63459e = strength;
            if (strength != MapMakerInternalMap.Strength.STRONG) {
                this.f63455a = true;
            }
            return this;
        }
        return (MapMaker) invokeL.objValue;
    }

    public MapMaker l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            j(MapMakerInternalMap.Strength.WEAK);
            return this;
        }
        return (MapMaker) invokeV.objValue;
    }

    public MapMaker m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            k(MapMakerInternalMap.Strength.WEAK);
            return this;
        }
        return (MapMaker) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            j.b c2 = j.c(this);
            int i2 = this.f63456b;
            if (i2 != -1) {
                c2.b("initialCapacity", i2);
            }
            int i3 = this.f63457c;
            if (i3 != -1) {
                c2.b("concurrencyLevel", i3);
            }
            MapMakerInternalMap.Strength strength = this.f63458d;
            if (strength != null) {
                c2.d("keyStrength", a.c(strength.toString()));
            }
            MapMakerInternalMap.Strength strength2 = this.f63459e;
            if (strength2 != null) {
                c2.d("valueStrength", a.c(strength2.toString()));
            }
            if (this.f63460f != null) {
                c2.h("keyEquivalence");
            }
            return c2.toString();
        }
        return (String) invokeV.objValue;
    }
}
