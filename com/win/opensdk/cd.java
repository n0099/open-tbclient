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
    int f13739a;

    /* renamed from: a  reason: collision with other field name */
    long f45a;

    /* renamed from: b  reason: collision with root package name */
    int f13740b;

    /* renamed from: b  reason: collision with other field name */
    long f46b;

    /* renamed from: case  reason: not valid java name */
    int f47case;
    int java;

    /* renamed from: java  reason: collision with other field name */
    private String f48java;
    Context pYJ;
    public PBNativeListener pYS;
    public ad pZS;
    public Info pZe;
    bj pZg;
    float qaK;
    float qaL;
    private View qaU;
    private List<View> pZN = Collections.synchronizedList(new ArrayList());
    long pZf = 0;
    private ae<Info> pZP = new ae<Info>() { // from class: com.win.opensdk.cd.1
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.win.opensdk.ae
        public final /* synthetic */ void bH(Info info) {
            Info info2 = info;
            try {
                cd.this.pZe = info2;
                if (cd.this.pYS != null) {
                    if (info2 != null && info2.getType() == 11) {
                        if (cd.this.m73java()) {
                            cd.this.pYS.onLoaded();
                        }
                    } else {
                        cd.this.pYS.onFail(PBError.PID_TYPE_ERROR);
                    }
                }
            } catch (Exception e) {
            }
        }

        @Override // com.win.opensdk.ae
        public final void b(PBError pBError) {
            if (cd.this.pYS != null) {
                cd.this.pYS.onFail(pBError);
            }
        }
    };
    boolean pYM = false;
    long pZL = 0;

    public cd(Context context, String str) {
        this.pYJ = context;
        this.f48java = str;
        this.pZS = new ad(context, str, e.f13745a);
        this.pZS.pZP = this.pZP;
        this.pZg = new bj(context);
    }

    /* renamed from: java  reason: collision with other method in class */
    public final boolean m73java() {
        return this.pZe != null && this.pZe.isEffective();
    }

    private String java() {
        return m73java() ? this.pZe.getLoad() : "";
    }

    public final void a(final View view, PBMediaView pBMediaView, List<View> list) {
        if (view != null && list != null && list.size() != 0 && m73java()) {
            this.pZf = 0L;
            if (this.qaU != null) {
                eGz();
            }
            this.qaU = view;
            hg(list);
            a(pBMediaView);
            w.iK(this.pYJ).a(new x(this.pZe)).eGz();
            if (this.pYS != null) {
                this.pYS.onDisplayed();
            }
            if (this.pZe != null) {
                az.k(this.pYJ, this.pZe.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(this.pZe);
            new ce().a(view, this.pZe, new ce.a() { // from class: com.win.opensdk.cd.2
                @Override // com.win.opensdk.ce.a
                public final void eGz() {
                    if (view != null) {
                        new Handler().postDelayed(new Runnable() { // from class: com.win.opensdk.cd.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    View rootView = view.getRootView();
                                    if (rootView != null && rootView.getVisibility() == 0) {
                                        w.iK(cd.this.pYJ).a(new x(cd.this.pZe), view.getWidth(), view.getHeight()).eGz();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, cd.this.pZe.getSpet());
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
                    htmlWebView.a(java(), this.pZe);
                    if (this.pZe.isNat()) {
                        htmlWebView.qam.setOnTouchListener(new View.OnTouchListener() { // from class: com.win.opensdk.cd.3
                            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [298=5] */
                            @Override // android.view.View.OnTouchListener
                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                switch (motionEvent.getAction()) {
                                    case 0:
                                        cd.this.pYM = true;
                                        cd.this.pZL = System.currentTimeMillis();
                                        cd.this.qaK = motionEvent.getX();
                                        cd.this.qaL = motionEvent.getY();
                                        cd.this.java = (int) motionEvent.getRawX();
                                        cd.this.f47case = (int) motionEvent.getRawY();
                                        cd.this.f45a = System.currentTimeMillis();
                                        break;
                                    case 1:
                                        cd.this.f13739a = (int) motionEvent.getRawX();
                                        cd.this.f13740b = (int) motionEvent.getRawY();
                                        cd.this.f46b = System.currentTimeMillis();
                                        Math.abs(motionEvent.getX() - cd.this.qaK);
                                        Math.abs(motionEvent.getY() - cd.this.qaL);
                                        if ((System.currentTimeMillis() - cd.this.pZL < 2000) && cd.this.pYM && cd.this.pZe != null && aw.a(cd.this.pZe, cd.this.pZf)) {
                                            cd.this.pZf = System.currentTimeMillis();
                                            aw.a(cd.this.pYJ, cd.this.pZe.getOpen(), cd.this.pZe, cd.this.pZg);
                                            w.a a2 = w.iK(cd.this.pYJ).a(new x(cd.this.pZe), (String) null);
                                            cd cdVar = cd.this;
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("dx", Integer.valueOf(cdVar.java));
                                            hashMap.put("dy", Integer.valueOf(cdVar.f47case));
                                            hashMap.put("dts", Long.valueOf(cdVar.f45a));
                                            hashMap.put("ux", Integer.valueOf(cdVar.f13739a));
                                            hashMap.put("uy", Integer.valueOf(cdVar.f13740b));
                                            hashMap.put("uts", Long.valueOf(cdVar.f46b));
                                            a2.hu("desc", hashMap.toString()).eGz();
                                            z.a(cd.this.pZe);
                                            if (cd.this.pYS != null) {
                                                cd.this.pYS.onClicked();
                                                break;
                                            }
                                        }
                                        break;
                                }
                                return true;
                            }
                        });
                    }
                    htmlWebView.pZx = new bo() { // from class: com.win.opensdk.cd.4
                        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [328=4] */
                        @Override // com.win.opensdk.bo
                        public final boolean ht(String str, String str2) {
                            if (aw.a(cd.this.pZe, cd.this.pZf)) {
                                cd.this.pZf = System.currentTimeMillis();
                                aw.a(cd.this.pYJ, str, cd.this.pZe, cd.this.pZg);
                                w.iK(cd.this.pYJ).a(new x(cd.this.pZe), str).hu("desc", str2).eGz();
                                if (cd.this.pYS != null) {
                                    cd.this.pYS.onClicked();
                                }
                                z.a(cd.this.pZe);
                                return true;
                            }
                            return true;
                        }

                        @Override // com.win.opensdk.bo
                        public final void aaE(String str) {
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
                    if (!this.pZN.contains(view)) {
                        this.pZN.add(view);
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
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener, View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private int f13741a;

        /* renamed from: b  reason: collision with root package name */
        private int f13742b;

        /* renamed from: case  reason: not valid java name */
        private int f49case;
        private int java;
        private long pZL;
        private long pZf;

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
                    this.pZf = System.currentTimeMillis();
                    return false;
                case 1:
                    this.f13741a = (int) motionEvent.getRawX();
                    this.f13742b = (int) motionEvent.getRawY();
                    this.pZL = System.currentTimeMillis();
                    if (cd.this.pZe == null || !aw.a(cd.this.pZe, cd.this.pZf)) {
                        return false;
                    }
                    cd.this.pZf = System.currentTimeMillis();
                    aw.a(cd.this.pYJ, cd.this.pZe.getOpen(), cd.this.pZe, cd.this.pZg);
                    w.a a2 = w.iK(cd.this.pYJ).a(new x(cd.this.pZe), (String) null);
                    HashMap hashMap = new HashMap();
                    hashMap.put("dx", Integer.valueOf(this.java));
                    hashMap.put("dy", Integer.valueOf(this.f49case));
                    hashMap.put("dts", Long.valueOf(this.pZf));
                    hashMap.put("ux", Integer.valueOf(this.f13741a));
                    hashMap.put("uy", Integer.valueOf(this.f13742b));
                    hashMap.put("uts", Long.valueOf(this.pZL));
                    a2.hu("desc", hashMap.toString()).eGz();
                    z.a(cd.this.pZe);
                    if (cd.this.pYS != null) {
                        cd.this.pYS.onClicked();
                        return false;
                    }
                    return false;
                default:
                    return false;
            }
        }
    }

    public final void eGz() {
        try {
            for (View view : this.pZN) {
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
            this.pZN.clear();
            if (this.qaU != null) {
                this.qaU = null;
            }
        } catch (Exception e) {
        }
    }
}
