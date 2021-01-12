package com.vivo.push.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import com.vivo.push.cache.ClientConfigManagerImpl;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class aj extends com.vivo.push.v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        if (this.f13709a == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + yVar + " ; mContext is Null");
        } else if (yVar == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask pushCommand is Null");
        } else {
            com.vivo.push.model.b a2 = com.vivo.push.util.s.a(this.f13709a);
            switch (yVar.b()) {
                case 0:
                    if (com.vivo.push.p.a().e()) {
                        Context context = this.f13709a;
                        Intent intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
                        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
                        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                            com.vivo.push.util.p.d("ModuleUtil", "disableDeprecatedService is null");
                        } else {
                            PackageManager packageManager = context.getPackageManager();
                            ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
                            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                                packageManager.setComponentEnabledSetting(componentName, 2, 1);
                            }
                        }
                        Context context2 = this.f13709a;
                        Intent intent2 = new Intent();
                        intent2.setPackage(context2.getPackageName());
                        intent2.setClassName(context2.getPackageName(), "com.vivo.push.sdk.service.LinkProxyActivity");
                        List<ResolveInfo> queryIntentActivities = context2.getPackageManager().queryIntentActivities(intent2, 128);
                        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                            com.vivo.push.util.p.d("ModuleUtil", "disableDeprecatedActivity is null");
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
                    if (a2 == null || a2.c()) {
                        com.vivo.push.p.a().a(((com.vivo.push.b.c) yVar).h(), 1005);
                        break;
                    } else {
                        int a3 = com.vivo.push.util.r.a((com.vivo.push.b.c) yVar);
                        if (a3 != 0) {
                            com.vivo.push.p.a().a(((com.vivo.push.b.c) yVar).h(), a3);
                            return;
                        }
                    }
                    break;
                case UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE /* 2009 */:
                    com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.f13709a).isDebug());
                    if (com.vivo.push.util.p.a()) {
                        com.vivo.push.p.a().k();
                        com.vivo.push.util.a aVar = new com.vivo.push.util.a();
                        aVar.a(this.f13709a, "com.vivo.push_preferences.hybridapptoken_v1");
                        aVar.a();
                        com.vivo.push.util.a aVar2 = new com.vivo.push.util.a();
                        aVar2.a(this.f13709a, "com.vivo.push_preferences.appconfig_v1");
                        aVar2.a();
                        if (!com.vivo.push.p.a().e()) {
                            ClientConfigManagerImpl.getInstance(this.f13709a).clearPush();
                            break;
                        }
                    }
                    break;
                case IMConstants.IM_MSG_TYPE_SHIELD /* 2011 */:
                    com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.f13709a).isDebug(((com.vivo.push.b.z) yVar).d()));
                    break;
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
            com.vivo.push.a.a.a(this.f13709a, a4, yVar);
        }
    }
}
