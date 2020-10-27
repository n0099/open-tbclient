package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;
/* loaded from: classes6.dex */
public class SocialApi {

    /* renamed from: a  reason: collision with root package name */
    private SocialApiIml f4565a;

    public SocialApi(QQToken qQToken) {
        this.f4565a = new SocialApiIml(qQToken);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f4565a.invite(activity, bundle, iUiListener);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f4565a.story(activity, bundle, iUiListener);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f4565a.gift(activity, bundle, iUiListener);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f4565a.ask(activity, bundle, iUiListener);
    }
}
