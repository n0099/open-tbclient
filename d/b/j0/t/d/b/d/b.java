package d.b.j0.t.d.b.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.toplivecard.AlaSquareLiveVideoMask;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import d.b.j0.j2.f;
import d.b.j0.j2.o;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f62270a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f62271b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f62272c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f62273d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.j2.f f62274e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.t.d.b.b.c f62275f;

    /* renamed from: g  reason: collision with root package name */
    public int f62276g;

    /* renamed from: h  reason: collision with root package name */
    public int f62277h;
    public int i;
    public int j;
    public int k;
    public String l;
    public boolean m;
    public f n;
    public int o;
    public TbCyberVideoView.g p;
    public CyberPlayerManager.OnErrorListener q;
    public CyberPlayerManager.OnPreparedListener r;
    public View.OnClickListener s;

    /* loaded from: classes4.dex */
    public class a implements TbCyberVideoView.g {
        public a() {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            b.this.r();
        }
    }

    /* renamed from: d.b.j0.t.d.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1617b implements CyberPlayerManager.OnErrorListener {
        public C1617b() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            b.this.s(false);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements CyberPlayerManager.OnPreparedListener {
        public c() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (b.this.f62273d != null) {
                b.this.f62273d.setLooping(false);
                b.this.f62273d.setVolume(0.0f, 0.0f);
                if (b.this.f62275f != null && b.this.f62275f.f62247a != null) {
                    if (b.this.m) {
                        if (b.this.n != null) {
                            b.this.n.b(b.this.f62275f.f62247a);
                        }
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c12646");
                        if (b.this.f62275f.f62248b != 0) {
                            if (b.this.f62275f.f62248b == 1) {
                                statisticItem.param("obj_type", 2);
                            }
                        } else {
                            statisticItem.param("obj_type", 1);
                        }
                        statisticItem.param("tid", b.this.f62275f.f62247a.w1());
                        TiebaStatic.log(statisticItem);
                    }
                }
                if (b.this.f62273d.getCyberPlayer() != null) {
                    b bVar = b.this;
                    bVar.v(bVar.f62273d.getCyberPlayer().getVideoHeight(), b.this.f62273d.getCyberPlayer().getVideoWidth());
                }
                if (b.this.f62272c != null) {
                    b.this.f62272c.d();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.d {
        public d(b bVar) {
        }

        @Override // d.b.j0.j2.f.d
        public void a() {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f62275f == null || b.this.f62275f.f62247a == null) {
                return;
            }
            if (b.this.n != null) {
                b.this.n.a(b.this.f62275f.f62247a);
            }
            b bVar = b.this;
            bVar.l(bVar.f62270a, b.this.f62275f.f62247a);
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(a2 a2Var);

        void b(a2 a2Var);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f62270a = null;
        this.l = "";
        this.m = false;
        this.p = new a();
        this.q = new C1617b();
        this.r = new c();
        this.s = new e();
        this.f62270a = tbPageContext;
        k();
    }

    public final void i() {
        a2 a2Var;
        d.b.j0.t.d.b.b.c cVar = this.f62275f;
        if (cVar == null || (a2Var = cVar.f62247a) == null || a2Var.q1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f62273d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f62274e = new d.b.j0.j2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.f62270a.getPageActivity());
        this.f62273d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f62273d.setOnErrorListener(this.q);
        this.f62273d.setOnSurfaceDestroyedListener(this.p);
        this.f62273d.setVolume(0.0f, 0.0f);
        this.f62273d.setStageType(null);
        this.f62274e.l(this.f62273d);
        this.f62274e.k(new d(this));
        if (this.f62273d.getParent() == null) {
            this.f62271b.addView(this.f62273d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f62275f.f62247a.q1().screen_direction);
    }

    public View j() {
        return this.f62271b;
    }

    public final void k() {
        TbPageContext<?> tbPageContext = this.f62270a;
        if (tbPageContext == null) {
            return;
        }
        this.f62271b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f62277h = l.k(this.f62270a.getPageActivity());
        int i = l.i(this.f62270a.getPageActivity());
        this.i = i;
        int i2 = this.f62277h;
        this.j = (int) ((i2 / 16.0d) * 9.0d);
        int i3 = (int) ((i2 / 4.0d) * 3.0d);
        this.k = i3;
        this.o = (int) ((i / 3.0d) - (i3 / 2.0d));
        this.f62272c = (AlaSquareLiveVideoMask) this.f62271b.findViewById(R.id.video_mask);
        this.f62271b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, a2 a2Var) {
        String str;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        d.b.j0.t.d.b.b.c cVar = this.f62275f;
        if (cVar != null && cVar.f62247a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i = this.f62275f.f62248b;
            if (i == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f62275f.f62247a.w1());
            TiebaStatic.log(statisticItem);
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = a2Var.T().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        String str2 = this.m ? AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_TAB_TOP_LIVE : AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_RECOMMEND_TOP_CARD;
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        alaLiveInfoCoreData.userName = a2Var.q1().user_info.user_name;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str2, str, z, "")));
    }

    public void m() {
        this.f62277h = l.k(this.f62270a.getPageActivity());
        int i = l.i(this.f62270a.getPageActivity());
        this.i = i;
        int i2 = this.f62277h;
        this.j = (int) ((i2 / 16.0d) * 9.0d);
        int i3 = (int) ((i2 / 4.0d) * 3.0d);
        this.k = i3;
        this.o = (int) ((i / 3.0d) - (i3 / 2.0d));
        if (this.f62275f != null) {
            TbCyberVideoView tbCyberVideoView = this.f62273d;
            boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
            t(this.f62275f.f62247a.q1().screen_direction);
            u(this.f62275f.f62247a.q1().screen_direction);
            r();
            if (isPlaying) {
                x(this.l);
            }
        }
    }

    public void n(d.b.j0.t.d.b.b.c cVar) {
        a2 a2Var;
        a2 a2Var2;
        if (cVar == null || (a2Var = cVar.f62247a) == null || a2Var.q1() == null) {
            return;
        }
        d.b.j0.t.d.b.b.c cVar2 = this.f62275f;
        if (cVar2 == null || ((a2Var2 = cVar2.f62247a) != null && !a2Var2.w1().equals(cVar.f62247a.w1()))) {
            t(cVar.f62247a.q1().screen_direction);
        }
        this.f62275f = cVar;
        this.f62276g = cVar.f62247a.q1().screen_direction;
        this.f62272c.setData(this.f62275f.f62247a);
    }

    public void o() {
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f62272c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.b();
        }
        SkinManager.setBackgroundColor(this.f62273d, R.color.black_alpha100);
    }

    public void p() {
        q();
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f62272c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.c();
        }
    }

    public final void q() {
        d.b.j0.j2.f fVar = this.f62274e;
        if (fVar != null) {
            fVar.l(null);
            this.f62274e.n();
            this.f62274e = null;
        }
        TbCyberVideoView tbCyberVideoView = this.f62273d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
            this.f62273d.G();
            if (this.f62273d.getMediaProgressObserver() != null) {
                this.f62273d.getMediaProgressObserver().l(null);
                this.f62273d.getMediaProgressObserver().n();
            }
            this.f62273d = null;
        }
    }

    public void r() {
        s(true);
    }

    public void s(boolean z) {
        if (z) {
            q();
        }
        TbCyberVideoView tbCyberVideoView = this.f62273d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
        this.f62272c.f();
        this.f62272c.e();
    }

    public final void t(int i) {
        if (i == 1) {
            if (this.m) {
                if (this.f62271b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f62271b.getLayoutParams();
                    layoutParams.width = this.f62277h;
                    layoutParams.height = this.k;
                    this.f62271b.setLayoutParams(layoutParams);
                    return;
                }
                this.f62271b.setLayoutParams(new FrameLayout.LayoutParams(this.f62277h, this.k));
                return;
            } else if (this.f62271b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f62271b.getLayoutParams();
                int i2 = this.f62277h;
                layoutParams2.width = i2;
                layoutParams2.height = i2;
                this.f62271b.setLayoutParams(layoutParams2);
                return;
            } else {
                FrameLayout frameLayout = this.f62271b;
                int i3 = this.f62277h;
                frameLayout.setLayoutParams(new AbsListView.LayoutParams(i3, i3));
                return;
            }
        }
        this.f62276g = 2;
        if (this.m) {
            if (this.f62271b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f62271b.getLayoutParams();
                layoutParams3.width = this.f62277h;
                layoutParams3.height = this.j;
                this.f62271b.setLayoutParams(layoutParams3);
                return;
            }
            this.f62271b.setLayoutParams(new AbsListView.LayoutParams(this.f62277h, this.j));
        } else if (this.f62271b.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f62271b.getLayoutParams();
            layoutParams4.width = this.f62277h;
            layoutParams4.height = this.j;
            this.f62271b.setLayoutParams(layoutParams4);
        } else {
            this.f62271b.setLayoutParams(new AbsListView.LayoutParams(this.f62277h, this.j));
        }
    }

    public final void u(int i) {
        TbCyberVideoView tbCyberVideoView = this.f62273d;
        if (tbCyberVideoView == null) {
            return;
        }
        if (i == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f62273d.getLayoutParams();
                layoutParams.width = this.f62277h;
                layoutParams.height = this.i;
                layoutParams.topMargin = -this.o;
                this.f62273d.setLayoutParams(layoutParams);
                return;
            }
            this.f62273d.setLayoutParams(new FrameLayout.LayoutParams(this.f62277h, this.i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f62273d.getLayoutParams();
            layoutParams2.width = this.f62277h;
            layoutParams2.height = this.j;
            this.f62273d.setLayoutParams(layoutParams2);
        } else {
            this.f62273d.setLayoutParams(new FrameLayout.LayoutParams(this.f62277h, this.j));
        }
    }

    public final void v(int i, int i2) {
        TbCyberVideoView tbCyberVideoView;
        if (this.f62276g != 1 || (tbCyberVideoView = this.f62273d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i;
        float f3 = i2;
        float f4 = f2 / f3;
        int i3 = this.f62277h;
        float f5 = i3 * f2;
        int i4 = this.i;
        float f6 = f5 / i4;
        if (f6 < f3) {
            i3 = (int) (i4 / f4);
        } else if (f6 > f3) {
            i4 = (int) (i3 * f4);
        }
        if (this.f62273d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f62273d.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.f62273d.setLayoutParams(layoutParams);
            return;
        }
        this.f62273d.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
    }

    public void w(f fVar) {
        this.n = fVar;
    }

    public void x(String str) {
        d.b.j0.t.d.b.b.c cVar;
        a2 a2Var;
        TbCyberVideoView tbCyberVideoView;
        if (StringUtils.isNull(str) || (cVar = this.f62275f) == null || (a2Var = cVar.f62247a) == null || a2Var.q1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f62273d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f62273d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f62273d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        o oVar = new o();
        oVar.f58032a = HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9;
        oVar.f58035d = String.valueOf(this.f62275f.f62247a.c0());
        oVar.f58034c = this.f62275f.f62247a.w1();
        this.f62273d.setVideoStatData(oVar);
        TbCyberVideoView tbCyberVideoView3 = this.f62273d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f62275f.f62247a.q1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f62273d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        d.b.j0.j2.f fVar = this.f62274e;
        if (fVar != null) {
            fVar.m();
        }
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.m = z;
        this.f62272c.setFromSpecialForum(z);
    }
}
