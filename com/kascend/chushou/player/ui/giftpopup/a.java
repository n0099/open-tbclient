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
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private View b;
    private View c;
    private View d;
    private int h;
    private ImageView k;
    private RelativeLayout l;
    private boolean m = false;
    public ListItem mOe;
    private GiftPopupLayout naR;
    private RedpacketNotifier naS;
    private InteractNotifier naT;
    private FoodView naU;
    private FrescoThumbnailView naV;

    public a(View view, int i) {
        this.h = 1;
        this.b = view;
        this.h = i;
    }

    public void a(List<ListItem> list, com.kascend.chushou.player.ui.h5.redpacket.a aVar, com.kascend.chushou.player.ui.h5.b.b bVar, com.kascend.chushou.player.ui.h5.d.a aVar2, com.kascend.chushou.player.ui.h5.a.a aVar3) {
        d();
        c(list);
        a(aVar);
        this.naT.a(bVar, aVar2, aVar3);
    }

    public void a(boolean z) {
        if (this.c != null) {
            this.c.setVisibility(0);
            if (!z) {
                this.d.setVisibility(8);
                this.naR.setVisibility(8);
                this.l.setVisibility(8);
                return;
            }
            this.d.setVisibility(0);
            this.naR.setVisibility(0);
            this.l.setVisibility(0);
            if (this.h == 2 && (this.c.getContext() instanceof Activity)) {
                Activity activity = (Activity) this.c.getContext();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
                if (tv.chushou.zues.utils.systemBar.b.hk(activity)) {
                    marginLayoutParams.bottomMargin = tv.chushou.zues.utils.systemBar.b.hi(activity) + tv.chushou.zues.utils.a.dip2px(activity, 68.0f);
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
        if (this.naR != null) {
            this.naR.removeAllViews();
            this.naR.setVisibility(8);
        }
        if (this.naT != null) {
            this.naT.b();
            this.naT.setVisibility(8);
        }
        if (this.naS != null) {
            this.naS.setVisibility(8);
        }
        if (this.naU != null) {
            this.naU.setVisibility(8);
        }
    }

    private void c(List<ListItem> list) {
        a(list);
    }

    public void a(com.kascend.chushou.player.ui.h5.redpacket.a aVar) {
        if (aVar != null) {
            d();
            this.naS.a(aVar, true);
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
            if (this.naR != null) {
                this.naR.removeAllViews();
                this.naR.setVisibility(8);
                return;
            }
            return;
        }
        d();
        this.naR.a(list, this.h);
    }

    public void a(int i) {
        if (i <= 0) {
            if (this.naS != null) {
                this.naS.setVisibility(8);
                return;
            }
            return;
        }
        d();
        this.naS.a(i, true);
    }

    public void a(long j) {
        d();
        if (this.naT != null) {
            this.naT.b(j);
        }
    }

    public void b(int i) {
        d();
        if (this.naT != null) {
            this.naT.a(i);
        }
    }

    public void b(long j) {
        d();
        if (this.naT != null) {
            this.naT.a(j);
        }
    }

    public void c() {
        d();
        if (this.naT != null) {
            this.naT.a();
        }
    }

    public void a(ListItem listItem, FoodView.a aVar) {
        if (this.naU != null && listItem != null) {
            this.naU.a(listItem, 0, aVar);
        }
    }

    private void d() {
        if (!this.m) {
            if (this.h == 1) {
                this.c = ((ViewStub) this.b.findViewById(a.f.viewstub_gift_popup_landscape)).inflate();
                this.naR = (GiftPopupLayout) this.c.findViewById(a.f.gift_popup_layout_landscape);
                this.naS = (RedpacketNotifier) this.c.findViewById(a.f.redpacket_notifier_landscape);
                this.naT = (InteractNotifier) this.c.findViewById(a.f.interact_notifier_landscape);
            } else {
                this.c = ((ViewStub) this.b.findViewById(a.f.viewstub_gift_popup_portrait)).inflate();
                this.naR = (GiftPopupLayout) this.c.findViewById(a.f.gift_popup_layout_portrait);
                this.naS = (RedpacketNotifier) this.c.findViewById(a.f.redpacket_notifier_portrait);
                this.naT = (InteractNotifier) this.c.findViewById(a.f.interact_notifier_portrait);
            }
            this.naU = (FoodView) this.c.findViewById(a.f.ad_pendant);
            this.d = this.c.findViewById(a.f.rl_vertical_container);
            this.naV = (FrescoThumbnailView) this.c.findViewById(a.f.ic_shopwindow);
            this.k = (ImageView) this.c.findViewById(a.f.iv_shopwindow_close);
            this.naV.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.l = (RelativeLayout) this.c.findViewById(a.f.rl_shopwindow);
            this.m = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.ic_shopwindow) {
            if (this.mOe != null) {
                if (this.naV.getContext() instanceof Activity) {
                    e.a(this.naV.getContext(), this.mOe, (JSONObject) null);
                    return;
                }
                Activity e = com.kascend.chushou.d.b.e();
                if (e != null) {
                    e.a(e, this.mOe, (JSONObject) null);
                }
            }
        } else if (id == a.f.iv_shopwindow_close && this.l != null) {
            this.l.setVisibility(8);
        }
    }

    public void b(List<ListItem> list) {
        if (this.naV != null && !h.isEmpty(list)) {
            this.mOe = list.get(0);
            this.naV.setVisibility(0);
            this.naV.a(this.mOe.mCover, 0, 0, 0, 1);
            if (this.k != null) {
                if (this.mOe.mShowClose) {
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
            }
        }
    }
}
