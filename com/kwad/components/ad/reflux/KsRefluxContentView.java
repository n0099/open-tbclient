package com.kwad.components.ad.reflux;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.core.e.b;
/* loaded from: classes8.dex */
public class KsRefluxContentView extends FrameLayout implements GestureDetector.OnGestureListener {
    public GestureDetector kE;
    public a kF;

    /* loaded from: classes8.dex */
    public interface a {
        boolean eC();

        boolean eD();
    }

    public KsRefluxContentView(@NonNull Context context) {
        super(context);
        L(context);
    }

    public KsRefluxContentView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        L(context);
    }

    public KsRefluxContentView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        L(context);
    }

    @RequiresApi(api = 21)
    public KsRefluxContentView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        L(context);
    }

    private void L(@NonNull Context context) {
        this.kE = new GestureDetector(context, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.kF;
        if (aVar == null || aVar.eC()) {
            b.d("KsRefluxContentView", "dispatchTouchEvent consumed");
            return super.dispatchTouchEvent(motionEvent);
        }
        b.d("KsRefluxContentView", "dispatchTouchEvent mGestureDetector onTouchEvent");
        this.kE.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        b.d("KsRefluxContentView", "onDown");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        b.d("KsRefluxContentView", "onFling");
        a aVar = this.kF;
        if (aVar != null) {
            return aVar.eD();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        b.d("KsRefluxContentView", "onLongPress");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        b.d("KsRefluxContentView", "onScroll");
        a aVar = this.kF;
        if (aVar != null) {
            return aVar.eD();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        b.d("KsRefluxContentView", "onShowPress");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        b.d("KsRefluxContentView", "onSingleTapUp");
        a aVar = this.kF;
        if (aVar != null) {
            return aVar.eD();
        }
        return false;
    }

    public void setContentViewListener(a aVar) {
        this.kF = aVar;
    }
}
