package com.mofamulu.tieba.map;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnTouchListener {
    final /* synthetic */ FreeNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FreeNearbyActivity freeNearbyActivity) {
        this.a = freeNearbyActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.a.y = true;
            return false;
        }
        return false;
    }
}
