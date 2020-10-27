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
/* loaded from: classes6.dex */
public class d extends com.kascend.chushou.player.e {

    /* renamed from: a  reason: collision with root package name */
    public String f4133a;
    public String b;
    private View c;
    private boolean h;
    private FrameLayout pgB;
    private FrescoThumbnailView pgD;
    private c.a pgE;
    private c pgC = null;
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
        this.f4133a = getArguments().getString("cover");
        this.h = getArguments().getBoolean("initViewAsync");
        this.b = getArguments().getString("liveType");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.c = layoutInflater.inflate(a.h.videoplayer_root_view_show_parent, viewGroup, false);
        this.pgB = (FrameLayout) this.c.findViewById(a.f.game_fragment);
        this.pgD = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pgD.getLayoutParams();
        int aG = tv.chushou.zues.utils.systemBar.b.aG(getActivity());
        if (aG > 0) {
            layoutParams.topMargin -= aG;
            layoutParams.bottomMargin = 0;
        }
        this.pgD.setLayoutParams(layoutParams);
        this.pgD.setVisibility(0);
        this.pgD.setBlur(true);
        a(this.f4133a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.pgD != null && !h.isEmpty(str)) {
            this.pgD.j(str, 0, 0, 0);
        }
    }

    public void a() {
        if (this.pgB != null) {
            c();
        } else {
            this.g = true;
        }
    }

    private void c() {
        this.pgD.setVisibility(8);
        this.pgB.setVisibility(0);
        this.pgC = c.b(this.f4133a, this.h, this.b);
        this.pgC.a(this.pgE);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.pgC);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.pgE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.pgC != null) {
            this.pgC.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.pgC != null) {
            this.pgC.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.pgC != null) {
            this.pgC.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.pgC != null) {
            this.pgC.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.pgC != null) {
            this.pgC.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.pgC != null) {
            this.pgC.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.pgC != null) {
            this.pgC.YT();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.pgC != null) {
            this.pgC.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.pgC != null) {
            this.pgC.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.pgC != null) {
            this.pgC.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.pgC != null) {
            this.pgC.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.pgC != null) {
            return this.pgC.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.pgC != null) {
            this.pgC.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.pgC != null) {
            this.pgC.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.pgC != null) {
            this.pgC.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.pgC != null) {
            this.pgC.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.pgC != null) {
            this.pgC.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.pgC != null) {
            this.pgC.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.pgC != null) {
            this.pgC.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.pgC != null) {
            return this.pgC.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.pgC != null) {
            return this.pgC.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.pgC != null) {
            this.pgC.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.pgC != null) {
            this.pgC.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.pgC != null) {
            this.pgC.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.pgC != null) {
            this.pgC.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.pgC != null) {
            this.pgC.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.pgC != null) {
            this.pgC.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.pgC != null) {
            this.pgC.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.pgC != null) {
            this.pgC.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.pgC != null) {
            this.pgC.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.pgC != null) {
            this.pgC.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.pgC != null) {
            this.pgC.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.pgC != null) {
            this.pgC.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.pgC != null) {
            this.pgC.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.pgC != null) {
            this.pgC.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.pgC != null) {
            this.pgC.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.pgC != null) {
            this.pgC.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.pgC != null) {
            this.pgC.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.pgC != null) {
            this.pgC.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.pgC != null) {
            this.pgC.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0984a
    public void b(long j) {
        if (this.pgC != null) {
            this.pgC.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0982a
    public void c(int i) {
        if (this.pgC != null) {
            this.pgC.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0984a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.pgC != null) {
            this.pgC.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0985a
    public void a(int i) {
        if (this.pgC != null) {
            this.pgC.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0985a
    public void D() {
        if (this.pgC != null) {
            this.pgC.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.pgC != null) {
            this.pgC.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.pgC != null) {
            this.pgC.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.pgC != null) {
            this.pgC.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.pgC != null) {
            this.pgC.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(IconConfig.Config config) {
        if (this.pgC != null) {
            this.pgC.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(BangInfo bangInfo, String str) {
        if (this.pgC != null) {
            this.pgC.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.pgC != null) {
            this.pgC.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.pgC != null) {
            this.pgC.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.pgC != null) {
            this.pgC.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.pgC != null) {
            this.pgC.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.pgC != null) {
            this.pgC.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.pgC != null) {
            this.pgC.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.pgC != null) {
            this.pgC.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.pgC != null) {
            this.pgC.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.pgC != null) {
            this.pgC.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.pgC != null) {
            this.pgC.P();
        }
    }
}
