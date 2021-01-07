package com.win.opensdk;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PBNative {
    private String java;
    private Context qdj;
    private cd qdr;
    private PBNativeListener qds;

    public PBNative(Context context, String str) {
        this.qdj = context;
        this.java = str;
        this.qdr = new cd(context, str);
        this.qdr.qds = new a();
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        this.qds = pBNativeListener;
    }

    public void load() {
        if (this.qdr != null) {
            cd cdVar = this.qdr;
            if (cdVar.qes == null) {
                return;
            }
            cdVar.qes.eKp();
        }
    }

    public boolean isReady() {
        return this.qdr != null && this.qdr.m77java();
    }

    public String getHeadline() {
        if (this.qdr != null) {
            cd cdVar = this.qdr;
            return cdVar.m77java() ? cdVar.qdE.getTitle() : "";
        }
        return "";
    }

    public String getIcon() {
        if (this.qdr != null) {
            cd cdVar = this.qdr;
            return cdVar.m77java() ? cdVar.qdE.getIcon() : "";
        }
        return "";
    }

    public String getBody() {
        if (this.qdr != null) {
            cd cdVar = this.qdr;
            return cdVar.m77java() ? cdVar.qdE.getDesc() : "";
        }
        return "";
    }

    public String getCallToAction() {
        if (this.qdr != null) {
            cd cdVar = this.qdr;
            return cdVar.m77java() ? cdVar.qdE.getBtndesc() : "";
        }
        return "";
    }

    public int getMediaViewHeight() {
        if (this.qdr != null) {
            cd cdVar = this.qdr;
            if (cdVar.m77java()) {
                return cdVar.qdE.getH();
            }
            return 0;
        }
        return 0;
    }

    public int getMediaViewWidth() {
        if (this.qdr != null) {
            cd cdVar = this.qdr;
            if (cdVar.m77java()) {
                return cdVar.qdE.getW();
            }
            return 0;
        }
        return 0;
    }

    public String getPid() {
        if (this.qdr != null) {
            cd cdVar = this.qdr;
            return cdVar.m77java() ? cdVar.qdE.getPid() : "";
        }
        return "";
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView) {
        if (this.qdr != null) {
            cd cdVar = this.qdr;
            List<View> arrayList = new ArrayList<>();
            if (view != null) {
                arrayList = cdVar.ez(view);
            }
            cdVar.a(view, pBMediaView, arrayList);
        }
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView, List<View> list) {
        if (this.qdr != null) {
            this.qdr.a(view, pBMediaView, list);
        }
    }

    public void destroy() {
        try {
            if (this.qdr != null) {
                cd cdVar = this.qdr;
                try {
                    cdVar.eKp();
                    if (cdVar.qes != null) {
                        cdVar.qes.eKq();
                        cdVar.qes = null;
                    }
                    if (cdVar.qds != null) {
                        cdVar.qds = null;
                    }
                } catch (Exception e) {
                }
                this.qdr = null;
            }
            if (this.qds != null) {
                this.qds = null;
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
            if (PBNative.this.qds != null) {
                PBNative.this.qds.onDisplayed();
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onFail(PBError pBError) {
            if (PBNative.this.qds != null) {
                PBNative.this.qds.onFail(pBError);
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onLoaded() {
            if (PBNative.this.qds != null) {
                PBNative.this.qds.onLoaded();
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onClicked() {
            if (PBNative.this.qds != null) {
                PBNative.this.qds.onClicked();
            }
        }
    }
}
