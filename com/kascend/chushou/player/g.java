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
    protected RelativeLayout nwF;
    protected RelativeLayout nwG;
    protected OnlineToggleButton nwH;
    protected RelativeLayout nwI;
    protected OnlineToggleButton nwJ;
    protected RelativeLayout nwK;
    protected OnlineToggleButton nwL;
    protected OnlineToggleButton nwM;
    protected LinearLayout nwN;
    protected PopupWindow nwO;
    protected PopupWindow nwP;
    protected PopupWindow nwQ;
    protected RecyclerView nwR;
    protected LinearLayoutManager nwS;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> nwT;
    protected ArrayList<a> nwU;
    protected ArrayList<a> nwV;
    protected PopupWindow nwW;
    protected View nwX;
    protected SVGAImageView nwY;
    protected View nwZ;
    protected EmanateView nxa;
    protected RoomSendGiftView nxb;
    protected RoundProgressBar nxc;
    protected TextView nxd;
    protected FrescoThumbnailView nxe;
    protected PaoGuideView nxf;
    protected AnimatorSet nxk;
    protected KasBaseMenuView.a nxl;
    protected H5Container nxm;
    protected RelativeLayout nxn;
    protected PopupWindow nxo;
    protected PopupWindow nxp;
    protected List<PrivacyItem> nxq;
    protected com.kascend.chushou.player.adapter.b nxr;
    protected PopupWindow nxs;
    protected ImageView nxt;
    protected List<PrivacyItem> nxu;
    protected FrescoThumbnailView nxv;
    protected ArrayList<String> nxw;
    protected boolean aR = false;
    protected int bb = 0;
    protected long nxg = 0;
    protected boolean nxh = false;
    protected IconConfig.Config nxi = new IconConfig.Config();
    protected CSDanmuLayout nxj = null;
    protected boolean bi = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.aa() && g.this.nwR != null && g.this.nwT != null && g.this.nwS != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.nwS.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.nwS.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.nwS.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.nwS.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.nwS.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.nwR.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.nwy != null) {
                                    g.this.nwy.O(g.this.d);
                                    if (g.this.b) {
                                        g.this.nwy.e(g.this.d, 1000L);
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
    public RelativeLayout dOa() {
        if (this.nwF == null) {
            this.nwF = (RelativeLayout) this.nwi.findViewById(a.f.video_root_view);
        }
        return this.nwF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(View view, int i, int i2) {
        if (!this.bi) {
            ag();
        }
        ah();
        if (this.nwO != null) {
            if (!this.nwO.isShowing()) {
                this.nwO.showAtLocation(view, 53, i, i2);
            } else {
                this.nwO.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point gE = tv.chushou.zues.utils.a.gE(this.nwx);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dMp().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dMp().b(1);
                layoutParams.width = -1;
                if (this.nwx.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gE.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dMp().b(2);
                layoutParams.width = -1;
                if (this.nwx.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gE.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.nxj != null) {
            this.nxj.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(View view, int i, int i2) {
        ae();
        if (this.nwP != null) {
            if (!this.nwP.isShowing()) {
                if (this.nwx.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.nwP.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.nwP.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.nwP.showAtLocation(view, 53, i, i2);
                return;
            }
            this.nwP.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.nwx.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.nwx).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.nwM = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dMp().b) {
                this.nwM.b();
            } else {
                this.nwM.c();
            }
        } else if (this.ap < 0) {
            if (h.dMp().n()) {
                this.nwM.b();
            } else {
                this.nwM.c();
            }
        } else if (h.dMp().o()) {
            this.nwM.b();
        } else {
            this.nwM.c();
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
        switch (h.dMp().m()) {
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
        if (this.nwx.getResources().getConfiguration().orientation == 1) {
            this.nwP = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwx, 230.0f), -2);
            this.nwP.setBackgroundDrawable(this.nwx.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.nwP = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwx, 295.0f), -1);
            this.nwP.setClippingEnabled(false);
            this.nwP.setBackgroundDrawable(this.nwx.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.nwP.setFocusable(true);
        this.nwP.setOutsideTouchable(true);
        this.nwP.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dMp().a(true);
        } else if (this.ap < 0) {
            h.dMp().e(true);
        } else {
            h.dMp().f(true);
        }
        switch (h.dMp().m()) {
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
            if (this.nwx.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.nwx).inflate(i2, (ViewGroup) null);
            this.nwN = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.nwG = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.nwH = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.nwI = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.nwJ = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.nwK = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.nwL = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.nwx.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwx);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.D(10.0f);
                }
                this.nwN.setPadding(this.nwN.getPaddingLeft(), statusBarHeight, this.nwN.getPaddingRight(), this.nwN.getPaddingBottom());
            }
            this.nwG.setOnClickListener(this);
            this.nwI.setOnClickListener(this);
            this.nwK.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.nwG.setVisibility(8);
            } else {
                this.nwG.setVisibility(0);
            }
            if (((VideoPlayer) this.nwx).q) {
                this.nwH.b();
            } else {
                this.nwH.c();
            }
            if (h.dMp().q()) {
                this.nwJ.b();
            } else {
                this.nwJ.c();
            }
            if (com.kascend.chushou.c.a) {
                this.nwK.setVisibility(0);
            } else {
                this.nwK.setVisibility(8);
            }
            if (h.dMp().a) {
                this.nwL.b();
            } else {
                this.nwL.c();
            }
            if (this.nww != null && (arrayList = this.nww.f) != null && arrayList.size() > 0) {
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
                            if (this.nwx.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.nwx).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dNc = this.nww.dNc();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nwx).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.nwx.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.nwx).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nwx, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nwx, 6.0f);
                                    }
                                    int identifier = this.nwx.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nwx.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nwN, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dNc != null && dNc.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.nwN.addView(inflate2);
                            this.bi = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.nwx.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.nwx).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dNc2 = this.nww.dNc();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nwx).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.nwx.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.nwx).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nwx, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nwx, 6.0f);
                                    }
                                    int identifier2 = this.nwx.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nwx.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nwN, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dNc2 != null && dNc2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.nwN.addView(inflate3);
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
            if (this.nwx.getResources().getConfiguration().orientation == 1) {
                this.nwO = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwx, 230.0f), -2);
                this.nwO.setBackgroundDrawable(this.nwx.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.nwO = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwx, 295.0f), -1);
                this.nwO.setClippingEnabled(false);
                this.nwO.setBackgroundDrawable(this.nwx.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.nwO.setFocusable(true);
            this.nwO.setOutsideTouchable(true);
            this.nwO.update();
        }
    }

    protected void ah() {
        if (this.nwI != null && this.nwJ != null) {
            this.nwI.setVisibility(0);
            if (h.dMp().q()) {
                this.nwJ.b();
            } else {
                this.nwJ.c();
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
        com.kascend.chushou.toolkit.a.c.a(this.nwx, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.nww.f;
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
            if (this.nwN == null) {
                this.nww.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.nww.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.nwx).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nwN.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nwN.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nwx.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nwx.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nwN, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.nwx, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.nww.f;
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
            if (this.nwN == null) {
                if (!z) {
                    this.nww.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.nww.a(playUrl);
                if (this.ap >= 0) {
                    this.nww.a(false);
                    if (this.nwx != null) {
                        ((VideoPlayer) this.nwx).b(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.nwx).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nwN.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nwN.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nwx.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nwx.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nwN, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.nwO != null) {
            this.nwO.dismiss();
        }
        if (this.nwQ != null) {
            this.nwQ.dismiss();
        }
        PlayUrl dNc = this.nww.dNc();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.nww.d) {
                this.nww.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.nww.a(playUrl);
                this.nww.a(false);
                if (this.nwx != null) {
                    ((VideoPlayer) this.nwx).b(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.nww.d) {
            this.nww.e = true;
        }
        h.dMp().a(this.nwx, urlDetails.mDefinitionType);
        if (z || (dNc != null && !dNc.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.nwx, dNZ(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.nww.a(playUrl);
            if (dNZ()) {
                if (((VideoPlayer) this.nwx) != null) {
                    ((VideoPlayer) this.nwx).r = -1L;
                }
                if (this.nsS != null) {
                    this.mNe = this.nsS.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.nwx).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.nwC = str2;
        if (this.nwy != null) {
            this.nwy.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.aR = true;
            if (this.nwV == null) {
                this.nwV = new ArrayList<>();
            }
            this.nwV.clear();
            this.nwV.addAll(list);
            this.nwW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.nwW == null) {
            View inflate = LayoutInflater.from(this.nwx).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.nwx.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.nwx.getResources().getColor(a.c.player_bg_color));
            }
            if (this.aR && !tv.chushou.zues.utils.h.isEmpty(this.nwV)) {
                this.nwU = this.nwV;
            } else {
                this.nwU = (ArrayList) h.dMp().dMr();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.nwU)) {
                String[] stringArray = this.nwx.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.nwx.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.nwU == null) {
                    this.nwU = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.nwU.add(aVar);
                }
            }
            this.nwR = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.nwT = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.nwU, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void C(View view, int i4) {
                    a aVar2;
                    if (g.this.nwW != null) {
                        g.this.nwW.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.nwU) && i4 < g.this.nwU.size() && (aVar2 = g.this.nwU.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.aR) {
                            g.this.nwU.remove(i4);
                            g.this.nwU.add(0, aVar2);
                            g.this.nwT.notifyDataSetChanged();
                            g.this.nwR.scrollToPosition(0);
                            RxExecutor.post(g.this.nwh, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dMp().a((Object) g.this.nwU);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.nwx, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.nww != null && g.this.nww.dNb() != null && g.this.nww.dNb().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.nww.dNb().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0956a view$OnLongClickListenerC0956a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0956a.a(a.f.tv_name, g.this.nwx.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0956a.a(a.f.tv_name, g.this.nwx.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0956a.a(a.f.tv_name, g.this.nwx.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0956a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.nwS = new LinearLayoutManager(this.nwx);
            this.nwR.setLayoutManager(this.nwS);
            this.nwR.setAdapter(this.nwT);
            this.nwR.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.nwW = new PopupWindow(inflate, this.nwx.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.nwx.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.nwW.setFocusable(true);
            this.nwW.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.nwW.setBackgroundDrawable(this.nwx.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.nwW.setBackgroundDrawable(this.nwx.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.nwW.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.nwy.O(this.d);
        this.nwy.r(this.d);
    }

    protected void an() {
        this.b = true;
        this.nwy.O(this.d);
        this.nwy.e(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.nwy != null) {
            this.nwy.O(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bu(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.nww != null) {
                RoomInfo dNe = this.nww.dNe();
                if (dNe != null) {
                    str = dNe.mRoomID;
                }
                if (dNe != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dNe.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.nwx, listItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.nwi != null) {
            Point gE = tv.chushou.zues.utils.a.gE(this.nwx);
            int i = gE.x > gE.y ? 1 : 2;
            if (this.nxm == null) {
                this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nxm.setPlayerViewHelper(this.nww);
            this.nxm.setVisibility(0);
            this.nxm.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.nww != null && (e = this.nww.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.nxm != null) {
            this.nxm.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.nwX == null && this.nwY == null) {
            if (this.nww.npu != null) {
                ChatInfo dMZ = this.nww.npu.dMZ();
                if (dMZ == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.nxn == null) {
                    this.nxn = (RelativeLayout) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dMZ.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dMZ.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dMZ.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dMZ.mAnimSubType > 0) {
                    dMZ.mAnimType = dMZ.mAnimSubType;
                }
                if (dMZ.mAnimationPluginId == 1) {
                    this.nwX = com.kascend.chushou.toolkit.d.a.dOx().a(this.nwx, String.valueOf(dMZ.mAnimType), this.nxn, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.aa() && g.this.nwX != null && g.this.nxn != null) {
                                Object tag = g.this.nwX.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dOx().a(g.this.nwx, String.valueOf(((ChatInfo) tag).mAnimType), g.this.nxn, g.this.nwX);
                                }
                                if (!z) {
                                    g.this.nwX.setVisibility(8);
                                    g.this.nxn.removeView(g.this.nwX);
                                    g.this.nwX = null;
                                    if (g.this.nwy != null) {
                                        g.this.nwy.removeMessages(11);
                                        g.this.nwy.B(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.nwX = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dMZ.mJsonData);
                } else if (dMZ.mAnimationPluginId == 2) {
                    if (this.nwY == null && this.nxn != null) {
                        this.nwY = (SVGAImageView) this.nxn.findViewById(a.f.svgaView);
                        if (this.nwY == null) {
                            this.nwY = new SVGAImageView(this.nwx);
                            this.nwY.setClearsAfterStop(true);
                            this.nwY.setLoops(1);
                            this.nwY.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.nxn.addView(this.nwY, layoutParams);
                        }
                    }
                    if (this.nwY == null) {
                        cVar.removeMessages(11);
                        cVar.B(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dOx().a(this.nwx, String.valueOf(dMZ.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.nwY.stopAnimation();
                            g.this.nwY.clearAnimation();
                            g.this.nwY.setVisibility(8);
                            g.this.nwY = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void RQ() {
                            g.this.nwY.stopAnimation();
                            g.this.nwY.clearAnimation();
                            g.this.nwY.setVisibility(8);
                            g.this.nwY = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void RR() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.nwY, dMZ);
                }
                if (this.nwX != null) {
                    this.nwX.setTag(dMZ);
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
        if (this.nwZ == null) {
            if (this.nww.npu != null) {
                int g = this.nww.npu.g();
                ChatInfo dNa = this.nww.npu.dNa();
                if (dNa == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dNa, g);
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
        if (this.nwZ != null || getContext() == null) {
            if (this.nwy != null) {
                this.nwy.removeMessages(12);
                this.nwy.B(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.nwZ = this.nwi.findViewById(a.f.rl_show_tip);
            if (this.nwZ != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dMi().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwx);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nwZ.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.nwx, 5.0f);
                    this.nwZ.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.nwZ = this.nwi.findViewById(a.f.rl_tip);
        }
        if (this.nwZ != null) {
            this.nwZ.setVisibility(0);
            this.nwZ.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.nww != null) {
                            RoomInfo dNe = g.this.nww.dNe();
                            if (dNe != null) {
                                str = dNe.mRoomID;
                            }
                            if (dNe != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dNe.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nwx, chatInfo.mItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.nwZ.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.nwZ.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.nww != null) {
                            RoomInfo dNe = g.this.nww.dNe();
                            if (dNe != null) {
                                str = dNe.mRoomID;
                            }
                            if (dNe != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dNe.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nwx, chatInfo.mItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.nwx.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nwx, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nwx, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                if (this.nwx.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nwx, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nwx, a.c.black), simpleDraweeSpanTextView)) {
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
            ViewTreeObserver viewTreeObserver = this.nwZ.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.nwZ != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.nwZ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.nwZ.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.nxk == null) {
                                g.this.nxk = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.nxk.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.nxk.removeAllListeners();
                            }
                            g.this.nxk.playTogether(ObjectAnimator.ofFloat(g.this.nwZ, "translationX", g.this.nwZ.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.nxk.start();
                            if (g.this.nwy != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.nwy.B(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void dAP() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!aa() && this.nwZ != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.nwZ, "translationX", 0.0f, 10.0f, -this.nwZ.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.aa()) {
                        if (g.this.nwZ != null) {
                            g.this.nwZ.setVisibility(8);
                        }
                        g.this.nwZ = null;
                        if (g.this.nwy != null) {
                            g.this.nwy.B(12, 800L);
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
            if (this.nxk == null) {
                this.nxk = new AnimatorSet();
            }
            this.nxk.playTogether(duration);
            this.nxk.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ar() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.nwx).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.nxa = new EmanateView(this.nwx);
            this.nxa.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.nxa);
            return;
        }
        this.nxa = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.nxb == null) {
            this.nxb = (RoomSendGiftView) this.nwi.findViewById(a.f.normalSendGiftView);
            this.nxb.setContext(this.nwx);
            if (this.nww != null) {
                this.nxb.a(this.nww.dNb());
            }
            this.nxb.a(z, z2);
            this.nxb.setVisibilityListener(this.nxl);
            this.nxb.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.nxa != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable TU = tv.chushou.zues.utils.h.TU(str);
                            if (TU == null) {
                                TU = tv.chushou.zues.utils.h.TW(str);
                            }
                            g.this.nxa.setDrawable(TU, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.nxa.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.nxa.eav();
                        }
                    }
                }
            });
            this.nxb.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
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
        if (this.nxb != null) {
            if (this.nww != null) {
                this.nxb.a(z ? this.nww.npA : this.nww.npB, this.nww.npC, this.nww.npD, z);
                this.nxb.setGiftTopIcon(this.nww.s);
            }
            if (micMemberInfo != null) {
                this.nxb.setMicMemberInfo(micMemberInfo);
            }
            this.nxb.c();
        }
    }

    protected void av(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.nxc.setProgress(i);
            if (!this.nxh) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.nxd.setText(this.nwx.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.nxd.setText(this.nwx.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.nxd.setText(this.nwx.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.nxe.bS(str, a.e.pao_circle_default);
            if (this.nxg != i) {
                this.nxe.startAnimation(AnimationUtils.loadAnimation(this.nwx, a.C0824a.pao_beat_anim));
                this.nxg = i;
            }
            if (this.bb != bangInfo.mLevel) {
                if (this.nwy != null && !this.nwy.LU(17)) {
                    this.nwy.b(this.nwy.LV(17), 500L);
                }
                this.bb = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.nxf.b()) {
            WindowManager windowManager = (WindowManager) this.nwx.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                this.nxf.a(this.nwx, i, this.nww.dNb().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.nxf.e();
        this.nxf.c();
    }

    public void as() {
        this.nxe.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.nxe.getWidth() / 2, this.nxe.getHeight() / 2);
        aVar.setDuration(1000L);
        this.nxe.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.nxj == null && this.nwx != null) {
            if ("3".equals(this.aw)) {
                z = h.dMp().b;
            } else if (this.nww == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dMp().d;
            } else {
                z = h.dMp().e;
            }
            this.nxj = new CSDanmuLayout(this.nwx.getApplicationContext(), new a.C0945a().LR(-16711936).LQ(800).ym(true).yn(this.ap >= 0).LP(2).dZq(), h.dMp().b());
            this.nxj.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.nwx);
            Point gE = tv.chushou.zues.utils.a.gE(this.nwx);
            switch (h.dMp().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.nwx.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gE.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.nwx.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gE.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dOa().addView(this.nxj, 1, layoutParams);
            if (this.nxj != null) {
                this.nxj.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.nxj != null) {
            this.nxj.setVisibility(8);
            this.nxj.dZr();
        }
        if (this.nxj != null) {
            this.nxj.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void S() {
        if (this.nxj != null && this.nww != null) {
            if (this.ap < 0) {
                this.nxj.setVisibility(h.dMp().d ? 0 : 8);
            } else {
                this.nxj.setVisibility(h.dMp().e ? 0 : 8);
            }
        }
        if (this.nxj != null && this.nxj.isPrepared() && !this.H && !this.al) {
            this.nxj.resume();
            this.nxj.dZr();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.nxs == null) {
            if (this.nxq == null) {
                this.nxq = new ArrayList();
            }
            this.nxq.clear();
            aX(getString(a.i.danmu_settings_no_gift), false);
            aX(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.nwx).nnU != null) {
                if (this.nww.dNb() != null) {
                    this.nxu = this.nww.dNb().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.nxu)) {
                    aX(getString(a.i.danmu_settings_no_normal), true);
                    this.nxq.addAll(this.nxu);
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
            View inflate = LayoutInflater.from(this.nwx).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.nwx));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.nxt = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.nwx).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.nxt.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.nxt.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.nxr = new com.kascend.chushou.player.adapter.b(i, this.nwx, this.nxq, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.nxr);
            if (!tv.chushou.zues.utils.h.isEmpty(this.nxu) && this.nxu.size() >= 5) {
                this.nxs = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwx, 165.0f), tv.chushou.zues.utils.a.dip2px(this.nwx, 354.0f));
            } else {
                this.nxs = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwx, 165.0f), -2);
            }
            this.nxs.setFocusable(true);
            this.nxs.setOutsideTouchable(true);
            this.nxs.setBackgroundDrawable(this.nwx.getResources().getDrawable(a.e.bg_room_pop));
            this.nxs.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dOb() {
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
        if (this.nxq != null) {
            this.nxq.add(privacyItem);
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
        if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_V8_SO, "chatType", str2, "chatState", str, "roomId", this.nww.dNb().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.nxr.notifyDataSetChanged();
        dNA();
    }

    protected void dNA() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.eae()) {
            tv.chushou.zues.utils.g.c(this.nwx, this.nwx.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dMl().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.nxr.notifyDataSetChanged();
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
                        g.this.nxr.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.nxr.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.nxq) {
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
                for (PrivacyItem privacyItem3 : this.nxq) {
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
            for (PrivacyItem privacyItem4 : this.nxq) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.nxw == null) {
            this.nxw = new ArrayList<>();
        }
        this.nxw.add(str);
        this.nxw.add(str2);
        p pVar = new p();
        pVar.a = this.nxw;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.nxw == null) {
            this.nxw = new ArrayList<>();
        }
        this.nxw.add(str);
        p pVar = new p();
        pVar.a = this.nxw;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.nxw != null) {
            this.nxw.remove(str);
            this.nxw.remove(str2);
            p pVar = new p();
            pVar.a = this.nxw;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.nxw != null) {
            this.nxw.remove(str);
            p pVar = new p();
            pVar.a = this.nxw;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dNw = dNw();
        if (dNw != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dNw.getLayoutParams();
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
            dNw.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dNw = dNw();
        if (dNw != null) {
            dNw.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dMp().q()) {
                h.dMp().g(false);
                this.nwJ.c();
                return;
            }
            h.dMp().g(true);
            this.nwJ.b();
        } else if (id == a.f.rl_decode) {
            if (h.dMp().a) {
                h.dMp().a(this.nwx, false);
                this.nwL.c();
            } else {
                h.dMp().a(this.nwx, true);
                this.nwL.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.nwx, dNZ(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.nwx).q) {
                ((VideoPlayer) this.nwx).q = false;
                if (this.nww.npu != null) {
                    this.nww.npu.e();
                    this.nww.npu.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.nwH.c();
                return;
            }
            ((VideoPlayer) this.nwx).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.nwH.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dMp().o();
            if (this.ap < 0) {
                o = h.dMp().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dMp().b;
            }
            boolean z = !o;
            if (z) {
                this.nwM.b();
            } else {
                this.nwM.c();
            }
            if (!this.aw.equals("1")) {
                h.dMp().a(z);
            } else if (this.ap < 0) {
                h.dMp().e(z);
            } else {
                h.dMp().f(z);
            }
            switch (h.dMp().m()) {
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
            com.kascend.chushou.toolkit.a.c.c(this.nwx, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.nwx).q) {
                ((VideoPlayer) this.nwx).q = false;
                if (this.nww.npu != null) {
                    this.nww.npu.e();
                    this.nww.npu.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.nxt.setImageResource(i);
            } else {
                ((VideoPlayer) this.nwx).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.nxt.setImageResource(i2);
            }
            dNA();
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
        if (aVar != null && this.nxm != null) {
            this.nxm.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dNJ() {
        return null;
    }

    public GiftAnimationLayout dNw() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dNR() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dNe;
        if (this.nww != null && (dNe = this.nww.dNe()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dNe.mOnlineCount.equals(str2) || !dNe.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dNe.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dNe.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dNR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dMp().c(true);
        if (this.nxo == null) {
            a();
        }
        if (!this.nxo.isShowing()) {
            if (view != null) {
                this.nxo.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.nwx, 3.0f), (this.nwi.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.nwx, 8.0f));
                RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.nxo != null) {
                            g.this.nxo.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.nxo.dismiss();
    }

    private void a() {
        if (this.nxo == null) {
            View inflate = LayoutInflater.from(this.nwx).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.nwx.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.nwx.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.nxo = new PopupWindow(inflate, -2, -2);
            this.nxo.setFocusable(true);
            this.nxo.setOutsideTouchable(true);
            this.nxo.setAnimationStyle(a.j.gift_toast_style);
            this.nxo.update();
            this.nxo.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.nxo = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
