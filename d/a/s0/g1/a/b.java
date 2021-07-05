package d.a.s0.g1.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.holder.HotRankListManualItemHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes9.dex */
public class b extends d.a.c.k.e.a<d.a.s0.g1.c.b, HotRankListManualItemHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.g1.c.b f59562e;

        public a(b bVar, d.a.s0.g1.c.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59562e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(this.f59562e.b()), this.f59562e.d(), "5")));
                StatisticItem statisticItem = new StatisticItem("c10811");
                TiebaStatic.log(statisticItem.param("obj_name", "" + this.f59562e.d()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotRanklistActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.s0.g1.c.b bVar, HotRankListManualItemHolder hotRankListManualItemHolder) {
        i0(i2, view, viewGroup, bVar, hotRankListManualItemHolder);
        return view;
    }

    public final void f0(HotRankListManualItemHolder hotRankListManualItemHolder, d.a.s0.g1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hotRankListManualItemHolder, bVar) == null) || hotRankListManualItemHolder == null || bVar == null) {
            return;
        }
        String string = StringUtils.isNull(bVar.c()) ? this.f44821e.getResources().getString(R.string.hot_topic_hot_trend) : bVar.c();
        hotRankListManualItemHolder.f17060d.setText(bVar.e());
        hotRankListManualItemHolder.f17058b.setText(string);
        hotRankListManualItemHolder.f17063g.M(bVar.h(), 10, false);
        if (StringUtils.isNull(bVar.d())) {
            hotRankListManualItemHolder.f17059c.setVisibility(8);
            hotRankListManualItemHolder.f17060d.setPadding(0, 0, 0, 0);
        } else {
            hotRankListManualItemHolder.f17059c.setVisibility(0);
            hotRankListManualItemHolder.f17059c.setText(bVar.d());
        }
        hotRankListManualItemHolder.f17064h.setOnClickListener(new a(this, bVar));
    }

    public final void g0(HotRankListManualItemHolder hotRankListManualItemHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hotRankListManualItemHolder) == null) || hotRankListManualItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotRankListManualItemHolder.f17057a != skinType) {
            hotRankListManualItemHolder.f17057a = skinType;
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f17058b, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f17059c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.f17060d, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.f17061e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.f17062f, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(hotRankListManualItemHolder.f17064h, R.drawable.hot_topic_ranklist_bg);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public HotRankListManualItemHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new HotRankListManualItemHolder(LayoutInflater.from(this.f44821e).inflate(R.layout.hot_topic_ranklist_head, viewGroup, false)) : (HotRankListManualItemHolder) invokeL.objValue;
    }

    public View i0(int i2, View view, ViewGroup viewGroup, d.a.s0.g1.c.b bVar, HotRankListManualItemHolder hotRankListManualItemHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, hotRankListManualItemHolder})) == null) {
            if (bVar != null) {
                g0(hotRankListManualItemHolder);
                f0(hotRankListManualItemHolder, bVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
