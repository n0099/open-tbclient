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
    public com.kwad.sdk.contentalliance.widget.b f35151a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35152b;

    /* renamed from: c  reason: collision with root package name */
    public b f35153c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35154d;

    /* renamed from: e  reason: collision with root package name */
    public c f35155e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35156f;

    /* loaded from: classes6.dex */
    public class a extends PagerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public PagerAdapter f35160b;

        public a(PagerAdapter pagerAdapter) {
            this.f35160b = pagerAdapter;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull View view, int i, @NonNull Object obj) {
            if (obj == EntryViewPager.this.f35152b) {
                ((ViewGroup) view).removeView(EntryViewPager.this.f35152b);
            } else {
                this.f35160b.destroyItem(view, i, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            if (obj == EntryViewPager.this.f35152b) {
                viewGroup.removeView(EntryViewPager.this.f35152b);
            } else {
                this.f35160b.destroyItem(viewGroup, i, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull View view) {
            this.f35160b.finishUpdate(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull ViewGroup viewGroup) {
            this.f35160b.finishUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f35160b.getCount() + 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            return this.f35160b.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            return this.f35160b.getPageTitle(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i) {
            if (i != getCount() - 1 || EntryViewPager.this.f35152b == null) {
                return this.f35160b.getPageWidth(i);
            }
            return 0.12f;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull View view, int i) {
            if (i == getCount() - 1) {
                ((ViewGroup) view).addView(EntryViewPager.this.f35152b);
                return EntryViewPager.this.f35152b;
            }
            return this.f35160b.instantiateItem(view, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            if (i == getCount() - 1) {
                viewGroup.addView(EntryViewPager.this.f35152b);
                return EntryViewPager.this.f35152b;
            }
            return this.f35160b.instantiateItem(viewGroup, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return this.f35160b.isViewFromObject(view, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            this.f35160b.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
            this.f35160b.registerDataSetObserver(dataSetObserver);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
            this.f35160b.restoreState(parcelable, classLoader);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public Parcelable saveState() {
            return this.f35160b.saveState();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull View view, int i, @NonNull Object obj) {
            this.f35160b.setPrimaryItem(view, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            this.f35160b.setPrimaryItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NonNull View view) {
            this.f35160b.startUpdate(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NonNull ViewGroup viewGroup) {
            this.f35160b.startUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
            this.f35160b.unregisterDataSetObserver(dataSetObserver);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends e {

        /* renamed from: b  reason: collision with root package name */
        public float f35162b;

        /* renamed from: c  reason: collision with root package name */
        public float[] f35163c = new float[8];

        /* renamed from: d  reason: collision with root package name */
        public boolean f35164d;

        public b() {
            this.f35162b = ao.a(EntryViewPager.this.getContext(), 4.0f);
            b();
        }

        private void b() {
            setColor(Color.parseColor("#FFF2F2F2"));
            a(ao.a(EntryViewPager.this.getContext(), 12.0f));
            a(Color.parseColor("#9c9c9c"));
            setCornerRadius(this.f35162b);
        }

        public boolean a() {
            return this.f35164d;
        }

        public void b(float f2) {
            if (f2 <= 0.0f) {
                a("左\r\n滑\r\n查\r\n看\r\n更\r\n多\r\n视\r\n频");
                setCornerRadius(this.f35162b);
                this.f35164d = false;
                return;
            }
            float f3 = f2 * 4.5f;
            float[] fArr = this.f35163c;
            fArr[0] = f3;
            fArr[1] = f3;
            float f4 = this.f35162b;
            fArr[2] = f4;
            fArr[3] = f4;
            fArr[4] = f4;
            fArr[5] = f4;
            fArr[6] = f3;
            fArr[7] = f3;
            setCornerRadii(fArr);
            this.f35164d = false;
            if (f3 >= (getBounds().height() * 2) / 3) {
                a("松\r\n开\n查\n看");
                this.f35164d = true;
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
        this.f35156f = true;
        a();
    }

    public EntryViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35156f = true;
        a();
    }

    private void a() {
        com.kwad.sdk.contentalliance.widget.b bVar = new com.kwad.sdk.contentalliance.widget.b(getContext());
        this.f35151a = bVar;
        if (this.f35156f) {
            bVar.setDragListener(this);
        }
        addView(this.f35151a);
        this.f35152b = new TextView(getContext());
        b bVar2 = new b();
        this.f35153c = bVar2;
        bVar2.b(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        int width = getWidth();
        int top = this.f35151a.getTop();
        int bottom = this.f35151a.getBottom();
        this.f35153c.b(this.f35152b.getWidth());
        this.f35153c.setBounds((int) ((width - f2) - this.f35152b.getWidth()), top, width, bottom);
        this.f35153c.b(f2);
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(int i, float f2) {
        b bVar = this.f35153c;
        final boolean z = bVar != null && bVar.a();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.entry.view.EntryViewPager.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                EntryViewPager.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                if (!z || valueAnimator.getAnimatedFraction() < 1.0f || EntryViewPager.this.f35155e == null) {
                    return;
                }
                EntryViewPager.this.f35155e.a();
            }
        });
        ofFloat.start();
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(int i, int i2, int i3, int i4) {
        if (this.f35152b.getRight() <= 0) {
            this.f35154d = false;
        } else if (i < this.f35152b.getLeft() - this.f35151a.getMeasuredWidth()) {
            this.f35154d = false;
        } else {
            this.f35154d = true;
            int width = getWidth();
            this.f35153c.setBounds(width - (this.f35151a.getMeasuredWidth() - (this.f35152b.getLeft() - i)), this.f35151a.getTop(), width, this.f35151a.getBottom());
        }
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(boolean z, int i, float f2) {
        if (z || !this.f35154d) {
            return;
        }
        a(f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f35154d) {
            this.f35153c.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        if (this.f35156f) {
            pagerAdapter = new a(pagerAdapter);
        }
        this.f35151a.setAdapter(pagerAdapter);
    }

    public void setDragSideEnable(boolean z) {
        com.kwad.sdk.contentalliance.widget.b bVar;
        this.f35156f = z;
        if (z || (bVar = this.f35151a) == null) {
            return;
        }
        bVar.setDragListener(null);
    }

    public void setOffscreenPageLimit(int i) {
        this.f35151a.setOffscreenPageLimit(i);
    }

    public void setOnDragOpenListener(c cVar) {
        this.f35155e = cVar;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f35151a.setOnPageChangeListener(onPageChangeListener);
    }

    public void setPageMargin(int i) {
        this.f35151a.setPageMargin(i);
    }
}
