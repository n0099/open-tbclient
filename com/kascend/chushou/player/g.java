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
    protected RelativeLayout mXJ;
    protected RelativeLayout mXK;
    protected OnlineToggleButton mXL;
    protected RelativeLayout mXM;
    protected OnlineToggleButton mXN;
    protected RelativeLayout mXO;
    protected OnlineToggleButton mXP;
    protected OnlineToggleButton mXQ;
    protected LinearLayout mXR;
    protected PopupWindow mXS;
    protected PopupWindow mXT;
    protected PopupWindow mXU;
    protected RecyclerView mXV;
    protected LinearLayoutManager mXW;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> mXX;
    protected ArrayList<a> mXY;
    protected ArrayList<a> mXZ;
    protected FrescoThumbnailView mYA;
    protected ArrayList<String> mYB;
    protected PopupWindow mYa;
    protected View mYc;
    protected SVGAImageView mYd;
    protected View mYe;
    protected EmanateView mYf;
    protected RoomSendGiftView mYg;
    protected RoundProgressBar mYh;
    protected TextView mYi;
    protected FrescoThumbnailView mYj;
    protected PaoGuideView mYk;
    protected AnimatorSet mYp;
    protected KasBaseMenuView.a mYq;
    protected H5Container mYr;
    protected RelativeLayout mYs;
    protected PopupWindow mYt;
    protected PopupWindow mYu;
    protected List<PrivacyItem> mYv;
    protected com.kascend.chushou.player.adapter.b mYw;
    protected PopupWindow mYx;
    protected ImageView mYy;
    protected List<PrivacyItem> mYz;
    protected boolean mYb = false;
    protected int aNY = 0;
    protected long mYl = 0;
    protected boolean mYm = false;
    protected IconConfig.Config mYn = new IconConfig.Config();
    protected CSDanmuLayout mYo = null;
    protected boolean bi = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.dCG() && g.this.mXV != null && g.this.mXX != null && g.this.mXW != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.mXW.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.mXW.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.mXW.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.mXW.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.mXW.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.mXV.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.mXC != null) {
                                    g.this.mXC.removeCallbacks(g.this.d);
                                    if (g.this.b) {
                                        g.this.mXC.d(g.this.d, 1000L);
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
    public RelativeLayout dCH() {
        if (this.mXJ == null) {
            this.mXJ = (RelativeLayout) this.mXl.findViewById(a.f.video_root_view);
        }
        return this.mXJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(View view, int i, int i2) {
        if (!this.bi) {
            ag();
        }
        ah();
        if (this.mXS != null) {
            if (!this.mXS.isShowing()) {
                this.mXS.showAtLocation(view, 53, i, i2);
            } else {
                this.mXS.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point he = tv.chushou.zues.utils.a.he(this.mXB);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dAM().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dAM().b(1);
                layoutParams.width = -1;
                if (this.mXB.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mXF / 3;
                } else {
                    layoutParams.height = he.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dAM().b(2);
                layoutParams.width = -1;
                if (this.mXB.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mXF / 3;
                } else {
                    layoutParams.height = he.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.mYo != null) {
            this.mYo.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(View view, int i, int i2) {
        ae();
        if (this.mXT != null) {
            if (!this.mXT.isShowing()) {
                if (this.mXB.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.mXT.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.mXT.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.mXT.showAtLocation(view, 53, i, i2);
                return;
            }
            this.mXT.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.mXB.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.mXB).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.mXQ = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dAM().b) {
                this.mXQ.b();
            } else {
                this.mXQ.c();
            }
        } else if (this.ap < 0) {
            if (h.dAM().n()) {
                this.mXQ.b();
            } else {
                this.mXQ.c();
            }
        } else if (h.dAM().o()) {
            this.mXQ.b();
        } else {
            this.mXQ.c();
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
        switch (h.dAM().m()) {
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
        if (this.mXB.getResources().getConfiguration().orientation == 1) {
            this.mXT = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXB, 230.0f), -2);
            this.mXT.setBackgroundDrawable(this.mXB.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.mXT = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXB, 295.0f), -1);
            this.mXT.setClippingEnabled(false);
            this.mXT.setBackgroundDrawable(this.mXB.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.mXT.setFocusable(true);
        this.mXT.setOutsideTouchable(true);
        this.mXT.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dAM().a(true);
        } else if (this.ap < 0) {
            h.dAM().e(true);
        } else {
            h.dAM().f(true);
        }
        switch (h.dAM().m()) {
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
            if (this.mXB.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.mXB).inflate(i2, (ViewGroup) null);
            this.mXR = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.mXK = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.mXL = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.mXM = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.mXN = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.mXO = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mXP = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.mXK.setOnClickListener(this);
            this.mXM.setOnClickListener(this);
            this.mXO.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.mXK.setVisibility(8);
            } else {
                this.mXK.setVisibility(0);
            }
            if (((VideoPlayer) this.mXB).q) {
                this.mXL.b();
            } else {
                this.mXL.c();
            }
            if (h.dAM().q()) {
                this.mXN.b();
            } else {
                this.mXN.c();
            }
            if (com.kascend.chushou.c.a) {
                this.mXO.setVisibility(0);
            } else {
                this.mXO.setVisibility(8);
            }
            if (h.dAM().a) {
                this.mXP.b();
            } else {
                this.mXP.c();
            }
            if (this.mXA != null && (arrayList = this.mXA.f) != null && arrayList.size() > 0) {
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
                            if (this.mXB.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.mXB).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dBx = this.mXA.dBx();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mXB).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.mXB.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.mXB).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mXB, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mXB, 6.0f);
                                    }
                                    int identifier = this.mXB.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mXB.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mXR, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dBx != null && dBx.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.mXR.addView(inflate2);
                            this.bi = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.mXB.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.mXB).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dBx2 = this.mXA.dBx();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mXB).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.mXB.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.mXB).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mXB, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mXB, 6.0f);
                                    }
                                    int identifier2 = this.mXB.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mXB.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mXR, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dBx2 != null && dBx2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.mXR.addView(inflate3);
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
            if (this.mXB.getResources().getConfiguration().orientation == 1) {
                this.mXS = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXB, 230.0f), -2);
                this.mXS.setBackgroundDrawable(this.mXB.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.mXS = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXB, 295.0f), -1);
                this.mXS.setClippingEnabled(false);
                this.mXS.setBackgroundDrawable(this.mXB.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.mXS.setFocusable(true);
            this.mXS.setOutsideTouchable(true);
            this.mXS.update();
        }
    }

    protected void ah() {
        if (this.mXM != null && this.mXN != null) {
            this.mXM.setVisibility(0);
            if (h.dAM().q()) {
                this.mXN.b();
            } else {
                this.mXN.c();
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
        com.kascend.chushou.toolkit.a.c.a(this.mXB, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.mXA.f;
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
            if (this.mXR == null) {
                this.mXA.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.mXA.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.mXB).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mXR.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mXR.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mXB.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mXB.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mXR, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.mXB, "点击音视切换_num", "视频切音频", new Object[0]);
        o(false);
    }

    protected void o(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.mXA.f;
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
            if (this.mXR == null) {
                if (!z) {
                    this.mXA.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.mXA.a(playUrl);
                if (this.ap >= 0) {
                    this.mXA.a(false);
                    if (this.mXB != null) {
                        ((VideoPlayer) this.mXB).a(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.mXB).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mXR.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mXR.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mXB.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mXB.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mXR, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.mXS != null) {
            this.mXS.dismiss();
        }
        if (this.mXU != null) {
            this.mXU.dismiss();
        }
        PlayUrl dBx = this.mXA.dBx();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.mXA.d) {
                this.mXA.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.mXA.a(playUrl);
                this.mXA.a(false);
                if (this.mXB != null) {
                    ((VideoPlayer) this.mXB).a(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.mXA.d) {
            this.mXA.e = true;
        }
        h.dAM().a(this.mXB, urlDetails.mDefinitionType);
        if (z || (dBx != null && !dBx.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.f(this.mXB, nL(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.mXA.a(playUrl);
            if (nL()) {
                if (((VideoPlayer) this.mXB) != null) {
                    ((VideoPlayer) this.mXB).r = -1L;
                }
                if (this.mTO != null) {
                    this.kVw = this.mTO.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.mXB).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.mXG = str2;
        if (this.mXC != null) {
            this.mXC.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.mYb = true;
            if (this.mXZ == null) {
                this.mXZ = new ArrayList<>();
            }
            this.mXZ.clear();
            this.mXZ.addAll(list);
            this.mYa = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.mYa == null) {
            View inflate = LayoutInflater.from(this.mXB).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.mXB.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.mXB.getResources().getColor(a.c.player_bg_color));
            }
            if (this.mYb && !tv.chushou.zues.utils.h.isEmpty(this.mXZ)) {
                this.mXY = this.mXZ;
            } else {
                this.mXY = (ArrayList) h.dAM().dAO();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.mXY)) {
                String[] stringArray = this.mXB.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.mXB.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.mXY == null) {
                    this.mXY = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.mXY.add(aVar);
                }
            }
            this.mXV = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.mXX = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.mXY, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void onItemClick(View view, int i4) {
                    a aVar2;
                    if (g.this.mYa != null) {
                        g.this.mYa.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.mXY) && i4 < g.this.mXY.size() && (aVar2 = g.this.mXY.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.mYb) {
                            g.this.mXY.remove(i4);
                            g.this.mXY.add(0, aVar2);
                            g.this.mXX.notifyDataSetChanged();
                            g.this.mXV.scrollToPosition(0);
                            RxExecutor.post(g.this.mXk, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dAM().a((Object) g.this.mXY);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.mXB, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.mXA != null && g.this.mXA.dBw() != null && g.this.mXA.dBw().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.mXA.dBw().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0805a view$OnLongClickListenerC0805a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0805a.a(a.f.tv_name, g.this.mXB.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0805a.a(a.f.tv_name, g.this.mXB.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0805a.a(a.f.tv_name, g.this.mXB.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0805a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.mXW = new LinearLayoutManager(this.mXB);
            this.mXV.setLayoutManager(this.mXW);
            this.mXV.setAdapter(this.mXX);
            this.mXV.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.mYa = new PopupWindow(inflate, this.mXB.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.mXB.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.mYa.setFocusable(true);
            this.mYa.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.mYa.setBackgroundDrawable(this.mXB.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.mYa.setBackgroundDrawable(this.mXB.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.mYa.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.mXC.removeCallbacks(this.d);
        this.mXC.m(this.d);
    }

    protected void an() {
        this.b = true;
        this.mXC.removeCallbacks(this.d);
        this.mXC.d(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.mXC != null) {
            this.mXC.removeCallbacks(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bD(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.mXA != null) {
                RoomInfo dBy = this.mXA.dBy();
                if (dBy != null) {
                    str = dBy.mRoomID;
                }
                if (dBy != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dBy.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.mXB, listItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.mXl != null) {
            Point he = tv.chushou.zues.utils.a.he(this.mXB);
            int i = he.x > he.y ? 1 : 2;
            if (this.mYr == null) {
                this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYr.setPlayerViewHelper(this.mXA);
            this.mYr.setVisibility(0);
            this.mYr.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dCI() {
        HashMap e;
        if (this.mXA != null && (e = this.mXA.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.mYr != null) {
            this.mYr.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.mYc == null && this.mYd == null) {
            if (this.mXA.mQj != null) {
                ChatInfo dBu = this.mXA.mQj.dBu();
                if (dBu == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.mYs == null) {
                    this.mYs = (RelativeLayout) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dBu.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dBu.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dBu.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dBu.mAnimSubType > 0) {
                    dBu.mAnimType = dBu.mAnimSubType;
                }
                if (dBu.mAnimationPluginId == 1) {
                    this.mYc = com.kascend.chushou.toolkit.d.a.dDe().a(this.mXB, String.valueOf(dBu.mAnimType), this.mYs, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.dCG() && g.this.mYc != null && g.this.mYs != null) {
                                Object tag = g.this.mYc.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dDe().a(g.this.mXB, String.valueOf(((ChatInfo) tag).mAnimType), g.this.mYs, g.this.mYc);
                                }
                                if (!z) {
                                    g.this.mYc.setVisibility(8);
                                    g.this.mYs.removeView(g.this.mYc);
                                    g.this.mYc = null;
                                    if (g.this.mXC != null) {
                                        g.this.mXC.removeMessages(11);
                                        g.this.mXC.L(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.mYc = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dBu.mJsonData);
                } else if (dBu.mAnimationPluginId == 2) {
                    if (this.mYd == null && this.mYs != null) {
                        this.mYd = (SVGAImageView) this.mYs.findViewById(a.f.svgaView);
                        if (this.mYd == null) {
                            this.mYd = new SVGAImageView(this.mXB);
                            this.mYd.setClearsAfterStop(true);
                            this.mYd.setLoops(1);
                            this.mYd.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.mYs.addView(this.mYd, layoutParams);
                        }
                    }
                    if (this.mYd == null) {
                        cVar.removeMessages(11);
                        cVar.L(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dDe().a(this.mXB, String.valueOf(dBu.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.mYd.stopAnimation();
                            g.this.mYd.clearAnimation();
                            g.this.mYd.setVisibility(8);
                            g.this.mYd = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onFinished() {
                            g.this.mYd.stopAnimation();
                            g.this.mYd.clearAnimation();
                            g.this.mYd.setVisibility(8);
                            g.this.mYd = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Ea() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.mYd, dBu);
                }
                if (this.mYc != null) {
                    this.mYc.setTag(dBu);
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
        if (this.mYe == null) {
            if (this.mXA.mQj != null) {
                int g = this.mXA.mQj.g();
                ChatInfo dBv = this.mXA.mQj.dBv();
                if (dBv == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dBv, g);
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
        if (this.mYe != null || getContext() == null) {
            if (this.mXC != null) {
                this.mXC.removeMessages(12);
                this.mXC.L(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.mYe = this.mXl.findViewById(a.f.rl_show_tip);
            if (this.mYe != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dAF().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXB);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mYe.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.mXB, 5.0f);
                    this.mYe.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.mYe = this.mXl.findViewById(a.f.rl_tip);
        }
        if (this.mYe != null) {
            this.mYe.setVisibility(0);
            this.mYe.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mXA != null) {
                            RoomInfo dBy = g.this.mXA.dBy();
                            if (dBy != null) {
                                str = dBy.mRoomID;
                            }
                            if (dBy != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dBy.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mXB, chatInfo.mItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.mYe.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.mYe.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mXA != null) {
                            RoomInfo dBy = g.this.mXA.dBy();
                            if (dBy != null) {
                                str = dBy.mRoomID;
                            }
                            if (dBy != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dBy.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mXB, chatInfo.mItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.mXB.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mXB, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mXB, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                if (this.mXB.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mXB, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mXB, a.c.black), simpleDraweeSpanTextView)) {
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
            ViewTreeObserver viewTreeObserver = this.mYe.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.mYe != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.mYe.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.mYe.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.mYp == null) {
                                g.this.mYp = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.mYp.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.mYp.removeAllListeners();
                            }
                            g.this.mYp.playTogether(ObjectAnimator.ofFloat(g.this.mYe, "translationX", g.this.mYe.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.mYp.start();
                            if (g.this.mXC != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.mXC.L(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void cWv() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!dCG() && this.mYe != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.mYe, "translationX", 0.0f, 10.0f, -this.mYe.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.dCG()) {
                        if (g.this.mYe != null) {
                            g.this.mYe.setVisibility(8);
                        }
                        g.this.mYe = null;
                        if (g.this.mXC != null) {
                            g.this.mXC.L(12, 800L);
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
            if (this.mYp == null) {
                this.mYp = new AnimatorSet();
            }
            this.mYp.playTogether(duration);
            this.mYp.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cWw() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.mXB).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.mYf = new EmanateView(this.mXB);
            this.mYf.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.mYf);
            return;
        }
        this.mYf = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.mYg == null) {
            this.mYg = (RoomSendGiftView) this.mXl.findViewById(a.f.normalSendGiftView);
            this.mYg.setContext(this.mXB);
            if (this.mXA != null) {
                this.mYg.a(this.mXA.dBw());
            }
            this.mYg.a(z, z2);
            this.mYg.setVisibilityListener(this.mYq);
            this.mYg.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.mYf != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable SL = tv.chushou.zues.utils.h.SL(str);
                            if (SL == null) {
                                SL = tv.chushou.zues.utils.h.SN(str);
                            }
                            g.this.mYf.setDrawable(SL, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.mYf.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.mYf.dPr();
                        }
                    }
                }
            });
            this.mYg.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
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
        if (this.mYg != null) {
            if (this.mXA != null) {
                this.mYg.a(z ? this.mXA.mQp : this.mXA.mQq, this.mXA.mQr, this.mXA.mQs, z);
                this.mYg.setGiftTopIcon(this.mXA.s);
            }
            if (micMemberInfo != null) {
                this.mYg.setMicMemberInfo(micMemberInfo);
            }
            this.mYg.c();
        }
    }

    protected void ar(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.mYh.setProgress(i);
            if (!this.mYm) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.mYi.setText(this.mXB.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.mYi.setText(this.mXB.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.mYi.setText(this.mXB.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.mYj.bV(str, a.e.pao_circle_default);
            if (this.mYl != i) {
                this.mYj.startAnimation(AnimationUtils.loadAnimation(this.mXB, a.C0682a.pao_beat_anim));
                this.mYl = i;
            }
            if (this.aNY != bangInfo.mLevel) {
                if (this.mXC != null && !this.mXC.Od(17)) {
                    this.mXC.a(this.mXC.Oe(17), 500L);
                }
                this.aNY = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(boolean z) {
        int i;
        if (!this.mYk.b()) {
            WindowManager windowManager = (WindowManager) this.mXB.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                this.mYk.a(this.mXB, i, this.mXA.dBw().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.mYk.e();
        this.mYk.c();
    }

    public void dCJ() {
        this.mYj.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.mYj.getWidth() / 2, this.mYj.getHeight() / 2);
        aVar.setDuration(1000L);
        this.mYj.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.mYo == null && this.mXB != null) {
            if ("3".equals(this.aw)) {
                z = h.dAM().b;
            } else if (this.mXA == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dAM().d;
            } else {
                z = h.dAM().e;
            }
            this.mYo = new CSDanmuLayout(this.mXB.getApplicationContext(), new a.C0794a().Oa(-16711936).NZ(800).wW(true).wX(this.ap >= 0).NY(2).dOo(), h.dAM().b());
            this.mYo.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.mXB);
            Point he = tv.chushou.zues.utils.a.he(this.mXB);
            switch (h.dAM().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.mXB.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mXF / 3;
                    } else {
                        layoutParams.height = he.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.mXB.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mXF / 3;
                    } else {
                        layoutParams.height = he.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dCH().addView(this.mYo, 1, layoutParams);
            if (this.mYo != null) {
                this.mYo.setVisibility(z ? 0 : 8);
            }
            q(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.mYo != null) {
            this.mYo.setVisibility(8);
            this.mYo.dOp();
        }
        if (this.mYo != null) {
            this.mYo.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void cWe() {
        if (this.mYo != null && this.mXA != null) {
            if (this.ap < 0) {
                this.mYo.setVisibility(h.dAM().d ? 0 : 8);
            } else {
                this.mYo.setVisibility(h.dAM().e ? 0 : 8);
            }
        }
        if (this.mYo != null && this.mYo.aGB() && !this.H && !this.al) {
            this.mYo.resume();
            this.mYo.dOp();
        }
    }

    protected void q(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.mYx == null) {
            if (this.mYv == null) {
                this.mYv = new ArrayList();
            }
            this.mYv.clear();
            aO(getString(a.i.danmu_settings_no_gift), false);
            aO(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.mXB).mOJ != null) {
                if (this.mXA.dBw() != null) {
                    this.mYz = this.mXA.dBw().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.mYz)) {
                    aO(getString(a.i.danmu_settings_no_normal), true);
                    this.mYv.addAll(this.mYz);
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
            View inflate = LayoutInflater.from(this.mXB).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mXB));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.mYy = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.mXB).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mYy.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mYy.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.mYw = new com.kascend.chushou.player.adapter.b(i, this.mXB, this.mYv, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.mYw);
            if (!tv.chushou.zues.utils.h.isEmpty(this.mYz) && this.mYz.size() >= 5) {
                this.mYx = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXB, 165.0f), tv.chushou.zues.utils.a.dip2px(this.mXB, 354.0f));
            } else {
                this.mYx = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXB, 165.0f), -2);
            }
            this.mYx.setFocusable(true);
            this.mYx.setOutsideTouchable(true);
            this.mYx.setBackgroundDrawable(this.mXB.getResources().getDrawable(a.e.bg_room_pop));
            this.mYx.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dCK() {
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
        if (this.mYv != null) {
            this.mYv.add(privacyItem);
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
        if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "26", "chatType", str2, "chatState", str, "roomId", this.mXA.dBw().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.mYw.notifyDataSetChanged();
        dBW();
    }

    protected void dBW() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.dPa()) {
            tv.chushou.zues.utils.g.c(this.mXB, this.mXB.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dAI().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.mYw.notifyDataSetChanged();
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
                        g.this.mYw.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.mYw.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.mYv) {
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
                for (PrivacyItem privacyItem3 : this.mYv) {
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
            for (PrivacyItem privacyItem4 : this.mYv) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.mYB == null) {
            this.mYB = new ArrayList<>();
        }
        this.mYB.add(str);
        this.mYB.add(str2);
        p pVar = new p();
        pVar.a = this.mYB;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.mYB == null) {
            this.mYB = new ArrayList<>();
        }
        this.mYB.add(str);
        p pVar = new p();
        pVar.a = this.mYB;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.mYB != null) {
            this.mYB.remove(str);
            this.mYB.remove(str2);
            p pVar = new p();
            pVar.a = this.mYB;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.mYB != null) {
            this.mYB.remove(str);
            p pVar = new p();
            pVar.a = this.mYB;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dBQ = dBQ();
        if (dBQ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dBQ.getLayoutParams();
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
            dBQ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MN(int i) {
        GiftAnimationLayout dBQ = dBQ();
        if (dBQ != null) {
            dBQ.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dAM().q()) {
                h.dAM().g(false);
                this.mXN.c();
                return;
            }
            h.dAM().g(true);
            this.mXN.b();
        } else if (id == a.f.rl_decode) {
            if (h.dAM().a) {
                h.dAM().a(this.mXB, false);
                this.mXP.c();
            } else {
                h.dAM().a(this.mXB, true);
                this.mXP.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.mXB, nL(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.mXB).q) {
                ((VideoPlayer) this.mXB).q = false;
                if (this.mXA.mQj != null) {
                    this.mXA.mQj.e();
                    this.mXA.mQj.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.mXL.c();
                return;
            }
            ((VideoPlayer) this.mXB).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.mXL.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dAM().o();
            if (this.ap < 0) {
                o = h.dAM().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dAM().b;
            }
            boolean z = !o;
            if (z) {
                this.mXQ.b();
            } else {
                this.mXQ.c();
            }
            if (!this.aw.equals("1")) {
                h.dAM().a(z);
            } else if (this.ap < 0) {
                h.dAM().e(z);
            } else {
                h.dAM().f(z);
            }
            switch (h.dAM().m()) {
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
            com.kascend.chushou.toolkit.a.c.d(this.mXB, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.mXB).q) {
                ((VideoPlayer) this.mXB).q = false;
                if (this.mXA.mQj != null) {
                    this.mXA.mQj.e();
                    this.mXA.mQj.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mYy.setImageResource(i);
            } else {
                ((VideoPlayer) this.mXB).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mYy.setImageResource(i2);
            }
            dBW();
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
        if (aVar != null && this.mYr != null) {
            this.mYr.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dCg() {
        return null;
    }

    public GiftAnimationLayout dBQ() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dCv() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dBy;
        if (this.mXA != null && (dBy = this.mXA.dBy()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dBy.mOnlineCount.equals(str2) || !dBy.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dBy.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dBy.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dCv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dAM().c(true);
        if (this.mYt == null) {
            a();
        }
        if (!this.mYt.isShowing()) {
            if (view != null) {
                this.mYt.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.mXB, 3.0f), (this.mXl.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.mXB, 8.0f));
                RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.mYt != null) {
                            g.this.mYt.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.mYt.dismiss();
    }

    private void a() {
        if (this.mYt == null) {
            View inflate = LayoutInflater.from(this.mXB).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.mXB.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.mXB.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.mYt = new PopupWindow(inflate, -2, -2);
            this.mYt.setFocusable(true);
            this.mYt.setOutsideTouchable(true);
            this.mYt.setAnimationStyle(a.j.gift_toast_style);
            this.mYt.update();
            this.mYt.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.mYt = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
