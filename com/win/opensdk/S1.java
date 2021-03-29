package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.fun.openid.sdk.OnGetOaidListener;
/* loaded from: classes7.dex */
public class S1 implements OnGetOaidListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ T1 f39791a;

    public S1(T1 t1) {
        this.f39791a = t1;
    }

    @Override // com.fun.openid.sdk.OnGetOaidListener
    public void onGetOaid(String str) {
        Context context;
        if (!TextUtils.isEmpty(T1.f39809c) || TextUtils.isEmpty(str) || (context = this.f39791a.f39812a) == null) {
            return;
        }
        T1.f39809c = str;
        V1.g(context, str);
    }
}
