package com.vivo.push.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.cache.ClientConfigManagerImpl;
import java.util.List;
/* loaded from: classes4.dex */
public final class ah extends com.vivo.push.l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(com.vivo.push.o oVar) {
        super(oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((com.vivo.push.o) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) {
            Context context = this.a;
            if (context == null) {
                com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; mContext is Null");
            } else if (oVar == null) {
                com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask pushCommand is Null");
            } else {
                com.vivo.push.model.b a = com.vivo.push.util.t.a(context);
                int b2 = oVar.b();
                if (b2 != 0) {
                    if (b2 == 2009) {
                        com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.a).isDebug());
                        if (com.vivo.push.util.p.a()) {
                            com.vivo.push.e.a().i();
                            com.vivo.push.util.b bVar = new com.vivo.push.util.b();
                            bVar.a(this.a, "com.vivo.push_preferences.hybridapptoken_v1");
                            bVar.a();
                            com.vivo.push.util.b bVar2 = new com.vivo.push.util.b();
                            bVar2.a(this.a, "com.vivo.push_preferences.appconfig_v1");
                            bVar2.a();
                            if (!com.vivo.push.e.a().e()) {
                                ClientConfigManagerImpl.getInstance(this.a).clearPush();
                            }
                        }
                    } else if (b2 != 2011) {
                        switch (b2) {
                            case 2002:
                            case 2003:
                            case 2004:
                            case 2005:
                                if (a != null && !a.c()) {
                                    com.vivo.push.b.c cVar = (com.vivo.push.b.c) oVar;
                                    int a2 = com.vivo.push.util.s.a(cVar);
                                    if (a2 != 0) {
                                        com.vivo.push.e.a().a(cVar.h(), a2);
                                        return;
                                    }
                                } else {
                                    com.vivo.push.e.a().a(((com.vivo.push.b.c) oVar).h(), 1005);
                                    break;
                                }
                                break;
                        }
                    } else {
                        com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.a).isDebug(((com.vivo.push.b.w) oVar).d()));
                    }
                } else if (com.vivo.push.e.a().e()) {
                    Context context2 = this.a;
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
                    Context context3 = this.a;
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
                if (a == null) {
                    com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; pushPkgInfo is Null");
                    return;
                }
                String a3 = a.a();
                if (a.c()) {
                    com.vivo.push.e.a().a(((com.vivo.push.b.c) oVar).h(), 1004);
                    oVar = new com.vivo.push.b.e();
                    com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; pkgName is InBlackList ");
                }
                com.vivo.push.a.a.a(this.a, a3, oVar);
            }
        }
    }
}
