package d.a.p0.u0.m1.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.adapter.FrsVideoActivityViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class d0 extends d.a.p0.u0.k<d.a.p0.h3.q, FrsVideoActivityViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String x;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.h3.q f63102e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d0 f63103f;

        public a(d0 d0Var, d.a.p0.h3.q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63103f = d0Var;
            this.f63102e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12587").param("fid", this.f63103f.x));
                d.a.o0.r.d0.b j = d.a.o0.r.d0.b.j();
                j.w("frs_video_activity_tip" + this.f63103f.x, System.currentTimeMillis());
                d.a.p0.h3.q qVar = this.f63102e;
                if (qVar == null || StringUtils.isNull(qVar.f58178f)) {
                    return;
                }
                d.a.o0.l.a.k(this.f63103f.f41837e, this.f63102e.f58178f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
    }

    public void A0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.x = str;
        }
    }

    public final boolean x0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            if (j == 0) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j > 86400000) {
                return true;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(currentTimeMillis);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j);
            return calendar.get(7) > calendar2.get(7);
        }
        return invokeJ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: y0 */
    public FrsVideoActivityViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f41837e).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
            FrsVideoActivityViewHolder frsVideoActivityViewHolder = new FrsVideoActivityViewHolder(inflate);
            SkinManager.setViewTextColor(frsVideoActivityViewHolder.f15570a, R.color.CAM_X0105);
            SkinManager.setViewTextColor(frsVideoActivityViewHolder.f15572c, R.color.CAM_X0301);
            SkinManager.setImageResource(frsVideoActivityViewHolder.f15571b, R.drawable.icon_news_list_prompt);
            SkinManager.setImageResource(frsVideoActivityViewHolder.f15573d, R.drawable.icon_index_category_arrow_r);
            SkinManager.setBackgroundColor(frsVideoActivityViewHolder.f15574e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(frsVideoActivityViewHolder.f15575f, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
            return frsVideoActivityViewHolder;
        }
        return (FrsVideoActivityViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.u0.k, d.a.c.k.e.a
    /* renamed from: z0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.p0.h3.q qVar, FrsVideoActivityViewHolder frsVideoActivityViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, qVar, frsVideoActivityViewHolder})) == null) {
            if (view == null || frsVideoActivityViewHolder == null) {
                return null;
            }
            view.setOnClickListener(new a(this, qVar));
            frsVideoActivityViewHolder.f15570a.setText(qVar != null ? qVar.f58177e : "");
            d.a.o0.r.d0.b j = d.a.o0.r.d0.b.j();
            if (x0(j.l("frs_video_activity_tip" + this.x, 0L))) {
                frsVideoActivityViewHolder.f15571b.setVisibility(0);
            } else {
                frsVideoActivityViewHolder.f15571b.setVisibility(8);
            }
            return frsVideoActivityViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
