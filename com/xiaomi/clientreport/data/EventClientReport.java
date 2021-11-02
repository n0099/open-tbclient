package com.xiaomi.clientreport.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.MessageStat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class EventClientReport extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String eventContent;
    public String eventId;
    public long eventTime;
    public int eventType;

    public EventClientReport() {
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

    public static EventClientReport getBlankInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new EventClientReport() : (EventClientReport) invokeV.objValue;
    }

    @Override // com.xiaomi.clientreport.data.a
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject json = super.toJson();
                if (json == null) {
                    return null;
                }
                json.put(TbEnum.SystemMessage.KEY_EVENT_ID, this.eventId);
                json.put("eventType", this.eventType);
                json.put(MessageStat.EVENT_TIME, this.eventTime);
                json.put("eventContent", this.eventContent == null ? "" : this.eventContent);
                return json;
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.xiaomi.clientreport.data.a
    public String toJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.toJsonString() : (String) invokeV.objValue;
    }
}
