package d.a.s0.u0.v1;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.k.e.n;
import d.a.s0.u0.v1.a;
import d.a.s0.u0.v1.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f67100a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f67101b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f67102c;

    /* renamed from: d  reason: collision with root package name */
    public a f67103d;

    public b(f fVar, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67102c = new ArrayList();
        this.f67100a = fVar;
        this.f67101b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = new a((TbPageContext) this.f67100a, d.l);
            this.f67103d = aVar;
            this.f67102c.add(aVar);
            this.f67101b.a(this.f67102c);
        }
    }

    public void b(a.InterfaceC1772a interfaceC1772a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1772a) == null) {
            this.f67103d.h0(interfaceC1772a);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f67101b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
