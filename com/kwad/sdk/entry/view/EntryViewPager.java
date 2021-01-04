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
/* loaded from: classes5.dex */
public class EntryViewPager extends FrameLayout implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private com.kwad.sdk.contentalliance.widget.b f10092a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f10093b;
    private b c;
    private boolean d;
    private c e;
    private boolean f;

    /* loaded from: classes5.dex */
    private class a extends PagerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private PagerAdapter f10097b;

        a(PagerAdapter pagerAdapter) {
            this.f10097b = pagerAdapter;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull View view, int i, @NonNull Object obj) {
            if (obj == EntryViewPager.this.f10093b) {
                ((ViewGroup) view).removeView(EntryViewPager.this.f10093b);
            } else {
                this.f10097b.destroyItem(view, i, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            if (obj == EntryViewPager.this.f10093b) {
                viewGroup.removeView(EntryViewPager.this.f10093b);
            } else {
                this.f10097b.destroyItem(viewGroup, i, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull View view) {
            this.f10097b.finishUpdate(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull ViewGroup viewGroup) {
            this.f10097b.finishUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f10097b.getCount() + 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            return this.f10097b.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            return this.f10097b.getPageTitle(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i) {
            if (i != getCount() - 1 || EntryViewPager.this.f10093b == null) {
                return this.f10097b.getPageWidth(i);
            }
            return 0.12f;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull View view, int i) {
            if (i == getCount() - 1) {
                ((ViewGroup) view).addView(EntryViewPager.this.f10093b);
                return EntryViewPager.this.f10093b;
            }
            return this.f10097b.instantiateItem(view, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            if (i == getCount() - 1) {
                viewGroup.addView(EntryViewPager.this.f10093b);
                return EntryViewPager.this.f10093b;
            }
            return this.f10097b.instantiateItem(viewGroup, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return this.f10097b.isViewFromObject(view, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            this.f10097b.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
            this.f10097b.registerDataSetObserver(dataSetObserver);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
            this.f10097b.restoreState(parcelable, classLoader);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public Parcelable saveState() {
            return this.f10097b.saveState();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull View view, int i, @NonNull Object obj) {
            this.f10097b.setPrimaryItem(view, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            this.f10097b.setPrimaryItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NonNull View view) {
            this.f10097b.startUpdate(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NonNull ViewGroup viewGroup) {
            this.f10097b.startUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
            this.f10097b.unregisterDataSetObserver(dataSetObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends e {

        /* renamed from: b  reason: collision with root package name */
        private float f10099b;
        private float[] c = new float[8];
        private boolean d;

        public b() {
            this.f10099b = ao.a(EntryViewPager.this.getContext(), 4.0f);
            b();
        }

        private void b() {
            setColor(Color.parseColor("#FFF2F2F2"));
            a(ao.a(EntryViewPager.this.getContext(), 12.0f));
            a(Color.parseColor("#9c9c9c"));
            setCornerRadius(this.f10099b);
        }

        public boolean a() {
            return this.d;
        }

        public void b(float f) {
            if (f <= 0.0f) {
                a("左\r\n滑\r\n查\r\n看\r\n更\r\n多\r\n视\r\n频");
                setCornerRadius(this.f10099b);
                this.d = false;
                return;
            }
            float f2 = 4.5f * f;
            this.c[0] = f2;
            this.c[1] = f2;
            this.c[2] = this.f10099b;
            this.c[3] = this.f10099b;
            this.c[4] = this.f10099b;
            this.c[5] = this.f10099b;
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

    /* loaded from: classes5.dex */
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
        this.f10092a = new com.kwad.sdk.contentalliance.widget.b(getContext());
        if (this.f) {
            this.f10092a.setDragListener(this);
        }
        addView(this.f10092a);
        this.f10093b = new TextView(getContext());
        this.c = new b();
        this.c.b(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        int width = getWidth();
        int top = this.f10092a.getTop();
        int bottom = this.f10092a.getBottom();
        this.c.b(this.f10093b.getWidth());
        this.c.setBounds((int) ((width - f) - this.f10093b.getWidth()), top, width, bottom);
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
        if (this.f10093b.getRight() <= 0) {
            this.d = false;
        } else if (i < this.f10093b.getLeft() - this.f10092a.getMeasuredWidth()) {
            this.d = false;
        } else {
            this.d = true;
            int width = getWidth();
            int top = this.f10092a.getTop();
            int bottom = this.f10092a.getBottom();
            this.c.setBounds(width - (this.f10092a.getMeasuredWidth() - (this.f10093b.getLeft() - i)), top, width, bottom);
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
        this.f10092a.setAdapter(pagerAdapter);
    }

    public void setDragSideEnable(boolean z) {
        this.f = z;
        if (z || this.f10092a == null) {
            return;
        }
        this.f10092a.setDragListener(null);
    }

    public void setOffscreenPageLimit(int i) {
        this.f10092a.setOffscreenPageLimit(i);
    }

    public void setOnDragOpenListener(c cVar) {
        this.e = cVar;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f10092a.setOnPageChangeListener(onPageChangeListener);
    }

    public void setPageMargin(int i) {
        this.f10092a.setPageMargin(i);
    }
}
