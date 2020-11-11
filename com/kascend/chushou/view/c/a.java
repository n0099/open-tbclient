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

    /* renamed from: a  reason: collision with root package name */
    public int f4231a;
    public TextView d;
    public String e;
    public String f;
    private View g;
    private boolean h = false;
    private boolean i = true;
    private List<FanItem> j = new ArrayList();
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<FanItem> psk;
    public SwipRefreshRecyclerView pyf;
    public EmptyLoadingView pyg;

    @Override // com.kascend.chushou.view.base.b, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getActivity();
        this.e = getArguments().getString("mUserId");
        this.f4231a = getArguments().getInt("type");
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
        if (this.f4231a == 2) {
            inflate.setBackgroundResource(0);
        }
        this.pyf = (SwipRefreshRecyclerView) inflate.findViewById(a.f.lv_list);
        this.pyf.setUpDefault();
        this.pyg = (EmptyLoadingView) inflate.findViewById(a.f.emptyview);
        this.psk = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<FanItem>(this.j, a.h.list_micperson_item, new d() { // from class: com.kascend.chushou.view.c.a.1
            @Override // tv.chushou.zues.widget.adapterview.d
            public void I(View view, int i) {
                if (a.this.mContext != null && a.this.j != null && i >= 0 && i < a.this.j.size()) {
                    com.kascend.chushou.d.a.a(a.this.mContext, e.O("_fromView", "53"), a.this.f, ((FanItem) a.this.j.get(i - a.this.pyf.getHeaderViewCount())).mUserId, a.this.e, false);
                }
            }
        }) { // from class: com.kascend.chushou.view.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1121a view$OnLongClickListenerC1121a, FanItem fanItem) {
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC1121a.sg(a.f.iv_avatar);
                frescoThumbnailView.setAnim(false);
                view$OnLongClickListenerC1121a.v(a.f.iv_avatar);
                frescoThumbnailView.ce(fanItem.mAvatar, c.eHE());
                TextView textView = (TextView) view$OnLongClickListenerC1121a.sg(a.f.tv_nickname);
                FrescoThumbnailView frescoThumbnailView2 = (FrescoThumbnailView) view$OnLongClickListenerC1121a.sg(a.f.iv_user_level_icon);
                if (h.isEmpty(fanItem.mLevelMedal)) {
                    frescoThumbnailView2.setVisibility(8);
                } else {
                    frescoThumbnailView2.setVisibility(0);
                    frescoThumbnailView2.a(fanItem.mLevelMedal, com.kascend.chushou.view.a.a(), b.C1124b.small, b.C1124b.small, 3);
                }
                FrescoThumbnailView frescoThumbnailView3 = (FrescoThumbnailView) view$OnLongClickListenerC1121a.sg(a.f.ftv_uid_medal);
                if (h.isEmpty(fanItem.mGloriouslyUidMedal)) {
                    frescoThumbnailView3.setVisibility(8);
                } else {
                    frescoThumbnailView3.setVisibility(0);
                    frescoThumbnailView3.a(fanItem.mGloriouslyUidMedal, com.kascend.chushou.view.a.a(), b.C1124b.small, b.C1124b.small, 3);
                }
                FrescoThumbnailView frescoThumbnailView4 = (FrescoThumbnailView) view$OnLongClickListenerC1121a.sg(a.f.iv_user_noble_icon);
                if (h.isEmpty(fanItem.mNobleMedal)) {
                    frescoThumbnailView4.setVisibility(8);
                } else {
                    frescoThumbnailView4.setAnim(true);
                    frescoThumbnailView4.setVisibility(0);
                    frescoThumbnailView4.a(fanItem.mNobleMedal, com.kascend.chushou.view.a.a(), b.C1124b.small, b.C1124b.small, 3);
                }
                view$OnLongClickListenerC1121a.eF(a.f.iv_sex, c.aaw(fanItem.mGender));
                textView.setText(fanItem.mNickname);
                String str = fanItem.mSignature;
                if (h.isEmpty(str)) {
                    str = "ID: " + fanItem.mUserId;
                }
                view$OnLongClickListenerC1121a.a(a.f.tv_autograph, str);
                if (a.this.f4231a == 2) {
                    if (!h.isEmpty(fanItem.mFansIcon)) {
                        view$OnLongClickListenerC1121a.a(false, a.f.iv_arrow);
                        view$OnLongClickListenerC1121a.a(true, a.f.iv_fans_icon);
                        view$OnLongClickListenerC1121a.a(a.f.iv_fans_icon, fanItem.mFansIcon, a.e.ic_loyal_icon_default, b.a.small, b.a.small, 1, false, true);
                        return;
                    }
                    view$OnLongClickListenerC1121a.a(true, a.f.iv_arrow);
                    view$OnLongClickListenerC1121a.a(false, a.f.iv_fans_icon);
                }
            }
        };
        this.pyf.setAdapter(this.psk);
        this.g = LayoutInflater.from(this.mContext).inflate(a.h.view_fan_list_header, (ViewGroup) this.pyf, false);
        this.d = (TextView) this.g.findViewById(a.f.tv_contact_count);
        this.pyf.setPullToRefreshEnabled(false);
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.b
    protected void initData() {
        this.psk.notifyDataSetChanged();
    }

    @Override // com.kascend.chushou.view.base.b
    public void showStatus(int i) {
        switch (i) {
            case 1:
                if (!this.h && this.i) {
                    this.pyf.setVisibility(8);
                    this.pyg.QP(1);
                    return;
                }
                return;
            case 2:
                if (this.h) {
                    this.pyf.completeRefresh();
                    this.h = false;
                }
                this.i = false;
                this.pyf.setVisibility(0);
                this.pyg.setVisibility(8);
                this.pyf.eHZ();
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.pyf.setVisibility(8);
                this.pyg.setVisibility(0);
                this.pyg.QP(i);
                return;
            case 7:
                g.O(this.mContext, a.i.str_nomoredata);
                this.pyf.setHasMoreItems(false);
                return;
            case 8:
                this.pyf.setHasMoreItems(true);
                return;
            default:
                return;
        }
    }

    public void a(ArrayList<FanItem> arrayList) {
        this.j.clear();
        this.j.addAll(arrayList);
        if (this.psk != null) {
            this.psk.notifyDataSetChanged();
        }
    }
}
