package com.yy.hiidostatis.defs.obj;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes8.dex */
public class EventElementInfo extends ParamableElem implements Elem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final transient int CTYPE_CLICK_TIMES_REPORT = 1;
    public static final transient int CTYPE_CUSTOM_REPORT = 0;
    public static final transient int DEFAULT_CVALUE = 0;
    public static final long serialVersionUID = 7740962417443813455L;
    public transient /* synthetic */ FieldHolder $fh;
    public String cid;
    public int ctype;
    public String cvalue;
    public Property property;

    public EventElementInfo(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.property = new Property();
        this.cid = str;
        this.ctype = 1;
        this.cvalue = Integer.toString(i);
    }

    public EventElementInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.property = new Property();
        this.cid = str;
        this.ctype = 0;
        this.cvalue = str2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, objectInputStream) == null) {
            this.cid = (String) objectInputStream.readObject();
            this.ctype = objectInputStream.readInt();
            this.cvalue = objectInputStream.readUTF();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, objectOutputStream) == null) {
            objectOutputStream.writeObject(this.cid);
            objectOutputStream.writeInt(this.ctype);
            objectOutputStream.writeUTF(this.cvalue);
        }
    }

    public void setCid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.cid = str;
        }
    }

    public void setCtype(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.ctype = i;
        }
    }

    public void setCustomValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (this.ctype == 1) {
                try {
                    Long.parseLong(str);
                } catch (NumberFormatException e) {
                    L.debug(this, "Input arg error %s for %s", str, e);
                }
            }
            this.cvalue = str;
        }
    }

    public void setProperty(Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, property) == null) {
            this.property = property;
        }
    }

    public String getCustomValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.cvalue;
        }
        return (String) invokeV.objValue;
    }

    public String getEventId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.cid;
        }
        return (String) invokeV.objValue;
    }

    public int getEventType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.ctype;
        }
        return invokeV.intValue;
    }

    public Property getProperty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.property;
        }
        return (Property) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.obj.Elem
    public String getStringRep() {
        InterceptResult invokeV;
        String connectedPropertys;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Util.replaceEncode(this.cid, ":"));
            sb.append(":");
            sb.append(this.ctype);
            sb.append(":");
            sb.append(Util.replaceEncode(this.cvalue, ":"));
            sb.append(":");
            String connectedParams = getConnectedParams();
            if (!Util.empty(connectedParams)) {
                sb.append(Util.replaceEncode(connectedParams, ":"));
            }
            sb.append(":");
            Property property = this.property;
            if (property == null) {
                connectedPropertys = null;
            } else {
                connectedPropertys = property.getConnectedPropertys();
            }
            if (!Util.empty(connectedPropertys)) {
                sb.append(Util.replaceEncode(connectedPropertys, ":"));
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("eventId=");
            sb.append(this.cid);
            sb.append(", event type=");
            if (this.ctype == 0) {
                str = "Custom";
            } else {
                str = "Times";
            }
            sb.append(str);
            sb.append(", value=");
            sb.append(this.cvalue);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
