package com.kascend.chushou.widget.gifts;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ConfigDetail;
import com.kascend.chushou.constants.FullRoomInfo;
import com.kascend.chushou.constants.GeneralGift;
import com.kascend.chushou.constants.GeneralTabGift;
import com.kascend.chushou.constants.GiftPanelStatus;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.MicMemberInfo;
import com.kascend.chushou.player.VideoPlayer;
import com.kascend.chushou.player.ui.food.FoodView;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.view.b.c;
import com.kascend.chushou.widget.EmptyLoadingView;
import com.kascend.chushou.widget.gifts.BaseGiftView;
import com.kascend.chushou.widget.gifts.PagerView;
import com.kascend.chushou.widget.gifts.a;
import com.kascend.chushou.widget.gifts.b;
import com.kascend.chushou.widget.gifts.f;
import com.kascend.chushou.widget.menu.KasBaseMenuView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.http.listener.JsonCallbackWrapper;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes4.dex */
public class RoomSendGiftView extends KasBaseMenuView implements View.OnClickListener, c.a, PagerView.a, b.a {
    private boolean B;
    private boolean C;
    private HashMap<String, GiftPanelStatus> F;
    private TextView P;
    private LinearLayout Q;
    private boolean U;
    private boolean V;
    private View aQb;
    public View b;
    public ArrayList<BaseGiftView> c;
    public ArrayList<TextView> d;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView mXx;
    private TextView mXz;
    private io.reactivex.disposables.a mZA;
    private String n;
    private TextView ncL;
    private View niA;
    private RippleButton niB;
    private long niC;
    private io.reactivex.disposables.b niD;
    private b niE;
    private List<GeneralGift> niF;
    private ImageView niG;
    private View niH;
    private FrameLayout niI;
    private EmptyLoadingView niJ;
    private f niK;
    private RelativeLayout niL;
    private MicMemberInfo niM;
    private RelativeLayout niN;
    private FrescoThumbnailView niO;
    private TextView niP;
    private TextView niQ;
    private TextView niR;
    private a niS;
    private FoodView.a niT;
    public FullRoomInfo nik;
    private GeneralGift nil;
    private FoodView nim;
    private FoodView nin;
    private FoodView nio;
    private FrescoThumbnailView nip;
    private FrescoThumbnailView niq;
    private PagerView nir;
    private LinearLayout nis;
    private c nit;
    private List<GeneralTabGift> niu;
    private List<GeneralTabGift> niv;
    private com.kascend.chushou.view.b.c niw;
    private ImageView nix;
    private TextView niy;
    private com.kascend.chushou.widget.gifts.b niz;
    private View o;
    private int p;
    private int r;
    private String s;

    /* loaded from: classes4.dex */
    public interface a {
        void A();

        void B();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, boolean z2);

