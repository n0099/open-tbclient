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
    protected RelativeLayout nQA;
    protected OnlineToggleButton nQB;
    protected OnlineToggleButton nQC;
    protected LinearLayout nQD;
    protected PopupWindow nQE;
    protected PopupWindow nQF;
    protected PopupWindow nQG;
    protected RecyclerView nQH;
    protected LinearLayoutManager nQI;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> nQJ;
    protected ArrayList<a> nQK;
    protected ArrayList<a> nQL;
    protected PopupWindow nQM;
    protected View nQN;
    protected SVGAImageView nQO;
    protected View nQP;
    protected EmanateView nQQ;
    protected RoomSendGiftView nQR;
    protected RoundProgressBar nQS;
    protected TextView nQT;
    protected FrescoThumbnailView nQU;
    protected PaoGuideView nQV;
    protected RelativeLayout nQv;
    protected RelativeLayout nQw;
    protected OnlineToggleButton nQx;
    protected RelativeLayout nQy;
    protected OnlineToggleButton nQz;
    protected AnimatorSet nRa;
    protected KasBaseMenuView.a nRb;
    protected H5Container nRd;
    protected RelativeLayout nRe;
    protected PopupWindow nRf;
    protected PopupWindow nRg;
    protected List<PrivacyItem> nRh;
    protected com.kascend.chushou.player.adapter.b nRi;
    protected PopupWindow nRj;
    protected ImageView nRk;
    protected List<PrivacyItem> nRl;
    protected FrescoThumbnailView nRm;
    protected ArrayList<String> nRn;
    protected boolean aR = false;
    protected int bb = 0;
    protected long nQW = 0;
    protected boolean nQX = false;
    protected IconConfig.Config nQY = new IconConfig.Config();
    protected CSDanmuLayout nQZ = null;
    protected boolean nRc = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.aa() && g.this.nQH != null && g.this.nQJ != null && g.this.nQI != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.nQI.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.nQI.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.nQI.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.nQI.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.nQI.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.nQH.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.nQm != null) {
                                    g.this.nQm.L(g.this.d);
                                    if (g.this.b) {
                                        g.this.nQm.e(g.this.d, 1000L);
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
    public RelativeLayout eaa() {
        if (this.nQv == null) {
            this.nQv = (RelativeLayout) this.nPW.findViewById(a.f.video_root_view);
        }
        return this.nQv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(View view, int i, int i2) {
        if (!this.nRc) {
            vf();
        }
        vg();
        if (this.nQE != null) {
            if (!this.nQE.isShowing()) {
                this.nQE.showAtLocation(view, 53, i, i2);
            } else {
                this.nQE.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point gW = tv.chushou.zues.utils.a.gW(this.nQl);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dYr().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dYr().b(1);
                layoutParams.width = -1;
                if (this.nQl.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gW.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dYr().b(2);
                layoutParams.width = -1;
                if (this.nQl.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gW.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.nQZ != null) {
            this.nQZ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(View view, int i, int i2) {
        dMt();
        if (this.nQF != null) {
            if (!this.nQF.isShowing()) {
                if (this.nQl.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.nQF.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.nQF.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.nQF.showAtLocation(view, 53, i, i2);
                return;
            }
            this.nQF.dismiss();
        }
    }

    protected void dMt() {
        int i = a.h.pop_danmu_full_setting;
        if (this.nQl.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.nQl).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.nQC = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.nQs.equals("1")) {
            if (h.dYr().b) {
                this.nQC.b();
            } else {
                this.nQC.c();
            }
        } else if (this.ap < 0) {
            if (h.dYr().n()) {
                this.nQC.b();
            } else {
                this.nQC.c();
            }
        } else if (h.dYr().o()) {
            this.nQC.b();
        } else {
            this.nQC.c();
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
        switch (h.dYr().m()) {
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
        if (this.nQl.getResources().getConfiguration().orientation == 1) {
            this.nQF = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQl, 230.0f), -2);
            this.nQF.setBackgroundDrawable(this.nQl.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.nQF = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQl, 295.0f), -1);
            this.nQF.setClippingEnabled(false);
            this.nQF.setBackgroundDrawable(this.nQl.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.nQF.setFocusable(true);
        this.nQF.setOutsideTouchable(true);
        this.nQF.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ve() {
        if (!this.nQs.equals("1")) {
            h.dYr().a(true);
        } else if (this.ap < 0) {
            h.dYr().e(true);
        } else {
            h.dYr().f(true);
        }
        switch (h.dYr().m()) {
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

    protected void vf() {
        ArrayList<PlayUrl> arrayList;
        int i;
        if (!this.nRc) {
            int i2 = a.h.pop_full_play_setting;
            if (this.nQl.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.nQl).inflate(i2, (ViewGroup) null);
            this.nQD = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.nQw = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.nQx = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.nQy = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.nQz = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.nQA = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.nQB = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.nQl.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQl);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.H(10.0f);
                }
                this.nQD.setPadding(this.nQD.getPaddingLeft(), statusBarHeight, this.nQD.getPaddingRight(), this.nQD.getPaddingBottom());
            }
            this.nQw.setOnClickListener(this);
            this.nQy.setOnClickListener(this);
            this.nQA.setOnClickListener(this);
            if (!this.nQs.equals("1") || this.ap < 0) {
                this.nQw.setVisibility(8);
            } else {
                this.nQw.setVisibility(0);
            }
            if (((VideoPlayer) this.nQl).q) {
                this.nQx.b();
            } else {
                this.nQx.c();
            }
            if (h.dYr().q()) {
                this.nQz.b();
            } else {
                this.nQz.c();
            }
            if (com.kascend.chushou.c.a) {
                this.nQA.setVisibility(0);
            } else {
                this.nQA.setVisibility(8);
            }
            if (h.dYr().a) {
                this.nQB.b();
            } else {
                this.nQB.c();
            }
            if (this.nQk != null && (arrayList = this.nQk.f) != null && arrayList.size() > 0) {
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
                            if (this.nQl.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.nQl).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dZd = this.nQk.dZd();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nQl).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.nQl.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.nQl).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nQl, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nQl, 6.0f);
                                    }
                                    int identifier = this.nQl.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nQl.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nQD, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dZd != null && dZd.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.nQD.addView(inflate2);
                            this.nRc = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.nQl.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.nQl).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dZd2 = this.nQk.dZd();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nQl).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.nQl.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.nQl).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nQl, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nQl, 6.0f);
                                    }
                                    int identifier2 = this.nQl.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nQl.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nQD, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dZd2 != null && dZd2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.nQD.addView(inflate3);
                            this.nRc = true;
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
            if (this.nQl.getResources().getConfiguration().orientation == 1) {
                this.nQE = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQl, 230.0f), -2);
                this.nQE.setBackgroundDrawable(this.nQl.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.nQE = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQl, 295.0f), -1);
                this.nQE.setClippingEnabled(false);
                this.nQE.setBackgroundDrawable(this.nQl.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.nQE.setFocusable(true);
            this.nQE.setOutsideTouchable(true);
            this.nQE.update();
        }
    }

    protected void vg() {
        if (this.nQy != null && this.nQz != null) {
            this.nQy.setVisibility(0);
            if (h.dYr().q()) {
                this.nQz.b();
            } else {
                this.nQz.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dMw() {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = null;
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() != -1) {
            com.kascend.chushou.d.e.a(0);
        }
        com.kascend.chushou.toolkit.a.c.a(this.nQl, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.nQk.f;
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
            if (this.nQD == null) {
                this.nQk.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.nQk.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.nQl).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nQD.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nQD.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nQl.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nQl.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nQD, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.nQl, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.nQk.f;
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
            if (this.nQD == null) {
                if (!z) {
                    this.nQk.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.nQk.a(playUrl);
                if (this.ap >= 0) {
                    this.nQk.a(false);
                    if (this.nQl != null) {
                        ((VideoPlayer) this.nQl).b(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.nQl).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nQD.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nQD.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nQl.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nQl.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nQD, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.nQE != null) {
            this.nQE.dismiss();
        }
        if (this.nQG != null) {
            this.nQG.dismiss();
        }
        PlayUrl dZd = this.nQk.dZd();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.nQk.d) {
                this.nQk.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.nQk.a(playUrl);
                this.nQk.a(false);
                if (this.nQl != null) {
                    ((VideoPlayer) this.nQl).b(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.nQk.d) {
            this.nQk.e = true;
        }
        h.dYr().a(this.nQl, urlDetails.mDefinitionType);
        if (z || (dZd != null && !dZd.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.nQl, dZZ(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.nQk.a(playUrl);
            if (dZZ()) {
                if (((VideoPlayer) this.nQl) != null) {
                    ((VideoPlayer) this.nQl).r = -1L;
                }
                if (this.nMD != null) {
                    this.nga = this.nMD.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.nQl).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.nQr = str2;
        if (this.nQm != null) {
            this.nQm.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void dZC() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.aR = true;
            if (this.nQL == null) {
                this.nQL = new ArrayList<>();
            }
            this.nQL.clear();
            this.nQL.addAll(list);
            this.nQM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.nQM == null) {
            View inflate = LayoutInflater.from(this.nQl).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.nQl.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.nQl.getResources().getColor(a.c.player_bg_color));
            }
            if (this.aR && !tv.chushou.zues.utils.h.isEmpty(this.nQL)) {
                this.nQK = this.nQL;
            } else {
                this.nQK = (ArrayList) h.dYr().dYt();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.nQK)) {
                String[] stringArray = this.nQl.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.nQl.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.nQK == null) {
                    this.nQK = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.nQK.add(aVar);
                }
            }
            this.nQH = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.nQJ = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.nQK, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void C(View view, int i4) {
                    a aVar2;
                    if (g.this.nQM != null) {
                        g.this.nQM.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.nQK) && i4 < g.this.nQK.size() && (aVar2 = g.this.nQK.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.aR) {
                            g.this.nQK.remove(i4);
                            g.this.nQK.add(0, aVar2);
                            g.this.nQJ.notifyDataSetChanged();
                            g.this.nQH.scrollToPosition(0);
                            RxExecutor.post(g.this.nPV, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dYr().a((Object) g.this.nQK);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.nQl, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.nQk != null && g.this.nQk.dZc() != null && g.this.nQk.dZc().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.nQk.dZc().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC1014a view$OnLongClickListenerC1014a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC1014a.a(a.f.tv_name, g.this.nQl.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC1014a.a(a.f.tv_name, g.this.nQl.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC1014a.a(a.f.tv_name, g.this.nQl.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC1014a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.nQI = new LinearLayoutManager(this.nQl);
            this.nQH.setLayoutManager(this.nQI);
            this.nQH.setAdapter(this.nQJ);
            this.nQH.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                    if (g.this.ap < 0) {
                        if (i4 == 0) {
                            g.this.eab();
                        } else {
                            g.this.ao();
                        }
                    }
                    super.onScrollStateChanged(recyclerView, i4);
                }
            });
            this.nQM = new PopupWindow(inflate, this.nQl.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.nQl.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.nQM.setFocusable(true);
            this.nQM.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.nQM.setBackgroundDrawable(this.nQl.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.nQM.setBackgroundDrawable(this.nQl.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.nQM.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.nQm.L(this.d);
        this.nQm.o(this.d);
    }

    protected void eab() {
        this.b = true;
        this.nQm.L(this.d);
        this.nQm.e(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.nQm != null) {
            this.nQm.L(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bw(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.nQk != null) {
                RoomInfo dZe = this.nQk.dZe();
                if (dZe != null) {
                    str = dZe.mRoomID;
                }
                if (dZe != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dZe.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.nQl, listItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.nPW != null) {
            Point gW = tv.chushou.zues.utils.a.gW(this.nQl);
            int i = gW.x > gW.y ? 1 : 2;
            if (this.nRd == null) {
                this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nRd.setPlayerViewHelper(this.nQk);
            this.nRd.setVisibility(0);
            this.nRd.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.nQk != null && (e = this.nQk.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.nRd != null) {
            this.nRd.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.nQN == null && this.nQO == null) {
            if (this.nQk.nJi != null) {
                ChatInfo dZa = this.nQk.nJi.dZa();
                if (dZa == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.nRe == null) {
                    this.nRe = (RelativeLayout) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dZa.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dZa.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dZa.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dZa.mAnimSubType > 0) {
                    dZa.mAnimType = dZa.mAnimSubType;
                }
                if (dZa.mAnimationPluginId == 1) {
                    this.nQN = com.kascend.chushou.toolkit.d.a.eaz().a(this.nQl, String.valueOf(dZa.mAnimType), this.nRe, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.aa() && g.this.nQN != null && g.this.nRe != null) {
                                Object tag = g.this.nQN.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.eaz().a(g.this.nQl, String.valueOf(((ChatInfo) tag).mAnimType), g.this.nRe, g.this.nQN);
                                }
                                if (!z) {
                                    g.this.nQN.setVisibility(8);
                                    g.this.nRe.removeView(g.this.nQN);
                                    g.this.nQN = null;
                                    if (g.this.nQm != null) {
                                        g.this.nQm.removeMessages(11);
                                        g.this.nQm.B(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.nQN = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dZa.mJsonData);
                } else if (dZa.mAnimationPluginId == 2) {
                    if (this.nQO == null && this.nRe != null) {
                        this.nQO = (SVGAImageView) this.nRe.findViewById(a.f.svgaView);
                        if (this.nQO == null) {
                            this.nQO = new SVGAImageView(this.nQl);
                            this.nQO.setClearsAfterStop(true);
                            this.nQO.setLoops(1);
                            this.nQO.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.nRe.addView(this.nQO, layoutParams);
                        }
                    }
                    if (this.nQO == null) {
                        cVar.removeMessages(11);
                        cVar.B(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.eaz().a(this.nQl, String.valueOf(dZa.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.nQO.stopAnimation();
                            g.this.nQO.clearAnimation();
                            g.this.nQO.setVisibility(8);
                            g.this.nQO = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void XL() {
                            g.this.nQO.stopAnimation();
                            g.this.nQO.clearAnimation();
                            g.this.nQO.setVisibility(8);
                            g.this.nQO = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void XM() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.nQO, dZa);
                }
                if (this.nQN != null) {
                    this.nQN.setTag(dZa);
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
        if (this.nQP == null) {
            if (this.nQk.nJi != null) {
                int g = this.nQk.nJi.g();
                ChatInfo dZb = this.nQk.nJi.dZb();
                if (dZb == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dZb, g);
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
        if (this.nQP != null || getContext() == null) {
            if (this.nQm != null) {
                this.nQm.removeMessages(12);
                this.nQm.B(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.nQP = this.nPW.findViewById(a.f.rl_show_tip);
            if (this.nQP != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dYj().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQl);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nQP.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.nQl, 5.0f);
                    this.nQP.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.nQP = this.nPW.findViewById(a.f.rl_tip);
        }
        if (this.nQP != null) {
            this.nQP.setVisibility(0);
            this.nQP.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.nQk != null) {
                            RoomInfo dZe = g.this.nQk.dZe();
                            if (dZe != null) {
                                str = dZe.mRoomID;
                            }
                            if (dZe != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dZe.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nQl, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.nQP.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.nQP.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.nQk != null) {
                            RoomInfo dZe = g.this.nQk.dZe();
                            if (dZe != null) {
                                str = dZe.mRoomID;
                            }
                            if (dZe != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dZe.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nQl, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.nQl.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nQl, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nQl, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0882a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.gW(getContext()).x;
                if (this.nQl.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nQl, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nQl, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0882a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.nQP.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.nQP != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.nQP.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.nQP.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.nRa == null) {
                                g.this.nRa = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.nRa.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.nRa.removeAllListeners();
                            }
                            g.this.nRa.playTogether(ObjectAnimator.ofFloat(g.this.nQP, "translationX", g.this.nQP.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.nRa.start();
                            if (g.this.nQm != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.nQm.B(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void aq() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!aa() && this.nQP != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.nQP, "translationX", 0.0f, 10.0f, -this.nQP.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.aa()) {
                        if (g.this.nQP != null) {
                            g.this.nQP.setVisibility(8);
                        }
                        g.this.nQP = null;
                        if (g.this.nQm != null) {
                            g.this.nQm.B(12, 800L);
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
            if (this.nRa == null) {
                this.nRa = new AnimatorSet();
            }
            this.nRa.playTogether(duration);
            this.nRa.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dMD() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.nQl).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.nQQ = new EmanateView(this.nQl);
            this.nQQ.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.nQQ);
            return;
        }
        this.nQQ = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.nQR == null) {
            this.nQR = (RoomSendGiftView) this.nPW.findViewById(a.f.normalSendGiftView);
            this.nQR.setContext(this.nQl);
            if (this.nQk != null) {
                this.nQR.a(this.nQk.dZc());
            }
            this.nQR.a(z, z2);
            this.nQR.setVisibilityListener(this.nRb);
            this.nQR.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.nQQ != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable WY = tv.chushou.zues.utils.h.WY(str);
                            if (WY == null) {
                                WY = tv.chushou.zues.utils.h.Xa(str);
                            }
                            g.this.nQQ.setDrawable(WY, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.nQQ.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.nQQ.emy();
                        }
                    }
                }
            });
            this.nQR.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void b(ConfigDetail configDetail) {
                    if (configDetail != null) {
                        g.this.b(configDetail);
                    }
                }

                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void a(boolean z3, boolean z4) {
                    g.this.aB(z3, z4);
                }
            });
        }
        if (this.nQR != null) {
            if (this.nQk != null) {
                this.nQR.a(z ? this.nQk.nJn : this.nQk.nJo, this.nQk.nJp, this.nQk.nJq, z);
                this.nQR.setGiftTopIcon(this.nQk.nJs);
            }
            if (micMemberInfo != null) {
                this.nQR.setMicMemberInfo(micMemberInfo);
            }
            this.nQR.c();
        }
    }

    protected void aB(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.nQS.setProgress(i);
            if (!this.nQX) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.nQT.setText(this.nQl.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.nQT.setText(this.nQl.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.nQT.setText(this.nQl.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.nQU.bX(str, a.e.pao_circle_default);
            if (this.nQW != i) {
                this.nQU.startAnimation(AnimationUtils.loadAnimation(this.nQl, a.C0882a.pao_beat_anim));
                this.nQW = i;
            }
            if (this.bb != bangInfo.mLevel) {
                if (this.nQm != null && !this.nQm.Ox(17)) {
                    this.nQm.b(this.nQm.Oy(17), 500L);
                }
                this.bb = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.nQV.b()) {
            WindowManager windowManager = (WindowManager) this.nQl.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                this.nQV.a(this.nQl, i, this.nQk.dZc().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.nQV.e();
        this.nQV.c();
    }

    public void eac() {
        this.nQU.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.nQU.getWidth() / 2, this.nQU.getHeight() / 2);
        aVar.setDuration(1000L);
        this.nQU.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.nQZ == null && this.nQl != null) {
            if ("3".equals(this.nQs)) {
                z = h.dYr().b;
            } else if (this.nQk == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dYr().d;
            } else {
                z = h.dYr().e;
            }
            this.nQZ = new CSDanmuLayout(this.nQl.getApplicationContext(), new a.C1003a().Ou(-16711936).Ot(800).ze(true).zf(this.ap >= 0).Os(2).elu(), h.dYr().b());
            this.nQZ.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.nQl);
            Point gW = tv.chushou.zues.utils.a.gW(this.nQl);
            switch (h.dYr().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.nQl.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gW.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.nQl.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gW.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            eaa().addView(this.nQZ, 1, layoutParams);
            if (this.nQZ != null) {
                this.nQZ.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.nQZ != null) {
            this.nQZ.setVisibility(8);
            this.nQZ.elv();
        }
        if (this.nQZ != null) {
            this.nQZ.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void S() {
        if (this.nQZ != null && this.nQk != null) {
            if (this.ap < 0) {
                this.nQZ.setVisibility(h.dYr().d ? 0 : 8);
            } else {
                this.nQZ.setVisibility(h.dYr().e ? 0 : 8);
            }
        }
        if (this.nQZ != null && this.nQZ.isPrepared() && !this.H && !this.al) {
            this.nQZ.resume();
            this.nQZ.elv();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.nRj == null) {
            if (this.nRh == null) {
                this.nRh = new ArrayList();
            }
            this.nRh.clear();
            bb(getString(a.i.danmu_settings_no_gift), false);
            bb(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.nQl).nHK != null) {
                if (this.nQk.dZc() != null) {
                    this.nRl = this.nQk.dZc().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.nRl)) {
                    bb(getString(a.i.danmu_settings_no_normal), true);
                    this.nRh.addAll(this.nRl);
                } else {
                    bb(getString(a.i.danmu_settings_no_normal), false);
                }
            } else {
                bb(getString(a.i.danmu_settings_no_normal), false);
            }
            if (i == 3) {
                i2 = a.h.pop_privacy_setting_black;
            } else {
                i2 = a.h.pop_privacy_setting;
            }
            View inflate = LayoutInflater.from(this.nQl).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.nQl));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.nRk = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.nQl).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.nRk.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.nRk.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.nRi = new com.kascend.chushou.player.adapter.b(i, this.nQl, this.nRh, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.nRi);
            if (!tv.chushou.zues.utils.h.isEmpty(this.nRl) && this.nRl.size() >= 5) {
                this.nRj = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQl, 165.0f), tv.chushou.zues.utils.a.dip2px(this.nQl, 354.0f));
            } else {
                this.nRj = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQl, 165.0f), -2);
            }
            this.nRj.setFocusable(true);
            this.nRj.setOutsideTouchable(true);
            this.nRj.setBackgroundDrawable(this.nQl.getResources().getDrawable(a.e.bg_room_pop));
            this.nRj.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ead() {
        i(2);
    }

    protected void bb(String str, boolean z) {
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
        if (this.nRh != null) {
            this.nRh.add(privacyItem);
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
        if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_V8_SO, "chatType", str2, "chatState", str, "roomId", this.nQk.dZc().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.nRi.notifyDataSetChanged();
        au();
    }

    protected void au() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.emh()) {
            tv.chushou.zues.utils.g.c(this.nQl, this.nQl.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dYm().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.nRi.notifyDataSetChanged();
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
                        g.this.nRi.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.nRi.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.nRh) {
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
                for (PrivacyItem privacyItem3 : this.nRh) {
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
            for (PrivacyItem privacyItem4 : this.nRh) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.nRn == null) {
            this.nRn = new ArrayList<>();
        }
        this.nRn.add(str);
        this.nRn.add(str2);
        p pVar = new p();
        pVar.a = this.nRn;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.nRn == null) {
            this.nRn = new ArrayList<>();
        }
        this.nRn.add(str);
        p pVar = new p();
        pVar.a = this.nRn;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.nRn != null) {
            this.nRn.remove(str);
            this.nRn.remove(str2);
            p pVar = new p();
            pVar.a = this.nRn;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.nRn != null) {
            this.nRn.remove(str);
            p pVar = new p();
            pVar.a = this.nRn;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dZw = dZw();
        if (dZw != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dZw.getLayoutParams();
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
            dZw.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dZw = dZw();
        if (dZw != null) {
            dZw.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dYr().q()) {
                h.dYr().g(false);
                this.nQz.c();
                return;
            }
            h.dYr().g(true);
            this.nQz.b();
        } else if (id == a.f.rl_decode) {
            if (h.dYr().a) {
                h.dYr().a(this.nQl, false);
                this.nQB.c();
            } else {
                h.dYr().a(this.nQl, true);
                this.nQB.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.nQl, dZZ(), this.ap < 0);
            dZC();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.nQl).q) {
                ((VideoPlayer) this.nQl).q = false;
                if (this.nQk.nJi != null) {
                    this.nQk.nJi.e();
                    this.nQk.nJi.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.nQx.c();
                return;
            }
            ((VideoPlayer) this.nQl).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.nQx.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dYr().o();
            if (this.ap < 0) {
                o = h.dYr().n();
            }
            if (!this.nQs.equals("1")) {
                o = h.dYr().b;
            }
            boolean z = !o;
            if (z) {
                this.nQC.b();
            } else {
                this.nQC.c();
            }
            if (!this.nQs.equals("1")) {
                h.dYr().a(z);
            } else if (this.ap < 0) {
                h.dYr().e(z);
            } else {
                h.dYr().f(z);
            }
            switch (h.dYr().m()) {
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
            com.kascend.chushou.toolkit.a.c.c(this.nQl, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.nQl).q) {
                ((VideoPlayer) this.nQl).q = false;
                if (this.nQk.nJi != null) {
                    this.nQk.nJi.e();
                    this.nQk.nJi.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.nRk.setImageResource(i);
            } else {
                ((VideoPlayer) this.nQl).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.nRk.setImageResource(i2);
            }
            au();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.nRd != null) {
            this.nRd.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dZH() {
        return null;
    }

    public GiftAnimationLayout dZw() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dZT() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dZe;
        if (this.nQk != null && (dZe = this.nQk.dZe()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dZe.mOnlineCount.equals(str2) || !dZe.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dZe.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dZe.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dZT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dYr().c(true);
        if (this.nRf == null) {
            a();
        }
        if (!this.nRf.isShowing()) {
            if (view != null) {
                this.nRf.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.nQl, 3.0f), (this.nPW.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.nQl, 8.0f));
                RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.nRf != null) {
                            g.this.nRf.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.nRf.dismiss();
    }

    private void a() {
        if (this.nRf == null) {
            View inflate = LayoutInflater.from(this.nQl).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.nQl.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.nQl.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.nRf = new PopupWindow(inflate, -2, -2);
            this.nRf.setFocusable(true);
            this.nRf.setOutsideTouchable(true);
            this.nRf.setAnimationStyle(a.j.gift_toast_style);
            this.nRf.update();
            this.nRf.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.nRf = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
