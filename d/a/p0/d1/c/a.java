package d.a.p0.d1.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.h3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends d.a.p0.e1.i.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.n1.p.a f54889g;

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
            }
        }
    }

    public final void a() {
        List<Object> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.f55672e) == null) {
            return;
        }
        v.e(list, 2);
    }

    public void c(d.a.p0.n1.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f54889g = aVar;
            d();
            a();
        }
    }

    public final void d() {
        d.a.p0.n1.p.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (aVar = this.f54889g) != null && aVar.d()) {
            List<ICardInfo> e2 = this.f54889g.e();
            ArrayList arrayList = new ArrayList();
            this.f55672e = arrayList;
            arrayList.addAll(e2);
            this.f54889g.a();
            this.f54889g.b();
        }
    }
}
