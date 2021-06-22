package d.a.o0.v.d.b.d;

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
import d.a.n0.r.q.a2;
import d.a.o0.k2.f;
import d.a.o0.k2.o;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f65301a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f65302b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f65303c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f65304d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.k2.f f65305e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.v.d.b.b.c f65306f;

    /* renamed from: g  reason: collision with root package name */
    public int f65307g;

    /* renamed from: h  reason: collision with root package name */
    public int f65308h;

    /* renamed from: i  reason: collision with root package name */
    public int f65309i;
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

    /* renamed from: d.a.o0.v.d.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1703b implements CyberPlayerManager.OnErrorListener {
        public C1703b() {
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
            if (b.this.f65304d != null) {
                b.this.f65304d.setLooping(false);
                b.this.f65304d.setVolume(0.0f, 0.0f);
                if (b.this.f65306f != null && b.this.f65306f.f65277a != null) {
                    if (b.this.m) {
                        if (b.this.n != null) {
                            b.this.n.b(b.this.f65306f.f65277a);
                        }
                    } else {
                        StatisticItem statisticItem = new StatisticItem("c12646");
                        if (b.this.f65306f.f65278b != 0) {
                            if (b.this.f65306f.f65278b == 1) {
                                statisticItem.param("obj_type", 2);
                            }
                        } else {
                            statisticItem.param("obj_type", 1);
                        }
                        statisticItem.param("tid", b.this.f65306f.f65277a.z1());
                        TiebaStatic.log(statisticItem);
                    }
                }
                if (b.this.f65304d.getCyberPlayer() != null) {
                    b bVar = b.this;
                    bVar.v(bVar.f65304d.getCyberPlayer().getVideoHeight(), b.this.f65304d.getCyberPlayer().getVideoWidth());
                }
                if (b.this.f65303c != null) {
                    b.this.f65303c.d();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.d {
        public d(b bVar) {
        }

        @Override // d.a.o0.k2.f.d
        public void a() {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f65306f == null || b.this.f65306f.f65277a == null) {
                return;
            }
            if (b.this.n != null) {
                b.this.n.a(b.this.f65306f.f65277a);
            }
            if (b.this.f65306f.f65277a != null && b.this.f65306f.f65277a.s1() != null && b.this.f65306f.f65277a.s1().isLegalYYLiveData()) {
                AlaInfoData s1 = b.this.f65306f.f65277a.s1();
                TbPageContext tbPageContext = b.this.f65301a;
                YyExtData yyExtData = s1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + s1.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_TOP_PLAY);
                return;
            }
            b bVar = b.this;
            bVar.l(bVar.f65301a, b.this.f65306f.f65277a);
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(a2 a2Var);

        void b(a2 a2Var);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f65301a = null;
        this.l = "";
        this.m = false;
        this.p = new a();
        this.q = new C1703b();
        this.r = new c();
        this.s = new e();
        this.f65301a = tbPageContext;
        k();
    }

    public final void i() {
        a2 a2Var;
        d.a.o0.v.d.b.b.c cVar = this.f65306f;
        if (cVar == null || (a2Var = cVar.f65277a) == null || a2Var.s1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f65304d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f65305e = new d.a.o0.k2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.f65301a.getPageActivity());
        this.f65304d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f65304d.setOnErrorListener(this.q);
        this.f65304d.setOnSurfaceDestroyedListener(this.p);
        this.f65304d.setVolume(0.0f, 0.0f);
        this.f65304d.setStageType(null);
        this.f65305e.l(this.f65304d);
        this.f65305e.k(new d(this));
        if (this.f65304d.getParent() == null) {
            this.f65302b.addView(this.f65304d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f65306f.f65277a.s1().screen_direction);
    }

    public View j() {
        return this.f65302b;
    }

    public final void k() {
        TbPageContext<?> tbPageContext = this.f65301a;
        if (tbPageContext == null) {
            return;
        }
        this.f65302b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f65308h = l.k(this.f65301a.getPageActivity());
        int i2 = l.i(this.f65301a.getPageActivity());
        this.f65309i = i2;
        int i3 = this.f65308h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f65303c = (AlaSquareLiveVideoMask) this.f65302b.findViewById(R.id.video_mask);
        this.f65302b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, a2 a2Var) {
        String str;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.s1() == null) {
            return;
        }
        d.a.o0.v.d.b.b.c cVar = this.f65306f;
        if (cVar != null && cVar.f65277a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f65306f.f65278b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f65306f.f65277a.z1());
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
        this.f65308h = l.k(this.f65301a.getPageActivity());
        int i2 = l.i(this.f65301a.getPageActivity());
        this.f65309i = i2;
        int i3 = this.f65308h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        if (this.f65306f != null) {
            TbCyberVideoView tbCyberVideoView = this.f65304d;
            boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
            t(this.f65306f.f65277a.s1().screen_direction);
            u(this.f65306f.f65277a.s1().screen_direction);
            r();
            if (isPlaying) {
                x(this.l);
            }
        }
    }

    public void n(d.a.o0.v.d.b.b.c cVar) {
        a2 a2Var;
        a2 a2Var2;
        if (cVar == null || (a2Var = cVar.f65277a) == null || a2Var.s1() == null) {
            return;
        }
        d.a.o0.v.d.b.b.c cVar2 = this.f65306f;
        if (cVar2 == null || ((a2Var2 = cVar2.f65277a) != null && !a2Var2.z1().equals(cVar.f65277a.z1()))) {
            t(cVar.f65277a.s1().screen_direction);
        }
        this.f65306f = cVar;
        this.f65307g = cVar.f65277a.s1().screen_direction;
        this.f65303c.setData(this.f65306f.f65277a);
    }

    public void o() {
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f65303c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.b();
        }
        SkinManager.setBackgroundColor(this.f65304d, R.color.black_alpha100);
    }

    public void p() {
        q();
        AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f65303c;
        if (alaSquareLiveVideoMask != null) {
            alaSquareLiveVideoMask.c();
        }
    }

    public final void q() {
        d.a.o0.k2.f fVar = this.f65305e;
        if (fVar != null) {
            fVar.l(null);
            this.f65305e.n();
            this.f65305e = null;
        }
        TbCyberVideoView tbCyberVideoView = this.f65304d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
            this.f65304d.G();
            if (this.f65304d.getMediaProgressObserver() != null) {
                this.f65304d.getMediaProgressObserver().l(null);
                this.f65304d.getMediaProgressObserver().n();
            }
            this.f65304d = null;
        }
    }

    public void r() {
        s(true);
    }

    public void s(boolean z) {
        if (z) {
            q();
        }
        TbCyberVideoView tbCyberVideoView = this.f65304d;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
        this.f65303c.f();
        this.f65303c.e();
    }

    public final void t(int i2) {
        if (i2 == 1) {
            if (this.m) {
                if (this.f65302b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f65302b.getLayoutParams();
                    layoutParams.width = this.f65308h;
                    layoutParams.height = this.k;
                    this.f65302b.setLayoutParams(layoutParams);
                    return;
                }
                this.f65302b.setLayoutParams(new FrameLayout.LayoutParams(this.f65308h, this.k));
                return;
            } else if (this.f65302b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f65302b.getLayoutParams();
                int i3 = this.f65308h;
                layoutParams2.width = i3;
                layoutParams2.height = i3;
                this.f65302b.setLayoutParams(layoutParams2);
                return;
            } else {
                FrameLayout frameLayout = this.f65302b;
                int i4 = this.f65308h;
                frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                return;
            }
        }
        this.f65307g = 2;
        if (this.m) {
            if (this.f65302b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f65302b.getLayoutParams();
                layoutParams3.width = this.f65308h;
                layoutParams3.height = this.j;
                this.f65302b.setLayoutParams(layoutParams3);
                return;
            }
            this.f65302b.setLayoutParams(new AbsListView.LayoutParams(this.f65308h, this.j));
        } else if (this.f65302b.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f65302b.getLayoutParams();
            layoutParams4.width = this.f65308h;
            layoutParams4.height = this.j;
            this.f65302b.setLayoutParams(layoutParams4);
        } else {
            this.f65302b.setLayoutParams(new AbsListView.LayoutParams(this.f65308h, this.j));
        }
    }

    public final void u(int i2) {
        TbCyberVideoView tbCyberVideoView = this.f65304d;
        if (tbCyberVideoView == null) {
            return;
        }
        if (i2 == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f65304d.getLayoutParams();
                layoutParams.width = this.f65308h;
                layoutParams.height = this.f65309i;
                layoutParams.topMargin = -this.o;
                this.f65304d.setLayoutParams(layoutParams);
                return;
            }
            this.f65304d.setLayoutParams(new FrameLayout.LayoutParams(this.f65308h, this.f65309i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f65304d.getLayoutParams();
            layoutParams2.width = this.f65308h;
            layoutParams2.height = this.j;
            this.f65304d.setLayoutParams(layoutParams2);
        } else {
            this.f65304d.setLayoutParams(new FrameLayout.LayoutParams(this.f65308h, this.j));
        }
    }

    public final void v(int i2, int i3) {
        TbCyberVideoView tbCyberVideoView;
        if (this.f65307g != 1 || (tbCyberVideoView = this.f65304d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f65308h;
        float f5 = i4 * f2;
        int i5 = this.f65309i;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f65304d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f65304d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f65304d.setLayoutParams(layoutParams);
            return;
        }
        this.f65304d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(f fVar) {
        this.n = fVar;
    }

    public void x(String str) {
        d.a.o0.v.d.b.b.c cVar;
        a2 a2Var;
        TbCyberVideoView tbCyberVideoView;
        if (StringUtils.isNull(str) || (cVar = this.f65306f) == null || (a2Var = cVar.f65277a) == null || a2Var.s1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f65304d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f65304d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f65304d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        o oVar = new o();
        oVar.f60712a = "9";
        oVar.f60715d = String.valueOf(this.f65306f.f65277a.c0());
        oVar.f60714c = this.f65306f.f65277a.z1();
        this.f65304d.setVideoStatData(oVar);
        TbCyberVideoView tbCyberVideoView3 = this.f65304d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f65306f.f65277a.s1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f65304d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        d.a.o0.k2.f fVar = this.f65305e;
        if (fVar != null) {
            fVar.m();
        }
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.m = z;
        this.f65303c.setFromSpecialForum(z);
    }
}
