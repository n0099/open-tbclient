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
/* loaded from: classes3.dex */
public final class cd {

    /* renamed from: a  reason: collision with root package name */
    int f13741a;

    /* renamed from: a  reason: collision with other field name */
    long f45a;

    /* renamed from: b  reason: collision with root package name */
    int f13742b;

    /* renamed from: b  reason: collision with other field name */
    long f46b;

    /* renamed from: case  reason: not valid java name */
    int f47case;
    int java;

    /* renamed from: java  reason: collision with other field name */
    private String f48java;
    public Info qjI;
    bj qjK;
    Context qjn;
    public PBNativeListener qjw;
    public ad qkw;
    float qlo;
    float qlp;
    private View qly;
    private List<View> qkr = Collections.synchronizedList(new ArrayList());
    long qjJ = 0;
    private ae<Info> qkt = new ae<Info>() { // from class: com.win.opensdk.cd.1
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.win.opensdk.ae
        public final /* synthetic */ void bH(Info info) {
            Info info2 = info;
            try {
                cd.this.qjI = info2;
                if (cd.this.qjw != null) {
                    if (info2 != null && info2.getType() == 11) {
                        if (cd.this.m72java()) {
                            cd.this.qjw.onLoaded();
                        }
                    } else {
                        cd.this.qjw.onFail(PBError.PID_TYPE_ERROR);
                    }
                }
            } catch (Exception e) {
            }
        }

        @Override // com.win.opensdk.ae
        public final void b(PBError pBError) {
            if (cd.this.qjw != null) {
                cd.this.qjw.onFail(pBError);
            }
        }
    };
    boolean qjq = false;
    long qkp = 0;

    public cd(Context context, String str) {
        this.qjn = context;
        this.f48java = str;
        this.qkw = new ad(context, str, e.f13747a);
        this.qkw.qkt = this.qkt;
        this.qjK = new bj(context);
    }

    /* renamed from: java  reason: collision with other method in class */
    public final boolean m72java() {
        return this.qjI != null && this.qjI.isEffective();
    }

    private String java() {
        return m72java() ? this.qjI.getLoad() : "";
    }

