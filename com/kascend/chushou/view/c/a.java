package com.kascend.chushou.view.c;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.FanItem;
import com.kascend.chushou.d.e;
import com.kascend.chushou.view.base.b;
import com.kascend.chushou.widget.EmptyLoadingView;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.widget.a.c;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.adapterview.d;
import tv.chushou.zues.widget.adapterview.recyclerview.a.a;
import tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes4.dex */
public class a extends b {
    public int a;
    public TextView d;
    public String e;
    public String f;
    private View g;
    private boolean h = false;
    private boolean i = true;
    private List<FanItem> j = new ArrayList();
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<FanItem> mZc;
    public SwipRefreshRecyclerView neS;
    public EmptyLoadingView neT;

    @Override // com.kascend.chushou.view.base.b, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getActivity();
        this.e = getArguments().getString("mUserId");
        this.a = getArguments().getInt("type");
        this.f = getArguments().getString("mRoomId");
        ArrayList arrayList = (ArrayList) getArguments().getSerializable("mFanList");
        if (!h.isEmpty(arrayList)) {
            this.j.clear();
            this.j.addAll(arrayList);
        }
    }

    @Override // com.kascend.chushou.view.base.b
    protected View initView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.view_fans, viewGroup, false);
        if (this.a == 2) {
            inflate.setBackgroundResource(0);
        }
        this.neS = (SwipRefreshRecyclerView) inflate.findViewById(a.f.lv_list);
        this.neS.setUpDefault();
        this.neT = (EmptyLoadingView) inflate.findViewById(a.f.emptyview);
        this.mZc = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<FanItem>(this.j, a.h.list_micperson_item, new d() { // from class: com.kascend.chushou.view.c.a.1
            @Override // tv.chushou.zues.widget.adapterview.d
            public void onItemClick(View view, int i) {
                if (a.this.mContext != null && a.this.j != null && i >= 0 && i < a.this.j.size()) {
                    com.kascend.chushou.d.a.a(a.this.mContext, e.M("_fromView", "53"), a.this.f, ((FanItem) a.this.j.get(i - a.this.neS.getHeaderViewCount())).mUserId, a.this.e, false);
                }
            }
        }) { // from class: com.kascend.chushou.view.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0805a view$OnLongClickListenerC0805a, FanItem fanItem) {
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC0805a.Ol(a.f.iv_avatar);
                frescoThumbnailView.setAnim(false);
                view$OnLongClickListenerC0805a.s(a.f.iv_avatar);
                frescoThumbnailView.bV(fanItem.mAvatar, c.dOV());
                TextView textView = (TextView) view$OnLongClickListenerC0805a.Ol(a.f.tv_nickname);
                FrescoThumbnailView frescoThumbnailView2 = (FrescoThumbnailView) view$OnLongClickListenerC0805a.Ol(a.f.iv_user_level_icon);
                if (h.isEmpty(fanItem.mLevelMedal)) {
                    frescoThumbnailView2.setVisibility(8);
                } else {
                    frescoThumbnailView2.setVisibility(0);
                    frescoThumbnailView2.a(fanItem.mLevelMedal, com.kascend.chushou.view.a.a(), b.C0808b.small, b.C0808b.small, 3);
                }
                FrescoThumbnailView frescoThumbnailView3 = (FrescoThumbnailView) view$OnLongClickListenerC0805a.Ol(a.f.ftv_uid_medal);
                if (h.isEmpty(fanItem.mGloriouslyUidMedal)) {
                    frescoThumbnailView3.setVisibility(8);
                } else {
                    frescoThumbnailView3.setVisibility(0);
                    frescoThumbnailView3.a(fanItem.mGloriouslyUidMedal, com.kascend.chushou.view.a.a(), b.C0808b.small, b.C0808b.small, 3);
                }
                FrescoThumbnailView frescoThumbnailView4 = (FrescoThumbnailView) view$OnLongClickListenerC0805a.Ol(a.f.iv_user_noble_icon);
                if (h.isEmpty(fanItem.mNobleMedal)) {
                    frescoThumbnailView4.setVisibility(8);
                } else {
                    frescoThumbnailView4.setAnim(true);
                    frescoThumbnailView4.setVisibility(0);
                    frescoThumbnailView4.a(fanItem.mNobleMedal, com.kascend.chushou.view.a.a(), b.C0808b.small, b.C0808b.small, 3);
                }
                view$OnLongClickListenerC0805a.eD(a.f.iv_sex, c.SC(fanItem.mGender));
                textView.setText(fanItem.mNickname);
                String str = fanItem.mSignature;
                if (h.isEmpty(str)) {
                    str = "ID: " + fanItem.mUserId;
                }
                view$OnLongClickListenerC0805a.a(a.f.tv_autograph, str);
                if (a.this.a == 2) {
                    if (!h.isEmpty(fanItem.mFansIcon)) {
                        view$OnLongClickListenerC0805a.a(false, a.f.iv_arrow);
                        view$OnLongClickListenerC0805a.a(true, a.f.iv_fans_icon);
                        view$OnLongClickListenerC0805a.a(a.f.iv_fans_icon, fanItem.mFansIcon, a.e.ic_loyal_icon_default, b.a.small, b.a.small, 1, false, true);
                        return;
                    }
                    view$OnLongClickListenerC0805a.a(true, a.f.iv_arrow);
                    view$OnLongClickListenerC0805a.a(false, a.f.iv_fans_icon);
                }
            }
        };
        this.neS.setAdapter(this.mZc);
        this.g = LayoutInflater.from(this.mContext).inflate(a.h.view_fan_list_header, (ViewGroup) this.neS, false);
        this.d = (TextView) this.g.findViewById(a.f.tv_contact_count);
        this.neS.setPullToRefreshEnabled(false);
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.b
    protected void initData() {
        this.mZc.notifyDataSetChanged();
    }

    @Override // com.kascend.chushou.view.base.b
    public void showStatus(int i) {
        switch (i) {
            case 1:
                if (!this.h && this.i) {
                    this.neS.setVisibility(8);
                    this.neT.MX(1);
                    return;
                }
                return;
            case 2:
                if (this.h) {
                    this.neS.completeRefresh();
                    this.h = false;
                }
                this.i = false;
                this.neS.setVisibility(0);
                this.neT.setVisibility(8);
                this.neS.dPn();
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.neS.setVisibility(8);
                this.neT.setVisibility(0);
                this.neT.MX(i);
                return;
            case 7:
                g.M(this.mContext, a.i.str_nomoredata);
                this.neS.setHasMoreItems(false);
                return;
            case 8:
                this.neS.setHasMoreItems(true);
                return;
            default:
                return;
        }
    }

    public void a(ArrayList<FanItem> arrayList) {
        this.j.clear();
        this.j.addAll(arrayList);
        if (this.mZc != null) {
            this.mZc.notifyDataSetChanged();
        }
    }
}
