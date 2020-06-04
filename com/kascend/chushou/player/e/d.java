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
    private FrescoThumbnailView mRe;
    private c.a mRf;
    private c mRd = null;
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
        this.mRe = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRe.getLayoutParams();
        int aw = tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        if (aw > 0) {
            layoutParams.topMargin -= aw;
            layoutParams.bottomMargin = 0;
        }
        this.mRe.setLayoutParams(layoutParams);
        this.mRe.setVisibility(0);
        this.mRe.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.mRe != null && !h.isEmpty(str)) {
            this.mRe.i(str, 0, 0, 0);
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
        this.mRe.setVisibility(8);
        this.d.setVisibility(0);
        this.mRd = c.b(this.a, this.h, this.b);
        this.mRd.a(this.mRf);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.mRd);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.mRf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mRd != null) {
            this.mRd.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.mRd != null) {
            this.mRd.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.mRd != null) {
            this.mRd.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.mRd != null) {
            this.mRd.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mRd != null) {
            this.mRd.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.mRd != null) {
            this.mRd.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.mRd != null) {
            this.mRd.Z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.mRd != null) {
            this.mRd.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mRd != null) {
            this.mRd.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.mRd != null) {
            this.mRd.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.mRd != null) {
            this.mRd.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.mRd != null) {
            return this.mRd.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.mRd != null) {
            this.mRd.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.mRd != null) {
            this.mRd.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.mRd != null) {
            this.mRd.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.mRd != null) {
            this.mRd.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mRd != null) {
            this.mRd.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.mRd != null) {
            this.mRd.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.mRd != null) {
            this.mRd.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mRd != null) {
            return this.mRd.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.mRd != null) {
            return this.mRd.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.mRd != null) {
            this.mRd.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.mRd != null) {
            this.mRd.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.mRd != null) {
            this.mRd.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.mRd != null) {
            this.mRd.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.mRd != null) {
            this.mRd.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mRd != null) {
            this.mRd.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mRd != null) {
            this.mRd.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.mRd != null) {
            this.mRd.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mRd != null) {
            this.mRd.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mRd != null) {
            this.mRd.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.mRd != null) {
            this.mRd.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.mRd != null) {
            this.mRd.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.mRd != null) {
            this.mRd.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.mRd != null) {
            this.mRd.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.mRd != null) {
            this.mRd.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.mRd != null) {
            this.mRd.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mRd != null) {
            this.mRd.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mRd != null) {
            this.mRd.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mRd != null) {
            this.mRd.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0810a
    public void b(long j) {
        if (this.mRd != null) {
            this.mRd.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0808a
    public void c(int i) {
        if (this.mRd != null) {
            this.mRd.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0810a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mRd != null) {
            this.mRd.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0811a
    public void a(int i) {
        if (this.mRd != null) {
            this.mRd.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0811a
    public void D() {
        if (this.mRd != null) {
            this.mRd.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mRd != null) {
            this.mRd.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mRd != null) {
            this.mRd.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.mRd != null) {
            this.mRd.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mRd != null) {
            this.mRd.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(IconConfig.Config config) {
        if (this.mRd != null) {
            this.mRd.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(BangInfo bangInfo, String str) {
        if (this.mRd != null) {
            this.mRd.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mRd != null) {
            this.mRd.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.mRd != null) {
            this.mRd.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.mRd != null) {
            this.mRd.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mRd != null) {
            this.mRd.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.mRd != null) {
            this.mRd.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.mRd != null) {
            this.mRd.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.mRd != null) {
            this.mRd.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.mRd != null) {
            this.mRd.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mRd != null) {
            this.mRd.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mRd != null) {
            this.mRd.P();
        }
    }
}
