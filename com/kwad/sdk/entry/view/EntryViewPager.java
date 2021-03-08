package com.kwad.sdk.entry.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.contentalliance.widget.b;
import com.kwad.sdk.contentalliance.widget.e;
import com.kwad.sdk.utils.ao;
/* loaded from: classes3.dex */
public class EntryViewPager extends FrameLayout implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private com.kwad.sdk.contentalliance.widget.b f6486a;
    private TextView b;
    private b c;
    private boolean d;
    private c e;
    private boolean f;

    /* loaded from: classes3.dex */
    private class a extends PagerAdapter {
        private PagerAdapter b;

        a(PagerAdapter pagerAdapter) {
            this.b = pagerAdapter;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull View view, int i, @NonNull Object obj) {
            if (obj == EntryViewPager.this.b) {
                ((ViewGroup) view).removeView(EntryViewPager.this.b);
            } else {
                this.b.destroyItem(view, i, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            if (obj == EntryViewPager.this.b) {
                viewGroup.removeView(EntryViewPager.this.b);
            } else {
                this.b.destroyItem(viewGroup, i, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull View view) {
            this.b.finishUpdate(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull ViewGroup viewGroup) {
            this.b.finishUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.getCount() + 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            return this.b.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            return this.b.getPageTitle(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i) {
            if (i != getCount() - 1 || EntryViewPager.this.b == null) {
                return this.b.getPageWidth(i);
            }
            return 0.12f;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull View view, int i) {
            if (i == getCount() - 1) {
                ((ViewGroup) view).addView(EntryViewPager.this.b);
                return EntryViewPager.this.b;
            }
            return this.b.instantiateItem(view, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            if (i == getCount() - 1) {
                viewGroup.addView(EntryViewPager.this.b);
                return EntryViewPager.this.b;
            }
            return this.b.instantiateItem(viewGroup, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return this.b.isViewFromObject(view, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            this.b.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
            this.b.registerDataSetObserver(dataSetObserver);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
            this.b.restoreState(parcelable, classLoader);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public Parcelable saveState() {
            return this.b.saveState();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull View view, int i, @NonNull Object obj) {
            this.b.setPrimaryItem(view, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            this.b.setPrimaryItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NonNull View view) {
            this.b.startUpdate(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NonNull ViewGroup viewGroup) {
            this.b.startUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
            this.b.unregisterDataSetObserver(dataSetObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends e {
        private float b;
        private float[] c = new float[8];
        private boolean d;

        public b() {
            this.b = ao.a(EntryViewPager.this.getContext(), 4.0f);
            b();
        }

        private void b() {
            setColor(Color.parseColor("#FFF2F2F2"));
            a(ao.a(EntryViewPager.this.getContext(), 12.0f));
            a(Color.parseColor("#9c9c9c"));
            setCornerRadius(this.b);
        }

        public boolean a() {
            return this.d;
        }

        public void b(float f) {
            if (f <= 0.0f) {
                a("左\r\n滑\r\n查\r\n看\r\n更\r\n多\r\n视\r\n频");
                setCornerRadius(this.b);
                this.d = false;
                return;
            }
            float f2 = 4.5f * f;
            this.c[0] = f2;
            this.c[1] = f2;
            this.c[2] = this.b;
            this.c[3] = this.b;
            this.c[4] = this.b;
            this.c[5] = this.b;
            this.c[6] = f2;
            this.c[7] = f2;
            setCornerRadii(this.c);
            this.d = false;
            if (f2 >= (getBounds().height() * 2) / 3) {
                a("松\r\n开\n查\n看");
                this.d = true;
            }
            invalidateSelf();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    public EntryViewPager(@NonNull Context context) {
        super(context);
        this.f = true;
        a();
    }

    public EntryViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = true;
        a();
    }

    private void a() {
        this.f6486a = new com.kwad.sdk.contentalliance.widget.b(getContext());
        if (this.f) {
            this.f6486a.setDragListener(this);
        }
        addView(this.f6486a);
        this.b = new TextView(getContext());
        this.c = new b();
        this.c.b(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        int width = getWidth();
        int top = this.f6486a.getTop();
        int bottom = this.f6486a.getBottom();
        this.c.b(this.b.getWidth());
        this.c.setBounds((int) ((width - f) - this.b.getWidth()), top, width, bottom);
        this.c.b(f);
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(int i, float f) {
        final boolean z = this.c != null && this.c.a();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.entry.view.EntryViewPager.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                EntryViewPager.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                if (!z || valueAnimator.getAnimatedFraction() < 1.0f || EntryViewPager.this.e == null) {
                    return;
                }
                EntryViewPager.this.e.a();
            }
        });
        ofFloat.start();
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(int i, int i2, int i3, int i4) {
        if (this.b.getRight() <= 0) {
            this.d = false;
        } else if (i < this.b.getLeft() - this.f6486a.getMeasuredWidth()) {
            this.d = false;
        } else {
            this.d = true;
            int width = getWidth();
            int top = this.f6486a.getTop();
            int bottom = this.f6486a.getBottom();
            this.c.setBounds(width - (this.f6486a.getMeasuredWidth() - (this.b.getLeft() - i)), top, width, bottom);
        }
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(boolean z, int i, float f) {
        if (z || !this.d) {
            return;
        }
        a(f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.d) {
            this.c.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        if (this.f) {
            pagerAdapter = new a(pagerAdapter);
        }
        this.f6486a.setAdapter(pagerAdapter);
    }

    public void setDragSideEnable(boolean z) {
        this.f = z;
        if (z || this.f6486a == null) {
            return;
        }
        this.f6486a.setDragListener(null);
    }

    public void setOffscreenPageLimit(int i) {
        this.f6486a.setOffscreenPageLimit(i);
    }

    public void setOnDragOpenListener(c cVar) {
        this.e = cVar;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f6486a.setOnPageChangeListener(onPageChangeListener);
    }

    public void setPageMargin(int i) {
        this.f6486a.setPageMargin(i);
    }
}
