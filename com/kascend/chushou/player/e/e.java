package com.kascend.chushou.player.e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.n;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.IconConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.PkNotifyInfo;
import com.kascend.chushou.constants.SkinConfig;
import com.kascend.chushou.d.j;
import com.kascend.chushou.player.VideoPlayer;
import com.kascend.chushou.player.e.c;
import com.kascend.chushou.player.g;
import com.kascend.chushou.widget.VideoVerticalViewPager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public class e extends com.kascend.chushou.player.e {
    public String c;
    public String d;
    private View f;
    private View h;
    private List<d> m;
    private VideoVerticalViewPager mWT;
    private d mWU;
    private d mWV;
    private d mWW;
    private d mWX;
    private Context mWY;
    private ListItem mXa;
    private ListItem mXb;
    private boolean q;
    private boolean u;
    private String v;
    private boolean o = false;
    private int p = -1;
    protected com.kascend.chushou.player.b mWZ = null;
    public List<ListItem> b = new ArrayList();
    private boolean r = false;
    c.a mXc = new c.a() { // from class: com.kascend.chushou.player.e.e.2
        @Override // com.kascend.chushou.player.e.c.a
        public void a(boolean z) {
            if (e.this.r && e.this.mWT != null) {
                e.this.mWT.setNoFocus(!z);
            }
        }

        @Override // com.kascend.chushou.player.e.c.a
        public void a() {
            e.this.u = true;
            if (e.this.r && e.this.mWT != null) {
                e.this.mWT.setNoFocus(true);
            }
        }
    };

    public static e a(String str, boolean z, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("cover", str);
        bundle.putBoolean("initViewAsync", z);
        bundle.putString("liveType", str2);
        bundle.putString("roomId", str3);
        e eVar = new e();
        eVar.setArguments(bundle);
        return eVar;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mWY = getActivity();
        this.c = getArguments().getString("cover");
        this.q = getArguments().getBoolean("initViewAsync");
        this.d = getArguments().getString("liveType");
        this.v = getArguments().getString("roomId");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f = layoutInflater.inflate(a.h.videoplayer_root_view_faceshow, viewGroup, false);
        this.mWT = (VideoVerticalViewPager) this.f.findViewById(a.f.viewpager);
        this.mWT.setOverScrollMode(2);
        return this.f;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        a();
    }

    private void a() {
        String str;
        String str2;
        this.mWZ = ((VideoPlayer) this.mWY).dAV();
        b();
        if (this.mXa != null) {
            str = !h.isEmpty(this.mXa.mOriginalCover) ? this.mXa.mOriginalCover : this.mXa.mCover;
        } else {
            str = "";
        }
        this.mWU = d.c(str, true, this.d);
        this.mWV = d.c(this.c, this.q, this.d);
        if (this.mXb != null) {
            str2 = !h.isEmpty(this.mXb.mOriginalCover) ? this.mXb.mOriginalCover : this.mXb.mCover;
        } else {
            str2 = "";
        }
        this.mWW = d.c(str2, true, this.d);
        this.m = new ArrayList();
        this.m.add(this.mWU);
        this.m.add(this.mWV);
        this.m.add(this.mWW);
        this.mWT.setAdapter(new a(getChildFragmentManager()));
        this.mWT.setCurrentItem(1, false);
        this.p = 1;
        this.mWX = this.m.get(1);
        if (this.mWX != null) {
            this.mWX.a();
            this.mWX.a(this.mXc);
        }
        this.mWT.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kascend.chushou.player.e.e.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(final int i) {
                if (e.this.p != i && e.this.r) {
                    if (e.this.mWX != null) {
                        e.this.mWX.b();
                    }
                    RxExecutor.postDelayed(new io.reactivex.disposables.a(), EventThread.MAIN_THREAD, 150L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.e.1.1
                        /* JADX WARN: Can't wrap try/catch for region: R(14:7|(13:43|44|(1:11)(1:42)|12|13|(1:15)|17|(1:19)(1:39)|(1:23)|24|(2:26|(1:30))(2:34|(1:38))|31|32)|9|(0)(0)|12|13|(0)|17|(0)(0)|(2:21|23)|24|(0)(0)|31|32) */
                        /* JADX WARN: Code restructure failed: missing block: B:35:0x00e6, code lost:
                            r0 = move-exception;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:36:0x00e7, code lost:
                            r0.printStackTrace();
                         */
                        /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
                        /* JADX WARN: Removed duplicated region for block: B:16:0x0053 A[Catch: JSONException -> 0x00e6, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00e6, blocks: (B:14:0x0041, B:16:0x0053), top: B:44:0x0041 }] */
                        /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
                        /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
                        /* JADX WARN: Removed duplicated region for block: B:37:0x00ec  */
                        /* JADX WARN: Removed duplicated region for block: B:42:0x0119  */
                        /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            JSONObject jSONObject;
                            JSONObject jSONObject2;
                            com.kascend.chushou.player.feedback.a aVar;
                            if (e.this.mWY != null && e.this.getActivity() != null && !e.this.getActivity().isFinishing()) {
                                if (e.this.mWZ != null) {
                                    try {
                                        jSONObject = new JSONObject(e.this.mWZ.h);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    jSONObject2 = jSONObject != null ? new JSONObject() : jSONObject;
                                    jSONObject2.put("tag_from_view", "1");
                                    if (jSONObject2.has("_thumb")) {
                                        jSONObject2.remove("_thumb");
                                    }
                                    aVar = !(e.this.mWY instanceof VideoPlayer) ? ((VideoPlayer) e.this.mWY).mPb : null;
                                    if (aVar != null && aVar.mXD != null) {
                                        aVar.mXD.time = System.currentTimeMillis() - aVar.b;
                                        aVar.mXD.roomId = e.this.v;
                                        aVar.a();
                                        aVar.mXD.reset();
                                        aVar.b = System.currentTimeMillis();
                                    }
                                    if (i <= e.this.p) {
                                        com.kascend.chushou.d.e.a(e.this.mWY, e.this.mXb, jSONObject2);
                                        if (aVar != null && aVar.mXD != null) {
                                            aVar.mXD.roomId = e.this.mXb.mRoomId;
                                            aVar.mXD.enterType = 2;
                                        }
                                    } else {
                                        com.kascend.chushou.d.e.a(e.this.mWY, e.this.mXa, jSONObject2);
                                        if (aVar != null && aVar.mXD != null) {
                                            aVar.mXD.roomId = e.this.mXa.mRoomId;
                                            aVar.mXD.enterType = 3;
                                        }
                                    }
                                    e.this.p = i;
                                }
                                jSONObject = null;
                                if (jSONObject != null) {
                                }
                                jSONObject2.put("tag_from_view", "1");
                                if (jSONObject2.has("_thumb")) {
                                }
                                if (!(e.this.mWY instanceof VideoPlayer)) {
                                }
                                if (aVar != null) {
                                    aVar.mXD.time = System.currentTimeMillis() - aVar.b;
                                    aVar.mXD.roomId = e.this.v;
                                    aVar.a();
                                    aVar.mXD.reset();
                                    aVar.b = System.currentTimeMillis();
                                }
                                if (i <= e.this.p) {
                                }
                                e.this.p = i;
                            }
                        }
                    });
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        ((VideoPlayer) this.mWY).n();
    }

    private void b() {
        if (this.mWZ != null && !h.isEmpty(this.mWZ.t)) {
            this.b.clear();
            if (this.mWZ != null && !h.isEmpty(this.mWZ.t)) {
                this.b.addAll(this.mWZ.t);
            }
            if (!h.isEmpty(this.b) && !h.isEmpty(this.v)) {
                int i = 0;
                while (true) {
                    if (i >= this.b.size()) {
                        i = -1;
                        break;
                    } else if (this.v.equals(this.b.get(i).mTargetKey)) {
                        break;
                    } else {
                        i++;
                    }
                }
                int size = this.b.size();
                if (i != -1 && size >= 3) {
                    this.r = true;
                    if (this.u && this.mWT != null) {
                        this.mWT.setNoFocus(true);
                    }
                    if (i - 1 < 0) {
                        this.mXa = this.b.get(size - 1);
                    } else {
                        this.mXa = this.b.get(i - 1);
                    }
                    a(this.mXa.mRoomId, this.mXa.mLiveType);
                    if (this.mWU != null) {
                        if (!h.isEmpty(this.mXa.mOriginalCover)) {
                            this.mWU.a(this.mXa.mOriginalCover);
                        } else {
                            this.mWU.a(this.mXa.mCover);
                        }
                    }
                    if (i + 1 >= size) {
                        this.mXb = this.b.get(0);
                    } else {
                        this.mXb = this.b.get(i + 1);
                    }
                    a(this.mXb.mRoomId, this.mXb.mLiveType);
                    if (this.mWW != null) {
                        if (!h.isEmpty(this.mXb.mOriginalCover)) {
                            this.mWW.a(this.mXb.mOriginalCover);
                        } else {
                            this.mWW.a(this.mXb.mCover);
                        }
                    }
                }
            }
        }
    }

    private String a(String str) {
        if ("4".equals(str)) {
            return TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY + Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
        }
        return "2" + Constants.ACCEPT_TIME_SEPARATOR_SP + "1" + Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY + Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    }

    private void a(String str, String str2) {
        j.dAP().a(str, a(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends FragmentStatePagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return (Fragment) e.this.m.get(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return e.this.m.size();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mWX != null) {
            this.mWX.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.mWX != null) {
            this.mWX.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.mWX != null) {
            this.mWX.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.mWX != null) {
            this.mWX.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mWX != null) {
            this.mWX.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.mWX != null) {
            this.mWX.e(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.mWX != null) {
            this.mWX.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mWX != null) {
            this.mWX.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.mWX != null) {
            this.mWX.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.mWX != null) {
            this.mWX.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.mWX != null) {
            return this.mWX.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.mWX != null) {
            this.mWX.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.mWX != null) {
            this.mWX.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.mWX != null) {
            this.mWX.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.mWX != null) {
            this.mWX.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mWX != null) {
            this.mWX.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.mWX != null) {
            this.mWX.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.mWX != null) {
            this.mWX.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mWX != null) {
            return this.mWX.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.h != null && this.h.getVisibility() == 0) {
            this.h.setVisibility(8);
            return true;
        } else if (this.mWX != null) {
            return this.mWX.a(i, keyEvent);
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.e
    public void w() {
        b();
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.mWX != null) {
            this.mWX.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.mWX != null) {
            this.mWX.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.mWX != null) {
            this.mWX.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.mWX != null) {
            this.mWX.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.mWX != null) {
            this.mWX.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mWX != null) {
            this.mWX.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mWX != null) {
            this.mWX.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.mWX != null) {
            this.mWX.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mWX != null) {
            this.mWX.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mWX != null) {
            this.mWX.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.mWX != null) {
            this.mWX.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.mWX != null) {
            this.mWX.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.mWX != null) {
            this.mWX.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.mWX != null) {
            this.mWX.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.mWX != null) {
            this.mWX.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.mWX != null) {
            this.mWX.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mWX != null) {
            this.mWX.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mWX != null) {
            this.mWX.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mWX != null) {
            this.mWX.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(long j) {
        if (this.mWX != null) {
            this.mWX.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0695a
    public void c(int i) {
        if (this.mWX != null) {
            this.mWX.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mWX != null) {
            this.mWX.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void a(int i) {
        if (this.mWX != null) {
            this.mWX.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void D() {
        if (this.mWX != null) {
            this.mWX.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mWX != null) {
            this.mWX.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mWX != null) {
            this.mWX.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.mWX != null) {
            this.mWX.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mWX != null) {
            this.mWX.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(IconConfig.Config config) {
        if (this.mWX != null) {
            this.mWX.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(BangInfo bangInfo, String str) {
        if (this.mWX != null) {
            this.mWX.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mWX != null) {
            this.mWX.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.mWX != null) {
            this.mWX.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.mWX != null) {
            this.mWX.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mWX != null) {
            this.mWX.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.mWX != null) {
            this.mWX.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.mWX != null) {
            this.mWX.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.mWX != null) {
            this.mWX.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.mWX != null) {
            this.mWX.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j(boolean z) {
        if (this.mWT != null) {
            this.mWT.setNoFocus(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mWX != null) {
            this.mWX.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mWX != null) {
            this.mWX.P();
        }
    }
}
