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
    protected RelativeLayout nnO;
    protected RelativeLayout nnP;
    protected OnlineToggleButton nnQ;
    protected RelativeLayout nnR;
    protected OnlineToggleButton nnS;
    protected RelativeLayout nnT;
    protected OnlineToggleButton nnU;
    protected OnlineToggleButton nnV;
    protected LinearLayout nnW;
    protected PopupWindow nnX;
    protected PopupWindow nnY;
    protected PopupWindow nnZ;
    protected PopupWindow noA;
    protected List<PrivacyItem> noB;
    protected com.kascend.chushou.player.adapter.b noC;
    protected PopupWindow noD;
    protected ImageView noE;
    protected List<PrivacyItem> noF;
    protected FrescoThumbnailView noG;
    protected ArrayList<String> noH;
    protected RecyclerView noa;
    protected LinearLayoutManager nob;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> noc;
    protected ArrayList<a> nod;
    protected ArrayList<a> noe;
    protected PopupWindow nof;
    protected View nog;
    protected SVGAImageView noh;
    protected View noi;
    protected EmanateView noj;
    protected RoomSendGiftView nok;
    protected RoundProgressBar nol;
    protected TextView nom;
    protected FrescoThumbnailView non;
    protected PaoGuideView noo;
    protected AnimatorSet nou;
    protected KasBaseMenuView.a nov;
    protected H5Container nox;
    protected RelativeLayout noy;
    protected PopupWindow noz;
    protected boolean aR = false;
    protected int bb = 0;
    protected long nop = 0;
    protected boolean noq = false;
    protected IconConfig.Config nor = new IconConfig.Config();
    protected CSDanmuLayout nos = null;
    protected boolean bi = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.aa() && g.this.noa != null && g.this.noc != null && g.this.nob != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.nob.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.nob.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.nob.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.nob.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.nob.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.noa.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.nnH != null) {
                                    g.this.nnH.P(g.this.d);
                                    if (g.this.b) {
                                        g.this.nnH.e(g.this.d, 1000L);
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
    public RelativeLayout dKA() {
        if (this.nnO == null) {
            this.nnO = (RelativeLayout) this.nnq.findViewById(a.f.video_root_view);
        }
        return this.nnO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(View view, int i, int i2) {
        if (!this.bi) {
            ag();
        }
        ah();
        if (this.nnX != null) {
            if (!this.nnX.isShowing()) {
                this.nnX.showAtLocation(view, 53, i, i2);
            } else {
                this.nnX.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point gw = tv.chushou.zues.utils.a.gw(this.nnG);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dIP().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dIP().b(1);
                layoutParams.width = -1;
                if (this.nnG.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gw.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dIP().b(2);
                layoutParams.width = -1;
                if (this.nnG.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gw.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.nos != null) {
            this.nos.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(View view, int i, int i2) {
        ae();
        if (this.nnY != null) {
            if (!this.nnY.isShowing()) {
                if (this.nnG.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.nnY.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.nnY.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.nnY.showAtLocation(view, 53, i, i2);
                return;
            }
            this.nnY.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.nnG.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.nnG).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.nnV = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dIP().b) {
                this.nnV.b();
            } else {
                this.nnV.c();
            }
        } else if (this.ap < 0) {
            if (h.dIP().n()) {
                this.nnV.b();
            } else {
                this.nnV.c();
            }
        } else if (h.dIP().o()) {
            this.nnV.b();
        } else {
            this.nnV.c();
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
        switch (h.dIP().m()) {
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
        if (this.nnG.getResources().getConfiguration().orientation == 1) {
            this.nnY = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnG, 230.0f), -2);
            this.nnY.setBackgroundDrawable(this.nnG.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.nnY = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnG, 295.0f), -1);
            this.nnY.setClippingEnabled(false);
            this.nnY.setBackgroundDrawable(this.nnG.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.nnY.setFocusable(true);
        this.nnY.setOutsideTouchable(true);
        this.nnY.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dIP().a(true);
        } else if (this.ap < 0) {
            h.dIP().e(true);
        } else {
            h.dIP().f(true);
        }
        switch (h.dIP().m()) {
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
            if (this.nnG.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.nnG).inflate(i2, (ViewGroup) null);
            this.nnW = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.nnP = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.nnQ = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.nnR = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.nnS = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.nnT = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.nnU = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.nnG.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnG);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.D(10.0f);
                }
                this.nnW.setPadding(this.nnW.getPaddingLeft(), statusBarHeight, this.nnW.getPaddingRight(), this.nnW.getPaddingBottom());
            }
            this.nnP.setOnClickListener(this);
            this.nnR.setOnClickListener(this);
            this.nnT.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.nnP.setVisibility(8);
            } else {
                this.nnP.setVisibility(0);
            }
            if (((VideoPlayer) this.nnG).q) {
                this.nnQ.b();
            } else {
                this.nnQ.c();
            }
            if (h.dIP().q()) {
                this.nnS.b();
            } else {
                this.nnS.c();
            }
            if (com.kascend.chushou.c.a) {
                this.nnT.setVisibility(0);
            } else {
                this.nnT.setVisibility(8);
            }
            if (h.dIP().a) {
                this.nnU.b();
            } else {
                this.nnU.c();
            }
            if (this.nnF != null && (arrayList = this.nnF.f) != null && arrayList.size() > 0) {
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
                            if (this.nnG.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.nnG).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dJC = this.nnF.dJC();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nnG).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.nnG.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.nnG).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nnG, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nnG, 6.0f);
                                    }
                                    int identifier = this.nnG.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nnG.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nnW, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dJC != null && dJC.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.nnW.addView(inflate2);
                            this.bi = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.nnG.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.nnG).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dJC2 = this.nnF.dJC();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nnG).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.nnG.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.nnG).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nnG, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nnG, 6.0f);
                                    }
                                    int identifier2 = this.nnG.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nnG.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nnW, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dJC2 != null && dJC2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.nnW.addView(inflate3);
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
            if (this.nnG.getResources().getConfiguration().orientation == 1) {
                this.nnX = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnG, 230.0f), -2);
                this.nnX.setBackgroundDrawable(this.nnG.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.nnX = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnG, 295.0f), -1);
                this.nnX.setClippingEnabled(false);
                this.nnX.setBackgroundDrawable(this.nnG.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.nnX.setFocusable(true);
            this.nnX.setOutsideTouchable(true);
            this.nnX.update();
        }
    }

    protected void ah() {
        if (this.nnR != null && this.nnS != null) {
            this.nnR.setVisibility(0);
            if (h.dIP().q()) {
                this.nnS.b();
            } else {
                this.nnS.c();
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
        com.kascend.chushou.toolkit.a.c.a(this.nnG, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.nnF.f;
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
            if (this.nnW == null) {
                this.nnF.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.nnF.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.nnG).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nnW.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nnW.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nnG.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nnG.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nnW, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.nnG, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.nnF.f;
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
            if (this.nnW == null) {
                if (!z) {
                    this.nnF.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.nnF.a(playUrl);
                if (this.ap >= 0) {
                    this.nnF.a(false);
                    if (this.nnG != null) {
                        ((VideoPlayer) this.nnG).b(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.nnG).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nnW.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nnW.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nnG.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nnG.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nnW, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.nnX != null) {
            this.nnX.dismiss();
        }
        if (this.nnZ != null) {
            this.nnZ.dismiss();
        }
        PlayUrl dJC = this.nnF.dJC();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.nnF.d) {
                this.nnF.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.nnF.a(playUrl);
                this.nnF.a(false);
                if (this.nnG != null) {
                    ((VideoPlayer) this.nnG).b(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.nnF.d) {
            this.nnF.e = true;
        }
        h.dIP().a(this.nnG, urlDetails.mDefinitionType);
        if (z || (dJC != null && !dJC.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.nnG, dKz(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.nnF.a(playUrl);
            if (dKz()) {
                if (((VideoPlayer) this.nnG) != null) {
                    ((VideoPlayer) this.nnG).r = -1L;
                }
                if (this.nkb != null) {
                    this.mEV = this.nkb.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.nnG).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.nnL = str2;
        if (this.nnH != null) {
            this.nnH.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.aR = true;
            if (this.noe == null) {
                this.noe = new ArrayList<>();
            }
            this.noe.clear();
            this.noe.addAll(list);
            this.nof = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.nof == null) {
            View inflate = LayoutInflater.from(this.nnG).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.nnG.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.nnG.getResources().getColor(a.c.player_bg_color));
            }
            if (this.aR && !tv.chushou.zues.utils.h.isEmpty(this.noe)) {
                this.nod = this.noe;
            } else {
                this.nod = (ArrayList) h.dIP().dIR();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.nod)) {
                String[] stringArray = this.nnG.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.nnG.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.nod == null) {
                    this.nod = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.nod.add(aVar);
                }
            }
            this.noa = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.noc = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.nod, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void B(View view, int i4) {
                    a aVar2;
                    if (g.this.nof != null) {
                        g.this.nof.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.nod) && i4 < g.this.nod.size() && (aVar2 = g.this.nod.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.aR) {
                            g.this.nod.remove(i4);
                            g.this.nod.add(0, aVar2);
                            g.this.noc.notifyDataSetChanged();
                            g.this.noa.scrollToPosition(0);
                            RxExecutor.post(g.this.nnp, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dIP().a((Object) g.this.nod);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.nnG, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.nnF != null && g.this.nnF.dJB() != null && g.this.nnF.dJB().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.nnF.dJB().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0940a view$OnLongClickListenerC0940a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0940a.a(a.f.tv_name, g.this.nnG.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0940a.a(a.f.tv_name, g.this.nnG.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0940a.a(a.f.tv_name, g.this.nnG.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0940a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.nob = new LinearLayoutManager(this.nnG);
            this.noa.setLayoutManager(this.nob);
            this.noa.setAdapter(this.noc);
            this.noa.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.nof = new PopupWindow(inflate, this.nnG.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.nnG.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.nof.setFocusable(true);
            this.nof.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.nof.setBackgroundDrawable(this.nnG.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.nof.setBackgroundDrawable(this.nnG.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.nof.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.nnH.P(this.d);
        this.nnH.r(this.d);
    }

    protected void an() {
        this.b = true;
        this.nnH.P(this.d);
        this.nnH.e(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.nnH != null) {
            this.nnH.P(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bu(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.nnF != null) {
                RoomInfo dJE = this.nnF.dJE();
                if (dJE != null) {
                    str = dJE.mRoomID;
                }
                if (dJE != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dJE.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.nnG, listItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.nnq != null) {
            Point gw = tv.chushou.zues.utils.a.gw(this.nnG);
            int i = gw.x > gw.y ? 1 : 2;
            if (this.nox == null) {
                this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nox.setPlayerViewHelper(this.nnF);
            this.nox.setVisibility(0);
            this.nox.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.nnF != null && (e = this.nnF.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.nox != null) {
            this.nox.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.nog == null && this.noh == null) {
            if (this.nnF.ngD != null) {
                ChatInfo dJz = this.nnF.ngD.dJz();
                if (dJz == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.noy == null) {
                    this.noy = (RelativeLayout) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dJz.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dJz.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dJz.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dJz.mAnimSubType > 0) {
                    dJz.mAnimType = dJz.mAnimSubType;
                }
                if (dJz.mAnimationPluginId == 1) {
                    this.nog = com.kascend.chushou.toolkit.d.a.dKX().a(this.nnG, String.valueOf(dJz.mAnimType), this.noy, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.aa() && g.this.nog != null && g.this.noy != null) {
                                Object tag = g.this.nog.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dKX().a(g.this.nnG, String.valueOf(((ChatInfo) tag).mAnimType), g.this.noy, g.this.nog);
                                }
                                if (!z) {
                                    g.this.nog.setVisibility(8);
                                    g.this.noy.removeView(g.this.nog);
                                    g.this.nog = null;
                                    if (g.this.nnH != null) {
                                        g.this.nnH.removeMessages(11);
                                        g.this.nnH.B(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.nog = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dJz.mJsonData);
                } else if (dJz.mAnimationPluginId == 2) {
                    if (this.noh == null && this.noy != null) {
                        this.noh = (SVGAImageView) this.noy.findViewById(a.f.svgaView);
                        if (this.noh == null) {
                            this.noh = new SVGAImageView(this.nnG);
                            this.noh.setClearsAfterStop(true);
                            this.noh.setLoops(1);
                            this.noh.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.noy.addView(this.noh, layoutParams);
                        }
                    }
                    if (this.noh == null) {
                        cVar.removeMessages(11);
                        cVar.B(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dKX().a(this.nnG, String.valueOf(dJz.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.noh.stopAnimation();
                            g.this.noh.clearAnimation();
                            g.this.noh.setVisibility(8);
                            g.this.noh = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void RB() {
                            g.this.noh.stopAnimation();
                            g.this.noh.clearAnimation();
                            g.this.noh.setVisibility(8);
                            g.this.noh = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void RC() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.noh, dJz);
                }
                if (this.nog != null) {
                    this.nog.setTag(dJz);
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
        if (this.noi == null) {
            if (this.nnF.ngD != null) {
                int g = this.nnF.ngD.g();
                ChatInfo dJA = this.nnF.ngD.dJA();
                if (dJA == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dJA, g);
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
        if (this.noi != null || getContext() == null) {
            if (this.nnH != null) {
                this.nnH.removeMessages(12);
                this.nnH.B(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.noi = this.nnq.findViewById(a.f.rl_show_tip);
            if (this.noi != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dII().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnG);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.noi.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.nnG, 5.0f);
                    this.noi.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.noi = this.nnq.findViewById(a.f.rl_tip);
        }
        if (this.noi != null) {
            this.noi.setVisibility(0);
            this.noi.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.nnF != null) {
                            RoomInfo dJE = g.this.nnF.dJE();
                            if (dJE != null) {
                                str = dJE.mRoomID;
                            }
                            if (dJE != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dJE.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nnG, chatInfo.mItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.noi.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.noi.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.nnF != null) {
                            RoomInfo dJE = g.this.nnF.dJE();
                            if (dJE != null) {
                                str = dJE.mRoomID;
                            }
                            if (dJE != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dJE.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nnG, chatInfo.mItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.nnG.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nnG, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nnG, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0814a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.gw(getContext()).x;
                if (this.nnG.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nnG, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nnG, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0814a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.noi.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.noi != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.noi.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.noi.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.nou == null) {
                                g.this.nou = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.nou.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.nou.removeAllListeners();
                            }
                            g.this.nou.playTogether(ObjectAnimator.ofFloat(g.this.noi, "translationX", g.this.noi.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.nou.start();
                            if (g.this.nnH != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.nnH.B(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void dxy() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!aa() && this.noi != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.noi, "translationX", 0.0f, 10.0f, -this.noi.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.aa()) {
                        if (g.this.noi != null) {
                            g.this.noi.setVisibility(8);
                        }
                        g.this.noi = null;
                        if (g.this.nnH != null) {
                            g.this.nnH.B(12, 800L);
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
            if (this.nou == null) {
                this.nou = new AnimatorSet();
            }
            this.nou.playTogether(duration);
            this.nou.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ar() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.nnG).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.noj = new EmanateView(this.nnG);
            this.noj.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.noj);
            return;
        }
        this.noj = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.nok == null) {
            this.nok = (RoomSendGiftView) this.nnq.findViewById(a.f.normalSendGiftView);
            this.nok.setContext(this.nnG);
            if (this.nnF != null) {
                this.nok.a(this.nnF.dJB());
            }
            this.nok.a(z, z2);
            this.nok.setVisibilityListener(this.nov);
            this.nok.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.noj != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable Ti = tv.chushou.zues.utils.h.Ti(str);
                            if (Ti == null) {
                                Ti = tv.chushou.zues.utils.h.Tk(str);
                            }
                            g.this.noj.setDrawable(Ti, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.noj.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.noj.dWU();
                        }
                    }
                }
            });
            this.nok.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void b(ConfigDetail configDetail) {
                    if (configDetail != null) {
                        g.this.b(configDetail);
                    }
                }

                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void a(boolean z3, boolean z4) {
                    g.this.au(z3, z4);
                }
            });
        }
        if (this.nok != null) {
            if (this.nnF != null) {
                this.nok.a(z ? this.nnF.ngJ : this.nnF.ngK, this.nnF.ngL, this.nnF.ngM, z);
                this.nok.setGiftTopIcon(this.nnF.s);
            }
            if (micMemberInfo != null) {
                this.nok.setMicMemberInfo(micMemberInfo);
            }
            this.nok.c();
        }
    }

    protected void au(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.nol.setProgress(i);
            if (!this.noq) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.nom.setText(this.nnG.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.nom.setText(this.nnG.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.nom.setText(this.nnG.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.non.bU(str, a.e.pao_circle_default);
            if (this.nop != i) {
                this.non.startAnimation(AnimationUtils.loadAnimation(this.nnG, a.C0814a.pao_beat_anim));
                this.nop = i;
            }
            if (this.bb != bangInfo.mLevel) {
                if (this.nnH != null && !this.nnH.LA(17)) {
                    this.nnH.b(this.nnH.LB(17), 500L);
                }
                this.bb = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.noo.b()) {
            WindowManager windowManager = (WindowManager) this.nnG.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                this.noo.a(this.nnG, i, this.nnF.dJB().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.noo.e();
        this.noo.c();
    }

    public void as() {
        this.non.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.non.getWidth() / 2, this.non.getHeight() / 2);
        aVar.setDuration(1000L);
        this.non.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.nos == null && this.nnG != null) {
            if ("3".equals(this.aw)) {
                z = h.dIP().b;
            } else if (this.nnF == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dIP().d;
            } else {
                z = h.dIP().e;
            }
            this.nos = new CSDanmuLayout(this.nnG.getApplicationContext(), new a.C0929a().Lx(-16711936).Lw(800).xH(true).xI(this.ap >= 0).Lv(2).dVP(), h.dIP().b());
            this.nos.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.nnG);
            Point gw = tv.chushou.zues.utils.a.gw(this.nnG);
            switch (h.dIP().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.nnG.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gw.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.nnG.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gw.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dKA().addView(this.nos, 1, layoutParams);
            if (this.nos != null) {
                this.nos.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.nos != null) {
            this.nos.setVisibility(8);
            this.nos.dVQ();
        }
        if (this.nos != null) {
            this.nos.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void S() {
        if (this.nos != null && this.nnF != null) {
            if (this.ap < 0) {
                this.nos.setVisibility(h.dIP().d ? 0 : 8);
            } else {
                this.nos.setVisibility(h.dIP().e ? 0 : 8);
            }
        }
        if (this.nos != null && this.nos.isPrepared() && !this.H && !this.al) {
            this.nos.resume();
            this.nos.dVQ();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.noD == null) {
            if (this.noB == null) {
                this.noB = new ArrayList();
            }
            this.noB.clear();
            ba(getString(a.i.danmu_settings_no_gift), false);
            ba(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.nnG).nfg != null) {
                if (this.nnF.dJB() != null) {
                    this.noF = this.nnF.dJB().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.noF)) {
                    ba(getString(a.i.danmu_settings_no_normal), true);
                    this.noB.addAll(this.noF);
                } else {
                    ba(getString(a.i.danmu_settings_no_normal), false);
                }
            } else {
                ba(getString(a.i.danmu_settings_no_normal), false);
            }
            if (i == 3) {
                i2 = a.h.pop_privacy_setting_black;
            } else {
                i2 = a.h.pop_privacy_setting;
            }
            View inflate = LayoutInflater.from(this.nnG).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.nnG));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.noE = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.nnG).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.noE.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.noE.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.noC = new com.kascend.chushou.player.adapter.b(i, this.nnG, this.noB, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.noC);
            if (!tv.chushou.zues.utils.h.isEmpty(this.noF) && this.noF.size() >= 5) {
                this.noD = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnG, 165.0f), tv.chushou.zues.utils.a.dip2px(this.nnG, 354.0f));
            } else {
                this.noD = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnG, 165.0f), -2);
            }
            this.noD.setFocusable(true);
            this.noD.setOutsideTouchable(true);
            this.noD.setBackgroundDrawable(this.nnG.getResources().getDrawable(a.e.bg_room_pop));
            this.noD.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dKB() {
        i(2);
    }

    protected void ba(String str, boolean z) {
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
        if (this.noB != null) {
            this.noB.add(privacyItem);
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
        if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "26", "chatType", str2, "chatState", str, "roomId", this.nnF.dJB().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.noC.notifyDataSetChanged();
        dKa();
    }

    protected void dKa() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.dWD()) {
            tv.chushou.zues.utils.g.c(this.nnG, this.nnG.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dIL().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.noC.notifyDataSetChanged();
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
                        g.this.noC.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.noC.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.noB) {
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
                for (PrivacyItem privacyItem3 : this.noB) {
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
            for (PrivacyItem privacyItem4 : this.noB) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.noH == null) {
            this.noH = new ArrayList<>();
        }
        this.noH.add(str);
        this.noH.add(str2);
        p pVar = new p();
        pVar.a = this.noH;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.noH == null) {
            this.noH = new ArrayList<>();
        }
        this.noH.add(str);
        p pVar = new p();
        pVar.a = this.noH;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.noH != null) {
            this.noH.remove(str);
            this.noH.remove(str2);
            p pVar = new p();
            pVar.a = this.noH;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.noH != null) {
            this.noH.remove(str);
            p pVar = new p();
            pVar.a = this.noH;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dJW = dJW();
        if (dJW != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dJW.getLayoutParams();
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
            dJW.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dJW = dJW();
        if (dJW != null) {
            dJW.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dIP().q()) {
                h.dIP().g(false);
                this.nnS.c();
                return;
            }
            h.dIP().g(true);
            this.nnS.b();
        } else if (id == a.f.rl_decode) {
            if (h.dIP().a) {
                h.dIP().a(this.nnG, false);
                this.nnU.c();
            } else {
                h.dIP().a(this.nnG, true);
                this.nnU.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.nnG, dKz(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.nnG).q) {
                ((VideoPlayer) this.nnG).q = false;
                if (this.nnF.ngD != null) {
                    this.nnF.ngD.e();
                    this.nnF.ngD.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.nnQ.c();
                return;
            }
            ((VideoPlayer) this.nnG).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.nnQ.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dIP().o();
            if (this.ap < 0) {
                o = h.dIP().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dIP().b;
            }
            boolean z = !o;
            if (z) {
                this.nnV.b();
            } else {
                this.nnV.c();
            }
            if (!this.aw.equals("1")) {
                h.dIP().a(z);
            } else if (this.ap < 0) {
                h.dIP().e(z);
            } else {
                h.dIP().f(z);
            }
            switch (h.dIP().m()) {
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
            com.kascend.chushou.toolkit.a.c.c(this.nnG, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.nnG).q) {
                ((VideoPlayer) this.nnG).q = false;
                if (this.nnF.ngD != null) {
                    this.nnF.ngD.e();
                    this.nnF.ngD.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.noE.setImageResource(i);
            } else {
                ((VideoPlayer) this.nnG).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.noE.setImageResource(i2);
            }
            dKa();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.nox != null) {
            this.nox.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0829a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dKj() {
        return null;
    }

    public GiftAnimationLayout dJW() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dKr() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dJE;
        if (this.nnF != null && (dJE = this.nnF.dJE()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dJE.mOnlineCount.equals(str2) || !dJE.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dJE.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dJE.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dKr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dIP().c(true);
        if (this.noz == null) {
            a();
        }
        if (!this.noz.isShowing()) {
            if (view != null) {
                this.noz.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.nnG, 3.0f), (this.nnq.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.nnG, 8.0f));
                RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.noz != null) {
                            g.this.noz.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.noz.dismiss();
    }

    private void a() {
        if (this.noz == null) {
            View inflate = LayoutInflater.from(this.nnG).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.nnG.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.nnG.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.noz = new PopupWindow(inflate, -2, -2);
            this.noz.setFocusable(true);
            this.noz.setOutsideTouchable(true);
            this.noz.setAnimationStyle(a.j.gift_toast_style);
            this.noz.update();
            this.noz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.noz = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
