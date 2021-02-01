package com.win.opensdk;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PBNative {
    private String java;
    private Context qiN;
    private cd qiV;
    private PBNativeListener qiW;

    public PBNative(Context context, String str) {
        this.qiN = context;
        this.java = str;
        this.qiV = new cd(context, str);
        this.qiV.qiW = new a();
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        this.qiW = pBNativeListener;
    }

    public void load() {
        if (this.qiV != null) {
            cd cdVar = this.qiV;
            if (cdVar.qjW == null) {
                return;
            }
            cdVar.qjW.eIP();
        }
    }

    public boolean isReady() {
        return this.qiV != null && this.qiV.m73java();
    }

    public String getHeadline() {
        if (this.qiV != null) {
            cd cdVar = this.qiV;
            return cdVar.m73java() ? cdVar.qji.getTitle() : "";
        }
        return "";
    }

    public String getIcon() {
        if (this.qiV != null) {
            cd cdVar = this.qiV;
            return cdVar.m73java() ? cdVar.qji.getIcon() : "";
        }
        return "";
    }

    public String getBody() {
        if (this.qiV != null) {
            cd cdVar = this.qiV;
            return cdVar.m73java() ? cdVar.qji.getDesc() : "";
        }
        return "";
    }

    public String getCallToAction() {
        if (this.qiV != null) {
            cd cdVar = this.qiV;
            return cdVar.m73java() ? cdVar.qji.getBtndesc() : "";
        }
        return "";
    }

    public int getMediaViewHeight() {
        if (this.qiV != null) {
            cd cdVar = this.qiV;
            if (cdVar.m73java()) {
                return cdVar.qji.getH();
            }
            return 0;
        }
        return 0;
    }

    public int getMediaViewWidth() {
        if (this.qiV != null) {
            cd cdVar = this.qiV;
            if (cdVar.m73java()) {
                return cdVar.qji.getW();
            }
            return 0;
        }
        return 0;
    }

    public String getPid() {
        if (this.qiV != null) {
            cd cdVar = this.qiV;
            return cdVar.m73java() ? cdVar.qji.getPid() : "";
        }
        return "";
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView) {
        if (this.qiV != null) {
            cd cdVar = this.qiV;
            List<View> arrayList = new ArrayList<>();
            if (view != null) {
                arrayList = cdVar.ex(view);
            }
            cdVar.a(view, pBMediaView, arrayList);
        }
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView, List<View> list) {
        if (this.qiV != null) {
            this.qiV.a(view, pBMediaView, list);
        }
    }

    public void destroy() {
        try {
            if (this.qiV != null) {
                cd cdVar = this.qiV;
                try {
                    cdVar.eIP();
                    if (cdVar.qjW != null) {
                        cdVar.qjW.eIQ();
                        cdVar.qjW = null;
                    }
                    if (cdVar.qiW != null) {
                        cdVar.qiW = null;
                    }
                } catch (Exception e) {
                }
                this.qiV = null;
            }
            if (this.qiW != null) {
                this.qiW = null;
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
            if (PBNative.this.qiW != null) {
                PBNative.this.qiW.onDisplayed();
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onFail(PBError pBError) {
            if (PBNative.this.qiW != null) {
                PBNative.this.qiW.onFail(pBError);
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onLoaded() {
            if (PBNative.this.qiW != null) {
                PBNative.this.qiW.onLoaded();
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onClicked() {
            if (PBNative.this.qiW != null) {
                PBNative.this.qiW.onClicked();
            }
        }
    }
}
