package d.a.p0.v.e.a;

import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f64655a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f64656b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f64657c;

    /* renamed from: d  reason: collision with root package name */
    public e f64658d;

    /* renamed from: e  reason: collision with root package name */
    public h f64659e;

    public d(d.a.c.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeMultiColumnListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64656b = new ArrayList();
        this.f64655a = fVar;
        this.f64657c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f64658d = new e((TbPageContext) this.f64655a, d.a.p0.v.e.b.c.f64669f);
            this.f64659e = new h((TbPageContext) this.f64655a, d.a.p0.v.e.b.c.f64670g);
            this.f64656b.add(this.f64658d);
            this.f64656b.add(this.f64659e);
            this.f64657c.addAdapters(this.f64656b);
        }
    }

    public void b(d.a.p0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            e eVar = this.f64658d;
            if (eVar != null) {
                eVar.h0(cVar);
            }
            h hVar = this.f64659e;
            if (hVar != null) {
                hVar.h0(cVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f64657c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
