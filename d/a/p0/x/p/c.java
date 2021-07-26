package d.a.p0.x.p;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.d.k.d.a f54177a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.d.k.d.a f54178b;

    /* renamed from: c  reason: collision with root package name */
    public int f54179c;

    /* renamed from: d  reason: collision with root package name */
    public int f54180d;

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
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54180d : invokeV.intValue;
    }

    public abstract String b(int i2);

    public abstract int c();

    public d.a.d.k.d.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54177a : (d.a.d.k.d.a) invokeV.objValue;
    }

    public d.a.d.k.d.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f54178b : (d.a.d.k.d.a) invokeV.objValue;
    }

    public abstract String f();

    public abstract String g();

    public abstract EmotionGroupType h();

    public abstract int i();

    public abstract boolean j();

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f54179c : invokeV.intValue;
    }

    public abstract int l();

    public abstract boolean m(String str);

    public abstract d.a.d.k.d.a n(String str);

    public abstract d.a.d.k.d.a o(String str);

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f54180d = i2;
        }
    }

    public void q(d.a.d.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            if (aVar != null) {
                aVar.p();
            }
            this.f54177a = aVar;
        }
    }

    public void r(d.a.d.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            if (aVar != null) {
                aVar.p();
            }
            this.f54178b = aVar;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f54179c = i2;
        }
    }
}
