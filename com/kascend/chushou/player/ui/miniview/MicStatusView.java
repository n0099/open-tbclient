package com.kascend.chushou.player.ui.miniview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.FanItem;
import com.kascend.chushou.constants.MicStatus;
import com.kascend.chushou.widget.NoClickRecyclerView;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.adapterview.d;
import tv.chushou.zues.widget.adapterview.recyclerview.a.a;
import tv.chushou.zues.widget.adapterview.recyclerview.b.b;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes6.dex */
public class MicStatusView extends RelativeLayout implements View.OnClickListener {
    private TextView a;
    private Context b;
    private String c;
    private boolean d;
    private List<FanItem> e;
    private long f;
    private boolean i;
    private String j;
    private int k;
    private NoClickRecyclerView ofr;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<FanItem> ofs;

    public MicStatusView(Context context) {
        super(context);
        this.d = false;
        this.e = new ArrayList();
        this.f = 0L;
        this.i = false;
        a(context);
    }

    public MicStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = false;
        this.e = new ArrayList();
        this.f = 0L;
        this.i = false;
        a(context);
    }

    public MicStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        this.e = new ArrayList();
        this.f = 0L;
        this.i = false;
        a(context);
    }

    private void a(Context context) {
        this.b = context;
        View inflate = LayoutInflater.from(context).inflate(a.h.view_mic_status, (ViewGroup) this, true);
        this.a = (TextView) inflate.findViewById(a.f.mic_txt);
        this.ofr = (NoClickRecyclerView) inflate.findViewById(a.f.recycler_view);
        this.ofr.setLayoutManager(new b(this.b, 0, false));
        this.ofs = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<FanItem>(this.e, a.h.item_mic_user, new d() { // from class: com.kascend.chushou.player.ui.miniview.MicStatusView.1
            @Override // tv.chushou.zues.widget.adapterview.d
            public void D(View view, int i) {
                tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
            }
        }) { // from class: com.kascend.chushou.player.ui.miniview.MicStatusView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1011a view$OnLongClickListenerC1011a, FanItem fanItem) {
                view$OnLongClickListenerC1011a.a(a.f.iv_image, fanItem.mAvatar, com.kascend.chushou.view.a.a(fanItem.mGender), b.a.oYs, b.a.oYs);
            }
        };
        this.ofr.setAdapter(this.ofs);
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.d;
    }

    public void a(String str) {
        this.d = true;
        this.c = str;
        setVisibility(0);
        startAnimation(AnimationUtils.loadAnimation(this.b, a.C0879a.slide_in_top_danmu_anim));
        tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.a(1, 0).VC(this.c));
    }

    public void a() {
        this.d = false;
        setVisibility(8);
        tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.a(1, 8).yI(false).VC(this.c));
    }

    public void a(List<FanItem> list, String str, boolean z, MicStatus micStatus, String str2) {
        if (!h.isEmpty(micStatus.micRoomId) && !micStatus.micRoomId.equals("0")) {
            this.j = micStatus.micRoomId;
            this.k = micStatus.micGameActionType;
        }
        this.i = z;
        if (this.a != null) {
            this.a.setText(String.format(this.b.getString(a.i.mic_play_together), Integer.valueOf(micStatus.onlineCount)));
        }
        if (this.ofs != null && !h.isEmpty(list)) {
            this.e.clear();
            this.e.addAll(list);
            this.ofs.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
