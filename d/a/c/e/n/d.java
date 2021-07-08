package d.a.c.e.n;

import android.content.Context;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.c.e.p.j;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (j.H()) {
                return CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
            }
            if (j.x()) {
                int f2 = j.f();
                StringBuilder sb = new StringBuilder();
                if (f2 == 1) {
                    sb.append('M');
                } else if (f2 == 2) {
                    sb.append('U');
                } else if (f2 != 3) {
                    sb.append('N');
                } else {
                    sb.append('T');
                }
                if (j.E()) {
                    sb.append("_WAP_");
                } else {
                    sb.append("_NET_");
                }
                if (j.u()) {
                    sb.append(com.baidu.apollon.statistics.g.f3986b);
                } else if (j.v()) {
                    sb.append("4G");
                } else if (j.t()) {
                    sb.append("2G");
                } else {
                    sb.append('N');
                }
                return sb.toString();
            }
            return "unknown";
        }
        return (String) invokeL.objValue;
    }
}
