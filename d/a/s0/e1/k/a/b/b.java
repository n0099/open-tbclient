package d.a.s0.e1.k.a.b;

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
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59005a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f59006b;

    /* renamed from: c  reason: collision with root package name */
    public s f59007c;

    /* renamed from: d  reason: collision with root package name */
    public c f59008d;

    /* renamed from: e  reason: collision with root package name */
    public a f59009e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.e1.k.b.b.b f59010f;

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
        this.f59005a = tbPageContext;
        this.f59007c = sVar;
        a();
        this.f59007c.a(this.f59006b);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59006b = new ArrayList();
            this.f59008d = new c(this.f59005a);
            this.f59009e = new a(this.f59005a);
            this.f59010f = new d.a.s0.e1.k.b.b.b(this.f59005a);
            this.f59006b.add(this.f59008d);
            this.f59006b.add(this.f59009e);
            this.f59006b.add(this.f59010f);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f59007c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f59007c.setData(list);
        }
    }
}
