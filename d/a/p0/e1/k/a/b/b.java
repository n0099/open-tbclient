package d.a.p0.e1.k.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55750a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55751b;

    /* renamed from: c  reason: collision with root package name */
    public s f55752c;

    /* renamed from: d  reason: collision with root package name */
    public c f55753d;

    /* renamed from: e  reason: collision with root package name */
    public a f55754e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.e1.k.b.b.b f55755f;

    public b(TbPageContext tbPageContext, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55750a = tbPageContext;
        this.f55752c = sVar;
        a();
        this.f55752c.a(this.f55751b);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f55751b = new ArrayList();
            this.f55753d = new c(this.f55750a);
            this.f55754e = new a(this.f55750a);
            this.f55755f = new d.a.p0.e1.k.b.b.b(this.f55750a);
            this.f55751b.add(this.f55753d);
            this.f55751b.add(this.f55754e);
            this.f55751b.add(this.f55755f);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f55752c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f55752c.setData(list);
        }
    }
}
