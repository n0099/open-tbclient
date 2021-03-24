package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.List;
/* loaded from: classes7.dex */
public class PBNative implements d {

    /* renamed from: a  reason: collision with root package name */
    public p0 f39757a;

    /* renamed from: b  reason: collision with root package name */
    public PBNativeListener f39758b;

    public PBNative(Context context, String str) {
        p0 p0Var = new p0(context, str);
        this.f39757a = p0Var;
        p0Var.f40009f = new f(this);
    }

    public void destroy() {
        try {
            if (this.f39757a != null) {
                this.f39757a.a();
                this.f39757a = null;
            }
            if (this.f39758b != null) {
                this.f39758b = null;
            }
        } catch (Exception unused) {
        }
    }

    public String getBody() {
        p0 p0Var = this.f39757a;
        return (p0Var == null || !p0Var.b()) ? "" : p0Var.f40006c.getDesc();
    }

    public String getCallToAction() {
        p0 p0Var = this.f39757a;
        return (p0Var == null || !p0Var.b()) ? "" : p0Var.f40006c.getBtndesc();
    }

    public String getHeadline() {
        p0 p0Var = this.f39757a;
        return (p0Var == null || !p0Var.b()) ? "" : p0Var.f40006c.getTitle();
    }

    public String getIM() {
        p0 p0Var = this.f39757a;
        if (p0Var != null) {
            String image = p0Var.b() ? p0Var.f40006c.getImage() : "";
            if (TextUtils.isEmpty(image)) {
                p0 p0Var2 = this.f39757a;
                return p0Var2.b() ? p0Var2.f40006c.getIcon() : "";
            }
            return image;
        }
        return "";
    }

    public String getIcon() {
        p0 p0Var = this.f39757a;
        return (p0Var == null || !p0Var.b()) ? "" : p0Var.f40006c.getIcon();
    }

    public int getMediaViewHeight() {
        p0 p0Var = this.f39757a;
        if (p0Var == null || !p0Var.b()) {
            return 0;
        }
        return p0Var.f40006c.getH();
    }

    public int getMediaViewWidth() {
        p0 p0Var = this.f39757a;
        if (p0Var == null || !p0Var.b()) {
            return 0;
        }
        return p0Var.f40006c.getW();
    }

    public String getPid() {
        p0 p0Var = this.f39757a;
        return (p0Var == null || !p0Var.b()) ? "" : p0Var.f40006c.getPid();
    }

    public boolean isD() {
        p0 p0Var = this.f39757a;
        if (p0Var != null) {
            Info info = p0Var.f40006c;
            return info != null && info.getOpent() == 1;
        }
        return false;
    }

    public boolean isReady() {
        p0 p0Var = this.f39757a;
        return p0Var != null && p0Var.b();
    }

    public void load() {
        n1 n1Var;
        p0 p0Var = this.f39757a;
        if (p0Var == null || (n1Var = p0Var.f40005b) == null) {
            return;
        }
        n1Var.b();
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView) {
        p0 p0Var = this.f39757a;
        if (p0Var != null) {
            p0Var.a(view, pBMediaView);
        }
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView, List list) {
        p0 p0Var = this.f39757a;
        if (p0Var != null) {
            p0Var.a(view, pBMediaView, list);
        }
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        this.f39758b = pBNativeListener;
    }
}
