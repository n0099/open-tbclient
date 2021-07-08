package d.a.n0.m.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.m.f.a;
/* loaded from: classes7.dex */
public class a extends a.C1143a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {abstractHttpManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((AbstractHttpManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.m.f.a.C1143a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: a */
    public d.a.n0.m.f.a build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.a.n0.m.b.b().j(this.httpUrl.toString(), this);
            requestFrom(6);
            return super.build();
        }
        return (d.a.n0.m.f.a) invokeV.objValue;
    }
}
