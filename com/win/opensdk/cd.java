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
    Context pYI;
    public PBNativeListener pYR;
    public ad pZR;
    public Info pZd;
    bj pZf;
    float qaJ;
    float qaK;
    private View qaT;
    private List<View> pZM = Collections.synchronizedList(new ArrayList());
    long pZe = 0;
    private ae<Info> pZO = new ae<Info>() { // from class: com.win.opensdk.cd.1
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.win.opensdk.ae
        public final /* synthetic */ void bH(Info info) {
            Info info2 = info;
            try {
                cd.this.pZd = info2;
                if (cd.this.pYR != null) {
                    if (info2 != null && info2.getType() == 11) {
                        if (cd.this.m73java()) {
                            cd.this.pYR.onLoaded();
                        }
                    } else {
                        cd.this.pYR.onFail(PBError.PID_TYPE_ERROR);
                    }
                }
            } catch (Exception e) {
            }
        }

        @Override // com.win.opensdk.ae
        public final void b(PBError pBError) {
            if (cd.this.pYR != null) {
                cd.this.pYR.onFail(pBError);
            }
        }
    };
    boolean pYL = false;
    long pZK = 0;

    public cd(Context context, String str) {
        this.pYI = context;
        this.f48java = str;
        this.pZR = new ad(context, str, e.f13745a);
        this.pZR.pZO = this.pZO;
        this.pZf = new bj(context);
    }

    /* renamed from: java  reason: collision with other method in class */
    public final boolean m73java() {
        return this.pZd != null && this.pZd.isEffective();
    }

    private String java() {
        return m73java() ? this.pZd.getLoad() : "";
    }

    public final void a(final View view, PBMediaView pBMediaView, List<View> list) {
        if (view != null && list != null && list.size() != 0 && m73java()) {
            this.pZe = 0L;
            if (this.qaT != null) {
                eGz();
            }
            this.qaT = view;
            hg(list);
            a(pBMediaView);
            w.iK(this.pYI).a(new x(this.pZd)).eGz();
            if (this.pYR != null) {
                this.pYR.onDisplayed();
            }
            if (this.pZd != null) {
                az.k(this.pYI, this.pZd.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(this.pZd);
            new ce().a(view, this.pZd, new ce.a() { // from class: com.win.opensdk.cd.2
                @Override // com.win.opensdk.ce.a
                public final void eGz() {
                    if (view != null) {
                        new Handler().postDelayed(new Runnable() { // from class: com.win.opensdk.cd.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    View rootView = view.getRootView();
                                    if (rootView != null && rootView.getVisibility() == 0) {
                                        w.iK(cd.this.pYI).a(new x(cd.this.pZd), view.getWidth(), view.getHeight()).eGz();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, cd.this.pZd.getSpet());
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
                    htmlWebView.a(java(), this.pZd);
                    if (this.pZd.isNat()) {
                        htmlWebView.qal.setOnTouchListener(new View.OnTouchListener() { // from class: com.win.opensdk.cd.3
                            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [298=5] */
                            @Override // android.view.View.OnTouchListener
                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                switch (motionEvent.getAction()) {
                                    case 0:
                                        cd.this.pYL = true;
                                        cd.this.pZK = System.currentTimeMillis();
                                        cd.this.qaJ = motionEvent.getX();
                                        cd.this.qaK = motionEvent.getY();
                                        cd.this.java = (int) motionEvent.getRawX();
                                        cd.this.f47case = (int) motionEvent.getRawY();
                                        cd.this.f45a = System.currentTimeMillis();
                                        break;
                                    case 1:
                                        cd.this.f13739a = (int) motionEvent.getRawX();
                                        cd.this.f13740b = (int) motionEvent.getRawY();
                                        cd.this.f46b = System.currentTimeMillis();
                                        Math.abs(motionEvent.getX() - cd.this.qaJ);
                                        Math.abs(motionEvent.getY() - cd.this.qaK);
                                        if ((System.currentTimeMillis() - cd.this.pZK < 2000) && cd.this.pYL && cd.this.pZd != null && aw.a(cd.this.pZd, cd.this.pZe)) {
                                            cd.this.pZe = System.currentTimeMillis();
                                            aw.a(cd.this.pYI, cd.this.pZd.getOpen(), cd.this.pZd, cd.this.pZf);
                                            w.a a2 = w.iK(cd.this.pYI).a(new x(cd.this.pZd), (String) null);
                                            cd cdVar = cd.this;
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("dx", Integer.valueOf(cdVar.java));
                                            hashMap.put("dy", Integer.valueOf(cdVar.f47case));
                                            hashMap.put("dts", Long.valueOf(cdVar.f45a));
                                            hashMap.put("ux", Integer.valueOf(cdVar.f13739a));
                                            hashMap.put("uy", Integer.valueOf(cdVar.f13740b));
                                            hashMap.put("uts", Long.valueOf(cdVar.f46b));
                                            a2.hu("desc", hashMap.toString()).eGz();
                                            z.a(cd.this.pZd);
                                            if (cd.this.pYR != null) {
                                                cd.this.pYR.onClicked();
                                                break;
                                            }
                                        }
                                        break;
                                }
                                return true;
                            }
                        });
                    }
                    htmlWebView.pZw = new bo() { // from class: com.win.opensdk.cd.4
                        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [328=4] */
                        @Override // com.win.opensdk.bo
                        public final boolean ht(String str, String str2) {
                            if (aw.a(cd.this.pZd, cd.this.pZe)) {
                                cd.this.pZe = System.currentTimeMillis();
                                aw.a(cd.this.pYI, str, cd.this.pZd, cd.this.pZf);
                                w.iK(cd.this.pYI).a(new x(cd.this.pZd), str).hu("desc", str2).eGz();
                                if (cd.this.pYR != null) {
                                    cd.this.pYR.onClicked();
                                }
                                z.a(cd.this.pZd);
                                return true;
                            }
                            return true;
                        }

                        @Override // com.win.opensdk.bo
                        public final void aaD(String str) {
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
                    if (!this.pZM.contains(view)) {
                        this.pZM.add(view);
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
        private long pZK;
        private long pZe;

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
                    this.pZe = System.currentTimeMillis();
                    return false;
                case 1:
                    this.f13741a = (int) motionEvent.getRawX();
                    this.f13742b = (int) motionEvent.getRawY();
                    this.pZK = System.currentTimeMillis();
                    if (cd.this.pZd == null || !aw.a(cd.this.pZd, cd.this.pZe)) {
                        return false;
                    }
                    cd.this.pZe = System.currentTimeMillis();
                    aw.a(cd.this.pYI, cd.this.pZd.getOpen(), cd.this.pZd, cd.this.pZf);
                    w.a a2 = w.iK(cd.this.pYI).a(new x(cd.this.pZd), (String) null);
                    HashMap hashMap = new HashMap();
                    hashMap.put("dx", Integer.valueOf(this.java));
                    hashMap.put("dy", Integer.valueOf(this.f49case));
                    hashMap.put("dts", Long.valueOf(this.pZe));
                    hashMap.put("ux", Integer.valueOf(this.f13741a));
                    hashMap.put("uy", Integer.valueOf(this.f13742b));
                    hashMap.put("uts", Long.valueOf(this.pZK));
                    a2.hu("desc", hashMap.toString()).eGz();
                    z.a(cd.this.pZd);
                    if (cd.this.pYR != null) {
                        cd.this.pYR.onClicked();
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
            for (View view : this.pZM) {
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
            this.pZM.clear();
            if (this.qaT != null) {
                this.qaT = null;
            }
        } catch (Exception e) {
        }
    }
}
