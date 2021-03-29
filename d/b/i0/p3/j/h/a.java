package d.b.i0.p3.j.h;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import d.b.b.e.p.k;
import d.b.h0.r.s.j;
import d.b.h0.r.s.l;
import d.b.i0.s1.g;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends d.b.b.a.d {

    /* renamed from: a  reason: collision with root package name */
    public View f59024a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f59025b;

    /* renamed from: c  reason: collision with root package name */
    public MaskVideoView f59026c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.p3.j.a f59027d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f59028e;

    /* renamed from: f  reason: collision with root package name */
    public j f59029f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.p3.j.h.c f59030g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.p3.j.h.e f59031h;
    public d.b.i0.p3.j.h.d i;
    public FrameLayout j;
    public FragmentTabWidget k;
    public int l;
    public MediaPlayer m;
    public boolean n;
    public g o;
    public l.e p;

    /* renamed from: d.b.i0.p3.j.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1463a implements FragmentTabWidget.b {
        public C1463a() {
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i, boolean z) {
            a aVar = a.this;
            if (i == aVar.l) {
                return;
            }
            if (i == 0) {
                aVar.f59030g.k().setVisibility(0);
                a.this.f59031h.x().setVisibility(8);
                a.this.i.h().setVisibility(8);
                a.this.f59030g.u(true);
                a.this.f59031h.G(false);
                a.this.i.n(false);
            } else if (i == 1) {
                aVar.i.h().setVisibility(0);
                a.this.f59031h.x().setVisibility(8);
                a.this.f59030g.k().setVisibility(8);
                a.this.f59030g.u(false);
                if (TextUtils.isEmpty(a.this.f59031h.w())) {
                    a.this.f59031h.G(false);
                } else {
                    a.this.f59031h.G(true);
                }
                a.this.i.n(true);
            } else if (i == 2) {
                aVar.f59031h.x().setVisibility(0);
                a.this.f59030g.k().setVisibility(8);
                a.this.i.h().setVisibility(8);
                a.this.f59030g.u(false);
                a.this.f59031h.G(true);
                a.this.i.n(false);
            }
            a aVar2 = a.this;
            aVar2.l = i;
            aVar2.k.setCurrentTab(a.this.l, true, true);
            a.this.i0();
            a.this.J();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements MediaPlayer.OnPreparedListener {

        /* renamed from: d.b.i0.p3.j.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1464a implements Runnable {
            public RunnableC1464a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f59030g.w();
            }
        }

        /* renamed from: d.b.i0.p3.j.h.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1465b implements MediaPlayer.OnInfoListener {
            public C1465b() {
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (i == 3) {
                    a aVar = a.this;
                    if (aVar.l == 0) {
                        aVar.f59026c.pause();
                        return true;
                    }
                    return true;
                }
                return true;
            }
        }

        public b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
        @Override // android.media.MediaPlayer.OnPreparedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.m = mediaPlayer;
            if (!a.this.n) {
                a aVar = a.this;
                if (aVar.l != 0) {
                    aVar.m.setVolume(1.0f, 1.0f);
                    d.b.b.e.m.e.a().postDelayed(new RunnableC1464a(), 200L);
                    if (Build.VERSION.SDK_INT < 17) {
                        a.this.f59026c.start();
                        mediaPlayer.setOnInfoListener(new C1465b());
                        return;
                    }
                    a.this.f59026c.seekTo(a.this.f59030g.getCurrentPosition());
                    return;
                }
            }
            a.this.m.setVolume(0.0f, 0.0f);
            d.b.b.e.m.e.a().postDelayed(new RunnableC1464a(), 200L);
            if (Build.VERSION.SDK_INT < 17) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            a aVar = a.this;
            if (aVar.l != 0) {
                aVar.S();
                a.this.f59031h.M();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.h0();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f59030g.m();
            if (a.this.f59027d != null) {
                a.this.f59027d.onNext();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements l.e {
        public f() {
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(l lVar, int i, View view) {
            if (i != 0) {
                if (i == 1 && a.this.f59027d != null) {
                    a.this.f59027d.finishPage();
                }
            } else if (a.this.f59027d != null) {
                a.this.f59027d.onSave();
            }
            if (a.this.f59029f == null || !a.this.f59029f.isShowing() || a.this.getPageContext() == null) {
                return;
            }
            a.this.f59029f.dismiss();
        }
    }

    public a(d.b.b.a.f fVar, d.b.i0.p3.j.a aVar, View view, g gVar) {
        super(fVar);
        this.l = 0;
        this.p = new f();
        this.f59027d = aVar;
        this.f59024a = view;
        this.o = gVar;
        this.f59028e = view.getResources();
        this.f59030g = new d.b.i0.p3.j.h.c(this.mContext, this);
        this.f59031h = new d.b.i0.p3.j.h.e(this.mContext, this, this.o);
        this.i = new d.b.i0.p3.j.h.d(this.mContext, this);
        this.f59030g.n(this.f59024a);
        this.f59031h.y(this.f59024a);
        this.i.i(this.f59024a);
        E();
        i0();
    }

    public final void A() {
        this.f59025b.setCenterTextTitle(this.f59028e.getString(R.string.select_cover));
        this.f59025b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d());
        SkinManager.setViewTextColor(this.f59025b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f59028e.getString(R.string.select_cover_next), new e()), R.color.CAM_X0106);
    }

    public final void B() {
        String[] stringArray = this.f59028e.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.f59028e.getDimension(R.dimen.fontsize34));
            this.k.addView(fragmentTabIndicator, i);
        }
        if (!F() && this.k.getChildAt(1) != null) {
            this.k.getChildAt(1).setVisibility(8);
        }
        this.k.setDiverColor(this.f59028e.getColor(R.color.CAM_X0105));
        this.k.setCurrentTab(this.l, true, false);
        this.k.setBackGroundDrawableResId(R.color.CAM_X0201);
        this.k.setDviderRectWidth(d.b.b.e.p.l.g(this.mContext.getPageActivity(), R.dimen.ds64));
        this.k.setTabSelectionListener(new C1463a());
    }

    public final void E() {
        this.f59025b = (NavigationBar) this.f59024a.findViewById(R.id.navigation_bar);
        MaskVideoView maskVideoView = (MaskVideoView) this.f59024a.findViewById(R.id.video_view);
        this.f59026c = maskVideoView;
        maskVideoView.setPreserveEGLContextOnPause(true);
        this.f59026c.setZOrderMediaOverlay(true);
        this.f59026c.setPostMonitorManager(this.o);
        FrameLayout frameLayout = (FrameLayout) this.f59024a.findViewById(R.id.edit_container);
        this.j = frameLayout;
        frameLayout.addView(this.f59030g.k());
        this.k = (FragmentTabWidget) this.f59024a.findViewById(R.id.tab_widget);
        A();
        B();
        this.j.addView(this.f59031h.x());
        this.j.addView(this.i.h());
        this.f59031h.x().setVisibility(8);
        this.i.h().setVisibility(8);
    }

    public final boolean F() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public boolean G() {
        return this.n;
    }

    public void I() {
        MaskVideoView maskVideoView = this.f59026c;
        if (maskVideoView != null) {
            maskVideoView.n(this.f59030g.getCurrentPosition());
        }
    }

    public final void J() {
        if (this.l == 0) {
            P();
            T();
            return;
        }
        S();
    }

    public void K(d.b.b.a.f fVar, int i) {
        this.f59025b.onChangeSkinType(fVar, i);
        this.k.g(i);
        this.k.setDiverColor(SkinManager.getColor(i, R.color.CAM_X0105));
        SkinManager.setBackgroundColor(this.f59024a, R.color.CAM_X0201);
        d.b.i0.p3.j.h.c cVar = this.f59030g;
        if (cVar != null) {
            cVar.q(fVar, i);
        }
        d.b.i0.p3.j.h.e eVar = this.f59031h;
        if (eVar != null) {
            eVar.A(fVar, i);
        }
    }

    public void L(String str, String str2) {
        this.f59031h.B(str, str2);
    }

    public void M() {
        P();
        this.f59030g.r();
        this.f59031h.E();
        this.i.l();
    }

    public void O() {
        this.f59026c.onResume();
        if (this.l != 0) {
            this.f59026c.s();
        }
        this.f59030g.s();
        this.f59031h.F();
        this.i.m();
    }

    public void P() {
        MaskVideoView maskVideoView = this.f59026c;
        if (maskVideoView != null) {
            maskVideoView.q();
        }
    }

    public void Q() {
        MaskVideoView maskVideoView = this.f59026c;
        if (maskVideoView != null) {
            maskVideoView.onPause();
        }
    }

    public void R() {
        d.b.i0.p3.j.h.c cVar = this.f59030g;
        if (cVar != null) {
            cVar.v();
        }
        MaskVideoView maskVideoView = this.f59026c;
        if (maskVideoView != null) {
            maskVideoView.t();
        }
    }

    public void S() {
        P();
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer != null) {
            if (this.n) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.f59026c.start();
        this.f59026c.seekTo(0);
    }

    public void T() {
        MaskVideoView maskVideoView = this.f59026c;
        if (maskVideoView != null) {
            maskVideoView.seekTo(this.f59030g.getCurrentPosition());
        }
    }

    public void U(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f59030g.x(str);
            this.f59026c.setVideoPath(str);
            this.f59026c.setOnPreparedListener(new b());
            this.f59026c.setOnCompletionListener(new c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void V(d.b.i0.p3.j.d.a aVar) {
        d.b.i0.p3.j.h.d dVar = this.i;
        if (dVar != null) {
            dVar.q(aVar);
        }
    }

    public void W(MaskVideoView.f fVar) {
        if (fVar == null || z() == null) {
            return;
        }
        z().setGenMaskCoverListener(fVar);
    }

    public void X(List<MusicData> list) {
        this.f59031h.P(list);
    }

    public void Y(boolean z) {
        this.n = z;
        if (this.m == null) {
            return;
        }
        S();
    }

    public void b0(List<PendantData> list) {
        this.f59030g.y(list);
    }

    public void c0(Intent intent) {
        this.f59031h.R(intent);
    }

    public void d0(String str, String str2) {
        d.b.i0.p3.j.h.e eVar = this.f59031h;
        if (eVar != null) {
            eVar.S(str, str2);
        }
    }

    public void f0(d.b.i0.p3.j.e.a aVar) {
        MaskVideoView maskVideoView = this.f59026c;
        if (maskVideoView != null) {
            maskVideoView.setFilter(aVar);
        }
        d.b.i0.p3.j.h.d dVar = this.i;
        if (dVar != null) {
            dVar.o(aVar);
        }
    }

    public void g0(boolean z) {
        d.b.i0.p3.j.h.e eVar = this.f59031h;
        if (eVar != null) {
            eVar.Q(z);
            Y(!z);
        }
    }

    public int getCurrentPosition() {
        MaskVideoView maskVideoView = this.f59026c;
        if (maskVideoView == null) {
            return 0;
        }
        return maskVideoView.getCurrentPosition();
    }

    public void h0() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && StringHelper.equals(((EditVideoActivity) this.mContext.getPageActivity()).getFromType(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.f59027d.finishPage();
            return;
        }
        if (this.f59029f == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            j jVar = new j(getPageContext());
            this.f59029f = jVar;
            jVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.f59029f.i(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.p);
        }
        this.f59029f.l();
    }

    public final void i0() {
        StatisticItem statisticItem = new StatisticItem("c12424");
        statisticItem.param("obj_locate", this.l == 0 ? 1 : 3);
        TiebaStatic.log(statisticItem);
    }

    public Bitmap r(Bitmap bitmap) {
        return this.f59030g.h(bitmap);
    }

    public void s() {
        d.b.i0.p3.j.a aVar = this.f59027d;
        if (aVar != null) {
            aVar.clearFinalVideoPath();
        }
    }

    public String u() {
        return this.f59031h.v();
    }

    public d.b.i0.p3.j.e.a v(String str) {
        if (this.i == null || k.isEmpty(str)) {
            return null;
        }
        return this.i.g(str);
    }

    public String w() {
        return this.f59031h.w();
    }

    public View x() {
        return this.f59024a;
    }

    public String y() {
        return this.f59030g.l();
    }

    public MaskVideoView z() {
        return this.f59026c;
    }
}
