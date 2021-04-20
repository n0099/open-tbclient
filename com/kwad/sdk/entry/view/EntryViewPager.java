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
/* loaded from: classes6.dex */
public class EntryViewPager extends FrameLayout implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.b f35056a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35057b;

    /* renamed from: c  reason: collision with root package name */
    public b f35058c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35059d;

    /* renamed from: e  reason: collision with root package name */
    public c f35060e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35061f;

    /* loaded from: classes6.dex */
    public class a extends PagerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public PagerAdapter f35065b;

        public a(PagerAdapter pagerAdapter) {
            this.f35065b = pagerAdapter;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull View view, int i, @NonNull Object obj) {
            if (obj == EntryViewPager.this.f35057b) {
                ((ViewGroup) view).removeView(EntryViewPager.this.f35057b);
            } else {
                this.f35065b.destroyItem(view, i, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            if (obj == EntryViewPager.this.f35057b) {
                viewGroup.removeView(EntryViewPager.this.f35057b);
            } else {
                this.f35065b.destroyItem(viewGroup, i, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull View view) {
            this.f35065b.finishUpdate(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull ViewGroup viewGroup) {
            this.f35065b.finishUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f35065b.getCount() + 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            return this.f35065b.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            return this.f35065b.getPageTitle(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i) {
            if (i != getCount() - 1 || EntryViewPager.this.f35057b == null) {
                return this.f35065b.getPageWidth(i);
            }
            return 0.12f;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull View view, int i) {
            if (i == getCount() - 1) {
                ((ViewGroup) view).addView(EntryViewPager.this.f35057b);
                return EntryViewPager.this.f35057b;
            }
            return this.f35065b.instantiateItem(view, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            if (i == getCount() - 1) {
                viewGroup.addView(EntryViewPager.this.f35057b);
                return EntryViewPager.this.f35057b;
            }
            return this.f35065b.instantiateItem(viewGroup, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return this.f35065b.isViewFromObject(view, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            this.f35065b.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
            this.f35065b.registerDataSetObserver(dataSetObserver);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
            this.f35065b.restoreState(parcelable, classLoader);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public Parcelable saveState() {
            return this.f35065b.saveState();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull View view, int i, @NonNull Object obj) {
            this.f35065b.setPrimaryItem(view, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            this.f35065b.setPrimaryItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NonNull View view) {
            this.f35065b.startUpdate(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NonNull ViewGroup viewGroup) {
            this.f35065b.startUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
            this.f35065b.unregisterDataSetObserver(dataSetObserver);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends e {

        /* renamed from: b  reason: collision with root package name */
        public float f35067b;

        /* renamed from: c  reason: collision with root package name */
        public float[] f35068c = new float[8];

        /* renamed from: d  reason: collision with root package name */
        public boolean f35069d;

        public b() {
            this.f35067b = ao.a(EntryViewPager.this.getContext(), 4.0f);
            b();
        }

        private void b() {
            setColor(Color.parseColor("#FFF2F2F2"));
            a(ao.a(EntryViewPager.this.getContext(), 12.0f));
            a(Color.parseColor("#9c9c9c"));
            setCornerRadius(this.f35067b);
        }

        public boolean a() {
            return this.f35069d;
        }

        public void b(float f2) {
            if (f2 <= 0.0f) {
                a("左\r\n滑\r\n查\r\n看\r\n更\r\n多\r\n视\r\n频");
                setCornerRadius(this.f35067b);
                this.f35069d = false;
                return;
            }
            float f3 = f2 * 4.5f;
            float[] fArr = this.f35068c;
            fArr[0] = f3;
            fArr[1] = f3;
            float f4 = this.f35067b;
            fArr[2] = f4;
            fArr[3] = f4;
            fArr[4] = f4;
            fArr[5] = f4;
            fArr[6] = f3;
            fArr[7] = f3;
            setCornerRadii(fArr);
            this.f35069d = false;
            if (f3 >= (getBounds().height() * 2) / 3) {
                a("松\r\n开\n查\n看");
                this.f35069d = true;
            }
            invalidateSelf();
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a();
    }

    public EntryViewPager(@NonNull Context context) {
        super(context);
        this.f35061f = true;
        a();
    }

    public EntryViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35061f = true;
        a();
    }

    private void a() {
        com.kwad.sdk.contentalliance.widget.b bVar = new com.kwad.sdk.contentalliance.widget.b(getContext());
        this.f35056a = bVar;
        if (this.f35061f) {
            bVar.setDragListener(this);
        }
        addView(this.f35056a);
        this.f35057b = new TextView(getContext());
        b bVar2 = new b();
        this.f35058c = bVar2;
        bVar2.b(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        int width = getWidth();
        int top = this.f35056a.getTop();
        int bottom = this.f35056a.getBottom();
        this.f35058c.b(this.f35057b.getWidth());
        this.f35058c.setBounds((int) ((width - f2) - this.f35057b.getWidth()), top, width, bottom);
        this.f35058c.b(f2);
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(int i, float f2) {
        b bVar = this.f35058c;
        final boolean z = bVar != null && bVar.a();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.entry.view.EntryViewPager.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                EntryViewPager.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                if (!z || valueAnimator.getAnimatedFraction() < 1.0f || EntryViewPager.this.f35060e == null) {
                    return;
                }
                EntryViewPager.this.f35060e.a();
            }
        });
        ofFloat.start();
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(int i, int i2, int i3, int i4) {
        if (this.f35057b.getRight() <= 0) {
            this.f35059d = false;
        } else if (i < this.f35057b.getLeft() - this.f35056a.getMeasuredWidth()) {
            this.f35059d = false;
        } else {
            this.f35059d = true;
            int width = getWidth();
            this.f35058c.setBounds(width - (this.f35056a.getMeasuredWidth() - (this.f35057b.getLeft() - i)), this.f35056a.getTop(), width, this.f35056a.getBottom());
        }
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(boolean z, int i, float f2) {
        if (z || !this.f35059d) {
            return;
        }
        a(f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f35059d) {
            this.f35058c.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        if (this.f35061f) {
            pagerAdapter = new a(pagerAdapter);
        }
        this.f35056a.setAdapter(pagerAdapter);
    }

    public void setDragSideEnable(boolean z) {
        com.kwad.sdk.contentalliance.widget.b bVar;
        this.f35061f = z;
        if (z || (bVar = this.f35056a) == null) {
            return;
        }
        bVar.setDragListener(null);
    }

    public void setOffscreenPageLimit(int i) {
        this.f35056a.setOffscreenPageLimit(i);
    }

    public void setOnDragOpenListener(c cVar) {
        this.f35060e = cVar;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f35056a.setOnPageChangeListener(onPageChangeListener);
    }

    public void setPageMargin(int i) {
        this.f35056a.setPageMargin(i);
    }
}
