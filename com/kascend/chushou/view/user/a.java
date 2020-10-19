package com.kascend.chushou.view.user;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import com.facebook.drawee.span.b;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.i;
import com.kascend.chushou.b.a.a.m;
import com.kascend.chushou.bean.Response;
import com.kascend.chushou.bean.RoomSpaceData;
import com.kascend.chushou.bean.UserBean;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.MyUserInfo;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.d.e;
import com.kascend.chushou.player.VideoPlayer;
import com.kascend.chushou.player.ui.food.FoodView;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.toolkit.c;
import com.kascend.chushou.widget.AchievementView;
import com.kascend.chushou.widget.EmptyLoadingView;
import com.kascend.chushou.widget.ImageSubscribeButton;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.FlowLayout;
import tv.chushou.zues.widget.adapterview.d;
import tv.chushou.zues.widget.adapterview.recyclerview.a.a;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
import tv.chushou.zues.widget.sweetalert.b;
import tv.chushou.zues.widget.textview.EllipsizedTextView;
/* loaded from: classes6.dex */
public class a extends com.kascend.chushou.view.base.b implements View.OnClickListener {
    private TextView A;
    private TextView D;
    private TextView E;
    private TextView F;
    private RelativeLayout G;
    private ImageView M;
    private String N;
    private int P;
    private String Q;
    private String R;
    private boolean S;
    private String U;
    private String V;
    private View d;
    private RelativeLayout e;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private RelativeLayout oju;
    private FrescoThumbnailView opn;
    private FrescoThumbnailView osY;
    private FrescoThumbnailView oth;
    private RelativeLayout ouY;
    private ViewStub oxU;
    private ImageSubscribeButton oxV;
    private EllipsizedTextView oxW;
    private FrescoThumbnailView oxX;
    private LinearLayout oxY;
    private FrescoThumbnailView oxZ;
    private EmptyLoadingView oxq;
    private FrescoThumbnailView oya;
    private FrescoThumbnailView oyb;
    private AchievementView oyc;
    private SimpleDraweeSpanTextView oyd;
    private RelativeLayout oye;
    private RelativeLayout oyf;
    private LinearLayout oyg;
    private FlowLayout oyh;
    private FlowLayout oyi;
    private LinearLayout oyj;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<ListItem> oyk;
    private c oyl;
    private JSONObject oym;
    private FrameLayout oyo;
    private InterfaceC0926a oyp;
    private TextView p;
    private TextView v;
    private boolean w = true;
    private boolean W = false;
    private RoomSpaceData oyn = null;
    private boolean Y = false;

