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
    protected PopupWindow phA;
    protected PopupWindow phB;
    protected RecyclerView phC;
    protected LinearLayoutManager phD;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> phE;
    protected ArrayList<a> phF;
    protected ArrayList<a> phG;
    protected PopupWindow phH;
    protected View phI;
    protected SVGAImageView phJ;
    protected View phK;
    protected EmanateView phL;
    protected RoomSendGiftView phM;
    protected RoundProgressBar phN;
    protected TextView phO;
    protected FrescoThumbnailView phP;
    protected PaoGuideView phQ;
    protected AnimatorSet phV;
    protected KasBaseMenuView.a phW;
    protected H5Container phY;
    protected RelativeLayout phZ;
    protected RelativeLayout phq;
    protected RelativeLayout phr;
    protected OnlineToggleButton phs;
    protected RelativeLayout pht;
    protected OnlineToggleButton phu;
    protected RelativeLayout phv;
    protected OnlineToggleButton phw;
    protected OnlineToggleButton phx;
    protected LinearLayout phy;
    protected PopupWindow phz;
    protected PopupWindow pia;
    protected PopupWindow pib;
    protected List<PrivacyItem> pie;
    protected com.kascend.chushou.player.adapter.b pif;
    protected PopupWindow pig;
    protected ImageView pih;
    protected List<PrivacyItem> pii;
    protected FrescoThumbnailView pij;
    protected ArrayList<String> pik;
    protected boolean aR = false;
    protected int bb = 0;
    protected long phR = 0;
    protected boolean phS = false;
    protected IconConfig.Config phT = new IconConfig.Config();
    protected CSDanmuLayout phU = null;
    protected boolean phX = false;

    /* renamed from: a  reason: collision with root package name */
    private double f4135a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.aa() && g.this.phC != null && g.this.phE != null && g.this.phD != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.phD.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.phD.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.phD.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.phD.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.phD.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.phC.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.phi != null) {
                                    g.this.phi.N(g.this.d);
                                    if (g.this.b) {
                                        g.this.phi.f(g.this.d, 1000L);
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
    public RelativeLayout erS() {
        if (this.phq == null) {
            this.phq = (RelativeLayout) this.pgS.findViewById(a.f.video_root_view);
        }
        return this.phq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(View view, int i, int i2) {
        if (!this.phX) {
            vC();
        }
        vD();
        if (this.phz != null) {
            if (!this.phz.isShowing()) {
                this.phz.showAtLocation(view, 53, i, i2);
            } else {
                this.phz.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point hD = tv.chushou.zues.utils.a.hD(this.phh);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.eqj().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.eqj().b(1);
                layoutParams.width = -1;
                if (this.phh.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = hD.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.eqj().b(2);
                layoutParams.width = -1;
                if (this.phh.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = hD.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.phU != null) {
            this.phU.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(View view, int i, int i2) {
        ead();
        if (this.phA != null) {
            if (!this.phA.isShowing()) {
                if (this.phh.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.phA.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.phA.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.phA.showAtLocation(view, 53, i, i2);
                return;
            }
            this.phA.dismiss();
        }
    }

    protected void ead() {
        int i = a.h.pop_danmu_full_setting;
        if (this.phh.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.phh).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.phx = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.phn.equals("1")) {
            if (h.eqj().b) {
                this.phx.b();
            } else {
                this.phx.c();
            }
        } else if (this.ap < 0) {
            if (h.eqj().n()) {
                this.phx.b();
            } else {
                this.phx.c();
            }
        } else if (h.eqj().o()) {
            this.phx.b();
        } else {
            this.phx.c();
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
        switch (h.eqj().m()) {
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
        if (this.phh.getResources().getConfiguration().orientation == 1) {
            this.phA = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.phh, 230.0f), -2);
            this.phA.setBackgroundDrawable(this.phh.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.phA = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.phh, 295.0f), -1);
            this.phA.setClippingEnabled(false);
            this.phA.setBackgroundDrawable(this.phh.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.phA.setFocusable(true);
        this.phA.setOutsideTouchable(true);
        this.phA.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vB() {
        if (!this.phn.equals("1")) {
            h.eqj().a(true);
        } else if (this.ap < 0) {
            h.eqj().e(true);
        } else {
            h.eqj().f(true);
        }
        switch (h.eqj().m()) {
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

    protected void vC() {
        ArrayList<PlayUrl> arrayList;
        int i;
        if (!this.phX) {
            int i2 = a.h.pop_full_play_setting;
            if (this.phh.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.phh).inflate(i2, (ViewGroup) null);
            this.phy = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.phr = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.phs = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.pht = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.phu = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.phv = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.phw = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.phh.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.phh);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.L(10.0f);
                }
                this.phy.setPadding(this.phy.getPaddingLeft(), statusBarHeight, this.phy.getPaddingRight(), this.phy.getPaddingBottom());
            }
            this.phr.setOnClickListener(this);
            this.pht.setOnClickListener(this);
            this.phv.setOnClickListener(this);
            if (!this.phn.equals("1") || this.ap < 0) {
                this.phr.setVisibility(8);
            } else {
                this.phr.setVisibility(0);
            }
            if (((VideoPlayer) this.phh).q) {
                this.phs.b();
            } else {
                this.phs.c();
            }
            if (h.eqj().q()) {
                this.phu.b();
            } else {
                this.phu.c();
            }
            if (com.kascend.chushou.c.f4077a) {
                this.phv.setVisibility(0);
            } else {
                this.phv.setVisibility(8);
            }
            if (h.eqj().f4085a) {
                this.phw.b();
            } else {
                this.phw.c();
            }
            if (this.phg != null && (arrayList = this.phg.f) != null && arrayList.size() > 0) {
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
                            if (this.phh.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.phh).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl eqV = this.phg.eqV();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.phh).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.phh.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.phh).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.phh, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.phh, 6.0f);
                                    }
                                    int identifier = this.phh.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.phh.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.phy, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (eqV != null && eqV.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.phy.addView(inflate2);
                            this.phX = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.phh.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.phh).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl eqV2 = this.phg.eqV();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.phh).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.phh.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.phh).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.phh, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.phh, 6.0f);
                                    }
                                    int identifier2 = this.phh.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.phh.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.phy, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (eqV2 != null && eqV2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.phy.addView(inflate3);
                            this.phX = true;
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
            if (this.phh.getResources().getConfiguration().orientation == 1) {
                this.phz = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.phh, 230.0f), -2);
                this.phz.setBackgroundDrawable(this.phh.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.phz = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.phh, 295.0f), -1);
                this.phz.setClippingEnabled(false);
                this.phz.setBackgroundDrawable(this.phh.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.phz.setFocusable(true);
            this.phz.setOutsideTouchable(true);
            this.phz.update();
        }
    }

    protected void vD() {
        if (this.pht != null && this.phu != null) {
            this.pht.setVisibility(0);
            if (h.eqj().q()) {
                this.phu.b();
            } else {
                this.phu.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eag() {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = null;
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() != -1) {
            com.kascend.chushou.d.e.a(0);
        }
        com.kascend.chushou.toolkit.a.c.a(this.phh, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.phg.f;
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
            if (this.phy == null) {
                this.phg.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.phg.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.phh).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.phy.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.phy.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.phh.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.phh.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.phy, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.phh, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.phg.f;
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
            if (this.phy == null) {
                if (!z) {
                    this.phg.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.phg.a(playUrl);
                if (this.ap >= 0) {
                    this.phg.a(false);
                    if (this.phh != null) {
                        ((VideoPlayer) this.phh).b(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.phh).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.phy.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.phy.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.phh.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.phh.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.phy, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.phz != null) {
            this.phz.dismiss();
        }
        if (this.phB != null) {
            this.phB.dismiss();
        }
        PlayUrl eqV = this.phg.eqV();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.phg.d) {
                this.phg.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.phg.a(playUrl);
                this.phg.a(false);
                if (this.phh != null) {
                    ((VideoPlayer) this.phh).b(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.phg.d) {
            this.phg.e = true;
        }
        h.eqj().a(this.phh, urlDetails.mDefinitionType);
        if (z || (eqV != null && !eqV.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.phh, erR(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.phg.a(playUrl);
            if (erR()) {
                if (((VideoPlayer) this.phh) != null) {
                    ((VideoPlayer) this.phh).r = -1L;
                }
                if (this.pdz != null) {
                    this.oiq = this.pdz.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.phh).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.phm = str2;
        if (this.phi != null) {
            this.phi.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void eru() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.aR = true;
            if (this.phG == null) {
                this.phG = new ArrayList<>();
            }
            this.phG.clear();
            this.phG.addAll(list);
            this.phH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.phH == null) {
            View inflate = LayoutInflater.from(this.phh).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.phh.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.phh.getResources().getColor(a.c.player_bg_color));
            }
            if (this.aR && !tv.chushou.zues.utils.h.isEmpty(this.phG)) {
                this.phF = this.phG;
            } else {
                this.phF = (ArrayList) h.eqj().eql();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.phF)) {
                String[] stringArray = this.phh.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.phh.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.phF == null) {
                    this.phF = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.phF.add(aVar);
                }
            }
            this.phC = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.phE = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.phF, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void I(View view, int i4) {
                    a aVar2;
                    if (g.this.phH != null) {
                        g.this.phH.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.phF) && i4 < g.this.phF.size() && (aVar2 = g.this.phF.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.aR) {
                            g.this.phF.remove(i4);
                            g.this.phF.add(0, aVar2);
                            g.this.phE.notifyDataSetChanged();
                            g.this.phC.scrollToPosition(0);
                            RxExecutor.post(g.this.pgR, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.eqj().a((Object) g.this.phF);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.phh, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.phg != null && g.this.phg.eqU() != null && g.this.phg.eqU().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.phg.eqU().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC1101a view$OnLongClickListenerC1101a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC1101a.a(a.f.tv_name, g.this.phh.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC1101a.a(a.f.tv_name, g.this.phh.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC1101a.a(a.f.tv_name, g.this.phh.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC1101a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.phD = new LinearLayoutManager(this.phh);
            this.phC.setLayoutManager(this.phD);
            this.phC.setAdapter(this.phE);
            this.phC.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                    if (g.this.ap < 0) {
                        if (i4 == 0) {
                            g.this.erT();
                        } else {
                            g.this.ao();
                        }
                    }
                    super.onScrollStateChanged(recyclerView, i4);
                }
            });
            this.phH = new PopupWindow(inflate, this.phh.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.phh.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.phH.setFocusable(true);
            this.phH.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.phH.setBackgroundDrawable(this.phh.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.phH.setBackgroundDrawable(this.phh.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.phH.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.phi.N(this.d);
        this.phi.o(this.d);
    }

    protected void erT() {
        this.b = true;
        this.phi.N(this.d);
        this.phi.f(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.phi != null) {
            this.phi.N(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bF(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.phg != null) {
                RoomInfo eqW = this.phg.eqW();
                if (eqW != null) {
                    str = eqW.mRoomID;
                }
                if (eqW != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(eqW.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.phh, listItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.pgS != null) {
            Point hD = tv.chushou.zues.utils.a.hD(this.phh);
            int i = hD.x > hD.y ? 1 : 2;
            if (this.phY == null) {
                this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.phY.setPlayerViewHelper(this.phg);
            this.phY.setVisibility(0);
            this.phY.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.phg != null && (e = this.phg.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.phY != null) {
            this.phY.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.phI == null && this.phJ == null) {
            if (this.phg.pac != null) {
                ChatInfo eqS = this.phg.pac.eqS();
                if (eqS == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.phZ == null) {
                    this.phZ = (RelativeLayout) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (eqS.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(eqS.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        eqS.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (eqS.mAnimSubType > 0) {
                    eqS.mAnimType = eqS.mAnimSubType;
                }
                if (eqS.mAnimationPluginId == 1) {
                    this.phI = com.kascend.chushou.toolkit.d.a.esr().a(this.phh, String.valueOf(eqS.mAnimType), this.phZ, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.aa() && g.this.phI != null && g.this.phZ != null) {
                                Object tag = g.this.phI.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.esr().a(g.this.phh, String.valueOf(((ChatInfo) tag).mAnimType), g.this.phZ, g.this.phI);
                                }
                                if (!z) {
                                    g.this.phI.setVisibility(8);
                                    g.this.phZ.removeView(g.this.phI);
                                    g.this.phI = null;
                                    if (g.this.phi != null) {
                                        g.this.phi.removeMessages(11);
                                        g.this.phi.E(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.phI = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, eqS.mJsonData);
                } else if (eqS.mAnimationPluginId == 2) {
                    if (this.phJ == null && this.phZ != null) {
                        this.phJ = (SVGAImageView) this.phZ.findViewById(a.f.svgaView);
                        if (this.phJ == null) {
                            this.phJ = new SVGAImageView(this.phh);
                            this.phJ.setClearsAfterStop(true);
                            this.phJ.setLoops(1);
                            this.phJ.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.phZ.addView(this.phJ, layoutParams);
                        }
                    }
                    if (this.phJ == null) {
                        cVar.removeMessages(11);
                        cVar.E(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.esr().a(this.phh, String.valueOf(eqS.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.phJ.stopAnimation();
                            g.this.phJ.clearAnimation();
                            g.this.phJ.setVisibility(8);
                            g.this.phJ = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void ada() {
                            g.this.phJ.stopAnimation();
                            g.this.phJ.clearAnimation();
                            g.this.phJ.setVisibility(8);
                            g.this.phJ = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void adb() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.phJ, eqS);
                }
                if (this.phI != null) {
                    this.phI.setTag(eqS);
                    return;
                }
                return;
            }
            return;
        }
        cVar.removeMessages(11);
        cVar.E(11, 800L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(tv.chushou.zues.c cVar) {
        if (this.phK == null) {
            if (this.phg.pac != null) {
                int g = this.phg.pac.g();
                ChatInfo eqT = this.phg.pac.eqT();
                if (eqT == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(eqT, g);
                    return;
                }
            }
            return;
        }
        cVar.removeMessages(12);
        cVar.E(12, 800L);
    }

    private void a(final ChatInfo chatInfo, final int i) {
        int i2;
        if (this.phK != null || getContext() == null) {
            if (this.phi != null) {
                this.phi.removeMessages(12);
                this.phi.E(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.phK = this.pgS.findViewById(a.f.rl_show_tip);
            if (this.phK != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.eqb().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.phh);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.phK.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.phh, 5.0f);
                    this.phK.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.phK = this.pgS.findViewById(a.f.rl_tip);
        }
        if (this.phK != null) {
            this.phK.setVisibility(0);
            this.phK.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.phg != null) {
                            RoomInfo eqW = g.this.phg.eqW();
                            if (eqW != null) {
                                str = eqW.mRoomID;
                            }
                            if (eqW != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(eqW.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.phh, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.phK.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.phK.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.phg != null) {
                            RoomInfo eqW = g.this.phg.eqW();
                            if (eqW != null) {
                                str = eqW.mRoomID;
                            }
                            if (eqW != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(eqW.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.phh, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.phh.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.phh, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.phh, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0969a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.hD(getContext()).x;
                if (this.phh.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.phh, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.phh, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0969a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.phK.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.phK != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.phK.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.phK.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.phV == null) {
                                g.this.phV = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.phV.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.phV.removeAllListeners();
                            }
                            g.this.phV.playTogether(ObjectAnimator.ofFloat(g.this.phK, "translationX", g.this.phK.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.phV.start();
                            if (g.this.phi != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.phi.E(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void aq() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!aa() && this.phK != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.phK, "translationX", 0.0f, 10.0f, -this.phK.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.aa()) {
                        if (g.this.phK != null) {
                            g.this.phK.setVisibility(8);
                        }
                        g.this.phK = null;
                        if (g.this.phi != null) {
                            g.this.phi.E(12, 800L);
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
            if (this.phV == null) {
                this.phV = new AnimatorSet();
            }
            this.phV.playTogether(duration);
            this.phV.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ean() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.phh).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.phL = new EmanateView(this.phh);
            this.phL.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.phL);
            return;
        }
        this.phL = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.phM == null) {
            this.phM = (RoomSendGiftView) this.pgS.findViewById(a.f.normalSendGiftView);
            this.phM.setContext(this.phh);
            if (this.phg != null) {
                this.phM.a(this.phg.eqU());
            }
            this.phM.a(z, z2);
            this.phM.setVisibilityListener(this.phW);
            this.phM.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.phL != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable aaa = tv.chushou.zues.utils.h.aaa(str);
                            if (aaa == null) {
                                aaa = tv.chushou.zues.utils.h.aac(str);
                            }
                            g.this.phL.setDrawable(aaa, (int) (view.getMeasuredWidth() * g.this.f4135a), (int) (view.getMeasuredHeight() * g.this.f4135a));
                            if (view != null) {
                                g.this.phL.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.f4135a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.f4135a)) / 2.0d)));
                            }
                            g.this.phL.eEo();
                        }
                    }
                }
            });
            this.phM.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void b(ConfigDetail configDetail) {
                    if (configDetail != null) {
                        g.this.b(configDetail);
                    }
                }

                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void a(boolean z3, boolean z4) {
                    g.this.aI(z3, z4);
                }
            });
        }
        if (this.phM != null) {
            if (this.phg != null) {
                this.phM.a(z ? this.phg.pai : this.phg.paj, this.phg.pak, this.phg.pal, z);
                this.phM.setGiftTopIcon(this.phg.pan);
            }
            if (micMemberInfo != null) {
                this.phM.setMicMemberInfo(micMemberInfo);
            }
            this.phM.c();
        }
    }

    protected void aI(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.phN.setProgress(i);
            if (!this.phS) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.phO.setText(this.phh.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.phO.setText(this.phh.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.phO.setText(this.phh.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.phP.cc(str, a.e.pao_circle_default);
            if (this.phR != i) {
                this.phP.startAnimation(AnimationUtils.loadAnimation(this.phh, a.C0969a.pao_beat_anim));
                this.phR = i;
            }
            if (this.bb != bangInfo.mLevel) {
                if (this.phi != null && !this.phi.Rz(17)) {
                    this.phi.b(this.phi.RA(17), 500L);
                }
                this.bb = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.phQ.b()) {
            WindowManager windowManager = (WindowManager) this.phh.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                this.phQ.a(this.phh, i, this.phg.eqU().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.phQ.e();
        this.phQ.c();
    }

    public void erU() {
        this.phP.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.phP.getWidth() / 2, this.phP.getHeight() / 2);
        aVar.setDuration(1000L);
        this.phP.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.phU == null && this.phh != null) {
            if ("3".equals(this.phn)) {
                z = h.eqj().b;
            } else if (this.phg == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.eqj().d;
            } else {
                z = h.eqj().e;
            }
            this.phU = new CSDanmuLayout(this.phh.getApplicationContext(), new a.C1090a().Rw(-16711936).Rv(800).Bd(true).Be(this.ap >= 0).Ru(2).eDk(), h.eqj().b());
            this.phU.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.phh);
            Point hD = tv.chushou.zues.utils.a.hD(this.phh);
            switch (h.eqj().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.phh.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = hD.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.phh.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = hD.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            erS().addView(this.phU, 1, layoutParams);
            if (this.phU != null) {
                this.phU.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.phU != null) {
            this.phU.setVisibility(8);
            this.phU.eDl();
        }
        if (this.phU != null) {
            this.phU.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void S() {
        if (this.phU != null && this.phg != null) {
            if (this.ap < 0) {
                this.phU.setVisibility(h.eqj().d ? 0 : 8);
            } else {
                this.phU.setVisibility(h.eqj().e ? 0 : 8);
            }
        }
        if (this.phU != null && this.phU.isPrepared() && !this.H && !this.al) {
            this.phU.resume();
            this.phU.eDl();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.pig == null) {
            if (this.pie == null) {
                this.pie = new ArrayList();
            }
            this.pie.clear();
            bm(getString(a.i.danmu_settings_no_gift), false);
            bm(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.phh).oYE != null) {
                if (this.phg.eqU() != null) {
                    this.pii = this.phg.eqU().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.pii)) {
                    bm(getString(a.i.danmu_settings_no_normal), true);
                    this.pie.addAll(this.pii);
                } else {
                    bm(getString(a.i.danmu_settings_no_normal), false);
                }
            } else {
                bm(getString(a.i.danmu_settings_no_normal), false);
            }
            if (i == 3) {
                i2 = a.h.pop_privacy_setting_black;
            } else {
                i2 = a.h.pop_privacy_setting;
            }
            View inflate = LayoutInflater.from(this.phh).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.phh));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.pih = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.phh).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.pih.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.pih.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.pif = new com.kascend.chushou.player.adapter.b(i, this.phh, this.pie, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.pif);
            if (!tv.chushou.zues.utils.h.isEmpty(this.pii) && this.pii.size() >= 5) {
                this.pig = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.phh, 165.0f), tv.chushou.zues.utils.a.dip2px(this.phh, 354.0f));
            } else {
                this.pig = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.phh, 165.0f), -2);
            }
            this.pig.setFocusable(true);
            this.pig.setOutsideTouchable(true);
            this.pig.setBackgroundDrawable(this.phh.getResources().getDrawable(a.e.bg_room_pop));
            this.pig.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void erV() {
        i(2);
    }

    protected void bm(String str, boolean z) {
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
        if (this.pie != null) {
            this.pie.add(privacyItem);
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
        if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_V8_SO, "chatType", str2, "chatState", str, "roomId", this.phg.eqU().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.pif.notifyDataSetChanged();
        au();
    }

    protected void au() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.eDX()) {
            tv.chushou.zues.utils.g.d(this.phh, this.phh.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.eqe().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.pif.notifyDataSetChanged();
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
                        g.this.pif.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.pif.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.pie) {
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
                for (PrivacyItem privacyItem3 : this.pie) {
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
            for (PrivacyItem privacyItem4 : this.pie) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.pik == null) {
            this.pik = new ArrayList<>();
        }
        this.pik.add(str);
        this.pik.add(str2);
        p pVar = new p();
        pVar.f4075a = this.pik;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.pik == null) {
            this.pik = new ArrayList<>();
        }
        this.pik.add(str);
        p pVar = new p();
        pVar.f4075a = this.pik;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.pik != null) {
            this.pik.remove(str);
            this.pik.remove(str2);
            p pVar = new p();
            pVar.f4075a = this.pik;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.pik != null) {
            this.pik.remove(str);
            p pVar = new p();
            pVar.f4075a = this.pik;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout ero = ero();
        if (ero != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ero.getLayoutParams();
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
            ero.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout ero = ero();
        if (ero != null) {
            ero.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.eqj().q()) {
                h.eqj().g(false);
                this.phu.c();
                return;
            }
            h.eqj().g(true);
            this.phu.b();
        } else if (id == a.f.rl_decode) {
            if (h.eqj().f4085a) {
                h.eqj().a(this.phh, false);
                this.phw.c();
            } else {
                h.eqj().a(this.phh, true);
                this.phw.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.phh, erR(), this.ap < 0);
            eru();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.phh).q) {
                ((VideoPlayer) this.phh).q = false;
                if (this.phg.pac != null) {
                    this.phg.pac.e();
                    this.phg.pac.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.phs.c();
                return;
            }
            ((VideoPlayer) this.phh).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.phs.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.eqj().o();
            if (this.ap < 0) {
                o = h.eqj().n();
            }
            if (!this.phn.equals("1")) {
                o = h.eqj().b;
            }
            boolean z = !o;
            if (z) {
                this.phx.b();
            } else {
                this.phx.c();
            }
            if (!this.phn.equals("1")) {
                h.eqj().a(z);
            } else if (this.ap < 0) {
                h.eqj().e(z);
            } else {
                h.eqj().f(z);
            }
            switch (h.eqj().m()) {
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
            com.kascend.chushou.toolkit.a.c.c(this.phh, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.phh).q) {
                ((VideoPlayer) this.phh).q = false;
                if (this.phg.pac != null) {
                    this.phg.pac.e();
                    this.phg.pac.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.pih.setImageResource(i);
            } else {
                ((VideoPlayer) this.phh).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.pih.setImageResource(i2);
            }
            au();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.phY != null) {
            this.phY.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0984a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a erz() {
        return null;
    }

    public GiftAnimationLayout ero() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void erL() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo eqW;
        if (this.phg != null && (eqW = this.phg.eqW()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!eqW.mOnlineCount.equals(str2) || !eqW.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    eqW.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    eqW.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                erL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.eqj().c(true);
        if (this.pia == null) {
            a();
        }
        if (!this.pia.isShowing()) {
            if (view != null) {
                this.pia.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.phh, 3.0f), (this.pgS.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aG(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.phh, 8.0f));
                RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.pia != null) {
                            g.this.pia.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.pia.dismiss();
    }

    private void a() {
        if (this.pia == null) {
            View inflate = LayoutInflater.from(this.phh).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.phh.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.phh.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.pia = new PopupWindow(inflate, -2, -2);
            this.pia.setFocusable(true);
            this.pia.setOutsideTouchable(true);
            this.pia.setAnimationStyle(a.j.gift_toast_style);
            this.pia.update();
            this.pia.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.pia = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
