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
    protected RelativeLayout nnR;
    protected RelativeLayout nnS;
    protected OnlineToggleButton nnT;
    protected RelativeLayout nnU;
    protected OnlineToggleButton nnV;
    protected RelativeLayout nnW;
    protected OnlineToggleButton nnX;
    protected OnlineToggleButton nnY;
    protected LinearLayout nnZ;
    protected H5Container noA;
    protected RelativeLayout noB;
    protected PopupWindow noC;
    protected PopupWindow noD;
    protected List<PrivacyItem> noE;
    protected com.kascend.chushou.player.adapter.b noF;
    protected PopupWindow noG;
    protected ImageView noH;
    protected List<PrivacyItem> noI;
    protected FrescoThumbnailView noJ;
    protected ArrayList<String> noK;
    protected PopupWindow noa;
    protected PopupWindow nob;
    protected PopupWindow noc;
    protected RecyclerView nod;
    protected LinearLayoutManager noe;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> nof;
    protected ArrayList<a> nog;
    protected ArrayList<a> noh;
    protected PopupWindow noi;
    protected View noj;
    protected SVGAImageView nok;
    protected View nol;
    protected EmanateView nom;
    protected RoomSendGiftView non;
    protected RoundProgressBar noo;
    protected TextView nop;
    protected FrescoThumbnailView noq;
    protected PaoGuideView nor;
    protected AnimatorSet noy;
    protected KasBaseMenuView.a noz;
    protected boolean aR = false;
    protected int bb = 0;
    protected long nos = 0;
    protected boolean nou = false;
    protected IconConfig.Config nov = new IconConfig.Config();
    protected CSDanmuLayout nox = null;
    protected boolean bi = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.aa() && g.this.nod != null && g.this.nof != null && g.this.noe != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.noe.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.noe.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.noe.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.noe.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.noe.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.nod.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.nnK != null) {
                                    g.this.nnK.P(g.this.d);
                                    if (g.this.b) {
                                        g.this.nnK.e(g.this.d, 1000L);
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
    public RelativeLayout dKE() {
        if (this.nnR == null) {
            this.nnR = (RelativeLayout) this.nnt.findViewById(a.f.video_root_view);
        }
        return this.nnR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(View view, int i, int i2) {
        if (!this.bi) {
            ag();
        }
        ah();
        if (this.noa != null) {
            if (!this.noa.isShowing()) {
                this.noa.showAtLocation(view, 53, i, i2);
            } else {
                this.noa.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point gw = tv.chushou.zues.utils.a.gw(this.nnJ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dIT().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dIT().b(1);
                layoutParams.width = -1;
                if (this.nnJ.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gw.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dIT().b(2);
                layoutParams.width = -1;
                if (this.nnJ.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gw.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.nox != null) {
            this.nox.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(View view, int i, int i2) {
        ae();
        if (this.nob != null) {
            if (!this.nob.isShowing()) {
                if (this.nnJ.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.nob.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.nob.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.nob.showAtLocation(view, 53, i, i2);
                return;
            }
            this.nob.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.nnJ.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.nnJ).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.nnY = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dIT().b) {
                this.nnY.b();
            } else {
                this.nnY.c();
            }
        } else if (this.ap < 0) {
            if (h.dIT().n()) {
                this.nnY.b();
            } else {
                this.nnY.c();
            }
        } else if (h.dIT().o()) {
            this.nnY.b();
        } else {
            this.nnY.c();
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
        switch (h.dIT().m()) {
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
        if (this.nnJ.getResources().getConfiguration().orientation == 1) {
            this.nob = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnJ, 230.0f), -2);
            this.nob.setBackgroundDrawable(this.nnJ.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.nob = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnJ, 295.0f), -1);
            this.nob.setClippingEnabled(false);
            this.nob.setBackgroundDrawable(this.nnJ.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.nob.setFocusable(true);
        this.nob.setOutsideTouchable(true);
        this.nob.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dIT().a(true);
        } else if (this.ap < 0) {
            h.dIT().e(true);
        } else {
            h.dIT().f(true);
        }
        switch (h.dIT().m()) {
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
            if (this.nnJ.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.nnJ).inflate(i2, (ViewGroup) null);
            this.nnZ = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.nnS = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.nnT = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.nnU = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.nnV = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.nnW = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.nnX = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.nnJ.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnJ);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.D(10.0f);
                }
                this.nnZ.setPadding(this.nnZ.getPaddingLeft(), statusBarHeight, this.nnZ.getPaddingRight(), this.nnZ.getPaddingBottom());
            }
            this.nnS.setOnClickListener(this);
            this.nnU.setOnClickListener(this);
            this.nnW.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.nnS.setVisibility(8);
            } else {
                this.nnS.setVisibility(0);
            }
            if (((VideoPlayer) this.nnJ).q) {
                this.nnT.b();
            } else {
                this.nnT.c();
            }
            if (h.dIT().q()) {
                this.nnV.b();
            } else {
                this.nnV.c();
            }
            if (com.kascend.chushou.c.a) {
                this.nnW.setVisibility(0);
            } else {
                this.nnW.setVisibility(8);
            }
            if (h.dIT().a) {
                this.nnX.b();
            } else {
                this.nnX.c();
            }
            if (this.nnI != null && (arrayList = this.nnI.f) != null && arrayList.size() > 0) {
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
                            if (this.nnJ.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.nnJ).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dJG = this.nnI.dJG();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nnJ).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.nnJ.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.nnJ).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nnJ, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nnJ, 6.0f);
                                    }
                                    int identifier = this.nnJ.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nnJ.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nnZ, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dJG != null && dJG.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.nnZ.addView(inflate2);
                            this.bi = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.nnJ.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.nnJ).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dJG2 = this.nnI.dJG();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nnJ).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.nnJ.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.nnJ).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nnJ, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nnJ, 6.0f);
                                    }
                                    int identifier2 = this.nnJ.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nnJ.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nnZ, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dJG2 != null && dJG2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.nnZ.addView(inflate3);
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
            if (this.nnJ.getResources().getConfiguration().orientation == 1) {
                this.noa = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnJ, 230.0f), -2);
                this.noa.setBackgroundDrawable(this.nnJ.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.noa = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnJ, 295.0f), -1);
                this.noa.setClippingEnabled(false);
                this.noa.setBackgroundDrawable(this.nnJ.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.noa.setFocusable(true);
            this.noa.setOutsideTouchable(true);
            this.noa.update();
        }
    }

    protected void ah() {
        if (this.nnU != null && this.nnV != null) {
            this.nnU.setVisibility(0);
            if (h.dIT().q()) {
                this.nnV.b();
            } else {
                this.nnV.c();
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
        com.kascend.chushou.toolkit.a.c.a(this.nnJ, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.nnI.f;
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
            if (this.nnZ == null) {
                this.nnI.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.nnI.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.nnJ).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nnZ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nnZ.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nnJ.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nnJ.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nnZ, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.nnJ, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.nnI.f;
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
            if (this.nnZ == null) {
                if (!z) {
                    this.nnI.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.nnI.a(playUrl);
                if (this.ap >= 0) {
                    this.nnI.a(false);
                    if (this.nnJ != null) {
                        ((VideoPlayer) this.nnJ).b(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.nnJ).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nnZ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nnZ.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nnJ.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nnJ.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nnZ, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.noa != null) {
            this.noa.dismiss();
        }
        if (this.noc != null) {
            this.noc.dismiss();
        }
        PlayUrl dJG = this.nnI.dJG();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.nnI.d) {
                this.nnI.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.nnI.a(playUrl);
                this.nnI.a(false);
                if (this.nnJ != null) {
                    ((VideoPlayer) this.nnJ).b(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.nnI.d) {
            this.nnI.e = true;
        }
        h.dIT().a(this.nnJ, urlDetails.mDefinitionType);
        if (z || (dJG != null && !dJG.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.nnJ, dKD(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.nnI.a(playUrl);
            if (dKD()) {
                if (((VideoPlayer) this.nnJ) != null) {
                    ((VideoPlayer) this.nnJ).r = -1L;
                }
                if (this.nke != null) {
                    this.mEY = this.nke.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.nnJ).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.nnO = str2;
        if (this.nnK != null) {
            this.nnK.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.aR = true;
            if (this.noh == null) {
                this.noh = new ArrayList<>();
            }
            this.noh.clear();
            this.noh.addAll(list);
            this.noi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.noi == null) {
            View inflate = LayoutInflater.from(this.nnJ).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.nnJ.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.nnJ.getResources().getColor(a.c.player_bg_color));
            }
            if (this.aR && !tv.chushou.zues.utils.h.isEmpty(this.noh)) {
                this.nog = this.noh;
            } else {
                this.nog = (ArrayList) h.dIT().dIV();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.nog)) {
                String[] stringArray = this.nnJ.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.nnJ.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.nog == null) {
                    this.nog = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.nog.add(aVar);
                }
            }
            this.nod = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.nof = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.nog, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void B(View view, int i4) {
                    a aVar2;
                    if (g.this.noi != null) {
                        g.this.noi.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.nog) && i4 < g.this.nog.size() && (aVar2 = g.this.nog.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.aR) {
                            g.this.nog.remove(i4);
                            g.this.nog.add(0, aVar2);
                            g.this.nof.notifyDataSetChanged();
                            g.this.nod.scrollToPosition(0);
                            RxExecutor.post(g.this.nns, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dIT().a((Object) g.this.nog);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.nnJ, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.nnI != null && g.this.nnI.dJF() != null && g.this.nnI.dJF().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.nnI.dJF().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0941a view$OnLongClickListenerC0941a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0941a.a(a.f.tv_name, g.this.nnJ.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0941a.a(a.f.tv_name, g.this.nnJ.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0941a.a(a.f.tv_name, g.this.nnJ.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0941a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.noe = new LinearLayoutManager(this.nnJ);
            this.nod.setLayoutManager(this.noe);
            this.nod.setAdapter(this.nof);
            this.nod.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.noi = new PopupWindow(inflate, this.nnJ.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.nnJ.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.noi.setFocusable(true);
            this.noi.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.noi.setBackgroundDrawable(this.nnJ.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.noi.setBackgroundDrawable(this.nnJ.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.noi.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.nnK.P(this.d);
        this.nnK.r(this.d);
    }

    protected void an() {
        this.b = true;
        this.nnK.P(this.d);
        this.nnK.e(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.nnK != null) {
            this.nnK.P(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bu(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.nnI != null) {
                RoomInfo dJI = this.nnI.dJI();
                if (dJI != null) {
                    str = dJI.mRoomID;
                }
                if (dJI != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dJI.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.nnJ, listItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.nnt != null) {
            Point gw = tv.chushou.zues.utils.a.gw(this.nnJ);
            int i = gw.x > gw.y ? 1 : 2;
            if (this.noA == null) {
                this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.noA.setPlayerViewHelper(this.nnI);
            this.noA.setVisibility(0);
            this.noA.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.nnI != null && (e = this.nnI.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.noA != null) {
            this.noA.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.noj == null && this.nok == null) {
            if (this.nnI.ngG != null) {
                ChatInfo dJD = this.nnI.ngG.dJD();
                if (dJD == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.noB == null) {
                    this.noB = (RelativeLayout) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dJD.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dJD.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dJD.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dJD.mAnimSubType > 0) {
                    dJD.mAnimType = dJD.mAnimSubType;
                }
                if (dJD.mAnimationPluginId == 1) {
                    this.noj = com.kascend.chushou.toolkit.d.a.dLb().a(this.nnJ, String.valueOf(dJD.mAnimType), this.noB, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.aa() && g.this.noj != null && g.this.noB != null) {
                                Object tag = g.this.noj.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dLb().a(g.this.nnJ, String.valueOf(((ChatInfo) tag).mAnimType), g.this.noB, g.this.noj);
                                }
                                if (!z) {
                                    g.this.noj.setVisibility(8);
                                    g.this.noB.removeView(g.this.noj);
                                    g.this.noj = null;
                                    if (g.this.nnK != null) {
                                        g.this.nnK.removeMessages(11);
                                        g.this.nnK.B(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.noj = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dJD.mJsonData);
                } else if (dJD.mAnimationPluginId == 2) {
                    if (this.nok == null && this.noB != null) {
                        this.nok = (SVGAImageView) this.noB.findViewById(a.f.svgaView);
                        if (this.nok == null) {
                            this.nok = new SVGAImageView(this.nnJ);
                            this.nok.setClearsAfterStop(true);
                            this.nok.setLoops(1);
                            this.nok.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.noB.addView(this.nok, layoutParams);
                        }
                    }
                    if (this.nok == null) {
                        cVar.removeMessages(11);
                        cVar.B(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dLb().a(this.nnJ, String.valueOf(dJD.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.nok.stopAnimation();
                            g.this.nok.clearAnimation();
                            g.this.nok.setVisibility(8);
                            g.this.nok = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void RB() {
                            g.this.nok.stopAnimation();
                            g.this.nok.clearAnimation();
                            g.this.nok.setVisibility(8);
                            g.this.nok = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void RC() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.nok, dJD);
                }
                if (this.noj != null) {
                    this.noj.setTag(dJD);
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
        if (this.nol == null) {
            if (this.nnI.ngG != null) {
                int g = this.nnI.ngG.g();
                ChatInfo dJE = this.nnI.ngG.dJE();
                if (dJE == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dJE, g);
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
        if (this.nol != null || getContext() == null) {
            if (this.nnK != null) {
                this.nnK.removeMessages(12);
                this.nnK.B(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.nol = this.nnt.findViewById(a.f.rl_show_tip);
            if (this.nol != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dIM().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnJ);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nol.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.nnJ, 5.0f);
                    this.nol.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.nol = this.nnt.findViewById(a.f.rl_tip);
        }
        if (this.nol != null) {
            this.nol.setVisibility(0);
            this.nol.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.nnI != null) {
                            RoomInfo dJI = g.this.nnI.dJI();
                            if (dJI != null) {
                                str = dJI.mRoomID;
                            }
                            if (dJI != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dJI.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nnJ, chatInfo.mItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.nol.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.nol.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.nnI != null) {
                            RoomInfo dJI = g.this.nnI.dJI();
                            if (dJI != null) {
                                str = dJI.mRoomID;
                            }
                            if (dJI != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dJI.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nnJ, chatInfo.mItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.nnJ.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nnJ, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nnJ, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0815a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.gw(getContext()).x;
                if (this.nnJ.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nnJ, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nnJ, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0815a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.nol.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.nol != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.nol.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.nol.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.noy == null) {
                                g.this.noy = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.noy.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.noy.removeAllListeners();
                            }
                            g.this.noy.playTogether(ObjectAnimator.ofFloat(g.this.nol, "translationX", g.this.nol.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.noy.start();
                            if (g.this.nnK != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.nnK.B(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void dxC() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!aa() && this.nol != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.nol, "translationX", 0.0f, 10.0f, -this.nol.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.aa()) {
                        if (g.this.nol != null) {
                            g.this.nol.setVisibility(8);
                        }
                        g.this.nol = null;
                        if (g.this.nnK != null) {
                            g.this.nnK.B(12, 800L);
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
            if (this.noy == null) {
                this.noy = new AnimatorSet();
            }
            this.noy.playTogether(duration);
            this.noy.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ar() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.nnJ).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.nom = new EmanateView(this.nnJ);
            this.nom.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.nom);
            return;
        }
        this.nom = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.non == null) {
            this.non = (RoomSendGiftView) this.nnt.findViewById(a.f.normalSendGiftView);
            this.non.setContext(this.nnJ);
            if (this.nnI != null) {
                this.non.a(this.nnI.dJF());
            }
            this.non.a(z, z2);
            this.non.setVisibilityListener(this.noz);
            this.non.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.nom != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable Tj = tv.chushou.zues.utils.h.Tj(str);
                            if (Tj == null) {
                                Tj = tv.chushou.zues.utils.h.Tl(str);
                            }
                            g.this.nom.setDrawable(Tj, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.nom.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.nom.dWY();
                        }
                    }
                }
            });
            this.non.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
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
        if (this.non != null) {
            if (this.nnI != null) {
                this.non.a(z ? this.nnI.ngM : this.nnI.ngN, this.nnI.ngO, this.nnI.ngP, z);
                this.non.setGiftTopIcon(this.nnI.s);
            }
            if (micMemberInfo != null) {
                this.non.setMicMemberInfo(micMemberInfo);
            }
            this.non.c();
        }
    }

    protected void au(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.noo.setProgress(i);
            if (!this.nou) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.nop.setText(this.nnJ.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.nop.setText(this.nnJ.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.nop.setText(this.nnJ.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.noq.bU(str, a.e.pao_circle_default);
            if (this.nos != i) {
                this.noq.startAnimation(AnimationUtils.loadAnimation(this.nnJ, a.C0815a.pao_beat_anim));
                this.nos = i;
            }
            if (this.bb != bangInfo.mLevel) {
                if (this.nnK != null && !this.nnK.LA(17)) {
                    this.nnK.b(this.nnK.LB(17), 500L);
                }
                this.bb = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.nor.b()) {
            WindowManager windowManager = (WindowManager) this.nnJ.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                this.nor.a(this.nnJ, i, this.nnI.dJF().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.nor.e();
        this.nor.c();
    }

    public void as() {
        this.noq.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.noq.getWidth() / 2, this.noq.getHeight() / 2);
        aVar.setDuration(1000L);
        this.noq.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.nox == null && this.nnJ != null) {
            if ("3".equals(this.aw)) {
                z = h.dIT().b;
            } else if (this.nnI == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dIT().d;
            } else {
                z = h.dIT().e;
            }
            this.nox = new CSDanmuLayout(this.nnJ.getApplicationContext(), new a.C0930a().Lx(-16711936).Lw(800).xH(true).xI(this.ap >= 0).Lv(2).dVT(), h.dIT().b());
            this.nox.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.nnJ);
            Point gw = tv.chushou.zues.utils.a.gw(this.nnJ);
            switch (h.dIT().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.nnJ.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gw.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.nnJ.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gw.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dKE().addView(this.nox, 1, layoutParams);
            if (this.nox != null) {
                this.nox.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.nox != null) {
            this.nox.setVisibility(8);
            this.nox.dVU();
        }
        if (this.nox != null) {
            this.nox.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void S() {
        if (this.nox != null && this.nnI != null) {
            if (this.ap < 0) {
                this.nox.setVisibility(h.dIT().d ? 0 : 8);
            } else {
                this.nox.setVisibility(h.dIT().e ? 0 : 8);
            }
        }
        if (this.nox != null && this.nox.isPrepared() && !this.H && !this.al) {
            this.nox.resume();
            this.nox.dVU();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.noG == null) {
            if (this.noE == null) {
                this.noE = new ArrayList();
            }
            this.noE.clear();
            ba(getString(a.i.danmu_settings_no_gift), false);
            ba(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.nnJ).nfj != null) {
                if (this.nnI.dJF() != null) {
                    this.noI = this.nnI.dJF().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.noI)) {
                    ba(getString(a.i.danmu_settings_no_normal), true);
                    this.noE.addAll(this.noI);
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
            View inflate = LayoutInflater.from(this.nnJ).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.nnJ));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.noH = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.nnJ).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.noH.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.noH.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.noF = new com.kascend.chushou.player.adapter.b(i, this.nnJ, this.noE, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.noF);
            if (!tv.chushou.zues.utils.h.isEmpty(this.noI) && this.noI.size() >= 5) {
                this.noG = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnJ, 165.0f), tv.chushou.zues.utils.a.dip2px(this.nnJ, 354.0f));
            } else {
                this.noG = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnJ, 165.0f), -2);
            }
            this.noG.setFocusable(true);
            this.noG.setOutsideTouchable(true);
            this.noG.setBackgroundDrawable(this.nnJ.getResources().getDrawable(a.e.bg_room_pop));
            this.noG.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dKF() {
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
        if (this.noE != null) {
            this.noE.add(privacyItem);
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
        if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "26", "chatType", str2, "chatState", str, "roomId", this.nnI.dJF().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.noF.notifyDataSetChanged();
        dKe();
    }

    protected void dKe() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.dWH()) {
            tv.chushou.zues.utils.g.c(this.nnJ, this.nnJ.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dIP().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.noF.notifyDataSetChanged();
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
                        g.this.noF.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.noF.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.noE) {
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
                for (PrivacyItem privacyItem3 : this.noE) {
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
            for (PrivacyItem privacyItem4 : this.noE) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.noK == null) {
            this.noK = new ArrayList<>();
        }
        this.noK.add(str);
        this.noK.add(str2);
        p pVar = new p();
        pVar.a = this.noK;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.noK == null) {
            this.noK = new ArrayList<>();
        }
        this.noK.add(str);
        p pVar = new p();
        pVar.a = this.noK;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.noK != null) {
            this.noK.remove(str);
            this.noK.remove(str2);
            p pVar = new p();
            pVar.a = this.noK;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.noK != null) {
            this.noK.remove(str);
            p pVar = new p();
            pVar.a = this.noK;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dKa = dKa();
        if (dKa != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dKa.getLayoutParams();
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
            dKa.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dKa = dKa();
        if (dKa != null) {
            dKa.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dIT().q()) {
                h.dIT().g(false);
                this.nnV.c();
                return;
            }
            h.dIT().g(true);
            this.nnV.b();
        } else if (id == a.f.rl_decode) {
            if (h.dIT().a) {
                h.dIT().a(this.nnJ, false);
                this.nnX.c();
            } else {
                h.dIT().a(this.nnJ, true);
                this.nnX.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.nnJ, dKD(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.nnJ).q) {
                ((VideoPlayer) this.nnJ).q = false;
                if (this.nnI.ngG != null) {
                    this.nnI.ngG.e();
                    this.nnI.ngG.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.nnT.c();
                return;
            }
            ((VideoPlayer) this.nnJ).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.nnT.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dIT().o();
            if (this.ap < 0) {
                o = h.dIT().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dIT().b;
            }
            boolean z = !o;
            if (z) {
                this.nnY.b();
            } else {
                this.nnY.c();
            }
            if (!this.aw.equals("1")) {
                h.dIT().a(z);
            } else if (this.ap < 0) {
                h.dIT().e(z);
            } else {
                h.dIT().f(z);
            }
            switch (h.dIT().m()) {
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
            com.kascend.chushou.toolkit.a.c.c(this.nnJ, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.nnJ).q) {
                ((VideoPlayer) this.nnJ).q = false;
                if (this.nnI.ngG != null) {
                    this.nnI.ngG.e();
                    this.nnI.ngG.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.noH.setImageResource(i);
            } else {
                ((VideoPlayer) this.nnJ).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.noH.setImageResource(i2);
            }
            dKe();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.noA != null) {
            this.noA.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0830a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dKn() {
        return null;
    }

    public GiftAnimationLayout dKa() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dKv() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dJI;
        if (this.nnI != null && (dJI = this.nnI.dJI()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dJI.mOnlineCount.equals(str2) || !dJI.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dJI.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dJI.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dKv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dIT().c(true);
        if (this.noC == null) {
            a();
        }
        if (!this.noC.isShowing()) {
            if (view != null) {
                this.noC.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.nnJ, 3.0f), (this.nnt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.nnJ, 8.0f));
                RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.noC != null) {
                            g.this.noC.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.noC.dismiss();
    }

    private void a() {
        if (this.noC == null) {
            View inflate = LayoutInflater.from(this.nnJ).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.nnJ.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.nnJ.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.noC = new PopupWindow(inflate, -2, -2);
            this.noC.setFocusable(true);
            this.noC.setOutsideTouchable(true);
            this.noC.setAnimationStyle(a.j.gift_toast_style);
            this.noC.update();
            this.noC.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.noC = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
