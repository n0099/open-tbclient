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
    protected RelativeLayout mYA;
    protected OnlineToggleButton mYB;
    protected RelativeLayout mYC;
    protected OnlineToggleButton mYD;
    protected RelativeLayout mYE;
    protected OnlineToggleButton mYF;
    protected OnlineToggleButton mYG;
    protected LinearLayout mYH;
    protected PopupWindow mYI;
    protected PopupWindow mYJ;
    protected PopupWindow mYK;
    protected RecyclerView mYL;
    protected LinearLayoutManager mYM;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> mYN;
    protected ArrayList<a> mYO;
    protected ArrayList<a> mYP;
    protected PopupWindow mYQ;
    protected View mYS;
    protected SVGAImageView mYT;
    protected View mYU;
    protected EmanateView mYV;
    protected RoomSendGiftView mYW;
    protected RoundProgressBar mYX;
    protected TextView mYY;
    protected FrescoThumbnailView mYZ;
    protected RelativeLayout mYz;
    protected PaoGuideView mZa;
    protected AnimatorSet mZf;
    protected KasBaseMenuView.a mZg;
    protected H5Container mZh;
    protected RelativeLayout mZi;
    protected PopupWindow mZj;
    protected PopupWindow mZk;
    protected List<PrivacyItem> mZl;
    protected com.kascend.chushou.player.adapter.b mZm;
    protected PopupWindow mZn;
    protected ImageView mZo;
    protected List<PrivacyItem> mZp;
    protected FrescoThumbnailView mZq;
    protected ArrayList<String> mZr;
    protected boolean mYR = false;
    protected int aSz = 0;
    protected long mZb = 0;
    protected boolean mZc = false;
    protected IconConfig.Config mZd = new IconConfig.Config();
    protected CSDanmuLayout mZe = null;
    protected boolean bi = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.dDP() && g.this.mYL != null && g.this.mYN != null && g.this.mYM != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.mYM.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.mYM.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.mYM.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.mYM.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.mYM.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.mYL.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.mYs != null) {
                                    g.this.mYs.removeCallbacks(g.this.d);
                                    if (g.this.b) {
                                        g.this.mYs.d(g.this.d, 1000L);
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
    public RelativeLayout dDQ() {
        if (this.mYz == null) {
            this.mYz = (RelativeLayout) this.mYb.findViewById(a.f.video_root_view);
        }
        return this.mYz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(View view, int i, int i2) {
        if (!this.bi) {
            ag();
        }
        ah();
        if (this.mYI != null) {
            if (!this.mYI.isShowing()) {
                this.mYI.showAtLocation(view, 53, i, i2);
            } else {
                this.mYI.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point hd = tv.chushou.zues.utils.a.hd(this.mYr);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dBV().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dBV().b(1);
                layoutParams.width = -1;
                if (this.mYr.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mYv / 3;
                } else {
                    layoutParams.height = hd.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dBV().b(2);
                layoutParams.width = -1;
                if (this.mYr.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mYv / 3;
                } else {
                    layoutParams.height = hd.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.mZe != null) {
            this.mZe.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(View view, int i, int i2) {
        ae();
        if (this.mYJ != null) {
            if (!this.mYJ.isShowing()) {
                if (this.mYr.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.mYJ.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.mYJ.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.mYJ.showAtLocation(view, 53, i, i2);
                return;
            }
            this.mYJ.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.mYr.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.mYr).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.mYG = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dBV().b) {
                this.mYG.b();
            } else {
                this.mYG.c();
            }
        } else if (this.ap < 0) {
            if (h.dBV().n()) {
                this.mYG.b();
            } else {
                this.mYG.c();
            }
        } else if (h.dBV().o()) {
            this.mYG.b();
        } else {
            this.mYG.c();
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
        switch (h.dBV().m()) {
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
        if (this.mYr.getResources().getConfiguration().orientation == 1) {
            this.mYJ = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYr, 230.0f), -2);
            this.mYJ.setBackgroundDrawable(this.mYr.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.mYJ = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYr, 295.0f), -1);
            this.mYJ.setClippingEnabled(false);
            this.mYJ.setBackgroundDrawable(this.mYr.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.mYJ.setFocusable(true);
        this.mYJ.setOutsideTouchable(true);
        this.mYJ.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dBV().a(true);
        } else if (this.ap < 0) {
            h.dBV().e(true);
        } else {
            h.dBV().f(true);
        }
        switch (h.dBV().m()) {
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
            if (this.mYr.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.mYr).inflate(i2, (ViewGroup) null);
            this.mYH = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.mYA = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.mYB = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.mYC = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.mYD = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.mYE = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mYF = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.mYr.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYr);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.S(10.0f);
                }
                this.mYH.setPadding(this.mYH.getPaddingLeft(), statusBarHeight, this.mYH.getPaddingRight(), this.mYH.getPaddingBottom());
            }
            this.mYA.setOnClickListener(this);
            this.mYC.setOnClickListener(this);
            this.mYE.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.mYA.setVisibility(8);
            } else {
                this.mYA.setVisibility(0);
            }
            if (((VideoPlayer) this.mYr).q) {
                this.mYB.b();
            } else {
                this.mYB.c();
            }
            if (h.dBV().q()) {
                this.mYD.b();
            } else {
                this.mYD.c();
            }
            if (com.kascend.chushou.c.a) {
                this.mYE.setVisibility(0);
            } else {
                this.mYE.setVisibility(8);
            }
            if (h.dBV().a) {
                this.mYF.b();
            } else {
                this.mYF.c();
            }
            if (this.mYq != null && (arrayList = this.mYq.f) != null && arrayList.size() > 0) {
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
                            if (this.mYr.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.mYr).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dCG = this.mYq.dCG();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mYr).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.mYr.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.mYr).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mYr, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mYr, 6.0f);
                                    }
                                    int identifier = this.mYr.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mYr.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mYH, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dCG != null && dCG.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.mYH.addView(inflate2);
                            this.bi = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.mYr.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.mYr).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dCG2 = this.mYq.dCG();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mYr).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.mYr.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.mYr).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mYr, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mYr, 6.0f);
                                    }
                                    int identifier2 = this.mYr.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mYr.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mYH, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dCG2 != null && dCG2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.mYH.addView(inflate3);
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
            if (this.mYr.getResources().getConfiguration().orientation == 1) {
                this.mYI = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYr, 230.0f), -2);
                this.mYI.setBackgroundDrawable(this.mYr.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.mYI = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYr, 295.0f), -1);
                this.mYI.setClippingEnabled(false);
                this.mYI.setBackgroundDrawable(this.mYr.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.mYI.setFocusable(true);
            this.mYI.setOutsideTouchable(true);
            this.mYI.update();
        }
    }

    protected void ah() {
        if (this.mYC != null && this.mYD != null) {
            this.mYC.setVisibility(0);
            if (h.dBV().q()) {
                this.mYD.b();
            } else {
                this.mYD.c();
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
        com.kascend.chushou.toolkit.a.c.a(this.mYr, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.mYq.f;
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
            if (this.mYH == null) {
                this.mYq.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.mYq.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.mYr).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mYH.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mYH.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mYr.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mYr.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mYH, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.mYr, "点击音视切换_num", "视频切音频", new Object[0]);
        o(false);
    }

    protected void o(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.mYq.f;
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
            if (this.mYH == null) {
                if (!z) {
                    this.mYq.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.mYq.a(playUrl);
                if (this.ap >= 0) {
                    this.mYq.a(false);
                    if (this.mYr != null) {
                        ((VideoPlayer) this.mYr).a(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.mYr).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mYH.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mYH.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mYr.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mYr.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mYH, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.mYI != null) {
            this.mYI.dismiss();
        }
        if (this.mYK != null) {
            this.mYK.dismiss();
        }
        PlayUrl dCG = this.mYq.dCG();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.mYq.d) {
                this.mYq.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.mYq.a(playUrl);
                this.mYq.a(false);
                if (this.mYr != null) {
                    ((VideoPlayer) this.mYr).a(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.mYq.d) {
            this.mYq.e = true;
        }
        h.dBV().a(this.mYr, urlDetails.mDefinitionType);
        if (z || (dCG != null && !dCG.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.f(this.mYr, ou(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.mYq.a(playUrl);
            if (ou()) {
                if (((VideoPlayer) this.mYr) != null) {
                    ((VideoPlayer) this.mYr).r = -1L;
                }
                if (this.mUF != null) {
                    this.kWq = this.mUF.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.mYr).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.mYw = str2;
        if (this.mYs != null) {
            this.mYs.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.mYR = true;
            if (this.mYP == null) {
                this.mYP = new ArrayList<>();
            }
            this.mYP.clear();
            this.mYP.addAll(list);
            this.mYQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.mYQ == null) {
            View inflate = LayoutInflater.from(this.mYr).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.mYr.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.mYr.getResources().getColor(a.c.player_bg_color));
            }
            if (this.mYR && !tv.chushou.zues.utils.h.isEmpty(this.mYP)) {
                this.mYO = this.mYP;
            } else {
                this.mYO = (ArrayList) h.dBV().dBX();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.mYO)) {
                String[] stringArray = this.mYr.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.mYr.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.mYO == null) {
                    this.mYO = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.mYO.add(aVar);
                }
            }
            this.mYL = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.mYN = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.mYO, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void onItemClick(View view, int i4) {
                    a aVar2;
                    if (g.this.mYQ != null) {
                        g.this.mYQ.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.mYO) && i4 < g.this.mYO.size() && (aVar2 = g.this.mYO.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.mYR) {
                            g.this.mYO.remove(i4);
                            g.this.mYO.add(0, aVar2);
                            g.this.mYN.notifyDataSetChanged();
                            g.this.mYL.scrollToPosition(0);
                            RxExecutor.post(g.this.mYa, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dBV().a((Object) g.this.mYO);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.mYr, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.mYq != null && g.this.mYq.dCF() != null && g.this.mYq.dCF().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.mYq.dCF().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0813a view$OnLongClickListenerC0813a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0813a.a(a.f.tv_name, g.this.mYr.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0813a.a(a.f.tv_name, g.this.mYr.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0813a.a(a.f.tv_name, g.this.mYr.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0813a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.mYM = new LinearLayoutManager(this.mYr);
            this.mYL.setLayoutManager(this.mYM);
            this.mYL.setAdapter(this.mYN);
            this.mYL.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.mYQ = new PopupWindow(inflate, this.mYr.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.mYr.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.mYQ.setFocusable(true);
            this.mYQ.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.mYQ.setBackgroundDrawable(this.mYr.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.mYQ.setBackgroundDrawable(this.mYr.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.mYQ.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.mYs.removeCallbacks(this.d);
        this.mYs.m(this.d);
    }

    protected void an() {
        this.b = true;
        this.mYs.removeCallbacks(this.d);
        this.mYs.d(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.mYs != null) {
            this.mYs.removeCallbacks(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bF(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.mYq != null) {
                RoomInfo dCH = this.mYq.dCH();
                if (dCH != null) {
                    str = dCH.mRoomID;
                }
                if (dCH != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dCH.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.mYr, listItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.mYb != null) {
            Point hd = tv.chushou.zues.utils.a.hd(this.mYr);
            int i = hd.x > hd.y ? 1 : 2;
            if (this.mZh == null) {
                this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mZh.setPlayerViewHelper(this.mYq);
            this.mZh.setVisibility(0);
            this.mZh.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dDR() {
        HashMap e;
        if (this.mYq != null && (e = this.mYq.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.mZh != null) {
            this.mZh.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.mYS == null && this.mYT == null) {
            if (this.mYq.mQZ != null) {
                ChatInfo dCD = this.mYq.mQZ.dCD();
                if (dCD == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.mZi == null) {
                    this.mZi = (RelativeLayout) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dCD.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dCD.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dCD.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dCD.mAnimSubType > 0) {
                    dCD.mAnimType = dCD.mAnimSubType;
                }
                if (dCD.mAnimationPluginId == 1) {
                    this.mYS = com.kascend.chushou.toolkit.d.a.dEo().a(this.mYr, String.valueOf(dCD.mAnimType), this.mZi, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.dDP() && g.this.mYS != null && g.this.mZi != null) {
                                Object tag = g.this.mYS.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dEo().a(g.this.mYr, String.valueOf(((ChatInfo) tag).mAnimType), g.this.mZi, g.this.mYS);
                                }
                                if (!z) {
                                    g.this.mYS.setVisibility(8);
                                    g.this.mZi.removeView(g.this.mYS);
                                    g.this.mYS = null;
                                    if (g.this.mYs != null) {
                                        g.this.mYs.removeMessages(11);
                                        g.this.mYs.K(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.mYS = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dCD.mJsonData);
                } else if (dCD.mAnimationPluginId == 2) {
                    if (this.mYT == null && this.mZi != null) {
                        this.mYT = (SVGAImageView) this.mZi.findViewById(a.f.svgaView);
                        if (this.mYT == null) {
                            this.mYT = new SVGAImageView(this.mYr);
                            this.mYT.setClearsAfterStop(true);
                            this.mYT.setLoops(1);
                            this.mYT.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.mZi.addView(this.mYT, layoutParams);
                        }
                    }
                    if (this.mYT == null) {
                        cVar.removeMessages(11);
                        cVar.K(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dEo().a(this.mYr, String.valueOf(dCD.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.mYT.stopAnimation();
                            g.this.mYT.clearAnimation();
                            g.this.mYT.setVisibility(8);
                            g.this.mYT = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onFinished() {
                            g.this.mYT.stopAnimation();
                            g.this.mYT.clearAnimation();
                            g.this.mYT.setVisibility(8);
                            g.this.mYT = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Gr() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.mYT, dCD);
                }
                if (this.mYS != null) {
                    this.mYS.setTag(dCD);
                    return;
                }
                return;
            }
            return;
        }
        cVar.removeMessages(11);
        cVar.K(11, 800L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(tv.chushou.zues.c cVar) {
        if (this.mYU == null) {
            if (this.mYq.mQZ != null) {
                int g = this.mYq.mQZ.g();
                ChatInfo dCE = this.mYq.mQZ.dCE();
                if (dCE == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dCE, g);
                    return;
                }
            }
            return;
        }
        cVar.removeMessages(12);
        cVar.K(12, 800L);
    }

    private void a(final ChatInfo chatInfo, final int i) {
        int i2;
        if (this.mYU != null || getContext() == null) {
            if (this.mYs != null) {
                this.mYs.removeMessages(12);
                this.mYs.K(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.mYU = this.mYb.findViewById(a.f.rl_show_tip);
            if (this.mYU != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dBO().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYr);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mYU.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.mYr, 5.0f);
                    this.mYU.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.mYU = this.mYb.findViewById(a.f.rl_tip);
        }
        if (this.mYU != null) {
            this.mYU.setVisibility(0);
            this.mYU.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mYq != null) {
                            RoomInfo dCH = g.this.mYq.dCH();
                            if (dCH != null) {
                                str = dCH.mRoomID;
                            }
                            if (dCH != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dCH.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mYr, chatInfo.mItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.mYU.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.mYU.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mYq != null) {
                            RoomInfo dCH = g.this.mYq.dCH();
                            if (dCH != null) {
                                str = dCH.mRoomID;
                            }
                            if (dCH != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dCH.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mYr, chatInfo.mItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.mYr.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mYr, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mYr, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0690a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.hd(getContext()).x;
                if (this.mYr.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mYr, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mYr, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0690a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.mYU.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.mYU != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.mYU.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.mYU.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.mZf == null) {
                                g.this.mZf = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.mZf.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.mZf.removeAllListeners();
                            }
                            g.this.mZf.playTogether(ObjectAnimator.ofFloat(g.this.mYU, "translationX", g.this.mYU.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.mZf.start();
                            if (g.this.mYs != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.mYs.K(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void cXM() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!dDP() && this.mYU != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.mYU, "translationX", 0.0f, 10.0f, -this.mYU.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.dDP()) {
                        if (g.this.mYU != null) {
                            g.this.mYU.setVisibility(8);
                        }
                        g.this.mYU = null;
                        if (g.this.mYs != null) {
                            g.this.mYs.K(12, 800L);
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
            if (this.mZf == null) {
                this.mZf = new AnimatorSet();
            }
            this.mZf.playTogether(duration);
            this.mZf.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cXN() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.mYr).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.mYV = new EmanateView(this.mYr);
            this.mYV.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.mYV);
            return;
        }
        this.mYV = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.mYW == null) {
            this.mYW = (RoomSendGiftView) this.mYb.findViewById(a.f.normalSendGiftView);
            this.mYW.setContext(this.mYr);
            if (this.mYq != null) {
                this.mYW.a(this.mYq.dCF());
            }
            this.mYW.a(z, z2);
            this.mYW.setVisibilityListener(this.mZg);
            this.mYW.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.mYV != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable SX = tv.chushou.zues.utils.h.SX(str);
                            if (SX == null) {
                                SX = tv.chushou.zues.utils.h.SZ(str);
                            }
                            g.this.mYV.setDrawable(SX, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.mYV.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.mYV.dQH();
                        }
                    }
                }
            });
            this.mYW.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
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
        if (this.mYW != null) {
            if (this.mYq != null) {
                this.mYW.a(z ? this.mYq.mRg : this.mYq.mRh, this.mYq.mRi, this.mYq.mRj, z);
                this.mYW.setGiftTopIcon(this.mYq.s);
            }
            if (micMemberInfo != null) {
                this.mYW.setMicMemberInfo(micMemberInfo);
            }
            this.mYW.c();
        }
    }

    protected void at(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.mYX.setProgress(i);
            if (!this.mZc) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.mYY.setText(this.mYr.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.mYY.setText(this.mYr.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.mYY.setText(this.mYr.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.mYZ.bU(str, a.e.pao_circle_default);
            if (this.mZb != i) {
                this.mYZ.startAnimation(AnimationUtils.loadAnimation(this.mYr, a.C0690a.pao_beat_anim));
                this.mZb = i;
            }
            if (this.aSz != bangInfo.mLevel) {
                if (this.mYs != null && !this.mYs.Og(17)) {
                    this.mYs.a(this.mYs.Oh(17), 500L);
                }
                this.aSz = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(boolean z) {
        int i;
        if (!this.mZa.b()) {
            WindowManager windowManager = (WindowManager) this.mYr.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                this.mZa.a(this.mYr, i, this.mYq.dCF().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.mZa.e();
        this.mZa.c();
    }

    public void dDS() {
        this.mYZ.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.mYZ.getWidth() / 2, this.mYZ.getHeight() / 2);
        aVar.setDuration(1000L);
        this.mYZ.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.mZe == null && this.mYr != null) {
            if ("3".equals(this.aw)) {
                z = h.dBV().b;
            } else if (this.mYq == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dBV().d;
            } else {
                z = h.dBV().e;
            }
            this.mZe = new CSDanmuLayout(this.mYr.getApplicationContext(), new a.C0802a().Od(-16711936).Oc(800).wZ(true).xa(this.ap >= 0).Ob(2).dPE(), h.dBV().b());
            this.mZe.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.mYr);
            Point hd = tv.chushou.zues.utils.a.hd(this.mYr);
            switch (h.dBV().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.mYr.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mYv / 3;
                    } else {
                        layoutParams.height = hd.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.mYr.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mYv / 3;
                    } else {
                        layoutParams.height = hd.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dDQ().addView(this.mZe, 1, layoutParams);
            if (this.mZe != null) {
                this.mZe.setVisibility(z ? 0 : 8);
            }
            q(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.mZe != null) {
            this.mZe.setVisibility(8);
            this.mZe.dPF();
        }
        if (this.mZe != null) {
            this.mZe.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void cXv() {
        if (this.mZe != null && this.mYq != null) {
            if (this.ap < 0) {
                this.mZe.setVisibility(h.dBV().d ? 0 : 8);
            } else {
                this.mZe.setVisibility(h.dBV().e ? 0 : 8);
            }
        }
        if (this.mZe != null && this.mZe.isPrepared() && !this.H && !this.al) {
            this.mZe.resume();
            this.mZe.dPF();
        }
    }

    protected void q(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.mZn == null) {
            if (this.mZl == null) {
                this.mZl = new ArrayList();
            }
            this.mZl.clear();
            aO(getString(a.i.danmu_settings_no_gift), false);
            aO(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.mYr).mPA != null) {
                if (this.mYq.dCF() != null) {
                    this.mZp = this.mYq.dCF().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.mZp)) {
                    aO(getString(a.i.danmu_settings_no_normal), true);
                    this.mZl.addAll(this.mZp);
                } else {
                    aO(getString(a.i.danmu_settings_no_normal), false);
                }
            } else {
                aO(getString(a.i.danmu_settings_no_normal), false);
            }
            if (i == 3) {
                i2 = a.h.pop_privacy_setting_black;
            } else {
                i2 = a.h.pop_privacy_setting;
            }
            View inflate = LayoutInflater.from(this.mYr).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mYr));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.mZo = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.mYr).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mZo.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mZo.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.mZm = new com.kascend.chushou.player.adapter.b(i, this.mYr, this.mZl, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.mZm);
            if (!tv.chushou.zues.utils.h.isEmpty(this.mZp) && this.mZp.size() >= 5) {
                this.mZn = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYr, 165.0f), tv.chushou.zues.utils.a.dip2px(this.mYr, 354.0f));
            } else {
                this.mZn = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYr, 165.0f), -2);
            }
            this.mZn.setFocusable(true);
            this.mZn.setOutsideTouchable(true);
            this.mZn.setBackgroundDrawable(this.mYr.getResources().getDrawable(a.e.bg_room_pop));
            this.mZn.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dDT() {
        i(2);
    }

    protected void aO(String str, boolean z) {
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
        if (this.mZl != null) {
            this.mZl.add(privacyItem);
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
        if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "26", "chatType", str2, "chatState", str, "roomId", this.mYq.dCF().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.mZm.notifyDataSetChanged();
        dDf();
    }

    protected void dDf() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.dQq()) {
            tv.chushou.zues.utils.g.c(this.mYr, this.mYr.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dBR().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.mZm.notifyDataSetChanged();
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
                        g.this.mZm.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.mZm.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.mZl) {
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
                for (PrivacyItem privacyItem3 : this.mZl) {
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
            for (PrivacyItem privacyItem4 : this.mZl) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.mZr == null) {
            this.mZr = new ArrayList<>();
        }
        this.mZr.add(str);
        this.mZr.add(str2);
        p pVar = new p();
        pVar.a = this.mZr;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.mZr == null) {
            this.mZr = new ArrayList<>();
        }
        this.mZr.add(str);
        p pVar = new p();
        pVar.a = this.mZr;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.mZr != null) {
            this.mZr.remove(str);
            this.mZr.remove(str2);
            p pVar = new p();
            pVar.a = this.mZr;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.mZr != null) {
            this.mZr.remove(str);
            p pVar = new p();
            pVar.a = this.mZr;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dCZ = dCZ();
        if (dCZ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dCZ.getLayoutParams();
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
            dCZ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dCZ = dCZ();
        if (dCZ != null) {
            dCZ.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dBV().q()) {
                h.dBV().g(false);
                this.mYD.c();
                return;
            }
            h.dBV().g(true);
            this.mYD.b();
        } else if (id == a.f.rl_decode) {
            if (h.dBV().a) {
                h.dBV().a(this.mYr, false);
                this.mYF.c();
            } else {
                h.dBV().a(this.mYr, true);
                this.mYF.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.mYr, ou(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.mYr).q) {
                ((VideoPlayer) this.mYr).q = false;
                if (this.mYq.mQZ != null) {
                    this.mYq.mQZ.e();
                    this.mYq.mQZ.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.mYB.c();
                return;
            }
            ((VideoPlayer) this.mYr).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.mYB.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dBV().o();
            if (this.ap < 0) {
                o = h.dBV().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dBV().b;
            }
            boolean z = !o;
            if (z) {
                this.mYG.b();
            } else {
                this.mYG.c();
            }
            if (!this.aw.equals("1")) {
                h.dBV().a(z);
            } else if (this.ap < 0) {
                h.dBV().e(z);
            } else {
                h.dBV().f(z);
            }
            switch (h.dBV().m()) {
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
            r(z);
            com.kascend.chushou.toolkit.a.c.d(this.mYr, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.mYr).q) {
                ((VideoPlayer) this.mYr).q = false;
                if (this.mYq.mQZ != null) {
                    this.mYq.mQZ.e();
                    this.mYq.mQZ.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mZo.setImageResource(i);
            } else {
                ((VideoPlayer) this.mYr).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mZo.setImageResource(i2);
            }
            dDf();
        }
    }

    protected void r(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.mZh != null) {
            this.mZh.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dDp() {
        return null;
    }

    public GiftAnimationLayout dCZ() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dDE() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dCH;
        if (this.mYq != null && (dCH = this.mYq.dCH()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dCH.mOnlineCount.equals(str2) || !dCH.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dCH.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dCH.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dDE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dBV().c(true);
        if (this.mZj == null) {
            a();
        }
        if (!this.mZj.isShowing()) {
            if (view != null) {
                this.mZj.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.mYr, 3.0f), (this.mYb.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.mYr, 8.0f));
                RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.mZj != null) {
                            g.this.mZj.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.mZj.dismiss();
    }

    private void a() {
        if (this.mZj == null) {
            View inflate = LayoutInflater.from(this.mYr).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.mYr.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.mYr.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.mZj = new PopupWindow(inflate, -2, -2);
            this.mZj.setFocusable(true);
            this.mZj.setOutsideTouchable(true);
            this.mZj.setAnimationStyle(a.j.gift_toast_style);
            this.mZj.update();
            this.mZj.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.mZj = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
