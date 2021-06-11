package d.a.n0.r3.i.h;

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
import d.a.c.e.p.k;
import d.a.m0.r.s.j;
import d.a.m0.r.s.l;
import d.a.n0.u1.g;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends d.a.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public View f63823a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f63824b;

    /* renamed from: c  reason: collision with root package name */
    public MaskVideoView f63825c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.r3.i.a f63826d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f63827e;

    /* renamed from: f  reason: collision with root package name */
    public j f63828f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r3.i.h.c f63829g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.r3.i.h.e f63830h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.r3.i.h.d f63831i;
    public FrameLayout j;
    public FragmentTabWidget k;
    public int l;
    public MediaPlayer m;
    public boolean n;
    public g o;
    public l.e p;

    /* renamed from: d.a.n0.r3.i.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1631a implements FragmentTabWidget.b {
        public C1631a() {
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i2, boolean z) {
            a aVar = a.this;
            if (i2 == aVar.l) {
                return;
            }
            if (i2 == 0) {
                aVar.f63829g.k().setVisibility(0);
                a.this.f63830h.v().setVisibility(8);
                a.this.f63831i.h().setVisibility(8);
                a.this.f63829g.s(true);
                a.this.f63830h.F(false);
                a.this.f63831i.n(false);
            } else if (i2 == 1) {
                aVar.f63831i.h().setVisibility(0);
                a.this.f63830h.v().setVisibility(8);
                a.this.f63829g.k().setVisibility(8);
                a.this.f63829g.s(false);
                if (TextUtils.isEmpty(a.this.f63830h.u())) {
                    a.this.f63830h.F(false);
                } else {
                    a.this.f63830h.F(true);
                }
                a.this.f63831i.n(true);
            } else if (i2 == 2) {
                aVar.f63830h.v().setVisibility(0);
                a.this.f63829g.k().setVisibility(8);
                a.this.f63831i.h().setVisibility(8);
                a.this.f63829g.s(false);
                a.this.f63830h.F(true);
                a.this.f63831i.n(false);
            }
            a aVar2 = a.this;
            aVar2.l = i2;
            aVar2.k.setCurrentTab(a.this.l, true, true);
            a.this.g0();
            a.this.H();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements MediaPlayer.OnPreparedListener {

        /* renamed from: d.a.n0.r3.i.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1632a implements Runnable {
            public RunnableC1632a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f63829g.u();
            }
        }

        /* renamed from: d.a.n0.r3.i.h.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1633b implements MediaPlayer.OnInfoListener {
            public C1633b() {
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                if (i2 == 3) {
                    a aVar = a.this;
                    if (aVar.l == 0) {
                        aVar.f63825c.pause();
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
                    d.a.c.e.m.e.a().postDelayed(new RunnableC1632a(), 200L);
                    if (Build.VERSION.SDK_INT < 17) {
                        a.this.f63825c.start();
                        mediaPlayer.setOnInfoListener(new C1633b());
                        return;
                    }
                    a.this.f63825c.seekTo(a.this.f63829g.getCurrentPosition());
                    return;
                }
            }
            a.this.m.setVolume(0.0f, 0.0f);
            d.a.c.e.m.e.a().postDelayed(new RunnableC1632a(), 200L);
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
                aVar.Q();
                a.this.f63830h.K();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.e0();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f63829g.m();
            if (a.this.f63826d != null) {
                a.this.f63826d.onNext();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements l.e {
        public f() {
        }

        @Override // d.a.m0.r.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            if (i2 != 0) {
                if (i2 == 1 && a.this.f63826d != null) {
                    a.this.f63826d.finishPage();
                }
            } else if (a.this.f63826d != null) {
                a.this.f63826d.onSave();
            }
            if (a.this.f63828f == null || !a.this.f63828f.isShowing() || a.this.getPageContext() == null) {
                return;
            }
            a.this.f63828f.dismiss();
        }
    }

    public a(d.a.c.a.f fVar, d.a.n0.r3.i.a aVar, View view, g gVar) {
        super(fVar);
        this.l = 0;
        this.p = new f();
        this.f63826d = aVar;
        this.f63823a = view;
        this.o = gVar;
        this.f63827e = view.getResources();
        this.f63829g = new d.a.n0.r3.i.h.c(this.mContext, this);
        this.f63830h = new d.a.n0.r3.i.h.e(this.mContext, this, this.o);
        this.f63831i = new d.a.n0.r3.i.h.d(this.mContext, this);
        this.f63829g.n(this.f63823a);
        this.f63830h.w(this.f63823a);
        this.f63831i.i(this.f63823a);
        A();
        g0();
    }

    public final void A() {
        this.f63824b = (NavigationBar) this.f63823a.findViewById(R.id.navigation_bar);
        MaskVideoView maskVideoView = (MaskVideoView) this.f63823a.findViewById(R.id.video_view);
        this.f63825c = maskVideoView;
        maskVideoView.setPreserveEGLContextOnPause(true);
        this.f63825c.setZOrderMediaOverlay(true);
        this.f63825c.setPostMonitorManager(this.o);
        FrameLayout frameLayout = (FrameLayout) this.f63823a.findViewById(R.id.edit_container);
        this.j = frameLayout;
        frameLayout.addView(this.f63829g.k());
        this.k = (FragmentTabWidget) this.f63823a.findViewById(R.id.tab_widget);
        y();
        z();
        this.j.addView(this.f63830h.v());
        this.j.addView(this.f63831i.h());
        this.f63830h.v().setVisibility(8);
        this.f63831i.h().setVisibility(8);
    }

    public final boolean B() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public boolean F() {
        return this.n;
    }

    public void G() {
        MaskVideoView maskVideoView = this.f63825c;
        if (maskVideoView != null) {
            maskVideoView.n(this.f63829g.getCurrentPosition());
        }
    }

    public final void H() {
        if (this.l == 0) {
            M();
            R();
            return;
        }
        Q();
    }

    public void I(d.a.c.a.f fVar, int i2) {
        this.f63824b.onChangeSkinType(fVar, i2);
        this.k.h(i2);
        this.k.setDiverColor(SkinManager.getColor(i2, R.color.CAM_X0105));
        SkinManager.setBackgroundColor(this.f63823a, R.color.CAM_X0201);
        d.a.n0.r3.i.h.c cVar = this.f63829g;
        if (cVar != null) {
            cVar.p(fVar, i2);
        }
        d.a.n0.r3.i.h.e eVar = this.f63830h;
        if (eVar != null) {
            eVar.y(fVar, i2);
        }
    }

    public void J(String str, String str2) {
        this.f63830h.z(str, str2);
    }

    public void K() {
        M();
        this.f63829g.q();
        this.f63830h.A();
        this.f63831i.l();
    }

    public void L() {
        this.f63825c.onResume();
        if (this.l != 0) {
            this.f63825c.s();
        }
        this.f63829g.r();
        this.f63830h.B();
        this.f63831i.m();
    }

    public void M() {
        MaskVideoView maskVideoView = this.f63825c;
        if (maskVideoView != null) {
            maskVideoView.q();
        }
    }

    public void O() {
        MaskVideoView maskVideoView = this.f63825c;
        if (maskVideoView != null) {
            maskVideoView.onPause();
        }
    }

    public void P() {
        d.a.n0.r3.i.h.c cVar = this.f63829g;
        if (cVar != null) {
            cVar.t();
        }
        MaskVideoView maskVideoView = this.f63825c;
        if (maskVideoView != null) {
            maskVideoView.t();
        }
    }

    public void Q() {
        M();
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer != null) {
            if (this.n) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.f63825c.start();
        this.f63825c.seekTo(0);
    }

    public void R() {
        MaskVideoView maskVideoView = this.f63825c;
        if (maskVideoView != null) {
            maskVideoView.seekTo(this.f63829g.getCurrentPosition());
        }
    }

    public void S(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f63829g.v(str);
            this.f63825c.setVideoPath(str);
            this.f63825c.setOnPreparedListener(new b());
            this.f63825c.setOnCompletionListener(new c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void T(d.a.n0.r3.i.d.a aVar) {
        d.a.n0.r3.i.h.d dVar = this.f63831i;
        if (dVar != null) {
            dVar.p(aVar);
        }
    }

    public void U(MaskVideoView.f fVar) {
        if (fVar == null || x() == null) {
            return;
        }
        x().setGenMaskCoverListener(fVar);
    }

    public void V(List<MusicData> list) {
        this.f63830h.M(list);
    }

    public void Y(boolean z) {
        this.n = z;
        if (this.m == null) {
            return;
        }
        Q();
    }

    public void Z(List<PendantData> list) {
        this.f63829g.w(list);
    }

    public void a0(Intent intent) {
        this.f63830h.P(intent);
    }

    public void b0(String str, String str2) {
        d.a.n0.r3.i.h.e eVar = this.f63830h;
        if (eVar != null) {
            eVar.Q(str, str2);
        }
    }

    public void c0(d.a.n0.r3.i.e.a aVar) {
        MaskVideoView maskVideoView = this.f63825c;
        if (maskVideoView != null) {
            maskVideoView.setFilter(aVar);
        }
        d.a.n0.r3.i.h.d dVar = this.f63831i;
        if (dVar != null) {
            dVar.o(aVar);
        }
    }

    public void d0(boolean z) {
        d.a.n0.r3.i.h.e eVar = this.f63830h;
        if (eVar != null) {
            eVar.O(z);
            Y(!z);
        }
    }

    public void e0() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && StringHelper.equals(((EditVideoActivity) this.mContext.getPageActivity()).getFromType(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.f63826d.finishPage();
            return;
        }
        if (this.f63828f == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            j jVar = new j(getPageContext());
            this.f63828f = jVar;
            jVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.f63828f.i(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.p);
        }
        this.f63828f.l();
    }

    public final void g0() {
        StatisticItem statisticItem = new StatisticItem("c12424");
        statisticItem.param("obj_locate", this.l == 0 ? 1 : 3);
        TiebaStatic.log(statisticItem);
    }

    public int getCurrentPosition() {
        MaskVideoView maskVideoView = this.f63825c;
        if (maskVideoView == null) {
            return 0;
        }
        return maskVideoView.getCurrentPosition();
    }

    public Bitmap q(Bitmap bitmap) {
        return this.f63829g.h(bitmap);
    }

    public void r() {
        d.a.n0.r3.i.a aVar = this.f63826d;
        if (aVar != null) {
            aVar.clearFinalVideoPath();
        }
    }

    public String s() {
        return this.f63830h.t();
    }

    public d.a.n0.r3.i.e.a t(String str) {
        if (this.f63831i == null || k.isEmpty(str)) {
            return null;
        }
        return this.f63831i.g(str);
    }

    public String u() {
        return this.f63830h.u();
    }

    public View v() {
        return this.f63823a;
    }

    public String w() {
        return this.f63829g.l();
    }

    public MaskVideoView x() {
        return this.f63825c;
    }

    public final void y() {
        this.f63824b.setCenterTextTitle(this.f63827e.getString(R.string.select_cover));
        this.f63824b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d());
        SkinManager.setViewTextColor(this.f63824b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f63827e.getString(R.string.select_cover_next), new e()), R.color.CAM_X0106);
    }

    public final void z() {
        String[] stringArray = this.f63827e.getStringArray(R.array.edit_video_tab);
        for (int i2 = 0; i2 < stringArray.length; i2++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i2]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.f63827e.getDimension(R.dimen.fontsize34));
            this.k.addView(fragmentTabIndicator, i2);
        }
        if (!B() && this.k.getChildAt(1) != null) {
            this.k.getChildAt(1).setVisibility(8);
        }
        this.k.setDiverColor(this.f63827e.getColor(R.color.CAM_X0105));
        this.k.setCurrentTab(this.l, true, false);
        this.k.setBackGroundDrawableResId(R.color.CAM_X0201);
        this.k.setDviderRectWidth(d.a.c.e.p.l.g(this.mContext.getPageActivity(), R.dimen.ds64));
        this.k.setTabSelectionListener(new C1631a());
    }
}
