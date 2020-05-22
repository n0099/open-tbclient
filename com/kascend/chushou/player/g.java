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
    protected RelativeLayout mQG;
    protected RelativeLayout mQH;
    protected OnlineToggleButton mQI;
    protected RelativeLayout mQJ;
    protected OnlineToggleButton mQK;
    protected RelativeLayout mQL;
    protected OnlineToggleButton mQM;
    protected OnlineToggleButton mQN;
    protected LinearLayout mQO;
    protected PopupWindow mQP;
    protected PopupWindow mQQ;
    protected PopupWindow mQR;
    protected RecyclerView mQS;
    protected LinearLayoutManager mQT;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> mQU;
    protected ArrayList<a> mQV;
    protected ArrayList<a> mQW;
    protected PopupWindow mQX;
    protected View mQY;
    protected SVGAImageView mQZ;
    protected View mRa;
    protected EmanateView mRb;
    protected RoomSendGiftView mRd;
    protected RoundProgressBar mRe;
    protected TextView mRf;
    protected FrescoThumbnailView mRg;
    protected PaoGuideView mRh;
    protected AnimatorSet mRm;
    protected KasBaseMenuView.a mRn;
    protected H5Container mRp;
    protected RelativeLayout mRq;
    protected PopupWindow mRr;
    protected PopupWindow mRs;
    protected List<PrivacyItem> mRt;
    protected com.kascend.chushou.player.adapter.b mRu;
    protected PopupWindow mRv;
    protected ImageView mRw;
    protected List<PrivacyItem> mRx;
    protected FrescoThumbnailView mRy;
    protected ArrayList<String> mRz;
    protected boolean aR = false;
    protected int bb = 0;
    protected long mRi = 0;
    protected boolean mRj = false;
    protected IconConfig.Config mRk = new IconConfig.Config();
    protected CSDanmuLayout mRl = null;
    protected boolean mRo = false;
    private double a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.dFE() && g.this.mQS != null && g.this.mQU != null && g.this.mQT != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.mQT.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.mQT.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.mQT.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.mQT.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.mQT.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.mQS.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.mQz != null) {
                                    g.this.mQz.P(g.this.d);
                                    if (g.this.b) {
                                        g.this.mQz.e(g.this.d, 1000L);
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
    public RelativeLayout dFF() {
        if (this.mQG == null) {
            this.mQG = (RelativeLayout) this.mQi.findViewById(a.f.video_root_view);
        }
        return this.mQG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(View view, int i, int i2) {
        if (!this.mRo) {
            ag();
        }
        ah();
        if (this.mQP != null) {
            if (!this.mQP.isShowing()) {
                this.mQP.showAtLocation(view, 53, i, i2);
            } else {
                this.mQP.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point gv = tv.chushou.zues.utils.a.gv(this.mQy);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.dDZ().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.dDZ().b(1);
                layoutParams.width = -1;
                if (this.mQy.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gv.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.dDZ().b(2);
                layoutParams.width = -1;
                if (this.mQy.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = gv.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.mRl != null) {
            this.mRl.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(View view, int i, int i2) {
        ae();
        if (this.mQQ != null) {
            if (!this.mQQ.isShowing()) {
                if (this.mQy.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.mQQ.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.mQQ.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.mQQ.showAtLocation(view, 53, i, i2);
                return;
            }
            this.mQQ.dismiss();
        }
    }

    protected void ae() {
        int i = a.h.pop_danmu_full_setting;
        if (this.mQy.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.mQy).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.mQN = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.aw.equals("1")) {
            if (h.dDZ().b) {
                this.mQN.b();
            } else {
                this.mQN.c();
            }
        } else if (this.ap < 0) {
            if (h.dDZ().n()) {
                this.mQN.b();
            } else {
                this.mQN.c();
            }
        } else if (h.dDZ().o()) {
            this.mQN.b();
        } else {
            this.mQN.c();
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
        switch (h.dDZ().m()) {
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
        if (this.mQy.getResources().getConfiguration().orientation == 1) {
            this.mQQ = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mQy, 230.0f), -2);
            this.mQQ.setBackgroundDrawable(this.mQy.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.mQQ = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mQy, 295.0f), -1);
            this.mQQ.setClippingEnabled(false);
            this.mQQ.setBackgroundDrawable(this.mQy.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.mQQ.setFocusable(true);
        this.mQQ.setOutsideTouchable(true);
        this.mQQ.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af() {
        if (!this.aw.equals("1")) {
            h.dDZ().a(true);
        } else if (this.ap < 0) {
            h.dDZ().e(true);
        } else {
            h.dDZ().f(true);
        }
        switch (h.dDZ().m()) {
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
        if (!this.mRo) {
            int i2 = a.h.pop_full_play_setting;
            if (this.mQy.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.mQy).inflate(i2, (ViewGroup) null);
            this.mQO = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.mQH = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.mQI = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.mQJ = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.mQK = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.mQL = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mQM = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.mQy.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mQy);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.B(10.0f);
                }
                this.mQO.setPadding(this.mQO.getPaddingLeft(), statusBarHeight, this.mQO.getPaddingRight(), this.mQO.getPaddingBottom());
            }
            this.mQH.setOnClickListener(this);
            this.mQJ.setOnClickListener(this);
            this.mQL.setOnClickListener(this);
            if (!this.aw.equals("1") || this.ap < 0) {
                this.mQH.setVisibility(8);
            } else {
                this.mQH.setVisibility(0);
            }
            if (((VideoPlayer) this.mQy).q) {
                this.mQI.b();
            } else {
                this.mQI.c();
            }
            if (h.dDZ().q()) {
                this.mQK.b();
            } else {
                this.mQK.c();
            }
            if (com.kascend.chushou.c.a) {
                this.mQL.setVisibility(0);
            } else {
                this.mQL.setVisibility(8);
            }
            if (h.dDZ().a) {
                this.mQM.b();
            } else {
                this.mQM.c();
            }
            if (this.mQx != null && (arrayList = this.mQx.f) != null && arrayList.size() > 0) {
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
                            if (this.mQy.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.mQy).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl dEM = this.mQx.dEM();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mQy).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.mQy.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.mQy).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mQy, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mQy, 6.0f);
                                    }
                                    int identifier = this.mQy.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mQy.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mQO, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (dEM != null && dEM.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.mQO.addView(inflate2);
                            this.mRo = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.mQy.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.mQy).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl dEM2 = this.mQx.dEM();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mQy).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.mQy.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.mQy).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mQy, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mQy, 6.0f);
                                    }
                                    int identifier2 = this.mQy.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mQy.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.mQO, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (dEM2 != null && dEM2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.mQO.addView(inflate3);
                            this.mRo = true;
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
            if (this.mQy.getResources().getConfiguration().orientation == 1) {
                this.mQP = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mQy, 230.0f), -2);
                this.mQP.setBackgroundDrawable(this.mQy.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.mQP = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mQy, 295.0f), -1);
                this.mQP.setClippingEnabled(false);
                this.mQP.setBackgroundDrawable(this.mQy.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.mQP.setFocusable(true);
            this.mQP.setOutsideTouchable(true);
            this.mQP.update();
        }
    }

    protected void ah() {
        if (this.mQJ != null && this.mQK != null) {
            this.mQJ.setVisibility(0);
            if (h.dDZ().q()) {
                this.mQK.b();
            } else {
                this.mQK.c();
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
        com.kascend.chushou.toolkit.a.c.a(this.mQy, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.mQx.f;
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
            if (this.mQO == null) {
                this.mQx.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.mQx.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.mQy).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mQO.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mQO.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mQy.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mQy.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mQO, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.mQy, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.mQx.f;
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
            if (this.mQO == null) {
                if (!z) {
                    this.mQx.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.mQx.a(playUrl);
                if (this.ap >= 0) {
                    this.mQx.a(false);
                    if (this.mQy != null) {
                        ((VideoPlayer) this.mQy).a(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.mQy).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.mQO.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.mQO.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.mQy.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.mQy.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.mQO, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.mQP != null) {
            this.mQP.dismiss();
        }
        if (this.mQR != null) {
            this.mQR.dismiss();
        }
        PlayUrl dEM = this.mQx.dEM();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.mQx.d) {
                this.mQx.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.mQx.a(playUrl);
                this.mQx.a(false);
                if (this.mQy != null) {
                    ((VideoPlayer) this.mQy).a(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.mQx.d) {
            this.mQx.e = true;
        }
        h.dDZ().a(this.mQy, urlDetails.mDefinitionType);
        if (z || (dEM != null && !dEM.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.mQy, dFD(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.mQx.a(playUrl);
            if (dFD()) {
                if (((VideoPlayer) this.mQy) != null) {
                    ((VideoPlayer) this.mQy).r = -1L;
                }
                if (this.mMN != null) {
                    this.mhQ = this.mMN.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.mQy).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.mQD = str2;
        if (this.mQz != null) {
            this.mQz.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ak() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.aR = true;
            if (this.mQW == null) {
                this.mQW = new ArrayList<>();
            }
            this.mQW.clear();
            this.mQW.addAll(list);
            this.mQX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.mQX == null) {
            View inflate = LayoutInflater.from(this.mQy).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.mQy.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.mQy.getResources().getColor(a.c.player_bg_color));
            }
            if (this.aR && !tv.chushou.zues.utils.h.isEmpty(this.mQW)) {
                this.mQV = this.mQW;
            } else {
                this.mQV = (ArrayList) h.dDZ().dEb();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.mQV)) {
                String[] stringArray = this.mQy.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.mQy.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.mQV == null) {
                    this.mQV = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.mQV.add(aVar);
                }
            }
            this.mQS = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.mQU = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.mQV, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void B(View view, int i4) {
                    a aVar2;
                    if (g.this.mQX != null) {
                        g.this.mQX.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.mQV) && i4 < g.this.mQV.size() && (aVar2 = g.this.mQV.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.aR) {
                            g.this.mQV.remove(i4);
                            g.this.mQV.add(0, aVar2);
                            g.this.mQU.notifyDataSetChanged();
                            g.this.mQS.scrollToPosition(0);
                            RxExecutor.post(g.this.mQh, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.dDZ().a((Object) g.this.mQV);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.mQy, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.mQx != null && g.this.mQx.dEL() != null && g.this.mQx.dEL().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.mQx.dEL().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC0920a view$OnLongClickListenerC0920a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC0920a.a(a.f.tv_name, g.this.mQy.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC0920a.a(a.f.tv_name, g.this.mQy.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC0920a.a(a.f.tv_name, g.this.mQy.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC0920a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.mQT = new LinearLayoutManager(this.mQy);
            this.mQS.setLayoutManager(this.mQT);
            this.mQS.setAdapter(this.mQU);
            this.mQS.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.mQX = new PopupWindow(inflate, this.mQy.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.mQy.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.mQX.setFocusable(true);
            this.mQX.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.mQX.setBackgroundDrawable(this.mQy.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.mQX.setBackgroundDrawable(this.mQy.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.mQX.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.mQz.P(this.d);
        this.mQz.r(this.d);
    }

    protected void an() {
        this.b = true;
        this.mQz.P(this.d);
        this.mQz.e(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.mQz != null) {
            this.mQz.P(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bt(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.mQx != null) {
                RoomInfo dEO = this.mQx.dEO();
                if (dEO != null) {
                    str = dEO.mRoomID;
                }
                if (dEO != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(dEO.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.mQy, listItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.mQi != null) {
            Point gv = tv.chushou.zues.utils.a.gv(this.mQy);
            int i = gv.x > gv.y ? 1 : 2;
            if (this.mRp == null) {
                this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mRp.setPlayerViewHelper(this.mQx);
            this.mRp.setVisibility(0);
            this.mRp.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.mQx != null && (e = this.mQx.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.mRp != null) {
            this.mRp.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.mQY == null && this.mQZ == null) {
            if (this.mQx.mJv != null) {
                ChatInfo dEJ = this.mQx.mJv.dEJ();
                if (dEJ == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.mRq == null) {
                    this.mRq = (RelativeLayout) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (dEJ.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(dEJ.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        dEJ.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (dEJ.mAnimSubType > 0) {
                    dEJ.mAnimType = dEJ.mAnimSubType;
                }
                if (dEJ.mAnimationPluginId == 1) {
                    this.mQY = com.kascend.chushou.toolkit.d.a.dGd().a(this.mQy, String.valueOf(dEJ.mAnimType), this.mRq, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.dFE() && g.this.mQY != null && g.this.mRq != null) {
                                Object tag = g.this.mQY.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.dGd().a(g.this.mQy, String.valueOf(((ChatInfo) tag).mAnimType), g.this.mRq, g.this.mQY);
                                }
                                if (!z) {
                                    g.this.mQY.setVisibility(8);
                                    g.this.mRq.removeView(g.this.mQY);
                                    g.this.mQY = null;
                                    if (g.this.mQz != null) {
                                        g.this.mQz.removeMessages(11);
                                        g.this.mQz.A(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.mQY = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, dEJ.mJsonData);
                } else if (dEJ.mAnimationPluginId == 2) {
                    if (this.mQZ == null && this.mRq != null) {
                        this.mQZ = (SVGAImageView) this.mRq.findViewById(a.f.svgaView);
                        if (this.mQZ == null) {
                            this.mQZ = new SVGAImageView(this.mQy);
                            this.mQZ.setClearsAfterStop(true);
                            this.mQZ.setLoops(1);
                            this.mQZ.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.mRq.addView(this.mQZ, layoutParams);
                        }
                    }
                    if (this.mQZ == null) {
                        cVar.removeMessages(11);
                        cVar.A(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.dGd().a(this.mQy, String.valueOf(dEJ.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.mQZ.stopAnimation();
                            g.this.mQZ.clearAnimation();
                            g.this.mQZ.setVisibility(8);
                            g.this.mQZ = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Qv() {
                            g.this.mQZ.stopAnimation();
                            g.this.mQZ.clearAnimation();
                            g.this.mQZ.setVisibility(8);
                            g.this.mQZ = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void Qw() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.mQZ, dEJ);
                }
                if (this.mQY != null) {
                    this.mQY.setTag(dEJ);
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
        if (this.mRa == null) {
            if (this.mQx.mJv != null) {
                int g = this.mQx.mJv.g();
                ChatInfo dEK = this.mQx.mJv.dEK();
                if (dEK == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(dEK, g);
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
        if (this.mRa != null || getContext() == null) {
            if (this.mQz != null) {
                this.mQz.removeMessages(12);
                this.mQz.A(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.mRa = this.mQi.findViewById(a.f.rl_show_tip);
            if (this.mRa != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.dDS().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mQy);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRa.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.mQy, 5.0f);
                    this.mRa.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.mRa = this.mQi.findViewById(a.f.rl_tip);
        }
        if (this.mRa != null) {
            this.mRa.setVisibility(0);
            this.mRa.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mQx != null) {
                            RoomInfo dEO = g.this.mQx.dEO();
                            if (dEO != null) {
                                str = dEO.mRoomID;
                            }
                            if (dEO != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dEO.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mQy, chatInfo.mItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.mRa.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.mRa.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.mQx != null) {
                            RoomInfo dEO = g.this.mQx.dEO();
                            if (dEO != null) {
                                str = dEO.mRoomID;
                            }
                            if (dEO != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(dEO.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.mQy, chatInfo.mItem, com.kascend.chushou.d.e.P("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.mQy.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mQy, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mQy, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0794a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.gv(getContext()).x;
                if (this.mQy.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.mQy, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.mQy, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0794a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.mRa.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.mRa != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.mRa.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.mRa.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.mRm == null) {
                                g.this.mRm = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.mRm.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.mRm.removeAllListeners();
                            }
                            g.this.mRm.playTogether(ObjectAnimator.ofFloat(g.this.mRa, "translationX", g.this.mRa.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.mRm.start();
                            if (g.this.mQz != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.mQz.A(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void dsF() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!dFE() && this.mRa != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.mRa, "translationX", 0.0f, 10.0f, -this.mRa.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.dFE()) {
                        if (g.this.mRa != null) {
                            g.this.mRa.setVisibility(8);
                        }
                        g.this.mRa = null;
                        if (g.this.mQz != null) {
                            g.this.mQz.A(12, 800L);
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
            if (this.mRm == null) {
                this.mRm = new AnimatorSet();
            }
            this.mRm.playTogether(duration);
            this.mRm.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dsG() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.mQy).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.mRb = new EmanateView(this.mQy);
            this.mRb.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.mRb);
            return;
        }
        this.mRb = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.mRd == null) {
            this.mRd = (RoomSendGiftView) this.mQi.findViewById(a.f.normalSendGiftView);
            this.mRd.setContext(this.mQy);
            if (this.mQx != null) {
                this.mRd.a(this.mQx.dEL());
            }
            this.mRd.a(z, z2);
            this.mRd.setVisibilityListener(this.mRn);
            this.mRd.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.mRb != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable Sv = tv.chushou.zues.utils.h.Sv(str);
                            if (Sv == null) {
                                Sv = tv.chushou.zues.utils.h.Sx(str);
                            }
                            g.this.mRb.setDrawable(Sv, (int) (view.getMeasuredWidth() * g.this.a), (int) (view.getMeasuredHeight() * g.this.a));
                            if (view != null) {
                                g.this.mRb.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.a)) / 2.0d)));
                            }
                            g.this.mRb.dSa();
                        }
                    }
                }
            });
            this.mRd.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
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
        if (this.mRd != null) {
            if (this.mQx != null) {
                this.mRd.a(z ? this.mQx.mJA : this.mQx.mJB, this.mQx.mJC, this.mQx.mJD, z);
                this.mRd.setGiftTopIcon(this.mQx.s);
            }
            if (micMemberInfo != null) {
                this.mRd.setMicMemberInfo(micMemberInfo);
            }
            this.mRd.c();
        }
    }

    protected void at(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.mRe.setProgress(i);
            if (!this.mRj) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.mRf.setText(this.mQy.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.mRf.setText(this.mQy.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.mRf.setText(this.mQy.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.mRg.bV(str, a.e.pao_circle_default);
            if (this.mRi != i) {
                this.mRg.startAnimation(AnimationUtils.loadAnimation(this.mQy, a.C0794a.pao_beat_anim));
                this.mRi = i;
            }
            if (this.bb != bangInfo.mLevel) {
                if (this.mQz != null && !this.mQz.Kr(17)) {
                    this.mQz.b(this.mQz.Ks(17), 500L);
                }
                this.bb = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.mRh.b()) {
            WindowManager windowManager = (WindowManager) this.mQy.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                this.mRh.a(this.mQy, i, this.mQx.dEL().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.mRh.e();
        this.mRh.c();
    }

    public void dFG() {
        this.mRg.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.mRg.getWidth() / 2, this.mRg.getHeight() / 2);
        aVar.setDuration(1000L);
        this.mRg.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.mRl == null && this.mQy != null) {
            if ("3".equals(this.aw)) {
                z = h.dDZ().b;
            } else if (this.mQx == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.dDZ().d;
            } else {
                z = h.dDZ().e;
            }
            this.mRl = new CSDanmuLayout(this.mQy.getApplicationContext(), new a.C0909a().Ko(-16711936).Kn(800).xk(true).xl(this.ap >= 0).Km(2).dQV(), h.dDZ().b());
            this.mRl.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.mQy);
            Point gv = tv.chushou.zues.utils.a.gv(this.mQy);
            switch (h.dDZ().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.mQy.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gv.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.mQy.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = gv.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            dFF().addView(this.mRl, 1, layoutParams);
            if (this.mRl != null) {
                this.mRl.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.mRl != null) {
            this.mRl.setVisibility(8);
            this.mRl.dQW();
        }
        if (this.mRl != null) {
            this.mRl.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void S() {
        if (this.mRl != null && this.mQx != null) {
            if (this.ap < 0) {
                this.mRl.setVisibility(h.dDZ().d ? 0 : 8);
            } else {
                this.mRl.setVisibility(h.dDZ().e ? 0 : 8);
            }
        }
        if (this.mRl != null && this.mRl.isPrepared() && !this.H && !this.al) {
            this.mRl.resume();
            this.mRl.dQW();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.mRv == null) {
            if (this.mRt == null) {
                this.mRt = new ArrayList();
            }
            this.mRt.clear();
            aY(getString(a.i.danmu_settings_no_gift), false);
            aY(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.mQy).mHU != null) {
                if (this.mQx.dEL() != null) {
                    this.mRx = this.mQx.dEL().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.mRx)) {
                    aY(getString(a.i.danmu_settings_no_normal), true);
                    this.mRt.addAll(this.mRx);
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
            View inflate = LayoutInflater.from(this.mQy).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mQy));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.mRw = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.mQy).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mRw.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mRw.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.mRu = new com.kascend.chushou.player.adapter.b(i, this.mQy, this.mRt, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.mRu);
            if (!tv.chushou.zues.utils.h.isEmpty(this.mRx) && this.mRx.size() >= 5) {
                this.mRv = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mQy, 165.0f), tv.chushou.zues.utils.a.dip2px(this.mQy, 354.0f));
            } else {
                this.mRv = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mQy, 165.0f), -2);
            }
            this.mRv.setFocusable(true);
            this.mRv.setOutsideTouchable(true);
            this.mRv.setBackgroundDrawable(this.mQy.getResources().getDrawable(a.e.bg_room_pop));
            this.mRv.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dFH() {
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
        if (this.mRt != null) {
            this.mRt.add(privacyItem);
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
        if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "26", "chatType", str2, "chatState", str, "roomId", this.mQx.dEL().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.mRu.notifyDataSetChanged();
        au();
    }

    protected void au() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.dRJ()) {
            tv.chushou.zues.utils.g.c(this.mQy, this.mQy.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.dDV().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.mRu.notifyDataSetChanged();
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
                        g.this.mRu.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.mRu.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.mRt) {
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
                for (PrivacyItem privacyItem3 : this.mRt) {
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
            for (PrivacyItem privacyItem4 : this.mRt) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.mRz == null) {
            this.mRz = new ArrayList<>();
        }
        this.mRz.add(str);
        this.mRz.add(str2);
        p pVar = new p();
        pVar.a = this.mRz;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.mRz == null) {
            this.mRz = new ArrayList<>();
        }
        this.mRz.add(str);
        p pVar = new p();
        pVar.a = this.mRz;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.mRz != null) {
            this.mRz.remove(str);
            this.mRz.remove(str2);
            p pVar = new p();
            pVar.a = this.mRz;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.mRz != null) {
            this.mRz.remove(str);
            p pVar = new p();
            pVar.a = this.mRz;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout dFc = dFc();
        if (dFc != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dFc.getLayoutParams();
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
            dFc.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout dFc = dFc();
        if (dFc != null) {
            dFc.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.dDZ().q()) {
                h.dDZ().g(false);
                this.mQK.c();
                return;
            }
            h.dDZ().g(true);
            this.mQK.b();
        } else if (id == a.f.rl_decode) {
            if (h.dDZ().a) {
                h.dDZ().a(this.mQy, false);
                this.mQM.c();
            } else {
                h.dDZ().a(this.mQy, true);
                this.mQM.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.mQy, dFD(), this.ap < 0);
            ak();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.mQy).q) {
                ((VideoPlayer) this.mQy).q = false;
                if (this.mQx.mJv != null) {
                    this.mQx.mJv.e();
                    this.mQx.mJv.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.mQI.c();
                return;
            }
            ((VideoPlayer) this.mQy).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.mQI.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.dDZ().o();
            if (this.ap < 0) {
                o = h.dDZ().n();
            }
            if (!this.aw.equals("1")) {
                o = h.dDZ().b;
            }
            boolean z = !o;
            if (z) {
                this.mQN.b();
            } else {
                this.mQN.c();
            }
            if (!this.aw.equals("1")) {
                h.dDZ().a(z);
            } else if (this.ap < 0) {
                h.dDZ().e(z);
            } else {
                h.dDZ().f(z);
            }
            switch (h.dDZ().m()) {
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
            com.kascend.chushou.toolkit.a.c.c(this.mQy, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.mQy).q) {
                ((VideoPlayer) this.mQy).q = false;
                if (this.mQx.mJv != null) {
                    this.mQx.mJv.e();
                    this.mQx.mJv.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.mRw.setImageResource(i);
            } else {
                ((VideoPlayer) this.mQy).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.mRw.setImageResource(i2);
            }
            au();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.mRp != null) {
            this.mRp.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0809a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a dFl() {
        return null;
    }

    public GiftAnimationLayout dFc() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void dFv() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo dEO;
        if (this.mQx != null && (dEO = this.mQx.dEO()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!dEO.mOnlineCount.equals(str2) || !dEO.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    dEO.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    dEO.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                dFv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.dDZ().c(true);
        if (this.mRr == null) {
            a();
        }
        if (!this.mRr.isShowing()) {
            if (view != null) {
                this.mRr.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.mQy, 3.0f), (this.mQi.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.mQy, 8.0f));
                RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.mRr != null) {
                            g.this.mRr.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.mRr.dismiss();
    }

    private void a() {
        if (this.mRr == null) {
            View inflate = LayoutInflater.from(this.mQy).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.mQy.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.mQy.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.mRr = new PopupWindow(inflate, -2, -2);
            this.mRr.setFocusable(true);
            this.mRr.setOutsideTouchable(true);
            this.mRr.setAnimationStyle(a.j.gift_toast_style);
            this.mRr.update();
            this.mRr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.mRr = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
