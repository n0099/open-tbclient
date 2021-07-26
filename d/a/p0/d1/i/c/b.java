package d.a.p0.d1.i.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b implements d.a.d.e.k.c<d.a.p0.d1.i.a.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f52350a;

    public b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52350a = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // d.a.d.e.k.c
    public /* bridge */ /* synthetic */ d.a.p0.d1.i.a.a a(d.a.p0.d1.i.a.a aVar) {
        d.a.p0.d1.i.a.a aVar2 = aVar;
        e(aVar2);
        return aVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // d.a.d.e.k.c
    public /* bridge */ /* synthetic */ d.a.p0.d1.i.a.a c(d.a.p0.d1.i.a.a aVar) {
        d.a.p0.d1.i.a.a aVar2 = aVar;
        i(aVar2);
        return aVar2;
    }

    public d.a.p0.d1.i.a.a e(d.a.p0.d1.i.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) ? aVar : (d.a.p0.d1.i.a.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.e.k.c
    /* renamed from: f */
    public void b(d.a.p0.d1.i.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null || aVar.b() == null) {
            return;
        }
        aVar.b().recycle();
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f52350a : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.e.k.c
    /* renamed from: h */
    public d.a.p0.d1.i.a.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new d.a.p0.d1.i.a.a(this.f52350a) : (d.a.p0.d1.i.a.a) invokeV.objValue;
    }

    public d.a.p0.d1.i.a.a i(d.a.p0.d1.i.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar)) == null) ? aVar : (d.a.p0.d1.i.a.a) invokeL.objValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f52350a = i2;
        }
    }
}
