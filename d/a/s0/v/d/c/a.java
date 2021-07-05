package d.a.s0.v.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.s0.v.d.c.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f67505a;

    /* renamed from: b  reason: collision with root package name */
    public Context f67506b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f67507c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f67508d;

    /* renamed from: e  reason: collision with root package name */
    public d f67509e;

    /* renamed from: f  reason: collision with root package name */
    public d f67510f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.v.d.c.d.c f67511g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.v.d.c.d.b f67512h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.v.d.c.d.a f67513i;
    public int j;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67505a = tbPageContext;
        this.f67506b = tbPageContext.getPageActivity();
        this.f67507c = bdTypeRecyclerView;
        this.j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f67508d = new ArrayList();
            this.f67509e = new d(this.f67505a, this.j, false);
            this.f67510f = new d(this.f67505a, this.j, true);
            this.f67511g = new d.a.s0.v.d.c.d.c(this.f67505a);
            this.f67512h = new d.a.s0.v.d.c.d.b(this.f67505a);
            this.f67513i = new d.a.s0.v.d.c.d.a(this.f67505a);
            this.f67508d.add(this.f67509e);
            this.f67508d.add(this.f67510f);
            this.f67508d.add(this.f67511g);
            this.f67508d.add(this.f67512h);
            this.f67508d.add(this.f67513i);
            this.f67507c.a(this.f67508d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f67507c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f67507c.setData(list);
        }
    }
}
