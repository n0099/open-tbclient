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
/* loaded from: classes6.dex */
public abstract class g extends f implements View.OnClickListener, CSDanmuLayout.a {
    private int c;
    protected RelativeLayout nwD;
    protected RelativeLayout nwE;
    protected OnlineToggleButton nwF;
    protected RelativeLayout nwG;
    protected OnlineToggleButton nwH;
    protected RelativeLayout nwI;
    protected OnlineToggleButton nwJ;
    protected OnlineToggleButton nwK;
    protected LinearLayout nwL;
    protected PopupWindow nwM;
    protected PopupWindow nwN;
    protected PopupWindow nwO;
    protected RecyclerView nwP;
    protected LinearLayoutManager nwQ;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> nwR;
    protected ArrayList<a> nwS;
    protected ArrayList<a> nwT;
    protected PopupWindow nwU;
    protected View nwV;
    protected SVGAImageView nwW;
    protected View nwX;
    protected EmanateView nwY;
    protected RoomSendGiftView nwZ;
    protected RoundProgressBar nxa;
    protected TextView nxb;
    protected FrescoThumbnailView nxc;
    protected PaoGuideView nxd;
    protected AnimatorSet nxi;
    protected KasBaseMenuView.a nxj;
    protected H5Container nxk;
    protected RelativeLayout nxl;
    protected PopupWindow nxm;
    protected PopupWindow nxn;
    protected List<PrivacyItem> nxo;
    protected com.kascend.chushou.player.adapter.b nxp;
    protected PopupWindow nxq;
    protected ImageView nxr;
    protected List<PrivacyItem> nxs;
    protected FrescoThumbnailView nxt;
    protected ArrayList<String> nxu;
    protected boolean aR = false;
    protected int bb = 0;
    protected long nxe = 0;
    protected boolean nxf = false;
    protected IconConfig.Config nxg = new IconConfig.Config();
    protected CSDanmuLayout nxh = null;
    protected boolean bi = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.aa() && g.this.nwP != null && g.this.nwR != null && g.this.nwQ != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.nwQ.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.nwQ.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.nwQ.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.nwQ.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.nwQ.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.nwP.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.nww != null) {
                                    g.this.nww.O(g.this.d);
                                    if (g.this.b) {
                                        g.this.nww.e(g.this.d, 1000L);
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

    /* loaded from: classes6.dex */
    public static class a implements Serializable {
        private static final long serialVersionUID = -5486819557418455887L;
        public String mStrDisplay;
        public String mStrSend;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RelativeLayout dNZ() {
        if (this.nwD == null) {
            this.nwD = (RelativeLayout) this.nwg.findViewById(a.f.video_root_view);
        }
        return this.nwD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(View view, int i, int i2) {
        if (!this.bi) {
            ag();
        }
        ah();
        if (this.nwM != null) {
            if (!this.nwM.isShowing()) {
                this.nwM.showAtLocation(view, 53, i, i2);
            } else {
                this.nwM.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point gE = tv.chushou.zues.utils.a.gE(this.nwv);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dMo().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dMo().b(1);
                layoutParams.width = -1;
                if (this.nwv.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gE.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dMo().b(2);
                layoutParams.width = -1;
                if (this.nwv.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gE.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.nxh != null) {
            this.nxh.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(View view, int i, int i2) {
        ae();
        if (this.nwN != null) {
            if (!this.nwN.isShowing()) {
                if (this.nwv.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.nwN.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.nwN.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.nwN.showAtLocation(view, 53, i, i2);
                return;
            }
            this.nwN.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.nwv.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.nwv).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.nwK = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dMo().b) {
                this.nwK.b();
            } else {
                this.nwK.c();
            }
        } else if (this.ap < 0) {
            if (h.dMo().n()) {
                this.nwK.b();
            } else {
                this.nwK.c();
            }
        } else if (h.dMo().o()) {
            this.nwK.b();
        } else {
            this.nwK.c();
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
        switch (h.dMo().m()) {
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
        if (this.nwv.getResources().getConfiguration().orientation == 1) {
            this.nwN = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwv, 230.0f), -2);
            this.nwN.setBackgroundDrawable(this.nwv.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.nwN = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwv, 295.0f), -1);
            this.nwN.setClippingEnabled(false);
            this.nwN.setBackgroundDrawable(this.nwv.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.nwN.setFocusable(true);
        this.nwN.setOutsideTouchable(true);
        this.nwN.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dMo().a(true);
        } else if (this.ap < 0) {
            h.dMo().e(true);
        } else {
            h.dMo().f(true);
        }
        switch (h.dMo().m()) {
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
            if (this.nwv.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.nwv).inflate(i2, (ViewGroup) null);
            this.nwL = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.nwE = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.nwF = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.nwG = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.nwH = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.nwI = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.nwJ = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.nwv.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwv);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.D(10.0f);
                }
                this.nwL.setPadding(this.nwL.getPaddingLeft(), statusBarHeight, this.nwL.getPaddingRight(), this.nwL.getPaddingBottom());
            }
            this.nwE.setOnClickListener(this);
            this.nwG.setOnClickListener(this);
            this.nwI.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.nwE.setVisibility(8);
            } else {
                this.nwE.setVisibility(0);
            }
            if (((VideoPlayer) this.nwv).q) {
                this.nwF.b();
            } else {
                this.nwF.c();
            }
            if (h.dMo().q()) {
                this.nwH.b();
            } else {
                this.nwH.c();
            }
            if (com.kascend.chushou.c.a) {
                this.nwI.setVisibility(0);
            } else {
                this.nwI.setVisibility(8);
            }
            if (h.dMo().a) {
                this.nwJ.b();
            } else {
                this.nwJ.c();
            }
            if (this.nwu != null && (arrayList = this.nwu.f) != null && arrayList.size() > 0) {
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
                            if (this.nwv.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.nwv).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dNb = this.nwu.dNb();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nwv).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.nwv.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.nwv).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nwv, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nwv, 6.0f);
                                    }
                                    int identifier = this.nwv.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nwv.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nwL, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dNb != null && dNb.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.nwL.addView(inflate2);
                            this.bi = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.nwv.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.nwv).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dNb2 = this.nwu.dNb();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nwv).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.nwv.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.nwv).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nwv, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nwv, 6.0f);
                                    }
                                    int identifier2 = this.nwv.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nwv.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nwL, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dNb2 != null && dNb2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.nwL.addView(inflate3);
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
            if (this.nwv.getResources().getConfiguration().orientation == 1) {
                this.nwM = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwv, 230.0f), -2);
                this.nwM.setBackgroundDrawable(this.nwv.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.nwM = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwv, 295.0f), -1);
                this.nwM.setClippingEnabled(false);
                this.nwM.setBackgroundDrawable(this.nwv.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.nwM.setFocusable(true);
            this.nwM.setOutsideTouchable(true);
            this.nwM.update();
        }
    }

    protected void ah() {
        if (this.nwG != null && this.nwH != null) {
            this.nwG.setVisibility(0);
            if (h.dMo().q()) {
                this.nwH.b();
            } else {
                this.nwH.c();
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
        com.kascend.chushou.toolkit.a.c.a(this.nwv, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.nwu.f;
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
            if (this.nwL == null) {
                this.nwu.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.nwu.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.nwv).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nwL.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nwL.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nwv.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nwv.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nwL, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.nwv, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.nwu.f;
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
            if (this.nwL == null) {
                if (!z) {
                    this.nwu.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.nwu.a(playUrl);
                if (this.ap >= 0) {
                    this.nwu.a(false);
                    if (this.nwv != null) {
                        ((VideoPlayer) this.nwv).b(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.nwv).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nwL.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nwL.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nwv.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nwv.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nwL, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.nwM != null) {
            this.nwM.dismiss();
        }
        if (this.nwO != null) {
            this.nwO.dismiss();
        }
        PlayUrl dNb = this.nwu.dNb();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.nwu.d) {
                this.nwu.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.nwu.a(playUrl);
                this.nwu.a(false);
                if (this.nwv != null) {
                    ((VideoPlayer) this.nwv).b(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.nwu.d) {
            this.nwu.e = true;
        }
        h.dMo().a(this.nwv, urlDetails.mDefinitionType);
        if (z || (dNb != null && !dNb.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.nwv, dNY(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.nwu.a(playUrl);
            if (dNY()) {
                if (((VideoPlayer) this.nwv) != null) {
                    ((VideoPlayer) this.nwv).r = -1L;
                }
                if (this.nsQ != null) {
                    this.mNc = this.nsQ.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.nwv).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.nwA = str2;
        if (this.nww != null) {
            this.nww.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.aR = true;
            if (this.nwT == null) {
                this.nwT = new ArrayList<>();
            }
            this.nwT.clear();
            this.nwT.addAll(list);
            this.nwU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.nwU == null) {
            View inflate = LayoutInflater.from(this.nwv).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.nwv.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.nwv.getResources().getColor(a.c.player_bg_color));
            }
            if (this.aR && !tv.chushou.zues.utils.h.isEmpty(this.nwT)) {
                this.nwS = this.nwT;
            } else {
                this.nwS = (ArrayList) h.dMo().dMq();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.nwS)) {
                String[] stringArray = this.nwv.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.nwv.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.nwS == null) {
                    this.nwS = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.nwS.add(aVar);
                }
            }
            this.nwP = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.nwR = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.nwS, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void C(View view, int i4) {
                    a aVar2;
                    if (g.this.nwU != null) {
                        g.this.nwU.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.nwS) && i4 < g.this.nwS.size() && (aVar2 = g.this.nwS.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.aR) {
                            g.this.nwS.remove(i4);
                            g.this.nwS.add(0, aVar2);
                            g.this.nwR.notifyDataSetChanged();
                            g.this.nwP.scrollToPosition(0);
                            RxExecutor.post(g.this.nwf, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dMo().a((Object) g.this.nwS);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.nwv, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.nwu != null && g.this.nwu.dNa() != null && g.this.nwu.dNa().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.nwu.dNa().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0956a view$OnLongClickListenerC0956a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0956a.a(a.f.tv_name, g.this.nwv.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0956a.a(a.f.tv_name, g.this.nwv.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0956a.a(a.f.tv_name, g.this.nwv.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0956a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.nwQ = new LinearLayoutManager(this.nwv);
            this.nwP.setLayoutManager(this.nwQ);
            this.nwP.setAdapter(this.nwR);
            this.nwP.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.nwU = new PopupWindow(inflate, this.nwv.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.nwv.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.nwU.setFocusable(true);
            this.nwU.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.nwU.setBackgroundDrawable(this.nwv.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.nwU.setBackgroundDrawable(this.nwv.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.nwU.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.nww.O(this.d);
        this.nww.r(this.d);
    }

    protected void an() {
        this.b = true;
        this.nww.O(this.d);
        this.nww.e(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.nww != null) {
            this.nww.O(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bu(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.nwu != null) {
                RoomInfo dNd = this.nwu.dNd();
                if (dNd != null) {
                    str = dNd.mRoomID;
                }
                if (dNd != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dNd.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.nwv, listItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.nwg != null) {
            Point gE = tv.chushou.zues.utils.a.gE(this.nwv);
            int i = gE.x > gE.y ? 1 : 2;
            if (this.nxk == null) {
                this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nxk.setPlayerViewHelper(this.nwu);
            this.nxk.setVisibility(0);
            this.nxk.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.nwu != null && (e = this.nwu.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.nxk != null) {
            this.nxk.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.nwV == null && this.nwW == null) {
            if (this.nwu.nps != null) {
                ChatInfo dMY = this.nwu.nps.dMY();
                if (dMY == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.nxl == null) {
                    this.nxl = (RelativeLayout) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dMY.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dMY.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dMY.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dMY.mAnimSubType > 0) {
                    dMY.mAnimType = dMY.mAnimSubType;
                }
                if (dMY.mAnimationPluginId == 1) {
                    this.nwV = com.kascend.chushou.toolkit.d.a.dOw().a(this.nwv, String.valueOf(dMY.mAnimType), this.nxl, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.aa() && g.this.nwV != null && g.this.nxl != null) {
                                Object tag = g.this.nwV.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dOw().a(g.this.nwv, String.valueOf(((ChatInfo) tag).mAnimType), g.this.nxl, g.this.nwV);
                                }
                                if (!z) {
                                    g.this.nwV.setVisibility(8);
                                    g.this.nxl.removeView(g.this.nwV);
                                    g.this.nwV = null;
                                    if (g.this.nww != null) {
                                        g.this.nww.removeMessages(11);
                                        g.this.nww.B(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.nwV = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dMY.mJsonData);
                } else if (dMY.mAnimationPluginId == 2) {
                    if (this.nwW == null && this.nxl != null) {
                        this.nwW = (SVGAImageView) this.nxl.findViewById(a.f.svgaView);
                        if (this.nwW == null) {
                            this.nwW = new SVGAImageView(this.nwv);
                            this.nwW.setClearsAfterStop(true);
                            this.nwW.setLoops(1);
                            this.nwW.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.nxl.addView(this.nwW, layoutParams);
                        }
                    }
                    if (this.nwW == null) {
                        cVar.removeMessages(11);
                        cVar.B(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dOw().a(this.nwv, String.valueOf(dMY.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.nwW.stopAnimation();
                            g.this.nwW.clearAnimation();
                            g.this.nwW.setVisibility(8);
                            g.this.nwW = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void RQ() {
                            g.this.nwW.stopAnimation();
                            g.this.nwW.clearAnimation();
                            g.this.nwW.setVisibility(8);
                            g.this.nwW = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void RR() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.nwW, dMY);
                }
                if (this.nwV != null) {
                    this.nwV.setTag(dMY);
                    return;
                }
                return;
            }
            return;
        }
        cVar.removeMessages(11);
        cVar.B(11, 800L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(tv.chushou.zues.c cVar) {
        if (this.nwX == null) {
            if (this.nwu.nps != null) {
                int g = this.nwu.nps.g();
                ChatInfo dMZ = this.nwu.nps.dMZ();
                if (dMZ == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dMZ, g);
                    return;
                }
            }
            return;
        }
        cVar.removeMessages(12);
        cVar.B(12, 800L);
    }

    private void a(final ChatInfo chatInfo, final int i) {
        int i2;
        if (this.nwX != null || getContext() == null) {
            if (this.nww != null) {
                this.nww.removeMessages(12);
                this.nww.B(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.nwX = this.nwg.findViewById(a.f.rl_show_tip);
            if (this.nwX != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dMh().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwv);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nwX.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.nwv, 5.0f);
                    this.nwX.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.nwX = this.nwg.findViewById(a.f.rl_tip);
        }
        if (this.nwX != null) {
            this.nwX.setVisibility(0);
            this.nwX.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.nwu != null) {
                            RoomInfo dNd = g.this.nwu.dNd();
                            if (dNd != null) {
                                str = dNd.mRoomID;
                            }
                            if (dNd != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dNd.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nwv, chatInfo.mItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.nwX.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.nwX.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.nwu != null) {
                            RoomInfo dNd = g.this.nwu.dNd();
                            if (dNd != null) {
                                str = dNd.mRoomID;
                            }
                            if (dNd != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dNd.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nwv, chatInfo.mItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.nwv.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nwv, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nwv, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0824a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.gE(getContext()).x;
                if (this.nwv.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nwv, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nwv, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0824a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.nwX.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.nwX != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.nwX.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.nwX.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.nxi == null) {
                                g.this.nxi = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.nxi.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.nxi.removeAllListeners();
                            }
                            g.this.nxi.playTogether(ObjectAnimator.ofFloat(g.this.nwX, "translationX", g.this.nwX.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.nxi.start();
                            if (g.this.nww != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.nww.B(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void dAO() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!aa() && this.nwX != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.nwX, "translationX", 0.0f, 10.0f, -this.nwX.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.aa()) {
                        if (g.this.nwX != null) {
                            g.this.nwX.setVisibility(8);
                        }
                        g.this.nwX = null;
                        if (g.this.nww != null) {
                            g.this.nww.B(12, 800L);
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
            if (this.nxi == null) {
                this.nxi = new AnimatorSet();
            }
            this.nxi.playTogether(duration);
            this.nxi.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ar() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.nwv).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.nwY = new EmanateView(this.nwv);
            this.nwY.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.nwY);
            return;
        }
        this.nwY = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.nwZ == null) {
            this.nwZ = (RoomSendGiftView) this.nwg.findViewById(a.f.normalSendGiftView);
            this.nwZ.setContext(this.nwv);
            if (this.nwu != null) {
                this.nwZ.a(this.nwu.dNa());
            }
            this.nwZ.a(z, z2);
            this.nwZ.setVisibilityListener(this.nxj);
            this.nwZ.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.nwY != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable TU = tv.chushou.zues.utils.h.TU(str);
                            if (TU == null) {
                                TU = tv.chushou.zues.utils.h.TW(str);
                            }
                            g.this.nwY.setDrawable(TU, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.nwY.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.nwY.eau();
                        }
                    }
                }
            });
            this.nwZ.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void b(ConfigDetail configDetail) {
                    if (configDetail != null) {
                        g.this.b(configDetail);
                    }
                }

                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void a(boolean z3, boolean z4) {
                    g.this.av(z3, z4);
                }
            });
        }
        if (this.nwZ != null) {
            if (this.nwu != null) {
                this.nwZ.a(z ? this.nwu.npy : this.nwu.npz, this.nwu.npA, this.nwu.npB, z);
                this.nwZ.setGiftTopIcon(this.nwu.s);
            }
            if (micMemberInfo != null) {
                this.nwZ.setMicMemberInfo(micMemberInfo);
            }
            this.nwZ.c();
        }
    }

    protected void av(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.nxa.setProgress(i);
            if (!this.nxf) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.nxb.setText(this.nwv.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.nxb.setText(this.nwv.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.nxb.setText(this.nwv.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.nxc.bS(str, a.e.pao_circle_default);
            if (this.nxe != i) {
                this.nxc.startAnimation(AnimationUtils.loadAnimation(this.nwv, a.C0824a.pao_beat_anim));
                this.nxe = i;
            }
            if (this.bb != bangInfo.mLevel) {
                if (this.nww != null && !this.nww.LU(17)) {
                    this.nww.b(this.nww.LV(17), 500L);
                }
                this.bb = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.nxd.b()) {
            WindowManager windowManager = (WindowManager) this.nwv.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                this.nxd.a(this.nwv, i, this.nwu.dNa().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.nxd.e();
        this.nxd.c();
    }

    public void as() {
        this.nxc.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.nxc.getWidth() / 2, this.nxc.getHeight() / 2);
        aVar.setDuration(1000L);
        this.nxc.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.nxh == null && this.nwv != null) {
            if ("3".equals(this.aw)) {
                z = h.dMo().b;
            } else if (this.nwu == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dMo().d;
            } else {
                z = h.dMo().e;
            }
            this.nxh = new CSDanmuLayout(this.nwv.getApplicationContext(), new a.C0945a().LR(-16711936).LQ(800).ym(true).yn(this.ap >= 0).LP(2).dZp(), h.dMo().b());
            this.nxh.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.nwv);
            Point gE = tv.chushou.zues.utils.a.gE(this.nwv);
            switch (h.dMo().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.nwv.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gE.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.nwv.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gE.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dNZ().addView(this.nxh, 1, layoutParams);
            if (this.nxh != null) {
                this.nxh.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.nxh != null) {
            this.nxh.setVisibility(8);
            this.nxh.dZq();
        }
        if (this.nxh != null) {
            this.nxh.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void S() {
        if (this.nxh != null && this.nwu != null) {
            if (this.ap < 0) {
                this.nxh.setVisibility(h.dMo().d ? 0 : 8);
            } else {
                this.nxh.setVisibility(h.dMo().e ? 0 : 8);
            }
        }
        if (this.nxh != null && this.nxh.isPrepared() && !this.H && !this.al) {
            this.nxh.resume();
            this.nxh.dZq();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.nxq == null) {
            if (this.nxo == null) {
                this.nxo = new ArrayList();
            }
            this.nxo.clear();
            aX(getString(a.i.danmu_settings_no_gift), false);
            aX(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.nwv).nnS != null) {
                if (this.nwu.dNa() != null) {
                    this.nxs = this.nwu.dNa().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.nxs)) {
                    aX(getString(a.i.danmu_settings_no_normal), true);
                    this.nxo.addAll(this.nxs);
                } else {
                    aX(getString(a.i.danmu_settings_no_normal), false);
                }
            } else {
                aX(getString(a.i.danmu_settings_no_normal), false);
            }
            if (i == 3) {
                i2 = a.h.pop_privacy_setting_black;
            } else {
                i2 = a.h.pop_privacy_setting;
            }
            View inflate = LayoutInflater.from(this.nwv).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.nwv));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.nxr = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.nwv).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.nxr.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.nxr.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.nxp = new com.kascend.chushou.player.adapter.b(i, this.nwv, this.nxo, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.nxp);
            if (!tv.chushou.zues.utils.h.isEmpty(this.nxs) && this.nxs.size() >= 5) {
                this.nxq = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwv, 165.0f), tv.chushou.zues.utils.a.dip2px(this.nwv, 354.0f));
            } else {
                this.nxq = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwv, 165.0f), -2);
            }
            this.nxq.setFocusable(true);
            this.nxq.setOutsideTouchable(true);
            this.nxq.setBackgroundDrawable(this.nwv.getResources().getDrawable(a.e.bg_room_pop));
            this.nxq.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dOa() {
        i(2);
    }

    protected void aX(String str, boolean z) {
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
        if (this.nxo != null) {
            this.nxo.add(privacyItem);
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
        if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_V8_SO, "chatType", str2, "chatState", str, "roomId", this.nwu.dNa().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.nxp.notifyDataSetChanged();
        dNz();
    }

    protected void dNz() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.ead()) {
            tv.chushou.zues.utils.g.c(this.nwv, this.nwv.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dMk().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.nxp.notifyDataSetChanged();
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
                        g.this.nxp.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.nxp.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.nxo) {
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
                for (PrivacyItem privacyItem3 : this.nxo) {
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
            for (PrivacyItem privacyItem4 : this.nxo) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.nxu == null) {
            this.nxu = new ArrayList<>();
        }
        this.nxu.add(str);
        this.nxu.add(str2);
        p pVar = new p();
        pVar.a = this.nxu;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.nxu == null) {
            this.nxu = new ArrayList<>();
        }
        this.nxu.add(str);
        p pVar = new p();
        pVar.a = this.nxu;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.nxu != null) {
            this.nxu.remove(str);
            this.nxu.remove(str2);
            p pVar = new p();
            pVar.a = this.nxu;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.nxu != null) {
            this.nxu.remove(str);
            p pVar = new p();
            pVar.a = this.nxu;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dNv = dNv();
        if (dNv != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dNv.getLayoutParams();
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
            dNv.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dNv = dNv();
        if (dNv != null) {
            dNv.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dMo().q()) {
                h.dMo().g(false);
                this.nwH.c();
                return;
            }
            h.dMo().g(true);
            this.nwH.b();
        } else if (id == a.f.rl_decode) {
            if (h.dMo().a) {
                h.dMo().a(this.nwv, false);
                this.nwJ.c();
            } else {
                h.dMo().a(this.nwv, true);
                this.nwJ.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.nwv, dNY(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.nwv).q) {
                ((VideoPlayer) this.nwv).q = false;
                if (this.nwu.nps != null) {
                    this.nwu.nps.e();
                    this.nwu.nps.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.nwF.c();
                return;
            }
            ((VideoPlayer) this.nwv).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.nwF.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dMo().o();
            if (this.ap < 0) {
                o = h.dMo().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dMo().b;
            }
            boolean z = !o;
            if (z) {
                this.nwK.b();
            } else {
                this.nwK.c();
            }
            if (!this.aw.equals("1")) {
                h.dMo().a(z);
            } else if (this.ap < 0) {
                h.dMo().e(z);
            } else {
                h.dMo().f(z);
            }
            switch (h.dMo().m()) {
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
            com.kascend.chushou.toolkit.a.c.c(this.nwv, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.nwv).q) {
                ((VideoPlayer) this.nwv).q = false;
                if (this.nwu.nps != null) {
                    this.nwu.nps.e();
                    this.nwu.nps.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.nxr.setImageResource(i);
            } else {
                ((VideoPlayer) this.nwv).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.nxr.setImageResource(i2);
            }
            dNz();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.nxk != null) {
            this.nxk.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dNI() {
        return null;
    }

    public GiftAnimationLayout dNv() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dNQ() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dNd;
        if (this.nwu != null && (dNd = this.nwu.dNd()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dNd.mOnlineCount.equals(str2) || !dNd.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dNd.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dNd.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dNQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dMo().c(true);
        if (this.nxm == null) {
            a();
        }
        if (!this.nxm.isShowing()) {
            if (view != null) {
                this.nxm.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.nwv, 3.0f), (this.nwg.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.nwv, 8.0f));
                RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.nxm != null) {
                            g.this.nxm.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.nxm.dismiss();
    }

    private void a() {
        if (this.nxm == null) {
            View inflate = LayoutInflater.from(this.nwv).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.nwv.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.nwv.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.nxm = new PopupWindow(inflate, -2, -2);
            this.nxm.setFocusable(true);
            this.nxm.setOutsideTouchable(true);
            this.nxm.setAnimationStyle(a.j.gift_toast_style);
            this.nxm.update();
            this.nxm.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.nxm = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
