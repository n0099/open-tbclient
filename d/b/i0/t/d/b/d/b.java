package d.b.i0.t.d.b.d;

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
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.i0.i2.f;
import d.b.i0.i2.o;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60284a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f60285b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f60286c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f60287d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.i2.f f60288e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.t.d.b.b.c f60289f;

    /* renamed from: g  reason: collision with root package name */
    public int f60290g;

    /* renamed from: h  reason: collision with root package name */
    public int f60291h;
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

    /* renamed from: d.b.i0.t.d.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1540b implements CyberPlayerManager.OnErrorListener {
        public C1540b() {
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
            if (b.this.f60287d != null) {
                b.this.f60287d.setLooping(false);
                b.this.f60287d.setVolume(0.0f, 0.0f);
                if (b.this.f60289f != null && b.this.f60289f.f60261a != null) {
                    if (b.this.m) {
                        if (b.this.n != null) {
                            b.this.n.b(b.this.f60289f.f60261a);
                        }
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c12646");
                        if (b.this.f60289f.f60262b != 0) {
                            if (b.this.f60289f.f60262b == 1) {
                                statisticItem.param("obj_type", 2);
                            }
                        } else {
                            statisticItem.param("obj_type", 1);
                        }
                        statisticItem.param("tid", b.this.f60289f.f60261a.w1());
                        TiebaStatic.log(statisticItem);
                    }
                }
                if (b.this.f60287d.getCyberPlayer() != null) {
                    b bVar = b.this;
                    bVar.v(bVar.f60287d.getCyberPlayer().getVideoHeight(), b.this.f60287d.getCyberPlayer().getVideoWidth());
                }
                if (b.this.f60286c != null) {
                    b.this.f60286c.d();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.d {
        public d(b bVar) {
        }

        @Override // d.b.i0.i2.f.d
        public void a() {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f60289f == null || b.this.f60289f.f60261a == null) {
                return;
            }
            if (b.this.n != null) {
                b.this.n.a(b.this.f60289f.f60261a);
            }
            b bVar = b.this;
            bVar.l(bVar.f60284a, b.this.f60289f.f60261a);
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(a2 a2Var);

        void b(a2 a2Var);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f60284a = null;
        this.l = "";
        this.m = false;
        this.p = new a();
        this.q = new C1540b();
        this.r = new c();
        this.s = new e();
        this.f60284a = tbPageContext;
        k();
    }

    public final void i() {
        a2 a2Var;
        d.b.i0.t.d.b.b.c cVar = this.f60289f;
        if (cVar == null || (a2Var = cVar.f60261a) == null || a2Var.q1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f60287d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f60288e = new d.b.i0.i2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.f60284a.getPageActivity());
        this.f60287d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f60287d.setOnErrorListener(this.q);
        this.f60287d.setOnSurfaceDestroyedListener(this.p);
        this.f60287d.setVolume(0.0f, 0.0f);
        this.f60287d.setStageType(null);
        this.f60288e.l(this.f60287d);
        this.f60288e.k(new d(this));
        if (this.f60287d.getParent() == null) {
            this.f60285b.addView(this.f60287d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f60289f.f60261a.q1().screen_direction);
    }

    public View j() {
        return this.f60285b;
    }

    public final void k() {
        TbPageContext<?> tbPageContext = this.f60284a;
        if (tbPageContext == null) {
            return;
        }
        this.f60285b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f60291h = l.k(this.f60284a.getPageActivity());
        int i = l.i(this.f60284a.getPageActivity());
        this.i = i;
        int i2 = this.f60291h;
        double d2 = i2;
        Double.isNaN(d2);
        this.j = (int) ((d2 / 16.0d) * 9.0d);
        double d3 = i2;
        Double.isNaN(d3);
        int i3 = (int) ((d3 / 4.0d) * 3.0d);
        this.k = i3;
        double d4 = i;
        Double.isNaN(d4);
        double d5 = i3;
        Double.isNaN(d5);
        this.o = (int) ((d4 / 3.0d) - (d5 / 2.0d));
        this.f60286c = (AlaSquareLiveVideoMask) this.f60285b.findViewById(R.id.video_mask);
        this.f60285b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, a2 a2Var) {
        String str;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        d.b.i0.t.d.b.b.c cVar = this.f60289f;
        if (cVar != null && cVar.f60261a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i = this.f60289f.f60262b;
            if (i == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f60289f.f60261a.w1());
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
        this.f60291h = l.k(this.f60284a.getPageActivity());
        int i = l.i(this.f60284a.getPageActivity());
        this.i = i;
        int i2 = this.f60291h;
        double d2 = i2;
        Double.isNaN(d2);
        this.j = (int) ((d2 / 16.0d) * 9.0d);
        double d3 = i2;
        Double.isNaN(d3);
        int i3 = (int) ((d3 / 4.0d) * 3.0d);
        this.k = i3;
        double d4 = i;
        Double.isNaN(d4);
        double d5 = i3;
        Double.isNaN(d5);
        this.o = (int) ((d4 / 3.0d) - (d5 / 2.0d));
        if (this.f60289f != null) {
            TbCyberVideoView tbCyberVideoView = this.f60287d;
            boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
            t(this.f60289f.f60261a.q1().screen_direction);
            u(this.f60289f.f60261a.q1().screen_direction);
            r();
            if (isPlaying) {
                x(this.l);
            }
        }
    }

    public void n(d.b.i0.t.d.b.b.c cVar) {
        a2 a2Var;
        a2 a2Var2;
        if (cVar == null || (a2Var = cVar.f60261a) == null || a2Var.q1() == null) {
            return;
        }
        d.b.i0.t.d.b.b.c cVar2 = this.f60289f;
        if (cVar2 == null || ((a2Var2 = cVar2.f60261a) != null && !a2Var2.w1().equals(cVar.f60261a.w1()))) {
            t(cVar.f60261a.q1().screen_direction);
        }
        this.f60289f = cVar;
        this.f60290g = cVar.f60261a.q1().screen_direction;
        this.f60286c.setData(this.f60289f.f60261a);
    }

    public void o() {
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f60286c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.b();
        }
        SkinManager.setBackgroundColor(this.f60287d, R.color.black_alpha100);
    }

    public void p() {
        q();
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f60286c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.c();
        }
    }

    public final void q() {
        d.b.i0.i2.f fVar = this.f60288e;
        if (fVar != null) {
            fVar.l(null);
            this.f60288e.n();
            this.f60288e = null;
        }
        TbCyberVideoView tbCyberVideoView = this.f60287d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
            this.f60287d.G();
            if (this.f60287d.getMediaProgressObserver() != null) {
                this.f60287d.getMediaProgressObserver().l(null);
                this.f60287d.getMediaProgressObserver().n();
            }
            this.f60287d = null;
        }
    }

    public void r() {
        s(true);
    }

    public void s(boolean z) {
        if (z) {
            q();
        }
        TbCyberVideoView tbCyberVideoView = this.f60287d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
        this.f60286c.f();
        this.f60286c.e();
    }

    public final void t(int i) {
        if (i == 1) {
            if (this.m) {
                if (this.f60285b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f60285b.getLayoutParams();
                    layoutParams.width = this.f60291h;
                    layoutParams.height = this.k;
                    this.f60285b.setLayoutParams(layoutParams);
                    return;
                }
                this.f60285b.setLayoutParams(new FrameLayout.LayoutParams(this.f60291h, this.k));
                return;
            } else if (this.f60285b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f60285b.getLayoutParams();
                int i2 = this.f60291h;
                layoutParams2.width = i2;
                layoutParams2.height = i2;
                this.f60285b.setLayoutParams(layoutParams2);
                return;
            } else {
                FrameLayout frameLayout = this.f60285b;
                int i3 = this.f60291h;
                frameLayout.setLayoutParams(new AbsListView.LayoutParams(i3, i3));
                return;
            }
        }
        this.f60290g = 2;
        if (this.m) {
            if (this.f60285b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f60285b.getLayoutParams();
                layoutParams3.width = this.f60291h;
                layoutParams3.height = this.j;
                this.f60285b.setLayoutParams(layoutParams3);
                return;
            }
            this.f60285b.setLayoutParams(new AbsListView.LayoutParams(this.f60291h, this.j));
        } else if (this.f60285b.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f60285b.getLayoutParams();
            layoutParams4.width = this.f60291h;
            layoutParams4.height = this.j;
            this.f60285b.setLayoutParams(layoutParams4);
        } else {
            this.f60285b.setLayoutParams(new AbsListView.LayoutParams(this.f60291h, this.j));
        }
    }

    public final void u(int i) {
        TbCyberVideoView tbCyberVideoView = this.f60287d;
        if (tbCyberVideoView == null) {
            return;
        }
        if (i == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f60287d.getLayoutParams();
                layoutParams.width = this.f60291h;
                layoutParams.height = this.i;
                layoutParams.topMargin = -this.o;
                this.f60287d.setLayoutParams(layoutParams);
                return;
            }
            this.f60287d.setLayoutParams(new FrameLayout.LayoutParams(this.f60291h, this.i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f60287d.getLayoutParams();
            layoutParams2.width = this.f60291h;
            layoutParams2.height = this.j;
            this.f60287d.setLayoutParams(layoutParams2);
        } else {
            this.f60287d.setLayoutParams(new FrameLayout.LayoutParams(this.f60291h, this.j));
        }
    }

    public final void v(int i, int i2) {
        TbCyberVideoView tbCyberVideoView;
        if (this.f60290g != 1 || (tbCyberVideoView = this.f60287d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i;
        float f3 = i2;
        float f4 = f2 / f3;
        int i3 = this.f60291h;
        float f5 = i3 * f2;
        int i4 = this.i;
        float f6 = f5 / i4;
        if (f6 < f3) {
            i3 = (int) (i4 / f4);
        } else if (f6 > f3) {
            i4 = (int) (i3 * f4);
        }
        if (this.f60287d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f60287d.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.f60287d.setLayoutParams(layoutParams);
            return;
        }
        this.f60287d.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
    }

    public void w(f fVar) {
        this.n = fVar;
    }

    public void x(String str) {
        d.b.i0.t.d.b.b.c cVar;
        a2 a2Var;
        TbCyberVideoView tbCyberVideoView;
        if (StringUtils.isNull(str) || (cVar = this.f60289f) == null || (a2Var = cVar.f60261a) == null || a2Var.q1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f60287d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f60287d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f60287d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        o oVar = new o();
        oVar.f56163a = HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9;
        oVar.f56166d = String.valueOf(this.f60289f.f60261a.c0());
        oVar.f56165c = this.f60289f.f60261a.w1();
        this.f60287d.setVideoStatData(oVar);
        TbCyberVideoView tbCyberVideoView3 = this.f60287d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f60289f.f60261a.q1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f60287d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        d.b.i0.i2.f fVar = this.f60288e;
        if (fVar != null) {
            fVar.m();
        }
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.m = z;
        this.f60286c.setFromSpecialForum(z);
    }
}
