package com.kascend.chushou.widget.gifts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes6.dex */
public class CirclePageIndicator extends View implements e {

    /* renamed from: a  reason: collision with root package name */
    private float f4273a;
    private final Paint b;
    private final Paint c;
    private final Paint d;
    private int g;
    private int h;
    private float i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private float o;
    private int p;
    private ViewPager pCO;
    private ViewPager.OnPageChangeListener pCP;
    private boolean q;

    public void setCentered(boolean z) {
        this.l = z;
        invalidate();
    }

    public void setPageColor(int i) {
        this.b.setColor(i);
        invalidate();
    }

    public int getPageColor() {
        return this.b.getColor();
    }

    public void setFillColor(int i) {
        this.d.setColor(i);
        invalidate();
    }

    public int getFillColor() {
        return this.d.getColor();
    }

    public void setOrientation(int i) {
        switch (i) {
            case 0:
            case 1:
                this.k = i;
                requestLayout();
                return;
            default:
                throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
    }

    public int getOrientation() {
        return this.k;
    }

    public void setStrokeColor(int i) {
        this.c.setColor(i);
        invalidate();
    }

    public int getStrokeColor() {
        return this.c.getColor();
    }

    public void setStrokeWidth(float f) {
        this.c.setStrokeWidth(f);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.c.getStrokeWidth();
    }

    public void setRadius(float f) {
        this.f4273a = f;
        invalidate();
    }

    public float getRadius() {
        return this.f4273a;
    }

    public void setSnap(boolean z) {
        this.m = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int count;
        int height;
        int paddingTop;
        int paddingBottom;
        int paddingLeft;
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.pCO != null && (count = this.pCO.getAdapter().getCount()) != 0) {
            if (this.g >= count) {
                setCurrentItem(count - 1);
                return;
            }
            if (this.k == 0) {
                height = getWidth();
                paddingTop = getPaddingLeft();
                paddingBottom = getPaddingRight();
                paddingLeft = getPaddingTop();
            } else {
                height = getHeight();
                paddingTop = getPaddingTop();
                paddingBottom = getPaddingBottom();
                paddingLeft = getPaddingLeft();
            }
            float f3 = this.f4273a * 4.666667f;
            float f4 = this.f4273a + paddingLeft;
            float f5 = paddingTop + ((this.f4273a * 8.0f) / 3.0f);
            if (this.l) {
                f5 += (((height - paddingTop) - paddingBottom) / 2.0f) - ((count * f3) / 2.0f);
            }
            float f6 = this.f4273a;
            if (this.c.getStrokeWidth() > 0.0f) {
                f6 -= this.c.getStrokeWidth() / 2.0f;
            }
            for (int i = 0; i < count; i++) {
                float f7 = (i * f3) + f5;
                if (this.k == 0) {
                    f2 = f7;
                    f7 = f4;
                } else {
                    f2 = f4;
                }
                if (this.b.getAlpha() > 0) {
                    canvas.drawCircle(f2, f7, f6, this.b);
                }
                if (f6 != this.f4273a) {
                    canvas.drawCircle(f2, f7, this.f4273a, this.c);
                }
            }
            float f8 = (this.m ? this.h : this.g) * f3;
            if (!this.m) {
                f8 += this.i * f3;
            }
            if (this.k == 0) {
                f = f5 + f8;
            } else {
                float f9 = f5 + f8;
                f = f4;
                f4 = f9;
            }
            canvas.drawCircle(f, f4, this.f4273a, this.d);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.pCO == null || this.pCO.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                this.p = MotionEventCompat.getPointerId(motionEvent, 0);
                this.o = motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.q) {
                    int count = this.pCO.getAdapter().getCount();
                    int width = getWidth();
                    float f = width / 2.0f;
                    float f2 = width / 6.0f;
                    if (this.g > 0 && motionEvent.getX() < f - f2) {
                        if (action != 3) {
                            this.pCO.setCurrentItem(this.g - 1);
                            return true;
                        }
                        return true;
                    } else if (this.g < count - 1 && motionEvent.getX() > f2 + f) {
                        if (action != 3) {
                            this.pCO.setCurrentItem(this.g + 1);
                            return true;
                        }
                        return true;
                    }
                }
                this.q = false;
                this.p = -1;
                if (this.pCO.isFakeDragging()) {
                    this.pCO.endFakeDrag();
                    return true;
                }
                return true;
            case 2:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.p));
                float f3 = x - this.o;
                if (!this.q && Math.abs(f3) > this.n) {
                    this.q = true;
                }
                if (this.q) {
                    this.o = x;
                    if (this.pCO.isFakeDragging() || this.pCO.beginFakeDrag()) {
                        this.pCO.fakeDragBy(f3);
                        return true;
                    }
                    return true;
                }
                return true;
            case 4:
            default:
                return true;
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.o = MotionEventCompat.getX(motionEvent, actionIndex);
                this.p = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                return true;
            case 6:
                int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, actionIndex2) == this.p) {
                    this.p = MotionEventCompat.getPointerId(motionEvent, actionIndex2 == 0 ? 1 : 0);
                }
                this.o = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.p));
                return true;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.pCO != viewPager) {
            if (this.pCO != null) {
                this.pCO.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.pCO = viewPager;
            this.pCO.setOnPageChangeListener(this);
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        if (this.pCO == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.pCO.setCurrentItem(i);
        this.g = i;
        invalidate();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        this.j = i;
        if (this.pCP != null) {
            this.pCP.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.g = i;
        this.i = f;
        invalidate();
        if (this.pCP != null) {
            this.pCP.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.m || this.j == 0) {
            this.g = i;
            this.h = i;
            invalidate();
        }
        if (this.pCP != null) {
            this.pCP.onPageSelected(i);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.pCP = onPageChangeListener;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.k == 0) {
            setMeasuredDimension(a(i), b(i2));
        } else {
            setMeasuredDimension(b(i), a(i2));
        }
    }

    private int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824 || this.pCO == null) {
            return size;
        }
        int count = this.pCO.getAdapter().getCount();
        int paddingLeft = (int) (((((count - 1) * this.f4273a) * 8.0f) / 3.0f) + getPaddingLeft() + getPaddingRight() + (count * 2 * this.f4273a) + 1.0f);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(paddingLeft, size);
        }
        return paddingLeft;
    }

    private int b(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int paddingTop = (int) ((2.0f * this.f4273a) + getPaddingTop() + getPaddingBottom() + 1.0f);
            return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
        }
        return size;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.g = savedState.f4274a;
        this.h = savedState.f4274a;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4274a = this.g;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.kascend.chushou.widget.gifts.CirclePageIndicator.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: at */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Ry */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f4274a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4274a = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4274a);
        }
    }
}
