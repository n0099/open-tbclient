package d.a.q0.j2.j;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a0.b0;
import d.a.q0.k2.c.d;
import d.a.q0.k2.e.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f59766a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f59767b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.d.k.e.a> f59768c;

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
        this.f59768c = new ArrayList();
        this.f59767b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f59766a = dVar;
        dVar.g0(b0Var);
        this.f59768c.add(this.f59766a);
        this.f59767b.a(this.f59768c);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59766a.L();
        }
    }
}
