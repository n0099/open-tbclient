package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;
/* loaded from: classes7.dex */
public class SocialApi {

    /* renamed from: a  reason: collision with root package name */
    public SocialApiIml f40094a;

    public SocialApi(QQToken qQToken) {
        this.f40094a = new SocialApiIml(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f40094a.ask(activity, bundle, iUiListener);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f40094a.gift(activity, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f40094a.invite(activity, bundle, iUiListener);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f40094a.story(activity, bundle, iUiListener);
    }
}
