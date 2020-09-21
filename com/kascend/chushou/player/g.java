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
    protected RelativeLayout oaH;
    protected RelativeLayout oaI;
    protected OnlineToggleButton oaJ;
    protected RelativeLayout oaK;
    protected OnlineToggleButton oaL;
    protected RelativeLayout oaM;
    protected OnlineToggleButton oaN;
    protected OnlineToggleButton oaO;
    protected LinearLayout oaP;
    protected PopupWindow oaQ;
    protected PopupWindow oaR;
    protected PopupWindow oaS;
    protected RecyclerView oaT;
    protected LinearLayoutManager oaU;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> oaV;
    protected ArrayList<a> oaW;
    protected ArrayList<a> oaX;
    protected PopupWindow oaY;
    protected View oaZ;
    protected ArrayList<String> obA;
    protected SVGAImageView oba;
    protected View obb;
    protected EmanateView obc;
    protected RoomSendGiftView obd;
    protected RoundProgressBar obe;
    protected TextView obf;
    protected FrescoThumbnailView obg;
    protected PaoGuideView obh;
    protected AnimatorSet obn;
    protected KasBaseMenuView.a obo;
    protected H5Container obq;
    protected RelativeLayout obr;
    protected PopupWindow obs;
    protected PopupWindow obt;
    protected List<PrivacyItem> obu;
    protected com.kascend.chushou.player.adapter.b obv;
    protected PopupWindow obw;
    protected ImageView obx;
    protected List<PrivacyItem> oby;
    protected FrescoThumbnailView obz;
    protected boolean aR = false;
    protected int bb = 0;
    protected long obi = 0;
    protected boolean obk = false;
    protected IconConfig.Config obl = new IconConfig.Config();
    protected CSDanmuLayout obm = null;
    protected boolean obp = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.aa() && g.this.oaT != null && g.this.oaV != null && g.this.oaU != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.oaU.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.oaU.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.oaU.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.oaU.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.oaU.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.oaT.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.oaz != null) {
                                    g.this.oaz.L(g.this.d);
                                    if (g.this.b) {
                                        g.this.oaz.e(g.this.d, 1000L);
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
    public RelativeLayout eeh() {
        if (this.oaH == null) {
            this.oaH = (RelativeLayout) this.oaj.findViewById(a.f.video_root_view);
        }
        return this.oaH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(View view, int i, int i2) {
        if (!this.obp) {
            vt();
        }
        vu();
        if (this.oaQ != null) {
            if (!this.oaQ.isShowing()) {
                this.oaQ.showAtLocation(view, 53, i, i2);
            } else {
                this.oaQ.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point hc = tv.chushou.zues.utils.a.hc(this.oay);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.ecy().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.ecy().b(1);
                layoutParams.width = -1;
                if (this.oay.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = hc.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.ecy().b(2);
                layoutParams.width = -1;
                if (this.oay.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = hc.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.obm != null) {
            this.obm.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(View view, int i, int i2) {
        dQA();
        if (this.oaR != null) {
            if (!this.oaR.isShowing()) {
                if (this.oay.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.oaR.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.oaR.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.oaR.showAtLocation(view, 53, i, i2);
                return;
            }
            this.oaR.dismiss();
        }
    }

    protected void dQA() {
        int i = a.h.pop_danmu_full_setting;
        if (this.oay.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.oay).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.oaO = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.oaE.equals("1")) {
            if (h.ecy().b) {
                this.oaO.b();
            } else {
                this.oaO.c();
            }
        } else if (this.ap < 0) {
            if (h.ecy().n()) {
                this.oaO.b();
            } else {
                this.oaO.c();
            }
        } else if (h.ecy().o()) {
            this.oaO.b();
        } else {
            this.oaO.c();
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
        switch (h.ecy().m()) {
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
        if (this.oay.getResources().getConfiguration().orientation == 1) {
            this.oaR = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.oay, 230.0f), -2);
            this.oaR.setBackgroundDrawable(this.oay.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.oaR = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.oay, 295.0f), -1);
            this.oaR.setClippingEnabled(false);
            this.oaR.setBackgroundDrawable(this.oay.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.oaR.setFocusable(true);
        this.oaR.setOutsideTouchable(true);
        this.oaR.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vs() {
        if (!this.oaE.equals("1")) {
            h.ecy().a(true);
        } else if (this.ap < 0) {
            h.ecy().e(true);
        } else {
            h.ecy().f(true);
        }
        switch (h.ecy().m()) {
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

    protected void vt() {
        ArrayList<PlayUrl> arrayList;
        int i;
        if (!this.obp) {
            int i2 = a.h.pop_full_play_setting;
            if (this.oay.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.oay).inflate(i2, (ViewGroup) null);
            this.oaP = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.oaI = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.oaJ = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.oaK = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.oaL = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.oaM = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.oaN = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.oay.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.oay);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.H(10.0f);
                }
                this.oaP.setPadding(this.oaP.getPaddingLeft(), statusBarHeight, this.oaP.getPaddingRight(), this.oaP.getPaddingBottom());
            }
            this.oaI.setOnClickListener(this);
            this.oaK.setOnClickListener(this);
            this.oaM.setOnClickListener(this);
            if (!this.oaE.equals("1") || this.ap < 0) {
                this.oaI.setVisibility(8);
            } else {
                this.oaI.setVisibility(0);
            }
            if (((VideoPlayer) this.oay).q) {
                this.oaJ.b();
            } else {
                this.oaJ.c();
            }
            if (h.ecy().q()) {
                this.oaL.b();
            } else {
                this.oaL.c();
            }
            if (com.kascend.chushou.c.a) {
                this.oaM.setVisibility(0);
            } else {
                this.oaM.setVisibility(8);
            }
            if (h.ecy().a) {
                this.oaN.b();
            } else {
                this.oaN.c();
            }
            if (this.oax != null && (arrayList = this.oax.f) != null && arrayList.size() > 0) {
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
                            if (this.oay.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.oay).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl edk = this.oax.edk();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.oay).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.oay.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.oay).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.oay, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.oay, 6.0f);
                                    }
                                    int identifier = this.oay.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.oay.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.oaP, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (edk != null && edk.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.oaP.addView(inflate2);
                            this.obp = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.oay.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.oay).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl edk2 = this.oax.edk();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.oay).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.oay.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.oay).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.oay, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.oay, 6.0f);
                                    }
                                    int identifier2 = this.oay.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.oay.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.oaP, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (edk2 != null && edk2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.oaP.addView(inflate3);
                            this.obp = true;
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
            if (this.oay.getResources().getConfiguration().orientation == 1) {
                this.oaQ = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.oay, 230.0f), -2);
                this.oaQ.setBackgroundDrawable(this.oay.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.oaQ = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.oay, 295.0f), -1);
                this.oaQ.setClippingEnabled(false);
                this.oaQ.setBackgroundDrawable(this.oay.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.oaQ.setFocusable(true);
            this.oaQ.setOutsideTouchable(true);
            this.oaQ.update();
        }
    }

    protected void vu() {
        if (this.oaK != null && this.oaL != null) {
            this.oaK.setVisibility(0);
            if (h.ecy().q()) {
                this.oaL.b();
            } else {
                this.oaL.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dQD() {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = null;
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() != -1) {
            com.kascend.chushou.d.e.a(0);
        }
        com.kascend.chushou.toolkit.a.c.a(this.oay, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.oax.f;
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
            if (this.oaP == null) {
                this.oax.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.oax.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.oay).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.oaP.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.oaP.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.oay.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.oay.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.oaP, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.oay, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.oax.f;
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
            if (this.oaP == null) {
                if (!z) {
                    this.oax.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.oax.a(playUrl);
                if (this.ap >= 0) {
                    this.oax.a(false);
                    if (this.oay != null) {
                        ((VideoPlayer) this.oay).b(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.oay).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.oaP.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.oaP.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.oay.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.oay.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.oaP, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.oaQ != null) {
            this.oaQ.dismiss();
        }
        if (this.oaS != null) {
            this.oaS.dismiss();
        }
        PlayUrl edk = this.oax.edk();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.oax.d) {
                this.oax.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.oax.a(playUrl);
                this.oax.a(false);
                if (this.oay != null) {
                    ((VideoPlayer) this.oay).b(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.oax.d) {
            this.oax.e = true;
        }
        h.ecy().a(this.oay, urlDetails.mDefinitionType);
        if (z || (edk != null && !edk.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.oay, eeg(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.oax.a(playUrl);
            if (eeg()) {
                if (((VideoPlayer) this.oay) != null) {
                    ((VideoPlayer) this.oay).r = -1L;
                }
                if (this.nWQ != null) {
                    this.nqu = this.nWQ.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.oay).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.oaD = str2;
        if (this.oaz != null) {
            this.oaz.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void edJ() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.aR = true;
            if (this.oaX == null) {
                this.oaX = new ArrayList<>();
            }
            this.oaX.clear();
            this.oaX.addAll(list);
            this.oaY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.oaY == null) {
            View inflate = LayoutInflater.from(this.oay).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.oay.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.oay.getResources().getColor(a.c.player_bg_color));
            }
            if (this.aR && !tv.chushou.zues.utils.h.isEmpty(this.oaX)) {
                this.oaW = this.oaX;
            } else {
                this.oaW = (ArrayList) h.ecy().ecA();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.oaW)) {
                String[] stringArray = this.oay.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.oay.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.oaW == null) {
                    this.oaW = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.oaW.add(aVar);
                }
            }
            this.oaT = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.oaV = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.oaW, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void D(View view, int i4) {
                    a aVar2;
                    if (g.this.oaY != null) {
                        g.this.oaY.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.oaW) && i4 < g.this.oaW.size() && (aVar2 = g.this.oaW.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.aR) {
                            g.this.oaW.remove(i4);
                            g.this.oaW.add(0, aVar2);
                            g.this.oaV.notifyDataSetChanged();
                            g.this.oaT.scrollToPosition(0);
                            RxExecutor.post(g.this.oai, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.ecy().a((Object) g.this.oaW);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.oay, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.oax != null && g.this.oax.edj() != null && g.this.oax.edj().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.oax.edj().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC1011a view$OnLongClickListenerC1011a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC1011a.a(a.f.tv_name, g.this.oay.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC1011a.a(a.f.tv_name, g.this.oay.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC1011a.a(a.f.tv_name, g.this.oay.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC1011a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.oaU = new LinearLayoutManager(this.oay);
            this.oaT.setLayoutManager(this.oaU);
            this.oaT.setAdapter(this.oaV);
            this.oaT.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                    if (g.this.ap < 0) {
                        if (i4 == 0) {
                            g.this.eei();
                        } else {
                            g.this.ao();
                        }
                    }
                    super.onScrollStateChanged(recyclerView, i4);
                }
            });
            this.oaY = new PopupWindow(inflate, this.oay.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.oay.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.oaY.setFocusable(true);
            this.oaY.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.oaY.setBackgroundDrawable(this.oay.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.oaY.setBackgroundDrawable(this.oay.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.oaY.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.oaz.L(this.d);
        this.oaz.o(this.d);
    }

    protected void eei() {
        this.b = true;
        this.oaz.L(this.d);
        this.oaz.e(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.oaz != null) {
            this.oaz.L(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void by(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.oax != null) {
                RoomInfo edl = this.oax.edl();
                if (edl != null) {
                    str = edl.mRoomID;
                }
                if (edl != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(edl.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.oay, listItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.oaj != null) {
            Point hc = tv.chushou.zues.utils.a.hc(this.oay);
            int i = hc.x > hc.y ? 1 : 2;
            if (this.obq == null) {
                this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.obq.setPlayerViewHelper(this.oax);
            this.obq.setVisibility(0);
            this.obq.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.oax != null && (e = this.oax.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.obq != null) {
            this.obq.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.oaZ == null && this.oba == null) {
            if (this.oax.nTv != null) {
                ChatInfo edh = this.oax.nTv.edh();
                if (edh == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.obr == null) {
                    this.obr = (RelativeLayout) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (edh.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(edh.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        edh.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (edh.mAnimSubType > 0) {
                    edh.mAnimType = edh.mAnimSubType;
                }
                if (edh.mAnimationPluginId == 1) {
                    this.oaZ = com.kascend.chushou.toolkit.d.a.eeG().a(this.oay, String.valueOf(edh.mAnimType), this.obr, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.aa() && g.this.oaZ != null && g.this.obr != null) {
                                Object tag = g.this.oaZ.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.eeG().a(g.this.oay, String.valueOf(((ChatInfo) tag).mAnimType), g.this.obr, g.this.oaZ);
                                }
                                if (!z) {
                                    g.this.oaZ.setVisibility(8);
                                    g.this.obr.removeView(g.this.oaZ);
                                    g.this.oaZ = null;
                                    if (g.this.oaz != null) {
                                        g.this.oaz.removeMessages(11);
                                        g.this.oaz.C(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.oaZ = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, edh.mJsonData);
                } else if (edh.mAnimationPluginId == 2) {
                    if (this.oba == null && this.obr != null) {
                        this.oba = (SVGAImageView) this.obr.findViewById(a.f.svgaView);
                        if (this.oba == null) {
                            this.oba = new SVGAImageView(this.oay);
                            this.oba.setClearsAfterStop(true);
                            this.oba.setLoops(1);
                            this.oba.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.obr.addView(this.oba, layoutParams);
                        }
                    }
                    if (this.oba == null) {
                        cVar.removeMessages(11);
                        cVar.C(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.eeG().a(this.oay, String.valueOf(edh.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.oba.stopAnimation();
                            g.this.oba.clearAnimation();
                            g.this.oba.setVisibility(8);
                            g.this.oba = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Yu() {
                            g.this.oba.stopAnimation();
                            g.this.oba.clearAnimation();
                            g.this.oba.setVisibility(8);
                            g.this.oba = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Yv() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.oba, edh);
                }
                if (this.oaZ != null) {
                    this.oaZ.setTag(edh);
                    return;
                }
                return;
            }
            return;
        }
        cVar.removeMessages(11);
        cVar.C(11, 800L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(tv.chushou.zues.c cVar) {
        if (this.obb == null) {
            if (this.oax.nTv != null) {
                int g = this.oax.nTv.g();
                ChatInfo edi = this.oax.nTv.edi();
                if (edi == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(edi, g);
                    return;
                }
            }
            return;
        }
        cVar.removeMessages(12);
        cVar.C(12, 800L);
    }

    private void a(final ChatInfo chatInfo, final int i) {
        int i2;
        if (this.obb != null || getContext() == null) {
            if (this.oaz != null) {
                this.oaz.removeMessages(12);
                this.oaz.C(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.obb = this.oaj.findViewById(a.f.rl_show_tip);
            if (this.obb != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.ecq().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.oay);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.obb.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.oay, 5.0f);
                    this.obb.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.obb = this.oaj.findViewById(a.f.rl_tip);
        }
        if (this.obb != null) {
            this.obb.setVisibility(0);
            this.obb.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.oax != null) {
                            RoomInfo edl = g.this.oax.edl();
                            if (edl != null) {
                                str = edl.mRoomID;
                            }
                            if (edl != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(edl.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.oay, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.obb.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.obb.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.oax != null) {
                            RoomInfo edl = g.this.oax.edl();
                            if (edl != null) {
                                str = edl.mRoomID;
                            }
                            if (edl != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(edl.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.oay, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.oay.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.oay, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.oay, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0879a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.hc(getContext()).x;
                if (this.oay.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.oay, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.oay, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0879a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.obb.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.obb != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.obb.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.obb.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.obn == null) {
                                g.this.obn = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.obn.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.obn.removeAllListeners();
                            }
                            g.this.obn.playTogether(ObjectAnimator.ofFloat(g.this.obb, "translationX", g.this.obb.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.obn.start();
                            if (g.this.oaz != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.oaz.C(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void aq() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!aa() && this.obb != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.obb, "translationX", 0.0f, 10.0f, -this.obb.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.aa()) {
                        if (g.this.obb != null) {
                            g.this.obb.setVisibility(8);
                        }
                        g.this.obb = null;
                        if (g.this.oaz != null) {
                            g.this.oaz.C(12, 800L);
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
            if (this.obn == null) {
                this.obn = new AnimatorSet();
            }
            this.obn.playTogether(duration);
            this.obn.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dQK() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.oay).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.obc = new EmanateView(this.oay);
            this.obc.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.obc);
            return;
        }
        this.obc = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.obd == null) {
            this.obd = (RoomSendGiftView) this.oaj.findViewById(a.f.normalSendGiftView);
            this.obd.setContext(this.oay);
            if (this.oax != null) {
                this.obd.a(this.oax.edj());
            }
            this.obd.a(z, z2);
            this.obd.setVisibilityListener(this.obo);
            this.obd.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.obc != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable Xz = tv.chushou.zues.utils.h.Xz(str);
                            if (Xz == null) {
                                Xz = tv.chushou.zues.utils.h.XB(str);
                            }
                            g.this.obc.setDrawable(Xz, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.obc.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.obc.eqF();
                        }
                    }
                }
            });
            this.obd.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void b(ConfigDetail configDetail) {
                    if (configDetail != null) {
                        g.this.b(configDetail);
                    }
                }

                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void a(boolean z3, boolean z4) {
                    g.this.aD(z3, z4);
                }
            });
        }
        if (this.obd != null) {
            if (this.oax != null) {
                this.obd.a(z ? this.oax.nTA : this.oax.nTB, this.oax.nTC, this.oax.nTD, z);
                this.obd.setGiftTopIcon(this.oax.nTF);
            }
            if (micMemberInfo != null) {
                this.obd.setMicMemberInfo(micMemberInfo);
            }
            this.obd.c();
        }
    }

    protected void aD(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.obe.setProgress(i);
            if (!this.obk) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.obf.setText(this.oay.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.obf.setText(this.oay.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.obf.setText(this.oay.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.obg.bX(str, a.e.pao_circle_default);
            if (this.obi != i) {
                this.obg.startAnimation(AnimationUtils.loadAnimation(this.oay, a.C0879a.pao_beat_anim));
                this.obi = i;
            }
            if (this.bb != bangInfo.mLevel) {
                if (this.oaz != null && !this.oaz.Pc(17)) {
                    this.oaz.b(this.oaz.Pd(17), 500L);
                }
                this.bb = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.obh.b()) {
            WindowManager windowManager = (WindowManager) this.oay.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                this.obh.a(this.oay, i, this.oax.edj().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.obh.e();
        this.obh.c();
    }

    public void eej() {
        this.obg.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.obg.getWidth() / 2, this.obg.getHeight() / 2);
        aVar.setDuration(1000L);
        this.obg.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.obm == null && this.oay != null) {
            if ("3".equals(this.oaE)) {
                z = h.ecy().b;
            } else if (this.oax == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.ecy().d;
            } else {
                z = h.ecy().e;
            }
            this.obm = new CSDanmuLayout(this.oay.getApplicationContext(), new a.C1000a().OZ(-16711936).OY(800).zo(true).zp(this.ap >= 0).OX(2).epB(), h.ecy().b());
            this.obm.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.oay);
            Point hc = tv.chushou.zues.utils.a.hc(this.oay);
            switch (h.ecy().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.oay.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = hc.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.oay.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = hc.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            eeh().addView(this.obm, 1, layoutParams);
            if (this.obm != null) {
                this.obm.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.obm != null) {
            this.obm.setVisibility(8);
            this.obm.epC();
        }
        if (this.obm != null) {
            this.obm.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void S() {
        if (this.obm != null && this.oax != null) {
            if (this.ap < 0) {
                this.obm.setVisibility(h.ecy().d ? 0 : 8);
            } else {
                this.obm.setVisibility(h.ecy().e ? 0 : 8);
            }
        }
        if (this.obm != null && this.obm.isPrepared() && !this.H && !this.al) {
            this.obm.resume();
            this.obm.epC();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.obw == null) {
            if (this.obu == null) {
                this.obu = new ArrayList();
            }
            this.obu.clear();
            bc(getString(a.i.danmu_settings_no_gift), false);
            bc(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.oay).nRX != null) {
                if (this.oax.edj() != null) {
                    this.oby = this.oax.edj().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.oby)) {
                    bc(getString(a.i.danmu_settings_no_normal), true);
                    this.obu.addAll(this.oby);
                } else {
                    bc(getString(a.i.danmu_settings_no_normal), false);
                }
            } else {
                bc(getString(a.i.danmu_settings_no_normal), false);
            }
            if (i == 3) {
                i2 = a.h.pop_privacy_setting_black;
            } else {
                i2 = a.h.pop_privacy_setting;
            }
            View inflate = LayoutInflater.from(this.oay).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.oay));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.obx = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.oay).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.obx.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.obx.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.obv = new com.kascend.chushou.player.adapter.b(i, this.oay, this.obu, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.obv);
            if (!tv.chushou.zues.utils.h.isEmpty(this.oby) && this.oby.size() >= 5) {
                this.obw = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.oay, 165.0f), tv.chushou.zues.utils.a.dip2px(this.oay, 354.0f));
            } else {
                this.obw = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.oay, 165.0f), -2);
            }
            this.obw.setFocusable(true);
            this.obw.setOutsideTouchable(true);
            this.obw.setBackgroundDrawable(this.oay.getResources().getDrawable(a.e.bg_room_pop));
            this.obw.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eek() {
        i(2);
    }

    protected void bc(String str, boolean z) {
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
        if (this.obu != null) {
            this.obu.add(privacyItem);
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
        if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_V8_SO, "chatType", str2, "chatState", str, "roomId", this.oax.edj().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.obv.notifyDataSetChanged();
        au();
    }

    protected void au() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.eqo()) {
            tv.chushou.zues.utils.g.c(this.oay, this.oay.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.ect().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.obv.notifyDataSetChanged();
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
                        g.this.obv.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.obv.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.obu) {
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
                for (PrivacyItem privacyItem3 : this.obu) {
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
            for (PrivacyItem privacyItem4 : this.obu) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.obA == null) {
            this.obA = new ArrayList<>();
        }
        this.obA.add(str);
        this.obA.add(str2);
        p pVar = new p();
        pVar.a = this.obA;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.obA == null) {
            this.obA = new ArrayList<>();
        }
        this.obA.add(str);
        p pVar = new p();
        pVar.a = this.obA;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.obA != null) {
            this.obA.remove(str);
            this.obA.remove(str2);
            p pVar = new p();
            pVar.a = this.obA;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.obA != null) {
            this.obA.remove(str);
            p pVar = new p();
            pVar.a = this.obA;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout edD = edD();
        if (edD != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) edD.getLayoutParams();
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
            edD.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout edD = edD();
        if (edD != null) {
            edD.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.ecy().q()) {
                h.ecy().g(false);
                this.oaL.c();
                return;
            }
            h.ecy().g(true);
            this.oaL.b();
        } else if (id == a.f.rl_decode) {
            if (h.ecy().a) {
                h.ecy().a(this.oay, false);
                this.oaN.c();
            } else {
                h.ecy().a(this.oay, true);
                this.oaN.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.oay, eeg(), this.ap < 0);
            edJ();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.oay).q) {
                ((VideoPlayer) this.oay).q = false;
                if (this.oax.nTv != null) {
                    this.oax.nTv.e();
                    this.oax.nTv.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.oaJ.c();
                return;
            }
            ((VideoPlayer) this.oay).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.oaJ.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.ecy().o();
            if (this.ap < 0) {
                o = h.ecy().n();
            }
            if (!this.oaE.equals("1")) {
                o = h.ecy().b;
            }
            boolean z = !o;
            if (z) {
                this.oaO.b();
            } else {
                this.oaO.c();
            }
            if (!this.oaE.equals("1")) {
                h.ecy().a(z);
            } else if (this.ap < 0) {
                h.ecy().e(z);
            } else {
                h.ecy().f(z);
            }
            switch (h.ecy().m()) {
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
            com.kascend.chushou.toolkit.a.c.c(this.oay, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.oay).q) {
                ((VideoPlayer) this.oay).q = false;
                if (this.oax.nTv != null) {
                    this.oax.nTv.e();
                    this.oax.nTv.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.obx.setImageResource(i);
            } else {
                ((VideoPlayer) this.oay).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.obx.setImageResource(i2);
            }
            au();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.obq != null) {
            this.obq.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0894a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a edO() {
        return null;
    }

    public GiftAnimationLayout edD() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void eea() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo edl;
        if (this.oax != null && (edl = this.oax.edl()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!edl.mOnlineCount.equals(str2) || !edl.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    edl.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    edl.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                eea();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.ecy().c(true);
        if (this.obs == null) {
            a();
        }
        if (!this.obs.isShowing()) {
            if (view != null) {
                this.obs.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.oay, 3.0f), (this.oaj.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.oay, 8.0f));
                RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.obs != null) {
                            g.this.obs.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.obs.dismiss();
    }

    private void a() {
        if (this.obs == null) {
            View inflate = LayoutInflater.from(this.oay).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.oay.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.oay.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.obs = new PopupWindow(inflate, -2, -2);
            this.obs.setFocusable(true);
            this.obs.setOutsideTouchable(true);
            this.obs.setAnimationStyle(a.j.gift_toast_style);
            this.obs.update();
            this.obs.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.obs = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
