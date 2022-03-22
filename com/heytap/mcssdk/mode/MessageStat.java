package com.heytap.mcssdk.mode;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class MessageStat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_PACKAGE = "appPackage";
    public static final String EVENT_ID = "eventID";
    public static final String EVENT_TIME = "eventTime";
    public static final String GLOBAL_ID = "globalID";
    public static final String MESSAGE_TYPE = "messageType";
    public static final String PROPERTY = "property";
    public static final String TASK_ID = "taskID";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAppPackage;
    public String mEventId;
    public long mEventTime;
    public String mGlobalId;
    public String mProperty;
    public String mTaskID;
    public int mType;

    public MessageStat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mType = 4096;
        this.mEventTime = System.currentTimeMillis();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageStat(int i, String str, String str2, String str3) {
        this(i, str, null, null, str2, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (String) objArr2[4], (String) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public MessageStat(int i, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3, str4, str5};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mType = 4096;
        this.mEventTime = System.currentTimeMillis();
        setType(i);
        setAppPackage(str);
        setGlobalId(str2);
        setTaskID(str3);
        setEventId(str4);
        setProperty(str5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageStat(String str, String str2) {
        this(4096, str, null, null, str2, "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (String) objArr2[4], (String) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageStat(String str, String str2, String str3) {
        this(4096, str, null, null, str2, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (String) objArr2[4], (String) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    public static MessageStat parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            MessageStat messageStat = new MessageStat();
            try {
                JSONObject jSONObject = new JSONObject(str);
                messageStat.setType(jSONObject.optInt("messageType", 0));
                messageStat.setAppPackage(jSONObject.optString("appPackage"));
                messageStat.setEventId(jSONObject.optString("eventID"));
                messageStat.setGlobalId(jSONObject.optString("globalID", ""));
                messageStat.setTaskID(jSONObject.optString("taskID", ""));
                messageStat.setProperty(jSONObject.optString(PROPERTY, ""));
                messageStat.setEventTime(jSONObject.optLong(EVENT_TIME, System.currentTimeMillis()));
                return messageStat;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (MessageStat) invokeL.objValue;
    }

    public String getAppPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAppPackage : (String) invokeV.objValue;
    }

    public String getEventId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mEventId : (String) invokeV.objValue;
    }

    public long getEventTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEventTime : invokeV.longValue;
    }

    public String getGlobalId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mGlobalId : (String) invokeV.objValue;
    }

    public String getProperty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mProperty : (String) invokeV.objValue;
    }

    public String getTaskID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTaskID : (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mType : invokeV.intValue;
    }

    public void setAppPackage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mAppPackage = str;
        }
    }

    public void setEventId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mEventId = str;
        }
    }

    public void setEventTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.mEventTime = j;
        }
    }

    public void setGlobalId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mGlobalId = str;
        }
    }

    public void setProperty(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mProperty = str;
        }
    }

    public void setTaskID(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mTaskID = String.valueOf(i);
        }
    }

    public void setTaskID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mTaskID = str;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mType = i;
        }
    }

    public String toJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("messageType", Integer.valueOf(this.mType));
                jSONObject.putOpt("eventID", this.mEventId);
                jSONObject.putOpt("appPackage", this.mAppPackage);
                jSONObject.putOpt(EVENT_TIME, Long.valueOf(this.mEventTime));
                if (!TextUtils.isEmpty(this.mGlobalId)) {
                    jSONObject.putOpt("globalID", this.mGlobalId);
                }
                if (!TextUtils.isEmpty(this.mTaskID)) {
                    jSONObject.putOpt("taskID", this.mTaskID);
                }
                if (!TextUtils.isEmpty(this.mProperty)) {
                    jSONObject.putOpt(PROPERTY, this.mProperty);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
