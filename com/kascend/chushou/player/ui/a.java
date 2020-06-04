package com.kascend.chushou.player.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import com.facebook.drawee.span.b;
import com.facebook.drawee.span.c;
import com.google.android.flexbox.FlexboxLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.i;
import com.kascend.chushou.b.a.a.l;
import com.kascend.chushou.b.a.a.m;
import com.kascend.chushou.b.a.a.p;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.constants.FanItem;
import com.kascend.chushou.constants.IconConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.MicStatus;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.d.e;
import com.kascend.chushou.player.VideoPlayer;
import com.kascend.chushou.player.b;
import com.kascend.chushou.player.ui.ShareDanmakuView;
import com.kascend.chushou.player.ui.button.EmbeddedButtonLayout;
import com.kascend.chushou.player.ui.food.FoodView;
import com.kascend.chushou.player.ui.h5.redpacket.RedpacketNotifier;
import com.kascend.chushou.player.ui.miniview.MicStatusView;
import com.kascend.chushou.widget.cswebview.d;
import com.kascend.chushou.widget.gif.EmojiGiftView;
import com.kascend.chushou.widget.gif.b;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.http.Http;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.toolkit.richtext.RichText;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.a.c;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public class a extends Fragment implements View.OnClickListener {
    private ArrayList<ChatInfo> f;
    private ArrayList<ChatInfo> g;
    private ArrayList<ChatInfo> h;
    private ArrayList<ChatInfo> mTA;
    private Button mTC;
    private Animator mTD;
    private Animator mTE;
    private View mTF;
    private Animator mTG;
    private ShareDanmakuView mTH;
    private MicStatusView mTI;
    private ValueAnimator mTJ;
    private EmbeddedButtonLayout mTK;
    private FoodView mTL;
    private FoodView mTM;
    private com.kascend.chushou.player.ui.miniview.a mTN;
    private InteractNotifier mTO;
    private RedpacketNotifier mTP;
    private FrescoThumbnailView mTQ;
    private RoomInfo mTR;
    private HashMap<String, Drawable> mTS;
    private ScrollView mTU;
    private RecyclerView mTx;
    private RecyclerView.LayoutManager mTz;
    private View n;
    private View o;
    private View q;
    private View r;
    private View u;
    private Context a = null;
    private View b = null;
    private b mTy = null;
    private C0804a mTB = null;
    private ArrayList<String> k = null;
    private boolean l = true;
    private boolean I = false;
    private final io.reactivex.disposables.a mTT = new io.reactivex.disposables.a();
    private boolean L = false;

    public static a wF(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("pkMode", z);
        a aVar = new a();
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.a = getActivity();
        tv.chushou.zues.a.a.register(this);
        if (arguments != null) {
            this.L = arguments.getBoolean("pkMode");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(a.h.view_banrrage_page, viewGroup, false);
        this.mTy = ((VideoPlayer) this.a).dEz();
        if (this.mTy != null) {
            this.mTR = this.mTy.dFc();
        }
        this.f = new ArrayList<>();
        if (this.mTR != null) {
            f();
        }
        this.h = new ArrayList<>();
        this.g = new ArrayList<>();
        return this.b;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        ArrayList<ChatInfo> c;
        super.onViewCreated(view, bundle);
        this.mTO = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.mTP = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.mTC = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.mTC.setOnClickListener(this);
        this.mTx = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.mTz = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.a);
        this.mTx.setLayoutManager(this.mTz);
        this.mTx.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.mTx.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.mTx.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.ui.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    a.this.j();
                } else if (i == 1) {
                    a.this.l = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.mTB = new C0804a(this.a);
        this.mTx.setAdapter(this.mTB);
        this.mTB.a(this.f.size());
        this.mTB.notifyDataSetChanged();
        if (this.mTy != null && (c = this.mTy.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        this.mTI = (MicStatusView) this.b.findViewById(a.f.rl_mic_status);
        this.mTI.setOnClickListener(this);
        this.mTL = (FoodView) this.b.findViewById(a.f.top_ad);
        this.mTM = (FoodView) this.b.findViewById(a.f.bottom_ad);
        this.mTU = (ScrollView) this.b.findViewById(a.f.sv);
        this.mTK = (EmbeddedButtonLayout) this.b.findViewById(a.f.embedded_button_layout);
        this.n = this.b.findViewById(a.f.view_reminder_subscribe);
        this.o = this.n.findViewById(a.f.spash_subscribe);
        ((TextView) this.n.findViewById(a.f.tv_reminder_subscribe)).setText(new c().J(this.a, a.e.videoplayer_reminder_subscribe).append(" ").append(this.a.getString(a.i.videoplayer_reminder_subscribe)));
        this.n.setOnClickListener(this);
        this.q = this.b.findViewById(a.f.view_reminder_danmaku);
        this.r = this.q.findViewById(a.f.spash_danmaku);
        ((TextView) this.q.findViewById(a.f.tv_reminder_danmaku)).setText(new c().J(this.a, a.e.videoplayer_reminder_danmaku).append(" ").append(this.a.getString(a.i.videoplayer_reminder_danmaku)));
        this.q.setOnClickListener(this);
        this.mTF = this.b.findViewById(a.f.view_reminder_sendgift);
        this.u = this.mTF.findViewById(a.f.spash_sendgift);
        ((TextView) this.mTF.findViewById(a.f.tv_reminder_sendgift)).setText(new c().J(tv.chushou.basis.d.b.dRy(), a.e.videoplayer_reminder_sendgift).append(" ").append(tv.chushou.widget.a.c.getString(a.i.videoplayer_reminder_sendGift)));
        this.mTF.setOnClickListener(this);
        this.mTH = (ShareDanmakuView) view.findViewById(a.f.share_danmaku_view);
        this.mTH.a(getActivity(), ContextCompat.getColor(this.a, a.c.videoplayer_share_danmaku), new ShareDanmakuView.a() { // from class: com.kascend.chushou.player.ui.a.4
            @Override // com.kascend.chushou.player.ui.ShareDanmakuView.a
            public void a(ChatInfo chatInfo) {
                if (a.this.mTB != null && a.this.mTz != null) {
                    if (a.this.f == null) {
                        a.this.f = new ArrayList();
                        a.this.f();
                    }
                    int size = a.this.f.size();
                    a.this.f.add(chatInfo);
                    a.this.mTB.a(a.this.f.size());
                    a.this.mTB.notifyItemInserted(size);
                    a.this.l = true;
                    if (a.this.mTC != null) {
                        a.this.mTC.setVisibility(8);
                    }
                    a.this.mTz.scrollToPosition(a.this.f.size() - 1);
                }
            }
        }, this.mTy != null ? this.mTy.h : "");
        if (this.mTy != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.a;
            a(this.mTy.b("2"));
            d();
            com.kascend.chushou.player.ui.a.a dEJ = videoPlayer.dEJ();
            this.mTK.a(dEJ.dFZ());
            BangInfo dGa = dEJ.dGa();
            if (dGa != null) {
                this.mTK.a(dGa, dEJ.d());
            }
            this.mTK.b(this.mTy.dFb());
            this.mTO.a(videoPlayer.dEG(), videoPlayer.dEH(), videoPlayer.dEI());
            this.mTP.a(videoPlayer.dEF(), false);
            if (this.mTy.mKJ != null && !h.isEmpty(this.mTy.mKJ.mUrl)) {
                a(this.mTy.mKJ);
            }
            if (this.mTR != null && !this.mTR.mIsSubscribed) {
                RxExecutor.postDelayed(this.mTT, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.mTR == null || !a.this.mTR.mIsSubscribed) {
                            a.this.c(true);
                        }
                    }
                });
            }
            RxExecutor.postDelayed(this.mTT, EventThread.MAIN_THREAD, 5L, TimeUnit.MINUTES, new Runnable() { // from class: com.kascend.chushou.player.ui.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mTy != null && !a.this.mTy.z) {
                        a.this.d(true);
                    }
                }
            });
            if (!h.isEmpty(this.mTy.mKQ)) {
                this.mTK.a(this.mTy.mKQ);
            }
        }
        if (this.mTR != null && !h.isEmpty(this.mTR.mRoomID)) {
            com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, this.L ? 0 : 8);
            aVar.Qy(this.mTR.mRoomID);
            onButtonLayoutLayout(aVar);
        }
    }

    private void a(ListItem listItem) {
        if (this.mTN == null) {
            this.mTN = new com.kascend.chushou.player.ui.miniview.a(this.a, listItem, new d() { // from class: com.kascend.chushou.player.ui.a.10
                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    if (a.this.mTN != null && a.this.b != null && a.this.mTN.a()) {
                        ((ViewGroup) a.this.b).removeView(a.this.mTN);
                        a.this.mTN = null;
                    }
                }

                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(String str) {
                }
            });
            ((ViewGroup) this.b).addView(this.mTN);
            if (listItem.mAutoDisplay == 0) {
                this.mTN.setVisibility(8);
            } else {
                this.mTN.a(a.C0795a.slide_in_top_danmu_anim, a.C0795a.slide_out_top_danmu_anim, this.mTR == null ? "" : this.mTR.mRoomID);
            }
        } else if (!this.mTN.isShown()) {
            this.mTN.a(a.C0795a.slide_in_top_danmu_anim, a.C0795a.slide_out_top_danmu_anim, this.mTR == null ? "" : this.mTR.mRoomID);
        } else {
            return;
        }
        if (listItem.mPackStyle == 1) {
            this.mTK.a(listItem);
        }
    }

    public void a(String str) {
        if (!h.isEmpty(str) && this.a != null && this.b != null) {
            if (this.mTQ == null) {
                this.mTQ = (FrescoThumbnailView) ((ViewStub) this.b.findViewById(a.f.iv_banrrage_bg)).inflate();
            }
            Point gv = tv.chushou.zues.utils.a.gv(this.a);
            int integer = (gv.y - ((gv.x * this.a.getResources().getInteger(a.g.h_thumb_height_def)) / this.a.getResources().getInteger(a.g.h_thumb_width_def))) - this.a.getResources().getDimensionPixelSize(a.d.videoplayer_tab_height);
            this.mTQ.setVisibility(0);
            this.mTQ.i(str, 0, gv.x, integer);
        }
    }

    public void a() {
        if (this.mTQ != null) {
            this.mTQ.setVisibility(8);
        }
    }

    public void b(String str) {
        if (this.mTN != null) {
            this.mTN.a(str);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.I = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.I = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        com.kascend.chushou.toolkit.b.a.b();
        this.mTH.a();
        if (this.mTD != null) {
            this.mTD.removeAllListeners();
            this.mTD.cancel();
            this.mTD = null;
        }
        if (this.mTE != null) {
            this.mTE.removeAllListeners();
            this.mTE.cancel();
            this.mTE = null;
        }
        if (this.mTG != null) {
            this.mTG.removeAllListeners();
            this.mTG.cancel();
            this.mTG = null;
        }
        if (this.mTO != null) {
            this.mTO.c();
        }
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.mTT.dispose();
        super.onDestroy();
        k();
    }

    protected boolean b() {
        return this.a == null || ((Activity) this.a).isFinishing();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_mic_status) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.btn_scrollbottom) {
            if (this.mTx != null) {
                e(true);
            }
        } else if (id == a.f.view_reminder_subscribe) {
            c(false);
            HashMap hashMap = new HashMap(3);
            hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", "73");
            a(hashMap);
        } else if (id == a.f.view_reminder_danmaku) {
            b(false);
            tv.chushou.zues.a.a.post(new i(53, this.a.getResources().getString(a.i.hotword_1)));
            com.kascend.chushou.toolkit.a.c.a(this.a, "双击666_num", null, new Object[0]);
        } else if (id == a.f.view_reminder_sendgift) {
            d(false);
            tv.chushou.zues.a.a.post(new i(56, null));
        }
    }

    public void a(long j) {
        if (this.mTO != null) {
            this.mTO.a(j);
        }
    }

    public void c() {
        if (this.mTO != null) {
            this.mTO.a();
        }
    }

    public void b(long j) {
        if (this.mTO != null) {
            this.mTO.b(j);
        }
    }

    public void a(int i) {
        if (this.mTO != null) {
            this.mTO.a(i);
        }
    }

    public void b(int i) {
        if (this.a != null) {
            this.mTP.a(((VideoPlayer) this.a).dEF(), false);
        }
        this.mTP.a(i, false);
    }

    public void a(IconConfig.Config config) {
        if (this.mTK != null) {
            this.mTK.a(config);
        }
    }

    public void a(BangInfo bangInfo, String str) {
        if (this.mTK != null) {
            this.mTK.a(bangInfo, str);
        }
    }

    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mTK != null) {
            this.mTK.a(j, bangInfo, str);
        }
    }

    public void a(List<ListItem> list) {
        if (this.mTK != null) {
            this.mTK.b(list);
        }
    }

    public void b(List<ListItem> list) {
        if (this.mTK != null) {
            this.mTK.a(list);
        }
    }

    public void d() {
        if (this.mTy.mKI != null && this.mTL != null) {
            this.mTL.a(true, this.mTR == null ? "" : this.mTR.mRoomID);
            this.mTL.a(this.mTy.mKI, a.C0795a.slide_in_top_danmu_anim, a.C0795a.slide_out_top_danmu_anim, false);
        }
        if (this.mTy.mKH != null && this.mTM != null) {
            this.mTM.a(this.mTy.mKH, a.C0795a.slide_in_bottom_danmu_anim, a.C0795a.slide_out_bottom_danmu_anim, true);
        }
        if (this.mTy.mKO != null && this.mTK != null) {
            this.mTK.a(this.mTy.mKO, new FoodView.a() { // from class: com.kascend.chushou.player.ui.a.11
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (a.this.mTy != null) {
                        a.this.mTy.mKO = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    public void b(boolean z) {
        if (z) {
            if (this.n != null && this.n.getVisibility() == 0) {
                this.n.setVisibility(8);
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, a.C0795a.videoplayer_reminder_in);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.13
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.dFX();
                }
            });
            this.q.setVisibility(0);
            this.q.startAnimation(loadAnimation);
            RxExecutor.postDelayed(this.mTT, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.14
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(false);
                }
            });
        } else if (this.q != null && this.q.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.a, a.C0795a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.15
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.mTE != null) {
                        a.this.mTE.removeAllListeners();
                        a.this.mTE.cancel();
                        a.this.mTE = null;
                    }
                    if (a.this.q != null) {
                        a.this.q.setVisibility(8);
                    }
                }
            });
            this.q.startAnimation(loadAnimation2);
        }
    }

    public void c(boolean z) {
        if (z) {
            if (this.n != null && this.n.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                this.o.setVisibility(8);
                Animation loadAnimation = AnimationUtils.loadAnimation(this.a, a.C0795a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.12
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dFW();
                    }
                });
                this.n.setVisibility(0);
                this.n.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mTT, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.c(false);
                    }
                });
            }
        } else if (this.n != null && this.n.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.a, a.C0795a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.17
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.mTD != null) {
                        a.this.mTD.removeAllListeners();
                        a.this.mTD.cancel();
                        a.this.mTD = null;
                    }
                    if (a.this.n != null) {
                        a.this.n.setVisibility(8);
                    }
                }
            });
            this.n.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dFW() {
        if (this.n == null || this.o == null) {
            return null;
        }
        if (this.mTD != null) {
            this.mTD.removeAllListeners();
            this.mTD.cancel();
            this.mTD = null;
        }
        this.o.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.o, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.o, 0.0f);
        int measuredWidth = (this.n.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.a, 13.0f) * 2)) - this.o.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.o, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.o, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.o, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.18
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.mTD != null) {
                    a.this.mTD.removeAllListeners();
                    a.this.mTD.cancel();
                    a.this.mTD = null;
                }
                RxExecutor.postDelayed(a.this.mTT, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dFW();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mTD = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dFX() {
        if (this.q == null || this.r == null) {
            return null;
        }
        if (this.mTE != null) {
            this.mTE.removeAllListeners();
            this.mTE.cancel();
            this.mTE = null;
        }
        this.r.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.r, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.r, 0.0f);
        int measuredWidth = (this.q.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.a, 13.0f) * 2)) - this.r.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.r, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.r, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.r, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.19
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.mTE != null) {
                    a.this.mTE.removeAllListeners();
                    a.this.mTE.cancel();
                    a.this.mTE = null;
                }
                RxExecutor.postDelayed(a.this.mTT, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dFX();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mTE = animatorSet;
        return animatorSet;
    }

    public void d(boolean z) {
        if (z) {
            if (this.mTF != null && this.mTF.getVisibility() != 0) {
                this.u.setVisibility(8);
                Animation loadAnimation = AnimationUtils.loadAnimation(h.dRy(), a.C0795a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.20
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dFY();
                    }
                });
                this.mTF.setVisibility(0);
                this.mTF.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mTT, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.21
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.d(false);
                    }
                });
            }
        } else if (this.mTF != null && this.mTF.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(h.dRy(), a.C0795a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.22
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.mTG != null) {
                        a.this.mTG.removeAllListeners();
                        a.this.mTG.cancel();
                        a.this.mTG = null;
                    }
                    if (a.this.mTF != null) {
                        a.this.mTF.setVisibility(8);
                    }
                }
            });
            this.mTF.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dFY() {
        if (this.mTF == null || this.u == null) {
            return null;
        }
        if (this.mTG != null) {
            this.mTG.removeAllListeners();
            this.mTG.cancel();
            this.mTG = null;
        }
        this.u.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.u, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.u, 0.0f);
        int measuredWidth = (this.mTF.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(h.dRy(), 13.0f) * 2)) - this.u.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.u, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.u, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.u, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.mTG != null) {
                    a.this.mTG.removeAllListeners();
                    a.this.mTG.cancel();
                    a.this.mTG = null;
                }
                RxExecutor.postDelayed(a.this.mTT, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dFY();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mTG = animatorSet;
        return animatorSet;
    }

    @Subscribe
    public void onRefreshPrivilegeEvent(l lVar) {
        if (!b()) {
            RxExecutor.post(this.mTT, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mTB != null) {
                        a.this.mTB.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (!b() && this.a != null && !((Activity) this.a).isFinishing() && pVar != null) {
            this.k = pVar.a;
            if (this.k != null && this.k.contains("4") && this.mTH != null) {
                this.mTH.b();
            }
            e(true);
        }
    }

    @Subscribe
    public void onRefreshSubscriberEvent(m mVar) {
        if (!b() && this.mTR != null && mVar.a(this.mTR.mCreatorUID, this.mTR.mRoomID) && mVar.c && this.n != null) {
            this.n.setVisibility(8);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!b() && bVar.a == 8 && this.mTN != null && this.mTN.getVisibility() != 0) {
            this.mTN.a(a.C0795a.slide_in_top_danmu_anim, a.C0795a.slide_out_top_danmu_anim, this.mTR == null ? "" : this.mTR.mRoomID);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!b()) {
            if (iVar.a == 49) {
                if (!this.I && iVar.b != null) {
                    a(iVar.b.toString());
                }
            } else if (iVar.a == 50 && !this.I && (iVar.b instanceof ListItem)) {
                ListItem listItem = (ListItem) iVar.b;
                if (!h.isEmpty(listItem.mUrl)) {
                    a(listItem);
                }
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!b() && this.mTR != null && !h.isEmpty(this.mTR.mRoomID) && this.mTR.mRoomID.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.mTN != null && this.mTN.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                } else if (this.mTI != null && this.mTI.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                }
                if (this.mTL != null && this.mTL.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mTL.getHeight());
                }
                this.mTU.setTranslationY(r0);
                return;
            }
            if (this.mTJ != null) {
                this.mTJ.cancel();
                this.mTJ = null;
            }
            int translationY = (int) this.mTU.getTranslationY();
            if (aVar.a == 1) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.a, 32.0f) : 0;
                if (this.mTN != null && this.mTN.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                }
                if (this.mTL != null && this.mTL.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mTL.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            } else if (2 == aVar.a) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.a, 65.0f) : 0;
                if (this.mTN != null && this.mTN.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                }
                if (this.mTL != null && this.mTL.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mTL.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            } else if (3 == aVar.a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                } else if (this.mTI != null && this.mTI.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                }
                if (this.mTL != null && this.mTL.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mTL.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            } else if (5 == aVar.a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 64.0f);
                    this.L = true;
                } else {
                    this.L = false;
                    if (this.mTI != null && this.mTI.getVisibility() == 0) {
                        r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                    }
                }
                if (this.mTN != null && this.mTN.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                }
                if (this.mTL != null && this.mTL.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mTL.getHeight());
                }
            } else if (aVar.b == 0) {
                r0 = this.mTL.getHeight();
                if (this.mTN != null && this.mTN.getVisibility() == 0) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 80.0f));
                }
            } else {
                if (this.mTN != null && this.mTN.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                } else if (this.mTI != null && this.mTI.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            }
            if (translationY != r0) {
                a(translationY, r0);
            }
        }
    }

    private void a(int i, int i2) {
        this.mTJ = ValueAnimator.ofInt(i, i2);
        this.mTJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.ui.a.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!a.this.b() && a.this.mTU != null) {
                    a.this.mTU.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mTJ.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.mTJ = null;
            }
        });
        this.mTJ.setInterpolator(new LinearInterpolator());
        this.mTJ.setDuration(800L);
        this.mTJ.start();
    }

    public void a(MicStatus micStatus, List<FanItem> list, String str, boolean z) {
        if (this.mTI != null) {
            if (!this.mTI.isShown()) {
                if (this.mTy != null && this.mTy.dEZ() != null && this.mTy.dEZ().mRoominfo != null) {
                    this.mTI.a(list, str, z, micStatus, this.mTy.dEZ().mRoominfo.mCreatorUID);
                    this.mTI.a(this.mTy.dEZ().mRoominfo.mRoomID);
                }
            } else if (this.mTy != null && this.mTy.dEZ() != null && this.mTy.dEZ().mRoominfo != null) {
                this.mTI.a(list, str, z, micStatus, this.mTy.dEZ().mRoominfo.mCreatorUID);
            }
        }
    }

    public void e() {
        if (this.mTI != null && this.mTI.isShown()) {
            this.mTI.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int childCount = this.mTz.getChildCount();
        int itemCount = this.mTz.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.mTz);
        if (f + childCount >= itemCount) {
            this.l = true;
            if (this.mTC != null) {
                this.mTC.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                e(true);
            }
        }
    }

    public void f() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.f.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.f.add(1, chatInfo2);
    }

    private void e(boolean z) {
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        while (2 < this.f.size()) {
            this.f.remove(2);
        }
        ArrayList<ChatInfo> a = a(this.h);
        if (a == null) {
            f(false);
            return;
        }
        this.f.addAll(a);
        int size = this.f.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.f.size(); i++) {
                this.f.remove(2);
            }
        }
        f(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.mTA == null) {
            this.mTA = new ArrayList<>();
        }
        this.mTA.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.k != null && this.k.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.k.contains("2"))) {
                        this.mTA.add(next);
                    } else if (!this.k.contains(next.mType)) {
                        this.mTA.add(next);
                    }
                }
                return this.mTA;
            }
            return arrayList;
        }
        return null;
    }

    public void c(List<ChatInfo> list) {
        if (!h.isEmpty(list)) {
            if ((this.k == null || !this.k.contains("4")) && this.mTH != null) {
                this.mTH.a(list);
            }
        }
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.f == null) {
                    this.f = new ArrayList<>(arrayList);
                    f();
                    f(z2);
                    return;
                }
                if (this.h == null) {
                    this.h = new ArrayList<>();
                }
                this.h.addAll(arrayList);
                int size = this.h.size();
                if (size > 500) {
                    this.h.subList(0, size - 500).clear();
                }
                ArrayList<ChatInfo> a = a(arrayList);
                int size2 = this.f.size();
                if (a != null) {
                    this.f.addAll(a);
                }
                int size3 = this.f.size();
                if (!this.l && this.mTC != null) {
                    this.mTC.setVisibility(0);
                }
                if (!h.isEmpty(a)) {
                    a(z2, 1, size2, a.size());
                }
                if (size3 > 200) {
                    int i = 0;
                    for (int i2 = 2; i2 < size3 - 100 && i2 < this.f.size(); i2++) {
                        this.f.remove(2);
                        i++;
                    }
                    a(z2, 2, 1, i);
                    return;
                }
                return;
            }
            if (this.f == null) {
                this.f = new ArrayList<>(arrayList);
                f();
            } else {
                if (this.h == null) {
                    this.h = new ArrayList<>();
                }
                this.h.clear();
                this.h.addAll(arrayList);
                this.f.clear();
                f();
                ArrayList<ChatInfo> a2 = a(arrayList);
                if (a2 != null) {
                    this.f.addAll(a2);
                }
            }
            f(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.I) {
            if (this.mTB != null) {
                this.mTB.a(this.f.size());
                if (i == 1) {
                    this.mTB.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.mTB.notifyItemRangeRemoved(i2, i3);
                    this.mTB.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.mTB.notifyDataSetChanged();
                }
            }
            if (z || this.l) {
                this.l = true;
                if (this.mTC != null) {
                    this.mTC.setVisibility(8);
                }
                if (z) {
                    this.mTx.scrollToPosition(this.f.size() - 1);
                } else {
                    this.mTx.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void f(boolean z) {
        if (!this.I) {
            if (this.mTB != null) {
                this.mTB.a(this.f.size());
                this.mTB.notifyDataSetChanged();
            }
            if (z || this.l) {
                this.l = true;
                if (this.mTC != null) {
                    this.mTC.setVisibility(8);
                }
                if (z) {
                    this.mTx.scrollToPosition(this.f.size() - 1);
                } else {
                    this.mTx.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void k() {
        tv.chushou.zues.a.a.ch(this);
        if (this.mTB != null) {
            this.mTB.a(0);
            this.mTB = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.h != null) {
            this.h.clear();
            this.h = null;
        }
        if (this.mTS != null) {
            this.mTS.clear();
            this.mTS = null;
        }
        this.a = null;
        this.b = null;
        this.mTx = null;
        this.mTC = null;
        if (this.mTA != null) {
            this.mTA.clear();
            this.mTA = null;
        }
        if (this.g != null) {
            this.g.clear();
            this.g = null;
        }
        this.mTB = null;
        if (this.k != null) {
            this.k.clear();
            this.k = null;
        }
        this.mTz = null;
        this.mTy = null;
        this.mTR = null;
        this.mTI = null;
        if (this.mTL != null) {
            this.mTL.a();
        }
        if (this.mTM != null) {
            this.mTM.a();
        }
    }

    private void a(Map<String, String> map) {
        String str;
        if (this.mTy != null && this.mTy.dFc() != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            }
            if (h.isEmpty(this.mTy.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.mTy.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            com.kascend.chushou.c.c.dEj().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.a.7
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!a.this.b()) {
                        ParserRet dF = com.kascend.chushou.c.a.dF(jSONObject);
                        if (dF.mRc == 0) {
                            g.F(a.this.a, a.i.subscribe_success);
                            a.this.mTR.mIsSubscribed = true;
                            return;
                        }
                        a(dF.mRc, dF.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!a.this.b()) {
                        if (h.isEmpty(str2)) {
                            str2 = a.this.a.getString(a.i.subscribe_failed);
                        }
                        g.c(a.this.a, str2);
                    }
                }
            }, (String) null, this.mTR.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0804a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        protected Context b;
        private LayoutInflater d;
        private final int m;
        private tv.chushou.zues.a mKf;
        private tv.chushou.zues.a mKg;
        private tv.chushou.zues.a mKh;
        private tv.chushou.zues.a mKi;
        private tv.chushou.zues.a mTZ;
        private final tv.chushou.zues.toolkit.richtext.a mUa;
        private final int n;
        private final int o;
        private final int p;
        private final int q;
        private final JSONObject s;
        private final int t;
        protected int a = 0;
        private final int j = 14;
        private final int k = 18;
        private final int l = 5;
        private final int u = tv.chushou.widget.a.c.B(28.0f);
        private final int v = tv.chushou.widget.a.c.B(21.0f);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$c */
        /* loaded from: classes5.dex */
        public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView c;
            private int d;
            private SimpleDraweeSpanTextView mKs;
            private ChatInfo mKw;

            c(View view) {
                super(view);
                this.mKs = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
                this.c = (TextView) view.findViewById(a.f.tv_share_room);
                this.c.setOnClickListener(this);
                this.c.setText(new tv.chushou.zues.widget.a.c().append(C0804a.this.b.getString(a.i.videoplayer_danmaku_share)).J(C0804a.this.b, a.e.videoplayer_danmaku_share_icon));
                this.d = C0804a.this.q;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kascend.chushou.player.b dEz;
                JSONObject jSONObject = null;
                if (this.mKw != null && this.mKw.mItem != null) {
                    String str = (!(C0804a.this.b instanceof VideoPlayer) || (dEz = ((VideoPlayer) C0804a.this.b).dEz()) == null) ? null : dEz.h;
                    if (!h.isEmpty(str)) {
                        try {
                            jSONObject = new JSONObject(str);
                        } catch (JSONException e) {
                        }
                    }
                    e.a(C0804a.this.b, this.mKw.mItem, jSONObject);
                }
            }

            void a(ChatInfo chatInfo) {
                this.mKw = chatInfo;
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(C0804a.this.b, cVar, chatInfo.mContentRichText, 18, this.d, this.mKs, null, C0804a.this.mUa)) {
                    cVar.a(chatInfo.mContent, new ForegroundColorSpan(this.d));
                }
                this.mKs.setDraweeSpanStringBuilder(cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0806a extends RecyclerView.ViewHolder implements Drawable.Callback {
            SimpleDraweeSpanTextView mKr;

            C0806a(View view) {
                super(view);
                this.mKr = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.mKr != null && ViewCompat.isAttachedToWindow(this.mKr)) {
                    this.mKr.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.mKr != null) {
                    this.mKr.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.mKr != null) {
                    this.mKr.removeCallbacks(runnable);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$b */
        /* loaded from: classes5.dex */
        public class b extends RecyclerView.ViewHolder implements Drawable.Callback {
            View a;
            SimpleDraweeSpanTextView mKs;
            EmojiGiftView mKt;

            b(View view) {
                super(view);
                this.a = view;
                this.mKs = (SimpleDraweeSpanTextView) view.findViewById(a.f.tvTitle);
                this.mKt = (EmojiGiftView) view.findViewById(a.f.tvEmoji);
            }

            void a(ChatInfo chatInfo) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                    com.kascend.chushou.d.d.mIS.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar, C0804a.this.u, C0804a.this.v);
                }
                if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                    for (int i = 0; i < chatInfo.mPrivilegeInfo.mMedals.size(); i++) {
                        String str = chatInfo.mPrivilegeInfo.mMedals.get(i);
                        if (!h.isEmpty(str)) {
                            C0804a.this.a(this.mKs, this, cVar, str, a.e.default_medal_icon, C0804a.this.o, C0804a.this.p);
                        }
                    }
                }
                if (chatInfo.mCoolMessage != null) {
                    tv.chushou.zues.toolkit.richtext.b.a(C0804a.this.b, cVar, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(C0804a.this.b, a.c.banrrage_chat_name_color), this.mKs, " : ", C0804a.this.mUa);
                } else if (!tv.chushou.zues.toolkit.richtext.b.a(C0804a.this.b, cVar, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(C0804a.this.b, a.c.kas_red_n), this.mKs)) {
                    cVar.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(C0804a.this.b.getResources().getColor(a.c.kas_red_n)));
                } else {
                    cVar.a(" : ", new ForegroundColorSpan(C0804a.this.b.getResources().getColor(a.c.kas_red_n)));
                }
                this.mKs.setMovementMethod(tv.chushou.zues.widget.a.b.dSA());
                cVar.setSpan(new tv.chushou.zues.widget.a.a(C0804a.this.mKf), 0, cVar.length() + (-1) > 0 ? cVar.length() - 1 : 0, 17);
                this.mKs.setTag(a.f.tag_position, chatInfo);
                cVar.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.b.1
                    @Override // com.facebook.drawee.span.b.c
                    public void d(com.facebook.drawee.span.b bVar) {
                        if (b.this.mKs != null) {
                            b.this.mKs.measure(0, 0);
                            b.this.mKs.requestLayout();
                        }
                    }
                });
                this.mKs.setDraweeSpanStringBuilder(cVar);
                int B = chatInfo.giftDisplayWidth > 0 ? tv.chushou.widget.a.c.B(chatInfo.giftDisplayWidth) : C0804a.this.t;
                int B2 = chatInfo.giftDisplayHeight > 0 ? tv.chushou.widget.a.c.B(chatInfo.giftDisplayHeight) : C0804a.this.t;
                FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) this.mKt.getLayoutParams();
                layoutParams.width = B;
                layoutParams.height = B2;
                this.mKt.setLayoutParams(layoutParams);
                this.mKt.g(chatInfo.mGift.icon, a.c.transparent, B, B2);
                this.mKt.setOnClickListener(C0804a.this.mKi);
                this.mKt.setTag(a.f.tag_position, Integer.valueOf(chatInfo.mGift.id));
                if (chatInfo.mCoolMessage != null && !h.isEmpty(chatInfo.mCoolMessage.mBgImage)) {
                    com.kascend.chushou.toolkit.b.a.dGi().a(chatInfo.mCoolMessage.mBgImage, this.a, a.e.bg_bubble_default);
                    return;
                }
                this.a.setBackgroundResource(0);
                this.a.setPadding(tv.chushou.zues.utils.a.dip2px(C0804a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0804a.this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(C0804a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0804a.this.b, 5.0f));
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.mKs != null && ViewCompat.isAttachedToWindow(this.mKs)) {
                    this.mKs.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.mKs != null) {
                    this.mKs.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.mKs != null) {
                    this.mKs.removeCallbacks(runnable);
                }
            }
        }

        C0804a(final Context context) {
            this.b = context;
            this.d = LayoutInflater.from(context);
            HashMap hashMap = new HashMap();
            hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            if (a.this.mTR != null) {
                hashMap.put("_fbroomid", a.this.mTR.mRoomID);
            }
            this.s = e.a(hashMap);
            this.mKg = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.1
                @Override // tv.chushou.zues.a
                public void dr(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        com.kascend.chushou.d.a.a(C0804a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.mTR.mCreatorUID, C0804a.this.s);
                    }
                }
            };
            this.mKf = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.2
                @Override // tv.chushou.zues.a
                public void dr(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        if (chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                            if (!chatInfo.mItem.mType.equals("1") || a.this.mTR == null || !chatInfo.mItem.mTargetKey.equals(a.this.mTR.mRoomID)) {
                                a.this.b(chatInfo.mItem);
                                e.a(C0804a.this.b, chatInfo.mItem, C0804a.this.s);
                                return;
                            }
                            return;
                        }
                        com.kascend.chushou.d.a.a(C0804a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.mTR.mCreatorUID, C0804a.this.s);
                    }
                }
            };
            this.mKh = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // tv.chushou.zues.a
                public void dr(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null && chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                        if (!chatInfo.mItem.mType.equals("1") || a.this.mTR == null || !chatInfo.mItem.mTargetKey.equals(a.this.mTR.mRoomID)) {
                            a.this.b(chatInfo.mItem);
                            e.a(C0804a.this.b, chatInfo.mItem, C0804a.this.s);
                        }
                    }
                }
            };
            this.mKi = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // tv.chushou.zues.a
                public void dr(View view) {
                    String valueOf = String.valueOf(view.getTag(a.f.tag_position));
                    if (!TextUtils.isEmpty(valueOf)) {
                        try {
                            com.kascend.chushou.view.b.a.b(valueOf, C0804a.this.s, a.this.mTR.mRoomID).show(((FragmentActivity) context).getSupportFragmentManager(), "emojiDialog");
                        } catch (Exception e) {
                        }
                    }
                }
            };
            this.mTZ = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.5
                @Override // tv.chushou.zues.a
                public void dr(View view) {
                    com.kascend.chushou.d.a.a(C0804a.this.b, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol", tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement_title));
                }
            };
            Drawable drawable = tv.chushou.widget.a.c.getDrawable(a.e.zues_default_gift_color);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.n = tv.chushou.zues.utils.a.dip2px(this.b, 21.0f);
            this.m = (intrinsicWidth * this.n) / intrinsicHeight;
            this.p = tv.chushou.zues.utils.a.dip2px(this.b, 21.0f);
            this.o = this.p;
            this.t = tv.chushou.zues.utils.a.dip2px(this.b, 40.0f);
            this.mUa = new com.kascend.chushou.toolkit.a(tv.chushou.zues.utils.a.dip2px(this.b, 13.0f));
            this.q = ContextCompat.getColor(this.b, a.c.videoplayer_share_danmaku);
        }

        public void a(int i) {
            this.a = i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (a.this.f == null || i >= a.this.f.size() || a.this.f.get(i) == null) {
                return 2;
            }
            ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
            String str = chatInfo.mType;
            if ("-4".equals(str)) {
                return 10000;
            }
            if ("-1".equals(str)) {
                return 1;
            }
            if ("3".equals(str)) {
                return chatInfo.giftType == 2 ? 4 : 2;
            }
            return chatInfo.isShare() ? 3 : 2;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            switch (i) {
                case 1:
                case 10000:
                    return new C0806a(this.d.inflate(a.h.view_banrrage_list_header, viewGroup, false));
                case 3:
                    return new c(this.d.inflate(a.h.chat_msg_share_layout, viewGroup, false));
                case 4:
                    return new b(this.d.inflate(a.h.chat_msg_emoji_layout, viewGroup, false));
                default:
                    return new C0806a(this.d.inflate(a.h.chat_msg_layout, viewGroup, false));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            if (!h.isEmpty(list)) {
                if (a.this.f != null && i < a.this.f.size()) {
                    if (viewHolder instanceof C0806a) {
                        String str = ((ChatInfo) a.this.f.get(i)).mType;
                        C0806a c0806a = (C0806a) viewHolder;
                        if (str.equals("1") || str.equals("3")) {
                            ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                            if (chatInfo != null && c0806a.mKr != null) {
                                c0806a.mKr.setTag(a.f.tag_position, chatInfo);
                                return;
                            }
                            return;
                        } else if (c0806a.mKr != null) {
                            c0806a.mKr.setOnClickListener(null);
                            return;
                        } else {
                            return;
                        }
                    } else if (viewHolder instanceof c) {
                        onBindViewHolder(viewHolder, i);
                        return;
                    } else if (viewHolder instanceof b) {
                        onBindViewHolder(viewHolder, i);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            onBindViewHolder(viewHolder, i);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            int i2;
            int i3;
            if (a.this.f != null && i < a.this.f.size()) {
                switch (getItemViewType(i)) {
                    case 1:
                    case 2:
                        String str = ((ChatInfo) a.this.f.get(i)).mType;
                        final C0806a c0806a = (C0806a) viewHolder;
                        char c2 = 65535;
                        switch (str.hashCode()) {
                            case 49:
                                if (str.equals("1")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 50:
                                if (str.equals("2")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 51:
                                if (str.equals("3")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case 52:
                                if (str.equals("4")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 1444:
                                if (str.equals("-1")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                                if (!h.isEmpty(a.this.mTR.mSystemAnnouncement)) {
                                    ArrayList<RichText> Ss = tv.chushou.zues.toolkit.richtext.b.Ss(a.this.mTR.mSystemAnnouncement);
                                    if (h.isEmpty(Ss)) {
                                        cVar.a(a.this.mTR.mSystemAnnouncement, new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                    } else {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar, Ss, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0806a.mKr);
                                    }
                                } else {
                                    cVar.a(this.b.getString(a.i.danmu_list_title, a.this.mTR.mCreatorNickname), new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                }
                                c0806a.mKr.setText(cVar);
                                c0806a.mKr.setOnClickListener(null);
                                c0806a.mKr.setBackgroundResource(0);
                                return;
                            case 1:
                                ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                                if (chatInfo != null && c0806a.mKr != null) {
                                    tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                                    if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                                        com.kascend.chushou.d.d.mIS.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar2, this.u, this.v);
                                    }
                                    if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                                        int i4 = 0;
                                        while (true) {
                                            int i5 = i4;
                                            if (i5 < chatInfo.mPrivilegeInfo.mMedals.size()) {
                                                String str2 = chatInfo.mPrivilegeInfo.mMedals.get(i5);
                                                if (!h.isEmpty(str2)) {
                                                    a(c0806a.mKr, c0806a, cVar2, str2, a.e.default_medal_icon, this.o, this.p);
                                                }
                                                i4 = i5 + 1;
                                            }
                                        }
                                    }
                                    if (chatInfo.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0806a.mKr, " : ", this.mUa);
                                        int length = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.mKg), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0806a.mKr, null, this.mUa);
                                        i3 = length;
                                    } else {
                                        if (chatInfo.mCoolNickname != null && !h.isEmpty(chatInfo.mCoolNickname.mNickName)) {
                                            cVar2.a(chatInfo.mCoolNickname.mNickName + " : ", new c.a().aZ(chatInfo.mCoolNickname.mFontColors).Hm(chatInfo.mCoolNickname.mNickName.length()).dxg());
                                        } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0806a.mKr, " : ", this.mUa)) {
                                            cVar2.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_name_color)));
                                        }
                                        int length2 = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.mKg), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        if (chatInfo.mCoolContent != null && !h.isEmpty(chatInfo.mCoolContent.mContent)) {
                                            cVar2.a(this.mUa.QB(chatInfo.mCoolContent.mContent), new c.a().aZ(chatInfo.mCoolContent.mFontColors).Hm(chatInfo.mCoolContent.mContent.length()).dxg());
                                            i3 = length2;
                                        } else {
                                            if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0806a.mKr, null, this.mUa)) {
                                                cVar2.a(this.mUa.QB(chatInfo.mContent), new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            i3 = length2;
                                        }
                                    }
                                    cVar2.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.6
                                        @Override // com.facebook.drawee.span.b.c
                                        public void d(com.facebook.drawee.span.b bVar) {
                                            if (c0806a.mKr != null) {
                                                c0806a.mKr.measure(0, 0);
                                                c0806a.mKr.requestLayout();
                                            }
                                        }
                                    });
                                    cVar2.append(" ");
                                    cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.mKf), i3, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                    c0806a.mKr.setDraweeSpanStringBuilder(cVar2);
                                    c0806a.mKr.setTag(a.f.tag_position, chatInfo);
                                    c0806a.mKr.setMovementMethod(tv.chushou.zues.widget.a.b.dSA());
                                    if (chatInfo.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.dGi().a(chatInfo.mCoolMessage.mBgImage, c0806a.mKr, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0806a.mKr.setBackgroundResource(0);
                                    c0806a.mKr.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                    return;
                                }
                                return;
                            case 2:
                            case 3:
                                ChatInfo chatInfo2 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo2 != null && c0806a.mKr != null) {
                                    c0806a.mKr.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar3 = new tv.chushou.zues.widget.a.c();
                                    int i6 = 0;
                                    while (true) {
                                        int i7 = i6;
                                        if (i7 < chatInfo2.mPrivilegeInfo.mMedals.size()) {
                                            String str3 = chatInfo2.mPrivilegeInfo.mMedals.get(i7);
                                            if (!h.isEmpty(str3)) {
                                                a(c0806a.mKr, c0806a, cVar3, str3, a.e.default_medal_icon, this.o, this.p);
                                            }
                                            i6 = i7 + 1;
                                        } else {
                                            if (chatInfo2.mCoolMessage != null) {
                                                tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0806a.mKr, null, this.mUa);
                                            } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0806a.mKr, null, this.mUa)) {
                                                cVar3.a(chatInfo2.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            cVar3.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.7
                                                @Override // com.facebook.drawee.span.b.c
                                                public void d(com.facebook.drawee.span.b bVar) {
                                                    if (c0806a.mKr != null) {
                                                        c0806a.mKr.measure(0, 0);
                                                        c0806a.mKr.requestLayout();
                                                    }
                                                }
                                            });
                                            cVar3.setSpan(new tv.chushou.zues.widget.a.a(this.mKh), 0, cVar3.length() + (-1) > 0 ? cVar3.length() - 1 : 0, 18);
                                            c0806a.mKr.setDraweeSpanStringBuilder(cVar3);
                                            c0806a.mKr.setTag(a.f.tag_position, chatInfo2);
                                            c0806a.mKr.setMovementMethod(tv.chushou.zues.widget.a.b.dSA());
                                            if (chatInfo2.mCoolMessage != null) {
                                                com.kascend.chushou.toolkit.b.a.dGi().a(chatInfo2.mCoolMessage.mBgImage, c0806a.mKr, a.e.bg_bubble_default);
                                                return;
                                            }
                                            c0806a.mKr.setBackgroundResource(0);
                                            c0806a.mKr.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                            return;
                                        }
                                    }
                                } else {
                                    return;
                                }
                                break;
                            case 4:
                                ChatInfo chatInfo3 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo3 != null && c0806a.mKr != null) {
                                    c0806a.mKr.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar4 = new tv.chushou.zues.widget.a.c();
                                    if (chatInfo3.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0806a.mKr, " : ", this.mUa);
                                        int length3 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.mKg), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0806a.mKr, null, this.mUa);
                                        i2 = length3;
                                    } else {
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0806a.mKr)) {
                                            cVar4.a(chatInfo3.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        } else {
                                            cVar4.a(" : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        }
                                        int length4 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.mKg), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0806a.mKr)) {
                                            cVar4.a(chatInfo3.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                        }
                                        i2 = length4;
                                    }
                                    cVar4.append(" ");
                                    if (!h.isEmpty(chatInfo3.mGift.icon)) {
                                        a(c0806a.mKr, c0806a, cVar4, chatInfo3.mGift.icon, a.e.zues_default_gift_color, this.m, this.n);
                                    }
                                    if (chatInfo3.mUserComboCount > 1) {
                                        String valueOf = String.valueOf(chatInfo3.mUserComboCount);
                                        int length5 = valueOf.length();
                                        boolean z = false;
                                        int i8 = 0;
                                        while (i8 < length5) {
                                            String substring = valueOf.substring(i8, i8 + 1);
                                            if (a.this.mTS == null) {
                                                a.this.mTS = new HashMap();
                                            }
                                            Drawable drawable = null;
                                            if (a.this.mTS.containsKey(substring)) {
                                                drawable = (Drawable) a.this.mTS.get(substring);
                                            }
                                            if (drawable == null) {
                                                drawable = this.b.getResources().getDrawable(this.b.getResources().getIdentifier("icon_combo_" + substring, "drawable", this.b.getPackageName()));
                                                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                                a.this.mTS.put(substring, drawable);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable));
                                            i8++;
                                            z = true;
                                        }
                                        if (z) {
                                            Drawable drawable2 = null;
                                            if (a.this.mTS.containsKey("-1")) {
                                                drawable2 = (Drawable) a.this.mTS.get("-1");
                                            }
                                            if (drawable2 == null) {
                                                drawable2 = this.b.getResources().getDrawable(a.e.icon_combo);
                                                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                                                a.this.mTS.put("-1", drawable2);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable2));
                                        }
                                    }
                                    cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.mKf), i2, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 17);
                                    c0806a.mKr.setDraweeSpanStringBuilder(cVar4);
                                    c0806a.mKr.setTag(a.f.tag_position, chatInfo3);
                                    c0806a.mKr.setMovementMethod(tv.chushou.zues.widget.a.b.dSA());
                                    c0806a.mKr.setFocusable(false);
                                    if (chatInfo3.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.dGi().a(chatInfo3.mCoolMessage.mBgImage, c0806a.mKr, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0806a.mKr.setBackgroundResource(0);
                                    c0806a.mKr.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    case 3:
                        ((c) viewHolder).a((ChatInfo) a.this.f.get(i));
                        return;
                    case 4:
                        ((b) viewHolder).a((ChatInfo) a.this.f.get(i));
                        return;
                    case 10000:
                        C0806a c0806a2 = (C0806a) viewHolder;
                        c0806a2.mKr.setOnClickListener(null);
                        tv.chushou.zues.widget.a.c cVar5 = new tv.chushou.zues.widget.a.c();
                        cVar5.a((CharSequence) tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement), new ForegroundColorSpan(Color.parseColor("#ff5959")), new tv.chushou.zues.widget.a.a(this.mTZ), new UnderlineSpan());
                        c0806a2.mKr.setDraweeSpanStringBuilder(cVar5);
                        c0806a2.mKr.setMovementMethod(tv.chushou.zues.widget.a.b.dSA());
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(SimpleDraweeSpanTextView simpleDraweeSpanTextView, Drawable.Callback callback, tv.chushou.zues.widget.a.c cVar, String str, int i, int i2, int i3) {
            if (!h.isEmpty(str)) {
                if (e.a(str)) {
                    cVar.a("", new b.a().a(callback).wJ(true).Jr(i2).Js(i3).QG(str).Jq(i).g(simpleDraweeSpanTextView).dGI());
                    cVar.append(" ");
                    return;
                }
                int length = cVar.length();
                com.facebook.drawee.view.b a = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(a.this.getResources()).Hj(i).dwU(), this.b);
                a.setController(com.facebook.drawee.a.a.c.dvt().PV(str).dwk());
                cVar.append("1");
                cVar.a(a, length, length, i2, i3, true, 2);
                cVar.append(" ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        com.kascend.chushou.player.b dEz;
        if (!h.isEmpty(listItem.mUrl)) {
            Context context = getContext();
            if ((context instanceof VideoPlayer) && (dEz = ((VideoPlayer) context).dEz()) != null && !h.isEmpty(dEz.a)) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("roomId", dEz.a);
                Http http = (Http) tv.chushou.basis.d.b.dRA().S(Http.class);
                if (http != null) {
                    listItem.mUrl = http.packParams(listItem.mUrl, hashMap);
                }
            }
        }
    }
}
