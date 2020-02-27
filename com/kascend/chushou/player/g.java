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
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> mYA;
    protected ArrayList<a> mYB;
    protected ArrayList<a> mYC;
    protected PopupWindow mYD;
    protected View mYF;
    protected SVGAImageView mYG;
    protected View mYH;
    protected EmanateView mYI;
    protected RoomSendGiftView mYJ;
    protected RoundProgressBar mYK;
    protected TextView mYL;
    protected FrescoThumbnailView mYM;
    protected PaoGuideView mYN;
    protected AnimatorSet mYS;
    protected KasBaseMenuView.a mYT;
    protected H5Container mYU;
    protected RelativeLayout mYV;
    protected PopupWindow mYW;
    protected PopupWindow mYX;
    protected List<PrivacyItem> mYY;
    protected com.kascend.chushou.player.adapter.b mYZ;
    protected RelativeLayout mYm;
    protected RelativeLayout mYn;
    protected OnlineToggleButton mYo;
    protected RelativeLayout mYp;
    protected OnlineToggleButton mYq;
    protected RelativeLayout mYr;
    protected OnlineToggleButton mYs;
    protected OnlineToggleButton mYt;
    protected LinearLayout mYu;
    protected PopupWindow mYv;
    protected PopupWindow mYw;
    protected PopupWindow mYx;
    protected RecyclerView mYy;
    protected LinearLayoutManager mYz;
    protected PopupWindow mZa;
    protected ImageView mZb;
    protected List<PrivacyItem> mZc;
    protected FrescoThumbnailView mZd;
    protected ArrayList<String> mZe;
    protected boolean mYE = false;
    protected int aSx = 0;
    protected long mYO = 0;
    protected boolean mYP = false;
    protected IconConfig.Config mYQ = new IconConfig.Config();
    protected CSDanmuLayout mYR = null;
    protected boolean bi = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.dDM() && g.this.mYy != null && g.this.mYA != null && g.this.mYz != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.mYz.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.mYz.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.mYz.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.mYz.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.mYz.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.mYy.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.mYf != null) {
                                    g.this.mYf.removeCallbacks(g.this.d);
                                    if (g.this.b) {
                                        g.this.mYf.d(g.this.d, 1000L);
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
    public RelativeLayout dDN() {
        if (this.mYm == null) {
            this.mYm = (RelativeLayout) this.mXO.findViewById(a.f.video_root_view);
        }
        return this.mYm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(View view, int i, int i2) {
        if (!this.bi) {
            ag();
        }
        ah();
        if (this.mYv != null) {
            if (!this.mYv.isShowing()) {
                this.mYv.showAtLocation(view, 53, i, i2);
            } else {
                this.mYv.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point hd = tv.chushou.zues.utils.a.hd(this.mYe);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dBS().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dBS().b(1);
                layoutParams.width = -1;
                if (this.mYe.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mYi / 3;
                } else {
                    layoutParams.height = hd.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dBS().b(2);
                layoutParams.width = -1;
                if (this.mYe.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mYi / 3;
                } else {
                    layoutParams.height = hd.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.mYR != null) {
            this.mYR.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(View view, int i, int i2) {
        ae();
        if (this.mYw != null) {
            if (!this.mYw.isShowing()) {
                if (this.mYe.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.mYw.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.mYw.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.mYw.showAtLocation(view, 53, i, i2);
                return;
            }
            this.mYw.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.mYe.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.mYe).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.mYt = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dBS().b) {
                this.mYt.b();
            } else {
                this.mYt.c();
            }
        } else if (this.ap < 0) {
            if (h.dBS().n()) {
                this.mYt.b();
            } else {
                this.mYt.c();
            }
        } else if (h.dBS().o()) {
            this.mYt.b();
        } else {
            this.mYt.c();
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
        switch (h.dBS().m()) {
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
        if (this.mYe.getResources().getConfiguration().orientation == 1) {
            this.mYw = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYe, 230.0f), -2);
            this.mYw.setBackgroundDrawable(this.mYe.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.mYw = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYe, 295.0f), -1);
            this.mYw.setClippingEnabled(false);
            this.mYw.setBackgroundDrawable(this.mYe.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.mYw.setFocusable(true);
        this.mYw.setOutsideTouchable(true);
        this.mYw.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dBS().a(true);
        } else if (this.ap < 0) {
            h.dBS().e(true);
        } else {
            h.dBS().f(true);
        }
        switch (h.dBS().m()) {
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
            if (this.mYe.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.mYe).inflate(i2, (ViewGroup) null);
            this.mYu = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.mYn = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.mYo = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.mYp = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.mYq = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.mYr = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mYs = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.mYe.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYe);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.S(10.0f);
                }
                this.mYu.setPadding(this.mYu.getPaddingLeft(), statusBarHeight, this.mYu.getPaddingRight(), this.mYu.getPaddingBottom());
            }
            this.mYn.setOnClickListener(this);
            this.mYp.setOnClickListener(this);
            this.mYr.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.mYn.setVisibility(8);
            } else {
                this.mYn.setVisibility(0);
            }
            if (((VideoPlayer) this.mYe).q) {
                this.mYo.b();
            } else {
                this.mYo.c();
            }
            if (h.dBS().q()) {
                this.mYq.b();
            } else {
                this.mYq.c();
            }
            if (com.kascend.chushou.c.a) {
                this.mYr.setVisibility(0);
            } else {
                this.mYr.setVisibility(8);
            }
            if (h.dBS().a) {
                this.mYs.b();
            } else {
                this.mYs.c();
            }
            if (this.mYd != null && (arrayList = this.mYd.f) != null && arrayList.size() > 0) {
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
                            if (this.mYe.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.mYe).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dCD = this.mYd.dCD();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mYe).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.mYe.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.mYe).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mYe, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mYe, 6.0f);
                                    }
                                    int identifier = this.mYe.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mYe.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mYu, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dCD != null && dCD.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.mYu.addView(inflate2);
                            this.bi = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.mYe.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.mYe).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dCD2 = this.mYd.dCD();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mYe).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.mYe.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.mYe).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mYe, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mYe, 6.0f);
                                    }
                                    int identifier2 = this.mYe.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mYe.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mYu, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dCD2 != null && dCD2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.mYu.addView(inflate3);
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
            if (this.mYe.getResources().getConfiguration().orientation == 1) {
                this.mYv = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYe, 230.0f), -2);
                this.mYv.setBackgroundDrawable(this.mYe.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.mYv = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYe, 295.0f), -1);
                this.mYv.setClippingEnabled(false);
                this.mYv.setBackgroundDrawable(this.mYe.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.mYv.setFocusable(true);
            this.mYv.setOutsideTouchable(true);
            this.mYv.update();
        }
    }

    protected void ah() {
        if (this.mYp != null && this.mYq != null) {
            this.mYp.setVisibility(0);
            if (h.dBS().q()) {
                this.mYq.b();
            } else {
                this.mYq.c();
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
        com.kascend.chushou.toolkit.a.c.a(this.mYe, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.mYd.f;
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
            if (this.mYu == null) {
                this.mYd.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.mYd.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.mYe).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mYu.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mYu.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mYe.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mYe.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mYu, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.mYe, "点击音视切换_num", "视频切音频", new Object[0]);
        o(false);
    }

    protected void o(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.mYd.f;
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
            if (this.mYu == null) {
                if (!z) {
                    this.mYd.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.mYd.a(playUrl);
                if (this.ap >= 0) {
                    this.mYd.a(false);
                    if (this.mYe != null) {
                        ((VideoPlayer) this.mYe).a(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.mYe).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mYu.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mYu.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mYe.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mYe.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mYu, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.mYv != null) {
            this.mYv.dismiss();
        }
        if (this.mYx != null) {
            this.mYx.dismiss();
        }
        PlayUrl dCD = this.mYd.dCD();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.mYd.d) {
                this.mYd.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.mYd.a(playUrl);
                this.mYd.a(false);
                if (this.mYe != null) {
                    ((VideoPlayer) this.mYe).a(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.mYd.d) {
            this.mYd.e = true;
        }
        h.dBS().a(this.mYe, urlDetails.mDefinitionType);
        if (z || (dCD != null && !dCD.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.f(this.mYe, ou(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.mYd.a(playUrl);
            if (ou()) {
                if (((VideoPlayer) this.mYe) != null) {
                    ((VideoPlayer) this.mYe).r = -1L;
                }
                if (this.mUs != null) {
                    this.kWc = this.mUs.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.mYe).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.mYj = str2;
        if (this.mYf != null) {
            this.mYf.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.mYE = true;
            if (this.mYC == null) {
                this.mYC = new ArrayList<>();
            }
            this.mYC.clear();
            this.mYC.addAll(list);
            this.mYD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.mYD == null) {
            View inflate = LayoutInflater.from(this.mYe).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.mYe.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.mYe.getResources().getColor(a.c.player_bg_color));
            }
            if (this.mYE && !tv.chushou.zues.utils.h.isEmpty(this.mYC)) {
                this.mYB = this.mYC;
            } else {
                this.mYB = (ArrayList) h.dBS().dBU();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.mYB)) {
                String[] stringArray = this.mYe.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.mYe.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.mYB == null) {
                    this.mYB = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.mYB.add(aVar);
                }
            }
            this.mYy = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.mYA = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.mYB, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void onItemClick(View view, int i4) {
                    a aVar2;
                    if (g.this.mYD != null) {
                        g.this.mYD.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.mYB) && i4 < g.this.mYB.size() && (aVar2 = g.this.mYB.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.mYE) {
                            g.this.mYB.remove(i4);
                            g.this.mYB.add(0, aVar2);
                            g.this.mYA.notifyDataSetChanged();
                            g.this.mYy.scrollToPosition(0);
                            RxExecutor.post(g.this.mXN, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dBS().a((Object) g.this.mYB);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.mYe, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.mYd != null && g.this.mYd.dCC() != null && g.this.mYd.dCC().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.mYd.dCC().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0813a view$OnLongClickListenerC0813a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0813a.a(a.f.tv_name, g.this.mYe.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0813a.a(a.f.tv_name, g.this.mYe.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0813a.a(a.f.tv_name, g.this.mYe.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0813a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.mYz = new LinearLayoutManager(this.mYe);
            this.mYy.setLayoutManager(this.mYz);
            this.mYy.setAdapter(this.mYA);
            this.mYy.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.mYD = new PopupWindow(inflate, this.mYe.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.mYe.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.mYD.setFocusable(true);
            this.mYD.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.mYD.setBackgroundDrawable(this.mYe.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.mYD.setBackgroundDrawable(this.mYe.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.mYD.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.mYf.removeCallbacks(this.d);
        this.mYf.m(this.d);
    }

    protected void an() {
        this.b = true;
        this.mYf.removeCallbacks(this.d);
        this.mYf.d(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.mYf != null) {
            this.mYf.removeCallbacks(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bF(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.mYd != null) {
                RoomInfo dCE = this.mYd.dCE();
                if (dCE != null) {
                    str = dCE.mRoomID;
                }
                if (dCE != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dCE.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.mYe, listItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.mXO != null) {
            Point hd = tv.chushou.zues.utils.a.hd(this.mYe);
            int i = hd.x > hd.y ? 1 : 2;
            if (this.mYU == null) {
                this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYU.setPlayerViewHelper(this.mYd);
            this.mYU.setVisibility(0);
            this.mYU.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dDO() {
        HashMap e;
        if (this.mYd != null && (e = this.mYd.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.mYU != null) {
            this.mYU.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.mYF == null && this.mYG == null) {
            if (this.mYd.mQM != null) {
                ChatInfo dCA = this.mYd.mQM.dCA();
                if (dCA == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.mYV == null) {
                    this.mYV = (RelativeLayout) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dCA.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dCA.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dCA.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dCA.mAnimSubType > 0) {
                    dCA.mAnimType = dCA.mAnimSubType;
                }
                if (dCA.mAnimationPluginId == 1) {
                    this.mYF = com.kascend.chushou.toolkit.d.a.dEl().a(this.mYe, String.valueOf(dCA.mAnimType), this.mYV, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.dDM() && g.this.mYF != null && g.this.mYV != null) {
                                Object tag = g.this.mYF.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dEl().a(g.this.mYe, String.valueOf(((ChatInfo) tag).mAnimType), g.this.mYV, g.this.mYF);
                                }
                                if (!z) {
                                    g.this.mYF.setVisibility(8);
                                    g.this.mYV.removeView(g.this.mYF);
                                    g.this.mYF = null;
                                    if (g.this.mYf != null) {
                                        g.this.mYf.removeMessages(11);
                                        g.this.mYf.K(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.mYF = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dCA.mJsonData);
                } else if (dCA.mAnimationPluginId == 2) {
                    if (this.mYG == null && this.mYV != null) {
                        this.mYG = (SVGAImageView) this.mYV.findViewById(a.f.svgaView);
                        if (this.mYG == null) {
                            this.mYG = new SVGAImageView(this.mYe);
                            this.mYG.setClearsAfterStop(true);
                            this.mYG.setLoops(1);
                            this.mYG.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.mYV.addView(this.mYG, layoutParams);
                        }
                    }
                    if (this.mYG == null) {
                        cVar.removeMessages(11);
                        cVar.K(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dEl().a(this.mYe, String.valueOf(dCA.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.mYG.stopAnimation();
                            g.this.mYG.clearAnimation();
                            g.this.mYG.setVisibility(8);
                            g.this.mYG = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onFinished() {
                            g.this.mYG.stopAnimation();
                            g.this.mYG.clearAnimation();
                            g.this.mYG.setVisibility(8);
                            g.this.mYG = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Gp() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.mYG, dCA);
                }
                if (this.mYF != null) {
                    this.mYF.setTag(dCA);
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
        if (this.mYH == null) {
            if (this.mYd.mQM != null) {
                int g = this.mYd.mQM.g();
                ChatInfo dCB = this.mYd.mQM.dCB();
                if (dCB == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dCB, g);
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
        if (this.mYH != null || getContext() == null) {
            if (this.mYf != null) {
                this.mYf.removeMessages(12);
                this.mYf.K(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.mYH = this.mXO.findViewById(a.f.rl_show_tip);
            if (this.mYH != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dBL().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYe);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mYH.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.mYe, 5.0f);
                    this.mYH.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.mYH = this.mXO.findViewById(a.f.rl_tip);
        }
        if (this.mYH != null) {
            this.mYH.setVisibility(0);
            this.mYH.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mYd != null) {
                            RoomInfo dCE = g.this.mYd.dCE();
                            if (dCE != null) {
                                str = dCE.mRoomID;
                            }
                            if (dCE != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dCE.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mYe, chatInfo.mItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.mYH.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.mYH.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mYd != null) {
                            RoomInfo dCE = g.this.mYd.dCE();
                            if (dCE != null) {
                                str = dCE.mRoomID;
                            }
                            if (dCE != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dCE.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mYe, chatInfo.mItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.mYe.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mYe, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mYe, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                if (this.mYe.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mYe, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mYe, a.c.black), simpleDraweeSpanTextView)) {
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
            ViewTreeObserver viewTreeObserver = this.mYH.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.mYH != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.mYH.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.mYH.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.mYS == null) {
                                g.this.mYS = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.mYS.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.mYS.removeAllListeners();
                            }
                            g.this.mYS.playTogether(ObjectAnimator.ofFloat(g.this.mYH, "translationX", g.this.mYH.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.mYS.start();
                            if (g.this.mYf != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.mYf.K(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void cXJ() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!dDM() && this.mYH != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.mYH, "translationX", 0.0f, 10.0f, -this.mYH.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.dDM()) {
                        if (g.this.mYH != null) {
                            g.this.mYH.setVisibility(8);
                        }
                        g.this.mYH = null;
                        if (g.this.mYf != null) {
                            g.this.mYf.K(12, 800L);
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
            if (this.mYS == null) {
                this.mYS = new AnimatorSet();
            }
            this.mYS.playTogether(duration);
            this.mYS.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cXK() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.mYe).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.mYI = new EmanateView(this.mYe);
            this.mYI.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.mYI);
            return;
        }
        this.mYI = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.mYJ == null) {
            this.mYJ = (RoomSendGiftView) this.mXO.findViewById(a.f.normalSendGiftView);
            this.mYJ.setContext(this.mYe);
            if (this.mYd != null) {
                this.mYJ.a(this.mYd.dCC());
            }
            this.mYJ.a(z, z2);
            this.mYJ.setVisibilityListener(this.mYT);
            this.mYJ.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.mYI != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable SW = tv.chushou.zues.utils.h.SW(str);
                            if (SW == null) {
                                SW = tv.chushou.zues.utils.h.SY(str);
                            }
                            g.this.mYI.setDrawable(SW, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.mYI.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.mYI.dQE();
                        }
                    }
                }
            });
            this.mYJ.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
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
        if (this.mYJ != null) {
            if (this.mYd != null) {
                this.mYJ.a(z ? this.mYd.mQS : this.mYd.mQT, this.mYd.mQU, this.mYd.mQV, z);
                this.mYJ.setGiftTopIcon(this.mYd.s);
            }
            if (micMemberInfo != null) {
                this.mYJ.setMicMemberInfo(micMemberInfo);
            }
            this.mYJ.c();
        }
    }

    protected void at(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.mYK.setProgress(i);
            if (!this.mYP) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.mYL.setText(this.mYe.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.mYL.setText(this.mYe.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.mYL.setText(this.mYe.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.mYM.bU(str, a.e.pao_circle_default);
            if (this.mYO != i) {
                this.mYM.startAnimation(AnimationUtils.loadAnimation(this.mYe, a.C0690a.pao_beat_anim));
                this.mYO = i;
            }
            if (this.aSx != bangInfo.mLevel) {
                if (this.mYf != null && !this.mYf.Og(17)) {
                    this.mYf.a(this.mYf.Oh(17), 500L);
                }
                this.aSx = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(boolean z) {
        int i;
        if (!this.mYN.b()) {
            WindowManager windowManager = (WindowManager) this.mYe.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                this.mYN.a(this.mYe, i, this.mYd.dCC().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.mYN.e();
        this.mYN.c();
    }

    public void dDP() {
        this.mYM.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.mYM.getWidth() / 2, this.mYM.getHeight() / 2);
        aVar.setDuration(1000L);
        this.mYM.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.mYR == null && this.mYe != null) {
            if ("3".equals(this.aw)) {
                z = h.dBS().b;
            } else if (this.mYd == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dBS().d;
            } else {
                z = h.dBS().e;
            }
            this.mYR = new CSDanmuLayout(this.mYe.getApplicationContext(), new a.C0802a().Od(-16711936).Oc(800).wZ(true).xa(this.ap >= 0).Ob(2).dPB(), h.dBS().b());
            this.mYR.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.mYe);
            Point hd = tv.chushou.zues.utils.a.hd(this.mYe);
            switch (h.dBS().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.mYe.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mYi / 3;
                    } else {
                        layoutParams.height = hd.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.mYe.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mYi / 3;
                    } else {
                        layoutParams.height = hd.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dDN().addView(this.mYR, 1, layoutParams);
            if (this.mYR != null) {
                this.mYR.setVisibility(z ? 0 : 8);
            }
            q(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.mYR != null) {
            this.mYR.setVisibility(8);
            this.mYR.dPC();
        }
        if (this.mYR != null) {
            this.mYR.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void cXs() {
        if (this.mYR != null && this.mYd != null) {
            if (this.ap < 0) {
                this.mYR.setVisibility(h.dBS().d ? 0 : 8);
            } else {
                this.mYR.setVisibility(h.dBS().e ? 0 : 8);
            }
        }
        if (this.mYR != null && this.mYR.isPrepared() && !this.H && !this.al) {
            this.mYR.resume();
            this.mYR.dPC();
        }
    }

    protected void q(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.mZa == null) {
            if (this.mYY == null) {
                this.mYY = new ArrayList();
            }
            this.mYY.clear();
            aO(getString(a.i.danmu_settings_no_gift), false);
            aO(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.mYe).mPl != null) {
                if (this.mYd.dCC() != null) {
                    this.mZc = this.mYd.dCC().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.mZc)) {
                    aO(getString(a.i.danmu_settings_no_normal), true);
                    this.mYY.addAll(this.mZc);
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
            View inflate = LayoutInflater.from(this.mYe).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mYe));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.mZb = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.mYe).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mZb.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mZb.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.mYZ = new com.kascend.chushou.player.adapter.b(i, this.mYe, this.mYY, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.mYZ);
            if (!tv.chushou.zues.utils.h.isEmpty(this.mZc) && this.mZc.size() >= 5) {
                this.mZa = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYe, 165.0f), tv.chushou.zues.utils.a.dip2px(this.mYe, 354.0f));
            } else {
                this.mZa = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYe, 165.0f), -2);
            }
            this.mZa.setFocusable(true);
            this.mZa.setOutsideTouchable(true);
            this.mZa.setBackgroundDrawable(this.mYe.getResources().getDrawable(a.e.bg_room_pop));
            this.mZa.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dDQ() {
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
        if (this.mYY != null) {
            this.mYY.add(privacyItem);
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
        if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "26", "chatType", str2, "chatState", str, "roomId", this.mYd.dCC().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.mYZ.notifyDataSetChanged();
        dDc();
    }

    protected void dDc() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.dQn()) {
            tv.chushou.zues.utils.g.c(this.mYe, this.mYe.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dBO().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.mYZ.notifyDataSetChanged();
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
                        g.this.mYZ.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.mYZ.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.mYY) {
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
                for (PrivacyItem privacyItem3 : this.mYY) {
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
            for (PrivacyItem privacyItem4 : this.mYY) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.mZe == null) {
            this.mZe = new ArrayList<>();
        }
        this.mZe.add(str);
        this.mZe.add(str2);
        p pVar = new p();
        pVar.a = this.mZe;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.mZe == null) {
            this.mZe = new ArrayList<>();
        }
        this.mZe.add(str);
        p pVar = new p();
        pVar.a = this.mZe;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.mZe != null) {
            this.mZe.remove(str);
            this.mZe.remove(str2);
            p pVar = new p();
            pVar.a = this.mZe;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.mZe != null) {
            this.mZe.remove(str);
            p pVar = new p();
            pVar.a = this.mZe;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dCW = dCW();
        if (dCW != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dCW.getLayoutParams();
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
            dCW.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dCW = dCW();
        if (dCW != null) {
            dCW.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dBS().q()) {
                h.dBS().g(false);
                this.mYq.c();
                return;
            }
            h.dBS().g(true);
            this.mYq.b();
        } else if (id == a.f.rl_decode) {
            if (h.dBS().a) {
                h.dBS().a(this.mYe, false);
                this.mYs.c();
            } else {
                h.dBS().a(this.mYe, true);
                this.mYs.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.mYe, ou(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.mYe).q) {
                ((VideoPlayer) this.mYe).q = false;
                if (this.mYd.mQM != null) {
                    this.mYd.mQM.e();
                    this.mYd.mQM.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.mYo.c();
                return;
            }
            ((VideoPlayer) this.mYe).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.mYo.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dBS().o();
            if (this.ap < 0) {
                o = h.dBS().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dBS().b;
            }
            boolean z = !o;
            if (z) {
                this.mYt.b();
            } else {
                this.mYt.c();
            }
            if (!this.aw.equals("1")) {
                h.dBS().a(z);
            } else if (this.ap < 0) {
                h.dBS().e(z);
            } else {
                h.dBS().f(z);
            }
            switch (h.dBS().m()) {
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
            com.kascend.chushou.toolkit.a.c.d(this.mYe, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.mYe).q) {
                ((VideoPlayer) this.mYe).q = false;
                if (this.mYd.mQM != null) {
                    this.mYd.mQM.e();
                    this.mYd.mQM.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mZb.setImageResource(i);
            } else {
                ((VideoPlayer) this.mYe).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mZb.setImageResource(i2);
            }
            dDc();
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
        if (aVar != null && this.mYU != null) {
            this.mYU.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dDm() {
        return null;
    }

    public GiftAnimationLayout dCW() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dDB() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dCE;
        if (this.mYd != null && (dCE = this.mYd.dCE()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dCE.mOnlineCount.equals(str2) || !dCE.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dCE.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dCE.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dDB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dBS().c(true);
        if (this.mYW == null) {
            a();
        }
        if (!this.mYW.isShowing()) {
            if (view != null) {
                this.mYW.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.mYe, 3.0f), (this.mXO.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.mYe, 8.0f));
                RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.mYW != null) {
                            g.this.mYW.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.mYW.dismiss();
    }

    private void a() {
        if (this.mYW == null) {
            View inflate = LayoutInflater.from(this.mYe).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.mYe.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.mYe.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.mYW = new PopupWindow(inflate, -2, -2);
            this.mYW.setFocusable(true);
            this.mYW.setOutsideTouchable(true);
            this.mYW.setAnimationStyle(a.j.gift_toast_style);
            this.mYW.update();
            this.mYW.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.mYW = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
