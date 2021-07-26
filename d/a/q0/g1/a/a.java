package d.a.q0.g1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.q0.g1.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f56843a;

    /* renamed from: b  reason: collision with root package name */
    public c f56844b;

    /* renamed from: c  reason: collision with root package name */
    public b f56845c;

    /* renamed from: d  reason: collision with root package name */
    public k f56846d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.d.k.e.a> f56847e;

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotRanklistActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56847e = new ArrayList();
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotRanklistActivity, bdTypeListView) == null) {
            this.f56844b = new c(hotRanklistActivity, d.a.q0.g1.c.c.m);
            this.f56845c = new b(hotRanklistActivity, d.a.q0.g1.c.b.j);
            this.f56846d = new k(hotRanklistActivity, o.k);
            this.f56847e.add(this.f56844b);
            this.f56847e.add(this.f56845c);
            this.f56847e.add(this.f56846d);
            this.f56843a = bdTypeListView;
            bdTypeListView.a(this.f56847e);
        }
    }

    public void b(d.a.q0.g1.c.j jVar, String str) {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, str) == null) {
            if (jVar.b() != null) {
                arrayList = jVar.b();
            } else {
                arrayList = new ArrayList<>();
            }
            k kVar = this.f56846d;
            if (kVar != null) {
                kVar.D0();
            }
            c cVar = this.f56844b;
            if (cVar != null) {
                cVar.m0(str);
            }
            BdTypeListView bdTypeListView = this.f56843a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
