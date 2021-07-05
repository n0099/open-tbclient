package d.a.s0.m2.c;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f63359a;

    /* renamed from: b  reason: collision with root package name */
    public l f63360b;

    /* renamed from: c  reason: collision with root package name */
    public g f63361c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.j2.h.a f63362d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f63363e;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
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
        this.f63363e = new ArrayList();
        this.f63359a = new f(tbPageContext, d.a.s0.m2.e.o.f63518g);
        this.f63360b = new l(tbPageContext);
        this.f63361c = new g(tbPageContext, d.a.s0.m2.e.h.f63495g);
        this.f63362d = new d.a.s0.j2.h.a(tbPageContext.getPageActivity(), d.a.s0.j2.d.f62346h);
        this.f63363e.add(this.f63359a);
        this.f63363e.add(this.f63360b);
        this.f63363e.add(this.f63361c);
        this.f63363e.add(this.f63362d);
        hTypeListView.a(this.f63363e);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f63359a.h0(onClickListener);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f63361c.h0(onClickListener);
        }
    }
}
