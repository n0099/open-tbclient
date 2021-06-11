package com.kwad.sdk.contentalliance.tube.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class WarpLinearLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public int f33967a;

    /* renamed from: b  reason: collision with root package name */
    public float f33968b;

    /* renamed from: c  reason: collision with root package name */
    public float f33969c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33970d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f33971e;

    /* loaded from: classes6.dex */
    public final class a {

        /* renamed from: b  reason: collision with root package name */
        public List<View> f33973b;

        /* renamed from: c  reason: collision with root package name */
        public int f33974c;

        /* renamed from: d  reason: collision with root package name */
        public int f33975d;

        public a() {
            this.f33973b = new ArrayList();
            this.f33974c = WarpLinearLayout.this.getPaddingLeft() + WarpLinearLayout.this.getPaddingRight();
            this.f33975d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(View view) {
            if (this.f33973b.size() != 0) {
                this.f33974c = (int) (this.f33974c + WarpLinearLayout.this.f33968b);
            }
            this.f33975d = this.f33975d > view.getMeasuredHeight() ? this.f33975d : view.getMeasuredHeight();
            this.f33974c += view.getMeasuredWidth();
            this.f33973b.add(view);
        }
    }

    public WarpLinearLayout(Context context) {
        this(context, null);
    }

    public WarpLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WarpLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33967a = 1;
        this.f33968b = ao.a(getContext(), 8.0f);
        this.f33969c = ao.a(getContext(), 8.0f);
    }

    public boolean a() {
        return this.f33970d;
    }

    public int getGrivate() {
        return this.f33967a;
    }

    public float getHorizontalSpace() {
        return this.f33968b;
    }

    public float getVerticalSpace() {
        return this.f33969c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        float f2;
        float measuredWidth;
        float f3;
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < this.f33971e.size(); i7++) {
            int paddingLeft = getPaddingLeft();
            a aVar = this.f33971e.get(i7);
            int measuredWidth2 = getMeasuredWidth() - aVar.f33974c;
            for (int i8 = 0; i8 < aVar.f33973b.size(); i8++) {
                View view = (View) aVar.f33973b.get(i8);
                if (a()) {
                    view.layout(paddingLeft, paddingTop, view.getMeasuredWidth() + paddingLeft + (measuredWidth2 / aVar.f33973b.size()), view.getMeasuredHeight() + paddingTop);
                    f2 = paddingLeft;
                    measuredWidth = view.getMeasuredWidth() + this.f33968b;
                    f3 = measuredWidth2 / aVar.f33973b.size();
                } else {
                    int grivate = getGrivate();
                    if (grivate == 0) {
                        i6 = paddingLeft + measuredWidth2;
                    } else if (grivate != 2) {
                        view.layout(paddingLeft, paddingTop, view.getMeasuredWidth() + paddingLeft, view.getMeasuredHeight() + paddingTop);
                        f2 = paddingLeft;
                        measuredWidth = view.getMeasuredWidth();
                        f3 = this.f33968b;
                    } else {
                        i6 = (measuredWidth2 / 2) + paddingLeft;
                    }
                    view.layout(i6, paddingTop, view.getMeasuredWidth() + i6, view.getMeasuredHeight() + paddingTop);
                    f2 = paddingLeft;
                    measuredWidth = view.getMeasuredWidth();
                    f3 = this.f33968b;
                }
                paddingLeft = (int) (f2 + measuredWidth + f3);
            }
            paddingTop = (int) (paddingTop + aVar.f33975d + this.f33969c);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int childCount = getChildCount();
        measureChildren(i2, i3);
        if (mode == Integer.MIN_VALUE) {
            int i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                if (i5 != 0) {
                    i4 = (int) (i4 + this.f33968b);
                }
                i4 += getChildAt(i5).getMeasuredWidth();
            }
            int paddingLeft = i4 + getPaddingLeft() + getPaddingRight();
            if (paddingLeft <= size) {
                size = paddingLeft;
            }
        } else if (mode == 0) {
            int i6 = 0;
            for (int i7 = 0; i7 < childCount; i7++) {
                if (i7 != 0) {
                    i6 = (int) (i6 + this.f33968b);
                }
                i6 += getChildAt(i7).getMeasuredWidth();
            }
            size = i6 + getPaddingLeft() + getPaddingRight();
        }
        a aVar = new a();
        this.f33971e = new ArrayList();
        for (int i8 = 0; i8 < childCount; i8++) {
            if (aVar.f33974c + getChildAt(i8).getMeasuredWidth() + this.f33968b > size) {
                if (aVar.f33973b.size() == 0) {
                    aVar.a(getChildAt(i8));
                    this.f33971e.add(aVar);
                    aVar = new a();
                } else {
                    this.f33971e.add(aVar);
                    aVar = new a();
                }
            }
            aVar.a(getChildAt(i8));
        }
        if (aVar.f33973b.size() > 0 && !this.f33971e.contains(aVar)) {
            this.f33971e.add(aVar);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        for (int i9 = 0; i9 < this.f33971e.size(); i9++) {
            if (i9 != 0) {
                paddingTop = (int) (paddingTop + this.f33969c);
            }
            paddingTop += this.f33971e.get(i9).f33975d;
        }
        if (mode2 == Integer.MIN_VALUE ? paddingTop <= size2 : mode2 != 1073741824) {
            size2 = paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    public void setGrivate(int i2) {
        this.f33967a = i2;
    }

    public void setHorizontalSpace(float f2) {
        this.f33968b = f2;
    }

    public void setIsFull(boolean z) {
        this.f33970d = z;
    }

    public void setVerticalSpace(float f2) {
        this.f33969c = f2;
    }
}
