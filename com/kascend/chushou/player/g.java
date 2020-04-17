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
    protected RelativeLayout mwI;
    protected RelativeLayout mwJ;
    protected OnlineToggleButton mwK;
    protected RelativeLayout mwL;
    protected OnlineToggleButton mwM;
    protected RelativeLayout mwN;
    protected OnlineToggleButton mwO;
    protected OnlineToggleButton mwP;
    protected LinearLayout mwQ;
    protected PopupWindow mwR;
    protected PopupWindow mwS;
    protected PopupWindow mwT;
    protected RecyclerView mwU;
    protected LinearLayoutManager mwV;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> mwW;
    protected ArrayList<a> mwX;
    protected ArrayList<a> mwY;
    protected PopupWindow mwZ;
    protected ArrayList<String> mxA;
    protected View mxb;
    protected SVGAImageView mxc;
    protected View mxd;
    protected EmanateView mxe;
    protected RoomSendGiftView mxf;
    protected RoundProgressBar mxg;
    protected TextView mxh;
    protected FrescoThumbnailView mxi;
    protected PaoGuideView mxj;
    protected AnimatorSet mxo;
    protected KasBaseMenuView.a mxp;
    protected H5Container mxq;
    protected RelativeLayout mxr;
    protected PopupWindow mxs;
    protected PopupWindow mxt;
    protected List<PrivacyItem> mxu;
    protected com.kascend.chushou.player.adapter.b mxv;
    protected PopupWindow mxw;
    protected ImageView mxx;
    protected List<PrivacyItem> mxy;
    protected FrescoThumbnailView mxz;
    protected boolean mxa = false;
    protected int boO = 0;
    protected long mxk = 0;
    protected boolean mxl = false;
    protected IconConfig.Config mxm = new IconConfig.Config();
    protected CSDanmuLayout mxn = null;
    protected boolean bi = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.dyq() && g.this.mwU != null && g.this.mwW != null && g.this.mwV != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.mwV.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.mwV.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.mwV.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.mwV.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.mwV.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.mwU.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.mwA != null) {
                                    g.this.mwA.N(g.this.d);
                                    if (g.this.b) {
                                        g.this.mwA.e(g.this.d, 1000L);
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
    public RelativeLayout dyr() {
        if (this.mwI == null) {
            this.mwI = (RelativeLayout) this.mwj.findViewById(a.f.video_root_view);
        }
        return this.mwI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(View view, int i, int i2) {
        if (!this.bi) {
            ag();
        }
        ah();
        if (this.mwR != null) {
            if (!this.mwR.isShowing()) {
                this.mwR.showAtLocation(view, 53, i, i2);
            } else {
                this.mwR.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point gh = tv.chushou.zues.utils.a.gh(this.mwz);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dwK().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dwK().b(1);
                layoutParams.width = -1;
                if (this.mwz.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mwD / 3;
                } else {
                    layoutParams.height = gh.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dwK().b(2);
                layoutParams.width = -1;
                if (this.mwz.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mwD / 3;
                } else {
                    layoutParams.height = gh.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.mxn != null) {
            this.mxn.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(View view, int i, int i2) {
        ae();
        if (this.mwS != null) {
            if (!this.mwS.isShowing()) {
                if (this.mwz.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.mwS.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.mwS.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.mwS.showAtLocation(view, 53, i, i2);
                return;
            }
            this.mwS.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.mwz.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.mwz).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.mwP = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dwK().b) {
                this.mwP.b();
            } else {
                this.mwP.c();
            }
        } else if (this.ap < 0) {
            if (h.dwK().n()) {
                this.mwP.b();
            } else {
                this.mwP.c();
            }
        } else if (h.dwK().o()) {
            this.mwP.b();
        } else {
            this.mwP.c();
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
        switch (h.dwK().m()) {
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
        if (this.mwz.getResources().getConfiguration().orientation == 1) {
            this.mwS = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwz, 230.0f), -2);
            this.mwS.setBackgroundDrawable(this.mwz.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.mwS = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwz, 295.0f), -1);
            this.mwS.setClippingEnabled(false);
            this.mwS.setBackgroundDrawable(this.mwz.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.mwS.setFocusable(true);
        this.mwS.setOutsideTouchable(true);
        this.mwS.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dwK().a(true);
        } else if (this.ap < 0) {
            h.dwK().e(true);
        } else {
            h.dwK().f(true);
        }
        switch (h.dwK().m()) {
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
            if (this.mwz.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.mwz).inflate(i2, (ViewGroup) null);
            this.mwQ = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.mwJ = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.mwK = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.mwL = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.mwM = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.mwN = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mwO = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.mwz.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwz);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.C(10.0f);
                }
                this.mwQ.setPadding(this.mwQ.getPaddingLeft(), statusBarHeight, this.mwQ.getPaddingRight(), this.mwQ.getPaddingBottom());
            }
            this.mwJ.setOnClickListener(this);
            this.mwL.setOnClickListener(this);
            this.mwN.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.mwJ.setVisibility(8);
            } else {
                this.mwJ.setVisibility(0);
            }
            if (((VideoPlayer) this.mwz).q) {
                this.mwK.b();
            } else {
                this.mwK.c();
            }
            if (h.dwK().q()) {
                this.mwM.b();
            } else {
                this.mwM.c();
            }
            if (com.kascend.chushou.c.a) {
                this.mwN.setVisibility(0);
            } else {
                this.mwN.setVisibility(8);
            }
            if (h.dwK().a) {
                this.mwO.b();
            } else {
                this.mwO.c();
            }
            if (this.mwy != null && (arrayList = this.mwy.f) != null && arrayList.size() > 0) {
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
                            if (this.mwz.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.mwz).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dxw = this.mwy.dxw();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mwz).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.mwz.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.mwz).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mwz, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mwz, 6.0f);
                                    }
                                    int identifier = this.mwz.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mwz.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mwQ, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dxw != null && dxw.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.mwQ.addView(inflate2);
                            this.bi = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.mwz.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.mwz).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dxw2 = this.mwy.dxw();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mwz).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.mwz.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.mwz).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mwz, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mwz, 6.0f);
                                    }
                                    int identifier2 = this.mwz.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mwz.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mwQ, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dxw2 != null && dxw2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.mwQ.addView(inflate3);
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
            if (this.mwz.getResources().getConfiguration().orientation == 1) {
                this.mwR = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwz, 230.0f), -2);
                this.mwR.setBackgroundDrawable(this.mwz.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.mwR = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwz, 295.0f), -1);
                this.mwR.setClippingEnabled(false);
                this.mwR.setBackgroundDrawable(this.mwz.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.mwR.setFocusable(true);
            this.mwR.setOutsideTouchable(true);
            this.mwR.update();
        }
    }

    protected void ah() {
        if (this.mwL != null && this.mwM != null) {
            this.mwL.setVisibility(0);
            if (h.dwK().q()) {
                this.mwM.b();
            } else {
                this.mwM.c();
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
        com.kascend.chushou.toolkit.a.c.a(this.mwz, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.mwy.f;
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
            if (this.mwQ == null) {
                this.mwy.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.mwy.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.mwz).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mwQ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mwQ.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mwz.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mwz.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mwQ, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.mwz, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.mwy.f;
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
            if (this.mwQ == null) {
                if (!z) {
                    this.mwy.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.mwy.a(playUrl);
                if (this.ap >= 0) {
                    this.mwy.a(false);
                    if (this.mwz != null) {
                        ((VideoPlayer) this.mwz).a(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.mwz).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mwQ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mwQ.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mwz.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mwz.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mwQ, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.mwR != null) {
            this.mwR.dismiss();
        }
        if (this.mwT != null) {
            this.mwT.dismiss();
        }
        PlayUrl dxw = this.mwy.dxw();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.mwy.d) {
                this.mwy.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.mwy.a(playUrl);
                this.mwy.a(false);
                if (this.mwz != null) {
                    ((VideoPlayer) this.mwz).a(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.mwy.d) {
            this.mwy.e = true;
        }
        h.dwK().a(this.mwz, urlDetails.mDefinitionType);
        if (z || (dxw != null && !dxw.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.mwz, dyp(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.mwy.a(playUrl);
            if (dyp()) {
                if (((VideoPlayer) this.mwz) != null) {
                    ((VideoPlayer) this.mwz).r = -1L;
                }
                if (this.msP != null) {
                    this.lOx = this.msP.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.mwz).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.mwF = str2;
        if (this.mwA != null) {
            this.mwA.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.mxa = true;
            if (this.mwY == null) {
                this.mwY = new ArrayList<>();
            }
            this.mwY.clear();
            this.mwY.addAll(list);
            this.mwZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.mwZ == null) {
            View inflate = LayoutInflater.from(this.mwz).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.mwz.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.mwz.getResources().getColor(a.c.player_bg_color));
            }
            if (this.mxa && !tv.chushou.zues.utils.h.isEmpty(this.mwY)) {
                this.mwX = this.mwY;
            } else {
                this.mwX = (ArrayList) h.dwK().dwM();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.mwX)) {
                String[] stringArray = this.mwz.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.mwz.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.mwX == null) {
                    this.mwX = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.mwX.add(aVar);
                }
            }
            this.mwU = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.mwW = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.mwX, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void B(View view, int i4) {
                    a aVar2;
                    if (g.this.mwZ != null) {
                        g.this.mwZ.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.mwX) && i4 < g.this.mwX.size() && (aVar2 = g.this.mwX.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.mxa) {
                            g.this.mwX.remove(i4);
                            g.this.mwX.add(0, aVar2);
                            g.this.mwW.notifyDataSetChanged();
                            g.this.mwU.scrollToPosition(0);
                            RxExecutor.post(g.this.mwi, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dwK().a((Object) g.this.mwX);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.mwz, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.mwy != null && g.this.mwy.dxv() != null && g.this.mwy.dxv().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.mwy.dxv().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0837a view$OnLongClickListenerC0837a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0837a.a(a.f.tv_name, g.this.mwz.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0837a.a(a.f.tv_name, g.this.mwz.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0837a.a(a.f.tv_name, g.this.mwz.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0837a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.mwV = new LinearLayoutManager(this.mwz);
            this.mwU.setLayoutManager(this.mwV);
            this.mwU.setAdapter(this.mwW);
            this.mwU.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.mwZ = new PopupWindow(inflate, this.mwz.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.mwz.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.mwZ.setFocusable(true);
            this.mwZ.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.mwZ.setBackgroundDrawable(this.mwz.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.mwZ.setBackgroundDrawable(this.mwz.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.mwZ.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.mwA.N(this.d);
        this.mwA.p(this.d);
    }

    protected void an() {
        this.b = true;
        this.mwA.N(this.d);
        this.mwA.e(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.mwA != null) {
            this.mwA.N(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bo(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.mwy != null) {
                RoomInfo dxz = this.mwy.dxz();
                if (dxz != null) {
                    str = dxz.mRoomID;
                }
                if (dxz != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dxz.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.mwz, listItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.mwj != null) {
            Point gh = tv.chushou.zues.utils.a.gh(this.mwz);
            int i = gh.x > gh.y ? 1 : 2;
            if (this.mxq == null) {
                this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mxq.setPlayerViewHelper(this.mwy);
            this.mxq.setVisibility(0);
            this.mxq.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.mwy != null && (e = this.mwy.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.mxq != null) {
            this.mxq.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.mxb == null && this.mxc == null) {
            if (this.mwy.mpt != null) {
                ChatInfo dxt = this.mwy.mpt.dxt();
                if (dxt == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.mxr == null) {
                    this.mxr = (RelativeLayout) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dxt.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dxt.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dxt.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dxt.mAnimSubType > 0) {
                    dxt.mAnimType = dxt.mAnimSubType;
                }
                if (dxt.mAnimationPluginId == 1) {
                    this.mxb = com.kascend.chushou.toolkit.d.a.dyO().a(this.mwz, String.valueOf(dxt.mAnimType), this.mxr, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.dyq() && g.this.mxb != null && g.this.mxr != null) {
                                Object tag = g.this.mxb.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dyO().a(g.this.mwz, String.valueOf(((ChatInfo) tag).mAnimType), g.this.mxr, g.this.mxb);
                                }
                                if (!z) {
                                    g.this.mxb.setVisibility(8);
                                    g.this.mxr.removeView(g.this.mxb);
                                    g.this.mxb = null;
                                    if (g.this.mwA != null) {
                                        g.this.mwA.removeMessages(11);
                                        g.this.mwA.A(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.mxb = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dxt.mJsonData);
                } else if (dxt.mAnimationPluginId == 2) {
                    if (this.mxc == null && this.mxr != null) {
                        this.mxc = (SVGAImageView) this.mxr.findViewById(a.f.svgaView);
                        if (this.mxc == null) {
                            this.mxc = new SVGAImageView(this.mwz);
                            this.mxc.setClearsAfterStop(true);
                            this.mxc.setLoops(1);
                            this.mxc.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.mxr.addView(this.mxc, layoutParams);
                        }
                    }
                    if (this.mxc == null) {
                        cVar.removeMessages(11);
                        cVar.A(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dyO().a(this.mwz, String.valueOf(dxt.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.mxc.stopAnimation();
                            g.this.mxc.clearAnimation();
                            g.this.mxc.setVisibility(8);
                            g.this.mxc = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onFinished() {
                            g.this.mxc.stopAnimation();
                            g.this.mxc.clearAnimation();
                            g.this.mxc.setVisibility(8);
                            g.this.mxc = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Oj() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.mxc, dxt);
                }
                if (this.mxb != null) {
                    this.mxb.setTag(dxt);
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
        if (this.mxd == null) {
            if (this.mwy.mpt != null) {
                int g = this.mwy.mpt.g();
                ChatInfo dxu = this.mwy.mpt.dxu();
                if (dxu == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dxu, g);
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
        if (this.mxd != null || getContext() == null) {
            if (this.mwA != null) {
                this.mwA.removeMessages(12);
                this.mwA.A(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.mxd = this.mwj.findViewById(a.f.rl_show_tip);
            if (this.mxd != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dwD().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwz);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mxd.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.mwz, 5.0f);
                    this.mxd.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.mxd = this.mwj.findViewById(a.f.rl_tip);
        }
        if (this.mxd != null) {
            this.mxd.setVisibility(0);
            this.mxd.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mwy != null) {
                            RoomInfo dxz = g.this.mwy.dxz();
                            if (dxz != null) {
                                str = dxz.mRoomID;
                            }
                            if (dxz != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dxz.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mwz, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.mxd.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.mxd.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mwy != null) {
                            RoomInfo dxz = g.this.mwy.dxz();
                            if (dxz != null) {
                                str = dxz.mRoomID;
                            }
                            if (dxz != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dxz.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mwz, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.mwz.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mwz, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mwz, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0715a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.gh(getContext()).x;
                if (this.mwz.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mwz, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mwz, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0715a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.mxd.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.mxd != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.mxd.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.mxd.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.mxo == null) {
                                g.this.mxo = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.mxo.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.mxo.removeAllListeners();
                            }
                            g.this.mxo.playTogether(ObjectAnimator.ofFloat(g.this.mxd, "translationX", g.this.mxd.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.mxo.start();
                            if (g.this.mwA != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.mwA.A(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void dls() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!dyq() && this.mxd != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.mxd, "translationX", 0.0f, 10.0f, -this.mxd.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.dyq()) {
                        if (g.this.mxd != null) {
                            g.this.mxd.setVisibility(8);
                        }
                        g.this.mxd = null;
                        if (g.this.mwA != null) {
                            g.this.mwA.A(12, 800L);
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
            if (this.mxo == null) {
                this.mxo = new AnimatorSet();
            }
            this.mxo.playTogether(duration);
            this.mxo.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dlt() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.mwz).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.mxe = new EmanateView(this.mwz);
            this.mxe.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.mxe);
            return;
        }
        this.mxe = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.mxf == null) {
            this.mxf = (RoomSendGiftView) this.mwj.findViewById(a.f.normalSendGiftView);
            this.mxf.setContext(this.mwz);
            if (this.mwy != null) {
                this.mxf.a(this.mwy.dxv());
            }
            this.mxf.a(z, z2);
            this.mxf.setVisibilityListener(this.mxp);
            this.mxf.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.mxe != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable Qm = tv.chushou.zues.utils.h.Qm(str);
                            if (Qm == null) {
                                Qm = tv.chushou.zues.utils.h.Qo(str);
                            }
                            g.this.mxe.setDrawable(Qm, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.mxe.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.mxe.dKj();
                        }
                    }
                }
            });
            this.mxf.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void b(ConfigDetail configDetail) {
                    if (configDetail != null) {
                        g.this.b(configDetail);
                    }
                }

                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void a(boolean z3, boolean z4) {
                    g.this.aq(z3, z4);
                }
            });
        }
        if (this.mxf != null) {
            if (this.mwy != null) {
                this.mxf.a(z ? this.mwy.mpy : this.mwy.mpz, this.mwy.mpA, this.mwy.mpB, z);
                this.mxf.setGiftTopIcon(this.mwy.s);
            }
            if (micMemberInfo != null) {
                this.mxf.setMicMemberInfo(micMemberInfo);
            }
            this.mxf.c();
        }
    }

    protected void aq(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.mxg.setProgress(i);
            if (!this.mxl) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.mxh.setText(this.mwz.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.mxh.setText(this.mwz.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.mxh.setText(this.mwz.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.mxi.bU(str, a.e.pao_circle_default);
            if (this.mxk != i) {
                this.mxi.startAnimation(AnimationUtils.loadAnimation(this.mwz, a.C0715a.pao_beat_anim));
                this.mxk = i;
            }
            if (this.boO != bangInfo.mLevel) {
                if (this.mwA != null && !this.mwA.JG(17)) {
                    this.mwA.a(this.mwA.JH(17), 500L);
                }
                this.boO = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.mxj.b()) {
            WindowManager windowManager = (WindowManager) this.mwz.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                this.mxj.a(this.mwz, i, this.mwy.dxv().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.mxj.e();
        this.mxj.c();
    }

    public void dys() {
        this.mxi.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.mxi.getWidth() / 2, this.mxi.getHeight() / 2);
        aVar.setDuration(1000L);
        this.mxi.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.mxn == null && this.mwz != null) {
            if ("3".equals(this.aw)) {
                z = h.dwK().b;
            } else if (this.mwy == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dwK().d;
            } else {
                z = h.dwK().e;
            }
            this.mxn = new CSDanmuLayout(this.mwz.getApplicationContext(), new a.C0826a().JD(-16711936).JC(800).wM(true).wN(this.ap >= 0).JB(2).dJe(), h.dwK().b());
            this.mxn.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.mwz);
            Point gh = tv.chushou.zues.utils.a.gh(this.mwz);
            switch (h.dwK().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.mwz.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mwD / 3;
                    } else {
                        layoutParams.height = gh.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.mwz.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mwD / 3;
                    } else {
                        layoutParams.height = gh.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dyr().addView(this.mxn, 1, layoutParams);
            if (this.mxn != null) {
                this.mxn.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.mxn != null) {
            this.mxn.setVisibility(8);
            this.mxn.dJf();
        }
        if (this.mxn != null) {
            this.mxn.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dlc() {
        if (this.mxn != null && this.mwy != null) {
            if (this.ap < 0) {
                this.mxn.setVisibility(h.dwK().d ? 0 : 8);
            } else {
                this.mxn.setVisibility(h.dwK().e ? 0 : 8);
            }
        }
        if (this.mxn != null && this.mxn.isPrepared() && !this.H && !this.al) {
            this.mxn.resume();
            this.mxn.dJf();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.mxw == null) {
            if (this.mxu == null) {
                this.mxu = new ArrayList();
            }
            this.mxu.clear();
            aL(getString(a.i.danmu_settings_no_gift), false);
            aL(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.mwz).mnT != null) {
                if (this.mwy.dxv() != null) {
                    this.mxy = this.mwy.dxv().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.mxy)) {
                    aL(getString(a.i.danmu_settings_no_normal), true);
                    this.mxu.addAll(this.mxy);
                } else {
                    aL(getString(a.i.danmu_settings_no_normal), false);
                }
            } else {
                aL(getString(a.i.danmu_settings_no_normal), false);
            }
            if (i == 3) {
                i2 = a.h.pop_privacy_setting_black;
            } else {
                i2 = a.h.pop_privacy_setting;
            }
            View inflate = LayoutInflater.from(this.mwz).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mwz));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.mxx = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.mwz).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mxx.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mxx.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.mxv = new com.kascend.chushou.player.adapter.b(i, this.mwz, this.mxu, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.mxv);
            if (!tv.chushou.zues.utils.h.isEmpty(this.mxy) && this.mxy.size() >= 5) {
                this.mxw = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwz, 165.0f), tv.chushou.zues.utils.a.dip2px(this.mwz, 354.0f));
            } else {
                this.mxw = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwz, 165.0f), -2);
            }
            this.mxw.setFocusable(true);
            this.mxw.setOutsideTouchable(true);
            this.mxw.setBackgroundDrawable(this.mwz.getResources().getDrawable(a.e.bg_room_pop));
            this.mxw.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dyt() {
        i(2);
    }

    protected void aL(String str, boolean z) {
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
        if (this.mxu != null) {
            this.mxu.add(privacyItem);
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
        if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "26", "chatType", str2, "chatState", str, "roomId", this.mwy.dxv().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.mxv.notifyDataSetChanged();
        au();
    }

    protected void au() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.dJS()) {
            tv.chushou.zues.utils.g.c(this.mwz, this.mwz.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dwG().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.mxv.notifyDataSetChanged();
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
                        g.this.mxv.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.mxv.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.mxu) {
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
                for (PrivacyItem privacyItem3 : this.mxu) {
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
            for (PrivacyItem privacyItem4 : this.mxu) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.mxA == null) {
            this.mxA = new ArrayList<>();
        }
        this.mxA.add(str);
        this.mxA.add(str2);
        p pVar = new p();
        pVar.a = this.mxA;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.mxA == null) {
            this.mxA = new ArrayList<>();
        }
        this.mxA.add(str);
        p pVar = new p();
        pVar.a = this.mxA;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.mxA != null) {
            this.mxA.remove(str);
            this.mxA.remove(str2);
            p pVar = new p();
            pVar.a = this.mxA;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.mxA != null) {
            this.mxA.remove(str);
            p pVar = new p();
            pVar.a = this.mxA;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dxM = dxM();
        if (dxM != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dxM.getLayoutParams();
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
            dxM.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dxM = dxM();
        if (dxM != null) {
            dxM.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dwK().q()) {
                h.dwK().g(false);
                this.mwM.c();
                return;
            }
            h.dwK().g(true);
            this.mwM.b();
        } else if (id == a.f.rl_decode) {
            if (h.dwK().a) {
                h.dwK().a(this.mwz, false);
                this.mwO.c();
            } else {
                h.dwK().a(this.mwz, true);
                this.mwO.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.mwz, dyp(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.mwz).q) {
                ((VideoPlayer) this.mwz).q = false;
                if (this.mwy.mpt != null) {
                    this.mwy.mpt.e();
                    this.mwy.mpt.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.mwK.c();
                return;
            }
            ((VideoPlayer) this.mwz).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.mwK.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dwK().o();
            if (this.ap < 0) {
                o = h.dwK().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dwK().b;
            }
            boolean z = !o;
            if (z) {
                this.mwP.b();
            } else {
                this.mwP.c();
            }
            if (!this.aw.equals("1")) {
                h.dwK().a(z);
            } else if (this.ap < 0) {
                h.dwK().e(z);
            } else {
                h.dwK().f(z);
            }
            switch (h.dwK().m()) {
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
            com.kascend.chushou.toolkit.a.c.c(this.mwz, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.mwz).q) {
                ((VideoPlayer) this.mwz).q = false;
                if (this.mwy.mpt != null) {
                    this.mwy.mpt.e();
                    this.mwy.mpt.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mxx.setImageResource(i);
            } else {
                ((VideoPlayer) this.mwz).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mxx.setImageResource(i2);
            }
            au();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.mxq != null) {
            this.mxq.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0730a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dxW() {
        return null;
    }

    public GiftAnimationLayout dxM() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dyh() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dxz;
        if (this.mwy != null && (dxz = this.mwy.dxz()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dxz.mOnlineCount.equals(str2) || !dxz.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dxz.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dxz.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dyh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dwK().c(true);
        if (this.mxs == null) {
            a();
        }
        if (!this.mxs.isShowing()) {
            if (view != null) {
                this.mxs.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.mwz, 3.0f), (this.mwj.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.mwz, 8.0f));
                RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.mxs != null) {
                            g.this.mxs.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.mxs.dismiss();
    }

    private void a() {
        if (this.mxs == null) {
            View inflate = LayoutInflater.from(this.mwz).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.mwz.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.mwz.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.mxs = new PopupWindow(inflate, -2, -2);
            this.mxs.setFocusable(true);
            this.mxs.setOutsideTouchable(true);
            this.mxs.setAnimationStyle(a.j.gift_toast_style);
            this.mxs.update();
            this.mxs.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.mxs = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
