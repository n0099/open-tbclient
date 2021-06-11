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
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.toplivecard.AlaSquareLiveVideoMask;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import d.a.n0.k2.f;
import d.a.n0.k2.o;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f65176a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f65177b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f65178c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f65179d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.k2.f f65180e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.v.d.b.b.c f65181f;

    /* renamed from: g  reason: collision with root package name */
    public int f65182g;

    /* renamed from: h  reason: collision with root package name */
    public int f65183h;

    /* renamed from: i  reason: collision with root package name */
    public int f65184i;
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
    public class C1699b implements CyberPlayerManager.OnErrorListener {
        public C1699b() {
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
            if (b.this.f65179d != null) {
                b.this.f65179d.setLooping(false);
                b.this.f65179d.setVolume(0.0f, 0.0f);
                if (b.this.f65181f != null && b.this.f65181f.f65152a != null) {
                    if (b.this.m) {
                        if (b.this.n != null) {
                            b.this.n.b(b.this.f65181f.f65152a);
                        }
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c12646");
                        if (b.this.f65181f.f65153b != 0) {
                            if (b.this.f65181f.f65153b == 1) {
                                statisticItem.param("obj_type", 2);
                            }
                        } else {
                            statisticItem.param("obj_type", 1);
                        }
                        statisticItem.param("tid", b.this.f65181f.f65152a.z1());
                        TiebaStatic.log(statisticItem);
                    }
                }
                if (b.this.f65179d.getCyberPlayer() != null) {
                    b bVar = b.this;
                    bVar.v(bVar.f65179d.getCyberPlayer().getVideoHeight(), b.this.f65179d.getCyberPlayer().getVideoWidth());
                }
                if (b.this.f65178c != null) {
                    b.this.f65178c.d();
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
            if (b.this.f65181f == null || b.this.f65181f.f65152a == null) {
                return;
            }
            if (b.this.n != null) {
                b.this.n.a(b.this.f65181f.f65152a);
            }
            if (b.this.f65181f.f65152a != null && b.this.f65181f.f65152a.s1() != null && b.this.f65181f.f65152a.s1().isLegalYYLiveData()) {
                AlaInfoData s1 = b.this.f65181f.f65152a.s1();
                TbPageContext tbPageContext = b.this.f65176a;
                YyExtData yyExtData = s1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + s1.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_TOP_PLAY);
                return;
            }
            b bVar = b.this;
            bVar.l(bVar.f65176a, b.this.f65181f.f65152a);
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(a2 a2Var);

        void b(a2 a2Var);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f65176a = null;
        this.l = "";
        this.m = false;
        this.p = new a();
        this.q = new C1699b();
        this.r = new c();
        this.s = new e();
        this.f65176a = tbPageContext;
        k();
    }

    public final void i() {
        a2 a2Var;
        d.a.n0.v.d.b.b.c cVar = this.f65181f;
        if (cVar == null || (a2Var = cVar.f65152a) == null || a2Var.s1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f65179d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f65180e = new d.a.n0.k2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.f65176a.getPageActivity());
        this.f65179d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f65179d.setOnErrorListener(this.q);
        this.f65179d.setOnSurfaceDestroyedListener(this.p);
        this.f65179d.setVolume(0.0f, 0.0f);
        this.f65179d.setStageType(null);
        this.f65180e.l(this.f65179d);
        this.f65180e.k(new d(this));
        if (this.f65179d.getParent() == null) {
            this.f65177b.addView(this.f65179d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f65181f.f65152a.s1().screen_direction);
    }

    public View j() {
        return this.f65177b;
    }

    public final void k() {
        TbPageContext<?> tbPageContext = this.f65176a;
        if (tbPageContext == null) {
            return;
        }
        this.f65177b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f65183h = l.k(this.f65176a.getPageActivity());
        int i2 = l.i(this.f65176a.getPageActivity());
        this.f65184i = i2;
        int i3 = this.f65183h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f65178c = (AlaSquareLiveVideoMask) this.f65177b.findViewById(R.id.video_mask);
        this.f65177b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, a2 a2Var) {
        String str;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.s1() == null) {
            return;
        }
        d.a.n0.v.d.b.b.c cVar = this.f65181f;
        if (cVar != null && cVar.f65152a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f65181f.f65153b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f65181f.f65152a.z1());
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
        alaLiveInfoCoreData.fillWithInfoData(a2Var.s1());
        alaLiveInfoCoreData.userName = a2Var.s1().user_info.user_name;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str2, str, z, "")));
    }

    public void m() {
        this.f65183h = l.k(this.f65176a.getPageActivity());
        int i2 = l.i(this.f65176a.getPageActivity());
        this.f65184i = i2;
        int i3 = this.f65183h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        if (this.f65181f != null) {
            TbCyberVideoView tbCyberVideoView = this.f65179d;
            boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
            t(this.f65181f.f65152a.s1().screen_direction);
            u(this.f65181f.f65152a.s1().screen_direction);
            r();
            if (isPlaying) {
                x(this.l);
            }
        }
    }

    public void n(d.a.n0.v.d.b.b.c cVar) {
        a2 a2Var;
        a2 a2Var2;
        if (cVar == null || (a2Var = cVar.f65152a) == null || a2Var.s1() == null) {
            return;
        }
        d.a.n0.v.d.b.b.c cVar2 = this.f65181f;
        if (cVar2 == null || ((a2Var2 = cVar2.f65152a) != null && !a2Var2.z1().equals(cVar.f65152a.z1()))) {
            t(cVar.f65152a.s1().screen_direction);
        }
        this.f65181f = cVar;
        this.f65182g = cVar.f65152a.s1().screen_direction;
        this.f65178c.setData(this.f65181f.f65152a);
    }

    public void o() {
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f65178c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.b();
        }
        SkinManager.setBackgroundColor(this.f65179d, R.color.black_alpha100);
    }

    public void p() {
        q();
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f65178c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.c();
        }
    }

    public final void q() {
        d.a.n0.k2.f fVar = this.f65180e;
        if (fVar != null) {
            fVar.l(null);
            this.f65180e.n();
            this.f65180e = null;
        }
        TbCyberVideoView tbCyberVideoView = this.f65179d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
            this.f65179d.G();
            if (this.f65179d.getMediaProgressObserver() != null) {
                this.f65179d.getMediaProgressObserver().l(null);
                this.f65179d.getMediaProgressObserver().n();
            }
            this.f65179d = null;
        }
    }

    public void r() {
        s(true);
    }

    public void s(boolean z) {
        if (z) {
            q();
        }
        TbCyberVideoView tbCyberVideoView = this.f65179d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
        this.f65178c.f();
        this.f65178c.e();
    }

    public final void t(int i2) {
        if (i2 == 1) {
            if (this.m) {
                if (this.f65177b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f65177b.getLayoutParams();
                    layoutParams.width = this.f65183h;
                    layoutParams.height = this.k;
                    this.f65177b.setLayoutParams(layoutParams);
                    return;
                }
                this.f65177b.setLayoutParams(new FrameLayout.LayoutParams(this.f65183h, this.k));
                return;
            } else if (this.f65177b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f65177b.getLayoutParams();
                int i3 = this.f65183h;
                layoutParams2.width = i3;
                layoutParams2.height = i3;
                this.f65177b.setLayoutParams(layoutParams2);
                return;
            } else {
                FrameLayout frameLayout = this.f65177b;
                int i4 = this.f65183h;
                frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                return;
            }
        }
        this.f65182g = 2;
        if (this.m) {
            if (this.f65177b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f65177b.getLayoutParams();
                layoutParams3.width = this.f65183h;
                layoutParams3.height = this.j;
                this.f65177b.setLayoutParams(layoutParams3);
                return;
            }
            this.f65177b.setLayoutParams(new AbsListView.LayoutParams(this.f65183h, this.j));
        } else if (this.f65177b.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f65177b.getLayoutParams();
            layoutParams4.width = this.f65183h;
            layoutParams4.height = this.j;
            this.f65177b.setLayoutParams(layoutParams4);
        } else {
            this.f65177b.setLayoutParams(new AbsListView.LayoutParams(this.f65183h, this.j));
        }
    }

    public final void u(int i2) {
        TbCyberVideoView tbCyberVideoView = this.f65179d;
        if (tbCyberVideoView == null) {
            return;
        }
        if (i2 == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f65179d.getLayoutParams();
                layoutParams.width = this.f65183h;
                layoutParams.height = this.f65184i;
                layoutParams.topMargin = -this.o;
                this.f65179d.setLayoutParams(layoutParams);
                return;
            }
            this.f65179d.setLayoutParams(new FrameLayout.LayoutParams(this.f65183h, this.f65184i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f65179d.getLayoutParams();
            layoutParams2.width = this.f65183h;
            layoutParams2.height = this.j;
            this.f65179d.setLayoutParams(layoutParams2);
        } else {
            this.f65179d.setLayoutParams(new FrameLayout.LayoutParams(this.f65183h, this.j));
        }
    }

    public final void v(int i2, int i3) {
        TbCyberVideoView tbCyberVideoView;
        if (this.f65182g != 1 || (tbCyberVideoView = this.f65179d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f65183h;
        float f5 = i4 * f2;
        int i5 = this.f65184i;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f65179d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f65179d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f65179d.setLayoutParams(layoutParams);
            return;
        }
        this.f65179d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(f fVar) {
        this.n = fVar;
    }

    public void x(String str) {
        d.a.n0.v.d.b.b.c cVar;
        a2 a2Var;
        TbCyberVideoView tbCyberVideoView;
        if (StringUtils.isNull(str) || (cVar = this.f65181f) == null || (a2Var = cVar.f65152a) == null || a2Var.s1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f65179d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f65179d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f65179d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        o oVar = new o();
        oVar.f60587a = "9";
        oVar.f60590d = String.valueOf(this.f65181f.f65152a.c0());
        oVar.f60589c = this.f65181f.f65152a.z1();
        this.f65179d.setVideoStatData(oVar);
        TbCyberVideoView tbCyberVideoView3 = this.f65179d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f65181f.f65152a.s1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f65179d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        d.a.n0.k2.f fVar = this.f65180e;
        if (fVar != null) {
            fVar.m();
        }
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.m = z;
        this.f65178c.setFromSpecialForum(z);
    }
}
