package com.kascend.chushou.widget.gifts;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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
/* loaded from: classes5.dex */
public class RoomSendGiftView extends KasBaseMenuView implements View.OnClickListener, c.a, PagerView.a, b.a {
    private boolean B;
    private boolean C;
    private HashMap<String, GiftPanelStatus> F;
    private TextView P;
    private LinearLayout Q;
    private boolean U;
    private boolean V;
    private View aUA;
    public View b;
    public ArrayList<BaseGiftView> c;
    public ArrayList<TextView> d;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView mYa;
    private TextView mYc;
    private String n;
    private io.reactivex.disposables.a nad;
    private TextView ndo;
    public FullRoomInfo niN;
    private GeneralGift niO;
    private FoodView niP;
    private FoodView niQ;
    private FoodView niR;
    private FrescoThumbnailView niS;
    private FrescoThumbnailView niT;
    private PagerView niU;
    private LinearLayout niV;
    private c niW;
    private List<GeneralTabGift> niX;
    private List<GeneralTabGift> niY;
    private com.kascend.chushou.view.b.c niZ;
    private ImageView nja;
    private TextView njb;
    private com.kascend.chushou.widget.gifts.b njc;
    private View njd;
    private RippleButton nje;
    private long njf;
    private io.reactivex.disposables.b njg;
    private b njh;
    private List<GeneralGift> nji;
    private ImageView njj;
    private View njk;
    private FrameLayout njl;
    private EmptyLoadingView njm;
    private f njn;
    private RelativeLayout njo;
    private MicMemberInfo njp;
    private RelativeLayout njq;
    private FrescoThumbnailView njr;
    private TextView njs;
    private TextView njt;
    private TextView nju;
    private a njv;
    private FoodView.a njw;
    private View o;
    private int p;
    private int r;
    private String s;

    /* loaded from: classes5.dex */
    public interface a {
        void A();

        void B();
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, boolean z2);

