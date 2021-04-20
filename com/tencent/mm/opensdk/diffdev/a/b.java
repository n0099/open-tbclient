package com.tencent.mm.opensdk.diffdev.a;

import android.os.Handler;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class b implements OAuthListener {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ a f39434f;

    public b(a aVar) {
        this.f39434f = aVar;
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        List list;
        Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
        this.f39434f.f39432d = null;
        ArrayList<OAuthListener> arrayList = new ArrayList();
        list = this.f39434f.f39431c;
        arrayList.addAll(list);
        for (OAuthListener oAuthListener : arrayList) {
            oAuthListener.onAuthFinish(oAuthErrCode, str);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthGotQrcode(String str, byte[] bArr) {
        List list;
        Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
        ArrayList<OAuthListener> arrayList = new ArrayList();
        list = this.f39434f.f39431c;
        arrayList.addAll(list);
        for (OAuthListener oAuthListener : arrayList) {
            oAuthListener.onAuthGotQrcode(str, bArr);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onQrcodeScanned() {
        Handler handler;
        Handler handler2;
        Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        handler = this.f39434f.handler;
        if (handler != null) {
            handler2 = this.f39434f.handler;
            handler2.post(new c(this));
        }
    }
}
