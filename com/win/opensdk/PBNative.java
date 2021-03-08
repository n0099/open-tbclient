package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.win.opensdk.core.Info;
import java.util.List;
/* loaded from: classes14.dex */
public class PBNative {

    /* renamed from: a  reason: collision with root package name */
    public dv f8103a;
    public PBNativeListener b;

    public PBNative(Context context, String str) {
        this.f8103a = new dv(context, str);
        this.f8103a.qlX = new cp(this);
    }

    public void destroy() {
        try {
            if (this.f8103a != null) {
                this.f8103a.a();
                this.f8103a = null;
            }
            if (this.b != null) {
                this.b = null;
            }
        } catch (Exception e) {
        }
    }

    public String getBody() {
        dv dvVar = this.f8103a;
        return (dvVar == null || !dvVar.b()) ? "" : dvVar.qkh.getDesc();
    }

    public String getCallToAction() {
        dv dvVar = this.f8103a;
        return (dvVar == null || !dvVar.b()) ? "" : dvVar.qkh.getBtndesc();
    }

    public String getHeadline() {
        dv dvVar = this.f8103a;
        return (dvVar == null || !dvVar.b()) ? "" : dvVar.qkh.getTitle();
    }

    public String getIM() {
        dv dvVar = this.f8103a;
        if (dvVar != null) {
            String image = dvVar.b() ? dvVar.qkh.getImage() : "";
            if (TextUtils.isEmpty(image)) {
                dv dvVar2 = this.f8103a;
                return dvVar2.b() ? dvVar2.qkh.getIcon() : "";
            }
            return image;
        }
        return "";
    }

    public String getIcon() {
        dv dvVar = this.f8103a;
        return (dvVar == null || !dvVar.b()) ? "" : dvVar.qkh.getIcon();
    }

    public int getMediaViewHeight() {
        dv dvVar = this.f8103a;
        if (dvVar == null || !dvVar.b()) {
            return 0;
        }
        return dvVar.qkh.getH();
    }

    public int getMediaViewWidth() {
        dv dvVar = this.f8103a;
        if (dvVar == null || !dvVar.b()) {
            return 0;
        }
        return dvVar.qkh.getW();
    }

    public String getPid() {
        dv dvVar = this.f8103a;
        return (dvVar == null || !dvVar.b()) ? "" : dvVar.qkh.getPid();
    }

    public boolean isD() {
        dv dvVar = this.f8103a;
        if (dvVar != null) {
            Info info = dvVar.qkh;
            if (info != null && info.getOpent() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isReady() {
        dv dvVar = this.f8103a;
        return dvVar != null && dvVar.b();
    }

    public void load() {
        dq dqVar;
        dv dvVar = this.f8103a;
        if (dvVar == null || (dqVar = dvVar.qlI) == null) {
            return;
        }
        dqVar.b();
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView) {
        dv dvVar = this.f8103a;
        if (dvVar != null) {
            dvVar.a(view, pBMediaView);
        }
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView, List list) {
        dv dvVar = this.f8103a;
        if (dvVar != null) {
            dvVar.a(view, pBMediaView, list);
        }
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        this.b = pBNativeListener;
    }
}
