package d.a.q0.h.i;

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
import d.a.q0.a.j2.k;
import d.a.q0.a.j2.p.e;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.f.i.k.f.a f53322e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.a.y.b.a f53323f;

    /* renamed from: g  reason: collision with root package name */
    public String f53324g;

    /* renamed from: d.a.q0.h.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1145a implements d.a.q0.f.i.k.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53325a;

        public C1145a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53325a = aVar;
        }

        @Override // d.a.q0.f.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                b bVar = new b();
                bVar.progress = i2;
                JSEvent jSEvent = new JSEvent("ProgressChange");
                jSEvent.data = bVar;
                this.f53325a.dispatchEvent(jSEvent);
            }
        }

        @Override // d.a.q0.f.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // d.a.q0.f.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                d dVar = new d();
                dVar.state = downloadState.value();
                JSEvent jSEvent = new JSEvent("StateChange");
                jSEvent.data = dVar;
                this.f53325a.dispatchEvent(jSEvent);
            }
        }

        @Override // d.a.q0.f.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // d.a.q0.f.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f53325a.f53324g : (String) invokeV.objValue;
        }

        @Override // d.a.q0.f.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(JSRuntime jSRuntime, d.a.q0.a.y.b.a aVar) {
        super(jSRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSRuntime, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53323f = aVar;
        if (z()) {
            this.f53322e = new C1145a(this);
            d.a.q0.h.t.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.f53322e);
        }
    }

    public void A(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            e eVar = new e();
            eVar.f49120b = str;
            eVar.f49119a = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
            eVar.a("targetPackageName", str2);
            k.g(eVar);
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
            d.a.q0.h.t.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD, this.f53322e);
        }
    }

    @JavascriptInterface
    public void installApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.q0.h.t.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.f53322e);
        }
    }

    @JavascriptInterface
    public void openApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            C(AppRuntime.getAppContext(), this.f53324g);
        }
    }

    @JavascriptInterface
    public void pauseDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.q0.h.t.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.f53322e);
        }
    }

    @JavascriptInterface
    public void resumeDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.q0.h.t.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD, this.f53322e);
        }
    }

    @JavascriptInterface
    public void startDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.q0.h.t.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f53322e);
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            this.f53324g = d.a.q0.h.t.a.f().getPackageName();
            if (!d.a.q0.h.t.a.f().b()) {
                d.a.q0.h.d.c.b bVar = new d.a.q0.h.d.c.b();
                bVar.errMsg = "download url is empty";
                d.a.q0.h.m0.c.a(this.f53323f, false, bVar);
                A("reallyDownloadNull", this.f53324g);
                return false;
            } else if (B(AppRuntime.getAppContext(), this.f53324g)) {
                d.a.q0.h.d.c.b bVar2 = new d.a.q0.h.d.c.b();
                bVar2.errMsg = "apk has installed";
                d.a.q0.h.m0.c.a(this.f53323f, false, bVar2);
                A("reallyHasInstalled", this.f53324g);
                return false;
            } else {
                c cVar = new c();
                cVar.statusCode = 0;
                cVar.packageName = this.f53324g;
                d.a.q0.h.m0.c.a(this.f53323f, true, cVar);
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
