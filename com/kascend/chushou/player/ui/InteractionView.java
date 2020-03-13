package com.kascend.chushou.player.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.games.utils.so.SoUtils;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ConfigDetail;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import tv.chushou.widget.a.c;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.adapterview.d;
import tv.chushou.zues.widget.adapterview.recyclerview.a.a;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes5.dex */
public class InteractionView extends RelativeLayout {
    private Context a;
    private TextView c;
    private LinearLayout d;
    private boolean e;
    private boolean f;
    private Animation g;
    private Animation h;
    private ArrayList<ConfigDetail> j;
    private RecyclerView mZI;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a mZJ;
    private final SparseArrayCompat<ConfigDetail> mZK;
    private a mZL;

    /* loaded from: classes5.dex */
    public interface a {
        void b(ConfigDetail configDetail);
    }

    public InteractionView(Context context) {
        this(context, null);
    }

    public InteractionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InteractionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
        this.f = false;
        this.j = new ArrayList<>();
        this.mZK = new SparseArrayCompat<>();
        this.a = context;
        d();
    }

    private void d() {
        View inflate = LayoutInflater.from(this.a).inflate(a.h.view_interaction, (ViewGroup) this, true);
        this.d = (LinearLayout) inflate.findViewById(a.f.ll_interaction);
        this.mZI = (RecyclerView) inflate.findViewById(a.f.recycleview);
        this.c = (TextView) inflate.findViewById(a.f.tv_interaction_title);
        this.mZI.setPadding(0, this.a.getResources().getDimensionPixelSize(a.d.feed_back_10dp), 0, 0);
        this.mZI.setClipToPadding(false);
        this.mZI.setClipChildren(false);
        this.mZI.setLayoutManager(new GridLayoutManager(this.a, 4));
        this.mZJ = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<ConfigDetail>(this.j, a.h.item_interaction, new d() { // from class: com.kascend.chushou.player.ui.InteractionView.1
            @Override // tv.chushou.zues.widget.adapterview.d
            public void onItemClick(View view, int i) {
                ConfigDetail configDetail;
                if (i >= 0 && (configDetail = (ConfigDetail) InteractionView.this.j.get(i)) != null && InteractionView.this.mZL != null) {
                    InteractionView.this.mZL.b(configDetail);
                }
            }
        }) { // from class: com.kascend.chushou.player.ui.InteractionView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0813a view$OnLongClickListenerC0813a, ConfigDetail configDetail) {
                if (configDetail != null) {
                    ((FrescoThumbnailView) view$OnLongClickListenerC0813a.Oo(a.f.iv_icon)).i(configDetail.mCover, a.e.ic_default_item_interaction, tv.chushou.zues.utils.a.dip2px(InteractionView.this.a, 60.0f), tv.chushou.zues.utils.a.dip2px(InteractionView.this.a, 60.0f));
                    view$OnLongClickListenerC0813a.a(a.f.tv_title, configDetail.mName);
                    if (InteractionView.this.f) {
                        view$OnLongClickListenerC0813a.eF(a.f.tv_title, Color.parseColor("#D6D8DD"));
                    } else {
                        view$OnLongClickListenerC0813a.eF(a.f.tv_title, Color.parseColor("#484848"));
                    }
                    if (!h.isEmpty(configDetail.notifyIcon)) {
                        view$OnLongClickListenerC0813a.a(true, a.f.ftv_recharge);
                        view$OnLongClickListenerC0813a.a(false, a.f.iv_recharge_point);
                        ((FrescoThumbnailView) view$OnLongClickListenerC0813a.Oo(a.f.ftv_recharge)).a(configDetail.notifyIcon, c.dQl(), b.C0816b.small, b.C0816b.small, 1);
                        return;
                    }
                    view$OnLongClickListenerC0813a.a(false, a.f.ftv_recharge);
                    view$OnLongClickListenerC0813a.a(configDetail.unreadCount > 0, a.f.iv_recharge_point);
                }
            }
        };
        this.mZI.setAdapter(this.mZJ);
        this.g = AnimationUtils.loadAnimation(this.a, a.C0690a.slide_in_bottom_anim);
        this.h = AnimationUtils.loadAnimation(this.a, a.C0690a.slide_out_bottom_anim);
    }

    public void a(boolean z) {
        if (!this.e) {
            this.e = true;
            this.g.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.InteractionView.3
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    InteractionView.this.mZJ.notifyDataSetChanged();
                }
            });
            if (z) {
                this.d.setBackgroundColor(Color.parseColor("#E5141414"));
                this.c.setTextColor(Color.parseColor("#888888"));
            } else {
                this.d.setBackgroundColor(-1);
                this.c.setTextColor(Color.parseColor("#484848"));
            }
            this.f = z;
            setVisibility(0);
            startAnimation(this.g);
        }
    }

    public boolean a() {
        if (this.e) {
            this.e = false;
            this.h.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.InteractionView.4
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    InteractionView.this.setVisibility(8);
                }
            });
            startAnimation(this.h);
            return true;
        }
        return false;
    }

    public boolean b() {
        return this.e;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.e) {
            return false;
        }
        a();
        return true;
    }

    public void setInterface(a aVar) {
        this.mZL = aVar;
    }

    public void b(ConfigDetail configDetail) {
        this.mZK.clear();
        this.j.clear();
        this.j.addAll(configDetail.configDetails);
        if (!h.isEmpty(this.j)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.j.size()) {
                    break;
                }
                ConfigDetail configDetail2 = this.j.get(i2);
                if (configDetail2 != null) {
                    if (configDetail2.mNotifyType.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR)) {
                        this.mZK.put(2, configDetail2);
                    } else if (configDetail2.mNotifyType.equals(SoUtils.SO_EVENT_ID_DEFAULT)) {
                        this.mZK.put(4, configDetail2);
                    } else if (configDetail2.mNotifyType.equals(SoUtils.SO_EVENT_ID_NEW_SO)) {
                        this.mZK.put(3, configDetail2);
                    } else if (configDetail2.mNotifyType.equals("26")) {
                        this.mZK.put(5, configDetail2);
                    }
                }
                i = i2 + 1;
            }
            if (this.mZJ != null) {
                this.mZJ.notifyDataSetChanged();
            }
        }
    }

    public void c() {
        int size = this.mZK.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.mZK.keyAt(i);
            ConfigDetail valueAt = this.mZK.valueAt(i);
            switch (keyAt) {
                case 2:
                case 3:
                case 4:
                case 5:
                    valueAt.notifyIcon = "";
                    valueAt.unreadCount = 0;
                    break;
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mZI.getLayoutParams();
        if (this.j.size() > 8) {
            layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.a, 240.0f);
        } else if (this.j.size() > 4) {
            layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.a, 214.0f);
        } else {
            layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.a, 122.0f);
        }
        this.mZI.setLayoutParams(layoutParams);
        if (this.mZJ != null) {
            this.mZJ.notifyDataSetChanged();
        }
    }
}
