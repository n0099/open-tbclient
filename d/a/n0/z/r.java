package d.a.n0.z;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.a.m0.r.q.a2;
import d.a.m0.z0.i0;
import d.a.n0.z.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class r extends d.a.n0.z.b<CardPersonDynamicThreadData> {
    public TextView A;
    public TextView B;
    public ConstrainImageGroup C;
    public boolean D;
    public View E;
    public TbImageView F;
    public ImageView G;
    public LinearLayout H;
    public TextView I;
    public LinearLayout J;
    public LinearLayout K;
    public TextView L;
    public TextView M;
    public TextView N;
    public TBLottieAnimationView O;
    public TextView P;
    public TextView Q;
    public OriginalThreadCardView R;
    public View S;
    public View T;
    public ThreadCardBottomOpSegmentLayout U;
    public boolean V;
    public boolean W;
    public EMTextView X;
    public View.OnClickListener Y;
    public q.i Z;
    public final View.OnClickListener a0;
    public final View.OnClickListener b0;
    public TbImageView.f c0;
    public PlayVoiceBntNew m;
    public ThreadViewAndCommentInfoLayout n;
    public View o;
    public int p;
    public CardPersonDynamicThreadData q;
    public TbPageContext<?> r;
    public TextView s;
    public LinearLayout t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public ImageView y;
    public q z;

    /* loaded from: classes4.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (!z || r.this.F == null) {
                return;
            }
            r.this.F.setDefaultBgResource(0);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r.this.h() != null) {
                r.this.h().a(view, r.this.q);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardPersonDynamicThreadData f63566e;

        public c(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
            this.f63566e = cardPersonDynamicThreadData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r.this.r != null) {
                if (r.this.z == null) {
                    r rVar = r.this;
                    rVar.z = new q(rVar.r);
                    r.this.z.o();
                    r.this.z.s(r.this.Z);
                }
                r.this.z.n(r.this.q, this.f63566e.J == 1);
                r.this.z.u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.m0.b1.j.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinkedList f63568a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a2 f63569b;

        public d(LinkedList linkedList, a2 a2Var) {
            this.f63568a = linkedList;
            this.f63569b = a2Var;
        }

        @Override // d.a.m0.b1.j.d
        public void a(View view, int i2, boolean z) {
            if (z) {
                r.this.N();
            } else {
                r.this.W(view, this.f63568a, i2, this.f63569b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.a.n0.v3.g {
        public e() {
        }

        @Override // d.a.n0.v3.g
        public void a(TextPaint textPaint, boolean z) {
            int color;
            if (z) {
                color = r.this.f63442g.getResources().getColor(R.color.CAM_X0304);
            } else {
                color = r.this.f63442g.getResources().getColor(R.color.CAM_X0302);
            }
            textPaint.setColor(color);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (r.this.q == null || StringUtils.isNull(r.this.q.j)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(r.this.f63442g).createNormalCfg(r.this.q.j, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r.this.h() != null) {
                r.this.h().a(view, r.this.q);
            }
            if (r.this.q.m != 60) {
                if ((r.this.q.m != 40 || r.this.q.p != 2) && !r.this.W) {
                    r.this.N();
                    return;
                } else {
                    BdToast.i(r.this.b(), r.this.b().getString(R.string.video_check_click_msg), R.drawable.icon_pure_toast_mistake40_svg, true).q();
                    return;
                }
            }
            TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
            if (r.this.q.r.r1().live_status != 1) {
                r.this.O();
            } else {
                r.this.L();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || r.this.q == null || r.this.q.f14276f == null || r.this.A == null || r.this.B == null || !((String) customResponsedMessage.getData()).equals(r.this.q.f14276f) || r.this.K()) {
                return;
            }
            m.l(r.this.A, r.this.q.f14276f, R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(r.this.B, r.this.q.f14276f, R.color.CAM_X0107, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements q.i {
        public h() {
        }

        @Override // d.a.n0.z.q.i
        public void a(boolean z) {
            r.this.T(z);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<CardPersonDynamicThreadData> h2 = r.this.h();
            if (h2 != null) {
                view.setTag("1");
                h2.a(view, r.this.q);
            }
            r.this.N();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<CardPersonDynamicThreadData> h2 = r.this.h();
            if (h2 != null) {
                view.setTag("2");
                h2.a(view, r.this.q);
            }
        }
    }

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.p = 3;
        this.D = true;
        new e();
        this.Y = new f();
        new g(2001390);
        this.Z = new h();
        this.a0 = new i();
        this.b0 = new j();
        this.c0 = new a();
        View l = l();
        this.o = l;
        this.r = tbPageContext;
        this.s = (TextView) l.findViewById(R.id.year_num);
        this.t = (LinearLayout) this.o.findViewById(R.id.left_time_view);
        this.u = (TextView) this.o.findViewById(R.id.month_num);
        this.v = (TextView) this.o.findViewById(R.id.day_num);
        this.w = (TextView) this.o.findViewById(R.id.source_bar);
        this.Q = (TextView) this.o.findViewById(R.id.video_under_review);
        this.x = (TextView) this.o.findViewById(R.id.tv_privacy_status);
        this.y = (ImageView) this.o.findViewById(R.id.iv_more);
        this.A = (TextView) this.o.findViewById(R.id.thread_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) this.o.findViewById(R.id.card_dynamic_thread_abstract_voice);
        this.m = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(this.b0);
        TextView textView = (TextView) this.o.findViewById(R.id.thread_content);
        this.B = textView;
        textView.setVisibility(8);
        this.C = (ConstrainImageGroup) this.o.findViewById(R.id.card_dynamic_thread_img_layout);
        this.C.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.C.setChildClickListener(this.a0);
        d.a.m0.b1.j.a aVar = new d.a.m0.b1.j.a(3);
        aVar.d(1.0d);
        this.C.setImageProcessor(aVar);
        this.E = this.o.findViewById(R.id.thread_view_img_container);
        this.F = (TbImageView) this.o.findViewById(R.id.thread_video_thumbnail);
        this.G = (ImageView) this.o.findViewById(R.id.thread_img_pause_play);
        this.n = (ThreadViewAndCommentInfoLayout) this.o.findViewById(R.id.card_dynamic_thread_info_layout);
        this.K = (LinearLayout) this.o.findViewById(R.id.duration_container);
        this.L = (TextView) this.o.findViewById(R.id.video_duration);
        this.M = (TextView) this.o.findViewById(R.id.video_play_count);
        this.N = (TextView) this.o.findViewById(R.id.audience_count);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.o.findViewById(R.id.ala_play);
        this.O = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.O, R.raw.ala_play);
        this.P = (TextView) this.o.findViewById(R.id.fake_video_state);
        this.H = (LinearLayout) this.o.findViewById(R.id.shared_ala_live_layout);
        this.I = (TextView) this.o.findViewById(R.id.shared_ala_live_room_title);
        LinearLayout linearLayout = (LinearLayout) this.o.findViewById(R.id.llAlaLivingLogLayout);
        this.J = linearLayout;
        linearLayout.setVisibility(8);
        this.R = (OriginalThreadCardView) this.o.findViewById(R.id.original_thread_info);
        this.S = this.o.findViewById(R.id.divider_line_thick);
        this.T = this.o.findViewById(R.id.divider_line_thin);
        ThreadCardBottomOpSegmentLayout threadCardBottomOpSegmentLayout = (ThreadCardBottomOpSegmentLayout) this.o.findViewById(R.id.card_thread_info_layout);
        this.U = threadCardBottomOpSegmentLayout;
        threadCardBottomOpSegmentLayout.hideDisagree();
        if (this.U.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.U.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.U.setLayoutParams(layoutParams);
        }
        this.U.setOnClickListener(this.Y);
        this.U.setReplyTimeVisible(false);
        this.U.setShowPraiseNum(true);
        this.U.setNeedAddPraiseIcon(true);
        this.U.setNeedAddReplyIcon(true);
        this.U.setShareVisible(true);
        this.U.setIsBarViewVisible(false);
        this.U.setFrom(13);
        d.a.m0.r.q.e eVar = new d.a.m0.r.q.e();
        eVar.f49994b = 8;
        eVar.f50000h = 3;
        this.U.setAgreeStatisticData(eVar);
        this.U.setShareReportFrom(6);
        this.U.setStType("person_page");
        this.U.setForumAfterClickListener(new b());
        this.X = (EMTextView) this.o.findViewById(R.id.tv_ueg_view);
    }

    public final void J(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            return;
        }
        if (!this.V && !this.W) {
            this.U.setCommentClickable(true);
            this.U.setAgreeClickable(true);
            this.U.setShareClickable(true);
            this.R.setClickable(true);
            this.y.setClickable(true);
        } else {
            this.U.setCommentClickable(false);
            this.U.setAgreeClickable(false);
            this.U.setShareClickable(false);
            this.R.setClickable(false);
            this.y.setClickable(false);
        }
        this.U.setCommentNumEnable(true);
        if (cardPersonDynamicThreadData.m == 60) {
            this.U.setCommentNumEnable(false);
        }
        CardPersonDynamicThreadData.MultipleForum[] multipleForumArr = cardPersonDynamicThreadData.D;
        if (multipleForumArr != null) {
            this.U.setMultiForumCount(multipleForumArr.length);
        }
        a2 a2Var = cardPersonDynamicThreadData.r;
        if (a2Var != null) {
            this.U.setForumId(String.valueOf(a2Var.c0()));
        }
        this.U.setData(cardPersonDynamicThreadData.r);
    }

    public final boolean K() {
        return this.q.H;
    }

    public void L() {
        a2 a2Var;
        CardPersonDynamicThreadData cardPersonDynamicThreadData = this.q;
        if (cardPersonDynamicThreadData == null || (a2Var = cardPersonDynamicThreadData.r) == null || a2Var.r1() == null) {
            return;
        }
        if (!d.a.c.e.p.j.z()) {
            d.a.c.e.p.l.L(this.r.getPageActivity(), R.string.no_network_guide);
            return;
        }
        if (!K()) {
            m.a(this.q.f14276f);
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(this.q.r.r1());
        if (this.q.r.r1().user_info != null) {
            alaLiveInfoCoreData.userName = this.q.r.r1().user_info.user_name;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.r.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
    }

    public final void M() {
        a2 a2Var;
        OriginalThreadInfo originalThreadInfo;
        CardPersonDynamicThreadData cardPersonDynamicThreadData = this.q;
        if (cardPersonDynamicThreadData == null || (a2Var = cardPersonDynamicThreadData.r) == null || (originalThreadInfo = a2Var.s1) == null) {
            return;
        }
        PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.r.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.f12038f, null, "person_page", 18005);
        createCfgForPersonCenter.setStartFrom(this.l);
        createCfgForPersonCenter.setBjhData(originalThreadInfo.p);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        TiebaStatic.log(new StatisticItem("c12943").param("obj_type", "3").param("tid", this.q.f14276f).param("obj_param1", this.q.H ? 1 : 2));
    }

    public final void N() {
        if (this.q == null) {
            return;
        }
        if (!K()) {
            m.a(this.q.f14276f);
            m.l(this.A, this.q.f14276f, R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(this.B, this.q.f14276f, R.color.CAM_X0107, R.color.CAM_X0109);
        }
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.r.getPageActivity());
        if (this.q.m == 40) {
            pbActivityConfig.setVideo_source("profile");
        }
        pbActivityConfig.createFromThreadCfg(this.q.r, null, "person_page", 18005, true, false, false);
        pbActivityConfig.setForumId(String.valueOf(this.q.r.c0()));
        pbActivityConfig.setForumName(this.q.r.i0());
        pbActivityConfig.setStartFrom(this.l);
        pbActivityConfig.setIsShareThread(this.q.r.t1);
        pbActivityConfig.setThreadData(this.q.r);
        pbActivityConfig.setIsPrivacy(this.q.q);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        a2 a2Var = this.q.r;
        if (a2Var == null || !a2Var.t1) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12943").param("obj_type", "2").param("tid", this.q.f14276f).param("obj_param1", this.q.H ? 1 : 2));
    }

    public final void O() {
        a2 a2Var;
        CardPersonDynamicThreadData cardPersonDynamicThreadData = this.q;
        if (cardPersonDynamicThreadData == null || (a2Var = cardPersonDynamicThreadData.r) == null || a2Var.r1() == null || this.q.r.r1().share_info == null) {
            return;
        }
        if (!K()) {
            m.a(this.q.f14276f);
        }
        if (this.q.r.r1().share_info.record_tid <= 0) {
            L();
            return;
        }
        String valueOf = String.valueOf(this.q.r.r1().share_info.record_tid);
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.r.getPageActivity());
        pbActivityConfig.setVideo_source("profile");
        pbActivityConfig.setStartFrom(this.l);
        pbActivityConfig.setThreadData(this.q.r);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02e7  */
    @Override // d.a.n0.z.b
    /* renamed from: P */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (cardPersonDynamicThreadData == null) {
            if (l() != null) {
                l().setVisibility(8);
                return;
            }
            return;
        }
        this.q = cardPersonDynamicThreadData;
        if (l() != null) {
            l().setVisibility(0);
            l().setOnClickListener(this.Y);
        }
        this.s.setVisibility(cardPersonDynamicThreadData.F ? 0 : 8);
        this.t.setVisibility(cardPersonDynamicThreadData.E ? 0 : 4);
        this.S.setVisibility(cardPersonDynamicThreadData.E ? 0 : 8);
        this.T.setVisibility(cardPersonDynamicThreadData.E ? 8 : 0);
        if (cardPersonDynamicThreadData.G) {
            this.S.setVisibility(8);
            this.T.setVisibility(8);
        }
        this.V = cardPersonDynamicThreadData.m == 40 && cardPersonDynamicThreadData.p == 2;
        V(cardPersonDynamicThreadData);
        a2 a2Var = cardPersonDynamicThreadData.r;
        if (a2Var != null) {
            this.W = a2Var.t1 && cardPersonDynamicThreadData.p == 2;
        }
        this.s.setText(cardPersonDynamicThreadData.t);
        this.u.setText(cardPersonDynamicThreadData.u);
        this.v.setText(cardPersonDynamicThreadData.v);
        CardPersonDynamicThreadData.MultipleForum[] multipleForumArr = cardPersonDynamicThreadData.D;
        if (multipleForumArr != null && multipleForumArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (true) {
                CardPersonDynamicThreadData.MultipleForum[] multipleForumArr2 = cardPersonDynamicThreadData.D;
                if (i2 >= multipleForumArr2.length) {
                    break;
                }
                sb.append(StringHelper.cutChineseAndEnglishWithSuffix(multipleForumArr2[i2].forum_name, 14, StringHelper.STRING_MORE));
                if (i2 < cardPersonDynamicThreadData.D.length - 1) {
                    sb.append("吧、");
                } else if (sb.lastIndexOf(this.f63442g.getString(R.string.forum)) != sb.length() - 1) {
                    sb.append(this.f63442g.getString(R.string.forum));
                }
                i2++;
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                this.w.setText(sb2);
                this.w.setVisibility(0);
            } else {
                this.w.setText(R.string.person_homepage);
            }
        } else {
            this.w.setText(R.string.person_homepage);
        }
        this.X.setVisibility(8);
        if (cardPersonDynamicThreadData.H) {
            int i3 = cardPersonDynamicThreadData.s;
            if (i3 == 3) {
                this.x.setVisibility(8);
            } else if (i3 == 1) {
                this.x.setVisibility(0);
            }
            T(cardPersonDynamicThreadData.q);
            if (cardPersonDynamicThreadData.J == 1) {
                this.x.setVisibility(8);
                this.X.setVisibility(0);
            }
            this.y.setVisibility(0);
            this.y.setOnClickListener(new c(cardPersonDynamicThreadData));
        } else {
            this.x.setVisibility(8);
            this.y.setVisibility(8);
        }
        VoiceData$VoiceModel[] voiceData$VoiceModelArr = cardPersonDynamicThreadData.B;
        if (voiceData$VoiceModelArr != null && voiceData$VoiceModelArr.length > 0) {
            this.m.setVisibility(0);
            X(true);
            VoiceData$VoiceModel voiceData$VoiceModel = voiceData$VoiceModelArr[0];
            this.m.setVoiceModel(voiceData$VoiceModel);
            this.m.setTag(voiceData$VoiceModel);
            this.m.b();
            if (voiceData$VoiceModel != null) {
                this.m.j(voiceData$VoiceModel.voice_status.intValue());
            }
            this.m.l();
        } else {
            this.m.setVisibility(8);
            X(false);
        }
        MediaData[] mediaDataArr = cardPersonDynamicThreadData.z;
        SkinManager.setBackgroundResource(this.H, R.color.transparent);
        this.I.setVisibility(8);
        this.J.setVisibility(8);
        this.H.setVisibility(0);
        this.E.setVisibility(8);
        this.P.setVisibility(8);
        this.K.setVisibility(8);
        this.N.setVisibility(8);
        this.O.cancelAnimation();
        this.O.setVisibility(8);
        long j2 = cardPersonDynamicThreadData.m;
        if (j2 == 36) {
            this.C.setVisibility(8);
        } else {
            if (j2 != 40) {
                long j3 = this.q.m;
                if (j3 != 50) {
                    if (j3 != 60 && j3 != 49) {
                        if (d.a.m0.r.k.c().g() && mediaDataArr.length > 0) {
                            LinkedList linkedList = new LinkedList();
                            a2 a2Var2 = cardPersonDynamicThreadData.r;
                            for (MediaData mediaData : mediaDataArr) {
                                if (mediaData != null && mediaData.getType() == 3) {
                                    linkedList.add(mediaData);
                                }
                            }
                            if (ListUtils.getCount(linkedList) > 0) {
                                this.C.setVisibility(0);
                                this.C.setFromCDN(this.D);
                                this.C.setSingleImageRatio(0.67d);
                                this.C.setImageClickListener(new d(linkedList, a2Var2));
                                this.C.setImageMediaList(linkedList);
                            } else {
                                this.C.setVisibility(8);
                            }
                        } else {
                            this.C.setVisibility(8);
                        }
                        this.H.setVisibility(8);
                    } else {
                        this.C.setVisibility(8);
                        if (this.q.r.r1() != null && this.q.r.r1().user_info != null) {
                            CardPersonDynamicThreadData cardPersonDynamicThreadData2 = this.q;
                            if (cardPersonDynamicThreadData2.m == 60) {
                                String str = cardPersonDynamicThreadData2.r.r1().user_info.user_name;
                                if (i0.d(str) > 14) {
                                    str = i0.m(str, 14) + StringHelper.STRING_MORE;
                                }
                                this.I.setText(m.d(str + ":", this.q.r.z1()));
                                this.I.setVisibility(0);
                                if (d.a.m0.r.k.c().g()) {
                                    this.E.setVisibility(0);
                                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.E.getLayoutParams();
                                    int width = this.E.getWidth();
                                    if (width == 0 || width > d.a.c.e.p.l.k(this.f63442g)) {
                                        width = (int) b().getResources().getDimension(R.dimen.ds560);
                                    }
                                    layoutParams.height = (width * 9) / 16;
                                    this.E.setLayoutParams(layoutParams);
                                    if (this.q.r.r1() != null) {
                                        this.F.setPlaceHolder(3);
                                        this.F.setEvent(this.c0);
                                        this.F.V(cardPersonDynamicThreadData.r.r1().cover, 10, false);
                                        this.G.setVisibility(8);
                                        this.O.setVisibility(0);
                                        this.O.playAnimation();
                                        SkinManager.setBackgroundResource(this.H, R.color.CAM_X0205);
                                        this.N.setVisibility(0);
                                        this.N.setText(String.format(this.f63442g.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(this.q.r.r1().audience_count)));
                                        this.U.getCommentContainer().setOnClickListener(this.Y);
                                    } else {
                                        this.U.getCommentContainer().setOnClickListener(this.U);
                                    }
                                }
                            }
                        }
                        this.I.setVisibility(8);
                        if (d.a.m0.r.k.c().g()) {
                        }
                    }
                }
            }
            this.C.setVisibility(8);
            if (d.a.m0.r.k.c().g()) {
                this.E.setVisibility(0);
                this.G.setVisibility(0);
                this.G.setImageResource(R.drawable.icon_play_video);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.E.getLayoutParams();
                int width2 = this.E.getWidth();
                if (width2 == 0 || width2 > d.a.c.e.p.l.k(this.f63442g)) {
                    width2 = (int) b().getResources().getDimension(R.dimen.ds672);
                }
                layoutParams2.height = (int) (width2 * 0.5625d);
                this.E.setLayoutParams(layoutParams2);
                if (this.q.A != null) {
                    this.F.setPlaceHolder(3);
                    this.F.setEvent(this.c0);
                    this.F.V(this.q.A.thumbnail_url, 17, false);
                    if (this.V) {
                        this.P.setVisibility(0);
                        this.P.setText(String.format(this.f63442g.getResources().getString(R.string.video_review_state), new Object[0]));
                    } else {
                        this.K.setVisibility(0);
                        this.L.setText(StringHelper.stringForVideoTime(this.q.A.video_duration.intValue() * 1000));
                        this.M.setText(String.format(this.f63442g.getResources().getString(R.string.play_count), StringHelper.numFormatOverWan(this.q.A.play_count.intValue())));
                    }
                }
            }
        }
        a2 a2Var3 = cardPersonDynamicThreadData.r;
        if (a2Var3 != null && a2Var3.s1 != null) {
            this.R.setVisibility(0);
            this.R.f(cardPersonDynamicThreadData.r.s1);
            this.R.setOnClickListener(this);
            this.m.setVisibility(8);
            this.C.setVisibility(8);
            this.H.setVisibility(8);
            if (this.W) {
                this.Q.setVisibility(0);
            } else {
                this.Q.setVisibility(8);
            }
        } else {
            this.R.setVisibility(8);
            this.Q.setVisibility(8);
        }
        S();
        J(cardPersonDynamicThreadData);
    }

    public void Q(d.a.c.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup = this.C;
        if (constrainImageGroup != null) {
            constrainImageGroup.setImageViewPool(bVar);
        }
    }

    public void R(d.a.c.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup = this.C;
        if (constrainImageGroup != null) {
            constrainImageGroup.setConstrainLayoutPool(bVar);
        }
    }

    public final void S() {
        this.m.setClickable(true);
        int childCount = this.C.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.C.getChildAt(i2);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public final void T(boolean z) {
        TextView textView = this.x;
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setText(R.string.privacy);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_card_privacy);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.x.setCompoundDrawables(drawable, null, null, null);
            return;
        }
        textView.setText(R.string.public_open);
        Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_card_open);
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        this.x.setCompoundDrawables(drawable2, null, null, null);
    }

    public final boolean V(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        a2 a2Var;
        if (cardPersonDynamicThreadData == null || (a2Var = cardPersonDynamicThreadData.r) == null) {
            return false;
        }
        SpannableStringBuilder Q2 = a2Var.Q2(false, true, this.V);
        if (Q2 != null && !StringUtils.isNull(Q2.toString())) {
            this.A.setVisibility(0);
            this.A.setOnTouchListener(new d.a.n0.v3.i(Q2));
            this.A.setText(Q2);
            if (!K()) {
                m.l(this.A, cardPersonDynamicThreadData.f14276f, R.color.CAM_X0105, R.color.CAM_X0109);
            }
        } else {
            this.A.setVisibility(8);
        }
        return true;
    }

    public final void W(View view, List<MediaData> list, int i2, a2 a2Var) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            d.a.c.e.p.l.L(this.r.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                arrayList.add(mediaData.getPicUrl());
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.D ? 13 : 14;
                imageUrlData.imageUrl = mediaData.getPicUrl();
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.threadId = d.a.c.e.m.b.f(a2Var.y1(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
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
        bVar.C(this.D);
        bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
        bVar.F(true);
        bVar.w(concurrentHashMap);
        bVar.H(true);
        bVar.N(a2Var);
        bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig v = bVar.v(this.r.getPageActivity());
        v.getIntent().putExtra("from", "other");
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
    }

    public final void X(boolean z) {
        ConstrainImageGroup constrainImageGroup = this.C;
        if (constrainImageGroup == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) constrainImageGroup.getLayoutParams();
        if (z) {
            layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
        } else {
            layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        }
        this.C.setLayoutParams(layoutParams);
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.card_person_dynamic_thread;
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.p != i2) {
            SkinManager.setLottieAnimation(this.O, R.raw.ala_play);
            SkinManager.setBackgroundResource(l(), R.drawable.home_thread_card_item_bg);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.Q, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0109);
            if (this.y != null) {
                this.y.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_personalba_more24_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            }
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.B, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.I, R.color.CAM_X0106);
            q qVar = this.z;
            if (qVar != null) {
                qVar.r();
            }
            this.n.b();
            this.U.onChangeSkinType();
            SkinManager.setBackgroundColor(this.S, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.T, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.I, R.color.CAM_X0205);
            OriginalThreadCardView originalThreadCardView = this.R;
            if (originalThreadCardView != null) {
                originalThreadCardView.n();
            }
            d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.X);
            d2.s(R.color.CAM_X0109);
            d2.x(R.string.F_X01);
        }
        this.p = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.R) {
            M();
        }
    }
}
