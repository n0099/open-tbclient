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
    protected ArrayList<a> naA;
    protected PopupWindow naB;
    protected View naD;
    protected SVGAImageView naE;
    protected View naF;
    protected EmanateView naG;
    protected RoomSendGiftView naH;
    protected RoundProgressBar naI;
    protected TextView naJ;
    protected FrescoThumbnailView naK;
    protected PaoGuideView naL;
    protected AnimatorSet naQ;
    protected KasBaseMenuView.a naR;
    protected H5Container naS;
    protected RelativeLayout naT;
    protected PopupWindow naU;
    protected PopupWindow naV;
    protected List<PrivacyItem> naW;
    protected com.kascend.chushou.player.adapter.b naX;
    protected PopupWindow naY;
    protected ImageView naZ;
    protected RelativeLayout nak;
    protected RelativeLayout nal;
    protected OnlineToggleButton nam;
    protected RelativeLayout nan;
    protected OnlineToggleButton nao;
    protected RelativeLayout nap;
    protected OnlineToggleButton naq;
    protected OnlineToggleButton nar;
    protected LinearLayout nas;
    protected PopupWindow nat;
    protected PopupWindow nau;
    protected PopupWindow nav;
    protected RecyclerView naw;
    protected LinearLayoutManager nax;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> nay;
    protected ArrayList<a> naz;
    protected List<PrivacyItem> nba;
    protected FrescoThumbnailView nbb;
    protected ArrayList<String> nbc;
    protected boolean naC = false;
    protected int aSM = 0;
    protected long naM = 0;
    protected boolean naN = false;
    protected IconConfig.Config naO = new IconConfig.Config();
    protected CSDanmuLayout naP = null;
    protected boolean bi = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.dEp() && g.this.naw != null && g.this.nay != null && g.this.nax != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.nax.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.nax.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.nax.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.nax.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.nax.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.naw.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.nac != null) {
                                    g.this.nac.removeCallbacks(g.this.d);
                                    if (g.this.b) {
                                        g.this.nac.d(g.this.d, 1000L);
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
    public RelativeLayout dEq() {
        if (this.nak == null) {
            this.nak = (RelativeLayout) this.mZL.findViewById(a.f.video_root_view);
        }
        return this.nak;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(View view, int i, int i2) {
        if (!this.bi) {
            ag();
        }
        ah();
        if (this.nat != null) {
            if (!this.nat.isShowing()) {
                this.nat.showAtLocation(view, 53, i, i2);
            } else {
                this.nat.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point hc = tv.chushou.zues.utils.a.hc(this.nab);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dCs().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dCs().b(1);
                layoutParams.width = -1;
                if (this.nab.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.naf / 3;
                } else {
                    layoutParams.height = hc.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dCs().b(2);
                layoutParams.width = -1;
                if (this.nab.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.naf / 3;
                } else {
                    layoutParams.height = hc.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.naP != null) {
            this.naP.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(View view, int i, int i2) {
        ae();
        if (this.nau != null) {
            if (!this.nau.isShowing()) {
                if (this.nab.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.nau.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.nau.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.nau.showAtLocation(view, 53, i, i2);
                return;
            }
            this.nau.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.nab.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.nab).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.nar = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dCs().b) {
                this.nar.b();
            } else {
                this.nar.c();
            }
        } else if (this.ap < 0) {
            if (h.dCs().n()) {
                this.nar.b();
            } else {
                this.nar.c();
            }
        } else if (h.dCs().o()) {
            this.nar.b();
        } else {
            this.nar.c();
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
        switch (h.dCs().m()) {
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
        if (this.nab.getResources().getConfiguration().orientation == 1) {
            this.nau = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nab, 230.0f), -2);
            this.nau.setBackgroundDrawable(this.nab.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.nau = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nab, 295.0f), -1);
            this.nau.setClippingEnabled(false);
            this.nau.setBackgroundDrawable(this.nab.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.nau.setFocusable(true);
        this.nau.setOutsideTouchable(true);
        this.nau.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dCs().a(true);
        } else if (this.ap < 0) {
            h.dCs().e(true);
        } else {
            h.dCs().f(true);
        }
        switch (h.dCs().m()) {
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
            if (this.nab.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.nab).inflate(i2, (ViewGroup) null);
            this.nas = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.nal = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.nam = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.nan = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.nao = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.nap = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.naq = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.nab.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nab);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.S(10.0f);
                }
                this.nas.setPadding(this.nas.getPaddingLeft(), statusBarHeight, this.nas.getPaddingRight(), this.nas.getPaddingBottom());
            }
            this.nal.setOnClickListener(this);
            this.nan.setOnClickListener(this);
            this.nap.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.nal.setVisibility(8);
            } else {
                this.nal.setVisibility(0);
            }
            if (((VideoPlayer) this.nab).q) {
                this.nam.b();
            } else {
                this.nam.c();
            }
            if (h.dCs().q()) {
                this.nao.b();
            } else {
                this.nao.c();
            }
            if (com.kascend.chushou.c.a) {
                this.nap.setVisibility(0);
            } else {
                this.nap.setVisibility(8);
            }
            if (h.dCs().a) {
                this.naq.b();
            } else {
                this.naq.c();
            }
            if (this.naa != null && (arrayList = this.naa.f) != null && arrayList.size() > 0) {
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
                            if (this.nab.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.nab).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dDe = this.naa.dDe();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nab).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.nab.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.nab).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nab, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nab, 6.0f);
                                    }
                                    int identifier = this.nab.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nab.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nas, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dDe != null && dDe.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.nas.addView(inflate2);
                            this.bi = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.nab.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.nab).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dDe2 = this.naa.dDe();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nab).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.nab.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.nab).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nab, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nab, 6.0f);
                                    }
                                    int identifier2 = this.nab.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nab.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.nas, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dDe2 != null && dDe2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.nas.addView(inflate3);
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
            if (this.nab.getResources().getConfiguration().orientation == 1) {
                this.nat = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nab, 230.0f), -2);
                this.nat.setBackgroundDrawable(this.nab.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.nat = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nab, 295.0f), -1);
                this.nat.setClippingEnabled(false);
                this.nat.setBackgroundDrawable(this.nab.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.nat.setFocusable(true);
            this.nat.setOutsideTouchable(true);
            this.nat.update();
        }
    }

    protected void ah() {
        if (this.nan != null && this.nao != null) {
            this.nan.setVisibility(0);
            if (h.dCs().q()) {
                this.nao.b();
            } else {
                this.nao.c();
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
        com.kascend.chushou.toolkit.a.c.a(this.nab, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.naa.f;
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
            if (this.nas == null) {
                this.naa.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.naa.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.nab).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nas.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nas.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nab.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nab.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nas, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.nab, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.naa.f;
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
            if (this.nas == null) {
                if (!z) {
                    this.naa.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.naa.a(playUrl);
                if (this.ap >= 0) {
                    this.naa.a(false);
                    if (this.nab != null) {
                        ((VideoPlayer) this.nab).a(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.nab).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.nas.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.nas.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.nab.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.nab.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.nas, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.nat != null) {
            this.nat.dismiss();
        }
        if (this.nav != null) {
            this.nav.dismiss();
        }
        PlayUrl dDe = this.naa.dDe();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.naa.d) {
                this.naa.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.naa.a(playUrl);
                this.naa.a(false);
                if (this.nab != null) {
                    ((VideoPlayer) this.nab).a(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.naa.d) {
            this.naa.e = true;
        }
        h.dCs().a(this.nab, urlDetails.mDefinitionType);
        if (z || (dDe != null && !dDe.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.f(this.nab, dEo(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.naa.a(playUrl);
            if (dEo()) {
                if (((VideoPlayer) this.nab) != null) {
                    ((VideoPlayer) this.nab).r = -1L;
                }
                if (this.mWp != null) {
                    this.kXT = this.mWp.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.nab).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.nah = str2;
        if (this.nac != null) {
            this.nac.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.naC = true;
            if (this.naA == null) {
                this.naA = new ArrayList<>();
            }
            this.naA.clear();
            this.naA.addAll(list);
            this.naB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.naB == null) {
            View inflate = LayoutInflater.from(this.nab).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.nab.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.nab.getResources().getColor(a.c.player_bg_color));
            }
            if (this.naC && !tv.chushou.zues.utils.h.isEmpty(this.naA)) {
                this.naz = this.naA;
            } else {
                this.naz = (ArrayList) h.dCs().dCu();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.naz)) {
                String[] stringArray = this.nab.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.nab.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.naz == null) {
                    this.naz = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.naz.add(aVar);
                }
            }
            this.naw = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.nay = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.naz, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void onItemClick(View view, int i4) {
                    a aVar2;
                    if (g.this.naB != null) {
                        g.this.naB.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.naz) && i4 < g.this.naz.size() && (aVar2 = g.this.naz.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.naC) {
                            g.this.naz.remove(i4);
                            g.this.naz.add(0, aVar2);
                            g.this.nay.notifyDataSetChanged();
                            g.this.naw.scrollToPosition(0);
                            RxExecutor.post(g.this.mZK, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dCs().a((Object) g.this.naz);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.nab, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.naa != null && g.this.naa.dDd() != null && g.this.naa.dDd().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.naa.dDd().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0814a view$OnLongClickListenerC0814a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0814a.a(a.f.tv_name, g.this.nab.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0814a.a(a.f.tv_name, g.this.nab.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0814a.a(a.f.tv_name, g.this.nab.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0814a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.nax = new LinearLayoutManager(this.nab);
            this.naw.setLayoutManager(this.nax);
            this.naw.setAdapter(this.nay);
            this.naw.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.naB = new PopupWindow(inflate, this.nab.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.nab.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.naB.setFocusable(true);
            this.naB.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.naB.setBackgroundDrawable(this.nab.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.naB.setBackgroundDrawable(this.nab.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.naB.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.nac.removeCallbacks(this.d);
        this.nac.m(this.d);
    }

    protected void an() {
        this.b = true;
        this.nac.removeCallbacks(this.d);
        this.nac.d(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.nac != null) {
            this.nac.removeCallbacks(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bF(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.naa != null) {
                RoomInfo dDf = this.naa.dDf();
                if (dDf != null) {
                    str = dDf.mRoomID;
                }
                if (dDf != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dDf.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.nab, listItem, com.kascend.chushou.d.e.N("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.mZL != null) {
            Point hc = tv.chushou.zues.utils.a.hc(this.nab);
            int i = hc.x > hc.y ? 1 : 2;
            if (this.naS == null) {
                this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.naS.setPlayerViewHelper(this.naa);
            this.naS.setVisibility(0);
            this.naS.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dEr() {
        HashMap e;
        if (this.naa != null && (e = this.naa.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.naS != null) {
            this.naS.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.naD == null && this.naE == null) {
            if (this.naa.mSJ != null) {
                ChatInfo dDb = this.naa.mSJ.dDb();
                if (dDb == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.naT == null) {
                    this.naT = (RelativeLayout) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dDb.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dDb.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dDb.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dDb.mAnimSubType > 0) {
                    dDb.mAnimType = dDb.mAnimSubType;
                }
                if (dDb.mAnimationPluginId == 1) {
                    this.naD = com.kascend.chushou.toolkit.d.a.dEO().a(this.nab, String.valueOf(dDb.mAnimType), this.naT, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.dEp() && g.this.naD != null && g.this.naT != null) {
                                Object tag = g.this.naD.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dEO().a(g.this.nab, String.valueOf(((ChatInfo) tag).mAnimType), g.this.naT, g.this.naD);
                                }
                                if (!z) {
                                    g.this.naD.setVisibility(8);
                                    g.this.naT.removeView(g.this.naD);
                                    g.this.naD = null;
                                    if (g.this.nac != null) {
                                        g.this.nac.removeMessages(11);
                                        g.this.nac.K(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.naD = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dDb.mJsonData);
                } else if (dDb.mAnimationPluginId == 2) {
                    if (this.naE == null && this.naT != null) {
                        this.naE = (SVGAImageView) this.naT.findViewById(a.f.svgaView);
                        if (this.naE == null) {
                            this.naE = new SVGAImageView(this.nab);
                            this.naE.setClearsAfterStop(true);
                            this.naE.setLoops(1);
                            this.naE.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.naT.addView(this.naE, layoutParams);
                        }
                    }
                    if (this.naE == null) {
                        cVar.removeMessages(11);
                        cVar.K(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dEO().a(this.nab, String.valueOf(dDb.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.naE.stopAnimation();
                            g.this.naE.clearAnimation();
                            g.this.naE.setVisibility(8);
                            g.this.naE = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onFinished() {
                            g.this.naE.stopAnimation();
                            g.this.naE.clearAnimation();
                            g.this.naE.setVisibility(8);
                            g.this.naE = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Gw() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.naE, dDb);
                }
                if (this.naD != null) {
                    this.naD.setTag(dDb);
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
        if (this.naF == null) {
            if (this.naa.mSJ != null) {
                int g = this.naa.mSJ.g();
                ChatInfo dDc = this.naa.mSJ.dDc();
                if (dDc == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dDc, g);
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
        if (this.naF != null || getContext() == null) {
            if (this.nac != null) {
                this.nac.removeMessages(12);
                this.nac.K(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.naF = this.mZL.findViewById(a.f.rl_show_tip);
            if (this.naF != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dCl().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nab);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.naF.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.nab, 5.0f);
                    this.naF.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.naF = this.mZL.findViewById(a.f.rl_tip);
        }
        if (this.naF != null) {
            this.naF.setVisibility(0);
            this.naF.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.naa != null) {
                            RoomInfo dDf = g.this.naa.dDf();
                            if (dDf != null) {
                                str = dDf.mRoomID;
                            }
                            if (dDf != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dDf.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nab, chatInfo.mItem, com.kascend.chushou.d.e.N("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.naF.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.naF.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.naa != null) {
                            RoomInfo dDf = g.this.naa.dDf();
                            if (dDf != null) {
                                str = dDf.mRoomID;
                            }
                            if (dDf != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dDf.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.nab, chatInfo.mItem, com.kascend.chushou.d.e.N("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.nab.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nab, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nab, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0691a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.hc(getContext()).x;
                if (this.nab.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.nab, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.nab, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0691a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.naF.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.naF != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.naF.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.naF.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.naQ == null) {
                                g.this.naQ = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.naQ.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.naQ.removeAllListeners();
                            }
                            g.this.naQ.playTogether(ObjectAnimator.ofFloat(g.this.naF, "translationX", g.this.naF.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.naQ.start();
                            if (g.this.nac != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.nac.K(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void cYj() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!dEp() && this.naF != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.naF, "translationX", 0.0f, 10.0f, -this.naF.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.dEp()) {
                        if (g.this.naF != null) {
                            g.this.naF.setVisibility(8);
                        }
                        g.this.naF = null;
                        if (g.this.nac != null) {
                            g.this.nac.K(12, 800L);
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
            if (this.naQ == null) {
                this.naQ = new AnimatorSet();
            }
            this.naQ.playTogether(duration);
            this.naQ.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cYk() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.nab).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.naG = new EmanateView(this.nab);
            this.naG.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.naG);
            return;
        }
        this.naG = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.naH == null) {
            this.naH = (RoomSendGiftView) this.mZL.findViewById(a.f.normalSendGiftView);
            this.naH.setContext(this.nab);
            if (this.naa != null) {
                this.naH.a(this.naa.dDd());
            }
            this.naH.a(z, z2);
            this.naH.setVisibilityListener(this.naR);
            this.naH.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.naG != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable SX = tv.chushou.zues.utils.h.SX(str);
                            if (SX == null) {
                                SX = tv.chushou.zues.utils.h.SZ(str);
                            }
                            g.this.naG.setDrawable(SX, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.naG.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.naG.dRh();
                        }
                    }
                }
            });
            this.naH.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
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
        if (this.naH != null) {
            if (this.naa != null) {
                this.naH.a(z ? this.naa.mSQ : this.naa.mSR, this.naa.mSS, this.naa.mST, z);
                this.naH.setGiftTopIcon(this.naa.s);
            }
            if (micMemberInfo != null) {
                this.naH.setMicMemberInfo(micMemberInfo);
            }
            this.naH.c();
        }
    }

    protected void at(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.naI.setProgress(i);
            if (!this.naN) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.naJ.setText(this.nab.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.naJ.setText(this.nab.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.naJ.setText(this.nab.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.naK.bU(str, a.e.pao_circle_default);
            if (this.naM != i) {
                this.naK.startAnimation(AnimationUtils.loadAnimation(this.nab, a.C0691a.pao_beat_anim));
                this.naM = i;
            }
            if (this.aSM != bangInfo.mLevel) {
                if (this.nac != null && !this.nac.Om(17)) {
                    this.nac.a(this.nac.On(17), 500L);
                }
                this.aSM = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.naL.b()) {
            WindowManager windowManager = (WindowManager) this.nab.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                this.naL.a(this.nab, i, this.naa.dDd().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.naL.e();
        this.naL.c();
    }

    public void dEs() {
        this.naK.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.naK.getWidth() / 2, this.naK.getHeight() / 2);
        aVar.setDuration(1000L);
        this.naK.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.naP == null && this.nab != null) {
            if ("3".equals(this.aw)) {
                z = h.dCs().b;
            } else if (this.naa == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dCs().d;
            } else {
                z = h.dCs().e;
            }
            this.naP = new CSDanmuLayout(this.nab.getApplicationContext(), new a.C0803a().Oj(-16711936).Oi(800).xh(true).xi(this.ap >= 0).Oh(2).dQe(), h.dCs().b());
            this.naP.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.nab);
            Point hc = tv.chushou.zues.utils.a.hc(this.nab);
            switch (h.dCs().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.nab.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.naf / 3;
                    } else {
                        layoutParams.height = hc.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.nab.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.naf / 3;
                    } else {
                        layoutParams.height = hc.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dEq().addView(this.naP, 1, layoutParams);
            if (this.naP != null) {
                this.naP.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.naP != null) {
            this.naP.setVisibility(8);
            this.naP.dQf();
        }
        if (this.naP != null) {
            this.naP.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void cXT() {
        if (this.naP != null && this.naa != null) {
            if (this.ap < 0) {
                this.naP.setVisibility(h.dCs().d ? 0 : 8);
            } else {
                this.naP.setVisibility(h.dCs().e ? 0 : 8);
            }
        }
        if (this.naP != null && this.naP.isPrepared() && !this.H && !this.al) {
            this.naP.resume();
            this.naP.dQf();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.naY == null) {
            if (this.naW == null) {
                this.naW = new ArrayList();
            }
            this.naW.clear();
            aO(getString(a.i.danmu_settings_no_gift), false);
            aO(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.nab).mRh != null) {
                if (this.naa.dDd() != null) {
                    this.nba = this.naa.dDd().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.nba)) {
                    aO(getString(a.i.danmu_settings_no_normal), true);
                    this.naW.addAll(this.nba);
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
            View inflate = LayoutInflater.from(this.nab).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.nab));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.naZ = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.nab).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.naZ.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.naZ.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.naX = new com.kascend.chushou.player.adapter.b(i, this.nab, this.naW, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.naX);
            if (!tv.chushou.zues.utils.h.isEmpty(this.nba) && this.nba.size() >= 5) {
                this.naY = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nab, 165.0f), tv.chushou.zues.utils.a.dip2px(this.nab, 354.0f));
            } else {
                this.naY = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nab, 165.0f), -2);
            }
            this.naY.setFocusable(true);
            this.naY.setOutsideTouchable(true);
            this.naY.setBackgroundDrawable(this.nab.getResources().getDrawable(a.e.bg_room_pop));
            this.naY.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dEt() {
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
        if (this.naW != null) {
            this.naW.add(privacyItem);
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
        if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "26", "chatType", str2, "chatState", str, "roomId", this.naa.dDd().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.naX.notifyDataSetChanged();
        dDD();
    }

    protected void dDD() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.dQQ()) {
            tv.chushou.zues.utils.g.c(this.nab, this.nab.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dCo().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.naX.notifyDataSetChanged();
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
                        g.this.naX.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.naX.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.naW) {
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
                for (PrivacyItem privacyItem3 : this.naW) {
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
            for (PrivacyItem privacyItem4 : this.naW) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.nbc == null) {
            this.nbc = new ArrayList<>();
        }
        this.nbc.add(str);
        this.nbc.add(str2);
        p pVar = new p();
        pVar.a = this.nbc;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.nbc == null) {
            this.nbc = new ArrayList<>();
        }
        this.nbc.add(str);
        p pVar = new p();
        pVar.a = this.nbc;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.nbc != null) {
            this.nbc.remove(str);
            this.nbc.remove(str2);
            p pVar = new p();
            pVar.a = this.nbc;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.nbc != null) {
            this.nbc.remove(str);
            p pVar = new p();
            pVar.a = this.nbc;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dDx = dDx();
        if (dDx != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dDx.getLayoutParams();
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
            dDx.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dDx = dDx();
        if (dDx != null) {
            dDx.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dCs().q()) {
                h.dCs().g(false);
                this.nao.c();
                return;
            }
            h.dCs().g(true);
            this.nao.b();
        } else if (id == a.f.rl_decode) {
            if (h.dCs().a) {
                h.dCs().a(this.nab, false);
                this.naq.c();
            } else {
                h.dCs().a(this.nab, true);
                this.naq.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.nab, dEo(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.nab).q) {
                ((VideoPlayer) this.nab).q = false;
                if (this.naa.mSJ != null) {
                    this.naa.mSJ.e();
                    this.naa.mSJ.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.nam.c();
                return;
            }
            ((VideoPlayer) this.nab).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.nam.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dCs().o();
            if (this.ap < 0) {
                o = h.dCs().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dCs().b;
            }
            boolean z = !o;
            if (z) {
                this.nar.b();
            } else {
                this.nar.c();
            }
            if (!this.aw.equals("1")) {
                h.dCs().a(z);
            } else if (this.ap < 0) {
                h.dCs().e(z);
            } else {
                h.dCs().f(z);
            }
            switch (h.dCs().m()) {
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
            com.kascend.chushou.toolkit.a.c.d(this.nab, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.nab).q) {
                ((VideoPlayer) this.nab).q = false;
                if (this.naa.mSJ != null) {
                    this.naa.mSJ.e();
                    this.naa.mSJ.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.naZ.setImageResource(i);
            } else {
                ((VideoPlayer) this.nab).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.naZ.setImageResource(i2);
            }
            dDD();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.naS != null) {
            this.naS.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0706a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dDO() {
        return null;
    }

    public GiftAnimationLayout dDx() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dEd() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dDf;
        if (this.naa != null && (dDf = this.naa.dDf()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dDf.mOnlineCount.equals(str2) || !dDf.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dDf.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dDf.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dEd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dCs().c(true);
        if (this.naU == null) {
            a();
        }
        if (!this.naU.isShowing()) {
            if (view != null) {
                this.naU.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.nab, 3.0f), (this.mZL.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.nab, 8.0f));
                RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.naU != null) {
                            g.this.naU.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.naU.dismiss();
    }

    private void a() {
        if (this.naU == null) {
            View inflate = LayoutInflater.from(this.nab).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.nab.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.nab.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.naU = new PopupWindow(inflate, -2, -2);
            this.naU.setFocusable(true);
            this.naU.setOutsideTouchable(true);
            this.naU.setAnimationStyle(a.j.gift_toast_style);
            this.naU.update();
            this.naU.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.naU = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
