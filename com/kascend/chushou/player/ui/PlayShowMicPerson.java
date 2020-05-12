package com.kascend.chushou.player.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.FanItem;
import com.kascend.chushou.constants.MicStatus;
import com.kascend.chushou.d.e;
import java.util.ArrayList;
import tv.chushou.widget.a.c;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.adapterview.d;
import tv.chushou.zues.widget.adapterview.recyclerview.a.a;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes5.dex */
public class PlayShowMicPerson extends RelativeLayout implements View.OnClickListener, Animation.AnimationListener {
    private TextView a;
    private Context b;
    private View c;
    private String e;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int l;
    private int m;
    private RecyclerView myf;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<FanItem> myg;
    private ArrayList<FanItem> n;

    public PlayShowMicPerson(Context context) {
        this(context, null);
    }

    public PlayShowMicPerson(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayShowMicPerson(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = false;
        this.i = false;
        this.j = false;
        this.n = new ArrayList<>();
        this.b = context;
        this.c = LayoutInflater.from(context).inflate(a.h.view_playshow_mic_person, (ViewGroup) this, true);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.PlayShowMicPerson.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PlayShowMicPerson.this.isShown()) {
                    PlayShowMicPerson.this.a();
                }
            }
        });
        this.a = (TextView) findViewById(a.f.tv_mic_count);
        this.myf = (RecyclerView) findViewById(a.f.lv_list);
        this.m = (int) ((tv.chushou.zues.utils.a.fU(this.b).y * 0.7d) - tv.chushou.zues.utils.a.dip2px(this.b, 44.0f));
        this.myf.setLayoutManager(new LinearLayoutManager(this.b));
        this.myg = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<FanItem>(this.n, a.h.list_playshow_micperson_item, new d() { // from class: com.kascend.chushou.player.ui.PlayShowMicPerson.2
            @Override // tv.chushou.zues.widget.adapterview.d
            public void B(View view, int i2) {
                if (PlayShowMicPerson.this.b != null && PlayShowMicPerson.this.n != null && i2 >= 0 && i2 < PlayShowMicPerson.this.n.size()) {
                    com.kascend.chushou.d.a.a(PlayShowMicPerson.this.b, e.O("_fromView", "53"), PlayShowMicPerson.this.e, ((FanItem) PlayShowMicPerson.this.n.get(i2)).mUserId, PlayShowMicPerson.this.f, false);
                }
            }
        }) { // from class: com.kascend.chushou.player.ui.PlayShowMicPerson.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0858a view$OnLongClickListenerC0858a, FanItem fanItem) {
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC0858a.JQ(a.f.iv_avatar);
                frescoThumbnailView.setAnim(false);
                view$OnLongClickListenerC0858a.t(a.f.iv_avatar);
                frescoThumbnailView.bU(fanItem.mAvatar, c.dJH());
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                cVar.append(fanItem.mNickname);
                cVar.append(" ").a(PlayShowMicPerson.this.b, c.Qh(fanItem.mGender), a.d.double_icon_size, a.d.double_icon_size);
                ((TextView) view$OnLongClickListenerC0858a.JQ(a.f.tv_nickname)).setText(cVar);
                TextView textView = (TextView) view$OnLongClickListenerC0858a.JQ(a.f.tv_signature);
                if (h.isEmpty(fanItem.mSignature)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(fanItem.mSignature);
                }
                if (!h.isEmpty(fanItem.mFansIcon)) {
                    view$OnLongClickListenerC0858a.a(false, a.f.iv_arrow);
                    view$OnLongClickListenerC0858a.a(true, a.f.iv_fans_icon);
                    view$OnLongClickListenerC0858a.a(a.f.iv_fans_icon, fanItem.mFansIcon, a.e.ic_loyal_icon_default, b.a.small, b.a.small, 1, false, true);
                    return;
                }
                view$OnLongClickListenerC0858a.a(true, a.f.iv_arrow);
                view$OnLongClickListenerC0858a.a(false, a.f.iv_fans_icon);
            }
        };
        this.myf.setAdapter(this.myg);
    }

    public void a(ArrayList<FanItem> arrayList, MicStatus micStatus, String str, boolean z, String str2) {
        if (!h.isEmpty(micStatus.micRoomId) && !micStatus.micRoomId.equals("0")) {
            this.g = micStatus.micRoomId;
            this.l = micStatus.micGameActionType;
        }
        this.h = z;
        if (this.j) {
            if (this.a != null) {
                this.a.setText(String.format(this.b.getString(a.i.mic_number2), Integer.valueOf(micStatus.onlineCount), Integer.valueOf(micStatus.capacity)));
            }
            this.n.clear();
            this.n.addAll(arrayList);
            setListViewHeight(this.n.size());
            this.myg.notifyDataSetChanged();
        }
    }

    public void a() {
        this.j = false;
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, a.C0736a.slide_out_bottom_anim);
        loadAnimation.setAnimationListener(this);
        if (this.c != null) {
            this.c.startAnimation(loadAnimation);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (!this.j) {
            setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    public void setListViewHeight(int i) {
        if (i > 0 && tv.chushou.zues.utils.a.dip2px(this.b, 60.0f) * i > this.m && this.myf != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.myf.getLayoutParams();
            layoutParams.height = this.m;
            this.myf.setLayoutParams(layoutParams);
        }
    }
}
