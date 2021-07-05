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
/* loaded from: classes10.dex */
public class RTCStats {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String id;
    public final Map<String, Object> members;
    public final long timestampUs;
    public final String type;

    public RTCStats(long j, String str, String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str, str2, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public static void appendValue(StringBuilder sb, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, sb, obj) == null) {
            if (!(obj instanceof Object[])) {
                if (!(obj instanceof String)) {
                    sb.append(obj);
                    return;
                }
                sb.append(Typography.quote);
                sb.append(obj);
                sb.append(Typography.quote);
                return;
            }
            Object[] objArr = (Object[]) obj;
            sb.append('[');
            for (int i2 = 0; i2 < objArr.length; i2++) {
                if (i2 != 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                appendValue(sb, objArr[i2]);
            }
            sb.append(']');
        }
    }

    @CalledByNative
    public static RTCStats create(long j, String str, String str2, Map map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), str, str2, map})) == null) ? new RTCStats(j, str, str2, map) : (RTCStats) invokeCommon.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : (String) invokeV.objValue;
    }

    public Map<String, Object> getMembers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.members : (Map) invokeV.objValue;
    }

    public double getTimestampUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.timestampUs : invokeV.doubleValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.type : (String) invokeV.objValue;
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
            for (Map.Entry<String, Object> entry : this.members.entrySet()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(entry.getKey());
                sb.append(": ");
                appendValue(sb, entry.getValue());
            }
            sb.append(" }");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
