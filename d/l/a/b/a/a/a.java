package d.l.a.b.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class a implements d.l.a.a.a.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f74087a;

    /* renamed from: b  reason: collision with root package name */
    public int f74088b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f74089c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f74090d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f74091e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f74092f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f74093g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f74094h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f74095i;
    public boolean j;
    public Object k;

    /* renamed from: d.l.a.b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C2045a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a f74096a;

        public C2045a() {
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
            this.f74096a = new a();
        }

        public C2045a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f74096a.f74087a = i2;
                return this;
            }
            return (C2045a) invokeI.objValue;
        }

        @Deprecated
        public C2045a b(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                this.f74096a.k = obj;
                return this;
            }
            return (C2045a) invokeL.objValue;
        }

        public C2045a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f74096a.f74089c = z;
                return this;
            }
            return (C2045a) invokeZ.objValue;
        }

        public a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f74096a : (a) invokeV.objValue;
        }

        public C2045a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f74096a.f74088b = i2;
                return this;
            }
            return (C2045a) invokeI.objValue;
        }

        public C2045a f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f74096a.f74090d = z;
                return this;
            }
            return (C2045a) invokeZ.objValue;
        }

        @Deprecated
        public C2045a g(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) ? this : (C2045a) invokeZ.objValue;
        }

        public C2045a h(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f74096a.f74091e = z;
                return this;
            }
            return (C2045a) invokeZ.objValue;
        }

        public C2045a i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.f74096a.f74092f = z;
                return this;
            }
            return (C2045a) invokeZ.objValue;
        }

        public C2045a j(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.f74096a.f74095i = z;
                return this;
            }
            return (C2045a) invokeZ.objValue;
        }

        public C2045a k(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.f74096a.j = z;
                return this;
            }
            return (C2045a) invokeZ.objValue;
        }
    }

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
        this.f74092f = true;
        this.f74094h = true;
        this.f74095i = true;
        this.j = true;
    }

    @Override // d.l.a.a.a.d.b
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f74087a : invokeV.intValue;
    }

    @Override // d.l.a.a.a.d.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f74088b : invokeV.intValue;
    }

    @Override // d.l.a.a.a.d.b
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f74089c : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.b
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f74090d : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.b
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f74092f : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f74093g : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.b
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f74094h : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.b
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f74095i : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f74088b = i2;
        }
    }

    @Override // d.l.a.a.a.d.b
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f74087a = i2;
        }
    }

    @Override // d.l.a.a.a.d.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f74094h = z;
        }
    }
}
