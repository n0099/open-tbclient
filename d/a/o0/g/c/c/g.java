package d.a.o0.g.c.c;

import android.content.Intent;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.f0;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends d.a.o0.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g() {
        super("openSpaceCleanActivity");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.g.f.a
    public d.a.o0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.o0.a.u0.b bVar) {
        InterceptResult invokeLL;
        boolean b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (f0.m()) {
                b2 = b("com.huawei.systemmanager", "com.huawei.systemmanager.appfeature.spacecleaner.SpaceCleanActivity");
            } else if (f0.n()) {
                b2 = b("com.miui.cleanmaster", "com.miui.optimizecenter.MainActivity");
            } else if (f0.o()) {
                b2 = b("com.coloros.phonemanager", "com.coloros.phonemanager.clear.ClearActivity");
            } else {
                b2 = f0.r() ? b("com.iqoo.secure", "com.iqoo.secure.clean.PhoneCleanActivity2") : false;
            }
            if (!b2) {
                Toast.makeText(d.a.o0.a.c1.a.b(), d.a.o0.g.b.aiapps_goto_clean_activity_fail, 0).show();
            }
            bVar.a(null);
            return null;
        }
        return (d.a.o0.a.u.h.b) invokeLL.objValue;
    }

    public final boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            return d.a.o0.a.v2.f.i(d.a.o0.a.c1.a.b(), intent, true, false);
        }
        return invokeLL.booleanValue;
    }
}
