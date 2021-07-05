package d.a.s0.q2.n;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.k.e.n;
import d.a.s0.l2.e;
import d.a.s0.m2.c.i;
import d.a.s0.m2.c.j;
import d.a.s0.m2.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i f64978a;

    /* renamed from: b  reason: collision with root package name */
    public j f64979b;

    /* renamed from: c  reason: collision with root package name */
    public c f64980c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f64981d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f64982e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f64983f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
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
        this.f64981d = new ArrayList();
        this.f64982e = new ArrayList<>();
        this.f64983f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.f64978a = new i(tbPageContext);
            this.f64979b = new j(tbPageContext, d.a.s0.m2.e.j.f63501f);
            e eVar = new e(tbPageContext, this, tbPageContext.getUniqueId());
            this.f64980c = eVar;
            this.f64979b.h0(eVar);
            this.f64981d.add(this.f64978a);
            this.f64981d.add(this.f64979b);
            this.f64983f.a(this.f64981d);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f64983f.getAdapter2() instanceof d.a.c.k.e.e)) {
            this.f64983f.getAdapter2().notifyDataSetChanged();
        }
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = false;
            if (k.isEmpty(str)) {
                return false;
            }
            if (this.f64983f != null && (arrayList = this.f64982e) != null) {
                Iterator<n> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f14502f)) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f64982e);
                    this.f64982e = mergeDynamicThreadByTime;
                    this.f64983f.setData(mergeDynamicThreadByTime);
                    b();
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void d(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || this.f64983f == null) {
            return;
        }
        this.f64982e.clear();
        this.f64982e.addAll(arrayList);
        this.f64983f.setData(this.f64982e);
    }

    public void e() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bdTypeListView = this.f64983f) == null) {
            return;
        }
        bdTypeListView.F();
    }
}
