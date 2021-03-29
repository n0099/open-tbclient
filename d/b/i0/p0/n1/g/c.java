package d.b.i0.p0.n1.g;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.b.b.e.p.l;
import d.b.h0.r.k;
import d.b.h0.r.q.a2;
import d.b.i0.p0.n2.i;
import d.b.i0.x.b0;
import d.b.i0.x.m;
import d.b.i0.x.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class c extends d.b.i0.x.b<a2> implements z, Object {
    public TbPageContext<?> A;
    public TextView B;
    public TextView C;
    public ConstrainImageGroup D;
    public boolean E;
    public View F;
    public TbImageView G;
    public String H;
    public i I;
    public View J;
    public AppletsCellView K;
    public View.OnClickListener L;
    public final View.OnClickListener M;
    public final View.OnClickListener N;
    public HeadPendantClickableView m;
    public PlayVoiceBntNew n;
    public ThreadCommentAndPraiseInfoLayout o;
    public ThreadSourceShareAndPraiseLayout p;
    public ThreadGodReplyLayout q;
    public ThreadUserInfoLayout r;
    public RelativeLayout s;
    public View t;
    public TbImageView u;
    public LinearLayout v;
    public String w;
    public String x;
    public int y;
    public a2 z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = c.this.o;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.changeSelectStatus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ThreadCommentAndPraiseInfoLayout.j {
        public b() {
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.j
        public void a(boolean z) {
            if (c.this.J != null) {
                c.this.J.setBackgroundColor(SkinManager.getColor(z ? R.color.CAM_X0201 : R.color.transparent));
            }
        }
    }

    /* renamed from: d.b.i0.p0.n1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1410c implements d.b.h0.b1.j.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinkedList f58102a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a2 f58103b;

        public C1410c(LinkedList linkedList, a2 a2Var) {
            this.f58102a = linkedList;
            this.f58103b = a2Var;
        }

        @Override // d.b.h0.b1.j.d
        public void a(View view, int i, boolean z) {
            b0<a2> i2 = c.this.i();
            if (!z) {
                if (i2 != null) {
                    view.setTag("1");
                    i2.f62184a = Boolean.FALSE;
                    i2.a(view, c.this.z);
                }
                c.this.R(view, this.f58102a, i, this.f58103b);
                return;
            }
            if (i2 != null) {
                view.setTag("1");
                i2.f62184a = Boolean.TRUE;
                i2.a(view, c.this.z);
            }
            c.this.B(false);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a2 f58105e;

        public d(a2 a2Var) {
            this.f58105e = a2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.A != null) {
                c.this.f62181f.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.f62181f.getContext(), "", this.f58105e.u1, true)));
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThemeCardInUserData f58107e;

        public e(ThemeCardInUserData themeCardInUserData) {
            this.f58107e = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.A.getPageActivity(), this.f58107e.getCardId())));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.b.i0.p0.b.e().g() && !d.b.i0.p0.a.h().j()) {
                if (c.this.i() != null) {
                    c.this.i().a(view, c.this.z);
                }
                c cVar = c.this;
                cVar.B(view == cVar.q);
                return;
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = c.this.o;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.changeSelectStatus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<a2> i = c.this.i();
            if (i != null) {
                view.setTag("2");
                i.a(view, c.this.z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.i() != null) {
                c.this.i().a(view, c.this.z);
            }
        }
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.y = 3;
        this.E = true;
        this.L = new f();
        this.M = new g();
        this.N = new h();
        View m = m();
        r(bdUniqueId);
        this.A = tbPageContext;
        this.l = 3;
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) m.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setRadius(l.g(this.A.getPageActivity(), R.dimen.ds70));
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        this.m.setAfterClickListener(this.N);
        this.t = m.findViewById(R.id.divider_line);
        this.B = (TextView) m.findViewById(R.id.card_home_page_normal_thread_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) m.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.n = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(this.M);
        TextView textView = (TextView) m.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.C = textView;
        textView.setVisibility(8);
        this.F = m.findViewById(R.id.divider_line_above_praise);
        this.D = (ConstrainImageGroup) m.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.D.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.D.setChildClickListener(this.L);
        d.b.h0.b1.j.f fVar = new d.b.h0.b1.j.f(3);
        fVar.d(1.0d);
        this.D.setImageProcessor(fVar);
        this.o = (ThreadCommentAndPraiseInfoLayout) m.findViewById(R.id.card_home_page_normal_thread_info_layout);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) m.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.r = threadUserInfoLayout;
        threadUserInfoLayout.setUserAfterClickListener(this.N);
        this.r.setFrom(3);
        this.o.setOnClickListener(this.L);
        this.o.setForumAfterClickListener(this.N);
        this.o.setReplyTimeVisible(false);
        this.o.setShowPraiseNum(true);
        this.o.setNeedAddPraiseIcon(true);
        this.o.setNeedAddReplyIcon(true);
        this.o.setIsBarViewVisible(false);
        this.o.setShareVisible(true);
        this.o.setShareReportFrom(1);
        this.o.setStType("frs_page");
        this.o.setFrom(2);
        this.o.R = 3;
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) m.findViewById(R.id.card_home_page_source_read_share_layout);
        this.p = threadSourceShareAndPraiseLayout;
        if (threadSourceShareAndPraiseLayout != null) {
            threadSourceShareAndPraiseLayout.f13536f.setOnClickListener(this.L);
            this.p.setFrom(2);
            this.p.setShareReportFrom(1);
            this.p.setSourceFromForPb(3);
            this.p.setStType("frs_page");
            this.p.setHideBarName(true);
            this.p.f13536f.setNeedAddReplyIcon(true);
        }
        RelativeLayout relativeLayout = (RelativeLayout) m.findViewById(R.id.card_home_page_normal_thread_root);
        this.s = relativeLayout;
        i iVar = new i(this.A, relativeLayout);
        this.I = iVar;
        iVar.d(k());
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) m.findViewById(R.id.card_frs_god_reply_layout);
        this.q = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this.L);
        TbImageView tbImageView = (TbImageView) m.findViewById(R.id.frs_normal_item_theme_card);
        this.u = tbImageView;
        tbImageView.setPageId(k());
        TbImageView tbImageView2 = (TbImageView) m.findViewById(R.id.frs_normal_item_star_view);
        this.G = tbImageView2;
        if (tbImageView2 != null) {
            tbImageView2.setPageId(k());
        }
        View findViewById = m.findViewById(R.id.thread_multi_del_mask_view);
        this.J = findViewById;
        findViewById.setOnClickListener(new a());
        this.o.setOnSelectStatusChangeListener(new b());
        this.v = (LinearLayout) m.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.K = (AppletsCellView) m.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public final boolean A() {
        return false;
    }

    public abstract void B(boolean z);

    public void E(a2 a2Var) {
        if (a2Var == null) {
            if (m() != null) {
                m().setVisibility(8);
                return;
            }
            return;
        }
        this.z = a2Var;
        if (m() != null) {
            m().setVisibility(0);
            m().setOnClickListener(this.L);
        }
        this.q.l();
        if (!A() && m.k(this.z.o0())) {
            m.l(this.B, this.z.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(this.C, this.z.o0(), R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.q.getGodReplyContent(), this.z.o0(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        z(a2Var);
        this.I.a(this.z);
        Q(a2Var);
        this.r.j(this.z);
        this.q.setFromCDN(this.E);
        this.q.setData(this.z.z1());
        this.r.setUserAfterClickListener(this.N);
        P(x(1));
        if (this.r.getHeaderImg() != null) {
            if (this.r.getIsSimpleThread()) {
                this.r.getHeaderImg().setVisibility(8);
                this.m.setVisibility(8);
            } else if (a2Var.T() != null && a2Var.T().getPendantData() != null && !StringUtils.isNull(a2Var.T().getPendantData().a())) {
                this.r.getHeaderImg().setVisibility(4);
                this.m.setVisibility(0);
                this.m.setData(a2Var);
            } else {
                this.m.setVisibility(8);
                this.r.getHeaderImg().setVisibility(0);
                this.r.getHeaderImg().setData(a2Var);
            }
        }
        O(a2Var);
        G(a2Var);
        this.K.setData(a2Var.j1());
        this.K.setForumId(String.valueOf(a2Var.c0()));
        this.K.setFrom("frs_card");
        ArrayList<VoiceData$VoiceModel> H1 = a2Var.H1();
        if (ListUtils.isEmpty(H1)) {
            this.n.setVisibility(8);
        } else {
            this.n.o();
            this.n.setVisibility(0);
            VoiceData$VoiceModel voiceData$VoiceModel = H1.get(0);
            this.n.setVoiceModel(voiceData$VoiceModel);
            this.n.setTag(voiceData$VoiceModel);
            this.n.d();
            if (voiceData$VoiceModel != null) {
                this.n.m(voiceData$VoiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> K0 = a2Var.K0();
        if (k.c().g() && ListUtils.getCount(K0) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < K0.size(); i++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(K0, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (ListUtils.getCount(linkedList) > 0) {
                this.D.setVisibility(0);
                this.D.setFromCDN(this.E);
                this.D.setImageClickListener(new C1410c(linkedList, a2Var));
                this.D.setImageMediaList(linkedList);
            } else {
                this.D.setVisibility(8);
            }
        } else {
            this.D.setVisibility(8);
        }
        T();
        K();
        S();
        if ((d.b.i0.p0.b.e().g() || d.b.i0.p0.a.h().j()) && this.o.isInFrsAllThread()) {
            this.J.setVisibility(0);
            if (!this.z.i2() && !this.z.j2() && !this.z.w2()) {
                this.J.setBackgroundResource(R.color.transparent);
            } else {
                SkinManager.setBackgroundColor(this.J, R.color.CAM_X0201);
            }
        } else {
            this.J.setVisibility(8);
        }
        o(this.A, TbadkCoreApplication.getInst().getSkinType());
    }

    public void F(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.o == null) {
            return;
        }
        L(bdUniqueId);
    }

    public final void G(a2 a2Var) {
        if (a2Var != null && x(2) == 1) {
            if (!StringUtils.isNull(this.w) && !StringUtils.isNull(this.x)) {
                a2Var.h4(this.w, this.x);
            }
            SpannableString E2 = a2Var.E2();
            if (E2 != null && !d.b.b.e.p.k.isEmpty(E2.toString())) {
                this.C.setVisibility(0);
                this.C.setOnTouchListener(new d.b.i0.t3.i(E2));
                this.C.setText(E2);
                m.l(this.C, a2Var.o0(), R.color.CAM_X0107, R.color.CAM_X0109);
                return;
            }
            this.C.setVisibility(8);
            return;
        }
        this.C.setVisibility(8);
    }

    public void I(d.b.b.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup = this.D;
        if (constrainImageGroup != null) {
            constrainImageGroup.setImageViewPool(bVar);
        }
    }

    public void J(d.b.b.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup = this.D;
        if (constrainImageGroup != null) {
            constrainImageGroup.setConstrainLayoutPool(bVar);
        }
    }

    public final void K() {
        this.n.setClickable(true);
        int childCount = this.D.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.D.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public final void L(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout = this.r;
        if (threadUserInfoLayout != null) {
            threadUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        ConstrainImageGroup constrainImageGroup = this.D;
        if (constrainImageGroup != null) {
            constrainImageGroup.setPageUniqueId(bdUniqueId);
        }
    }

    public void M(double d2) {
        ConstrainImageGroup constrainImageGroup = this.D;
        if (constrainImageGroup != null) {
            constrainImageGroup.setSingleImageRatio(d2);
        }
    }

    public final boolean O(a2 a2Var) {
        if (!StringUtils.isNull(this.w) && !StringUtils.isNull(this.x)) {
            a2Var.h4(this.w, this.x);
        }
        SpannableStringBuilder N2 = a2Var.N2(false, true);
        if (N2 != null && !StringUtils.isNull(N2.toString())) {
            this.B.setVisibility(0);
            this.B.setOnTouchListener(new d.b.i0.t3.i(N2));
            this.B.setText(N2);
            m.l(this.B, a2Var.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
        } else {
            this.B.setVisibility(8);
        }
        return true;
    }

    public void P(int i) {
        a2 a2Var = this.z;
        if (a2Var == null) {
            return;
        }
        if (i == 1) {
            this.o.setVisibility(8);
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.p;
            if (threadSourceShareAndPraiseLayout != null) {
                threadSourceShareAndPraiseLayout.g(this.z);
                return;
            }
            return;
        }
        this.o.setData(a2Var);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout2 = this.p;
        if (threadSourceShareAndPraiseLayout2 != null) {
            threadSourceShareAndPraiseLayout2.setVisibility(8);
        }
    }

    public final void Q(a2 a2Var) {
        if (this.G == null) {
            return;
        }
        if (this.u != null && a2Var != null) {
            if (!StringUtils.isNull(a2Var.t1) && this.u.getVisibility() != 0) {
                i iVar = this.I;
                if (iVar != null && iVar.b() && (this.G.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
                    layoutParams.rightMargin = l.g(this.A.getPageActivity(), R.dimen.tbds106);
                    this.G.setLayoutParams(layoutParams);
                }
                this.G.setVisibility(0);
                this.G.setImageDrawable(null);
                this.G.W(a2Var.t1, 10, false);
                this.G.setOnClickListener(new d(a2Var));
                return;
            }
            this.G.setVisibility(8);
            return;
        }
        this.G.setVisibility(8);
    }

    public final void R(View view, List<MediaData> list, int i, a2 a2Var) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.K(this.A.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            String str = null;
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                str = mediaData.getSrc_pic();
            } else if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                str = mediaData.getPicUrl();
            }
            if (!StringUtils.isNull(str)) {
                arrayList.add(str);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.E ? 13 : 14;
                imageUrlData.imageUrl = y(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = d.b.b.e.m.b.f(a2Var.w1(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(i);
        bVar.z(a2Var.i0());
        bVar.y(String.valueOf(a2Var.c0()));
        bVar.P(a2Var.w1());
        bVar.C(this.E);
        bVar.K(arrayList.size() > 0 ? arrayList.get(0) : "");
        bVar.G(true);
        bVar.w(concurrentHashMap);
        bVar.I(true);
        bVar.O(a2Var);
        bVar.N(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig v = bVar.v(this.A.getPageActivity());
        v.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.A;
        historyMessage.threadId = a2Var.o0();
        historyMessage.threadName = a2Var.x1();
        historyMessage.forumName = a2Var.i0();
        historyMessage.postID = a2Var.f0();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    public final void S() {
        TextView textView = this.B;
        if (textView == null || this.n == null || this.D == null || this.f62182g == null || textView.getVisibility() != 8) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.topMargin = this.f62182g.getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.n.setLayoutParams(layoutParams);
        if (this.n.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.D.getLayoutParams();
            layoutParams2.topMargin = this.f62182g.getResources().getDimensionPixelSize(R.dimen.tbds28);
            this.D.setLayoutParams(layoutParams2);
        }
    }

    public final void T() {
        ConstrainImageGroup constrainImageGroup;
        if (this.F == null || (constrainImageGroup = this.D) == null || this.q == null) {
            return;
        }
        if (constrainImageGroup.getVisibility() == 8 && this.q.getVisibility() == 8 && this.K.getVisibility() == 8) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.y != i) {
            SkinManager.setBackgroundResource(m(), R.drawable.addresslist_item_bg);
            SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204);
            this.D.b();
            this.o.onChangeSkinType();
            this.r.h();
            AppletsCellView appletsCellView = this.K;
            if (appletsCellView != null) {
                appletsCellView.c();
            }
            this.I.c();
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.p;
            if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                this.p.f();
            }
            HeadPendantClickableView headPendantClickableView = this.m;
            if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.m.getHeadView() instanceof TbImageView)) {
                this.m.getHeadView().setPlaceHolder(1);
            }
        }
        this.y = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
        this.l = i;
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.o;
        if (threadCommentAndPraiseInfoLayout != null) {
            threadCommentAndPraiseInfoLayout.R = i;
            threadCommentAndPraiseInfoLayout.setFrom(2);
        }
        ThreadUserInfoLayout threadUserInfoLayout = this.r;
        if (threadUserInfoLayout != null) {
            threadUserInfoLayout.setFrom(3);
        }
    }

    public void setPage(String str) {
        this.H = str;
    }

    public int x(int i) {
        return d.b.i0.m.d.c().b(this.H, i);
    }

    public final String y(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallUrl();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        return TextUtils.isEmpty(picUrl) ? mediaData.getSrc_pic() : picUrl;
    }

    public void z(a2 a2Var) {
        MetaData T;
        if (a2Var == null || this.u == null || (T = a2Var.T()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = T.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
            this.u.setVisibility(0);
            this.u.setImageDrawable(null);
            this.u.W(themeCard.getCardImageUrlAndroid(), 10, false);
            this.u.setOnClickListener(new e(themeCard));
            return;
        }
        this.u.setVisibility(8);
    }
}
