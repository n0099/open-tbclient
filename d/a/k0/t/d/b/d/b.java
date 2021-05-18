package d.a.k0.t.d.b.d;

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
import d.a.j0.r.q.a2;
import d.a.k0.j2.f;
import d.a.k0.j2.o;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f61175a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f61176b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f61177c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f61178d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.j2.f f61179e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.t.d.b.b.c f61180f;

    /* renamed from: g  reason: collision with root package name */
    public int f61181g;

    /* renamed from: h  reason: collision with root package name */
    public int f61182h;

    /* renamed from: i  reason: collision with root package name */
    public int f61183i;
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

    /* renamed from: d.a.k0.t.d.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1622b implements CyberPlayerManager.OnErrorListener {
        public C1622b() {
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
            if (b.this.f61178d != null) {
                b.this.f61178d.setLooping(false);
                b.this.f61178d.setVolume(0.0f, 0.0f);
                if (b.this.f61180f != null && b.this.f61180f.f61151a != null) {
                    if (b.this.m) {
                        if (b.this.n != null) {
                            b.this.n.b(b.this.f61180f.f61151a);
                        }
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c12646");
                        if (b.this.f61180f.f61152b != 0) {
                            if (b.this.f61180f.f61152b == 1) {
                                statisticItem.param("obj_type", 2);
                            }
                        } else {
                            statisticItem.param("obj_type", 1);
                        }
                        statisticItem.param("tid", b.this.f61180f.f61151a.x1());
                        TiebaStatic.log(statisticItem);
                    }
                }
                if (b.this.f61178d.getCyberPlayer() != null) {
                    b bVar = b.this;
                    bVar.v(bVar.f61178d.getCyberPlayer().getVideoHeight(), b.this.f61178d.getCyberPlayer().getVideoWidth());
                }
                if (b.this.f61177c != null) {
                    b.this.f61177c.d();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.d {
        public d(b bVar) {
        }

        @Override // d.a.k0.j2.f.d
        public void a() {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f61180f == null || b.this.f61180f.f61151a == null) {
                return;
            }
            if (b.this.n != null) {
                b.this.n.a(b.this.f61180f.f61151a);
            }
            b bVar = b.this;
            bVar.l(bVar.f61175a, b.this.f61180f.f61151a);
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(a2 a2Var);

        void b(a2 a2Var);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f61175a = null;
        this.l = "";
        this.m = false;
        this.p = new a();
        this.q = new C1622b();
        this.r = new c();
        this.s = new e();
        this.f61175a = tbPageContext;
        k();
    }

    public final void i() {
        a2 a2Var;
        d.a.k0.t.d.b.b.c cVar = this.f61180f;
        if (cVar == null || (a2Var = cVar.f61151a) == null || a2Var.q1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f61178d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f61179e = new d.a.k0.j2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.f61175a.getPageActivity());
        this.f61178d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f61178d.setOnErrorListener(this.q);
        this.f61178d.setOnSurfaceDestroyedListener(this.p);
        this.f61178d.setVolume(0.0f, 0.0f);
        this.f61178d.setStageType(null);
        this.f61179e.l(this.f61178d);
        this.f61179e.k(new d(this));
        if (this.f61178d.getParent() == null) {
            this.f61176b.addView(this.f61178d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f61180f.f61151a.q1().screen_direction);
    }

    public View j() {
        return this.f61176b;
    }

    public final void k() {
        TbPageContext<?> tbPageContext = this.f61175a;
        if (tbPageContext == null) {
            return;
        }
        this.f61176b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f61182h = l.k(this.f61175a.getPageActivity());
        int i2 = l.i(this.f61175a.getPageActivity());
        this.f61183i = i2;
        int i3 = this.f61182h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f61177c = (AlaSquareLiveVideoMask) this.f61176b.findViewById(R.id.video_mask);
        this.f61176b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, a2 a2Var) {
        String str;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        d.a.k0.t.d.b.b.c cVar = this.f61180f;
        if (cVar != null && cVar.f61151a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f61180f.f61152b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f61180f.f61151a.x1());
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
        this.f61182h = l.k(this.f61175a.getPageActivity());
        int i2 = l.i(this.f61175a.getPageActivity());
        this.f61183i = i2;
        int i3 = this.f61182h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        if (this.f61180f != null) {
            TbCyberVideoView tbCyberVideoView = this.f61178d;
            boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
            t(this.f61180f.f61151a.q1().screen_direction);
            u(this.f61180f.f61151a.q1().screen_direction);
            r();
            if (isPlaying) {
                x(this.l);
            }
        }
    }

    public void n(d.a.k0.t.d.b.b.c cVar) {
        a2 a2Var;
        a2 a2Var2;
        if (cVar == null || (a2Var = cVar.f61151a) == null || a2Var.q1() == null) {
            return;
        }
        d.a.k0.t.d.b.b.c cVar2 = this.f61180f;
        if (cVar2 == null || ((a2Var2 = cVar2.f61151a) != null && !a2Var2.x1().equals(cVar.f61151a.x1()))) {
            t(cVar.f61151a.q1().screen_direction);
        }
        this.f61180f = cVar;
        this.f61181g = cVar.f61151a.q1().screen_direction;
        this.f61177c.setData(this.f61180f.f61151a);
    }

    public void o() {
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f61177c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.b();
        }
        SkinManager.setBackgroundColor(this.f61178d, R.color.black_alpha100);
    }

    public void p() {
        q();
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f61177c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.c();
        }
    }

    public final void q() {
        d.a.k0.j2.f fVar = this.f61179e;
        if (fVar != null) {
            fVar.l(null);
            this.f61179e.n();
            this.f61179e = null;
        }
        TbCyberVideoView tbCyberVideoView = this.f61178d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
            this.f61178d.G();
            if (this.f61178d.getMediaProgressObserver() != null) {
                this.f61178d.getMediaProgressObserver().l(null);
                this.f61178d.getMediaProgressObserver().n();
            }
            this.f61178d = null;
        }
    }

    public void r() {
        s(true);
    }

    public void s(boolean z) {
        if (z) {
            q();
        }
        TbCyberVideoView tbCyberVideoView = this.f61178d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
        this.f61177c.f();
        this.f61177c.e();
    }

    public final void t(int i2) {
        if (i2 == 1) {
            if (this.m) {
                if (this.f61176b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f61176b.getLayoutParams();
                    layoutParams.width = this.f61182h;
                    layoutParams.height = this.k;
                    this.f61176b.setLayoutParams(layoutParams);
                    return;
                }
                this.f61176b.setLayoutParams(new FrameLayout.LayoutParams(this.f61182h, this.k));
                return;
            } else if (this.f61176b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f61176b.getLayoutParams();
                int i3 = this.f61182h;
                layoutParams2.width = i3;
                layoutParams2.height = i3;
                this.f61176b.setLayoutParams(layoutParams2);
                return;
            } else {
                FrameLayout frameLayout = this.f61176b;
                int i4 = this.f61182h;
                frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                return;
            }
        }
        this.f61181g = 2;
        if (this.m) {
            if (this.f61176b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f61176b.getLayoutParams();
                layoutParams3.width = this.f61182h;
                layoutParams3.height = this.j;
                this.f61176b.setLayoutParams(layoutParams3);
                return;
            }
            this.f61176b.setLayoutParams(new AbsListView.LayoutParams(this.f61182h, this.j));
        } else if (this.f61176b.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f61176b.getLayoutParams();
            layoutParams4.width = this.f61182h;
            layoutParams4.height = this.j;
            this.f61176b.setLayoutParams(layoutParams4);
        } else {
            this.f61176b.setLayoutParams(new AbsListView.LayoutParams(this.f61182h, this.j));
        }
    }

    public final void u(int i2) {
        TbCyberVideoView tbCyberVideoView = this.f61178d;
        if (tbCyberVideoView == null) {
            return;
        }
        if (i2 == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f61178d.getLayoutParams();
                layoutParams.width = this.f61182h;
                layoutParams.height = this.f61183i;
                layoutParams.topMargin = -this.o;
                this.f61178d.setLayoutParams(layoutParams);
                return;
            }
            this.f61178d.setLayoutParams(new FrameLayout.LayoutParams(this.f61182h, this.f61183i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f61178d.getLayoutParams();
            layoutParams2.width = this.f61182h;
            layoutParams2.height = this.j;
            this.f61178d.setLayoutParams(layoutParams2);
        } else {
            this.f61178d.setLayoutParams(new FrameLayout.LayoutParams(this.f61182h, this.j));
        }
    }

    public final void v(int i2, int i3) {
        TbCyberVideoView tbCyberVideoView;
        if (this.f61181g != 1 || (tbCyberVideoView = this.f61178d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f61182h;
        float f5 = i4 * f2;
        int i5 = this.f61183i;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f61178d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f61178d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f61178d.setLayoutParams(layoutParams);
            return;
        }
        this.f61178d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(f fVar) {
        this.n = fVar;
    }

    public void x(String str) {
        d.a.k0.t.d.b.b.c cVar;
        a2 a2Var;
        TbCyberVideoView tbCyberVideoView;
        if (StringUtils.isNull(str) || (cVar = this.f61180f) == null || (a2Var = cVar.f61151a) == null || a2Var.q1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f61178d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f61178d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f61178d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        o oVar = new o();
        oVar.f56718a = HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9;
        oVar.f56721d = String.valueOf(this.f61180f.f61151a.c0());
        oVar.f56720c = this.f61180f.f61151a.x1();
        this.f61178d.setVideoStatData(oVar);
        TbCyberVideoView tbCyberVideoView3 = this.f61178d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f61180f.f61151a.q1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f61178d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        d.a.k0.j2.f fVar = this.f61179e;
        if (fVar != null) {
            fVar.m();
        }
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.m = z;
        this.f61177c.setFromSpecialForum(z);
    }
}
