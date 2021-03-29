package d.b.i0.c2.o.f;

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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
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
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.z0.j0;
import d.b.h0.z0.l0;
import d.b.i0.c2.k.e.o0;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes5.dex */
public class f extends d.b.b.j.e.a<PostData, VideoPbVideoInfoViewHolder> {
    public BaseFragment m;
    public d.b.i0.c2.h.e n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public o0 s;
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
            long j;
            if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                if (f.this.k != null) {
                    int h2 = ((VideoPbVideoInfoViewHolder) f.this.k).h();
                    if (h2 == 1) {
                        ((VideoPbVideoInfoViewHolder) f.this.k).b(2);
                    } else if (h2 == 2) {
                        ((VideoPbVideoInfoViewHolder) f.this.k).b(1);
                    }
                    if (f.this.n.Z() || h2 == 1) {
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
                    d.b.h0.l.a.o(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
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
                    if (alaInfo.isChushou) {
                        UrlManager urlManager = UrlManager.getInstance();
                        TbPageContext<BaseFragmentActivity> pageContext = f.this.m.getPageContext();
                        urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        j = 0;
                    } else {
                        j = 0;
                        if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(f.this.m.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                    }
                    StatisticItem statisticItem = new StatisticItem("c13715");
                    statisticItem.param("fid", fid);
                    statisticItem.param("fname", fName);
                    AlaUserInfoData alaUserInfoData = alaInfo.user_info;
                    statisticItem.param("obj_param1", alaUserInfoData != null ? alaUserInfoData.user_id : j);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("tid", tid);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, floor);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(f.this.f42358e, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(f.this.f42358e, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbVideoInfoViewHolder f53224e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f53225f;

        public b(f fVar, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i) {
            this.f53224e = videoPbVideoInfoViewHolder;
            this.f53225f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
            int measuredWidth = this.f53224e.z.getMeasuredWidth();
            int measuredWidth2 = this.f53224e.w.getMeasuredWidth();
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.f53224e.x.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
            int i = this.f53225f;
            if (measuredWidth3 < i) {
                this.f53224e.C.setVisibility(8);
                this.f53224e.y.setVisibility(8);
            } else if (measuredWidth3 - i < dimenPixelSize3) {
                this.f53224e.y.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbVideoInfoViewHolder f53226e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f53227f;

        public c(f fVar, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i) {
            this.f53226e = videoPbVideoInfoViewHolder;
            this.f53227f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
            int measuredWidth = this.f53226e.v.getMeasuredWidth();
            int measuredWidth2 = this.f53226e.D.getMeasuredWidth();
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.f53226e.E.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
            int i = this.f53227f;
            if (measuredWidth3 < i) {
                this.f53226e.G.setVisibility(8);
                this.f53226e.F.setVisibility(8);
            } else if (measuredWidth3 - i < dimenPixelSize3) {
                this.f53226e.F.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
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

    public final int A0(d.b.i0.c2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return 0;
        }
        if (eVar.L().k2()) {
            return (ListUtils.isEmpty(eVar.p()) && (eVar.h() == null || StringUtils.isNull(eVar.h().i()))) ? 0 : 2;
        }
        return 1;
    }

    public final boolean B0(PostData postData) {
        return postData != null && ListUtils.getCount(postData.i0) >= 2;
    }

    public final boolean C0(a2 a2Var) {
        return (a2Var == null || a2Var.O0() == null || a2Var.O0().getOptions() == null || a2Var.O0().getOptions().size() <= 0) ? false : true;
    }

    public void D0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (videoPbVideoInfoViewHolder == null) {
            return;
        }
        videoPbVideoInfoViewHolder.m(this.o);
        videoPbVideoInfoViewHolder.p(this.t || this.u || this.v);
        videoPbVideoInfoViewHolder.o(this.p, this.r, this.q);
        videoPbVideoInfoViewHolder.n();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: E0 */
    public VideoPbVideoInfoViewHolder R(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f42358e).inflate(R.layout.pb_list_video_info_item, viewGroup, false);
        Context context = this.f42358e;
        BaseFragment baseFragment = this.m;
        VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(context, inflate, baseFragment instanceof VideoPbFragment ? (VideoPbFragment) baseFragment : null);
        videoPbVideoInfoViewHolder.q(this.x);
        D0(videoPbVideoInfoViewHolder);
        this.k = videoPbVideoInfoViewHolder;
        return videoPbVideoInfoViewHolder;
    }

    public View F0(int i, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        d.b.i0.c2.h.e eVar = this.n;
        if (eVar != null && eVar.L() != null && postData != null) {
            d.b.i0.c2.m.a.d(this.m.getUniqueId(), this.n, postData, 1, 1);
            K0(videoPbVideoInfoViewHolder);
            x0(videoPbVideoInfoViewHolder, postData);
            y0(videoPbVideoInfoViewHolder, postData);
            z0(videoPbVideoInfoViewHolder, postData);
            D0(videoPbVideoInfoViewHolder);
        }
        return view;
    }

    public final void G0(PostData postData) {
        if (postData == null || postData.s() == null) {
            return;
        }
        String userId = postData.s().getUserId();
        d.b.i0.c2.h.e eVar = this.n;
        String m = eVar != null ? eVar.m() : "";
        d.b.i0.c2.h.e eVar2 = this.n;
        String n = eVar2 != null ? eVar2.n() : "";
        int z = postData.z();
        String D = postData.D();
        StatisticItem statisticItem = new StatisticItem("c13714");
        statisticItem.param("fid", m);
        statisticItem.param("fname", n);
        statisticItem.param("obj_param1", userId);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("tid", D);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, z);
        TiebaStatic.log(statisticItem);
    }

    public void H0(d.b.i0.c2.h.e eVar) {
        this.n = eVar;
    }

    public final void I0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.n != null && metaData != null) {
            String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
            TextView textView = videoPbVideoInfoViewHolder.n;
            textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.n.getLayoutParams();
            layoutParams.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            videoPbVideoInfoViewHolder.m.setText(metaData.getNewGodData().getFieldName() + l0.c(metaData.getNewGodData().isVideoGod()));
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

    public final void J0(TextView textView, PostData postData) {
        if (textView == null && postData == null) {
            return;
        }
        textView.setTag(postData);
        d.b.i0.c2.h.e eVar = this.n;
        if (eVar != null && eVar.Z()) {
            textView.setVisibility(8);
            textView.setTag(null);
        } else if (postData.s() != null) {
            MetaData s = postData.s();
            String str = this.w;
            if (str != null && !str.equals("0") && this.w.equals(s.getUserId())) {
                textView.setVisibility(0);
                textView.setText(R.string.host_name);
                textView.setBackgroundColor(0);
                d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(textView);
                a2.n(R.color.CAM_X0302);
                a2.h(R.string.J_X04);
                a2.f(R.dimen.L_X01);
                a2.e(R.color.CAM_X0302);
            } else if (s.getIs_bawu() == 1 && postData.W()) {
                d.b.h0.r.u.c a3 = d.b.h0.r.u.c.a(textView);
                a3.n(R.color.CAM_X0101);
                a3.h(R.string.J_X04);
                a3.c(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.brand_official);
            } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                d.b.h0.r.u.c a4 = d.b.h0.r.u.c.a(textView);
                a4.n(R.color.CAM_X0101);
                a4.h(R.string.J_X04);
                a4.c(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_member_bazhu_tip);
            } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                d.b.h0.r.u.c a5 = d.b.h0.r.u.c.a(textView);
                a5.n(R.color.CAM_X0101);
                a5.h(R.string.J_X04);
                a5.c(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_member_xbazhu_tip);
            } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                d.b.h0.r.u.c a6 = d.b.h0.r.u.c.a(textView);
                a6.n(R.color.CAM_X0101);
                a6.h(R.string.J_X04);
                a6.c(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_content_assist_tip);
            } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                d.b.h0.r.u.c a7 = d.b.h0.r.u.c.a(textView);
                a7.n(R.color.CAM_X0101);
                a7.h(R.string.J_X04);
                a7.c(R.color.CAM_X0302);
                textView.setVisibility(0);
                textView.setText(R.string.bawu_manage_assist_tip);
            } else {
                textView.setVisibility(8);
            }
        } else {
            textView.setVisibility(8);
        }
    }

    public final void K0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        d.b.i0.c2.h.e eVar = this.n;
        if (eVar == null) {
            return;
        }
        this.p = eVar.j;
        if (eVar.L() != null) {
            this.r = this.n.L().w0() == 1;
            this.q = this.n.L().x0() == 1;
        }
        videoPbVideoInfoViewHolder.o(this.p, this.r, this.q);
    }

    public final void L0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        d.b.i0.c2.h.e eVar = this.n;
        if (eVar == null || eVar.L() == null) {
            return;
        }
        this.o = 0;
        if (!this.n.L().k2()) {
            if (postData != null && postData.s() != null) {
                this.o = postData.s().getLevel_id();
            }
            if (!this.n.Z()) {
                videoPbVideoInfoViewHolder.k.setVisibility(0);
                videoPbVideoInfoViewHolder.m(this.o);
                return;
            }
            videoPbVideoInfoViewHolder.k.setVisibility(8);
            return;
        }
        videoPbVideoInfoViewHolder.k.setVisibility(8);
    }

