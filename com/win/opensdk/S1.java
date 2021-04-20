package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.fun.openid.sdk.OnGetOaidListener;
/* loaded from: classes7.dex */
public class S1 implements OnGetOaidListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ T1 f40080a;

    public S1(T1 t1) {
        this.f40080a = t1;
    }

    @Override // com.fun.openid.sdk.OnGetOaidListener
    public void onGetOaid(String str) {
        Context context;
        if (!TextUtils.isEmpty(T1.f40098c) || TextUtils.isEmpty(str) || (context = this.f40080a.f40101a) == null) {
            return;
        }
        T1.f40098c = str;
        V1.g(context, str);
    }
}
