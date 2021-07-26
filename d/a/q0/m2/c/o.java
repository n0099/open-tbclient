package d.a.q0.m2.c;

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
/* loaded from: classes8.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f60736a;

    /* renamed from: b  reason: collision with root package name */
    public l f60737b;

    /* renamed from: c  reason: collision with root package name */
    public g f60738c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.j2.h.a f60739d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.d.k.e.a> f60740e;

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
        this.f60740e = new ArrayList();
        this.f60736a = new f(tbPageContext, d.a.q0.m2.e.o.f60895g);
        this.f60737b = new l(tbPageContext);
        this.f60738c = new g(tbPageContext, d.a.q0.m2.e.h.f60872g);
        this.f60739d = new d.a.q0.j2.h.a(tbPageContext.getPageActivity(), d.a.q0.j2.d.f59725h);
        this.f60740e.add(this.f60736a);
        this.f60740e.add(this.f60737b);
        this.f60740e.add(this.f60738c);
        this.f60740e.add(this.f60739d);
        hTypeListView.a(this.f60740e);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f60736a.g0(onClickListener);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f60738c.g0(onClickListener);
        }
    }
}
