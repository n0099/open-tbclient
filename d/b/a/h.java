package d.b.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h extends s1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f69231e;

    /* renamed from: f  reason: collision with root package name */
    public final y1 f69232f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, y1 y1Var) {
        super(false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, y1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69231e = context;
        this.f69232f = y1Var;
    }

    @Override // d.b.a.s1
    public boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            String packageName = this.f69231e.getPackageName();
            PackageInfo packageInfo = null;
            if (TextUtils.isEmpty(this.f69232f.p())) {
                jSONObject.put(AsInstallService.SCHEME_PACKAGE_ADDED, packageName);
            } else {
                if (h0.f69234b) {
                    h0.a("has zijie pkg", null);
                }
                jSONObject.put(AsInstallService.SCHEME_PACKAGE_ADDED, this.f69232f.p());
                jSONObject.put("real_package_name", packageName);
            }
            try {
                packageInfo = this.f69231e.getPackageManager().getPackageInfo(packageName, 0);
            } catch (Throwable unused) {
            }
            if (packageInfo != null) {
                try {
                    i2 = packageInfo.versionCode;
                } catch (Throwable th) {
                    h0.b(th);
                    return false;
                }
            } else {
                i2 = 0;
            }
            if (!TextUtils.isEmpty(this.f69232f.g())) {
                jSONObject.put("app_version", this.f69232f.g());
            } else {
                jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
            }
            if (!TextUtils.isEmpty(this.f69232f.l())) {
                jSONObject.put("app_version_minor", this.f69232f.l());
            } else {
                jSONObject.put("app_version_minor", "");
            }
            if (this.f69232f.d() != 0) {
                jSONObject.put("version_code", this.f69232f.d());
            } else {
                jSONObject.put("version_code", i2);
            }
            if (this.f69232f.e() != 0) {
                jSONObject.put("update_version_code", this.f69232f.e());
            } else {
                jSONObject.put("update_version_code", i2);
            }
            if (this.f69232f.f() != 0) {
                jSONObject.put("manifest_version_code", this.f69232f.f());
            } else {
                jSONObject.put("manifest_version_code", i2);
            }
            if (!TextUtils.isEmpty(this.f69232f.c())) {
                jSONObject.put("app_name", this.f69232f.c());
            }
            if (!TextUtils.isEmpty(this.f69232f.h())) {
                jSONObject.put("tweaked_channel", this.f69232f.h());
            }
            if (packageInfo == null || packageInfo.applicationInfo == null || (i3 = packageInfo.applicationInfo.labelRes) <= 0) {
                return true;
            }
            jSONObject.put("display_name", this.f69231e.getString(i3));
            return true;
        }
        return invokeL.booleanValue;
    }
}
