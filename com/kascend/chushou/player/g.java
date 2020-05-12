package com.kascend.chushou.player;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.games.utils.so.SoUtils;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import com.facebook.drawee.span.b;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.p;
import com.kascend.chushou.b.a.a.q;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.constants.ConfigDetail;
import com.kascend.chushou.constants.IconConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.MicMemberInfo;
import com.kascend.chushou.constants.PlayUrl;
import com.kascend.chushou.constants.PrivacyItem;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.constants.UrlDetails;
import com.kascend.chushou.d.h;
import com.kascend.chushou.player.ui.h5.H5Container;
import com.kascend.chushou.widget.GiftAnimationLayout;
import com.kascend.chushou.widget.OnlineToggleButton;
import com.kascend.chushou.widget.RoundProgressBar;
import com.kascend.chushou.widget.ShimmerFrameLayout;
import com.kascend.chushou.widget.gifts.RoomSendGiftView;
import com.kascend.chushou.widget.guide.PaoGuideView;
import com.kascend.chushou.widget.menu.KasBaseMenuView;
import com.opensource.svgaplayer.SVGAImageView;
import com.tencent.connect.common.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.apollo.CSDanmuLayout;
import tv.chushou.apollo.a;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.widget.adapterview.recyclerview.a.a;
import tv.chushou.zues.widget.emanate.view.EmanateView;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public abstract class g extends f implements View.OnClickListener, CSDanmuLayout.a {
    private int c;
    protected RelativeLayout mwN;
    protected RelativeLayout mwO;
    protected OnlineToggleButton mwP;
    protected RelativeLayout mwQ;
    protected OnlineToggleButton mwR;
    protected RelativeLayout mwS;
    protected OnlineToggleButton mwT;
    protected OnlineToggleButton mwU;
    protected LinearLayout mwV;
    protected PopupWindow mwW;
    protected PopupWindow mwX;
    protected PopupWindow mwY;
    protected RecyclerView mwZ;
    protected com.kascend.chushou.player.adapter.b mxA;
    protected PopupWindow mxB;
    protected ImageView mxC;
    protected List<PrivacyItem> mxD;
    protected FrescoThumbnailView mxE;
    protected ArrayList<String> mxF;
    protected LinearLayoutManager mxa;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> mxb;
    protected ArrayList<a> mxc;
    protected ArrayList<a> mxd;
    protected PopupWindow mxe;
    protected View mxg;
    protected SVGAImageView mxh;
    protected View mxi;
    protected EmanateView mxj;
    protected RoomSendGiftView mxk;
    protected RoundProgressBar mxl;
    protected TextView mxm;
    protected FrescoThumbnailView mxn;
    protected PaoGuideView mxo;
    protected AnimatorSet mxt;
    protected KasBaseMenuView.a mxu;
    protected H5Container mxv;
    protected RelativeLayout mxw;
    protected PopupWindow mxx;
    protected PopupWindow mxy;
    protected List<PrivacyItem> mxz;
    protected boolean mxf = false;
    protected int boT = 0;
    protected long mxp = 0;
    protected boolean mxq = false;
    protected IconConfig.Config mxr = new IconConfig.Config();
    protected CSDanmuLayout mxs = null;
    protected boolean bi = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.dyn() && g.this.mwZ != null && g.this.mxb != null && g.this.mxa != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.mxa.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.mxa.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.mxa.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.mxa.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.mxa.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.mwZ.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.mwF != null) {
                                    g.this.mwF.N(g.this.d);
                                    if (g.this.b) {
                                        g.this.mwF.e(g.this.d, 1000L);
                                    }
                                }
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator) {
                            }
                        });
                        shimmerFrameLayout.b();
                    }
                }
            }
        }
    };

    /* loaded from: classes5.dex */
    public static class a implements Serializable {
        private static final long serialVersionUID = -5486819557418455887L;
        public String mStrDisplay;
        public String mStrSend;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RelativeLayout dyo() {
        if (this.mwN == null) {
            this.mwN = (RelativeLayout) this.mwo.findViewById(a.f.video_root_view);
        }
        return this.mwN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(View view, int i, int i2) {
        if (!this.bi) {
            ag();
        }
        ah();
        if (this.mwW != null) {
            if (!this.mwW.isShowing()) {
                this.mwW.showAtLocation(view, 53, i, i2);
            } else {
                this.mwW.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point fU = tv.chushou.zues.utils.a.fU(this.mwE);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dwI().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dwI().b(1);
                layoutParams.width = -1;
                if (this.mwE.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mwI / 3;
                } else {
                    layoutParams.height = fU.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dwI().b(2);
                layoutParams.width = -1;
                if (this.mwE.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mwI / 3;
                } else {
                    layoutParams.height = fU.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.mxs != null) {
            this.mxs.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(View view, int i, int i2) {
        ae();
        if (this.mwX != null) {
            if (!this.mwX.isShowing()) {
                if (this.mwE.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.mwX.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.mwX.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.mwX.showAtLocation(view, 53, i, i2);
                return;
            }
            this.mwX.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.mwE.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.mwE).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.mwU = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dwI().b) {
                this.mwU.b();
            } else {
                this.mwU.c();
            }
        } else if (this.ap < 0) {
            if (h.dwI().n()) {
                this.mwU.b();
            } else {
                this.mwU.c();
            }
        } else if (h.dwI().o()) {
            this.mwU.b();
        } else {
            this.mwU.c();
        }
        final RadioGroup radioGroup = (RadioGroup) inflate.findViewById(a.f.rg_danmu);
        inflate.findViewById(a.f.cb_danmu_full).setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                radioGroup.check(a.f.cb_danmu_full);
                g.this.d(0);
            }
        });
        inflate.findViewById(a.f.cb_danmu_top).setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                radioGroup.check(a.f.cb_danmu_top);
                g.this.d(0);
                RxExecutor.postDelayed(null, EventThread.MAIN_THREAD, 50L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.d(1);
                    }
                });
            }
        });
        inflate.findViewById(a.f.cb_danmu_bottom).setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                radioGroup.check(a.f.cb_danmu_bottom);
                g.this.d(0);
                RxExecutor.postDelayed(null, EventThread.MAIN_THREAD, 50L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.d(2);
                    }
                });
            }
        });
        switch (h.dwI().m()) {
            case 0:
                radioGroup.check(a.f.cb_danmu_full);
                break;
            case 1:
                radioGroup.check(a.f.cb_danmu_top);
                break;
            case 2:
                radioGroup.check(a.f.cb_danmu_bottom);
                break;
        }
        if (this.mwE.getResources().getConfiguration().orientation == 1) {
            this.mwX = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwE, 230.0f), -2);
            this.mwX.setBackgroundDrawable(this.mwE.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.mwX = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwE, 295.0f), -1);
            this.mwX.setClippingEnabled(false);
            this.mwX.setBackgroundDrawable(this.mwE.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.mwX.setFocusable(true);
        this.mwX.setOutsideTouchable(true);
        this.mwX.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dwI().a(true);
        } else if (this.ap < 0) {
            h.dwI().e(true);
        } else {
            h.dwI().f(true);
        }
        switch (h.dwI().m()) {
            case 0:
                d(0);
                return;
            case 1:
                d(0);
                RxExecutor.postDelayed(null, EventThread.MAIN_THREAD, 50L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.15
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.d(1);
                    }
                });
                return;
            case 2:
                d(0);
                RxExecutor.postDelayed(null, EventThread.MAIN_THREAD, 50L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.16
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.d(2);
                    }
                });
                return;
            default:
                return;
        }
    }

    protected void ag() {
        ArrayList<PlayUrl> arrayList;
        int i;
        if (!this.bi) {
            int i2 = a.h.pop_full_play_setting;
            if (this.mwE.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.mwE).inflate(i2, (ViewGroup) null);
            this.mwV = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.mwO = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.mwP = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.mwQ = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.mwR = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.mwS = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mwT = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.mwE.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwE);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.C(10.0f);
                }
                this.mwV.setPadding(this.mwV.getPaddingLeft(), statusBarHeight, this.mwV.getPaddingRight(), this.mwV.getPaddingBottom());
            }
            this.mwO.setOnClickListener(this);
            this.mwQ.setOnClickListener(this);
            this.mwS.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.mwO.setVisibility(8);
            } else {
                this.mwO.setVisibility(0);
            }
            if (((VideoPlayer) this.mwE).q) {
                this.mwP.b();
            } else {
                this.mwP.c();
            }
            if (h.dwI().q()) {
                this.mwR.b();
            } else {
                this.mwR.c();
            }
            if (com.kascend.chushou.c.a) {
                this.mwS.setVisibility(0);
            } else {
                this.mwS.setVisibility(8);
            }
            if (h.dwI().a) {
                this.mwT.b();
            } else {
                this.mwT.c();
            }
            if (this.mwD != null && (arrayList = this.mwD.f) != null && arrayList.size() > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    final PlayUrl playUrl = arrayList.get(i4);
                    if (playUrl != null) {
                        int i5 = a.h.definition_full_item;
                        if ("2".equals(playUrl.mType)) {
                            if (this.mwE.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.mwE).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dxu = this.mwD.dxu();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mwE).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.mwE.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.mwE).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mwE, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mwE, 6.0f);
                                    }
                                    int identifier = this.mwE.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mwE.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mwV, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dxu != null && dxu.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.mwV.addView(inflate2);
                            this.bi = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.mwE.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.mwE).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dxu2 = this.mwD.dxu();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mwE).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.mwE.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.mwE).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mwE, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mwE, 6.0f);
                                    }
                                    int identifier2 = this.mwE.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mwE.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mwV, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dxu2 != null && dxu2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.mwV.addView(inflate3);
                            this.bi = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate3.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate3.findViewById(a.f.diliver).setVisibility(0);
                            }
                        }
                    }
                    i3 = i4 + 1;
                }
            }
            if (this.mwE.getResources().getConfiguration().orientation == 1) {
                this.mwW = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwE, 230.0f), -2);
                this.mwW.setBackgroundDrawable(this.mwE.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.mwW = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwE, 295.0f), -1);
                this.mwW.setClippingEnabled(false);
                this.mwW.setBackgroundDrawable(this.mwE.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.mwW.setFocusable(true);
            this.mwW.setOutsideTouchable(true);
            this.mwW.update();
        }
    }

    protected void ah() {
        if (this.mwQ != null && this.mwR != null) {
            this.mwQ.setVisibility(0);
            if (h.dwI().q()) {
                this.mwR.b();
            } else {
                this.mwR.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai() {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = null;
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() != -1) {
            com.kascend.chushou.d.e.a(0);
        }
        com.kascend.chushou.toolkit.a.c.a(this.mwE, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.mwD.f;
        if (!tv.chushou.zues.utils.h.isEmpty(arrayList)) {
            int i = 0;
            str = null;
            str2 = null;
            str3 = null;
            PlayUrl playUrl3 = null;
            while (true) {
                if (i >= arrayList.size()) {
                    playUrl = playUrl3;
                    break;
                }
                playUrl3 = arrayList.get(i);
                if (playUrl3 != null && "1".equals(playUrl3.mType)) {
                    if (!tv.chushou.zues.utils.h.isEmpty(playUrl3.mUrlDetails)) {
                        str3 = playUrl3.mUrlDetails.get(0).mUrl;
                        str2 = playUrl3.mUrlDetails.get(0).mDefinitionName;
                        str = playUrl3.mUrlDetails.get(0).mDefinitionType;
                        str4 = playUrl3.mUrlDetails.get(0).mSourceId;
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(str3)) {
                        playUrl = playUrl3;
                        break;
                    }
                }
                i++;
            }
        } else {
            str = null;
            str2 = null;
            str3 = null;
            playUrl = null;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(str3) && playUrl != null) {
            if (this.mwV == null) {
                this.mwD.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.mwD.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.mwE).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mwV.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mwV.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mwE.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mwE.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mwV, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.mwE, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.mwD.f;
        if (!tv.chushou.zues.utils.h.isEmpty(arrayList)) {
            int i = 0;
            str = null;
            str2 = null;
            str3 = null;
            PlayUrl playUrl3 = null;
            while (true) {
                if (i >= arrayList.size()) {
                    playUrl = playUrl3;
                    break;
                }
                playUrl3 = arrayList.get(i);
                if (playUrl3 != null && "2".equals(playUrl3.mType)) {
                    if (!tv.chushou.zues.utils.h.isEmpty(playUrl3.mUrlDetails)) {
                        str3 = playUrl3.mUrlDetails.get(0).mUrl;
                        str2 = playUrl3.mUrlDetails.get(0).mDefinitionType;
                        str = playUrl3.mUrlDetails.get(0).mSourceId;
                        str4 = playUrl3.mUrlDetails.get(0).mDefinitionName;
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(str3)) {
                        playUrl = playUrl3;
                        break;
                    }
                }
                i++;
            }
        } else {
            str = null;
            str2 = null;
            str3 = null;
            playUrl = null;
        }
        if (playUrl != null) {
            if (this.mwV == null) {
                if (!z) {
                    this.mwD.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.mwD.a(playUrl);
                if (this.ap >= 0) {
                    this.mwD.a(false);
                    if (this.mwE != null) {
                        ((VideoPlayer) this.mwE).a(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.mwE).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mwV.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mwV.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mwE.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mwE.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mwV, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.mwW != null) {
            this.mwW.dismiss();
        }
        if (this.mwY != null) {
            this.mwY.dismiss();
        }
        PlayUrl dxu = this.mwD.dxu();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.mwD.d) {
                this.mwD.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.mwD.a(playUrl);
                this.mwD.a(false);
                if (this.mwE != null) {
                    ((VideoPlayer) this.mwE).a(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.mwD.d) {
            this.mwD.e = true;
        }
        h.dwI().a(this.mwE, urlDetails.mDefinitionType);
        if (z || (dxu != null && !dxu.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.mwE, dym(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.mwD.a(playUrl);
            if (dym()) {
                if (((VideoPlayer) this.mwE) != null) {
                    ((VideoPlayer) this.mwE).r = -1L;
                }
                if (this.msU != null) {
                    this.lOB = this.msU.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.mwE).a(true, Uri.parse(playUrl.mSelectedUrl), true);
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                RadioGroup radioGroup = (RadioGroup) viewGroup.getChildAt(i).findViewById(a.f.rg_defi);
                if (radioGroup != null && !playUrl.mSelectedUrl.equals(((PlayUrl) radioGroup.getTag()).mSelectedUrl)) {
                    radioGroup.clearCheck();
                }
            }
        }
    }

    public void c(String str, String str2) {
        this.au = str;
        this.mwK = str2;
        if (this.mwF != null) {
            this.mwF.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.mxf = true;
            if (this.mxd == null) {
                this.mxd = new ArrayList<>();
            }
            this.mxd.clear();
            this.mxd.addAll(list);
            this.mxe = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.mxe == null) {
            View inflate = LayoutInflater.from(this.mwE).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.mwE.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.mwE.getResources().getColor(a.c.player_bg_color));
            }
            if (this.mxf && !tv.chushou.zues.utils.h.isEmpty(this.mxd)) {
                this.mxc = this.mxd;
            } else {
                this.mxc = (ArrayList) h.dwI().dwK();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.mxc)) {
                String[] stringArray = this.mwE.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.mwE.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.mxc == null) {
                    this.mxc = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.mxc.add(aVar);
                }
            }
            this.mwZ = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.mxb = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.mxc, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void B(View view, int i4) {
                    a aVar2;
                    if (g.this.mxe != null) {
                        g.this.mxe.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.mxc) && i4 < g.this.mxc.size() && (aVar2 = g.this.mxc.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.mxf) {
                            g.this.mxc.remove(i4);
                            g.this.mxc.add(0, aVar2);
                            g.this.mxb.notifyDataSetChanged();
                            g.this.mwZ.scrollToPosition(0);
                            RxExecutor.post(g.this.mwn, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dwI().a((Object) g.this.mxc);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.mwE, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.mwD != null && g.this.mwD.dxt() != null && g.this.mwD.dxt().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.mwD.dxt().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0858a view$OnLongClickListenerC0858a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0858a.a(a.f.tv_name, g.this.mwE.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0858a.a(a.f.tv_name, g.this.mwE.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0858a.a(a.f.tv_name, g.this.mwE.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0858a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.mxa = new LinearLayoutManager(this.mwE);
            this.mwZ.setLayoutManager(this.mxa);
            this.mwZ.setAdapter(this.mxb);
            this.mwZ.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                    if (g.this.ap < 0) {
                        if (i4 == 0) {
                            g.this.an();
                        } else {
                            g.this.ao();
                        }
                    }
                    super.onScrollStateChanged(recyclerView, i4);
                }
            });
            this.mxe = new PopupWindow(inflate, this.mwE.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.mwE.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.mxe.setFocusable(true);
            this.mxe.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.mxe.setBackgroundDrawable(this.mwE.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.mxe.setBackgroundDrawable(this.mwE.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.mxe.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.mwF.N(this.d);
        this.mwF.p(this.d);
    }

    protected void an() {
        this.b = true;
        this.mwF.N(this.d);
        this.mwF.e(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.mwF != null) {
            this.mwF.N(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bp(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.mwD != null) {
                RoomInfo dxw = this.mwD.dxw();
                if (dxw != null) {
                    str = dxw.mRoomID;
                }
                if (dxw != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dxw.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.mwE, listItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.mwo != null) {
            Point fU = tv.chushou.zues.utils.a.fU(this.mwE);
            int i = fU.x > fU.y ? 1 : 2;
            if (this.mxv == null) {
                this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mxv.setPlayerViewHelper(this.mwD);
            this.mxv.setVisibility(0);
            this.mxv.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.mwD != null && (e = this.mwD.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.mxv != null) {
            this.mxv.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.mxg == null && this.mxh == null) {
            if (this.mwD.mpy != null) {
                ChatInfo dxr = this.mwD.mpy.dxr();
                if (dxr == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.mxw == null) {
                    this.mxw = (RelativeLayout) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dxr.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dxr.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dxr.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dxr.mAnimSubType > 0) {
                    dxr.mAnimType = dxr.mAnimSubType;
                }
                if (dxr.mAnimationPluginId == 1) {
                    this.mxg = com.kascend.chushou.toolkit.d.a.dyL().a(this.mwE, String.valueOf(dxr.mAnimType), this.mxw, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.dyn() && g.this.mxg != null && g.this.mxw != null) {
                                Object tag = g.this.mxg.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dyL().a(g.this.mwE, String.valueOf(((ChatInfo) tag).mAnimType), g.this.mxw, g.this.mxg);
                                }
                                if (!z) {
                                    g.this.mxg.setVisibility(8);
                                    g.this.mxw.removeView(g.this.mxg);
                                    g.this.mxg = null;
                                    if (g.this.mwF != null) {
                                        g.this.mwF.removeMessages(11);
                                        g.this.mwF.A(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.mxg = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dxr.mJsonData);
                } else if (dxr.mAnimationPluginId == 2) {
                    if (this.mxh == null && this.mxw != null) {
                        this.mxh = (SVGAImageView) this.mxw.findViewById(a.f.svgaView);
                        if (this.mxh == null) {
                            this.mxh = new SVGAImageView(this.mwE);
                            this.mxh.setClearsAfterStop(true);
                            this.mxh.setLoops(1);
                            this.mxh.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.mxw.addView(this.mxh, layoutParams);
                        }
                    }
                    if (this.mxh == null) {
                        cVar.removeMessages(11);
                        cVar.A(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dyL().a(this.mwE, String.valueOf(dxr.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.mxh.stopAnimation();
                            g.this.mxh.clearAnimation();
                            g.this.mxh.setVisibility(8);
                            g.this.mxh = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onFinished() {
                            g.this.mxh.stopAnimation();
                            g.this.mxh.clearAnimation();
                            g.this.mxh.setVisibility(8);
                            g.this.mxh = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Oi() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.mxh, dxr);
                }
                if (this.mxg != null) {
                    this.mxg.setTag(dxr);
                    return;
                }
                return;
            }
            return;
        }
        cVar.removeMessages(11);
        cVar.A(11, 800L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(tv.chushou.zues.c cVar) {
        if (this.mxi == null) {
            if (this.mwD.mpy != null) {
                int g = this.mwD.mpy.g();
                ChatInfo dxs = this.mwD.mpy.dxs();
                if (dxs == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dxs, g);
                    return;
                }
            }
            return;
        }
        cVar.removeMessages(12);
        cVar.A(12, 800L);
    }

    private void a(final ChatInfo chatInfo, final int i) {
        int i2;
        if (this.mxi != null || getContext() == null) {
            if (this.mwF != null) {
                this.mwF.removeMessages(12);
                this.mwF.A(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.mxi = this.mwo.findViewById(a.f.rl_show_tip);
            if (this.mxi != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dwB().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwE);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mxi.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.mwE, 5.0f);
                    this.mxi.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.mxi = this.mwo.findViewById(a.f.rl_tip);
        }
        if (this.mxi != null) {
            this.mxi.setVisibility(0);
            this.mxi.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mwD != null) {
                            RoomInfo dxw = g.this.mwD.dxw();
                            if (dxw != null) {
                                str = dxw.mRoomID;
                            }
                            if (dxw != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dxw.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mwE, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.mxi.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.mxi.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mwD != null) {
                            RoomInfo dxw = g.this.mwD.dxw();
                            if (dxw != null) {
                                str = dxw.mRoomID;
                            }
                            if (dxw != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dxw.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mwE, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.mwE.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mwE, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mwE, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
                    cVar.append(chatInfo.mContent);
                }
                cVar.a(new b.c() { // from class: com.kascend.chushou.player.g.26
                    @Override // com.facebook.drawee.span.b.c
                    public void d(com.facebook.drawee.span.b bVar) {
                        simpleDraweeSpanTextView.measure(0, 0);
                        simpleDraweeSpanTextView.requestLayout();
                    }
                });
                simpleDraweeSpanTextView.setDraweeSpanStringBuilder(cVar);
                int dip2px = tv.chushou.zues.utils.a.dip2px(getContext(), 300.0f);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                simpleDraweeSpanTextView.measure(makeMeasureSpec, makeMeasureSpec);
                tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "ci: " + simpleDraweeSpanTextView.getMeasuredWidth() + "   " + dip2px);
                if (dip2px <= simpleDraweeSpanTextView.getMeasuredWidth()) {
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0736a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.fU(getContext()).x;
                if (this.mwE.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mwE, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mwE, a.c.black), simpleDraweeSpanTextView)) {
                    cVar2.append(chatInfo.mContent);
                }
                cVar2.a(new b.c() { // from class: com.kascend.chushou.player.g.27
                    @Override // com.facebook.drawee.span.b.c
                    public void d(com.facebook.drawee.span.b bVar) {
                        simpleDraweeSpanTextView.measure(0, 0);
                        simpleDraweeSpanTextView.requestLayout();
                    }
                });
                simpleDraweeSpanTextView.setDraweeSpanStringBuilder(cVar2);
                int dip2px2 = tv.chushou.zues.utils.a.dip2px(getContext(), 60.0f);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                simpleDraweeSpanTextView.measure(makeMeasureSpec2, makeMeasureSpec2);
                tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "ci: " + simpleDraweeSpanTextView.getMeasuredWidth() + "   " + (i2 - dip2px2));
                if (i2 - dip2px2 <= simpleDraweeSpanTextView.getMeasuredWidth()) {
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0736a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.mxi.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.mxi != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.mxi.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.mxi.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.mxt == null) {
                                g.this.mxt = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.mxt.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.mxt.removeAllListeners();
                            }
                            g.this.mxt.playTogether(ObjectAnimator.ofFloat(g.this.mxi, "translationX", g.this.mxi.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.mxt.start();
                            if (g.this.mwF != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.mwF.A(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void dlq() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!dyn() && this.mxi != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.mxi, "translationX", 0.0f, 10.0f, -this.mxi.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.dyn()) {
                        if (g.this.mxi != null) {
                            g.this.mxi.setVisibility(8);
                        }
                        g.this.mxi = null;
                        if (g.this.mwF != null) {
                            g.this.mwF.A(12, 800L);
                        }
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            if (this.mxt == null) {
                this.mxt = new AnimatorSet();
            }
            this.mxt.playTogether(duration);
            this.mxt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dlr() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.mwE).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.mxj = new EmanateView(this.mwE);
            this.mxj.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.mxj);
            return;
        }
        this.mxj = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.mxk == null) {
            this.mxk = (RoomSendGiftView) this.mwo.findViewById(a.f.normalSendGiftView);
            this.mxk.setContext(this.mwE);
            if (this.mwD != null) {
                this.mxk.a(this.mwD.dxt());
            }
            this.mxk.a(z, z2);
            this.mxk.setVisibilityListener(this.mxu);
            this.mxk.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.mxj != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable Qp = tv.chushou.zues.utils.h.Qp(str);
                            if (Qp == null) {
                                Qp = tv.chushou.zues.utils.h.Qr(str);
                            }
                            g.this.mxj.setDrawable(Qp, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.mxj.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.mxj.dKg();
                        }
                    }
                }
            });
            this.mxk.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void b(ConfigDetail configDetail) {
                    if (configDetail != null) {
                        g.this.b(configDetail);
                    }
                }

                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void a(boolean z3, boolean z4) {
                    g.this.aq(z3, z4);
                }
            });
        }
        if (this.mxk != null) {
            if (this.mwD != null) {
                this.mxk.a(z ? this.mwD.mpD : this.mwD.mpE, this.mwD.mpF, this.mwD.mpG, z);
                this.mxk.setGiftTopIcon(this.mwD.s);
            }
            if (micMemberInfo != null) {
                this.mxk.setMicMemberInfo(micMemberInfo);
            }
            this.mxk.c();
        }
    }

    protected void aq(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.mxl.setProgress(i);
            if (!this.mxq) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.mxm.setText(this.mwE.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.mxm.setText(this.mwE.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.mxm.setText(this.mwE.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.mxn.bU(str, a.e.pao_circle_default);
            if (this.mxp != i) {
                this.mxn.startAnimation(AnimationUtils.loadAnimation(this.mwE, a.C0736a.pao_beat_anim));
                this.mxp = i;
            }
            if (this.boT != bangInfo.mLevel) {
                if (this.mwF != null && !this.mwF.JG(17)) {
                    this.mwF.a(this.mwF.JH(17), 500L);
                }
                this.boT = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.mxo.b()) {
            WindowManager windowManager = (WindowManager) this.mwE.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null) {
                this.mxo.a(this.mwE, i, this.mwD.dxt().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.mxo.e();
        this.mxo.c();
    }

    public void dyp() {
        this.mxn.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.mxn.getWidth() / 2, this.mxn.getHeight() / 2);
        aVar.setDuration(1000L);
        this.mxn.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.mxs == null && this.mwE != null) {
            if ("3".equals(this.aw)) {
                z = h.dwI().b;
            } else if (this.mwD == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dwI().d;
            } else {
                z = h.dwI().e;
            }
            this.mxs = new CSDanmuLayout(this.mwE.getApplicationContext(), new a.C0847a().JD(-16711936).JC(800).wM(true).wN(this.ap >= 0).JB(2).dJb(), h.dwI().b());
            this.mxs.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.mwE);
            Point fU = tv.chushou.zues.utils.a.fU(this.mwE);
            switch (h.dwI().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.mwE.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mwI / 3;
                    } else {
                        layoutParams.height = fU.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.mwE.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mwI / 3;
                    } else {
                        layoutParams.height = fU.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dyo().addView(this.mxs, 1, layoutParams);
            if (this.mxs != null) {
                this.mxs.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.mxs != null) {
            this.mxs.setVisibility(8);
            this.mxs.dJc();
        }
        if (this.mxs != null) {
            this.mxs.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dla() {
        if (this.mxs != null && this.mwD != null) {
            if (this.ap < 0) {
                this.mxs.setVisibility(h.dwI().d ? 0 : 8);
            } else {
                this.mxs.setVisibility(h.dwI().e ? 0 : 8);
            }
        }
        if (this.mxs != null && this.mxs.isPrepared() && !this.H && !this.al) {
            this.mxs.resume();
            this.mxs.dJc();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.mxB == null) {
            if (this.mxz == null) {
                this.mxz = new ArrayList();
            }
            this.mxz.clear();
            aL(getString(a.i.danmu_settings_no_gift), false);
            aL(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.mwE).mnY != null) {
                if (this.mwD.dxt() != null) {
                    this.mxD = this.mwD.dxt().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.mxD)) {
                    aL(getString(a.i.danmu_settings_no_normal), true);
                    this.mxz.addAll(this.mxD);
                } else {
                    aL(getString(a.i.danmu_settings_no_normal), false);
                }
            } else {
                aL(getString(a.i.danmu_settings_no_normal), false);
            }
            if (i == 3) {
                i2 = a.h.pop_privacy_setting_black;
            } else {
                i2 = a.h.pop_privacy_setting;
            }
            View inflate = LayoutInflater.from(this.mwE).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mwE));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.mxC = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.mwE).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mxC.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mxC.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.mxA = new com.kascend.chushou.player.adapter.b(i, this.mwE, this.mxz, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.mxA);
            if (!tv.chushou.zues.utils.h.isEmpty(this.mxD) && this.mxD.size() >= 5) {
                this.mxB = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwE, 165.0f), tv.chushou.zues.utils.a.dip2px(this.mwE, 354.0f));
            } else {
                this.mxB = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwE, 165.0f), -2);
            }
            this.mxB.setFocusable(true);
            this.mxB.setOutsideTouchable(true);
            this.mxB.setBackgroundDrawable(this.mwE.getResources().getDrawable(a.e.bg_room_pop));
            this.mxB.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dyq() {
        i(2);
    }

    protected void aL(String str, boolean z) {
        PrivacyItem privacyItem = new PrivacyItem();
        privacyItem.mState = 0;
        privacyItem.mMulti = true;
        privacyItem.mType = 3;
        privacyItem.mPopShow = true;
        privacyItem.mText = str;
        privacyItem.mShowing = true;
        if (z) {
            privacyItem.mItemPosition = 7;
        } else {
            privacyItem.mItemPosition = 6;
        }
        if (this.mxz != null) {
            this.mxz.add(privacyItem);
        }
    }

    protected void a(PrivacyItem privacyItem) {
        String str;
        String str2;
        if (getString(a.i.danmu_settings_no_gift).equals(privacyItem.mText)) {
            if (privacyItem.mState == 0) {
                privacyItem.mState = 1;
                d("3");
                str = "0";
            } else {
                privacyItem.mState = 0;
                e("3");
                str = "1";
            }
            str2 = "1";
        } else if (getString(a.i.danmu_settings_no_system).equals(privacyItem.mText)) {
            if (privacyItem.mState == 0) {
                privacyItem.mState = 1;
                d("4", "2");
                str = "0";
            } else {
                privacyItem.mState = 0;
                e("4", "2");
                str = "1";
            }
            str2 = "2";
        } else if (getString(a.i.danmu_settings_no_normal).equals(privacyItem.mText)) {
            if (privacyItem.mState == 0) {
                privacyItem.mState = 1;
                d("1");
                str = "0";
            } else {
                privacyItem.mState = 0;
                e("1");
                str = "1";
            }
            str2 = "3";
        } else {
            b(privacyItem);
            return;
        }
        if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "26", "chatType", str2, "chatState", str, "roomId", this.mwD.dxt().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.mxA.notifyDataSetChanged();
        au();
    }

    protected void au() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.dJP()) {
            tv.chushou.zues.utils.g.c(this.mwE, this.mwE.getString(a.i.s_no_available_network));
        } else if (privacyItem.mType != 3 || privacyItem.mMulti || privacyItem.mState != 1) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("key", privacyItem.mId);
                if (privacyItem.mState == 1) {
                    jSONObject.put("value", 0);
                } else if (privacyItem.mState == 0) {
                    jSONObject.put("value", 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            final int i = privacyItem.mState;
            com.kascend.chushou.c.c.dwE().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.mxA.notifyDataSetChanged();
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject2) {
                    if (jSONObject2.optInt("code", -1) == 0) {
                        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "onSuccess: " + jSONObject2.toString());
                        if (i == 1) {
                            privacyItem.mState = 0;
                        } else if (i == 0) {
                            privacyItem.mState = 1;
                        }
                        g.this.c(privacyItem);
                        g.this.mxA.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.mxA.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.mxz) {
                    if (privacyItem2.mParentId == privacyItem.mId) {
                        privacyItem2.mShowing = false;
                    }
                }
                if (privacyItem.mItemPosition == 2) {
                    privacyItem.mItemPosition = 0;
                } else if (privacyItem.mItemPosition == 3) {
                    privacyItem.mItemPosition = 1;
                }
            } else if (privacyItem.mState == 1) {
                for (PrivacyItem privacyItem3 : this.mxz) {
                    if (privacyItem3.mParentId == privacyItem.mId) {
                        privacyItem3.mShowing = true;
                    }
                }
                if (privacyItem.mItemPosition == 0) {
                    privacyItem.mItemPosition = 2;
                } else if (privacyItem.mItemPosition == 1) {
                    privacyItem.mItemPosition = 3;
                }
            }
        } else if (!privacyItem.mMulti && privacyItem.mType == 3 && privacyItem.mState == 1) {
            for (PrivacyItem privacyItem4 : this.mxz) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.mxF == null) {
            this.mxF = new ArrayList<>();
        }
        this.mxF.add(str);
        this.mxF.add(str2);
        p pVar = new p();
        pVar.a = this.mxF;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.mxF == null) {
            this.mxF = new ArrayList<>();
        }
        this.mxF.add(str);
        p pVar = new p();
        pVar.a = this.mxF;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.mxF != null) {
            this.mxF.remove(str);
            this.mxF.remove(str2);
            p pVar = new p();
            pVar.a = this.mxF;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.mxF != null) {
            this.mxF.remove(str);
            p pVar = new p();
            pVar.a = this.mxF;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dxJ = dxJ();
        if (dxJ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dxJ.getLayoutParams();
            if (i2 == 10) {
                layoutParams.topMargin = i;
                layoutParams.addRule(12, 0);
                layoutParams.bottomMargin = 0;
            } else if (i2 == 12) {
                layoutParams.bottomMargin = i;
                layoutParams.addRule(10, 0);
                layoutParams.topMargin = 0;
            }
            layoutParams.addRule(i2);
            dxJ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dxJ = dxJ();
        if (dxJ != null) {
            dxJ.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dwI().q()) {
                h.dwI().g(false);
                this.mwR.c();
                return;
            }
            h.dwI().g(true);
            this.mwR.b();
        } else if (id == a.f.rl_decode) {
            if (h.dwI().a) {
                h.dwI().a(this.mwE, false);
                this.mwT.c();
            } else {
                h.dwI().a(this.mwE, true);
                this.mwT.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.mwE, dym(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.mwE).q) {
                ((VideoPlayer) this.mwE).q = false;
                if (this.mwD.mpy != null) {
                    this.mwD.mpy.e();
                    this.mwD.mpy.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.mwP.c();
                return;
            }
            ((VideoPlayer) this.mwE).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.mwP.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dwI().o();
            if (this.ap < 0) {
                o = h.dwI().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dwI().b;
            }
            boolean z = !o;
            if (z) {
                this.mwU.b();
            } else {
                this.mwU.c();
            }
            if (!this.aw.equals("1")) {
                h.dwI().a(z);
            } else if (this.ap < 0) {
                h.dwI().e(z);
            } else {
                h.dwI().f(z);
            }
            switch (h.dwI().m()) {
                case 1:
                    d(0);
                    RxExecutor.postDelayed(null, EventThread.MAIN_THREAD, 50L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.9
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.d(1);
                        }
                    });
                    break;
                case 2:
                    d(0);
                    RxExecutor.postDelayed(null, EventThread.MAIN_THREAD, 50L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.10
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.d(2);
                        }
                    });
                    break;
            }
            s(z);
            com.kascend.chushou.toolkit.a.c.c(this.mwE, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.mwE).q) {
                ((VideoPlayer) this.mwE).q = false;
                if (this.mwD.mpy != null) {
                    this.mwD.mpy.e();
                    this.mwD.mpy.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mxC.setImageResource(i);
            } else {
                ((VideoPlayer) this.mwE).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mxC.setImageResource(i2);
            }
            au();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.mxv != null) {
            this.mxv.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0751a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dxT() {
        return null;
    }

    public GiftAnimationLayout dxJ() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dye() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dxw;
        if (this.mwD != null && (dxw = this.mwD.dxw()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dxw.mOnlineCount.equals(str2) || !dxw.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dxw.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dxw.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dye();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dwI().c(true);
        if (this.mxx == null) {
            a();
        }
        if (!this.mxx.isShowing()) {
            if (view != null) {
                this.mxx.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.mwE, 3.0f), (this.mwo.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.mwE, 8.0f));
                RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.mxx != null) {
                            g.this.mxx.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.mxx.dismiss();
    }

    private void a() {
        if (this.mxx == null) {
            View inflate = LayoutInflater.from(this.mwE).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.mwE.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.mwE.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.mxx = new PopupWindow(inflate, -2, -2);
            this.mxx.setFocusable(true);
            this.mxx.setOutsideTouchable(true);
            this.mxx.setAnimationStyle(a.j.gift_toast_style);
            this.mxx.update();
            this.mxx.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.mxx = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
