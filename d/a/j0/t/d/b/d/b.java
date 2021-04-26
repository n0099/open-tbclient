package d.a.j0.t.d.b.d;

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
import d.a.i0.r.q.a2;
import d.a.j0.j2.f;
import d.a.j0.j2.o;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60451a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f60452b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f60453c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f60454d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.j2.f f60455e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.t.d.b.b.c f60456f;

    /* renamed from: g  reason: collision with root package name */
    public int f60457g;

    /* renamed from: h  reason: collision with root package name */
    public int f60458h;

    /* renamed from: i  reason: collision with root package name */
    public int f60459i;
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

    /* renamed from: d.a.j0.t.d.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1557b implements CyberPlayerManager.OnErrorListener {
        public C1557b() {
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
            if (b.this.f60454d != null) {
                b.this.f60454d.setLooping(false);
                b.this.f60454d.setVolume(0.0f, 0.0f);
                if (b.this.f60456f != null && b.this.f60456f.f60427a != null) {
                    if (b.this.m) {
                        if (b.this.n != null) {
                            b.this.n.b(b.this.f60456f.f60427a);
                        }
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c12646");
                        if (b.this.f60456f.f60428b != 0) {
                            if (b.this.f60456f.f60428b == 1) {
                                statisticItem.param("obj_type", 2);
                            }
                        } else {
                            statisticItem.param("obj_type", 1);
                        }
                        statisticItem.param("tid", b.this.f60456f.f60427a.w1());
                        TiebaStatic.log(statisticItem);
                    }
                }
                if (b.this.f60454d.getCyberPlayer() != null) {
                    b bVar = b.this;
                    bVar.v(bVar.f60454d.getCyberPlayer().getVideoHeight(), b.this.f60454d.getCyberPlayer().getVideoWidth());
                }
                if (b.this.f60453c != null) {
                    b.this.f60453c.d();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.d {
        public d(b bVar) {
        }

        @Override // d.a.j0.j2.f.d
        public void a() {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f60456f == null || b.this.f60456f.f60427a == null) {
                return;
            }
            if (b.this.n != null) {
                b.this.n.a(b.this.f60456f.f60427a);
            }
            b bVar = b.this;
            bVar.l(bVar.f60451a, b.this.f60456f.f60427a);
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(a2 a2Var);

        void b(a2 a2Var);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f60451a = null;
        this.l = "";
        this.m = false;
        this.p = new a();
        this.q = new C1557b();
        this.r = new c();
        this.s = new e();
        this.f60451a = tbPageContext;
        k();
    }

    public final void i() {
        a2 a2Var;
        d.a.j0.t.d.b.b.c cVar = this.f60456f;
        if (cVar == null || (a2Var = cVar.f60427a) == null || a2Var.q1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f60454d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f60455e = new d.a.j0.j2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.f60451a.getPageActivity());
        this.f60454d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f60454d.setOnErrorListener(this.q);
        this.f60454d.setOnSurfaceDestroyedListener(this.p);
        this.f60454d.setVolume(0.0f, 0.0f);
        this.f60454d.setStageType(null);
        this.f60455e.l(this.f60454d);
        this.f60455e.k(new d(this));
        if (this.f60454d.getParent() == null) {
            this.f60452b.addView(this.f60454d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f60456f.f60427a.q1().screen_direction);
    }

    public View j() {
        return this.f60452b;
    }

    public final void k() {
        TbPageContext<?> tbPageContext = this.f60451a;
        if (tbPageContext == null) {
            return;
        }
        this.f60452b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f60458h = l.k(this.f60451a.getPageActivity());
        int i2 = l.i(this.f60451a.getPageActivity());
        this.f60459i = i2;
        int i3 = this.f60458h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f60453c = (AlaSquareLiveVideoMask) this.f60452b.findViewById(R.id.video_mask);
        this.f60452b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, a2 a2Var) {
        String str;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        d.a.j0.t.d.b.b.c cVar = this.f60456f;
        if (cVar != null && cVar.f60427a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f60456f.f60428b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f60456f.f60427a.w1());
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
        this.f60458h = l.k(this.f60451a.getPageActivity());
        int i2 = l.i(this.f60451a.getPageActivity());
        this.f60459i = i2;
        int i3 = this.f60458h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        if (this.f60456f != null) {
            TbCyberVideoView tbCyberVideoView = this.f60454d;
            boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
            t(this.f60456f.f60427a.q1().screen_direction);
            u(this.f60456f.f60427a.q1().screen_direction);
            r();
            if (isPlaying) {
                x(this.l);
            }
        }
    }

    public void n(d.a.j0.t.d.b.b.c cVar) {
        a2 a2Var;
        a2 a2Var2;
        if (cVar == null || (a2Var = cVar.f60427a) == null || a2Var.q1() == null) {
            return;
        }
        d.a.j0.t.d.b.b.c cVar2 = this.f60456f;
        if (cVar2 == null || ((a2Var2 = cVar2.f60427a) != null && !a2Var2.w1().equals(cVar.f60427a.w1()))) {
            t(cVar.f60427a.q1().screen_direction);
        }
        this.f60456f = cVar;
        this.f60457g = cVar.f60427a.q1().screen_direction;
        this.f60453c.setData(this.f60456f.f60427a);
    }

    public void o() {
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f60453c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.b();
        }
        SkinManager.setBackgroundColor(this.f60454d, R.color.black_alpha100);
    }

    public void p() {
        q();
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f60453c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.c();
        }
    }

    public final void q() {
        d.a.j0.j2.f fVar = this.f60455e;
        if (fVar != null) {
            fVar.l(null);
            this.f60455e.n();
            this.f60455e = null;
        }
        TbCyberVideoView tbCyberVideoView = this.f60454d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
            this.f60454d.G();
            if (this.f60454d.getMediaProgressObserver() != null) {
                this.f60454d.getMediaProgressObserver().l(null);
                this.f60454d.getMediaProgressObserver().n();
            }
            this.f60454d = null;
        }
    }

    public void r() {
        s(true);
    }

    public void s(boolean z) {
        if (z) {
            q();
        }
        TbCyberVideoView tbCyberVideoView = this.f60454d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
        this.f60453c.f();
        this.f60453c.e();
    }

    public final void t(int i2) {
        if (i2 == 1) {
            if (this.m) {
                if (this.f60452b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f60452b.getLayoutParams();
                    layoutParams.width = this.f60458h;
                    layoutParams.height = this.k;
                    this.f60452b.setLayoutParams(layoutParams);
                    return;
                }
                this.f60452b.setLayoutParams(new FrameLayout.LayoutParams(this.f60458h, this.k));
                return;
            } else if (this.f60452b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f60452b.getLayoutParams();
                int i3 = this.f60458h;
                layoutParams2.width = i3;
                layoutParams2.height = i3;
                this.f60452b.setLayoutParams(layoutParams2);
                return;
            } else {
                FrameLayout frameLayout = this.f60452b;
                int i4 = this.f60458h;
                frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                return;
            }
        }
        this.f60457g = 2;
        if (this.m) {
            if (this.f60452b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f60452b.getLayoutParams();
                layoutParams3.width = this.f60458h;
                layoutParams3.height = this.j;
                this.f60452b.setLayoutParams(layoutParams3);
                return;
            }
            this.f60452b.setLayoutParams(new AbsListView.LayoutParams(this.f60458h, this.j));
        } else if (this.f60452b.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f60452b.getLayoutParams();
            layoutParams4.width = this.f60458h;
            layoutParams4.height = this.j;
            this.f60452b.setLayoutParams(layoutParams4);
        } else {
            this.f60452b.setLayoutParams(new AbsListView.LayoutParams(this.f60458h, this.j));
        }
    }

    public final void u(int i2) {
        TbCyberVideoView tbCyberVideoView = this.f60454d;
        if (tbCyberVideoView == null) {
            return;
        }
        if (i2 == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f60454d.getLayoutParams();
                layoutParams.width = this.f60458h;
                layoutParams.height = this.f60459i;
                layoutParams.topMargin = -this.o;
                this.f60454d.setLayoutParams(layoutParams);
                return;
            }
            this.f60454d.setLayoutParams(new FrameLayout.LayoutParams(this.f60458h, this.f60459i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f60454d.getLayoutParams();
            layoutParams2.width = this.f60458h;
            layoutParams2.height = this.j;
            this.f60454d.setLayoutParams(layoutParams2);
        } else {
            this.f60454d.setLayoutParams(new FrameLayout.LayoutParams(this.f60458h, this.j));
        }
    }

    public final void v(int i2, int i3) {
        TbCyberVideoView tbCyberVideoView;
        if (this.f60457g != 1 || (tbCyberVideoView = this.f60454d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f60458h;
        float f5 = i4 * f2;
        int i5 = this.f60459i;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f60454d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f60454d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f60454d.setLayoutParams(layoutParams);
            return;
        }
        this.f60454d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(f fVar) {
        this.n = fVar;
    }

    public void x(String str) {
        d.a.j0.t.d.b.b.c cVar;
        a2 a2Var;
        TbCyberVideoView tbCyberVideoView;
        if (StringUtils.isNull(str) || (cVar = this.f60456f) == null || (a2Var = cVar.f60427a) == null || a2Var.q1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f60454d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f60454d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f60454d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        o oVar = new o();
        oVar.f56011a = HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9;
        oVar.f56014d = String.valueOf(this.f60456f.f60427a.c0());
        oVar.f56013c = this.f60456f.f60427a.w1();
        this.f60454d.setVideoStatData(oVar);
        TbCyberVideoView tbCyberVideoView3 = this.f60454d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f60456f.f60427a.q1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f60454d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        d.a.j0.j2.f fVar = this.f60455e;
        if (fVar != null) {
            fVar.m();
        }
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.m = z;
        this.f60453c.setFromSpecialForum(z);
    }
}
