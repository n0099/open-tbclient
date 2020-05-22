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
/* loaded from: classes5.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected Context b;
    private LayoutInflater c;
    private final int l;
    private final int m;
    private tv.chushou.zues.a mIU;
    private tv.chushou.zues.a mIV;
    private tv.chushou.zues.a mIW;
    private tv.chushou.zues.a mIX;
    private tv.chushou.zues.a mIY;
    private final tv.chushou.zues.toolkit.richtext.a mIZ;
    private ArrayList<ChatInfo> mJa;
    private RoomInfo mJb;
    private HashMap<String, Drawable> mJd;
    private final int n;
    private final int o;
    private final int p;
    private JSONObject r;
    private final int w;
    protected int a = 0;
    private final int i = 14;
    private final int j = 18;
    private final int k = 5;
    private HashMap<String, String> mJc = new HashMap<>();
    private final int x = tv.chushou.widget.a.c.B(28.0f);
    private final int y = tv.chushou.widget.a.c.B(21.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0797a extends RecyclerView.ViewHolder implements Drawable.Callback {
        SimpleDraweeSpanTextView mJh;

        C0797a(View view) {
            super(view);
            this.mJh = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            if (this.mJh != null && ViewCompat.isAttachedToWindow(this.mJh)) {
                this.mJh.invalidate();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
            if (this.mJh != null) {
                this.mJh.postDelayed(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            if (this.mJh != null) {
                this.mJh.removeCallbacks(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView c;
        private int d;
        private SimpleDraweeSpanTextView mJi;
        private ChatInfo mJm;

        c(View view) {
            super(view);
            this.mJi = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
            this.c = (TextView) view.findViewById(a.f.tv_share_room);
            this.c.setOnClickListener(this);
            this.c.setText(new tv.chushou.zues.widget.a.c().append(a.this.b.getString(a.i.videoplayer_danmaku_share)).J(a.this.b, a.e.videoplayer_danmaku_share_icon));
            String Kx = tv.chushou.zues.utils.a.Kx(a.this.p);
            String str = (String) a.this.mJc.get(Kx);
            this.d = Color.parseColor(h.isEmpty(str) ? Kx : str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.kascend.chushou.player.b dEl;
            JSONObject jSONObject = null;
            if (this.mJm != null && this.mJm.mItem != null) {
                String str = (!(a.this.b instanceof VideoPlayer) || (dEl = ((VideoPlayer) a.this.b).dEl()) == null) ? null : dEl.h;
                if (!h.isEmpty(str)) {
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (JSONException e) {
                    }
                }
                e.a(a.this.b, this.mJm.mItem, jSONObject);
            }
        }

        void a(ChatInfo chatInfo) {
            this.mJm = chatInfo;
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            if (!tv.chushou.zues.toolkit.richtext.b.a(a.this.b, cVar, chatInfo.mContentRichText, 18, this.d, this.mJi, null, a.this.mIZ, a.this.mJc)) {
                cVar.a(chatInfo.mContent, new ForegroundColorSpan(this.d));
            }
            this.mJi.setDraweeSpanStringBuilder(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends RecyclerView.ViewHolder implements Drawable.Callback {
        View a;
        private int e;
        SimpleDraweeSpanTextView mJi;
        EmojiGiftView mJj;

        b(View view) {
            super(view);
            this.e = tv.chushou.widget.a.c.B(21.0f);
            this.a = view;
            this.mJi = (SimpleDraweeSpanTextView) view.findViewById(a.f.tvTitle);
            this.mJj = (EmojiGiftView) view.findViewById(a.f.tvEmoji);
        }

        void a(ChatInfo chatInfo) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                d.mHE.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar, a.this.x, this.e);
            }
            if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                for (int i = 0; i < chatInfo.mPrivilegeInfo.mMedals.size(); i++) {
                    String str = chatInfo.mPrivilegeInfo.mMedals.get(i);
                    if (!h.isEmpty(str)) {
                        a.this.a(this.mJi, this, cVar, str, a.e.default_medal_icon, a.this.n, a.this.o);
                    }
                }
            }
            if (chatInfo.mCoolMessage != null) {
                tv.chushou.zues.toolkit.richtext.b.a(a.this.b, cVar, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(a.this.b, a.c.banrrage_chat_name_color), this.mJi, " : ", a.this.mIZ);
            } else if (!tv.chushou.zues.toolkit.richtext.b.a(a.this.b, cVar, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(a.this.b, a.c.kas_red_n), this.mJi)) {
                cVar.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(a.this.b.getResources().getColor(a.c.kas_red_n)));
            } else {
                cVar.a(" : ", new ForegroundColorSpan(a.this.b.getResources().getColor(a.c.kas_red_n)));
            }
            this.mJi.setMovementMethod(tv.chushou.zues.widget.a.b.dSm());
            cVar.setSpan(new tv.chushou.zues.widget.a.a(a.this.mIU), 0, cVar.length() + (-1) > 0 ? cVar.length() - 1 : 0, 17);
            this.mJi.setTag(a.f.tag_position, chatInfo);
            cVar.a(new b.c() { // from class: com.kascend.chushou.player.adapter.a.b.1
                @Override // com.facebook.drawee.span.b.c
                public void d(com.facebook.drawee.span.b bVar) {
                    if (b.this.mJi != null) {
                        b.this.mJi.measure(0, 0);
                        b.this.mJi.requestLayout();
                    }
                }
            });
            this.mJi.setDraweeSpanStringBuilder(cVar);
            int B = chatInfo.giftDisplayWidth > 0 ? tv.chushou.widget.a.c.B(chatInfo.giftDisplayWidth) : a.this.w;
            int B2 = chatInfo.giftDisplayHeight > 0 ? tv.chushou.widget.a.c.B(chatInfo.giftDisplayHeight) : a.this.w;
            FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) this.mJj.getLayoutParams();
            layoutParams.width = B;
            layoutParams.height = B2;
            this.mJj.setLayoutParams(layoutParams);
            this.mJj.g(chatInfo.mGift.icon, a.c.transparent, B, B2);
            this.mJj.setOnClickListener(a.this.mIX);
            this.mJj.setTag(a.f.tag_position, Integer.valueOf(chatInfo.mGift.id));
            if (chatInfo.mCoolMessage != null && !h.isEmpty(chatInfo.mCoolMessage.mBgImage)) {
                com.kascend.chushou.toolkit.b.a.dFU().a(chatInfo.mCoolMessage.mBgImage, this.a, a.e.bg_bubble_default);
                return;
            }
            this.a.setBackgroundResource(0);
            this.a.setPadding(tv.chushou.zues.utils.a.dip2px(a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(a.this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(a.this.b, 5.0f));
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            if (this.mJi != null && ViewCompat.isAttachedToWindow(this.mJi)) {
                this.mJi.invalidate();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
            if (this.mJi != null) {
                this.mJi.postDelayed(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            if (this.mJi != null) {
                this.mJi.removeCallbacks(runnable);
            }
        }
    }

    public void a() {
        if (this.mJd != null) {
            this.mJd.clear();
            this.mJd = null;
        }
        com.kascend.chushou.toolkit.b.a.b();
    }

    public void a(RoomInfo roomInfo) {
        this.mJb = roomInfo;
        if (this.mJb != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            hashMap.put("_fbroomid", this.mJb.mRoomID);
            this.r = e.a(hashMap);
        }
    }

    public void a(HashMap<String, String> hashMap) {
        if (this.mJc != null) {
            this.mJc.clear();
            this.mJc.putAll(hashMap);
        }
    }

    public a(final Context context, ArrayList<ChatInfo> arrayList) {
        this.b = null;
        this.mJa = arrayList;
        this.b = context;
        this.c = LayoutInflater.from(context);
        HashMap hashMap = new HashMap();
        hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
        hashMap.put("_fromPos", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        this.r = e.a(hashMap);
        this.mIV = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.adapter.a.1
            @Override // tv.chushou.zues.a
            public void dr(View view) {
                ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                if (chatInfo != null) {
                    com.kascend.chushou.d.a.a(a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.mJb.mCreatorUID, a.this.r);
                }
            }
        };
        this.mIU = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.adapter.a.2
            @Override // tv.chushou.zues.a
            public void dr(View view) {
                ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                if (chatInfo != null) {
                    if (chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                        if (!chatInfo.mItem.mType.equals("1") || a.this.mJb == null || !chatInfo.mItem.mTargetKey.equals(a.this.mJb.mRoomID)) {
                            a.this.a(chatInfo.mItem);
                            e.a(a.this.b, chatInfo.mItem, a.this.r);
                            return;
                        }
                        return;
                    }
                    com.kascend.chushou.d.a.a(a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.mJb.mCreatorUID, a.this.r);
                }
            }
        };
        this.mIW = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.adapter.a.3
            @Override // tv.chushou.zues.a
            public void dr(View view) {
                ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                if (chatInfo != null && chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                    if (!chatInfo.mItem.mType.equals("1") || a.this.mJb == null || !chatInfo.mItem.mTargetKey.equals(a.this.mJb.mRoomID)) {
                        a.this.a(chatInfo.mItem);
                        e.a(a.this.b, chatInfo.mItem, a.this.r);
                    }
                }
            }
        };
        this.mIX = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.adapter.a.4
            @Override // tv.chushou.zues.a
            public void dr(View view) {
                String valueOf = String.valueOf(view.getTag(a.f.tag_position));
                if (!TextUtils.isEmpty(valueOf)) {
                    try {
                        com.kascend.chushou.view.b.a.b(valueOf, a.this.r, a.this.mJb.mRoomID).show(((FragmentActivity) context).getSupportFragmentManager(), "emojiDialog");
                    } catch (Exception e) {
                    }
                }
            }
        };
        this.mIY = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.adapter.a.5
            @Override // tv.chushou.zues.a
            public void dr(View view) {
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
        this.mIZ = new com.kascend.chushou.toolkit.a(tv.chushou.zues.utils.a.dip2px(this.b, 13.0f));
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
        if (this.mJa == null || i >= this.mJa.size() || this.mJa.get(i) == null) {
            return 2;
        }
        ChatInfo chatInfo = this.mJa.get(i);
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
                return new C0797a(this.c.inflate(a.h.view_banrrage_list_header, viewGroup, false));
            case 2:
            default:
                return new C0797a(this.c.inflate(a.h.chat_msg_layout, viewGroup, false));
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
        } else if (this.mJa != null && i < this.mJa.size()) {
            if (viewHolder instanceof C0797a) {
                C0797a c0797a = (C0797a) viewHolder;
                String str = this.mJa.get(i).mType;
                if (str.equals("1") || str.equals("3")) {
                    ChatInfo chatInfo = this.mJa.get(i);
                    if (chatInfo != null && c0797a.mJh != null) {
                        c0797a.mJh.setTag(a.f.tag_position, chatInfo);
                    }
                } else if (c0797a.mJh != null) {
                    c0797a.mJh.setOnClickListener(null);
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
        if (this.mJa != null && i < this.mJa.size()) {
            switch (getItemViewType(i)) {
                case 1:
                case 2:
                    String str = this.mJa.get(i).mType;
                    final C0797a c0797a = (C0797a) viewHolder;
                    c0797a.mJh.setShadowLayer(2.0f, 2.0f, 2.0f, this.b.getResources().getColor(a.c.color_E5000000));
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
                            if (this.mJb != null) {
                                if (h.isEmpty(this.mJb.mSystemAnnouncement)) {
                                    cVar.a(this.b.getString(a.i.danmu_list_title, this.mJb.mCreatorNickname), new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                } else {
                                    ArrayList<RichText> Sr = tv.chushou.zues.toolkit.richtext.b.Sr(this.mJb.mSystemAnnouncement);
                                    if (h.isEmpty(Sr)) {
                                        cVar.a(this.mJb.mSystemAnnouncement, new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                    } else {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar, Sr, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0797a.mJh, null, null, this.mJc);
                                    }
                                }
                            }
                            c0797a.mJh.setText(cVar);
                            c0797a.mJh.setOnClickListener(null);
                            c0797a.mJh.setBackgroundResource(0);
                            return;
                        case 1:
                            ChatInfo chatInfo = this.mJa.get(i);
                            if (chatInfo != null && c0797a.mJh != null) {
                                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                                if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                                    d.mHE.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar2, this.x, this.y);
                                }
                                if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 < chatInfo.mPrivilegeInfo.mMedals.size()) {
                                            String str2 = chatInfo.mPrivilegeInfo.mMedals.get(i5);
                                            if (!h.isEmpty(str2)) {
                                                a(c0797a.mJh, c0797a, cVar2, str2, a.e.default_medal_icon, this.n, this.o);
                                            }
                                            i4 = i5 + 1;
                                        }
                                    }
                                }
                                if (chatInfo.mCoolMessage != null) {
                                    c0797a.mJh.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                                    tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0797a.mJh, " : ", this.mIZ, this.mJc);
                                    int length = cVar2.length();
                                    cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.mIV), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                    tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0797a.mJh, null, this.mIZ, this.mJc);
                                    i3 = length;
                                } else {
                                    if (chatInfo.mCoolNickname != null && !h.isEmpty(chatInfo.mCoolNickname.mNickName)) {
                                        ArrayList<String> arrayList3 = new ArrayList<>();
                                        if (this.mJc != null && !h.isEmpty(chatInfo.mCoolNickname.mFontColors)) {
                                            int size = chatInfo.mCoolNickname.mFontColors.size();
                                            for (int i6 = 0; i6 < size; i6++) {
                                                String str3 = this.mJc.get(chatInfo.mCoolNickname.mFontColors.get(i6).toLowerCase());
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
                                        cVar2.a(chatInfo.mCoolNickname.mNickName + " : ", new c.a().aZ(arrayList2).Hk(chatInfo.mCoolNickname.mNickName.length()).dwS());
                                    } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0797a.mJh, " : ", this.mIZ, this.mJc)) {
                                        if (this.mJc != null) {
                                            String str4 = this.mJc.get(tv.chushou.zues.utils.a.Kx(this.b.getResources().getColor(a.c.banrrage_chat_name_color)));
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
                                    cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.mIV), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                    if (chatInfo.mCoolContent != null && !h.isEmpty(chatInfo.mCoolContent.mContent)) {
                                        CharSequence QA = this.mIZ.QA(chatInfo.mCoolContent.mContent);
                                        ArrayList<String> arrayList4 = new ArrayList<>();
                                        if (this.mJc != null && !h.isEmpty(chatInfo.mCoolContent.mFontColors)) {
                                            int size2 = chatInfo.mCoolContent.mFontColors.size();
                                            for (int i7 = 0; i7 < size2; i7++) {
                                                String str5 = this.mJc.get(chatInfo.mCoolContent.mFontColors.get(i7).toLowerCase());
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
                                        cVar2.a(QA, new c.a().aZ(arrayList).Hk(chatInfo.mCoolContent.mContent.length()).dwS());
                                        i3 = length2;
                                    } else {
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0797a.mJh, null, this.mIZ, this.mJc)) {
                                            if (this.mJc != null) {
                                                String str6 = this.mJc.get(tv.chushou.zues.utils.a.Kx(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                                if (h.isEmpty(str6)) {
                                                    cVar2.a(this.mIZ.QA(chatInfo.mContent), new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                                } else {
                                                    cVar2.a(this.mIZ.QA(chatInfo.mContent), new ForegroundColorSpan(Color.parseColor(str6)));
                                                }
                                                i3 = length2;
                                            } else {
                                                cVar2.a(this.mIZ.QA(chatInfo.mContent), new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                        }
                                        i3 = length2;
                                    }
                                }
                                cVar2.a(new b.c() { // from class: com.kascend.chushou.player.adapter.a.6
                                    @Override // com.facebook.drawee.span.b.c
                                    public void d(com.facebook.drawee.span.b bVar) {
                                        if (c0797a.mJh != null) {
                                            c0797a.mJh.measure(0, 0);
                                            c0797a.mJh.requestLayout();
                                        }
                                    }
                                });
                                cVar2.append(" ");
                                cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.mIU), i3, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                c0797a.mJh.setDraweeSpanStringBuilder(cVar2);
                                c0797a.mJh.setTag(a.f.tag_position, chatInfo);
                                c0797a.mJh.setMovementMethod(tv.chushou.zues.widget.a.b.dSm());
                                if (chatInfo.mCoolMessage != null) {
                                    com.kascend.chushou.toolkit.b.a.dFU().a(chatInfo.mCoolMessage.mBgImage, c0797a.mJh, a.e.bg_bubble_default);
                                    return;
                                }
                                c0797a.mJh.setBackgroundResource(0);
                                c0797a.mJh.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                return;
                            }
                            return;
                        case 2:
                        case 3:
                            ChatInfo chatInfo2 = this.mJa.get(i);
                            if (chatInfo2 != null && c0797a.mJh != null) {
                                c0797a.mJh.setTextSize(14.0f);
                                tv.chushou.zues.widget.a.c cVar3 = new tv.chushou.zues.widget.a.c();
                                int i8 = 0;
                                while (true) {
                                    int i9 = i8;
                                    if (i9 < chatInfo2.mPrivilegeInfo.mMedals.size()) {
                                        String str7 = chatInfo2.mPrivilegeInfo.mMedals.get(i9);
                                        if (!h.isEmpty(str7)) {
                                            a(c0797a.mJh, c0797a, cVar3, str7, a.e.default_medal_icon, this.n, this.o);
                                        }
                                        i8 = i9 + 1;
                                    } else {
                                        if (chatInfo2.mCoolMessage != null) {
                                            c0797a.mJh.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                                            tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0797a.mJh, null, this.mIZ, this.mJc);
                                        } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0797a.mJh, null, this.mIZ, this.mJc)) {
                                            if (this.mJc != null) {
                                                String str8 = this.mJc.get(tv.chushou.zues.utils.a.Kx(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
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
                                                if (c0797a.mJh != null) {
                                                    c0797a.mJh.measure(0, 0);
                                                    c0797a.mJh.requestLayout();
                                                }
                                            }
                                        });
                                        cVar3.setSpan(new tv.chushou.zues.widget.a.a(this.mIW), 0, cVar3.length() + (-1) > 0 ? cVar3.length() - 1 : 0, 18);
                                        c0797a.mJh.setDraweeSpanStringBuilder(cVar3);
                                        c0797a.mJh.setTag(a.f.tag_position, chatInfo2);
                                        c0797a.mJh.setMovementMethod(tv.chushou.zues.widget.a.b.dSm());
                                        if (chatInfo2.mCoolMessage != null) {
                                            com.kascend.chushou.toolkit.b.a.dFU().a(chatInfo2.mCoolMessage.mBgImage, c0797a.mJh, a.e.bg_bubble_default);
                                            return;
                                        }
                                        c0797a.mJh.setBackgroundResource(0);
                                        c0797a.mJh.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                        return;
                                    }
                                }
                            } else {
                                return;
                            }
                            break;
                        case 4:
                            ChatInfo chatInfo3 = this.mJa.get(i);
                            if (chatInfo3 != null && c0797a.mJh != null) {
                                c0797a.mJh.setTextSize(14.0f);
                                tv.chushou.zues.widget.a.c cVar4 = new tv.chushou.zues.widget.a.c();
                                if (chatInfo3.mCoolMessage != null) {
                                    c0797a.mJh.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                                    tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0797a.mJh, " : ", this.mIZ, this.mJc);
                                    int length3 = cVar4.length();
                                    cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.mIV), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                    tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0797a.mJh, null, this.mIZ, this.mJc);
                                    i2 = length3;
                                } else {
                                    if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0797a.mJh, null, null, this.mJc)) {
                                        cVar4.a(chatInfo3.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                    } else {
                                        cVar4.a(" : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                    }
                                    int length4 = cVar4.length();
                                    cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.mIV), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                    if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0797a.mJh, null, null, this.mJc)) {
                                        if (this.mJc != null) {
                                            String str9 = this.mJc.get(tv.chushou.zues.utils.a.Kx(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
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
                                    a(c0797a.mJh, c0797a, cVar4, chatInfo3.mGift.icon, a.e.zues_default_gift_color, this.l, this.m);
                                }
                                if (chatInfo3.mUserComboCount > 1) {
                                    String valueOf = String.valueOf(chatInfo3.mUserComboCount);
                                    int length5 = valueOf.length();
                                    boolean z2 = false;
                                    int i10 = 0;
                                    while (i10 < length5) {
                                        String substring = valueOf.substring(i10, i10 + 1);
                                        if (this.mJd == null) {
                                            this.mJd = new HashMap<>();
                                        }
                                        Drawable drawable = null;
                                        if (this.mJd.containsKey(substring)) {
                                            drawable = this.mJd.get(substring);
                                        }
                                        if (drawable == null) {
                                            drawable = this.b.getResources().getDrawable(this.b.getResources().getIdentifier("icon_combo_" + substring, "drawable", this.b.getPackageName()));
                                            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                            this.mJd.put(substring, drawable);
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
                                        if (this.mJd.containsKey("-1")) {
                                            drawable3 = this.mJd.get("-1");
                                        }
                                        if (drawable3 == null) {
                                            drawable3 = this.b.getResources().getDrawable(a.e.icon_combo);
                                            drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
                                            this.mJd.put("-1", drawable3);
                                        }
                                        cVar4.a("", new tv.chushou.zues.widget.a.e(drawable3));
                                    }
                                }
                                cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.mIU), i2, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 17);
                                c0797a.mJh.setDraweeSpanStringBuilder(cVar4);
                                c0797a.mJh.setTag(a.f.tag_position, chatInfo3);
                                c0797a.mJh.setMovementMethod(tv.chushou.zues.widget.a.b.dSm());
                                c0797a.mJh.setFocusable(false);
                                if (chatInfo3.mCoolMessage != null) {
                                    com.kascend.chushou.toolkit.b.a.dFU().a(chatInfo3.mCoolMessage.mBgImage, c0797a.mJh, a.e.bg_bubble_default);
                                    return;
                                }
                                c0797a.mJh.setBackgroundResource(0);
                                c0797a.mJh.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                case 3:
                    ((c) viewHolder).a(this.mJa.get(i));
                    return;
                case 4:
                    ((b) viewHolder).a(this.mJa.get(i));
                    return;
                case 5:
                    C0797a c0797a2 = (C0797a) viewHolder;
                    c0797a2.mJh.setOnClickListener(null);
                    tv.chushou.zues.widget.a.c cVar5 = new tv.chushou.zues.widget.a.c();
                    cVar5.a((CharSequence) tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement), new ForegroundColorSpan(Color.parseColor("#ff5959")), new tv.chushou.zues.widget.a.a(this.mIY), new UnderlineSpan());
                    c0797a2.mJh.setDraweeSpanStringBuilder(cVar5);
                    c0797a2.mJh.setMovementMethod(tv.chushou.zues.widget.a.b.dSm());
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
                cVar.a("", new b.a().a(callback).wH(true).Jp(i2).Jq(i3).QF(str).Jo(i).g(simpleDraweeSpanTextView).dGu());
                cVar.append(" ");
                return;
            }
            int length = cVar.length();
            com.facebook.drawee.view.b a = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(this.b.getResources()).Hh(i).dwG(), this.b);
            a.setController(com.facebook.drawee.a.a.c.dvf().PU(str).dvW());
            cVar.append("1");
            cVar.a(a, length, length, i2, i3, true, 2);
            cVar.append(" ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ListItem listItem) {
        if (!h.isEmpty(listItem.mUrl) && this.mJb != null && !h.isEmpty(this.mJb.mRoomID)) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("roomId", this.mJb.mRoomID);
            Http http = (Http) tv.chushou.basis.d.b.dRm().S(Http.class);
            if (http != null) {
                listItem.mUrl = http.packParams(listItem.mUrl, hashMap);
            }
        }
    }
}
