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
/* loaded from: classes5.dex */
public class e extends com.kascend.chushou.player.e {
    public String c;
    public String d;
    private View f;
    private View h;
    private List<d> m;
    private VideoVerticalViewPager mvW;
    private d mvX;
    private d mvY;
    private d mvZ;
    private d mwa;
    private Context mwb;
    private ListItem mwd;
    private ListItem mwe;
    private boolean q;
    private boolean u;
    private String v;
    private boolean o = false;
    private int p = -1;
    protected com.kascend.chushou.player.b mwc = null;
    public List<ListItem> b = new ArrayList();
    private boolean r = false;
    c.a mwf = new c.a() { // from class: com.kascend.chushou.player.e.e.2
        @Override // com.kascend.chushou.player.e.c.a
        public void a(boolean z) {
            if (e.this.r && e.this.mvW != null) {
                e.this.mvW.setNoFocus(!z);
            }
        }

        @Override // com.kascend.chushou.player.e.c.a
        public void a() {
            e.this.u = true;
            if (e.this.r && e.this.mvW != null) {
                e.this.mvW.setNoFocus(true);
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
        this.mwb = getActivity();
        this.c = getArguments().getString("cover");
        this.q = getArguments().getBoolean("initViewAsync");
        this.d = getArguments().getString("liveType");
        this.v = getArguments().getString("roomId");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f = layoutInflater.inflate(a.h.videoplayer_root_view_faceshow, viewGroup, false);
        this.mvW = (VideoVerticalViewPager) this.f.findViewById(a.f.viewpager);
        this.mvW.setOverScrollMode(2);
        return this.f;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        a();
    }

    private void a() {
        String str;
        String str2;
        this.mwc = ((VideoPlayer) this.mwb).dwV();
        b();
        if (this.mwd != null) {
            str = !h.isEmpty(this.mwd.mOriginalCover) ? this.mwd.mOriginalCover : this.mwd.mCover;
        } else {
            str = "";
        }
        this.mvX = d.c(str, true, this.d);
        this.mvY = d.c(this.c, this.q, this.d);
        if (this.mwe != null) {
            str2 = !h.isEmpty(this.mwe.mOriginalCover) ? this.mwe.mOriginalCover : this.mwe.mCover;
        } else {
            str2 = "";
        }
        this.mvZ = d.c(str2, true, this.d);
        this.m = new ArrayList();
        this.m.add(this.mvX);
        this.m.add(this.mvY);
        this.m.add(this.mvZ);
        this.mvW.setAdapter(new a(getChildFragmentManager()));
        this.mvW.setCurrentItem(1, false);
        this.p = 1;
        this.mwa = this.m.get(1);
        if (this.mwa != null) {
            this.mwa.a();
            this.mwa.a(this.mwf);
        }
        this.mvW.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kascend.chushou.player.e.e.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(final int i) {
                if (e.this.p != i && e.this.r) {
                    if (e.this.mwa != null) {
                        e.this.mwa.b();
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
                            if (e.this.mwb != null && e.this.getActivity() != null && !e.this.getActivity().isFinishing()) {
                                if (e.this.mwc != null) {
                                    try {
                                        jSONObject = new JSONObject(e.this.mwc.h);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    jSONObject2 = jSONObject != null ? new JSONObject() : jSONObject;
                                    jSONObject2.put("tag_from_view", "1");
                                    if (jSONObject2.has("_thumb")) {
                                        jSONObject2.remove("_thumb");
                                    }
                                    aVar = !(e.this.mwb instanceof VideoPlayer) ? ((VideoPlayer) e.this.mwb).mor : null;
                                    if (aVar != null && aVar.mwH != null) {
                                        aVar.mwH.time = System.currentTimeMillis() - aVar.b;
                                        aVar.mwH.roomId = e.this.v;
                                        aVar.a();
                                        aVar.mwH.reset();
                                        aVar.b = System.currentTimeMillis();
                                    }
                                    if (i <= e.this.p) {
                                        com.kascend.chushou.d.e.a(e.this.mwb, e.this.mwe, jSONObject2);
                                        if (aVar != null && aVar.mwH != null) {
                                            aVar.mwH.roomId = e.this.mwe.mRoomId;
                                            aVar.mwH.enterType = 2;
                                        }
                                    } else {
                                        com.kascend.chushou.d.e.a(e.this.mwb, e.this.mwd, jSONObject2);
                                        if (aVar != null && aVar.mwH != null) {
                                            aVar.mwH.roomId = e.this.mwd.mRoomId;
                                            aVar.mwH.enterType = 3;
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
                                if (!(e.this.mwb instanceof VideoPlayer)) {
                                }
                                if (aVar != null) {
                                    aVar.mwH.time = System.currentTimeMillis() - aVar.b;
                                    aVar.mwH.roomId = e.this.v;
                                    aVar.a();
                                    aVar.mwH.reset();
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
        ((VideoPlayer) this.mwb).n();
    }

    private void b() {
        if (this.mwc != null && !h.isEmpty(this.mwc.t)) {
            this.b.clear();
            if (this.mwc != null && !h.isEmpty(this.mwc.t)) {
                this.b.addAll(this.mwc.t);
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
                    if (this.u && this.mvW != null) {
                        this.mvW.setNoFocus(true);
                    }
                    if (i - 1 < 0) {
                        this.mwd = this.b.get(size - 1);
                    } else {
                        this.mwd = this.b.get(i - 1);
                    }
                    a(this.mwd.mRoomId, this.mwd.mLiveType);
                    if (this.mvX != null) {
                        if (!h.isEmpty(this.mwd.mOriginalCover)) {
                            this.mvX.a(this.mwd.mOriginalCover);
                        } else {
                            this.mvX.a(this.mwd.mCover);
                        }
                    }
                    if (i + 1 >= size) {
                        this.mwe = this.b.get(0);
                    } else {
                        this.mwe = this.b.get(i + 1);
                    }
                    a(this.mwe.mRoomId, this.mwe.mLiveType);
                    if (this.mvZ != null) {
                        if (!h.isEmpty(this.mwe.mOriginalCover)) {
                            this.mvZ.a(this.mwe.mOriginalCover);
                        } else {
                            this.mvZ.a(this.mwe.mCover);
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
        j.dwP().a(str, a(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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
        if (this.mwa != null) {
            this.mwa.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.mwa != null) {
            this.mwa.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.mwa != null) {
            this.mwa.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.mwa != null) {
            this.mwa.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mwa != null) {
            this.mwa.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.mwa != null) {
            this.mwa.e(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.mwa != null) {
            this.mwa.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mwa != null) {
            this.mwa.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.mwa != null) {
            this.mwa.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.mwa != null) {
            this.mwa.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.mwa != null) {
            return this.mwa.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.mwa != null) {
            this.mwa.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.mwa != null) {
            this.mwa.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.mwa != null) {
            this.mwa.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.mwa != null) {
            this.mwa.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mwa != null) {
            this.mwa.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.mwa != null) {
            this.mwa.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.mwa != null) {
            this.mwa.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mwa != null) {
            return this.mwa.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.h != null && this.h.getVisibility() == 0) {
            this.h.setVisibility(8);
            return true;
        } else if (this.mwa != null) {
            return this.mwa.a(i, keyEvent);
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
        if (this.mwa != null) {
            this.mwa.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.mwa != null) {
            this.mwa.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.mwa != null) {
            this.mwa.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.mwa != null) {
            this.mwa.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.mwa != null) {
            this.mwa.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mwa != null) {
            this.mwa.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mwa != null) {
            this.mwa.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.mwa != null) {
            this.mwa.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mwa != null) {
            this.mwa.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mwa != null) {
            this.mwa.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.mwa != null) {
            this.mwa.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.mwa != null) {
            this.mwa.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.mwa != null) {
            this.mwa.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.mwa != null) {
            this.mwa.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.mwa != null) {
            this.mwa.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.mwa != null) {
            this.mwa.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mwa != null) {
            this.mwa.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mwa != null) {
            this.mwa.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mwa != null) {
            this.mwa.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0730a
    public void b(long j) {
        if (this.mwa != null) {
            this.mwa.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0728a
    public void c(int i) {
        if (this.mwa != null) {
            this.mwa.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0730a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mwa != null) {
            this.mwa.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0731a
    public void a(int i) {
        if (this.mwa != null) {
            this.mwa.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0731a
    public void D() {
        if (this.mwa != null) {
            this.mwa.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mwa != null) {
            this.mwa.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mwa != null) {
            this.mwa.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.mwa != null) {
            this.mwa.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mwa != null) {
            this.mwa.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(IconConfig.Config config) {
        if (this.mwa != null) {
            this.mwa.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(BangInfo bangInfo, String str) {
        if (this.mwa != null) {
            this.mwa.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mwa != null) {
            this.mwa.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.mwa != null) {
            this.mwa.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.mwa != null) {
            this.mwa.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mwa != null) {
            this.mwa.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.mwa != null) {
            this.mwa.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.mwa != null) {
            this.mwa.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.mwa != null) {
            this.mwa.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.mwa != null) {
            this.mwa.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j(boolean z) {
        if (this.mvW != null) {
            this.mvW.setNoFocus(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mwa != null) {
            this.mwa.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mwa != null) {
            this.mwa.P();
        }
    }
}
