package d.a.o0.j.p;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.j.g;
/* loaded from: classes7.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context) {
        super("GaodeMap", context.getString(g.openlocation_bottommenu_gaodemap), "com.autonavi.minimap");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.j.p.c
    public void e(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048576, this, context, latLng, latLng2, str, str2) == null) || latLng == null || latLng2 == null) {
            return;
        }
        Uri.Builder buildUpon = Uri.parse("androidamap://route?").buildUpon();
        buildUpon.appendQueryParameter("sourceApplication", context.getPackageName());
        buildUpon.appendQueryParameter("slat", String.valueOf(latLng.latitude));
        buildUpon.appendQueryParameter("slon", String.valueOf(latLng.longitude));
        buildUpon.appendQueryParameter("sname", str);
        buildUpon.appendQueryParameter("dlat", String.valueOf(latLng2.latitude));
        buildUpon.appendQueryParameter("dlon", String.valueOf(latLng2.longitude));
        buildUpon.appendQueryParameter("dname", str2);
        buildUpon.appendQueryParameter(BdZeusUtil.URL_KEY_MACHINE, "0");
        buildUpon.appendQueryParameter("t", "0");
        Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
        intent.setPackage("com.autonavi.minimap");
        context.startActivity(intent);
    }
}
