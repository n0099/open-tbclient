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

    /* renamed from: a  reason: collision with root package name */
    public List<GeneralGift> f4287a;
    public View b;
    public int d;
    private int f;
    private Context h;
    private String i;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView p;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<GeneralGift> pCq;
    private a pCr;
    private PopupWindow pCs;
    private FlexboxLayout pCt;
    private GridLayoutManager pCu;
    private d pCv;
    private c pCw;
    public GeneralGift phF;
    private FrescoThumbnailView ptQ;
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
        this.phF = null;
        this.d = -1;
        this.r = -1;
        this.s = 5;
        this.x = false;
        this.h = context;
        this.f = i2;
        this.pCr = aVar;
        this.i = str;
        this.s = i3;
        a(context);
    }

    private void a(Context context) {
        this.f4287a = new ArrayList();
        this.pCu = new GridLayoutManager(context, this.s);
        this.pCu.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.kascend.chushou.widget.gifts.f.1
            @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                if (f.this.vc(i)) {
                    return f.this.s;
                }
                return 1;
            }
        });
        final int dip2px = tv.chushou.zues.utils.a.dip2px(context, 28.0f);
        addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.kascend.chushou.widget.gifts.f.2
            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                if (f.this.f4287a != null) {
                    if (f.this.pCu.getPosition(view) / f.this.s == ((int) Math.ceil((f.this.f4287a.size() * 1.0f) / f.this.s)) - 1) {
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
        this.pCq = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<GeneralGift>(this.f4287a, a.h.room_gift_item, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.widget.gifts.f.3
            @Override // tv.chushou.zues.widget.adapterview.d
            public void I(View view, int i) {
                f.this.a(view, i);
            }
        }, new tv.chushou.zues.widget.adapterview.e() { // from class: com.kascend.chushou.widget.gifts.f.4
            @Override // tv.chushou.zues.widget.adapterview.e
            public boolean J(View view, int i) {
                f.this.a(view, i);
                f.this.b(view, i);
                f.this.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        }) { // from class: com.kascend.chushou.widget.gifts.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1121a view$OnLongClickListenerC1121a, GeneralGift generalGift) {
                if (generalGift != null) {
                    FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC1121a.sg(a.f.iv_gift_icon);
                    frescoThumbnailView.setAnim(true);
                    frescoThumbnailView.i(generalGift.mIcon, a.e.default_gift, b.a.qov, b.a.qov);
                    if (h.isEmpty(generalGift.mCornerImage)) {
                        view$OnLongClickListenerC1121a.sg(a.f.iv_gift_label).setVisibility(4);
                    } else {
                        view$OnLongClickListenerC1121a.a(true, a.f.iv_gift_label);
                        view$OnLongClickListenerC1121a.a(a.f.iv_gift_label, generalGift.mCornerImage, a.e.default_gift, b.a.qov, b.a.qov);
                    }
                    view$OnLongClickListenerC1121a.a(a.f.tv_gift_name, generalGift.mName);
                    view$OnLongClickListenerC1121a.a(a.f.tv_gift_count, generalGift.mDisplayDesc);
                    if (f.this.a(generalGift.mType)) {
                        view$OnLongClickListenerC1121a.eE(a.f.tv_gift_count, ContextCompat.getColor(f.this.getContext(), a.c.second_black));
                    } else {
                        view$OnLongClickListenerC1121a.eE(a.f.tv_gift_count, ContextCompat.getColor(f.this.getContext(), a.c.ff7d01));
                    }
                    if (generalGift.mSelectFlag) {
                        view$OnLongClickListenerC1121a.sg(a.f.rl_gift_item_root).setSelected(true);
                    } else {
                        view$OnLongClickListenerC1121a.sg(a.f.rl_gift_item_root).setSelected(false);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a, android.support.v7.widget.RecyclerView.Adapter
            /* renamed from: a */
            public void onBindViewHolder(@NonNull a.View$OnLongClickListenerC1121a view$OnLongClickListenerC1121a, int i, @NonNull List<Object> list) {
                if (!h.isEmpty(list)) {
                    if (f.this.f4287a != null && i < f.this.f4287a.size()) {
                        if (f.this.f4287a.get(i).mSelectFlag) {
                            view$OnLongClickListenerC1121a.sg(a.f.rl_gift_item_root).setSelected(true);
                            f.this.b = view$OnLongClickListenerC1121a.sg(a.f.iv_gift_icon);
                            f.this.d = i;
                            if (f.this.pCr != null) {
                                f.this.pCr.a(f.this.b, f.this.phF, i, f.this.f);
                                return;
                            }
                            return;
                        }
                        view$OnLongClickListenerC1121a.sg(a.f.rl_gift_item_root).setSelected(false);
                        return;
                    }
                    return;
                }
                onBindViewHolder(view$OnLongClickListenerC1121a, i);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a, android.support.v7.widget.RecyclerView.Adapter
            /* renamed from: a */
            public void onBindViewHolder(a.View$OnLongClickListenerC1121a view$OnLongClickListenerC1121a, int i) {
                super.onBindViewHolder(view$OnLongClickListenerC1121a, i);
                if (f.this.f4287a != null && i < f.this.f4287a.size() && f.this.f4287a.get(i).mSelectFlag) {
                    f.this.b = view$OnLongClickListenerC1121a.sg(a.f.iv_gift_icon);
                    f.this.d = i;
                    if (f.this.pCr != null) {
                        f.this.pCr.a(f.this.b, f.this.phF, i, f.this.f);
                    }
                }
            }
        };
        setLayoutManager(this.pCu);
        setAdapter(this.pCq);
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
                if (this.f4287a == null || childAdapterPosition < 0 || childAdapterPosition > this.f4287a.size() || findChildViewUnder == null) {
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
        if (!a(this.f4287a.get(i).mType)) {
            if (this.pCr != null) {
                this.pCr.a(this.f4287a.get(i));
                return;
            }
            return;
        }
        this.b = view.findViewById(a.f.iv_gift_icon);
        this.phF = this.f4287a.get(i);
        this.d = i;
        if (this.pCr != null) {
            this.pCr.a(this.b, this.phF, i, this.f);
        }
        if (this.f4287a != null && this.pCq != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f4287a.size(); i3++) {
                if (i3 != i) {
                    if (this.f4287a.get(i3).mSelectFlag) {
                        this.f4287a.get(i3).mSelectFlag = false;
                        i2 = i3;
                    }
                } else {
                    this.f4287a.get(i3).mSelectFlag = true;
                }
            }
            this.pCq.notifyItemChanged(i2, 1);
            this.pCq.notifyItemChanged(i, 1);
        }
        if (this.phF != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_ACT_TYPE_TWENTY_EIGHT, "giftId", Integer.valueOf(this.phF.mId), "roomId", this.i);
        }
    }

    public void g(List<GeneralGift> list, boolean z, boolean z2) {
        boolean z3;
        int i = 0;
        if (z2) {
            this.f4287a.clear();
        }
        this.x = z;
        if (!h.isEmpty(list)) {
            this.f4287a.addAll(list);
            if (list.size() > 0 && list.get(0) != null) {
                this.u = list.get(0).mGroupName;
                if (list.get(0).mGroup == 127) {
                    z = false;
                }
            }
        }
        if (z && this.pCv != null && z2 && this.f4287a.size() > 0) {
            GeneralGift generalGift = this.f4287a.get(this.f4287a.size() - 1);
            this.pCv.a(this.i, generalGift.mId, generalGift.mGroup);
        }
        setHasMoreItems(z && (z2 || !h.isEmpty(list)));
        if (this.phF != null) {
            for (int i2 = 0; i2 < this.f4287a.size(); i2++) {
                if (this.f4287a.get(i2) != null && this.f4287a.get(i2).mId == this.phF.mId && this.f4287a.get(i2).mType == this.phF.mType) {
                    this.f4287a.get(i2).mSelectFlag = true;
                    this.phF = list.get(i2);
                    this.d = i2;
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        if (!z3) {
            this.b = null;
            this.phF = null;
            this.d = -1;
            while (true) {
                if (i < this.f4287a.size()) {
                    if (!a(this.f4287a.get(i).mType)) {
                        i++;
                    } else {
                        this.f4287a.get(i).mSelectFlag = true;
                        this.b = getChildAt(i);
                        this.phF = this.f4287a.get(i);
                        this.d = i;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.pCq.notifyDataSetChanged();
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
        if (this.pCw != null) {
            this.pCw.a();
            this.pCw = null;
        }
        this.pCv = dVar;
        setLoadMoreListener(new tv.chushou.zues.widget.adapterview.b() { // from class: com.kascend.chushou.widget.gifts.f.6
            @Override // tv.chushou.zues.widget.adapterview.b
            public void bOI() {
                if (f.this.pCv != null && f.this.pCv.b()) {
                    f.this.pCv.c();
                }
            }
        });
    }

    public void setSearchPresenter(c cVar) {
        if (this.pCv != null) {
            this.pCv.a();
            this.pCv = null;
        }
        this.pCw = cVar;
        setLoadMoreListener(new tv.chushou.zues.widget.adapterview.b() { // from class: com.kascend.chushou.widget.gifts.f.7
            @Override // tv.chushou.zues.widget.adapterview.b
            public void bOI() {
                if (f.this.pCw != null && f.this.pCw.b()) {
                    f.this.pCw.a(false);
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.pCv != null) {
            this.pCv.a((d) this);
        }
        if (this.pCw != null) {
            this.pCw.a((c) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.widget.SwipeRefreshLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.pCv != null) {
            this.pCv.a();
        }
        if (this.pCw != null) {
            this.pCw.a();
        }
    }

    public void a(String str) {
        if (this.pCw != null) {
            this.pCw.a(str);
        }
    }

    public void a() {
        if (this.pCw != null) {
            this.pCw.c();
        }
        if (this.f4287a != null) {
            this.f4287a.clear();
        }
        if (this.pCq != null) {
            this.pCq.notifyDataSetChanged();
        }
        this.b = null;
        this.phF = null;
        this.d = -1;
    }

    private void c() {
        if (this.pCs == null) {
            if (this.x) {
                this.q = LayoutInflater.from(this.h).inflate(a.h.room_emoji_gift_pop_view, (ViewGroup) null);
            } else {
                this.q = LayoutInflater.from(this.h).inflate(a.h.room_gift_pop_view, (ViewGroup) null);
            }
            this.ptQ = (FrescoThumbnailView) this.q.findViewById(a.f.iv_gift_icon);
            this.ptQ.setAnim(true);
            this.l = (TextView) this.q.findViewById(a.f.tv_expired_time);
            this.m = (TextView) this.q.findViewById(a.f.tv_gift_name);
            this.n = (TextView) this.q.findViewById(a.f.tv_gift_count);
            this.pCt = (FlexboxLayout) this.q.findViewById(a.f.ll_gift_tags);
            this.p = (TextView) this.q.findViewById(a.f.tv_gift_desc);
            this.pCs = new PopupWindow(this.q, tv.chushou.zues.utils.a.dip2px(this.h, this.x ? 160.0f : 250.0f), -2);
            this.pCs.setBackgroundDrawable(this.h.getResources().getDrawable(a.e.bg_room_gift_pop));
            this.pCs.setFocusable(false);
            this.pCs.setOutsideTouchable(false);
            this.pCs.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, int i) {
        if (view != null && i >= 0 && this.f4287a != null && i < this.f4287a.size()) {
            GeneralGift generalGift = this.f4287a.get(i);
            if (this.pCs == null) {
                c();
            }
            this.r = i;
            if (this.x) {
                ViewGroup.LayoutParams layoutParams = this.ptQ.getLayoutParams();
                if (generalGift.mGiftDetailHeight > 0 && generalGift.mGiftDetailWidth > 0) {
                    layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.h, generalGift.mGiftDetailHeight);
                    layoutParams.width = tv.chushou.zues.utils.a.dip2px(this.h, generalGift.mGiftDetailWidth);
                } else {
                    layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.h, 80.0f);
                    layoutParams.width = tv.chushou.zues.utils.a.dip2px(this.h, 80.0f);
                }
                this.ptQ.setLayoutParams(layoutParams);
            }
            this.ptQ.i(generalGift.mIcon, a.e.default_gift, b.a.qov, b.a.qov);
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
                this.pCt.removeAllViews();
                this.pCt.setVisibility(8);
            } else {
                this.pCt.removeAllViews();
                for (int i2 = 0; i2 < generalGift.mTagLists.size(); i2++) {
                    View inflate = LayoutInflater.from(this.h).inflate(a.h.room_gift_pop_tag_item, (ViewGroup) this.pCt, false);
                    ((TextView) inflate.findViewById(a.f.tv_tag)).setText(generalGift.mTagLists.get(i2));
                    this.pCt.addView(inflate);
                }
                this.pCt.setVisibility(0);
            }
            this.p.setText(generalGift.mDesc);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            Point hD = tv.chushou.zues.utils.a.hD(this.h);
            this.q.measure(0, 0);
            int width = ((view.getWidth() / 2) + i3) - (this.q.getMeasuredWidth() / 2);
            if (this.q.getMeasuredWidth() + width + tv.chushou.zues.utils.a.dip2px(this.h, 5.0f) > hD.x) {
                width = (hD.x - this.q.getMeasuredWidth()) - tv.chushou.zues.utils.a.dip2px(this.h, 5.0f);
            } else if (width < 0) {
                width = tv.chushou.zues.utils.a.dip2px(this.h, 5.0f);
            }
            int measuredHeight = (i4 - this.q.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(this.h, 15.0f);
            if (!this.pCs.isShowing()) {
                this.pCs.showAtLocation(view, 0, width, measuredHeight);
            } else {
                this.pCs.update(width, measuredHeight, -1, -1);
            }
        }
    }

    private void d() {
        if (this.pCs != null) {
            this.pCs.dismiss();
            this.pCs = null;
        }
    }

    public boolean b() {
        if (this.d == -1 || this.pCu == null || (this.d >= this.pCu.findFirstVisibleItemPosition() && this.d <= this.pCu.findLastVisibleItemPosition())) {
            return false;
        }
        scrollToPosition(this.d);
        return true;
    }
}
