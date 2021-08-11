package com.yy.gslbsdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class TypeTools {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_HTTPS_HALF = 1;
    public static final int TYPE_HTTPS_NONE = 0;
    public static final int TYPE_HTTPS_TOTAL = 2;
    public static final int TYPE_ISP_CMC = 3;
    public static final int TYPE_ISP_CNC = 2;
    public static final int TYPE_ISP_CTL = 1;
    public static final int TYPE_ISP_EDU = 4;
    public static final int TYPE_ISP_LOCALIZE = 6;
    public static final int TYPE_ISP_PUBLIC = 5;
    public static final int TYPE_ISP_UNKNOWN = 0;
    public static final int TYPE_NET_2G = 3;
    public static final int TYPE_NET_3G = 4;
    public static final int TYPE_NET_4G = 5;
    public static final int TYPE_NET_DISCONNECTED = 0;
    public static final int TYPE_NET_UNKNOWN = 1;
    public static final int TYPE_NET_WIFI = 2;
    public static final int TYPE_PRE_RESOLVE_NO = 0;
    public static final int TYPE_PRE_RESOLVE_YES = 1;
    public static final int TYPE_PROBE_METHOD_GET = 0;
    public static final int TYPE_PROBE_METHOD_HEAD = 1;
    public static final int TYPE_PROBE_PROTO_HTTP = 0;
    public static final int TYPE_PROBE_PROTO_HTTPS = 1;
    public static final int TYPE_PROTO_CACHED = 1;
    public static final int TYPE_PROTO_EXTERNAL = 5;
    public static final int TYPE_PROTO_HTTP = 3;
    public static final int TYPE_PROTO_LOCALDNS = 4;
    public static final int TYPE_PROTO_NONE = 0;
    public static final int TYPE_PROTO_UDP = 2;
    public static final int TYPE_RES_DATA_NULL = 2;
    public static final int TYPE_RES_ERR_CONNECTION = 9;
    public static final int TYPE_RES_ERR_DISCONNECTED = 10;
    public static final int TYPE_RES_ERR_HOST = 6;
    public static final int TYPE_RES_ERR_IP = 7;
    public static final int TYPE_RES_ERR_OTHER = 8;
    public static final int TYPE_RES_ERR_PARAM = 5;
    public static final int TYPE_RES_ERR_PARSE = 3;
    public static final int TYPE_RES_ERR_SERVER = 4;
    public static final int TYPE_RES_SUCCESS = 0;
    public static final int TYPE_RES_TIMEOUT = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public TypeTools() {
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
}
