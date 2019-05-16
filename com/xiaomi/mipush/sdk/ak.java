package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.service.clientReport.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ak implements c.a {
    @Override // com.xiaomi.push.service.clientReport.c.a
    public void a(Context context, com.xiaomi.xmpush.thrift.f fVar) {
        MiTinyDataClient.upload(context, fVar);
    }
}
