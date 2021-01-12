package com.win.opensdk;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PBNative {
    private String java;
    private Context pYI;
    private cd pYQ;
    private PBNativeListener pYR;

    public PBNative(Context context, String str) {
        this.pYI = context;
        this.java = str;
        this.pYQ = new cd(context, str);
        this.pYQ.pYR = new a();
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        this.pYR = pBNativeListener;
    }

    public void load() {
        if (this.pYQ != null) {
            cd cdVar = this.pYQ;
            if (cdVar.pZR == null) {
                return;
            }
            cdVar.pZR.eGz();
        }
    }

    public boolean isReady() {
        return this.pYQ != null && this.pYQ.m73java();
    }

    public String getHeadline() {
        if (this.pYQ != null) {
            cd cdVar = this.pYQ;
            return cdVar.m73java() ? cdVar.pZd.getTitle() : "";
        }
        return "";
    }

    public String getIcon() {
        if (this.pYQ != null) {
            cd cdVar = this.pYQ;
            return cdVar.m73java() ? cdVar.pZd.getIcon() : "";
        }
        return "";
    }

    public String getBody() {
        if (this.pYQ != null) {
            cd cdVar = this.pYQ;
            return cdVar.m73java() ? cdVar.pZd.getDesc() : "";
        }
        return "";
    }

    public String getCallToAction() {
        if (this.pYQ != null) {
            cd cdVar = this.pYQ;
            return cdVar.m73java() ? cdVar.pZd.getBtndesc() : "";
        }
        return "";
    }

    public int getMediaViewHeight() {
        if (this.pYQ != null) {
            cd cdVar = this.pYQ;
            if (cdVar.m73java()) {
                return cdVar.pZd.getH();
            }
            return 0;
        }
        return 0;
    }

    public int getMediaViewWidth() {
        if (this.pYQ != null) {
            cd cdVar = this.pYQ;
            if (cdVar.m73java()) {
                return cdVar.pZd.getW();
            }
            return 0;
        }
        return 0;
    }

    public String getPid() {
        if (this.pYQ != null) {
            cd cdVar = this.pYQ;
            return cdVar.m73java() ? cdVar.pZd.getPid() : "";
        }
        return "";
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView) {
        if (this.pYQ != null) {
            cd cdVar = this.pYQ;
            List<View> arrayList = new ArrayList<>();
            if (view != null) {
                arrayList = cdVar.ez(view);
            }
            cdVar.a(view, pBMediaView, arrayList);
        }
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView, List<View> list) {
        if (this.pYQ != null) {
            this.pYQ.a(view, pBMediaView, list);
        }
    }

    public void destroy() {
        try {
            if (this.pYQ != null) {
                cd cdVar = this.pYQ;
                try {
                    cdVar.eGz();
                    if (cdVar.pZR != null) {
                        cdVar.pZR.eGA();
                        cdVar.pZR = null;
                    }
                    if (cdVar.pYR != null) {
                        cdVar.pYR = null;
                    }
                } catch (Exception e) {
                }
                this.pYQ = null;
            }
            if (this.pYR != null) {
                this.pYR = null;
            }
        } catch (Exception e2) {
        }
    }

    /* loaded from: classes3.dex */
    class a implements PBNativeListener {
        a() {
        }

        @Override // com.win.opensdk.PBNativeListener
        public final void onDisplayed() {
            if (PBNative.this.pYR != null) {
                PBNative.this.pYR.onDisplayed();
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onFail(PBError pBError) {
            if (PBNative.this.pYR != null) {
                PBNative.this.pYR.onFail(pBError);
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onLoaded() {
            if (PBNative.this.pYR != null) {
                PBNative.this.pYR.onLoaded();
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onClicked() {
            if (PBNative.this.pYR != null) {
                PBNative.this.pYR.onClicked();
            }
        }
    }
}
