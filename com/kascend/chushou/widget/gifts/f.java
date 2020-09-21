package com.kascend.chushou.widget.gifts;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.GeneralGift;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.adapterview.recyclerview.a.a;
import tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes6.dex */
public class f extends SwipRefreshRecyclerView {
    public List<GeneralGift> a;
    public View b;
    public int d;
    private int f;
    private Context h;
    private String i;
    private TextView l;
    private TextView m;
    private TextView n;
    public GeneralGift nRD;
    private FrescoThumbnailView odH;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<GeneralGift> omh;
    private a omi;
    private PopupWindow omj;
    private FlexboxLayout omk;
    private GridLayoutManager oml;
    private d omm;
    private c omn;
    private TextView p;
    private View q;
    private int r;
    private int s;
    private String u;
    private boolean x;

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view, Object obj, int i, int i2);

        void a(Object obj);
    }

    public f(Context context, int i, a aVar, String str, int i2) {
        this(context, null, i, aVar, str, i2);
    }

    public f(Context context, AttributeSet attributeSet, int i, a aVar, String str, int i2) {
        this(context, attributeSet, 0, i, aVar, str, i2);
    }

    public f(Context context, AttributeSet attributeSet, int i, int i2, a aVar, String str, int i3) {
        super(context, attributeSet);
        this.nRD = null;
        this.d = -1;
        this.r = -1;
        this.s = 5;
        this.x = false;
        this.h = context;
        this.f = i2;
        this.omi = aVar;
        this.i = str;
        this.s = i3;
        a(context);
    }

    private void a(Context context) {
        this.a = new ArrayList();
        this.oml = new GridLayoutManager(context, this.s);
        this.oml.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.kascend.chushou.widget.gifts.f.1
            @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                if (f.this.Pq(i)) {
                    return f.this.s;
                }
                return 1;
            }
        });
        final int dip2px = tv.chushou.zues.utils.a.dip2px(context, 28.0f);
        addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.kascend.chushou.widget.gifts.f.2
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                if (f.this.a != null) {
                    if (f.this.oml.getPosition(view) / f.this.s == ((int) Math.ceil((f.this.a.size() * 1.0f) / f.this.s)) - 1) {
                        rect.bottom = dip2px;
                        return;
                    } else {
                        rect.bottom = 0;
                        return;
                    }
                }
                super.getItemOffsets(rect, view, recyclerView, state);
            }
        });
        this.omh = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<GeneralGift>(this.a, a.h.room_gift_item, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.widget.gifts.f.3
            @Override // tv.chushou.zues.widget.adapterview.d
            public void D(View view, int i) {
                f.this.a(view, i);
            }
        }, new tv.chushou.zues.widget.adapterview.e() { // from class: com.kascend.chushou.widget.gifts.f.4
            @Override // tv.chushou.zues.widget.adapterview.e
            public boolean E(View view, int i) {
                f.this.a(view, i);
                f.this.b(view, i);
                f.this.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        }) { // from class: com.kascend.chushou.widget.gifts.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1011a view$OnLongClickListenerC1011a, GeneralGift generalGift) {
                if (generalGift != null) {
                    FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC1011a.rn(a.f.iv_gift_icon);
                    frescoThumbnailView.setAnim(true);
                    frescoThumbnailView.i(generalGift.mIcon, a.e.default_gift, b.a.oYs, b.a.oYs);
                    if (h.isEmpty(generalGift.mCornerImage)) {
                        view$OnLongClickListenerC1011a.rn(a.f.iv_gift_label).setVisibility(4);
                    } else {
                        view$OnLongClickListenerC1011a.a(true, a.f.iv_gift_label);
                        view$OnLongClickListenerC1011a.a(a.f.iv_gift_label, generalGift.mCornerImage, a.e.default_gift, b.a.oYs, b.a.oYs);
                    }
                    view$OnLongClickListenerC1011a.a(a.f.tv_gift_name, generalGift.mName);
                    view$OnLongClickListenerC1011a.a(a.f.tv_gift_count, generalGift.mDisplayDesc);
                    if (f.this.a(generalGift.mType)) {
                        view$OnLongClickListenerC1011a.et(a.f.tv_gift_count, ContextCompat.getColor(f.this.getContext(), a.c.second_black));
                    } else {
                        view$OnLongClickListenerC1011a.et(a.f.tv_gift_count, ContextCompat.getColor(f.this.getContext(), a.c.ff7d01));
                    }
                    if (generalGift.mSelectFlag) {
                        view$OnLongClickListenerC1011a.rn(a.f.rl_gift_item_root).setSelected(true);
                    } else {
                        view$OnLongClickListenerC1011a.rn(a.f.rl_gift_item_root).setSelected(false);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a, android.support.v7.widget.RecyclerView.Adapter
            /* renamed from: a */
            public void onBindViewHolder(@NonNull a.View$OnLongClickListenerC1011a view$OnLongClickListenerC1011a, int i, @NonNull List<Object> list) {
                if (!h.isEmpty(list)) {
                    if (f.this.a != null && i < f.this.a.size()) {
                        if (f.this.a.get(i).mSelectFlag) {
                            view$OnLongClickListenerC1011a.rn(a.f.rl_gift_item_root).setSelected(true);
                            f.this.b = view$OnLongClickListenerC1011a.rn(a.f.iv_gift_icon);
                            f.this.d = i;
                            if (f.this.omi != null) {
                                f.this.omi.a(f.this.b, f.this.nRD, i, f.this.f);
                                return;
                            }
                            return;
                        }
                        view$OnLongClickListenerC1011a.rn(a.f.rl_gift_item_root).setSelected(false);
                        return;
                    }
                    return;
                }
                onBindViewHolder(view$OnLongClickListenerC1011a, i);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a, android.support.v7.widget.RecyclerView.Adapter
            /* renamed from: a */
            public void onBindViewHolder(a.View$OnLongClickListenerC1011a view$OnLongClickListenerC1011a, int i) {
                super.onBindViewHolder(view$OnLongClickListenerC1011a, i);
                if (f.this.a != null && i < f.this.a.size() && f.this.a.get(i).mSelectFlag) {
                    f.this.b = view$OnLongClickListenerC1011a.rn(a.f.iv_gift_icon);
                    f.this.d = i;
                    if (f.this.omi != null) {
                        f.this.omi.a(f.this.b, f.this.nRD, i, f.this.f);
                    }
                }
            }
        };
        setLayoutManager(this.oml);
        setAdapter(this.omh);
        setPullToRefreshEnabled(false);
    }

    @Override // tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return a(motionEvent) || super.dispatchTouchEvent(motionEvent);
    }

    public boolean a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.r = -1;
            d();
            return false;
        } else if (motionEvent.getAction() != 2 || this.r == -1) {
            return false;
        } else {
            View findChildViewUnder = getInnerRecyclerView().findChildViewUnder((int) motionEvent.getX(), (int) motionEvent.getY());
            int childAdapterPosition = findChildViewUnder != null ? getInnerRecyclerView().getChildAdapterPosition(findChildViewUnder) : -1;
            if (childAdapterPosition != -1) {
                if (childAdapterPosition == this.r) {
                    return true;
                }
                if (this.a == null || childAdapterPosition < 0 || childAdapterPosition > this.a.size() || findChildViewUnder == null) {
                    return false;
                }
                this.r = childAdapterPosition;
                a(findChildViewUnder, childAdapterPosition);
                b(findChildViewUnder, childAdapterPosition);
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int i) {
        if (!a(this.a.get(i).mType)) {
            if (this.omi != null) {
                this.omi.a(this.a.get(i));
                return;
            }
            return;
        }
        this.b = view.findViewById(a.f.iv_gift_icon);
        this.nRD = this.a.get(i);
        this.d = i;
        if (this.omi != null) {
            this.omi.a(this.b, this.nRD, i, this.f);
        }
        if (this.a != null && this.omh != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.a.size(); i3++) {
                if (i3 != i) {
                    if (this.a.get(i3).mSelectFlag) {
                        this.a.get(i3).mSelectFlag = false;
                        i2 = i3;
                    }
                } else {
                    this.a.get(i3).mSelectFlag = true;
                }
            }
            this.omh.notifyItemChanged(i2, 1);
            this.omh.notifyItemChanged(i, 1);
        }
        if (this.nRD != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_ACT_TYPE_TWENTY_EIGHT, "giftId", Integer.valueOf(this.nRD.mId), "roomId", this.i);
        }
    }

    public void g(List<GeneralGift> list, boolean z, boolean z2) {
        boolean z3;
        int i = 0;
        if (z2) {
            this.a.clear();
        }
        this.x = z;
        if (!h.isEmpty(list)) {
            this.a.addAll(list);
            if (list.size() > 0 && list.get(0) != null) {
                this.u = list.get(0).mGroupName;
                if (list.get(0).mGroup == 127) {
                    z = false;
                }
            }
        }
        if (z && this.omm != null && z2 && this.a.size() > 0) {
            GeneralGift generalGift = this.a.get(this.a.size() - 1);
            this.omm.a(this.i, generalGift.mId, generalGift.mGroup);
        }
        setHasMoreItems(z && (z2 || !h.isEmpty(list)));
        if (this.nRD != null) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                if (this.a.get(i2) != null && this.a.get(i2).mId == this.nRD.mId && this.a.get(i2).mType == this.nRD.mType) {
                    this.a.get(i2).mSelectFlag = true;
                    this.nRD = list.get(i2);
                    this.d = i2;
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        if (!z3) {
            this.b = null;
            this.nRD = null;
            this.d = -1;
            while (true) {
                if (i < this.a.size()) {
                    if (!a(this.a.get(i).mType)) {
                        i++;
                    } else {
                        this.a.get(i).mSelectFlag = true;
                        this.b = getChildAt(i);
                        this.nRD = this.a.get(i);
                        this.d = i;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.omh.notifyDataSetChanged();
    }

    public boolean a(int i) {
        return i == 2 || i == 1;
    }

    public int getIndex() {
        return this.f;
    }

    public String getGroupName() {
        return this.u;
    }

    public void setPresenter(d dVar) {
        if (this.omn != null) {
            this.omn.a();
            this.omn = null;
        }
        this.omm = dVar;
        setLoadMoreListener(new tv.chushou.zues.widget.adapterview.b() { // from class: com.kascend.chushou.widget.gifts.f.6
            @Override // tv.chushou.zues.widget.adapterview.b
            public void bGU() {
                if (f.this.omm != null && f.this.omm.b()) {
                    f.this.omm.c();
                }
            }
        });
    }

    public void setSearchPresenter(c cVar) {
        if (this.omm != null) {
            this.omm.a();
            this.omm = null;
        }
        this.omn = cVar;
        setLoadMoreListener(new tv.chushou.zues.widget.adapterview.b() { // from class: com.kascend.chushou.widget.gifts.f.7
            @Override // tv.chushou.zues.widget.adapterview.b
            public void bGU() {
                if (f.this.omn != null && f.this.omn.b()) {
                    f.this.omn.a(false);
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.omm != null) {
            this.omm.a((d) this);
        }
        if (this.omn != null) {
            this.omn.a((c) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.widget.SwipeRefreshLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.omm != null) {
            this.omm.a();
        }
        if (this.omn != null) {
            this.omn.a();
        }
    }

    public void a(String str) {
        if (this.omn != null) {
            this.omn.a(str);
        }
    }

    public void a() {
        if (this.omn != null) {
            this.omn.c();
        }
        if (this.a != null) {
            this.a.clear();
        }
        if (this.omh != null) {
            this.omh.notifyDataSetChanged();
        }
        this.b = null;
        this.nRD = null;
        this.d = -1;
    }

    private void c() {
        if (this.omj == null) {
            if (this.x) {
                this.q = LayoutInflater.from(this.h).inflate(a.h.room_emoji_gift_pop_view, (ViewGroup) null);
            } else {
                this.q = LayoutInflater.from(this.h).inflate(a.h.room_gift_pop_view, (ViewGroup) null);
            }
            this.odH = (FrescoThumbnailView) this.q.findViewById(a.f.iv_gift_icon);
            this.odH.setAnim(true);
            this.l = (TextView) this.q.findViewById(a.f.tv_expired_time);
            this.m = (TextView) this.q.findViewById(a.f.tv_gift_name);
            this.n = (TextView) this.q.findViewById(a.f.tv_gift_count);
            this.omk = (FlexboxLayout) this.q.findViewById(a.f.ll_gift_tags);
            this.p = (TextView) this.q.findViewById(a.f.tv_gift_desc);
            this.omj = new PopupWindow(this.q, tv.chushou.zues.utils.a.dip2px(this.h, this.x ? 160.0f : 250.0f), -2);
            this.omj.setBackgroundDrawable(this.h.getResources().getDrawable(a.e.bg_room_gift_pop));
            this.omj.setFocusable(false);
            this.omj.setOutsideTouchable(false);
            this.omj.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, int i) {
        if (view != null && i >= 0 && this.a != null && i < this.a.size()) {
            GeneralGift generalGift = this.a.get(i);
            if (this.omj == null) {
                c();
            }
            this.r = i;
            if (this.x) {
                ViewGroup.LayoutParams layoutParams = this.odH.getLayoutParams();
                if (generalGift.mGiftDetailHeight > 0 && generalGift.mGiftDetailWidth > 0) {
                    layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.h, generalGift.mGiftDetailHeight);
                    layoutParams.width = tv.chushou.zues.utils.a.dip2px(this.h, generalGift.mGiftDetailWidth);
                } else {
                    layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.h, 80.0f);
                    layoutParams.width = tv.chushou.zues.utils.a.dip2px(this.h, 80.0f);
                }
                this.odH.setLayoutParams(layoutParams);
            }
            this.odH.i(generalGift.mIcon, a.e.default_gift, b.a.oYs, b.a.oYs);
            if (h.isEmpty(generalGift.mExpiredTimeDesc)) {
                this.l.setVisibility(8);
            } else {
                this.l.setText(generalGift.mExpiredTimeDesc);
                this.l.setVisibility(0);
            }
            this.m.setText(generalGift.mName);
            if (TextUtils.isEmpty(generalGift.mWorthDesc)) {
                this.n.setVisibility(8);
            } else {
                this.n.setText(generalGift.mWorthDesc);
                this.n.setVisibility(0);
            }
            if (h.isEmpty(generalGift.mTagLists)) {
                this.omk.removeAllViews();
                this.omk.setVisibility(8);
            } else {
                this.omk.removeAllViews();
                for (int i2 = 0; i2 < generalGift.mTagLists.size(); i2++) {
                    View inflate = LayoutInflater.from(this.h).inflate(a.h.room_gift_pop_tag_item, (ViewGroup) this.omk, false);
                    ((TextView) inflate.findViewById(a.f.tv_tag)).setText(generalGift.mTagLists.get(i2));
                    this.omk.addView(inflate);
                }
                this.omk.setVisibility(0);
            }
            this.p.setText(generalGift.mDesc);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            Point hc = tv.chushou.zues.utils.a.hc(this.h);
            this.q.measure(0, 0);
            int width = ((view.getWidth() / 2) + i3) - (this.q.getMeasuredWidth() / 2);
            if (this.q.getMeasuredWidth() + width + tv.chushou.zues.utils.a.dip2px(this.h, 5.0f) > hc.x) {
                width = (hc.x - this.q.getMeasuredWidth()) - tv.chushou.zues.utils.a.dip2px(this.h, 5.0f);
            } else if (width < 0) {
                width = tv.chushou.zues.utils.a.dip2px(this.h, 5.0f);
            }
            int measuredHeight = (i4 - this.q.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(this.h, 15.0f);
            if (!this.omj.isShowing()) {
                this.omj.showAtLocation(view, 0, width, measuredHeight);
            } else {
                this.omj.update(width, measuredHeight, -1, -1);
            }
        }
    }

    private void d() {
        if (this.omj != null) {
            this.omj.dismiss();
            this.omj = null;
        }
    }

    public boolean b() {
        if (this.d == -1 || this.oml == null || (this.d >= this.oml.findFirstVisibleItemPosition() && this.d <= this.oml.findLastVisibleItemPosition())) {
            return false;
        }
        scrollToPosition(this.d);
        return true;
    }
}
