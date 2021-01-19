package com.win.opensdk;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PBNative {
    private String java;
    private Context pYJ;
    private cd pYR;
    private PBNativeListener pYS;

    public PBNative(Context context, String str) {
        this.pYJ = context;
        this.java = str;
        this.pYR = new cd(context, str);
        this.pYR.pYS = new a();
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        this.pYS = pBNativeListener;
    }

    public void load() {
        if (this.pYR != null) {
            cd cdVar = this.pYR;
            if (cdVar.pZS == null) {
                return;
            }
            cdVar.pZS.eGz();
        }
    }

    public boolean isReady() {
        return this.pYR != null && this.pYR.m73java();
    }

    public String getHeadline() {
        if (this.pYR != null) {
            cd cdVar = this.pYR;
            return cdVar.m73java() ? cdVar.pZe.getTitle() : "";
        }
        return "";
    }

    public String getIcon() {
        if (this.pYR != null) {
            cd cdVar = this.pYR;
            return cdVar.m73java() ? cdVar.pZe.getIcon() : "";
        }
        return "";
    }

    public String getBody() {
        if (this.pYR != null) {
            cd cdVar = this.pYR;
            return cdVar.m73java() ? cdVar.pZe.getDesc() : "";
        }
        return "";
    }

    public String getCallToAction() {
        if (this.pYR != null) {
            cd cdVar = this.pYR;
            return cdVar.m73java() ? cdVar.pZe.getBtndesc() : "";
        }
        return "";
    }

    public int getMediaViewHeight() {
        if (this.pYR != null) {
            cd cdVar = this.pYR;
            if (cdVar.m73java()) {
                return cdVar.pZe.getH();
            }
            return 0;
        }
        return 0;
    }

    public int getMediaViewWidth() {
        if (this.pYR != null) {
            cd cdVar = this.pYR;
            if (cdVar.m73java()) {
                return cdVar.pZe.getW();
            }
            return 0;
        }
        return 0;
    }

    public String getPid() {
        if (this.pYR != null) {
            cd cdVar = this.pYR;
            return cdVar.m73java() ? cdVar.pZe.getPid() : "";
        }
        return "";
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView) {
        if (this.pYR != null) {
            cd cdVar = this.pYR;
            List<View> arrayList = new ArrayList<>();
            if (view != null) {
                arrayList = cdVar.ez(view);
            }
            cdVar.a(view, pBMediaView, arrayList);
        }
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView, List<View> list) {
        if (this.pYR != null) {
            this.pYR.a(view, pBMediaView, list);
        }
    }

    public void destroy() {
        try {
            if (this.pYR != null) {
                cd cdVar = this.pYR;
                try {
                    cdVar.eGz();
                    if (cdVar.pZS != null) {
                        cdVar.pZS.eGA();
                        cdVar.pZS = null;
                    }
                    if (cdVar.pYS != null) {
                        cdVar.pYS = null;
                    }
                } catch (Exception e) {
                }
                this.pYR = null;
            }
            if (this.pYS != null) {
                this.pYS = null;
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
            if (PBNative.this.pYS != null) {
                PBNative.this.pYS.onDisplayed();
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onFail(PBError pBError) {
            if (PBNative.this.pYS != null) {
                PBNative.this.pYS.onFail(pBError);
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onLoaded() {
            if (PBNative.this.pYS != null) {
                PBNative.this.pYS.onLoaded();
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onClicked() {
            if (PBNative.this.pYS != null) {
                PBNative.this.pYS.onClicked();
            }
        }
    }
}
