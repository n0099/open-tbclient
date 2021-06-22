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
/* loaded from: classes7.dex */
public class EntryViewPager extends FrameLayout implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.b f35525a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35526b;

    /* renamed from: c  reason: collision with root package name */
    public b f35527c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35528d;

    /* renamed from: e  reason: collision with root package name */
    public c f35529e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35530f;

    /* loaded from: classes7.dex */
    public class a extends PagerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public PagerAdapter f35534b;

        public a(PagerAdapter pagerAdapter) {
            this.f35534b = pagerAdapter;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull View view, int i2, @NonNull Object obj) {
            if (obj == EntryViewPager.this.f35526b) {
                ((ViewGroup) view).removeView(EntryViewPager.this.f35526b);
            } else {
                this.f35534b.destroyItem(view, i2, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            if (obj == EntryViewPager.this.f35526b) {
                viewGroup.removeView(EntryViewPager.this.f35526b);
            } else {
                this.f35534b.destroyItem(viewGroup, i2, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull View view) {
            this.f35534b.finishUpdate(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull ViewGroup viewGroup) {
            this.f35534b.finishUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f35534b.getCount() + 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            return this.f35534b.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i2) {
            return this.f35534b.getPageTitle(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i2) {
            if (i2 != getCount() - 1 || EntryViewPager.this.f35526b == null) {
                return this.f35534b.getPageWidth(i2);
            }
            return 0.12f;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull View view, int i2) {
            if (i2 == getCount() - 1) {
                ((ViewGroup) view).addView(EntryViewPager.this.f35526b);
                return EntryViewPager.this.f35526b;
            }
            return this.f35534b.instantiateItem(view, i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
            if (i2 == getCount() - 1) {
                viewGroup.addView(EntryViewPager.this.f35526b);
                return EntryViewPager.this.f35526b;
            }
            return this.f35534b.instantiateItem(viewGroup, i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return this.f35534b.isViewFromObject(view, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            this.f35534b.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
            this.f35534b.registerDataSetObserver(dataSetObserver);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
            this.f35534b.restoreState(parcelable, classLoader);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public Parcelable saveState() {
            return this.f35534b.saveState();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull View view, int i2, @NonNull Object obj) {
            this.f35534b.setPrimaryItem(view, i2, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            this.f35534b.setPrimaryItem(viewGroup, i2, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NonNull View view) {
            this.f35534b.startUpdate(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NonNull ViewGroup viewGroup) {
            this.f35534b.startUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
            this.f35534b.unregisterDataSetObserver(dataSetObserver);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends e {

        /* renamed from: b  reason: collision with root package name */
        public float f35536b;

        /* renamed from: c  reason: collision with root package name */
        public float[] f35537c = new float[8];

        /* renamed from: d  reason: collision with root package name */
        public boolean f35538d;

        public b() {
            this.f35536b = ao.a(EntryViewPager.this.getContext(), 4.0f);
            b();
        }

        private void b() {
            setColor(Color.parseColor("#FFF2F2F2"));
            a(ao.a(EntryViewPager.this.getContext(), 12.0f));
            a(Color.parseColor("#9c9c9c"));
            setCornerRadius(this.f35536b);
        }

        public boolean a() {
            return this.f35538d;
        }

        public void b(float f2) {
            if (f2 <= 0.0f) {
                a("左\r\n滑\r\n查\r\n看\r\n更\r\n多\r\n视\r\n频");
                setCornerRadius(this.f35536b);
                this.f35538d = false;
                return;
            }
            float f3 = f2 * 4.5f;
            float[] fArr = this.f35537c;
            fArr[0] = f3;
            fArr[1] = f3;
            float f4 = this.f35536b;
            fArr[2] = f4;
            fArr[3] = f4;
            fArr[4] = f4;
            fArr[5] = f4;
            fArr[6] = f3;
            fArr[7] = f3;
            setCornerRadii(fArr);
            this.f35538d = false;
            if (f3 >= (getBounds().height() * 2) / 3) {
                a("松\r\n开\n查\n看");
                this.f35538d = true;
            }
            invalidateSelf();
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a();
    }

    public EntryViewPager(@NonNull Context context) {
        super(context);
        this.f35530f = true;
        a();
    }

    public EntryViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35530f = true;
        a();
    }

    private void a() {
        com.kwad.sdk.contentalliance.widget.b bVar = new com.kwad.sdk.contentalliance.widget.b(getContext());
        this.f35525a = bVar;
        if (this.f35530f) {
            bVar.setDragListener(this);
        }
        addView(this.f35525a);
        this.f35526b = new TextView(getContext());
        b bVar2 = new b();
        this.f35527c = bVar2;
        bVar2.b(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        int width = getWidth();
        int top = this.f35525a.getTop();
        int bottom = this.f35525a.getBottom();
        this.f35527c.b(this.f35526b.getWidth());
        this.f35527c.setBounds((int) ((width - f2) - this.f35526b.getWidth()), top, width, bottom);
        this.f35527c.b(f2);
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(int i2, float f2) {
        b bVar = this.f35527c;
        final boolean z = bVar != null && bVar.a();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.entry.view.EntryViewPager.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                EntryViewPager.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                if (!z || valueAnimator.getAnimatedFraction() < 1.0f || EntryViewPager.this.f35529e == null) {
                    return;
                }
                EntryViewPager.this.f35529e.a();
            }
        });
        ofFloat.start();
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(int i2, int i3, int i4, int i5) {
        if (this.f35526b.getRight() <= 0) {
            this.f35528d = false;
        } else if (i2 < this.f35526b.getLeft() - this.f35525a.getMeasuredWidth()) {
            this.f35528d = false;
        } else {
            this.f35528d = true;
            int width = getWidth();
            this.f35527c.setBounds(width - (this.f35525a.getMeasuredWidth() - (this.f35526b.getLeft() - i2)), this.f35525a.getTop(), width, this.f35525a.getBottom());
        }
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(boolean z, int i2, float f2) {
        if (z || !this.f35528d) {
            return;
        }
        a(f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f35528d) {
            this.f35527c.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        if (this.f35530f) {
            pagerAdapter = new a(pagerAdapter);
        }
        this.f35525a.setAdapter(pagerAdapter);
    }

    public void setDragSideEnable(boolean z) {
        com.kwad.sdk.contentalliance.widget.b bVar;
        this.f35530f = z;
        if (z || (bVar = this.f35525a) == null) {
            return;
        }
        bVar.setDragListener(null);
    }

    public void setOffscreenPageLimit(int i2) {
        this.f35525a.setOffscreenPageLimit(i2);
    }

    public void setOnDragOpenListener(c cVar) {
        this.f35529e = cVar;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f35525a.setOnPageChangeListener(onPageChangeListener);
    }

    public void setPageMargin(int i2) {
        this.f35525a.setPageMargin(i2);
    }
}
