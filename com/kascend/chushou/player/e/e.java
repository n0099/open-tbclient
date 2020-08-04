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
/* loaded from: classes6.dex */
public class e extends com.kascend.chushou.player.e {
    public String c;
    public String d;
    private View f;
    private View h;
    private List<d> m;
    private VideoVerticalViewPager nvV;
    private d nvW;
    private d nvX;
    private d nvY;
    private d nvZ;
    private Context nwa;
    private ListItem nwc;
    private ListItem nwd;
    private boolean q;
    private boolean u;
    private String v;
    private boolean o = false;
    private int p = -1;
    protected com.kascend.chushou.player.b nwb = null;
    public List<ListItem> b = new ArrayList();
    private boolean r = false;
    c.a nwe = new c.a() { // from class: com.kascend.chushou.player.e.e.2
        @Override // com.kascend.chushou.player.e.c.a
        public void a(boolean z) {
            if (e.this.r && e.this.nvV != null) {
                e.this.nvV.setNoFocus(!z);
            }
        }

        @Override // com.kascend.chushou.player.e.c.a
        public void a() {
            e.this.u = true;
            if (e.this.r && e.this.nvV != null) {
                e.this.nvV.setNoFocus(true);
            }
        }
    };

    public static e b(String str, boolean z, String str2, String str3) {
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
        this.nwa = getActivity();
        this.c = getArguments().getString("cover");
        this.q = getArguments().getBoolean("initViewAsync");
        this.d = getArguments().getString("liveType");
        this.v = getArguments().getString("roomId");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f = layoutInflater.inflate(a.h.videoplayer_root_view_faceshow, viewGroup, false);
        this.nvV = (VideoVerticalViewPager) this.f.findViewById(a.f.viewpager);
        this.nvV.setOverScrollMode(2);
        return this.f;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        a();
    }

