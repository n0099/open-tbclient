package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.win.opensdk.ce;
import com.win.opensdk.core.Info;
import com.win.opensdk.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public final class cd {

    /* renamed from: a  reason: collision with root package name */
    int f14039a;

    /* renamed from: a  reason: collision with other field name */
    long f46a;

    /* renamed from: b  reason: collision with root package name */
    int f14040b;

    /* renamed from: b  reason: collision with other field name */
    long f47b;

    /* renamed from: case  reason: not valid java name */
    int f48case;
    int java;

    /* renamed from: java  reason: collision with other field name */
    private String f49java;
    public Info qdE;
    bj qdG;
    Context qdj;
    public PBNativeListener qds;
    public ad qes;
    float qfk;
    float qfl;
    private View qfu;
    private List<View> qen = Collections.synchronizedList(new ArrayList());
    long qdF = 0;
    private ae<Info> qep = new ae<Info>() { // from class: com.win.opensdk.cd.1
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.win.opensdk.ae
        public final /* synthetic */ void bH(Info info) {
            Info info2 = info;
            try {
                cd.this.qdE = info2;
                if (cd.this.qds != null) {
                    if (info2 != null && info2.getType() == 11) {
                        if (cd.this.m77java()) {
                            cd.this.qds.onLoaded();
                        }
                    } else {
                        cd.this.qds.onFail(PBError.PID_TYPE_ERROR);
                    }
                }
            } catch (Exception e) {
            }
        }

        @Override // com.win.opensdk.ae
        public final void b(PBError pBError) {
            if (cd.this.qds != null) {
                cd.this.qds.onFail(pBError);
            }
        }
    };
    boolean qdm = false;
    long qel = 0;

    public cd(Context context, String str) {
        this.qdj = context;
        this.f49java = str;
        this.qes = new ad(context, str, e.f14045a);
        this.qes.qep = this.qep;
        this.qdG = new bj(context);
    }

    /* renamed from: java  reason: collision with other method in class */
    public final boolean m77java() {
        return this.qdE != null && this.qdE.isEffective();
    }

    private String java() {
        return m77java() ? this.qdE.getLoad() : "";
    }

    public final void a(final View view, PBMediaView pBMediaView, List<View> list) {
        if (view != null && list != null && list.size() != 0 && m77java()) {
            this.qdF = 0L;
            if (this.qfu != null) {
                eKp();
            }
            this.qfu = view;
            hg(list);
            a(pBMediaView);
            w.iM(this.qdj).a(new x(this.qdE)).eKp();
            if (this.qds != null) {
                this.qds.onDisplayed();
            }
            if (this.qdE != null) {
                az.k(this.qdj, this.qdE.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(this.qdE);
            new ce().a(view, this.qdE, new ce.a() { // from class: com.win.opensdk.cd.2
                @Override // com.win.opensdk.ce.a
                public final void eKp() {
                    if (view != null) {
                        new Handler().postDelayed(new Runnable() { // from class: com.win.opensdk.cd.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    View rootView = view.getRootView();
                                    if (rootView != null && rootView.getVisibility() == 0) {
                                        w.iM(cd.this.qdj).a(new x(cd.this.qdE), view.getWidth(), view.getHeight()).eKp();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, cd.this.qdE.getSpet());
                    }
                }
            });
        }
    }

    private void a(PBMediaView pBMediaView) {
        if (pBMediaView != null) {
            try {
                if (pBMediaView.getHtmlWebView() != null) {
                    bw htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(java(), this.qdE);
                    if (this.qdE.isNat()) {
                        htmlWebView.qeM.setOnTouchListener(new View.OnTouchListener() { // from class: com.win.opensdk.cd.3
                            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [298=5] */
                            @Override // android.view.View.OnTouchListener
                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                switch (motionEvent.getAction()) {
                                    case 0:
                                        cd.this.qdm = true;
                                        cd.this.qel = System.currentTimeMillis();
                                        cd.this.qfk = motionEvent.getX();
                                        cd.this.qfl = motionEvent.getY();
                                        cd.this.java = (int) motionEvent.getRawX();
                                        cd.this.f48case = (int) motionEvent.getRawY();
                                        cd.this.f46a = System.currentTimeMillis();
                                        break;
                                    case 1:
                                        cd.this.f14039a = (int) motionEvent.getRawX();
                                        cd.this.f14040b = (int) motionEvent.getRawY();
                                        cd.this.f47b = System.currentTimeMillis();
                                        Math.abs(motionEvent.getX() - cd.this.qfk);
                                        Math.abs(motionEvent.getY() - cd.this.qfl);
                                        if ((System.currentTimeMillis() - cd.this.qel < 2000) && cd.this.qdm && cd.this.qdE != null && aw.a(cd.this.qdE, cd.this.qdF)) {
                                            cd.this.qdF = System.currentTimeMillis();
                                            aw.a(cd.this.qdj, cd.this.qdE.getOpen(), cd.this.qdE, cd.this.qdG);
                                            w.a a2 = w.iM(cd.this.qdj).a(new x(cd.this.qdE), (String) null);
                                            cd cdVar = cd.this;
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("dx", Integer.valueOf(cdVar.java));
                                            hashMap.put("dy", Integer.valueOf(cdVar.f48case));
                                            hashMap.put("dts", Long.valueOf(cdVar.f46a));
                                            hashMap.put("ux", Integer.valueOf(cdVar.f14039a));
                                            hashMap.put("uy", Integer.valueOf(cdVar.f14040b));
                                            hashMap.put("uts", Long.valueOf(cdVar.f47b));
                                            a2.hv("desc", hashMap.toString()).eKp();
                                            z.a(cd.this.qdE);
                                            if (cd.this.qds != null) {
                                                cd.this.qds.onClicked();
                                                break;
                                            }
                                        }
                                        break;
                                }
                                return true;
                            }
                        });
                    }
                    htmlWebView.qdX = new bo() { // from class: com.win.opensdk.cd.4
                        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [328=4] */
                        @Override // com.win.opensdk.bo
                        public final boolean hu(String str, String str2) {
                            if (aw.a(cd.this.qdE, cd.this.qdF)) {
                                cd.this.qdF = System.currentTimeMillis();
                                aw.a(cd.this.qdj, str, cd.this.qdE, cd.this.qdG);
                                w.iM(cd.this.qdj).a(new x(cd.this.qdE), str).hv("desc", str2).eKp();
                                if (cd.this.qds != null) {
                                    cd.this.qds.onClicked();
                                }
                                z.a(cd.this.qdE);
                                return true;
                            }
                            return true;
                        }

                        @Override // com.win.opensdk.bo
                        public final void abL(String str) {
                        }
                    };
                }
            } catch (Exception e) {
            }
        }
    }

    private void hg(List<View> list) {
        try {
            a aVar = new a();
            for (View view : list) {
                if (view != null && !(view instanceof PBMediaView)) {
                    if (!this.qen.contains(view)) {
                        this.qen.add(view);
                    }
                    view.setOnClickListener(aVar);
                    view.setOnTouchListener(aVar);
                }
            }
        } catch (Exception e) {
        }
    }

    public final List<View> ez(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            try {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        arrayList.add(childAt);
                        if (!(childAt instanceof PBMediaView)) {
                            arrayList.addAll(ez(childAt));
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener, View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private int f14041a;

        /* renamed from: b  reason: collision with root package name */
        private int f14042b;

        /* renamed from: case  reason: not valid java name */
        private int f50case;
        private int java;
        private long qdF;
        private long qel;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [464=5] */
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.java = (int) motionEvent.getRawX();
                    this.f50case = (int) motionEvent.getRawY();
                    this.qdF = System.currentTimeMillis();
                    return false;
                case 1:
                    this.f14041a = (int) motionEvent.getRawX();
                    this.f14042b = (int) motionEvent.getRawY();
                    this.qel = System.currentTimeMillis();
                    if (cd.this.qdE == null || !aw.a(cd.this.qdE, cd.this.qdF)) {
                        return false;
                    }
                    cd.this.qdF = System.currentTimeMillis();
                    aw.a(cd.this.qdj, cd.this.qdE.getOpen(), cd.this.qdE, cd.this.qdG);
                    w.a a2 = w.iM(cd.this.qdj).a(new x(cd.this.qdE), (String) null);
                    HashMap hashMap = new HashMap();
                    hashMap.put("dx", Integer.valueOf(this.java));
                    hashMap.put("dy", Integer.valueOf(this.f50case));
                    hashMap.put("dts", Long.valueOf(this.qdF));
                    hashMap.put("ux", Integer.valueOf(this.f14041a));
                    hashMap.put("uy", Integer.valueOf(this.f14042b));
                    hashMap.put("uts", Long.valueOf(this.qel));
                    a2.hv("desc", hashMap.toString()).eKp();
                    z.a(cd.this.qdE);
                    if (cd.this.qds != null) {
                        cd.this.qds.onClicked();
                        return false;
                    }
                    return false;
                default:
                    return false;
            }
        }
    }

    public final void eKp() {
        try {
            for (View view : this.qen) {
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
            this.qen.clear();
            if (this.qfu != null) {
                this.qfu = null;
            }
        } catch (Exception e) {
        }
    }
}
