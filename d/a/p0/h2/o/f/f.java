package d.a.p0.h2.o.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PollData;
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
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoPbVideoInfoViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.r.q.b2;
import d.a.o0.t.g;
import d.a.o0.z0.l0;
import d.a.o0.z0.n0;
import d.a.p0.h2.k.e.q0;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes8.dex */
public class f extends d.a.c.k.e.a<PostData, VideoPbVideoInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment m;
    public d.a.p0.h2.h.e n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public q0 s;
    public boolean t;
    public boolean u;
    public boolean v;
    public String w;
    public View.OnClickListener x;
    public CustomMessageListener y;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f57786e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57786e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (this.f57786e.k != null) {
                        int g2 = ((VideoPbVideoInfoViewHolder) this.f57786e.k).g();
                        if (g2 == 1) {
                            ((VideoPbVideoInfoViewHolder) this.f57786e.k).b(2);
                        } else if (g2 == 2) {
                            ((VideoPbVideoInfoViewHolder) this.f57786e.k).b(1);
                        }
                        if (this.f57786e.n.e0() || g2 == 1) {
                            ((VideoPbVideoInfoViewHolder) this.f57786e.k).y.setVisibility(8);
                            ((VideoPbVideoInfoViewHolder) this.f57786e.k).C.setVisibility(8);
                        } else {
                            ((VideoPbVideoInfoViewHolder) this.f57786e.k).y.setVisibility(0);
                            ((VideoPbVideoInfoViewHolder) this.f57786e.k).C.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                        return;
                    }
                    return;
                }
                if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        r7 = view.getTag() != null ? (String) view.getTag() : null;
                        if (r7 != null) {
                            UrlManager.getInstance().dealOneLink(this.f57786e.m.getPageContext(), new String[]{r7});
                        }
                        TiebaStatic.eventStat(this.f57786e.m.getPageContext().getPageActivity(), "consume_2", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        d.a.o0.l.a.o(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                    }
                } else if (view.getId() == R.id.head_view_video_info_item) {
                    HeadImageView headView = ((HeadPendantClickableView) view).getHeadView();
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
                            YYLiveUtil.jumpYYLiveRoom(this.f57786e.m.getPageContext(), alaInfo);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f57786e.f41837e, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (this.f57786e.n != null && this.f57786e.n.m() != null) {
                        r7 = this.f57786e.n.m().getName();
                    }
                    String str3 = r7;
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", str);
                    if (this.f57786e.n != null) {
                        statisticItem3.param("fid", this.f57786e.n.n());
                        statisticItem3.param("tid", this.f57786e.n.P());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f57786e.f41837e, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbVideoInfoViewHolder f57787e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f57788f;

        public b(f fVar, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, videoPbVideoInfoViewHolder, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57787e = videoPbVideoInfoViewHolder;
            this.f57788f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                int measuredWidth = this.f57787e.z.getMeasuredWidth();
                int measuredWidth2 = this.f57787e.w.getMeasuredWidth();
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.f57787e.x.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
                int i2 = this.f57788f;
                if (measuredWidth3 < i2) {
                    this.f57787e.C.setVisibility(8);
                    this.f57787e.y.setVisibility(8);
                } else if (measuredWidth3 - i2 < dimenPixelSize3) {
                    this.f57787e.y.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbVideoInfoViewHolder f57789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f57790f;

        public c(f fVar, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, videoPbVideoInfoViewHolder, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57789e = videoPbVideoInfoViewHolder;
            this.f57790f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                int measuredWidth = this.f57789e.v.getMeasuredWidth();
                int measuredWidth2 = this.f57789e.D.getMeasuredWidth();
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.f57789e.E.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
                int i2 = this.f57790f;
                if (measuredWidth3 < i2) {
                    this.f57789e.G.setVisibility(8);
                    this.f57789e.F.setVisibility(8);
                } else if (measuredWidth3 - i2 < dimenPixelSize3) {
                    this.f57789e.F.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f57791a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57791a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f57791a.k == null || ((VideoPbVideoInfoViewHolder) this.f57791a.k).q == null) {
                return;
            }
            ((VideoPbVideoInfoViewHolder) this.f57791a.k).q.setTextSize(TbConfig.getContentSize());
            this.f57791a.L();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bdUniqueId};
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
        this.w = null;
        this.x = new a(this);
        d dVar = new d(this, 2004018);
        this.y = dVar;
        this.m = baseFragment;
        baseFragment.registerListener(dVar);
    }

    public final void A0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, videoPbVideoInfoViewHolder, postData) == null) {
            videoPbVideoInfoViewHolder.q(8, null);
            d.a.p0.h2.h.e eVar = this.n;
            if (eVar == null || eVar.N() == null || postData == null) {
                return;
            }
            if (postData.S) {
                videoPbVideoInfoViewHolder.q(0, postData.E());
            }
            BaseFragment baseFragment = this.m;
            if (baseFragment instanceof VideoPbFragment) {
                ((VideoPbFragment) baseFragment).c5(postData.S);
            }
        }
    }

    public final int B0(d.a.p0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null) {
                return 0;
            }
            if (eVar.N().b2()) {
                return (ListUtils.isEmpty(eVar.q()) && (eVar.h() == null || StringUtils.isNull(eVar.h().g()))) ? 0 : 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final boolean C0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData)) == null) ? postData != null && ListUtils.getCount(postData.n0) >= 2 : invokeL.booleanValue;
    }

    public final boolean D0(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, b2Var)) == null) ? (b2Var == null || b2Var.D0() == null || b2Var.D0().getOptions() == null || b2Var.D0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    public void E0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, videoPbVideoInfoViewHolder) == null) || videoPbVideoInfoViewHolder == null) {
            return;
        }
        videoPbVideoInfoViewHolder.l(this.o);
        videoPbVideoInfoViewHolder.o(this.t || this.u || this.v);
        videoPbVideoInfoViewHolder.n(this.p, this.r, this.q);
        videoPbVideoInfoViewHolder.m();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: F0 */
    public VideoPbVideoInfoViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f41837e).inflate(R.layout.pb_list_video_info_item, viewGroup, false);
            Context context = this.f41837e;
            BaseFragment baseFragment = this.m;
            VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(context, inflate, baseFragment instanceof VideoPbFragment ? (VideoPbFragment) baseFragment : null);
            videoPbVideoInfoViewHolder.p(this.x);
            E0(videoPbVideoInfoViewHolder);
            this.k = videoPbVideoInfoViewHolder;
            return videoPbVideoInfoViewHolder;
        }
        return (VideoPbVideoInfoViewHolder) invokeL.objValue;
    }

    public View G0(int i2, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, videoPbVideoInfoViewHolder})) == null) {
            d.a.p0.h2.h.e eVar = this.n;
            if (eVar != null && eVar.N() != null && postData != null) {
                d.a.p0.h2.m.a.d(this.m.getUniqueId(), this.n, postData, 1, 1);
                L0(videoPbVideoInfoViewHolder);
                y0(videoPbVideoInfoViewHolder, postData);
                z0(videoPbVideoInfoViewHolder, postData);
                A0(videoPbVideoInfoViewHolder, postData);
                E0(videoPbVideoInfoViewHolder);
                videoPbVideoInfoViewHolder.H.setVisibility(d.a.o0.c1.b.e.d() ? 0 : 8);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void H0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, postData) == null) || postData == null || postData.t() == null) {
            return;
        }
        String userId = postData.t().getUserId();
        d.a.p0.h2.h.e eVar = this.n;
        String n = eVar != null ? eVar.n() : "";
        d.a.p0.h2.h.e eVar2 = this.n;
        String o = eVar2 != null ? eVar2.o() : "";
        int A = postData.A();
        String E = postData.E();
        StatisticItem statisticItem = new StatisticItem("c13714");
        statisticItem.param("fid", n);
        statisticItem.param("fname", o);
        statisticItem.param("obj_param1", userId);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("tid", E);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, A);
        if (postData.t().getAlaInfo() != null) {
            AlaInfoData alaInfo = postData.t().getAlaInfo();
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
            if (alaInfo.mYyExtData != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
            }
        }
        TiebaStatic.log(statisticItem);
    }

    public void I0(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.n = eVar;
        }
    }

    public final void J0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, videoPbVideoInfoViewHolder, metaData) == null) {
            if (this.n != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoPbVideoInfoViewHolder.n;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
            }
            if (metaData != null && metaData.isNewGod()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.n.getLayoutParams();
                layoutParams.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoPbVideoInfoViewHolder.m.setText(metaData.getNewGodData().getFieldName() + n0.d(metaData.getNewGodData().isVideoGod()));
                videoPbVideoInfoViewHolder.m.setVisibility(0);
            } else if (metaData != null && metaData.showBazhuGrade()) {
                videoPbVideoInfoViewHolder.m.setText(StringHelper.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
                videoPbVideoInfoViewHolder.m.setVisibility(0);
            } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !k.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.n.getLayoutParams();
                layoutParams2.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                videoPbVideoInfoViewHolder.m.setText(metaData.getBaijiahaoInfo().auth_desc);
                videoPbVideoInfoViewHolder.m.setVisibility(0);
            } else {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.n.getLayoutParams();
                layoutParams3.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
                videoPbVideoInfoViewHolder.m.setVisibility(8);
            }
        }
    }

    public final void K0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            d.a.p0.h2.h.e eVar = this.n;
            if (eVar != null && eVar.e0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.t() != null) {
                MetaData t = postData.t();
                String str = this.w;
                if (str != null && !str.equals("0") && this.w.equals(t.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(textView);
                    d2.t(R.color.CAM_X0302);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.k(R.color.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && postData.X()) {
                    d.a.o0.r.u.c d3 = d.a.o0.r.u.c.d(textView);
                    d3.t(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    d.a.o0.r.u.c d4 = d.a.o0.r.u.c.d(textView);
                    d4.t(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    d.a.o0.r.u.c d5 = d.a.o0.r.u.c.d(textView);
                    d5.t(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (t.getIs_bawu() == 1 && "pri_content_assist".equals(t.getBawu_type())) {
                    d.a.o0.r.u.c d6 = d.a.o0.r.u.c.d(textView);
                    d6.t(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (t.getIs_bawu() == 1 && "pri_manage_assist".equals(t.getBawu_type())) {
                    d.a.o0.r.u.c d7 = d.a.o0.r.u.c.d(textView);
                    d7.t(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public final void L0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        d.a.p0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, videoPbVideoInfoViewHolder) == null) || (eVar = this.n) == null) {
            return;
        }
        this.p = eVar.j;
        if (eVar.N() != null) {
            this.r = this.n.N().l0() == 1;
            this.q = this.n.N().m0() == 1;
        }
        videoPbVideoInfoViewHolder.n(this.p, this.r, this.q);
    }

    public final void M0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        d.a.p0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, videoPbVideoInfoViewHolder, postData) == null) || (eVar = this.n) == null || eVar.N() == null) {
            return;
        }
        this.o = 0;
        if (!this.n.N().b2()) {
            if (postData != null && postData.t() != null) {
                this.o = postData.t().getLevel_id();
            }
            if (!this.n.e0()) {
                videoPbVideoInfoViewHolder.k.setVisibility(0);
                videoPbVideoInfoViewHolder.l(this.o);
                return;
            }
            videoPbVideoInfoViewHolder.k.setVisibility(8);
            return;
        }
        videoPbVideoInfoViewHolder.k.setVisibility(8);
    }

    public final void N0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048589, this, videoPbVideoInfoViewHolder, metaData, postData) == null) || this.n == null || metaData == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.f19865f.getHeadView().setUserId(metaData.getUserId());
        videoPbVideoInfoViewHolder.f19865f.getHeadView().setUserName(metaData.getUserName());
        videoPbVideoInfoViewHolder.f19865f.getHeadView().setTid(postData.E());
        d.a.p0.h2.h.e eVar = this.n;
        videoPbVideoInfoViewHolder.f19865f.getHeadView().setFid(eVar != null ? eVar.n() : "");
        d.a.p0.h2.h.e eVar2 = this.n;
        videoPbVideoInfoViewHolder.f19865f.getHeadView().setFName(eVar2 != null ? eVar2.o() : "");
        videoPbVideoInfoViewHolder.f19865f.i(metaData, 4);
        videoPbVideoInfoViewHolder.f19865f.m(metaData);
        if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
            videoPbVideoInfoViewHolder.i(true);
            videoPbVideoInfoViewHolder.f19865f.getHeadView().setLiveStatus(1);
            videoPbVideoInfoViewHolder.f19865f.getHeadView().setAlaInfo(postData.t().getAlaInfo());
            H0(postData);
            return;
        }
        videoPbVideoInfoViewHolder.i(false);
        videoPbVideoInfoViewHolder.f19865f.getHeadView().setLiveStatus(0);
        videoPbVideoInfoViewHolder.f19865f.getHeadView().setAlaInfo(null);
    }

    public final void O0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, videoPbVideoInfoViewHolder, metaData, postData) == null) || this.n == null || postData == null || postData.t() == null) {
            return;
        }
        d.a.p0.h2.h.e eVar = this.n;
        String P = eVar != null ? eVar.P() : "";
        int B0 = B0(this.n);
        int i2 = 4;
        if (this.n.N() != null && this.n.N().r2()) {
            i2 = 8;
        }
        if (this.s == null) {
            q0 q0Var = new q0(this.m.getPageContext(), videoPbVideoInfoViewHolder.o, i2);
            this.s = q0Var;
            q0Var.l(this.m.getUniqueId());
        }
        postData.t().setIsLike(postData.t().hadConcerned());
        this.s.n(postData.t());
        this.s.w(P);
        this.s.u(this.n.N());
        q0 q0Var2 = this.s;
        q0Var2.s = true;
        q0Var2.v(B0);
        if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
            videoPbVideoInfoViewHolder.o.setVisibility(8);
        } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
            videoPbVideoInfoViewHolder.o.setVisibility(8);
        }
        if (this.n.f56901i) {
            videoPbVideoInfoViewHolder.o.setVisibility(8);
        }
    }

    public final void P0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, videoPbVideoInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.f19868i.setText(metaData.getName_show());
        videoPbVideoInfoViewHolder.f19868i.setTag(R.id.tag_user_id, metaData.getUserId());
        videoPbVideoInfoViewHolder.f19868i.setTag(R.id.tag_user_name, metaData.getName_show());
        this.u = metaData.isBigV();
        this.v = metaData.isNewGod();
    }

    public final void Q0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, videoPbVideoInfoViewHolder, metaData) == null) || this.n == null || metaData == null) {
            return;
        }
        ArrayList<IconData> iconInfo = metaData.getIconInfo();
        videoPbVideoInfoViewHolder.l.setTag(R.id.tag_user_id, metaData.getUserId());
        videoPbVideoInfoViewHolder.l.g(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
    }

    public final void R0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, videoPbVideoInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.t = true;
            videoPbVideoInfoViewHolder.f19867h.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.f19868i.getLayoutParams();
            layoutParams.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.t = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.f19868i.getLayoutParams();
            layoutParams2.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoPbVideoInfoViewHolder.f19867h.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        G0(i2, view, viewGroup, postData, videoPbVideoInfoViewHolder);
        return view;
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.w = str;
        }
    }

    public final void y0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        d.a.p0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, videoPbVideoInfoViewHolder, postData) == null) || (eVar = this.n) == null || eVar.N() == null || this.n.N().H() == null || postData == null) {
            return;
        }
        N0(videoPbVideoInfoViewHolder, this.n.N().H(), postData);
        R0(videoPbVideoInfoViewHolder, this.n.N().H());
        P0(videoPbVideoInfoViewHolder, this.n.N().H());
        K0(videoPbVideoInfoViewHolder.j, this.n.j());
        M0(videoPbVideoInfoViewHolder, postData);
        Q0(videoPbVideoInfoViewHolder, this.n.N().H());
        J0(videoPbVideoInfoViewHolder, this.n.N().H());
        O0(videoPbVideoInfoViewHolder, this.n.N().H(), postData);
    }

    public final void z0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        d.a.p0.h2.h.e eVar;
        String formatTime;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, videoPbVideoInfoViewHolder, postData) == null) || (eVar = this.n) == null || eVar.N() == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.s(this.f41837e, this.n.N().R0(), this.n.N().getTitle(), this.n.N(), C0(postData), this.n.m0());
        if (this.n.N().l1() != null) {
            String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(this.n.N().l1().play_count.intValue());
            TextView textView = videoPbVideoInfoViewHolder.w;
            textView.setText(numberUniformFormatExtra + this.f41837e.getString(R.string.play));
            TextView textView2 = videoPbVideoInfoViewHolder.D;
            textView2.setText(numberUniformFormatExtra + this.f41837e.getString(R.string.play));
        }
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.R()), "yyyy"))) {
            formatTime = StringHelper.getFormatTimeShort(postData.R());
        } else {
            formatTime = StringHelper.getFormatTime(postData.R());
        }
        TextView textView3 = videoPbVideoInfoViewHolder.x;
        textView3.setText(formatTime + this.f41837e.getString(R.string.send_post));
        TextView textView4 = videoPbVideoInfoViewHolder.E;
        textView4.setText(formatTime + this.f41837e.getString(R.string.send_post));
        g I = postData.I();
        if (I != null && !TextUtils.isEmpty(I.b()) && !TextUtils.isEmpty(I.b().trim())) {
            videoPbVideoInfoViewHolder.y.setText(I.b());
            videoPbVideoInfoViewHolder.F.setText(I.b());
            videoPbVideoInfoViewHolder.y.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.y.setVisibility(8);
        }
        if (I != null && !TextUtils.isEmpty(I.a())) {
            videoPbVideoInfoViewHolder.C.setText(I.a());
            videoPbVideoInfoViewHolder.G.setText(I.a());
            videoPbVideoInfoViewHolder.C.setVisibility(0);
            int measureText = (int) videoPbVideoInfoViewHolder.C.getPaint().measureText(I.a(), 0, I.a().length());
            videoPbVideoInfoViewHolder.z.post(new b(this, videoPbVideoInfoViewHolder, measureText));
            videoPbVideoInfoViewHolder.v.post(new c(this, videoPbVideoInfoViewHolder, measureText));
        } else {
            videoPbVideoInfoViewHolder.C.setVisibility(8);
        }
        PollData D0 = this.n.N().D0();
        if (D0 != null && D0.getOptions() != null && D0.getOptions().size() > 0) {
            videoPbVideoInfoViewHolder.A.setPageContext(this.m.getPageContext());
            videoPbVideoInfoViewHolder.A.setDataForPb(D0, this.n.P(), this.n.n());
            videoPbVideoInfoViewHolder.A.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.A.setVisibility(8);
        }
        LinearLayout linearLayout = videoPbVideoInfoViewHolder.M;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        d.a.p0.h2.h.e eVar2 = this.n;
        if (eVar2 != null && eVar2.N() != null && !D0(this.n.N()) && (!ListUtils.isEmpty(this.n.N().v0()) || !ListUtils.isEmpty(this.n.N().Z()))) {
            l0 l0Var = new l0();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.f41837e);
            d.a.p0.h2.h.e eVar3 = this.n;
            pbLinkGoodsRootView.j(eVar3, l0Var.a(eVar3.N().v0(), this.n.N().Z()), this.n.o(), (VideoPbFragment) this.m, l0Var.b());
            videoPbVideoInfoViewHolder.M.addView(pbLinkGoodsRootView);
            videoPbVideoInfoViewHolder.M.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.M.setVisibility(8);
        }
        videoPbVideoInfoViewHolder.r(this.f41837e, postData);
    }
}
