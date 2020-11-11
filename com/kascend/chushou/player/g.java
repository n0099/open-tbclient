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
    protected RelativeLayout pqR;
    protected RelativeLayout pqS;
    protected OnlineToggleButton pqT;
    protected RelativeLayout pqU;
    protected OnlineToggleButton pqV;
    protected RelativeLayout pqW;
    protected OnlineToggleButton pqX;
    protected OnlineToggleButton pqY;
    protected LinearLayout pqZ;
    protected RelativeLayout prA;
    protected PopupWindow prB;
    protected PopupWindow prC;
    protected List<PrivacyItem> prD;
    protected com.kascend.chushou.player.adapter.b prE;
    protected PopupWindow prF;
    protected ImageView prG;
    protected List<PrivacyItem> prH;
    protected FrescoThumbnailView prI;
    protected ArrayList<String> prJ;
    protected PopupWindow pra;
    protected PopupWindow prb;
    protected PopupWindow prc;
    protected RecyclerView prd;
    protected LinearLayoutManager pre;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> prf;
    protected ArrayList<a> prg;
    protected ArrayList<a> prh;
    protected PopupWindow pri;
    protected View prj;
    protected SVGAImageView prk;
    protected View prl;
    protected EmanateView prm;
    protected RoomSendGiftView prn;
    protected RoundProgressBar pro;
    protected TextView prp;
    protected FrescoThumbnailView prq;
    protected PaoGuideView prr;
    protected AnimatorSet prw;
    protected KasBaseMenuView.a prx;
    protected H5Container prz;
    protected boolean aR = false;
    protected int bb = 0;
    protected long prs = 0;
    protected boolean prt = false;
    protected IconConfig.Config pru = new IconConfig.Config();
    protected CSDanmuLayout prv = null;
    protected boolean pry = false;

    /* renamed from: a  reason: collision with root package name */
    private double f4137a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.aa() && g.this.prd != null && g.this.prf != null && g.this.pre != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.pre.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.pre.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.pre.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.pre.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.pre.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.prd.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.pqJ != null) {
                                    g.this.pqJ.N(g.this.d);
                                    if (g.this.b) {
                                        g.this.pqJ.f(g.this.d, 1000L);
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
        if (this.pqR == null) {
            this.pqR = (RelativeLayout) this.pqt.findViewById(a.f.video_root_view);
        }
        return this.pqR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(View view, int i, int i2) {
        if (!this.pry) {
            vC();
        }
        vD();
        if (this.pra != null) {
            if (!this.pra.isShowing()) {
                this.pra.showAtLocation(view, 53, i, i2);
            } else {
                this.pra.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point hD = tv.chushou.zues.utils.a.hD(this.pqI);
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
                if (this.pqI.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = hD.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.etY().b(2);
                layoutParams.width = -1;
                if (this.pqI.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = hD.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.prv != null) {
            this.prv.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(View view, int i, int i2) {
        edL();
        if (this.prb != null) {
            if (!this.prb.isShowing()) {
                if (this.pqI.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.prb.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.prb.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.prb.showAtLocation(view, 53, i, i2);
                return;
            }
            this.prb.dismiss();
        }
    }

    protected void edL() {
        int i = a.h.pop_danmu_full_setting;
        if (this.pqI.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.pqI).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.pqY = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.pqO.equals("1")) {
            if (h.etY().b) {
                this.pqY.b();
            } else {
                this.pqY.c();
            }
        } else if (this.ap < 0) {
            if (h.etY().n()) {
                this.pqY.b();
            } else {
                this.pqY.c();
            }
        } else if (h.etY().o()) {
            this.pqY.b();
        } else {
            this.pqY.c();
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
        if (this.pqI.getResources().getConfiguration().orientation == 1) {
            this.prb = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.pqI, 230.0f), -2);
            this.prb.setBackgroundDrawable(this.pqI.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.prb = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.pqI, 295.0f), -1);
            this.prb.setClippingEnabled(false);
            this.prb.setBackgroundDrawable(this.pqI.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.prb.setFocusable(true);
        this.prb.setOutsideTouchable(true);
        this.prb.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vB() {
        if (!this.pqO.equals("1")) {
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

    protected void vC() {
        ArrayList<PlayUrl> arrayList;
        int i;
        if (!this.pry) {
            int i2 = a.h.pop_full_play_setting;
            if (this.pqI.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.pqI).inflate(i2, (ViewGroup) null);
            this.pqZ = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.pqS = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.pqT = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.pqU = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.pqV = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.pqW = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.pqX = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.pqI.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.pqI);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.N(10.0f);
                }
                this.pqZ.setPadding(this.pqZ.getPaddingLeft(), statusBarHeight, this.pqZ.getPaddingRight(), this.pqZ.getPaddingBottom());
            }
            this.pqS.setOnClickListener(this);
            this.pqU.setOnClickListener(this);
            this.pqW.setOnClickListener(this);
            if (!this.pqO.equals("1") || this.ap < 0) {
                this.pqS.setVisibility(8);
            } else {
                this.pqS.setVisibility(0);
            }
            if (((VideoPlayer) this.pqI).q) {
                this.pqT.b();
            } else {
                this.pqT.c();
            }
            if (h.etY().q()) {
                this.pqV.b();
            } else {
                this.pqV.c();
            }
            if (com.kascend.chushou.c.f4079a) {
                this.pqW.setVisibility(0);
            } else {
                this.pqW.setVisibility(8);
            }
            if (h.etY().f4087a) {
                this.pqX.b();
            } else {
                this.pqX.c();
            }
            if (this.pqH != null && (arrayList = this.pqH.f) != null && arrayList.size() > 0) {
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
                            if (this.pqI.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.pqI).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl euK = this.pqH.euK();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.pqI).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.pqI.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.pqI).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.pqI, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.pqI, 6.0f);
                                    }
                                    int identifier = this.pqI.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.pqI.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.pqZ, playUrl.mName, urlDetails);
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
                            this.pqZ.addView(inflate2);
                            this.pry = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.pqI.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.pqI).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl euK2 = this.pqH.euK();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.pqI).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.pqI.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.pqI).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.pqI, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.pqI, 6.0f);
                                    }
                                    int identifier2 = this.pqI.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.pqI.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.pqZ, playUrl.mName, urlDetails2);
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
                            this.pqZ.addView(inflate3);
                            this.pry = true;
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
            if (this.pqI.getResources().getConfiguration().orientation == 1) {
                this.pra = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.pqI, 230.0f), -2);
                this.pra.setBackgroundDrawable(this.pqI.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.pra = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.pqI, 295.0f), -1);
                this.pra.setClippingEnabled(false);
                this.pra.setBackgroundDrawable(this.pqI.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.pra.setFocusable(true);
            this.pra.setOutsideTouchable(true);
            this.pra.update();
        }
    }

    protected void vD() {
        if (this.pqU != null && this.pqV != null) {
            this.pqU.setVisibility(0);
            if (h.etY().q()) {
                this.pqV.b();
            } else {
                this.pqV.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void edO() {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = null;
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() != -1) {
            com.kascend.chushou.d.e.a(0);
        }
        com.kascend.chushou.toolkit.a.c.a(this.pqI, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.pqH.f;
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
            if (this.pqZ == null) {
                this.pqH.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.pqH.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.pqI).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.pqZ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.pqZ.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.pqI.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.pqI.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.pqZ, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.pqI, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.pqH.f;
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
            if (this.pqZ == null) {
                if (!z) {
                    this.pqH.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.pqH.a(playUrl);
                if (this.ap >= 0) {
                    this.pqH.a(false);
                    if (this.pqI != null) {
                        ((VideoPlayer) this.pqI).b(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.pqI).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.pqZ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.pqZ.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.pqI.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.pqI.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.pqZ, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.pra != null) {
            this.pra.dismiss();
        }
        if (this.prc != null) {
            this.prc.dismiss();
        }
        PlayUrl euK = this.pqH.euK();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.pqH.d) {
                this.pqH.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.pqH.a(playUrl);
                this.pqH.a(false);
                if (this.pqI != null) {
                    ((VideoPlayer) this.pqI).b(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.pqH.d) {
            this.pqH.e = true;
        }
        h.etY().a(this.pqI, urlDetails.mDefinitionType);
        if (z || (euK != null && !euK.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.pqI, evG(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.pqH.a(playUrl);
            if (evG()) {
                if (((VideoPlayer) this.pqI) != null) {
                    ((VideoPlayer) this.pqI).r = -1L;
                }
                if (this.pmW != null) {
                    this.orw = this.pmW.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.pqI).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.pqN = str2;
        if (this.pqJ != null) {
            this.pqJ.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void evj() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.aR = true;
            if (this.prh == null) {
                this.prh = new ArrayList<>();
            }
            this.prh.clear();
            this.prh.addAll(list);
            this.pri = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.pri == null) {
            View inflate = LayoutInflater.from(this.pqI).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.pqI.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.pqI.getResources().getColor(a.c.player_bg_color));
            }
            if (this.aR && !tv.chushou.zues.utils.h.isEmpty(this.prh)) {
                this.prg = this.prh;
            } else {
                this.prg = (ArrayList) h.etY().eua();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.prg)) {
                String[] stringArray = this.pqI.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.pqI.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.prg == null) {
                    this.prg = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.prg.add(aVar);
                }
            }
            this.prd = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.prf = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.prg, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void I(View view, int i4) {
                    a aVar2;
                    if (g.this.pri != null) {
                        g.this.pri.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.prg) && i4 < g.this.prg.size() && (aVar2 = g.this.prg.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.aR) {
                            g.this.prg.remove(i4);
                            g.this.prg.add(0, aVar2);
                            g.this.prf.notifyDataSetChanged();
                            g.this.prd.scrollToPosition(0);
                            RxExecutor.post(g.this.pqs, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.etY().a((Object) g.this.prg);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.pqI, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.pqH != null && g.this.pqH.euJ() != null && g.this.pqH.euJ().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.pqH.euJ().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC1121a view$OnLongClickListenerC1121a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC1121a.a(a.f.tv_name, g.this.pqI.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC1121a.a(a.f.tv_name, g.this.pqI.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC1121a.a(a.f.tv_name, g.this.pqI.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC1121a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.pre = new LinearLayoutManager(this.pqI);
            this.prd.setLayoutManager(this.pre);
            this.prd.setAdapter(this.prf);
            this.prd.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
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
            this.pri = new PopupWindow(inflate, this.pqI.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.pqI.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.pri.setFocusable(true);
            this.pri.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.pri.setBackgroundDrawable(this.pqI.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.pri.setBackgroundDrawable(this.pqI.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.pri.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.pqJ.N(this.d);
        this.pqJ.o(this.d);
    }

    protected void evI() {
        this.b = true;
        this.pqJ.N(this.d);
        this.pqJ.f(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.pqJ != null) {
            this.pqJ.N(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bF(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.pqH != null) {
                RoomInfo euL = this.pqH.euL();
                if (euL != null) {
                    str = euL.mRoomID;
                }
                if (euL != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(euL.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.pqI, listItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.pqt != null) {
            Point hD = tv.chushou.zues.utils.a.hD(this.pqI);
            int i = hD.x > hD.y ? 1 : 2;
            if (this.prz == null) {
                this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.prz.setPlayerViewHelper(this.pqH);
            this.prz.setVisibility(0);
            this.prz.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.pqH != null && (e = this.pqH.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.prz != null) {
            this.prz.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.prj == null && this.prk == null) {
            if (this.pqH.pjA != null) {
                ChatInfo euH = this.pqH.pjA.euH();
                if (euH == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.prA == null) {
                    this.prA = (RelativeLayout) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_plugin_animation)).inflate();
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
                    this.prj = com.kascend.chushou.toolkit.d.a.ewg().a(this.pqI, String.valueOf(euH.mAnimType), this.prA, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.aa() && g.this.prj != null && g.this.prA != null) {
                                Object tag = g.this.prj.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.ewg().a(g.this.pqI, String.valueOf(((ChatInfo) tag).mAnimType), g.this.prA, g.this.prj);
                                }
                                if (!z) {
                                    g.this.prj.setVisibility(8);
                                    g.this.prA.removeView(g.this.prj);
                                    g.this.prj = null;
                                    if (g.this.pqJ != null) {
                                        g.this.pqJ.removeMessages(11);
                                        g.this.pqJ.D(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.prj = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, euH.mJsonData);
                } else if (euH.mAnimationPluginId == 2) {
                    if (this.prk == null && this.prA != null) {
                        this.prk = (SVGAImageView) this.prA.findViewById(a.f.svgaView);
                        if (this.prk == null) {
                            this.prk = new SVGAImageView(this.pqI);
                            this.prk.setClearsAfterStop(true);
                            this.prk.setLoops(1);
                            this.prk.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.prA.addView(this.prk, layoutParams);
                        }
                    }
                    if (this.prk == null) {
                        cVar.removeMessages(11);
                        cVar.D(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.ewg().a(this.pqI, String.valueOf(euH.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.prk.stopAnimation();
                            g.this.prk.clearAnimation();
                            g.this.prk.setVisibility(8);
                            g.this.prk = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void afA() {
                            g.this.prk.stopAnimation();
                            g.this.prk.clearAnimation();
                            g.this.prk.setVisibility(8);
                            g.this.prk = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void afB() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.prk, euH);
                }
                if (this.prj != null) {
                    this.prj.setTag(euH);
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
        if (this.prl == null) {
            if (this.pqH.pjA != null) {
                int g = this.pqH.pjA.g();
                ChatInfo euI = this.pqH.pjA.euI();
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
        if (this.prl != null || getContext() == null) {
            if (this.pqJ != null) {
                this.pqJ.removeMessages(12);
                this.pqJ.D(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.prl = this.pqt.findViewById(a.f.rl_show_tip);
            if (this.prl != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.etQ().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.pqI);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.prl.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.pqI, 5.0f);
                    this.prl.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.prl = this.pqt.findViewById(a.f.rl_tip);
        }
        if (this.prl != null) {
            this.prl.setVisibility(0);
            this.prl.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.pqH != null) {
                            RoomInfo euL = g.this.pqH.euL();
                            if (euL != null) {
                                str = euL.mRoomID;
                            }
                            if (euL != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(euL.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.pqI, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.prl.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.prl.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.pqH != null) {
                            RoomInfo euL = g.this.pqH.euL();
                            if (euL != null) {
                                str = euL.mRoomID;
                            }
                            if (euL != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(euL.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.pqI, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.pqI.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.pqI, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.pqI, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0988a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.hD(getContext()).x;
                if (this.pqI.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.pqI, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.pqI, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0988a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.prl.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.prl != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.prl.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.prl.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.prw == null) {
                                g.this.prw = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.prw.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.prw.removeAllListeners();
                            }
                            g.this.prw.playTogether(ObjectAnimator.ofFloat(g.this.prl, "translationX", g.this.prl.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.prw.start();
                            if (g.this.pqJ != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.pqJ.D(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void aq() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!aa() && this.prl != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.prl, "translationX", 0.0f, 10.0f, -this.prl.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.aa()) {
                        if (g.this.prl != null) {
                            g.this.prl.setVisibility(8);
                        }
                        g.this.prl = null;
                        if (g.this.pqJ != null) {
                            g.this.pqJ.D(12, 800L);
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
            if (this.prw == null) {
                this.prw = new AnimatorSet();
            }
            this.prw.playTogether(duration);
            this.prw.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void edV() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.pqI).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.prm = new EmanateView(this.pqI);
            this.prm.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.prm);
            return;
        }
        this.prm = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.prn == null) {
            this.prn = (RoomSendGiftView) this.pqt.findViewById(a.f.normalSendGiftView);
            this.prn.setContext(this.pqI);
            if (this.pqH != null) {
                this.prn.a(this.pqH.euJ());
            }
            this.prn.a(z, z2);
            this.prn.setVisibilityListener(this.prx);
            this.prn.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.prm != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable aaE = tv.chushou.zues.utils.h.aaE(str);
                            if (aaE == null) {
                                aaE = tv.chushou.zues.utils.h.aaG(str);
                            }
                            g.this.prm.setDrawable(aaE, (int) (view.getMeasuredWidth() * g.this.f4137a), (int) (view.getMeasuredHeight() * g.this.f4137a));
                            if (view != null) {
                                g.this.prm.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.f4137a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.f4137a)) / 2.0d)));
                            }
                            g.this.prm.eId();
                        }
                    }
                }
            });
            this.prn.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
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
        if (this.prn != null) {
            if (this.pqH != null) {
                this.prn.a(z ? this.pqH.pjF : this.pqH.pjG, this.pqH.pjH, this.pqH.pjI, z);
                this.prn.setGiftTopIcon(this.pqH.pjK);
            }
            if (micMemberInfo != null) {
                this.prn.setMicMemberInfo(micMemberInfo);
            }
            this.prn.c();
        }
    }

    protected void aI(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.pro.setProgress(i);
            if (!this.prt) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.prp.setText(this.pqI.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.prp.setText(this.pqI.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.prp.setText(this.pqI.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.prq.ce(str, a.e.pao_circle_default);
            if (this.prs != i) {
                this.prq.startAnimation(AnimationUtils.loadAnimation(this.pqI, a.C0988a.pao_beat_anim));
                this.prs = i;
            }
            if (this.bb != bangInfo.mLevel) {
                if (this.pqJ != null && !this.pqJ.RU(17)) {
                    this.pqJ.b(this.pqJ.RV(17), 500L);
                }
                this.bb = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.prr.b()) {
            WindowManager windowManager = (WindowManager) this.pqI.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                this.prr.a(this.pqI, i, this.pqH.euJ().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.prr.e();
        this.prr.c();
    }

    public void evJ() {
        this.prq.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.prq.getWidth() / 2, this.prq.getHeight() / 2);
        aVar.setDuration(1000L);
        this.prq.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.prv == null && this.pqI != null) {
            if ("3".equals(this.pqO)) {
                z = h.etY().b;
            } else if (this.pqH == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.etY().d;
            } else {
                z = h.etY().e;
            }
            this.prv = new CSDanmuLayout(this.pqI.getApplicationContext(), new a.C1110a().RR(-16711936).RQ(800).Bo(true).Bp(this.ap >= 0).RP(2).eGZ(), h.etY().b());
            this.prv.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.pqI);
            Point hD = tv.chushou.zues.utils.a.hD(this.pqI);
            switch (h.etY().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.pqI.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = hD.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.pqI.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = hD.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            evH().addView(this.prv, 1, layoutParams);
            if (this.prv != null) {
                this.prv.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.prv != null) {
            this.prv.setVisibility(8);
            this.prv.eHa();
        }
        if (this.prv != null) {
            this.prv.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void S() {
        if (this.prv != null && this.pqH != null) {
            if (this.ap < 0) {
                this.prv.setVisibility(h.etY().d ? 0 : 8);
            } else {
                this.prv.setVisibility(h.etY().e ? 0 : 8);
            }
        }
        if (this.prv != null && this.prv.isPrepared() && !this.H && !this.al) {
            this.prv.resume();
            this.prv.eHa();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.prF == null) {
            if (this.prD == null) {
                this.prD = new ArrayList();
            }
            this.prD.clear();
            bo(getString(a.i.danmu_settings_no_gift), false);
            bo(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.pqI).phZ != null) {
                if (this.pqH.euJ() != null) {
                    this.prH = this.pqH.euJ().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.prH)) {
                    bo(getString(a.i.danmu_settings_no_normal), true);
                    this.prD.addAll(this.prH);
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
            View inflate = LayoutInflater.from(this.pqI).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.pqI));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.prG = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.pqI).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.prG.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.prG.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.prE = new com.kascend.chushou.player.adapter.b(i, this.pqI, this.prD, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.prE);
            if (!tv.chushou.zues.utils.h.isEmpty(this.prH) && this.prH.size() >= 5) {
                this.prF = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.pqI, 165.0f), tv.chushou.zues.utils.a.dip2px(this.pqI, 354.0f));
            } else {
                this.prF = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.pqI, 165.0f), -2);
            }
            this.prF.setFocusable(true);
            this.prF.setOutsideTouchable(true);
            this.prF.setBackgroundDrawable(this.pqI.getResources().getDrawable(a.e.bg_room_pop));
            this.prF.update();
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
        if (this.prD != null) {
            this.prD.add(privacyItem);
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
        if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_V8_SO, "chatType", str2, "chatState", str, "roomId", this.pqH.euJ().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.prE.notifyDataSetChanged();
        au();
    }

    protected void au() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.eHM()) {
            tv.chushou.zues.utils.g.d(this.pqI, this.pqI.getString(a.i.s_no_available_network));
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
                    g.this.prE.notifyDataSetChanged();
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
                        g.this.prE.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.prE.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.prD) {
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
                for (PrivacyItem privacyItem3 : this.prD) {
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
            for (PrivacyItem privacyItem4 : this.prD) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.prJ == null) {
            this.prJ = new ArrayList<>();
        }
        this.prJ.add(str);
        this.prJ.add(str2);
        p pVar = new p();
        pVar.f4077a = this.prJ;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.prJ == null) {
            this.prJ = new ArrayList<>();
        }
        this.prJ.add(str);
        p pVar = new p();
        pVar.f4077a = this.prJ;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.prJ != null) {
            this.prJ.remove(str);
            this.prJ.remove(str2);
            p pVar = new p();
            pVar.f4077a = this.prJ;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.prJ != null) {
            this.prJ.remove(str);
            p pVar = new p();
            pVar.f4077a = this.prJ;
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
                this.pqV.c();
                return;
            }
            h.etY().g(true);
            this.pqV.b();
        } else if (id == a.f.rl_decode) {
            if (h.etY().f4087a) {
                h.etY().a(this.pqI, false);
                this.pqX.c();
            } else {
                h.etY().a(this.pqI, true);
                this.pqX.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.pqI, evG(), this.ap < 0);
            evj();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.pqI).q) {
                ((VideoPlayer) this.pqI).q = false;
                if (this.pqH.pjA != null) {
                    this.pqH.pjA.e();
                    this.pqH.pjA.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.pqT.c();
                return;
            }
            ((VideoPlayer) this.pqI).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.pqT.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.etY().o();
            if (this.ap < 0) {
                o = h.etY().n();
            }
            if (!this.pqO.equals("1")) {
                o = h.etY().b;
            }
            boolean z = !o;
            if (z) {
                this.pqY.b();
            } else {
                this.pqY.c();
            }
            if (!this.pqO.equals("1")) {
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
            com.kascend.chushou.toolkit.a.c.c(this.pqI, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.pqI).q) {
                ((VideoPlayer) this.pqI).q = false;
                if (this.pqH.pjA != null) {
                    this.pqH.pjA.e();
                    this.pqH.pjA.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.prG.setImageResource(i);
            } else {
                ((VideoPlayer) this.pqI).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.prG.setImageResource(i2);
            }
            au();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.prz != null) {
            this.prz.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC1003a
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
        if (this.pqH != null && (euL = this.pqH.euL()) != null) {
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
        if (this.prB == null) {
            a();
        }
        if (!this.prB.isShowing()) {
            if (view != null) {
                this.prB.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.pqI, 3.0f), (this.pqt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aI(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.pqI, 8.0f));
                RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.prB != null) {
                            g.this.prB.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.prB.dismiss();
    }

    private void a() {
        if (this.prB == null) {
            View inflate = LayoutInflater.from(this.pqI).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.pqI.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.pqI.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.prB = new PopupWindow(inflate, -2, -2);
            this.prB.setFocusable(true);
            this.prB.setOutsideTouchable(true);
            this.prB.setAnimationStyle(a.j.gift_toast_style);
            this.prB.update();
            this.prB.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.prB = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
