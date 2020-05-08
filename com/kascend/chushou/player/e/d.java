package com.kascend.chushou.player.e;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.n;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.IconConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.PkNotifyInfo;
import com.kascend.chushou.constants.SkinConfig;
import com.kascend.chushou.player.e.c;
import com.kascend.chushou.player.g;
import java.util.List;
import java.util.Map;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public class d extends com.kascend.chushou.player.e {
    public String a;
    public String b;
    private View c;
    private FrameLayout d;
    private boolean h;
    private FrescoThumbnailView mvZ;
    private c.a mwa;
    private c mvY = null;
    private boolean g = false;

    public static d c(String str, boolean z, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("cover", str);
        bundle.putBoolean("initViewAsync", z);
        bundle.putString("liveType", str2);
        d dVar = new d();
        dVar.setArguments(bundle);
        return dVar;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = getArguments().getString("cover");
        this.h = getArguments().getBoolean("initViewAsync");
        this.b = getArguments().getString("liveType");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.c = layoutInflater.inflate(a.h.videoplayer_root_view_show_parent, viewGroup, false);
        this.d = (FrameLayout) this.c.findViewById(a.f.game_fragment);
        this.mvZ = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mvZ.getLayoutParams();
        int ax = tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        if (ax > 0) {
            layoutParams.topMargin -= ax;
            layoutParams.bottomMargin = 0;
        }
        this.mvZ.setLayoutParams(layoutParams);
        this.mvZ.setVisibility(0);
        this.mvZ.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.mvZ != null && !h.isEmpty(str)) {
            this.mvZ.i(str, 0, 0, 0);
        }
    }

    public void a() {
        if (this.d != null) {
            c();
        } else {
            this.g = true;
        }
    }

    private void c() {
        this.mvZ.setVisibility(8);
        this.d.setVisibility(0);
        this.mvY = c.b(this.a, this.h, this.b);
        this.mvY.a(this.mwa);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.mvY);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.mwa = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mvY != null) {
            this.mvY.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.mvY != null) {
            this.mvY.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.mvY != null) {
            this.mvY.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.mvY != null) {
            this.mvY.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mvY != null) {
            this.mvY.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.mvY != null) {
            this.mvY.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.mvY != null) {
            this.mvY.Z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.mvY != null) {
            this.mvY.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mvY != null) {
            this.mvY.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.mvY != null) {
            this.mvY.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.mvY != null) {
            this.mvY.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.mvY != null) {
            return this.mvY.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.mvY != null) {
            this.mvY.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.mvY != null) {
            this.mvY.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.mvY != null) {
            this.mvY.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.mvY != null) {
            this.mvY.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mvY != null) {
            this.mvY.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.mvY != null) {
            this.mvY.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.mvY != null) {
            this.mvY.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mvY != null) {
            return this.mvY.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.mvY != null) {
            return this.mvY.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.mvY != null) {
            this.mvY.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.mvY != null) {
            this.mvY.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.mvY != null) {
            this.mvY.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.mvY != null) {
            this.mvY.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.mvY != null) {
            this.mvY.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mvY != null) {
            this.mvY.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mvY != null) {
            this.mvY.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.mvY != null) {
            this.mvY.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mvY != null) {
            this.mvY.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mvY != null) {
            this.mvY.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.mvY != null) {
            this.mvY.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.mvY != null) {
            this.mvY.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.mvY != null) {
            this.mvY.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.mvY != null) {
            this.mvY.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.mvY != null) {
            this.mvY.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.mvY != null) {
            this.mvY.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mvY != null) {
            this.mvY.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mvY != null) {
            this.mvY.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mvY != null) {
            this.mvY.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0751a
    public void b(long j) {
        if (this.mvY != null) {
            this.mvY.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0749a
    public void c(int i) {
        if (this.mvY != null) {
            this.mvY.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0751a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mvY != null) {
            this.mvY.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0752a
    public void a(int i) {
        if (this.mvY != null) {
            this.mvY.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0752a
    public void D() {
        if (this.mvY != null) {
            this.mvY.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mvY != null) {
            this.mvY.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mvY != null) {
            this.mvY.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.mvY != null) {
            this.mvY.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mvY != null) {
            this.mvY.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(IconConfig.Config config) {
        if (this.mvY != null) {
            this.mvY.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(BangInfo bangInfo, String str) {
        if (this.mvY != null) {
            this.mvY.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mvY != null) {
            this.mvY.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.mvY != null) {
            this.mvY.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.mvY != null) {
            this.mvY.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mvY != null) {
            this.mvY.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.mvY != null) {
            this.mvY.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.mvY != null) {
            this.mvY.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.mvY != null) {
            this.mvY.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.mvY != null) {
            this.mvY.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mvY != null) {
            this.mvY.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mvY != null) {
            this.mvY.P();
        }
    }
}
