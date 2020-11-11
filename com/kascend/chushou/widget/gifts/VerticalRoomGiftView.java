package com.kascend.chushou.widget.gifts;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.GeneralGift;
import com.kascend.chushou.constants.GiftPanelStatus;
import com.kascend.chushou.widget.gifts.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.adapterview.loadmore.DefaultLoadMoreView;
import tv.chushou.zues.widget.psts.PagerSlidingTabStrip;
/* loaded from: classes6.dex */
public class VerticalRoomGiftView extends BaseGiftView {
    public List<f> i;
    private Context m;
    private List<GeneralGift> n;
    private Map<Integer, List<GeneralGift>> o;
    private int p;
    private GiftViewPager pCf;
    private PagerSlidingTabStrip pCg;
    private a pCh;
    private io.reactivex.disposables.a pCi;
    private f.a pCj;
    private int q;
    private int r;
    private View s;
    private String t;

    public VerticalRoomGiftView(Context context, int i) {
        this(context, null, i);
    }

    public VerticalRoomGiftView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, 0, i);
    }

    public VerticalRoomGiftView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.p = -1;
        this.q = 0;
        this.r = 5;
        this.pCi = new io.reactivex.disposables.a();
        this.pCj = new f.a() { // from class: com.kascend.chushou.widget.gifts.VerticalRoomGiftView.3
            @Override // com.kascend.chushou.widget.gifts.f.a
            public void a(View view, Object obj, int i3, int i4) {
                VerticalRoomGiftView.this.c = view;
                if (obj instanceof GeneralGift) {
                    VerticalRoomGiftView.this.pBk = (GeneralGift) obj;
                }
                VerticalRoomGiftView.this.e = i3;
                if (VerticalRoomGiftView.this.pBj != null) {
                    VerticalRoomGiftView.this.pBj.b(VerticalRoomGiftView.this.c, VerticalRoomGiftView.this.pBk, VerticalRoomGiftView.this.e, VerticalRoomGiftView.this.getTag().toString());
                }
            }

            @Override // com.kascend.chushou.widget.gifts.f.a
            public void a(Object obj) {
                if (VerticalRoomGiftView.this.pBj != null) {
                    VerticalRoomGiftView.this.pBj.a(obj);
                }
            }
        };
        this.r = i2;
        a(context);
    }

    private void a(Context context) {
        this.m = context;
        this.g = false;
        View inflate = LayoutInflater.from(context).inflate(a.h.gift_room_base_view, (ViewGroup) this, true);
        this.pCf = (GiftViewPager) inflate.findViewById(a.f.gift_kasvp);
        this.pCg = (PagerSlidingTabStrip) inflate.findViewById(a.f.gift_indicator);
        this.i = new ArrayList();
        this.pCh = new a();
        this.pCf.setAdapter(this.pCh);
        this.pCg.setVisibility(8);
        this.q = 0;
        this.pCf.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kascend.chushou.widget.gifts.VerticalRoomGiftView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                f fVar = VerticalRoomGiftView.this.i.get(i);
                VerticalRoomGiftView.this.q = i;
                VerticalRoomGiftView.this.c = fVar.b;
                VerticalRoomGiftView.this.pBk = fVar.phF;
                VerticalRoomGiftView.this.e = fVar.d;
                if (VerticalRoomGiftView.this.pBj != null) {
                    VerticalRoomGiftView.this.pBj.b(VerticalRoomGiftView.this.c, VerticalRoomGiftView.this.pBk, VerticalRoomGiftView.this.e, VerticalRoomGiftView.this.getTag().toString());
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.s = inflate.findViewById(a.f.ll_btn_search);
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.widget.gifts.VerticalRoomGiftView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tv.chushou.zues.a.a.post(new com.kascend.chushou.widget.gifts.a.a(VerticalRoomGiftView.this.t, true));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (VerticalRoomGiftView.this.i == null) {
                return 0;
            }
            return VerticalRoomGiftView.this.i.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (VerticalRoomGiftView.this.i != null) {
                viewGroup.removeView(VerticalRoomGiftView.this.i.get(i));
                Object tag = VerticalRoomGiftView.this.i.get(i).getTag();
                if (tag != null && !h.isEmpty(tag.toString())) {
                    VerticalRoomGiftView.this.i.remove(i);
                }
                VerticalRoomGiftView.this.pCh.notifyDataSetChanged();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            Object tag;
            if (!(obj instanceof f) || (tag = ((f) obj).getTag()) == null || h.isEmpty(tag.toString())) {
                return super.getItemPosition(obj);
            }
            return -2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (VerticalRoomGiftView.this.i == null || i >= VerticalRoomGiftView.this.i.size()) {
                return null;
            }
            f fVar = VerticalRoomGiftView.this.i.get(i);
            if (i > 2) {
                i = 2;
            }
            viewGroup.addView(fVar, i);
            return fVar;
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            return (VerticalRoomGiftView.this.i == null || i >= VerticalRoomGiftView.this.i.size() || VerticalRoomGiftView.this.i.get(i) == null || VerticalRoomGiftView.this.i.get(i).getGroupName() == null) ? "" : VerticalRoomGiftView.this.i.get(i).getGroupName();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.BaseGiftView
    public void a(ArrayList<GeneralGift> arrayList, String str, int i, boolean z) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (this.n == null || this.o == null) {
            a((List<GeneralGift>) arrayList, str, i, z);
        } else {
            Map<Integer, List<GeneralGift>> a2 = a(arrayList);
            int size = a2.size();
            int size2 = this.o.size();
            int i2 = size2 - size;
            if (i2 > 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    this.i.get(this.i.size() - 1).setTag("1");
                }
            } else if (i2 < 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= Math.abs(i2)) {
                        break;
                    }
                    this.i.add(new f(this.m, size2 + i5, this.pCj, str, this.r));
                    i4 = i5 + 1;
                }
            }
            int i6 = 0;
            Iterator<Integer> it = a2.keySet().iterator();
            while (true) {
                int i7 = i6;
                if (!it.hasNext()) {
                    break;
                }
                List<GeneralGift> list = a2.get(it.next());
                if (list != null) {
                    this.i.get(i7).g(list, z, true);
                }
                i6 = i7 + 1;
            }
            if (this.i.size() > 1 && this.h) {
                this.pCg.setVisibility(0);
                this.pCg.c(this.pCf);
                this.pCg.setSelectItem(this.q);
            } else {
                this.pCg.setVisibility(8);
            }
            if (this.h && this.r == 5) {
                this.t = str;
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
            this.o = a2;
        }
        this.n.clear();
        this.n.addAll(arrayList);
        this.pCh.notifyDataSetChanged();
        if (h.isEmpty(this.n) && this.pBj != null) {
            this.pBj.a(i);
        }
    }

    private Map<Integer, List<GeneralGift>> a(List<GeneralGift> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            GeneralGift generalGift = list.get(i);
            List list2 = (List) linkedHashMap.get(Integer.valueOf(generalGift.mGroup));
            if (list2 == null) {
                list2 = new ArrayList();
                linkedHashMap.put(Integer.valueOf(generalGift.mGroup), list2);
            }
            list2.add(generalGift);
        }
        return linkedHashMap;
    }

    @Override // com.kascend.chushou.widget.gifts.BaseGiftView
    public void a(List<GeneralGift> list, String str, int i, boolean z) {
        this.p = i;
        if (!h.isEmpty(list)) {
            if (this.pBj != null) {
                this.pBj.b(this.p);
            }
            if (this.n == null) {
                this.n = new ArrayList();
            } else {
                this.n.clear();
            }
            this.n.addAll(list);
            this.h = z;
            this.i.clear();
            this.o = a(list);
            int size = this.o.size();
            int i2 = 0;
            for (Integer num : this.o.keySet()) {
                List<GeneralGift> list2 = this.o.get(num);
                if (list2 != null) {
                    f fVar = new f(this.m, i2, this.pCj, str, this.r);
                    if (z) {
                        fVar.setLoadMoreFooter(new DefaultLoadMoreView(getContext()));
                        fVar.setPresenter(new d());
                    }
                    fVar.g(list2, z, true);
                    this.i.add(fVar);
                }
                i2++;
            }
            if (this.i.size() > 1 && this.h) {
                this.pCg.setVisibility(0);
                this.pCg.c(this.pCf);
                this.pCg.setSelectItem(this.q);
            } else {
                this.pCg.setVisibility(8);
            }
            if (this.h) {
                this.t = str;
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
            this.pCh.notifyDataSetChanged();
            this.pCf.setOffscreenPageLimit(size);
            this.g = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.BaseGiftView
    public void a(GiftPanelStatus giftPanelStatus) {
    }

    @Override // com.kascend.chushou.widget.gifts.BaseGiftView
    public View getCurGiftView() {
        c();
        return super.getCurGiftView();
    }

    @Override // com.kascend.chushou.widget.gifts.BaseGiftView
    public GeneralGift getCurObj() {
        c();
        return super.getCurObj();
    }

    @Override // com.kascend.chushou.widget.gifts.BaseGiftView
    public int getCurSelectPos() {
        c();
        return super.getCurSelectPos();
    }

    private void c() {
        f fVar;
        if (this.q >= 0 && this.q < this.i.size() && (fVar = this.i.get(this.q)) != null) {
            this.c = fVar.b;
            this.pBk = fVar.phF;
            this.e = fVar.d;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.BaseGiftView
    public boolean a() {
        f fVar;
        if (this.q < 0 || this.q >= this.i.size() || (fVar = this.i.get(this.q)) == null) {
            return false;
        }
        return fVar.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.widget.gifts.BaseGiftView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.pCi.dispose();
        this.pCf = null;
        this.pCg = null;
        this.c = null;
        this.e = -1;
        this.pBk = null;
        if (this.i != null) {
            this.i.clear();
            this.i = null;
        }
    }

    public int getTabIndex() {
        return this.p;
    }
}
