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
    protected RelativeLayout mRR;
    protected RelativeLayout mRS;
    protected OnlineToggleButton mRT;
    protected RelativeLayout mRU;
    protected OnlineToggleButton mRV;
    protected RelativeLayout mRW;
    protected OnlineToggleButton mRX;
    protected OnlineToggleButton mRY;
    protected LinearLayout mRZ;
    protected H5Container mSA;
    protected RelativeLayout mSB;
    protected PopupWindow mSD;
    protected PopupWindow mSE;
    protected List<PrivacyItem> mSF;
    protected com.kascend.chushou.player.adapter.b mSG;
    protected PopupWindow mSH;
    protected ImageView mSI;
    protected List<PrivacyItem> mSJ;
    protected FrescoThumbnailView mSK;
    protected ArrayList<String> mSL;
    protected PopupWindow mSa;
    protected PopupWindow mSb;
    protected PopupWindow mSc;
    protected RecyclerView mSd;
    protected LinearLayoutManager mSe;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> mSf;
    protected ArrayList<a> mSg;
    protected ArrayList<a> mSh;
    protected PopupWindow mSi;
    protected View mSj;
    protected SVGAImageView mSk;
    protected View mSl;
    protected EmanateView mSm;
    protected RoomSendGiftView mSn;
    protected RoundProgressBar mSo;
    protected TextView mSq;
    protected FrescoThumbnailView mSr;
    protected PaoGuideView mSs;
    protected AnimatorSet mSx;
    protected KasBaseMenuView.a mSy;
    protected boolean aR = false;
    protected int bb = 0;
    protected long mSt = 0;
    protected boolean mSu = false;
    protected IconConfig.Config mSv = new IconConfig.Config();
    protected CSDanmuLayout mSw = null;
    protected boolean mSz = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.dFS() && g.this.mSd != null && g.this.mSf != null && g.this.mSe != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.mSe.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.mSe.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.mSe.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.mSe.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.mSe.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.mSd.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.mRK != null) {
                                    g.this.mRK.P(g.this.d);
                                    if (g.this.b) {
                                        g.this.mRK.e(g.this.d, 1000L);
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
    public RelativeLayout dFT() {
        if (this.mRR == null) {
            this.mRR = (RelativeLayout) this.mRt.findViewById(a.f.video_root_view);
        }
        return this.mRR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(View view, int i, int i2) {
        if (!this.mSz) {
            ag();
        }
        ah();
        if (this.mSa != null) {
            if (!this.mSa.isShowing()) {
                this.mSa.showAtLocation(view, 53, i, i2);
            } else {
                this.mSa.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point gv = tv.chushou.zues.utils.a.gv(this.mRJ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dEn().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dEn().b(1);
                layoutParams.width = -1;
                if (this.mRJ.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gv.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dEn().b(2);
                layoutParams.width = -1;
                if (this.mRJ.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gv.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.mSw != null) {
            this.mSw.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(View view, int i, int i2) {
        ae();
        if (this.mSb != null) {
            if (!this.mSb.isShowing()) {
                if (this.mRJ.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.mSb.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.mSb.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.mSb.showAtLocation(view, 53, i, i2);
                return;
            }
            this.mSb.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.mRJ.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.mRJ).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.mRY = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dEn().b) {
                this.mRY.b();
            } else {
                this.mRY.c();
            }
        } else if (this.ap < 0) {
            if (h.dEn().n()) {
                this.mRY.b();
            } else {
                this.mRY.c();
            }
        } else if (h.dEn().o()) {
            this.mRY.b();
        } else {
            this.mRY.c();
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
        switch (h.dEn().m()) {
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
        if (this.mRJ.getResources().getConfiguration().orientation == 1) {
            this.mSb = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mRJ, 230.0f), -2);
            this.mSb.setBackgroundDrawable(this.mRJ.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.mSb = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mRJ, 295.0f), -1);
            this.mSb.setClippingEnabled(false);
            this.mSb.setBackgroundDrawable(this.mRJ.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.mSb.setFocusable(true);
        this.mSb.setOutsideTouchable(true);
        this.mSb.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dEn().a(true);
        } else if (this.ap < 0) {
            h.dEn().e(true);
        } else {
            h.dEn().f(true);
        }
        switch (h.dEn().m()) {
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
        if (!this.mSz) {
            int i2 = a.h.pop_full_play_setting;
            if (this.mRJ.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.mRJ).inflate(i2, (ViewGroup) null);
            this.mRZ = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.mRS = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.mRT = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.mRU = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.mRV = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.mRW = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mRX = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.mRJ.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mRJ);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.B(10.0f);
                }
                this.mRZ.setPadding(this.mRZ.getPaddingLeft(), statusBarHeight, this.mRZ.getPaddingRight(), this.mRZ.getPaddingBottom());
            }
            this.mRS.setOnClickListener(this);
            this.mRU.setOnClickListener(this);
            this.mRW.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.mRS.setVisibility(8);
            } else {
                this.mRS.setVisibility(0);
            }
            if (((VideoPlayer) this.mRJ).q) {
                this.mRT.b();
            } else {
                this.mRT.c();
            }
            if (h.dEn().q()) {
                this.mRV.b();
            } else {
                this.mRV.c();
            }
            if (com.kascend.chushou.c.a) {
                this.mRW.setVisibility(0);
            } else {
                this.mRW.setVisibility(8);
            }
            if (h.dEn().a) {
                this.mRX.b();
            } else {
                this.mRX.c();
            }
            if (this.mRI != null && (arrayList = this.mRI.f) != null && arrayList.size() > 0) {
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
                            if (this.mRJ.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.mRJ).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dFa = this.mRI.dFa();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mRJ).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.mRJ.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.mRJ).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mRJ, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mRJ, 6.0f);
                                    }
                                    int identifier = this.mRJ.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mRJ.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mRZ, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dFa != null && dFa.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.mRZ.addView(inflate2);
                            this.mSz = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.mRJ.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.mRJ).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dFa2 = this.mRI.dFa();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mRJ).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.mRJ.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.mRJ).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mRJ, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mRJ, 6.0f);
                                    }
                                    int identifier2 = this.mRJ.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mRJ.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mRZ, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dFa2 != null && dFa2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.mRZ.addView(inflate3);
                            this.mSz = true;
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
            if (this.mRJ.getResources().getConfiguration().orientation == 1) {
                this.mSa = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mRJ, 230.0f), -2);
                this.mSa.setBackgroundDrawable(this.mRJ.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.mSa = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mRJ, 295.0f), -1);
                this.mSa.setClippingEnabled(false);
                this.mSa.setBackgroundDrawable(this.mRJ.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.mSa.setFocusable(true);
            this.mSa.setOutsideTouchable(true);
            this.mSa.update();
        }
    }

    protected void ah() {
        if (this.mRU != null && this.mRV != null) {
            this.mRU.setVisibility(0);
            if (h.dEn().q()) {
                this.mRV.b();
            } else {
                this.mRV.c();
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
        com.kascend.chushou.toolkit.a.c.a(this.mRJ, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.mRI.f;
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
            if (this.mRZ == null) {
                this.mRI.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.mRI.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.mRJ).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mRZ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mRZ.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mRJ.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mRJ.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mRZ, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.mRJ, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.mRI.f;
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
            if (this.mRZ == null) {
                if (!z) {
                    this.mRI.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.mRI.a(playUrl);
                if (this.ap >= 0) {
                    this.mRI.a(false);
                    if (this.mRJ != null) {
                        ((VideoPlayer) this.mRJ).a(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.mRJ).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mRZ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mRZ.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mRJ.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mRJ.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mRZ, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.mSa != null) {
            this.mSa.dismiss();
        }
        if (this.mSc != null) {
            this.mSc.dismiss();
        }
        PlayUrl dFa = this.mRI.dFa();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.mRI.d) {
                this.mRI.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.mRI.a(playUrl);
                this.mRI.a(false);
                if (this.mRJ != null) {
                    ((VideoPlayer) this.mRJ).a(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.mRI.d) {
            this.mRI.e = true;
        }
        h.dEn().a(this.mRJ, urlDetails.mDefinitionType);
        if (z || (dFa != null && !dFa.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.mRJ, dFR(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.mRI.a(playUrl);
            if (dFR()) {
                if (((VideoPlayer) this.mRJ) != null) {
                    ((VideoPlayer) this.mRJ).r = -1L;
                }
                if (this.mNX != null) {
                    this.mjc = this.mNX.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.mRJ).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.mRO = str2;
        if (this.mRK != null) {
            this.mRK.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.aR = true;
            if (this.mSh == null) {
                this.mSh = new ArrayList<>();
            }
            this.mSh.clear();
            this.mSh.addAll(list);
            this.mSi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.mSi == null) {
            View inflate = LayoutInflater.from(this.mRJ).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.mRJ.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.mRJ.getResources().getColor(a.c.player_bg_color));
            }
            if (this.aR && !tv.chushou.zues.utils.h.isEmpty(this.mSh)) {
                this.mSg = this.mSh;
            } else {
                this.mSg = (ArrayList) h.dEn().dEp();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.mSg)) {
                String[] stringArray = this.mRJ.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.mRJ.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.mSg == null) {
                    this.mSg = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.mSg.add(aVar);
                }
            }
            this.mSd = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.mSf = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.mSg, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void B(View view, int i4) {
                    a aVar2;
                    if (g.this.mSi != null) {
                        g.this.mSi.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.mSg) && i4 < g.this.mSg.size() && (aVar2 = g.this.mSg.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.aR) {
                            g.this.mSg.remove(i4);
                            g.this.mSg.add(0, aVar2);
                            g.this.mSf.notifyDataSetChanged();
                            g.this.mSd.scrollToPosition(0);
                            RxExecutor.post(g.this.mRs, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dEn().a((Object) g.this.mSg);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.mRJ, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.mRI != null && g.this.mRI.dEZ() != null && g.this.mRI.dEZ().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.mRI.dEZ().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0921a view$OnLongClickListenerC0921a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0921a.a(a.f.tv_name, g.this.mRJ.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0921a.a(a.f.tv_name, g.this.mRJ.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0921a.a(a.f.tv_name, g.this.mRJ.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0921a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.mSe = new LinearLayoutManager(this.mRJ);
            this.mSd.setLayoutManager(this.mSe);
            this.mSd.setAdapter(this.mSf);
            this.mSd.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.mSi = new PopupWindow(inflate, this.mRJ.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.mRJ.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.mSi.setFocusable(true);
            this.mSi.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.mSi.setBackgroundDrawable(this.mRJ.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.mSi.setBackgroundDrawable(this.mRJ.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.mSi.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.mRK.P(this.d);
        this.mRK.r(this.d);
    }

    protected void an() {
        this.b = true;
        this.mRK.P(this.d);
        this.mRK.e(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.mRK != null) {
            this.mRK.P(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bt(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.mRI != null) {
                RoomInfo dFc = this.mRI.dFc();
                if (dFc != null) {
                    str = dFc.mRoomID;
                }
                if (dFc != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dFc.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.mRJ, listItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.mRt != null) {
            Point gv = tv.chushou.zues.utils.a.gv(this.mRJ);
            int i = gv.x > gv.y ? 1 : 2;
            if (this.mSA == null) {
                this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mSA.setPlayerViewHelper(this.mRI);
            this.mSA.setVisibility(0);
            this.mSA.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.mRI != null && (e = this.mRI.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.mSA != null) {
            this.mSA.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.mSj == null && this.mSk == null) {
            if (this.mRI.mKF != null) {
                ChatInfo dEX = this.mRI.mKF.dEX();
                if (dEX == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.mSB == null) {
                    this.mSB = (RelativeLayout) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dEX.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dEX.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dEX.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dEX.mAnimSubType > 0) {
                    dEX.mAnimType = dEX.mAnimSubType;
                }
                if (dEX.mAnimationPluginId == 1) {
                    this.mSj = com.kascend.chushou.toolkit.d.a.dGr().a(this.mRJ, String.valueOf(dEX.mAnimType), this.mSB, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.dFS() && g.this.mSj != null && g.this.mSB != null) {
                                Object tag = g.this.mSj.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dGr().a(g.this.mRJ, String.valueOf(((ChatInfo) tag).mAnimType), g.this.mSB, g.this.mSj);
                                }
                                if (!z) {
                                    g.this.mSj.setVisibility(8);
                                    g.this.mSB.removeView(g.this.mSj);
                                    g.this.mSj = null;
                                    if (g.this.mRK != null) {
                                        g.this.mRK.removeMessages(11);
                                        g.this.mRK.A(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.mSj = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dEX.mJsonData);
                } else if (dEX.mAnimationPluginId == 2) {
                    if (this.mSk == null && this.mSB != null) {
                        this.mSk = (SVGAImageView) this.mSB.findViewById(a.f.svgaView);
                        if (this.mSk == null) {
                            this.mSk = new SVGAImageView(this.mRJ);
                            this.mSk.setClearsAfterStop(true);
                            this.mSk.setLoops(1);
                            this.mSk.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.mSB.addView(this.mSk, layoutParams);
                        }
                    }
                    if (this.mSk == null) {
                        cVar.removeMessages(11);
                        cVar.A(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dGr().a(this.mRJ, String.valueOf(dEX.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.mSk.stopAnimation();
                            g.this.mSk.clearAnimation();
                            g.this.mSk.setVisibility(8);
                            g.this.mSk = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Qv() {
                            g.this.mSk.stopAnimation();
                            g.this.mSk.clearAnimation();
                            g.this.mSk.setVisibility(8);
                            g.this.mSk = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Qw() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.mSk, dEX);
                }
                if (this.mSj != null) {
                    this.mSj.setTag(dEX);
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
        if (this.mSl == null) {
            if (this.mRI.mKF != null) {
                int g = this.mRI.mKF.g();
                ChatInfo dEY = this.mRI.mKF.dEY();
                if (dEY == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dEY, g);
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
        if (this.mSl != null || getContext() == null) {
            if (this.mRK != null) {
                this.mRK.removeMessages(12);
                this.mRK.A(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.mSl = this.mRt.findViewById(a.f.rl_show_tip);
            if (this.mSl != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dEg().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mRJ);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mSl.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.mRJ, 5.0f);
                    this.mSl.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.mSl = this.mRt.findViewById(a.f.rl_tip);
        }
        if (this.mSl != null) {
            this.mSl.setVisibility(0);
            this.mSl.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mRI != null) {
                            RoomInfo dFc = g.this.mRI.dFc();
                            if (dFc != null) {
                                str = dFc.mRoomID;
                            }
                            if (dFc != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dFc.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mRJ, chatInfo.mItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.mSl.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.mSl.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mRI != null) {
                            RoomInfo dFc = g.this.mRI.dFc();
                            if (dFc != null) {
                                str = dFc.mRoomID;
                            }
                            if (dFc != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dFc.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mRJ, chatInfo.mItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.mRJ.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mRJ, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mRJ, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0795a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.gv(getContext()).x;
                if (this.mRJ.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mRJ, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mRJ, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0795a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.mSl.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.mSl != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.mSl.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.mSl.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.mSx == null) {
                                g.this.mSx = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.mSx.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.mSx.removeAllListeners();
                            }
                            g.this.mSx.playTogether(ObjectAnimator.ofFloat(g.this.mSl, "translationX", g.this.mSl.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.mSx.start();
                            if (g.this.mRK != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.mRK.A(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void dsT() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!dFS() && this.mSl != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.mSl, "translationX", 0.0f, 10.0f, -this.mSl.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.dFS()) {
                        if (g.this.mSl != null) {
                            g.this.mSl.setVisibility(8);
                        }
                        g.this.mSl = null;
                        if (g.this.mRK != null) {
                            g.this.mRK.A(12, 800L);
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
            if (this.mSx == null) {
                this.mSx = new AnimatorSet();
            }
            this.mSx.playTogether(duration);
            this.mSx.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dsU() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.mRJ).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.mSm = new EmanateView(this.mRJ);
            this.mSm.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.mSm);
            return;
        }
        this.mSm = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.mSn == null) {
            this.mSn = (RoomSendGiftView) this.mRt.findViewById(a.f.normalSendGiftView);
            this.mSn.setContext(this.mRJ);
            if (this.mRI != null) {
                this.mSn.a(this.mRI.dEZ());
            }
            this.mSn.a(z, z2);
            this.mSn.setVisibilityListener(this.mSy);
            this.mSn.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.mSm != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable Sw = tv.chushou.zues.utils.h.Sw(str);
                            if (Sw == null) {
                                Sw = tv.chushou.zues.utils.h.Sy(str);
                            }
                            g.this.mSm.setDrawable(Sw, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.mSm.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.mSm.dSo();
                        }
                    }
                }
            });
            this.mSn.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void b(ConfigDetail configDetail) {
                    if (configDetail != null) {
                        g.this.b(configDetail);
                    }
                }

                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void a(boolean z3, boolean z4) {
                    g.this.at(z3, z4);
                }
            });
        }
        if (this.mSn != null) {
            if (this.mRI != null) {
                this.mSn.a(z ? this.mRI.mKK : this.mRI.mKL, this.mRI.mKM, this.mRI.mKN, z);
                this.mSn.setGiftTopIcon(this.mRI.s);
            }
            if (micMemberInfo != null) {
                this.mSn.setMicMemberInfo(micMemberInfo);
            }
            this.mSn.c();
        }
    }

    protected void at(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.mSo.setProgress(i);
            if (!this.mSu) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.mSq.setText(this.mRJ.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.mSq.setText(this.mRJ.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.mSq.setText(this.mRJ.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.mSr.bV(str, a.e.pao_circle_default);
            if (this.mSt != i) {
                this.mSr.startAnimation(AnimationUtils.loadAnimation(this.mRJ, a.C0795a.pao_beat_anim));
                this.mSt = i;
            }
            if (this.bb != bangInfo.mLevel) {
                if (this.mRK != null && !this.mRK.Kt(17)) {
                    this.mRK.b(this.mRK.Ku(17), 500L);
                }
                this.bb = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.mSs.b()) {
            WindowManager windowManager = (WindowManager) this.mRJ.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                this.mSs.a(this.mRJ, i, this.mRI.dEZ().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.mSs.e();
        this.mSs.c();
    }

    public void dFU() {
        this.mSr.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.mSr.getWidth() / 2, this.mSr.getHeight() / 2);
        aVar.setDuration(1000L);
        this.mSr.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.mSw == null && this.mRJ != null) {
            if ("3".equals(this.aw)) {
                z = h.dEn().b;
            } else if (this.mRI == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dEn().d;
            } else {
                z = h.dEn().e;
            }
            this.mSw = new CSDanmuLayout(this.mRJ.getApplicationContext(), new a.C0910a().Kq(-16711936).Kp(800).xm(true).xn(this.ap >= 0).Ko(2).dRj(), h.dEn().b());
            this.mSw.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.mRJ);
            Point gv = tv.chushou.zues.utils.a.gv(this.mRJ);
            switch (h.dEn().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.mRJ.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gv.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.mRJ.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gv.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dFT().addView(this.mSw, 1, layoutParams);
            if (this.mSw != null) {
                this.mSw.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.mSw != null) {
            this.mSw.setVisibility(8);
            this.mSw.dRk();
        }
        if (this.mSw != null) {
            this.mSw.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void S() {
        if (this.mSw != null && this.mRI != null) {
            if (this.ap < 0) {
                this.mSw.setVisibility(h.dEn().d ? 0 : 8);
            } else {
                this.mSw.setVisibility(h.dEn().e ? 0 : 8);
            }
        }
        if (this.mSw != null && this.mSw.isPrepared() && !this.H && !this.al) {
            this.mSw.resume();
            this.mSw.dRk();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.mSH == null) {
            if (this.mSF == null) {
                this.mSF = new ArrayList();
            }
            this.mSF.clear();
            aY(getString(a.i.danmu_settings_no_gift), false);
            aY(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.mRJ).mJi != null) {
                if (this.mRI.dEZ() != null) {
                    this.mSJ = this.mRI.dEZ().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.mSJ)) {
                    aY(getString(a.i.danmu_settings_no_normal), true);
                    this.mSF.addAll(this.mSJ);
                } else {
                    aY(getString(a.i.danmu_settings_no_normal), false);
                }
            } else {
                aY(getString(a.i.danmu_settings_no_normal), false);
            }
            if (i == 3) {
                i2 = a.h.pop_privacy_setting_black;
            } else {
                i2 = a.h.pop_privacy_setting;
            }
            View inflate = LayoutInflater.from(this.mRJ).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mRJ));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.mSI = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.mRJ).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mSI.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mSI.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.mSG = new com.kascend.chushou.player.adapter.b(i, this.mRJ, this.mSF, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.mSG);
            if (!tv.chushou.zues.utils.h.isEmpty(this.mSJ) && this.mSJ.size() >= 5) {
                this.mSH = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mRJ, 165.0f), tv.chushou.zues.utils.a.dip2px(this.mRJ, 354.0f));
            } else {
                this.mSH = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mRJ, 165.0f), -2);
            }
            this.mSH.setFocusable(true);
            this.mSH.setOutsideTouchable(true);
            this.mSH.setBackgroundDrawable(this.mRJ.getResources().getDrawable(a.e.bg_room_pop));
            this.mSH.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dFV() {
        i(2);
    }

    protected void aY(String str, boolean z) {
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
        if (this.mSF != null) {
            this.mSF.add(privacyItem);
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
        if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "26", "chatType", str2, "chatState", str, "roomId", this.mRI.dEZ().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.mSG.notifyDataSetChanged();
        au();
    }

    protected void au() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.dRX()) {
            tv.chushou.zues.utils.g.c(this.mRJ, this.mRJ.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dEj().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.mSG.notifyDataSetChanged();
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
                        g.this.mSG.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.mSG.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.mSF) {
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
                for (PrivacyItem privacyItem3 : this.mSF) {
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
            for (PrivacyItem privacyItem4 : this.mSF) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.mSL == null) {
            this.mSL = new ArrayList<>();
        }
        this.mSL.add(str);
        this.mSL.add(str2);
        p pVar = new p();
        pVar.a = this.mSL;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.mSL == null) {
            this.mSL = new ArrayList<>();
        }
        this.mSL.add(str);
        p pVar = new p();
        pVar.a = this.mSL;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.mSL != null) {
            this.mSL.remove(str);
            this.mSL.remove(str2);
            p pVar = new p();
            pVar.a = this.mSL;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.mSL != null) {
            this.mSL.remove(str);
            p pVar = new p();
            pVar.a = this.mSL;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dFq = dFq();
        if (dFq != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dFq.getLayoutParams();
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
            dFq.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dFq = dFq();
        if (dFq != null) {
            dFq.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dEn().q()) {
                h.dEn().g(false);
                this.mRV.c();
                return;
            }
            h.dEn().g(true);
            this.mRV.b();
        } else if (id == a.f.rl_decode) {
            if (h.dEn().a) {
                h.dEn().a(this.mRJ, false);
                this.mRX.c();
            } else {
                h.dEn().a(this.mRJ, true);
                this.mRX.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.mRJ, dFR(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.mRJ).q) {
                ((VideoPlayer) this.mRJ).q = false;
                if (this.mRI.mKF != null) {
                    this.mRI.mKF.e();
                    this.mRI.mKF.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.mRT.c();
                return;
            }
            ((VideoPlayer) this.mRJ).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.mRT.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dEn().o();
            if (this.ap < 0) {
                o = h.dEn().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dEn().b;
            }
            boolean z = !o;
            if (z) {
                this.mRY.b();
            } else {
                this.mRY.c();
            }
            if (!this.aw.equals("1")) {
                h.dEn().a(z);
            } else if (this.ap < 0) {
                h.dEn().e(z);
            } else {
                h.dEn().f(z);
            }
            switch (h.dEn().m()) {
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
            com.kascend.chushou.toolkit.a.c.c(this.mRJ, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.mRJ).q) {
                ((VideoPlayer) this.mRJ).q = false;
                if (this.mRI.mKF != null) {
                    this.mRI.mKF.e();
                    this.mRI.mKF.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mSI.setImageResource(i);
            } else {
                ((VideoPlayer) this.mRJ).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mSI.setImageResource(i2);
            }
            au();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.mSA != null) {
            this.mSA.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0810a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dFz() {
        return null;
    }

    public GiftAnimationLayout dFq() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dFJ() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dFc;
        if (this.mRI != null && (dFc = this.mRI.dFc()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dFc.mOnlineCount.equals(str2) || !dFc.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dFc.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dFc.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dFJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dEn().c(true);
        if (this.mSD == null) {
            a();
        }
        if (!this.mSD.isShowing()) {
            if (view != null) {
                this.mSD.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.mRJ, 3.0f), (this.mRt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.mRJ, 8.0f));
                RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.mSD != null) {
                            g.this.mSD.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.mSD.dismiss();
    }

    private void a() {
        if (this.mSD == null) {
            View inflate = LayoutInflater.from(this.mRJ).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.mRJ.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.mRJ.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.mSD = new PopupWindow(inflate, -2, -2);
            this.mSD.setFocusable(true);
            this.mSD.setOutsideTouchable(true);
            this.mSD.setAnimationStyle(a.j.gift_toast_style);
            this.mSD.update();
            this.mSD.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.mSD = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
