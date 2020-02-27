package com.meizu.cloud.pushsdk.handler.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a.b.f;
import com.meizu.cloud.pushsdk.util.c;
import java.io.File;
/* loaded from: classes8.dex */
public class a extends com.meizu.cloud.pushsdk.handler.a.a<f> {
    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 65536;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a */
    public void b(f fVar) {
        c.c(c(), c().getPackageName(), fVar.d().b().d(), fVar.d().b().a(), fVar.d().b().e(), fVar.d().b().b());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(f fVar, com.meizu.cloud.pushsdk.notification.c cVar) {
        String message;
        File file = null;
        com.meizu.cloud.a.a.flush();
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdktmp/" + fVar.d().b().a() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + fVar.d().b().d() + ".zip";
        try {
            new b(str).a(fVar.c());
            message = null;
            file = new File(str);
        } catch (Exception e) {
            message = e.getMessage();
            com.meizu.cloud.a.a.e("AbstractMessageHandler", "zip error message " + message);
        }
        if (file != null && file.length() / 1024 > fVar.a()) {
            message = "the upload file exceeds the max size";
        } else if (fVar.b() && !com.meizu.cloud.pushsdk.util.a.b(c())) {
            message = "current network not allowed upload log file";
        }
        com.meizu.cloud.pushsdk.b.a.c<String> a = com.meizu.cloud.pushsdk.platform.a.b.a(c()).a(fVar.d().b().a(), fVar.d().b().d(), message, file);
        if (a == null || !a.b()) {
            com.meizu.cloud.a.a.i("AbstractMessageHandler", "upload error code " + a.c() + a.a());
            return;
        }
        if (file != null) {
            file.delete();
        }
        com.meizu.cloud.a.a.e("AbstractMessageHandler", "upload success " + a.a());
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        int i;
        com.meizu.cloud.a.a.i("AbstractMessageHandler", "start LogUploadMessageHandler match");
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            com.meizu.cloud.pushsdk.handler.a.b.b a = com.meizu.cloud.pushsdk.handler.a.b.b.a(stringExtra);
            if (a.a() != null) {
                i = a.a().a();
                return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && "2".equals(String.valueOf(i));
            }
        }
        i = 0;
        if (PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction())) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public f c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
        return new f(intent.getStringExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE), stringExtra, intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), stringExtra2);
    }
}
