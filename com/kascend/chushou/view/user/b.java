package com.kascend.chushou.view.user;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.i;
import com.kascend.chushou.bean.RoomSpaceData;
import com.kascend.chushou.bean.UserBean;
import com.kascend.chushou.constants.MyUserInfo;
import com.kascend.chushou.constants.ShareInfo;
import com.kascend.chushou.d.e;
import com.kascend.chushou.player.a.f;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.toolkit.c;
import com.kascend.chushou.view.user.a;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.adapterview.abslistview.KasGridView;
import tv.chushou.zues.widget.adapterview.abslistview.a;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
import tv.chushou.zues.widget.sweetalert.b;
import tv.chushou.zues.widget.textview.EllipsizedTextView;
/* loaded from: classes5.dex */
public class b extends com.kascend.chushou.view.base.b implements AppBarLayout.OnOffsetChangedListener, View.OnClickListener, View.OnLongClickListener, a.InterfaceC0823a {
    private View a;
    private LinearLayout d;
    private TextView e;
    private ImageView h;
    private ImageView i;
    private RelativeLayout j;
    private TextView l;
    private RelativeLayout m;
    private FrescoThumbnailView mTS;
    private AppBarLayout mZo;
    private KasGridView mZp;
    private EllipsizedTextView mZq;
    private ProgressBar mZr;
    private tv.chushou.zues.widget.adapterview.abslistview.a<RoomSpaceData.AvatarBean> mZs;
    private a mZt;
    private c mZu;
    private RoomSpaceData mZv;
    private FrescoThumbnailView mZw;
    private PopupWindow mZx;
    private ImageView n;
    private String s;
    private String t;
    private String v;
    private List<RoomSpaceData.AvatarBean> p = new ArrayList();
    private boolean u = true;
    private boolean w = false;

    public static b b(String str, String str2, boolean z, String str3) {
        Bundle bundle = new Bundle();
        if (!h.isEmpty(str)) {
            bundle.putString("uid", str);
        }
        if (!h.isEmpty(str2)) {
            bundle.putString("roomId", str2);
        }
        bundle.putBoolean("mScrollToPosition", z);
        bundle.putString("datainfo", str3);
        b bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }

