package com.win.opensdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class t0 {

    /* renamed from: a  reason: collision with root package name */
    public View f40415a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40416b;

    /* renamed from: c  reason: collision with root package name */
    public s0 f40417c;

    /* renamed from: d  reason: collision with root package name */
    public Info f40418d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f40419e = new q0(this, Looper.getMainLooper());

    public void a(View view, Info info, s0 s0Var) {
        this.f40415a = view;
        this.f40417c = s0Var;
        this.f40418d = info;
        try {
            if (!this.f40416b) {
                this.f40419e.sendEmptyMessage(1101);
            }
            this.f40415a.getViewTreeObserver().addOnScrollChangedListener(new r0(this, s0Var));
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
        if (view.getGlobalVisibleRect(rect) && this.f40418d != null) {
            if (rect.width() >= this.f40418d.getSper() * view.getMeasuredWidth()) {
                if (rect.height() >= this.f40418d.getSper() * view.getMeasuredHeight()) {
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
