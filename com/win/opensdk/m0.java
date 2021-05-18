package com.win.opensdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class m0 {

    /* renamed from: a  reason: collision with root package name */
    public View f37151a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37152b;

    /* renamed from: c  reason: collision with root package name */
    public l0 f37153c;

    /* renamed from: d  reason: collision with root package name */
    public Info f37154d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f37155e = new j0(this, Looper.getMainLooper());

    public void a(View view, Info info, l0 l0Var) {
        this.f37151a = view;
        this.f37153c = l0Var;
        this.f37154d = info;
        try {
            if (!this.f37152b) {
                this.f37155e.sendEmptyMessage(1101);
            }
            this.f37151a.getViewTreeObserver().addOnScrollChangedListener(new k0(this, l0Var));
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
        if (view.getGlobalVisibleRect(rect) && this.f37154d != null) {
            if (rect.width() >= this.f37154d.getSper() * view.getMeasuredWidth()) {
                if (rect.height() >= this.f37154d.getSper() * view.getMeasuredHeight()) {
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
