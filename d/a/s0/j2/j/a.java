package d.a.s0.j2.j;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.a0.b0;
import d.a.s0.k2.c.d;
import d.a.s0.k2.e.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f62387a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f62388b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62389c;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b0<h> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, b0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62389c = new ArrayList();
        this.f62388b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f62387a = dVar;
        dVar.h0(b0Var);
        this.f62389c.add(this.f62387a);
        this.f62388b.a(this.f62389c);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62387a.L();
        }
    }
}
