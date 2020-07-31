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
/* loaded from: classes6.dex */
public class a extends b {
    public int a;
    public TextView d;
    public String e;
    public String f;
    private View g;
    private boolean h = false;
    private boolean i = true;
    private List<FanItem> j = new ArrayList();
    public SwipRefreshRecyclerView nDX;
    public EmptyLoadingView nDY;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<FanItem> nxV;

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
        this.nDX = (SwipRefreshRecyclerView) inflate.findViewById(a.f.lv_list);
        this.nDX.setUpDefault();
        this.nDY = (EmptyLoadingView) inflate.findViewById(a.f.emptyview);
        this.nxV = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<FanItem>(this.j, a.h.list_micperson_item, new d() { // from class: com.kascend.chushou.view.c.a.1
            @Override // tv.chushou.zues.widget.adapterview.d
            public void C(View view, int i) {
                if (a.this.mContext != null && a.this.j != null && i >= 0 && i < a.this.j.size()) {
                    com.kascend.chushou.d.a.a(a.this.mContext, e.P("_fromView", "53"), a.this.f, ((FanItem) a.this.j.get(i - a.this.nDX.getHeaderViewCount())).mUserId, a.this.e, false);
                }
            }
        }) { // from class: com.kascend.chushou.view.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0956a view$OnLongClickListenerC0956a, FanItem fanItem) {
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC0956a.oK(a.f.iv_avatar);
                frescoThumbnailView.setAnim(false);
                view$OnLongClickListenerC0956a.t(a.f.iv_avatar);
                frescoThumbnailView.bS(fanItem.mAvatar, c.dZV());
                TextView textView = (TextView) view$OnLongClickListenerC0956a.oK(a.f.tv_nickname);
                FrescoThumbnailView frescoThumbnailView2 = (FrescoThumbnailView) view$OnLongClickListenerC0956a.oK(a.f.iv_user_level_icon);
                if (h.isEmpty(fanItem.mLevelMedal)) {
                    frescoThumbnailView2.setVisibility(8);
                } else {
                    frescoThumbnailView2.setVisibility(0);
                    frescoThumbnailView2.a(fanItem.mLevelMedal, com.kascend.chushou.view.a.a(), b.C0959b.small, b.C0959b.small, 3);
                }
                FrescoThumbnailView frescoThumbnailView3 = (FrescoThumbnailView) view$OnLongClickListenerC0956a.oK(a.f.ftv_uid_medal);
                if (h.isEmpty(fanItem.mGloriouslyUidMedal)) {
                    frescoThumbnailView3.setVisibility(8);
                } else {
                    frescoThumbnailView3.setVisibility(0);
                    frescoThumbnailView3.a(fanItem.mGloriouslyUidMedal, com.kascend.chushou.view.a.a(), b.C0959b.small, b.C0959b.small, 3);
                }
                FrescoThumbnailView frescoThumbnailView4 = (FrescoThumbnailView) view$OnLongClickListenerC0956a.oK(a.f.iv_user_noble_icon);
                if (h.isEmpty(fanItem.mNobleMedal)) {
                    frescoThumbnailView4.setVisibility(8);
                } else {
                    frescoThumbnailView4.setAnim(true);
                    frescoThumbnailView4.setVisibility(0);
                    frescoThumbnailView4.a(fanItem.mNobleMedal, com.kascend.chushou.view.a.a(), b.C0959b.small, b.C0959b.small, 3);
                }
                view$OnLongClickListenerC0956a.ei(a.f.iv_sex, c.TL(fanItem.mGender));
                textView.setText(fanItem.mNickname);
                String str = fanItem.mSignature;
                if (h.isEmpty(str)) {
                    str = "ID: " + fanItem.mUserId;
                }
                view$OnLongClickListenerC0956a.a(a.f.tv_autograph, str);
                if (a.this.a == 2) {
                    if (!h.isEmpty(fanItem.mFansIcon)) {
                        view$OnLongClickListenerC0956a.a(false, a.f.iv_arrow);
                        view$OnLongClickListenerC0956a.a(true, a.f.iv_fans_icon);
                        view$OnLongClickListenerC0956a.a(a.f.iv_fans_icon, fanItem.mFansIcon, a.e.ic_loyal_icon_default, b.a.small, b.a.small, 1, false, true);
                        return;
                    }
                    view$OnLongClickListenerC0956a.a(true, a.f.iv_arrow);
                    view$OnLongClickListenerC0956a.a(false, a.f.iv_fans_icon);
                }
            }
        };
        this.nDX.setAdapter(this.nxV);
        this.g = LayoutInflater.from(this.mContext).inflate(a.h.view_fan_list_header, (ViewGroup) this.nDX, false);
        this.d = (TextView) this.g.findViewById(a.f.tv_contact_count);
        this.nDX.setPullToRefreshEnabled(false);
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.b
    protected void initData() {
        this.nxV.notifyDataSetChanged();
    }

    @Override // com.kascend.chushou.view.base.b
    public void showStatus(int i) {
        switch (i) {
            case 1:
                if (!this.h && this.i) {
                    this.nDX.setVisibility(8);
                    this.nDY.KO(1);
                    return;
                }
                return;
            case 2:
                if (this.h) {
                    this.nDX.completeRefresh();
                    this.h = false;
                }
                this.i = false;
                this.nDX.setVisibility(0);
                this.nDY.setVisibility(8);
                this.nDX.eaq();
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.nDX.setVisibility(8);
                this.nDY.setVisibility(0);
                this.nDY.KO(i);
                return;
            case 7:
                g.F(this.mContext, a.i.str_nomoredata);
                this.nDX.setHasMoreItems(false);
                return;
            case 8:
                this.nDX.setHasMoreItems(true);
                return;
            default:
                return;
        }
    }

    public void a(ArrayList<FanItem> arrayList) {
        this.j.clear();
        this.j.addAll(arrayList);
        if (this.nxV != null) {
            this.nxV.notifyDataSetChanged();
        }
    }
}
