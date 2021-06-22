package d.a.o0.e2.o.m;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.r.q.a2;
import d.a.n0.t.g;
import d.a.n0.z0.j0;
import d.a.n0.z0.l0;
import d.a.o0.e2.k.e.q0;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes5.dex */
public class f extends d.a.c.k.e.a<PostData, VideoPbVideoInfoViewHolder> {
    public BaseFragment m;
    public d.a.o0.e2.h.e n;
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                if (f.this.k != null) {
                    int h2 = ((VideoPbVideoInfoViewHolder) f.this.k).h();
                    if (h2 == 1) {
                        ((VideoPbVideoInfoViewHolder) f.this.k).b(2);
                    } else if (h2 == 2) {
                        ((VideoPbVideoInfoViewHolder) f.this.k).b(1);
                    }
                    if (f.this.n.a0() || h2 == 1) {
                        ((VideoPbVideoInfoViewHolder) f.this.k).y.setVisibility(8);
                        ((VideoPbVideoInfoViewHolder) f.this.k).C.setVisibility(8);
                    } else {
                        ((VideoPbVideoInfoViewHolder) f.this.k).y.setVisibility(0);
                        ((VideoPbVideoInfoViewHolder) f.this.k).C.setVisibility(0);
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
                        UrlManager.getInstance().dealOneLink(f.this.m.getPageContext(), new String[]{r7});
                    }
                    TiebaStatic.eventStat(f.this.m.getPageContext().getPageActivity(), "consume_2", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
            } else if (view.getId() == R.id.user_yinji_video_info_item) {
                if (view.getTag(R.id.tag_user_id) instanceof String) {
                    d.a.n0.l.a.o(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
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
                        YYLiveUtil.jumpYYLiveRoom(f.this.m.getPageContext(), alaInfo);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(f.this.f43012e, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                }
            } else if (view.getId() == R.id.user_name_video_info_item) {
                TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                if (f.this.n != null && f.this.n.l() != null) {
                    r7 = f.this.n.l().getName();
                }
                String str3 = r7;
                StatisticItem statisticItem3 = new StatisticItem("c13267");
                statisticItem3.param("uid", str);
                if (f.this.n != null) {
                    statisticItem3.param("fid", f.this.n.m());
                    statisticItem3.param("tid", f.this.n.N());
                }
                statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem3);
                if (str != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(f.this.f43012e, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbVideoInfoViewHolder f57628e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f57629f;

        public b(f fVar, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i2) {
            this.f57628e = videoPbVideoInfoViewHolder;
            this.f57629f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
            int measuredWidth = this.f57628e.z.getMeasuredWidth();
            int measuredWidth2 = this.f57628e.w.getMeasuredWidth();
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.f57628e.x.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
            int i2 = this.f57629f;
            if (measuredWidth3 < i2) {
                this.f57628e.C.setVisibility(8);
                this.f57628e.y.setVisibility(8);
            } else if (measuredWidth3 - i2 < dimenPixelSize3) {
                this.f57628e.y.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbVideoInfoViewHolder f57630e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f57631f;

        public c(f fVar, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i2) {
            this.f57630e = videoPbVideoInfoViewHolder;
            this.f57631f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
            int measuredWidth = this.f57630e.v.getMeasuredWidth();
            int measuredWidth2 = this.f57630e.D.getMeasuredWidth();
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.f57630e.E.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
            int i2 = this.f57631f;
            if (measuredWidth3 < i2) {
                this.f57630e.G.setVisibility(8);
                this.f57630e.F.setVisibility(8);
            } else if (measuredWidth3 - i2 < dimenPixelSize3) {
                this.f57630e.F.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.k == null || ((VideoPbVideoInfoViewHolder) f.this.k).q == null) {
                return;
            }
            ((VideoPbVideoInfoViewHolder) f.this.k).q.setTextSize(TbConfig.getContentSize());
            f.this.L();
        }
    }

    public f(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.w = null;
        this.x = new a();
        d dVar = new d(2004018);
        this.y = dVar;
        this.m = baseFragment;
        baseFragment.registerListener(dVar);
    }

    public final void A0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        videoPbVideoInfoViewHolder.r(8, null);
        d.a.o0.e2.h.e eVar = this.n;
        if (eVar == null || eVar.L() == null || postData == null) {
            return;
        }
        if (postData.S) {
            videoPbVideoInfoViewHolder.r(0, postData.E());
        }
        BaseFragment baseFragment = this.m;
        if (baseFragment instanceof VideoPbFragment) {
            ((VideoPbFragment) baseFragment).f5(postData.S);
        }
    }

    public final int B0(d.a.o0.e2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return 0;
        }
        if (eVar.L().o2()) {
            return (ListUtils.isEmpty(eVar.p()) && (eVar.h() == null || StringUtils.isNull(eVar.h().h()))) ? 0 : 2;
        }
        return 1;
    }

    public final boolean C0(PostData postData) {
        return postData != null && ListUtils.getCount(postData.n0) >= 2;
    }

    public final boolean D0(a2 a2Var) {
        return (a2Var == null || a2Var.P0() == null || a2Var.P0().getOptions() == null || a2Var.P0().getOptions().size() <= 0) ? false : true;
    }

    public void E0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (videoPbVideoInfoViewHolder == null) {
            return;
        }
        videoPbVideoInfoViewHolder.m(this.o);
        videoPbVideoInfoViewHolder.p(this.t || this.u || this.v);
        videoPbVideoInfoViewHolder.o(this.p, this.r, this.q);
        videoPbVideoInfoViewHolder.n();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: F0 */
    public VideoPbVideoInfoViewHolder Q(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f43012e).inflate(R.layout.pb_list_video_info_item, viewGroup, false);
        Context context = this.f43012e;
        BaseFragment baseFragment = this.m;
        VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(context, inflate, baseFragment instanceof VideoPbFragment ? (VideoPbFragment) baseFragment : null);
        videoPbVideoInfoViewHolder.q(this.x);
        E0(videoPbVideoInfoViewHolder);
        this.k = videoPbVideoInfoViewHolder;
        return videoPbVideoInfoViewHolder;
    }

    public View G0(int i2, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        d.a.o0.e2.h.e eVar = this.n;
        if (eVar != null && eVar.L() != null && postData != null) {
            d.a.o0.e2.m.a.d(this.m.getUniqueId(), this.n, postData, 1, 1);
            L0(videoPbVideoInfoViewHolder);
            y0(videoPbVideoInfoViewHolder, postData);
            z0(videoPbVideoInfoViewHolder, postData);
            A0(videoPbVideoInfoViewHolder, postData);
            E0(videoPbVideoInfoViewHolder);
            videoPbVideoInfoViewHolder.H.setVisibility(d.a.n0.c1.b.e.d() ? 0 : 8);
        }
        return view;
    }

    public final void H0(PostData postData) {
        if (postData == null || postData.t() == null) {
            return;
        }
        String userId = postData.t().getUserId();
        d.a.o0.e2.h.e eVar = this.n;
        String m = eVar != null ? eVar.m() : "";
        d.a.o0.e2.h.e eVar2 = this.n;
        String n = eVar2 != null ? eVar2.n() : "";
        int A = postData.A();
        String E = postData.E();
        StatisticItem statisticItem = new StatisticItem("c13714");
        statisticItem.param("fid", m);
        statisticItem.param("fname", n);
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

    public void I0(d.a.o0.e2.h.e eVar) {
        this.n = eVar;
    }

    public final void J0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.n != null && metaData != null) {
            String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
            TextView textView = videoPbVideoInfoViewHolder.n;
            textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.n.getLayoutParams();
            layoutParams.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            videoPbVideoInfoViewHolder.m.setText(metaData.getNewGodData().getFieldName() + l0.d(metaData.getNewGodData().isVideoGod()));
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

    public final void K0(TextView textView, PostData postData) {
        if (textView == null && postData == null) {
            return;
        }
        textView.setTag(postData);
        d.a.o0.e2.h.e eVar = this.n;
        if (eVar != null && eVar.a0()) {
            textView.setVisibility(8);
            textView.setTag(null);
        } else if (postData.t() != null) {
            MetaData t = postData.t();
            String str = this.w;
            if (str != null && !str.equals("0") && this.w.equals(t.getUserId())) {
                textView.setVisibility(0);
                textView.setText(R.string.host_name);
                textView.setBackgroundColor(0);
                d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(textView);
                d2.s(R.color.CAM_X0302);
                d2.m(R.string.J_X04);
                d2.k(R.dimen.L_X01);
                d2.j(R.color.CAM_X0302);
            } else if (t.getIs_bawu() == 1 && postData.X()) {
                d.a.n0.r.u.c d3 = d.a.n0.r.u.c.d(textView);
                d3.s(R.color.CAM_X0101);
                d3.m(R.string.J_X04);
                d3.f(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.brand_official);
            } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                d.a.n0.r.u.c d4 = d.a.n0.r.u.c.d(textView);
                d4.s(R.color.CAM_X0101);
                d4.m(R.string.J_X04);
                d4.f(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_member_bazhu_tip);
            } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                d.a.n0.r.u.c d5 = d.a.n0.r.u.c.d(textView);
                d5.s(R.color.CAM_X0101);
                d5.m(R.string.J_X04);
                d5.f(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_member_xbazhu_tip);
            } else if (t.getIs_bawu() == 1 && "pri_content_assist".equals(t.getBawu_type())) {
                d.a.n0.r.u.c d6 = d.a.n0.r.u.c.d(textView);
                d6.s(R.color.CAM_X0101);
                d6.m(R.string.J_X04);
                d6.f(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_content_assist_tip);
            } else if (t.getIs_bawu() == 1 && "pri_manage_assist".equals(t.getBawu_type())) {
                d.a.n0.r.u.c d7 = d.a.n0.r.u.c.d(textView);
                d7.s(R.color.CAM_X0101);
                d7.m(R.string.J_X04);
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

    public final void L0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        d.a.o0.e2.h.e eVar = this.n;
        if (eVar == null) {
            return;
        }
        this.p = eVar.j;
        if (eVar.L() != null) {
            this.r = this.n.L().x0() == 1;
            this.q = this.n.L().y0() == 1;
        }
        videoPbVideoInfoViewHolder.o(this.p, this.r, this.q);
    }

    public final void M0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        d.a.o0.e2.h.e eVar = this.n;
        if (eVar == null || eVar.L() == null) {
            return;
        }
        this.o = 0;
        if (!this.n.L().o2()) {
            if (postData != null && postData.t() != null) {
                this.o = postData.t().getLevel_id();
            }
            if (!this.n.a0()) {
                videoPbVideoInfoViewHolder.k.setVisibility(0);
                videoPbVideoInfoViewHolder.m(this.o);
                return;
            }
            videoPbVideoInfoViewHolder.k.setVisibility(8);
            return;
        }
        videoPbVideoInfoViewHolder.k.setVisibility(8);
    }

    public final void N0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.n == null || metaData == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.f19675f.getHeadView().setUserId(metaData.getUserId());
        videoPbVideoInfoViewHolder.f19675f.getHeadView().setUserName(metaData.getUserName());
        videoPbVideoInfoViewHolder.f19675f.getHeadView().setTid(postData.E());
        d.a.o0.e2.h.e eVar = this.n;
        videoPbVideoInfoViewHolder.f19675f.getHeadView().setFid(eVar != null ? eVar.m() : "");
        d.a.o0.e2.h.e eVar2 = this.n;
        videoPbVideoInfoViewHolder.f19675f.getHeadView().setFName(eVar2 != null ? eVar2.n() : "");
        videoPbVideoInfoViewHolder.f19675f.i(metaData, 4);
        videoPbVideoInfoViewHolder.f19675f.m(metaData);
        if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
            videoPbVideoInfoViewHolder.j(true);
            videoPbVideoInfoViewHolder.f19675f.getHeadView().setLiveStatus(1);
            videoPbVideoInfoViewHolder.f19675f.getHeadView().setAlaInfo(postData.t().getAlaInfo());
            H0(postData);
            return;
        }
        videoPbVideoInfoViewHolder.j(false);
        videoPbVideoInfoViewHolder.f19675f.getHeadView().setLiveStatus(0);
        videoPbVideoInfoViewHolder.f19675f.getHeadView().setAlaInfo(null);
    }

    public final void O0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.n == null || postData == null || postData.t() == null) {
            return;
        }
        d.a.o0.e2.h.e eVar = this.n;
        String N = eVar != null ? eVar.N() : "";
        int B0 = B0(this.n);
        int i2 = 4;
        if (this.n.L() != null && this.n.L().E2()) {
            i2 = 8;
        }
        if (this.s == null) {
            q0 q0Var = new q0(this.m.getPageContext(), videoPbVideoInfoViewHolder.o, i2);
            this.s = q0Var;
            q0Var.l(this.m.getUniqueId());
        }
        postData.t().setIsLike(postData.t().hadConcerned());
        this.s.n(postData.t());
        this.s.w(N);
        this.s.u(this.n.L());
        q0 q0Var2 = this.s;
        q0Var2.s = true;
        q0Var2.v(B0);
        if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
            videoPbVideoInfoViewHolder.o.setVisibility(8);
        } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
            videoPbVideoInfoViewHolder.o.setVisibility(8);
        }
        if (this.n.f56741i) {
            videoPbVideoInfoViewHolder.o.setVisibility(8);
        }
    }

    public final void P0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.f19678i.setText(metaData.getName_show());
        videoPbVideoInfoViewHolder.f19678i.setTag(R.id.tag_user_id, metaData.getUserId());
        videoPbVideoInfoViewHolder.f19678i.setTag(R.id.tag_user_name, metaData.getName_show());
        this.u = metaData.isBigV();
        this.v = metaData.isNewGod();
    }

    public final void Q0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.n == null || metaData == null) {
            return;
        }
        ArrayList<IconData> iconInfo = metaData.getIconInfo();
        videoPbVideoInfoViewHolder.l.setTag(R.id.tag_user_id, metaData.getUserId());
        videoPbVideoInfoViewHolder.l.g(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
    }

    public final void R0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.t = true;
            videoPbVideoInfoViewHolder.f19677h.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.f19678i.getLayoutParams();
            layoutParams.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.t = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.f19678i.getLayoutParams();
            layoutParams2.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoPbVideoInfoViewHolder.f19677h.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        G0(i2, view, viewGroup, postData, videoPbVideoInfoViewHolder);
        return view;
    }

    public void q(String str) {
        this.w = str;
    }

    public final void y0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        d.a.o0.e2.h.e eVar = this.n;
        if (eVar == null || eVar.L() == null || this.n.L().T() == null || postData == null) {
            return;
        }
        N0(videoPbVideoInfoViewHolder, this.n.L().T(), postData);
        R0(videoPbVideoInfoViewHolder, this.n.L().T());
        P0(videoPbVideoInfoViewHolder, this.n.L().T());
        K0(videoPbVideoInfoViewHolder.j, this.n.j());
        M0(videoPbVideoInfoViewHolder, postData);
        Q0(videoPbVideoInfoViewHolder, this.n.L().T());
        J0(videoPbVideoInfoViewHolder, this.n.L().T());
        O0(videoPbVideoInfoViewHolder, this.n.L().T(), postData);
    }

    public final void z0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        String formatTime;
        d.a.o0.e2.h.e eVar = this.n;
        if (eVar == null || eVar.L() == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.t(this.f43012e, this.n.L().d1(), this.n.L().A1(), this.n.L(), C0(postData), this.n.g0());
        if (this.n.L().x1() != null) {
            String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(this.n.L().x1().play_count.intValue());
            TextView textView = videoPbVideoInfoViewHolder.w;
            textView.setText(numberUniformFormatExtra + this.f43012e.getString(R.string.play));
            TextView textView2 = videoPbVideoInfoViewHolder.D;
            textView2.setText(numberUniformFormatExtra + this.f43012e.getString(R.string.play));
        }
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.R()), "yyyy"))) {
            formatTime = StringHelper.getFormatTimeShort(postData.R());
        } else {
            formatTime = StringHelper.getFormatTime(postData.R());
        }
        TextView textView3 = videoPbVideoInfoViewHolder.x;
        textView3.setText(formatTime + this.f43012e.getString(R.string.send_post));
        TextView textView4 = videoPbVideoInfoViewHolder.E;
        textView4.setText(formatTime + this.f43012e.getString(R.string.send_post));
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
        PollData P0 = this.n.L().P0();
        if (P0 != null && P0.getOptions() != null && P0.getOptions().size() > 0) {
            videoPbVideoInfoViewHolder.A.setPageContext(this.m.getPageContext());
            videoPbVideoInfoViewHolder.A.setDataForPb(P0, this.n.N(), this.n.m());
            videoPbVideoInfoViewHolder.A.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.A.setVisibility(8);
        }
        LinearLayout linearLayout = videoPbVideoInfoViewHolder.M;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        d.a.o0.e2.h.e eVar2 = this.n;
        if (eVar2 != null && eVar2.L() != null && !D0(this.n.L()) && (!ListUtils.isEmpty(this.n.L().H0()) || !ListUtils.isEmpty(this.n.L().l0()))) {
            j0 j0Var = new j0();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.f43012e);
            d.a.o0.e2.h.e eVar3 = this.n;
            pbLinkGoodsRootView.j(eVar3, j0Var.a(eVar3.L().H0(), this.n.L().l0()), this.n.n(), (VideoPbFragment) this.m, j0Var.b());
            videoPbVideoInfoViewHolder.M.addView(pbLinkGoodsRootView);
            videoPbVideoInfoViewHolder.M.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.M.setVisibility(8);
        }
        videoPbVideoInfoViewHolder.s(this.f43012e, postData);
    }
}
