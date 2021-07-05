package d.a.s0.v.e.a;

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
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f67873a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f67874b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f67875c;

    /* renamed from: d  reason: collision with root package name */
    public e f67876d;

    /* renamed from: e  reason: collision with root package name */
    public h f67877e;

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
        this.f67874b = new ArrayList();
        this.f67873a = fVar;
        this.f67875c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f67876d = new e((TbPageContext) this.f67873a, d.a.s0.v.e.b.c.f67887f);
            this.f67877e = new h((TbPageContext) this.f67873a, d.a.s0.v.e.b.c.f67888g);
            this.f67874b.add(this.f67876d);
            this.f67874b.add(this.f67877e);
            this.f67875c.addAdapters(this.f67874b);
        }
    }

    public void b(d.a.s0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            e eVar = this.f67876d;
            if (eVar != null) {
                eVar.h0(cVar);
            }
            h hVar = this.f67877e;
            if (hVar != null) {
                hVar.h0(cVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f67875c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
