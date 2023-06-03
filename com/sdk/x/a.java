package com.sdk.x;

import android.content.Context;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.e;
import com.sdk.a.f;
import com.sdk.base.framework.bean.DataInfo;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public <T> e<T> a(Context context, int i, List<String> list, com.sdk.e.a<T> aVar) {
        InterceptResult invokeLILL;
        StringBuffer stringBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048576, this, context, i, list, aVar)) == null) {
            com.sdk.z.a aVar2 = new com.sdk.z.a(context, list, aVar);
            DataInfo dataInfo = new DataInfo();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            if (list.size() != 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String str = list.get(i2);
                    String substring = str.substring(0, 3);
                    try {
                        InetAddress byName = InetAddress.getByName(str);
                        byName.getHostAddress();
                        byte[] address = byName.getAddress();
                        if (str.length() != 0) {
                            if (address.length == 4) {
                                if (!substring.equals(SpeedStats.UBC_LAUNCH_SPEED_ID) && !substring.equals("192")) {
                                    stringBuffer2.append(str);
                                    stringBuffer = stringBuffer2;
                                }
                            } else if (!str.contains("%") && !"::1".equals(str)) {
                                stringBuffer3.append(str);
                                stringBuffer = stringBuffer3;
                            }
                            stringBuffer.append("-");
                        }
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                }
                if (stringBuffer2.length() != 0 && '-' == stringBuffer2.charAt(stringBuffer2.length() - 1)) {
                    dataInfo.putData("privateIp", stringBuffer2.deleteCharAt(stringBuffer2.length() - 1));
                }
                if (stringBuffer3.length() != 0 && '-' == stringBuffer3.charAt(stringBuffer3.length() - 1)) {
                    dataInfo.putData("privateIp_v6", stringBuffer3.deleteCharAt(stringBuffer3.length() - 1));
                }
            }
            dataInfo.putData("serviceType", Integer.valueOf(i));
            dataInfo.putData("newVersion", "11");
            return aVar2.a(aVar2.i, "/dro/netm/v1.0/qc", dataInfo, new com.sdk.g.a(aVar2), 0, f.a.b);
        }
        return (e) invokeLILL.objValue;
    }
}
