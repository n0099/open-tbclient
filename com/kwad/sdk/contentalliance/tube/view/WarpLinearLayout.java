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
    public int f34065a;

    /* renamed from: b  reason: collision with root package name */
    public float f34066b;

    /* renamed from: c  reason: collision with root package name */
    public float f34067c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34068d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f34069e;

    /* loaded from: classes6.dex */
    public final class a {

        /* renamed from: b  reason: collision with root package name */
        public List<View> f34071b;

        /* renamed from: c  reason: collision with root package name */
        public int f34072c;

        /* renamed from: d  reason: collision with root package name */
        public int f34073d;

        public a() {
            this.f34071b = new ArrayList();
            this.f34072c = WarpLinearLayout.this.getPaddingLeft() + WarpLinearLayout.this.getPaddingRight();
            this.f34073d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(View view) {
            if (this.f34071b.size() != 0) {
                this.f34072c = (int) (this.f34072c + WarpLinearLayout.this.f34066b);
            }
            this.f34073d = this.f34073d > view.getMeasuredHeight() ? this.f34073d : view.getMeasuredHeight();
            this.f34072c += view.getMeasuredWidth();
            this.f34071b.add(view);
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
        this.f34065a = 1;
        this.f34066b = ao.a(getContext(), 8.0f);
        this.f34067c = ao.a(getContext(), 8.0f);
    }

    public boolean a() {
        return this.f34068d;
    }

    public int getGrivate() {
        return this.f34065a;
    }

    public float getHorizontalSpace() {
        return this.f34066b;
    }

    public float getVerticalSpace() {
        return this.f34067c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        float f2;
        float measuredWidth;
        float f3;
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < this.f34069e.size(); i7++) {
            int paddingLeft = getPaddingLeft();
            a aVar = this.f34069e.get(i7);
            int measuredWidth2 = getMeasuredWidth() - aVar.f34072c;
            for (int i8 = 0; i8 < aVar.f34071b.size(); i8++) {
                View view = (View) aVar.f34071b.get(i8);
                if (a()) {
                    view.layout(paddingLeft, paddingTop, view.getMeasuredWidth() + paddingLeft + (measuredWidth2 / aVar.f34071b.size()), view.getMeasuredHeight() + paddingTop);
                    f2 = paddingLeft;
                    measuredWidth = view.getMeasuredWidth() + this.f34066b;
                    f3 = measuredWidth2 / aVar.f34071b.size();
                } else {
                    int grivate = getGrivate();
                    if (grivate == 0) {
                        i6 = paddingLeft + measuredWidth2;
                    } else if (grivate != 2) {
                        view.layout(paddingLeft, paddingTop, view.getMeasuredWidth() + paddingLeft, view.getMeasuredHeight() + paddingTop);
                        f2 = paddingLeft;
                        measuredWidth = view.getMeasuredWidth();
                        f3 = this.f34066b;
                    } else {
                        i6 = (measuredWidth2 / 2) + paddingLeft;
                    }
                    view.layout(i6, paddingTop, view.getMeasuredWidth() + i6, view.getMeasuredHeight() + paddingTop);
                    f2 = paddingLeft;
                    measuredWidth = view.getMeasuredWidth();
                    f3 = this.f34066b;
                }
                paddingLeft = (int) (f2 + measuredWidth + f3);
            }
            paddingTop = (int) (paddingTop + aVar.f34073d + this.f34067c);
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
                    i4 = (int) (i4 + this.f34066b);
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
                    i6 = (int) (i6 + this.f34066b);
                }
                i6 += getChildAt(i7).getMeasuredWidth();
            }
            size = i6 + getPaddingLeft() + getPaddingRight();
        }
        a aVar = new a();
        this.f34069e = new ArrayList();
        for (int i8 = 0; i8 < childCount; i8++) {
            if (aVar.f34072c + getChildAt(i8).getMeasuredWidth() + this.f34066b > size) {
                if (aVar.f34071b.size() == 0) {
                    aVar.a(getChildAt(i8));
                    this.f34069e.add(aVar);
                    aVar = new a();
                } else {
                    this.f34069e.add(aVar);
                    aVar = new a();
                }
            }
            aVar.a(getChildAt(i8));
        }
        if (aVar.f34071b.size() > 0 && !this.f34069e.contains(aVar)) {
            this.f34069e.add(aVar);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        for (int i9 = 0; i9 < this.f34069e.size(); i9++) {
            if (i9 != 0) {
                paddingTop = (int) (paddingTop + this.f34067c);
            }
            paddingTop += this.f34069e.get(i9).f34073d;
        }
        if (mode2 == Integer.MIN_VALUE ? paddingTop <= size2 : mode2 != 1073741824) {
            size2 = paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    public void setGrivate(int i2) {
        this.f34065a = i2;
    }

    public void setHorizontalSpace(float f2) {
        this.f34066b = f2;
    }

    public void setIsFull(boolean z) {
        this.f34068d = z;
    }

    public void setVerticalSpace(float f2) {
        this.f34067c = f2;
    }
}