        void b(ConfigDetail configDetail);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view, String str);
    }

    static /* synthetic */ long U(RoomSendGiftView roomSendGiftView) {
        long j = roomSendGiftView.njf;
        roomSendGiftView.njf = j - 1;
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
        this.niO = null;
        this.B = true;
        this.C = true;
        this.niY = new ArrayList();
        this.F = new HashMap<>();
        this.nad = new io.reactivex.disposables.a();
        this.niZ = null;
        this.njf = 0L;
        this.nji = new ArrayList();
        this.U = false;
        this.njw = new FoodView.a() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.12
            @Override // com.kascend.chushou.player.ui.food.FoodView.a
            public boolean a() {
                int i2;
                if (RoomSendGiftView.this.njo != null && RoomSendGiftView.this.e != null && (!(RoomSendGiftView.this.e instanceof VideoPlayer) || !((VideoPlayer) RoomSendGiftView.this.e).isFinishing())) {
                    if ((RoomSendGiftView.this.niQ != null && RoomSendGiftView.this.niQ.getVisibility() == 0) || (RoomSendGiftView.this.niR != null && RoomSendGiftView.this.niR.getVisibility() == 0)) {
                        i2 = tv.chushou.zues.utils.a.dip2px(RoomSendGiftView.this.e, 32.0f);
                    } else {
                        i2 = 0;
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) RoomSendGiftView.this.njo.getLayoutParams();
                    layoutParams.height = i2 + tv.chushou.zues.utils.a.dip2px(RoomSendGiftView.this.e, 10.0f);
                    RoomSendGiftView.this.njo.setLayoutParams(layoutParams);
                }
                return true;
            }
        };
        a(context);
    }

    public void setOnGiftSendListener(c cVar) {
        this.niW = cVar;
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
            this.njo = (RelativeLayout) this.f.findViewById(a.f.ll_gift_ad);
            this.niP = (FoodView) this.f.findViewById(a.f.iv_gift_ad);
            this.niQ = (FoodView) this.f.findViewById(a.f.ad_left);
            this.niR = (FoodView) this.f.findViewById(a.f.ad_right);
            this.niS = (FrescoThumbnailView) this.f.findViewById(a.f.iv_gift_top_icon_two);
            this.niT = (FrescoThumbnailView) this.f.findViewById(a.f.iv_gift_top_icon_one);
            this.niT.setOnClickListener(this);
            this.niS.setOnClickListener(this);
            this.niV = (LinearLayout) this.f.findViewById(a.f.ll_tab_contain);
            this.niU = (PagerView) this.f.findViewById(a.f.rl_gift_contain);
            this.niU.setOnPageChangedListener(this);
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
            this.nja = (ImageView) this.f.findViewById(a.f.iv_arrow);
            this.njb = (TextView) this.f.findViewById(a.f.tv_gift_count);
            this.njd = this.f.findViewById(a.f.rl_gift_count);
            this.njd.setOnClickListener(this);
            this.ndo = (TextView) this.f.findViewById(a.f.tv_second);
            this.nje = (RippleButton) this.f.findViewById(a.f.btn_combo);
            this.nje.setOnClickListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.aUA = this.f.findViewById(a.f.ll_emoji_search);
            this.njk = this.f.findViewById(a.f.rl_gift_emoji_search_edit_bar);
            this.mYa = (TextView) this.f.findViewById(a.f.btn_search);
            this.njj = (ImageView) this.f.findViewById(a.f.iv_emoji_delete);
            this.mYc = (TextView) this.f.findViewById(a.f.tv_emoji_search);
            this.mYa.setOnClickListener(this);
            this.mYc.setOnClickListener(this);
            this.njk.setOnClickListener(this);
            this.njj.setOnClickListener(this);
            this.mYc.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.1
                @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    super.afterTextChanged(editable);
                    RoomSendGiftView.this.mYa.setEnabled(editable.length() > 0);
                    RoomSendGiftView.this.njj.setVisibility(editable.length() <= 0 ? 8 : 0);
                }
            });
            this.njl = (FrameLayout) this.f.findViewById(a.f.fl_emoji_container);
            this.njm = (EmptyLoadingView) this.f.findViewById(a.f.empty_search);
            this.njq = (RelativeLayout) this.f.findViewById(a.f.rl_mic_user);
            this.njr = (FrescoThumbnailView) this.f.findViewById(a.f.ftv_mic_avatar);
            this.njs = (TextView) this.f.findViewById(a.f.tv_mic_order);
            this.njt = (TextView) this.f.findViewById(a.f.tv_mic_nickname);
            this.nju = (TextView) this.f.findViewById(a.f.tv_mic_user_info);
            this.nju.setOnClickListener(this);
            addView(this.f, layoutParams);
        }
    }

    public void a(ListItem listItem, ListItem listItem2, ListItem listItem3, boolean z) {
        int i;
        int i2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.njo.getLayoutParams();
        if (listItem != null) {
            int a2 = a(listItem, this.niP, z);
            if (!this.niP.isShown()) {
                if (this.niP.a(listItem, this.njw, false)) {
                    int dip2px = a2 - tv.chushou.zues.utils.a.dip2px(this.e, 10.0f);
                    this.niP.setVisibility(0);
                    i = dip2px;
                } else {
                    this.niP.setVisibility(8);
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
            this.niQ.a(listItem2, (FoodView.a) null, true, (String) null, dip2px2);
            i = Math.max(i, dip2px2 - dip2px3);
        } else {
            this.niQ.setVisibility(8);
        }
        if (listItem3 != null && !h.isEmpty(listItem3.mCover)) {
            this.niR.a(listItem3, (FoodView.a) null, true, (String) null, dip2px2);
            i2 = Math.max(i, dip2px2 - dip2px3);
        } else {
            this.niR.setVisibility(8);
            i2 = i;
        }
        layoutParams.height = i2 + tv.chushou.zues.utils.a.dip2px(this.e, 10.0f);
        this.njo.setLayoutParams(layoutParams);
    }

    private int a(ListItem listItem, View view, boolean z) {
        int a2;
        Point hd = tv.chushou.zues.utils.a.hd(this.e);
        if (z) {
            a2 = com.kascend.chushou.a.a.dBM().a(listItem, view, hd.x, (hd.x * 106) / 720, (hd.x * 77) / 720);
        } else {
            a2 = com.kascend.chushou.a.a.dBM().a(listItem, view, hd.x, (hd.x * 106) / 1280, (hd.x * 77) / 1280);
        }
        if (a2 == 0) {
            if (z) {
                return (int) (hd.x / 6.79d);
            }
            return hd.x / 12;
        }
        return a2;
    }

    @Override // com.kascend.chushou.widget.menu.KasBaseMenuView
    public void setMicMemberInfo(MicMemberInfo micMemberInfo) {
        if (this.njq != null) {
            this.njp = micMemberInfo;
            if (micMemberInfo == null) {
                this.njq.setVisibility(8);
                return;
            }
            this.njq.setVisibility(0);
            this.njr.i(micMemberInfo.avatar, com.kascend.chushou.view.a.a(micMemberInfo.gender), b.a.small, b.a.small);
            this.njs.setText(getContext().getString(a.i.str_send_to_order, Integer.valueOf(micMemberInfo.order)));
            this.njt.setText(micMemberInfo.nickname);
        }
    }

    public void a() {
        setMicMemberInfo(null);
    }

    public void setGiftTopIcon(List<ListItem> list) {
        if (!h.isEmpty(list)) {
            if (list.size() == 1) {
                this.niS.setVisibility(8);
                ListItem listItem = list.get(0);
                if (!h.isEmpty(listItem.mCover)) {
                    this.niT.setTag(listItem);
                    this.niT.setAnim(true);
                    this.niT.a(listItem.mCover, 0, 0, 0, 1);
                }
                this.niT.setVisibility(0);
                return;
            }
            ListItem listItem2 = list.get(0);
            if (!h.isEmpty(listItem2.mCover)) {
                this.niT.setTag(listItem2);
                this.niT.setAnim(true);
                this.niT.a(listItem2.mCover, 0, 0, 0, 1);
            }
            this.niT.setVisibility(0);
            ListItem listItem3 = list.get(1);
            if (!h.isEmpty(listItem3.mCover)) {
                this.niS.setTag(listItem3);
                this.niS.setAnim(true);
                this.niS.a(listItem3.mCover, 0, 0, 0, 1);
            }
            this.niS.setVisibility(0);
            return;
        }
        this.niT.setVisibility(8);
        this.niS.setVisibility(8);
    }

    public void a(boolean z, boolean z2) {
        if (!h.isEmpty(this.niX)) {
            this.B = z2;
            this.C = z;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.niU.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aUA.getLayoutParams();
            if (this.B) {
                layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.e, 170.0f);
                layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.e, 214.0f);
            } else {
                layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.e, 95.0f);
                layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.e, 129.0f);
            }
            this.niU.setLayoutParams(layoutParams);
            this.aUA.setLayoutParams(layoutParams2);
            if (!(this.njl.getChildAt(0) instanceof f)) {
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
                    this.njn = new f(this.e, 0, aVar, this.n, 5);
                } else {
                    this.njn = new f(this.e, 0, aVar, this.n, 8);
                }
                this.njn.setSearchPresenter(new com.kascend.chushou.widget.gifts.c(this.n));
                this.njl.addView(this.njn, 0);
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
        if (!h.isEmpty(this.niX)) {
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            int size = this.c.size();
            int size2 = size - this.niX.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.niU.removeView(this.c.get((size - 1) - i2));
                this.niV.removeView(this.d.get((size - 1) - i2));
            }
            for (int i3 = 0; i3 < size2; i3++) {
                this.c.remove((size - 1) - i3);
                this.d.remove((size - 1) - i3);
            }
            for (final int i4 = 0; i4 < this.niX.size(); i4++) {
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
                    TextView dEB = dEB();
                    this.c.add(verticalRoomGiftView);
                    this.niU.addView(verticalRoomGiftView);
                    this.d.add(dEB);
                    this.niV.addView(dEB);
                    verticalRoomGiftView2 = verticalRoomGiftView;
                    textView = dEB;
                }
                GeneralTabGift generalTabGift = this.niX.get(i4);
                verticalRoomGiftView2.setViewListener(new BaseGiftView.a() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.14
                    @Override // com.kascend.chushou.widget.gifts.BaseGiftView.a
                    public void a(int i5) {
                        if (RoomSendGiftView.this.niX != null && i5 < RoomSendGiftView.this.niX.size()) {
                            RoomSendGiftView.this.niX.remove(i5);
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
                        RoomSendGiftView.this.niO = (GeneralGift) obj;
                        GiftPanelStatus giftPanelStatus = (GiftPanelStatus) RoomSendGiftView.this.F.get(str);
                        if (giftPanelStatus == null) {
                            giftPanelStatus = new GiftPanelStatus();
                        }
                        giftPanelStatus.mGeneralGiftSelectPos = RoomSendGiftView.this.p;
                        giftPanelStatus.mGeneralGiftView = RoomSendGiftView.this.o;
                        giftPanelStatus.mSelectGiftObj = RoomSendGiftView.this.niO;
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
                while (i < this.niX.size()) {
                    if (this.s.equals(this.niX.get(i).mName)) {
                        break;
                    }
                    i++;
                }
            }
            i = 0;
            b(i);
            if (this.niU != null) {
                this.niU.a(i, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GeneralGift generalGift) {
        ListItem listItem = new ListItem();
        switch (generalGift.mType) {
            case 94:
                if (this.njh != null) {
                    ConfigDetail configDetail = new ConfigDetail();
                    configDetail.mType = "94";
                    configDetail.mUrl = generalGift.mUrl;
                    configDetail.mLandscape = generalGift.mLandscape;
                    configDetail.mPortrait = generalGift.mPortrait;
                    this.njh.b(configDetail);
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

    private TextView dEB() {
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
                if (!h.isEmpty(this.niX) && i2 < this.niX.size()) {
                    this.s = this.niX.get(i2).mName;
                }
                this.o = baseGiftView.getCurGiftView();
                this.p = baseGiftView.getCurSelectPos();
                this.niO = baseGiftView.getCurObj();
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
                    if (!h.isEmpty(this.niX) && i < this.niX.size()) {
                        this.s = this.niX.get(i).mName;
                    }
                    this.o = baseGiftView.getCurGiftView();
                    this.p = baseGiftView.getCurSelectPos();
                    this.niO = baseGiftView.getCurObj();
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
            if (this.niU != null) {
                this.niU.a(this.r, true);
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
        String e = com.kascend.chushou.d.h.dBS().e();
        String f = com.kascend.chushou.d.h.dBS().f();
        final int g = com.kascend.chushou.d.h.dBS().g();
        if (LoginManager.Instance().islogined()) {
            a(e, f, g);
            com.kascend.chushou.c.c.dBO().c(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.2
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (RoomSendGiftView.this.e != null && !((VideoPlayer) RoomSendGiftView.this.e).isFinishing()) {
                        RoomSendGiftView.this.a(com.kascend.chushou.d.h.dBS().e(), com.kascend.chushou.d.h.dBS().f(), g);
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            List<GeneralTabGift> a2 = com.kascend.chushou.c.f.a(optJSONObject);
                            if (RoomSendGiftView.this.niN != null && !h.isEmpty(a2)) {
                                RoomSendGiftView.this.niY.clear();
                                RoomSendGiftView.this.niY.addAll(a2);
                                RxExecutor.post(RoomSendGiftView.this.nad, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (RoomSendGiftView.this.e != null) {
                                            synchronized (RoomSendGiftView.class) {
                                                RoomSendGiftView.this.niN.mGeneralTabGifts.clear();
                                                RoomSendGiftView.this.niN.mGeneralTabGifts.addAll(RoomSendGiftView.this.niY);
                                                if (RoomSendGiftView.this.niX == null) {
                                                    RoomSendGiftView.this.niX = new ArrayList();
                                                }
                                                RoomSendGiftView.this.niX.clear();
                                                RoomSendGiftView.this.niX.addAll(RoomSendGiftView.this.niY);
                                                RoomSendGiftView.this.U = true;
                                                if (!h.isEmpty(RoomSendGiftView.this.nji)) {
                                                    Iterator it = RoomSendGiftView.this.niX.iterator();
                                                    while (true) {
                                                        if (!it.hasNext()) {
                                                            break;
                                                        }
                                                        GeneralTabGift generalTabGift = (GeneralTabGift) it.next();
                                                        if (generalTabGift.mFrequentlyUsedTab) {
                                                            generalTabGift.mGeneralGifts.addAll(RoomSendGiftView.this.nji);
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
        this.nji.clear();
        this.U = false;
        b();
        getCommonlyGift();
    }

    private void getCommonlyGift() {
        List<Integer> dBW = com.kascend.chushou.d.h.dBS().dBW();
        if (!h.isEmpty(dBW)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < dBW.size(); i++) {
                sb.append(dBW.get(i));
                if (i != dBW.size() - 1) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            com.kascend.chushou.c.c.dBO().d(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.3
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
                                RoomSendGiftView.this.nji.addAll(a2);
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
                                    GeneralTabGift generalTabGift = (GeneralTabGift) RoomSendGiftView.this.niX.get(tabIndex);
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
                            com.kascend.chushou.d.h.dBS().b(arrayList);
                            return;
                        }
                        com.kascend.chushou.d.h.dBS().b(new ArrayList());
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
        if (this.aUA.getVisibility() == 0) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.widget.gifts.a.a(this.n, false));
            return;
        }
        if (this.njn != null) {
            this.njn.a();
            c(2);
            this.mYc.setText("");
        }
        k();
        if (this.niP != null) {
            this.niP.a();
        }
        if (this.niQ != null) {
            this.niQ.a();
        }
        if (this.niR != null) {
            this.niR.a();
        }
        super.e();
        a();
    }

    private void h() {
    }

    public void a(FullRoomInfo fullRoomInfo) {
        if (fullRoomInfo != null) {
            this.niN = fullRoomInfo;
            if (fullRoomInfo.mRoominfo != null) {
                this.niX = fullRoomInfo.mGeneralTabGifts;
                this.n = fullRoomInfo.mRoominfo.mRoomID;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, GeneralGift generalGift, GeneralGift generalGift2) {
        boolean z;
        if (generalGift != null && !h.isEmpty(this.niX)) {
            int i3 = 0;
            boolean z2 = false;
            while (i3 < this.niX.size()) {
                GeneralTabGift generalTabGift = this.niX.get(i3);
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
        if (this.niO != null) {
            String str = null;
            if (this.e instanceof VideoPlayer) {
                str = com.kascend.chushou.d.e.a(((VideoPlayer) this.e).dCd().h, "_fromView", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "11");
            }
            if (com.kascend.chushou.d.e.c(this.e, str)) {
                int i = this.p;
                GeneralGift generalGift = this.niO;
                View view = this.o;
                if (i >= 0 && generalGift != null && view != null) {
                    if (this.niW != null) {
                        this.niW.a(view, generalGift.mIcon);
                    }
                    String str2 = null;
                    if (this.e instanceof VideoPlayer) {
                        str2 = ((VideoPlayer) this.e).dCd().h;
                    }
                    if (this.niN != null && this.niN.mRoominfo != null) {
                        if (generalGift.mType == 2) {
                            long j = 1;
                            if (generalGift.mSupportBatch) {
                                j = h.parseLong(this.njb.getText().toString());
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
                                        if (RoomSendGiftView.this.njv != null) {
                                            RoomSendGiftView.this.njv.B();
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
                            if (this.njp != null && this.njq.getVisibility() == 0) {
                                com.kascend.chushou.c.c.dBO().a(bVar, String.valueOf(generalGift.mActionType), String.valueOf(generalGift.mId), this.niN.mRoominfo.mRoomID, this.njp.uid, this.njp.micRoomId, str2, this.r, this.p, this.niO, j);
                            } else {
                                com.kascend.chushou.c.c.dBO().a(bVar, String.valueOf(generalGift.mActionType), String.valueOf(generalGift.mId), this.niN.mRoominfo.mRoomID, str2, this.r, this.p, this.niO, j);
                            }
                            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "29", "giftId", Integer.valueOf(generalGift.mId), "roomId", this.niN.mRoominfo.mRoomID);
                            return;
                        }
                        int i2 = generalGift.mPoint;
                        long j2 = 1;
                        if (generalGift.mSupportBatch) {
                            j2 = h.parseLong(this.njb.getText().toString());
                        }
                        if (j2 < 1) {
                            j2 = 1;
                        }
                        a(i2, String.valueOf(generalGift.mId), str2, j2, this.V);
                        com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "29", "giftId", Integer.valueOf(generalGift.mId), "roomId", this.niN.mRoominfo.mRoomID);
                    }
                }
            }
        }
    }

    private void j() {
        BaseGiftView baseGiftView;
        if (this.aUA.getVisibility() == 0) {
            this.o = this.njn.b;
            this.p = this.njn.d;
            this.niO = this.njn.mOR;
            this.V = true;
        } else if (this.c != null && this.r < this.c.size() && (baseGiftView = this.c.get(this.r)) != null) {
            baseGiftView.a();
            this.o = baseGiftView.getCurGiftView();
            this.p = baseGiftView.getCurSelectPos();
            this.niO = baseGiftView.getCurObj();
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
                    if (RoomSendGiftView.this.njv != null) {
                        RoomSendGiftView.this.njv.A();
                    }
                    RoomSendGiftView.this.a(com.kascend.chushou.d.h.dBS().e(), com.kascend.chushou.d.h.dBS().f(), com.kascend.chushou.d.h.dBS().g());
                    if (RoomSendGiftView.this.niZ != null && RoomSendGiftView.this.niZ.getDialog().isShowing()) {
                        RoomSendGiftView.this.niZ.dismissAllowingStateLoss();
                    }
                    if (z) {
                        com.kascend.chushou.d.h.dBS().c(h.parseInt(str));
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
                        if (!RoomSendGiftView.this.C || TextUtils.isEmpty(str5) || RoomSendGiftView.this.niX == null) {
                            g.c(RoomSendGiftView.this.e, RoomSendGiftView.this.e.getString(a.i.no_loyal_fans));
                            return;
                        }
                        int i3 = 0;
                        boolean z3 = false;
                        while (i3 < RoomSendGiftView.this.niX.size()) {
                            GeneralTabGift generalTabGift = (GeneralTabGift) RoomSendGiftView.this.niX.get(i3);
                            int i4 = 0;
                            while (true) {
                                if (i4 >= generalTabGift.mGeneralGifts.size()) {
                                    z2 = z3;
                                    break;
                                } else if (generalTabGift.mGeneralGifts.get(i4).mType != 1 || !str5.equals(String.valueOf(generalTabGift.mGeneralGifts.get(i4).mId))) {
                                    i4++;
                                } else {
                                    GeneralGift generalGift = generalTabGift.mGeneralGifts.get(i4);
                                    if (RoomSendGiftView.this.niZ == null || RoomSendGiftView.this.niZ.getDialog() == null || !RoomSendGiftView.this.niZ.getDialog().isShowing()) {
                                        RoomSendGiftView.this.niZ = com.kascend.chushou.view.b.c.d(String.valueOf(generalGift.mId), generalGift.mPoint, generalGift.mIcon, RoomSendGiftView.this.niN.mRoominfo.mRoomID);
                                        RoomSendGiftView.this.niZ.a((c.a) RoomSendGiftView.this);
                                        RoomSendGiftView.this.niZ.show(((VideoPlayer) RoomSendGiftView.this.e).getSupportFragmentManager(), "SendLoyalFansDialog");
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
                    } else if (i2 == 1027) {
                        if (h.isEmpty(str3)) {
                            str3 = tv.chushou.widget.a.c.getString(a.i.video_send_gift_coin_insufficient);
                        }
                        RoomSendGiftView.this.c(str3);
                    } else if (i2 == 1026 && !h.isEmpty(str3)) {
                        g.c(RoomSendGiftView.this.e, str3);
                    }
                }
            }
        };
        if (this.njp != null && this.njq.getVisibility() == 0) {
            com.kascend.chushou.c.c.dBO().a(jsonCallbackWrapper, this.njp.uid, str, this.njp.micRoomId, str2, j);
        } else {
            com.kascend.chushou.c.c.dBO().a(jsonCallbackWrapper, this.niN.mRoominfo.mRoomID, str, str2, j);
        }
    }

    @Override // com.kascend.chushou.view.b.c.a
    public void a(int i, String str) {
        if (!TextUtils.isEmpty(str) && com.kascend.chushou.d.e.c(this.e, null)) {
            String str2 = "";
            if (this.e instanceof VideoPlayer) {
                str2 = ((VideoPlayer) this.e).dCd().h;
            }
            a(i, str, str2, 1L, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getContext() instanceof a) {
            this.njv = (a) getContext();
        }
        tv.chushou.zues.a.a.register(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.widget.menu.KasBaseMenuView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.njv = null;
        this.nad.dispose();
        super.onDetachedFromWindow();
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.niN = null;
        this.niW = null;
        this.b = null;
        this.niU = null;
        if (this.c != null) {
            this.c.clear();
            this.c = null;
        }
        if (this.d != null) {
            this.d.clear();
            this.d = null;
        }
        this.niO = null;
        this.p = -1;
        this.o = null;
        this.r = 0;
        this.s = null;
        this.F.clear();
        if (this.niY != null) {
            this.niY.clear();
            this.niY = null;
        }
        if (this.njg != null) {
            this.njg.dispose();
        }
        tv.chushou.zues.a.a.cr(this);
    }

    @Override // com.kascend.chushou.widget.menu.KasBaseMenuView, android.view.View.OnClickListener
    public void onClick(View view) {
        JSONObject M = com.kascend.chushou.d.e.M("_fromView", com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN);
        int id = view.getId();
        if (id == a.f.iv_gift_top_icon_two) {
            if (this.e != null && this.niS != null && this.niS.getTag() != null && (this.niS.getTag() instanceof ListItem)) {
                com.kascend.chushou.d.e.a(this.e, (ListItem) this.niS.getTag(), M);
            }
        } else if (id == a.f.iv_gift_top_icon_one) {
            if (this.e != null && this.niT != null && this.niT.getTag() != null && (this.niT.getTag() instanceof ListItem)) {
                com.kascend.chushou.d.e.a(this.e, (ListItem) this.niT.getTag(), M);
            }
        } else if (id == a.f.recharge) {
            HashMap hashMap = new HashMap();
            hashMap.put("_fromView", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", "33");
            if (this.niN != null && this.niN.mRoominfo != null) {
                hashMap.put("roomId", this.niN.mRoominfo.mRoomID);
            }
            com.kascend.chushou.d.a.c(this.e, tv.chushou.zues.utils.d.toJson(hashMap));
        } else if (id == a.f.gift_tab) {
            if (view instanceof TextView) {
                b(((TextView) view).getText().toString());
            }
        } else if (id == a.f.tv_noble_coin) {
            com.kascend.chushou.d.e.a(this.e, com.kascend.chushou.c.c.a(47));
        } else if (id == a.f.rl_gift_count) {
            if (this.njc == null) {
                this.njc = new com.kascend.chushou.widget.gifts.b(getContext(), this);
                this.njc.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.6
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        RoomSendGiftView.this.nja.setImageResource(a.e.icon_arrow_red_up);
                    }
                });
            }
            int[] iArr = new int[2];
            this.njd.getLocationOnScreen(iArr);
            this.nja.setImageResource(a.e.icon_arrow_red_down);
            this.njc.showAtLocation(this.njd, 0, iArr[0] + ((this.njd.getWidth() - this.njc.getWidth()) / 2), (iArr[1] - this.njc.getHeight()) + 20);
        } else if (id == a.f.btn_present_single || id == a.f.btn_present) {
            if (this.nje.getVisibility() != 0) {
                j();
                if (this.niO != null && this.niO.mComboExpiryTime != 0) {
                    a(this.niO.mComboExpiryTime);
                    m();
                }
            }
            i();
        } else if (id == a.f.btn_combo) {
            a(this.niO.mComboExpiryTime);
            i();
        } else if (id == a.f.tv_emoji_search || id == a.f.rl_gift_emoji_search_edit_bar) {
            if (this.njh != null) {
                setVisibility(8);
                this.njh.a(true, false);
            }
        } else if (id == a.f.iv_emoji_delete) {
            if (this.njh != null) {
                setVisibility(8);
                this.njh.a(true, true);
            }
        } else if (id == a.f.btn_search) {
            a(this.mYc.getText().toString());
        } else if (id == a.f.tv_mic_user_info) {
            if (this.njp != null) {
                com.kascend.chushou.d.a.a(this.e, (JSONObject) null, this.n, this.njp.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
            }
        } else {
            super.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GeneralGift generalGift) {
        this.njb.setText(a.i.str_one);
        k();
        if (generalGift != null) {
            if (generalGift.mSupportBatch) {
                this.Q.setVisibility(0);
                this.P.setVisibility(8);
                if (this.C) {
                    if (tv.chushou.zues.utils.a.he(this.e).x < 720) {
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
        this.njf = 10 * j;
        this.ndo.setText(String.valueOf(this.njf));
        if (this.njg != null) {
            this.njg.dispose();
        }
        this.njg = io.reactivex.g.a(0L, this.njf, 100L, 100L, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dJg()).b(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Long l) throws Exception {
                RoomSendGiftView.U(RoomSendGiftView.this);
                if (RoomSendGiftView.this.njf > 0) {
                    RoomSendGiftView.this.ndo.setText(String.valueOf(RoomSendGiftView.this.njf));
                } else {
                    RoomSendGiftView.this.l();
                }
            }
        });
    }

    private void k() {
        if (this.nje != null && this.nje.getVisibility() == 0) {
            if (this.njg != null) {
                this.njg.dispose();
            }
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.nje.startAnimation(AnimationUtils.loadAnimation(getContext(), a.C0690a.anim_bottom_right_out));
        this.nje.postDelayed(new Runnable() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.8
            @Override // java.lang.Runnable
            public void run() {
                if (RoomSendGiftView.this.nje != null) {
                    RoomSendGiftView.this.nje.setVisibility(8);
                }
            }
        }, 200L);
    }

    private void m() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.C0690a.anim_bottom_right_in);
        this.nje.setVisibility(0);
        this.nje.startAnimation(loadAnimation);
    }

    @Override // com.kascend.chushou.widget.gifts.b.a
    public void a(boolean z, int i) {
        if (z) {
            com.kascend.chushou.widget.gifts.a aVar = new com.kascend.chushou.widget.gifts.a(getContext(), this.C);
            if (this.C) {
                aVar.a(new a.InterfaceC0724a() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.9
                    @Override // com.kascend.chushou.widget.gifts.a.InterfaceC0724a
                    public void a(int i2) {
                        RoomSendGiftView.this.njb.setText(String.valueOf(i2));
                    }

                    @Override // com.kascend.chushou.widget.gifts.a.InterfaceC0724a
                    public void b(int i2) {
                    }
                });
                aVar.showAtLocation(this, 80, 0, 0);
                return;
            }
            aVar.a(new a.InterfaceC0724a() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.10
                @Override // com.kascend.chushou.widget.gifts.a.InterfaceC0724a
                public void a(int i2) {
                }

                @Override // com.kascend.chushou.widget.gifts.a.InterfaceC0724a
                public void b(int i2) {
                    RoomSendGiftView.this.njb.setText(String.valueOf(i2));
                }
            });
            int[] iArr = new int[2];
            this.njd.getLocationOnScreen(iArr);
            aVar.showAtLocation(this.njd, 0, iArr[0], iArr[1] - tv.chushou.zues.utils.a.dip2px(getContext(), 152.13333f));
            return;
        }
        this.njb.setText(String.valueOf(i));
    }

    public void setOnGiftClickListener(b bVar) {
        this.njh = bVar;
    }

    @Subscribe
    public void onEmojiEvent(com.kascend.chushou.widget.gifts.a.a aVar) {
        if (isShown() && TextUtils.equals(aVar.a, this.n)) {
            switch (aVar.c) {
                case 1:
                    if (aVar.b) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.C0690a.slide_in_bottom_anim);
                        this.aUA.setVisibility(0);
                        this.aUA.startAnimation(loadAnimation);
                        return;
                    }
                    this.aUA.startAnimation(AnimationUtils.loadAnimation(getContext(), a.C0690a.slide_out_bottom_anim));
                    this.f.postDelayed(new Runnable() { // from class: com.kascend.chushou.widget.gifts.RoomSendGiftView.11
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RoomSendGiftView.this.aUA != null) {
                                RoomSendGiftView.this.aUA.setVisibility(8);
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
        this.njm.Na(i);
    }

    public void a(String str) {
        if (this.njn != null) {
            this.njn.a(str);
        }
    }

    public void setEmojiSearchText(String str) {
        this.mYc.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (!(this.e instanceof FragmentActivity)) {
            g.u(str);
            return;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) this.e;
        if (!fragmentActivity.isFinishing()) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            if (supportFragmentManager.findFragmentByTag("RechargeDialog") == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("_fromView", com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN);
                com.kascend.chushou.view.b.b.Rb(tv.chushou.zues.utils.d.toJson(hashMap)).show(supportFragmentManager, "RechargeDialog");
            }
        }
    }
}
