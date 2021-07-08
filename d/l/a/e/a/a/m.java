package d.l.a.e.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class m extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, d.l.a.e.b.j.a aVar, String str) {
        super(context, aVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (d.l.a.e.b.j.a) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.l.a.e.a.a.e
    public Intent b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String t = this.f71569b.t("s");
            String b2 = d.l.a.e.a.h.d.b(this.f71569b.t("bb"), t);
            if (!TextUtils.isEmpty(b2) && b2.split(",").length == 2) {
                String b3 = d.l.a.e.a.h.d.b(this.f71569b.t("bc"), t);
                if (!TextUtils.isEmpty(b3) && b3.split(",").length == 2) {
                    String[] split = b2.split(",");
                    String[] split2 = b3.split(",");
                    String b4 = d.l.a.e.a.h.d.b(this.f71569b.t(Config.DEVICE_BRAND), t);
                    String b5 = d.l.a.e.a.h.d.b(this.f71569b.t("be"), t);
                    String b6 = d.l.a.e.a.h.d.b(this.f71569b.t("bf"), t);
                    HashMap hashMap = new HashMap();
                    hashMap.put(split[0], split[1]);
                    hashMap.put(split2[0], split2[1]);
                    hashMap.put(b4, this.f71570c);
                    Intent intent = new Intent();
                    intent.setAction(b6);
                    intent.setData(Uri.parse(b5 + b(hashMap)));
                    intent.addFlags(268468224);
                    return intent;
                }
            }
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public static String b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) {
            if (map == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(URLEncoder.encode(entry.getValue()));
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            return stringBuffer2.endsWith("&") ? stringBuffer2.substring(0, stringBuffer2.length() - 1) : stringBuffer2;
        }
        return (String) invokeL.objValue;
    }
}
