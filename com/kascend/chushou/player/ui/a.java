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
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
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
/* loaded from: classes6.dex */
public class a extends Fragment implements View.OnClickListener {
    private View cfM;
    private ArrayList<ChatInfo> f;
    private ArrayList<ChatInfo> g;
    private ArrayList<ChatInfo> h;
    private ArrayList<ChatInfo> i;
    private Button m;
    private View n;
    private View o;
    private MicStatusView psA;
    private EmbeddedButtonLayout psB;
    private FoodView psC;
    private FoodView psD;
    private com.kascend.chushou.player.ui.miniview.a psE;
    private InteractNotifier psF;
    private RedpacketNotifier psG;
    private FrescoThumbnailView psH;
    private RoomInfo psI;
    private HashMap<String, Drawable> psJ;
    private ScrollView psL;
    private RecyclerView pss;
    private RecyclerView.LayoutManager psu;
    private Animator psw;
    private Animator psx;
    private Animator psy;
    private ShareDanmakuView psz;
    private View q;
    private View r;
    private View u;
    private ValueAnimator y;

    /* renamed from: a  reason: collision with root package name */
    private Context f4147a = null;
    private View b = null;
    private b pst = null;
    private C0997a psv = null;
    private ArrayList<String> k = null;
    private boolean l = true;
    private boolean I = false;
    private final io.reactivex.disposables.a psK = new io.reactivex.disposables.a();
    private boolean L = false;

