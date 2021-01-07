package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class n extends TouchDelegate {

    /* renamed from: a  reason: collision with root package name */
    private View f7894a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f7895b;
    private Rect c;
    private boolean d;
    private int e;

    public n(Rect rect, View view) {
        super(rect, view);
        this.f7895b = rect;
        this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.c = new Rect(rect);
        this.c.inset(-this.e, -this.e);
        this.f7894a = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                if (this.f7895b.contains(x, y)) {
                    this.d = true;
                    z2 = true;
                    z = true;
                    break;
                } else {
                    this.d = false;
                    z2 = true;
                    z = false;
                    break;
                }
            case 1:
            case 2:
                z = this.d;
                if (z) {
                    z2 = this.c.contains(x, y);
                    break;
                }
                z2 = true;
                break;
            case 3:
                z = this.d;
                this.d = false;
                z2 = true;
                break;
            default:
                z2 = true;
                z = false;
                break;
        }
        if (z) {
            View view = this.f7894a;
            if (z2) {
                motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
            } else {
                int i = this.e;
                motionEvent.setLocation(-(i * 2), -(i * 2));
            }
            if (view.getVisibility() == 0) {
                return view.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
