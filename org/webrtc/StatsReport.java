package org.webrtc;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class StatsReport {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String id;
    public final double timestamp;
    public final String type;
    public final Value[] values;

    /* loaded from: classes10.dex */
    public static class Value {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String name;
        public final String value;

        @CalledByNative("Value")
        public Value(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.value = str2;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return PreferencesUtil.LEFT_MOUNT + this.name + ": " + this.value + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    @CalledByNative
    public StatsReport(String str, String str2, double d2, Value[] valueArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Double.valueOf(d2), valueArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.id = str;
        this.type = str2;
        this.timestamp = d2;
        this.values = valueArr;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (String) invokeV.objValue;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(this.id);
        sb.append(", type: ");
        sb.append(this.type);
        sb.append(", timestamp: ");
        sb.append(this.timestamp);
        sb.append(", values: ");
        int i2 = 0;
        while (true) {
            Value[] valueArr = this.values;
            if (i2 >= valueArr.length) {
                return sb.toString();
            }
            sb.append(valueArr[i2].toString());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            i2++;
        }
    }
}