    public static a AH(boolean z) {
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
        this.f4147a = getActivity();
        tv.chushou.zues.a.a.register(this);
        if (arguments != null) {
            this.L = arguments.getBoolean("pkMode");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(a.h.view_banrrage_page, viewGroup, false);
        this.pst = ((VideoPlayer) this.f4147a).euk();
        if (this.pst != null) {
            this.psI = this.pst.euL();
        }
        this.f = new ArrayList<>();
        if (this.psI != null) {
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
        this.psF = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.psG = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.m = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.m.setOnClickListener(this);
        this.pss = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.psu = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.f4147a);
        this.pss.setLayoutManager(this.psu);
        this.pss.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.pss.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.pss.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.ui.a.1
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
        this.psv = new C0997a(this.f4147a);
        this.pss.setAdapter(this.psv);
        this.psv.a(this.f.size());
        this.psv.notifyDataSetChanged();
        if (this.pst != null && (c = this.pst.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        this.psA = (MicStatusView) this.b.findViewById(a.f.rl_mic_status);
        this.psA.setOnClickListener(this);
        this.psC = (FoodView) this.b.findViewById(a.f.top_ad);
        this.psD = (FoodView) this.b.findViewById(a.f.bottom_ad);
        this.psL = (ScrollView) this.b.findViewById(a.f.sv);
        this.psB = (EmbeddedButtonLayout) this.b.findViewById(a.f.embedded_button_layout);
        this.n = this.b.findViewById(a.f.view_reminder_subscribe);
        this.o = this.n.findViewById(a.f.spash_subscribe);
        ((TextView) this.n.findViewById(a.f.tv_reminder_subscribe)).setText(new c().R(this.f4147a, a.e.videoplayer_reminder_subscribe).append(" ").append(this.f4147a.getString(a.i.videoplayer_reminder_subscribe)));
        this.n.setOnClickListener(this);
        this.q = this.b.findViewById(a.f.view_reminder_danmaku);
        this.r = this.q.findViewById(a.f.spash_danmaku);
        ((TextView) this.q.findViewById(a.f.tv_reminder_danmaku)).setText(new c().R(this.f4147a, a.e.videoplayer_reminder_danmaku).append(" ").append(this.f4147a.getString(a.i.videoplayer_reminder_danmaku)));
        this.q.setOnClickListener(this);
        this.cfM = this.b.findViewById(a.f.view_reminder_sendgift);
        this.u = this.cfM.findViewById(a.f.spash_sendgift);
        ((TextView) this.cfM.findViewById(a.f.tv_reminder_sendgift)).setText(new c().R(tv.chushou.basis.d.b.eHo(), a.e.videoplayer_reminder_sendgift).append(" ").append(tv.chushou.widget.a.c.getString(a.i.videoplayer_reminder_sendGift)));
        this.cfM.setOnClickListener(this);
        this.psz = (ShareDanmakuView) view.findViewById(a.f.share_danmaku_view);
        this.psz.a(getActivity(), ContextCompat.getColor(this.f4147a, a.c.videoplayer_share_danmaku), new ShareDanmakuView.a() { // from class: com.kascend.chushou.player.ui.a.4
            @Override // com.kascend.chushou.player.ui.ShareDanmakuView.a
            public void a(ChatInfo chatInfo) {
                if (a.this.psv != null && a.this.psu != null) {
                    if (a.this.f == null) {
                        a.this.f = new ArrayList();
                        a.this.f();
                    }
                    int size = a.this.f.size();
                    a.this.f.add(chatInfo);
                    a.this.psv.a(a.this.f.size());
                    a.this.psv.notifyItemInserted(size);
                    a.this.l = true;
                    if (a.this.m != null) {
                        a.this.m.setVisibility(8);
                    }
                    a.this.psu.scrollToPosition(a.this.f.size() - 1);
                }
            }
        }, this.pst != null ? this.pst.h : "");
        if (this.pst != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.f4147a;
            a(this.pst.b("2"));
            d();
            com.kascend.chushou.player.ui.a.a euu = videoPlayer.euu();
            this.psB.a(euu.evO());
            BangInfo evP = euu.evP();
            if (evP != null) {
                this.psB.a(evP, euu.d());
            }
            this.psB.b(this.pst.i());
            this.psF.a(videoPlayer.eur(), videoPlayer.eus(), videoPlayer.eut());
            this.psG.a(videoPlayer.euq(), false);
            if (this.pst.pjE != null && !h.isEmpty(this.pst.pjE.mUrl)) {
                a(this.pst.pjE);
            }
            if (this.psI != null && !this.psI.mIsSubscribed) {
                RxExecutor.postDelayed(this.psK, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.psI == null || !a.this.psI.mIsSubscribed) {
                            a.this.c(true);
                        }
                    }
                });
            }
            RxExecutor.postDelayed(this.psK, EventThread.MAIN_THREAD, 5L, TimeUnit.MINUTES, new Runnable() { // from class: com.kascend.chushou.player.ui.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.pst != null && !a.this.pst.z) {
                        a.this.d(true);
                    }
                }
            });
            if (!h.isEmpty(this.pst.pjM)) {
                this.psB.a(this.pst.pjM);
            }
        }
        if (this.psI != null && !h.isEmpty(this.psI.mRoomID)) {
            com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, this.L ? 0 : 8);
            aVar.YH(this.psI.mRoomID);
            onButtonLayoutLayout(aVar);
        }
    }

    private void a(ListItem listItem) {
        if (this.psE == null) {
            this.psE = new com.kascend.chushou.player.ui.miniview.a(this.f4147a, listItem, new d() { // from class: com.kascend.chushou.player.ui.a.10
                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    if (a.this.psE != null && a.this.b != null && a.this.psE.a()) {
                        ((ViewGroup) a.this.b).removeView(a.this.psE);
                        a.this.psE = null;
                    }
                }

                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(String str) {
                }
            });
            ((ViewGroup) this.b).addView(this.psE);
            if (listItem.mAutoDisplay == 0) {
                this.psE.setVisibility(8);
            } else {
                this.psE.a(a.C0988a.slide_in_top_danmu_anim, a.C0988a.slide_out_top_danmu_anim, this.psI == null ? "" : this.psI.mRoomID);
            }
        } else if (!this.psE.isShown()) {
            this.psE.a(a.C0988a.slide_in_top_danmu_anim, a.C0988a.slide_out_top_danmu_anim, this.psI == null ? "" : this.psI.mRoomID);
        } else {
            return;
        }
        if (listItem.mPackStyle == 1) {
            this.psB.a(listItem);
        }
    }

    public void a(String str) {
        if (!h.isEmpty(str) && this.f4147a != null && this.b != null) {
            if (this.psH == null) {
                this.psH = (FrescoThumbnailView) ((ViewStub) this.b.findViewById(a.f.iv_banrrage_bg)).inflate();
            }
            Point hD = tv.chushou.zues.utils.a.hD(this.f4147a);
            int integer = (hD.y - ((hD.x * this.f4147a.getResources().getInteger(a.g.h_thumb_height_def)) / this.f4147a.getResources().getInteger(a.g.h_thumb_width_def))) - this.f4147a.getResources().getDimensionPixelSize(a.d.videoplayer_tab_height);
            this.psH.setVisibility(0);
            this.psH.i(str, 0, hD.x, integer);
        }
    }

    public void a() {
        if (this.psH != null) {
            this.psH.setVisibility(8);
        }
    }

    public void b(String str) {
        if (this.psE != null) {
            this.psE.a(str);
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
        this.psz.a();
        if (this.psw != null) {
            this.psw.removeAllListeners();
            this.psw.cancel();
            this.psw = null;
        }
        if (this.psx != null) {
            this.psx.removeAllListeners();
            this.psx.cancel();
            this.psx = null;
        }
        if (this.psy != null) {
            this.psy.removeAllListeners();
            this.psy.cancel();
            this.psy = null;
        }
        if (this.psF != null) {
            this.psF.c();
        }
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.psK.dispose();
        super.onDestroy();
        k();
    }

    protected boolean b() {
        return this.f4147a == null || ((Activity) this.f4147a).isFinishing();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_mic_status) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.btn_scrollbottom) {
            if (this.pss != null) {
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
            tv.chushou.zues.a.a.post(new i(53, this.f4147a.getResources().getString(a.i.hotword_1)));
            com.kascend.chushou.toolkit.a.c.a(this.f4147a, "双击666_num", null, new Object[0]);
        } else if (id == a.f.view_reminder_sendgift) {
            d(false);
            tv.chushou.zues.a.a.post(new i(56, null));
        }
    }

    public void a(long j) {
        if (this.psF != null) {
            this.psF.a(j);
        }
    }

    public void c() {
        if (this.psF != null) {
            this.psF.a();
        }
    }

    public void b(long j) {
        if (this.psF != null) {
            this.psF.b(j);
        }
    }

    public void a(int i) {
        if (this.psF != null) {
            this.psF.a(i);
        }
    }

    public void b(int i) {
        if (this.f4147a != null) {
            this.psG.a(((VideoPlayer) this.f4147a).euq(), false);
        }
        this.psG.a(i, false);
    }

    public void a(IconConfig.Config config) {
        if (this.psB != null) {
            this.psB.a(config);
        }
    }

    public void a(BangInfo bangInfo, String str) {
        if (this.psB != null) {
            this.psB.a(bangInfo, str);
        }
    }

    public void a(long j, BangInfo bangInfo, String str) {
        if (this.psB != null) {
            this.psB.a(j, bangInfo, str);
        }
    }

    public void a(List<ListItem> list) {
        if (this.psB != null) {
            this.psB.b(list);
        }
    }

    public void b(List<ListItem> list) {
        if (this.psB != null) {
            this.psB.a(list);
        }
    }

    public void d() {
        if (this.pst.pjD != null && this.psC != null) {
            this.psC.a(true, this.psI == null ? "" : this.psI.mRoomID);
            this.psC.a(this.pst.pjD, a.C0988a.slide_in_top_danmu_anim, a.C0988a.slide_out_top_danmu_anim, false);
        }
        if (this.pst.pjC != null && this.psD != null) {
            this.psD.a(this.pst.pjC, a.C0988a.slide_in_bottom_danmu_anim, a.C0988a.slide_out_bottom_danmu_anim, true);
        }
        if (this.pst.pjJ != null && this.psB != null) {
            this.psB.a(this.pst.pjJ, new FoodView.a() { // from class: com.kascend.chushou.player.ui.a.11
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (a.this.pst != null) {
                        a.this.pst.pjJ = null;
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f4147a, a.C0988a.videoplayer_reminder_in);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.13
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.evM();
                }
            });
            this.q.setVisibility(0);
            this.q.startAnimation(loadAnimation);
            RxExecutor.postDelayed(this.psK, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.14
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(false);
                }
            });
        } else if (this.q != null && this.q.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f4147a, a.C0988a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.15
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.psx != null) {
                        a.this.psx.removeAllListeners();
                        a.this.psx.cancel();
                        a.this.psx = null;
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
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f4147a, a.C0988a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.12
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.evL();
                    }
                });
                this.n.setVisibility(0);
                this.n.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.psK, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.c(false);
                    }
                });
            }
        } else if (this.n != null && this.n.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f4147a, a.C0988a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.17
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.psw != null) {
                        a.this.psw.removeAllListeners();
                        a.this.psw.cancel();
                        a.this.psw = null;
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
    public Animator evL() {
        if (this.n == null || this.o == null) {
            return null;
        }
        if (this.psw != null) {
            this.psw.removeAllListeners();
            this.psw.cancel();
            this.psw = null;
        }
        this.o.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.o, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.o, 0.0f);
        int measuredWidth = (this.n.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.f4147a, 13.0f) * 2)) - this.o.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.o, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.o, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.o, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.18
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.psw != null) {
                    a.this.psw.removeAllListeners();
                    a.this.psw.cancel();
                    a.this.psw = null;
                }
                RxExecutor.postDelayed(a.this.psK, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.evL();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.psw = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator evM() {
        if (this.q == null || this.r == null) {
            return null;
        }
        if (this.psx != null) {
            this.psx.removeAllListeners();
            this.psx.cancel();
            this.psx = null;
        }
        this.r.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.r, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.r, 0.0f);
        int measuredWidth = (this.q.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.f4147a, 13.0f) * 2)) - this.r.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.r, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.r, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.r, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.19
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.psx != null) {
                    a.this.psx.removeAllListeners();
                    a.this.psx.cancel();
                    a.this.psx = null;
                }
                RxExecutor.postDelayed(a.this.psK, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.evM();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.psx = animatorSet;
        return animatorSet;
    }

    public void d(boolean z) {
        if (z) {
            if (this.cfM != null && this.cfM.getVisibility() != 0) {
                this.u.setVisibility(8);
                Animation loadAnimation = AnimationUtils.loadAnimation(h.eHo(), a.C0988a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.20
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.evN();
                    }
                });
                this.cfM.setVisibility(0);
                this.cfM.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.psK, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.21
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.d(false);
                    }
                });
            }
        } else if (this.cfM != null && this.cfM.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(h.eHo(), a.C0988a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.22
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.psy != null) {
                        a.this.psy.removeAllListeners();
                        a.this.psy.cancel();
                        a.this.psy = null;
                    }
                    if (a.this.cfM != null) {
                        a.this.cfM.setVisibility(8);
                    }
                }
            });
            this.cfM.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator evN() {
        if (this.cfM == null || this.u == null) {
            return null;
        }
        if (this.psy != null) {
            this.psy.removeAllListeners();
            this.psy.cancel();
            this.psy = null;
        }
        this.u.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.u, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.u, 0.0f);
        int measuredWidth = (this.cfM.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(h.eHo(), 13.0f) * 2)) - this.u.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.u, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.u, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.u, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.psy != null) {
                    a.this.psy.removeAllListeners();
                    a.this.psy.cancel();
                    a.this.psy = null;
                }
                RxExecutor.postDelayed(a.this.psK, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.evN();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.psy = animatorSet;
        return animatorSet;
    }

    @Subscribe
    public void onRefreshPrivilegeEvent(l lVar) {
        if (!b()) {
            RxExecutor.post(this.psK, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.psv != null) {
                        a.this.psv.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (!b() && this.f4147a != null && !((Activity) this.f4147a).isFinishing() && pVar != null) {
            this.k = pVar.f4077a;
            if (this.k != null && this.k.contains("4") && this.psz != null) {
                this.psz.b();
            }
            e(true);
        }
    }

    @Subscribe
    public void onRefreshSubscriberEvent(m mVar) {
        if (!b() && this.psI != null && mVar.a(this.psI.mCreatorUID, this.psI.mRoomID) && mVar.c && this.n != null) {
            this.n.setVisibility(8);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!b() && bVar.f4152a == 8 && this.psE != null && this.psE.getVisibility() != 0) {
            this.psE.a(a.C0988a.slide_in_top_danmu_anim, a.C0988a.slide_out_top_danmu_anim, this.psI == null ? "" : this.psI.mRoomID);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!b()) {
            if (iVar.f4073a == 49) {
                if (!this.I && iVar.b != null) {
                    a(iVar.b.toString());
                }
            } else if (iVar.f4073a == 50 && !this.I && (iVar.b instanceof ListItem)) {
                ListItem listItem = (ListItem) iVar.b;
                if (!h.isEmpty(listItem.mUrl)) {
                    a(listItem);
                }
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!b() && this.psI != null && !h.isEmpty(this.psI.mRoomID) && this.psI.mRoomID.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.psE != null && this.psE.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                } else if (this.psA != null && this.psA.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f);
                }
                if (this.psC != null && this.psC.getVisibility() == 0) {
                    r0 = Math.max(r0, this.psC.getHeight());
                }
                this.psL.setTranslationY(r0);
                return;
            }
            if (this.y != null) {
                this.y.cancel();
                this.y = null;
            }
            int translationY = (int) this.psL.getTranslationY();
            if (aVar.f4151a == 1) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f) : 0;
                if (this.psE != null && this.psE.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                }
                if (this.psC != null && this.psC.getVisibility() == 0) {
                    r0 = Math.max(r0, this.psC.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4147a, 64.0f));
                }
            } else if (2 == aVar.f4151a) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.f4147a, 65.0f) : 0;
                if (this.psE != null && this.psE.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                }
                if (this.psC != null && this.psC.getVisibility() == 0) {
                    r0 = Math.max(r0, this.psC.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4147a, 64.0f));
                }
            } else if (3 == aVar.f4151a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                } else if (this.psA != null && this.psA.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f);
                }
                if (this.psC != null && this.psC.getVisibility() == 0) {
                    r0 = Math.max(r0, this.psC.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4147a, 64.0f));
                }
            } else if (5 == aVar.f4151a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 64.0f);
                    this.L = true;
                } else {
                    this.L = false;
                    if (this.psA != null && this.psA.getVisibility() == 0) {
                        r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f);
                    }
                }
                if (this.psE != null && this.psE.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                }
                if (this.psC != null && this.psC.getVisibility() == 0) {
                    r0 = Math.max(r0, this.psC.getHeight());
                }
            } else if (aVar.b == 0) {
                r0 = this.psC.getHeight();
                if (this.psE != null && this.psE.getVisibility() == 0) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f));
                }
            } else {
                if (this.psE != null && this.psE.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                } else if (this.psA != null && this.psA.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f);
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4147a, 64.0f));
                }
            }
            if (translationY != r0) {
                a(translationY, r0);
            }
        }
    }

    private void a(int i, int i2) {
        this.y = ValueAnimator.ofInt(i, i2);
        this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.ui.a.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!a.this.b() && a.this.psL != null) {
                    a.this.psL.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.y.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.y = null;
            }
        });
        this.y.setInterpolator(new LinearInterpolator());
        this.y.setDuration(800L);
        this.y.start();
    }

    public void a(MicStatus micStatus, List<FanItem> list, String str, boolean z) {
        if (this.psA != null) {
            if (!this.psA.isShown()) {
                if (this.pst != null && this.pst.euJ() != null && this.pst.euJ().mRoominfo != null) {
                    this.psA.a(list, str, z, micStatus, this.pst.euJ().mRoominfo.mCreatorUID);
                    this.psA.a(this.pst.euJ().mRoominfo.mRoomID);
                }
            } else if (this.pst != null && this.pst.euJ() != null && this.pst.euJ().mRoominfo != null) {
                this.psA.a(list, str, z, micStatus, this.pst.euJ().mRoominfo.mCreatorUID);
            }
        }
    }

    public void e() {
        if (this.psA != null && this.psA.isShown()) {
            this.psA.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int childCount = this.psu.getChildCount();
        int itemCount = this.psu.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.psu);
        if (f + childCount >= itemCount) {
            this.l = true;
            if (this.m != null) {
                this.m.setVisibility(8);
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
        ArrayList<ChatInfo> a2 = a(this.h);
        if (a2 == null) {
            f(false);
            return;
        }
        this.f.addAll(a2);
        int size = this.f.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.f.size(); i++) {
                this.f.remove(2);
            }
        }
        f(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.i == null) {
            this.i = new ArrayList<>();
        }
        this.i.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.k != null && this.k.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.k.contains("2"))) {
                        this.i.add(next);
                    } else if (!this.k.contains(next.mType)) {
                        this.i.add(next);
                    }
                }
                return this.i;
            }
            return arrayList;
        }
        return null;
    }

    public void c(List<ChatInfo> list) {
        if (!h.isEmpty(list)) {
            if ((this.k == null || !this.k.contains("4")) && this.psz != null) {
                this.psz.a(list);
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
                    this.h.subList(0, size + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL).clear();
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.f.size();
                if (a2 != null) {
                    this.f.addAll(a2);
                }
                int size3 = this.f.size();
                if (!this.l && this.m != null) {
                    this.m.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
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
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.f.addAll(a3);
                }
            }
            f(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.I) {
            if (this.psv != null) {
                this.psv.a(this.f.size());
                if (i == 1) {
                    this.psv.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.psv.notifyItemRangeRemoved(i2, i3);
                    this.psv.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.psv.notifyDataSetChanged();
                }
            }
            if (z || this.l) {
                this.l = true;
                if (this.m != null) {
                    this.m.setVisibility(8);
                }
                if (z) {
                    this.pss.scrollToPosition(this.f.size() - 1);
                } else {
                    this.pss.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void f(boolean z) {
        if (!this.I) {
            if (this.psv != null) {
                this.psv.a(this.f.size());
                this.psv.notifyDataSetChanged();
            }
            if (z || this.l) {
                this.l = true;
                if (this.m != null) {
                    this.m.setVisibility(8);
                }
                if (z) {
                    this.pss.scrollToPosition(this.f.size() - 1);
                } else {
                    this.pss.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void k() {
        tv.chushou.zues.a.a.ct(this);
        if (this.psv != null) {
            this.psv.a(0);
            this.psv = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.h != null) {
            this.h.clear();
            this.h = null;
        }
        if (this.psJ != null) {
            this.psJ.clear();
            this.psJ = null;
        }
        this.f4147a = null;
        this.b = null;
        this.pss = null;
        this.m = null;
        if (this.i != null) {
            this.i.clear();
            this.i = null;
        }
        if (this.g != null) {
            this.g.clear();
            this.g = null;
        }
        this.psv = null;
        if (this.k != null) {
            this.k.clear();
            this.k = null;
        }
        this.psu = null;
        this.pst = null;
        this.psI = null;
        this.psA = null;
        if (this.psC != null) {
            this.psC.a();
        }
        if (this.psD != null) {
            this.psD.a();
        }
    }

    private void a(Map<String, String> map) {
        String str;
        if (this.pst != null && this.pst.euL() != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            }
            if (h.isEmpty(this.pst.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.pst.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            com.kascend.chushou.c.c.etT().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.a.7
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!a.this.b()) {
                        ParserRet eH = com.kascend.chushou.c.a.eH(jSONObject);
                        if (eH.mRc == 0) {
                            g.O(a.this.f4147a, a.i.subscribe_success);
                            a.this.psI.mIsSubscribed = true;
                            return;
                        }
                        a(eH.mRc, eH.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!a.this.b()) {
                        if (h.isEmpty(str2)) {
                            str2 = a.this.f4147a.getString(a.i.subscribe_failed);
                        }
                        g.d(a.this.f4147a, str2);
                    }
                }
            }, (String) null, this.psI.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0997a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        protected Context b;
        private LayoutInflater d;
        private final int m;
        private final int n;
        private final int o;
        private final int p;
        private tv.chushou.zues.a pja;
        private tv.chushou.zues.a pjb;
        private tv.chushou.zues.a pjc;
        private tv.chushou.zues.a pjd;
        private tv.chushou.zues.a psQ;
        private final tv.chushou.zues.toolkit.richtext.a psR;
        private final int q;
        private final JSONObject s;
        private final int t;

        /* renamed from: a  reason: collision with root package name */
        protected int f4148a = 0;
        private final int j = 14;
        private final int k = 18;
        private final int l = 5;
        private final int u = tv.chushou.widget.a.c.N(28.0f);
        private final int v = tv.chushou.widget.a.c.N(21.0f);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$c */
        /* loaded from: classes6.dex */
        public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView c;
            private int d;
            private SimpleDraweeSpanTextView pjn;
            private ChatInfo pjr;

            c(View view) {
                super(view);
                this.pjn = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
                this.c = (TextView) view.findViewById(a.f.tv_share_room);
                this.c.setOnClickListener(this);
                this.c.setText(new tv.chushou.zues.widget.a.c().append(C0997a.this.b.getString(a.i.videoplayer_danmaku_share)).R(C0997a.this.b, a.e.videoplayer_danmaku_share_icon));
                this.d = C0997a.this.q;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kascend.chushou.player.b euk;
                JSONObject jSONObject = null;
                if (this.pjr != null && this.pjr.mItem != null) {
                    String str = (!(C0997a.this.b instanceof VideoPlayer) || (euk = ((VideoPlayer) C0997a.this.b).euk()) == null) ? null : euk.h;
                    if (!h.isEmpty(str)) {
                        try {
                            jSONObject = new JSONObject(str);
                        } catch (JSONException e) {
                        }
                    }
                    e.a(C0997a.this.b, this.pjr.mItem, jSONObject);
                }
            }

            void a(ChatInfo chatInfo) {
                this.pjr = chatInfo;
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(C0997a.this.b, cVar, chatInfo.mContentRichText, 18, this.d, this.pjn, null, C0997a.this.psR)) {
                    cVar.a(chatInfo.mContent, new ForegroundColorSpan(this.d));
                }
                this.pjn.setDraweeSpanStringBuilder(cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0999a extends RecyclerView.ViewHolder implements Drawable.Callback {
            SimpleDraweeSpanTextView pjm;

            C0999a(View view) {
                super(view);
                this.pjm = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.pjm != null && ViewCompat.isAttachedToWindow(this.pjm)) {
                    this.pjm.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.pjm != null) {
                    this.pjm.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.pjm != null) {
                    this.pjm.removeCallbacks(runnable);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$b */
        /* loaded from: classes6.dex */
        public class b extends RecyclerView.ViewHolder implements Drawable.Callback {

            /* renamed from: a  reason: collision with root package name */
            View f4150a;
            SimpleDraweeSpanTextView pjn;
            EmojiGiftView pjo;

            b(View view) {
                super(view);
                this.f4150a = view;
                this.pjn = (SimpleDraweeSpanTextView) view.findViewById(a.f.tvTitle);
                this.pjo = (EmojiGiftView) view.findViewById(a.f.tvEmoji);
            }

            void a(ChatInfo chatInfo) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                    com.kascend.chushou.d.d.phL.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar, C0997a.this.u, C0997a.this.v);
                }
                if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                    for (int i = 0; i < chatInfo.mPrivilegeInfo.mMedals.size(); i++) {
                        String str = chatInfo.mPrivilegeInfo.mMedals.get(i);
                        if (!h.isEmpty(str)) {
                            C0997a.this.a(this.pjn, this, cVar, str, a.e.default_medal_icon, C0997a.this.o, C0997a.this.p);
                        }
                    }
                }
                if (chatInfo.mCoolMessage != null) {
                    tv.chushou.zues.toolkit.richtext.b.a(C0997a.this.b, cVar, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(C0997a.this.b, a.c.banrrage_chat_name_color), this.pjn, " : ", C0997a.this.psR);
                } else if (!tv.chushou.zues.toolkit.richtext.b.a(C0997a.this.b, cVar, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(C0997a.this.b, a.c.kas_red_n), this.pjn)) {
                    cVar.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(C0997a.this.b.getResources().getColor(a.c.kas_red_n)));
                } else {
                    cVar.a(" : ", new ForegroundColorSpan(C0997a.this.b.getResources().getColor(a.c.kas_red_n)));
                }
                this.pjn.setMovementMethod(tv.chushou.zues.widget.a.b.eIn());
                cVar.setSpan(new tv.chushou.zues.widget.a.a(C0997a.this.pja), 0, cVar.length() + (-1) > 0 ? cVar.length() - 1 : 0, 17);
                this.pjn.setTag(a.f.tag_position, chatInfo);
                cVar.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.b.1
                    @Override // com.facebook.drawee.span.b.c
                    public void d(com.facebook.drawee.span.b bVar) {
                        if (b.this.pjn != null) {
                            b.this.pjn.measure(0, 0);
                            b.this.pjn.requestLayout();
                        }
                    }
                });
                this.pjn.setDraweeSpanStringBuilder(cVar);
                int N = chatInfo.giftDisplayWidth > 0 ? tv.chushou.widget.a.c.N(chatInfo.giftDisplayWidth) : C0997a.this.t;
                int N2 = chatInfo.giftDisplayHeight > 0 ? tv.chushou.widget.a.c.N(chatInfo.giftDisplayHeight) : C0997a.this.t;
                FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) this.pjo.getLayoutParams();
                layoutParams.width = N;
                layoutParams.height = N2;
                this.pjo.setLayoutParams(layoutParams);
                this.pjo.a(chatInfo.mGift.icon, a.c.transparent, N, N2);
                this.pjo.setOnClickListener(C0997a.this.pjd);
                this.pjo.setTag(a.f.tag_position, Integer.valueOf(chatInfo.mGift.id));
                if (chatInfo.mCoolMessage != null && !h.isEmpty(chatInfo.mCoolMessage.mBgImage)) {
                    com.kascend.chushou.toolkit.b.a.evX().a(chatInfo.mCoolMessage.mBgImage, this.f4150a, a.e.bg_bubble_default);
                    return;
                }
                this.f4150a.setBackgroundResource(0);
                this.f4150a.setPadding(tv.chushou.zues.utils.a.dip2px(C0997a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0997a.this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(C0997a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0997a.this.b, 5.0f));
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.pjn != null && ViewCompat.isAttachedToWindow(this.pjn)) {
                    this.pjn.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.pjn != null) {
                    this.pjn.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.pjn != null) {
                    this.pjn.removeCallbacks(runnable);
                }
            }
        }

        C0997a(final Context context) {
            this.b = context;
            this.d = LayoutInflater.from(context);
            HashMap hashMap = new HashMap();
            hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            if (a.this.psI != null) {
                hashMap.put("_fbroomid", a.this.psI.mRoomID);
            }
            this.s = e.a(hashMap);
            this.pjb = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.1
                @Override // tv.chushou.zues.a
                public void ef(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        com.kascend.chushou.d.a.a(C0997a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.psI.mCreatorUID, C0997a.this.s);
                    }
                }
            };
            this.pja = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.2
                @Override // tv.chushou.zues.a
                public void ef(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        if (chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                            if (!chatInfo.mItem.mType.equals("1") || a.this.psI == null || !chatInfo.mItem.mTargetKey.equals(a.this.psI.mRoomID)) {
                                a.this.b(chatInfo.mItem);
                                e.a(C0997a.this.b, chatInfo.mItem, C0997a.this.s);
                                return;
                            }
                            return;
                        }
                        com.kascend.chushou.d.a.a(C0997a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.psI.mCreatorUID, C0997a.this.s);
                    }
                }
            };
            this.pjc = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // tv.chushou.zues.a
                public void ef(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null && chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                        if (!chatInfo.mItem.mType.equals("1") || a.this.psI == null || !chatInfo.mItem.mTargetKey.equals(a.this.psI.mRoomID)) {
                            a.this.b(chatInfo.mItem);
                            e.a(C0997a.this.b, chatInfo.mItem, C0997a.this.s);
                        }
                    }
                }
            };
            this.pjd = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // tv.chushou.zues.a
                public void ef(View view) {
                    String valueOf = String.valueOf(view.getTag(a.f.tag_position));
                    if (!TextUtils.isEmpty(valueOf)) {
                        try {
                            com.kascend.chushou.view.b.a.b(valueOf, C0997a.this.s, a.this.psI.mRoomID).show(((FragmentActivity) context).getSupportFragmentManager(), "emojiDialog");
                        } catch (Exception e) {
                        }
                    }
                }
            };
            this.psQ = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.5
                @Override // tv.chushou.zues.a
                public void ef(View view) {
                    com.kascend.chushou.d.a.a(C0997a.this.b, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol", tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement_title));
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
            this.psR = new com.kascend.chushou.toolkit.a(tv.chushou.zues.utils.a.dip2px(this.b, 13.0f));
            this.q = ContextCompat.getColor(this.b, a.c.videoplayer_share_danmaku);
        }

        public void a(int i) {
            this.f4148a = i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f4148a;
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
                    return new C0999a(this.d.inflate(a.h.view_banrrage_list_header, viewGroup, false));
                case 3:
                    return new c(this.d.inflate(a.h.chat_msg_share_layout, viewGroup, false));
                case 4:
                    return new b(this.d.inflate(a.h.chat_msg_emoji_layout, viewGroup, false));
                default:
                    return new C0999a(this.d.inflate(a.h.chat_msg_layout, viewGroup, false));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            if (!h.isEmpty(list)) {
                if (a.this.f != null && i < a.this.f.size()) {
                    if (viewHolder instanceof C0999a) {
                        String str = ((ChatInfo) a.this.f.get(i)).mType;
                        C0999a c0999a = (C0999a) viewHolder;
                        if (str.equals("1") || str.equals("3")) {
                            ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                            if (chatInfo != null && c0999a.pjm != null) {
                                c0999a.pjm.setTag(a.f.tag_position, chatInfo);
                                return;
                            }
                            return;
                        } else if (c0999a.pjm != null) {
                            c0999a.pjm.setOnClickListener(null);
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
                        final C0999a c0999a = (C0999a) viewHolder;
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
                                if (!h.isEmpty(a.this.psI.mSystemAnnouncement)) {
                                    ArrayList<RichText> aaA = tv.chushou.zues.toolkit.richtext.b.aaA(a.this.psI.mSystemAnnouncement);
                                    if (h.isEmpty(aaA)) {
                                        cVar.a(a.this.psI.mSystemAnnouncement, new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                    } else {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar, aaA, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0999a.pjm);
                                    }
                                } else {
                                    cVar.a(this.b.getString(a.i.danmu_list_title, a.this.psI.mCreatorNickname), new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                }
                                c0999a.pjm.setText(cVar);
                                c0999a.pjm.setOnClickListener(null);
                                c0999a.pjm.setBackgroundResource(0);
                                return;
                            case 1:
                                ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                                if (chatInfo != null && c0999a.pjm != null) {
                                    tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                                    if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                                        com.kascend.chushou.d.d.phL.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar2, this.u, this.v);
                                    }
                                    if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                                        int i4 = 0;
                                        while (true) {
                                            int i5 = i4;
                                            if (i5 < chatInfo.mPrivilegeInfo.mMedals.size()) {
                                                String str2 = chatInfo.mPrivilegeInfo.mMedals.get(i5);
                                                if (!h.isEmpty(str2)) {
                                                    a(c0999a.pjm, c0999a, cVar2, str2, a.e.default_medal_icon, this.o, this.p);
                                                }
                                                i4 = i5 + 1;
                                            }
                                        }
                                    }
                                    if (chatInfo.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0999a.pjm, " : ", this.psR);
                                        int length = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.pjb), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0999a.pjm, null, this.psR);
                                        i3 = length;
                                    } else {
                                        if (chatInfo.mCoolNickname != null && !h.isEmpty(chatInfo.mCoolNickname.mNickName)) {
                                            cVar2.a(chatInfo.mCoolNickname.mNickName + " : ", new c.a().bn(chatInfo.mCoolNickname.mFontColors).OP(chatInfo.mCoolNickname.mNickName.length()).emD());
                                        } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0999a.pjm, " : ", this.psR)) {
                                            cVar2.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_name_color)));
                                        }
                                        int length2 = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.pjb), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        if (chatInfo.mCoolContent != null && !h.isEmpty(chatInfo.mCoolContent.mContent)) {
                                            cVar2.a(this.psR.YK(chatInfo.mCoolContent.mContent), new c.a().bn(chatInfo.mCoolContent.mFontColors).OP(chatInfo.mCoolContent.mContent.length()).emD());
                                            i3 = length2;
                                        } else {
                                            if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0999a.pjm, null, this.psR)) {
                                                cVar2.a(this.psR.YK(chatInfo.mContent), new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            i3 = length2;
                                        }
                                    }
                                    cVar2.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.6
                                        @Override // com.facebook.drawee.span.b.c
                                        public void d(com.facebook.drawee.span.b bVar) {
                                            if (c0999a.pjm != null) {
                                                c0999a.pjm.measure(0, 0);
                                                c0999a.pjm.requestLayout();
                                            }
                                        }
                                    });
                                    cVar2.append(" ");
                                    cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.pja), i3, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                    c0999a.pjm.setDraweeSpanStringBuilder(cVar2);
                                    c0999a.pjm.setTag(a.f.tag_position, chatInfo);
                                    c0999a.pjm.setMovementMethod(tv.chushou.zues.widget.a.b.eIn());
                                    if (chatInfo.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.evX().a(chatInfo.mCoolMessage.mBgImage, c0999a.pjm, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0999a.pjm.setBackgroundResource(0);
                                    c0999a.pjm.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                    return;
                                }
                                return;
                            case 2:
                            case 3:
                                ChatInfo chatInfo2 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo2 != null && c0999a.pjm != null) {
                                    c0999a.pjm.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar3 = new tv.chushou.zues.widget.a.c();
                                    int i6 = 0;
                                    while (true) {
                                        int i7 = i6;
                                        if (i7 < chatInfo2.mPrivilegeInfo.mMedals.size()) {
                                            String str3 = chatInfo2.mPrivilegeInfo.mMedals.get(i7);
                                            if (!h.isEmpty(str3)) {
                                                a(c0999a.pjm, c0999a, cVar3, str3, a.e.default_medal_icon, this.o, this.p);
                                            }
                                            i6 = i7 + 1;
                                        } else {
                                            if (chatInfo2.mCoolMessage != null) {
                                                tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0999a.pjm, null, this.psR);
                                            } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0999a.pjm, null, this.psR)) {
                                                cVar3.a(chatInfo2.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            cVar3.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.7
                                                @Override // com.facebook.drawee.span.b.c
                                                public void d(com.facebook.drawee.span.b bVar) {
                                                    if (c0999a.pjm != null) {
                                                        c0999a.pjm.measure(0, 0);
                                                        c0999a.pjm.requestLayout();
                                                    }
                                                }
                                            });
                                            cVar3.setSpan(new tv.chushou.zues.widget.a.a(this.pjc), 0, cVar3.length() + (-1) > 0 ? cVar3.length() - 1 : 0, 18);
                                            c0999a.pjm.setDraweeSpanStringBuilder(cVar3);
                                            c0999a.pjm.setTag(a.f.tag_position, chatInfo2);
                                            c0999a.pjm.setMovementMethod(tv.chushou.zues.widget.a.b.eIn());
                                            if (chatInfo2.mCoolMessage != null) {
                                                com.kascend.chushou.toolkit.b.a.evX().a(chatInfo2.mCoolMessage.mBgImage, c0999a.pjm, a.e.bg_bubble_default);
                                                return;
                                            }
                                            c0999a.pjm.setBackgroundResource(0);
                                            c0999a.pjm.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                            return;
                                        }
                                    }
                                } else {
                                    return;
                                }
                                break;
                            case 4:
                                ChatInfo chatInfo3 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo3 != null && c0999a.pjm != null) {
                                    c0999a.pjm.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar4 = new tv.chushou.zues.widget.a.c();
                                    if (chatInfo3.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0999a.pjm, " : ", this.psR);
                                        int length3 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.pjb), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0999a.pjm, null, this.psR);
                                        i2 = length3;
                                    } else {
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0999a.pjm)) {
                                            cVar4.a(chatInfo3.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        } else {
                                            cVar4.a(" : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        }
                                        int length4 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.pjb), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0999a.pjm)) {
                                            cVar4.a(chatInfo3.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                        }
                                        i2 = length4;
                                    }
                                    cVar4.append(" ");
                                    if (!h.isEmpty(chatInfo3.mGift.icon)) {
                                        a(c0999a.pjm, c0999a, cVar4, chatInfo3.mGift.icon, a.e.zues_default_gift_color, this.m, this.n);
                                    }
                                    if (chatInfo3.mUserComboCount > 1) {
                                        String valueOf = String.valueOf(chatInfo3.mUserComboCount);
                                        int length5 = valueOf.length();
                                        boolean z = false;
                                        int i8 = 0;
                                        while (i8 < length5) {
                                            String substring = valueOf.substring(i8, i8 + 1);
                                            if (a.this.psJ == null) {
                                                a.this.psJ = new HashMap();
                                            }
                                            Drawable drawable = null;
                                            if (a.this.psJ.containsKey(substring)) {
                                                drawable = (Drawable) a.this.psJ.get(substring);
                                            }
                                            if (drawable == null) {
                                                drawable = this.b.getResources().getDrawable(this.b.getResources().getIdentifier("icon_combo_" + substring, "drawable", this.b.getPackageName()));
                                                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                                a.this.psJ.put(substring, drawable);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable));
                                            i8++;
                                            z = true;
                                        }
                                        if (z) {
                                            Drawable drawable2 = null;
                                            if (a.this.psJ.containsKey("-1")) {
                                                drawable2 = (Drawable) a.this.psJ.get("-1");
                                            }
                                            if (drawable2 == null) {
                                                drawable2 = this.b.getResources().getDrawable(a.e.icon_combo);
                                                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                                                a.this.psJ.put("-1", drawable2);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable2));
                                        }
                                    }
                                    cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.pja), i2, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 17);
                                    c0999a.pjm.setDraweeSpanStringBuilder(cVar4);
                                    c0999a.pjm.setTag(a.f.tag_position, chatInfo3);
                                    c0999a.pjm.setMovementMethod(tv.chushou.zues.widget.a.b.eIn());
                                    c0999a.pjm.setFocusable(false);
                                    if (chatInfo3.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.evX().a(chatInfo3.mCoolMessage.mBgImage, c0999a.pjm, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0999a.pjm.setBackgroundResource(0);
                                    c0999a.pjm.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
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
                        C0999a c0999a2 = (C0999a) viewHolder;
                        c0999a2.pjm.setOnClickListener(null);
                        tv.chushou.zues.widget.a.c cVar5 = new tv.chushou.zues.widget.a.c();
                        cVar5.a((CharSequence) tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement), new ForegroundColorSpan(Color.parseColor("#ff5959")), new tv.chushou.zues.widget.a.a(this.psQ), new UnderlineSpan());
                        c0999a2.pjm.setDraweeSpanStringBuilder(cVar5);
                        c0999a2.pjm.setMovementMethod(tv.chushou.zues.widget.a.b.eIn());
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
                    cVar.a("", new b.a().a(callback).AL(true).QT(i2).QU(i3).YP(str).QS(i).l(simpleDraweeSpanTextView).ewx());
                    cVar.append(" ");
                    return;
                }
                int length = cVar.length();
                com.facebook.drawee.view.b a2 = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(a.this.getResources()).OM(i).ems(), this.b);
                a2.setController(com.facebook.drawee.a.a.c.ekS().Ye(str).elJ());
                cVar.append("1");
                cVar.a(a2, length, length, i2, i3, true, 2);
                cVar.append(" ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        com.kascend.chushou.player.b euk;
        if (!h.isEmpty(listItem.mUrl)) {
            Context context = getContext();
            if ((context instanceof VideoPlayer) && (euk = ((VideoPlayer) context).euk()) != null && !h.isEmpty(euk.f4119a)) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("roomId", euk.f4119a);
                Http http = (Http) tv.chushou.basis.d.b.eHq().S(Http.class);
                if (http != null) {
                    listItem.mUrl = http.packParams(listItem.mUrl, hashMap);
                }
            }
        }
    }
}
