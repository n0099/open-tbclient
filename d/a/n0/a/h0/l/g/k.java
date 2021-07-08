package d.a.n0.a.h0.l.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class k extends a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(961088652, "Ld/a/n0/a/h0/l/g/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(961088652, "Ld/a/n0/a/h0/l/g/k;");
                return;
            }
        }
        l = d.a.n0.a.k.f45831a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(boolean z, boolean z2) {
        super(z, z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (l) {
            Log.d("PreloadMasterManager", "PreloadMasterManagerSingle created");
        }
    }

    @Override // d.a.n0.a.h0.l.g.a
    public boolean k(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, pMSAppInfo)) == null) {
            PMSAppInfo g2 = g();
            if (g2 == null) {
                return false;
            }
            if (!TextUtils.equals(pMSAppInfo.appId, g2.appId)) {
                if (l) {
                    Log.e("PreloadMasterManager", "one master can only prefetch one appId");
                }
                return true;
            } else if (w(pMSAppInfo, cVar)) {
                if (l) {
                    Log.w("PreloadMasterManager", "prefetch app is not the same !!!!");
                    Log.w("PreloadMasterManager", "bind app info - " + g());
                    Log.w("PreloadMasterManager", "prefetch app info - " + pMSAppInfo);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean w(PMSAppInfo pMSAppInfo, PrefetchEvent.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo, cVar)) == null) {
            PMSAppInfo g2 = g();
            if (this.f44875c == null) {
                return false;
            }
            return (pMSAppInfo.versionCode == g2.versionCode && TextUtils.equals(pMSAppInfo.appId, g2.appId) && !m(cVar, this.f44876d)) ? false : true;
        }
        return invokeLL.booleanValue;
    }
}
