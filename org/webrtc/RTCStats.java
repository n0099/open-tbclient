package org.webrtc;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.text.Typography;
/* loaded from: classes8.dex */
public class RTCStats {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String id;
    public final Map members;
    public final long timestampUs;
    public final String type;

    public RTCStats(long j, String str, String str2, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str, str2, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.timestampUs = j;
        this.type = str;
        this.id = str2;
        this.members = map;
    }

    public static RTCStats create(long j, String str, String str2, Map map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), str, str2, map})) == null) {
            return new RTCStats(j, str, str2, map);
        }
        return (RTCStats) invokeCommon.objValue;
    }

    public static void appendValue(StringBuilder sb, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, sb, obj) == null) {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                sb.append('[');
                for (int i = 0; i < objArr.length; i++) {
                    if (i != 0) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                    appendValue(sb, objArr[i]);
                }
                sb.append(']');
            } else if (obj instanceof String) {
                sb.append(Typography.quote);
                sb.append(obj);
                sb.append(Typography.quote);
            } else {
                sb.append(obj);
            }
        }
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.id;
        }
        return (String) invokeV.objValue;
    }

    public Map getMembers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.members;
        }
        return (Map) invokeV.objValue;
    }

    public double getTimestampUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.timestampUs;
        }
        return invokeV.doubleValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.type;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("{ timestampUs: ");
            sb.append(this.timestampUs);
            sb.append(", type: ");
            sb.append(this.type);
            sb.append(", id: ");
            sb.append(this.id);
            for (Map.Entry entry : this.members.entrySet()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append((String) entry.getKey());
                sb.append(": ");
                appendValue(sb, entry.getValue());
            }
            sb.append(" }");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
