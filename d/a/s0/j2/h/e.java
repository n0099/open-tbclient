package d.a.s0.j2.h;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.r0.t.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.k.e.a> f62368a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f62369b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f62370c;

    /* renamed from: d  reason: collision with root package name */
    public c f62371d;

    /* renamed from: e  reason: collision with root package name */
    public b f62372e;

    /* renamed from: f  reason: collision with root package name */
    public a f62373f;

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
        this.f62368a = new ArrayList();
        this.f62369b = tbPageContext;
        this.f62370c = hTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62371d = new c(this.f62369b, o.f56727h);
            this.f62372e = new b(this.f62369b, d.a.s0.j2.i.c.f62382f);
            this.f62373f = new a(this.f62369b.getPageActivity(), d.a.s0.j2.d.f62346h);
            this.f62368a.add(this.f62371d);
            this.f62368a.add(this.f62372e);
            this.f62368a.add(this.f62373f);
            this.f62370c.a(this.f62368a);
        }
    }

    public void b() {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hTypeListView = this.f62370c) != null && (hTypeListView.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.f62370c.getAdapter()).notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (hTypeListView = this.f62370c) == null) {
            return;
        }
        hTypeListView.setData(list);
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f62371d.h0(onClickListener);
            this.f62372e.h0(onClickListener);
        }
    }
}
