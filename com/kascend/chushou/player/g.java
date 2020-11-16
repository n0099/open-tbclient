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
    protected OnlineToggleButton psA;
    protected OnlineToggleButton psB;
    protected LinearLayout psC;
    protected PopupWindow psD;
    protected PopupWindow psE;
    protected PopupWindow psF;
    protected RecyclerView psG;
    protected LinearLayoutManager psH;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> psI;
    protected ArrayList<a> psJ;
    protected ArrayList<a> psK;
    protected PopupWindow psL;
    protected View psM;
    protected SVGAImageView psN;
    protected View psO;
    protected EmanateView psP;
    protected RoomSendGiftView psQ;
    protected RoundProgressBar psR;
    protected TextView psS;
    protected FrescoThumbnailView psT;
    protected PaoGuideView psU;
    protected AnimatorSet psZ;
    protected RelativeLayout psu;
    protected RelativeLayout psv;
    protected OnlineToggleButton psw;
    protected RelativeLayout psx;
    protected OnlineToggleButton psy;
    protected RelativeLayout psz;
    protected KasBaseMenuView.a pta;
    protected H5Container ptc;
    protected RelativeLayout ptd;
    protected PopupWindow pte;
    protected PopupWindow ptf;
    protected List<PrivacyItem> ptg;
    protected com.kascend.chushou.player.adapter.b pth;
    protected PopupWindow pti;
    protected ImageView ptj;
    protected List<PrivacyItem> ptk;
    protected FrescoThumbnailView ptl;
    protected ArrayList<String> ptm;
    protected boolean aR = false;
    protected int bb = 0;
    protected long psV = 0;
    protected boolean psW = false;
    protected IconConfig.Config psX = new IconConfig.Config();
    protected CSDanmuLayout psY = null;
    protected boolean ptb = false;

    /* renamed from: a  reason: collision with root package name */
    private double f4137a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.aa() && g.this.psG != null && g.this.psI != null && g.this.psH != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.psH.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.psH.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.psH.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.psH.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.psH.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.psG.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.psm != null) {
                                    g.this.psm.N(g.this.d);
                                    if (g.this.b) {
                                        g.this.psm.f(g.this.d, 1000L);
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
    public RelativeLayout evH() {
        if (this.psu == null) {
            this.psu = (RelativeLayout) this.prW.findViewById(a.f.video_root_view);
        }
        return this.psu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(View view, int i, int i2) {
        if (!this.ptb) {
            vB();
        }
        vC();
        if (this.psD != null) {
            if (!this.psD.isShowing()) {
                this.psD.showAtLocation(view, 53, i, i2);
            } else {
                this.psD.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point hB = tv.chushou.zues.utils.a.hB(this.psl);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.etY().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.etY().b(1);
                layoutParams.width = -1;
                if (this.psl.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = hB.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.etY().b(2);
                layoutParams.width = -1;
                if (this.psl.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = hB.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.psY != null) {
            this.psY.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(View view, int i, int i2) {
        edK();
        if (this.psE != null) {
            if (!this.psE.isShowing()) {
                if (this.psl.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.psE.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.psE.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.psE.showAtLocation(view, 53, i, i2);
                return;
            }
            this.psE.dismiss();
        }
    }

    protected void edK() {
        int i = a.h.pop_danmu_full_setting;
        if (this.psl.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.psl).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.psB = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.psr.equals("1")) {
            if (h.etY().b) {
                this.psB.b();
            } else {
                this.psB.c();
            }
        } else if (this.ap < 0) {
            if (h.etY().n()) {
                this.psB.b();
            } else {
                this.psB.c();
            }
        } else if (h.etY().o()) {
            this.psB.b();
        } else {
            this.psB.c();
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
        switch (h.etY().m()) {
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
        if (this.psl.getResources().getConfiguration().orientation == 1) {
            this.psE = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.psl, 230.0f), -2);
            this.psE.setBackgroundDrawable(this.psl.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.psE = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.psl, 295.0f), -1);
            this.psE.setClippingEnabled(false);
            this.psE.setBackgroundDrawable(this.psl.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.psE.setFocusable(true);
        this.psE.setOutsideTouchable(true);
        this.psE.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vA() {
        if (!this.psr.equals("1")) {
            h.etY().a(true);
        } else if (this.ap < 0) {
            h.etY().e(true);
        } else {
            h.etY().f(true);
        }
        switch (h.etY().m()) {
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

    protected void vB() {
        ArrayList<PlayUrl> arrayList;
        int i;
        if (!this.ptb) {
            int i2 = a.h.pop_full_play_setting;
            if (this.psl.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.psl).inflate(i2, (ViewGroup) null);
            this.psC = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.psv = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.psw = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.psx = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.psy = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.psz = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.psA = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.psl.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.psl);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.M(10.0f);
                }
                this.psC.setPadding(this.psC.getPaddingLeft(), statusBarHeight, this.psC.getPaddingRight(), this.psC.getPaddingBottom());
            }
            this.psv.setOnClickListener(this);
            this.psx.setOnClickListener(this);
            this.psz.setOnClickListener(this);
            if (!this.psr.equals("1") || this.ap < 0) {
                this.psv.setVisibility(8);
            } else {
                this.psv.setVisibility(0);
            }
            if (((VideoPlayer) this.psl).q) {
                this.psw.b();
            } else {
                this.psw.c();
            }
            if (h.etY().q()) {
                this.psy.b();
            } else {
                this.psy.c();
            }
            if (com.kascend.chushou.c.f4079a) {
                this.psz.setVisibility(0);
            } else {
                this.psz.setVisibility(8);
            }
            if (h.etY().f4087a) {
                this.psA.b();
            } else {
                this.psA.c();
            }
            if (this.psk != null && (arrayList = this.psk.f) != null && arrayList.size() > 0) {
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
                            if (this.psl.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.psl).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl euK = this.psk.euK();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.psl).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.psl.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.psl).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.psl, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.psl, 6.0f);
                                    }
                                    int identifier = this.psl.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.psl.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.psC, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (euK != null && euK.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.psC.addView(inflate2);
                            this.ptb = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.psl.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.psl).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl euK2 = this.psk.euK();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.psl).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.psl.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.psl).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.psl, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.psl, 6.0f);
                                    }
                                    int identifier2 = this.psl.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.psl.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.psC, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (euK2 != null && euK2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.psC.addView(inflate3);
                            this.ptb = true;
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
            if (this.psl.getResources().getConfiguration().orientation == 1) {
                this.psD = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.psl, 230.0f), -2);
                this.psD.setBackgroundDrawable(this.psl.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.psD = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.psl, 295.0f), -1);
                this.psD.setClippingEnabled(false);
                this.psD.setBackgroundDrawable(this.psl.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.psD.setFocusable(true);
            this.psD.setOutsideTouchable(true);
            this.psD.update();
        }
    }

    protected void vC() {
        if (this.psx != null && this.psy != null) {
            this.psx.setVisibility(0);
            if (h.etY().q()) {
                this.psy.b();
            } else {
                this.psy.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void edN() {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = null;
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() != -1) {
            com.kascend.chushou.d.e.a(0);
        }
        com.kascend.chushou.toolkit.a.c.a(this.psl, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.psk.f;
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
            if (this.psC == null) {
                this.psk.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.psk.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.psl).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.psC.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.psC.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.psl.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.psl.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.psC, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.psl, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.psk.f;
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
            if (this.psC == null) {
                if (!z) {
                    this.psk.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.psk.a(playUrl);
                if (this.ap >= 0) {
                    this.psk.a(false);
                    if (this.psl != null) {
                        ((VideoPlayer) this.psl).b(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.psl).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.psC.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.psC.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.psl.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.psl.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.psC, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.psD != null) {
            this.psD.dismiss();
        }
        if (this.psF != null) {
            this.psF.dismiss();
        }
        PlayUrl euK = this.psk.euK();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.psk.d) {
                this.psk.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.psk.a(playUrl);
                this.psk.a(false);
                if (this.psl != null) {
                    ((VideoPlayer) this.psl).b(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.psk.d) {
            this.psk.e = true;
        }
        h.etY().a(this.psl, urlDetails.mDefinitionType);
        if (z || (euK != null && !euK.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.psl, evG(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.psk.a(playUrl);
            if (evG()) {
                if (((VideoPlayer) this.psl) != null) {
                    ((VideoPlayer) this.psl).r = -1L;
                }
                if (this.poC != null) {
                    this.osZ = this.poC.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.psl).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.psq = str2;
        if (this.psm != null) {
            this.psm.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void evj() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.aR = true;
            if (this.psK == null) {
                this.psK = new ArrayList<>();
            }
            this.psK.clear();
            this.psK.addAll(list);
            this.psL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.psL == null) {
            View inflate = LayoutInflater.from(this.psl).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.psl.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.psl.getResources().getColor(a.c.player_bg_color));
            }
            if (this.aR && !tv.chushou.zues.utils.h.isEmpty(this.psK)) {
                this.psJ = this.psK;
            } else {
                this.psJ = (ArrayList) h.etY().eua();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.psJ)) {
                String[] stringArray = this.psl.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.psl.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.psJ == null) {
                    this.psJ = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.psJ.add(aVar);
                }
            }
            this.psG = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.psI = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.psJ, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void K(View view, int i4) {
                    a aVar2;
                    if (g.this.psL != null) {
                        g.this.psL.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.psJ) && i4 < g.this.psJ.size() && (aVar2 = g.this.psJ.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.aR) {
                            g.this.psJ.remove(i4);
                            g.this.psJ.add(0, aVar2);
                            g.this.psI.notifyDataSetChanged();
                            g.this.psG.scrollToPosition(0);
                            RxExecutor.post(g.this.prV, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.etY().a((Object) g.this.psJ);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.psl, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.psk != null && g.this.psk.euJ() != null && g.this.psk.euJ().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.psk.euJ().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC1124a view$OnLongClickListenerC1124a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC1124a.a(a.f.tv_name, g.this.psl.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC1124a.a(a.f.tv_name, g.this.psl.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC1124a.a(a.f.tv_name, g.this.psl.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC1124a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.psH = new LinearLayoutManager(this.psl);
            this.psG.setLayoutManager(this.psH);
            this.psG.setAdapter(this.psI);
            this.psG.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                    if (g.this.ap < 0) {
                        if (i4 == 0) {
                            g.this.evI();
                        } else {
                            g.this.ao();
                        }
                    }
                    super.onScrollStateChanged(recyclerView, i4);
                }
            });
            this.psL = new PopupWindow(inflate, this.psl.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.psl.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.psL.setFocusable(true);
            this.psL.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.psL.setBackgroundDrawable(this.psl.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.psL.setBackgroundDrawable(this.psl.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.psL.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.psm.N(this.d);
        this.psm.o(this.d);
    }

    protected void evI() {
        this.b = true;
        this.psm.N(this.d);
        this.psm.f(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.psm != null) {
            this.psm.N(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bG(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.psk != null) {
                RoomInfo euL = this.psk.euL();
                if (euL != null) {
                    str = euL.mRoomID;
                }
                if (euL != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(euL.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.psl, listItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.prW != null) {
            Point hB = tv.chushou.zues.utils.a.hB(this.psl);
            int i = hB.x > hB.y ? 1 : 2;
            if (this.ptc == null) {
                this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.ptc.setPlayerViewHelper(this.psk);
            this.ptc.setVisibility(0);
            this.ptc.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.psk != null && (e = this.psk.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.ptc != null) {
            this.ptc.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.psM == null && this.psN == null) {
            if (this.psk.ple != null) {
                ChatInfo euH = this.psk.ple.euH();
                if (euH == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.ptd == null) {
                    this.ptd = (RelativeLayout) ((ViewStub) this.prW.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (euH.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(euH.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        euH.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (euH.mAnimSubType > 0) {
                    euH.mAnimType = euH.mAnimSubType;
                }
                if (euH.mAnimationPluginId == 1) {
                    this.psM = com.kascend.chushou.toolkit.d.a.ewg().a(this.psl, String.valueOf(euH.mAnimType), this.ptd, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.aa() && g.this.psM != null && g.this.ptd != null) {
                                Object tag = g.this.psM.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.ewg().a(g.this.psl, String.valueOf(((ChatInfo) tag).mAnimType), g.this.ptd, g.this.psM);
                                }
                                if (!z) {
                                    g.this.psM.setVisibility(8);
                                    g.this.ptd.removeView(g.this.psM);
                                    g.this.psM = null;
                                    if (g.this.psm != null) {
                                        g.this.psm.removeMessages(11);
                                        g.this.psm.D(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.psM = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, euH.mJsonData);
                } else if (euH.mAnimationPluginId == 2) {
                    if (this.psN == null && this.ptd != null) {
                        this.psN = (SVGAImageView) this.ptd.findViewById(a.f.svgaView);
                        if (this.psN == null) {
                            this.psN = new SVGAImageView(this.psl);
                            this.psN.setClearsAfterStop(true);
                            this.psN.setLoops(1);
                            this.psN.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.ptd.addView(this.psN, layoutParams);
                        }
                    }
                    if (this.psN == null) {
                        cVar.removeMessages(11);
                        cVar.D(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.ewg().a(this.psl, String.valueOf(euH.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.psN.stopAnimation();
                            g.this.psN.clearAnimation();
                            g.this.psN.setVisibility(8);
                            g.this.psN = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void aeS() {
                            g.this.psN.stopAnimation();
                            g.this.psN.clearAnimation();
                            g.this.psN.setVisibility(8);
                            g.this.psN = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void aeT() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.psN, euH);
                }
                if (this.psM != null) {
                    this.psM.setTag(euH);
                    return;
                }
                return;
            }
            return;
        }
        cVar.removeMessages(11);
        cVar.D(11, 800L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(tv.chushou.zues.c cVar) {
        if (this.psO == null) {
            if (this.psk.ple != null) {
                int g = this.psk.ple.g();
                ChatInfo euI = this.psk.ple.euI();
                if (euI == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(euI, g);
                    return;
                }
            }
            return;
        }
        cVar.removeMessages(12);
        cVar.D(12, 800L);
    }

    private void a(final ChatInfo chatInfo, final int i) {
        int i2;
        if (this.psO != null || getContext() == null) {
            if (this.psm != null) {
                this.psm.removeMessages(12);
                this.psm.D(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.psO = this.prW.findViewById(a.f.rl_show_tip);
            if (this.psO != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.etQ().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.psl);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.psO.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.psl, 5.0f);
                    this.psO.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.psO = this.prW.findViewById(a.f.rl_tip);
        }
        if (this.psO != null) {
            this.psO.setVisibility(0);
            this.psO.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.psk != null) {
                            RoomInfo euL = g.this.psk.euL();
                            if (euL != null) {
                                str = euL.mRoomID;
                            }
                            if (euL != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(euL.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.psl, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.psO.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.psO.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.psk != null) {
                            RoomInfo euL = g.this.psk.euL();
                            if (euL != null) {
                                str = euL.mRoomID;
                            }
                            if (euL != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(euL.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.psl, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.psl.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.psl, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.psl, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0991a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.hB(getContext()).x;
                if (this.psl.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.psl, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.psl, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0991a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.psO.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.psO != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.psO.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.psO.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.psZ == null) {
                                g.this.psZ = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.psZ.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.psZ.removeAllListeners();
                            }
                            g.this.psZ.playTogether(ObjectAnimator.ofFloat(g.this.psO, "translationX", g.this.psO.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.psZ.start();
                            if (g.this.psm != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.psm.D(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void aq() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!aa() && this.psO != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.psO, "translationX", 0.0f, 10.0f, -this.psO.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.aa()) {
                        if (g.this.psO != null) {
                            g.this.psO.setVisibility(8);
                        }
                        g.this.psO = null;
                        if (g.this.psm != null) {
                            g.this.psm.D(12, 800L);
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
            if (this.psZ == null) {
                this.psZ = new AnimatorSet();
            }
            this.psZ.playTogether(duration);
            this.psZ.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void edU() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.psl).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.psP = new EmanateView(this.psl);
            this.psP.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.psP);
            return;
        }
        this.psP = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.psQ == null) {
            this.psQ = (RoomSendGiftView) this.prW.findViewById(a.f.normalSendGiftView);
            this.psQ.setContext(this.psl);
            if (this.psk != null) {
                this.psQ.a(this.psk.euJ());
            }
            this.psQ.a(z, z2);
            this.psQ.setVisibilityListener(this.pta);
            this.psQ.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.psP != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable aap = tv.chushou.zues.utils.h.aap(str);
                            if (aap == null) {
                                aap = tv.chushou.zues.utils.h.aar(str);
                            }
                            g.this.psP.setDrawable(aap, (int) (view.getMeasuredWidth() * g.this.f4137a), (int) (view.getMeasuredHeight() * g.this.f4137a));
                            if (view != null) {
                                g.this.psP.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.f4137a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.f4137a)) / 2.0d)));
                            }
                            g.this.psP.eIe();
                        }
                    }
                }
            });
            this.psQ.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void b(ConfigDetail configDetail) {
                    if (configDetail != null) {
                        g.this.b(configDetail);
                    }
                }

                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void a(boolean z3, boolean z4) {
                    g.this.aG(z3, z4);
                }
            });
        }
        if (this.psQ != null) {
            if (this.psk != null) {
                this.psQ.a(z ? this.psk.plj : this.psk.plk, this.psk.pll, this.psk.plm, z);
                this.psQ.setGiftTopIcon(this.psk.plo);
            }
            if (micMemberInfo != null) {
                this.psQ.setMicMemberInfo(micMemberInfo);
            }
            this.psQ.c();
        }
    }

    protected void aG(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.psR.setProgress(i);
            if (!this.psW) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.psS.setText(this.psl.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.psS.setText(this.psl.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.psS.setText(this.psl.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.psT.cd(str, a.e.pao_circle_default);
            if (this.psV != i) {
                this.psT.startAnimation(AnimationUtils.loadAnimation(this.psl, a.C0991a.pao_beat_anim));
                this.psV = i;
            }
            if (this.bb != bangInfo.mLevel) {
                if (this.psm != null && !this.psm.Sw(17)) {
                    this.psm.b(this.psm.Sx(17), 500L);
                }
                this.bb = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.psU.b()) {
            WindowManager windowManager = (WindowManager) this.psl.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                this.psU.a(this.psl, i, this.psk.euJ().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.psU.e();
        this.psU.c();
    }

    public void evJ() {
        this.psT.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.psT.getWidth() / 2, this.psT.getHeight() / 2);
        aVar.setDuration(1000L);
        this.psT.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.psY == null && this.psl != null) {
            if ("3".equals(this.psr)) {
                z = h.etY().b;
            } else if (this.psk == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.etY().d;
            } else {
                z = h.etY().e;
            }
            this.psY = new CSDanmuLayout(this.psl.getApplicationContext(), new a.C1113a().Su(-16711936).St(800).Bv(true).Bw(this.ap >= 0).Ss(2).eHa(), h.etY().b());
            this.psY.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.psl);
            Point hB = tv.chushou.zues.utils.a.hB(this.psl);
            switch (h.etY().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.psl.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = hB.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.psl.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = hB.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            evH().addView(this.psY, 1, layoutParams);
            if (this.psY != null) {
                this.psY.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.psY != null) {
            this.psY.setVisibility(8);
            this.psY.eHb();
        }
        if (this.psY != null) {
            this.psY.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void S() {
        if (this.psY != null && this.psk != null) {
            if (this.ap < 0) {
                this.psY.setVisibility(h.etY().d ? 0 : 8);
            } else {
                this.psY.setVisibility(h.etY().e ? 0 : 8);
            }
        }
        if (this.psY != null && this.psY.isPrepared() && !this.H && !this.al) {
            this.psY.resume();
            this.psY.eHb();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.pti == null) {
            if (this.ptg == null) {
                this.ptg = new ArrayList();
            }
            this.ptg.clear();
            bo(getString(a.i.danmu_settings_no_gift), false);
            bo(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.psl).pjF != null) {
                if (this.psk.euJ() != null) {
                    this.ptk = this.psk.euJ().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.ptk)) {
                    bo(getString(a.i.danmu_settings_no_normal), true);
                    this.ptg.addAll(this.ptk);
                } else {
                    bo(getString(a.i.danmu_settings_no_normal), false);
                }
            } else {
                bo(getString(a.i.danmu_settings_no_normal), false);
            }
            if (i == 3) {
                i2 = a.h.pop_privacy_setting_black;
            } else {
                i2 = a.h.pop_privacy_setting;
            }
            View inflate = LayoutInflater.from(this.psl).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.psl));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.ptj = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.psl).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.ptj.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.ptj.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.pth = new com.kascend.chushou.player.adapter.b(i, this.psl, this.ptg, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.pth);
            if (!tv.chushou.zues.utils.h.isEmpty(this.ptk) && this.ptk.size() >= 5) {
                this.pti = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.psl, 165.0f), tv.chushou.zues.utils.a.dip2px(this.psl, 354.0f));
            } else {
                this.pti = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.psl, 165.0f), -2);
            }
            this.pti.setFocusable(true);
            this.pti.setOutsideTouchable(true);
            this.pti.setBackgroundDrawable(this.psl.getResources().getDrawable(a.e.bg_room_pop));
            this.pti.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void evK() {
        i(2);
    }

    protected void bo(String str, boolean z) {
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
        if (this.ptg != null) {
            this.ptg.add(privacyItem);
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
        if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_V8_SO, "chatType", str2, "chatState", str, "roomId", this.psk.euJ().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.pth.notifyDataSetChanged();
        au();
    }

    protected void au() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.eHN()) {
            tv.chushou.zues.utils.g.d(this.psl, this.psl.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.etT().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.pth.notifyDataSetChanged();
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
                        g.this.pth.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.pth.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.ptg) {
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
                for (PrivacyItem privacyItem3 : this.ptg) {
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
            for (PrivacyItem privacyItem4 : this.ptg) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.ptm == null) {
            this.ptm = new ArrayList<>();
        }
        this.ptm.add(str);
        this.ptm.add(str2);
        p pVar = new p();
        pVar.f4077a = this.ptm;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.ptm == null) {
            this.ptm = new ArrayList<>();
        }
        this.ptm.add(str);
        p pVar = new p();
        pVar.f4077a = this.ptm;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.ptm != null) {
            this.ptm.remove(str);
            this.ptm.remove(str2);
            p pVar = new p();
            pVar.f4077a = this.ptm;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.ptm != null) {
            this.ptm.remove(str);
            p pVar = new p();
            pVar.f4077a = this.ptm;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout evd = evd();
        if (evd != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) evd.getLayoutParams();
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
            evd.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout evd = evd();
        if (evd != null) {
            evd.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.etY().q()) {
                h.etY().g(false);
                this.psy.c();
                return;
            }
            h.etY().g(true);
            this.psy.b();
        } else if (id == a.f.rl_decode) {
            if (h.etY().f4087a) {
                h.etY().a(this.psl, false);
                this.psA.c();
            } else {
                h.etY().a(this.psl, true);
                this.psA.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.psl, evG(), this.ap < 0);
            evj();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.psl).q) {
                ((VideoPlayer) this.psl).q = false;
                if (this.psk.ple != null) {
                    this.psk.ple.e();
                    this.psk.ple.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.psw.c();
                return;
            }
            ((VideoPlayer) this.psl).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.psw.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.etY().o();
            if (this.ap < 0) {
                o = h.etY().n();
            }
            if (!this.psr.equals("1")) {
                o = h.etY().b;
            }
            boolean z = !o;
            if (z) {
                this.psB.b();
            } else {
                this.psB.c();
            }
            if (!this.psr.equals("1")) {
                h.etY().a(z);
            } else if (this.ap < 0) {
                h.etY().e(z);
            } else {
                h.etY().f(z);
            }
            switch (h.etY().m()) {
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
            com.kascend.chushou.toolkit.a.c.c(this.psl, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.psl).q) {
                ((VideoPlayer) this.psl).q = false;
                if (this.psk.ple != null) {
                    this.psk.ple.e();
                    this.psk.ple.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.ptj.setImageResource(i);
            } else {
                ((VideoPlayer) this.psl).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.ptj.setImageResource(i2);
            }
            au();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.ptc != null) {
            this.ptc.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC1006a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a evo() {
        return null;
    }

    public GiftAnimationLayout evd() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void evA() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo euL;
        if (this.psk != null && (euL = this.psk.euL()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!euL.mOnlineCount.equals(str2) || !euL.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    euL.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    euL.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                evA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.etY().c(true);
        if (this.pte == null) {
            a();
        }
        if (!this.pte.isShowing()) {
            if (view != null) {
                this.pte.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.psl, 3.0f), (this.prW.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aH(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.psl, 8.0f));
                RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.pte != null) {
                            g.this.pte.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.pte.dismiss();
    }

    private void a() {
        if (this.pte == null) {
            View inflate = LayoutInflater.from(this.psl).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.psl.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.psl.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.pte = new PopupWindow(inflate, -2, -2);
            this.pte.setFocusable(true);
            this.pte.setOutsideTouchable(true);
            this.pte.setAnimationStyle(a.j.gift_toast_style);
            this.pte.update();
            this.pte.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.pte = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