    public final void a(final View view, PBMediaView pBMediaView, List<View> list) {
        if (view != null && list != null && list.size() != 0 && m72java()) {
            this.qjJ = 0L;
            if (this.qly != null) {
                eIX();
            }
            this.qly = view;
            he(list);
            a(pBMediaView);
            w.iN(this.qjn).a(new x(this.qjI)).eIX();
            if (this.qjw != null) {
                this.qjw.onDisplayed();
            }
            if (this.qjI != null) {
                az.k(this.qjn, this.qjI.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(this.qjI);
            new ce().a(view, this.qjI, new ce.a() { // from class: com.win.opensdk.cd.2
                @Override // com.win.opensdk.ce.a
                public final void eIX() {
                    if (view != null) {
                        new Handler().postDelayed(new Runnable() { // from class: com.win.opensdk.cd.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    View rootView = view.getRootView();
                                    if (rootView != null && rootView.getVisibility() == 0) {
                                        w.iN(cd.this.qjn).a(new x(cd.this.qjI), view.getWidth(), view.getHeight()).eIX();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, cd.this.qjI.getSpet());
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
                    htmlWebView.a(java(), this.qjI);
                    if (this.qjI.isNat()) {
                        htmlWebView.qkQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.win.opensdk.cd.3
                            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [298=5] */
                            @Override // android.view.View.OnTouchListener
                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                switch (motionEvent.getAction()) {
                                    case 0:
                                        cd.this.qjq = true;
                                        cd.this.qkp = System.currentTimeMillis();
                                        cd.this.qlo = motionEvent.getX();
                                        cd.this.qlp = motionEvent.getY();
                                        cd.this.java = (int) motionEvent.getRawX();
                                        cd.this.f47case = (int) motionEvent.getRawY();
                                        cd.this.f45a = System.currentTimeMillis();
                                        break;
                                    case 1:
                                        cd.this.f13741a = (int) motionEvent.getRawX();
                                        cd.this.f13742b = (int) motionEvent.getRawY();
                                        cd.this.f46b = System.currentTimeMillis();
                                        Math.abs(motionEvent.getX() - cd.this.qlo);
                                        Math.abs(motionEvent.getY() - cd.this.qlp);
                                        if ((System.currentTimeMillis() - cd.this.qkp < 2000) && cd.this.qjq && cd.this.qjI != null && aw.a(cd.this.qjI, cd.this.qjJ)) {
                                            cd.this.qjJ = System.currentTimeMillis();
                                            aw.a(cd.this.qjn, cd.this.qjI.getOpen(), cd.this.qjI, cd.this.qjK);
                                            w.a a2 = w.iN(cd.this.qjn).a(new x(cd.this.qjI), (String) null);
                                            cd cdVar = cd.this;
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("dx", Integer.valueOf(cdVar.java));
                                            hashMap.put("dy", Integer.valueOf(cdVar.f47case));
                                            hashMap.put("dts", Long.valueOf(cdVar.f45a));
                                            hashMap.put("ux", Integer.valueOf(cdVar.f13741a));
                                            hashMap.put("uy", Integer.valueOf(cdVar.f13742b));
                                            hashMap.put("uts", Long.valueOf(cdVar.f46b));
                                            a2.hD("desc", hashMap.toString()).eIX();
                                            z.a(cd.this.qjI);
                                            if (cd.this.qjw != null) {
                                                cd.this.qjw.onClicked();
                                                break;
                                            }
                                        }
                                        break;
                                }
                                return true;
                            }
                        });
                    }
                    htmlWebView.qkb = new bo() { // from class: com.win.opensdk.cd.4
                        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [328=4] */
                        @Override // com.win.opensdk.bo
                        public final boolean hC(String str, String str2) {
                            if (aw.a(cd.this.qjI, cd.this.qjJ)) {
                                cd.this.qjJ = System.currentTimeMillis();
                                aw.a(cd.this.qjn, str, cd.this.qjI, cd.this.qjK);
                                w.iN(cd.this.qjn).a(new x(cd.this.qjI), str).hD("desc", str2).eIX();
                                if (cd.this.qjw != null) {
                                    cd.this.qjw.onClicked();
                                }
                                z.a(cd.this.qjI);
                                return true;
                            }
                            return true;
                        }

                        @Override // com.win.opensdk.bo
                        public final void abR(String str) {
                        }
                    };
                }
            } catch (Exception e) {
            }
        }
    }

    private void he(List<View> list) {
        try {
            a aVar = new a();
            for (View view : list) {
                if (view != null && !(view instanceof PBMediaView)) {
                    if (!this.qkr.contains(view)) {
                        this.qkr.add(view);
                    }
                    view.setOnClickListener(aVar);
                    view.setOnTouchListener(aVar);
                }
            }
        } catch (Exception e) {
        }
    }

    public final List<View> ex(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            try {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        arrayList.add(childAt);
                        if (!(childAt instanceof PBMediaView)) {
                            arrayList.addAll(ex(childAt));
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener, View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private int f13743a;

        /* renamed from: b  reason: collision with root package name */
        private int f13744b;

        /* renamed from: case  reason: not valid java name */
        private int f49case;
        private int java;
        private long qjJ;
        private long qkp;

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
                    this.f49case = (int) motionEvent.getRawY();
                    this.qjJ = System.currentTimeMillis();
                    return false;
                case 1:
                    this.f13743a = (int) motionEvent.getRawX();
                    this.f13744b = (int) motionEvent.getRawY();
                    this.qkp = System.currentTimeMillis();
                    if (cd.this.qjI == null || !aw.a(cd.this.qjI, cd.this.qjJ)) {
                        return false;
                    }
                    cd.this.qjJ = System.currentTimeMillis();
                    aw.a(cd.this.qjn, cd.this.qjI.getOpen(), cd.this.qjI, cd.this.qjK);
                    w.a a2 = w.iN(cd.this.qjn).a(new x(cd.this.qjI), (String) null);
                    HashMap hashMap = new HashMap();
                    hashMap.put("dx", Integer.valueOf(this.java));
                    hashMap.put("dy", Integer.valueOf(this.f49case));
                    hashMap.put("dts", Long.valueOf(this.qjJ));
                    hashMap.put("ux", Integer.valueOf(this.f13743a));
                    hashMap.put("uy", Integer.valueOf(this.f13744b));
                    hashMap.put("uts", Long.valueOf(this.qkp));
                    a2.hD("desc", hashMap.toString()).eIX();
                    z.a(cd.this.qjI);
                    if (cd.this.qjw != null) {
                        cd.this.qjw.onClicked();
                        return false;
                    }
                    return false;
                default:
                    return false;
            }
        }
    }

    public final void eIX() {
        try {
            for (View view : this.qkr) {
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
            this.qkr.clear();
            if (this.qly != null) {
                this.qly = null;
            }
        } catch (Exception e) {
        }
    }
}
