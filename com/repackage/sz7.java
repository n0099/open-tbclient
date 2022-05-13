package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatEnterForumViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sz7 extends eo<vs7, VideoTabPbFloatEnterForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz7 a;

        public a(sz7 sz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.i instanceof VideoPbCommentFloatFragment)) {
                VideoPbCommentFloatFragment videoPbCommentFloatFragment = (VideoPbCommentFloatFragment) this.a.i;
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", videoPbCommentFloatFragment.v().getForumId());
                statisticItem.param("tid", videoPbCommentFloatFragment.v().h2());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", videoPbCommentFloatFragment.v().n1());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 16);
                statisticItem.param("obj_locate", videoPbCommentFloatFragment.V2());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz7(Context context, BdUniqueId bdUniqueId, BaseFragment baseFragment) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, baseFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = baseFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, vs7 vs7Var, VideoTabPbFloatEnterForumViewHolder videoTabPbFloatEnterForumViewHolder) {
        b0(i, view2, viewGroup, vs7Var, videoTabPbFloatEnterForumViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: a0 */
    public VideoTabPbFloatEnterForumViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.a);
            FlowLabelLayout flowLabelLayout = new FlowLabelLayout(this.a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = mi.f(this.a, R.dimen.tbds156);
            layoutParams.topMargin = mi.f(this.a, R.dimen.M_H_X003);
            layoutParams.rightMargin = mi.f(this.a, R.dimen.M_W_X007);
            layoutParams.bottomMargin = mi.f(this.a, R.dimen.M_H_X005);
            frameLayout.addView(flowLabelLayout, layoutParams);
            return new VideoTabPbFloatEnterForumViewHolder(this.a, frameLayout);
        }
        return (VideoTabPbFloatEnterForumViewHolder) invokeL.objValue;
    }

    public View b0(int i, View view2, ViewGroup viewGroup, vs7 vs7Var, VideoTabPbFloatEnterForumViewHolder videoTabPbFloatEnterForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vs7Var, videoTabPbFloatEnterForumViewHolder})) == null) {
            if (vs7Var != null) {
                videoTabPbFloatEnterForumViewHolder.setData(vs7Var.a);
                videoTabPbFloatEnterForumViewHolder.d(new a(this));
            }
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
            videoTabPbFloatEnterForumViewHolder.c();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
