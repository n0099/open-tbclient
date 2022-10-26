package com.yy.hiidostatis.defs.obj;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.Util;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class AppaElemInfo extends ParamableElem implements Elem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 5075819899173282579L;
    public transient /* synthetic */ FieldHolder $fh;
    public long dtime;
    public long ftime;
    public long ltime;
    public long stime;

    public AppaElemInfo() {
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

    public long getDelayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.dtime;
        }
        return invokeV.longValue;
    }

    public long getFtime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.ftime;
        }
        return invokeV.longValue;
    }

    public long getLingerTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.ltime;
        }
        return invokeV.longValue;
    }

    public long getStime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.stime;
        }
        return invokeV.longValue;
    }

    public AppaElemInfo(long j, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.stime = j;
        this.ftime = j2;
        this.ltime = j3;
        this.dtime = j4;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, objectInputStream) == null) {
            this.stime = objectInputStream.readLong();
            this.ftime = objectInputStream.readLong();
            this.ltime = objectInputStream.readLong();
            this.dtime = objectInputStream.readLong();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, objectOutputStream) == null) {
            objectOutputStream.writeLong(this.stime);
            objectOutputStream.writeLong(this.ftime);
            objectOutputStream.writeLong(this.ltime);
            objectOutputStream.writeLong(this.dtime);
        }
    }

    public void setDtime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.dtime = j;
        }
    }

    public void setFtime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.ftime = j;
        }
    }

    public void setLingerTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.ltime = j;
        }
    }

    public void setStime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.stime = j;
        }
    }

    public AppaElemInfo copy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AppaElemInfo appaElemInfo = new AppaElemInfo();
            appaElemInfo.dtime = this.dtime;
            appaElemInfo.ftime = this.ftime;
            appaElemInfo.ltime = this.ltime;
            appaElemInfo.stime = this.stime;
            appaElemInfo.addParams(new ArrayList(getParams()));
            return appaElemInfo;
        }
        return (AppaElemInfo) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "stime=" + this.stime + " ftime(millis)=" + this.ftime + " ltime(millis)=" + this.ltime + " dtime(millis)=" + this.dtime;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.obj.Elem
    public String getStringRep() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.stime);
            sb.append(":");
            sb.append(this.ftime);
            sb.append(":");
            sb.append(this.ltime);
            sb.append(":");
            sb.append(this.dtime);
            sb.append(":");
            String connectedParams = getConnectedParams();
            if (!Util.empty(connectedParams)) {
                sb.append(Util.replaceEncode(connectedParams, ":"));
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
