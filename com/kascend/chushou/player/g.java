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
/* loaded from: classes4.dex */
public abstract class g extends f implements View.OnClickListener, CSDanmuLayout.a {
    private int c;
    protected RelativeLayout mXE;
    protected RelativeLayout mXF;
    protected OnlineToggleButton mXG;
    protected RelativeLayout mXH;
    protected OnlineToggleButton mXI;
    protected RelativeLayout mXJ;
    protected OnlineToggleButton mXK;
    protected OnlineToggleButton mXL;
    protected LinearLayout mXM;
    protected PopupWindow mXN;
    protected PopupWindow mXO;
    protected PopupWindow mXP;
    protected RecyclerView mXQ;
    protected LinearLayoutManager mXR;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> mXS;
    protected ArrayList<a> mXT;
    protected ArrayList<a> mXU;
    protected PopupWindow mXV;
    protected View mXX;
    protected SVGAImageView mXY;
    protected View mXZ;
    protected EmanateView mYa;
    protected RoomSendGiftView mYb;
    protected RoundProgressBar mYc;
    protected TextView mYd;
    protected FrescoThumbnailView mYe;
    protected PaoGuideView mYf;
    protected AnimatorSet mYk;
    protected KasBaseMenuView.a mYl;
    protected H5Container mYm;
    protected RelativeLayout mYn;
    protected PopupWindow mYo;
    protected PopupWindow mYp;
    protected List<PrivacyItem> mYq;
    protected com.kascend.chushou.player.adapter.b mYr;
    protected PopupWindow mYs;
    protected ImageView mYt;
    protected List<PrivacyItem> mYu;
    protected FrescoThumbnailView mYv;
    protected ArrayList<String> mYw;
    protected boolean mXW = false;
    protected int aNY = 0;
    protected long mYg = 0;
    protected boolean mYh = false;
    protected IconConfig.Config mYi = new IconConfig.Config();
    protected CSDanmuLayout mYj = null;
    protected boolean bi = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.dCE() && g.this.mXQ != null && g.this.mXS != null && g.this.mXR != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.mXR.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.mXR.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.mXR.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.mXR.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.mXR.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.mXQ.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.mXx != null) {
                                    g.this.mXx.removeCallbacks(g.this.d);
                                    if (g.this.b) {
                                        g.this.mXx.d(g.this.d, 1000L);
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

    /* loaded from: classes4.dex */
    public static class a implements Serializable {
        private static final long serialVersionUID = -5486819557418455887L;
        public String mStrDisplay;
        public String mStrSend;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RelativeLayout dCF() {
        if (this.mXE == null) {
            this.mXE = (RelativeLayout) this.mXg.findViewById(a.f.video_root_view);
        }
        return this.mXE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(View view, int i, int i2) {
        if (!this.bi) {
            ag();
        }
        ah();
        if (this.mXN != null) {
            if (!this.mXN.isShowing()) {
                this.mXN.showAtLocation(view, 53, i, i2);
            } else {
                this.mXN.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point he = tv.chushou.zues.utils.a.he(this.mXw);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dAK().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dAK().b(1);
                layoutParams.width = -1;
                if (this.mXw.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mXA / 3;
                } else {
                    layoutParams.height = he.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dAK().b(2);
                layoutParams.width = -1;
                if (this.mXw.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mXA / 3;
                } else {
                    layoutParams.height = he.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.mYj != null) {
            this.mYj.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(View view, int i, int i2) {
        ae();
        if (this.mXO != null) {
            if (!this.mXO.isShowing()) {
                if (this.mXw.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.mXO.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.mXO.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.mXO.showAtLocation(view, 53, i, i2);
                return;
            }
            this.mXO.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.mXw.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.mXw).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.mXL = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dAK().b) {
                this.mXL.b();
            } else {
                this.mXL.c();
            }
        } else if (this.ap < 0) {
            if (h.dAK().n()) {
                this.mXL.b();
            } else {
                this.mXL.c();
            }
        } else if (h.dAK().o()) {
            this.mXL.b();
        } else {
            this.mXL.c();
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
        switch (h.dAK().m()) {
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
        if (this.mXw.getResources().getConfiguration().orientation == 1) {
            this.mXO = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXw, 230.0f), -2);
            this.mXO.setBackgroundDrawable(this.mXw.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.mXO = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXw, 295.0f), -1);
            this.mXO.setClippingEnabled(false);
            this.mXO.setBackgroundDrawable(this.mXw.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.mXO.setFocusable(true);
        this.mXO.setOutsideTouchable(true);
        this.mXO.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dAK().a(true);
        } else if (this.ap < 0) {
            h.dAK().e(true);
        } else {
            h.dAK().f(true);
        }
        switch (h.dAK().m()) {
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
            if (this.mXw.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.mXw).inflate(i2, (ViewGroup) null);
            this.mXM = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.mXF = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.mXG = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.mXH = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.mXI = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.mXJ = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mXK = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.mXF.setOnClickListener(this);
            this.mXH.setOnClickListener(this);
            this.mXJ.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.mXF.setVisibility(8);
            } else {
                this.mXF.setVisibility(0);
            }
            if (((VideoPlayer) this.mXw).q) {
                this.mXG.b();
            } else {
                this.mXG.c();
            }
            if (h.dAK().q()) {
                this.mXI.b();
            } else {
                this.mXI.c();
            }
            if (com.kascend.chushou.c.a) {
                this.mXJ.setVisibility(0);
            } else {
                this.mXJ.setVisibility(8);
            }
            if (h.dAK().a) {
                this.mXK.b();
            } else {
                this.mXK.c();
            }
            if (this.mXv != null && (arrayList = this.mXv.f) != null && arrayList.size() > 0) {
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
                            if (this.mXw.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.mXw).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dBv = this.mXv.dBv();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mXw).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.mXw.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.mXw).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mXw, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mXw, 6.0f);
                                    }
                                    int identifier = this.mXw.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mXw.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mXM, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dBv != null && dBv.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.mXM.addView(inflate2);
                            this.bi = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.mXw.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.mXw).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dBv2 = this.mXv.dBv();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mXw).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.mXw.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.mXw).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mXw, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mXw, 6.0f);
                                    }
                                    int identifier2 = this.mXw.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mXw.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mXM, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dBv2 != null && dBv2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.mXM.addView(inflate3);
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
            if (this.mXw.getResources().getConfiguration().orientation == 1) {
                this.mXN = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXw, 230.0f), -2);
                this.mXN.setBackgroundDrawable(this.mXw.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.mXN = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXw, 295.0f), -1);
                this.mXN.setClippingEnabled(false);
                this.mXN.setBackgroundDrawable(this.mXw.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.mXN.setFocusable(true);
            this.mXN.setOutsideTouchable(true);
            this.mXN.update();
        }
    }

    protected void ah() {
        if (this.mXH != null && this.mXI != null) {
            this.mXH.setVisibility(0);
            if (h.dAK().q()) {
                this.mXI.b();
            } else {
                this.mXI.c();
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
        com.kascend.chushou.toolkit.a.c.a(this.mXw, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.mXv.f;
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
            if (this.mXM == null) {
                this.mXv.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.mXv.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.mXw).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mXM.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mXM.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mXw.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mXw.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mXM, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.mXw, "点击音视切换_num", "视频切音频", new Object[0]);
        o(false);
    }

    protected void o(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.mXv.f;
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
            if (this.mXM == null) {
                if (!z) {
                    this.mXv.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.mXv.a(playUrl);
                if (this.ap >= 0) {
                    this.mXv.a(false);
                    if (this.mXw != null) {
                        ((VideoPlayer) this.mXw).a(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.mXw).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mXM.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mXM.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mXw.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mXw.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mXM, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.mXN != null) {
            this.mXN.dismiss();
        }
        if (this.mXP != null) {
            this.mXP.dismiss();
        }
        PlayUrl dBv = this.mXv.dBv();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.mXv.d) {
                this.mXv.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.mXv.a(playUrl);
                this.mXv.a(false);
                if (this.mXw != null) {
                    ((VideoPlayer) this.mXw).a(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.mXv.d) {
            this.mXv.e = true;
        }
        h.dAK().a(this.mXw, urlDetails.mDefinitionType);
        if (z || (dBv != null && !dBv.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.f(this.mXw, nL(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.mXv.a(playUrl);
            if (nL()) {
                if (((VideoPlayer) this.mXw) != null) {
                    ((VideoPlayer) this.mXw).r = -1L;
                }
                if (this.mTJ != null) {
                    this.kVr = this.mTJ.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.mXw).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.mXB = str2;
        if (this.mXx != null) {
            this.mXx.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.mXW = true;
            if (this.mXU == null) {
                this.mXU = new ArrayList<>();
            }
            this.mXU.clear();
            this.mXU.addAll(list);
            this.mXV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.mXV == null) {
            View inflate = LayoutInflater.from(this.mXw).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.mXw.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.mXw.getResources().getColor(a.c.player_bg_color));
            }
            if (this.mXW && !tv.chushou.zues.utils.h.isEmpty(this.mXU)) {
                this.mXT = this.mXU;
            } else {
                this.mXT = (ArrayList) h.dAK().dAM();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.mXT)) {
                String[] stringArray = this.mXw.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.mXw.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.mXT == null) {
                    this.mXT = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.mXT.add(aVar);
                }
            }
            this.mXQ = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.mXS = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.mXT, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void onItemClick(View view, int i4) {
                    a aVar2;
                    if (g.this.mXV != null) {
                        g.this.mXV.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.mXT) && i4 < g.this.mXT.size() && (aVar2 = g.this.mXT.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.mXW) {
                            g.this.mXT.remove(i4);
                            g.this.mXT.add(0, aVar2);
                            g.this.mXS.notifyDataSetChanged();
                            g.this.mXQ.scrollToPosition(0);
                            RxExecutor.post(g.this.mXf, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dAK().a((Object) g.this.mXT);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.mXw, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.mXv != null && g.this.mXv.dBu() != null && g.this.mXv.dBu().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.mXv.dBu().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0805a view$OnLongClickListenerC0805a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0805a.a(a.f.tv_name, g.this.mXw.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0805a.a(a.f.tv_name, g.this.mXw.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0805a.a(a.f.tv_name, g.this.mXw.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0805a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.mXR = new LinearLayoutManager(this.mXw);
            this.mXQ.setLayoutManager(this.mXR);
            this.mXQ.setAdapter(this.mXS);
            this.mXQ.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.mXV = new PopupWindow(inflate, this.mXw.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.mXw.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.mXV.setFocusable(true);
            this.mXV.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.mXV.setBackgroundDrawable(this.mXw.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.mXV.setBackgroundDrawable(this.mXw.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.mXV.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.mXx.removeCallbacks(this.d);
        this.mXx.m(this.d);
    }

    protected void an() {
        this.b = true;
        this.mXx.removeCallbacks(this.d);
        this.mXx.d(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.mXx != null) {
            this.mXx.removeCallbacks(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bD(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.mXv != null) {
                RoomInfo dBw = this.mXv.dBw();
                if (dBw != null) {
                    str = dBw.mRoomID;
                }
                if (dBw != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dBw.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.mXw, listItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.mXg != null) {
            Point he = tv.chushou.zues.utils.a.he(this.mXw);
            int i = he.x > he.y ? 1 : 2;
            if (this.mYm == null) {
                this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYm.setPlayerViewHelper(this.mXv);
            this.mYm.setVisibility(0);
            this.mYm.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dCG() {
        HashMap e;
        if (this.mXv != null && (e = this.mXv.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.mYm != null) {
            this.mYm.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.mXX == null && this.mXY == null) {
            if (this.mXv.mQe != null) {
                ChatInfo dBs = this.mXv.mQe.dBs();
                if (dBs == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.mYn == null) {
                    this.mYn = (RelativeLayout) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dBs.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dBs.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dBs.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dBs.mAnimSubType > 0) {
                    dBs.mAnimType = dBs.mAnimSubType;
                }
                if (dBs.mAnimationPluginId == 1) {
                    this.mXX = com.kascend.chushou.toolkit.d.a.dDc().a(this.mXw, String.valueOf(dBs.mAnimType), this.mYn, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.dCE() && g.this.mXX != null && g.this.mYn != null) {
                                Object tag = g.this.mXX.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dDc().a(g.this.mXw, String.valueOf(((ChatInfo) tag).mAnimType), g.this.mYn, g.this.mXX);
                                }
                                if (!z) {
                                    g.this.mXX.setVisibility(8);
                                    g.this.mYn.removeView(g.this.mXX);
                                    g.this.mXX = null;
                                    if (g.this.mXx != null) {
                                        g.this.mXx.removeMessages(11);
                                        g.this.mXx.L(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.mXX = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dBs.mJsonData);
                } else if (dBs.mAnimationPluginId == 2) {
                    if (this.mXY == null && this.mYn != null) {
                        this.mXY = (SVGAImageView) this.mYn.findViewById(a.f.svgaView);
                        if (this.mXY == null) {
                            this.mXY = new SVGAImageView(this.mXw);
                            this.mXY.setClearsAfterStop(true);
                            this.mXY.setLoops(1);
                            this.mXY.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.mYn.addView(this.mXY, layoutParams);
                        }
                    }
                    if (this.mXY == null) {
                        cVar.removeMessages(11);
                        cVar.L(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dDc().a(this.mXw, String.valueOf(dBs.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.mXY.stopAnimation();
                            g.this.mXY.clearAnimation();
                            g.this.mXY.setVisibility(8);
                            g.this.mXY = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onFinished() {
                            g.this.mXY.stopAnimation();
                            g.this.mXY.clearAnimation();
                            g.this.mXY.setVisibility(8);
                            g.this.mXY = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Ea() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.mXY, dBs);
                }
                if (this.mXX != null) {
                    this.mXX.setTag(dBs);
                    return;
                }
                return;
            }
            return;
        }
        cVar.removeMessages(11);
        cVar.L(11, 800L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(tv.chushou.zues.c cVar) {
        if (this.mXZ == null) {
            if (this.mXv.mQe != null) {
                int g = this.mXv.mQe.g();
                ChatInfo dBt = this.mXv.mQe.dBt();
                if (dBt == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dBt, g);
                    return;
                }
            }
            return;
        }
        cVar.removeMessages(12);
        cVar.L(12, 800L);
    }

    private void a(final ChatInfo chatInfo, final int i) {
        int i2;
        if (this.mXZ != null || getContext() == null) {
            if (this.mXx != null) {
                this.mXx.removeMessages(12);
                this.mXx.L(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.mXZ = this.mXg.findViewById(a.f.rl_show_tip);
            if (this.mXZ != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dAD().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXw);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mXZ.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.mXw, 5.0f);
                    this.mXZ.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.mXZ = this.mXg.findViewById(a.f.rl_tip);
        }
        if (this.mXZ != null) {
            this.mXZ.setVisibility(0);
            this.mXZ.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mXv != null) {
                            RoomInfo dBw = g.this.mXv.dBw();
                            if (dBw != null) {
                                str = dBw.mRoomID;
                            }
                            if (dBw != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dBw.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mXw, chatInfo.mItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.mXZ.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.mXZ.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mXv != null) {
                            RoomInfo dBw = g.this.mXv.dBw();
                            if (dBw != null) {
                                str = dBw.mRoomID;
                            }
                            if (dBw != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dBw.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mXw, chatInfo.mItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.mXw.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mXw, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mXw, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0682a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.he(getContext()).x;
                if (this.mXw.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mXw, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mXw, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0682a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.mXZ.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.mXZ != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.mXZ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.mXZ.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.mYk == null) {
                                g.this.mYk = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.mYk.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.mYk.removeAllListeners();
                            }
                            g.this.mYk.playTogether(ObjectAnimator.ofFloat(g.this.mXZ, "translationX", g.this.mXZ.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.mYk.start();
                            if (g.this.mXx != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.mXx.L(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void cWt() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!dCE() && this.mXZ != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.mXZ, "translationX", 0.0f, 10.0f, -this.mXZ.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.dCE()) {
                        if (g.this.mXZ != null) {
                            g.this.mXZ.setVisibility(8);
                        }
                        g.this.mXZ = null;
                        if (g.this.mXx != null) {
                            g.this.mXx.L(12, 800L);
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
            if (this.mYk == null) {
                this.mYk = new AnimatorSet();
            }
            this.mYk.playTogether(duration);
            this.mYk.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cWu() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.mXw).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.mYa = new EmanateView(this.mXw);
            this.mYa.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.mYa);
            return;
        }
        this.mYa = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.mYb == null) {
            this.mYb = (RoomSendGiftView) this.mXg.findViewById(a.f.normalSendGiftView);
            this.mYb.setContext(this.mXw);
            if (this.mXv != null) {
                this.mYb.a(this.mXv.dBu());
            }
            this.mYb.a(z, z2);
            this.mYb.setVisibilityListener(this.mYl);
            this.mYb.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.mYa != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable SL = tv.chushou.zues.utils.h.SL(str);
                            if (SL == null) {
                                SL = tv.chushou.zues.utils.h.SN(str);
                            }
                            g.this.mYa.setDrawable(SL, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.mYa.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.mYa.dPp();
                        }
                    }
                }
            });
            this.mYb.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void b(ConfigDetail configDetail) {
                    if (configDetail != null) {
                        g.this.b(configDetail);
                    }
                }

                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void a(boolean z3, boolean z4) {
                    g.this.ar(z3, z4);
                }
            });
        }
        if (this.mYb != null) {
            if (this.mXv != null) {
                this.mYb.a(z ? this.mXv.mQk : this.mXv.mQl, this.mXv.mQm, this.mXv.mQn, z);
                this.mYb.setGiftTopIcon(this.mXv.s);
            }
            if (micMemberInfo != null) {
                this.mYb.setMicMemberInfo(micMemberInfo);
            }
            this.mYb.c();
        }
    }

    protected void ar(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.mYc.setProgress(i);
            if (!this.mYh) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.mYd.setText(this.mXw.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.mYd.setText(this.mXw.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.mYd.setText(this.mXw.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.mYe.bV(str, a.e.pao_circle_default);
            if (this.mYg != i) {
                this.mYe.startAnimation(AnimationUtils.loadAnimation(this.mXw, a.C0682a.pao_beat_anim));
                this.mYg = i;
            }
            if (this.aNY != bangInfo.mLevel) {
                if (this.mXx != null && !this.mXx.Od(17)) {
                    this.mXx.a(this.mXx.Oe(17), 500L);
                }
                this.aNY = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(boolean z) {
        int i;
        if (!this.mYf.b()) {
            WindowManager windowManager = (WindowManager) this.mXw.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                this.mYf.a(this.mXw, i, this.mXv.dBu().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.mYf.e();
        this.mYf.c();
    }

    public void dCH() {
        this.mYe.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.mYe.getWidth() / 2, this.mYe.getHeight() / 2);
        aVar.setDuration(1000L);
        this.mYe.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.mYj == null && this.mXw != null) {
            if ("3".equals(this.aw)) {
                z = h.dAK().b;
            } else if (this.mXv == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dAK().d;
            } else {
                z = h.dAK().e;
            }
            this.mYj = new CSDanmuLayout(this.mXw.getApplicationContext(), new a.C0794a().Oa(-16711936).NZ(800).wW(true).wX(this.ap >= 0).NY(2).dOm(), h.dAK().b());
            this.mYj.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.mXw);
            Point he = tv.chushou.zues.utils.a.he(this.mXw);
            switch (h.dAK().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.mXw.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mXA / 3;
                    } else {
                        layoutParams.height = he.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.mXw.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mXA / 3;
                    } else {
                        layoutParams.height = he.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dCF().addView(this.mYj, 1, layoutParams);
            if (this.mYj != null) {
                this.mYj.setVisibility(z ? 0 : 8);
            }
            q(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.mYj != null) {
            this.mYj.setVisibility(8);
            this.mYj.dOn();
        }
        if (this.mYj != null) {
            this.mYj.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void cWc() {
        if (this.mYj != null && this.mXv != null) {
            if (this.ap < 0) {
                this.mYj.setVisibility(h.dAK().d ? 0 : 8);
            } else {
                this.mYj.setVisibility(h.dAK().e ? 0 : 8);
            }
        }
        if (this.mYj != null && this.mYj.aGB() && !this.H && !this.al) {
            this.mYj.resume();
            this.mYj.dOn();
        }
    }

    protected void q(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.mYs == null) {
            if (this.mYq == null) {
                this.mYq = new ArrayList();
            }
            this.mYq.clear();
            aO(getString(a.i.danmu_settings_no_gift), false);
            aO(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.mXw).mOE != null) {
                if (this.mXv.dBu() != null) {
                    this.mYu = this.mXv.dBu().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.mYu)) {
                    aO(getString(a.i.danmu_settings_no_normal), true);
                    this.mYq.addAll(this.mYu);
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
            View inflate = LayoutInflater.from(this.mXw).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mXw));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.mYt = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.mXw).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mYt.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mYt.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.mYr = new com.kascend.chushou.player.adapter.b(i, this.mXw, this.mYq, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.mYr);
            if (!tv.chushou.zues.utils.h.isEmpty(this.mYu) && this.mYu.size() >= 5) {
                this.mYs = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXw, 165.0f), tv.chushou.zues.utils.a.dip2px(this.mXw, 354.0f));
            } else {
                this.mYs = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXw, 165.0f), -2);
            }
            this.mYs.setFocusable(true);
            this.mYs.setOutsideTouchable(true);
            this.mYs.setBackgroundDrawable(this.mXw.getResources().getDrawable(a.e.bg_room_pop));
            this.mYs.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dCI() {
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
        if (this.mYq != null) {
            this.mYq.add(privacyItem);
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
        if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "26", "chatType", str2, "chatState", str, "roomId", this.mXv.dBu().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.mYr.notifyDataSetChanged();
        dBU();
    }

    protected void dBU() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.dOY()) {
            tv.chushou.zues.utils.g.c(this.mXw, this.mXw.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dAG().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.mYr.notifyDataSetChanged();
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
                        g.this.mYr.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.mYr.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.mYq) {
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
                for (PrivacyItem privacyItem3 : this.mYq) {
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
            for (PrivacyItem privacyItem4 : this.mYq) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.mYw == null) {
            this.mYw = new ArrayList<>();
        }
        this.mYw.add(str);
        this.mYw.add(str2);
        p pVar = new p();
        pVar.a = this.mYw;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.mYw == null) {
            this.mYw = new ArrayList<>();
        }
        this.mYw.add(str);
        p pVar = new p();
        pVar.a = this.mYw;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.mYw != null) {
            this.mYw.remove(str);
            this.mYw.remove(str2);
            p pVar = new p();
            pVar.a = this.mYw;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.mYw != null) {
            this.mYw.remove(str);
            p pVar = new p();
            pVar.a = this.mYw;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dBO = dBO();
        if (dBO != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dBO.getLayoutParams();
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
            dBO.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MN(int i) {
        GiftAnimationLayout dBO = dBO();
        if (dBO != null) {
            dBO.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dAK().q()) {
                h.dAK().g(false);
                this.mXI.c();
                return;
            }
            h.dAK().g(true);
            this.mXI.b();
        } else if (id == a.f.rl_decode) {
            if (h.dAK().a) {
                h.dAK().a(this.mXw, false);
                this.mXK.c();
            } else {
                h.dAK().a(this.mXw, true);
                this.mXK.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.mXw, nL(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.mXw).q) {
                ((VideoPlayer) this.mXw).q = false;
                if (this.mXv.mQe != null) {
                    this.mXv.mQe.e();
                    this.mXv.mQe.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.mXG.c();
                return;
            }
            ((VideoPlayer) this.mXw).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.mXG.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dAK().o();
            if (this.ap < 0) {
                o = h.dAK().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dAK().b;
            }
            boolean z = !o;
            if (z) {
                this.mXL.b();
            } else {
                this.mXL.c();
            }
            if (!this.aw.equals("1")) {
                h.dAK().a(z);
            } else if (this.ap < 0) {
                h.dAK().e(z);
            } else {
                h.dAK().f(z);
            }
            switch (h.dAK().m()) {
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
            com.kascend.chushou.toolkit.a.c.d(this.mXw, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.mXw).q) {
                ((VideoPlayer) this.mXw).q = false;
                if (this.mXv.mQe != null) {
                    this.mXv.mQe.e();
                    this.mXv.mQe.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mYt.setImageResource(i);
            } else {
                ((VideoPlayer) this.mXw).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mYt.setImageResource(i2);
            }
            dBU();
        }
    }

    protected void r(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.mYm != null) {
            this.mYm.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dCe() {
        return null;
    }

    public GiftAnimationLayout dBO() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dCt() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dBw;
        if (this.mXv != null && (dBw = this.mXv.dBw()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dBw.mOnlineCount.equals(str2) || !dBw.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dBw.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dBw.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dCt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dAK().c(true);
        if (this.mYo == null) {
            a();
        }
        if (!this.mYo.isShowing()) {
            if (view != null) {
                this.mYo.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.mXw, 3.0f), (this.mXg.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.mXw, 8.0f));
                RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.mYo != null) {
                            g.this.mYo.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.mYo.dismiss();
    }

    private void a() {
        if (this.mYo == null) {
            View inflate = LayoutInflater.from(this.mXw).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.mXw.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.mXw.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.mYo = new PopupWindow(inflate, -2, -2);
            this.mYo.setFocusable(true);
            this.mYo.setOutsideTouchable(true);
            this.mYo.setAnimationStyle(a.j.gift_toast_style);
            this.mYo.update();
            this.mYo.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.mYo = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
