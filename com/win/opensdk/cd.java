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
    int f14038a;

    /* renamed from: a  reason: collision with other field name */
    long f45a;

    /* renamed from: b  reason: collision with root package name */
    int f14039b;

    /* renamed from: b  reason: collision with other field name */
    long f46b;

    /* renamed from: case  reason: not valid java name */
    int f47case;
    int java;

    /* renamed from: java  reason: collision with other field name */
    private String f48java;
    Context qbB;
    public PBNativeListener qbK;
    public Info qbW;
    bj qbY;
    public ad qcK;
    float qdC;
    float qdD;
    private View qdM;
    private List<View> qcF = Collections.synchronizedList(new ArrayList());
    long qbX = 0;
    private ae<Info> qcH = new ae<Info>() { // from class: com.win.opensdk.cd.1
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.win.opensdk.ae
        public final /* synthetic */ void bG(Info info) {
            Info info2 = info;
            try {
                cd.this.qbW = info2;
                if (cd.this.qbK != null) {
                    if (info2 != null && info2.getType() == 11) {
                        if (cd.this.m66java()) {
                            cd.this.qbK.onLoaded();
                        }
                    } else {
                        cd.this.qbK.onFail(PBError.PID_TYPE_ERROR);
                    }
                }
            } catch (Exception e) {
            }
        }

        @Override // com.win.opensdk.ae
        public final void b(PBError pBError) {
            if (cd.this.qbK != null) {
                cd.this.qbK.onFail(pBError);
            }
        }
    };
    boolean qbE = false;
    long qcD = 0;

    public cd(Context context, String str) {
        this.qbB = context;
        this.f48java = str;
        this.qcK = new ad(context, str, e.f14044a);
        this.qcK.qcH = this.qcH;
        this.qbY = new bj(context);
    }

    /* renamed from: java  reason: collision with other method in class */
    public final boolean m66java() {
        return this.qbW != null && this.qbW.isEffective();
    }

    private String java() {
        return m66java() ? this.qbW.getLoad() : "";
    }

    public final void a(final View view, PBMediaView pBMediaView, List<View> list) {
        if (view != null && list != null && list.size() != 0 && m66java()) {
            this.qbX = 0L;
            if (this.qdM != null) {
                eJL();
            }
            this.qdM = view;
            hf(list);
            a(pBMediaView);
            w.iM(this.qbB).a(new x(this.qbW)).eJL();
            if (this.qbK != null) {
                this.qbK.onDisplayed();
            }
            if (this.qbW != null) {
                az.k(this.qbB, this.qbW.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(this.qbW);
            new ce().a(view, this.qbW, new ce.a() { // from class: com.win.opensdk.cd.2
                @Override // com.win.opensdk.ce.a
                public final void eJL() {
                    if (view != null) {
                        new Handler().postDelayed(new Runnable() { // from class: com.win.opensdk.cd.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    View rootView = view.getRootView();
                                    if (rootView != null && rootView.getVisibility() == 0) {
                                        w.iM(cd.this.qbB).a(new x(cd.this.qbW), view.getWidth(), view.getHeight()).eJL();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, cd.this.qbW.getSpet());
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
                    htmlWebView.a(java(), this.qbW);
                    if (this.qbW.isNat()) {
                        htmlWebView.qde.setOnTouchListener(new View.OnTouchListener() { // from class: com.win.opensdk.cd.3
                            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [298=5] */
                            @Override // android.view.View.OnTouchListener
                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                switch (motionEvent.getAction()) {
                                    case 0:
                                        cd.this.qbE = true;
                                        cd.this.qcD = System.currentTimeMillis();
                                        cd.this.qdC = motionEvent.getX();
                                        cd.this.qdD = motionEvent.getY();
                                        cd.this.java = (int) motionEvent.getRawX();
                                        cd.this.f47case = (int) motionEvent.getRawY();
                                        cd.this.f45a = System.currentTimeMillis();
                                        break;
                                    case 1:
                                        cd.this.f14038a = (int) motionEvent.getRawX();
                                        cd.this.f14039b = (int) motionEvent.getRawY();
                                        cd.this.f46b = System.currentTimeMillis();
                                        Math.abs(motionEvent.getX() - cd.this.qdC);
                                        Math.abs(motionEvent.getY() - cd.this.qdD);
                                        if ((System.currentTimeMillis() - cd.this.qcD < 2000) && cd.this.qbE && cd.this.qbW != null && aw.a(cd.this.qbW, cd.this.qbX)) {
                                            cd.this.qbX = System.currentTimeMillis();
                                            aw.a(cd.this.qbB, cd.this.qbW.getOpen(), cd.this.qbW, cd.this.qbY);
                                            w.a a2 = w.iM(cd.this.qbB).a(new x(cd.this.qbW), (String) null);
                                            cd cdVar = cd.this;
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("dx", Integer.valueOf(cdVar.java));
                                            hashMap.put("dy", Integer.valueOf(cdVar.f47case));
                                            hashMap.put("dts", Long.valueOf(cdVar.f45a));
                                            hashMap.put("ux", Integer.valueOf(cdVar.f14038a));
                                            hashMap.put("uy", Integer.valueOf(cdVar.f14039b));
                                            hashMap.put("uts", Long.valueOf(cdVar.f46b));
                                            a2.hu("desc", hashMap.toString()).eJL();
                                            z.a(cd.this.qbW);
                                            if (cd.this.qbK != null) {
                                                cd.this.qbK.onClicked();
                                                break;
                                            }
                                        }
                                        break;
                                }
                                return true;
                            }
                        });
                    }
                    htmlWebView.qcp = new bo() { // from class: com.win.opensdk.cd.4
                        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [328=4] */
                        @Override // com.win.opensdk.bo
                        public final boolean ht(String str, String str2) {
                            if (aw.a(cd.this.qbW, cd.this.qbX)) {
                                cd.this.qbX = System.currentTimeMillis();
                                aw.a(cd.this.qbB, str, cd.this.qbW, cd.this.qbY);
                                w.iM(cd.this.qbB).a(new x(cd.this.qbW), str).hu("desc", str2).eJL();
                                if (cd.this.qbK != null) {
                                    cd.this.qbK.onClicked();
                                }
                                z.a(cd.this.qbW);
                                return true;
                            }
                            return true;
                        }

                        @Override // com.win.opensdk.bo
                        public final void abK(String str) {
                        }
                    };
                }
            } catch (Exception e) {
            }
        }
    }

    private void hf(List<View> list) {
        try {
            a aVar = new a();
            for (View view : list) {
                if (view != null && !(view instanceof PBMediaView)) {
                    if (!this.qcF.contains(view)) {
                        this.qcF.add(view);
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
        private int f14040a;

        /* renamed from: b  reason: collision with root package name */
        private int f14041b;

        /* renamed from: case  reason: not valid java name */
        private int f49case;
        private int java;
        private long qbX;
        private long qcD;

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
                    this.qbX = System.currentTimeMillis();
                    return false;
                case 1:
                    this.f14040a = (int) motionEvent.getRawX();
                    this.f14041b = (int) motionEvent.getRawY();
                    this.qcD = System.currentTimeMillis();
                    if (cd.this.qbW == null || !aw.a(cd.this.qbW, cd.this.qbX)) {
                        return false;
                    }
                    cd.this.qbX = System.currentTimeMillis();
                    aw.a(cd.this.qbB, cd.this.qbW.getOpen(), cd.this.qbW, cd.this.qbY);
                    w.a a2 = w.iM(cd.this.qbB).a(new x(cd.this.qbW), (String) null);
                    HashMap hashMap = new HashMap();
                    hashMap.put("dx", Integer.valueOf(this.java));
                    hashMap.put("dy", Integer.valueOf(this.f49case));
                    hashMap.put("dts", Long.valueOf(this.qbX));
                    hashMap.put("ux", Integer.valueOf(this.f14040a));
                    hashMap.put("uy", Integer.valueOf(this.f14041b));
                    hashMap.put("uts", Long.valueOf(this.qcD));
                    a2.hu("desc", hashMap.toString()).eJL();
                    z.a(cd.this.qbW);
                    if (cd.this.qbK != null) {
                        cd.this.qbK.onClicked();
                        return false;
                    }
                    return false;
                default:
                    return false;
            }
        }
    }

    public final void eJL() {
        try {
            for (View view : this.qcF) {
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
            this.qcF.clear();
            if (this.qdM != null) {
                this.qdM = null;
            }
        } catch (Exception e) {
        }
    }
}
