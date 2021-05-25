package d.a.n0.v.d.b.d;

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
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import d.a.n0.k2.f;
import d.a.n0.k2.o;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f61463a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f61464b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f61465c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f61466d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.k2.f f61467e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.v.d.b.b.c f61468f;

    /* renamed from: g  reason: collision with root package name */
    public int f61469g;

    /* renamed from: h  reason: collision with root package name */
    public int f61470h;

    /* renamed from: i  reason: collision with root package name */
    public int f61471i;
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

    /* renamed from: d.a.n0.v.d.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1642b implements CyberPlayerManager.OnErrorListener {
        public C1642b() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
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
            if (b.this.f61466d != null) {
                b.this.f61466d.setLooping(false);
                b.this.f61466d.setVolume(0.0f, 0.0f);
                if (b.this.f61468f != null && b.this.f61468f.f61439a != null) {
                    if (b.this.m) {
                        if (b.this.n != null) {
                            b.this.n.b(b.this.f61468f.f61439a);
                        }
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c12646");
                        if (b.this.f61468f.f61440b != 0) {
                            if (b.this.f61468f.f61440b == 1) {
                                statisticItem.param("obj_type", 2);
                            }
                        } else {
                            statisticItem.param("obj_type", 1);
                        }
                        statisticItem.param("tid", b.this.f61468f.f61439a.y1());
                        TiebaStatic.log(statisticItem);
                    }
                }
                if (b.this.f61466d.getCyberPlayer() != null) {
                    b bVar = b.this;
                    bVar.v(bVar.f61466d.getCyberPlayer().getVideoHeight(), b.this.f61466d.getCyberPlayer().getVideoWidth());
                }
                if (b.this.f61465c != null) {
                    b.this.f61465c.d();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.d {
        public d(b bVar) {
        }

        @Override // d.a.n0.k2.f.d
        public void a() {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f61468f == null || b.this.f61468f.f61439a == null) {
                return;
            }
            if (b.this.n != null) {
                b.this.n.a(b.this.f61468f.f61439a);
            }
            b bVar = b.this;
            bVar.l(bVar.f61463a, b.this.f61468f.f61439a);
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(a2 a2Var);

        void b(a2 a2Var);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f61463a = null;
        this.l = "";
        this.m = false;
        this.p = new a();
        this.q = new C1642b();
        this.r = new c();
        this.s = new e();
        this.f61463a = tbPageContext;
        k();
    }

    public final void i() {
        a2 a2Var;
        d.a.n0.v.d.b.b.c cVar = this.f61468f;
        if (cVar == null || (a2Var = cVar.f61439a) == null || a2Var.r1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f61466d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f61467e = new d.a.n0.k2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.f61463a.getPageActivity());
        this.f61466d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f61466d.setOnErrorListener(this.q);
        this.f61466d.setOnSurfaceDestroyedListener(this.p);
        this.f61466d.setVolume(0.0f, 0.0f);
        this.f61466d.setStageType(null);
        this.f61467e.l(this.f61466d);
        this.f61467e.k(new d(this));
        if (this.f61466d.getParent() == null) {
            this.f61464b.addView(this.f61466d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f61468f.f61439a.r1().screen_direction);
    }

    public View j() {
        return this.f61464b;
    }

    public final void k() {
        TbPageContext<?> tbPageContext = this.f61463a;
        if (tbPageContext == null) {
            return;
        }
        this.f61464b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f61470h = l.k(this.f61463a.getPageActivity());
        int i2 = l.i(this.f61463a.getPageActivity());
        this.f61471i = i2;
        int i3 = this.f61470h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f61465c = (AlaSquareLiveVideoMask) this.f61464b.findViewById(R.id.video_mask);
        this.f61464b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, a2 a2Var) {
        String str;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.r1() == null) {
            return;
        }
        d.a.n0.v.d.b.b.c cVar = this.f61468f;
        if (cVar != null && cVar.f61439a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f61468f.f61440b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f61468f.f61439a.y1());
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
        alaLiveInfoCoreData.fillWithInfoData(a2Var.r1());
        alaLiveInfoCoreData.userName = a2Var.r1().user_info.user_name;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str2, str, z, "")));
    }

    public void m() {
        this.f61470h = l.k(this.f61463a.getPageActivity());
        int i2 = l.i(this.f61463a.getPageActivity());
        this.f61471i = i2;
        int i3 = this.f61470h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        if (this.f61468f != null) {
            TbCyberVideoView tbCyberVideoView = this.f61466d;
            boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
            t(this.f61468f.f61439a.r1().screen_direction);
            u(this.f61468f.f61439a.r1().screen_direction);
            r();
            if (isPlaying) {
                x(this.l);
            }
        }
    }

    public void n(d.a.n0.v.d.b.b.c cVar) {
        a2 a2Var;
        a2 a2Var2;
        if (cVar == null || (a2Var = cVar.f61439a) == null || a2Var.r1() == null) {
            return;
        }
        d.a.n0.v.d.b.b.c cVar2 = this.f61468f;
        if (cVar2 == null || ((a2Var2 = cVar2.f61439a) != null && !a2Var2.y1().equals(cVar.f61439a.y1()))) {
            t(cVar.f61439a.r1().screen_direction);
        }
        this.f61468f = cVar;
        this.f61469g = cVar.f61439a.r1().screen_direction;
        this.f61465c.setData(this.f61468f.f61439a);
    }

    public void o() {
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f61465c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.b();
        }
        SkinManager.setBackgroundColor(this.f61466d, R.color.black_alpha100);
    }

    public void p() {
        q();
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f61465c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.c();
        }
    }

    public final void q() {
        d.a.n0.k2.f fVar = this.f61467e;
        if (fVar != null) {
            fVar.l(null);
            this.f61467e.n();
            this.f61467e = null;
        }
        TbCyberVideoView tbCyberVideoView = this.f61466d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
            this.f61466d.G();
            if (this.f61466d.getMediaProgressObserver() != null) {
                this.f61466d.getMediaProgressObserver().l(null);
                this.f61466d.getMediaProgressObserver().n();
            }
            this.f61466d = null;
        }
    }

    public void r() {
        s(true);
    }

    public void s(boolean z) {
        if (z) {
            q();
        }
        TbCyberVideoView tbCyberVideoView = this.f61466d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
        this.f61465c.f();
        this.f61465c.e();
    }

    public final void t(int i2) {
        if (i2 == 1) {
            if (this.m) {
                if (this.f61464b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f61464b.getLayoutParams();
                    layoutParams.width = this.f61470h;
                    layoutParams.height = this.k;
                    this.f61464b.setLayoutParams(layoutParams);
                    return;
                }
                this.f61464b.setLayoutParams(new FrameLayout.LayoutParams(this.f61470h, this.k));
                return;
            } else if (this.f61464b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f61464b.getLayoutParams();
                int i3 = this.f61470h;
                layoutParams2.width = i3;
                layoutParams2.height = i3;
                this.f61464b.setLayoutParams(layoutParams2);
                return;
            } else {
                FrameLayout frameLayout = this.f61464b;
                int i4 = this.f61470h;
                frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                return;
            }
        }
        this.f61469g = 2;
        if (this.m) {
            if (this.f61464b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f61464b.getLayoutParams();
                layoutParams3.width = this.f61470h;
                layoutParams3.height = this.j;
                this.f61464b.setLayoutParams(layoutParams3);
                return;
            }
            this.f61464b.setLayoutParams(new AbsListView.LayoutParams(this.f61470h, this.j));
        } else if (this.f61464b.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f61464b.getLayoutParams();
            layoutParams4.width = this.f61470h;
            layoutParams4.height = this.j;
            this.f61464b.setLayoutParams(layoutParams4);
        } else {
            this.f61464b.setLayoutParams(new AbsListView.LayoutParams(this.f61470h, this.j));
        }
    }

    public final void u(int i2) {
        TbCyberVideoView tbCyberVideoView = this.f61466d;
        if (tbCyberVideoView == null) {
            return;
        }
        if (i2 == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f61466d.getLayoutParams();
                layoutParams.width = this.f61470h;
                layoutParams.height = this.f61471i;
                layoutParams.topMargin = -this.o;
                this.f61466d.setLayoutParams(layoutParams);
                return;
            }
            this.f61466d.setLayoutParams(new FrameLayout.LayoutParams(this.f61470h, this.f61471i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f61466d.getLayoutParams();
            layoutParams2.width = this.f61470h;
            layoutParams2.height = this.j;
            this.f61466d.setLayoutParams(layoutParams2);
        } else {
            this.f61466d.setLayoutParams(new FrameLayout.LayoutParams(this.f61470h, this.j));
        }
    }

    public final void v(int i2, int i3) {
        TbCyberVideoView tbCyberVideoView;
        if (this.f61469g != 1 || (tbCyberVideoView = this.f61466d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f61470h;
        float f5 = i4 * f2;
        int i5 = this.f61471i;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f61466d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f61466d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f61466d.setLayoutParams(layoutParams);
            return;
        }
        this.f61466d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(f fVar) {
        this.n = fVar;
    }

    public void x(String str) {
        d.a.n0.v.d.b.b.c cVar;
        a2 a2Var;
        TbCyberVideoView tbCyberVideoView;
        if (StringUtils.isNull(str) || (cVar = this.f61468f) == null || (a2Var = cVar.f61439a) == null || a2Var.r1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f61466d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f61466d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f61466d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        o oVar = new o();
        oVar.f56898a = HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9;
        oVar.f56901d = String.valueOf(this.f61468f.f61439a.c0());
        oVar.f56900c = this.f61468f.f61439a.y1();
        this.f61466d.setVideoStatData(oVar);
        TbCyberVideoView tbCyberVideoView3 = this.f61466d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f61468f.f61439a.r1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f61466d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        d.a.n0.k2.f fVar = this.f61467e;
        if (fVar != null) {
            fVar.m();
        }
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.m = z;
        this.f61465c.setFromSpecialForum(z);
    }
}
