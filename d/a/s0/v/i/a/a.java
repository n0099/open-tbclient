package d.a.s0.v.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaInsertRecLiveHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.s0.a0.z;
import d.a.s0.h3.g;
import d.a.s0.u0.k;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends k<g, FrsPageAlaInsertRecLiveHolder> implements z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String x;
    public d.a.s0.v.i.e.a y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = "";
    }

    @Override // d.a.s0.u0.k, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        w0(i2, view, viewGroup, (g) obj, (FrsPageAlaInsertRecLiveHolder) viewHolder);
        return view;
    }

    @Override // d.a.s0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.x = str;
        }
    }

    @Override // d.a.s0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: v0 */
    public FrsPageAlaInsertRecLiveHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.o;
            if (tbPageContext == null) {
                return null;
            }
            d.a.s0.v.i.e.a aVar = new d.a.s0.v.i.e.a(tbPageContext);
            this.y = aVar;
            aVar.a(this.x);
            return new FrsPageAlaInsertRecLiveHolder(this.y);
        }
        return (FrsPageAlaInsertRecLiveHolder) invokeL.objValue;
    }

    public View w0(int i2, View view, ViewGroup viewGroup, g gVar, FrsPageAlaInsertRecLiveHolder frsPageAlaInsertRecLiveHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, frsPageAlaInsertRecLiveHolder})) == null) {
            super.X(i2, view, viewGroup, gVar, frsPageAlaInsertRecLiveHolder);
            if (gVar != null) {
                FrsViewData frsViewData = this.n;
                int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
                List<b2> list = gVar.f61192e;
                if (list != null && list.get(0) != null) {
                    gVar.f61192e.get(0).P1 = (i2 + 1) - topThreadSize;
                }
                frsPageAlaInsertRecLiveHolder.f14228a.a(this.x);
                frsPageAlaInsertRecLiveHolder.f14228a.m(gVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
