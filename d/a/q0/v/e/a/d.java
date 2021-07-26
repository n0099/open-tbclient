package d.a.q0.v.e.a;

import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.d.a.f f65300a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.d.k.e.a> f65301b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f65302c;

    /* renamed from: d  reason: collision with root package name */
    public e f65303d;

    /* renamed from: e  reason: collision with root package name */
    public h f65304e;

    public d(d.a.d.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
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
        this.f65301b = new ArrayList();
        this.f65300a = fVar;
        this.f65302c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f65303d = new e((TbPageContext) this.f65300a, d.a.q0.v.e.b.c.f65314f);
            this.f65304e = new h((TbPageContext) this.f65300a, d.a.q0.v.e.b.c.f65315g);
            this.f65301b.add(this.f65303d);
            this.f65301b.add(this.f65304e);
            this.f65302c.addAdapters(this.f65301b);
        }
    }

    public void b(d.a.q0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            e eVar = this.f65303d;
            if (eVar != null) {
                eVar.g0(cVar);
            }
            h hVar = this.f65304e;
            if (hVar != null) {
                hVar.g0(cVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f65302c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
