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
    protected RelativeLayout nQN;
    protected RelativeLayout nQO;
    protected OnlineToggleButton nQP;
    protected RelativeLayout nQQ;
    protected OnlineToggleButton nQR;
    protected RelativeLayout nQS;
    protected OnlineToggleButton nQT;
    protected OnlineToggleButton nQU;
    protected LinearLayout nQV;
    protected PopupWindow nQW;
    protected PopupWindow nQX;
    protected PopupWindow nQY;
    protected RecyclerView nQZ;
    protected com.kascend.chushou.player.adapter.b nRA;
    protected PopupWindow nRB;
    protected ImageView nRC;
    protected List<PrivacyItem> nRD;
    protected FrescoThumbnailView nRE;
    protected ArrayList<String> nRF;
    protected LinearLayoutManager nRa;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> nRb;
    protected ArrayList<a> nRc;
    protected ArrayList<a> nRd;
    protected PopupWindow nRe;
    protected View nRf;
    protected SVGAImageView nRg;
    protected View nRh;
    protected EmanateView nRi;
    protected RoomSendGiftView nRj;
    protected RoundProgressBar nRk;
    protected TextView nRl;
    protected FrescoThumbnailView nRm;
    protected PaoGuideView nRn;
    protected AnimatorSet nRs;
    protected KasBaseMenuView.a nRt;
    protected H5Container nRv;
    protected RelativeLayout nRw;
    protected PopupWindow nRx;
    protected PopupWindow nRy;
    protected List<PrivacyItem> nRz;
    protected boolean aR = false;
    protected int bb = 0;
    protected long nRo = 0;
    protected boolean nRp = false;
    protected IconConfig.Config nRq = new IconConfig.Config();
    protected CSDanmuLayout nRr = null;
    protected boolean nRu = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.aa() && g.this.nQZ != null && g.this.nRb != null && g.this.nRa != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.nRa.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.nRa.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.nRa.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.nRa.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.nRa.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.nQZ.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.nQE != null) {
                                    g.this.nQE.L(g.this.d);
                                    if (g.this.b) {
                                        g.this.nQE.e(g.this.d, 1000L);
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
    public RelativeLayout eaj() {
        if (this.nQN == null) {
            this.nQN = (RelativeLayout) this.nQo.findViewById(a.f.video_root_view);
        }
        return this.nQN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(View view, int i, int i2) {
        if (!this.nRu) {
            vf();
        }
        vg();
        if (this.nQW != null) {
            if (!this.nQW.isShowing()) {
                this.nQW.showAtLocation(view, 53, i, i2);
            } else {
                this.nQW.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point gW = tv.chushou.zues.utils.a.gW(this.nQD);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dYA().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dYA().b(1);
                layoutParams.width = -1;
                if (this.nQD.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gW.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dYA().b(2);
                layoutParams.width = -1;
                if (this.nQD.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gW.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.nRr != null) {
            this.nRr.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(View view, int i, int i2) {
        dMC();
        if (this.nQX != null) {
            if (!this.nQX.isShowing()) {
                if (this.nQD.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.nQX.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.nQX.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.nQX.showAtLocation(view, 53, i, i2);
                return;
            }
            this.nQX.dismiss();
        }
    }

    protected void dMC() {
        int i = a.h.pop_danmu_full_setting;
        if (this.nQD.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.nQD).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.nQU = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.nQK.equals("1")) {
            if (h.dYA().b) {
                this.nQU.b();
            } else {
                this.nQU.c();
            }
        } else if (this.ap < 0) {
            if (h.dYA().n()) {
                this.nQU.b();
            } else {
                this.nQU.c();
            }
        } else if (h.dYA().o()) {
            this.nQU.b();
        } else {
            this.nQU.c();
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
        switch (h.dYA().m()) {
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
        if (this.nQD.getResources().getConfiguration().orientation == 1) {
            this.nQX = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQD, 230.0f), -2);
            this.nQX.setBackgroundDrawable(this.nQD.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.nQX = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQD, 295.0f), -1);
            this.nQX.setClippingEnabled(false);
            this.nQX.setBackgroundDrawable(this.nQD.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.nQX.setFocusable(true);
        this.nQX.setOutsideTouchable(true);
        this.nQX.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ve() {
        if (!this.nQK.equals("1")) {
            h.dYA().a(true);
        } else if (this.ap < 0) {
            h.dYA().e(true);
        } else {
            h.dYA().f(true);
        }
        switch (h.dYA().m()) {
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
        if (!this.nRu) {
            int i2 = a.h.pop_full_play_setting;
            if (this.nQD.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.nQD).inflate(i2, (ViewGroup) null);
            this.nQV = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.nQO = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.nQP = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.nQQ = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.nQR = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.nQS = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.nQT = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.nQD.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQD);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.H(10.0f);
                }
                this.nQV.setPadding(this.nQV.getPaddingLeft(), statusBarHeight, this.nQV.getPaddingRight(), this.nQV.getPaddingBottom());
            }
            this.nQO.setOnClickListener(this);
            this.nQQ.setOnClickListener(this);
            this.nQS.setOnClickListener(this);
            if (!this.nQK.equals("1") || this.ap < 0) {
                this.nQO.setVisibility(8);
            } else {
                this.nQO.setVisibility(0);
            }
            if (((VideoPlayer) this.nQD).q) {
                this.nQP.b();
            } else {
                this.nQP.c();
            }
            if (h.dYA().q()) {
                this.nQR.b();
            } else {
                this.nQR.c();
            }
            if (com.kascend.chushou.c.a) {
                this.nQS.setVisibility(0);
            } else {
                this.nQS.setVisibility(8);
            }
            if (h.dYA().a) {
                this.nQT.b();
            } else {
                this.nQT.c();
            }
            if (this.nQC != null && (arrayList = this.nQC.f) != null && arrayList.size() > 0) {
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
                            if (this.nQD.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.nQD).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dZm = this.nQC.dZm();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nQD).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.nQD.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.nQD).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nQD, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nQD, 6.0f);
                                    }
                                    int identifier = this.nQD.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nQD.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nQV, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dZm != null && dZm.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.nQV.addView(inflate2);
                            this.nRu = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.nQD.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.nQD).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dZm2 = this.nQC.dZm();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nQD).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.nQD.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.nQD).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nQD, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nQD, 6.0f);
                                    }
                                    int identifier2 = this.nQD.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nQD.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nQV, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dZm2 != null && dZm2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.nQV.addView(inflate3);
                            this.nRu = true;
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
            if (this.nQD.getResources().getConfiguration().orientation == 1) {
                this.nQW = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQD, 230.0f), -2);
                this.nQW.setBackgroundDrawable(this.nQD.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.nQW = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQD, 295.0f), -1);
                this.nQW.setClippingEnabled(false);
                this.nQW.setBackgroundDrawable(this.nQD.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.nQW.setFocusable(true);
            this.nQW.setOutsideTouchable(true);
            this.nQW.update();
        }
    }

    protected void vg() {
        if (this.nQQ != null && this.nQR != null) {
            this.nQQ.setVisibility(0);
            if (h.dYA().q()) {
                this.nQR.b();
            } else {
                this.nQR.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dMF() {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = null;
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() != -1) {
            com.kascend.chushou.d.e.a(0);
        }
        com.kascend.chushou.toolkit.a.c.a(this.nQD, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.nQC.f;
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
            if (this.nQV == null) {
                this.nQC.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.nQC.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.nQD).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nQV.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nQV.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nQD.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nQD.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nQV, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.nQD, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.nQC.f;
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
            if (this.nQV == null) {
                if (!z) {
                    this.nQC.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.nQC.a(playUrl);
                if (this.ap >= 0) {
                    this.nQC.a(false);
                    if (this.nQD != null) {
                        ((VideoPlayer) this.nQD).b(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.nQD).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nQV.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nQV.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nQD.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nQD.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nQV, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.nQW != null) {
            this.nQW.dismiss();
        }
        if (this.nQY != null) {
            this.nQY.dismiss();
        }
        PlayUrl dZm = this.nQC.dZm();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.nQC.d) {
                this.nQC.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.nQC.a(playUrl);
                this.nQC.a(false);
                if (this.nQD != null) {
                    ((VideoPlayer) this.nQD).b(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.nQC.d) {
            this.nQC.e = true;
        }
        h.dYA().a(this.nQD, urlDetails.mDefinitionType);
        if (z || (dZm != null && !dZm.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.nQD, eai(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.nQC.a(playUrl);
            if (eai()) {
                if (((VideoPlayer) this.nQD) != null) {
                    ((VideoPlayer) this.nQD).r = -1L;
                }
                if (this.nMV != null) {
                    this.ngs = this.nMV.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.nQD).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.nQJ = str2;
        if (this.nQE != null) {
            this.nQE.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void dZL() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.aR = true;
            if (this.nRd == null) {
                this.nRd = new ArrayList<>();
            }
            this.nRd.clear();
            this.nRd.addAll(list);
            this.nRe = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.nRe == null) {
            View inflate = LayoutInflater.from(this.nQD).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.nQD.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.nQD.getResources().getColor(a.c.player_bg_color));
            }
            if (this.aR && !tv.chushou.zues.utils.h.isEmpty(this.nRd)) {
                this.nRc = this.nRd;
            } else {
                this.nRc = (ArrayList) h.dYA().dYC();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.nRc)) {
                String[] stringArray = this.nQD.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.nQD.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.nRc == null) {
                    this.nRc = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.nRc.add(aVar);
                }
            }
            this.nQZ = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.nRb = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.nRc, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void C(View view, int i4) {
                    a aVar2;
                    if (g.this.nRe != null) {
                        g.this.nRe.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.nRc) && i4 < g.this.nRc.size() && (aVar2 = g.this.nRc.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.aR) {
                            g.this.nRc.remove(i4);
                            g.this.nRc.add(0, aVar2);
                            g.this.nRb.notifyDataSetChanged();
                            g.this.nQZ.scrollToPosition(0);
                            RxExecutor.post(g.this.nQn, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dYA().a((Object) g.this.nRc);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.nQD, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.nQC != null && g.this.nQC.dZl() != null && g.this.nQC.dZl().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.nQC.dZl().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC1014a view$OnLongClickListenerC1014a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC1014a.a(a.f.tv_name, g.this.nQD.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC1014a.a(a.f.tv_name, g.this.nQD.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC1014a.a(a.f.tv_name, g.this.nQD.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC1014a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.nRa = new LinearLayoutManager(this.nQD);
            this.nQZ.setLayoutManager(this.nRa);
            this.nQZ.setAdapter(this.nRb);
            this.nQZ.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                    if (g.this.ap < 0) {
                        if (i4 == 0) {
                            g.this.eak();
                        } else {
                            g.this.ao();
                        }
                    }
                    super.onScrollStateChanged(recyclerView, i4);
                }
            });
            this.nRe = new PopupWindow(inflate, this.nQD.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.nQD.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.nRe.setFocusable(true);
            this.nRe.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.nRe.setBackgroundDrawable(this.nQD.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.nRe.setBackgroundDrawable(this.nQD.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.nRe.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.nQE.L(this.d);
        this.nQE.o(this.d);
    }

    protected void eak() {
        this.b = true;
        this.nQE.L(this.d);
        this.nQE.e(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.nQE != null) {
            this.nQE.L(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bw(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.nQC != null) {
                RoomInfo dZn = this.nQC.dZn();
                if (dZn != null) {
                    str = dZn.mRoomID;
                }
                if (dZn != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dZn.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.nQD, listItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.nQo != null) {
            Point gW = tv.chushou.zues.utils.a.gW(this.nQD);
            int i = gW.x > gW.y ? 1 : 2;
            if (this.nRv == null) {
                this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nRv.setPlayerViewHelper(this.nQC);
            this.nRv.setVisibility(0);
            this.nRv.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.nQC != null && (e = this.nQC.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.nRv != null) {
            this.nRv.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.nRf == null && this.nRg == null) {
            if (this.nQC.nJA != null) {
                ChatInfo dZj = this.nQC.nJA.dZj();
                if (dZj == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.nRw == null) {
                    this.nRw = (RelativeLayout) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dZj.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dZj.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dZj.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dZj.mAnimSubType > 0) {
                    dZj.mAnimType = dZj.mAnimSubType;
                }
                if (dZj.mAnimationPluginId == 1) {
                    this.nRf = com.kascend.chushou.toolkit.d.a.eaI().a(this.nQD, String.valueOf(dZj.mAnimType), this.nRw, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.aa() && g.this.nRf != null && g.this.nRw != null) {
                                Object tag = g.this.nRf.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.eaI().a(g.this.nQD, String.valueOf(((ChatInfo) tag).mAnimType), g.this.nRw, g.this.nRf);
                                }
                                if (!z) {
                                    g.this.nRf.setVisibility(8);
                                    g.this.nRw.removeView(g.this.nRf);
                                    g.this.nRf = null;
                                    if (g.this.nQE != null) {
                                        g.this.nQE.removeMessages(11);
                                        g.this.nQE.B(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.nRf = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dZj.mJsonData);
                } else if (dZj.mAnimationPluginId == 2) {
                    if (this.nRg == null && this.nRw != null) {
                        this.nRg = (SVGAImageView) this.nRw.findViewById(a.f.svgaView);
                        if (this.nRg == null) {
                            this.nRg = new SVGAImageView(this.nQD);
                            this.nRg.setClearsAfterStop(true);
                            this.nRg.setLoops(1);
                            this.nRg.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.nRw.addView(this.nRg, layoutParams);
                        }
                    }
                    if (this.nRg == null) {
                        cVar.removeMessages(11);
                        cVar.B(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.eaI().a(this.nQD, String.valueOf(dZj.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.nRg.stopAnimation();
                            g.this.nRg.clearAnimation();
                            g.this.nRg.setVisibility(8);
                            g.this.nRg = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void XL() {
                            g.this.nRg.stopAnimation();
                            g.this.nRg.clearAnimation();
                            g.this.nRg.setVisibility(8);
                            g.this.nRg = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void XM() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.nRg, dZj);
                }
                if (this.nRf != null) {
                    this.nRf.setTag(dZj);
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
        if (this.nRh == null) {
            if (this.nQC.nJA != null) {
                int g = this.nQC.nJA.g();
                ChatInfo dZk = this.nQC.nJA.dZk();
                if (dZk == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dZk, g);
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
        if (this.nRh != null || getContext() == null) {
            if (this.nQE != null) {
                this.nQE.removeMessages(12);
                this.nQE.B(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.nRh = this.nQo.findViewById(a.f.rl_show_tip);
            if (this.nRh != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dYs().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQD);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nRh.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.nQD, 5.0f);
                    this.nRh.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.nRh = this.nQo.findViewById(a.f.rl_tip);
        }
        if (this.nRh != null) {
            this.nRh.setVisibility(0);
            this.nRh.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.nQC != null) {
                            RoomInfo dZn = g.this.nQC.dZn();
                            if (dZn != null) {
                                str = dZn.mRoomID;
                            }
                            if (dZn != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dZn.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nQD, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.nRh.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.nRh.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.nQC != null) {
                            RoomInfo dZn = g.this.nQC.dZn();
                            if (dZn != null) {
                                str = dZn.mRoomID;
                            }
                            if (dZn != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dZn.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nQD, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.nQD.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nQD, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nQD, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                if (this.nQD.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nQD, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nQD, a.c.black), simpleDraweeSpanTextView)) {
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
            ViewTreeObserver viewTreeObserver = this.nRh.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.nRh != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.nRh.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.nRh.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.nRs == null) {
                                g.this.nRs = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.nRs.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.nRs.removeAllListeners();
                            }
                            g.this.nRs.playTogether(ObjectAnimator.ofFloat(g.this.nRh, "translationX", g.this.nRh.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.nRs.start();
                            if (g.this.nQE != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.nQE.B(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void aq() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!aa() && this.nRh != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.nRh, "translationX", 0.0f, 10.0f, -this.nRh.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.aa()) {
                        if (g.this.nRh != null) {
                            g.this.nRh.setVisibility(8);
                        }
                        g.this.nRh = null;
                        if (g.this.nQE != null) {
                            g.this.nQE.B(12, 800L);
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
            if (this.nRs == null) {
                this.nRs = new AnimatorSet();
            }
            this.nRs.playTogether(duration);
            this.nRs.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dMM() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.nQD).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.nRi = new EmanateView(this.nQD);
            this.nRi.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.nRi);
            return;
        }
        this.nRi = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.nRj == null) {
            this.nRj = (RoomSendGiftView) this.nQo.findViewById(a.f.normalSendGiftView);
            this.nRj.setContext(this.nQD);
            if (this.nQC != null) {
                this.nRj.a(this.nQC.dZl());
            }
            this.nRj.a(z, z2);
            this.nRj.setVisibilityListener(this.nRt);
            this.nRj.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.nRi != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable WY = tv.chushou.zues.utils.h.WY(str);
                            if (WY == null) {
                                WY = tv.chushou.zues.utils.h.Xa(str);
                            }
                            g.this.nRi.setDrawable(WY, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.nRi.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.nRi.emH();
                        }
                    }
                }
            });
            this.nRj.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
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
        if (this.nRj != null) {
            if (this.nQC != null) {
                this.nRj.a(z ? this.nQC.nJF : this.nQC.nJG, this.nQC.nJH, this.nQC.nJI, z);
                this.nRj.setGiftTopIcon(this.nQC.nJK);
            }
            if (micMemberInfo != null) {
                this.nRj.setMicMemberInfo(micMemberInfo);
            }
            this.nRj.c();
        }
    }

    protected void aB(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.nRk.setProgress(i);
            if (!this.nRp) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.nRl.setText(this.nQD.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.nRl.setText(this.nQD.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.nRl.setText(this.nQD.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.nRm.bX(str, a.e.pao_circle_default);
            if (this.nRo != i) {
                this.nRm.startAnimation(AnimationUtils.loadAnimation(this.nQD, a.C0882a.pao_beat_anim));
                this.nRo = i;
            }
            if (this.bb != bangInfo.mLevel) {
                if (this.nQE != null && !this.nQE.Ox(17)) {
                    this.nQE.b(this.nQE.Oy(17), 500L);
                }
                this.bb = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.nRn.b()) {
            WindowManager windowManager = (WindowManager) this.nQD.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                this.nRn.a(this.nQD, i, this.nQC.dZl().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.nRn.e();
        this.nRn.c();
    }

    public void eal() {
        this.nRm.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.nRm.getWidth() / 2, this.nRm.getHeight() / 2);
        aVar.setDuration(1000L);
        this.nRm.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.nRr == null && this.nQD != null) {
            if ("3".equals(this.nQK)) {
                z = h.dYA().b;
            } else if (this.nQC == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dYA().d;
            } else {
                z = h.dYA().e;
            }
            this.nRr = new CSDanmuLayout(this.nQD.getApplicationContext(), new a.C1003a().Ou(-16711936).Ot(800).zg(true).zh(this.ap >= 0).Os(2).elD(), h.dYA().b());
            this.nRr.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.nQD);
            Point gW = tv.chushou.zues.utils.a.gW(this.nQD);
            switch (h.dYA().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.nQD.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gW.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.nQD.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gW.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            eaj().addView(this.nRr, 1, layoutParams);
            if (this.nRr != null) {
                this.nRr.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.nRr != null) {
            this.nRr.setVisibility(8);
            this.nRr.elE();
        }
        if (this.nRr != null) {
            this.nRr.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void S() {
        if (this.nRr != null && this.nQC != null) {
            if (this.ap < 0) {
                this.nRr.setVisibility(h.dYA().d ? 0 : 8);
            } else {
                this.nRr.setVisibility(h.dYA().e ? 0 : 8);
            }
        }
        if (this.nRr != null && this.nRr.isPrepared() && !this.H && !this.al) {
            this.nRr.resume();
            this.nRr.elE();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.nRB == null) {
            if (this.nRz == null) {
                this.nRz = new ArrayList();
            }
            this.nRz.clear();
            bb(getString(a.i.danmu_settings_no_gift), false);
            bb(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.nQD).nIc != null) {
                if (this.nQC.dZl() != null) {
                    this.nRD = this.nQC.dZl().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.nRD)) {
                    bb(getString(a.i.danmu_settings_no_normal), true);
                    this.nRz.addAll(this.nRD);
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
            View inflate = LayoutInflater.from(this.nQD).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.nQD));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.nRC = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.nQD).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.nRC.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.nRC.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.nRA = new com.kascend.chushou.player.adapter.b(i, this.nQD, this.nRz, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.nRA);
            if (!tv.chushou.zues.utils.h.isEmpty(this.nRD) && this.nRD.size() >= 5) {
                this.nRB = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQD, 165.0f), tv.chushou.zues.utils.a.dip2px(this.nQD, 354.0f));
            } else {
                this.nRB = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQD, 165.0f), -2);
            }
            this.nRB.setFocusable(true);
            this.nRB.setOutsideTouchable(true);
            this.nRB.setBackgroundDrawable(this.nQD.getResources().getDrawable(a.e.bg_room_pop));
            this.nRB.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eam() {
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
        if (this.nRz != null) {
            this.nRz.add(privacyItem);
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
        if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_V8_SO, "chatType", str2, "chatState", str, "roomId", this.nQC.dZl().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.nRA.notifyDataSetChanged();
        au();
    }

    protected void au() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.emq()) {
            tv.chushou.zues.utils.g.c(this.nQD, this.nQD.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dYv().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.nRA.notifyDataSetChanged();
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
                        g.this.nRA.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.nRA.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.nRz) {
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
                for (PrivacyItem privacyItem3 : this.nRz) {
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
            for (PrivacyItem privacyItem4 : this.nRz) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.nRF == null) {
            this.nRF = new ArrayList<>();
        }
        this.nRF.add(str);
        this.nRF.add(str2);
        p pVar = new p();
        pVar.a = this.nRF;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.nRF == null) {
            this.nRF = new ArrayList<>();
        }
        this.nRF.add(str);
        p pVar = new p();
        pVar.a = this.nRF;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.nRF != null) {
            this.nRF.remove(str);
            this.nRF.remove(str2);
            p pVar = new p();
            pVar.a = this.nRF;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.nRF != null) {
            this.nRF.remove(str);
            p pVar = new p();
            pVar.a = this.nRF;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dZF = dZF();
        if (dZF != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dZF.getLayoutParams();
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
            dZF.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dZF = dZF();
        if (dZF != null) {
            dZF.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dYA().q()) {
                h.dYA().g(false);
                this.nQR.c();
                return;
            }
            h.dYA().g(true);
            this.nQR.b();
        } else if (id == a.f.rl_decode) {
            if (h.dYA().a) {
                h.dYA().a(this.nQD, false);
                this.nQT.c();
            } else {
                h.dYA().a(this.nQD, true);
                this.nQT.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.nQD, eai(), this.ap < 0);
            dZL();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.nQD).q) {
                ((VideoPlayer) this.nQD).q = false;
                if (this.nQC.nJA != null) {
                    this.nQC.nJA.e();
                    this.nQC.nJA.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.nQP.c();
                return;
            }
            ((VideoPlayer) this.nQD).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.nQP.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dYA().o();
            if (this.ap < 0) {
                o = h.dYA().n();
            }
            if (!this.nQK.equals("1")) {
                o = h.dYA().b;
            }
            boolean z = !o;
            if (z) {
                this.nQU.b();
            } else {
                this.nQU.c();
            }
            if (!this.nQK.equals("1")) {
                h.dYA().a(z);
            } else if (this.ap < 0) {
                h.dYA().e(z);
            } else {
                h.dYA().f(z);
            }
            switch (h.dYA().m()) {
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
            com.kascend.chushou.toolkit.a.c.c(this.nQD, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.nQD).q) {
                ((VideoPlayer) this.nQD).q = false;
                if (this.nQC.nJA != null) {
                    this.nQC.nJA.e();
                    this.nQC.nJA.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.nRC.setImageResource(i);
            } else {
                ((VideoPlayer) this.nQD).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.nRC.setImageResource(i2);
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
        if (aVar != null && this.nRv != null) {
            this.nRv.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dZQ() {
        return null;
    }

    public GiftAnimationLayout dZF() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void eac() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dZn;
        if (this.nQC != null && (dZn = this.nQC.dZn()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dZn.mOnlineCount.equals(str2) || !dZn.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dZn.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dZn.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                eac();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dYA().c(true);
        if (this.nRx == null) {
            a();
        }
        if (!this.nRx.isShowing()) {
            if (view != null) {
                this.nRx.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.nQD, 3.0f), (this.nQo.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.nQD, 8.0f));
                RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.nRx != null) {
                            g.this.nRx.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.nRx.dismiss();
    }

    private void a() {
        if (this.nRx == null) {
            View inflate = LayoutInflater.from(this.nQD).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.nQD.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.nQD.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.nRx = new PopupWindow(inflate, -2, -2);
            this.nRx.setFocusable(true);
            this.nRx.setOutsideTouchable(true);
            this.nRx.setAnimationStyle(a.j.gift_toast_style);
            this.nRx.update();
            this.nRx.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.nRx = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
