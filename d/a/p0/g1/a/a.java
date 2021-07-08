package d.a.p0.g1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.p0.g1.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f56299a;

    /* renamed from: b  reason: collision with root package name */
    public c f56300b;

    /* renamed from: c  reason: collision with root package name */
    public b f56301c;

    /* renamed from: d  reason: collision with root package name */
    public k f56302d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f56303e;

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
        this.f56303e = new ArrayList();
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hotRanklistActivity, bdTypeListView) == null) {
            this.f56300b = new c(hotRanklistActivity, d.a.p0.g1.c.c.m);
            this.f56301c = new b(hotRanklistActivity, d.a.p0.g1.c.b.j);
            this.f56302d = new k(hotRanklistActivity, o.k);
            this.f56303e.add(this.f56300b);
            this.f56303e.add(this.f56301c);
            this.f56303e.add(this.f56302d);
            this.f56299a = bdTypeListView;
            bdTypeListView.a(this.f56303e);
        }
    }

    public void b(d.a.p0.g1.c.j jVar, String str) {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, str) == null) {
            if (jVar.b() != null) {
                arrayList = jVar.b();
            } else {
                arrayList = new ArrayList<>();
            }
            k kVar = this.f56302d;
            if (kVar != null) {
                kVar.D0();
            }
            c cVar = this.f56300b;
            if (cVar != null) {
                cVar.m0(str);
            }
            BdTypeListView bdTypeListView = this.f56299a;
            if (bdTypeListView != null) {
                bdTypeListView.setData(arrayList);
            }
        }
    }
}
