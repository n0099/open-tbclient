package com.kascend.chushou.widget.showplayer;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coremedia.iso.boxes.MetaBox;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.o;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.widget.ItemTagView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.utils.systemBar.b;
import tv.chushou.zues.widget.a.c;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes5.dex */
public class PlayShowRecommendView extends RelativeLayout implements View.OnClickListener {
    protected Context a;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private a mIQ;
    private RoomInfo mIR;
    private FrescoThumbnailView mzK;
    private FrescoThumbnailView mzP;
    private ArrayList<ListItem> n;

    /* loaded from: classes5.dex */
    public interface a {
        void a(View view);
    }

    public PlayShowRecommendView(Context context) {
        this(context, null);
        a(context);
    }

    public PlayShowRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        int statusBarHeight = b.getStatusBarHeight(this.a);
        LayoutInflater.from(this.a).inflate(a.h.view_playshow_recommend, (ViewGroup) this, true);
        this.mzP = (FrescoThumbnailView) findViewById(a.f.iv_head);
        this.mzK = (FrescoThumbnailView) findViewById(a.f.iv_audio_all_bg);
        this.e = (TextView) findViewById(a.f.tv_nickname);
        this.f = (TextView) findViewById(a.f.tv_roomid);
        this.g = (TextView) findViewById(a.f.tv_fans_count);
        this.h = (TextView) findViewById(a.f.tv_subscribe);
        this.i = (LinearLayout) findViewById(a.f.ll_recommend);
        this.i.setVisibility(8);
        this.j = (LinearLayout) findViewById(a.f.ll_recommend_detail);
        this.k = (LinearLayout) findViewById(a.f.ll_endView);
        this.d = (ImageView) findViewById(a.f.iv_close);
        this.d.setOnClickListener(this);
        this.h.setOnClickListener(this);
        if (statusBarHeight > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.d.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams2.topMargin = statusBarHeight;
            this.k.setLayoutParams(layoutParams2);
        }
    }

    public void a(RoomInfo roomInfo, a aVar) {
        this.mIR = roomInfo;
        this.mIQ = aVar;
        this.i.setVisibility(8);
        this.j.removeAllViews();
        a(roomInfo.mRoomID);
        c cVar = new c();
        cVar.append(this.a.getString(a.i.str_userinfo_roomid)).append(":  ").append(roomInfo.mRoomID);
        this.f.setText(cVar);
        this.mzK.setBlur(true);
        this.mzK.i(roomInfo.mCreatorAvatar, a.e.ic_audio_bg, b.a.ntZ, b.a.ntZ);
        this.mzP.i(roomInfo.mCreatorAvatar, tv.chushou.widget.a.c.dJK(), b.a.small, b.a.small);
        c cVar2 = new c();
        cVar2.append(roomInfo.mCreatorNickname);
        cVar2.append(" ").a(this.a, tv.chushou.widget.a.c.Qe(roomInfo.mCreatorGender), a.d.double_icon_size, a.d.double_icon_size);
        this.e.setText(cVar2);
        c cVar3 = new c();
        cVar3.append(this.a.getString(a.i.follower_title)).append(":  ").append(tv.chushou.zues.utils.b.formatNumber(roomInfo.mFansCount));
        this.g.setText(cVar3);
        if (roomInfo.mIsSubscribed) {
            c cVar4 = new c();
            cVar4.b(this.a, a.e.ic_playshow_subcribed, tv.chushou.zues.utils.a.dip2px(this.a, 20.0f), tv.chushou.zues.utils.a.dip2px(this.a, 20.0f));
            cVar4.append("   ").append(this.a.getResources().getString(a.i.like_already));
            this.h.setText(cVar4);
            this.h.setBackgroundResource(a.e.bg_playshow_end_subscirbed);
            this.h.setClickable(false);
            return;
        }
        c cVar5 = new c();
        cVar5.b(this.a, a.e.ic_playshow_subcribe, tv.chushou.zues.utils.a.dip2px(this.a, 20.0f), tv.chushou.zues.utils.a.dip2px(this.a, 20.0f));
        cVar5.append("   ").append(this.a.getResources().getString(a.i.homepage_subscribe));
        this.h.setBackgroundResource(a.e.bg_playshow_end_subscirbe);
        this.h.setText(cVar5);
        this.h.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.a != null) {
            int size = this.n.size();
            if (size == 0) {
                this.i.setVisibility(8);
                return;
            }
            this.i.setVisibility(0);
            this.j.removeAllViews();
            int min = Math.min(size, 2);
            for (int i = 0; i < min; i++) {
                ListItem listItem = this.n.get(i);
                View inflate = LayoutInflater.from(this.a).inflate(a.h.playshow_recommendview_item, (ViewGroup) null, false);
                View findViewById = inflate.findViewById(a.f.rl_view);
                if (i != 0) {
                    findViewById.setVisibility(0);
                } else {
                    findViewById.setVisibility(8);
                }
                ((FrescoThumbnailView) inflate.findViewById(a.f.iv_thumb)).bU(listItem.mCover, a.e.def_recmd);
                ((TextView) inflate.findViewById(a.f.tv_content)).setText(listItem.mName);
                ((ItemTagView) inflate.findViewById(a.f.iv_tag)).a(listItem);
                inflate.setTag(listItem);
                inflate.setClickable(true);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.widget.showplayer.PlayShowRecommendView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Object tag = view.getTag();
                        if (tag != null && (tag instanceof ListItem)) {
                            ListItem listItem2 = (ListItem) tag;
                            if (listItem2.mType != null && listItem2.mType.equals("1")) {
                                o oVar = new o();
                                oVar.mnr = listItem2;
                                oVar.b = "recommend";
                                oVar.c = PlayShowRecommendView.this.a;
                                oVar.g = listItem2.mLiveType;
                                tv.chushou.zues.a.a.post(oVar);
                            }
                        }
                    }
                });
                this.j.addView(inflate);
            }
            setVisibility(0);
        }
    }

    private void a(String str) {
        if (tv.chushou.zues.utils.a.dJS()) {
            com.kascend.chushou.c.c.dwG().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.showplayer.PlayShowRecommendView.2
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject == null) {
                        PlayShowRecommendView.this.i.setVisibility(8);
                        return;
                    }
                    String str3 = "";
                    try {
                        int i = jSONObject.getInt("code");
                        if (jSONObject.has("message")) {
                            str3 = jSONObject.getString("message");
                        }
                        e.i("PlayShowRecommendView", "rc = " + i + " msg=" + str3);
                        if (i == 0 && jSONObject.has("data")) {
                            ArrayList arrayList = new ArrayList();
                            JSONArray jSONArray = jSONObject.getJSONArray("data");
                            int length = jSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                ListItem listItem = new ListItem();
                                listItem.mCover = jSONObject2.optString("cover");
                                listItem.mName = jSONObject2.optString("name");
                                listItem.mType = jSONObject2.optString("type");
                                listItem.mTargetKey = jSONObject2.optString("targetKey");
                                if (jSONObject2.has(MetaBox.TYPE)) {
                                    JSONObject jSONObject3 = jSONObject2.getJSONObject(MetaBox.TYPE);
                                    listItem.mLiveType = jSONObject3.optString("liveType");
                                    listItem.mSC = jSONObject3.optString("_sc");
                                }
                                arrayList.add(listItem);
                            }
                            if (arrayList == null || arrayList.size() == 0) {
                                PlayShowRecommendView.this.i.setVisibility(8);
                            } else {
                                PlayShowRecommendView.this.n = arrayList;
                                PlayShowRecommendView.this.a();
                            }
                            e.i("PlayShowRecommendView", "parser sucess");
                        }
                    } catch (Exception e) {
                        e.e("PlayShowRecommendView", "error " + e.toString());
                        PlayShowRecommendView.this.i.setVisibility(8);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    PlayShowRecommendView.this.i.setVisibility(8);
                }
            }, str);
        } else {
            this.i.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.n != null) {
            this.n.clear();
            this.n = null;
        }
        this.a = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.tv_subscribe) {
            if (this.mIR != null) {
                b(this.mIR.mCreatorUID);
            }
        } else if (this.mIQ != null) {
            this.mIQ.a(view);
        }
    }

    private void b(String str) {
        com.kascend.chushou.c.c.dwG().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.widget.showplayer.PlayShowRecommendView.3
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str2, JSONObject jSONObject) {
                if (ViewCompat.isAttachedToWindow(PlayShowRecommendView.this)) {
                    ParserRet dy = com.kascend.chushou.c.a.dy(jSONObject);
                    if (dy.mRc == 0) {
                        g.F(PlayShowRecommendView.this.a, a.i.subscribe_success);
                        c cVar = new c();
                        cVar.b(PlayShowRecommendView.this.a, a.e.ic_playshow_subcribed, tv.chushou.zues.utils.a.dip2px(PlayShowRecommendView.this.a, 20.0f), tv.chushou.zues.utils.a.dip2px(PlayShowRecommendView.this.a, 20.0f));
                        cVar.append("   ").append(PlayShowRecommendView.this.a.getResources().getString(a.i.like_already));
                        PlayShowRecommendView.this.h.setText(cVar);
                        PlayShowRecommendView.this.h.setClickable(false);
                        PlayShowRecommendView.this.h.setBackgroundResource(a.e.bg_playshow_end_subscirbed);
                        return;
                    }
                    a(dy.mRc, dy.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str2) {
                if (ViewCompat.isAttachedToWindow(PlayShowRecommendView.this)) {
                    if (h.isEmpty(str2)) {
                        str2 = PlayShowRecommendView.this.a.getString(a.i.subscribe_failed);
                    }
                    g.c(PlayShowRecommendView.this.a, str2);
                }
            }
        }, (String) null, str, "");
    }
}