    @Override // com.kascend.chushou.view.base.b, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.s = arguments.getString("uid", "");
            this.t = arguments.getString("roomId", "");
            this.u = arguments.getBoolean("mScrollToPosition");
            this.v = arguments.getString("datainfo");
        }
        MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
        if (userInfo != null && !h.isEmpty(this.s) && this.s.equals(userInfo.mUserID)) {
            this.w = true;
        }
    }

    @Override // com.kascend.chushou.view.base.b
    protected View initView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.fragment_user_space, viewGroup, false);
        this.d = (LinearLayout) inflate.findViewById(a.f.rl_top);
        this.a = inflate.findViewById(a.f.cdl);
        if (Build.VERSION.SDK_INT >= 19) {
            int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mContext);
            int gD = tv.chushou.zues.utils.systemBar.b.gD(this.mContext);
            this.a.setPadding(0, -statusBarHeight, 0, 0);
            ((ViewGroup.MarginLayoutParams) this.d.getLayoutParams()).setMargins(0, ((int) (statusBarHeight * 0.625d)) + statusBarHeight + gD, 0, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((RelativeLayout) inflate.findViewById(a.f.title_view)).getLayoutParams();
            marginLayoutParams.height = statusBarHeight + gD;
            marginLayoutParams.setMargins(0, statusBarHeight, 0, 0);
            ((ViewGroup.MarginLayoutParams) ((RelativeLayout) inflate.findViewById(a.f.title_view_content)).getLayoutParams()).setMargins(0, statusBarHeight, 0, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) ((Toolbar) inflate.findViewById(a.f.toolbar)).getLayoutParams();
            marginLayoutParams2.height = statusBarHeight + gD;
            marginLayoutParams2.setMargins(0, statusBarHeight, 0, 0);
            inflate.findViewById(a.f.iv_topmask).getLayoutParams().height = statusBarHeight + gD;
            inflate.findViewById(a.f.collapse_toolbar).setMinimumHeight(statusBarHeight + gD + statusBarHeight);
        }
        this.mTS = (FrescoThumbnailView) inflate.findViewById(a.f.iv_background);
        this.e = (TextView) inflate.findViewById(a.f.tv_user_roomId);
        this.e.setOnLongClickListener(this);
        this.mZw = (FrescoThumbnailView) inflate.findViewById(a.f.ftv_uid_medal);
        this.mZp = (KasGridView) inflate.findViewById(a.f.gridview);
        this.mZq = (EllipsizedTextView) inflate.findViewById(a.f.tittle_name);
        this.mZq.setOnLongClickListener(this);
        this.h = (ImageView) inflate.findViewById(a.f.detail_icon);
        this.n = (ImageView) inflate.findViewById(a.f.report_icon);
        this.i = (ImageView) inflate.findViewById(a.f.share_icon);
        this.j = (RelativeLayout) inflate.findViewById(a.f.rl_bottom_bar);
        this.mZr = (ProgressBar) inflate.findViewById(a.f.progress_subscribe);
        this.l = (TextView) inflate.findViewById(a.f.tv_bottom_subscribe);
        this.m = (RelativeLayout) inflate.findViewById(a.f.fragment_container);
        this.h.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.mZo = (AppBarLayout) inflate.findViewById(a.f.appbar);
        this.mZo.addOnOffsetChangedListener(this);
        inflate.findViewById(a.f.back_icon).setOnClickListener(this);
        inflate.findViewById(a.f.share_icon).setOnClickListener(this);
        inflate.findViewById(a.f.tv_bottom_subscribe).setOnClickListener(this);
        inflate.findViewById(a.f.fl_subscribe).setOnClickListener(this);
        tv.chushou.zues.a.a.register(this);
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.b
    protected void initData() {
        if (this.mZt == null) {
            this.mZt = a.a(1, this.s, this.t, this.u, this.v, true);
            getChildFragmentManager().beginTransaction().add(a.f.fragment_container, this.mZt).commitAllowingStateLoss();
            if (this.mZu != null) {
                this.mZt.a(this.mZu);
            }
            this.mZt.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.b
    public void unInit() {
        tv.chushou.zues.a.a.ch(this);
        super.unInit();
    }

    @Override // com.kascend.chushou.view.user.a.InterfaceC0823a
    public void a(RoomSpaceData roomSpaceData) {
        this.mZv = roomSpaceData;
        if (h.isEmpty(this.t) && roomSpaceData.room != null) {
            this.t = roomSpaceData.room.id;
        }
        if (h.isEmpty(this.s) && roomSpaceData.user != null) {
            this.s = roomSpaceData.user.uid;
        }
        b(roomSpaceData);
        a(roomSpaceData.isSubscribed);
        if (this.mContext instanceof UserRoomActivity) {
            ((UserRoomActivity) this.mContext).c();
        }
    }

    @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        tv.chushou.zues.toolkit.d.b.setAlpha(this.d, 1.0f - (Math.abs(i) / appBarLayout.getTotalScrollRange()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mZv != null) {
            int id = view.getId();
            if (id == a.f.back_icon) {
                if (this.mZu != null) {
                    if (!this.mZu.a(view)) {
                        ((Activity) this.mContext).finish();
                        return;
                    }
                    return;
                }
                ((Activity) this.mContext).finish();
            } else if (id == a.f.detail_icon) {
                if (this.w) {
                    e();
                }
            } else if (id != a.f.ll_account_safe && id != a.f.ll_edit) {
                if (id == a.f.ll_share) {
                    c(this.mZv);
                } else if (id == a.f.report_icon) {
                    d();
                } else if (id == a.f.share_icon) {
                    c(this.mZv);
                } else if (id == a.f.tv_bottom_subscribe || id == a.f.fl_subscribe) {
                    c();
                }
            }
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing()) {
            switch (iVar.a) {
                case 0:
                case 1:
                    boolean z = this.w;
                    MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
                    if (userInfo != null && !h.isEmpty(this.s) && this.s.equals(userInfo.mUserID)) {
                        this.w = true;
                    }
                    if (z != this.w) {
                        b(this.mZv);
                        return;
                    }
                    return;
                case 12:
                    if ((iVar.b instanceof List) && this.w && this.mZv != null) {
                        ArrayList arrayList = (ArrayList) iVar.b;
                        this.mZv.avatarList = new ArrayList();
                        if (!h.isEmpty(arrayList)) {
                            this.mZv.avatarList.addAll(arrayList);
                        }
                        this.p.clear();
                        this.p.addAll(arrayList);
                        b();
                        return;
                    }
                    return;
                case 13:
                    if (this.mZv != null && this.mZv.user != null && (iVar.b instanceof String) && this.w) {
                        this.mZv.user.nickname = (String) iVar.b;
                        a();
                        return;
                    }
                    return;
                case 14:
                    if ((iVar.b instanceof String) && this.w && this.mZv != null && this.mZv.user != null) {
                        this.mZv.user.gender = (String) iVar.b;
                        a();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void a(c cVar) {
        this.mZu = cVar;
    }

    private void b(RoomSpaceData roomSpaceData) {
        if (roomSpaceData != null) {
            if (this.w) {
                this.h.setVisibility(8);
                this.n.setVisibility(8);
                this.i.setVisibility(8);
            } else {
                this.h.setVisibility(8);
                this.i.setVisibility(8);
                this.n.setVisibility(0);
            }
            this.e.setText("");
            this.j.setVisibility(8);
            ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).setMargins(0, 0, 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 0));
            if (this.u) {
                this.mZo.setExpanded(false);
            }
            b();
            a();
            this.mZo.requestLayout();
            if (this.mZt != null) {
                this.mZo.post(new Runnable() { // from class: com.kascend.chushou.view.user.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mZt.b();
                    }
                });
            }
        }
    }

    private void a() {
        if (this.mZv != null && this.mZv.user != null) {
            UserBean userBean = this.mZv.user;
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(TextUtils.ellipsize(userBean.nickname, this.mZq.getPaint(), tv.chushou.zues.utils.a.gv(this.mContext).x - tv.chushou.zues.utils.a.dip2px(this.mContext, 221.0f), TextUtils.TruncateAt.END));
            List<String> list = this.mZv.hiddenList;
            if (list != null) {
                if (!list.contains("gender")) {
                    cVar.append(" ");
                    cVar.J(this.mContext, tv.chushou.widget.a.c.Sm(userBean.gender));
                }
            }
            this.mZq.setText(cVar);
        }
    }

    private void b() {
        if (this.mZv != null && this.mZv.user != null) {
            if (!h.isEmpty(this.mZv.user.gloriouslyUid)) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!h.isEmpty(this.t) && !"-1".equals(this.t)) {
                    cVar.append(getString(a.i.str_userinfo_roomid)).append(":").append(this.t).append("    ");
                }
                cVar.append(this.mContext.getString(a.i.profile_id, this.mZv.user.gloriouslyUid));
                this.e.setText(cVar);
            }
            if (h.isEmpty(this.mZv.user.gloriouslyUidMedal)) {
                this.mZw.setVisibility(8);
            } else {
                this.mZw.a(this.mZv.user.gloriouslyUidMedal, com.kascend.chushou.view.a.a(), b.C0923b.small, b.C0923b.small, 1);
                this.mZw.setVisibility(0);
            }
            String str = this.mZv.user.avatar;
            if (!h.isEmpty(this.mZv.avatarList)) {
                str = this.mZv.avatarList.get(0).avatar;
            }
            if (h.isEmpty(str)) {
                this.mTS.yE(tv.chushou.widget.a.c.dRB());
            } else {
                this.mTS.i(str, com.kascend.chushou.view.a.a(null), tv.chushou.zues.widget.fresco.b.nOX, tv.chushou.zues.widget.fresco.b.nOX);
                this.mTS.getHierarchy().Hf(tv.chushou.widget.a.c.dRB());
            }
            if (!h.isEmpty(this.mZv.avatarList)) {
                this.p.clear();
                this.p.addAll(this.mZv.avatarList);
            }
            if (this.w && this.p.size() < 4) {
                RoomSpaceData.AvatarBean avatarBean = new RoomSpaceData.AvatarBean();
                avatarBean.id = "add_image";
                this.p.add(avatarBean);
            }
            if (this.mZs == null) {
                this.mZs = new tv.chushou.zues.widget.adapterview.abslistview.a<RoomSpaceData.AvatarBean>(this.mContext, this.p, a.h.item_user_space_avatar) { // from class: com.kascend.chushou.view.user.b.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // tv.chushou.zues.widget.adapterview.abslistview.a
                    public void a(a.C0919a c0919a, RoomSpaceData.AvatarBean avatarBean2) {
                        FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) c0919a.KB(a.f.iv_avatar);
                        ImageView imageView = (ImageView) c0919a.KB(a.f.iv_add);
                        if (avatarBean2.id.equals("add_image")) {
                            imageView.setVisibility(0);
                            frescoThumbnailView.h(avatarBean2.avatar, a.c.transparent_20_white, tv.chushou.zues.widget.fresco.b.nOX / 4, tv.chushou.zues.widget.fresco.b.nOX / 4);
                            return;
                        }
                        imageView.setVisibility(8);
                        frescoThumbnailView.i(avatarBean2.avatar, com.kascend.chushou.view.a.a(null), tv.chushou.zues.widget.fresco.b.nOX, tv.chushou.zues.widget.fresco.b.nOX);
                        frescoThumbnailView.getHierarchy().Hf(tv.chushou.widget.a.c.dRB());
                    }
                };
                this.mZp.setAdapter((ListAdapter) this.mZs);
            }
            this.mZs.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
        if (z) {
            cVar.a(this.mContext, a.e.userpage_liked, a.d.userpage_bottom_share, a.d.userpage_bottom_share).append(" ").a(getString(a.i.like_already), new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.second_black)));
        } else {
            cVar.a(this.mContext, a.e.userpage_follow, a.d.userpage_bottom_share, a.d.userpage_bottom_share).append(" ").a(getString(a.i.like), new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.selected_green)));
        }
        this.l.setText(cVar);
    }

    private void c() {
        String optString;
        final String a;
        if (this.mZv != null && this.mZv.user != null) {
            final boolean z = this.mZv.isSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.view.user.b.3
                @Override // com.kascend.chushou.c.b
                public void a() {
                    if (!b.this.isFinishing()) {
                        b.this.l.setVisibility(8);
                        b.this.mZr.setVisibility(0);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!b.this.isFinishing()) {
                        if (jSONObject == null) {
                            a(-1, "");
                            return;
                        }
                        int optInt = jSONObject.optInt("code", -1);
                        String optString2 = jSONObject.optString("message", "");
                        if (optInt == 0) {
                            b.this.l.setVisibility(0);
                            b.this.mZr.setVisibility(8);
                            b.this.a(!z, true, -1, null);
                            b.this.mZv.isSubscribed = b.this.mZv.isSubscribed ? false : true;
                            b.this.a(b.this.mZv.isSubscribed);
                            return;
                        }
                        a(optInt, optString2);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!b.this.isFinishing()) {
                        b.this.l.setVisibility(0);
                        b.this.mZr.setVisibility(8);
                        b.this.a(!z, false, i, str);
                    }
                }
            };
            if (this.v != null) {
                try {
                    optString = new JSONObject(this.v).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a = e.a("_fromView", Constants.VIA_REPORT_TYPE_DATALINE, "_sc", optString);
                if (!z && this.mZv.user != null) {
                    e.a(this.mContext, this.mZv.user.nickname, new b.a() { // from class: com.kascend.chushou.view.user.b.4
                        @Override // tv.chushou.zues.widget.sweetalert.b.a
                        public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                            bVar2.dSo();
                            com.kascend.chushou.c.c.dDV().b(bVar, (String) null, b.this.mZv.user.uid, a);
                        }
                    });
                    return;
                } else {
                    com.kascend.chushou.c.c.dDV().a(bVar, (String) null, this.mZv.user.uid, a);
                }
            }
            optString = null;
            a = e.a("_fromView", Constants.VIA_REPORT_TYPE_DATALINE, "_sc", optString);
            if (!z) {
            }
            com.kascend.chushou.c.c.dDV().a(bVar, (String) null, this.mZv.user.uid, a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2, int i, String str) {
        if (z2) {
            if (z) {
                g.F(this.mContext, a.i.subscribe_success);
            } else {
                g.F(this.mContext, a.i.unsubscribe_success);
            }
        } else if (i == 401) {
            e.b(this.mContext, (String) null);
        } else {
            if (h.isEmpty(str)) {
                str = this.mContext.getString(a.i.subscribe_failed);
            }
            g.c(this.mContext, str);
        }
    }

    private void c(RoomSpaceData roomSpaceData) {
        if (roomSpaceData != null && roomSpaceData.user != null) {
            ShareInfo shareInfo = new ShareInfo();
            shareInfo.mTitle = String.format(this.mContext.getString(a.i.share_profile_title), roomSpaceData.user.nickname);
            shareInfo.mContent = roomSpaceData.user.signature;
            if (h.isEmpty(shareInfo.mContent)) {
                shareInfo.mContent = this.mContext.getString(a.i.share_profile_content);
            }
            shareInfo.mThumbnail = roomSpaceData.user.avatar;
            shareInfo.mShareType = "5";
            shareInfo.mTargetKey = roomSpaceData.user.uid;
            com.kascend.cstvsdk.utils.b.ncX.a(this.mContext, "5", roomSpaceData.user.uid, shareInfo, e.a("_fromView", Constants.VIA_REPORT_TYPE_DATALINE), false);
        }
    }

    private void d() {
        if (this.mZv != null && this.mZv.user != null) {
            UserBean userBean = this.mZv.user;
            f fVar = new f(this.mContext);
            fVar.a(userBean.uid, userBean.nickname);
            fVar.show();
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (this.w) {
            e.d(getChildFragmentManager());
            return true;
        } else if (this.mZv != null && this.mZv.user != null) {
            e.a(getChildFragmentManager(), this.mZv.user.nickname, this.t, this.mZv.user.uid);
            return true;
        } else {
            return true;
        }
    }

    private void e() {
        if (this.mZx == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(a.h.popup_item_mine_more, (ViewGroup) null);
            inflate.findViewById(a.f.ll_edit).setOnClickListener(this);
            inflate.findViewById(a.f.ll_share).setOnClickListener(this);
            inflate.findViewById(a.f.ll_account_safe).setOnClickListener(this);
            this.mZx = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mContext, 138.0f), -2);
            this.mZx.setOutsideTouchable(true);
            this.mZx.setFocusable(true);
            this.mZx.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.ic_main_mine_more_bg));
            this.mZx.update();
        }
        if (this.mZx.isShowing()) {
            this.mZx.dismiss();
        } else {
            this.mZx.showAsDropDown(this.h, tv.chushou.zues.utils.a.dip2px(this.mContext, -9.0f), 0);
        }
    }
}
