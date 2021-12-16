package com.vivo.push.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class t extends ab {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(com.vivo.push.y yVar) {
        super(yVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((com.vivo.push.y) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static Intent b(Intent intent, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, intent, map)) == null) {
            if (map != null && map.entrySet() != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null && entry.getKey() != null) {
                        intent.putExtra(entry.getKey(), entry.getValue());
                    }
                }
            }
            return intent;
        }
        return (Intent) invokeLL.objValue;
    }

    @Override // com.vivo.push.v
    public final void a(com.vivo.push.y yVar) {
        Intent parseUri;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yVar) == null) {
            com.vivo.push.b.r rVar = (com.vivo.push.b.r) yVar;
            InsideNotificationItem f2 = rVar.f();
            if (f2 == null) {
                com.vivo.push.util.p.d("OnNotificationClickTask", "current notification item is null");
                return;
            }
            UPSNotificationMessage a = com.vivo.push.util.q.a(f2);
            boolean equals = this.a.getPackageName().equals(rVar.d());
            if (equals) {
                NotifyAdapterUtil.cancelNotify(this.a);
            }
            if (equals) {
                com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(1030L);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("type", "2");
                hashMap.put("messageID", String.valueOf(rVar.e()));
                hashMap.put(Constants.PARAM_PLATFORM, this.a.getPackageName());
                Context context = this.a;
                String b2 = com.vivo.push.util.z.b(context, context.getPackageName());
                if (!TextUtils.isEmpty(b2)) {
                    hashMap.put("remoteAppId", b2);
                }
                aaVar.a(hashMap);
                com.vivo.push.p.a().a(aaVar);
                com.vivo.push.util.p.d("OnNotificationClickTask", "notification is clicked by skip type[" + a.getSkipType() + PreferencesUtil.RIGHT_MOUNT);
                int skipType = a.getSkipType();
                boolean z = true;
                if (skipType == 1) {
                    new Thread(new y(this, this.a, a.getParams())).start();
                    com.vivo.push.w.b(new u(this, a));
                    return;
                } else if (skipType == 2) {
                    String skipContent = a.getSkipContent();
                    if (!skipContent.startsWith("http://") && !skipContent.startsWith("https://")) {
                        z = false;
                    }
                    if (z) {
                        Uri parse = Uri.parse(skipContent);
                        Intent intent = new Intent("android.intent.action.VIEW", parse);
                        intent.setFlags(268435456);
                        b(intent, a.getParams());
                        try {
                            this.a.startActivity(intent);
                        } catch (Exception unused) {
                            com.vivo.push.util.p.a("OnNotificationClickTask", "startActivity error : " + parse);
                        }
                    } else {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "url not legal");
                    }
                    com.vivo.push.w.b(new v(this, a));
                    return;
                } else if (skipType == 3) {
                    com.vivo.push.w.b(new w(this, a));
                    return;
                } else if (skipType != 4) {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "illegitmacy skip type error : " + a.getSkipType());
                    return;
                } else {
                    String skipContent2 = a.getSkipContent();
                    try {
                        parseUri = Intent.parseUri(skipContent2, 1);
                        str = parseUri.getPackage();
                    } catch (Exception e2) {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : " + skipContent2, e2);
                    }
                    if (!TextUtils.isEmpty(str) && !this.a.getPackageName().equals(str)) {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                        return;
                    }
                    String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
                    if (!TextUtils.isEmpty(packageName) && !this.a.getPackageName().equals(packageName)) {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "open activity component error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                        return;
                    }
                    parseUri.setPackage(this.a.getPackageName());
                    parseUri.addFlags(268435456);
                    b(parseUri, a.getParams());
                    this.a.startActivity(parseUri);
                    com.vivo.push.w.b(new x(this, a));
                    return;
                }
            }
            com.vivo.push.util.p.a("OnNotificationClickTask", "notify is " + a + " ; isMatch is " + equals);
        }
    }
}
