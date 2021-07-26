package d.a.q0.v.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.q0.v.d.c.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64932a;

    /* renamed from: b  reason: collision with root package name */
    public Context f64933b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f64934c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.d.k.e.a> f64935d;

    /* renamed from: e  reason: collision with root package name */
    public d f64936e;

    /* renamed from: f  reason: collision with root package name */
    public d f64937f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.v.d.c.d.c f64938g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.v.d.c.d.b f64939h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.v.d.c.d.a f64940i;
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
        this.f64932a = tbPageContext;
        this.f64933b = tbPageContext.getPageActivity();
        this.f64934c = bdTypeRecyclerView;
        this.j = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f64935d = new ArrayList();
            this.f64936e = new d(this.f64932a, this.j, false);
            this.f64937f = new d(this.f64932a, this.j, true);
            this.f64938g = new d.a.q0.v.d.c.d.c(this.f64932a);
            this.f64939h = new d.a.q0.v.d.c.d.b(this.f64932a);
            this.f64940i = new d.a.q0.v.d.c.d.a(this.f64932a);
            this.f64935d.add(this.f64936e);
            this.f64935d.add(this.f64937f);
            this.f64935d.add(this.f64938g);
            this.f64935d.add(this.f64939h);
            this.f64935d.add(this.f64940i);
            this.f64934c.a(this.f64935d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f64934c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f64934c.setData(list);
        }
    }
}
