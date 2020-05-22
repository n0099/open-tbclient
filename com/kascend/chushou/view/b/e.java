package com.kascend.chushou.view.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.Space;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.MyUserInfo;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.d.h;
import com.kascend.chushou.toolkit.LoginManager;
import tv.chushou.zues.utils.g;
/* loaded from: classes5.dex */
public class e extends com.kascend.chushou.view.base.a {
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private Space mYd;
    private Space mYe;
    private boolean n;
    private String o;
    private String p;
    private String q;

    public static e wF(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("mIsOwn", z);
        e eVar = new e();
        eVar.setArguments(bundle);
        return eVar;
    }

    public static e c(boolean z, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("mIsOwn", z);
        bundle.putString("mNickName", str);
        bundle.putString("mRoomId", str2);
        bundle.putString("mUId", str3);
        e eVar = new e();
        eVar.setArguments(bundle);
        return eVar;
    }

    @Override // com.kascend.chushou.view.base.a, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.n = arguments.getBoolean("mIsOwn");
        this.o = arguments.getString("mNickName");
        this.p = arguments.getString("mRoomId");
        this.q = arguments.getString("mUId");
    }

    @Override // com.kascend.chushou.view.base.a
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.dialog_user_info_copy, viewGroup, false);
        this.e = (LinearLayout) inflate.findViewById(a.f.item_nickname);
        this.f = (LinearLayout) inflate.findViewById(a.f.item_roomid);
        this.g = (LinearLayout) inflate.findViewById(a.f.item_uid);
        this.h = (TextView) this.e.findViewById(a.f.tv_content);
        this.i = (TextView) this.f.findViewById(a.f.tv_content);
        this.j = (TextView) this.g.findViewById(a.f.tv_content);
        this.k = (TextView) this.e.findViewById(a.f.tv_copy);
        this.l = (TextView) this.f.findViewById(a.f.tv_copy);
        this.m = (TextView) this.g.findViewById(a.f.tv_copy);
        this.mYd = (Space) inflate.findViewById(a.f.space_01);
        this.mYe = (Space) inflate.findViewById(a.f.space_02);
        c();
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.a
    public void a(View view) {
        ((TextView) this.e.findViewById(a.f.tv_tag)).setText(this.b.getString(a.i.str_userinfo_nickname));
        ((TextView) this.f.findViewById(a.f.tv_tag)).setText(this.b.getString(a.i.str_userinfo_roomid));
        ((TextView) this.g.findViewById(a.f.tv_tag)).setText(this.b.getString(a.i.str_userinfo_uid));
        if (this.n) {
            a();
        } else {
            a(this.o, this.p, this.q);
        }
    }

    private void c() {
        this.k.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.view.b.e.1
            @Override // tv.chushou.zues.a
            public void dr(View view) {
                g.c(e.this.b, e.this.b.getString(a.i.str_userinfo_copy_result, e.this.b.getString(a.i.str_userinfo_nickname)));
                e.this.a(e.this.h.getText());
            }
        });
        this.l.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.view.b.e.2
            @Override // tv.chushou.zues.a
            public void dr(View view) {
                g.c(e.this.b, e.this.b.getString(a.i.str_userinfo_copy_result, e.this.b.getString(a.i.str_userinfo_roomid)));
                e.this.a(e.this.i.getText());
            }
        });
        this.m.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.view.b.e.3
            @Override // tv.chushou.zues.a
            public void dr(View view) {
                g.c(e.this.b, e.this.b.getString(a.i.str_userinfo_copy_result, e.this.b.getString(a.i.str_userinfo_uid)));
                e.this.a(e.this.j.getText());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence) {
        ((ClipboardManager) this.b.getApplicationContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, charSequence));
        dismiss();
    }

    public void a() {
        String str;
        String str2;
        String str3;
        MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
        if (userInfo == null) {
            str = h.dDZ().c();
            str2 = h.dDZ().b();
        } else {
            str = userInfo.mNickname;
            str2 = userInfo.mUserID;
        }
        if (userInfo != null && userInfo.mRoomInfos != null && userInfo.mRoomInfos.size() > 0) {
            RoomInfo roomInfo = userInfo.mRoomInfos.get(0);
            if (!tv.chushou.zues.utils.h.isEmpty(roomInfo.mRoomID) && !roomInfo.mRoomID.equals("0")) {
                str3 = roomInfo.mRoomID;
                a(str, str3, str2);
            }
        }
        str3 = "";
        a(str, str3, str2);
    }

    public void a(String str, String str2, String str3) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
            this.h.setText(str);
        }
        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
            this.mYd.setVisibility(8);
            this.f.setVisibility(8);
        } else {
            this.mYd.setVisibility(0);
            this.f.setVisibility(0);
            this.i.setText(str2);
        }
        if (tv.chushou.zues.utils.h.isEmpty(str3)) {
            this.mYe.setVisibility(8);
            this.g.setVisibility(8);
            return;
        }
        this.mYe.setVisibility(0);
        this.g.setVisibility(0);
        this.j.setText(str3);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        a(tv.chushou.zues.utils.a.dip2px(this.b, 300.0f), -2);
    }
}
