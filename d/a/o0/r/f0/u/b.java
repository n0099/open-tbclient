package d.a.o0.r.f0.u;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
/* loaded from: classes7.dex */
public abstract class b<T extends n, V extends BdBaseViewPagerAdapter.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f52433a;

    /* renamed from: b  reason: collision with root package name */
    public a<T, V> f52434b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f52435c;

    /* loaded from: classes7.dex */
    public interface a<T extends n, V extends BdBaseViewPagerAdapter.a> {
        void a(V v, T t);
    }

    public b(Context context, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52433a = context;
        this.f52435c = bdUniqueId;
    }

    public a<T, V> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52434b : (a) invokeV.objValue;
    }

    public BdUniqueId b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52435c : (BdUniqueId) invokeV.objValue;
    }

    public abstract V c(ViewGroup viewGroup);

    public void d(V v, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, v, t) == null) {
        }
    }

    public abstract View e(ViewGroup viewGroup, V v, T t);

    public void f(a<T, V> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f52434b = aVar;
        }
    }
}
