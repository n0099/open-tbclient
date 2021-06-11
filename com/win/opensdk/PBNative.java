package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.List;
/* loaded from: classes7.dex */
public class PBNative implements d {

    /* renamed from: a  reason: collision with root package name */
    public i0 f40580a;

    /* renamed from: b  reason: collision with root package name */
    public PBNativeListener f40581b;

    public PBNative(Context context, String str) {
        i0 i0Var = new i0(context, str);
        this.f40580a = i0Var;
        i0Var.f40738f = new f(this);
    }

    public void destroy() {
        try {
            if (this.f40580a != null) {
                this.f40580a.a();
                this.f40580a = null;
            }
            if (this.f40581b != null) {
                this.f40581b = null;
            }
        } catch (Exception unused) {
        }
    }

    public String getBody() {
        i0 i0Var = this.f40580a;
        return (i0Var == null || !i0Var.b()) ? "" : i0Var.f40735c.getDesc();
    }

    public String getCallToAction() {
        i0 i0Var = this.f40580a;
        return (i0Var == null || !i0Var.b()) ? "" : i0Var.f40735c.getBtndesc();
    }

    public String getHeadline() {
        i0 i0Var = this.f40580a;
        return (i0Var == null || !i0Var.b()) ? "" : i0Var.f40735c.getTitle();
    }

    public String getIM() {
        i0 i0Var = this.f40580a;
        if (i0Var != null) {
            String image = i0Var.b() ? i0Var.f40735c.getImage() : "";
            if (TextUtils.isEmpty(image)) {
                i0 i0Var2 = this.f40580a;
                return i0Var2.b() ? i0Var2.f40735c.getIcon() : "";
            }
            return image;
        }
        return "";
    }

    public String getIcon() {
        i0 i0Var = this.f40580a;
        return (i0Var == null || !i0Var.b()) ? "" : i0Var.f40735c.getIcon();
    }

    public int getMediaViewHeight() {
        i0 i0Var = this.f40580a;
        if (i0Var == null || !i0Var.b()) {
            return 0;
        }
        return i0Var.f40735c.getH();
    }

    public int getMediaViewWidth() {
        i0 i0Var = this.f40580a;
        if (i0Var == null || !i0Var.b()) {
            return 0;
        }
        return i0Var.f40735c.getW();
    }

    public String getPid() {
        i0 i0Var = this.f40580a;
        return (i0Var == null || !i0Var.b()) ? "" : i0Var.f40735c.getPid();
    }

    public boolean isD() {
        i0 i0Var = this.f40580a;
        if (i0Var != null) {
            Info info = i0Var.f40735c;
            return info != null && info.getOpent() == 1;
        }
        return false;
    }

    public boolean isReady() {
        i0 i0Var = this.f40580a;
        return i0Var != null && i0Var.b();
    }

    public void load() {
        K0 k0;
        i0 i0Var = this.f40580a;
        if (i0Var == null || (k0 = i0Var.f40734b) == null) {
            return;
        }
        k0.b();
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView) {
        i0 i0Var = this.f40580a;
        if (i0Var != null) {
            i0Var.a(view, pBMediaView);
        }
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView, List list) {
        i0 i0Var = this.f40580a;
        if (i0Var != null) {
            i0Var.a(view, pBMediaView, list);
        }
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        this.f40581b = pBNativeListener;
    }
}
