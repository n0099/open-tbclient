package d.a.n0.d1.a;

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
import d.a.m0.r.s.a;
/* loaded from: classes4.dex */
public class k extends d.a.c.j.e.a<d.a.n0.d1.c.o, TopicMediaHolder> {
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
        public boolean onError(int i2, int i3, Object obj) {
            if (!k.this.r) {
                BdToast.i(k.this.n.getPageContext().getPageActivity(), k.this.n.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).q();
            }
            k.this.D0();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k.this.x0();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (k.this.p == null || k.this.p.f16818b == null || k.this.p.f16822f == null || k.this.p.f16819c == null) {
                return;
            }
            k.this.p.f16818b.setVisibility(0);
            k.this.p.f16822f.setVisibility(8);
            k.this.p.f16819c.stopPlayback();
            k.this.r = true;
            k kVar = k.this;
            kVar.y0(kVar.p);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (k.this.p == null || k.this.p.m == null) {
                return;
            }
            int[] iArr = new int[2];
            k.this.p.m.getLocationInWindow(iArr);
            int i2 = iArr[1];
            k.this.p.m.getHeight();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (k.this.v != null) {
                k.this.v.removeMessages(1);
            }
            if (k.this.p == null || k.this.p.f16820d == null || k.this.p.f16821e == null) {
                return;
            }
            k.this.p.f16820d.j();
            k.this.p.f16821e.e();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f52494e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.d1.c.o f52495f;

        public g(TopicMediaHolder topicMediaHolder, d.a.n0.d1.c.o oVar) {
            this.f52494e = topicMediaHolder;
            this.f52495f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f52494e.f16822f.setVisibility(8);
            TbCyberVideoView tbCyberVideoView = this.f52494e.f16819c;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.setPlayMode("2");
            }
            this.f52494e.f16819c.start();
            k.this.G0(this.f52495f, this.f52494e);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements CyberPlayerManager.OnPreparedListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f52497e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.d1.c.o f52498f;

        public h(TopicMediaHolder topicMediaHolder, d.a.n0.d1.c.o oVar) {
            this.f52497e = topicMediaHolder;
            this.f52498f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TopicVideoControllerView topicVideoControllerView;
            TopicMediaHolder topicMediaHolder = this.f52497e;
            if (topicMediaHolder == null || topicMediaHolder.f16819c == null || (topicVideoControllerView = topicMediaHolder.f16820d) == null) {
                return;
            }
            int curProgress = topicVideoControllerView.getCurProgress();
            if (curProgress > 0) {
                float duration = this.f52497e.f16819c.getDuration() * 1.0f * curProgress;
                TopicMediaHolder topicMediaHolder2 = this.f52497e;
                TopicVideoControllerView topicVideoControllerView2 = topicMediaHolder2.f16820d;
                topicMediaHolder2.f16819c.seekTo((int) (duration / 10000.0f));
            }
            Message obtainMessage = k.this.v.obtainMessage(1);
            obtainMessage.obj = this.f52498f;
            k.this.v.sendMessage(obtainMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements CyberPlayerManager.OnCompletionListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f52500e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.d1.c.o f52501f;

        public i(TopicMediaHolder topicMediaHolder, d.a.n0.d1.c.o oVar) {
            this.f52500e = topicMediaHolder;
            this.f52501f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            this.f52500e.f16822f.setVisibility(0);
            k.this.z0(this.f52501f, this.f52500e);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f52503e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.d1.c.o f52504f;

        public j(TopicMediaHolder topicMediaHolder, d.a.n0.d1.c.o oVar) {
            this.f52503e = topicMediaHolder;
            this.f52504f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f52503e.f16819c.isPlaying()) {
                k.this.v0(this.f52503e, this.f52504f);
                return;
            }
            this.f52503e.f16819c.pause();
            this.f52503e.f16824h.setVisibility(0);
        }
    }

    /* renamed from: d.a.n0.d1.a.k$k  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1237k implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.d1.c.o f52506e;

        public View$OnClickListenerC1237k(d.a.n0.d1.c.o oVar) {
            this.f52506e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k.this.n.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(k.this.n.getActivity()).createNormalConfig(String.valueOf(this.f52506e.f52606e), this.f52506e.f52607f, "")));
        }
    }

    /* loaded from: classes4.dex */
    public class l implements TbCyberVideoView.g {
        public l() {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            if (k.this.p != null && k.this.p.f16819c != null) {
                k.this.p.f16819c.stopPlayback();
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
            if (message.what != 1 || k.this.r || k.this.p == null || k.this.p.f16819c == null || k.this.p.f16818b == null || k.this.p.f16822f == null || k.this.p.f16824h == null) {
                return;
            }
            if (k.this.p.f16819c.getCurrentPosition() > 0) {
                k.this.p.f16818b.setVisibility(8);
                k.this.p.f16822f.setVisibility(8);
                k.this.p.f16824h.setVisibility(8);
                k kVar = k.this;
                kVar.G0((d.a.n0.d1.c.o) message.obj, kVar.p);
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
        public final /* synthetic */ TopicMediaHolder f52510e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.d1.c.o f52511f;

        public n(TopicMediaHolder topicMediaHolder, d.a.n0.d1.c.o oVar) {
            this.f52510e = topicMediaHolder;
            this.f52511f = oVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            TbCyberVideoView tbCyberVideoView;
            TopicMediaHolder topicMediaHolder = this.f52510e;
            if (topicMediaHolder != null && (tbCyberVideoView = topicMediaHolder.f16819c) != null) {
                tbCyberVideoView.setPlayMode("2");
            }
            k.this.w0(this.f52510e, this.f52511f);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class o implements a.e {
        public o(k kVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public d.a.n0.d1.c.o f52513e;

        /* renamed from: f  reason: collision with root package name */
        public TopicMediaHolder f52514f;

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a() {
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                p.this.b();
                aVar.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b(p pVar) {
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public p(d.a.n0.d1.c.o oVar, TopicMediaHolder topicMediaHolder) {
            this.f52513e = oVar;
            this.f52514f = topicMediaHolder;
        }

        public final void b() {
            TopicMediaHolder topicMediaHolder;
            TbCyberVideoView tbCyberVideoView;
            if (this.f52513e == null || (topicMediaHolder = this.f52514f) == null || (tbCyberVideoView = topicMediaHolder.f16819c) == null) {
                return;
            }
            tbCyberVideoView.setPlayMode("2");
            this.f52514f.f16819c.setVideoPath(this.f52513e.f52609h);
            this.f52514f.f16819c.start();
            k.this.r = false;
            k.this.F0(this.f52514f);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicMediaHolder topicMediaHolder;
            View view2;
            if (this.f52513e == null || (topicMediaHolder = this.f52514f) == null || (view2 = topicMediaHolder.f16825i) == null || topicMediaHolder.f16819c == null) {
                return;
            }
            if (view2.getVisibility() == 0) {
                this.f52514f.f16819c.stopPlayback();
                k.this.r = true;
                k.this.y0(this.f52514f);
            } else if (d.a.c.e.p.j.x()) {
                d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(k.this.n.getPageContext().getPageActivity());
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
    @Override // d.a.c.j.e.a
    /* renamed from: A0 */
    public TopicMediaHolder P(ViewGroup viewGroup) {
        if (this.o == null) {
            this.o = LayoutInflater.from(this.f39228e).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.p = new TopicMediaHolder(this.o);
            View findViewById = this.o.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int k = d.a.c.e.p.l.k(this.f39228e);
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
    @Override // d.a.c.j.e.a
    /* renamed from: B0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.d1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null && topicMediaHolder != null) {
            if (!this.q) {
                this.q = true;
                if (!StringUtils.isNull(oVar.f52609h) && oVar.f52610i > 0) {
                    this.t = false;
                    topicMediaHolder.j.setVisibility(0);
                    if (this.s) {
                        topicMediaHolder.f16820d.setVisibility(8);
                        topicMediaHolder.f16821e.setVisibility(0);
                    } else {
                        topicMediaHolder.f16820d.setVisibility(0);
                        topicMediaHolder.f16821e.setVisibility(8);
                    }
                } else {
                    this.t = true;
                    topicMediaHolder.f16820d.setVisibility(8);
                    topicMediaHolder.f16821e.setVisibility(8);
                    topicMediaHolder.j.setVisibility(8);
                }
                if (!StringUtils.isNull(oVar.f52609h) && oVar.f52610i > 0) {
                    topicMediaHolder.f16818b.setForegroundDrawable(R.drawable.icon_play_video);
                    topicMediaHolder.f16818b.setOnClickListener(new p(oVar, topicMediaHolder));
                } else {
                    topicMediaHolder.f16818b.setForegroundDrawable(0);
                    topicMediaHolder.f16818b.setOnClickListener(null);
                }
                topicMediaHolder.f16818b.setTag(Integer.valueOf(i2));
                topicMediaHolder.f16818b.setDefaultResource(0);
                if (!d.a.m0.r.k.c().g()) {
                    topicMediaHolder.f16818b.setNoImageBottomTextColor(R.color.CAM_X0108);
                    topicMediaHolder.f16818b.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    topicMediaHolder.f16818b.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    topicMediaHolder.f16818b.setSupportNoImage(true);
                    topicMediaHolder.f16818b.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    topicMediaHolder.f16818b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!topicMediaHolder.f16819c.isPlaying()) {
                        z0(oVar, topicMediaHolder);
                    }
                }
                topicMediaHolder.f16823g.setOnClickListener(new g(topicMediaHolder, oVar));
                topicMediaHolder.f16819c.setOnPreparedListener(new h(topicMediaHolder, oVar));
                topicMediaHolder.f16819c.setOnCompletionListener(new i(topicMediaHolder, oVar));
                topicMediaHolder.f16819c.setOnErrorListener(this.w);
                topicMediaHolder.f16819c.setOnSurfaceDestroyedListener(this.u);
                topicMediaHolder.j.setOnClickListener(new j(topicMediaHolder, oVar));
                if (this.s) {
                    topicMediaHolder.f16821e.setPlayer(topicMediaHolder.f16819c);
                } else {
                    topicMediaHolder.f16820d.setPlayer(topicMediaHolder.f16819c);
                }
                if (StringUtils.isNull(oVar.f52607f)) {
                    topicMediaHolder.k.setVisibility(8);
                    topicMediaHolder.l.setVisibility(8);
                } else {
                    topicMediaHolder.k.setVisibility(0);
                    topicMediaHolder.l.setVisibility(0);
                    topicMediaHolder.k.setText(oVar.f52607f);
                    topicMediaHolder.k.setOnClickListener(new View$OnClickListenerC1237k(oVar));
                }
            }
            if (topicMediaHolder.f16817a != this.m) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
                topicMediaHolder.f16820d.m(this.m);
                SkinManager.setImageResource(topicMediaHolder.f16824h, R.drawable.icon_play_video);
                SkinManager.setViewTextColor(topicMediaHolder.f16823g, R.color.CAM_X0101, 1);
                topicMediaHolder.f16821e.h(this.m);
                topicMediaHolder.f16823g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(topicMediaHolder.k, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundColor(topicMediaHolder.l, R.color.CAM_X0204);
            }
            topicMediaHolder.f16817a = this.m;
        }
        return this.o;
    }

    public void C0() {
        this.q = false;
    }

    public final void D0() {
        ForeDrawableImageView foreDrawableImageView;
        TopicMediaHolder topicMediaHolder = this.p;
        if (topicMediaHolder == null || (foreDrawableImageView = topicMediaHolder.f16818b) == null || topicMediaHolder.f16822f == null) {
            return;
        }
        foreDrawableImageView.setVisibility(0);
        this.p.f16822f.setVisibility(8);
        this.r = true;
        y0(this.p);
        E0(this.p);
    }

    public final void E0(TopicMediaHolder topicMediaHolder) {
        TopicVideoControllerView topicVideoControllerView;
        if (topicMediaHolder == null || (topicVideoControllerView = topicMediaHolder.f16820d) == null || topicMediaHolder.f16821e == null) {
            return;
        }
        topicVideoControllerView.o();
        topicMediaHolder.f16821e.i();
    }

    public final void F0(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.f16825i.setVisibility(0);
            topicMediaHolder.f16818b.setForegroundDrawable(0);
        }
    }

    public final void G0(d.a.n0.d1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar == null || topicMediaHolder == null) {
            return;
        }
        if (this.s) {
            topicMediaHolder.f16821e.k();
        } else {
            topicMediaHolder.f16820d.q();
        }
    }

    public final void v0(TopicMediaHolder topicMediaHolder, d.a.n0.d1.c.o oVar) {
        if (d.a.c.e.p.j.x()) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.n.getPageContext().getPageActivity());
            aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.setPositiveButton(R.string.confirm, new n(topicMediaHolder, oVar));
            aVar.setNegativeButton(R.string.cancel, new o(this));
            aVar.create(this.n.getPageContext()).show();
            return;
        }
        w0(topicMediaHolder, oVar);
    }

    public final void w0(TopicMediaHolder topicMediaHolder, d.a.n0.d1.c.o oVar) {
        topicMediaHolder.f16819c.start();
        topicMediaHolder.f16824h.setVisibility(8);
        topicMediaHolder.f16822f.setVisibility(8);
        G0(oVar, topicMediaHolder);
    }

    public final void x0() {
        TbCyberVideoView tbCyberVideoView;
        TopicMediaHolder topicMediaHolder = this.p;
        if (topicMediaHolder == null || (tbCyberVideoView = topicMediaHolder.f16819c) == null || topicMediaHolder.f16824h == null || topicMediaHolder.f16825i == null) {
            return;
        }
        if (tbCyberVideoView.isPlaying()) {
            this.p.f16819c.pause();
            this.p.f16824h.setVisibility(0);
        } else if (this.p.f16825i.getVisibility() == 0) {
            this.p.f16819c.stopPlayback();
            this.r = true;
            y0(this.p);
        }
    }

    public final void y0(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.f16825i.setVisibility(8);
            if (this.t) {
                topicMediaHolder.f16818b.setForegroundDrawable(0);
            } else {
                topicMediaHolder.f16818b.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    public final void z0(d.a.n0.d1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.f52609h) && oVar.f52610i > 0) {
                topicMediaHolder.f16818b.V(oVar.j, 17, false);
            } else {
                topicMediaHolder.f16818b.V(oVar.f52608g, 17, false);
            }
            topicMediaHolder.f16818b.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.j)) {
                topicMediaHolder.f16818b.setEvent(new a(this));
            }
            if (this.s) {
                topicMediaHolder.f16821e.g();
            } else {
                topicMediaHolder.f16820d.l(0, oVar.f52610i * 1000);
            }
        }
    }
}
