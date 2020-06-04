package com.kascend.chushou.view.b.b;

import android.os.Bundle;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import com.facebook.drawee.span.b;
import com.google.android.flexbox.FlexboxLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.i;
import com.kascend.chushou.bean.UserCard;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.constants.PrivilegeInfo;
import com.kascend.chushou.d.e;
import com.kascend.chushou.d.f;
import com.kascend.chushou.toolkit.LoginManager;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import tv.chushou.widget.a.c;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
@h
/* loaded from: classes5.dex */
public final class a extends com.kascend.chushou.view.base.a implements View.OnClickListener {
    public static final C0820a mZf = new C0820a(null);
    private boolean e;
    private boolean f;
    private HashMap h;
    private com.kascend.chushou.view.b.b.b mZd;
    private final DecimalFormat mZe = new DecimalFormat("#.#");

    public View Jf(int i) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        View view = (View) this.h.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            View findViewById = view2.findViewById(i);
            this.h.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public void c() {
        if (this.h != null) {
            this.h.clear();
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    @h
    /* renamed from: com.kascend.chushou.view.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0820a {
        private C0820a() {
        }

        public /* synthetic */ C0820a(o oVar) {
            this();
        }

        public final a a(String str, String str2, String str3, boolean z, boolean z2) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putString("targetUid", str);
            if (str2 != null) {
                bundle.putString("roomId", str2);
            }
            String str4 = str3;
            if (!(str4 == null || str4.length() == 0)) {
                bundle.putString("nickname", str3);
            }
            bundle.putBoolean("inLivePage", z);
            bundle.putBoolean("showAt", z2);
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    @Override // com.kascend.chushou.view.base.a, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String str = (arguments == null || (str = arguments.getString("targetUid")) == null) ? "" : "";
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("roomId") : null;
        Bundle arguments3 = getArguments();
        String string2 = arguments3 != null ? arguments3.getString("nickname") : null;
        Bundle arguments4 = getArguments();
        this.e = arguments4 != null ? arguments4.getBoolean("inLivePage", false) : false;
        Bundle arguments5 = getArguments();
        this.f = arguments5 != null ? arguments5.getBoolean("showAt", false) : false;
        this.mZd = new com.kascend.chushou.view.b.b.b(str, string, string2);
        setStyle(1, a.j.cs_usercard_dialog);
    }

    @Override // com.kascend.chushou.view.base.a
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        q.m(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(a.h.dialog_user_info1, viewGroup, false);
        q.l((Object) inflate, "inflater.inflate(R.layou…_info1, container, false)");
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        q.m(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) Jf(a.f.tvReport);
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = (TextView) Jf(a.f.tvAt);
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        TextView textView3 = (TextView) Jf(a.f.tvSubscribe);
        if (textView3 != null) {
            textView3.setOnClickListener(this);
        }
        FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) Jf(a.f.ivAvatar);
        if (frescoThumbnailView != null) {
            frescoThumbnailView.setOnClickListener(this);
        }
        com.kascend.chushou.view.b.b.b bVar = this.mZd;
        if (bVar != null) {
            bVar.a((com.kascend.chushou.view.b.b.b) this);
        }
        com.kascend.chushou.view.b.b.b bVar2 = this.mZd;
        if (bVar2 != null) {
            bVar2.d();
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        a(-1, -2, 80, a.j.share_dialog_animation);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        com.kascend.chushou.view.b.b.b bVar = this.mZd;
        if (bVar != null) {
            bVar.a();
        }
        super.onDestroy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kascend.chushou.view.b.b.b bVar;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i = a.f.ivAvatar;
        if (valueOf == null || valueOf.intValue() != i) {
            int i2 = a.f.tvReport;
            if (valueOf != null && valueOf.intValue() == i2) {
                if (e.c(getActivity(), null)) {
                    d();
                    return;
                }
                return;
            }
            int i3 = a.f.tvAt;
            if (valueOf != null && valueOf.intValue() == i3) {
                e();
                return;
            }
            int i4 = a.f.tvSubscribe;
            if (valueOf != null && valueOf.intValue() == i4 && (bVar = this.mZd) != null) {
                bVar.e();
            }
        }
    }

    public final void a() {
        TextView textView = (TextView) Jf(a.f.tvReport);
        if (textView != null) {
            textView.setVisibility(8);
        }
        ((FrescoThumbnailView) Jf(a.f.ivAvatar)).yG(c.dRP());
        ImageView imageView = (ImageView) Jf(a.f.ivGender);
        if (imageView != null) {
            imageView.setImageResource(c.Sn(null));
        }
        String string = c.getString(a.i.profile_failture_str);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) Jf(a.f.tvNickName);
        if (simpleDraweeSpanTextView != null) {
            simpleDraweeSpanTextView.setText(string);
        }
        TextView textView2 = (TextView) Jf(a.f.tvSignature);
        if (textView2 != null) {
            textView2.setText(string);
        }
        FlexboxLayout flexboxLayout = (FlexboxLayout) Jf(a.f.flexMedal);
        if (flexboxLayout != null) {
            flexboxLayout.setVisibility(8);
        }
        TextView textView3 = (TextView) Jf(a.f.tvFans);
        if (textView3 != null) {
            textView3.setText(string);
        }
        TextView textView4 = (TextView) Jf(a.f.tvSubscribers);
        if (textView4 != null) {
            textView4.setText(string);
        }
        TextView textView5 = (TextView) Jf(a.f.tvGifts);
        if (textView5 != null) {
            textView5.setText(string);
        }
        TextView textView6 = (TextView) Jf(a.f.tvReport);
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) Jf(a.f.llBottomBtn);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = (LinearLayout) Jf(a.f.llBottomContent);
        q.l((Object) linearLayout2, "llBottomContent");
        ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = c.B(22.0f);
        LinearLayout linearLayout3 = (LinearLayout) Jf(a.f.llBottomContent);
        q.l((Object) linearLayout3, "llBottomContent");
        linearLayout3.setLayoutParams(marginLayoutParams);
    }

    public final void a(UserCard userCard) {
        UserCard.UserCardMeta meta;
        UserCard.UserCardMeta meta2;
        UserCard.UserCardMeta meta3;
        UserCard.UserCardMeta meta4;
        List<String> hiddenList;
        UserCard.UserCardMeta meta5;
        UserCard.UserCardMeta meta6;
        List<String> hiddenList2;
        UserCard.UserCardMeta meta7;
        UserCard.UserCardMeta meta8;
        List<String> hiddenList3;
        UserCard.UserCardMeta meta9;
        UserCard.UserCardMeta meta10;
        q.m(userCard, "card");
        FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) Jf(a.f.ivAvatar);
        if (frescoThumbnailView != null) {
            UserCard.UserCardInfo userCardInfo = userCard.getUserCardInfo();
            frescoThumbnailView.i(userCardInfo != null ? userCardInfo.getAvatar() : null, c.dRP(), b.C0924b.nQi, b.C0924b.nQi);
        }
        ImageView imageView = (ImageView) Jf(a.f.ivGender);
        if (imageView != null) {
            UserCard.UserCardInfo userCardInfo2 = userCard.getUserCardInfo();
            imageView.setImageResource(c.Sn(userCardInfo2 != null ? userCardInfo2.getGender() : null));
        }
        ImageView imageView2 = (ImageView) Jf(a.f.ivGender);
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
        UserCard.UserCardInfo userCardInfo3 = userCard.getUserCardInfo();
        cVar.append(userCardInfo3 != null ? userCardInfo3.getNickname() : null);
        UserCard.UserCardInfo userCardInfo4 = userCard.getUserCardInfo();
        a(this, cVar, (userCardInfo4 == null || (meta10 = userCardInfo4.getMeta()) == null) ? null : meta10.getNobleMedal(), 0, 4, null);
        UserCard.UserCardInfo userCardInfo5 = userCard.getUserCardInfo();
        a(this, cVar, userCardInfo5 != null ? userCardInfo5.getLevelMedal() : null, 0, 4, null);
        cVar.a(new b());
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) Jf(a.f.tvNickName);
        if (simpleDraweeSpanTextView != null) {
            simpleDraweeSpanTextView.setText(cVar);
        }
        TextView textView = (TextView) Jf(a.f.tvSignature);
        if (textView != null) {
            UserCard.UserCardInfo userCardInfo6 = userCard.getUserCardInfo();
            textView.setText(f.b(userCardInfo6 != null ? userCardInfo6.getSignature() : null, a.i.profile_default_autograph));
        }
        UserCard.UserCardInfo userCardInfo7 = userCard.getUserCardInfo();
        List<UserCard.Medal> medalList = (userCardInfo7 == null || (meta9 = userCardInfo7.getMeta()) == null) ? null : meta9.getMedalList();
        if (tv.chushou.zues.utils.h.isEmpty(medalList)) {
            FlexboxLayout flexboxLayout = (FlexboxLayout) Jf(a.f.flexMedal);
            if (flexboxLayout != null) {
                flexboxLayout.setVisibility(8);
            }
        } else {
            ((FlexboxLayout) Jf(a.f.flexMedal)).removeAllViews();
            FlexboxLayout flexboxLayout2 = (FlexboxLayout) Jf(a.f.flexMedal);
            q.l((Object) flexboxLayout2, "flexMedal");
            flexboxLayout2.setVisibility(0);
            if (medalList == null) {
                q.dMa();
            }
            for (UserCard.Medal medal : medalList) {
                View inflate = getLayoutInflater().inflate(a.h.view_medal_card, (ViewGroup) ((FlexboxLayout) Jf(a.f.flexMedal)), false);
                if (inflate == null) {
                    throw new TypeCastException("null cannot be cast to non-null type tv.chushou.zues.widget.fresco.FrescoThumbnailView");
                }
                FrescoThumbnailView frescoThumbnailView2 = (FrescoThumbnailView) inflate;
                frescoThumbnailView2.setAnim(true);
                frescoThumbnailView2.a(medal.getUrl(), a.e.ic_default_medal, b.C0924b.small, b.C0924b.small, 1);
                FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(frescoThumbnailView2.getLayoutParams());
                layoutParams.setFlexShrink(0.0f);
                ((FlexboxLayout) Jf(a.f.flexMedal)).addView(frescoThumbnailView2, layoutParams);
            }
        }
        UserCard.UserCardInfo userCardInfo8 = userCard.getUserCardInfo();
        if (userCardInfo8 == null || (meta8 = userCardInfo8.getMeta()) == null || (hiddenList3 = meta8.getHiddenList()) == null || !hiddenList3.contains("fansCount")) {
            TextView textView2 = (TextView) Jf(a.f.tvFans);
            if (textView2 != null) {
                UserCard.UserCardInfo userCardInfo9 = userCard.getUserCardInfo();
                textView2.setText(fX((userCardInfo9 == null || (meta7 = userCardInfo9.getMeta()) == null) ? 0L : meta7.getFansCount()));
            }
        } else {
            TextView textView3 = (TextView) Jf(a.f.tvFans);
            if (textView3 != null) {
                textView3.setText(c.getString(a.i.user_space_private));
            }
        }
        UserCard.UserCardInfo userCardInfo10 = userCard.getUserCardInfo();
        if (userCardInfo10 == null || (meta6 = userCardInfo10.getMeta()) == null || (hiddenList2 = meta6.getHiddenList()) == null || !hiddenList2.contains("idolsCount")) {
            TextView textView4 = (TextView) Jf(a.f.tvSubscribers);
            if (textView4 != null) {
                UserCard.UserCardInfo userCardInfo11 = userCard.getUserCardInfo();
                textView4.setText(fX((userCardInfo11 == null || (meta5 = userCardInfo11.getMeta()) == null) ? 0L : meta5.getIdolsCount()));
            }
        } else {
            TextView textView5 = (TextView) Jf(a.f.tvSubscribers);
            if (textView5 != null) {
                textView5.setText(c.getString(a.i.user_space_private));
            }
        }
        UserCard.UserCardInfo userCardInfo12 = userCard.getUserCardInfo();
        if (userCardInfo12 == null || (meta4 = userCardInfo12.getMeta()) == null || (hiddenList = meta4.getHiddenList()) == null || !hiddenList.contains("giftPointCount")) {
            TextView textView6 = (TextView) Jf(a.f.tvGifts);
            if (textView6 != null) {
                UserCard.UserCardInfo userCardInfo13 = userCard.getUserCardInfo();
                textView6.setText(fX((userCardInfo13 == null || (meta3 = userCardInfo13.getMeta()) == null) ? 0L : meta3.getGiftPointCount()));
            }
        } else {
            TextView textView7 = (TextView) Jf(a.f.tvGifts);
            if (textView7 != null) {
                textView7.setText(c.getString(a.i.user_space_private));
            }
        }
        TextView textView8 = (TextView) Jf(a.f.tvAt);
        if (textView8 != null) {
            textView8.setText("@TA");
        }
        TextView textView9 = (TextView) Jf(a.f.tvAt);
        if (textView9 != null) {
            textView9.setEnabled(true);
        }
        String managerLevel = userCard.getManagerLevel();
        UserCard.UserCardInfo userCardInfo14 = userCard.getUserCardInfo();
        String managerLevel2 = (userCardInfo14 == null || (meta2 = userCardInfo14.getMeta()) == null) ? null : meta2.getManagerLevel();
        LoginManager Instance = LoginManager.Instance();
        com.kascend.chushou.view.b.b.b bVar = this.mZd;
        if (Instance.isMySelf(bVar != null ? bVar.f() : null)) {
            TextView textView10 = (TextView) Jf(a.f.tvReport);
            if (textView10 != null) {
                textView10.setVisibility(8);
            }
        } else if (q.l((Object) managerLevel2, (Object) "3")) {
            TextView textView11 = (TextView) Jf(a.f.tvReport);
            if (textView11 != null) {
                textView11.setVisibility(8);
            }
        } else if (q.l((Object) managerLevel, (Object) "3") || q.l((Object) managerLevel, (Object) "2") || q.l((Object) managerLevel, (Object) "1")) {
            TextView textView12 = (TextView) Jf(a.f.tvReport);
            if (textView12 != null) {
                textView12.setVisibility(0);
            }
            TextView textView13 = (TextView) Jf(a.f.tvReport);
            if (textView13 != null) {
                textView13.setText(c.getString(a.i.str_manage));
            }
        } else if (q.l((Object) managerLevel, (Object) "0")) {
            TextView textView14 = (TextView) Jf(a.f.tvReport);
            if (textView14 != null) {
                textView14.setVisibility(0);
            }
            TextView textView15 = (TextView) Jf(a.f.tvReport);
            if (textView15 != null) {
                textView15.setText(c.getString(a.i.str_report));
            }
        } else {
            TextView textView16 = (TextView) Jf(a.f.tvReport);
            if (textView16 != null) {
                textView16.setVisibility(8);
            }
        }
        UserCard.UserCardInfo userCardInfo15 = userCard.getUserCardInfo();
        if (userCardInfo15 == null || (meta = userCardInfo15.getMeta()) == null || meta.isSDKUser()) {
            LinearLayout linearLayout = (LinearLayout) Jf(a.f.llBottomBtn);
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = (LinearLayout) Jf(a.f.llBottomContent);
            q.l((Object) linearLayout2, "llBottomContent");
            ViewGroup.LayoutParams layoutParams2 = linearLayout2.getLayoutParams();
            if (layoutParams2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams.bottomMargin = c.B(22.0f);
            LinearLayout linearLayout3 = (LinearLayout) Jf(a.f.llBottomContent);
            q.l((Object) linearLayout3, "llBottomContent");
            linearLayout3.setLayoutParams(marginLayoutParams);
            return;
        }
        LinearLayout linearLayout4 = (LinearLayout) Jf(a.f.llBottomContent);
        q.l((Object) linearLayout4, "llBottomContent");
        ViewGroup.LayoutParams layoutParams3 = linearLayout4.getLayoutParams();
        if (layoutParams3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams3;
        LoginManager Instance2 = LoginManager.Instance();
        com.kascend.chushou.view.b.b.b bVar2 = this.mZd;
        boolean isMySelf = Instance2.isMySelf(bVar2 != null ? bVar2.f() : null);
        if (!this.f && isMySelf) {
            LinearLayout linearLayout5 = (LinearLayout) Jf(a.f.llBottomBtn);
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
            marginLayoutParams2.bottomMargin = c.B(22.0f);
            LinearLayout linearLayout6 = (LinearLayout) Jf(a.f.llBottomContent);
            q.l((Object) linearLayout6, "llBottomContent");
            linearLayout6.setLayoutParams(marginLayoutParams2);
            return;
        }
        LinearLayout linearLayout7 = (LinearLayout) Jf(a.f.llBottomBtn);
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(0);
        }
        marginLayoutParams2.bottomMargin = c.B(0.0f);
        LinearLayout linearLayout8 = (LinearLayout) Jf(a.f.llBottomContent);
        q.l((Object) linearLayout8, "llBottomContent");
        linearLayout8.setLayoutParams(marginLayoutParams2);
        TextView textView17 = (TextView) Jf(a.f.tvAt);
        if (textView17 != null) {
            textView17.setVisibility(this.f ? 0 : 8);
        }
        if (isMySelf) {
            TextView textView18 = (TextView) Jf(a.f.tvSubscribe);
            if (textView18 != null) {
                textView18.setVisibility(8);
            }
            a(userCard.getUserCardInfo().getMeta().isSubscribed());
            return;
        }
        TextView textView19 = (TextView) Jf(a.f.tvSubscribe);
        if (textView19 != null) {
            textView19.setVisibility(0);
        }
        a(userCard.getUserCardInfo().getMeta().isSubscribed());
    }

    @h
    /* loaded from: classes5.dex */
    static final class b implements b.c {
        b() {
        }

        @Override // com.facebook.drawee.span.b.c
        public final void d(com.facebook.drawee.span.b bVar) {
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) a.this.Jf(a.f.tvNickName);
            if (simpleDraweeSpanTextView != null) {
                simpleDraweeSpanTextView.measure(0, 0);
            }
            SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = (SimpleDraweeSpanTextView) a.this.Jf(a.f.tvNickName);
            if (simpleDraweeSpanTextView2 != null) {
                simpleDraweeSpanTextView2.requestLayout();
            }
        }
    }

    static /* bridge */ /* synthetic */ void a(a aVar, tv.chushou.zues.widget.a.c cVar, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = a.d.user_level_icon_height;
        }
        aVar.a(cVar, str, i);
    }

    private final void a(tv.chushou.zues.widget.a.c cVar, String str, int i) {
        if (!tv.chushou.zues.utils.h.isEmpty(str)) {
            cVar.append(" ");
            int length = cVar.length();
            com.facebook.drawee.view.b a = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(getResources()).Hj(com.kascend.chushou.view.a.a()).dwU(), this.b);
            com.facebook.drawee.controller.a dwg = com.facebook.drawee.a.a.c.dvt().PV(str).wc(true).dwk();
            q.l((Object) dwg, "Fresco.newDraweeControll…yAnimations(true).build()");
            q.l((Object) a, "medalDraweeHolder");
            a.setController(dwg);
            cVar.append("1");
            int Kr = c.Kr(i);
            cVar.a(a, length, length, Kr, Kr, true, 2);
        }
    }

    public final void a(boolean z) {
        TextView textView = (TextView) Jf(a.f.tvSubscribe);
        if (textView != null) {
            textView.setEnabled(true);
        }
        if (z) {
            TextView textView2 = (TextView) Jf(a.f.tvSubscribe);
            if (textView2 != null) {
                textView2.setBackgroundResource(a.e.cs_bg_user_card_at);
            }
            TextView textView3 = (TextView) Jf(a.f.tvSubscribe);
            if (textView3 != null) {
                textView3.setText(a.i.str_attracted);
                return;
            }
            return;
        }
        TextView textView4 = (TextView) Jf(a.f.tvSubscribe);
        if (textView4 != null) {
            textView4.setBackgroundResource(a.e.cs_bg_user_card_subscribe);
        }
        TextView textView5 = (TextView) Jf(a.f.tvSubscribe);
        if (textView5 != null) {
            textView5.setText(a.i.str_attention);
        }
    }

    private final void d() {
        UserCard dGt;
        UserCard.UserCardMeta meta;
        UserCard.UserCardMeta meta2;
        String str = null;
        com.kascend.chushou.view.b.b.b bVar = this.mZd;
        if (bVar != null && (dGt = bVar.dGt()) != null) {
            ChatInfo chatInfo = new ChatInfo();
            UserCard.UserCardInfo userCardInfo = dGt.getUserCardInfo();
            chatInfo.mUserNickname = userCardInfo != null ? userCardInfo.getNickname() : null;
            UserCard.UserCardInfo userCardInfo2 = dGt.getUserCardInfo();
            chatInfo.mUserID = userCardInfo2 != null ? userCardInfo2.getUid() : null;
            com.kascend.chushou.view.b.b.b bVar2 = this.mZd;
            chatInfo.mRoomID = bVar2 != null ? bVar2.g() : null;
            UserCard.UserCardInfo userCardInfo3 = dGt.getUserCardInfo();
            String managerLevel = (userCardInfo3 == null || (meta2 = userCardInfo3.getMeta()) == null) ? null : meta2.getManagerLevel();
            if (!(managerLevel == null || managerLevel.length() == 0)) {
                PrivilegeInfo privilegeInfo = chatInfo.mPrivilegeInfo;
                UserCard.UserCardInfo userCardInfo4 = dGt.getUserCardInfo();
                if (userCardInfo4 != null && (meta = userCardInfo4.getMeta()) != null) {
                    str = meta.getManagerLevel();
                }
                privilegeInfo.mRole = str;
            }
            com.kascend.chushou.player.a.f fVar = new com.kascend.chushou.player.a.f(getActivity());
            fVar.a(chatInfo, dGt.getManagerLevel(), this.e);
            fVar.show();
        }
    }

    private final void e() {
        com.kascend.chushou.view.b.b.b bVar;
        UserCard dGt;
        UserCard.UserCardInfo userCardInfo;
        if (this.e && (bVar = this.mZd) != null && (dGt = bVar.dGt()) != null && (userCardInfo = dGt.getUserCardInfo()) != null) {
            tv.chushou.zues.a.a.post(new i(3, userCardInfo));
            dismissAllowingStateLoss();
        }
    }

    private final tv.chushou.zues.widget.a.c fX(long j) {
        tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
        int aQ = (int) c.aQ(12.0f);
        int aQ2 = (int) c.aQ(30.0f);
        if (j < 10000) {
            tv.chushou.zues.widget.a.c a = cVar.a(String.valueOf(j), new AbsoluteSizeSpan(aQ2));
            q.l((Object) a, "sp.append(num.toString(), AbsoluteSizeSpan(big))");
            return a;
        } else if (j < 100000000) {
            tv.chushou.zues.widget.a.c a2 = cVar.a(this.mZe.format((j * 1.0d) / 10000), new AbsoluteSizeSpan(aQ2)).a(c.getString(a.i.zues_str_wan), new AbsoluteSizeSpan(aQ));
            q.l((Object) a2, "sp.append(df.format(size… AbsoluteSizeSpan(small))");
            return a2;
        } else {
            tv.chushou.zues.widget.a.c a3 = cVar.a(this.mZe.format((j * 1.0d) / 100000000), new AbsoluteSizeSpan(aQ2)).a(c.getString(a.i.zues_str_yi), new AbsoluteSizeSpan(aQ));
            q.l((Object) a3, "sp.append(df.format(size… AbsoluteSizeSpan(small))");
            return a3;
        }
    }
}
