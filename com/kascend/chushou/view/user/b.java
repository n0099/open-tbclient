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
public class b extends com.kascend.chushou.view.base.b implements AppBarLayout.OnOffsetChangedListener, View.OnClickListener, View.OnLongClickListener, a.InterfaceC0765a {
    private View a;
    private LinearLayout d;
    private TextView e;
    private ImageView h;
    private ImageView i;
    private RelativeLayout j;
    private TextView l;
    private RelativeLayout m;
    private AppBarLayout mFo;
    private KasGridView mFp;
    private EllipsizedTextView mFq;
    private ProgressBar mFr;
    private tv.chushou.zues.widget.adapterview.abslistview.a<RoomSpaceData.AvatarBean> mFs;
    private a mFt;
    private c mFu;
    private RoomSpaceData mFv;
    private FrescoThumbnailView mFw;
    private PopupWindow mFx;
    private FrescoThumbnailView mzP;
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
            int gb = tv.chushou.zues.utils.systemBar.b.gb(this.mContext);
            this.a.setPadding(0, -statusBarHeight, 0, 0);
            ((ViewGroup.MarginLayoutParams) this.d.getLayoutParams()).setMargins(0, ((int) (statusBarHeight * 0.625d)) + statusBarHeight + gb, 0, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((RelativeLayout) inflate.findViewById(a.f.title_view)).getLayoutParams();
            marginLayoutParams.height = statusBarHeight + gb;
            marginLayoutParams.setMargins(0, statusBarHeight, 0, 0);
            ((ViewGroup.MarginLayoutParams) ((RelativeLayout) inflate.findViewById(a.f.title_view_content)).getLayoutParams()).setMargins(0, statusBarHeight, 0, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) ((Toolbar) inflate.findViewById(a.f.toolbar)).getLayoutParams();
            marginLayoutParams2.height = statusBarHeight + gb;
            marginLayoutParams2.setMargins(0, statusBarHeight, 0, 0);
            inflate.findViewById(a.f.iv_topmask).getLayoutParams().height = statusBarHeight + gb;
            inflate.findViewById(a.f.collapse_toolbar).setMinimumHeight(statusBarHeight + gb + statusBarHeight);
        }
        this.mzP = (FrescoThumbnailView) inflate.findViewById(a.f.iv_background);
        this.e = (TextView) inflate.findViewById(a.f.tv_user_roomId);
        this.e.setOnLongClickListener(this);
        this.mFw = (FrescoThumbnailView) inflate.findViewById(a.f.ftv_uid_medal);
        this.mFp = (KasGridView) inflate.findViewById(a.f.gridview);
        this.mFq = (EllipsizedTextView) inflate.findViewById(a.f.tittle_name);
        this.mFq.setOnLongClickListener(this);
        this.h = (ImageView) inflate.findViewById(a.f.detail_icon);
        this.n = (ImageView) inflate.findViewById(a.f.report_icon);
        this.i = (ImageView) inflate.findViewById(a.f.share_icon);
        this.j = (RelativeLayout) inflate.findViewById(a.f.rl_bottom_bar);
        this.mFr = (ProgressBar) inflate.findViewById(a.f.progress_subscribe);
        this.l = (TextView) inflate.findViewById(a.f.tv_bottom_subscribe);
        this.m = (RelativeLayout) inflate.findViewById(a.f.fragment_container);
        this.h.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.mFo = (AppBarLayout) inflate.findViewById(a.f.appbar);
        this.mFo.addOnOffsetChangedListener(this);
        inflate.findViewById(a.f.back_icon).setOnClickListener(this);
        inflate.findViewById(a.f.share_icon).setOnClickListener(this);
        inflate.findViewById(a.f.tv_bottom_subscribe).setOnClickListener(this);
        inflate.findViewById(a.f.fl_subscribe).setOnClickListener(this);
        tv.chushou.zues.a.a.register(this);
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.b
    protected void initData() {
        if (this.mFt == null) {
            this.mFt = a.a(1, this.s, this.t, this.u, this.v, true);
            getChildFragmentManager().beginTransaction().add(a.f.fragment_container, this.mFt).commitAllowingStateLoss();
            if (this.mFu != null) {
                this.mFt.a(this.mFu);
            }
            this.mFt.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.b
    public void unInit() {
        tv.chushou.zues.a.a.cb(this);
        super.unInit();
    }

    @Override // com.kascend.chushou.view.user.a.InterfaceC0765a
    public void a(RoomSpaceData roomSpaceData) {
        this.mFv = roomSpaceData;
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
        if (this.mFv != null) {
            int id = view.getId();
            if (id == a.f.back_icon) {
                if (this.mFu != null) {
                    if (!this.mFu.a(view)) {
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
                    c(this.mFv);
                } else if (id == a.f.report_icon) {
                    d();
                } else if (id == a.f.share_icon) {
                    c(this.mFv);
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
                        b(this.mFv);
                        return;
                    }
                    return;
                case 12:
                    if ((iVar.b instanceof List) && this.w && this.mFv != null) {
                        ArrayList arrayList = (ArrayList) iVar.b;
                        this.mFv.avatarList = new ArrayList();
                        if (!h.isEmpty(arrayList)) {
                            this.mFv.avatarList.addAll(arrayList);
                        }
                        this.p.clear();
                        this.p.addAll(arrayList);
                        b();
                        return;
                    }
                    return;
                case 13:
                    if (this.mFv != null && this.mFv.user != null && (iVar.b instanceof String) && this.w) {
                        this.mFv.user.nickname = (String) iVar.b;
                        a();
                        return;
                    }
                    return;
                case 14:
                    if ((iVar.b instanceof String) && this.w && this.mFv != null && this.mFv.user != null) {
                        this.mFv.user.gender = (String) iVar.b;
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
        this.mFu = cVar;
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
                this.mFo.setExpanded(false);
            }
            b();
            a();
            this.mFo.requestLayout();
            if (this.mFt != null) {
                this.mFo.post(new Runnable() { // from class: com.kascend.chushou.view.user.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mFt.b();
                    }
                });
            }
        }
    }

    private void a() {
        if (this.mFv != null && this.mFv.user != null) {
            UserBean userBean = this.mFv.user;
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(TextUtils.ellipsize(userBean.nickname, this.mFq.getPaint(), tv.chushou.zues.utils.a.fU(this.mContext).x - tv.chushou.zues.utils.a.dip2px(this.mContext, 221.0f), TextUtils.TruncateAt.END));
            List<String> list = this.mFv.hiddenList;
            if (list != null) {
                if (!list.contains("gender")) {
                    cVar.append(" ");
                    cVar.J(this.mContext, tv.chushou.widget.a.c.Qg(userBean.gender));
                }
            }
            this.mFq.setText(cVar);
        }
    }

    private void b() {
        if (this.mFv != null && this.mFv.user != null) {
            if (!h.isEmpty(this.mFv.user.gloriouslyUid)) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!h.isEmpty(this.t) && !"-1".equals(this.t)) {
                    cVar.append(getString(a.i.str_userinfo_roomid)).append(":").append(this.t).append("    ");
                }
                cVar.append(this.mContext.getString(a.i.profile_id, this.mFv.user.gloriouslyUid));
                this.e.setText(cVar);
            }
            if (h.isEmpty(this.mFv.user.gloriouslyUidMedal)) {
                this.mFw.setVisibility(8);
            } else {
                this.mFw.a(this.mFv.user.gloriouslyUidMedal, com.kascend.chushou.view.a.a(), b.C0861b.small, b.C0861b.small, 1);
                this.mFw.setVisibility(0);
            }
            String str = this.mFv.user.avatar;
            if (!h.isEmpty(this.mFv.avatarList)) {
                str = this.mFv.avatarList.get(0).avatar;
            }
            if (h.isEmpty(str)) {
                this.mzP.xW(tv.chushou.widget.a.c.dJG());
            } else {
                this.mzP.i(str, com.kascend.chushou.view.a.a(null), tv.chushou.zues.widget.fresco.b.nua, tv.chushou.zues.widget.fresco.b.nua);
                this.mzP.getHierarchy().Gt(tv.chushou.widget.a.c.dJG());
            }
            if (!h.isEmpty(this.mFv.avatarList)) {
                this.p.clear();
                this.p.addAll(this.mFv.avatarList);
            }
            if (this.w && this.p.size() < 4) {
                RoomSpaceData.AvatarBean avatarBean = new RoomSpaceData.AvatarBean();
                avatarBean.id = "add_image";
                this.p.add(avatarBean);
            }
            if (this.mFs == null) {
                this.mFs = new tv.chushou.zues.widget.adapterview.abslistview.a<RoomSpaceData.AvatarBean>(this.mContext, this.p, a.h.item_user_space_avatar) { // from class: com.kascend.chushou.view.user.b.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // tv.chushou.zues.widget.adapterview.abslistview.a
                    public void a(a.C0857a c0857a, RoomSpaceData.AvatarBean avatarBean2) {
                        FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) c0857a.JQ(a.f.iv_avatar);
                        ImageView imageView = (ImageView) c0857a.JQ(a.f.iv_add);
                        if (avatarBean2.id.equals("add_image")) {
                            imageView.setVisibility(0);
                            frescoThumbnailView.h(avatarBean2.avatar, a.c.transparent_20_white, tv.chushou.zues.widget.fresco.b.nua / 4, tv.chushou.zues.widget.fresco.b.nua / 4);
                            return;
                        }
                        imageView.setVisibility(8);
                        frescoThumbnailView.i(avatarBean2.avatar, com.kascend.chushou.view.a.a(null), tv.chushou.zues.widget.fresco.b.nua, tv.chushou.zues.widget.fresco.b.nua);
                        frescoThumbnailView.getHierarchy().Gt(tv.chushou.widget.a.c.dJG());
                    }
                };
                this.mFp.setAdapter((ListAdapter) this.mFs);
            }
            this.mFs.notifyDataSetChanged();
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
        if (this.mFv != null && this.mFv.user != null) {
            final boolean z = this.mFv.isSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.view.user.b.3
                @Override // com.kascend.chushou.c.b
                public void a() {
                    if (!b.this.isFinishing()) {
                        b.this.l.setVisibility(8);
                        b.this.mFr.setVisibility(0);
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
                            b.this.mFr.setVisibility(8);
                            b.this.a(!z, true, -1, null);
                            b.this.mFv.isSubscribed = b.this.mFv.isSubscribed ? false : true;
                            b.this.a(b.this.mFv.isSubscribed);
                            return;
                        }
                        a(optInt, optString2);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!b.this.isFinishing()) {
                        b.this.l.setVisibility(0);
                        b.this.mFr.setVisibility(8);
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
                if (!z && this.mFv.user != null) {
                    e.a(this.mContext, this.mFv.user.nickname, new b.a() { // from class: com.kascend.chushou.view.user.b.4
                        @Override // tv.chushou.zues.widget.sweetalert.b.a
                        public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                            bVar2.dKt();
                            com.kascend.chushou.c.c.dwD().b(bVar, (String) null, b.this.mFv.user.uid, a);
                        }
                    });
                    return;
                } else {
                    com.kascend.chushou.c.c.dwD().a(bVar, (String) null, this.mFv.user.uid, a);
                }
            }
            optString = null;
            a = e.a("_fromView", Constants.VIA_REPORT_TYPE_DATALINE, "_sc", optString);
            if (!z) {
            }
            com.kascend.chushou.c.c.dwD().a(bVar, (String) null, this.mFv.user.uid, a);
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
            com.kascend.cstvsdk.utils.b.mJa.a(this.mContext, "5", roomSpaceData.user.uid, shareInfo, e.a("_fromView", Constants.VIA_REPORT_TYPE_DATALINE), false);
        }
    }

    private void d() {
        if (this.mFv != null && this.mFv.user != null) {
            UserBean userBean = this.mFv.user;
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
        } else if (this.mFv != null && this.mFv.user != null) {
            e.a(getChildFragmentManager(), this.mFv.user.nickname, this.t, this.mFv.user.uid);
            return true;
        } else {
            return true;
        }
    }

    private void e() {
        if (this.mFx == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(a.h.popup_item_mine_more, (ViewGroup) null);
            inflate.findViewById(a.f.ll_edit).setOnClickListener(this);
            inflate.findViewById(a.f.ll_share).setOnClickListener(this);
            inflate.findViewById(a.f.ll_account_safe).setOnClickListener(this);
            this.mFx = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mContext, 138.0f), -2);
            this.mFx.setOutsideTouchable(true);
            this.mFx.setFocusable(true);
            this.mFx.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.ic_main_mine_more_bg));
            this.mFx.update();
        }
        if (this.mFx.isShowing()) {
            this.mFx.dismiss();
        } else {
            this.mFx.showAsDropDown(this.h, tv.chushou.zues.utils.a.dip2px(this.mContext, -9.0f), 0);
        }
    }
}
