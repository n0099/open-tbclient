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
/* loaded from: classes7.dex */
public class rz7 extends eo<PostData, VideoPbVideoInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment i;
    @Nullable
    public gz7 j;
    public bs7 k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public cw7 p;
    public boolean q;
    public boolean r;
    public boolean s;
    public String t;
    public View.OnClickListener u;
    public CustomMessageListener v;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz7 a;

        public a(rz7 rz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090442 || view2.getId() == R.id.obfuscated_res_0x7f0923c4) {
                    if (this.a.g != null) {
                        int h = ((VideoPbVideoInfoViewHolder) this.a.g).h();
                        if (h == 1) {
                            ((VideoPbVideoInfoViewHolder) this.a.g).c(2);
                        } else if (h == 2) {
                            ((VideoPbVideoInfoViewHolder) this.a.g).c(1);
                        }
                        if (this.a.k.g0() || h == 1) {
                            ((VideoPbVideoInfoViewHolder) this.a.g).x.setVisibility(8);
                            ((VideoPbVideoInfoViewHolder) this.a.g).B.setVisibility(8);
                        } else {
                            ((VideoPbVideoInfoViewHolder) this.a.g).x.setVisibility(0);
                            ((VideoPbVideoInfoViewHolder) this.a.g).B.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                        return;
                    }
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f092424) {
                    if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        r7 = view2.getTag() != null ? (String) view2.getTag() : null;
                        if (r7 != null) {
                            UrlManager.getInstance().dealOneLink(this.a.i.getPageContext(), new String[]{r7});
                        }
                        TiebaStatic.eventStat(this.a.i.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09231b) {
                    if (view2.getTag(R.id.obfuscated_res_0x7f091efc) instanceof String) {
                        fm4.q(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14d7), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view2.getTag(R.id.obfuscated_res_0x7f091efc)) + "&opacity=0", true, true, true);
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090d24) {
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
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0922f9) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    String str = view2.getTag(R.id.obfuscated_res_0x7f091efc) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f091efc) : null;
                    String str2 = view2.getTag(R.id.obfuscated_res_0x7f091f04) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f091f04) : null;
                    if (this.a.k != null && this.a.k.l() != null) {
                        r7 = this.a.k.l().getName();
                    }
                    String str3 = r7;
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", str);
                    if (this.a.k != null) {
                        statisticItem3.param("fid", this.a.k.m());
                        statisticItem3.param("tid", this.a.k.Q());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbVideoInfoViewHolder a;
        public final /* synthetic */ int b;

        public b(rz7 rz7Var, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz7Var, videoPbVideoInfoViewHolder, Integer.valueOf(i)};
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

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbVideoInfoViewHolder a;
        public final /* synthetic */ int b;

        public c(rz7 rz7Var, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz7Var, videoPbVideoInfoViewHolder, Integer.valueOf(i)};
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

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(rz7 rz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz7Var, Integer.valueOf(i)};
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
            this.a = rz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.g == null || ((VideoPbVideoInfoViewHolder) this.a.g).p == null) {
                return;
            }
            ((VideoPbVideoInfoViewHolder) this.a.g).p.setTextSize(TbConfig.getContentSize());
            this.a.H();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rz7(BaseFragment baseFragment, @Nullable gz7 gz7Var, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, gz7Var, bdUniqueId};
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
        this.t = null;
        this.u = new a(this);
        d dVar = new d(this, 2004018);
        this.v = dVar;
        this.i = baseFragment;
        this.j = gz7Var;
        baseFragment.registerListener(dVar);
    }

    public void A0(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bs7Var) == null) {
            this.k = bs7Var;
        }
    }

    public final void B0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoPbVideoInfoViewHolder, metaData) == null) {
            if (this.k != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoPbVideoInfoViewHolder.l;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05f4));
            }
            String authInfo = UtilHelper.getAuthInfo(metaData, false, 24);
            if (!TextUtils.isEmpty(authInfo)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.l.getLayoutParams();
                layoutParams.setMargins(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoPbVideoInfoViewHolder.k.setText(authInfo);
                videoPbVideoInfoViewHolder.k.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.l.getLayoutParams();
            layoutParams2.setMargins(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoPbVideoInfoViewHolder.k.setVisibility(8);
        }
    }

    public final void C0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            bs7 bs7Var = this.k;
            if (bs7Var != null && bs7Var.g0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.s() != null) {
                MetaData s = postData.s();
                String str = this.t;
                if (str != null && !str.equals("0") && this.t.equals(s.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f085e);
                    textView.setBackgroundColor(0);
                    gs4 d2 = gs4.d(textView);
                    d2.v(R.color.CAM_X0302);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.e0()) {
                    gs4 d3 = gs4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0337);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    gs4 d4 = gs4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f0);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    gs4 d5 = gs4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f1);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    gs4 d6 = gs4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02ed);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    gs4 d7 = gs4.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02ee);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public final void D0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, videoPbVideoInfoViewHolder) == null) || (bs7Var = this.k) == null) {
            return;
        }
        this.m = bs7Var.j;
        if (bs7Var.O() != null) {
            this.o = this.k.O().getIs_good() == 1;
            this.n = this.k.O().getIs_top() == 1;
        }
        videoPbVideoInfoViewHolder.o(this.m, this.o, this.n);
    }

    public final void E0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, videoPbVideoInfoViewHolder, postData) == null) || (bs7Var = this.k) == null || bs7Var.O() == null) {
            return;
        }
        this.l = 0;
        if (!this.k.O().isMutiForumThread()) {
            if (postData != null && postData.s() != null) {
                this.l = postData.s().getLevel_id();
            }
            if (!this.k.g0()) {
                videoPbVideoInfoViewHolder.i.setVisibility(0);
                videoPbVideoInfoViewHolder.m(this.l);
                return;
            }
            videoPbVideoInfoViewHolder.i.setVisibility(8);
            return;
        }
        videoPbVideoInfoViewHolder.i.setVisibility(8);
    }

    public final void F0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, videoPbVideoInfoViewHolder, metaData, postData) == null) || this.k == null || metaData == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.d.getHeadView().setUserId(metaData.getUserId());
        videoPbVideoInfoViewHolder.d.getHeadView().setUserName(metaData.getUserName());
        videoPbVideoInfoViewHolder.d.getHeadView().setTid(postData.I());
        bs7 bs7Var = this.k;
        videoPbVideoInfoViewHolder.d.getHeadView().setFid(bs7Var != null ? bs7Var.m() : "");
        bs7 bs7Var2 = this.k;
        videoPbVideoInfoViewHolder.d.getHeadView().setFName(bs7Var2 != null ? bs7Var2.n() : "");
        videoPbVideoInfoViewHolder.d.j(metaData, 4);
        videoPbVideoInfoViewHolder.d.n(metaData);
        if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
            videoPbVideoInfoViewHolder.j(true);
            videoPbVideoInfoViewHolder.d.getHeadView().setLiveStatus(1);
            videoPbVideoInfoViewHolder.d.getHeadView().setAlaInfo(postData.s().getAlaInfo());
            z0(postData);
            return;
        }
        videoPbVideoInfoViewHolder.j(false);
        videoPbVideoInfoViewHolder.d.getHeadView().setLiveStatus(0);
        videoPbVideoInfoViewHolder.d.getHeadView().setAlaInfo(null);
    }

    public final void G0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, videoPbVideoInfoViewHolder, metaData, postData) == null) || this.k == null || postData == null || postData.s() == null) {
            return;
        }
        bs7 bs7Var = this.k;
        String Q = bs7Var != null ? bs7Var.Q() : "";
        int t0 = t0(this.k);
        int i = 4;
        if (this.k.O() != null && this.k.O().isVideoWorksInfo()) {
            i = 8;
        }
        if (this.p == null) {
            cw7 cw7Var = new cw7(this.i.getPageContext(), videoPbVideoInfoViewHolder.m, i);
            this.p = cw7Var;
            cw7Var.l(this.i.getUniqueId());
        }
        postData.s().setIsLike(postData.s().hadConcerned());
        this.p.n(postData.s());
        this.p.y(Q);
        this.p.w(this.k.O());
        cw7 cw7Var2 = this.p;
        cw7Var2.p = true;
        cw7Var2.x(t0);
        if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
            videoPbVideoInfoViewHolder.m.setVisibility(8);
        } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
            videoPbVideoInfoViewHolder.m.setVisibility(8);
        }
        if (this.k.i) {
            videoPbVideoInfoViewHolder.m.setVisibility(8);
        }
    }

    public final void H0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, videoPbVideoInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.g.setText(metaData.getName_show());
        videoPbVideoInfoViewHolder.g.setTag(R.id.obfuscated_res_0x7f091efc, metaData.getUserId());
        videoPbVideoInfoViewHolder.g.setTag(R.id.obfuscated_res_0x7f091f04, metaData.getName_show());
        this.r = metaData.isBigV();
        this.s = metaData.isNewGod();
    }

    public final void I0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoPbVideoInfoViewHolder, metaData) == null) || this.k == null || metaData == null) {
            return;
        }
        ArrayList<IconData> iconInfo = metaData.getIconInfo();
        videoPbVideoInfoViewHolder.j.setTag(R.id.obfuscated_res_0x7f091efc, metaData.getUserId());
        videoPbVideoInfoViewHolder.j.g(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
    }

    public final void J0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, videoPbVideoInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.q = true;
            videoPbVideoInfoViewHolder.f.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.g.getLayoutParams();
            layoutParams.setMargins(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.q = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.g.getLayoutParams();
            layoutParams2.setMargins(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoPbVideoInfoViewHolder.f.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        y0(i, view2, viewGroup, postData, videoPbVideoInfoViewHolder);
        return view2;
    }

    public final void o0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, bs7 bs7Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048588, this, videoPbVideoInfoViewHolder, bs7Var, i) == null) || bs7Var == null) {
            return;
        }
        videoPbVideoInfoViewHolder.r(bs7Var, i);
    }

    public final void p0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, videoPbVideoInfoViewHolder, postData) == null) || (bs7Var = this.k) == null || bs7Var.O() == null || this.k.O().getAuthor() == null || postData == null) {
            return;
        }
        F0(videoPbVideoInfoViewHolder, this.k.O().getAuthor(), postData);
        J0(videoPbVideoInfoViewHolder, this.k.O().getAuthor());
        H0(videoPbVideoInfoViewHolder, this.k.O().getAuthor());
        C0(videoPbVideoInfoViewHolder.h, this.k.j());
        E0(videoPbVideoInfoViewHolder, postData);
        I0(videoPbVideoInfoViewHolder, this.k.O().getAuthor());
        B0(videoPbVideoInfoViewHolder, this.k.O().getAuthor());
        G0(videoPbVideoInfoViewHolder, this.k.O().getAuthor(), postData);
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.t = str;
        }
    }

    public final void q0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        bs7 bs7Var;
        String formatTime;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, videoPbVideoInfoViewHolder, postData) == null) || (bs7Var = this.k) == null || bs7Var.O() == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.v(this.k.O().getRichTitle(), this.k.O().getTitle(), this.k.O(), u0(postData), this.k.s0());
        if (this.k.O().getThreadVideoInfo() != null) {
            String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(this.k.O().getThreadVideoInfo().play_count.intValue());
            TextView textView = videoPbVideoInfoViewHolder.v;
            textView.setText(numberUniformFormatExtra + this.a.getString(R.string.obfuscated_res_0x7f0f0e6a));
            TextView textView2 = videoPbVideoInfoViewHolder.C;
            textView2.setText(numberUniformFormatExtra + this.a.getString(R.string.obfuscated_res_0x7f0f0e6a));
        }
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.X()), "yyyy"))) {
            formatTime = StringHelper.getFormatTimeShort(postData.X());
        } else {
            formatTime = StringHelper.getFormatTime(postData.X());
        }
        TextView textView3 = videoPbVideoInfoViewHolder.w;
        textView3.setText(formatTime + this.a.getString(R.string.obfuscated_res_0x7f0f1102));
        TextView textView4 = videoPbVideoInfoViewHolder.D;
        textView4.setText(formatTime + this.a.getString(R.string.obfuscated_res_0x7f0f1102));
        b05 M = postData.M();
        if (M != null && !TextUtils.isEmpty(M.b()) && !TextUtils.isEmpty(M.b().trim())) {
            videoPbVideoInfoViewHolder.x.setText(M.b());
            videoPbVideoInfoViewHolder.E.setText(M.b());
            videoPbVideoInfoViewHolder.x.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.x.setVisibility(8);
        }
        if (M != null && !TextUtils.isEmpty(M.a())) {
            videoPbVideoInfoViewHolder.B.setText(M.a());
            videoPbVideoInfoViewHolder.F.setText(M.a());
            videoPbVideoInfoViewHolder.B.setVisibility(0);
            int measureText = (int) videoPbVideoInfoViewHolder.B.getPaint().measureText(M.a(), 0, M.a().length());
            videoPbVideoInfoViewHolder.y.post(new b(this, videoPbVideoInfoViewHolder, measureText));
            videoPbVideoInfoViewHolder.u.post(new c(this, videoPbVideoInfoViewHolder, measureText));
        } else {
            videoPbVideoInfoViewHolder.B.setVisibility(8);
        }
        PollData pollData = this.k.O().getPollData();
        if (pollData != null && pollData.getOptions() != null && pollData.getOptions().size() > 0) {
            videoPbVideoInfoViewHolder.z.setPageContext(this.i.getPageContext());
            videoPbVideoInfoViewHolder.z.setDataForPb(pollData, this.k.Q(), this.k.m());
            videoPbVideoInfoViewHolder.z.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.z.setVisibility(8);
        }
        LinearLayout linearLayout = videoPbVideoInfoViewHolder.N;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        bs7 bs7Var2 = this.k;
        if (bs7Var2 != null && bs7Var2.O() != null && !v0(this.k.O()) && (!ListUtils.isEmpty(this.k.O().getLinkDataList()) || !ListUtils.isEmpty(this.k.O().getGoodsDataList()))) {
            ae5 ae5Var = new ae5();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.a);
            bs7 bs7Var3 = this.k;
            pbLinkGoodsRootView.j(bs7Var3, ae5Var.a(bs7Var3.O().getLinkDataList(), this.k.O().getGoodsDataList()), this.k.n(), (AbsVideoPbFragment) this.i, ae5Var.b());
            videoPbVideoInfoViewHolder.N.addView(pbLinkGoodsRootView);
            videoPbVideoInfoViewHolder.N.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.N.setVisibility(8);
        }
        videoPbVideoInfoViewHolder.u(this.a, postData);
    }

    public final void r0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, videoPbVideoInfoViewHolder, postData) == null) {
            videoPbVideoInfoViewHolder.t(8, null);
            bs7 bs7Var = this.k;
            if (bs7Var == null || bs7Var.O() == null || postData == null) {
                return;
            }
            if (postData.Q) {
                videoPbVideoInfoViewHolder.t(0, postData.I());
            }
            BaseFragment baseFragment = this.i;
            if (baseFragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) baseFragment).d5(postData.Q);
            }
        }
    }

    public final int s0() {
        InterceptResult invokeV;
        PbModel v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            gz7 gz7Var = this.j;
            if (gz7Var == null || (v = gz7Var.v()) == null) {
                return 0;
            }
            return v.O1();
        }
        return invokeV.intValue;
    }

    public final int t0(bs7 bs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bs7Var)) == null) {
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

    public final boolean u0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, postData)) == null) ? postData != null && ListUtils.getCount(postData.m0) >= 2 : invokeL.booleanValue;
    }

    public final boolean v0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, threadData)) == null) ? (threadData == null || threadData.getPollData() == null || threadData.getPollData().getOptions() == null || threadData.getPollData().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    public void w0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, videoPbVideoInfoViewHolder) == null) || videoPbVideoInfoViewHolder == null) {
            return;
        }
        videoPbVideoInfoViewHolder.m(this.l);
        videoPbVideoInfoViewHolder.q(this.q || this.r || this.s);
        videoPbVideoInfoViewHolder.o(this.m, this.o, this.n);
        videoPbVideoInfoViewHolder.n();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: x0 */
    public VideoPbVideoInfoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d067f, viewGroup, false);
            Context context = this.a;
            BaseFragment baseFragment = this.i;
            VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(context, inflate, baseFragment instanceof AbsVideoPbFragment ? (AbsVideoPbFragment) baseFragment : null);
            videoPbVideoInfoViewHolder.s(this.u);
            w0(videoPbVideoInfoViewHolder);
            this.g = videoPbVideoInfoViewHolder;
            return videoPbVideoInfoViewHolder;
        }
        return (VideoPbVideoInfoViewHolder) invokeL.objValue;
    }

    public View y0(int i, View view2, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postData, videoPbVideoInfoViewHolder})) == null) {
            bs7 bs7Var = this.k;
            if (bs7Var != null && bs7Var.O() != null && postData != null) {
                vy7.d(this.i.getUniqueId(), this.k, postData, 1, 1);
                D0(videoPbVideoInfoViewHolder);
                p0(videoPbVideoInfoViewHolder, postData);
                q0(videoPbVideoInfoViewHolder, postData);
                r0(videoPbVideoInfoViewHolder, postData);
                o0(videoPbVideoInfoViewHolder, this.k, s0());
                w0(videoPbVideoInfoViewHolder);
                videoPbVideoInfoViewHolder.G.setVisibility(8);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, postData) == null) || postData == null || postData.s() == null) {
            return;
        }
        String userId = postData.s().getUserId();
        bs7 bs7Var = this.k;
        String m = bs7Var != null ? bs7Var.m() : "";
        bs7 bs7Var2 = this.k;
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
}
