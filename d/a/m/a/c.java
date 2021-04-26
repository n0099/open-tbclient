package d.a.m.a;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.b.o;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f63300e;

    public c(b bVar) {
        this.f63300e = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String b2 = o.b();
        if ("NONE".equals(b2) || RomUtils.UNKNOWN.equals(b2)) {
            com.baidu.crabsdk.c.a.c("network is not available!");
        } else if (CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING.equals(b2)) {
            b.a(this.f63300e);
        } else if (com.baidu.crabsdk.a.s) {
            com.baidu.crabsdk.c.a.c("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
        } else if (!"MOBILE".equals(b2)) {
            com.baidu.crabsdk.c.a.c("network is not wifi!");
        } else {
            com.baidu.crabsdk.c.a.c("upload without wifi!");
            b.a(this.f63300e);
        }
    }
}