        void b(ConfigDetail configDetail);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view, String str);
    }

    static /* synthetic */ long W(RoomSendGiftView roomSendGiftView) {
        long j = roomSendGiftView.niC;
        roomSendGiftView.niC = j - 1;
        return j;
    }

    public RoomSendGiftView(Context context) {
        this(context, null);
    }

    public RoomSendGiftView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoomSendGiftView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = -1;
        this.nil = null;
        this.B = true;
        this.C = true;
        this.niv = new ArrayList();
        this.F = new HashMap<>();
        this.mZA = new io.reactivex.disposables.a();
        this.niw = null;
        this.niC = 0L;
        this.niF = new ArrayList();
        this.U = false;
        this.niT = new FoodView.a() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.12
            @Override // com.kascend.chushou.player.ui.food.FoodView.a
            public boolean a() {
                int i2;
                if (RoomSendGiftView.this.niL != null && RoomSendGiftView.this.e != null && (!(RoomSendGiftView.this.e instanceof VideoPlayer) || !((VideoPlayer) RoomSendGiftView.this.e).isFinishing())) {
                    if ((RoomSendGiftView.this.nin != null && RoomSendGiftView.this.nin.getVisibility() == 0) || (RoomSendGiftView.this.nio != null && RoomSendGiftView.this.nio.getVisibility() == 0)) {
                        i2 = tv.chushou.zues.utils.a.dip2px(RoomSendGiftView.this.e, 32.0f);
                    } else {
                        i2 = 0;
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) RoomSendGiftView.this.niL.getLayoutParams();
                    layoutParams.height = i2 + tv.chushou.zues.utils.a.dip2px(RoomSendGiftView.this.e, 10.0f);
                    RoomSendGiftView.this.niL.setLayoutParams(layoutParams);
                }
                return true;
            }
        };
        a(context);
    }

    public void setOnGiftSendListener(c cVar) {
        this.nit = cVar;
    }

    public void setContext(Context context) {
        this.e = context;
    }

    private void a(Context context) {
        this.e = context;
        if (this.f == null) {
            this.f = LayoutInflater.from(getContext()).inflate(a.h.room_send_gift_view, (ViewGroup) null, false);
        }
        if (!this.i) {
            this.i = true;
            this.b = this.f.findViewById(a.f.content);
            this.niL = (RelativeLayout) this.f.findViewById(a.f.ll_gift_ad);
            this.nim = (FoodView) this.f.findViewById(a.f.iv_gift_ad);
            this.nin = (FoodView) this.f.findViewById(a.f.ad_left);
            this.nio = (FoodView) this.f.findViewById(a.f.ad_right);
            this.nip = (FrescoThumbnailView) this.f.findViewById(a.f.iv_gift_top_icon_two);
            this.niq = (FrescoThumbnailView) this.f.findViewById(a.f.iv_gift_top_icon_one);
            this.niq.setOnClickListener(this);
            this.nip.setOnClickListener(this);
            this.nis = (LinearLayout) this.f.findViewById(a.f.ll_tab_contain);
            this.nir = (PagerView) this.f.findViewById(a.f.rl_gift_contain);
            this.nir.setOnPageChangedListener(this);
            this.j = (TextView) this.f.findViewById(a.f.tvMyChuShouBi);
            this.k = (TextView) this.f.findViewById(a.f.tv_noble_coin);
            this.k.setOnClickListener(this);
            this.l = (TextView) this.f.findViewById(a.f.recharge);
            this.l.setOnClickListener(this);
            this.m = (TextView) this.f.findViewById(a.f.btn_present);
            this.P = (TextView) this.f.findViewById(a.f.btn_present_single);
            this.Q = (LinearLayout) this.f.findViewById(a.f.ll_btn_support_batch);
            this.P.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.nix = (ImageView) this.f.findViewById(a.f.iv_arrow);
            this.niy = (TextView) this.f.findViewById(a.f.tv_gift_count);
            this.niA = this.f.findViewById(a.f.rl_gift_count);
            this.niA.setOnClickListener(this);
            this.ncL = (TextView) this.f.findViewById(a.f.tv_second);
            this.niB = (RippleButton) this.f.findViewById(a.f.btn_combo);
            this.niB.setOnClickListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.aQb = this.f.findViewById(a.f.ll_emoji_search);
            this.niH = this.f.findViewById(a.f.rl_gift_emoji_search_edit_bar);
            this.mXx = (TextView) this.f.findViewById(a.f.btn_search);
            this.niG = (ImageView) this.f.findViewById(a.f.iv_emoji_delete);
            this.mXz = (TextView) this.f.findViewById(a.f.tv_emoji_search);
            this.mXx.setOnClickListener(this);
            this.mXz.setOnClickListener(this);
            this.niH.setOnClickListener(this);
            this.niG.setOnClickListener(this);
            this.mXz.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.1
                @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    super.afterTextChanged(editable);
                    RoomSendGiftView.this.mXx.setEnabled(editable.length() > 0);
                    RoomSendGiftView.this.niG.setVisibility(editable.length() <= 0 ? 8 : 0);
                }
            });
            this.niI = (FrameLayout) this.f.findViewById(a.f.fl_emoji_container);
            this.niJ = (EmptyLoadingView) this.f.findViewById(a.f.empty_search);
            this.niN = (RelativeLayout) this.f.findViewById(a.f.rl_mic_user);
            this.niO = (FrescoThumbnailView) this.f.findViewById(a.f.ftv_mic_avatar);
            this.niP = (TextView) this.f.findViewById(a.f.tv_mic_order);
            this.niQ = (TextView) this.f.findViewById(a.f.tv_mic_nickname);
            this.niR = (TextView) this.f.findViewById(a.f.tv_mic_user_info);
            this.niR.setOnClickListener(this);
            addView(this.f, layoutParams);
        }
    }

    public void a(ListItem listItem, ListItem listItem2, ListItem listItem3, boolean z) {
        int i;
        int i2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.niL.getLayoutParams();
        if (listItem != null) {
            int a2 = a(listItem, this.nim, z);
            if (!this.nim.isShown()) {
                if (this.nim.a(listItem, this.niT, false)) {
                    int dip2px = a2 - tv.chushou.zues.utils.a.dip2px(this.e, 10.0f);
                    this.nim.setVisibility(0);
                    i = dip2px;
                } else {
                    this.nim.setVisibility(8);
                    i = 0;
                }
            } else {
                i = a2 - tv.chushou.zues.utils.a.dip2px(this.e, 10.0f);
            }
        } else {
            i = 0;
        }
        int dip2px2 = tv.chushou.zues.utils.a.dip2px(this.e, 36.0f);
        int dip2px3 = tv.chushou.zues.utils.a.dip2px(this.e, 4.0f);
        if (listItem2 != null && !h.isEmpty(listItem2.mCover)) {
            this.nin.a(listItem2, (FoodView.a) null, true, (String) null, dip2px2);
            i = Math.max(i, dip2px2 - dip2px3);
        } else {
            this.nin.setVisibility(8);
        }
        if (listItem3 != null && !h.isEmpty(listItem3.mCover)) {
            this.nio.a(listItem3, (FoodView.a) null, true, (String) null, dip2px2);
            i2 = Math.max(i, dip2px2 - dip2px3);
        } else {
            this.nio.setVisibility(8);
            i2 = i;
        }
        layoutParams.height = i2 + tv.chushou.zues.utils.a.dip2px(this.e, 10.0f);
        this.niL.setLayoutParams(layoutParams);
    }

    private int a(ListItem listItem, View view, boolean z) {
        int a2;
        Point he = tv.chushou.zues.utils.a.he(this.e);
        if (z) {
            a2 = com.kascend.chushou.a.a.dAG().a(listItem, view, he.x, (he.x * 106) / 720, (he.x * 77) / 720);
        } else {
            a2 = com.kascend.chushou.a.a.dAG().a(listItem, view, he.x, (he.x * 106) / 1280, (he.x * 77) / 1280);
        }
        if (a2 == 0) {
            if (z) {
                return (int) (he.x / 6.79d);
            }
            return he.x / 12;
        }
        return a2;
    }

    @Override // com.kascend.chushou.widget.menu.KasBaseMenuView
    public void setMicMemberInfo(MicMemberInfo micMemberInfo) {
        if (this.niN != null) {
            this.niM = micMemberInfo;
            if (micMemberInfo == null) {
                this.niN.setVisibility(8);
                return;
            }
            this.niN.setVisibility(0);
            this.niO.i(micMemberInfo.avatar, com.kascend.chushou.view.a.a(micMemberInfo.gender), b.a.small, b.a.small);
            this.niP.setText(getContext().getString(a.i.str_send_to_order, Integer.valueOf(micMemberInfo.order)));
            this.niQ.setText(micMemberInfo.nickname);
        }
    }

    public void a() {
        setMicMemberInfo(null);
    }

    public void setGiftTopIcon(List<ListItem> list) {
        if (!h.isEmpty(list)) {
            if (list.size() == 1) {
                this.nip.setVisibility(8);
                ListItem listItem = list.get(0);
                if (!h.isEmpty(listItem.mCover)) {
                    this.niq.setTag(listItem);
                    this.niq.setAnim(true);
                    this.niq.a(listItem.mCover, 0, 0, 0, 1);
                }
                this.niq.setVisibility(0);
                return;
            }
            ListItem listItem2 = list.get(0);
            if (!h.isEmpty(listItem2.mCover)) {
                this.niq.setTag(listItem2);
                this.niq.setAnim(true);
                this.niq.a(listItem2.mCover, 0, 0, 0, 1);
            }
            this.niq.setVisibility(0);
            ListItem listItem3 = list.get(1);
            if (!h.isEmpty(listItem3.mCover)) {
                this.nip.setTag(listItem3);
                this.nip.setAnim(true);
                this.nip.a(listItem3.mCover, 0, 0, 0, 1);
            }
            this.nip.setVisibility(0);
            return;
        }
        this.niq.setVisibility(8);
        this.nip.setVisibility(8);
    }

    public void a(boolean z, boolean z2) {
        if (!h.isEmpty(this.niu)) {
            this.B = z2;
            this.C = z;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nir.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aQb.getLayoutParams();
            if (this.B) {
                layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.e, 170.0f);
                layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.e, 214.0f);
            } else {
                layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.e, 95.0f);
                layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.e, 129.0f);
            }
            this.nir.setLayoutParams(layoutParams);
            this.aQb.setLayoutParams(layoutParams2);
            if (!(this.niI.getChildAt(0) instanceof f)) {
                f.a aVar = new f.a() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.13
                    @Override // com.kascend.chushou.widget.gifts.f.a
                    public void a(View view, Object obj, int i, int i2) {
                        RoomSendGiftView.this.b((GeneralGift) obj);
                    }

                    @Override // com.kascend.chushou.widget.gifts.f.a
                    public void a(Object obj) {
                        RoomSendGiftView.this.a((GeneralGift) obj);
                    }
                };
                if (this.B || this.C) {
                    this.niK = new f(this.e, 0, aVar, this.n, 5);
                } else {
                    this.niK = new f(this.e, 0, aVar, this.n, 8);
                }
                this.niK.setSearchPresenter(new com.kascend.chushou.widget.gifts.c(this.n));
                this.niI.addView(this.niK, 0);
            }
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v38, types: [com.kascend.chushou.widget.gifts.BaseGiftView] */
    public void f() {
        int i;
        VerticalRoomGiftView verticalRoomGiftView;
        VerticalRoomGiftView verticalRoomGiftView2;
        TextView textView;
        if (!h.isEmpty(this.niu)) {
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            int size = this.c.size();
            int size2 = size - this.niu.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.nir.removeView(this.c.get((size - 1) - i2));
                this.nis.removeView(this.d.get((size - 1) - i2));
            }
            for (int i3 = 0; i3 < size2; i3++) {
                this.c.remove((size - 1) - i3);
                this.d.remove((size - 1) - i3);
            }
            for (final int i4 = 0; i4 < this.niu.size(); i4++) {
                if (i4 < this.c.size()) {
                    verticalRoomGiftView2 = this.c.get(i4);
                    textView = this.d.get(i4);
                } else {
                    if (this.B) {
                        verticalRoomGiftView = new VerticalRoomGiftView(this.e, 5);
                    } else if (this.C) {
                        verticalRoomGiftView = new VerticalRoomGiftView(this.e, 5);
                    } else {
                        verticalRoomGiftView = new VerticalRoomGiftView(this.e, 8);
                    }
                    TextView dDu = dDu();
                    this.c.add(verticalRoomGiftView);
                    this.nir.addView(verticalRoomGiftView);
                    this.d.add(dDu);
                    this.nis.addView(dDu);
                    verticalRoomGiftView2 = verticalRoomGiftView;
                    textView = dDu;
                }
                GeneralTabGift generalTabGift = this.niu.get(i4);
                verticalRoomGiftView2.setViewListener(new BaseGiftView.a() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.14
                    @Override // com.kascend.chushou.widget.gifts.BaseGiftView.a
                    public void a(int i5) {
                        if (RoomSendGiftView.this.niu != null && i5 < RoomSendGiftView.this.niu.size()) {
                            RoomSendGiftView.this.niu.remove(i5);
                            RoomSendGiftView.this.f();
                        }
                    }

                    @Override // com.kascend.chushou.widget.gifts.BaseGiftView.a
                    public void b(int i5) {
                    }

                    @Override // com.kascend.chushou.widget.gifts.BaseGiftView.a
                    public void a(View view, Object obj, int i5, String str) {
                        if (i4 == RoomSendGiftView.this.r && RoomSendGiftView.this.p != i5) {
                            RoomSendGiftView.this.b((GeneralGift) obj);
                        }
                        RoomSendGiftView.this.o = view;
                        RoomSendGiftView.this.p = i5;
                        RoomSendGiftView.this.nil = (GeneralGift) obj;
                        GiftPanelStatus giftPanelStatus = (GiftPanelStatus) RoomSendGiftView.this.F.get(str);
                        if (giftPanelStatus == null) {
                            giftPanelStatus = new GiftPanelStatus();
                        }
                        giftPanelStatus.mGeneralGiftSelectPos = RoomSendGiftView.this.p;
                        giftPanelStatus.mGeneralGiftView = RoomSendGiftView.this.o;
                        giftPanelStatus.mSelectGiftObj = RoomSendGiftView.this.nil;
                        giftPanelStatus.mGiftTabName = str;
                        RoomSendGiftView.this.F.put(str, giftPanelStatus);
                    }

                    @Override // com.kascend.chushou.widget.gifts.BaseGiftView.a
                    public void a(Object obj) {
                        RoomSendGiftView.this.a((GeneralGift) obj);
                    }
                });
                if (verticalRoomGiftView2.g) {
                    verticalRoomGiftView2.a((ArrayList) generalTabGift.mGeneralGifts, h.isEmpty(this.n) ? "" : this.n, i4, generalTabGift.mFrequentlyUsedTab);
                } else {
                    verticalRoomGiftView2.a(generalTabGift.mGeneralGifts, h.isEmpty(this.n) ? "" : this.n, i4, generalTabGift.mFrequentlyUsedTab);
                }
                Iterator<Map.Entry<String, GiftPanelStatus>> it = this.F.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        GiftPanelStatus value = it.next().getValue();
                        if (generalTabGift.mName.equals(value.mGiftTabName)) {
                            verticalRoomGiftView2.a(value);
                            break;
                        }
                    }
                }
                textView.setText(generalTabGift.mName);
                verticalRoomGiftView2.setTag(generalTabGift.mName);
                textView.setTag(generalTabGift.mName);
            }
            if (!h.isEmpty(this.s)) {
                i = 0;
                while (i < this.niu.size()) {
                    if (this.s.equals(this.niu.get(i).mName)) {
                        break;
                    }
                    i++;
                }
            }
            i = 0;
            b(i);
            if (this.nir != null) {
                this.nir.a(i, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GeneralGift generalGift) {
        ListItem listItem = new ListItem();
        switch (generalGift.mType) {
            case 94:
                if (this.niE != null) {
                    ConfigDetail configDetail = new ConfigDetail();
                    configDetail.mType = "94";
                    configDetail.mUrl = generalGift.mUrl;
                    configDetail.mLandscape = generalGift.mLandscape;
                    configDetail.mPortrait = generalGift.mPortrait;
                    this.niE.b(configDetail);
                    return;
                }
                return;
            case 96:
                listItem.mType = "96";
                break;
            case 98:
                listItem.mType = "98";
                break;
            case 99:
                listItem.mType = "99";
                break;
        }
        listItem.mUrl = generalGift.mUrl;
        com.kascend.chushou.d.e.a(getContext(), listItem, (JSONObject) null);
    }

    private TextView dDu() {
        TextView textView = new TextView(this.e);
        textView.setId(a.f.gift_tab);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.e, 20.0f), 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(0, 0, 0, 0);
        textView.setTextColor(this.e.getResources().getColor(a.c.download_content_color));
        textView.setTextSize(14.0f);
        textView.setOnClickListener(this);
        return textView;
    }

    private void b(int i) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            BaseGiftView baseGiftView = this.c.get(i2);
            if (i == i2) {
                if (this.r != i2 || this.p != baseGiftView.getCurSelectPos()) {
                    b(baseGiftView.getCurObj());
                }
                this.r = i2;
                if (!h.isEmpty(this.niu) && i2 < this.niu.size()) {
                    this.s = this.niu.get(i2).mName;
                }
                this.o = baseGiftView.getCurGiftView();
                this.p = baseGiftView.getCurSelectPos();
                this.nil = baseGiftView.getCurObj();
            }
        }
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            TextView textView = this.d.get(i3);
            if (i == i3) {
                textView.setTextColor(this.e.getResources().getColor(a.c.kas_red_n));
            } else {
                textView.setTextColor(this.e.getResources().getColor(a.c.download_content_color));
            }
        }
    }

    private void b(String str) {
        if (!h.isEmpty(str)) {
            for (int i = 0; i < this.c.size(); i++) {
                BaseGiftView baseGiftView = this.c.get(i);
                if (str.equals(baseGiftView.getTag().toString())) {
                    if (this.r != i || this.p != baseGiftView.getCurSelectPos()) {
                        b(baseGiftView.getCurObj());
                    }
                    this.r = i;
                    if (!h.isEmpty(this.niu) && i < this.niu.size()) {
                        this.s = this.niu.get(i).mName;
                    }
                    this.o = baseGiftView.getCurGiftView();
                    this.p = baseGiftView.getCurSelectPos();
                    this.nil = baseGiftView.getCurObj();
                }
            }
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                TextView textView = this.d.get(i2);
                if (str.equals(textView.getTag().toString())) {
                    textView.setTextColor(this.e.getResources().getColor(a.c.kas_red_n));
                } else {
                    textView.setTextColor(this.e.getResources().getColor(a.c.download_content_color));
                }
            }
            if (this.nir != null) {
                this.nir.a(this.r, true);
            }
        }
    }

    @Override // com.kascend.chushou.widget.gifts.PagerView.a
    public void a(int i) {
        b(i);
    }

    public void a(String str, String str2, int i) {
        if (this.j != null) {
            this.j.setVisibility(0);
            this.j.setText(String.valueOf(h.parseLong(str)));
        }
    }

    public void b() {
        String e = com.kascend.chushou.d.h.dAM().e();
        String f = com.kascend.chushou.d.h.dAM().f();
        final int g = com.kascend.chushou.d.h.dAM().g();
        if (LoginManager.Instance().islogined()) {
            a(e, f, g);
            com.kascend.chushou.c.c.dAI().c(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.2
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (RoomSendGiftView.this.e != null && !((VideoPlayer) RoomSendGiftView.this.e).isFinishing()) {
                        RoomSendGiftView.this.a(com.kascend.chushou.d.h.dAM().e(), com.kascend.chushou.d.h.dAM().f(), g);
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            List<GeneralTabGift> a2 = com.kascend.chushou.c.f.a(optJSONObject);
                            if (RoomSendGiftView.this.nik != null && !h.isEmpty(a2)) {
                                RoomSendGiftView.this.niv.clear();
                                RoomSendGiftView.this.niv.addAll(a2);
                                RxExecutor.post(RoomSendGiftView.this.mZA, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (RoomSendGiftView.this.e != null) {
                                            synchronized (RoomSendGiftView.class) {
                                                RoomSendGiftView.this.nik.mGeneralTabGifts.clear();
                                                RoomSendGiftView.this.nik.mGeneralTabGifts.addAll(RoomSendGiftView.this.niv);
                                                if (RoomSendGiftView.this.niu == null) {
                                                    RoomSendGiftView.this.niu = new ArrayList();
                                                }
                                                RoomSendGiftView.this.niu.clear();
                                                RoomSendGiftView.this.niu.addAll(RoomSendGiftView.this.niv);
                                                RoomSendGiftView.this.U = true;
                                                if (!h.isEmpty(RoomSendGiftView.this.niF)) {
                                                    Iterator it = RoomSendGiftView.this.niu.iterator();
                                                    while (true) {
                                                        if (!it.hasNext()) {
                                                            break;
                                                        }
                                                        GeneralTabGift generalTabGift = (GeneralTabGift) it.next();
                                                        if (generalTabGift.mFrequentlyUsedTab) {
                                                            generalTabGift.mGeneralGifts.addAll(RoomSendGiftView.this.niF);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            RoomSendGiftView.this.f();
                                        }
                                    }
                                });
                            }
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                }
            }, this.n);
            return;
        }
        a("0", f, g);
    }

    @Override // com.kascend.chushou.widget.menu.KasBaseMenuView
    public void c() {
        super.c();
    }

    @Override // com.kascend.chushou.widget.menu.KasBaseMenuView
    protected void d() {
        h();
        this.niF.clear();
        this.U = false;
        b();
        getCommonlyGift();
    }

    private void getCommonlyGift() {
        List<Integer> dAQ = com.kascend.chushou.d.h.dAM().dAQ();
        if (!h.isEmpty(dAQ)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < dAQ.size(); i++) {
                sb.append(dAQ.get(i));
                if (i != dAQ.size() - 1) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            com.kascend.chushou.c.c.dAI().d(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.3
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    VerticalRoomGiftView verticalRoomGiftView;
                    if (RoomSendGiftView.this.e != null && !((VideoPlayer) RoomSendGiftView.this.e).isFinishing()) {
                        List<GeneralGift> a2 = com.kascend.chushou.c.f.a(jSONObject, RoomSendGiftView.this.b.getResources().getString(a.i.str_commonly));
                        if (!h.isEmpty(a2)) {
                            if (!RoomSendGiftView.this.U) {
                                RoomSendGiftView.this.niF.addAll(a2);
                            } else {
                                if (RoomSendGiftView.this.c != null) {
                                    Iterator<BaseGiftView> it = RoomSendGiftView.this.c.iterator();
                                    while (it.hasNext()) {
                                        BaseGiftView next = it.next();
                                        if (next.b() && (next instanceof VerticalRoomGiftView)) {
                                            verticalRoomGiftView = (VerticalRoomGiftView) next;
                                            break;
                                        }
                                    }
                                }
                                verticalRoomGiftView = null;
                                if (verticalRoomGiftView != null) {
                                    int tabIndex = verticalRoomGiftView.getTabIndex();
                                    GeneralTabGift generalTabGift = (GeneralTabGift) RoomSendGiftView.this.niu.get(tabIndex);
                                    generalTabGift.mGeneralGifts.addAll(a2);
                                    verticalRoomGiftView.a((ArrayList) generalTabGift.mGeneralGifts, h.isEmpty(RoomSendGiftView.this.n) ? "" : RoomSendGiftView.this.n, tabIndex, true);
                                }
                            }
                            ArrayList arrayList = new ArrayList();
                            for (GeneralGift generalGift : a2) {
                                if (generalGift != null) {
                                    arrayList.add(Integer.valueOf(generalGift.mId));
                                }
                            }
                            com.kascend.chushou.d.h.dAM().b(arrayList);
                            return;
                        }
                        com.kascend.chushou.d.h.dAM().b(new ArrayList());
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i2, String str) {
                }
            }, sb.toString());
        }
    }

    @Override // com.kascend.chushou.widget.menu.KasBaseMenuView
    public void e() {
        if (this.aQb.getVisibility() == 0) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.widget.gifts.a.a(this.n, false));
            return;
        }
        if (this.niK != null) {
            this.niK.a();
            c(2);
            this.mXz.setText("");
        }
        k();
        if (this.nim != null) {
            this.nim.a();
        }
        if (this.nin != null) {
            this.nin.a();
        }
        if (this.nio != null) {
            this.nio.a();
        }
        super.e();
        a();
    }

    private void h() {
    }

    public void a(FullRoomInfo fullRoomInfo) {
        if (fullRoomInfo != null) {
            this.nik = fullRoomInfo;
            if (fullRoomInfo.mRoominfo != null) {
                this.niu = fullRoomInfo.mGeneralTabGifts;
                this.n = fullRoomInfo.mRoominfo.mRoomID;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, GeneralGift generalGift, GeneralGift generalGift2) {
        boolean z;
        if (generalGift != null && !h.isEmpty(this.niu)) {
            int i3 = 0;
            boolean z2 = false;
            while (i3 < this.niu.size()) {
                GeneralTabGift generalTabGift = this.niu.get(i3);
                int i4 = 0;
                while (true) {
                    if (i4 >= generalTabGift.mGeneralGifts.size()) {
                        z = z2;
                        break;
                    }
                    GeneralGift generalGift3 = generalTabGift.mGeneralGifts.get(i4);
                    if (generalGift3 == null || generalGift.mId != generalGift3.mId || generalGift3.mType != generalGift.mType) {
                        i4++;
                    } else {
                        if (generalGift2 == null) {
                            generalTabGift.mGeneralGifts.remove(generalGift);
                        } else if (generalGift3.mId == generalGift2.mId && generalGift3.mType == generalGift2.mType) {
                            generalGift3.copyClone(generalGift2);
                        }
                        if (this.c != null && i < this.c.size()) {
                            this.c.get(i).a((ArrayList) generalTabGift.mGeneralGifts, this.n, i, generalTabGift.mFrequentlyUsedTab);
                        }
                        z = true;
                    }
                }
                if (!z) {
                    i3++;
                    z2 = z;
                } else {
                    return;
                }
            }
        }
    }

    private void i() {
        j();
        if (this.nil != null) {
            String str = null;
            if (this.e instanceof VideoPlayer) {
                str = com.kascend.chushou.d.e.a(((VideoPlayer) this.e).dAX().h, "_fromView", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "11");
            }
            if (com.kascend.chushou.d.e.c(this.e, str)) {
                int i = this.p;
                GeneralGift generalGift = this.nil;
                View view = this.o;
                if (i >= 0 && generalGift != null && view != null) {
                    if (this.nit != null) {
                        this.nit.a(view, generalGift.mIcon);
                    }
                    String str2 = null;
                    if (this.e instanceof VideoPlayer) {
                        str2 = ((VideoPlayer) this.e).dAX().h;
                    }
                    if (this.nik != null && this.nik.mRoominfo != null) {
                        if (generalGift.mType == 2) {
                            long j = 1;
                            if (generalGift.mSupportBatch) {
                                j = h.parseLong(this.niy.getText().toString());
                            }
                            if (j < 1) {
                                j = 1;
                            }
                            com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.4
                                @Override // com.kascend.chushou.c.b
                                public void a() {
                                }

                                @Override // com.kascend.chushou.c.b
                                public void a(String str3, JSONObject jSONObject) {
                                    JSONObject optJSONObject;
                                    GeneralGift generalGift2;
                                    if (RoomSendGiftView.this.e != null && !((VideoPlayer) RoomSendGiftView.this.e).isFinishing() && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                                        if (RoomSendGiftView.this.niS != null) {
                                            RoomSendGiftView.this.niS.B();
                                        }
                                        GeneralGift dM = com.kascend.chushou.c.f.dM(optJSONObject.optJSONObject("generalGift"));
                                        int optInt = jSONObject.optInt("pos");
                                        int optInt2 = jSONObject.optInt("tabIndex");
                                        Object opt = jSONObject.opt("giftObj");
                                        if (opt == null || !(opt instanceof GeneralGift)) {
                                            generalGift2 = null;
                                        } else {
                                            generalGift2 = (GeneralGift) opt;
                                        }
                                        RoomSendGiftView.this.a(optInt2, optInt, generalGift2, dM);
                                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("h5Tips");
                                        if (optJSONObject2 != null) {
                                            ((VideoPlayer) RoomSendGiftView.this.e).c(com.kascend.chushou.c.e.dJ(optJSONObject2));
                                        }
                                    }
                                }

                                @Override // com.kascend.chushou.c.b
                                public void a(int i2, String str3) {
                                    if (RoomSendGiftView.this.e != null && !((VideoPlayer) RoomSendGiftView.this.e).isFinishing() && i2 == 1026 && !h.isEmpty(str3)) {
                                        g.c(RoomSendGiftView.this.e, str3);
                                    }
                                }
                            };
                            if (this.niM != null && this.niN.getVisibility() == 0) {
                                com.kascend.chushou.c.c.dAI().a(bVar, String.valueOf(generalGift.mActionType), String.valueOf(generalGift.mId), this.nik.mRoominfo.mRoomID, this.niM.uid, this.niM.micRoomId, str2, this.r, this.p, this.nil, j);
                            } else {
                                com.kascend.chushou.c.c.dAI().a(bVar, String.valueOf(generalGift.mActionType), String.valueOf(generalGift.mId), this.nik.mRoominfo.mRoomID, str2, this.r, this.p, this.nil, j);
                            }
                            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "29", "giftId", Integer.valueOf(generalGift.mId), "roomId", this.nik.mRoominfo.mRoomID);
                            return;
                        }
                        int i2 = generalGift.mPoint;
                        long j2 = 1;
                        if (generalGift.mSupportBatch) {
                            j2 = h.parseLong(this.niy.getText().toString());
                        }
                        if (j2 < 1) {
                            j2 = 1;
                        }
                        a(i2, String.valueOf(generalGift.mId), str2, j2, this.V);
                        com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "29", "giftId", Integer.valueOf(generalGift.mId), "roomId", this.nik.mRoominfo.mRoomID);
                    }
                }
            }
        }
    }

    private void j() {
        BaseGiftView baseGiftView;
        if (this.aQb.getVisibility() == 0) {
            this.o = this.niK.b;
            this.p = this.niK.d;
            this.nil = this.niK.mOp;
            this.V = true;
        } else if (this.c != null && this.r < this.c.size() && (baseGiftView = this.c.get(this.r)) != null) {
            baseGiftView.a();
            this.o = baseGiftView.getCurGiftView();
            this.p = baseGiftView.getCurSelectPos();
            this.nil = baseGiftView.getCurObj();
            this.V = baseGiftView.b();
        }
    }

    public void a(int i, final String str, String str2, long j, final boolean z) {
        JsonCallbackWrapper jsonCallbackWrapper = new JsonCallbackWrapper() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.5
            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callStart() {
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callSuccess(String str3, JSONObject jSONObject) {
                JSONObject optJSONObject;
                if (RoomSendGiftView.this.e != null && !((VideoPlayer) RoomSendGiftView.this.e).isFinishing()) {
                    if (RoomSendGiftView.this.niS != null) {
                        RoomSendGiftView.this.niS.A();
                    }
                    RoomSendGiftView.this.a(com.kascend.chushou.d.h.dAM().e(), com.kascend.chushou.d.h.dAM().f(), com.kascend.chushou.d.h.dAM().g());
                    if (RoomSendGiftView.this.niw != null && RoomSendGiftView.this.niw.getDialog().isShowing()) {
                        RoomSendGiftView.this.niw.dismissAllowingStateLoss();
                    }
                    if (z) {
                        com.kascend.chushou.d.h.dAM().c(h.parseInt(str));
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                    if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("h5Tips")) != null) {
                        ((VideoPlayer) RoomSendGiftView.this.e).c(com.kascend.chushou.c.e.dJ(optJSONObject));
                    }
                }
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callFailure(int i2, @Nullable String str3, @Nullable String str4) {
                String str5;
                boolean z2;
                if (RoomSendGiftView.this.e != null && !((VideoPlayer) RoomSendGiftView.this.e).isFinishing()) {
                    if (i2 == 1028) {
                        String str6 = "";
                        if (h.isEmpty(str4)) {
                            str5 = "";
                        } else {
                            try {
                                JSONObject optJSONObject = new JSONObject(str4).optJSONObject("data");
                                if (optJSONObject != null) {
                                    str6 = optJSONObject.optString("bigfansGiftId");
                                }
                                str5 = str6;
                            } catch (JSONException e) {
                                str5 = "";
                            }
                        }
                        if (!RoomSendGiftView.this.C || TextUtils.isEmpty(str5) || RoomSendGiftView.this.niu == null) {
                            g.c(RoomSendGiftView.this.e, RoomSendGiftView.this.e.getString(a.i.no_loyal_fans));
                            return;
                        }
                        int i3 = 0;
                        boolean z3 = false;
                        while (i3 < RoomSendGiftView.this.niu.size()) {
                            GeneralTabGift generalTabGift = (GeneralTabGift) RoomSendGiftView.this.niu.get(i3);
                            int i4 = 0;
                            while (true) {
                                if (i4 >= generalTabGift.mGeneralGifts.size()) {
                                    z2 = z3;
                                    break;
                                } else if (generalTabGift.mGeneralGifts.get(i4).mType != 1 || !str5.equals(String.valueOf(generalTabGift.mGeneralGifts.get(i4).mId))) {
                                    i4++;
                                } else {
                                    GeneralGift generalGift = generalTabGift.mGeneralGifts.get(i4);
                                    if (RoomSendGiftView.this.niw == null || RoomSendGiftView.this.niw.getDialog() == null || !RoomSendGiftView.this.niw.getDialog().isShowing()) {
                                        RoomSendGiftView.this.niw = com.kascend.chushou.view.b.c.d(String.valueOf(generalGift.mId), generalGift.mPoint, generalGift.mIcon, RoomSendGiftView.this.nik.mRoominfo.mRoomID);
                                        RoomSendGiftView.this.niw.a((c.a) RoomSendGiftView.this);
                                        RoomSendGiftView.this.niw.show(((VideoPlayer) RoomSendGiftView.this.e).getSupportFragmentManager(), "SendLoyalFansDialog");
                                        RoomSendGiftView.this.e();
                                    }
                                    z2 = true;
                                }
                            }
                            if (!z2) {
                                i3++;
                                z3 = z2;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (i2 == 1027) {
                        if (!h.isEmpty(str3)) {
                            g.c(RoomSendGiftView.this.e, str3);
                        } else {
                            g.M(RoomSendGiftView.this.e, a.i.video_send_gift_coin_insufficient);
                        }
                    }
                    if (i2 == 1026 && !h.isEmpty(str3)) {
                        g.c(RoomSendGiftView.this.e, str3);
                    }
                }
            }
        };
        if (this.niM != null && this.niN.getVisibility() == 0) {
            com.kascend.chushou.c.c.dAI().a(jsonCallbackWrapper, this.niM.uid, str, this.niM.micRoomId, str2, j);
        } else {
            com.kascend.chushou.c.c.dAI().a(jsonCallbackWrapper, this.nik.mRoominfo.mRoomID, str, str2, j);
        }
    }

    @Override // com.kascend.chushou.view.b.c.a
    public void a(int i, String str) {
        if (!TextUtils.isEmpty(str) && com.kascend.chushou.d.e.c(this.e, null)) {
            String str2 = "";
            if (this.e instanceof VideoPlayer) {
                str2 = ((VideoPlayer) this.e).dAX().h;
            }
            a(i, str, str2, 1L, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getContext() instanceof a) {
            this.niS = (a) getContext();
        }
        tv.chushou.zues.a.a.register(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.widget.menu.KasBaseMenuView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.niS = null;
        this.mZA.dispose();
        super.onDetachedFromWindow();
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.nik = null;
        this.nit = null;
        this.b = null;
        this.nir = null;
        if (this.c != null) {
            this.c.clear();
            this.c = null;
        }
        if (this.d != null) {
            this.d.clear();
            this.d = null;
        }
        this.nil = null;
        this.p = -1;
        this.o = null;
        this.r = 0;
        this.s = null;
        this.F.clear();
        if (this.niv != null) {
            this.niv.clear();
            this.niv = null;
        }
        if (this.niD != null) {
            this.niD.dispose();
        }
        tv.chushou.zues.a.a.cq(this);
    }

    @Override // com.kascend.chushou.widget.menu.KasBaseMenuView, android.view.View.OnClickListener
    public void onClick(View view) {
        JSONObject M = com.kascend.chushou.d.e.M("_fromView", com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN);
        int id = view.getId();
        if (id == a.f.iv_gift_top_icon_two) {
            if (this.e != null && this.nip != null && this.nip.getTag() != null && (this.nip.getTag() instanceof ListItem)) {
                com.kascend.chushou.d.e.a(this.e, (ListItem) this.nip.getTag(), M);
            }
        } else if (id == a.f.iv_gift_top_icon_one) {
            if (this.e != null && this.niq != null && this.niq.getTag() != null && (this.niq.getTag() instanceof ListItem)) {
                com.kascend.chushou.d.e.a(this.e, (ListItem) this.niq.getTag(), M);
            }
        } else if (id == a.f.recharge) {
            HashMap hashMap = new HashMap();
            hashMap.put("_fromView", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", "33");
            if (this.nik != null && this.nik.mRoominfo != null) {
                hashMap.put("roomId", this.nik.mRoominfo.mRoomID);
            }
            com.kascend.chushou.d.a.c(this.e, tv.chushou.zues.utils.d.toJson(hashMap));
        } else if (id == a.f.gift_tab) {
            if (view instanceof TextView) {
                b(((TextView) view).getText().toString());
            }
        } else if (id == a.f.tv_noble_coin) {
            com.kascend.chushou.d.e.a(this.e, com.kascend.chushou.c.c.a(47));
        } else if (id == a.f.rl_gift_count) {
            if (this.niz == null) {
                this.niz = new com.kascend.chushou.widget.gifts.b(getContext(), this);
                this.niz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.6
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        RoomSendGiftView.this.nix.setImageResource(a.e.icon_arrow_red_up);
                    }
                });
            }
            int[] iArr = new int[2];
            this.niA.getLocationOnScreen(iArr);
            this.nix.setImageResource(a.e.icon_arrow_red_down);
            this.niz.showAtLocation(this.niA, 0, iArr[0] + ((this.niA.getWidth() - this.niz.getWidth()) / 2), (iArr[1] - this.niz.getHeight()) + 20);
        } else if (id == a.f.btn_present_single || id == a.f.btn_present) {
            if (this.niB.getVisibility() != 0) {
                j();
                if (this.nil != null && this.nil.mComboExpiryTime != 0) {
                    a(this.nil.mComboExpiryTime);
                    m();
                }
            }
            i();
        } else if (id == a.f.btn_combo) {
            a(this.nil.mComboExpiryTime);
            i();
        } else if (id == a.f.tv_emoji_search || id == a.f.rl_gift_emoji_search_edit_bar) {
            if (this.niE != null) {
                setVisibility(8);
                this.niE.a(true, false);
            }
        } else if (id == a.f.iv_emoji_delete) {
            if (this.niE != null) {
                setVisibility(8);
                this.niE.a(true, true);
            }
        } else if (id == a.f.btn_search) {
            a(this.mXz.getText().toString());
        } else if (id == a.f.tv_mic_user_info) {
            if (this.niM != null) {
                com.kascend.chushou.d.a.a(this.e, (JSONObject) null, this.n, this.niM.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
            }
        } else {
            super.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GeneralGift generalGift) {
        this.niy.setText(a.i.str_one);
        k();
        if (generalGift != null) {
            if (generalGift.mSupportBatch) {
                this.Q.setVisibility(0);
                this.P.setVisibility(8);
                if (this.C) {
                    if (tv.chushou.zues.utils.a.hf(this.e).x < 720) {
                        this.l.setVisibility(8);
                    } else {
                        this.l.setVisibility(0);
                    }
                }
            } else if (generalGift.mType == 1 || generalGift.mType == 2) {
                this.Q.setVisibility(8);
                this.P.setVisibility(0);
                if (this.C) {
                    this.l.setVisibility(0);
                }
            }
        }
    }

    private void a(long j) {
        this.niC = 10 * j;
        this.ncL.setText(String.valueOf(this.niC));
        if (this.niD != null) {
            this.niD.dispose();
        }
        this.niD = io.reactivex.g.a(0L, this.niC, 100L, 100L, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dHZ()).b(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Long l) throws Exception {
                RoomSendGiftView.W(RoomSendGiftView.this);
                if (RoomSendGiftView.this.niC > 0) {
                    RoomSendGiftView.this.ncL.setText(String.valueOf(RoomSendGiftView.this.niC));
                } else {
                    RoomSendGiftView.this.l();
                }
            }
        });
    }

    private void k() {
        if (this.niB != null && this.niB.getVisibility() == 0) {
            if (this.niD != null) {
                this.niD.dispose();
            }
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.niB.startAnimation(AnimationUtils.loadAnimation(getContext(), a.C0682a.anim_bottom_right_out));
        this.niB.postDelayed(new Runnable() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.8
            @Override // java.lang.Runnable
            public void run() {
                if (RoomSendGiftView.this.niB != null) {
                    RoomSendGiftView.this.niB.setVisibility(8);
                }
            }
        }, 200L);
    }

    private void m() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.C0682a.anim_bottom_right_in);
        this.niB.setVisibility(0);
        this.niB.startAnimation(loadAnimation);
    }

    @Override // com.kascend.chushou.widget.gifts.b.a
    public void a(boolean z, int i) {
        if (z) {
            com.kascend.chushou.widget.gifts.a aVar = new com.kascend.chushou.widget.gifts.a(getContext(), this.C);
            if (this.C) {
                aVar.a(new a.InterfaceC0716a() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.9
                    @Override // com.kascend.chushou.widget.gifts.a.InterfaceC0716a
                    public void a(int i2) {
                        RoomSendGiftView.this.niy.setText(String.valueOf(i2));
                    }

                    @Override // com.kascend.chushou.widget.gifts.a.InterfaceC0716a
                    public void b(int i2) {
                    }
                });
                aVar.showAtLocation(this, 80, 0, 0);
                return;
            }
            aVar.a(new a.InterfaceC0716a() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.10
                @Override // com.kascend.chushou.widget.gifts.a.InterfaceC0716a
                public void a(int i2) {
                }

                @Override // com.kascend.chushou.widget.gifts.a.InterfaceC0716a
                public void b(int i2) {
                    RoomSendGiftView.this.niy.setText(String.valueOf(i2));
                }
            });
            int[] iArr = new int[2];
            this.niA.getLocationOnScreen(iArr);
            aVar.showAtLocation(this.niA, 0, iArr[0], iArr[1] - tv.chushou.zues.utils.a.dip2px(getContext(), 152.13333f));
            return;
        }
        this.niy.setText(String.valueOf(i));
    }

    public void setOnGiftClickListener(b bVar) {
        this.niE = bVar;
    }

    @Subscribe
    public void onEmojiEvent(com.kascend.chushou.widget.gifts.a.a aVar) {
        if (isShown() && TextUtils.equals(aVar.a, this.n)) {
            switch (aVar.c) {
                case 1:
                    if (aVar.b) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.C0682a.slide_in_bottom_anim);
                        this.aQb.setVisibility(0);
                        this.aQb.startAnimation(loadAnimation);
                        return;
                    }
                    this.aQb.startAnimation(AnimationUtils.loadAnimation(getContext(), a.C0682a.slide_out_bottom_anim));
                    this.f.postDelayed(new Runnable() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.11
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RoomSendGiftView.this.aQb != null) {
                                RoomSendGiftView.this.aQb.setVisibility(8);
                            }
                        }
                    }, 200L);
                    k();
                    return;
                case 2:
                    c(aVar.d);
                    return;
                default:
                    return;
            }
        }
    }

    private void c(int i) {
        this.niJ.MX(i);
    }

    public void a(String str) {
        if (this.niK != null) {
            this.niK.a(str);
        }
    }

    public void setEmojiSearchText(String str) {
        this.mXz.setText(str);
    }
}
