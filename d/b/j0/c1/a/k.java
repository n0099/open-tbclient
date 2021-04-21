package d.b.j0.c1.a;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.holder.TopicMediaHolder;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.b.i0.r.s.a;
/* loaded from: classes4.dex */
public class k extends d.b.c.j.e.a<d.b.j0.c1.c.o, TopicMediaHolder> {
    public CustomMessageListener A;
    public int m;
    public BaseActivity<?> n;
    public View o;
    public TopicMediaHolder p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public TbCyberVideoView.g u;
    public Handler v;
    public CyberPlayerManager.OnErrorListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes4.dex */
    public class a implements TbImageView.f {
        public a(k kVar) {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CyberPlayerManager.OnErrorListener {
        public b() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            if (!k.this.r) {
                BdToast.i(k.this.n.getPageContext().getPageActivity(), k.this.n.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).q();
            }
            k.this.D0();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k.this.x0();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (k.this.p == null || k.this.p.f17296b == null || k.this.p.f17300f == null || k.this.p.f17297c == null) {
                return;
            }
            k.this.p.f17296b.setVisibility(0);
            k.this.p.f17300f.setVisibility(8);
            k.this.p.f17297c.stopPlayback();
            k.this.r = true;
            k kVar = k.this;
            kVar.y0(kVar.p);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (k.this.p == null || k.this.p.m == null) {
                return;
            }
            int[] iArr = new int[2];
            k.this.p.m.getLocationInWindow(iArr);
            int i = iArr[1];
            k.this.p.m.getHeight();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (k.this.v != null) {
                k.this.v.removeMessages(1);
            }
            if (k.this.p == null || k.this.p.f17298d == null || k.this.p.f17299e == null) {
                return;
            }
            k.this.p.f17298d.j();
            k.this.p.f17299e.e();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f53860e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.c1.c.o f53861f;

        public g(TopicMediaHolder topicMediaHolder, d.b.j0.c1.c.o oVar) {
            this.f53860e = topicMediaHolder;
            this.f53861f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f53860e.f17300f.setVisibility(8);
            TbCyberVideoView tbCyberVideoView = this.f53860e.f17297c;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.setPlayMode("2");
            }
            this.f53860e.f17297c.start();
            k.this.G0(this.f53861f, this.f53860e);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements CyberPlayerManager.OnPreparedListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f53863e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.c1.c.o f53864f;

        public h(TopicMediaHolder topicMediaHolder, d.b.j0.c1.c.o oVar) {
            this.f53863e = topicMediaHolder;
            this.f53864f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TopicVideoControllerView topicVideoControllerView;
            TopicMediaHolder topicMediaHolder = this.f53863e;
            if (topicMediaHolder == null || topicMediaHolder.f17297c == null || (topicVideoControllerView = topicMediaHolder.f17298d) == null) {
                return;
            }
            int curProgress = topicVideoControllerView.getCurProgress();
            if (curProgress > 0) {
                float duration = this.f53863e.f17297c.getDuration() * 1.0f * curProgress;
                TopicMediaHolder topicMediaHolder2 = this.f53863e;
                TopicVideoControllerView topicVideoControllerView2 = topicMediaHolder2.f17298d;
                topicMediaHolder2.f17297c.seekTo((int) (duration / 10000.0f));
            }
            Message obtainMessage = k.this.v.obtainMessage(1);
            obtainMessage.obj = this.f53864f;
            k.this.v.sendMessage(obtainMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements CyberPlayerManager.OnCompletionListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f53866e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.c1.c.o f53867f;

        public i(TopicMediaHolder topicMediaHolder, d.b.j0.c1.c.o oVar) {
            this.f53866e = topicMediaHolder;
            this.f53867f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            this.f53866e.f17300f.setVisibility(0);
            k.this.z0(this.f53867f, this.f53866e);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f53869e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.c1.c.o f53870f;

        public j(TopicMediaHolder topicMediaHolder, d.b.j0.c1.c.o oVar) {
            this.f53869e = topicMediaHolder;
            this.f53870f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f53869e.f17297c.isPlaying()) {
                k.this.v0(this.f53869e, this.f53870f);
                return;
            }
            this.f53869e.f17297c.pause();
            this.f53869e.f17302h.setVisibility(0);
        }
    }

    /* renamed from: d.b.j0.c1.a.k$k  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1209k implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.c1.c.o f53872e;

        public View$OnClickListenerC1209k(d.b.j0.c1.c.o oVar) {
            this.f53872e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k.this.n.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(k.this.n.getActivity()).createNormalConfig(String.valueOf(this.f53872e.f53963e), this.f53872e.f53964f, "")));
        }
    }

    /* loaded from: classes4.dex */
    public class l implements TbCyberVideoView.g {
        public l() {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            if (k.this.p != null && k.this.p.f17297c != null) {
                k.this.p.f17297c.stopPlayback();
            }
            k.this.D0();
        }
    }

    /* loaded from: classes4.dex */
    public class m extends Handler {
        public m(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1 || k.this.r || k.this.p == null || k.this.p.f17297c == null || k.this.p.f17296b == null || k.this.p.f17300f == null || k.this.p.f17302h == null) {
                return;
            }
            if (k.this.p.f17297c.getCurrentPosition() > 0) {
                k.this.p.f17296b.setVisibility(8);
                k.this.p.f17300f.setVisibility(8);
                k.this.p.f17302h.setVisibility(8);
                k kVar = k.this;
                kVar.G0((d.b.j0.c1.c.o) message.obj, kVar.p);
                k kVar2 = k.this;
                kVar2.y0(kVar2.p);
                return;
            }
            Message obtainMessage = k.this.v.obtainMessage(1);
            obtainMessage.obj = message.obj;
            k.this.v.sendMessageDelayed(obtainMessage, 50L);
        }
    }

    /* loaded from: classes4.dex */
    public class n implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f53876e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.c1.c.o f53877f;

        public n(TopicMediaHolder topicMediaHolder, d.b.j0.c1.c.o oVar) {
            this.f53876e = topicMediaHolder;
            this.f53877f = oVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            TbCyberVideoView tbCyberVideoView;
            TopicMediaHolder topicMediaHolder = this.f53876e;
            if (topicMediaHolder != null && (tbCyberVideoView = topicMediaHolder.f17297c) != null) {
                tbCyberVideoView.setPlayMode("2");
            }
            k.this.w0(this.f53876e, this.f53877f);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class o implements a.e {
        public o(k kVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public d.b.j0.c1.c.o f53879e;

        /* renamed from: f  reason: collision with root package name */
        public TopicMediaHolder f53880f;

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a() {
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                p.this.b();
                aVar.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b(p pVar) {
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public p(d.b.j0.c1.c.o oVar, TopicMediaHolder topicMediaHolder) {
            this.f53879e = oVar;
            this.f53880f = topicMediaHolder;
        }

        public final void b() {
            TopicMediaHolder topicMediaHolder;
            TbCyberVideoView tbCyberVideoView;
            if (this.f53879e == null || (topicMediaHolder = this.f53880f) == null || (tbCyberVideoView = topicMediaHolder.f17297c) == null) {
                return;
            }
            tbCyberVideoView.setPlayMode("2");
            this.f53880f.f17297c.setVideoPath(this.f53879e.f53966h);
            this.f53880f.f17297c.start();
            k.this.r = false;
            k.this.F0(this.f53880f);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicMediaHolder topicMediaHolder;
            View view2;
            if (this.f53879e == null || (topicMediaHolder = this.f53880f) == null || (view2 = topicMediaHolder.i) == null || topicMediaHolder.f17297c == null) {
                return;
            }
            if (view2.getVisibility() == 0) {
                this.f53880f.f17297c.stopPlayback();
                k.this.r = true;
                k.this.y0(this.f53880f);
            } else if (d.b.c.e.p.j.x()) {
                d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(k.this.n.getPageContext().getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.setPositiveButton(R.string.confirm, new a());
                aVar.setNegativeButton(R.string.cancel, new b(this));
                aVar.create(k.this.n.getPageContext()).show();
            } else {
                b();
            }
        }
    }

    public k(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = new l();
        this.v = new m(Looper.getMainLooper());
        this.w = new b();
        this.x = new c(2004011);
        this.y = new d(2004012);
        this.z = new e(2004013);
        this.A = new f(2004014);
        this.n = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.x);
            baseActivity.registerListener(this.y);
            baseActivity.registerListener(this.z);
            baseActivity.registerListener(this.A);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: A0 */
    public TopicMediaHolder R(ViewGroup viewGroup) {
        if (this.o == null) {
            this.o = LayoutInflater.from(this.f43095e).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.p = new TopicMediaHolder(this.o);
            View findViewById = this.o.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int k = d.b.c.e.p.l.k(this.f43095e);
            if (layoutParams != null) {
                layoutParams.height = (int) (k / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            D0();
        }
        return this.p;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: B0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.b.j0.c1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null && topicMediaHolder != null) {
            if (!this.q) {
                this.q = true;
                if (!StringUtils.isNull(oVar.f53966h) && oVar.i > 0) {
                    this.t = false;
                    topicMediaHolder.j.setVisibility(0);
                    if (this.s) {
                        topicMediaHolder.f17298d.setVisibility(8);
                        topicMediaHolder.f17299e.setVisibility(0);
                    } else {
                        topicMediaHolder.f17298d.setVisibility(0);
                        topicMediaHolder.f17299e.setVisibility(8);
                    }
                } else {
                    this.t = true;
                    topicMediaHolder.f17298d.setVisibility(8);
                    topicMediaHolder.f17299e.setVisibility(8);
                    topicMediaHolder.j.setVisibility(8);
                }
                if (!StringUtils.isNull(oVar.f53966h) && oVar.i > 0) {
                    topicMediaHolder.f17296b.setForegroundDrawable(R.drawable.icon_play_video);
                    topicMediaHolder.f17296b.setOnClickListener(new p(oVar, topicMediaHolder));
                } else {
                    topicMediaHolder.f17296b.setForegroundDrawable(0);
                    topicMediaHolder.f17296b.setOnClickListener(null);
                }
                topicMediaHolder.f17296b.setTag(Integer.valueOf(i2));
                topicMediaHolder.f17296b.setDefaultResource(0);
                if (!d.b.i0.r.k.c().g()) {
                    topicMediaHolder.f17296b.setNoImageBottomTextColor(R.color.CAM_X0108);
                    topicMediaHolder.f17296b.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    topicMediaHolder.f17296b.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    topicMediaHolder.f17296b.setSupportNoImage(true);
                    topicMediaHolder.f17296b.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    topicMediaHolder.f17296b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!topicMediaHolder.f17297c.isPlaying()) {
                        z0(oVar, topicMediaHolder);
                    }
                }
                topicMediaHolder.f17301g.setOnClickListener(new g(topicMediaHolder, oVar));
                topicMediaHolder.f17297c.setOnPreparedListener(new h(topicMediaHolder, oVar));
                topicMediaHolder.f17297c.setOnCompletionListener(new i(topicMediaHolder, oVar));
                topicMediaHolder.f17297c.setOnErrorListener(this.w);
                topicMediaHolder.f17297c.setOnSurfaceDestroyedListener(this.u);
                topicMediaHolder.j.setOnClickListener(new j(topicMediaHolder, oVar));
                if (this.s) {
                    topicMediaHolder.f17299e.setPlayer(topicMediaHolder.f17297c);
                } else {
                    topicMediaHolder.f17298d.setPlayer(topicMediaHolder.f17297c);
                }
                if (StringUtils.isNull(oVar.f53964f)) {
                    topicMediaHolder.k.setVisibility(8);
                    topicMediaHolder.l.setVisibility(8);
                } else {
                    topicMediaHolder.k.setVisibility(0);
                    topicMediaHolder.l.setVisibility(0);
                    topicMediaHolder.k.setText(oVar.f53964f);
                    topicMediaHolder.k.setOnClickListener(new View$OnClickListenerC1209k(oVar));
                }
            }
            if (topicMediaHolder.f17295a != this.m) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
                topicMediaHolder.f17298d.m(this.m);
                SkinManager.setImageResource(topicMediaHolder.f17302h, R.drawable.icon_play_video);
                SkinManager.setViewTextColor(topicMediaHolder.f17301g, R.color.CAM_X0101, 1);
                topicMediaHolder.f17299e.h(this.m);
                topicMediaHolder.f17301g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(topicMediaHolder.k, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundColor(topicMediaHolder.l, R.color.CAM_X0204);
            }
            topicMediaHolder.f17295a = this.m;
        }
        return this.o;
    }

    public void C0() {
        this.q = false;
    }

    public final void D0() {
        ForeDrawableImageView foreDrawableImageView;
        TopicMediaHolder topicMediaHolder = this.p;
        if (topicMediaHolder == null || (foreDrawableImageView = topicMediaHolder.f17296b) == null || topicMediaHolder.f17300f == null) {
            return;
        }
        foreDrawableImageView.setVisibility(0);
        this.p.f17300f.setVisibility(8);
        this.r = true;
        y0(this.p);
        E0(this.p);
    }

    public final void E0(TopicMediaHolder topicMediaHolder) {
        TopicVideoControllerView topicVideoControllerView;
        if (topicMediaHolder == null || (topicVideoControllerView = topicMediaHolder.f17298d) == null || topicMediaHolder.f17299e == null) {
            return;
        }
        topicVideoControllerView.o();
        topicMediaHolder.f17299e.i();
    }

    public final void F0(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.i.setVisibility(0);
            topicMediaHolder.f17296b.setForegroundDrawable(0);
        }
    }

    public final void G0(d.b.j0.c1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar == null || topicMediaHolder == null) {
            return;
        }
        if (this.s) {
            topicMediaHolder.f17299e.k();
        } else {
            topicMediaHolder.f17298d.q();
        }
    }

    public final void v0(TopicMediaHolder topicMediaHolder, d.b.j0.c1.c.o oVar) {
        if (d.b.c.e.p.j.x()) {
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.n.getPageContext().getPageActivity());
            aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.setPositiveButton(R.string.confirm, new n(topicMediaHolder, oVar));
            aVar.setNegativeButton(R.string.cancel, new o(this));
            aVar.create(this.n.getPageContext()).show();
            return;
        }
        w0(topicMediaHolder, oVar);
    }

    public final void w0(TopicMediaHolder topicMediaHolder, d.b.j0.c1.c.o oVar) {
        topicMediaHolder.f17297c.start();
        topicMediaHolder.f17302h.setVisibility(8);
        topicMediaHolder.f17300f.setVisibility(8);
        G0(oVar, topicMediaHolder);
    }

    public final void x0() {
        TbCyberVideoView tbCyberVideoView;
        TopicMediaHolder topicMediaHolder = this.p;
        if (topicMediaHolder == null || (tbCyberVideoView = topicMediaHolder.f17297c) == null || topicMediaHolder.f17302h == null || topicMediaHolder.i == null) {
            return;
        }
        if (tbCyberVideoView.isPlaying()) {
            this.p.f17297c.pause();
            this.p.f17302h.setVisibility(0);
        } else if (this.p.i.getVisibility() == 0) {
            this.p.f17297c.stopPlayback();
            this.r = true;
            y0(this.p);
        }
    }

    public final void y0(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.i.setVisibility(8);
            if (this.t) {
                topicMediaHolder.f17296b.setForegroundDrawable(0);
            } else {
                topicMediaHolder.f17296b.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    public final void z0(d.b.j0.c1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.f53966h) && oVar.i > 0) {
                topicMediaHolder.f17296b.W(oVar.j, 17, false);
            } else {
                topicMediaHolder.f17296b.W(oVar.f53965g, 17, false);
            }
            topicMediaHolder.f17296b.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.j)) {
                topicMediaHolder.f17296b.setEvent(new a(this));
            }
            if (this.s) {
                topicMediaHolder.f17299e.g();
            } else {
                topicMediaHolder.f17298d.l(0, oVar.i * 1000);
            }
        }
    }
}
