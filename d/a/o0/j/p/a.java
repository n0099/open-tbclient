package d.a.o0.j.p;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
import d.a.o0.j.g;
/* loaded from: classes7.dex */
public class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context) {
        super(BaiduMap.f6906e, context.getString(g.openlocation_bottommenu_baidumap), "com.baidu.BaiduMap");
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
        this.f51053c = true;
    }

    @Override // d.a.o0.j.p.c
    public void e(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048576, this, context, latLng, latLng2, str, str2) == null) || latLng == null || latLng2 == null) {
            return;
        }
        Intent intent = new Intent();
        Uri.Builder buildUpon = Uri.parse("baidumap://map/direction?").buildUpon();
        buildUpon.appendQueryParameter(FilterValue.DEFAULT_FILTER_VALUE, "name:" + str + "|latlng:" + latLng.latitude + "," + latLng.longitude);
        buildUpon.appendQueryParameter("destination", "name:" + str2 + "|latlng:" + latLng2.latitude + "," + latLng2.longitude);
        buildUpon.appendQueryParameter("mode", "driving");
        buildUpon.appendQueryParameter("target", "1");
        buildUpon.appendQueryParameter("src", context.getPackageName());
        intent.setData(buildUpon.build());
        context.startActivity(intent);
    }
}
