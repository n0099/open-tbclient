package d.l.a.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.d.b.c;
import d.l.a.d.e;
import d.l.a.e.b.g.r;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class m implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.l.a.e.b.g.r
    public void a(DownloadInfo downloadInfo, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, downloadInfo, i2, i3) == null) {
            d.l.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i3));
                jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            e.c.a().r("pause_reserve_wifi", jSONObject, c2);
        }
    }
}
