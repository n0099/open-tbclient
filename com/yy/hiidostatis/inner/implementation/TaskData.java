package com.yy.hiidostatis.inner.implementation;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.message.utils.NoNull;
import java.io.Serializable;
import java.util.UUID;
/* loaded from: classes8.dex */
public class TaskData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MAGIC_MD5 = "hd!@#$%";
    public static final long serialVersionUID = -3875880932357283826L;
    public transient /* synthetic */ FieldHolder $fh;
    public String act;
    public long aid;
    public String appkey;
    public String content;
    public int crepid;
    public String dataId;
    public long order;
    public int packId;
    public int remain;
    public long time;
    public int tryTimes;
    public String verifyMd5;

    public TaskData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.time = currentTimeMillis;
        this.order = currentTimeMillis;
        this.act = str;
    }

    public String createDataId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return UUID.randomUUID().toString().replaceAll("-", "");
            } catch (Throwable unused) {
                return String.valueOf((long) (Math.random() * 1.0E9d));
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean verifyMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (getVerifyMd5() != null && getVerifyMd5().trim().length() != 0 && !getVerifyMd5().equals(createVerifyMd5())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public String createVerifyMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return Coder.encryptMD5(String.format("%s%s", this.content, MAGIC_MD5));
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String getAct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.act;
        }
        return (String) invokeV.objValue;
    }

    public long getAid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.aid;
        }
        return invokeV.longValue;
    }

    public String getAppkey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!NoNull.isEmpty(this.appkey)) {
                return this.appkey;
            }
            return Util.parseParam(this.content, "appkey");
        }
        return (String) invokeV.objValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public int getCrepid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.crepid;
        }
        return invokeV.intValue;
    }

    public String getDataId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.dataId;
        }
        return (String) invokeV.objValue;
    }

    public long getOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.order;
        }
        return invokeV.longValue;
    }

    public int getPackId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.packId;
        }
        return invokeV.intValue;
    }

    public int getRemain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.remain;
        }
        return invokeV.intValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.time;
        }
        return invokeV.longValue;
    }

    public int getTryTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.tryTimes;
        }
        return invokeV.intValue;
    }

    public String getVerifyMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.verifyMd5;
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return getDataId().hashCode();
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (hashCode() == obj.hashCode()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.aid = j;
        }
    }

    public void setAppkey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.appkey = str;
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.content = str;
        }
    }

    public void setCrepid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.crepid = i;
        }
    }

    public void setDataId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.dataId = str;
        }
    }

    public void setOrder(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.order = j;
        }
    }

    public void setPackId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.packId = i;
        }
    }

    public void setRemain(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.remain = i;
        }
    }

    public void setTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.time = j;
        }
    }

    public void setTryTimes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.tryTimes = i;
        }
    }

    public void setVerifyMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.verifyMd5 = str;
        }
    }
}
