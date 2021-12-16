package com.yy.hiidostatis.defs.obj;

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
import java.io.Serializable;
import java.util.LinkedHashMap;
/* loaded from: classes4.dex */
public class Property implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIVIDE_PROPERTY = ",";
    public static final int MAX_EVENT_FIELD_BYTES = 256;
    public static final int MAX_SIZE = 30;
    public static final long serialVersionUID = -6839046473425691433L;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedHashMap<String, PropertyPair> mParams;

    public Property() {
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
        this.mParams = new LinkedHashMap<>(30);
    }

    private boolean isOverSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.mParams.size() >= 30 : invokeV.booleanValue;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, objectInputStream) == null) {
            LinkedHashMap<String, PropertyPair> linkedHashMap = (LinkedHashMap) objectInputStream.readObject();
            this.mParams = linkedHashMap;
            if (linkedHashMap == null) {
                this.mParams = new LinkedHashMap<>();
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, objectOutputStream) == null) {
            objectOutputStream.writeObject(this.mParams);
        }
    }

    public synchronized void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.mParams.clear();
            }
        }
    }

    public synchronized boolean containsKey(String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                containsKey = this.mParams.containsKey(str);
            }
            return containsKey;
        }
        return invokeL.booleanValue;
    }

    public synchronized Property copy() {
        InterceptResult invokeV;
        Property property;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                property = new Property();
                if (this.mParams != null) {
                    property.mParams.putAll(this.mParams);
                }
            }
            return property;
        }
        return (Property) invokeV.objValue;
    }

    public synchronized String getConnectedPropertys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                LinkedHashMap<String, PropertyPair> linkedHashMap = this.mParams;
                if (linkedHashMap != null && linkedHashMap.size() != 0) {
                    if (linkedHashMap.size() == 1) {
                        return Util.replaceEncode(linkedHashMap.values().iterator().next().getConnectedPair(), ",");
                    }
                    StringBuilder sb = new StringBuilder();
                    for (PropertyPair propertyPair : linkedHashMap.values()) {
                        sb.append(Util.replaceEncode(propertyPair.getConnectedPair(), ","));
                        sb.append(",");
                    }
                    sb.replace(sb.length() - 1, sb.length(), "");
                    return sb.toString();
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized void putDouble(String str, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Double.valueOf(d2)}) == null) {
            synchronized (this) {
                if (isOverSize()) {
                    L.warn(this, "Property max size is %d,now is %d,so get up this inParam:key=[%s],value=[%s]", 30, Integer.valueOf(size()), str + "", d2 + "");
                } else if (Util.empty(str)) {
                    L.debug(this, "key is not allow null.", new Object[0]);
                } else if (str.getBytes().length > 256) {
                    L.warn(this, "key[%s] bytes[%d] must under %d bytes", str, Integer.valueOf(str.getBytes().length), 256);
                } else {
                    this.mParams.put(str, new PropertyPair(str, d2));
                }
            }
        }
    }

    public synchronized void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            synchronized (this) {
                if (!isOverSize()) {
                    if (Util.empty(str)) {
                        L.debug(this, "key is not allow null.", new Object[0]);
                        return;
                    } else {
                        this.mParams.put(str, new PropertyPair(str, str2));
                        return;
                    }
                }
                L.warn(this, "Property max size is %d,now is %d,so get up this inParam:key=[%s],value=[%s]", 30, Integer.valueOf(size()), str + "", str2 + "");
            }
        }
    }

    public synchronized boolean removeProperty(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            synchronized (this) {
                z = this.mParams.remove(str) != null;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public synchronized int size() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                size = this.mParams.size();
            }
            return size;
        }
        return invokeV.intValue;
    }
}
