package d.a.s0.t0.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.s0.t0.a.c f65514a;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (bdTypeListView == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d.a.s0.t0.a.a(tbPageContext, d.a.s0.t0.c.a.f65543h, tbPageContext.getUniqueId()));
        d.a.s0.t0.a.c cVar = new d.a.s0.t0.a.c(tbPageContext, d.a.s0.t0.c.b.l, tbPageContext.getUniqueId());
        this.f65514a = cVar;
        arrayList.add(cVar);
        arrayList.add(new d.a.s0.t0.a.b(tbPageContext, d.a.s0.t0.c.a.f65542g, tbPageContext.getUniqueId()));
        arrayList.add(new d.a.s0.t0.a.d(tbPageContext, d.a.s0.t0.c.a.f65544i, tbPageContext.getUniqueId()));
        bdTypeListView.a(arrayList);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f65514a.h0(onClickListener);
        }
    }
}
