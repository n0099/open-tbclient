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
    public ListItem mOj;
    private GiftPopupLayout naW;
    private RedpacketNotifier naX;
    private InteractNotifier naY;
    private FoodView naZ;
    private FrescoThumbnailView nba;

    public a(View view, int i) {
        this.h = 1;
        this.b = view;
        this.h = i;
    }

    public void a(List<ListItem> list, com.kascend.chushou.player.ui.h5.redpacket.a aVar, com.kascend.chushou.player.ui.h5.b.b bVar, com.kascend.chushou.player.ui.h5.d.a aVar2, com.kascend.chushou.player.ui.h5.a.a aVar3) {
        d();
        c(list);
        a(aVar);
        this.naY.a(bVar, aVar2, aVar3);
    }

    public void a(boolean z) {
        if (this.c != null) {
            this.c.setVisibility(0);
            if (!z) {
                this.d.setVisibility(8);
                this.naW.setVisibility(8);
                this.l.setVisibility(8);
                return;
            }
            this.d.setVisibility(0);
            this.naW.setVisibility(0);
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
        if (this.naW != null) {
            this.naW.removeAllViews();
            this.naW.setVisibility(8);
        }
        if (this.naY != null) {
            this.naY.b();
            this.naY.setVisibility(8);
        }
        if (this.naX != null) {
            this.naX.setVisibility(8);
        }
        if (this.naZ != null) {
            this.naZ.setVisibility(8);
        }
    }

    private void c(List<ListItem> list) {
        a(list);
    }

    public void a(com.kascend.chushou.player.ui.h5.redpacket.a aVar) {
        if (aVar != null) {
            d();
            this.naX.a(aVar, true);
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
            if (this.naW != null) {
                this.naW.removeAllViews();
                this.naW.setVisibility(8);
                return;
            }
            return;
        }
        d();
        this.naW.a(list, this.h);
    }

    public void a(int i) {
        if (i <= 0) {
            if (this.naX != null) {
                this.naX.setVisibility(8);
                return;
            }
            return;
        }
        d();
        this.naX.a(i, true);
    }

    public void a(long j) {
        d();
        if (this.naY != null) {
            this.naY.b(j);
        }
    }

    public void b(int i) {
        d();
        if (this.naY != null) {
            this.naY.a(i);
        }
    }

    public void b(long j) {
        d();
        if (this.naY != null) {
            this.naY.a(j);
        }
    }

    public void c() {
        d();
        if (this.naY != null) {
            this.naY.a();
        }
    }

    public void a(ListItem listItem, FoodView.a aVar) {
        if (this.naZ != null && listItem != null) {
            this.naZ.a(listItem, 0, aVar);
        }
    }

    private void d() {
        if (!this.m) {
            if (this.h == 1) {
                this.c = ((ViewStub) this.b.findViewById(a.f.viewstub_gift_popup_landscape)).inflate();
                this.naW = (GiftPopupLayout) this.c.findViewById(a.f.gift_popup_layout_landscape);
                this.naX = (RedpacketNotifier) this.c.findViewById(a.f.redpacket_notifier_landscape);
                this.naY = (InteractNotifier) this.c.findViewById(a.f.interact_notifier_landscape);
            } else {
                this.c = ((ViewStub) this.b.findViewById(a.f.viewstub_gift_popup_portrait)).inflate();
                this.naW = (GiftPopupLayout) this.c.findViewById(a.f.gift_popup_layout_portrait);
                this.naX = (RedpacketNotifier) this.c.findViewById(a.f.redpacket_notifier_portrait);
                this.naY = (InteractNotifier) this.c.findViewById(a.f.interact_notifier_portrait);
            }
            this.naZ = (FoodView) this.c.findViewById(a.f.ad_pendant);
            this.d = this.c.findViewById(a.f.rl_vertical_container);
            this.nba = (FrescoThumbnailView) this.c.findViewById(a.f.ic_shopwindow);
            this.k = (ImageView) this.c.findViewById(a.f.iv_shopwindow_close);
            this.nba.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.l = (RelativeLayout) this.c.findViewById(a.f.rl_shopwindow);
            this.m = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.ic_shopwindow) {
            if (this.mOj != null) {
                if (this.nba.getContext() instanceof Activity) {
                    e.a(this.nba.getContext(), this.mOj, (JSONObject) null);
                    return;
                }
                Activity e = com.kascend.chushou.d.b.e();
                if (e != null) {
                    e.a(e, this.mOj, (JSONObject) null);
                }
            }
        } else if (id == a.f.iv_shopwindow_close && this.l != null) {
            this.l.setVisibility(8);
        }
    }

    public void b(List<ListItem> list) {
        if (this.nba != null && !h.isEmpty(list)) {
            this.mOj = list.get(0);
            this.nba.setVisibility(0);
            this.nba.a(this.mOj.mCover, 0, 0, 0, 1);
            if (this.k != null) {
                if (this.mOj.mShowClose) {
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
            }
        }
    }
}
