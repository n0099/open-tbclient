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
    private FrescoThumbnailView nne;
    private c.a nnf;
    private c nnd = null;
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
        this.nne = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nne.getLayoutParams();
        int aw = tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        if (aw > 0) {
            layoutParams.topMargin -= aw;
            layoutParams.bottomMargin = 0;
        }
        this.nne.setLayoutParams(layoutParams);
        this.nne.setVisibility(0);
        this.nne.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.nne != null && !h.isEmpty(str)) {
            this.nne.i(str, 0, 0, 0);
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
        this.nne.setVisibility(8);
        this.d.setVisibility(0);
        this.nnd = c.b(this.a, this.h, this.b);
        this.nnd.a(this.nnf);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.nnd);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.nnf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.nnd != null) {
            this.nnd.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.nnd != null) {
            this.nnd.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.nnd != null) {
            this.nnd.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.nnd != null) {
            this.nnd.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nnd != null) {
            this.nnd.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.nnd != null) {
            this.nnd.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.nnd != null) {
            this.nnd.Z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.nnd != null) {
            this.nnd.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nnd != null) {
            this.nnd.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.nnd != null) {
            this.nnd.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.nnd != null) {
            this.nnd.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.nnd != null) {
            return this.nnd.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.nnd != null) {
            this.nnd.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.nnd != null) {
            this.nnd.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.nnd != null) {
            this.nnd.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.nnd != null) {
            this.nnd.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nnd != null) {
            this.nnd.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.nnd != null) {
            this.nnd.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.nnd != null) {
            this.nnd.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nnd != null) {
            return this.nnd.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.nnd != null) {
            return this.nnd.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.nnd != null) {
            this.nnd.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.nnd != null) {
            this.nnd.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.nnd != null) {
            this.nnd.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.nnd != null) {
            this.nnd.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.nnd != null) {
            this.nnd.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nnd != null) {
            this.nnd.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nnd != null) {
            this.nnd.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.nnd != null) {
            this.nnd.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nnd != null) {
            this.nnd.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nnd != null) {
            this.nnd.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.nnd != null) {
            this.nnd.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.nnd != null) {
            this.nnd.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.nnd != null) {
            this.nnd.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.nnd != null) {
            this.nnd.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.nnd != null) {
            this.nnd.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.nnd != null) {
            this.nnd.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nnd != null) {
            this.nnd.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nnd != null) {
            this.nnd.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nnd != null) {
            this.nnd.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0830a
    public void b(long j) {
        if (this.nnd != null) {
            this.nnd.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0828a
    public void c(int i) {
        if (this.nnd != null) {
            this.nnd.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0830a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nnd != null) {
            this.nnd.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0831a
    public void a(int i) {
        if (this.nnd != null) {
            this.nnd.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0831a
    public void D() {
        if (this.nnd != null) {
            this.nnd.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nnd != null) {
            this.nnd.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nnd != null) {
            this.nnd.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.nnd != null) {
            this.nnd.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nnd != null) {
            this.nnd.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(IconConfig.Config config) {
        if (this.nnd != null) {
            this.nnd.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(BangInfo bangInfo, String str) {
        if (this.nnd != null) {
            this.nnd.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nnd != null) {
            this.nnd.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.nnd != null) {
            this.nnd.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.nnd != null) {
            this.nnd.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nnd != null) {
            this.nnd.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.nnd != null) {
            this.nnd.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.nnd != null) {
            this.nnd.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.nnd != null) {
            this.nnd.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.nnd != null) {
            this.nnd.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nnd != null) {
            this.nnd.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nnd != null) {
            this.nnd.P();
        }
    }
}
