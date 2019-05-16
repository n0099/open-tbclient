package com.vivo.push.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.baidu.mapapi.UIMsg;
import com.vivo.push.cache.ClientConfigManagerImpl;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ai extends com.vivo.push.s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        if (this.a == null) {
            com.vivo.push.util.m.d("SendCommandTask", "SendCommandTask " + vVar + " ; mContext is Null");
        } else if (vVar == null) {
            com.vivo.push.util.m.d("SendCommandTask", "SendCommandTask pushCommand is Null");
        } else {
            com.vivo.push.model.b a = com.vivo.push.util.p.a(this.a);
            switch (vVar.b()) {
                case 0:
                    if (com.vivo.push.m.a().f()) {
                        Context context = this.a;
                        Intent intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
                        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
                        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                            com.vivo.push.util.m.d("ModuleUtil", "disableDeprecatedService is null");
                        } else {
                            PackageManager packageManager = context.getPackageManager();
                            ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
                            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                                packageManager.setComponentEnabledSetting(componentName, 2, 1);
                            }
                        }
                        Context context2 = this.a;
                        Intent intent2 = new Intent();
                        intent2.setPackage(context2.getPackageName());
                        intent2.setClassName(context2.getPackageName(), "com.vivo.push.sdk.service.LinkProxyActivity");
                        List<ResolveInfo> queryIntentActivities = context2.getPackageManager().queryIntentActivities(intent2, 128);
                        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                            com.vivo.push.util.m.d("ModuleUtil", "disableDeprecatedActivity is null");
                            break;
                        } else {
                            PackageManager packageManager2 = context2.getPackageManager();
                            ComponentName componentName2 = new ComponentName(context2, queryIntentActivities.get(0).activityInfo.name);
                            if (packageManager2.getComponentEnabledSetting(componentName2) != 2) {
                                packageManager2.setComponentEnabledSetting(componentName2, 2, 1);
                                break;
                            }
                        }
                    }
                    break;
                case 2002:
                case 2003:
                case 2004:
                case 2005:
                    if (a == null || a.c()) {
                        com.vivo.push.m.a().a(((com.vivo.push.b.c) vVar).h(), 1005);
                        break;
                    } else {
                        int a2 = com.vivo.push.util.o.a((com.vivo.push.b.c) vVar);
                        if (a2 != 0) {
                            com.vivo.push.m.a().a(((com.vivo.push.b.c) vVar).h(), a2);
                            return;
                        }
                    }
                    break;
                case UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE /* 2009 */:
                    com.vivo.push.util.m.a(ClientConfigManagerImpl.getInstance(this.a).isDebug());
                    if (com.vivo.push.util.m.a()) {
                        com.vivo.push.m.a().l();
                        com.vivo.push.util.a aVar = new com.vivo.push.util.a();
                        aVar.a(this.a, "com.vivo.push_preferences.hybridapptoken");
                        aVar.a();
                        if (!com.vivo.push.m.a().f()) {
                            ClientConfigManagerImpl.getInstance(this.a).clearPush();
                            break;
                        }
                    }
                    break;
                case 2011:
                    com.vivo.push.util.m.a(ClientConfigManagerImpl.getInstance(this.a).isDebug(((com.vivo.push.b.w) vVar).d()));
                    break;
            }
            if (a == null) {
                com.vivo.push.util.m.d("SendCommandTask", "SendCommandTask " + vVar + " ; pushPkgInfo is Null");
                return;
            }
            String a3 = a.a();
            if (a.c()) {
                com.vivo.push.m.a().a(((com.vivo.push.b.c) vVar).h(), 1004);
                vVar = new com.vivo.push.b.e();
                com.vivo.push.util.m.d("SendCommandTask", "SendCommandTask " + vVar + " ; pkgName is InBlackList ");
            }
            com.vivo.push.a.a.a(this.a, a3, vVar);
        }
    }
}
