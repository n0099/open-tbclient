package com.heytap.mcssdk.constant;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "appSecret";
    public static final String B = "registerID";
    public static final String C = "sdkVersion";
    public static final String D = "params";
    public static final String a = "message";
    public static final String b = "type";
    public static final String c = "messageID";
    public static final String d = "taskID";
    public static final String e = "appPackage";
    public static final String f = "title";
    public static final String g = "content";
    public static final String h = "globalID";
    public static final String i = "description";
    public static final String j = "notifyID";
    public static final String k = "eventId";
    public static final String l = "statistics_extra";
    public static final String m = "data_extra";
    public static final String n = "balanceTime";
    public static final String o = "timeRanges";
    public static final String p = "rule";
    public static final String q = "forcedDelivery";
    public static final String r = "distinctBycontent";
    public static final String s = "startDate";
    public static final String t = "endDate";
    public static final String u = "appID";
    public static final String v = "msg_command";
    public static final String w = "miniProgramPkg";
    public static final String x = "code";
    public static final String y = "command";
    public static final String z = "appKey";
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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
