package d.a.n0.z;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.v0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class n extends d.a.n0.z.b<d.a.n0.z.e0.k> implements d.a.n0.o.e {
    public static final int L = d.a.c.e.p.l.k(TbadkCoreApplication.getInst()) - ((d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    public ConstrainImageGroup A;
    public View B;
    public boolean C;
    public boolean D;
    public RelativeLayout E;
    public String F;
    public ThreadForumEnterButton G;
    public String H;
    public View.OnClickListener I;
    public final View.OnClickListener J;
    public final View.OnClickListener K;
    public HeadPendantClickableView m;
    public PlayVoiceBntNew n;
    public ThreadCommentAndPraiseInfoLayout o;
    public ThreadGodReplyLayout p;
    public ThreadUserInfoLayout q;
    public LinearLayout r;
    public NEGFeedBackView s;
    public View t;
    public ThreadSourceShareAndPraiseLayout u;
    public int v;
    public d.a.n0.z.e0.k w;
    public TbPageContext<?> x;
    public TextView y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (n.this.h() != null) {
                n.this.h().a(view, n.this.w);
            }
            if (n.this.w == null || n.this.w.f63459e == null) {
                return;
            }
            m.a(n.this.w.f63459e.o0());
            if (n.this.G()) {
                return;
            }
            m.l(n.this.y, n.this.w.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(n.this.z, n.this.w.f63459e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(n.this.p.getGodReplyContent(), n.this.w.f63459e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (n.this.h() != null) {
                n.this.h().a(view, n.this.w);
            }
            if (n.this.w == null || n.this.w.f63459e == null) {
                return;
            }
            n nVar = n.this;
            if (view == nVar.u.f12400e) {
                return;
            }
            m.a(nVar.w.f63459e.o0());
            if (n.this.G()) {
                return;
            }
            m.l(n.this.y, n.this.w.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(n.this.z, n.this.w.f63459e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(n.this.p.getGodReplyContent(), n.this.w.f63459e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.m0.b1.j.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinkedList f63536a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a2 f63537b;

        public c(LinkedList linkedList, a2 a2Var) {
            this.f63536a = linkedList;
            this.f63537b = a2Var;
        }

        @Override // d.a.m0.b1.j.d
        public void a(View view, int i2, boolean z) {
            b0<d.a.n0.z.e0.k> h2 = n.this.h();
            if (h2 != null) {
                view.setTag("1");
                if (n.this.K != null) {
                    n.this.K.onClick(n.this.A);
                }
                h2.a(view, n.this.w);
            }
            if (z) {
                n.this.H();
            } else {
                n.this.T(view, this.f63536a, i2, this.f63537b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (n.this.w != null) {
                n.this.w.k = 1;
            }
            if (n.this.h() != null) {
                n.this.h().a(view, n.this.w);
            }
            n nVar = n.this;
            nVar.I(view == nVar.p);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.n0.z.e0.k> h2 = n.this.h();
            if (h2 != null) {
                view.setTag("2");
                h2.a(view, n.this.w);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (n.this.w == null) {
                if (n.this.h() != null) {
                    n.this.h().a(view, n.this.w);
                    return;
                }
                return;
            }
            if (view == n.this.q.getUserName()) {
                n.this.w.k = 3;
            } else if (view == n.this.q.getHeaderImg()) {
                n.this.w.k = 4;
            } else if (view == n.this.A) {
                n.this.w.k = 2;
                return;
            } else {
                n.this.w.k = 1;
            }
            if (n.this.h() != null) {
                n.this.h().a(view, n.this.w);
            }
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.s = null;
        this.v = 3;
        this.C = true;
        this.D = true;
        this.I = new d();
        this.J = new e();
        this.K = new f();
        View l = l();
        this.x = tbPageContext;
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) l.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setPlaceHolder(1);
            this.m.getHeadView().setRadius(d.a.c.e.p.l.g(this.x.getPageActivity(), R.dimen.ds70));
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        this.y = (TextView) l.findViewById(R.id.card_home_page_normal_thread_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) l.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.n = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(this.J);
        this.z = (TextView) l.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.A = (ConstrainImageGroup) l.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.B = l.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.A.setChildClickListener(this.I);
        this.A.setImageMargin(dimensionPixelSize);
        d.a.m0.b1.j.f fVar = new d.a.m0.b1.j.f(3);
        fVar.d(1.0d);
        this.A.setImageProcessor(fVar);
        this.t = l.findViewById(R.id.divider_line_above_praise);
        this.o = (ThreadCommentAndPraiseInfoLayout) l.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.q = (ThreadUserInfoLayout) l.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.s = new NEGFeedBackView(this.x);
        this.E = (RelativeLayout) l.findViewById(R.id.card_home_page_normal_thread_root);
        this.s.l(this.E, d.a.c.e.p.l.g(this.f63442g, R.dimen.tbds120), 0);
        if (this.o.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.o.setLayoutParams(layoutParams);
        }
        this.o.setOnClickListener(this.I);
        this.o.setReplyTimeVisible(false);
        this.o.setShowPraiseNum(true);
        this.o.setNeedAddPraiseIcon(true);
        this.o.setNeedAddReplyIcon(true);
        this.o.setShareVisible(true);
        this.o.setFrom(1);
        this.o.setShareReportFrom(3);
        this.o.setForumAfterClickListener(new a());
        this.r = (LinearLayout) l.findViewById(R.id.card_home_page_normal_thread_content_layout);
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) l.findViewById(R.id.card_home_page_god_reply_layout);
        this.p = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this.I);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) l.findViewById(R.id.card_home_page_source_read_share_layout);
        this.u = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f12401f.setOnClickListener(this.I);
        this.u.setFrom(1);
        this.u.setShareReportFrom(3);
        this.u.setForumAfterClickListener(new b());
        this.G = (ThreadForumEnterButton) l.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public int F(int i2) {
        return d.a.n0.o.d.c().b(this.F, i2);
    }

    public final boolean G() {
        d.a.n0.z.e0.k kVar = this.w;
        return kVar.T && !kVar.U;
    }

    public final void H() {
        I(false);
    }

    public final void I(boolean z) {
        d.a.n0.z.e0.k kVar = this.w;
        if (kVar == null || kVar.f63459e == null) {
            return;
        }
        if (!G()) {
            m.a(this.w.f63459e.o0());
            m.l(this.y, this.w.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(this.z, this.w.f63459e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(this.p.getGodReplyContent(), this.w.f63459e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        PbActivityConfig addLocateParam = new PbActivityConfig(this.x.getPageActivity()).createFromThreadCfg(this.w.f63459e, null, m.g(), 18003, true, false, false).addLocateParam(this.w.l());
        addLocateParam.setForumId(String.valueOf(this.w.f63459e.c0()));
        addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
        addLocateParam.setForumName(this.w.f63459e.i0());
        addLocateParam.setStartFrom(this.l);
        if (z) {
            addLocateParam.setJumpGodReply(true);
        }
        m.a(this.w.m().y1());
        this.x.sendMessage(new CustomMessage(2004001, addLocateParam));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: J */
    public void m(d.a.n0.z.e0.k kVar) {
        boolean z;
        if (kVar != null && kVar.m() != null) {
            this.w = kVar;
            if (l() != null) {
                l().setVisibility(0);
                l().setOnClickListener(this.I);
            }
            if (this.s != null) {
                SparseArray<String> sparseArray = this.w.feedBackReasonMap;
                if (sparseArray != null && sparseArray.size() > 0) {
                    v0 v0Var = new v0();
                    v0Var.n(this.w.m().y1());
                    v0Var.k(this.w.m().c0());
                    v0Var.m(this.w.m().M0());
                    v0Var.j(this.w.feedBackReasonMap);
                    this.s.setData(v0Var);
                    this.s.setFirstRowSingleColumn(true);
                    if (kVar.f63459e.T() != null && !StringUtils.isNull(kVar.f63459e.T().getUserId())) {
                        if (kVar.f63459e.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                            this.s.setVisibility(8);
                        } else {
                            NEGFeedBackView nEGFeedBackView = this.s;
                            if (nEGFeedBackView != null) {
                                nEGFeedBackView.setVisibility(this.D ? 0 : 8);
                            }
                        }
                    }
                } else {
                    this.s.setVisibility(8);
                }
            }
            this.q.j(kVar.f63459e);
            this.p.setFromCDN(this.C);
            this.p.setData(kVar.f63459e.B1());
            if (!G() && m.k(this.w.f63459e.o0())) {
                m.l(this.y, this.w.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.l(this.z, this.w.f63459e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.l(this.p.getGodReplyContent(), this.w.f63459e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            this.q.setUserAfterClickListener(this.K);
            a2 m = kVar.m();
            if (this.q.getHeaderImg() != null) {
                if (this.q.getIsSimpleThread()) {
                    this.q.getHeaderImg().setVisibility(8);
                    this.m.setVisibility(8);
                } else if (m.T() != null && m.T().getPendantData() != null && !StringUtils.isNull(m.T().getPendantData().a())) {
                    this.q.getHeaderImg().setVisibility(4);
                    this.m.setVisibility(0);
                    this.m.setData(m);
                } else {
                    this.m.setVisibility(8);
                    this.q.getHeaderImg().setVisibility(0);
                    this.q.getHeaderImg().setData(m);
                }
            }
            ThreadCardUtils.setTitle(this.y, m);
            ThreadCardUtils.setAbstract(this.z, this.y, m, L);
            ArrayList<VoiceData$VoiceModel> J1 = kVar.f63459e.J1();
            if (ListUtils.isEmpty(J1)) {
                this.n.setVisibility(8);
                z = false;
            } else {
                this.n.setVisibility(0);
                VoiceData$VoiceModel voiceData$VoiceModel = J1.get(0);
                this.n.setVoiceModel(voiceData$VoiceModel);
                this.n.setTag(voiceData$VoiceModel);
                this.n.b();
                if (voiceData$VoiceModel != null) {
                    this.n.j(voiceData$VoiceModel.voice_status.intValue());
                }
                this.n.l();
                z = true;
            }
            if (this.w.T && z) {
                this.A.setVisibility(8);
            } else {
                ArrayList<MediaData> L0 = m.L0();
                if (d.a.m0.r.k.c().g() && ListUtils.getCount(L0) != 0) {
                    LinkedList linkedList = new LinkedList();
                    for (int i2 = 0; i2 < L0.size(); i2++) {
                        MediaData mediaData = (MediaData) ListUtils.getItem(L0, i2);
                        if (mediaData != null && mediaData.getType() == 3) {
                            linkedList.add(mediaData);
                        }
                    }
                    if (ListUtils.getCount(linkedList) > 0) {
                        this.A.setVisibility(0);
                        this.A.setFromCDN(this.C);
                        this.A.setImageClickListener(new c(linkedList, m));
                        this.A.setImageMediaList(linkedList);
                    } else {
                        this.A.setVisibility(8);
                    }
                } else {
                    this.A.setVisibility(8);
                }
            }
            V();
            O();
            Q(i());
            this.G.setVisibility(8);
            S(F(1));
            n(this.x, TbadkCoreApplication.getInst().getSkinType());
        } else if (l() != null) {
            l().setVisibility(8);
        }
    }

    public void K(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        Q(bdUniqueId);
    }

    public void L(d.a.c.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup = this.A;
        if (constrainImageGroup != null) {
            constrainImageGroup.setImageViewPool(bVar);
        }
    }

    public void M(d.a.c.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup = this.A;
        if (constrainImageGroup != null) {
            constrainImageGroup.setConstrainLayoutPool(bVar);
        }
    }

    public void N(boolean z) {
        this.C = z;
    }

    public final void O() {
        if (!this.w.U) {
            this.n.setClickable(false);
        } else {
            this.n.setClickable(true);
        }
        int childCount = this.A.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.A.getChildAt(i2);
            if (childAt != null) {
                if (!this.w.U) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void P(boolean z) {
        this.D = z;
    }

    public final void Q(BdUniqueId bdUniqueId) {
        p(bdUniqueId);
        ConstrainImageGroup constrainImageGroup = this.A;
        if (constrainImageGroup != null) {
            constrainImageGroup.setPageUniqueId(bdUniqueId);
        }
        NEGFeedBackView nEGFeedBackView = this.s;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setUniqueId(bdUniqueId);
        }
        ThreadUserInfoLayout threadUserInfoLayout = this.q;
        if (threadUserInfoLayout != null) {
            threadUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
    }

    public void R(boolean z) {
        View view = this.B;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void S(int i2) {
        d.a.n0.z.e0.k kVar = this.w;
        if (kVar == null || kVar.f63459e == null) {
            return;
        }
        this.H = m.g();
        if (i2 == 1) {
            this.o.setVisibility(8);
            this.u.setStType(this.H);
            this.u.g(this.w.f63459e);
            this.q.l(false);
            return;
        }
        this.o.setData(this.w.f63459e);
        this.o.setStType(this.H);
        this.u.setVisibility(8);
        this.q.l(true);
    }

    public final void T(View view, List<MediaData> list, int i2, a2 a2Var) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            d.a.c.e.p.l.L(this.x.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.C ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = d.a.c.e.m.b.f(a2Var.y1(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                }
            }
        }
        if (arrayList.size() <= 0) {
            for (MediaData mediaData2 : list) {
                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                    arrayList.add(mediaData2.getPicUrl());
                }
            }
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(i2);
        bVar.z(a2Var.i0());
        bVar.y(String.valueOf(a2Var.c0()));
        bVar.O(a2Var.y1());
        bVar.C(this.C);
        bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
        bVar.F(true);
        bVar.w(concurrentHashMap);
        bVar.H(true);
        bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig v = bVar.v(this.x.getPageActivity());
        if (this.l == 2) {
            v.getIntent().putExtra("from", "index");
        } else {
            v.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.x;
        historyMessage.threadId = a2Var.o0();
        historyMessage.threadName = a2Var.z1();
        historyMessage.forumName = a2Var.i0();
        historyMessage.postID = a2Var.f0();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    public final void V() {
        ConstrainImageGroup constrainImageGroup;
        if (this.t == null || (constrainImageGroup = this.A) == null || this.p == null) {
            return;
        }
        if (constrainImageGroup.getVisibility() == 8 && this.p.getVisibility() == 8) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.card_home_page_multi_img_new;
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.v != i2) {
            SkinManager.setBackgroundResource(l(), R.drawable.addresslist_item_bg);
            SkinManager.setBackgroundColor(this.t, R.color.transparent);
            this.A.b();
            this.o.onChangeSkinType();
            this.p.k();
            this.q.h();
            NEGFeedBackView nEGFeedBackView = this.s;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.q();
            }
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0204);
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.u;
            if (threadSourceShareAndPraiseLayout != null) {
                threadSourceShareAndPraiseLayout.f();
            }
        }
        this.v = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // d.a.n0.o.e
    public void setPage(String str) {
        this.F = str;
    }
}
