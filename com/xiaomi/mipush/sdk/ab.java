package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.service.av;
import com.xiaomi.push.service.aw;
import com.xiaomi.xmpush.thrift.ae;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ab implements aw.b {
    private Context a;

    public ab(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.service.aw.b
    public void a(ArrayList<av.b> arrayList) {
        if (arrayList == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[MiTinyDataClient]:requests is null, MiTinyDataClient upload by long connection failed.");
            return;
        }
        ArrayList<ae> a = av.a(arrayList, this.a.getPackageName(), a.a(this.a).c());
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("Get a null XmPushActionNotification when TinyDataHelper.transToTriftObj() in MiPushClient.");
            return;
        }
        Iterator<ae> it = a.iterator();
        while (it.hasNext()) {
            ae next = it.next();
            next.a("uploadWay", "longMiTinyClient");
            u.a(this.a).a(next, com.xiaomi.xmpush.thrift.a.Notification, true, null);
        }
    }

    @Override // com.xiaomi.push.service.aw.b
    public boolean a(av.b bVar) {
        return com.xiaomi.channel.commonutils.network.d.d(this.a);
    }
}
