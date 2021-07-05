package com.heytap.mcssdk.mode;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_ID = "appID";
    public static final String APP_PACKAGE = "appPackage";
    public static final String BALANCE_TIME = "balanceTime";
    public static final String CONTENT = "content";
    public static final int CONTENT_DISTINCT = 1;
    public static final int CONTENT__NOT_DISTINCT = 0;
    public static final int DELIVERY_FORCED = 1;
    public static final int DELIVERY_NOT_FORCED = 0;
    public static final String DESCRIPTION = "description";
    public static final String DISTINCT_CONTENT = "distinctBycontent";
    public static final String END_DATE = "endDate";
    public static final String FORCED_DELIVERY = "forcedDelivery";
    public static final String GLOBAL_ID = "globalID";
    public static final String MESSAGE = "message";
    public static final int MESSAGE_ALARM = 4100;
    public static final int MESSAGE_APP = 4098;
    public static final int MESSAGE_BASE = 4096;
    public static final int MESSAGE_CMD_DATA = 4105;
    public static final int MESSAGE_FIND_PHONE = 4101;
    public static final String MESSAGE_ID = "messageID";
    public static final int MESSAGE_LAUNCH_ALARM = 4102;
    public static final int MESSAGE_NOTIFICATION = 4097;
    public static final int MESSAGE_P2P = 4099;
    public static final int MESSAGE_SMS_DATA = 4106;
    public static final int MESSAGE_SPT_DATA = 4103;
    public static final int MESSAGE_STAT = 4196;
    public static final String PRIORITY = "priority";
    public static final String RULE = "rule";
    public static final String SHOW_MODE = "showMode";
    public static final String START_DATE = "startDate";
    public static final String TASK_ID = "taskID";
    public static final String TIME_RANGES = "timeRanges";
    public static final String TITLE = "title";
    public static final String TYPE = "type";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAppPackage;
    public int mMessageID;
    public String mTaskID;

    public Message() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTaskID = "";
    }

    public String getAppPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAppPackage : (String) invokeV.objValue;
    }

    public int getMessageID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMessageID : invokeV.intValue;
    }

    public String getTaskID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mTaskID : (String) invokeV.objValue;
    }

    public abstract int getType();

    public void setAppPackage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.mAppPackage = str;
        }
    }

    public void setMessageID(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mMessageID = i2;
        }
    }

    public void setTaskID(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mTaskID = String.valueOf(i2);
        }
    }

    public void setTaskID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mTaskID = str;
        }
    }
}
