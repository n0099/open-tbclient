package com.win.opensdk;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PBNative {
    private String java;
    private Context qjn;
    private cd qjv;
    private PBNativeListener qjw;

    public PBNative(Context context, String str) {
        this.qjn = context;
        this.java = str;
        this.qjv = new cd(context, str);
        this.qjv.qjw = new a();
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        this.qjw = pBNativeListener;
    }

    public void load() {
        if (this.qjv != null) {
            cd cdVar = this.qjv;
            if (cdVar.qkw == null) {
                return;
            }
            cdVar.qkw.eIX();
        }
    }

    public boolean isReady() {
        return this.qjv != null && this.qjv.m72java();
    }

    public String getHeadline() {
        if (this.qjv != null) {
            cd cdVar = this.qjv;
            return cdVar.m72java() ? cdVar.qjI.getTitle() : "";
        }
        return "";
    }

    public String getIcon() {
        if (this.qjv != null) {
            cd cdVar = this.qjv;
            return cdVar.m72java() ? cdVar.qjI.getIcon() : "";
        }
        return "";
    }

    public String getBody() {
        if (this.qjv != null) {
            cd cdVar = this.qjv;
            return cdVar.m72java() ? cdVar.qjI.getDesc() : "";
        }
        return "";
    }

    public String getCallToAction() {
        if (this.qjv != null) {
            cd cdVar = this.qjv;
            return cdVar.m72java() ? cdVar.qjI.getBtndesc() : "";
        }
        return "";
    }

    public int getMediaViewHeight() {
        if (this.qjv != null) {
            cd cdVar = this.qjv;
            if (cdVar.m72java()) {
                return cdVar.qjI.getH();
            }
            return 0;
        }
        return 0;
    }

    public int getMediaViewWidth() {
        if (this.qjv != null) {
            cd cdVar = this.qjv;
            if (cdVar.m72java()) {
                return cdVar.qjI.getW();
            }
            return 0;
        }
        return 0;
    }

    public String getPid() {
        if (this.qjv != null) {
            cd cdVar = this.qjv;
            return cdVar.m72java() ? cdVar.qjI.getPid() : "";
        }
        return "";
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView) {
        if (this.qjv != null) {
            cd cdVar = this.qjv;
            List<View> arrayList = new ArrayList<>();
            if (view != null) {
                arrayList = cdVar.ex(view);
            }
            cdVar.a(view, pBMediaView, arrayList);
        }
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView, List<View> list) {
        if (this.qjv != null) {
            this.qjv.a(view, pBMediaView, list);
        }
    }

    public void destroy() {
        try {
            if (this.qjv != null) {
                cd cdVar = this.qjv;
                try {
                    cdVar.eIX();
                    if (cdVar.qkw != null) {
                        cdVar.qkw.eIY();
                        cdVar.qkw = null;
                    }
                    if (cdVar.qjw != null) {
                        cdVar.qjw = null;
                    }
                } catch (Exception e) {
                }
                this.qjv = null;
            }
            if (this.qjw != null) {
                this.qjw = null;
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
            if (PBNative.this.qjw != null) {
                PBNative.this.qjw.onDisplayed();
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onFail(PBError pBError) {
            if (PBNative.this.qjw != null) {
                PBNative.this.qjw.onFail(pBError);
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onLoaded() {
            if (PBNative.this.qjw != null) {
                PBNative.this.qjw.onLoaded();
            }
        }

        @Override // com.win.opensdk.PBListener
        public final void onClicked() {
            if (PBNative.this.qjw != null) {
                PBNative.this.qjw.onClicked();
            }
        }
    }
}
