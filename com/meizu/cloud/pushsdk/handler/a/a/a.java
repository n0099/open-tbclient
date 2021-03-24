package com.meizu.cloud.pushsdk.handler.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a.b.g;
import com.meizu.cloud.pushsdk.notification.c;
import com.meizu.cloud.pushsdk.util.d;
import java.io.File;
/* loaded from: classes6.dex */
public class a extends com.meizu.cloud.pushsdk.handler.a.a<g> {
    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 65536;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a */
    public void b(g gVar) {
        d.c(c(), c().getPackageName(), gVar.d().b().d(), gVar.d().b().a(), gVar.d().b().e(), gVar.d().b().b());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(g gVar, c cVar) {
        String message;
        d.j.a.a.a.c();
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdktmp/" + gVar.d().b().a() + "_" + gVar.d().b().d() + ".zip";
        File file = null;
        try {
            new b(str).a(gVar.c());
            File file2 = new File(str);
            message = null;
            file = file2;
        } catch (Exception e2) {
            message = e2.getMessage();
            d.j.a.a.a.b("AbstractMessageHandler", "zip error message " + message);
        }
        if (file != null && file.length() / 1024 > gVar.a()) {
            message = "the upload file exceeds the max size";
        } else if (gVar.b() && !com.meizu.cloud.pushsdk.util.a.b(c())) {
            message = "current network not allowed upload log file";
        }
        com.meizu.cloud.pushsdk.b.a.c<String> a2 = com.meizu.cloud.pushsdk.platform.a.b.a(c()).a(gVar.d().b().a(), gVar.d().b().d(), message, file);
        if (a2 == null || !a2.b()) {
            d.j.a.a.a.d("AbstractMessageHandler", "upload error code " + a2.c() + a2.a());
            return;
        }
        if (file != null) {
            file.delete();
        }
        d.j.a.a.a.b("AbstractMessageHandler", "upload success " + a2.a());
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        int i;
        d.j.a.a.a.d("AbstractMessageHandler", "start LogUploadMessageHandler match");
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            com.meizu.cloud.pushsdk.handler.a.b.b a2 = com.meizu.cloud.pushsdk.handler.a.b.b.a(stringExtra);
            if (a2.a() != null) {
                i = a2.a().a();
                return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && "2".equals(String.valueOf(i));
            }
        }
        i = 0;
        if (PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction())) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public g c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
        return new g(intent.getStringExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE), stringExtra, intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), stringExtra2);
    }
}
