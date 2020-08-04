package com.kascend.chushou.player.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.player.ui.h5.b.b;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.c;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class InteractNotifier extends RelativeLayout implements Handler.Callback, ViewPager.OnPageChangeListener {
    private final Context a;
    private LinearLayout b;
    private final List<Object> c;
    private final List<ImageView> d;
    private final List<View> e;
    private ViewPager f;
    private int g;
    private b nxI;
    private com.kascend.chushou.player.ui.h5.d.a nxJ;
    private com.kascend.chushou.player.ui.h5.a.a nxK;
    private final c nxL;

    public InteractNotifier(Context context) {
        this(context, null);
    }

    public InteractNotifier(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InteractNotifier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.g = 0;
        this.nxL = new c(this);
        this.a = context;
        LayoutInflater.from(context).inflate(a.h.widget_interact_notifier, (ViewGroup) this, true);
        this.f = (ViewPager) findViewById(a.f.interact_notifier_viewpager);
        this.b = (LinearLayout) findViewById(a.f.interact_notifier_indicator);
        this.f.setAdapter(new a());
        this.f.addOnPageChangeListener(this);
        this.f.setOffscreenPageLimit(1);
    }

    public void a(b bVar, com.kascend.chushou.player.ui.h5.d.a aVar, com.kascend.chushou.player.ui.h5.a.a aVar2) {
        this.nxI = bVar;
        this.nxJ = aVar;
        this.nxK = aVar2;
        d();
    }

    public void a(long j) {
        if (j > 0) {
            if (!this.c.contains(0)) {
                d();
                return;
            }
            for (View view : this.e) {
                if (view instanceof com.kascend.chushou.player.ui.h5.b.c) {
                    com.kascend.chushou.player.ui.h5.b.c cVar = (com.kascend.chushou.player.ui.h5.b.c) view;
                    if (cVar.getType() == 2) {
                        cVar.a(j);
                    }
                }
            }
            return;
        }
        d();
    }

    public void b(long j) {
        if (j > 0) {
            if (!this.c.contains(1)) {
                d();
                return;
            }
            for (View view : this.e) {
                if (view instanceof com.kascend.chushou.player.ui.h5.b.c) {
                    com.kascend.chushou.player.ui.h5.b.c cVar = (com.kascend.chushou.player.ui.h5.b.c) view;
                    if (cVar.getType() == 1) {
                        cVar.a(j);
                    }
                }
            }
            return;
        }
        d();
    }

    public void a(int i) {
        if (i > 0) {
            if (!this.c.contains(1)) {
                d();
                return;
            }
            for (View view : this.e) {
                if (view instanceof com.kascend.chushou.player.ui.h5.b.c) {
                    com.kascend.chushou.player.ui.h5.b.c cVar = (com.kascend.chushou.player.ui.h5.b.c) view;
                    if (cVar.getType() == 1) {
                        cVar.a(i);
                    }
                }
            }
            return;
        }
        d();
    }

    public void a() {
        d();
    }

    public void b() {
        this.c.clear();
        this.f.setAdapter(new a());
        this.nxL.ch(null);
    }

    public void c() {
        this.nxL.ch(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f.setCurrentItem(this.g + 1);
                this.nxL.B(1, 3000L);
                break;
        }
        return true;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.g = i;
        int b = b(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.c.size()) {
                this.d.get(i3).setBackgroundResource(i3 == b ? a.e.indicator_red : a.e.indicator_gray);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    private void d() {
        ArrayList arrayList = new ArrayList();
        if ((this.nxI != null ? this.nxI.dOk() : null) != null) {
            arrayList.add(1);
        }
        if ((this.nxJ != null ? this.nxJ.dOk() : null) != null) {
            arrayList.add(0);
        }
        List<com.kascend.chushou.player.ui.h5.c.b> c = this.nxK != null ? this.nxK.c() : null;
        if (!h.isEmpty(c)) {
            arrayList.addAll(c);
        }
        this.nxL.removeMessages(1);
        this.c.clear();
        this.c.addAll(arrayList);
        this.f.setAdapter(new a());
        this.f.setCurrentItem(0);
        this.g = 0;
        if (h.isEmpty(this.c)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.b.removeAllViews();
        this.d.clear();
        int i = 0;
        while (i < this.c.size()) {
            ImageView imageView = new ImageView(this.a);
            imageView.setBackgroundResource(i == 0 ? a.e.indicator_red : a.e.indicator_gray);
            this.d.add(imageView);
            int dip2px = tv.chushou.zues.utils.a.dip2px(this.a, 6.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px);
            layoutParams.leftMargin = 5;
            layoutParams.rightMargin = 5;
            this.b.addView(imageView, layoutParams);
            i++;
        }
        if (this.c.size() > 1) {
            this.b.setVisibility(0);
            this.nxL.B(1, 3000L);
            return;
        }
        this.b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        return i % this.c.size();
    }

    /* loaded from: classes6.dex */
    public class a extends PagerAdapter {
        public a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (InteractNotifier.this.c.size() == 0) {
                return 0;
            }
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            com.kascend.chushou.player.ui.h5.b.c cVar;
            Object obj = InteractNotifier.this.c.get(InteractNotifier.this.b(i));
            if (obj instanceof Integer) {
                switch (((Integer) obj).intValue()) {
                    case 0:
                        com.kascend.chushou.player.ui.h5.b.c cVar2 = new com.kascend.chushou.player.ui.h5.b.c(InteractNotifier.this.a);
                        cVar2.a(InteractNotifier.this.nxJ);
                        cVar = cVar2;
                        break;
                    case 1:
                        com.kascend.chushou.player.ui.h5.b.c cVar3 = new com.kascend.chushou.player.ui.h5.b.c(InteractNotifier.this.a);
                        cVar3.a(InteractNotifier.this.nxI);
                        cVar = cVar3;
                        break;
                    default:
                        cVar = new View(InteractNotifier.this.a);
                        break;
                }
            } else if (obj instanceof com.kascend.chushou.player.ui.h5.c.b) {
                com.kascend.chushou.player.ui.h5.a.b bVar = new com.kascend.chushou.player.ui.h5.a.b(InteractNotifier.this.a);
                bVar.a((com.kascend.chushou.player.ui.h5.c.b) obj);
                cVar = bVar;
            } else {
                cVar = new View(InteractNotifier.this.a);
            }
            viewGroup.addView(cVar);
            InteractNotifier.this.e.add(cVar);
            return cVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            View view = (View) obj;
            InteractNotifier.this.e.remove(view);
            viewGroup.removeView(view);
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }
}