    public final void M0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.n == null || metaData == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.f20120f.getHeadView().setUserId(metaData.getUserId());
        videoPbVideoInfoViewHolder.f20120f.getHeadView().setUserName(metaData.getUserName());
        videoPbVideoInfoViewHolder.f20120f.getHeadView().setTid(postData.D());
        d.b.i0.c2.h.e eVar = this.n;
        videoPbVideoInfoViewHolder.f20120f.getHeadView().setFid(eVar != null ? eVar.m() : "");
        d.b.i0.c2.h.e eVar2 = this.n;
        videoPbVideoInfoViewHolder.f20120f.getHeadView().setFName(eVar2 != null ? eVar2.n() : "");
        videoPbVideoInfoViewHolder.f20120f.i(metaData, 4);
        videoPbVideoInfoViewHolder.f20120f.m(metaData);
        if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
            videoPbVideoInfoViewHolder.j(true);
            videoPbVideoInfoViewHolder.f20120f.getHeadView().setLiveStatus(1);
            videoPbVideoInfoViewHolder.f20120f.getHeadView().setAlaInfo(postData.s().getAlaInfo());
            G0(postData);
            return;
        }
        videoPbVideoInfoViewHolder.j(false);
        videoPbVideoInfoViewHolder.f20120f.getHeadView().setLiveStatus(0);
        videoPbVideoInfoViewHolder.f20120f.getHeadView().setAlaInfo(null);
    }

    public final void N0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.n == null || postData == null || postData.s() == null) {
            return;
        }
        d.b.i0.c2.h.e eVar = this.n;
        String N = eVar != null ? eVar.N() : "";
        int A0 = A0(this.n);
        int i = 4;
        if (this.n.L() != null && this.n.L().z2()) {
            i = 8;
        }
        if (this.s == null) {
            o0 o0Var = new o0(this.m.getPageContext(), videoPbVideoInfoViewHolder.o, i);
            this.s = o0Var;
            o0Var.l(this.m.getUniqueId());
        }
        postData.s().setIsLike(postData.s().hadConcerned());
        this.s.n(postData.s());
        this.s.x(N);
        this.s.v(this.n.L());
        o0 o0Var2 = this.s;
        o0Var2.r = true;
        o0Var2.w(A0);
        if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
            videoPbVideoInfoViewHolder.o.setVisibility(8);
        } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
            videoPbVideoInfoViewHolder.o.setVisibility(8);
        }
        if (this.n.i) {
            videoPbVideoInfoViewHolder.o.setVisibility(8);
        }
    }

    public final void O0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.i.setText(metaData.getName_show());
        videoPbVideoInfoViewHolder.i.setTag(R.id.tag_user_id, metaData.getUserId());
        videoPbVideoInfoViewHolder.i.setTag(R.id.tag_user_name, metaData.getName_show());
        this.u = metaData.isBigV();
        this.v = metaData.isNewGod();
    }

    public final void P0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.n == null || metaData == null) {
            return;
        }
        ArrayList<IconData> iconInfo = metaData.getIconInfo();
        videoPbVideoInfoViewHolder.l.setTag(R.id.tag_user_id, metaData.getUserId());
        videoPbVideoInfoViewHolder.l.g(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
    }

    public final void Q0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.t = true;
            videoPbVideoInfoViewHolder.f20122h.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.i.getLayoutParams();
            layoutParams.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.t = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.i.getLayoutParams();
            layoutParams2.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoPbVideoInfoViewHolder.f20122h.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        F0(i, view, viewGroup, postData, videoPbVideoInfoViewHolder);
        return view;
    }

    public void n(String str) {
        this.w = str;
    }

    public final void x0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        d.b.i0.c2.h.e eVar = this.n;
        if (eVar == null || eVar.L() == null || this.n.L().T() == null || postData == null) {
            return;
        }
        M0(videoPbVideoInfoViewHolder, this.n.L().T(), postData);
        Q0(videoPbVideoInfoViewHolder, this.n.L().T());
        O0(videoPbVideoInfoViewHolder, this.n.L().T());
        J0(videoPbVideoInfoViewHolder.j, this.n.j());
        L0(videoPbVideoInfoViewHolder, postData);
        P0(videoPbVideoInfoViewHolder, this.n.L().T());
        I0(videoPbVideoInfoViewHolder, this.n.L().T());
        N0(videoPbVideoInfoViewHolder, this.n.L().T(), postData);
    }

    public final void y0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        String formatTime;
        d.b.i0.c2.h.e eVar = this.n;
        if (eVar == null || eVar.L() == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.u(this.f42358e, this.n.L().b1(), this.n.L().x1(), this.n.L(), B0(postData), this.n.f0());
        if (this.n.L().u1() != null) {
            String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(this.n.L().u1().play_count.intValue());
            TextView textView = videoPbVideoInfoViewHolder.w;
            textView.setText(numberUniformFormatExtra + this.f42358e.getString(R.string.play));
            TextView textView2 = videoPbVideoInfoViewHolder.D;
            textView2.setText(numberUniformFormatExtra + this.f42358e.getString(R.string.play));
        }
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.Q()), "yyyy"))) {
            formatTime = StringHelper.getFormatTimeShort(postData.Q());
        } else {
            formatTime = StringHelper.getFormatTime(postData.Q());
        }
        TextView textView3 = videoPbVideoInfoViewHolder.x;
        textView3.setText(formatTime + this.f42358e.getString(R.string.send_post));
        TextView textView4 = videoPbVideoInfoViewHolder.E;
        textView4.setText(formatTime + this.f42358e.getString(R.string.send_post));
        d.b.h0.t.f H = postData.H();
        if (H != null && !TextUtils.isEmpty(H.b()) && !TextUtils.isEmpty(H.b().trim())) {
            videoPbVideoInfoViewHolder.y.setText(H.b());
            videoPbVideoInfoViewHolder.F.setText(H.b());
            videoPbVideoInfoViewHolder.y.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.y.setVisibility(8);
        }
        if (H != null && !TextUtils.isEmpty(H.a())) {
            videoPbVideoInfoViewHolder.C.setText(H.a());
            videoPbVideoInfoViewHolder.G.setText(H.a());
            videoPbVideoInfoViewHolder.C.setVisibility(0);
            int measureText = (int) videoPbVideoInfoViewHolder.C.getPaint().measureText(H.a(), 0, H.a().length());
            videoPbVideoInfoViewHolder.z.post(new b(this, videoPbVideoInfoViewHolder, measureText));
            videoPbVideoInfoViewHolder.v.post(new c(this, videoPbVideoInfoViewHolder, measureText));
        } else {
            videoPbVideoInfoViewHolder.C.setVisibility(8);
        }
        PollData O0 = this.n.L().O0();
        if (O0 != null && O0.getOptions() != null && O0.getOptions().size() > 0) {
            videoPbVideoInfoViewHolder.A.setPageContext(this.m.getPageContext());
            videoPbVideoInfoViewHolder.A.setDataForPb(O0, this.n.N(), this.n.m());
            videoPbVideoInfoViewHolder.A.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.A.setVisibility(8);
        }
        LinearLayout linearLayout = videoPbVideoInfoViewHolder.L;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        d.b.i0.c2.h.e eVar2 = this.n;
        if (eVar2 != null && eVar2.L() != null && !C0(this.n.L()) && (!ListUtils.isEmpty(this.n.L().G0()) || !ListUtils.isEmpty(this.n.L().l0()))) {
            j0 j0Var = new j0();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.f42358e);
            d.b.i0.c2.h.e eVar3 = this.n;
            pbLinkGoodsRootView.j(eVar3, j0Var.a(eVar3.L().G0(), this.n.L().l0()), this.n.n(), (VideoPbFragment) this.m, j0Var.b());
            videoPbVideoInfoViewHolder.L.addView(pbLinkGoodsRootView);
            videoPbVideoInfoViewHolder.L.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.L.setVisibility(8);
        }
        videoPbVideoInfoViewHolder.s(this.f42358e, postData);
    }

    public final void z0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        videoPbVideoInfoViewHolder.r(8, null);
        d.b.i0.c2.h.e eVar = this.n;
        if (eVar == null || eVar.L() == null || postData == null) {
            return;
        }
        if (postData.S) {
            videoPbVideoInfoViewHolder.r(0, postData.D());
        }
        BaseFragment baseFragment = this.m;
        if (baseFragment instanceof VideoPbFragment) {
            ((VideoPbFragment) baseFragment).K4(postData.S);
        }
    }
}
