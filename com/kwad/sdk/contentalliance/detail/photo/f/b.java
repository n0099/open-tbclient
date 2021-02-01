package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes3.dex */
class b {
    public static void a(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.c(view2);
                        return false;
                    case 1:
                        b.d(view2);
                        return false;
                    case 2:
                    default:
                        return false;
                    case 3:
                        b.d(view2);
                        return false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(View view) {
        if (view != null) {
            view.animate().cancel();
            view.animate().scaleX(0.8f).scaleY(0.8f).setDuration(100L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(View view) {
        if (view != null) {
            view.animate().cancel();
            view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100L).start();
        }
    }
}
