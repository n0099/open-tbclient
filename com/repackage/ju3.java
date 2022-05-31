package com.repackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ju3 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hn3 a;
    public or1 b;
    public String c;

    /* loaded from: classes6.dex */
    public class a implements hn3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju3 a;

        public a(ju3 ju3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju3Var;
        }

        @Override // com.repackage.hn3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                ku3 ku3Var = new ku3();
                ku3Var.progress = i;
                JSEvent jSEvent = new JSEvent("ProgressChange");
                jSEvent.data = ku3Var;
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.repackage.hn3
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.repackage.hn3
        public void c(DownloadState downloadState, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i) == null) {
                mu3 mu3Var = new mu3();
                mu3Var.state = downloadState.value();
                JSEvent jSEvent = new JSEvent("StateChange");
                jSEvent.data = mu3Var;
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.repackage.hn3
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // com.repackage.hn3
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.c : (String) invokeV.objValue;
        }

        @Override // com.repackage.hn3
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ju3(JSRuntime jSRuntime, or1 or1Var) {
        super(jSRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSRuntime, or1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = or1Var;
        if (z()) {
            this.a = new a(this);
            xv3.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.a);
        }
    }

    public void A(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            j63 j63Var = new j63();
            j63Var.b = str;
            j63Var.a = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
            j63Var.a("targetPackageName", str2);
            a63.g(j63Var);
        }
    }

    public final boolean B(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            if (context != null) {
                try {
                    if (context.getPackageManager() != null) {
                        return context.getPackageManager().getPackageInfo(str, 0) != null;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void C(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0 || queryIntentActivities.iterator().next() == null) {
            return;
        }
        String str2 = queryIntentActivities.iterator().next().activityInfo.name;
        Intent intent2 = new Intent("android.intent.action.MAIN");
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.setComponent(new ComponentName(str, str2));
        intent2.setFlags(270532608);
        try {
            context.startActivity(intent2);
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void deleteDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            xv3.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD, this.a);
        }
    }

    @JavascriptInterface
    public void installApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            xv3.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.a);
        }
    }

    @JavascriptInterface
    public void openApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            C(AppRuntime.getAppContext(), this.c);
        }
    }

    @JavascriptInterface
    public void pauseDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            xv3.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.a);
        }
    }

    @JavascriptInterface
    public void resumeDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            xv3.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD, this.a);
        }
    }

    @JavascriptInterface
    public void startDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            xv3.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a);
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            this.c = xv3.f().getPackageName();
            if (!xv3.f().c()) {
                pt3 pt3Var = new pt3();
                pt3Var.errMsg = "download url is empty";
                s14.call(this.b, false, pt3Var);
                A("reallyDownloadNull", this.c);
                return false;
            } else if (B(AppRuntime.getAppContext(), this.c)) {
                pt3 pt3Var2 = new pt3();
                pt3Var2.errMsg = "apk has installed";
                s14.call(this.b, false, pt3Var2);
                A("reallyHasInstalled", this.c);
                return false;
            } else {
                lu3 lu3Var = new lu3();
                lu3Var.statusCode = 0;
                lu3Var.packageName = this.c;
                s14.call(this.b, true, lu3Var);
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
