package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatUserInfoViewHolder;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class tz7 extends eo<PostData, VideoTabPbFloatUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment i;
    public bs7 j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public cw7 o;
    public boolean p;
    public boolean q;
    public boolean r;
    public String s;
    public View.OnClickListener t;
    public CustomMessageListener u;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz7 a;

        public a(tz7 tz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0923bf) {
                    if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str = view2.getTag() != null ? (String) view2.getTag() : null;
                        if (str != null) {
                            UrlManager.getInstance().dealOneLink(this.a.i.getPageContext(), new String[]{str});
                        }
                        TiebaStatic.eventStat(this.a.i.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0923ba) {
                    if (view2.getTag(R.id.obfuscated_res_0x7f091efc) instanceof String) {
                        fm4.q(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14d7), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view2.getTag(R.id.obfuscated_res_0x7f091efc)) + "&opacity=0", true, true, true);
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0923ad) {
                    HeadImageView headView = ((HeadPendantClickableView) view2).getHeadView();
                    String userId = headView.getUserId();
                    String userName = headView.getUserName();
                    String fid = headView.getFid();
                    String tid = headView.getTid();
                    String fName = headView.getFName();
                    int floor = headView.getFloor();
                    AlaInfoData alaInfo = headView.getAlaInfo();
                    int liveStatus = headView.getLiveStatus();
                    if (alaInfo != null && (liveStatus == 1 || alaInfo.live_status == 1)) {
                        if (alaInfo.isLegalYYLiveData()) {
                            YYLiveUtil.jumpYYLiveRoom(this.a.i.getPageContext(), alaInfo, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        }
                        StatisticItem statisticItem = new StatisticItem("c13715");
                        statisticItem.param("fid", fid);
                        statisticItem.param("fname", fName);
                        AlaUserInfoData alaUserInfoData = alaInfo.user_info;
                        statisticItem.param("obj_param1", alaUserInfoData != null ? alaUserInfoData.user_id : 0L);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("tid", tid);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, floor);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(alaInfo));
                        if (alaInfo.mYyExtData != null) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                            TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    StatisticItem statisticItem2 = new StatisticItem("c13267");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("fid", fid);
                    statisticItem2.param("tid", tid);
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0923b9) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    String str2 = view2.getTag(R.id.obfuscated_res_0x7f091efc) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f091efc) : null;
                    String str3 = view2.getTag(R.id.obfuscated_res_0x7f091f04) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f091f04) : null;
                    String name = (this.a.j == null || this.a.j.l() == null) ? null : this.a.j.l().getName();
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", str2);
                    if (this.a.j != null) {
                        statisticItem3.param("fid", this.a.j.m());
                        statisticItem3.param("tid", this.a.j.Q());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str2 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a, str2, str3, name, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0923a8 && (this.a.i instanceof VideoPbCommentFloatFragment)) {
                    StatisticItem statisticItem4 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem4.param("fid", this.a.j.m());
                    statisticItem4.param("tid", this.a.j.Q());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("post_id", this.a.j.j().I());
                    statisticItem4.param("obj_source", 1);
                    statisticItem4.param("obj_type", 15);
                    statisticItem4.param("obj_locate", ((VideoPbCommentFloatFragment) this.a.i).V2());
                    TiebaStatic.log(statisticItem4);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(tz7 tz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.g == null || ((VideoTabPbFloatUserInfoViewHolder) this.a.g).o == null) {
                return;
            }
            ((VideoTabPbFloatUserInfoViewHolder) this.a.g).o.setTextSize(TbConfig.getContentSize());
            this.a.H();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tz7(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bdUniqueId};
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
        this.s = null;
        this.t = new a(this);
        b bVar = new b(this, 2004018);
        this.u = bVar;
        this.i = baseFragment;
        baseFragment.registerListener(bVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, PostData postData, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        n0(i, view2, viewGroup, postData, videoTabPbFloatUserInfoViewHolder);
        return view2;
    }

    public final void g0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (bs7Var = this.j) == null || bs7Var.O() == null || this.j.O().getAuthor() == null || postData == null) {
            return;
        }
        u0(videoTabPbFloatUserInfoViewHolder, this.j.O().getAuthor(), postData);
        z0(videoTabPbFloatUserInfoViewHolder, this.j.O().getAuthor());
        x0(videoTabPbFloatUserInfoViewHolder, this.j.O().getAuthor());
        r0(videoTabPbFloatUserInfoViewHolder.h, postData);
        t0(videoTabPbFloatUserInfoViewHolder, postData);
        y0(videoTabPbFloatUserInfoViewHolder, this.j.O().getAuthor());
        q0(videoTabPbFloatUserInfoViewHolder, this.j.O().getAuthor());
        w0(videoTabPbFloatUserInfoViewHolder, this.j.O().getAuthor(), postData);
        v0(videoTabPbFloatUserInfoViewHolder, this.j.O().getAuthor());
    }

    public final void h0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (bs7Var = this.j) == null || bs7Var.O() == null || postData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.o(this.j.O().getRichTitle(), this.j.O().getTitle(), this.j.O(), k0(postData), this.j.s0());
        videoTabPbFloatUserInfoViewHolder.n(this.a, postData);
    }

    public final void i0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, videoTabPbFloatUserInfoViewHolder, postData) == null) {
            videoTabPbFloatUserInfoViewHolder.m(8, null);
            bs7 bs7Var = this.j;
            if (bs7Var == null || bs7Var.O() == null || postData == null) {
                return;
            }
            if (postData.Q) {
                videoTabPbFloatUserInfoViewHolder.m(0, postData.I());
            }
            BaseFragment baseFragment = this.i;
            if (baseFragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) baseFragment).d5(postData.Q);
            }
        }
    }

    public final int j0(bs7 bs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bs7Var)) == null) {
            if (bs7Var == null || bs7Var.O() == null) {
                return 0;
            }
            if (bs7Var.O().isMutiForumThread()) {
                return (ListUtils.isEmpty(bs7Var.p()) && (bs7Var.h() == null || StringUtils.isNull(bs7Var.h().a()))) ? 0 : 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final boolean k0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, postData)) == null) ? postData != null && ListUtils.getCount(postData.m0) >= 2 : invokeL.booleanValue;
    }

    public void l0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, videoTabPbFloatUserInfoViewHolder) == null) || videoTabPbFloatUserInfoViewHolder == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.h(this.k);
        videoTabPbFloatUserInfoViewHolder.k(this.p || this.q || this.r);
        videoTabPbFloatUserInfoViewHolder.j(this.l, this.n, this.m);
        videoTabPbFloatUserInfoViewHolder.i();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: m0 */
    public VideoTabPbFloatUserInfoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0682, viewGroup, false);
            Context context = this.a;
            BaseFragment baseFragment = this.i;
            VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder = new VideoTabPbFloatUserInfoViewHolder(context, inflate, baseFragment instanceof AbsVideoPbFragment ? (AbsVideoPbFragment) baseFragment : null);
            videoTabPbFloatUserInfoViewHolder.l(this.t);
            l0(videoTabPbFloatUserInfoViewHolder);
            this.g = videoTabPbFloatUserInfoViewHolder;
            return videoTabPbFloatUserInfoViewHolder;
        }
        return (VideoTabPbFloatUserInfoViewHolder) invokeL.objValue;
    }

    public View n0(int i, View view2, ViewGroup viewGroup, PostData postData, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postData, videoTabPbFloatUserInfoViewHolder})) == null) {
            bs7 bs7Var = this.j;
            if (bs7Var != null && bs7Var.O() != null && postData != null) {
                vy7.d(this.i.getUniqueId(), this.j, postData, 1, 1);
                s0(videoTabPbFloatUserInfoViewHolder);
                g0(videoTabPbFloatUserInfoViewHolder, postData);
                h0(videoTabPbFloatUserInfoViewHolder, postData);
                i0(videoTabPbFloatUserInfoViewHolder, postData);
                l0(videoTabPbFloatUserInfoViewHolder);
                videoTabPbFloatUserInfoViewHolder.q.setVisibility(8);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void o0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postData) == null) || postData == null || postData.s() == null) {
            return;
        }
        String userId = postData.s().getUserId();
        bs7 bs7Var = this.j;
        String m = bs7Var != null ? bs7Var.m() : "";
        bs7 bs7Var2 = this.j;
        String n = bs7Var2 != null ? bs7Var2.n() : "";
        int A = postData.A();
        String I = postData.I();
        StatisticItem statisticItem = new StatisticItem("c13714");
        statisticItem.param("fid", m);
        statisticItem.param("fname", n);
        statisticItem.param("obj_param1", userId);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("tid", I);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, A);
        if (postData.s().getAlaInfo() != null) {
            AlaInfoData alaInfo = postData.s().getAlaInfo();
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
            if (alaInfo.mYyExtData != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
            }
        }
        TiebaStatic.log(statisticItem);
    }

    public void p0(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bs7Var) == null) {
            this.j = bs7Var;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.s = str;
        }
    }

    public final void q0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) {
            if (this.j != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoTabPbFloatUserInfoViewHolder.l;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05f4));
            }
            String authInfo = UtilHelper.getAuthInfo(metaData, false, 24);
            if (!TextUtils.isEmpty(authInfo)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.l.getLayoutParams();
                layoutParams.setMargins(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoTabPbFloatUserInfoViewHolder.k.setText(authInfo);
                videoTabPbFloatUserInfoViewHolder.k.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.l.getLayoutParams();
            layoutParams2.setMargins(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoTabPbFloatUserInfoViewHolder.k.setVisibility(8);
        }
    }

    public final void r0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, textView, postData) == null) || textView == null || postData == null) {
            return;
        }
        textView.setTag(postData);
        if (postData.s() != null && StringHelper.equals(this.s, postData.s().getUserId())) {
            textView.setVisibility(0);
            gs4 d = gs4.d(textView);
            d.v(R.color.CAM_X0101);
            d.n(R.string.J_X04);
            d.f(R.color.CAM_X0302);
            textView.setText(R.string.obfuscated_res_0x7f0f085e);
            return;
        }
        textView.setVisibility(8);
    }

    public final void s0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, videoTabPbFloatUserInfoViewHolder) == null) || (bs7Var = this.j) == null) {
            return;
        }
        this.l = bs7Var.j;
        if (bs7Var.O() != null) {
            this.n = this.j.O().getIs_good() == 1;
            this.m = this.j.O().getIs_top() == 1;
        }
        videoTabPbFloatUserInfoViewHolder.j(this.l, this.n, this.m);
    }

    public final void t0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (bs7Var = this.j) == null || bs7Var.O() == null) {
            return;
        }
        this.k = 0;
        if (!this.j.O().isMutiForumThread()) {
            if (postData != null && postData.s() != null) {
                this.k = postData.s().getLevel_id();
            }
            if (!this.j.g0()) {
                videoTabPbFloatUserInfoViewHolder.i.setVisibility(0);
                videoTabPbFloatUserInfoViewHolder.h(this.k);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.i.setVisibility(8);
            return;
        }
        videoTabPbFloatUserInfoViewHolder.i.setVisibility(8);
    }

    public final void u0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048593, this, videoTabPbFloatUserInfoViewHolder, metaData, postData) == null) || this.j == null || metaData == null || postData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setUserId(metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setUserName(metaData.getUserName());
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setTid(postData.I());
        bs7 bs7Var = this.j;
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setFid(bs7Var != null ? bs7Var.m() : "");
        bs7 bs7Var2 = this.j;
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setFName(bs7Var2 != null ? bs7Var2.n() : "");
        videoTabPbFloatUserInfoViewHolder.d.j(metaData, 4);
        videoTabPbFloatUserInfoViewHolder.d.n(metaData);
        if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
            videoTabPbFloatUserInfoViewHolder.e(true);
            videoTabPbFloatUserInfoViewHolder.d.getHeadView().setLiveStatus(1);
            videoTabPbFloatUserInfoViewHolder.d.getHeadView().setAlaInfo(postData.s().getAlaInfo());
            o0(postData);
            return;
        }
        videoTabPbFloatUserInfoViewHolder.e(false);
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setLiveStatus(0);
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setAlaInfo(null);
    }

    public final void v0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || videoTabPbFloatUserInfoViewHolder == null || metaData == null || this.j == null) {
            return;
        }
        String ipAddress = metaData.getIpAddress();
        if (!TextUtils.isEmpty(ipAddress)) {
            TextView textView = videoTabPbFloatUserInfoViewHolder.r;
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14d8) + ipAddress);
            return;
        }
        videoTabPbFloatUserInfoViewHolder.r.setVisibility(8);
    }

    public final void w0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048595, this, videoTabPbFloatUserInfoViewHolder, metaData, postData) == null) || this.j == null || postData == null || postData.s() == null) {
            return;
        }
        bs7 bs7Var = this.j;
        String Q = bs7Var != null ? bs7Var.Q() : "";
        int j0 = j0(this.j);
        int i = 4;
        if (this.j.O() != null && this.j.O().isVideoWorksInfo()) {
            i = 8;
        }
        if (this.o == null) {
            cw7 cw7Var = new cw7(this.i.getPageContext(), videoTabPbFloatUserInfoViewHolder.m, i);
            this.o = cw7Var;
            cw7Var.l(this.i.getUniqueId());
        }
        postData.s().setIsLike(postData.s().hadConcerned());
        this.o.n(postData.s());
        this.o.y(Q);
        this.o.w(this.j.O());
        cw7 cw7Var2 = this.o;
        cw7Var2.p = true;
        cw7Var2.x(j0);
        this.o.k(true);
        if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
            videoTabPbFloatUserInfoViewHolder.m.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.m.setText("");
        } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
            videoTabPbFloatUserInfoViewHolder.m.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.m.setText("");
        }
        if (this.j.i) {
            videoTabPbFloatUserInfoViewHolder.m.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.m.setText("");
        }
        if (postData.s().getIsLike()) {
            videoTabPbFloatUserInfoViewHolder.m.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.m.setText("");
        }
    }

    public final void x0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.g.setText(metaData.getName_show());
        videoTabPbFloatUserInfoViewHolder.g.setTag(R.id.obfuscated_res_0x7f091efc, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.g.setTag(R.id.obfuscated_res_0x7f091f04, metaData.getName_show());
        this.q = metaData.isBigV();
        this.r = metaData.isNewGod();
    }

    public final void y0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || this.j == null || metaData == null) {
            return;
        }
        ArrayList<IconData> iconInfo = metaData.getIconInfo();
        videoTabPbFloatUserInfoViewHolder.j.setTag(R.id.obfuscated_res_0x7f091efc, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.j.g(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
    }

    public final void z0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.p = true;
            videoTabPbFloatUserInfoViewHolder.f.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.g.getLayoutParams();
            layoutParams.setMargins(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.p = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.g.getLayoutParams();
            layoutParams2.setMargins(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoTabPbFloatUserInfoViewHolder.f.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }
}
