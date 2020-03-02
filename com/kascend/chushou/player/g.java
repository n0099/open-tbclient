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
    protected RecyclerView mYA;
    protected LinearLayoutManager mYB;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> mYC;
    protected ArrayList<a> mYD;
    protected ArrayList<a> mYE;
    protected PopupWindow mYF;
    protected View mYH;
    protected SVGAImageView mYI;
    protected View mYJ;
    protected EmanateView mYK;
    protected RoomSendGiftView mYL;
    protected RoundProgressBar mYM;
    protected TextView mYN;
    protected FrescoThumbnailView mYO;
    protected PaoGuideView mYP;
    protected AnimatorSet mYU;
    protected KasBaseMenuView.a mYV;
    protected H5Container mYW;
    protected RelativeLayout mYX;
    protected PopupWindow mYY;
    protected PopupWindow mYZ;
    protected RelativeLayout mYo;
    protected RelativeLayout mYp;
    protected OnlineToggleButton mYq;
    protected RelativeLayout mYr;
    protected OnlineToggleButton mYs;
    protected RelativeLayout mYt;
    protected OnlineToggleButton mYu;
    protected OnlineToggleButton mYv;
    protected LinearLayout mYw;
    protected PopupWindow mYx;
    protected PopupWindow mYy;
    protected PopupWindow mYz;
    protected List<PrivacyItem> mZa;
    protected com.kascend.chushou.player.adapter.b mZb;
    protected PopupWindow mZc;
    protected ImageView mZd;
    protected List<PrivacyItem> mZe;
    protected FrescoThumbnailView mZf;
    protected ArrayList<String> mZg;
    protected boolean mYG = false;
    protected int aSy = 0;
    protected long mYQ = 0;
    protected boolean mYR = false;
    protected IconConfig.Config mYS = new IconConfig.Config();
    protected CSDanmuLayout mYT = null;
    protected boolean bi = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.dDO() && g.this.mYA != null && g.this.mYC != null && g.this.mYB != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.mYB.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.mYB.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.mYB.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.mYB.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.mYB.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.mYA.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.mYh != null) {
                                    g.this.mYh.removeCallbacks(g.this.d);
                                    if (g.this.b) {
                                        g.this.mYh.d(g.this.d, 1000L);
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
    public RelativeLayout dDP() {
        if (this.mYo == null) {
            this.mYo = (RelativeLayout) this.mXQ.findViewById(a.f.video_root_view);
        }
        return this.mYo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(View view, int i, int i2) {
        if (!this.bi) {
            ag();
        }
        ah();
        if (this.mYx != null) {
            if (!this.mYx.isShowing()) {
                this.mYx.showAtLocation(view, 53, i, i2);
            } else {
                this.mYx.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point hd = tv.chushou.zues.utils.a.hd(this.mYg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dBU().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dBU().b(1);
                layoutParams.width = -1;
                if (this.mYg.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mYk / 3;
                } else {
                    layoutParams.height = hd.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dBU().b(2);
                layoutParams.width = -1;
                if (this.mYg.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.mYk / 3;
                } else {
                    layoutParams.height = hd.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.mYT != null) {
            this.mYT.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(View view, int i, int i2) {
        ae();
        if (this.mYy != null) {
            if (!this.mYy.isShowing()) {
                if (this.mYg.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.mYy.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.mYy.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.mYy.showAtLocation(view, 53, i, i2);
                return;
            }
            this.mYy.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.mYg.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.mYg).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.mYv = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dBU().b) {
                this.mYv.b();
            } else {
                this.mYv.c();
            }
        } else if (this.ap < 0) {
            if (h.dBU().n()) {
                this.mYv.b();
            } else {
                this.mYv.c();
            }
        } else if (h.dBU().o()) {
            this.mYv.b();
        } else {
            this.mYv.c();
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
        switch (h.dBU().m()) {
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
        if (this.mYg.getResources().getConfiguration().orientation == 1) {
            this.mYy = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYg, 230.0f), -2);
            this.mYy.setBackgroundDrawable(this.mYg.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.mYy = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYg, 295.0f), -1);
            this.mYy.setClippingEnabled(false);
            this.mYy.setBackgroundDrawable(this.mYg.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.mYy.setFocusable(true);
        this.mYy.setOutsideTouchable(true);
        this.mYy.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dBU().a(true);
        } else if (this.ap < 0) {
            h.dBU().e(true);
        } else {
            h.dBU().f(true);
        }
        switch (h.dBU().m()) {
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
            if (this.mYg.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.mYg).inflate(i2, (ViewGroup) null);
            this.mYw = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.mYp = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.mYq = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.mYr = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.mYs = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.mYt = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mYu = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.mYg.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYg);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.S(10.0f);
                }
                this.mYw.setPadding(this.mYw.getPaddingLeft(), statusBarHeight, this.mYw.getPaddingRight(), this.mYw.getPaddingBottom());
            }
            this.mYp.setOnClickListener(this);
            this.mYr.setOnClickListener(this);
            this.mYt.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.mYp.setVisibility(8);
            } else {
                this.mYp.setVisibility(0);
            }
            if (((VideoPlayer) this.mYg).q) {
                this.mYq.b();
            } else {
                this.mYq.c();
            }
            if (h.dBU().q()) {
                this.mYs.b();
            } else {
                this.mYs.c();
            }
            if (com.kascend.chushou.c.a) {
                this.mYt.setVisibility(0);
            } else {
                this.mYt.setVisibility(8);
            }
            if (h.dBU().a) {
                this.mYu.b();
            } else {
                this.mYu.c();
            }
            if (this.mYf != null && (arrayList = this.mYf.f) != null && arrayList.size() > 0) {
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
                            if (this.mYg.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.mYg).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dCF = this.mYf.dCF();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mYg).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.mYg.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.mYg).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mYg, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mYg, 6.0f);
                                    }
                                    int identifier = this.mYg.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mYg.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mYw, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dCF != null && dCF.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.mYw.addView(inflate2);
                            this.bi = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.mYg.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.mYg).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dCF2 = this.mYf.dCF();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mYg).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.mYg.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.mYg).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mYg, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mYg, 6.0f);
                                    }
                                    int identifier2 = this.mYg.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mYg.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mYw, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dCF2 != null && dCF2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.mYw.addView(inflate3);
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
            if (this.mYg.getResources().getConfiguration().orientation == 1) {
                this.mYx = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYg, 230.0f), -2);
                this.mYx.setBackgroundDrawable(this.mYg.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.mYx = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYg, 295.0f), -1);
                this.mYx.setClippingEnabled(false);
                this.mYx.setBackgroundDrawable(this.mYg.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.mYx.setFocusable(true);
            this.mYx.setOutsideTouchable(true);
            this.mYx.update();
        }
    }

    protected void ah() {
        if (this.mYr != null && this.mYs != null) {
            this.mYr.setVisibility(0);
            if (h.dBU().q()) {
                this.mYs.b();
            } else {
                this.mYs.c();
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
        com.kascend.chushou.toolkit.a.c.a(this.mYg, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.mYf.f;
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
            if (this.mYw == null) {
                this.mYf.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.mYf.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.mYg).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mYw.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mYw.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mYg.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mYg.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mYw, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.mYg, "点击音视切换_num", "视频切音频", new Object[0]);
        o(false);
    }

    protected void o(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.mYf.f;
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
            if (this.mYw == null) {
                if (!z) {
                    this.mYf.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.mYf.a(playUrl);
                if (this.ap >= 0) {
                    this.mYf.a(false);
                    if (this.mYg != null) {
                        ((VideoPlayer) this.mYg).a(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.mYg).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mYw.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mYw.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mYg.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mYg.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mYw, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.mYx != null) {
            this.mYx.dismiss();
        }
        if (this.mYz != null) {
            this.mYz.dismiss();
        }
        PlayUrl dCF = this.mYf.dCF();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.mYf.d) {
                this.mYf.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.mYf.a(playUrl);
                this.mYf.a(false);
                if (this.mYg != null) {
                    ((VideoPlayer) this.mYg).a(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.mYf.d) {
            this.mYf.e = true;
        }
        h.dBU().a(this.mYg, urlDetails.mDefinitionType);
        if (z || (dCF != null && !dCF.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.f(this.mYg, ou(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.mYf.a(playUrl);
            if (ou()) {
                if (((VideoPlayer) this.mYg) != null) {
                    ((VideoPlayer) this.mYg).r = -1L;
                }
                if (this.mUu != null) {
                    this.kWe = this.mUu.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.mYg).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.mYl = str2;
        if (this.mYh != null) {
            this.mYh.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.mYG = true;
            if (this.mYE == null) {
                this.mYE = new ArrayList<>();
            }
            this.mYE.clear();
            this.mYE.addAll(list);
            this.mYF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.mYF == null) {
            View inflate = LayoutInflater.from(this.mYg).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.mYg.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.mYg.getResources().getColor(a.c.player_bg_color));
            }
            if (this.mYG && !tv.chushou.zues.utils.h.isEmpty(this.mYE)) {
                this.mYD = this.mYE;
            } else {
                this.mYD = (ArrayList) h.dBU().dBW();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.mYD)) {
                String[] stringArray = this.mYg.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.mYg.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.mYD == null) {
                    this.mYD = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.mYD.add(aVar);
                }
            }
            this.mYA = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.mYC = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.mYD, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void onItemClick(View view, int i4) {
                    a aVar2;
                    if (g.this.mYF != null) {
                        g.this.mYF.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.mYD) && i4 < g.this.mYD.size() && (aVar2 = g.this.mYD.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.mYG) {
                            g.this.mYD.remove(i4);
                            g.this.mYD.add(0, aVar2);
                            g.this.mYC.notifyDataSetChanged();
                            g.this.mYA.scrollToPosition(0);
                            RxExecutor.post(g.this.mXP, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dBU().a((Object) g.this.mYD);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.mYg, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.mYf != null && g.this.mYf.dCE() != null && g.this.mYf.dCE().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.mYf.dCE().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0813a view$OnLongClickListenerC0813a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0813a.a(a.f.tv_name, g.this.mYg.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0813a.a(a.f.tv_name, g.this.mYg.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0813a.a(a.f.tv_name, g.this.mYg.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0813a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.mYB = new LinearLayoutManager(this.mYg);
            this.mYA.setLayoutManager(this.mYB);
            this.mYA.setAdapter(this.mYC);
            this.mYA.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.mYF = new PopupWindow(inflate, this.mYg.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.mYg.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.mYF.setFocusable(true);
            this.mYF.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.mYF.setBackgroundDrawable(this.mYg.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.mYF.setBackgroundDrawable(this.mYg.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.mYF.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.mYh.removeCallbacks(this.d);
        this.mYh.m(this.d);
    }

    protected void an() {
        this.b = true;
        this.mYh.removeCallbacks(this.d);
        this.mYh.d(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.mYh != null) {
            this.mYh.removeCallbacks(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bF(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.mYf != null) {
                RoomInfo dCG = this.mYf.dCG();
                if (dCG != null) {
                    str = dCG.mRoomID;
                }
                if (dCG != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dCG.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.mYg, listItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.mXQ != null) {
            Point hd = tv.chushou.zues.utils.a.hd(this.mYg);
            int i = hd.x > hd.y ? 1 : 2;
            if (this.mYW == null) {
                this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYW.setPlayerViewHelper(this.mYf);
            this.mYW.setVisibility(0);
            this.mYW.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dDQ() {
        HashMap e;
        if (this.mYf != null && (e = this.mYf.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.mYW != null) {
            this.mYW.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.mYH == null && this.mYI == null) {
            if (this.mYf.mQO != null) {
                ChatInfo dCC = this.mYf.mQO.dCC();
                if (dCC == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.mYX == null) {
                    this.mYX = (RelativeLayout) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dCC.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dCC.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dCC.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dCC.mAnimSubType > 0) {
                    dCC.mAnimType = dCC.mAnimSubType;
                }
                if (dCC.mAnimationPluginId == 1) {
                    this.mYH = com.kascend.chushou.toolkit.d.a.dEn().a(this.mYg, String.valueOf(dCC.mAnimType), this.mYX, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.dDO() && g.this.mYH != null && g.this.mYX != null) {
                                Object tag = g.this.mYH.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dEn().a(g.this.mYg, String.valueOf(((ChatInfo) tag).mAnimType), g.this.mYX, g.this.mYH);
                                }
                                if (!z) {
                                    g.this.mYH.setVisibility(8);
                                    g.this.mYX.removeView(g.this.mYH);
                                    g.this.mYH = null;
                                    if (g.this.mYh != null) {
                                        g.this.mYh.removeMessages(11);
                                        g.this.mYh.K(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.mYH = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dCC.mJsonData);
                } else if (dCC.mAnimationPluginId == 2) {
                    if (this.mYI == null && this.mYX != null) {
                        this.mYI = (SVGAImageView) this.mYX.findViewById(a.f.svgaView);
                        if (this.mYI == null) {
                            this.mYI = new SVGAImageView(this.mYg);
                            this.mYI.setClearsAfterStop(true);
                            this.mYI.setLoops(1);
                            this.mYI.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.mYX.addView(this.mYI, layoutParams);
                        }
                    }
                    if (this.mYI == null) {
                        cVar.removeMessages(11);
                        cVar.K(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dEn().a(this.mYg, String.valueOf(dCC.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.mYI.stopAnimation();
                            g.this.mYI.clearAnimation();
                            g.this.mYI.setVisibility(8);
                            g.this.mYI = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onFinished() {
                            g.this.mYI.stopAnimation();
                            g.this.mYI.clearAnimation();
                            g.this.mYI.setVisibility(8);
                            g.this.mYI = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Gr() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.mYI, dCC);
                }
                if (this.mYH != null) {
                    this.mYH.setTag(dCC);
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
        if (this.mYJ == null) {
            if (this.mYf.mQO != null) {
                int g = this.mYf.mQO.g();
                ChatInfo dCD = this.mYf.mQO.dCD();
                if (dCD == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dCD, g);
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
        if (this.mYJ != null || getContext() == null) {
            if (this.mYh != null) {
                this.mYh.removeMessages(12);
                this.mYh.K(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.mYJ = this.mXQ.findViewById(a.f.rl_show_tip);
            if (this.mYJ != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dBN().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYg);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mYJ.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.mYg, 5.0f);
                    this.mYJ.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.mYJ = this.mXQ.findViewById(a.f.rl_tip);
        }
        if (this.mYJ != null) {
            this.mYJ.setVisibility(0);
            this.mYJ.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mYf != null) {
                            RoomInfo dCG = g.this.mYf.dCG();
                            if (dCG != null) {
                                str = dCG.mRoomID;
                            }
                            if (dCG != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dCG.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mYg, chatInfo.mItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.mYJ.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.mYJ.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mYf != null) {
                            RoomInfo dCG = g.this.mYf.dCG();
                            if (dCG != null) {
                                str = dCG.mRoomID;
                            }
                            if (dCG != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dCG.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mYg, chatInfo.mItem, com.kascend.chushou.d.e.M("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.mYg.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mYg, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mYg, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                if (this.mYg.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mYg, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mYg, a.c.black), simpleDraweeSpanTextView)) {
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
            ViewTreeObserver viewTreeObserver = this.mYJ.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.mYJ != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.mYJ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.mYJ.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.mYU == null) {
                                g.this.mYU = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.mYU.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.mYU.removeAllListeners();
                            }
                            g.this.mYU.playTogether(ObjectAnimator.ofFloat(g.this.mYJ, "translationX", g.this.mYJ.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.mYU.start();
                            if (g.this.mYh != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.mYh.K(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void cXL() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!dDO() && this.mYJ != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.mYJ, "translationX", 0.0f, 10.0f, -this.mYJ.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.dDO()) {
                        if (g.this.mYJ != null) {
                            g.this.mYJ.setVisibility(8);
                        }
                        g.this.mYJ = null;
                        if (g.this.mYh != null) {
                            g.this.mYh.K(12, 800L);
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
            if (this.mYU == null) {
                this.mYU = new AnimatorSet();
            }
            this.mYU.playTogether(duration);
            this.mYU.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cXM() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.mYg).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.mYK = new EmanateView(this.mYg);
            this.mYK.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.mYK);
            return;
        }
        this.mYK = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.mYL == null) {
            this.mYL = (RoomSendGiftView) this.mXQ.findViewById(a.f.normalSendGiftView);
            this.mYL.setContext(this.mYg);
            if (this.mYf != null) {
                this.mYL.a(this.mYf.dCE());
            }
            this.mYL.a(z, z2);
            this.mYL.setVisibilityListener(this.mYV);
            this.mYL.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.mYK != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable SW = tv.chushou.zues.utils.h.SW(str);
                            if (SW == null) {
                                SW = tv.chushou.zues.utils.h.SY(str);
                            }
                            g.this.mYK.setDrawable(SW, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.mYK.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.mYK.dQG();
                        }
                    }
                }
            });
            this.mYL.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
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
        if (this.mYL != null) {
            if (this.mYf != null) {
                this.mYL.a(z ? this.mYf.mQU : this.mYf.mQV, this.mYf.mQW, this.mYf.mQX, z);
                this.mYL.setGiftTopIcon(this.mYf.s);
            }
            if (micMemberInfo != null) {
                this.mYL.setMicMemberInfo(micMemberInfo);
            }
            this.mYL.c();
        }
    }

    protected void at(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.mYM.setProgress(i);
            if (!this.mYR) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.mYN.setText(this.mYg.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.mYN.setText(this.mYg.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.mYN.setText(this.mYg.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.mYO.bU(str, a.e.pao_circle_default);
            if (this.mYQ != i) {
                this.mYO.startAnimation(AnimationUtils.loadAnimation(this.mYg, a.C0690a.pao_beat_anim));
                this.mYQ = i;
            }
            if (this.aSy != bangInfo.mLevel) {
                if (this.mYh != null && !this.mYh.Og(17)) {
                    this.mYh.a(this.mYh.Oh(17), 500L);
                }
                this.aSy = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(boolean z) {
        int i;
        if (!this.mYP.b()) {
            WindowManager windowManager = (WindowManager) this.mYg.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                this.mYP.a(this.mYg, i, this.mYf.dCE().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.mYP.e();
        this.mYP.c();
    }

    public void dDR() {
        this.mYO.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.mYO.getWidth() / 2, this.mYO.getHeight() / 2);
        aVar.setDuration(1000L);
        this.mYO.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.mYT == null && this.mYg != null) {
            if ("3".equals(this.aw)) {
                z = h.dBU().b;
            } else if (this.mYf == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dBU().d;
            } else {
                z = h.dBU().e;
            }
            this.mYT = new CSDanmuLayout(this.mYg.getApplicationContext(), new a.C0802a().Od(-16711936).Oc(800).wZ(true).xa(this.ap >= 0).Ob(2).dPD(), h.dBU().b());
            this.mYT.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.mYg);
            Point hd = tv.chushou.zues.utils.a.hd(this.mYg);
            switch (h.dBU().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.mYg.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mYk / 3;
                    } else {
                        layoutParams.height = hd.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.mYg.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.mYk / 3;
                    } else {
                        layoutParams.height = hd.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dDP().addView(this.mYT, 1, layoutParams);
            if (this.mYT != null) {
                this.mYT.setVisibility(z ? 0 : 8);
            }
            q(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.mYT != null) {
            this.mYT.setVisibility(8);
            this.mYT.dPE();
        }
        if (this.mYT != null) {
            this.mYT.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void cXu() {
        if (this.mYT != null && this.mYf != null) {
            if (this.ap < 0) {
                this.mYT.setVisibility(h.dBU().d ? 0 : 8);
            } else {
                this.mYT.setVisibility(h.dBU().e ? 0 : 8);
            }
        }
        if (this.mYT != null && this.mYT.isPrepared() && !this.H && !this.al) {
            this.mYT.resume();
            this.mYT.dPE();
        }
    }

    protected void q(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.mZc == null) {
            if (this.mZa == null) {
                this.mZa = new ArrayList();
            }
            this.mZa.clear();
            aO(getString(a.i.danmu_settings_no_gift), false);
            aO(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.mYg).mPp != null) {
                if (this.mYf.dCE() != null) {
                    this.mZe = this.mYf.dCE().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.mZe)) {
                    aO(getString(a.i.danmu_settings_no_normal), true);
                    this.mZa.addAll(this.mZe);
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
            View inflate = LayoutInflater.from(this.mYg).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mYg));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.mZd = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.mYg).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mZd.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mZd.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.mZb = new com.kascend.chushou.player.adapter.b(i, this.mYg, this.mZa, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.mZb);
            if (!tv.chushou.zues.utils.h.isEmpty(this.mZe) && this.mZe.size() >= 5) {
                this.mZc = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYg, 165.0f), tv.chushou.zues.utils.a.dip2px(this.mYg, 354.0f));
            } else {
                this.mZc = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYg, 165.0f), -2);
            }
            this.mZc.setFocusable(true);
            this.mZc.setOutsideTouchable(true);
            this.mZc.setBackgroundDrawable(this.mYg.getResources().getDrawable(a.e.bg_room_pop));
            this.mZc.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dDS() {
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
        if (this.mZa != null) {
            this.mZa.add(privacyItem);
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
        if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "26", "chatType", str2, "chatState", str, "roomId", this.mYf.dCE().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.mZb.notifyDataSetChanged();
        dDe();
    }

    protected void dDe() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.dQp()) {
            tv.chushou.zues.utils.g.c(this.mYg, this.mYg.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dBQ().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.mZb.notifyDataSetChanged();
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
                        g.this.mZb.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.mZb.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.mZa) {
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
                for (PrivacyItem privacyItem3 : this.mZa) {
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
            for (PrivacyItem privacyItem4 : this.mZa) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.mZg == null) {
            this.mZg = new ArrayList<>();
        }
        this.mZg.add(str);
        this.mZg.add(str2);
        p pVar = new p();
        pVar.a = this.mZg;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.mZg == null) {
            this.mZg = new ArrayList<>();
        }
        this.mZg.add(str);
        p pVar = new p();
        pVar.a = this.mZg;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.mZg != null) {
            this.mZg.remove(str);
            this.mZg.remove(str2);
            p pVar = new p();
            pVar.a = this.mZg;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.mZg != null) {
            this.mZg.remove(str);
            p pVar = new p();
            pVar.a = this.mZg;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dCY = dCY();
        if (dCY != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dCY.getLayoutParams();
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
            dCY.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dCY = dCY();
        if (dCY != null) {
            dCY.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dBU().q()) {
                h.dBU().g(false);
                this.mYs.c();
                return;
            }
            h.dBU().g(true);
            this.mYs.b();
        } else if (id == a.f.rl_decode) {
            if (h.dBU().a) {
                h.dBU().a(this.mYg, false);
                this.mYu.c();
            } else {
                h.dBU().a(this.mYg, true);
                this.mYu.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.mYg, ou(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.mYg).q) {
                ((VideoPlayer) this.mYg).q = false;
                if (this.mYf.mQO != null) {
                    this.mYf.mQO.e();
                    this.mYf.mQO.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.mYq.c();
                return;
            }
            ((VideoPlayer) this.mYg).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.mYq.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dBU().o();
            if (this.ap < 0) {
                o = h.dBU().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dBU().b;
            }
            boolean z = !o;
            if (z) {
                this.mYv.b();
            } else {
                this.mYv.c();
            }
            if (!this.aw.equals("1")) {
                h.dBU().a(z);
            } else if (this.ap < 0) {
                h.dBU().e(z);
            } else {
                h.dBU().f(z);
            }
            switch (h.dBU().m()) {
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
            com.kascend.chushou.toolkit.a.c.d(this.mYg, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.mYg).q) {
                ((VideoPlayer) this.mYg).q = false;
                if (this.mYf.mQO != null) {
                    this.mYf.mQO.e();
                    this.mYf.mQO.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mZd.setImageResource(i);
            } else {
                ((VideoPlayer) this.mYg).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mZd.setImageResource(i2);
            }
            dDe();
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
        if (aVar != null && this.mYW != null) {
            this.mYW.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dDo() {
        return null;
    }

    public GiftAnimationLayout dCY() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dDD() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dCG;
        if (this.mYf != null && (dCG = this.mYf.dCG()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dCG.mOnlineCount.equals(str2) || !dCG.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dCG.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dCG.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dDD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dBU().c(true);
        if (this.mYY == null) {
            a();
        }
        if (!this.mYY.isShowing()) {
            if (view != null) {
                this.mYY.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.mYg, 3.0f), (this.mXQ.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.mYg, 8.0f));
                RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.mYY != null) {
                            g.this.mYY.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.mYY.dismiss();
    }

    private void a() {
        if (this.mYY == null) {
            View inflate = LayoutInflater.from(this.mYg).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.mYg.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.mYg.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.mYY = new PopupWindow(inflate, -2, -2);
            this.mYY.setFocusable(true);
            this.mYY.setOutsideTouchable(true);
            this.mYY.setAnimationStyle(a.j.gift_toast_style);
            this.mYY.update();
            this.mYY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.mYY = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
