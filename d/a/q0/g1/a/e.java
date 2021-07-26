package d.a.q0.g1.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.holder.HotTopicIntervalItemHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e extends d.a.d.k.e.a<d.a.q0.g1.c.g, HotTopicIntervalItemHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotTopicActivity, bdUniqueId};
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
    @Override // d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.q0.g1.c.g gVar, HotTopicIntervalItemHolder hotTopicIntervalItemHolder) {
        i0(i2, view, viewGroup, gVar, hotTopicIntervalItemHolder);
        return view;
    }

    public final void e0(HotTopicIntervalItemHolder hotTopicIntervalItemHolder, d.a.q0.g1.c.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hotTopicIntervalItemHolder, gVar) == null) {
            if (hotTopicIntervalItemHolder != null && gVar != null && !StringUtils.isNull(gVar.f56966e)) {
                hotTopicIntervalItemHolder.f17171c.setVisibility(0);
                hotTopicIntervalItemHolder.f17171c.setText(gVar.f56966e);
            } else if (hotTopicIntervalItemHolder != null) {
                hotTopicIntervalItemHolder.f17171c.setVisibility(8);
            }
        }
    }

    public final void f0(HotTopicIntervalItemHolder hotTopicIntervalItemHolder, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, hotTopicIntervalItemHolder, view) == null) || hotTopicIntervalItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotTopicIntervalItemHolder.f17169a != skinType) {
            hotTopicIntervalItemHolder.f17169a = skinType;
            SkinManager.setBackgroundColor(hotTopicIntervalItemHolder.a(), R.color.CAM_X0201);
            SkinManager.setBackgroundColor(hotTopicIntervalItemHolder.f17170b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(hotTopicIntervalItemHolder.f17171c, R.color.CAM_X0108, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: g0 */
    public HotTopicIntervalItemHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new HotTopicIntervalItemHolder(LayoutInflater.from(this.f42341e).inflate(R.layout.hot_topic_interval, viewGroup, false)) : (HotTopicIntervalItemHolder) invokeL.objValue;
    }

    public View i0(int i2, View view, ViewGroup viewGroup, d.a.q0.g1.c.g gVar, HotTopicIntervalItemHolder hotTopicIntervalItemHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, hotTopicIntervalItemHolder})) == null) {
            if (gVar != null && hotTopicIntervalItemHolder != null) {
                f0(hotTopicIntervalItemHolder, view);
                e0(hotTopicIntervalItemHolder, gVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
