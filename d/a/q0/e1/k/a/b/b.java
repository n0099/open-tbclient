package d.a.q0.e1.k.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.d.k.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56294a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.d.k.e.a> f56295b;

    /* renamed from: c  reason: collision with root package name */
    public s f56296c;

    /* renamed from: d  reason: collision with root package name */
    public c f56297d;

    /* renamed from: e  reason: collision with root package name */
    public a f56298e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.e1.k.b.b.b f56299f;

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
        this.f56294a = tbPageContext;
        this.f56296c = sVar;
        a();
        this.f56296c.a(this.f56295b);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f56295b = new ArrayList();
            this.f56297d = new c(this.f56294a);
            this.f56298e = new a(this.f56294a);
            this.f56299f = new d.a.q0.e1.k.b.b.b(this.f56294a);
            this.f56295b.add(this.f56297d);
            this.f56295b.add(this.f56298e);
            this.f56295b.add(this.f56299f);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f56296c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f56296c.setData(list);
        }
    }
}
