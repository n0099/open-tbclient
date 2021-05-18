package com.vivo.push.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.vivo.push.cache.ClientConfigManagerImpl;
import java.util.List;
/* loaded from: classes7.dex */
public final class aj extends com.vivo.push.v {
    public aj(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    public final void a(com.vivo.push.y yVar) {
        Context context = this.f36823a;
        if (context == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + yVar + " ; mContext is Null");
        } else if (yVar == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask pushCommand is Null");
        } else {
            com.vivo.push.model.b a2 = com.vivo.push.util.s.a(context);
            int b2 = yVar.b();
            if (b2 != 0) {
                if (b2 == 2009) {
                    com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.f36823a).isDebug());
                    if (com.vivo.push.util.p.a()) {
                        com.vivo.push.p.a().k();
                        com.vivo.push.util.a aVar = new com.vivo.push.util.a();
                        aVar.a(this.f36823a, "com.vivo.push_preferences.hybridapptoken_v1");
                        aVar.a();
                        com.vivo.push.util.a aVar2 = new com.vivo.push.util.a();
                        aVar2.a(this.f36823a, "com.vivo.push_preferences.appconfig_v1");
                        aVar2.a();
                        if (!com.vivo.push.p.a().e()) {
                            ClientConfigManagerImpl.getInstance(this.f36823a).clearPush();
                        }
                    }
                } else if (b2 != 2011) {
                    switch (b2) {
                        case 2002:
                        case 2003:
                        case 2004:
                        case 2005:
                            if (a2 != null && !a2.c()) {
                                com.vivo.push.b.c cVar = (com.vivo.push.b.c) yVar;
                                int a3 = com.vivo.push.util.r.a(cVar);
                                if (a3 != 0) {
                                    com.vivo.push.p.a().a(cVar.h(), a3);
                                    return;
                                }
                            } else {
                                com.vivo.push.p.a().a(((com.vivo.push.b.c) yVar).h(), 1005);
                                break;
                            }
                            break;
                    }
                } else {
                    com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.f36823a).isDebug(((com.vivo.push.b.z) yVar).d()));
                }
            } else if (com.vivo.push.p.a().e()) {
                Context context2 = this.f36823a;
                Intent intent = new Intent();
                intent.setPackage(context2.getPackageName());
                intent.setClassName(context2.getPackageName(), "com.vivo.push.sdk.service.CommandService");
                List<ResolveInfo> queryIntentServices = context2.getPackageManager().queryIntentServices(intent, 128);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    PackageManager packageManager = context2.getPackageManager();
                    ComponentName componentName = new ComponentName(context2, queryIntentServices.get(0).serviceInfo.name);
                    if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                        packageManager.setComponentEnabledSetting(componentName, 2, 1);
                    }
                } else {
                    com.vivo.push.util.p.d("ModuleUtil", "disableDeprecatedService is null");
                }
                Context context3 = this.f36823a;
                Intent intent2 = new Intent();
                intent2.setPackage(context3.getPackageName());
                intent2.setClassName(context3.getPackageName(), "com.vivo.push.sdk.service.LinkProxyActivity");
                List<ResolveInfo> queryIntentActivities = context3.getPackageManager().queryIntentActivities(intent2, 128);
                if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                    PackageManager packageManager2 = context3.getPackageManager();
                    ComponentName componentName2 = new ComponentName(context3, queryIntentActivities.get(0).activityInfo.name);
                    if (packageManager2.getComponentEnabledSetting(componentName2) != 2) {
                        packageManager2.setComponentEnabledSetting(componentName2, 2, 1);
                    }
                } else {
                    com.vivo.push.util.p.d("ModuleUtil", "disableDeprecatedActivity is null");
                }
            }
            if (a2 == null) {
                com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + yVar + " ; pushPkgInfo is Null");
                return;
            }
            String a4 = a2.a();
            if (a2.c()) {
                com.vivo.push.p.a().a(((com.vivo.push.b.c) yVar).h(), 1004);
                yVar = new com.vivo.push.b.e();
                com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + yVar + " ; pkgName is InBlackList ");
            }
            com.vivo.push.a.a.a(this.f36823a, a4, yVar);
        }
    }
}
