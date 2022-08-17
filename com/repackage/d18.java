package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
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
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
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
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoPbVideoInfoViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes6.dex */
public class d18 extends bn<PostData, VideoPbVideoInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    @Nullable
    public s08 b;
    public et7 c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public jx7 h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;
    public View.OnClickListener m;
    public CustomMessageListener n;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d18 a;

        public a(d18 d18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090454 || view2.getId() == R.id.obfuscated_res_0x7f092523) {
                    if (this.a.viewholder != null) {
                        int f = ((VideoPbVideoInfoViewHolder) this.a.viewholder).f();
                        if (f == 1) {
                            ((VideoPbVideoInfoViewHolder) this.a.viewholder).a(2);
                        } else if (f == 2) {
                            ((VideoPbVideoInfoViewHolder) this.a.viewholder).a(1);
                        }
                        if (this.a.c.i0() || f == 1) {
                            ((VideoPbVideoInfoViewHolder) this.a.viewholder).x.setVisibility(8);
                            ((VideoPbVideoInfoViewHolder) this.a.viewholder).B.setVisibility(8);
                        } else {
                            ((VideoPbVideoInfoViewHolder) this.a.viewholder).x.setVisibility(0);
                            ((VideoPbVideoInfoViewHolder) this.a.viewholder).B.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                        return;
                    }
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f092586) {
                    if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        r7 = view2.getTag() != null ? (String) view2.getTag() : null;
                        if (r7 != null) {
                            UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{r7});
                        }
                        TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092478) {
                    if (view2.getTag(R.id.obfuscated_res_0x7f09203d) instanceof String) {
                        jm4.s(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14e6), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view2.getTag(R.id.obfuscated_res_0x7f09203d)) + "&opacity=0", true, true, true);
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090d23) {
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
                            YYLiveUtil.jumpYYLiveRoom(this.a.a.getPageContext(), alaInfo, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092456) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    String str = view2.getTag(R.id.obfuscated_res_0x7f09203d) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f09203d) : null;
                    String str2 = view2.getTag(R.id.obfuscated_res_0x7f092045) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f092045) : null;
                    if (this.a.c != null && this.a.c.l() != null) {
                        r7 = this.a.c.l().getName();
                    }
                    String str3 = r7;
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", str);
                    if (this.a.c != null) {
                        statisticItem3.param("fid", this.a.c.m());
                        statisticItem3.param("tid", this.a.c.Q());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbVideoInfoViewHolder a;
        public final /* synthetic */ int b;

        public b(d18 d18Var, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d18Var, videoPbVideoInfoViewHolder, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbVideoInfoViewHolder;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                int measuredWidth = this.a.y.getMeasuredWidth();
                int measuredWidth2 = this.a.v.getMeasuredWidth();
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.a.w.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
                int i = this.b;
                if (measuredWidth3 < i) {
                    this.a.B.setVisibility(8);
                    this.a.x.setVisibility(8);
                } else if (measuredWidth3 - i < dimenPixelSize3) {
                    this.a.x.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbVideoInfoViewHolder a;
        public final /* synthetic */ int b;

        public c(d18 d18Var, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d18Var, videoPbVideoInfoViewHolder, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbVideoInfoViewHolder;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                int measuredWidth = this.a.u.getMeasuredWidth();
                int measuredWidth2 = this.a.C.getMeasuredWidth();
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.a.D.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
                int i = this.b;
                if (measuredWidth3 < i) {
                    this.a.F.setVisibility(8);
                    this.a.E.setVisibility(8);
                } else if (measuredWidth3 - i < dimenPixelSize3) {
                    this.a.E.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(d18 d18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d18Var, Integer.valueOf(i)};
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
            this.a = d18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.viewholder == null || ((VideoPbVideoInfoViewHolder) this.a.viewholder).p == null) {
                return;
            }
            ((VideoPbVideoInfoViewHolder) this.a.viewholder).p.setTextSize(TbConfig.getContentSize());
            this.a.notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d18(BaseFragment baseFragment, @Nullable s08 s08Var, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, s08Var, bdUniqueId};
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
        this.l = null;
        this.m = new a(this);
        d dVar = new d(this, 2004018);
        this.n = dVar;
        this.a = baseFragment;
        this.b = s08Var;
        baseFragment.registerListener(dVar);
    }

    public final void H(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, et7 et7Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, videoPbVideoInfoViewHolder, et7Var, i) == null) || et7Var == null) {
            return;
        }
        videoPbVideoInfoViewHolder.o(et7Var, i);
    }

    public final void J(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        et7 et7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoPbVideoInfoViewHolder, postData) == null) || (et7Var = this.c) == null || et7Var.O() == null || this.c.O().getAuthor() == null || postData == null) {
            return;
        }
        Z(videoPbVideoInfoViewHolder, this.c.O().getAuthor(), postData);
        d0(videoPbVideoInfoViewHolder, this.c.O().getAuthor());
        b0(videoPbVideoInfoViewHolder, this.c.O().getAuthor());
        W(videoPbVideoInfoViewHolder.h, this.c.j());
        Y(videoPbVideoInfoViewHolder, postData);
        c0(videoPbVideoInfoViewHolder, this.c.O().getAuthor());
        V(videoPbVideoInfoViewHolder, this.c.O().getAuthor());
        a0(videoPbVideoInfoViewHolder, this.c.O().getAuthor(), postData);
    }

    public final void K(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        et7 et7Var;
        String formatTime;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoPbVideoInfoViewHolder, postData) == null) || (et7Var = this.c) == null || et7Var.O() == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.s(this.c.O().getRichTitle(), this.c.O().getTitle(), this.c.O(), O(postData), this.c.v0());
        if (this.c.O().getThreadVideoInfo() != null) {
            String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(this.c.O().getThreadVideoInfo().play_count.intValue());
            TextView textView = videoPbVideoInfoViewHolder.v;
            textView.setText(numberUniformFormatExtra + this.mContext.getString(R.string.obfuscated_res_0x7f0f0e86));
            TextView textView2 = videoPbVideoInfoViewHolder.C;
            textView2.setText(numberUniformFormatExtra + this.mContext.getString(R.string.obfuscated_res_0x7f0f0e86));
        }
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.e0()), "yyyy"))) {
            formatTime = StringHelper.getFormatTimeShort(postData.e0());
        } else {
            formatTime = StringHelper.getFormatTime(postData.e0());
        }
        TextView textView3 = videoPbVideoInfoViewHolder.w;
        textView3.setText(formatTime + this.mContext.getString(R.string.obfuscated_res_0x7f0f110c));
        TextView textView4 = videoPbVideoInfoViewHolder.D;
        textView4.setText(formatTime + this.mContext.getString(R.string.obfuscated_res_0x7f0f110c));
        j15 R = postData.R();
        if (R != null && !TextUtils.isEmpty(R.b()) && !TextUtils.isEmpty(R.b().trim())) {
            videoPbVideoInfoViewHolder.x.setText(R.b());
            videoPbVideoInfoViewHolder.E.setText(R.b());
            videoPbVideoInfoViewHolder.x.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.x.setVisibility(8);
        }
        if (R != null && !TextUtils.isEmpty(R.a())) {
            videoPbVideoInfoViewHolder.B.setText(R.a());
            videoPbVideoInfoViewHolder.F.setText(R.a());
            videoPbVideoInfoViewHolder.B.setVisibility(0);
            int measureText = (int) videoPbVideoInfoViewHolder.B.getPaint().measureText(R.a(), 0, R.a().length());
            videoPbVideoInfoViewHolder.y.post(new b(this, videoPbVideoInfoViewHolder, measureText));
            videoPbVideoInfoViewHolder.u.post(new c(this, videoPbVideoInfoViewHolder, measureText));
        } else {
            videoPbVideoInfoViewHolder.B.setVisibility(8);
        }
        PollData pollData = this.c.O().getPollData();
        if (pollData != null && pollData.getOptions() != null && pollData.getOptions().size() > 0) {
            videoPbVideoInfoViewHolder.z.setPageContext(this.a.getPageContext());
            videoPbVideoInfoViewHolder.z.setDataForPb(pollData, this.c.Q(), this.c.m());
            videoPbVideoInfoViewHolder.z.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.z.setVisibility(8);
        }
        LinearLayout linearLayout = videoPbVideoInfoViewHolder.N;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        et7 et7Var2 = this.c;
        if (et7Var2 != null && et7Var2.O() != null && !P(this.c.O()) && (!ListUtils.isEmpty(this.c.O().getLinkDataList()) || !ListUtils.isEmpty(this.c.O().getGoodsDataList()))) {
            lf5 lf5Var = new lf5();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
            et7 et7Var3 = this.c;
            pbLinkGoodsRootView.j(et7Var3, lf5Var.a(et7Var3.O().getLinkDataList(), this.c.O().getGoodsDataList()), this.c.n(), (AbsVideoPbFragment) this.a, lf5Var.c());
            videoPbVideoInfoViewHolder.N.addView(pbLinkGoodsRootView);
            videoPbVideoInfoViewHolder.N.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.N.setVisibility(8);
        }
        videoPbVideoInfoViewHolder.r(this.mContext, postData);
    }

    public final void L(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, videoPbVideoInfoViewHolder, postData) == null) {
            videoPbVideoInfoViewHolder.q(8, null);
            et7 et7Var = this.c;
            if (et7Var == null || et7Var.O() == null || postData == null) {
                return;
            }
            if (postData.Q) {
                videoPbVideoInfoViewHolder.q(0, postData.K());
            }
            BaseFragment baseFragment = this.a;
            if (baseFragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) baseFragment).V5(postData.Q);
            }
        }
    }

    public final int M() {
        InterceptResult invokeV;
        PbModel K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            s08 s08Var = this.b;
            if (s08Var == null || (K = s08Var.K()) == null) {
                return 0;
            }
            return K.R1();
        }
        return invokeV.intValue;
    }

    public final int N(et7 et7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, et7Var)) == null) {
            if (et7Var == null || et7Var.O() == null) {
                return 0;
            }
            if (et7Var.O().isMutiForumThread()) {
                return (ListUtils.isEmpty(et7Var.p()) && (et7Var.h() == null || StringUtils.isNull(et7Var.h().c()))) ? 0 : 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final boolean O(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, postData)) == null) ? postData != null && ListUtils.getCount(postData.g0) >= 2 : invokeL.booleanValue;
    }

    public final boolean P(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadData)) == null) ? (threadData == null || threadData.getPollData() == null || threadData.getPollData().getOptions() == null || threadData.getPollData().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    public void Q(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoPbVideoInfoViewHolder) == null) || videoPbVideoInfoViewHolder == null) {
            return;
        }
        videoPbVideoInfoViewHolder.k(this.d);
        videoPbVideoInfoViewHolder.n(this.i || this.j || this.k);
        videoPbVideoInfoViewHolder.m(this.e, this.g, this.f);
        videoPbVideoInfoViewHolder.l();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: R */
    public VideoPbVideoInfoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06bc, viewGroup, false);
            Context context = this.mContext;
            BaseFragment baseFragment = this.a;
            VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(context, inflate, baseFragment instanceof AbsVideoPbFragment ? (AbsVideoPbFragment) baseFragment : null);
            videoPbVideoInfoViewHolder.p(this.m);
            Q(videoPbVideoInfoViewHolder);
            this.viewholder = videoPbVideoInfoViewHolder;
            return videoPbVideoInfoViewHolder;
        }
        return (VideoPbVideoInfoViewHolder) invokeL.objValue;
    }

    public View S(int i, View view2, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postData, videoPbVideoInfoViewHolder})) == null) {
            et7 et7Var = this.c;
            if (et7Var != null && et7Var.O() != null && postData != null) {
                h08.d(this.a.getUniqueId(), this.c, postData, 1, 1);
                X(videoPbVideoInfoViewHolder);
                J(videoPbVideoInfoViewHolder, postData);
                K(videoPbVideoInfoViewHolder, postData);
                L(videoPbVideoInfoViewHolder, postData);
                H(videoPbVideoInfoViewHolder, this.c, M());
                Q(videoPbVideoInfoViewHolder);
                videoPbVideoInfoViewHolder.G.setVisibility(8);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void T(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postData) == null) || postData == null || postData.s() == null) {
            return;
        }
        String userId = postData.s().getUserId();
        et7 et7Var = this.c;
        String m = et7Var != null ? et7Var.m() : "";
        et7 et7Var2 = this.c;
        String n = et7Var2 != null ? et7Var2.n() : "";
        int B = postData.B();
        String K = postData.K();
        StatisticItem statisticItem = new StatisticItem("c13714");
        statisticItem.param("fid", m);
        statisticItem.param("fname", n);
        statisticItem.param("obj_param1", userId);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("tid", K);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, B);
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

    public void U(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, et7Var) == null) {
            this.c = et7Var;
        }
    }

    public final void V(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, videoPbVideoInfoViewHolder, metaData) == null) {
            if (this.c != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoPbVideoInfoViewHolder.l;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0603));
            }
            String authInfo = UtilHelper.getAuthInfo(metaData, false, 24);
            if (!TextUtils.isEmpty(authInfo)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.l.getLayoutParams();
                layoutParams.setMargins(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoPbVideoInfoViewHolder.k.setText(authInfo);
                videoPbVideoInfoViewHolder.k.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.l.getLayoutParams();
            layoutParams2.setMargins(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoPbVideoInfoViewHolder.k.setVisibility(8);
        }
    }

    public final void W(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            et7 et7Var = this.c;
            if (et7Var != null && et7Var.i0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.s() != null) {
                MetaData s = postData.s();
                String str = this.l;
                if (str != null && !str.equals("0") && this.l.equals(s.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0869);
                    textView.setBackgroundColor(0);
                    ms4 d2 = ms4.d(textView);
                    d2.v(R.color.CAM_X0302);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.o0()) {
                    ms4 d3 = ms4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0341);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    ms4 d4 = ms4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fa);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    ms4 d5 = ms4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fb);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    ms4 d6 = ms4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f7);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    ms4 d7 = ms4.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f8);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public final void X(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        et7 et7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, videoPbVideoInfoViewHolder) == null) || (et7Var = this.c) == null) {
            return;
        }
        this.e = et7Var.j;
        if (et7Var.O() != null) {
            this.g = this.c.O().getIs_good() == 1;
            this.f = this.c.O().getIs_top() == 1;
        }
        videoPbVideoInfoViewHolder.m(this.e, this.g, this.f);
    }

    public final void Y(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        et7 et7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, videoPbVideoInfoViewHolder, postData) == null) || (et7Var = this.c) == null || et7Var.O() == null) {
            return;
        }
        this.d = 0;
        if (!this.c.O().isMutiForumThread()) {
            if (postData != null && postData.s() != null) {
                this.d = postData.s().getLevel_id();
            }
            if (!this.c.i0()) {
                videoPbVideoInfoViewHolder.i.setVisibility(0);
                videoPbVideoInfoViewHolder.k(this.d);
                return;
            }
            videoPbVideoInfoViewHolder.i.setVisibility(8);
            return;
        }
        videoPbVideoInfoViewHolder.i.setVisibility(8);
    }

    public final void Z(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048593, this, videoPbVideoInfoViewHolder, metaData, postData) == null) || this.c == null || metaData == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.d.getHeadView().setUserId(metaData.getUserId());
        videoPbVideoInfoViewHolder.d.getHeadView().setUserName(metaData.getUserName());
        videoPbVideoInfoViewHolder.d.getHeadView().setTid(postData.K());
        et7 et7Var = this.c;
        videoPbVideoInfoViewHolder.d.getHeadView().setFid(et7Var != null ? et7Var.m() : "");
        et7 et7Var2 = this.c;
        videoPbVideoInfoViewHolder.d.getHeadView().setFName(et7Var2 != null ? et7Var2.n() : "");
        videoPbVideoInfoViewHolder.d.j(metaData, 4);
        videoPbVideoInfoViewHolder.d.n(metaData);
        if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
            videoPbVideoInfoViewHolder.h(true);
            videoPbVideoInfoViewHolder.d.getHeadView().setLiveStatus(1);
            videoPbVideoInfoViewHolder.d.getHeadView().setAlaInfo(postData.s().getAlaInfo());
            T(postData);
            return;
        }
        videoPbVideoInfoViewHolder.h(false);
        videoPbVideoInfoViewHolder.d.getHeadView().setLiveStatus(0);
        videoPbVideoInfoViewHolder.d.getHeadView().setAlaInfo(null);
    }

    public final void a0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, videoPbVideoInfoViewHolder, metaData, postData) == null) || this.c == null || postData == null || postData.s() == null) {
            return;
        }
        et7 et7Var = this.c;
        String Q = et7Var != null ? et7Var.Q() : "";
        int N = N(this.c);
        int i = 4;
        if (this.c.O() != null && this.c.O().isVideoWorksInfo()) {
            i = 8;
        }
        if (this.h == null) {
            jx7 jx7Var = new jx7(this.a.getPageContext(), videoPbVideoInfoViewHolder.m, i);
            this.h = jx7Var;
            jx7Var.l(this.a.getUniqueId());
        }
        postData.s().setIsLike(postData.s().hadConcerned());
        this.h.n(postData.s());
        this.h.x(Q);
        this.h.v(this.c.O());
        jx7 jx7Var2 = this.h;
        jx7Var2.p = true;
        jx7Var2.w(N);
        if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
            videoPbVideoInfoViewHolder.m.setVisibility(8);
        } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
            videoPbVideoInfoViewHolder.m.setVisibility(8);
        }
        if (this.c.i) {
            videoPbVideoInfoViewHolder.m.setVisibility(8);
        }
    }

    public final void b0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, videoPbVideoInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.g.setText(metaData.getName_show());
        videoPbVideoInfoViewHolder.g.setTag(R.id.obfuscated_res_0x7f09203d, metaData.getUserId());
        videoPbVideoInfoViewHolder.g.setTag(R.id.obfuscated_res_0x7f092045, metaData.getName_show());
        this.j = metaData.isBigV();
        this.k = metaData.isNewGod();
    }

    public final void c0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, videoPbVideoInfoViewHolder, metaData) == null) || this.c == null || metaData == null) {
            return;
        }
        ArrayList<IconData> iconInfo = metaData.getIconInfo();
        videoPbVideoInfoViewHolder.j.setTag(R.id.obfuscated_res_0x7f09203d, metaData.getUserId());
        videoPbVideoInfoViewHolder.j.g(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
    }

    public final void d0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, videoPbVideoInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.i = true;
            videoPbVideoInfoViewHolder.f.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.g.getLayoutParams();
            layoutParams.setMargins(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.i = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.g.getLayoutParams();
            layoutParams2.setMargins(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoPbVideoInfoViewHolder.f.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.l = str;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.bn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        S(i, view2, viewGroup, postData, videoPbVideoInfoViewHolder);
        return view2;
    }
}
