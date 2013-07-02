package com.mofamulu.tieba.dslv;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.tieba.hp.DragSortListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        boolean z;
        boolean z2;
        DragSortListView dragSortListView;
        float f3;
        float f4;
        int i;
        DragSortListView dragSortListView2;
        int i2;
        DragSortListView dragSortListView3;
        z = this.a.d;
        if (z) {
            z2 = this.a.e;
            if (z2) {
                dragSortListView = this.a.w;
                int width = dragSortListView.getWidth() / 5;
                f3 = this.a.r;
                if (f <= f3) {
                    f4 = this.a.r;
                    if (f < (-f4)) {
                        i = this.a.x;
                        if (i < width) {
                            dragSortListView2 = this.a.w;
                            dragSortListView2.a(true, f);
                        }
                    }
                } else {
                    i2 = this.a.x;
                    if (i2 > (-width)) {
                        dragSortListView3 = this.a.w;
                        dragSortListView3.a(true, f);
                    }
                }
                this.a.e = false;
            }
        }
        return false;
    }
}
