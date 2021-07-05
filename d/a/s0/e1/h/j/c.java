package d.a.s0.e1.h.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.a0.e0.o;
import tbclient.Personalized.Resource;
/* loaded from: classes9.dex */
public class c extends o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    public void c(Resource resource) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, resource) == null) || resource == null) {
            return;
        }
        this.f57081e = resource.res_id.longValue();
        this.f57082f = resource.user_name;
        this.f57083g = resource.user_image;
        this.f57084h = resource.user_link;
        this.f57085i = resource.res_title;
        this.j = resource.res_image;
        this.k = resource.res_link;
        this.l = resource.position.longValue();
        this.m = resource.icon_text;
    }
}
