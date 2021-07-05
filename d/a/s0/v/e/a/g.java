package d.a.s0.v.e.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f67878a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f67879b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f67880c;

    /* renamed from: d  reason: collision with root package name */
    public f f67881d;

    /* renamed from: e  reason: collision with root package name */
    public c f67882e;

    /* renamed from: f  reason: collision with root package name */
    public a f67883f;

    /* renamed from: g  reason: collision with root package name */
    public b f67884g;

    public g(d.a.c.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67880c = new ArrayList();
        this.f67878a = fVar;
        this.f67879b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.f67878a, d.a.s0.v.h.b.a.f67983g);
                this.f67882e = cVar;
                this.f67880c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.f67878a, d.a.s0.v.h.b.a.f67983g);
                this.f67881d = fVar;
                this.f67880c.add(fVar);
            }
            this.f67883f = new a((TbPageContext) this.f67878a, d.a.s0.v.e.b.a.f67885e);
            this.f67884g = new b((TbPageContext) this.f67878a, d.a.s0.v.e.b.b.f67886e);
            this.f67880c.add(this.f67883f);
            this.f67880c.add(this.f67884g);
            this.f67879b.a(this.f67880c);
        }
    }

    public void b(d.a.s0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            f fVar = this.f67881d;
            if (fVar != null) {
                fVar.h0(cVar);
            }
            c cVar2 = this.f67882e;
            if (cVar2 != null) {
                cVar2.h0(cVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f67879b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
