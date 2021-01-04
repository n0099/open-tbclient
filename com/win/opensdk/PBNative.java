package com.win.opensdk;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PBNative {
    private String java;
    private Context qbB;
    private cd qbJ;
    private PBNativeListener qbK;

    public PBNative(Context context, String str) {
        this.qbB = context;
        this.java = str;
        this.qbJ = new cd(context, str);
        this.qbJ.qbK = new a();
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        this.qbK = pBNativeListener;
    }

    public void load() {
        if (this.qbJ != null) {
            cd cdVar = this.qbJ;
            if (cdVar.qcK == null) {
                return;
            }
            cdVar.qcK.eJL();
        }
    }

    public boolean isReady() {
        return this.qbJ != null && this.qbJ.m66java();
    }

    public String getHeadline() {
        if (this.qbJ != null) {
            cd cdVar = this.qbJ;
            return cdVar.m66java() ? cdVar.qbW.getTitle() : "";
        }
        return "";
    }

    public String getIcon() {
        if (this.qbJ != null) {
            cd cdVar = this.qbJ;
            return cdVar.m66java() ? cdVar.qbW.getIcon() : "";
        }
        return "";
    }

    public String getBody() {
        if (this.qbJ != null) {
            cd cdVar = this.qbJ;
            return cdVar.m66java() ? cdVar.qbW.getDesc() : "";
        }
        return "";
    }

    public String getCallToAction() {
        if (this.qbJ != null) {
            cd cdVar = this.qbJ;
            return cdVar.m66java() ? cdVar.qbW.getBtndesc() : "";
        }
        return "";
    }

    public int getMediaViewHeight() {
        if (this.qbJ != null) {
            cd cdVar = this.qbJ;
            if (cdVar.m66java()) {
                return cdVar.qbW.getH();
            }
            return 0;
        }
        return 0;
    }

    public int getMediaViewWidth() {
        if (this.qbJ != null) {
            cd cdVar = this.qbJ;
            if (cdVar.m66java()) {
                return cdVar.qbW.getW();
            }
            return 0;
        }
        return 0;
    }

    public String getPid() {
        if (this.qbJ != null) {
            cd cdVar = this.qbJ;
            return cdVar.m66java() ? cdVar.qbW.getPid() : "";
        }
        return "";
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView) {
        if (this.qbJ != null) {
            cd cdVar = this.qbJ;
            List<View> arrayList = new ArrayList<>();
            if (view != null) {
                arrayList = cdVar.ez(view);
            }
            cdVar.a(view, pBMediaView, arrayList);
        }
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView, List<View> list) {
        if (this.qbJ != null) {
            this.qbJ.a(view, pBMediaView, list);
        }
    }

    public void destroy() {
        try {
            if (this.qbJ != null) {
                cd cdVar = this.qbJ;
                try {
                    cdVar.eJL();
                    if (cdVar.qcK != null) {
                        cdVar.qcK.eJM();
                        cdVar.qcK = null;
                    }
                    if (cdVar.qbK != null) {
                        cdVar.qbK = null;
                    }
                } catch (Exception e) {
                }
                this.qbJ = null;
            }
            if (this.qbK != null) {
                this.qbK = null;
            }
        } catch (Exception e2) {
        }
    }

    /* loaded from: classes4.dex */
    class a implements PBNativeListener {
        a() {
        }

        @Override // com.win.opensdk.PBNativeListener
        public final void onDisplayed() {
            if (PBNative.this.qbK != null) {
                PBNative.this.qbK.onDisplayed();
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onFail(PBError pBError) {
            if (PBNative.this.qbK != null) {
                PBNative.this.qbK.onFail(pBError);
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onLoaded() {
            if (PBNative.this.qbK != null) {
                PBNative.this.qbK.onLoaded();
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onClicked() {
            if (PBNative.this.qbK != null) {
                PBNative.this.qbK.onClicked();
            }
        }
    }
}
