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
public class PageElemInfo extends ParamableElem implements Elem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -5734456734934257499L;
    public transient /* synthetic */ FieldHolder $fh;
    public long dtime;
    public long ltime;
    public String npage;
    public String page;
    public long stime;

    public PageElemInfo() {
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

    public String getDestinationPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.npage;
        }
        return (String) invokeV.objValue;
    }

    public long getLingerTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.ltime;
        }
        return invokeV.longValue;
    }

    public String getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.page;
        }
        return (String) invokeV.objValue;
    }

    public long getStime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.stime;
        }
        return invokeV.longValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!Util.empty(this.page) && !Util.empty(this.npage)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public PageElemInfo(String str, String str2, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.page = str;
        this.npage = str2;
        this.ltime = j;
        this.dtime = j2;
        this.stime = j3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, objectInputStream) == null) {
            this.page = (String) objectInputStream.readObject();
            this.npage = (String) objectInputStream.readObject();
            this.ltime = objectInputStream.readLong();
            this.dtime = objectInputStream.readLong();
            this.stime = objectInputStream.readLong();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, objectOutputStream) == null) {
            objectOutputStream.writeObject(this.page);
            objectOutputStream.writeObject(this.npage);
            objectOutputStream.writeLong(this.ltime);
            objectOutputStream.writeLong(this.dtime);
            objectOutputStream.writeLong(this.stime);
        }
    }

    public void setDestinationPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.npage = str;
        }
    }

    public void setDtime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.dtime = j;
        }
    }

    public void setLtime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.ltime = j;
        }
    }

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.page = str;
        }
    }

    public void setStime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.stime = j;
        }
    }

    public PageElemInfo copy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PageElemInfo pageElemInfo = new PageElemInfo();
            pageElemInfo.dtime = this.dtime;
            pageElemInfo.ltime = this.ltime;
            pageElemInfo.stime = this.stime;
            pageElemInfo.page = this.page;
            pageElemInfo.npage = this.npage;
            pageElemInfo.addParams(new ArrayList(getParams()));
            return pageElemInfo;
        }
        return (PageElemInfo) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.obj.Elem
    public String getStringRep() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Util.replaceEncode(this.page, ":"));
            sb.append(":");
            sb.append(Util.replaceEncode(this.npage, ":"));
            sb.append(":");
            sb.append(this.stime);
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return " page=" + this.page + ", dest page=" + this.npage + ", stime=" + this.stime + ", lingertime=" + this.ltime + ", dtime=" + this.dtime;
        }
        return (String) invokeV.objValue;
    }
}
