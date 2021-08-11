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
/* loaded from: classes10.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
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

    public long getDelayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dtime : invokeV.longValue;
    }

    public long getFtime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ftime : invokeV.longValue;
    }

    public long getLingerTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.ltime : invokeV.longValue;
    }

    public long getStime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.stime : invokeV.longValue;
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

    public void setDtime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.dtime = j2;
        }
    }

    public void setFtime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.ftime = j2;
        }
    }

    public void setLingerTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            this.ltime = j2;
        }
    }

    public void setStime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            this.stime = j2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "stime=" + this.stime + " ftime(millis)=" + this.ftime + " ltime(millis)=" + this.ltime + " dtime(millis)=" + this.dtime;
        }
        return (String) invokeV.objValue;
    }

    public AppaElemInfo(long j2, long j3, long j4, long j5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.stime = j2;
        this.ftime = j3;
        this.ltime = j4;
        this.dtime = j5;
    }
}
