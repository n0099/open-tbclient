package com.kwad.sdk.contentalliance.tube.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class WarpLinearLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f5992a;
    private float b;
    private float c;
    private boolean d;
    private List<a> e;

    /* loaded from: classes3.dex */
    private final class a {
        private List<View> b;
        private int c;
        private int d;

        private a() {
            this.b = new ArrayList();
            this.c = WarpLinearLayout.this.getPaddingLeft() + WarpLinearLayout.this.getPaddingRight();
            this.d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(View view) {
            if (this.b.size() != 0) {
                this.c = (int) (this.c + WarpLinearLayout.this.b);
            }
            this.d = this.d > view.getMeasuredHeight() ? this.d : view.getMeasuredHeight();
            this.c += view.getMeasuredWidth();
            this.b.add(view);
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
        this.f5992a = 1;
        this.b = ao.a(getContext(), 8.0f);
        this.c = ao.a(getContext(), 8.0f);
    }

    public boolean a() {
        return this.d;
    }

    public int getGrivate() {
        return this.f5992a;
    }

    public float getHorizontalSpace() {
        return this.b;
    }

    public float getVerticalSpace() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float measuredWidth;
        float f2;
        int paddingTop = getPaddingTop();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            int i7 = paddingTop;
            if (i6 >= this.e.size()) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            a aVar = this.e.get(i6);
            int measuredWidth2 = getMeasuredWidth() - aVar.c;
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 < aVar.b.size()) {
                    View view = (View) aVar.b.get(i9);
                    if (a()) {
                        view.layout(paddingLeft, i7, view.getMeasuredWidth() + paddingLeft + (measuredWidth2 / aVar.b.size()), view.getMeasuredHeight() + i7);
                        f = paddingLeft;
                        measuredWidth = view.getMeasuredWidth() + this.b;
                        f2 = measuredWidth2 / aVar.b.size();
                    } else {
                        switch (getGrivate()) {
                            case 0:
                                view.layout(paddingLeft + measuredWidth2, i7, paddingLeft + measuredWidth2 + view.getMeasuredWidth(), view.getMeasuredHeight() + i7);
                                break;
                            case 1:
                            default:
                                view.layout(paddingLeft, i7, view.getMeasuredWidth() + paddingLeft, view.getMeasuredHeight() + i7);
                                break;
                            case 2:
                                view.layout((measuredWidth2 / 2) + paddingLeft, i7, (measuredWidth2 / 2) + paddingLeft + view.getMeasuredWidth(), view.getMeasuredHeight() + i7);
                                break;
                        }
                        f = paddingLeft;
                        measuredWidth = view.getMeasuredWidth();
                        f2 = this.b;
                    }
                    paddingLeft = (int) (measuredWidth + f2 + f);
                    i8 = i9 + 1;
                }
            }
            paddingTop = (int) (aVar.d + this.c + i7);
            i5 = i6 + 1;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        measureChildren(i, i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                int i3 = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    if (i4 != 0) {
                        i3 = (int) (i3 + this.b);
                    }
                    i3 += getChildAt(i4).getMeasuredWidth();
                }
                int paddingLeft = i3 + getPaddingLeft() + getPaddingRight();
                if (paddingLeft > size) {
                    paddingLeft = size;
                }
                size = paddingLeft;
                break;
            case 0:
                int i5 = 0;
                for (int i6 = 0; i6 < childCount; i6++) {
                    if (i6 != 0) {
                        i5 = (int) (i5 + this.b);
                    }
                    i5 += getChildAt(i6).getMeasuredWidth();
                }
                size = getPaddingLeft() + getPaddingRight() + i5;
                break;
        }
        a aVar = new a();
        this.e = new ArrayList();
        for (int i7 = 0; i7 < childCount; i7++) {
            if (aVar.c + getChildAt(i7).getMeasuredWidth() + this.b <= size) {
                aVar.a(getChildAt(i7));
            } else if (aVar.b.size() == 0) {
                aVar.a(getChildAt(i7));
                this.e.add(aVar);
                aVar = new a();
            } else {
                this.e.add(aVar);
                aVar = new a();
                aVar.a(getChildAt(i7));
            }
        }
        if (aVar.b.size() > 0 && !this.e.contains(aVar)) {
            this.e.add(aVar);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        for (int i8 = 0; i8 < this.e.size(); i8++) {
            if (i8 != 0) {
                paddingTop = (int) (paddingTop + this.c);
            }
            paddingTop += this.e.get(i8).d;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                if (paddingTop > size2) {
                    paddingTop = size2;
                    break;
                }
                break;
            case 1073741824:
                paddingTop = size2;
                break;
        }
        setMeasuredDimension(size, paddingTop);
    }

    public void setGrivate(int i) {
        this.f5992a = i;
    }

    public void setHorizontalSpace(float f) {
        this.b = f;
    }

    public void setIsFull(boolean z) {
        this.d = z;
    }

    public void setVerticalSpace(float f) {
        this.c = f;
    }
}
