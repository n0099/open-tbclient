package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.fun.openid.sdk.OnGetOaidListener;
/* loaded from: classes6.dex */
public class p1 implements OnGetOaidListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q1 f37919a;

    public p1(q1 q1Var) {
        this.f37919a = q1Var;
    }

    @Override // com.fun.openid.sdk.OnGetOaidListener
    public void onGetOaid(String str) {
        Context context;
        if (!TextUtils.isEmpty(q1.f37932c) || TextUtils.isEmpty(str) || (context = this.f37919a.f37935a) == null) {
            return;
        }
        q1.f37932c = str;
        s1.g(context, str);
    }
}
