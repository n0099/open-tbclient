package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.kwad.components.core.s.d;
import com.kwad.sdk.core.webview.KsAdWebView;
/* loaded from: classes10.dex */
public class SplitScrollWebView extends KsAdWebView {
    public int PI;
    public boolean Qf;
    public a Qg;
    public float Qh;
    public boolean Qi;

    /* loaded from: classes10.dex */
    public interface a {
        void d(float f);

        boolean pN();
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.Qf = false;
        pH();
    }

    public void setDisableAnimation(boolean z) {
        this.Qf = z;
    }

    public void setSplitScrollWebViewListener(a aVar) {
        this.Qg = aVar;
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Qf = false;
        pH();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Qf = false;
        pH();
    }

    private void pH() {
        this.PI = 0;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int screenHeight;
        if (this.PI != 0) {
            if (d.qP()) {
                i3 = com.kwad.sdk.d.a.a.getStatusBarHeight(getContext());
            } else {
                i3 = 0;
            }
            if (getContext() instanceof Activity) {
                screenHeight = com.kwad.sdk.d.a.a.e((Activity) getContext());
            } else {
                screenHeight = com.kwad.sdk.d.a.a.getScreenHeight(getContext());
            }
            i2 = View.MeasureSpec.makeMeasureSpec((screenHeight - i3) - this.PI, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (this.Qf) {
            return super.onTouchEvent(obtain);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float y = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return false;
                    }
                } else {
                    float f = this.Qh;
                    float f2 = f - y;
                    a aVar = this.Qg;
                    if (aVar != null && y <= f) {
                        this.Qi = true;
                        aVar.d(f2);
                    }
                    return super.onTouchEvent(obtain);
                }
            }
            if (this.Qg == null) {
                return false;
            }
            if ((this.Qh - y < 0.0f && !this.Qi) || !this.Qg.pN()) {
                return false;
            }
            this.Qf = true;
            return false;
        }
        this.Qh = y;
        this.Qi = false;
        return super.onTouchEvent(motionEvent);
    }
}
