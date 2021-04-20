package d.b.i0.q3.j.h;

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
import d.b.c.e.p.k;
import d.b.h0.r.s.j;
import d.b.h0.r.s.l;
import d.b.i0.t1.g;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends d.b.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public View f60692a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f60693b;

    /* renamed from: c  reason: collision with root package name */
    public MaskVideoView f60694c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.q3.j.a f60695d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f60696e;

    /* renamed from: f  reason: collision with root package name */
    public j f60697f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.q3.j.h.c f60698g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.q3.j.h.e f60699h;
    public d.b.i0.q3.j.h.d i;
    public FrameLayout j;
    public FragmentTabWidget k;
    public int l;
    public MediaPlayer m;
    public boolean n;
    public g o;
    public l.e p;

    /* renamed from: d.b.i0.q3.j.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1526a implements FragmentTabWidget.b {
        public C1526a() {
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i, boolean z) {
            a aVar = a.this;
            if (i == aVar.l) {
                return;
            }
            if (i == 0) {
                aVar.f60698g.k().setVisibility(0);
                a.this.f60699h.x().setVisibility(8);
                a.this.i.h().setVisibility(8);
                a.this.f60698g.u(true);
                a.this.f60699h.G(false);
                a.this.i.n(false);
            } else if (i == 1) {
                aVar.i.h().setVisibility(0);
                a.this.f60699h.x().setVisibility(8);
                a.this.f60698g.k().setVisibility(8);
                a.this.f60698g.u(false);
                if (TextUtils.isEmpty(a.this.f60699h.w())) {
                    a.this.f60699h.G(false);
                } else {
                    a.this.f60699h.G(true);
                }
                a.this.i.n(true);
            } else if (i == 2) {
                aVar.f60699h.x().setVisibility(0);
                a.this.f60698g.k().setVisibility(8);
                a.this.i.h().setVisibility(8);
                a.this.f60698g.u(false);
                a.this.f60699h.G(true);
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

        /* renamed from: d.b.i0.q3.j.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1527a implements Runnable {
            public RunnableC1527a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f60698g.w();
            }
        }

        /* renamed from: d.b.i0.q3.j.h.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1528b implements MediaPlayer.OnInfoListener {
            public C1528b() {
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (i == 3) {
                    a aVar = a.this;
                    if (aVar.l == 0) {
                        aVar.f60694c.pause();
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
                    d.b.c.e.m.e.a().postDelayed(new RunnableC1527a(), 200L);
                    if (Build.VERSION.SDK_INT < 17) {
                        a.this.f60694c.start();
                        mediaPlayer.setOnInfoListener(new C1528b());
                        return;
                    }
                    a.this.f60694c.seekTo(a.this.f60698g.getCurrentPosition());
                    return;
                }
            }
            a.this.m.setVolume(0.0f, 0.0f);
            d.b.c.e.m.e.a().postDelayed(new RunnableC1527a(), 200L);
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
                a.this.f60699h.M();
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
            a.this.f60698g.m();
            if (a.this.f60695d != null) {
                a.this.f60695d.onNext();
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
                if (i == 1 && a.this.f60695d != null) {
                    a.this.f60695d.finishPage();
                }
            } else if (a.this.f60695d != null) {
                a.this.f60695d.onSave();
            }
            if (a.this.f60697f == null || !a.this.f60697f.isShowing() || a.this.getPageContext() == null) {
                return;
            }
            a.this.f60697f.dismiss();
        }
    }

    public a(d.b.c.a.f fVar, d.b.i0.q3.j.a aVar, View view, g gVar) {
        super(fVar);
        this.l = 0;
        this.p = new f();
        this.f60695d = aVar;
        this.f60692a = view;
        this.o = gVar;
        this.f60696e = view.getResources();
        this.f60698g = new d.b.i0.q3.j.h.c(this.mContext, this);
        this.f60699h = new d.b.i0.q3.j.h.e(this.mContext, this, this.o);
        this.i = new d.b.i0.q3.j.h.d(this.mContext, this);
        this.f60698g.n(this.f60692a);
        this.f60699h.y(this.f60692a);
        this.i.i(this.f60692a);
        E();
        i0();
    }

    public final void A() {
        this.f60693b.setCenterTextTitle(this.f60696e.getString(R.string.select_cover));
        this.f60693b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d());
        SkinManager.setViewTextColor(this.f60693b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f60696e.getString(R.string.select_cover_next), new e()), R.color.CAM_X0106);
    }

    public final void B() {
        String[] stringArray = this.f60696e.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.f60696e.getDimension(R.dimen.fontsize34));
            this.k.addView(fragmentTabIndicator, i);
        }
        if (!F() && this.k.getChildAt(1) != null) {
            this.k.getChildAt(1).setVisibility(8);
        }
        this.k.setDiverColor(this.f60696e.getColor(R.color.CAM_X0105));
        this.k.setCurrentTab(this.l, true, false);
        this.k.setBackGroundDrawableResId(R.color.CAM_X0201);
        this.k.setDviderRectWidth(d.b.c.e.p.l.g(this.mContext.getPageActivity(), R.dimen.ds64));
        this.k.setTabSelectionListener(new C1526a());
    }

    public final void E() {
        this.f60693b = (NavigationBar) this.f60692a.findViewById(R.id.navigation_bar);
        MaskVideoView maskVideoView = (MaskVideoView) this.f60692a.findViewById(R.id.video_view);
        this.f60694c = maskVideoView;
        maskVideoView.setPreserveEGLContextOnPause(true);
        this.f60694c.setZOrderMediaOverlay(true);
        this.f60694c.setPostMonitorManager(this.o);
        FrameLayout frameLayout = (FrameLayout) this.f60692a.findViewById(R.id.edit_container);
        this.j = frameLayout;
        frameLayout.addView(this.f60698g.k());
        this.k = (FragmentTabWidget) this.f60692a.findViewById(R.id.tab_widget);
        A();
        B();
        this.j.addView(this.f60699h.x());
        this.j.addView(this.i.h());
        this.f60699h.x().setVisibility(8);
        this.i.h().setVisibility(8);
    }

    public final boolean F() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public boolean G() {
        return this.n;
    }

    public void I() {
        MaskVideoView maskVideoView = this.f60694c;
        if (maskVideoView != null) {
            maskVideoView.n(this.f60698g.getCurrentPosition());
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

    public void K(d.b.c.a.f fVar, int i) {
        this.f60693b.onChangeSkinType(fVar, i);
        this.k.g(i);
        this.k.setDiverColor(SkinManager.getColor(i, R.color.CAM_X0105));
        SkinManager.setBackgroundColor(this.f60692a, R.color.CAM_X0201);
        d.b.i0.q3.j.h.c cVar = this.f60698g;
        if (cVar != null) {
            cVar.q(fVar, i);
        }
        d.b.i0.q3.j.h.e eVar = this.f60699h;
        if (eVar != null) {
            eVar.A(fVar, i);
        }
    }

    public void L(String str, String str2) {
        this.f60699h.B(str, str2);
    }

    public void M() {
        P();
        this.f60698g.r();
        this.f60699h.E();
        this.i.l();
    }

    public void O() {
        this.f60694c.onResume();
        if (this.l != 0) {
            this.f60694c.s();
        }
        this.f60698g.s();
        this.f60699h.F();
        this.i.m();
    }

    public void P() {
        MaskVideoView maskVideoView = this.f60694c;
        if (maskVideoView != null) {
            maskVideoView.q();
        }
    }

    public void Q() {
        MaskVideoView maskVideoView = this.f60694c;
        if (maskVideoView != null) {
            maskVideoView.onPause();
        }
    }

    public void R() {
        d.b.i0.q3.j.h.c cVar = this.f60698g;
        if (cVar != null) {
            cVar.v();
        }
        MaskVideoView maskVideoView = this.f60694c;
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
        this.f60694c.start();
        this.f60694c.seekTo(0);
    }

    public void T() {
        MaskVideoView maskVideoView = this.f60694c;
        if (maskVideoView != null) {
            maskVideoView.seekTo(this.f60698g.getCurrentPosition());
        }
    }

    public void U(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f60698g.x(str);
            this.f60694c.setVideoPath(str);
            this.f60694c.setOnPreparedListener(new b());
            this.f60694c.setOnCompletionListener(new c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void V(d.b.i0.q3.j.d.a aVar) {
        d.b.i0.q3.j.h.d dVar = this.i;
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
        this.f60699h.P(list);
    }

    public void Y(boolean z) {
        this.n = z;
        if (this.m == null) {
            return;
        }
        S();
    }

    public void b0(List<PendantData> list) {
        this.f60698g.y(list);
    }

    public void c0(Intent intent) {
        this.f60699h.R(intent);
    }

    public void d0(String str, String str2) {
        d.b.i0.q3.j.h.e eVar = this.f60699h;
        if (eVar != null) {
            eVar.S(str, str2);
        }
    }

    public void f0(d.b.i0.q3.j.e.a aVar) {
        MaskVideoView maskVideoView = this.f60694c;
        if (maskVideoView != null) {
            maskVideoView.setFilter(aVar);
        }
        d.b.i0.q3.j.h.d dVar = this.i;
        if (dVar != null) {
            dVar.o(aVar);
        }
    }

    public void g0(boolean z) {
        d.b.i0.q3.j.h.e eVar = this.f60699h;
        if (eVar != null) {
            eVar.Q(z);
            Y(!z);
        }
    }

    public int getCurrentPosition() {
        MaskVideoView maskVideoView = this.f60694c;
        if (maskVideoView == null) {
            return 0;
        }
        return maskVideoView.getCurrentPosition();
    }

    public void h0() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && StringHelper.equals(((EditVideoActivity) this.mContext.getPageActivity()).getFromType(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.f60695d.finishPage();
            return;
        }
        if (this.f60697f == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            j jVar = new j(getPageContext());
            this.f60697f = jVar;
            jVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.f60697f.i(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.p);
        }
        this.f60697f.l();
    }

    public final void i0() {
        StatisticItem statisticItem = new StatisticItem("c12424");
        statisticItem.param("obj_locate", this.l == 0 ? 1 : 3);
        TiebaStatic.log(statisticItem);
    }

    public Bitmap r(Bitmap bitmap) {
        return this.f60698g.h(bitmap);
    }

    public void s() {
        d.b.i0.q3.j.a aVar = this.f60695d;
        if (aVar != null) {
            aVar.clearFinalVideoPath();
        }
    }

    public String u() {
        return this.f60699h.v();
    }

    public d.b.i0.q3.j.e.a v(String str) {
        if (this.i == null || k.isEmpty(str)) {
            return null;
        }
        return this.i.g(str);
    }

    public String w() {
        return this.f60699h.w();
    }

    public View x() {
        return this.f60692a;
    }

    public String y() {
        return this.f60698g.l();
    }

    public MaskVideoView z() {
        return this.f60694c;
    }
}
