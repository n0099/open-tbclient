package com.win.opensdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class t0 {

    /* renamed from: a  reason: collision with root package name */
    public View f40030a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40031b;

    /* renamed from: c  reason: collision with root package name */
    public s0 f40032c;

    /* renamed from: d  reason: collision with root package name */
    public Info f40033d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f40034e = new q0(this, Looper.getMainLooper());

    public void a(View view, Info info, s0 s0Var) {
        this.f40030a = view;
        this.f40032c = s0Var;
        this.f40033d = info;
        try {
            if (!this.f40031b) {
                this.f40034e.sendEmptyMessage(1101);
            }
            this.f40030a.getViewTreeObserver().addOnScrollChangedListener(new r0(this, s0Var));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(View view) {
        Rect rect;
        boolean z;
        if (view == null || !view.isShown()) {
            return false;
        }
        if (view.getGlobalVisibleRect(new Rect()) && this.f40033d != null) {
            double measuredWidth = view.getMeasuredWidth();
            double sper = this.f40033d.getSper();
            Double.isNaN(measuredWidth);
            if (rect.width() >= sper * measuredWidth) {
                double measuredHeight = view.getMeasuredHeight();
                double sper2 = this.f40033d.getSper();
                Double.isNaN(measuredHeight);
                if (rect.height() >= sper2 * measuredHeight) {
                    z = false;
                    return z;
                }
            }
        }
        z = true;
        if (z) {
        }
    }
}
