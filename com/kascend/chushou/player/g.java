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
    protected FrescoThumbnailView oqA;
    protected PaoGuideView oqB;
    protected AnimatorSet oqG;
    protected KasBaseMenuView.a oqH;
    protected H5Container oqJ;
    protected RelativeLayout oqK;
    protected PopupWindow oqL;
    protected PopupWindow oqM;
    protected List<PrivacyItem> oqN;
    protected com.kascend.chushou.player.adapter.b oqO;
    protected PopupWindow oqP;
    protected ImageView oqQ;
    protected List<PrivacyItem> oqR;
    protected FrescoThumbnailView oqS;
    protected ArrayList<String> oqT;
    protected RelativeLayout oqb;
    protected RelativeLayout oqc;
    protected OnlineToggleButton oqd;
    protected RelativeLayout oqe;
    protected OnlineToggleButton oqf;
    protected RelativeLayout oqg;
    protected OnlineToggleButton oqh;
    protected OnlineToggleButton oqi;
    protected LinearLayout oqj;
    protected PopupWindow oqk;
    protected PopupWindow oql;
    protected PopupWindow oqm;
    protected RecyclerView oqn;
    protected LinearLayoutManager oqo;
    protected tv.chushou.zues.widget.adapterview.recyclerview.a.a<a> oqp;
    protected ArrayList<a> oqq;
    protected ArrayList<a> oqr;
    protected PopupWindow oqs;
    protected View oqt;
    protected SVGAImageView oqu;
    protected View oqv;
    protected EmanateView oqw;
    protected RoomSendGiftView oqx;
    protected RoundProgressBar oqy;
    protected TextView oqz;
    protected boolean aR = false;
    protected int bb = 0;
    protected long oqC = 0;
    protected boolean oqD = false;
    protected IconConfig.Config oqE = new IconConfig.Config();
    protected CSDanmuLayout oqF = null;
    protected boolean oqI = false;

    /* renamed from: a  reason: collision with root package name */
    private double f4137a = 0.8d;
    private boolean b = false;
    private Runnable d = new Runnable() { // from class: com.kascend.chushou.player.g.21
        @Override // java.lang.Runnable
        public void run() {
            int nextInt;
            if (!g.this.aa() && g.this.oqn != null && g.this.oqp != null && g.this.oqo != null) {
                int findFirstCompletelyVisibleItemPosition = g.this.oqo.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = g.this.oqo.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition > -1 && findFirstCompletelyVisibleItemPosition < g.this.oqo.getItemCount() && findLastCompletelyVisibleItemPosition > -1 && findLastCompletelyVisibleItemPosition < g.this.oqo.getItemCount() && findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition) {
                    do {
                        nextInt = (new Random().nextInt(findLastCompletelyVisibleItemPosition) % ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1)) + findFirstCompletelyVisibleItemPosition;
                    } while (nextInt == g.this.c);
                    g.this.c = nextInt;
                    if (g.this.c > -1 && g.this.c < g.this.oqo.getItemCount()) {
                        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) g.this.oqn.getChildAt(g.this.c - findFirstCompletelyVisibleItemPosition);
                        shimmerFrameLayout.setDuration(2000);
                        shimmerFrameLayout.setRepeatCount(0);
                        shimmerFrameLayout.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.21.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (g.this.opT != null) {
                                    g.this.opT.L(g.this.d);
                                    if (g.this.b) {
                                        g.this.opT.e(g.this.d, 1000L);
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
    public RelativeLayout ehS() {
        if (this.oqb == null) {
            this.oqb = (RelativeLayout) this.opD.findViewById(a.f.video_root_view);
        }
        return this.oqb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(View view, int i, int i2) {
        if (!this.oqI) {
            vC();
        }
        vD();
        if (this.oqk != null) {
            if (!this.oqk.isShowing()) {
                this.oqk.showAtLocation(view, 53, i, i2);
            } else {
                this.oqk.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Point hj = tv.chushou.zues.utils.a.hj(this.opS);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        switch (i) {
            case 0:
                h.egj().b(0);
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                break;
            case 1:
                h.egj().b(1);
                layoutParams.width = -1;
                if (this.opS.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = hj.y / 3;
                }
                layoutParams.addRule(10);
                break;
            case 2:
                h.egj().b(2);
                layoutParams.width = -1;
                if (this.opS.getResources().getConfiguration().orientation == 1) {
                    layoutParams.height = this.aq / 3;
                } else {
                    layoutParams.height = hj.y / 3;
                }
                layoutParams.addRule(12);
                break;
        }
        if (this.oqF != null) {
            this.oqF.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(View view, int i, int i2) {
        dUl();
        if (this.oql != null) {
            if (!this.oql.isShowing()) {
                if (this.opS.getResources().getConfiguration().orientation == 1) {
                    if (this.ap < 0) {
                        this.oql.showAsDropDown(view, i, i2);
                        return;
                    } else {
                        this.oql.showAtLocation(view, 85, i, i2);
                        return;
                    }
                }
                this.oql.showAtLocation(view, 53, i, i2);
                return;
            }
            this.oql.dismiss();
        }
    }

    protected void dUl() {
        int i = a.h.pop_danmu_full_setting;
        if (this.opS.getResources().getConfiguration().orientation == 1) {
            i = a.h.pop_danmu_setting;
        }
        View inflate = LayoutInflater.from(this.opS).inflate(i, (ViewGroup) null);
        inflate.findViewById(a.f.rl_danmu).setOnClickListener(this);
        this.oqi = (OnlineToggleButton) inflate.findViewById(a.f.btn_danmu_toggle);
        if (!this.opY.equals("1")) {
            if (h.egj().b) {
                this.oqi.b();
            } else {
                this.oqi.c();
            }
        } else if (this.ap < 0) {
            if (h.egj().n()) {
                this.oqi.b();
            } else {
                this.oqi.c();
            }
        } else if (h.egj().o()) {
            this.oqi.b();
        } else {
            this.oqi.c();
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
        switch (h.egj().m()) {
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
        if (this.opS.getResources().getConfiguration().orientation == 1) {
            this.oql = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.opS, 230.0f), -2);
            this.oql.setBackgroundDrawable(this.opS.getResources().getDrawable(a.e.bg_room_pop));
        } else {
            this.oql = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.opS, 295.0f), -1);
            this.oql.setClippingEnabled(false);
            this.oql.setBackgroundDrawable(this.opS.getResources().getDrawable(a.e.bg_full_playsetting));
        }
        this.oql.setFocusable(true);
        this.oql.setOutsideTouchable(true);
        this.oql.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vB() {
        if (!this.opY.equals("1")) {
            h.egj().a(true);
        } else if (this.ap < 0) {
            h.egj().e(true);
        } else {
            h.egj().f(true);
        }
        switch (h.egj().m()) {
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
        if (!this.oqI) {
            int i2 = a.h.pop_full_play_setting;
            if (this.opS.getResources().getConfiguration().orientation == 1) {
                i2 = a.h.pop_play_setting;
            }
            View inflate = LayoutInflater.from(this.opS).inflate(i2, (ViewGroup) null);
            this.oqj = (LinearLayout) inflate.findViewById(a.f.ll_pop_root);
            this.oqc = (RelativeLayout) inflate.findViewById(a.f.rl_gift_effect);
            this.oqd = (OnlineToggleButton) inflate.findViewById(a.f.btn_gift_effect_toggle);
            this.oqe = (RelativeLayout) inflate.findViewById(a.f.rl_redpacket_config);
            this.oqf = (OnlineToggleButton) inflate.findViewById(a.f.btn_redpacket_config_toggle);
            this.oqg = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.oqh = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            if (this.opS.getResources().getConfiguration().orientation == 2) {
                int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.opS);
                if (statusBarHeight == 0) {
                    statusBarHeight = tv.chushou.widget.a.c.J(10.0f);
                }
                this.oqj.setPadding(this.oqj.getPaddingLeft(), statusBarHeight, this.oqj.getPaddingRight(), this.oqj.getPaddingBottom());
            }
            this.oqc.setOnClickListener(this);
            this.oqe.setOnClickListener(this);
            this.oqg.setOnClickListener(this);
            if (!this.opY.equals("1") || this.ap < 0) {
                this.oqc.setVisibility(8);
            } else {
                this.oqc.setVisibility(0);
            }
            if (((VideoPlayer) this.opS).q) {
                this.oqd.b();
            } else {
                this.oqd.c();
            }
            if (h.egj().q()) {
                this.oqf.b();
            } else {
                this.oqf.c();
            }
            if (com.kascend.chushou.c.f4079a) {
                this.oqg.setVisibility(0);
            } else {
                this.oqg.setVisibility(8);
            }
            if (h.egj().f4087a) {
                this.oqh.b();
            } else {
                this.oqh.c();
            }
            if (this.opR != null && (arrayList = this.opR.f) != null && arrayList.size() > 0) {
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
                            if (this.opS.getResources().getConfiguration().orientation == 1) {
                                i = a.h.definition_item_audio;
                            } else {
                                i = a.h.definition_item_audio_full;
                            }
                            View inflate2 = LayoutInflater.from(this.opS).inflate(i, (ViewGroup) null, false);
                            ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                            radioGroup.setTag(playUrl);
                            PlayUrl egV = this.opR.egV();
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails = playUrl.mUrlDetails.get(i7);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails.mUrl)) {
                                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.opS).inflate(a.h.definition_item_audio_item, (ViewGroup) null, false);
                                    if (this.opS.getResources().getConfiguration().orientation != 1) {
                                        radioButton = (RadioButton) LayoutInflater.from(this.opS).inflate(a.h.definition_item_audio_item_full, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.opS, 103.0f), -1);
                                    if (i7 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.opS, 6.0f);
                                    }
                                    int identifier = this.opS.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.opS.getPackageName());
                                    if (identifier > 0) {
                                        radioButton.setId(identifier);
                                        radioButton.setLayoutParams(layoutParams);
                                        radioButton.setTag(playUrl);
                                        radioButton.setText(urlDetails.mDefinitionName);
                                        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.17
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.oqj, playUrl.mName, urlDetails);
                                            }
                                        });
                                        radioGroup.addView(radioButton);
                                        if (egV != null && egV.mSelectedUrl.equals(urlDetails.mUrl)) {
                                            radioGroup.check(radioButton.getId());
                                        }
                                    }
                                }
                                i6 = i7 + 1;
                            }
                            this.oqj.addView(inflate2);
                            this.oqI = true;
                            if (i4 == arrayList.size() - 1) {
                                inflate2.findViewById(a.f.diliver).setVisibility(8);
                            } else {
                                inflate2.findViewById(a.f.diliver).setVisibility(0);
                            }
                        } else {
                            if (this.opS.getResources().getConfiguration().orientation == 1) {
                                i5 = a.h.definition_item;
                            }
                            View inflate3 = LayoutInflater.from(this.opS).inflate(i5, (ViewGroup) null, false);
                            ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                            RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                            radioGroup2.setTag(playUrl);
                            PlayUrl egV2 = this.opR.egV();
                            int i8 = 0;
                            while (true) {
                                int i9 = i8;
                                if (i9 >= playUrl.mUrlDetails.size()) {
                                    break;
                                }
                                final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i9);
                                if (!tv.chushou.zues.utils.h.isEmpty(urlDetails2.mDefinitionName) && !tv.chushou.zues.utils.h.isEmpty(urlDetails2.mUrl)) {
                                    RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.opS).inflate(a.h.definition_item_item_full, (ViewGroup) null, false);
                                    if (this.opS.getResources().getConfiguration().orientation == 1) {
                                        radioButton2 = (RadioButton) LayoutInflater.from(this.opS).inflate(a.h.definition_item_item, (ViewGroup) null, false);
                                    }
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.opS, 63.0f), -1);
                                    if (i9 != playUrl.mUrlDetails.size() - 1) {
                                        layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.opS, 6.0f);
                                    }
                                    int identifier2 = this.opS.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.opS.getPackageName());
                                    if (identifier2 > 0) {
                                        radioButton2.setId(identifier2);
                                        radioButton2.setLayoutParams(layoutParams2);
                                        radioButton2.setTag(playUrl);
                                        radioButton2.setText(urlDetails2.mDefinitionName);
                                        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.18
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view) {
                                                g.this.a(view, g.this.oqj, playUrl.mName, urlDetails2);
                                            }
                                        });
                                        radioGroup2.addView(radioButton2);
                                        if (egV2 != null && egV2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                            radioGroup2.check(radioButton2.getId());
                                        }
                                    }
                                }
                                i8 = i9 + 1;
                            }
                            this.oqj.addView(inflate3);
                            this.oqI = true;
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
            if (this.opS.getResources().getConfiguration().orientation == 1) {
                this.oqk = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.opS, 230.0f), -2);
                this.oqk.setBackgroundDrawable(this.opS.getResources().getDrawable(a.e.bg_room_pop));
            } else {
                this.oqk = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.opS, 295.0f), -1);
                this.oqk.setClippingEnabled(false);
                this.oqk.setBackgroundDrawable(this.opS.getResources().getDrawable(a.e.bg_full_playsetting));
            }
            this.oqk.setFocusable(true);
            this.oqk.setOutsideTouchable(true);
            this.oqk.update();
        }
    }

    protected void vD() {
        if (this.oqe != null && this.oqf != null) {
            this.oqe.setVisibility(0);
            if (h.egj().q()) {
                this.oqf.b();
            } else {
                this.oqf.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dUo() {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = null;
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() != -1) {
            com.kascend.chushou.d.e.a(0);
        }
        com.kascend.chushou.toolkit.a.c.a(this.opS, "点击音视切换_num", "音频切视频", new Object[0]);
        ArrayList<PlayUrl> arrayList = this.opR.f;
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
            if (this.oqj == null) {
                this.opR.e = true;
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str4;
                playUrl.mSelectedType = str;
                this.opR.a(playUrl);
                c(playUrl.mName, str2);
                ((VideoPlayer) this.opS).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.oqj.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.oqj.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.opS.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.opS.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.oqj, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
        com.kascend.chushou.toolkit.a.c.a(this.opS, "点击音视切换_num", "视频切音频", new Object[0]);
        p(false);
    }

    protected void p(boolean z) {
        String str;
        String str2;
        String str3;
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str4 = "";
        ArrayList<PlayUrl> arrayList = this.opR.f;
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
            if (this.oqj == null) {
                if (!z) {
                    this.opR.e = true;
                }
                playUrl.mSelectedUrl = str3;
                playUrl.mSelectedSourceId = str;
                playUrl.mSelectedType = str2;
                this.opR.a(playUrl);
                if (this.ap >= 0) {
                    this.opR.a(false);
                    if (this.opS != null) {
                        ((VideoPlayer) this.opS).b(1, null, this.H, false);
                        return;
                    }
                    return;
                }
                c(playUrl.mName, str4);
                ((VideoPlayer) this.opS).a(true, Uri.parse(playUrl.mSelectedUrl), true);
                return;
            }
            int childCount = this.oqj.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RadioGroup radioGroup = (RadioGroup) this.oqj.getChildAt(i2).findViewById(a.f.rg_defi);
                if (radioGroup != null && (playUrl2 = (PlayUrl) radioGroup.getTag()) != null && playUrl2.mName.equals(playUrl.mName) && !tv.chushou.zues.utils.h.isEmpty(playUrl2.mUrlDetails)) {
                    int identifier = this.opS.getResources().getIdentifier("radiobutton_" + playUrl2.mUrlDetails.get(0).mDefinitionType, "id", this.opS.getPackageName());
                    if (identifier > 0) {
                        radioGroup.check(identifier);
                    }
                    a(radioGroup, this.oqj, playUrl.mName, true, playUrl2.mUrlDetails.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, ViewGroup viewGroup, String str, UrlDetails urlDetails) {
        a(view, viewGroup, str, false, urlDetails);
    }

    protected void a(View view, ViewGroup viewGroup, String str, boolean z, UrlDetails urlDetails) {
        if (this.oqk != null) {
            this.oqk.dismiss();
        }
        if (this.oqm != null) {
            this.oqm.dismiss();
        }
        PlayUrl egV = this.opR.egV();
        PlayUrl playUrl = (PlayUrl) view.getTag();
        String str2 = urlDetails.mUrl;
        if ("2".equals(playUrl.mType)) {
            if (!this.opR.d) {
                this.opR.e = true;
            }
            if (this.ap >= 0) {
                playUrl.mSelectedUrl = str2;
                playUrl.mSelectedSourceId = urlDetails.mSourceId;
                playUrl.mSelectedType = urlDetails.mDefinitionType;
                this.opR.a(playUrl);
                this.opR.a(false);
                if (this.opS != null) {
                    ((VideoPlayer) this.opS).b(1, null, this.H, false);
                    return;
                }
                return;
            }
        } else if (this.opR.d) {
            this.opR.e = true;
        }
        h.egj().a(this.opS, urlDetails.mDefinitionType);
        if (z || (egV != null && !egV.mSelectedUrl.equals(str2))) {
            com.kascend.chushou.toolkit.a.c.e(this.opS, ehR(), this.ap < 0);
            playUrl.mSelectedUrl = str2;
            playUrl.mSelectedSourceId = urlDetails.mSourceId;
            playUrl.mSelectedType = urlDetails.mDefinitionType;
            this.opR.a(playUrl);
            if (ehR()) {
                if (((VideoPlayer) this.opS) != null) {
                    ((VideoPlayer) this.opS).r = -1L;
                }
                if (this.omi != null) {
                    this.nFO = this.omi.getCurrentPos();
                }
            }
            c(str, urlDetails.mDefinitionName);
            ((VideoPlayer) this.opS).a(true, Uri.parse(playUrl.mSelectedUrl), true);
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
        this.opX = str2;
        if (this.opT != null) {
            this.opT.removeMessages(19);
        }
        a(str, str2, false);
    }

    protected void ehu() {
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<a> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(list)) {
            this.aR = true;
            if (this.oqr == null) {
                this.oqr = new ArrayList<>();
            }
            this.oqr.clear();
            this.oqr.addAll(list);
            this.oqs = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        a(a.h.list_pop_item, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, final int i2) {
        if (this.oqs == null) {
            View inflate = LayoutInflater.from(this.opS).inflate(a.h.list_popup, (ViewGroup) null);
            if (this.ap < 0) {
                inflate.setBackgroundColor(this.opS.getResources().getColor(a.c.kas_white));
            } else {
                inflate.setBackgroundColor(this.opS.getResources().getColor(a.c.player_bg_color));
            }
            if (this.aR && !tv.chushou.zues.utils.h.isEmpty(this.oqr)) {
                this.oqq = this.oqr;
            } else {
                this.oqq = (ArrayList) h.egj().egl();
            }
            if (tv.chushou.zues.utils.h.isEmpty(this.oqq)) {
                String[] stringArray = this.opS.getResources().getStringArray(a.b.hot_word_display);
                String[] stringArray2 = this.opS.getResources().getStringArray(a.b.hot_word_send);
                int length = stringArray.length;
                if (this.oqq == null) {
                    this.oqq = new ArrayList<>();
                }
                for (int i3 = 0; i3 < length; i3++) {
                    a aVar = new a();
                    aVar.mStrDisplay = stringArray[i3];
                    aVar.mStrSend = stringArray2[i3];
                    this.oqq.add(aVar);
                }
            }
            this.oqn = (RecyclerView) inflate.findViewById(a.f.popup_list);
            this.oqp = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<a>(this.oqq, i, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.g.19
                @Override // tv.chushou.zues.widget.adapterview.d
                public void E(View view, int i4) {
                    a aVar2;
                    if (g.this.oqs != null) {
                        g.this.oqs.dismiss();
                    }
                    if (!tv.chushou.zues.utils.h.isEmpty(g.this.oqq) && i4 < g.this.oqq.size() && (aVar2 = g.this.oqq.get(i4)) != null && g.this.a(aVar2.mStrSend, true)) {
                        if (!g.this.aR) {
                            g.this.oqq.remove(i4);
                            g.this.oqq.add(0, aVar2);
                            g.this.oqp.notifyDataSetChanged();
                            g.this.oqn.scrollToPosition(0);
                            RxExecutor.post(g.this.opC, EventThread.IO, new Runnable() { // from class: com.kascend.chushou.player.g.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.egj().a((Object) g.this.oqq);
                                }
                            });
                        }
                        com.kascend.chushou.toolkit.a.c.a(g.this.opS, aVar2.mStrSend, g.this.ap < 0);
                        if (g.this.opR != null && g.this.opR.egU() != null && g.this.opR.egU().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_DEFAULT, "hotword", aVar2.mStrSend, "roomId", g.this.opR.egU().mRoominfo.mRoomID);
                        }
                    }
                }
            }) { // from class: com.kascend.chushou.player.g.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
                public void a(a.View$OnLongClickListenerC1029a view$OnLongClickListenerC1029a, a aVar2) {
                    if (i2 > 0) {
                        view$OnLongClickListenerC1029a.a(a.f.tv_name, g.this.opS.getResources().getColorStateList(i2));
                    } else if (g.this.ap >= 0) {
                        view$OnLongClickListenerC1029a.a(a.f.tv_name, g.this.opS.getResources().getColorStateList(a.c.popitem_l_color_selector));
                    } else {
                        view$OnLongClickListenerC1029a.a(a.f.tv_name, g.this.opS.getResources().getColorStateList(a.c.popitem_color_select));
                    }
                    if (aVar2 != null) {
                        view$OnLongClickListenerC1029a.a(a.f.tv_name, aVar2.mStrDisplay);
                    }
                }
            };
            this.oqo = new LinearLayoutManager(this.opS);
            this.oqn.setLayoutManager(this.oqo);
            this.oqn.setAdapter(this.oqp);
            this.oqn.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.g.12
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                    if (g.this.ap < 0) {
                        if (i4 == 0) {
                            g.this.ehT();
                        } else {
                            g.this.ao();
                        }
                    }
                    super.onScrollStateChanged(recyclerView, i4);
                }
            });
            this.oqs = new PopupWindow(inflate, this.opS.getResources().getDimensionPixelSize(a.d.popwindow_hotword_width), this.opS.getResources().getDimensionPixelSize(a.d.popwindow_hotword_height));
            this.oqs.setFocusable(true);
            this.oqs.setOutsideTouchable(true);
            if (this.ap < 0) {
                this.oqs.setBackgroundDrawable(this.opS.getResources().getDrawable(a.e.ic_bg_hotpopo));
            } else {
                this.oqs.setBackgroundDrawable(this.opS.getResources().getDrawable(a.e.popwindow_bg));
            }
            this.oqs.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am() {
        this.b = true;
        this.opT.L(this.d);
        this.opT.o(this.d);
    }

    protected void ehT() {
        this.b = true;
        this.opT.L(this.d);
        this.opT.e(this.d, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        this.b = false;
        if (this.opT != null) {
            this.opT.L(this.d);
        }
    }

    @Override // tv.chushou.apollo.CSDanmuLayout.a
    public void bB(Object obj) {
        if (obj != null && (obj instanceof ListItem)) {
            ListItem listItem = (ListItem) obj;
            String str = "";
            if (this.opR != null) {
                RoomInfo egW = this.opR.egW();
                if (egW != null) {
                    str = egW.mRoomID;
                }
                if (egW != null && listItem.mType.equals("1") && listItem.mTargetKey.equals(egW.mRoomID)) {
                    return;
                }
            }
            com.kascend.chushou.d.e.a(this.opS, listItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "67", "_fbroomid", str));
        }
    }

    protected boolean a(String str, boolean z) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "showPopupWebView");
        if (aVar != null && this.opD != null) {
            Point hj = tv.chushou.zues.utils.a.hj(this.opS);
            int i = hj.x > hj.y ? 1 : 2;
            if (this.oqJ == null) {
                this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.oqJ.setPlayerViewHelper(this.opR);
            this.oqJ.setVisibility(0);
            this.oqJ.a(i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap() {
        HashMap e;
        if (this.opR != null && (e = this.opR.e()) != null && e.size() > 0) {
            for (Map.Entry entry : e.entrySet()) {
                c((com.kascend.chushou.player.ui.h5.c.a) entry.getValue());
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (i == 888 && i2 == 666 && this.oqJ != null) {
            this.oqJ.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(tv.chushou.zues.c cVar) {
        if (this.oqt == null && this.oqu == null) {
            if (this.opR.oiN != null) {
                ChatInfo egS = this.opR.oiN.egS();
                if (egS == null) {
                    cVar.removeMessages(11);
                    return;
                }
                if (this.oqK == null) {
                    this.oqK = (RelativeLayout) ((ViewStub) this.opD.findViewById(a.f.videoplayer_plugin_animation)).inflate();
                }
                if (egS.mJsonData != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(egS.mJsonData.toString());
                        jSONObject.put("roomType", this.ay);
                        egS.mJsonData = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (egS.mAnimSubType > 0) {
                    egS.mAnimType = egS.mAnimSubType;
                }
                if (egS.mAnimationPluginId == 1) {
                    this.oqt = com.kascend.chushou.toolkit.d.a.eir().a(this.opS, String.valueOf(egS.mAnimType), this.oqK, new Animation.AnimationListener() { // from class: com.kascend.chushou.player.g.22
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            boolean z;
                            if (!g.this.aa() && g.this.oqt != null && g.this.oqK != null) {
                                Object tag = g.this.oqt.getTag();
                                if (tag == null || !(tag instanceof ChatInfo)) {
                                    z = false;
                                } else {
                                    z = com.kascend.chushou.toolkit.d.a.eir().a(g.this.opS, String.valueOf(((ChatInfo) tag).mAnimType), g.this.oqK, g.this.oqt);
                                }
                                if (!z) {
                                    g.this.oqt.setVisibility(8);
                                    g.this.oqK.removeView(g.this.oqt);
                                    g.this.oqt = null;
                                    if (g.this.opT != null) {
                                        g.this.opT.removeMessages(11);
                                        g.this.opT.D(11, 800L);
                                        return;
                                    }
                                    return;
                                }
                                g.this.oqt = null;
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }, egS.mJsonData);
                } else if (egS.mAnimationPluginId == 2) {
                    if (this.oqu == null && this.oqK != null) {
                        this.oqu = (SVGAImageView) this.oqK.findViewById(a.f.svgaView);
                        if (this.oqu == null) {
                            this.oqu = new SVGAImageView(this.opS);
                            this.oqu.setClearsAfterStop(true);
                            this.oqu.setLoops(1);
                            this.oqu.setId(a.f.svgaView);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(15);
                            this.oqK.addView(this.oqu, layoutParams);
                        }
                    }
                    if (this.oqu == null) {
                        cVar.removeMessages(11);
                        cVar.D(11, 800L);
                        return;
                    }
                    com.kascend.chushou.toolkit.d.a.eir().a(this.opS, String.valueOf(egS.mAnimType), new com.kascend.chushou.toolkit.d.b() { // from class: com.kascend.chushou.player.g.23
                        @Override // com.kascend.chushou.toolkit.d.b
                        public void a() {
                            g.this.oqu.stopAnimation();
                            g.this.oqu.clearAnimation();
                            g.this.oqu.setVisibility(8);
                            g.this.oqu = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void onPause() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void abg() {
                            g.this.oqu.stopAnimation();
                            g.this.oqu.clearAnimation();
                            g.this.oqu.setVisibility(8);
                            g.this.oqu = null;
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void abh() {
                        }

                        @Override // com.opensource.svgaplayer.a
                        public void b(int i, double d) {
                        }
                    }, this.oqu, egS);
                }
                if (this.oqt != null) {
                    this.oqt.setTag(egS);
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
        if (this.oqv == null) {
            if (this.opR.oiN != null) {
                int g = this.opR.oiN.g();
                ChatInfo egT = this.opR.oiN.egT();
                if (egT == null) {
                    cVar.removeMessages(12);
                    return;
                } else {
                    a(egT, g);
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
        if (this.oqv != null || getContext() == null) {
            if (this.opT != null) {
                this.opT.removeMessages(12);
                this.opT.D(12, 800L);
                return;
            }
            return;
        }
        if (getContext().getResources().getConfiguration().orientation != 2) {
            this.oqv = this.opD.findViewById(a.f.rl_show_tip);
            if (this.oqv != null) {
                if (!"2".equals(this.ay) && com.kascend.chushou.b.egb().d == 0) {
                    int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.opS);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.oqv.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight + tv.chushou.zues.utils.a.dip2px(this.opS, 5.0f);
                    this.oqv.setLayoutParams(layoutParams);
                }
            } else {
                return;
            }
        } else {
            this.oqv = this.opD.findViewById(a.f.rl_tip);
        }
        if (this.oqv != null) {
            this.oqv.setVisibility(0);
            this.oqv.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.opR != null) {
                            RoomInfo egW = g.this.opR.egW();
                            if (egW != null) {
                                str = egW.mRoomID;
                            }
                            if (egW != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(egW.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.opS, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) this.oqv.findViewById(a.f.rl_tip_next);
            final SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) this.oqv.findViewById(a.f.tv_content);
            simpleDraweeSpanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.g.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (chatInfo.mItem != null && !tv.chushou.zues.utils.h.isEmpty(chatInfo.mItem.mType)) {
                        String str = "";
                        if (g.this.opR != null) {
                            RoomInfo egW = g.this.opR.egW();
                            if (egW != null) {
                                str = egW.mRoomID;
                            }
                            if (egW != null && chatInfo.mItem.mType.equals("1") && chatInfo.mItem.mTargetKey.equals(egW.mRoomID)) {
                                return;
                            }
                        }
                        com.kascend.chushou.d.e.a(g.this.opS, chatInfo.mItem, com.kascend.chushou.d.e.O("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "68", "_fbroomid", str));
                    }
                }
            });
            simpleDraweeSpanTextView.clearAnimation();
            if (this.opS.getResources().getConfiguration().orientation != 2) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.opS, cVar, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.opS, a.c.color_FFCC00), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0897a.tip_translate));
                }
            } else {
                int i3 = tv.chushou.zues.utils.a.hj(getContext()).x;
                if (this.opS.getResources().getConfiguration().orientation == 2) {
                    i2 = (int) (i3 * 0.7d);
                } else {
                    i2 = (int) (i3 * 0.88d);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = i2;
                relativeLayout.setLayoutParams(layoutParams2);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(this.opS, cVar2, chatInfo.mContentRichText, 14, ContextCompat.getColor(this.opS, a.c.black), simpleDraweeSpanTextView)) {
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
                    simpleDraweeSpanTextView.startAnimation(AnimationUtils.loadAnimation(getActivity(), a.C0897a.tip_translate));
                }
            }
            ViewTreeObserver viewTreeObserver = this.oqv.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.player.g.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    @TargetApi(16)
                    public void onGlobalLayout() {
                        if (g.this.oqv != null) {
                            if (Build.VERSION.SDK_INT < 16) {
                                g.this.oqv.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            } else {
                                g.this.oqv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                            if (g.this.oqG == null) {
                                g.this.oqG = new AnimatorSet();
                            } else {
                                ArrayList<Animator> childAnimations = g.this.oqG.getChildAnimations();
                                if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                                    Iterator<Animator> it = childAnimations.iterator();
                                    while (it.hasNext()) {
                                        it.next().removeAllListeners();
                                    }
                                }
                                g.this.oqG.removeAllListeners();
                            }
                            g.this.oqG.playTogether(ObjectAnimator.ofFloat(g.this.oqv, "translationX", g.this.oqv.getWidth(), 10.0f, 20.0f, 5.0f, 10.0f, 0.0f).setDuration(700L));
                            g.this.oqG.start();
                            if (g.this.opT != null) {
                                long j = 7000;
                                if (i > 10) {
                                    j = 1500;
                                } else if (i > 5) {
                                    j = 7000 - ((i - 5) * 1000);
                                }
                                g.this.opT.D(18, j + 700);
                            }
                        }
                    }
                });
            }
        }
    }

    public void aq() {
        tv.chushou.zues.utils.e.d("VideoPlayerUIBaseFragment", "hideTip");
        if (!aa() && this.oqv != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.oqv, "translationX", 0.0f, 10.0f, -this.oqv.getWidth()).setDuration(700L);
            duration.addListener(new Animator.AnimatorListener() { // from class: com.kascend.chushou.player.g.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!g.this.aa()) {
                        if (g.this.oqv != null) {
                            g.this.oqv.setVisibility(8);
                        }
                        g.this.oqv = null;
                        if (g.this.opT != null) {
                            g.this.opT.D(12, 800L);
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
            if (this.oqG == null) {
                this.oqG = new AnimatorSet();
            }
            this.oqG.playTogether(duration);
            this.oqG.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dUv() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) this.opS).findViewById(16908290);
        View findViewById = viewGroup.findViewById(a.f.video_player_emanate_view);
        if (findViewById == null) {
            this.oqw = new EmanateView(this.opS);
            this.oqw.setId(a.f.video_player_emanate_view);
            viewGroup.addView(this.oqw);
            return;
        }
        this.oqw = (EmanateView) findViewById;
    }

    public void b(boolean z, boolean z2) {
        a(z, z2, (MicMemberInfo) null);
    }

    public void a(boolean z, boolean z2, MicMemberInfo micMemberInfo) {
        if (this.oqx == null) {
            this.oqx = (RoomSendGiftView) this.opD.findViewById(a.f.normalSendGiftView);
            this.oqx.setContext(this.opS);
            if (this.opR != null) {
                this.oqx.a(this.opR.egU());
            }
            this.oqx.a(z, z2);
            this.oqx.setVisibilityListener(this.oqH);
            this.oqx.setOnGiftSendListener(new RoomSendGiftView.c() { // from class: com.kascend.chushou.player.g.5
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.c
                public void a(View view, String str) {
                    if (g.this.oqw != null && view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        if (iArr[0] >= 0 && iArr[1] > 0) {
                            Drawable Yn = tv.chushou.zues.utils.h.Yn(str);
                            if (Yn == null) {
                                Yn = tv.chushou.zues.utils.h.Yp(str);
                            }
                            g.this.oqw.setDrawable(Yn, (int) (view.getMeasuredWidth() * g.this.f4137a), (int) (view.getMeasuredHeight() * g.this.f4137a));
                            if (view != null) {
                                g.this.oqw.setEmanateStartLoc((int) (iArr[0] + ((view.getMeasuredWidth() - (view.getMeasuredWidth() * g.this.f4137a)) / 2.0d)), (int) (iArr[1] + ((view.getMeasuredHeight() - (view.getMeasuredHeight() * g.this.f4137a)) / 2.0d)));
                            }
                            g.this.oqw.euq();
                        }
                    }
                }
            });
            this.oqx.setOnGiftClickListener(new RoomSendGiftView.b() { // from class: com.kascend.chushou.player.g.6
                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void b(ConfigDetail configDetail) {
                    if (configDetail != null) {
                        g.this.b(configDetail);
                    }
                }

                @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.b
                public void a(boolean z3, boolean z4) {
                    g.this.aC(z3, z4);
                }
            });
        }
        if (this.oqx != null) {
            if (this.opR != null) {
                this.oqx.a(z ? this.opR.oiS : this.opR.oiT, this.opR.oiU, this.opR.oiV, z);
                this.oqx.setGiftTopIcon(this.opR.oiX);
            }
            if (micMemberInfo != null) {
                this.oqx.setMicMemberInfo(micMemberInfo);
            }
            this.oqx.c();
        }
    }

    protected void aC(boolean z, boolean z2) {
    }

    public void b(BangInfo bangInfo, String str) {
        if (bangInfo != null) {
            int i = (int) ((((float) bangInfo.mCurPoint) / ((float) bangInfo.mEndPoint)) * 100.0f);
            this.oqy.setProgress(i);
            if (!this.oqD) {
                long j = bangInfo.mEndPoint - bangInfo.mCurPoint;
                if (j <= 0) {
                    this.oqz.setText(this.opS.getString(a.i.pao_full));
                } else if (j < 99999) {
                    this.oqz.setText(this.opS.getString(a.i.pao_leave, String.valueOf(j)));
                } else {
                    this.oqz.setText(this.opS.getString(a.i.pao_leave, tv.chushou.zues.utils.b.formatNumber(String.valueOf(j))));
                }
            }
            this.oqA.bY(str, a.e.pao_circle_default);
            if (this.oqC != i) {
                this.oqA.startAnimation(AnimationUtils.loadAnimation(this.opS, a.C0897a.pao_beat_anim));
                this.oqC = i;
            }
            if (this.bb != bangInfo.mLevel) {
                if (this.opT != null && !this.opT.PI(17)) {
                    this.opT.b(this.opT.PJ(17), 500L);
                }
                this.bb = bangInfo.mLevel;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(boolean z) {
        int i;
        if (!this.oqB.b()) {
            WindowManager windowManager = (WindowManager) this.opS.getSystemService("window");
            int width = (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f);
            if (z) {
                i = (int) (windowManager.getDefaultDisplay().getWidth() * (windowManager.getDefaultDisplay().getWidth() > windowManager.getDefaultDisplay().getHeight() ? 0.4f : 0.7f));
            } else {
                i = width;
            }
            if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                this.oqB.a(this.opS, i, this.opR.egU().mRoominfo.mRoomID);
            } else {
                return;
            }
        }
        this.oqB.e();
        this.oqB.c();
    }

    public void ehU() {
        this.oqA.clearAnimation();
        com.kascend.chushou.widget.b.a aVar = new com.kascend.chushou.widget.b.a(0.0f, -360.0f, 0.0f, 0.0f, this.oqA.getWidth() / 2, this.oqA.getHeight() / 2);
        aVar.setDuration(1000L);
        this.oqA.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Y() {
        boolean z;
        if (this.oqF == null && this.opS != null) {
            if ("3".equals(this.opY)) {
                z = h.egj().b;
            } else if (this.opR == null) {
                z = false;
            } else if (this.ap < 0) {
                z = h.egj().d;
            } else {
                z = h.egj().e;
            }
            this.oqF = new CSDanmuLayout(this.opS.getApplicationContext(), new a.C1018a().PF(-16711936).PE(800).zV(true).zW(this.ap >= 0).PD(2).etm(), h.egj().b());
            this.oqF.setClickDanmuListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = (int) tv.chushou.zues.utils.a.a(1, 10.0f, this.opS);
            Point hj = tv.chushou.zues.utils.a.hj(this.opS);
            switch (h.egj().m()) {
                case 0:
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    layoutParams.addRule(13);
                    break;
                case 1:
                    layoutParams.width = -1;
                    if (this.opS.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = hj.y / 3;
                    }
                    layoutParams.addRule(10);
                    break;
                case 2:
                    layoutParams.width = -1;
                    if (this.opS.getResources().getConfiguration().orientation == 1) {
                        layoutParams.height = this.aq / 3;
                    } else {
                        layoutParams.height = hj.y / 3;
                    }
                    layoutParams.addRule(12);
                    break;
            }
            ehS().addView(this.oqF, 1, layoutParams);
            if (this.oqF != null) {
                this.oqF.setVisibility(z ? 0 : 8);
            }
            r(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void R() {
        if (this.oqF != null) {
            this.oqF.setVisibility(8);
            this.oqF.etn();
        }
        if (this.oqF != null) {
            this.oqF.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void S() {
        if (this.oqF != null && this.opR != null) {
            if (this.ap < 0) {
                this.oqF.setVisibility(h.egj().d ? 0 : 8);
            } else {
                this.oqF.setVisibility(h.egj().e ? 0 : 8);
            }
        }
        if (this.oqF != null && this.oqF.isPrepared() && !this.H && !this.al) {
            this.oqF.resume();
            this.oqF.etn();
        }
    }

    protected void r(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(int i) {
        int i2;
        if (this.oqP == null) {
            if (this.oqN == null) {
                this.oqN = new ArrayList();
            }
            this.oqN.clear();
            bg(getString(a.i.danmu_settings_no_gift), false);
            bg(getString(a.i.danmu_settings_no_system), false);
            if (((VideoPlayer) this.opS).ohp != null) {
                if (this.opR.egU() != null) {
                    this.oqR = this.opR.egU().mPrivacyItems;
                }
                if (!tv.chushou.zues.utils.h.isEmpty(this.oqR)) {
                    bg(getString(a.i.danmu_settings_no_normal), true);
                    this.oqN.addAll(this.oqR);
                } else {
                    bg(getString(a.i.danmu_settings_no_normal), false);
                }
            } else {
                bg(getString(a.i.danmu_settings_no_normal), false);
            }
            if (i == 3) {
                i2 = a.h.pop_privacy_setting_black;
            } else {
                i2 = a.h.pop_privacy_setting;
            }
            View inflate = LayoutInflater.from(this.opS).inflate(i2, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.opS));
            ((TextView) inflate.findViewById(a.f.tv_title)).setText(a.i.danmu_settings_no_gift_effect);
            this.oqQ = (ImageView) inflate.findViewById(a.f.iv_check);
            if (((VideoPlayer) this.opS).q) {
                int i3 = a.e.icon_setting_item_uncheck;
                if (i == 3) {
                    i3 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.oqQ.setImageResource(i3);
            } else {
                int i4 = a.e.icon_setting_item_multi_check;
                if (i == 3) {
                    i4 = a.e.icon_face_show_setting_item_multi_check;
                }
                this.oqQ.setImageResource(i4);
            }
            ((LinearLayout) inflate.findViewById(a.f.rl_content)).setOnClickListener(this);
            this.oqO = new com.kascend.chushou.player.adapter.b(i, this.opS, this.oqN, new com.kascend.chushou.view.a.a<PrivacyItem>() { // from class: com.kascend.chushou.player.g.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kascend.chushou.view.a.a
                /* renamed from: a */
                public void b(View view, PrivacyItem privacyItem) {
                    g.this.a(privacyItem);
                }
            });
            recyclerView.setAdapter(this.oqO);
            if (!tv.chushou.zues.utils.h.isEmpty(this.oqR) && this.oqR.size() >= 5) {
                this.oqP = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.opS, 165.0f), tv.chushou.zues.utils.a.dip2px(this.opS, 354.0f));
            } else {
                this.oqP = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.opS, 165.0f), -2);
            }
            this.oqP.setFocusable(true);
            this.oqP.setOutsideTouchable(true);
            this.oqP.setBackgroundDrawable(this.opS.getResources().getDrawable(a.e.bg_room_pop));
            this.oqP.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ehV() {
        i(2);
    }

    protected void bg(String str, boolean z) {
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
        if (this.oqN != null) {
            this.oqN.add(privacyItem);
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
        if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_V8_SO, "chatType", str2, "chatState", str, "roomId", this.opR.egU().mRoominfo.mRoomID);
        }
        c(privacyItem);
        this.oqO.notifyDataSetChanged();
        au();
    }

    protected void au() {
    }

    protected void b(final PrivacyItem privacyItem) {
        if (!tv.chushou.zues.utils.a.etZ()) {
            tv.chushou.zues.utils.g.c(this.opS, this.opS.getString(a.i.s_no_available_network));
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
            com.kascend.chushou.c.c.ege().e(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.g.8
                @Override // com.kascend.chushou.c.b
                public void a() {
                    privacyItem.mState = 2;
                    g.this.oqO.notifyDataSetChanged();
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
                        g.this.oqO.notifyDataSetChanged();
                        return;
                    }
                    a(-1, "");
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                    privacyItem.mState = i;
                    g.this.oqO.notifyDataSetChanged();
                }
            }, jSONArray.toString());
        }
    }

    protected void c(PrivacyItem privacyItem) {
        if (privacyItem.group) {
            if (privacyItem.mState == 0) {
                for (PrivacyItem privacyItem2 : this.oqN) {
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
                for (PrivacyItem privacyItem3 : this.oqN) {
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
            for (PrivacyItem privacyItem4 : this.oqN) {
                if (privacyItem4.mParentId == privacyItem.mParentId && !privacyItem4.equals(privacyItem)) {
                    privacyItem4.mState = 0;
                }
            }
        }
    }

    protected void d(String str, String str2) {
        if (this.oqT == null) {
            this.oqT = new ArrayList<>();
        }
        this.oqT.add(str);
        this.oqT.add(str2);
        p pVar = new p();
        pVar.f4077a = this.oqT;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void d(String str) {
        if (this.oqT == null) {
            this.oqT = new ArrayList<>();
        }
        this.oqT.add(str);
        p pVar = new p();
        pVar.f4077a = this.oqT;
        tv.chushou.zues.a.a.post(pVar);
    }

    protected void e(String str, String str2) {
        if (this.oqT != null) {
            this.oqT.remove(str);
            this.oqT.remove(str2);
            p pVar = new p();
            pVar.f4077a = this.oqT;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    protected void e(String str) {
        if (this.oqT != null) {
            this.oqT.remove(str);
            p pVar = new p();
            pVar.f4077a = this.oqT;
            tv.chushou.zues.a.a.post(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        GiftAnimationLayout eho = eho();
        if (eho != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) eho.getLayoutParams();
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
            eho.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i) {
        GiftAnimationLayout eho = eho();
        if (eho != null) {
            eho.setLayoutDefaultBg(i);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_redpacket_config) {
            if (h.egj().q()) {
                h.egj().g(false);
                this.oqf.c();
                return;
            }
            h.egj().g(true);
            this.oqf.b();
        } else if (id == a.f.rl_decode) {
            if (h.egj().f4087a) {
                h.egj().a(this.opS, false);
                this.oqh.c();
            } else {
                h.egj().a(this.opS, true);
                this.oqh.a();
            }
            com.kascend.chushou.toolkit.a.c.a(this.opS, ehR(), this.ap < 0);
            ehu();
        } else if (id == a.f.rl_gift_effect) {
            if (((VideoPlayer) this.opS).q) {
                ((VideoPlayer) this.opS).q = false;
                if (this.opR.oiN != null) {
                    this.opR.oiN.e();
                    this.opR.oiN.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                this.oqd.c();
                return;
            }
            ((VideoPlayer) this.opS).q = true;
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
            this.oqd.b();
        } else if (id == a.f.rl_danmu) {
            boolean o = h.egj().o();
            if (this.ap < 0) {
                o = h.egj().n();
            }
            if (!this.opY.equals("1")) {
                o = h.egj().b;
            }
            boolean z = !o;
            if (z) {
                this.oqi.b();
            } else {
                this.oqi.c();
            }
            if (!this.opY.equals("1")) {
                h.egj().a(z);
            } else if (this.ap < 0) {
                h.egj().e(z);
            } else {
                h.egj().f(z);
            }
            switch (h.egj().m()) {
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
            com.kascend.chushou.toolkit.a.c.c(this.opS, this.ap < 0, z ? false : true);
        } else if (id == a.f.rl_content) {
            if (((VideoPlayer) this.opS).q) {
                ((VideoPlayer) this.opS).q = false;
                if (this.opR.oiN != null) {
                    this.opR.oiN.e();
                    this.opR.oiN.b();
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, false));
                int i = a.e.icon_setting_item_multi_check;
                if ("2".equals(this.ay)) {
                    i = a.e.icon_face_show_setting_item_multi_check;
                }
                this.oqQ.setImageResource(i);
            } else {
                ((VideoPlayer) this.opS).q = true;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.f(0, true));
                int i2 = a.e.icon_setting_item_uncheck;
                if ("2".equals(this.ay)) {
                    i2 = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.oqQ.setImageResource(i2);
            }
            au();
        }
    }

    protected void s(boolean z) {
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(BangInfo bangInfo, String str) {
        a(bangInfo);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
        if (aVar != null && this.oqJ != null) {
            this.oqJ.c();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0912a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        c(aVar);
    }

    public com.kascend.chushou.player.b.a ehz() {
        return null;
    }

    public GiftAnimationLayout eho() {
        return null;
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
    }

    public void ehL() {
    }

    public void a(BangInfo bangInfo) {
        RoomInfo egW;
        if (this.opR != null && (egW = this.opR.egW()) != null) {
            String str = bangInfo.mSubscriberCount;
            String str2 = bangInfo.mOnlineCount;
            if (!egW.mOnlineCount.equals(str2) || !egW.mFansCount.equals(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    egW.mOnlineCount = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    egW.mFansCount = str;
                }
                tv.chushou.zues.a.a.post(new q());
                ehL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        h.egj().c(true);
        if (this.oqL == null) {
            a();
        }
        if (!this.oqL.isShowing()) {
            if (view != null) {
                this.oqL.showAtLocation(view, 83, tv.chushou.zues.utils.a.dip2px(this.opS, 3.0f), (this.opD.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aD(getActivity())) - tv.chushou.zues.utils.a.dip2px(this.opS, 8.0f));
                RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.g.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.oqL != null) {
                            g.this.oqL.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        this.oqL.dismiss();
    }

    private void a() {
        if (this.oqL == null) {
            View inflate = LayoutInflater.from(this.opS).inflate(a.h.item_popup_room_newuser_danmu, (ViewGroup) null);
            ((LinearLayout) inflate.findViewById(a.f.ll_new_user)).setBackgroundResource(a.e.bg_newuser_danmu);
            ((TextView) inflate.findViewById(a.f.tv_newuser_01)).setText(this.opS.getString(a.i.str_newuser_danmu1));
            ((TextView) inflate.findViewById(a.f.tv_newuser_02)).setText(this.opS.getString(a.i.str_newuser_danmu2));
            ((ImageView) inflate.findViewById(a.f.iv_newuser)).setImageResource(a.e.ic_newuser_best);
            this.oqL = new PopupWindow(inflate, -2, -2);
            this.oqL.setFocusable(true);
            this.oqL.setOutsideTouchable(true);
            this.oqL.setAnimationStyle(a.j.gift_toast_style);
            this.oqL.update();
            this.oqL.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.g.13
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    g.this.oqL = null;
                }
            });
        }
    }

    protected void b(ConfigDetail configDetail) {
    }
}
