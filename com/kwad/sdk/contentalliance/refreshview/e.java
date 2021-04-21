package com.kwad.sdk.contentalliance.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class e extends RefreshLayout {
    public e(Context context) {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (f.a()) {
            setRefreshInitialOffset((-ao.a(context)) - ao.a(context, 30.0f));
        }
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_shoot_refresh_view, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.ksad_slide_shoot_refresh_view);
        this.f33343d = findViewById;
        findViewById.setVisibility(8);
        View view = this.f33343d;
        if (!(view instanceof d)) {
            throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
        }
        this.f33344e = (d) view;
    }

    public void a(MotionEvent motionEvent) {
        if (e()) {
            return;
        }
        super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public View b(AttributeSet attributeSet) {
        return null;
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public b b() {
        return new a(getContext());
    }

    public void b(MotionEvent motionEvent) {
        if (e()) {
            return;
        }
        super.onTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
