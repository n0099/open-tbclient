package com.win.opensdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class t0 {

    /* renamed from: a  reason: collision with root package name */
    public View f40031a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40032b;

    /* renamed from: c  reason: collision with root package name */
    public s0 f40033c;

    /* renamed from: d  reason: collision with root package name */
    public Info f40034d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f40035e = new q0(this, Looper.getMainLooper());

    public void a(View view, Info info, s0 s0Var) {
        this.f40031a = view;
        this.f40033c = s0Var;
        this.f40034d = info;
        try {
            if (!this.f40032b) {
                this.f40035e.sendEmptyMessage(1101);
            }
            this.f40031a.getViewTreeObserver().addOnScrollChangedListener(new r0(this, s0Var));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(View view) {
        boolean z;
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect) && this.f40034d != null) {
            if (rect.width() >= this.f40034d.getSper() * view.getMeasuredWidth()) {
                if (rect.height() >= this.f40034d.getSper() * view.getMeasuredHeight()) {
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
