package com.yy.hiidostatis.defs.obj;

import android.text.TextUtils;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ParamableElem implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIVIDE_PARAM = ";";
    public static final String DIVIDE_PARAM_TMP = "@@$$@@";
    public static final long serialVersionUID = 6761787877387462101L;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> mParams;

    public ParamableElem() {
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
        this.mParams = new ArrayList<>();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, objectInputStream) == null) {
            ArrayList<String> arrayList = (ArrayList) objectInputStream.readObject();
            this.mParams = arrayList;
            if (arrayList == null) {
                this.mParams = new ArrayList<>();
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, objectOutputStream) == null) {
            objectOutputStream.writeObject(this.mParams);
        }
    }

    public ParamableElem addParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.mParams.add(Util.asEmptyOnNull(str));
            return this;
        }
        return (ParamableElem) invokeL.objValue;
    }

    public ParamableElem addParams(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            this.mParams.addAll(list);
            return this;
        }
        return (ParamableElem) invokeL.objValue;
    }

    public ParamableElem clearParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.mParams.clear();
            return this;
        }
        return (ParamableElem) invokeV.objValue;
    }

    public String getConnectedParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<String> arrayList = this.mParams;
            if (Util.empty(arrayList)) {
                return null;
            }
            if (arrayList.size() == 1) {
                return Util.replaceEncode(arrayList.get(0), DIVIDE_PARAM);
            }
            return Util.replaceEncode(TextUtils.join(DIVIDE_PARAM_TMP, arrayList.toArray(new String[arrayList.size()])), DIVIDE_PARAM).replace(DIVIDE_PARAM_TMP, DIVIDE_PARAM);
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<String> getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new ArrayList<>(this.mParams) : (ArrayList) invokeV.objValue;
    }

    public boolean isSameParams(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, strArr)) == null) {
            if (this.mParams.isEmpty()) {
                return strArr.length == 0;
            } else if (this.mParams.size() != strArr.length) {
                return false;
            } else {
                for (int i = 0; i < strArr.length; i++) {
                    if (!strArr[i].equals(this.mParams.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
