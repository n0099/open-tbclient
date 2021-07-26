package d.a.q0.j2.h;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.p0.u.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.d.k.e.a> f59747a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f59748b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f59749c;

    /* renamed from: d  reason: collision with root package name */
    public c f59750d;

    /* renamed from: e  reason: collision with root package name */
    public b f59751e;

    /* renamed from: f  reason: collision with root package name */
    public a f59752f;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59747a = new ArrayList();
        this.f59748b = tbPageContext;
        this.f59749c = hTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59750d = new c(this.f59748b, m.f54117h);
            this.f59751e = new b(this.f59748b, d.a.q0.j2.i.c.f59761f);
            this.f59752f = new a(this.f59748b.getPageActivity(), d.a.q0.j2.d.f59725h);
            this.f59747a.add(this.f59750d);
            this.f59747a.add(this.f59751e);
            this.f59747a.add(this.f59752f);
            this.f59749c.a(this.f59747a);
        }
    }

    public void b() {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hTypeListView = this.f59749c) != null && (hTypeListView.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.f59749c.getAdapter()).notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (hTypeListView = this.f59749c) == null) {
            return;
        }
        hTypeListView.setData(list);
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f59750d.g0(onClickListener);
            this.f59751e.g0(onClickListener);
        }
    }
}
