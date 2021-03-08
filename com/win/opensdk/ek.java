package com.win.opensdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.baidu.mapapi.UIMsg;
import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class ek {

    /* renamed from: a  reason: collision with root package name */
    public View f8162a;
    public boolean b;
    public Handler e = new dz(this, Looper.getMainLooper());
    public eg qmj;
    public Info qmk;

    public void a(View view, Info info, eg egVar) {
        this.f8162a = view;
        this.qmj = egVar;
        this.qmk = info;
        try {
            if (!this.b) {
                this.e.sendEmptyMessage(UIMsg.f_FUN.FUN_ID_SCH_POI);
            }
            this.f8162a.getViewTreeObserver().addOnScrollChangedListener(new ec(this, egVar));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
        if ((!r11.getGlobalVisibleRect(r2) || r10.qmk == null || ((double) r2.width()) < ((double) r11.getMeasuredWidth()) * r10.qmk.getSper() || ((double) r2.height()) < ((double) r11.getMeasuredHeight()) * r10.qmk.getSper()) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(View view) {
        boolean z = true;
        if (view == null) {
            return false;
        }
        if (view.isShown()) {
            Rect rect = new Rect();
        }
        z = false;
        return z;
    }
}
