package com.kwad.sdk.reward.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ap;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.reward.d implements ap.a {

    /* renamed from: b  reason: collision with root package name */
    public Handler f36959b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f36960c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f36961d;

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f36962e = new BroadcastReceiver() { // from class: com.kwad.sdk.reward.b.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                return;
            }
            Message obtainMessage = a.this.f36959b.obtainMessage(BaseActivity.DIALOG_LOADING);
            obtainMessage.obj = schemeSpecificPart;
            obtainMessage.sendToTarget();
        }
    };

    private void e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        ((com.kwad.sdk.reward.d) this).f37201a.f36956g.registerReceiver(this.f36962e, intentFilter);
    }

    private void f() {
        Activity activity = ((com.kwad.sdk.reward.d) this).f37201a.f36956g;
        if (activity != null) {
            activity.unregisterReceiver(this.f36962e);
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f36960c = com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.reward.d) this).f37201a.f36955f);
        this.f36961d = ((com.kwad.sdk.reward.d) this).f37201a.f36958i;
        this.f36959b = new ap(this);
        e();
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        Object obj;
        if (message.what == 242 && (obj = message.obj) != null && obj.equals(this.f36960c.adBaseInfo.appPackageName)) {
            com.kwad.sdk.reward.a.b bVar = ((com.kwad.sdk.reward.d) this).f37201a.f36951b;
            if (bVar != null) {
                bVar.e();
            }
            this.f36961d.h();
            ((com.kwad.sdk.reward.d) this).f37201a.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        f();
    }
}
