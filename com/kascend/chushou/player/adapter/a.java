package com.kascend.chushou.player.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import com.facebook.drawee.span.b;
import com.facebook.drawee.span.c;
import com.google.android.flexbox.FlexboxLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.d.d;
import com.kascend.chushou.d.e;
import com.kascend.chushou.player.VideoPlayer;
import com.kascend.chushou.widget.gif.EmojiGiftView;
import com.kascend.chushou.widget.gif.b;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.http.Http;
import tv.chushou.zues.toolkit.richtext.RichText;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected Context b;
    private LayoutInflater c;
    private final int l;
    private final int m;
    private final int n;
    private tv.chushou.zues.a noR;
    private tv.chushou.zues.a noS;
    private tv.chushou.zues.a noT;
    private tv.chushou.zues.a noU;
    private tv.chushou.zues.a noV;
    private final tv.chushou.zues.toolkit.richtext.a noW;
    private ArrayList<ChatInfo> noX;
    private RoomInfo noY;
    private HashMap<String, Drawable> npa;
    private final int o;
    private final int p;
    private JSONObject r;
    private final int w;
    protected int a = 0;
    private final int i = 14;
    private final int j = 18;
    private final int k = 5;
    private HashMap<String, String> noZ = new HashMap<>();
    private final int x = tv.chushou.widget.a.c.D(28.0f);
    private final int y = tv.chushou.widget.a.c.D(21.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0827a extends RecyclerView.ViewHolder implements Drawable.Callback {
        SimpleDraweeSpanTextView npe;

        C0827a(View view) {
            super(view);
            this.npe = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            if (this.npe != null && ViewCompat.isAttachedToWindow(this.npe)) {
                this.npe.invalidate();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
            if (this.npe != null) {
                this.npe.postDelayed(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            if (this.npe != null) {
                this.npe.removeCallbacks(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView c;
        private int d;
        private SimpleDraweeSpanTextView npf;
        private ChatInfo npj;

        c(View view) {
            super(view);
            this.npf = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
            this.c = (TextView) view.findViewById(a.f.tv_share_room);
            this.c.setOnClickListener(this);
            this.c.setText(new tv.chushou.zues.widget.a.c().append(a.this.b.getString(a.i.videoplayer_danmaku_share)).J(a.this.b, a.e.videoplayer_danmaku_share_icon));
            String Ma = tv.chushou.zues.utils.a.Ma(a.this.p);
            String str = (String) a.this.noZ.get(Ma);
            this.d = Color.parseColor(h.isEmpty(str) ? Ma : str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.kascend.chushou.player.b dMA;
            JSONObject jSONObject = null;
            if (this.npj != null && this.npj.mItem != null) {
                String str = (!(a.this.b instanceof VideoPlayer) || (dMA = ((VideoPlayer) a.this.b).dMA()) == null) ? null : dMA.h;
                if (!h.isEmpty(str)) {
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (JSONException e) {
                    }
                }
                e.a(a.this.b, this.npj.mItem, jSONObject);
            }
        }

        void a(ChatInfo chatInfo) {
            this.npj = chatInfo;
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            if (!tv.chushou.zues.toolkit.richtext.b.a(a.this.b, cVar, chatInfo.mContentRichText, 18, this.d, this.npf, null, a.this.noW, a.this.noZ)) {
                cVar.a(chatInfo.mContent, new ForegroundColorSpan(this.d));
            }
            this.npf.setDraweeSpanStringBuilder(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends RecyclerView.ViewHolder implements Drawable.Callback {
        View a;
        private int e;
        SimpleDraweeSpanTextView npf;
        EmojiGiftView npg;

        b(View view) {
            super(view);
            this.e = tv.chushou.widget.a.c.D(21.0f);
            this.a = view;
            this.npf = (SimpleDraweeSpanTextView) view.findViewById(a.f.tvTitle);
            this.npg = (EmojiGiftView) view.findViewById(a.f.tvEmoji);
        }

        void a(ChatInfo chatInfo) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                d.nnD.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar, a.this.x, this.e);
            }
            if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                for (int i = 0; i < chatInfo.mPrivilegeInfo.mMedals.size(); i++) {
                    String str = chatInfo.mPrivilegeInfo.mMedals.get(i);
                    if (!h.isEmpty(str)) {
                        a.this.a(this.npf, this, cVar, str, a.e.default_medal_icon, a.this.n, a.this.o);
                    }
                }
            }
            if (chatInfo.mCoolMessage != null) {
                tv.chushou.zues.toolkit.richtext.b.a(a.this.b, cVar, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(a.this.b, a.c.banrrage_chat_name_color), this.npf, " : ", a.this.noW);
            } else if (!tv.chushou.zues.toolkit.richtext.b.a(a.this.b, cVar, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(a.this.b, a.c.kas_red_n), this.npf)) {
                cVar.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(a.this.b.getResources().getColor(a.c.kas_red_n)));
            } else {
                cVar.a(" : ", new ForegroundColorSpan(a.this.b.getResources().getColor(a.c.kas_red_n)));
            }
            this.npf.setMovementMethod(tv.chushou.zues.widget.a.b.eaG());
            cVar.setSpan(new tv.chushou.zues.widget.a.a(a.this.noR), 0, cVar.length() + (-1) > 0 ? cVar.length() - 1 : 0, 17);
            this.npf.setTag(a.f.tag_position, chatInfo);
            cVar.a(new b.c() { // from class: com.kascend.chushou.player.adapter.a.b.1
                @Override // com.facebook.drawee.span.b.c
                public void d(com.facebook.drawee.span.b bVar) {
                    if (b.this.npf != null) {
                        b.this.npf.measure(0, 0);
                        b.this.npf.requestLayout();
                    }
                }
            });
            this.npf.setDraweeSpanStringBuilder(cVar);
            int D = chatInfo.giftDisplayWidth > 0 ? tv.chushou.widget.a.c.D(chatInfo.giftDisplayWidth) : a.this.w;
            int D2 = chatInfo.giftDisplayHeight > 0 ? tv.chushou.widget.a.c.D(chatInfo.giftDisplayHeight) : a.this.w;
            FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) this.npg.getLayoutParams();
            layoutParams.width = D;
            layoutParams.height = D2;
            this.npg.setLayoutParams(layoutParams);
            this.npg.g(chatInfo.mGift.icon, a.c.transparent, D, D2);
            this.npg.setOnClickListener(a.this.noU);
            this.npg.setTag(a.f.tag_position, Integer.valueOf(chatInfo.mGift.id));
            if (chatInfo.mCoolMessage != null && !h.isEmpty(chatInfo.mCoolMessage.mBgImage)) {
                com.kascend.chushou.toolkit.b.a.dOn().a(chatInfo.mCoolMessage.mBgImage, this.a, a.e.bg_bubble_default);
                return;
            }
            this.a.setBackgroundResource(0);
            this.a.setPadding(tv.chushou.zues.utils.a.dip2px(a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(a.this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(a.this.b, 5.0f));
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            if (this.npf != null && ViewCompat.isAttachedToWindow(this.npf)) {
                this.npf.invalidate();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
            if (this.npf != null) {
                this.npf.postDelayed(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            if (this.npf != null) {
                this.npf.removeCallbacks(runnable);
            }
        }
    }

    public void a() {
        if (this.npa != null) {
            this.npa.clear();
            this.npa = null;
        }
        com.kascend.chushou.toolkit.b.a.b();
    }

    public void a(RoomInfo roomInfo) {
        this.noY = roomInfo;
        if (this.noY != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            hashMap.put("_fbroomid", this.noY.mRoomID);
            this.r = e.a(hashMap);
        }
    }

    public void a(HashMap<String, String> hashMap) {
        if (this.noZ != null) {
            this.noZ.clear();
            this.noZ.putAll(hashMap);
        }
    }

    public a(final Context context, ArrayList<ChatInfo> arrayList) {
        this.b = null;
        this.noX = arrayList;
        this.b = context;
        this.c = LayoutInflater.from(context);
        HashMap hashMap = new HashMap();
        hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
        hashMap.put("_fromPos", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        this.r = e.a(hashMap);
        this.noS = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.adapter.a.1
            @Override // tv.chushou.zues.a
            public void dy(View view) {
                ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                if (chatInfo != null) {
                    com.kascend.chushou.d.a.a(a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.noY.mCreatorUID, a.this.r);
                }
            }
        };
        this.noR = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.adapter.a.2
            @Override // tv.chushou.zues.a
            public void dy(View view) {
                ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                if (chatInfo != null) {
                    if (chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                        if (!chatInfo.mItem.mType.equals("1") || a.this.noY == null || !chatInfo.mItem.mTargetKey.equals(a.this.noY.mRoomID)) {
                            a.this.a(chatInfo.mItem);
                            e.a(a.this.b, chatInfo.mItem, a.this.r);
                            return;
                        }
                        return;
                    }
                    com.kascend.chushou.d.a.a(a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.noY.mCreatorUID, a.this.r);
                }
            }
        };
        this.noT = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.adapter.a.3
            @Override // tv.chushou.zues.a
            public void dy(View view) {
                ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                if (chatInfo != null && chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                    if (!chatInfo.mItem.mType.equals("1") || a.this.noY == null || !chatInfo.mItem.mTargetKey.equals(a.this.noY.mRoomID)) {
                        a.this.a(chatInfo.mItem);
                        e.a(a.this.b, chatInfo.mItem, a.this.r);
                    }
                }
            }
        };
        this.noU = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.adapter.a.4
            @Override // tv.chushou.zues.a
            public void dy(View view) {
                String valueOf = String.valueOf(view.getTag(a.f.tag_position));
                if (!TextUtils.isEmpty(valueOf)) {
                    try {
                        com.kascend.chushou.view.b.a.b(valueOf, a.this.r, a.this.noY.mRoomID).show(((FragmentActivity) context).getSupportFragmentManager(), "emojiDialog");
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.noV = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.adapter.a.5
            @Override // tv.chushou.zues.a
            public void dy(View view) {
                com.kascend.chushou.d.a.a(a.this.b, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol", tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement_title));
            }
        };
        Drawable drawable = tv.chushou.widget.a.c.getDrawable(a.e.zues_default_gift_color);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.m = tv.chushou.zues.utils.a.dip2px(this.b, 21.0f);
        this.l = (intrinsicWidth * this.m) / intrinsicHeight;
        this.o = tv.chushou.zues.utils.a.dip2px(this.b, 21.0f);
        this.n = this.o;
        this.w = tv.chushou.zues.utils.a.dip2px(this.b, 40.0f);
        this.noW = new com.kascend.chushou.toolkit.a(tv.chushou.zues.utils.a.dip2px(this.b, 13.0f));
        this.p = ContextCompat.getColor(this.b, a.c.videoplayer_share_danmaku);
    }

    public void a(int i) {
        this.a = i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.noX == null || i >= this.noX.size() || this.noX.get(i) == null) {
            return 2;
        }
        ChatInfo chatInfo = this.noX.get(i);
        String str = chatInfo.mType;
        if ("-4".equals(str)) {
            return 5;
        }
        if ("-1".equals(str)) {
            return 1;
        }
        if ("3".equals(str)) {
            return chatInfo.giftType == 2 ? 4 : 2;
        }
        return chatInfo.isShare() ? 3 : 2;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
            case 5:
                return new C0827a(this.c.inflate(a.h.view_banrrage_list_header, viewGroup, false));
            case 2:
            default:
                return new C0827a(this.c.inflate(a.h.chat_msg_layout, viewGroup, false));
            case 3:
                return new c(this.c.inflate(a.h.chat_msg_share_layout, viewGroup, false));
            case 4:
                return new b(this.c.inflate(a.h.chat_msg_emoji_layout, viewGroup, false));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        if (h.isEmpty(list)) {
            onBindViewHolder(viewHolder, i);
        } else if (this.noX != null && i < this.noX.size()) {
            if (viewHolder instanceof C0827a) {
                C0827a c0827a = (C0827a) viewHolder;
                String str = this.noX.get(i).mType;
                if (str.equals("1") || str.equals("3")) {
                    ChatInfo chatInfo = this.noX.get(i);
                    if (chatInfo != null && c0827a.npe != null) {
                        c0827a.npe.setTag(a.f.tag_position, chatInfo);
                    }
                } else if (c0827a.npe != null) {
                    c0827a.npe.setOnClickListener(null);
                }
            } else if (viewHolder instanceof c) {
                onBindViewHolder(viewHolder, i);
            } else if (viewHolder instanceof b) {
                onBindViewHolder(viewHolder, i);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        boolean z;
        int i3;
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        if (this.noX != null && i < this.noX.size()) {
            switch (getItemViewType(i)) {
                case 1:
                case 2:
                    String str = this.noX.get(i).mType;
                    final C0827a c0827a = (C0827a) viewHolder;
                    c0827a.npe.setShadowLayer(2.0f, 2.0f, 2.0f, this.b.getResources().getColor(a.c.color_E5000000));
                    char c2 = 65535;
                    switch (str.hashCode()) {
                        case 49:
                            if (str.equals("1")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 50:
                            if (str.equals("2")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 51:
                            if (str.equals("3")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 52:
                            if (str.equals("4")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1444:
                            if (str.equals("-1")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                            if (this.noY != null) {
                                if (h.isEmpty(this.noY.mSystemAnnouncement)) {
                                    cVar.a(this.b.getString(a.i.danmu_list_title, this.noY.mCreatorNickname), new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                } else {
                                    ArrayList<RichText> TQ = tv.chushou.zues.toolkit.richtext.b.TQ(this.noY.mSystemAnnouncement);
                                    if (h.isEmpty(TQ)) {
                                        cVar.a(this.noY.mSystemAnnouncement, new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                    } else {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar, TQ, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0827a.npe, null, null, this.noZ);
                                    }
                                }
                            }
                            c0827a.npe.setText(cVar);
                            c0827a.npe.setOnClickListener(null);
                            c0827a.npe.setBackgroundResource(0);
                            return;
                        case 1:
                            ChatInfo chatInfo = this.noX.get(i);
                            if (chatInfo != null && c0827a.npe != null) {
                                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                                if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                                    d.nnD.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar2, this.x, this.y);
                                }
                                if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 < chatInfo.mPrivilegeInfo.mMedals.size()) {
                                            String str2 = chatInfo.mPrivilegeInfo.mMedals.get(i5);
                                            if (!h.isEmpty(str2)) {
                                                a(c0827a.npe, c0827a, cVar2, str2, a.e.default_medal_icon, this.n, this.o);
                                            }
                                            i4 = i5 + 1;
                                        }
                                    }
                                }
                                if (chatInfo.mCoolMessage != null) {
                                    c0827a.npe.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                                    tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0827a.npe, " : ", this.noW, this.noZ);
                                    int length = cVar2.length();
                                    cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.noS), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                    tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0827a.npe, null, this.noW, this.noZ);
                                    i3 = length;
                                } else {
                                    if (chatInfo.mCoolNickname != null && !h.isEmpty(chatInfo.mCoolNickname.mNickName)) {
                                        ArrayList<String> arrayList3 = new ArrayList<>();
                                        if (this.noZ != null && !h.isEmpty(chatInfo.mCoolNickname.mFontColors)) {
                                            int size = chatInfo.mCoolNickname.mFontColors.size();
                                            for (int i6 = 0; i6 < size; i6++) {
                                                String str3 = this.noZ.get(chatInfo.mCoolNickname.mFontColors.get(i6).toLowerCase());
                                                if (h.isEmpty(str3)) {
                                                    arrayList3.add(chatInfo.mCoolNickname.mFontColors.get(i6));
                                                } else {
                                                    arrayList3.add(str3);
                                                }
                                            }
                                            arrayList2 = arrayList3;
                                        } else {
                                            arrayList2 = chatInfo.mCoolNickname.mFontColors;
                                        }
                                        cVar2.a(chatInfo.mCoolNickname.mNickName + " : ", new c.a().bb(arrayList2).IO(chatInfo.mCoolNickname.mNickName.length()).dEY());
                                    } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0827a.npe, " : ", this.noW, this.noZ)) {
                                        if (this.noZ != null) {
                                            String str4 = this.noZ.get(tv.chushou.zues.utils.a.Ma(this.b.getResources().getColor(a.c.banrrage_chat_name_color)));
                                            if (h.isEmpty(str4)) {
                                                cVar2.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_name_color)));
                                            } else {
                                                cVar2.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(Color.parseColor(str4)));
                                            }
                                        } else {
                                            cVar2.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_name_color)));
                                        }
                                    }
                                    int length2 = cVar2.length();
                                    cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.noS), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                    if (chatInfo.mCoolContent != null && !h.isEmpty(chatInfo.mCoolContent.mContent)) {
                                        CharSequence RZ = this.noW.RZ(chatInfo.mCoolContent.mContent);
                                        ArrayList<String> arrayList4 = new ArrayList<>();
                                        if (this.noZ != null && !h.isEmpty(chatInfo.mCoolContent.mFontColors)) {
                                            int size2 = chatInfo.mCoolContent.mFontColors.size();
                                            for (int i7 = 0; i7 < size2; i7++) {
                                                String str5 = this.noZ.get(chatInfo.mCoolContent.mFontColors.get(i7).toLowerCase());
                                                if (h.isEmpty(str5)) {
                                                    arrayList4.add(chatInfo.mCoolContent.mFontColors.get(i7));
                                                } else {
                                                    arrayList4.add(str5);
                                                }
                                            }
                                            arrayList = arrayList4;
                                        } else {
                                            arrayList = chatInfo.mCoolContent.mFontColors;
                                        }
                                        cVar2.a(RZ, new c.a().bb(arrayList).IO(chatInfo.mCoolContent.mContent.length()).dEY());
                                        i3 = length2;
                                    } else {
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0827a.npe, null, this.noW, this.noZ)) {
                                            if (this.noZ != null) {
                                                String str6 = this.noZ.get(tv.chushou.zues.utils.a.Ma(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                                if (h.isEmpty(str6)) {
                                                    cVar2.a(this.noW.RZ(chatInfo.mContent), new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                                } else {
                                                    cVar2.a(this.noW.RZ(chatInfo.mContent), new ForegroundColorSpan(Color.parseColor(str6)));
                                                }
                                                i3 = length2;
                                            } else {
                                                cVar2.a(this.noW.RZ(chatInfo.mContent), new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                        }
                                        i3 = length2;
                                    }
                                }
                                cVar2.a(new b.c() { // from class: com.kascend.chushou.player.adapter.a.6
                                    @Override // com.facebook.drawee.span.b.c
                                    public void d(com.facebook.drawee.span.b bVar) {
                                        if (c0827a.npe != null) {
                                            c0827a.npe.measure(0, 0);
                                            c0827a.npe.requestLayout();
                                        }
                                    }
                                });
                                cVar2.append(" ");
                                cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.noR), i3, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                c0827a.npe.setDraweeSpanStringBuilder(cVar2);
                                c0827a.npe.setTag(a.f.tag_position, chatInfo);
                                c0827a.npe.setMovementMethod(tv.chushou.zues.widget.a.b.eaG());
                                if (chatInfo.mCoolMessage != null) {
                                    com.kascend.chushou.toolkit.b.a.dOn().a(chatInfo.mCoolMessage.mBgImage, c0827a.npe, a.e.bg_bubble_default);
                                    return;
                                }
                                c0827a.npe.setBackgroundResource(0);
                                c0827a.npe.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                return;
                            }
                            return;
                        case 2:
                        case 3:
                            ChatInfo chatInfo2 = this.noX.get(i);
                            if (chatInfo2 != null && c0827a.npe != null) {
                                c0827a.npe.setTextSize(14.0f);
                                tv.chushou.zues.widget.a.c cVar3 = new tv.chushou.zues.widget.a.c();
                                int i8 = 0;
                                while (true) {
                                    int i9 = i8;
                                    if (i9 < chatInfo2.mPrivilegeInfo.mMedals.size()) {
                                        String str7 = chatInfo2.mPrivilegeInfo.mMedals.get(i9);
                                        if (!h.isEmpty(str7)) {
                                            a(c0827a.npe, c0827a, cVar3, str7, a.e.default_medal_icon, this.n, this.o);
                                        }
                                        i8 = i9 + 1;
                                    } else {
                                        if (chatInfo2.mCoolMessage != null) {
                                            c0827a.npe.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                                            tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0827a.npe, null, this.noW, this.noZ);
                                        } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0827a.npe, null, this.noW, this.noZ)) {
                                            if (this.noZ != null) {
                                                String str8 = this.noZ.get(tv.chushou.zues.utils.a.Ma(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                                if (h.isEmpty(str8)) {
                                                    cVar3.a(chatInfo2.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                                } else {
                                                    cVar3.a(chatInfo2.mContent, new ForegroundColorSpan(Color.parseColor(str8)));
                                                }
                                            } else {
                                                cVar3.a(chatInfo2.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                        }
                                        cVar3.a(new b.c() { // from class: com.kascend.chushou.player.adapter.a.7
                                            @Override // com.facebook.drawee.span.b.c
                                            public void d(com.facebook.drawee.span.b bVar) {
                                                if (c0827a.npe != null) {
                                                    c0827a.npe.measure(0, 0);
                                                    c0827a.npe.requestLayout();
                                                }
                                            }
                                        });
                                        cVar3.setSpan(new tv.chushou.zues.widget.a.a(this.noT), 0, cVar3.length() + (-1) > 0 ? cVar3.length() - 1 : 0, 18);
                                        c0827a.npe.setDraweeSpanStringBuilder(cVar3);
                                        c0827a.npe.setTag(a.f.tag_position, chatInfo2);
                                        c0827a.npe.setMovementMethod(tv.chushou.zues.widget.a.b.eaG());
                                        if (chatInfo2.mCoolMessage != null) {
                                            com.kascend.chushou.toolkit.b.a.dOn().a(chatInfo2.mCoolMessage.mBgImage, c0827a.npe, a.e.bg_bubble_default);
                                            return;
                                        }
                                        c0827a.npe.setBackgroundResource(0);
                                        c0827a.npe.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                        return;
                                    }
                                }
                            } else {
                                return;
                            }
                            break;
                        case 4:
                            ChatInfo chatInfo3 = this.noX.get(i);
                            if (chatInfo3 != null && c0827a.npe != null) {
                                c0827a.npe.setTextSize(14.0f);
                                tv.chushou.zues.widget.a.c cVar4 = new tv.chushou.zues.widget.a.c();
                                if (chatInfo3.mCoolMessage != null) {
                                    c0827a.npe.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                                    tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0827a.npe, " : ", this.noW, this.noZ);
                                    int length3 = cVar4.length();
                                    cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.noS), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                    tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0827a.npe, null, this.noW, this.noZ);
                                    i2 = length3;
                                } else {
                                    if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0827a.npe, null, null, this.noZ)) {
                                        cVar4.a(chatInfo3.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                    } else {
                                        cVar4.a(" : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                    }
                                    int length4 = cVar4.length();
                                    cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.noS), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                    if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0827a.npe, null, null, this.noZ)) {
                                        if (this.noZ != null) {
                                            String str9 = this.noZ.get(tv.chushou.zues.utils.a.Ma(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            if (h.isEmpty(str9)) {
                                                cVar4.a(chatInfo3.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            } else {
                                                cVar4.a(chatInfo3.mContent, new ForegroundColorSpan(Color.parseColor(str9)));
                                            }
                                            i2 = length4;
                                        } else {
                                            cVar4.a(chatInfo3.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                        }
                                    }
                                    i2 = length4;
                                }
                                cVar4.append(" ");
                                if (!h.isEmpty(chatInfo3.mGift.icon)) {
                                    a(c0827a.npe, c0827a, cVar4, chatInfo3.mGift.icon, a.e.zues_default_gift_color, this.l, this.m);
                                }
                                if (chatInfo3.mUserComboCount > 1) {
                                    String valueOf = String.valueOf(chatInfo3.mUserComboCount);
                                    int length5 = valueOf.length();
                                    boolean z2 = false;
                                    int i10 = 0;
                                    while (i10 < length5) {
                                        String substring = valueOf.substring(i10, i10 + 1);
                                        if (this.npa == null) {
                                            this.npa = new HashMap<>();
                                        }
                                        Drawable drawable = null;
                                        if (this.npa.containsKey(substring)) {
                                            drawable = this.npa.get(substring);
                                        }
                                        if (drawable == null) {
                                            drawable = this.b.getResources().getDrawable(this.b.getResources().getIdentifier("icon_combo_" + substring, "drawable", this.b.getPackageName()));
                                            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                            this.npa.put(substring, drawable);
                                        }
                                        Drawable drawable2 = drawable;
                                        if (drawable2 != null) {
                                            z = true;
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable2));
                                        } else {
                                            z = z2;
                                        }
                                        i10++;
                                        z2 = z;
                                    }
                                    if (z2) {
                                        Drawable drawable3 = null;
                                        if (this.npa.containsKey("-1")) {
                                            drawable3 = this.npa.get("-1");
                                        }
                                        if (drawable3 == null) {
                                            drawable3 = this.b.getResources().getDrawable(a.e.icon_combo);
                                            drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
                                            this.npa.put("-1", drawable3);
                                        }
                                        cVar4.a("", new tv.chushou.zues.widget.a.e(drawable3));
                                    }
                                }
                                cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.noR), i2, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 17);
                                c0827a.npe.setDraweeSpanStringBuilder(cVar4);
                                c0827a.npe.setTag(a.f.tag_position, chatInfo3);
                                c0827a.npe.setMovementMethod(tv.chushou.zues.widget.a.b.eaG());
                                c0827a.npe.setFocusable(false);
                                if (chatInfo3.mCoolMessage != null) {
                                    com.kascend.chushou.toolkit.b.a.dOn().a(chatInfo3.mCoolMessage.mBgImage, c0827a.npe, a.e.bg_bubble_default);
                                    return;
                                }
                                c0827a.npe.setBackgroundResource(0);
                                c0827a.npe.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                case 3:
                    ((c) viewHolder).a(this.noX.get(i));
                    return;
                case 4:
                    ((b) viewHolder).a(this.noX.get(i));
                    return;
                case 5:
                    C0827a c0827a2 = (C0827a) viewHolder;
                    c0827a2.npe.setOnClickListener(null);
                    tv.chushou.zues.widget.a.c cVar5 = new tv.chushou.zues.widget.a.c();
                    cVar5.a((CharSequence) tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement), new ForegroundColorSpan(Color.parseColor("#ff5959")), new tv.chushou.zues.widget.a.a(this.noV), new UnderlineSpan());
                    c0827a2.npe.setDraweeSpanStringBuilder(cVar5);
                    c0827a2.npe.setMovementMethod(tv.chushou.zues.widget.a.b.eaG());
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SimpleDraweeSpanTextView simpleDraweeSpanTextView, Drawable.Callback callback, tv.chushou.zues.widget.a.c cVar, String str, int i, int i2, int i3) {
        if (!h.isEmpty(str)) {
            if (e.a(str)) {
                cVar.a("", new b.a().a(callback).xJ(true).KS(i2).KT(i3).Se(str).KR(i).i(simpleDraweeSpanTextView).dON());
                cVar.append(" ");
                return;
            }
            int length = cVar.length();
            com.facebook.drawee.view.b a = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(this.b.getResources()).IL(i).dEN(), this.b);
            a.setController(com.facebook.drawee.a.a.c.dDm().Rt(str).dEd());
            cVar.append("1");
            cVar.a(a, length, length, i2, i3, true, 2);
            cVar.append(" ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ListItem listItem) {
        if (!h.isEmpty(listItem.mUrl) && this.noY != null && !h.isEmpty(this.noY.mRoomID)) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("roomId", this.noY.mRoomID);
            Http http = (Http) tv.chushou.basis.d.b.dZG().S(Http.class);
            if (http != null) {
                listItem.mUrl = http.packParams(listItem.mUrl, hashMap);
            }
        }
    }
}
