package com.kascend.chushou.player.ui.giftpopup;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.d.e;
import com.kascend.chushou.player.ui.InteractNotifier;
import com.kascend.chushou.player.ui.food.FoodView;
import com.kascend.chushou.player.ui.h5.redpacket.RedpacketNotifier;
import java.util.List;
import org.json.JSONObject;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    private View b;
    private View c;
    private View d;
    private int h;
    private ImageView k;
    private RelativeLayout l;
    private boolean m = false;
    public ListItem mHs;
    private GiftPopupLayout mUg;
    private RedpacketNotifier mUh;
    private InteractNotifier mUi;
    private FoodView mUj;
    private FrescoThumbnailView mUl;

    public a(View view, int i) {
        this.h = 1;
        this.b = view;
        this.h = i;
    }

    public void a(List<ListItem> list, com.kascend.chushou.player.ui.h5.redpacket.a aVar, com.kascend.chushou.player.ui.h5.b.b bVar, com.kascend.chushou.player.ui.h5.d.a aVar2, com.kascend.chushou.player.ui.h5.a.a aVar3) {
        d();
        c(list);
        a(aVar);
        this.mUi.a(bVar, aVar2, aVar3);
    }

    public void a(boolean z) {
        if (this.c != null) {
            this.c.setVisibility(0);
            if (!z) {
                this.d.setVisibility(8);
                this.mUg.setVisibility(8);
                this.l.setVisibility(8);
                return;
            }
            this.d.setVisibility(0);
            this.mUg.setVisibility(0);
            this.l.setVisibility(0);
            if (this.h == 2 && (this.c.getContext() instanceof Activity)) {
                Activity activity = (Activity) this.c.getContext();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
                if (tv.chushou.zues.utils.systemBar.b.gC(activity)) {
                    marginLayoutParams.bottomMargin = tv.chushou.zues.utils.systemBar.b.gA(activity) + tv.chushou.zues.utils.a.dip2px(activity, 68.0f);
                } else {
                    marginLayoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(activity, 68.0f);
                }
                this.c.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public int a() {
        return this.h;
    }

    public void b() {
        if (this.mUg != null) {
            this.mUg.removeAllViews();
            this.mUg.setVisibility(8);
        }
        if (this.mUi != null) {
            this.mUi.b();
            this.mUi.setVisibility(8);
        }
        if (this.mUh != null) {
            this.mUh.setVisibility(8);
        }
        if (this.mUj != null) {
            this.mUj.setVisibility(8);
        }
    }

    private void c(List<ListItem> list) {
        a(list);
    }

    public void a(com.kascend.chushou.player.ui.h5.redpacket.a aVar) {
        if (aVar != null) {
            d();
            this.mUh.a(aVar, true);
        }
    }

    public void a(com.kascend.chushou.player.ui.h5.b.b bVar) {
        if (bVar != null) {
            d();
        }
    }

    public void a(com.kascend.chushou.player.ui.h5.d.a aVar) {
        if (aVar != null) {
            d();
        }
    }

    public void a(com.kascend.chushou.player.ui.h5.a.a aVar) {
        if (aVar != null) {
            d();
        }
    }

    public void a(List<ListItem> list) {
        if (h.isEmpty(list)) {
            if (this.mUg != null) {
                this.mUg.removeAllViews();
                this.mUg.setVisibility(8);
                return;
            }
            return;
        }
        d();
        this.mUg.a(list, this.h);
    }

    public void a(int i) {
        if (i <= 0) {
            if (this.mUh != null) {
                this.mUh.setVisibility(8);
                return;
            }
            return;
        }
        d();
        this.mUh.a(i, true);
    }

    public void a(long j) {
        d();
        if (this.mUi != null) {
            this.mUi.b(j);
        }
    }

    public void b(int i) {
        d();
        if (this.mUi != null) {
            this.mUi.a(i);
        }
    }

    public void b(long j) {
        d();
        if (this.mUi != null) {
            this.mUi.a(j);
        }
    }

    public void c() {
        d();
        if (this.mUi != null) {
            this.mUi.a();
        }
    }

    public void a(ListItem listItem, FoodView.a aVar) {
        if (this.mUj != null && listItem != null) {
            this.mUj.a(listItem, 0, aVar);
        }
    }

    private void d() {
        if (!this.m) {
            if (this.h == 1) {
                this.c = ((ViewStub) this.b.findViewById(a.f.viewstub_gift_popup_landscape)).inflate();
                this.mUg = (GiftPopupLayout) this.c.findViewById(a.f.gift_popup_layout_landscape);
                this.mUh = (RedpacketNotifier) this.c.findViewById(a.f.redpacket_notifier_landscape);
                this.mUi = (InteractNotifier) this.c.findViewById(a.f.interact_notifier_landscape);
            } else {
                this.c = ((ViewStub) this.b.findViewById(a.f.viewstub_gift_popup_portrait)).inflate();
                this.mUg = (GiftPopupLayout) this.c.findViewById(a.f.gift_popup_layout_portrait);
                this.mUh = (RedpacketNotifier) this.c.findViewById(a.f.redpacket_notifier_portrait);
                this.mUi = (InteractNotifier) this.c.findViewById(a.f.interact_notifier_portrait);
            }
            this.mUj = (FoodView) this.c.findViewById(a.f.ad_pendant);
            this.d = this.c.findViewById(a.f.rl_vertical_container);
            this.mUl = (FrescoThumbnailView) this.c.findViewById(a.f.ic_shopwindow);
            this.k = (ImageView) this.c.findViewById(a.f.iv_shopwindow_close);
            this.mUl.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.l = (RelativeLayout) this.c.findViewById(a.f.rl_shopwindow);
            this.m = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.ic_shopwindow) {
            if (this.mHs != null) {
                if (this.mUl.getContext() instanceof Activity) {
                    e.a(this.mUl.getContext(), this.mHs, (JSONObject) null);
                    return;
                }
                Activity e = com.kascend.chushou.d.b.e();
                if (e != null) {
                    e.a(e, this.mHs, (JSONObject) null);
                }
            }
        } else if (id == a.f.iv_shopwindow_close && this.l != null) {
            this.l.setVisibility(8);
        }
    }

    public void b(List<ListItem> list) {
        if (this.mUl != null && !h.isEmpty(list)) {
            this.mHs = list.get(0);
            this.mUl.setVisibility(0);
            this.mUl.a(this.mHs.mCover, 0, 0, 0, 1);
            if (this.k != null) {
                if (this.mHs.mShowClose) {
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
            }
        }
    }
}
