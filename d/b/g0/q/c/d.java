package d.b.g0.q.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    public Context f49344a;

    public d(Context context) {
        if (context != null) {
            this.f49344a = context.getApplicationContext();
            return;
        }
        throw new RuntimeException("context can not be null");
    }

    @Override // d.b.g0.q.c.b
    public boolean a() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.q.c.b
    /* renamed from: b */
    public String get() {
        return d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.q.c.b
    /* renamed from: c */
    public void put(String str) {
    }

    public final String d() {
        List<ResolveInfo> queryBroadcastReceivers = this.f49344a.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.intent.action.UUID"), 0);
        String str = null;
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.applicationInfo != null && !this.f49344a.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                    File file = new File(new File(resolveInfo.activityInfo.applicationInfo.dataDir, com.baidu.fsg.face.base.b.c.f5556g), "libuuid.so");
                    if (file.exists()) {
                        str = d.b.g0.q.d.a.c(file);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        break;
                    }
                }
            }
        }
        return str;
    }
}
