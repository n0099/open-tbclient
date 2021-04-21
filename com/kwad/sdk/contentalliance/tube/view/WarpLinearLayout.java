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
    public int f33735a;

    /* renamed from: b  reason: collision with root package name */
    public float f33736b;

    /* renamed from: c  reason: collision with root package name */
    public float f33737c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33738d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f33739e;

    /* loaded from: classes6.dex */
    public final class a {

        /* renamed from: b  reason: collision with root package name */
        public List<View> f33741b;

        /* renamed from: c  reason: collision with root package name */
        public int f33742c;

        /* renamed from: d  reason: collision with root package name */
        public int f33743d;

        public a() {
            this.f33741b = new ArrayList();
            this.f33742c = WarpLinearLayout.this.getPaddingLeft() + WarpLinearLayout.this.getPaddingRight();
            this.f33743d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(View view) {
            if (this.f33741b.size() != 0) {
                this.f33742c = (int) (this.f33742c + WarpLinearLayout.this.f33736b);
            }
            this.f33743d = this.f33743d > view.getMeasuredHeight() ? this.f33743d : view.getMeasuredHeight();
            this.f33742c += view.getMeasuredWidth();
            this.f33741b.add(view);
        }
    }

    public WarpLinearLayout(Context context) {
        this(context, null);
    }

    public WarpLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WarpLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33735a = 1;
        this.f33736b = ao.a(getContext(), 8.0f);
        this.f33737c = ao.a(getContext(), 8.0f);
    }

    public boolean a() {
        return this.f33738d;
    }

    public int getGrivate() {
        return this.f33735a;
    }

    public float getHorizontalSpace() {
        return this.f33736b;
    }

    public float getVerticalSpace() {
        return this.f33737c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        float f2;
        float measuredWidth;
        float f3;
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < this.f33739e.size(); i6++) {
            int paddingLeft = getPaddingLeft();
            a aVar = this.f33739e.get(i6);
            int measuredWidth2 = getMeasuredWidth() - aVar.f33742c;
            for (int i7 = 0; i7 < aVar.f33741b.size(); i7++) {
                View view = (View) aVar.f33741b.get(i7);
                if (a()) {
                    view.layout(paddingLeft, paddingTop, view.getMeasuredWidth() + paddingLeft + (measuredWidth2 / aVar.f33741b.size()), view.getMeasuredHeight() + paddingTop);
                    f2 = paddingLeft;
                    measuredWidth = view.getMeasuredWidth() + this.f33736b;
                    f3 = measuredWidth2 / aVar.f33741b.size();
                } else {
                    int grivate = getGrivate();
                    if (grivate == 0) {
                        i5 = paddingLeft + measuredWidth2;
                    } else if (grivate != 2) {
                        view.layout(paddingLeft, paddingTop, view.getMeasuredWidth() + paddingLeft, view.getMeasuredHeight() + paddingTop);
                        f2 = paddingLeft;
                        measuredWidth = view.getMeasuredWidth();
                        f3 = this.f33736b;
                    } else {
                        i5 = (measuredWidth2 / 2) + paddingLeft;
                    }
                    view.layout(i5, paddingTop, view.getMeasuredWidth() + i5, view.getMeasuredHeight() + paddingTop);
                    f2 = paddingLeft;
                    measuredWidth = view.getMeasuredWidth();
                    f3 = this.f33736b;
                }
                paddingLeft = (int) (f2 + measuredWidth + f3);
            }
            paddingTop = (int) (paddingTop + aVar.f33743d + this.f33737c);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        measureChildren(i, i2);
        if (mode == Integer.MIN_VALUE) {
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                if (i4 != 0) {
                    i3 = (int) (i3 + this.f33736b);
                }
                i3 += getChildAt(i4).getMeasuredWidth();
            }
            int paddingLeft = i3 + getPaddingLeft() + getPaddingRight();
            if (paddingLeft <= size) {
                size = paddingLeft;
            }
        } else if (mode == 0) {
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                if (i6 != 0) {
                    i5 = (int) (i5 + this.f33736b);
                }
                i5 += getChildAt(i6).getMeasuredWidth();
            }
            size = i5 + getPaddingLeft() + getPaddingRight();
        }
        a aVar = new a();
        this.f33739e = new ArrayList();
        for (int i7 = 0; i7 < childCount; i7++) {
            if (aVar.f33742c + getChildAt(i7).getMeasuredWidth() + this.f33736b > size) {
                if (aVar.f33741b.size() == 0) {
                    aVar.a(getChildAt(i7));
                    this.f33739e.add(aVar);
                    aVar = new a();
                } else {
                    this.f33739e.add(aVar);
                    aVar = new a();
                }
            }
            aVar.a(getChildAt(i7));
        }
        if (aVar.f33741b.size() > 0 && !this.f33739e.contains(aVar)) {
            this.f33739e.add(aVar);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        for (int i8 = 0; i8 < this.f33739e.size(); i8++) {
            if (i8 != 0) {
                paddingTop = (int) (paddingTop + this.f33737c);
            }
            paddingTop += this.f33739e.get(i8).f33743d;
        }
        if (mode2 == Integer.MIN_VALUE ? paddingTop <= size2 : mode2 != 1073741824) {
            size2 = paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    public void setGrivate(int i) {
        this.f33735a = i;
    }

    public void setHorizontalSpace(float f2) {
        this.f33736b = f2;
    }

    public void setIsFull(boolean z) {
        this.f33738d = z;
    }

    public void setVerticalSpace(float f2) {
        this.f33737c = f2;
    }
}
