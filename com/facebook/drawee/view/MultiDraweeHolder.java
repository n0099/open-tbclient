package com.facebook.drawee.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class MultiDraweeHolder<DH extends DraweeHierarchy> {
    @VisibleForTesting
    public boolean mIsAttached = false;
    @VisibleForTesting
    public ArrayList<DraweeHolder<DH>> mHolders = new ArrayList<>();

    public void add(DraweeHolder<DH> draweeHolder) {
        add(this.mHolders.size(), draweeHolder);
    }

    public void clear() {
        if (this.mIsAttached) {
            for (int i2 = 0; i2 < this.mHolders.size(); i2++) {
                this.mHolders.get(i2).onDetach();
            }
        }
        this.mHolders.clear();
    }

    public void draw(Canvas canvas) {
        for (int i2 = 0; i2 < this.mHolders.size(); i2++) {
            Drawable topLevelDrawable = get(i2).getTopLevelDrawable();
            if (topLevelDrawable != null) {
                topLevelDrawable.draw(canvas);
            }
        }
    }

    public DraweeHolder<DH> get(int i2) {
        return this.mHolders.get(i2);
    }

    public void onAttach() {
        if (this.mIsAttached) {
            return;
        }
        this.mIsAttached = true;
        for (int i2 = 0; i2 < this.mHolders.size(); i2++) {
            this.mHolders.get(i2).onAttach();
        }
    }

    public void onDetach() {
        if (this.mIsAttached) {
            this.mIsAttached = false;
            for (int i2 = 0; i2 < this.mHolders.size(); i2++) {
                this.mHolders.get(i2).onDetach();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        for (int i2 = 0; i2 < this.mHolders.size(); i2++) {
            if (this.mHolders.get(i2).onTouchEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public void remove(int i2) {
        DraweeHolder<DH> draweeHolder = this.mHolders.get(i2);
        if (this.mIsAttached) {
            draweeHolder.onDetach();
        }
        this.mHolders.remove(i2);
    }

    public int size() {
        return this.mHolders.size();
    }

    public boolean verifyDrawable(Drawable drawable) {
        for (int i2 = 0; i2 < this.mHolders.size(); i2++) {
            if (drawable == get(i2).getTopLevelDrawable()) {
                return true;
            }
        }
        return false;
    }

    public void add(int i2, DraweeHolder<DH> draweeHolder) {
        Preconditions.checkNotNull(draweeHolder);
        Preconditions.checkElementIndex(i2, this.mHolders.size() + 1);
        this.mHolders.add(i2, draweeHolder);
        if (this.mIsAttached) {
            draweeHolder.onAttach();
        }
    }
}