    /* renamed from: com.kascend.chushou.view.user.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0926a {
        void a(RoomSpaceData roomSpaceData);
    }

    public static a a(int i, String str, String str2, boolean z, String str3, boolean z2) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        if (!h.isEmpty(str)) {
            bundle.putString("uid", str);
        }
        if (!h.isEmpty(str2)) {
            bundle.putString("roomId", str2);
        }
        bundle.putBoolean("mScrollToPosition", z);
        bundle.putString("datainfo", str3);
        bundle.putBoolean("autoload", z2);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // com.kascend.chushou.view.base.b, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.P = arguments.getInt("type", 2);
            this.Q = arguments.getString("uid", "");
            this.R = arguments.getString("roomId", "");
            this.V = arguments.getString("datainfo");
            this.S = arguments.getBoolean("autoload", false);
        }
        if (this.mContext instanceof VideoPlayer) {
            this.oym = e.O("_fromView", Constants.VIA_REPORT_TYPE_WPA_STATE);
            this.U = this.oym == null ? "" : this.oym.toString();
            this.N = Constants.VIA_REPORT_TYPE_WPA_STATE;
        } else if (this.mContext instanceof UserRoomActivity) {
            this.oym = e.O("_fromView", Constants.VIA_REPORT_TYPE_DATALINE);
            this.U = this.oym == null ? "" : this.oym.toString();
            this.N = Constants.VIA_REPORT_TYPE_DATALINE;
        }
        MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
        if (userInfo != null && !h.isEmpty(this.Q) && this.Q.equals(userInfo.mUserID)) {
            this.W = true;
        }
    }

    @Override // com.kascend.chushou.view.base.b
    protected View initView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.fragment_user_space_bottom_new, viewGroup, false);
        this.oxU = (ViewStub) inflate.findViewById(a.f.viewstub_bg);
        this.oxq = (EmptyLoadingView) inflate.findViewById(a.f.empty_view);
        if (this.P == 1 || this.P == 2) {
        }
        this.d = inflate.findViewById(a.f.userspace_header);
        this.e = (RelativeLayout) this.d.findViewById(a.f.rl_live_userinfo);
        this.opn = (FrescoThumbnailView) this.d.findViewById(a.f.iv_avatar);
        this.osY = (FrescoThumbnailView) this.d.findViewById(a.f.iv_avatar_decoration);
        this.M = (ImageView) this.d.findViewById(a.f.iv_sex);
        this.oxV = (ImageSubscribeButton) this.d.findViewById(a.f.subscribe_btn);
        this.oxW = (EllipsizedTextView) this.d.findViewById(a.f.tv_nickname);
        this.d.findViewById(a.f.rl_nameinfo).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.kascend.chushou.view.user.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.oyn == null || a.this.oyn.user == null || a.this.oyn.room == null) {
                    return false;
                }
                e.a(a.this.getChildFragmentManager(), a.this.oyn.user.nickname, a.this.oyn.room.id, a.this.oyn.user.uid);
                return true;
            }
        });
        this.j = (TextView) this.d.findViewById(a.f.tv_game);
        this.k = (TextView) this.d.findViewById(a.f.tv_fans_count);
        this.l = (TextView) this.d.findViewById(a.f.tv_room_id);
        this.m = (TextView) this.d.findViewById(a.f.tv_live_time);
        this.n = (TextView) this.d.findViewById(a.f.tv_device);
        this.G = (RelativeLayout) this.d.findViewById(a.f.ll_fans_live);
        this.E = (TextView) this.d.findViewById(a.f.tv_fans);
        this.F = (TextView) this.d.findViewById(a.f.tv_subscribe);
        this.oxX = (FrescoThumbnailView) this.d.findViewById(a.f.iv_live_status_bg);
        this.p = (TextView) this.d.findViewById(a.f.tv_live_status);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.v = (TextView) this.d.findViewById(a.f.tv_live_notice);
        this.oxY = (LinearLayout) this.d.findViewById(a.f.ll_user_space_contribution);
        this.oxZ = (FrescoThumbnailView) this.d.findViewById(a.f.iv_image01);
        this.oya = (FrescoThumbnailView) this.d.findViewById(a.f.iv_image02);
        this.oyb = (FrescoThumbnailView) this.d.findViewById(a.f.iv_image03);
        this.oyc = (AchievementView) this.d.findViewById(a.f.av_medal);
        this.oyo = (FrameLayout) this.d.findViewById(a.f.fl_user_detail);
        this.oju = (RelativeLayout) this.d.findViewById(a.f.rl_user_level);
        this.oyd = (SimpleDraweeSpanTextView) this.d.findViewById(a.f.tv_live_level);
        this.ouY = (RelativeLayout) this.d.findViewById(a.f.rl_signature);
        this.A = (TextView) this.d.findViewById(a.f.tv_live_signature);
        this.oyg = (LinearLayout) this.d.findViewById(a.f.ll_medal);
        this.oyh = (FlowLayout) this.d.findViewById(a.f.fl_medal_container);
        this.oye = (RelativeLayout) this.d.findViewById(a.f.rl_favourite_games);
        this.oyi = (FlowLayout) this.d.findViewById(a.f.fl_games_container);
        this.oyf = (RelativeLayout) this.d.findViewById(a.f.rl_achievement);
        this.D = (TextView) this.d.findViewById(a.f.tv_achievement);
        this.oyj = (LinearLayout) this.d.findViewById(a.f.ll_recommend);
        RecyclerView recyclerView = (RecyclerView) this.d.findViewById(a.f.lv_recommend);
        this.oyk = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<ListItem>(a.h.view_recommend_item, new d() { // from class: com.kascend.chushou.view.user.a.2
            @Override // tv.chushou.zues.widget.adapterview.d
            public void E(View view, int i) {
                ListItem listItem = (ListItem) a.this.oyk.getItem(i);
                if (listItem != null) {
                    e.a(a.this.getContext(), listItem, e.O("_fromView", a.this.N, "_fromPos", com.kascend.chushou.toolkit.a.b.a(listItem.mDisplayStyle)));
                }
            }
        }) { // from class: com.kascend.chushou.view.user.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1029a view$OnLongClickListenerC1029a, ListItem listItem) {
                if (TextUtils.equals(listItem.mDisplayStyle, "10")) {
                    FoodView foodView = (FoodView) view$OnLongClickListenerC1029a.rL(a.f.iv_ad);
                    int i = tv.chushou.zues.utils.a.hj(foodView.getContext()).x;
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) foodView.getLayoutParams();
                    layoutParams.width = i;
                    layoutParams.height = i / 5;
                    foodView.setLayoutParams(layoutParams);
                    foodView.a(listItem, (FoodView.a) null, true, Constants.VIA_REPORT_TYPE_DATALINE);
                } else if (TextUtils.equals(listItem.mDisplayStyle, "32")) {
                    FoodView foodView2 = (FoodView) view$OnLongClickListenerC1029a.rL(a.f.iv_ad);
                    int i2 = tv.chushou.zues.utils.a.hj(foodView2.getContext()).x;
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) foodView2.getLayoutParams();
                    layoutParams2.width = i2;
                    layoutParams2.height = i2 / 5;
                    foodView2.setLayoutParams(layoutParams2);
                    foodView2.b(listItem, (FoodView.a) null, true, Constants.VIA_REPORT_TYPE_DATALINE);
                } else if (TextUtils.equals(listItem.mDisplayStyle, "30")) {
                    view$OnLongClickListenerC1029a.a(a.f.ftv_icon, listItem.mCover, tv.chushou.widget.a.c.etR(), b.C1032b.small, b.C1032b.small);
                    view$OnLongClickListenerC1029a.a(a.f.tv_desc, listItem.mDesc);
                    view$OnLongClickListenerC1029a.a(a.f.tv_name, listItem.mName);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public int OC(int i) {
                return i == 1 ? a.h.item_listitem_small_poster : super.OC(i);
            }

            @Override // android.support.v7.widget.RecyclerView.Adapter
            public int getItemViewType(int i) {
                ListItem item = getItem(i);
                if (item == null || !(TextUtils.equals(item.mDisplayStyle, "10") || TextUtils.equals(item.mDisplayStyle, "32"))) {
                    return super.getItemViewType(i);
                }
                return 1;
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(this.oyk);
        recyclerView.setFocusableInTouchMode(false);
        recyclerView.requestFocus();
        this.opn.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.oxV.setOnClickListener(this);
        this.oxY.setOnClickListener(this);
        this.p.setOnClickListener(this);
        tv.chushou.zues.a.a.register(this);
        this.Y = true;
        if (this.S) {
            a();
        }
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.b
    protected void initData() {
        this.d.setVisibility(8);
        this.oxq.OD(1);
        if (this.oyn != null) {
            a(this.oyn);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.kascend.chushou.view.base.b, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.Y = false;
        tv.chushou.zues.a.a.cp(this);
        super.onDestroyView();
    }

    public void a() {
        if (this.oyn == null) {
            if (!h.isEmpty(this.Q) || !h.isEmpty(this.R)) {
                com.kascend.chushou.c.c.ege().b(this.R, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.view.user.a.4
                    @Override // com.kascend.chushou.c.b
                    public void a() {
                    }

                    @Override // com.kascend.chushou.c.b
                    public void a(String str, JSONObject jSONObject) {
                        if (!a.this.isFinishing()) {
                            Response response = (Response) tv.chushou.zues.utils.d.c(str, new com.google.gson.b.a<Response<RoomSpaceData>>() { // from class: com.kascend.chushou.view.user.a.4.1
                            }.getType());
                            if (response != null && response.code == 0 && response.data != 0) {
                                a.this.oyn = (RoomSpaceData) response.data;
                                if (a.this.oyn.user != null && h.isEmpty(a.this.Q)) {
                                    a.this.Q = a.this.oyn.user.uid;
                                }
                                if (a.this.oyn.room != null && h.isEmpty(a.this.R)) {
                                    a.this.R = a.this.oyn.room.id;
                                }
                                if (a.this.Y) {
                                    a.this.a(a.this.oyn);
                                }
                                if (a.this.oyp != null) {
                                    a.this.oyp.a(a.this.oyn);
                                }
                            } else if (response != null) {
                                a(response.code, response.message);
                            } else {
                                a(-1, "");
                            }
                        }
                    }

                    @Override // com.kascend.chushou.c.b
                    public void a(int i, String str) {
                    }
                }, this.U, this.Q);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (!h.isEmpty(this.Q)) {
            int id = view.getId();
            if (id == a.f.iv_avatar) {
                if (this.P == 1) {
                    str = Constants.VIA_REPORT_TYPE_DATALINE;
                } else {
                    str = Constants.VIA_REPORT_TYPE_START_WAP;
                }
                com.kascend.chushou.d.a.a(this.mContext, e.O("_fromView", str), (String) null, this.Q, (String) null, false);
            } else if (id == a.f.tv_live_notice) {
                this.w = this.w ? false : true;
                c();
            } else if (id == a.f.subscribe_btn) {
                if (e.c(this.mContext, null)) {
                    d();
                }
            } else if (id == a.f.ll_user_space_contribution) {
                if (!h.isEmpty(this.R)) {
                    com.kascend.chushou.d.a.a(this.mContext, this.R);
                }
            } else if (id == a.f.tv_live_status) {
                if (!h.isEmpty(this.R)) {
                    if (this.oyl == null || !this.oyl.a(view)) {
                        ListItem listItem = new ListItem();
                        Object[] objArr = new Object[2];
                        objArr[0] = "_fromView";
                        objArr[1] = this.P == 1 ? Constants.VIA_REPORT_TYPE_DATALINE : Constants.VIA_REPORT_TYPE_START_WAP;
                        JSONObject O = e.O(objArr);
                        if (this.oyn != null && this.oyn.user != null) {
                            listItem.mCreater = this.oyn.user.nickname;
                        }
                        listItem.mTargetKey = this.R;
                        if (this.oyn != null) {
                            if ("5".equals(this.oyn.liveType)) {
                                listItem.mType = Constants.VIA_REPORT_TYPE_WPA_STATE;
                            } else {
                                listItem.mType = "1";
                                listItem.mLiveType = this.oyn.liveType;
                            }
                        } else {
                            listItem.mType = "1";
                        }
                        e.a(this.mContext, listItem, O);
                    }
                }
            } else {
                if (id == a.f.tv_fans || id != a.f.tv_subscribe) {
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 11) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
            if (i2 == -1 && this.oyn != null && this.oyn.room != null) {
                this.oyn.room.announcement = String.valueOf(intent.getData());
                e(this.oyn);
            }
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && this.oyn != null) {
            if (iVar.f4073a == 15) {
                if ((iVar.b instanceof String) && this.W && this.oyn.user != null) {
                    this.oyn.user.signature = (String) iVar.b;
                    a(this.oyn.user);
                }
            } else if (iVar.f4073a == 0 || iVar.f4073a == 1) {
                if ((iVar.b instanceof Boolean) && ((Boolean) iVar.b).booleanValue()) {
                    boolean z = this.W;
                    MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
                    if (userInfo != null && !h.isEmpty(this.Q) && this.Q.equals(userInfo.mUserID)) {
                        this.W = true;
                    }
                    if (z != this.W) {
                        this.oyn = null;
                        a();
                    }
                }
            } else if (iVar.f4073a == 10 && (iVar.b instanceof String) && this.W && this.oyn.room != null) {
                this.oyn.room.announcement = (String) iVar.b;
                e(this.oyn);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (!isFinishing() && this.oyn != null) {
            if (!h.isEmpty(mVar.f4076a) && this.oyn.user != null && mVar.f4076a.equals(this.oyn.user.uid)) {
                if (mVar.c) {
                    this.oyn.isSubscribed = true;
                    a(2);
                } else {
                    this.oyn.isSubscribed = false;
                    a(0);
                }
            }
            if (!h.isEmpty(mVar.b) && this.oyn.room != null && mVar.b.equals(this.oyn.room.id)) {
                if (mVar.c) {
                    this.oyn.isSubscribed = true;
                    a(2);
                    return;
                }
                this.oyn.isSubscribed = false;
                a(0);
            }
        }
    }

    public void a(c cVar) {
        this.oyl = cVar;
    }

    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RoomSpaceData roomSpaceData) {
        if (roomSpaceData != null) {
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            if (userInfo != null && roomSpaceData.user != null) {
                this.W = roomSpaceData.user.uid.equals(userInfo.mUserID);
            }
            this.d.setVisibility(0);
            this.oxq.setVisibility(8);
            a(roomSpaceData.skinInfo);
            c(roomSpaceData);
            f(roomSpaceData);
            g(roomSpaceData);
            a(roomSpaceData.parseRecommendList());
        }
    }

    private void a(RoomSpaceData.SkinBean skinBean) {
        String str;
        int hq;
        if (skinBean != null && this.oxU != null) {
            if (this.P == 2) {
                str = skinBean.background;
            } else {
                str = skinBean.homeBackground;
            }
            if (!h.isEmpty(str)) {
                if (this.oth == null) {
                    this.oth = (FrescoThumbnailView) this.oxU.inflate();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oth.getLayoutParams();
                    layoutParams.width = -1;
                    Point hj = tv.chushou.zues.utils.a.hj(this.mContext);
                    if (this.P == 2) {
                        hq = (hj.y - ((hj.x * this.mContext.getResources().getInteger(a.g.h_thumb_height_def)) / this.mContext.getResources().getInteger(a.g.h_thumb_width_def))) - this.mContext.getResources().getDimensionPixelSize(a.d.videoplayer_tab_height);
                        if (com.kascend.chushou.b.egb().d == 1) {
                            hq -= tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mContext);
                        }
                    } else {
                        hq = hj.y - tv.chushou.zues.utils.systemBar.b.hq(this.mContext);
                    }
                    layoutParams.height = hq;
                    this.oth.setLayoutParams(layoutParams);
                }
                this.oth.bY(str, a.c.kas_white);
            }
        }
    }

    private void b(RoomSpaceData roomSpaceData) {
        if (roomSpaceData != null && roomSpaceData.room != null && roomSpaceData.room.creator != null) {
            RoomSpaceData.RoomBean roomBean = roomSpaceData.room;
            this.e.setVisibility(0);
            this.j.setVisibility(0);
            this.G.setVisibility(8);
            this.M.setImageResource(tv.chushou.widget.a.c.Yf(roomBean.creator.gender));
            this.opn.bY(roomBean.creator.avatar, com.kascend.chushou.view.a.a(roomBean.creator.gender));
            if (roomBean.creator.meta != null) {
                if (h.isEmpty(roomBean.creator.meta.avatarFrame)) {
                    this.osY.setVisibility(8);
                } else {
                    this.osY.setVisibility(0);
                    this.osY.setAnim(true);
                    this.osY.bY(roomBean.creator.meta.avatarFrame.get(0), 0);
                }
            } else {
                this.osY.setVisibility(8);
            }
            this.oxW.setText(roomBean.creator.nickname);
            this.l.setText("");
            this.k.setText(new tv.chushou.zues.widget.a.c().append(this.mContext.getString(a.i.follower_title)).append("：").append(tv.chushou.zues.utils.b.formatNumber(String.valueOf(roomSpaceData.fansCount))));
            if (roomBean.liveStatus != null && roomBean.liveStatus.game != null && !h.isEmpty(roomBean.liveStatus.game.name)) {
                this.j.setText(roomBean.liveStatus.game.name);
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(4);
            }
            if (roomBean.liveStatus != null && !h.isEmpty(roomBean.liveStatus.liveTimeDesc)) {
                this.m.setText(new tv.chushou.zues.widget.a.c().append(this.mContext.getString(a.i.str_live_time)).append("：").append(roomBean.liveStatus.liveTimeDesc));
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            if (roomBean.liveStatus != null && !h.isEmpty(roomBean.liveStatus.modelName)) {
                this.n.setText(new tv.chushou.zues.widget.a.c().append(this.mContext.getString(a.i.str_user_device)).append("：").append(roomBean.liveStatus.modelName));
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            RoomSpaceData.SkinBean skinBean = roomSpaceData.skinInfo;
            this.oxV.a(skinBean != null ? skinBean.subscribeBtnBg : "", skinBean != null ? skinBean.subscribedBtnBg : "");
            if (roomSpaceData.isSubscribed) {
                a(2);
            } else {
                a(0);
            }
        }
    }

    private void c(RoomSpaceData roomSpaceData) {
        if (roomSpaceData != null) {
            if (this.P == 2) {
                b(roomSpaceData);
            } else if (this.P == 1) {
                d(roomSpaceData);
            }
            if (this.P == 2) {
                this.oxY.setVisibility(8);
            } else {
                ArrayList arrayList = new ArrayList();
                if (!h.isEmpty(roomSpaceData.roomGiftBillboardList)) {
                    for (RoomSpaceData.UserData userData : roomSpaceData.roomGiftBillboardList) {
                        if (userData != null && userData.user != null && !TextUtils.isEmpty(userData.user.avatar)) {
                            arrayList.add(userData.user.avatar);
                        }
                    }
                }
                if (h.isEmpty(arrayList)) {
                    this.oxY.setVisibility(8);
                } else {
                    this.oxY.setVisibility(0);
                    FrescoThumbnailView[] frescoThumbnailViewArr = {this.oyb, this.oya, this.oxZ};
                    Collections.reverse(arrayList);
                    for (int i = 0; i < frescoThumbnailViewArr.length; i++) {
                        if (i < arrayList.size()) {
                            frescoThumbnailViewArr[i].setVisibility(0);
                            frescoThumbnailViewArr[i].bY((String) arrayList.get(i), tv.chushou.widget.a.c.etR());
                        } else {
                            frescoThumbnailViewArr[i].setVisibility(8);
                        }
                    }
                }
            }
            e(roomSpaceData);
        }
    }

    private void a(int i) {
        this.oxV.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.oxV.b(i);
    }

    private void d(RoomSpaceData roomSpaceData) {
        if (roomSpaceData != null) {
            this.e.setVisibility(8);
            this.j.setVisibility(8);
            this.G.setVisibility(0);
            if (!(!roomSpaceData.hiddenList.contains("fansCount"))) {
                this.E.setText(a.i.user_space_fans_private);
                this.E.setClickable(false);
            } else {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                cVar.a((CharSequence) tv.chushou.zues.utils.b.formatNumber(String.valueOf(roomSpaceData.fansCount)), new StyleSpan(1), new tv.chushou.zues.widget.a.d(getContext(), 17)).append(" ").a(this.mContext.getString(a.i.follower_title), new tv.chushou.zues.widget.a.d(getContext(), 12));
                this.E.setText(cVar);
                this.E.setClickable(true);
            }
            if (!(!roomSpaceData.hiddenList.contains("idolsCount"))) {
                this.F.setText(a.i.user_space_subscribe_private);
                this.F.setClickable(false);
            } else {
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                cVar2.a((CharSequence) tv.chushou.zues.utils.b.formatNumber(String.valueOf(roomSpaceData.idolsCount)), new StyleSpan(1), new tv.chushou.zues.widget.a.d(getContext(), 17)).append(" ").a(this.mContext.getString(a.i.str_subscribe_btn), new tv.chushou.zues.widget.a.d(getContext(), 12));
                this.F.setText(cVar2);
                this.F.setClickable(true);
            }
            RoomSpaceData.RoomBean roomBean = roomSpaceData.room;
            if (roomSpaceData.isOnline) {
                this.p.setClickable(true);
                String str = "";
                if (roomSpaceData.skinInfo != null) {
                    str = roomSpaceData.skinInfo.lastLiveTimeBtnBg;
                }
                this.oxX.bY(str, 0);
                this.p.setBackgroundResource(a.e.user_space_live_bg);
                tv.chushou.zues.widget.a.c cVar3 = new tv.chushou.zues.widget.a.c();
                cVar3.a(this.mContext, a.e.live_white, a.d.room_live_icon_width, a.d.room_live_icon_height).append(" ").a(this.mContext.getString(a.i.user_space_live), new ForegroundColorSpan(ContextCompat.getColor(this.mContext, a.c.white)));
                this.p.setText(cVar3);
            } else if (roomBean != null && !h.isEmpty(roomBean.lastLiveTimeDesc)) {
                this.p.setClickable(true);
                String str2 = "";
                if (roomSpaceData.skinInfo != null) {
                    str2 = roomSpaceData.skinInfo.lastLiveTimeBtnBg;
                }
                this.oxX.bY(str2, 0);
                this.p.setBackgroundResource(a.e.user_space_last_live_bg);
                tv.chushou.zues.widget.a.c cVar4 = new tv.chushou.zues.widget.a.c();
                cVar4.a(this.mContext, a.e.live_white, a.d.room_live_icon_width, a.d.room_live_icon_height).append(" ").a(roomBean.lastLiveTimeDesc, new ForegroundColorSpan(ContextCompat.getColor(this.mContext, a.c.white)));
                this.p.setText(cVar4);
            } else {
                this.p.setVisibility(8);
            }
        }
    }

    private void e(RoomSpaceData roomSpaceData) {
        if (roomSpaceData != null) {
            this.v.setMaxLines(4);
            this.v.setEllipsize(TextUtils.TruncateAt.END);
            this.w = true;
            if (roomSpaceData.room == null || h.isEmpty(roomSpaceData.room.announcement)) {
                this.v.setVisibility(8);
                if (this.d != null) {
                    this.d.findViewById(a.f.view_line).setVisibility(8);
                    return;
                }
                return;
            }
            this.v.setVisibility(0);
            this.v.setText(roomSpaceData.room.announcement);
        }
    }

    private void c() {
        if (this.w) {
            this.v.setMaxLines(4);
        } else {
            this.v.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        }
    }

    private void f(RoomSpaceData roomSpaceData) {
        if (this.oyc != null && roomSpaceData != null) {
            this.oyc.a(roomSpaceData.achievementMedalInfo, roomSpaceData.user != null ? roomSpaceData.user.uid : this.Q);
        }
    }

    private void g(RoomSpaceData roomSpaceData) {
        if (roomSpaceData != null) {
            if (roomSpaceData.user == null || (h.isEmpty(roomSpaceData.user.levelMedal) && ((roomSpaceData.user.meta == null || h.isEmpty(roomSpaceData.user.meta.nobleMedal)) && h.isEmpty(roomSpaceData.user.signature) && h.isEmpty(roomSpaceData.likedGameList) && roomSpaceData.bangCount == 0 && roomSpaceData.giftPointCount == 0 && h.isEmpty(roomSpaceData.medalList)))) {
                this.oyo.setVisibility(8);
                return;
            }
            this.oyo.setVisibility(0);
            if (roomSpaceData.user == null || (h.isEmpty(roomSpaceData.user.levelMedal) && (roomSpaceData.user.meta == null || h.isEmpty(roomSpaceData.user.meta.nobleMedal)))) {
                this.oju.setVisibility(8);
            } else {
                this.oju.setVisibility(0);
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (roomSpaceData.user.meta != null) {
                    a(cVar, roomSpaceData.user.meta.nobleMedal);
                }
                if (!h.isEmpty(roomSpaceData.user.gloriouslyUidMedal)) {
                    a(cVar, roomSpaceData.user.gloriouslyUidMedal);
                }
                a(cVar, roomSpaceData.user.levelMedal);
                cVar.a(new b.c() { // from class: com.kascend.chushou.view.user.a.5
                    @Override // com.facebook.drawee.span.b.c
                    public void d(com.facebook.drawee.span.b bVar) {
                        if (a.this.oyd != null) {
                            a.this.oyd.measure(0, 0);
                            a.this.oyd.requestLayout();
                        }
                    }
                });
                this.oyd.setDraweeSpanStringBuilder(cVar);
            }
            a(roomSpaceData.user);
            b(roomSpaceData.medalList);
            if (h.isEmpty(roomSpaceData.likedGameList)) {
                this.oye.setVisibility(8);
            } else {
                this.oye.setVisibility(0);
                for (RoomSpaceData.LikedGameBean likedGameBean : roomSpaceData.likedGameList) {
                    TextView textView = (TextView) getLayoutInflater().inflate(a.h.view_favor_game_tag, (ViewGroup) this.oyi, false);
                    textView.setText(likedGameBean.name);
                    this.oyi.addView(textView);
                }
            }
            boolean z = !roomSpaceData.hiddenList.contains("giftPointCount");
            boolean z2 = !roomSpaceData.hiddenList.contains("bangCount");
            if (true == z && roomSpaceData.giftPointCount <= 0 && true == z2 && roomSpaceData.bangCount <= 0) {
                this.oyf.setVisibility(8);
                return;
            }
            this.oyf.setVisibility(0);
            tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
            if (!z2) {
                cVar2.N(this.mContext, a.e.user_space_bubble).append(" ").append(this.mContext.getString(a.i.user_space_bang_private)).append("    ");
            } else if (roomSpaceData.bangCount > 0) {
                cVar2.N(this.mContext, a.e.user_space_bubble).append(" ").append(this.mContext.getString(a.i.userpage_sendpaopao)).append(tv.chushou.zues.utils.b.formatNumber(String.valueOf(roomSpaceData.bangCount))).append(this.mContext.getString(a.i.paopao_unit)).append("    ");
            }
            if (!z) {
                cVar2.N(this.mContext, a.e.icon_coin).append(" ").append(this.mContext.getString(a.i.userpage_sendgift)).append(this.mContext.getString(a.i.user_space_sendgift_private));
            } else if (roomSpaceData.giftPointCount > 0) {
                cVar2.N(this.mContext, a.e.icon_coin).append(" ").append(this.mContext.getString(a.i.userpage_sendgift)).append(tv.chushou.zues.utils.b.formatNumber(String.valueOf(roomSpaceData.giftPointCount)));
            }
            this.D.setText(cVar2);
        }
    }

    private void a(tv.chushou.zues.widget.a.c cVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = cVar.length();
            com.facebook.drawee.view.b a2 = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(getResources()).MA(com.kascend.chushou.view.a.a()).dYF(), this.mContext);
            a2.setController(com.facebook.drawee.a.a.c.dXf().VN(str).yM(true).dXW());
            cVar.append("1");
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.user_level_icon_height);
            cVar.a(a2, length, length, dimensionPixelSize, dimensionPixelSize, true, 2);
            cVar.append(" ");
        }
    }

    private void a(UserBean userBean) {
        if (userBean == null || h.isEmpty(userBean.signature)) {
            this.ouY.setVisibility(8);
            return;
        }
        this.ouY.setVisibility(0);
        this.A.setText(userBean.signature);
    }

    private void a(List<ListItem> list) {
        if (h.isEmpty(list)) {
            this.oyj.setVisibility(8);
            return;
        }
        this.oyj.setVisibility(0);
        this.oyk.gq(list);
    }

    private void b(List<RoomSpaceData.MedalBean> list) {
        if (!h.isEmpty(list)) {
            this.oyg.setVisibility(0);
            for (RoomSpaceData.MedalBean medalBean : list) {
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) getLayoutInflater().inflate(a.h.view_medal, (ViewGroup) this.oyh, false);
                frescoThumbnailView.setAnim(true);
                frescoThumbnailView.a(medalBean.url, a.e.default_medal_icon, b.C1032b.small, b.C1032b.small, 1);
                this.oyh.addView(frescoThumbnailView);
            }
            return;
        }
        this.oyg.setVisibility(8);
    }

    private void d() {
        String str;
        String str2;
        String str3;
        if (this.oyn != null) {
            final boolean z = this.oyn.isSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.view.user.a.6
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str4, JSONObject jSONObject) {
                    if (!a.this.isFinishing()) {
                        ParserRet et = com.kascend.chushou.c.a.et(jSONObject);
                        if (et.mRc == 0) {
                            a.this.a(!z, true, -1, null);
                            a.this.oyn.isSubscribed = a.this.oyn.isSubscribed ? false : true;
                            if (a.this.oyn.isSubscribed) {
                                a.this.b(2);
                                return;
                            } else {
                                a.this.b(0);
                                return;
                            }
                        }
                        a(et.mRc, et.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str4) {
                    if (!a.this.isFinishing()) {
                        a.this.a(!z, false, i, str4);
                    }
                }
            };
            if (this.mContext instanceof VideoPlayer) {
                com.kascend.chushou.player.b egv = ((VideoPlayer) this.mContext).egv();
                if (egv != null && egv.h != null) {
                    try {
                        str = new JSONObject(egv.h).optString("_sc");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    str3 = Constants.VIA_REPORT_TYPE_START_WAP;
                    str2 = "32";
                }
                str = null;
                str3 = Constants.VIA_REPORT_TYPE_START_WAP;
                str2 = "32";
            } else if (this.mContext instanceof UserRoomActivity) {
                if (!h.isEmpty(this.V)) {
                    try {
                        str = new JSONObject(this.V).optString("_sc");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    str3 = Constants.VIA_REPORT_TYPE_DATALINE;
                    str2 = null;
                }
                str = null;
                str3 = Constants.VIA_REPORT_TYPE_DATALINE;
                str2 = null;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            final String a2 = e.a("_fromView", str3, "_fromPos", str2, "_sc", str);
            if (this.oyn.user != null) {
                if (z) {
                    e.a(this.mContext, this.oyn.user.nickname, new b.a() { // from class: com.kascend.chushou.view.user.a.7
                        @Override // tv.chushou.zues.widget.sweetalert.b.a
                        public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                            bVar2.euC();
                            com.kascend.chushou.c.c.ege().b(bVar, (String) null, a.this.oyn.user.uid, a2);
                        }
                    });
                } else {
                    com.kascend.chushou.c.c.ege().a(bVar, (String) null, this.oyn.user.uid, a2);
                }
            }
        }
    }

    public void a(boolean z, boolean z2, int i, String str) {
        if (z2) {
            if (z) {
                g.K(this.mContext, a.i.subscribe_success);
            } else {
                g.K(this.mContext, a.i.unsubscribe_success);
            }
        } else if (401 == i) {
            e.b(this.mContext, (String) null);
        } else {
            if (h.isEmpty(str)) {
                str = this.mContext.getString(a.i.subscribe_failed);
            }
            g.c(this.mContext, str);
        }
    }

    public void a(InterfaceC0926a interfaceC0926a) {
        this.oyp = interfaceC0926a;
    }
}
