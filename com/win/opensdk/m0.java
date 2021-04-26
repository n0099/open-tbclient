package com.win.opensdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class m0 {

    /* renamed from: a  reason: collision with root package name */
    public View f37906a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37907b;

    /* renamed from: c  reason: collision with root package name */
    public l0 f37908c;

    /* renamed from: d  reason: collision with root package name */
    public Info f37909d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f37910e = new j0(this, Looper.getMainLooper());

    public void a(View view, Info info, l0 l0Var) {
        this.f37906a = view;
        this.f37908c = l0Var;
        this.f37909d = info;
        try {
            if (!this.f37907b) {
                this.f37910e.sendEmptyMessage(1101);
            }
            this.f37906a.getViewTreeObserver().addOnScrollChangedListener(new k0(this, l0Var));
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
        if (view.getGlobalVisibleRect(rect) && this.f37909d != null) {
            if (rect.width() >= this.f37909d.getSper() * view.getMeasuredWidth()) {
                if (rect.height() >= this.f37909d.getSper() * view.getMeasuredHeight()) {
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
