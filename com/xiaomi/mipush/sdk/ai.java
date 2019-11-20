package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.eu;
import com.xiaomi.push.hk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ai implements eu.a {
    @Override // com.xiaomi.push.eu.a
    public void a(Context context, hk hkVar) {
        MiTinyDataClient.upload(context, hkVar);
    }
}