    private void a() {
        String str;
        String str2;
        this.nwb = ((VideoPlayer) this.nwa).dMB();
        b();
        if (this.nwc != null) {
            str = !h.isEmpty(this.nwc.mOriginalCover) ? this.nwc.mOriginalCover : this.nwc.mCover;
        } else {
            str = "";
        }
        this.nvW = d.c(str, true, this.d);
        this.nvX = d.c(this.c, this.q, this.d);
        if (this.nwd != null) {
            str2 = !h.isEmpty(this.nwd.mOriginalCover) ? this.nwd.mOriginalCover : this.nwd.mCover;
        } else {
            str2 = "";
        }
        this.nvY = d.c(str2, true, this.d);
        this.m = new ArrayList();
        this.m.add(this.nvW);
        this.m.add(this.nvX);
        this.m.add(this.nvY);
        this.nvV.setAdapter(new a(getChildFragmentManager()));
        this.nvV.setCurrentItem(1, false);
        this.p = 1;
        this.nvZ = this.m.get(1);
        if (this.nvZ != null) {
            this.nvZ.a();
            this.nvZ.a(this.nwe);
        }
        this.nvV.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kascend.chushou.player.e.e.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(final int i) {
                if (e.this.p != i && e.this.r) {
                    if (e.this.nvZ != null) {
                        e.this.nvZ.b();
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
                            if (e.this.nwa != null && e.this.getActivity() != null && !e.this.getActivity().isFinishing()) {
                                if (e.this.nwb != null) {
                                    try {
                                        jSONObject = new JSONObject(e.this.nwb.h);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    jSONObject2 = jSONObject != null ? new JSONObject() : jSONObject;
                                    jSONObject2.put("tag_from_view", "1");
                                    if (jSONObject2.has("_thumb")) {
                                        jSONObject2.remove("_thumb");
                                    }
                                    aVar = !(e.this.nwa instanceof VideoPlayer) ? ((VideoPlayer) e.this.nwa).nop : null;
                                    if (aVar != null && aVar.nwE != null) {
                                        aVar.nwE.time = System.currentTimeMillis() - aVar.b;
                                        aVar.nwE.roomId = e.this.v;
                                        aVar.a();
                                        aVar.nwE.reset();
                                        aVar.b = System.currentTimeMillis();
                                    }
                                    if (i <= e.this.p) {
                                        com.kascend.chushou.d.e.a(e.this.nwa, e.this.nwd, jSONObject2);
                                        if (aVar != null && aVar.nwE != null) {
                                            aVar.nwE.roomId = e.this.nwd.mRoomId;
                                            aVar.nwE.enterType = 2;
                                        }
                                    } else {
                                        com.kascend.chushou.d.e.a(e.this.nwa, e.this.nwc, jSONObject2);
                                        if (aVar != null && aVar.nwE != null) {
                                            aVar.nwE.roomId = e.this.nwc.mRoomId;
                                            aVar.nwE.enterType = 3;
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
                                if (!(e.this.nwa instanceof VideoPlayer)) {
                                }
                                if (aVar != null) {
                                    aVar.nwE.time = System.currentTimeMillis() - aVar.b;
                                    aVar.nwE.roomId = e.this.v;
                                    aVar.a();
                                    aVar.nwE.reset();
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
        ((VideoPlayer) this.nwa).n();
    }

    private void b() {
        if (this.nwb != null && !h.isEmpty(this.nwb.t)) {
            this.b.clear();
            if (this.nwb != null && !h.isEmpty(this.nwb.t)) {
                this.b.addAll(this.nwb.t);
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
                    if (this.u && this.nvV != null) {
                        this.nvV.setNoFocus(true);
                    }
                    if (i - 1 < 0) {
                        this.nwc = this.b.get(size - 1);
                    } else {
                        this.nwc = this.b.get(i - 1);
                    }
                    a(this.nwc.mRoomId, this.nwc.mLiveType);
                    if (this.nvW != null) {
                        if (!h.isEmpty(this.nwc.mOriginalCover)) {
                            this.nvW.a(this.nwc.mOriginalCover);
                        } else {
                            this.nvW.a(this.nwc.mCover);
                        }
                    }
                    if (i + 1 >= size) {
                        this.nwd = this.b.get(0);
                    } else {
                        this.nwd = this.b.get(i + 1);
                    }
                    a(this.nwd.mRoomId, this.nwd.mLiveType);
                    if (this.nvY != null) {
                        if (!h.isEmpty(this.nwd.mOriginalCover)) {
                            this.nvY.a(this.nwd.mOriginalCover);
                        } else {
                            this.nvY.a(this.nwd.mCover);
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
        j.dMv().a(str, a(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
        if (this.nvZ != null) {
            this.nvZ.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.nvZ != null) {
            this.nvZ.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.nvZ != null) {
            this.nvZ.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.nvZ != null) {
            this.nvZ.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nvZ != null) {
            this.nvZ.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.nvZ != null) {
            this.nvZ.e(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.nvZ != null) {
            this.nvZ.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nvZ != null) {
            this.nvZ.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.nvZ != null) {
            this.nvZ.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.nvZ != null) {
            this.nvZ.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.nvZ != null) {
            return this.nvZ.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.nvZ != null) {
            this.nvZ.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.nvZ != null) {
            this.nvZ.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.nvZ != null) {
            this.nvZ.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.nvZ != null) {
            this.nvZ.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nvZ != null) {
            this.nvZ.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.nvZ != null) {
            this.nvZ.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.nvZ != null) {
            this.nvZ.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nvZ != null) {
            return this.nvZ.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.h != null && this.h.getVisibility() == 0) {
            this.h.setVisibility(8);
            return true;
        } else if (this.nvZ != null) {
            return this.nvZ.a(i, keyEvent);
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
        if (this.nvZ != null) {
            this.nvZ.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.nvZ != null) {
            this.nvZ.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.nvZ != null) {
            this.nvZ.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.nvZ != null) {
            this.nvZ.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.nvZ != null) {
            this.nvZ.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nvZ != null) {
            this.nvZ.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nvZ != null) {
            this.nvZ.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.nvZ != null) {
            this.nvZ.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nvZ != null) {
            this.nvZ.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nvZ != null) {
            this.nvZ.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.nvZ != null) {
            this.nvZ.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.nvZ != null) {
            this.nvZ.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.nvZ != null) {
            this.nvZ.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.nvZ != null) {
            this.nvZ.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.nvZ != null) {
            this.nvZ.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.nvZ != null) {
            this.nvZ.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nvZ != null) {
            this.nvZ.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nvZ != null) {
            this.nvZ.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nvZ != null) {
            this.nvZ.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(long j) {
        if (this.nvZ != null) {
            this.nvZ.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0837a
    public void c(int i) {
        if (this.nvZ != null) {
            this.nvZ.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nvZ != null) {
            this.nvZ.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void a(int i) {
        if (this.nvZ != null) {
            this.nvZ.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void D() {
        if (this.nvZ != null) {
            this.nvZ.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nvZ != null) {
            this.nvZ.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nvZ != null) {
            this.nvZ.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.nvZ != null) {
            this.nvZ.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nvZ != null) {
            this.nvZ.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(IconConfig.Config config) {
        if (this.nvZ != null) {
            this.nvZ.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(BangInfo bangInfo, String str) {
        if (this.nvZ != null) {
            this.nvZ.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nvZ != null) {
            this.nvZ.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.nvZ != null) {
            this.nvZ.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.nvZ != null) {
            this.nvZ.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nvZ != null) {
            this.nvZ.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.nvZ != null) {
            this.nvZ.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.nvZ != null) {
            this.nvZ.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.nvZ != null) {
            this.nvZ.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.nvZ != null) {
            this.nvZ.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j(boolean z) {
        if (this.nvV != null) {
            this.nvV.setNoFocus(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nvZ != null) {
            this.nvZ.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nvZ != null) {
            this.nvZ.P();
        }
    }
}
