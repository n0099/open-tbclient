package org.apache.commons.lang3.exception;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
/* loaded from: classes5.dex */
public class DefaultExceptionContext implements ExceptionContext, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 20110706;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Pair<String, Object>> contextValues;

    public DefaultExceptionContext() {
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
        this.contextValues = new ArrayList();
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Pair<String, Object>> getContextEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.contextValues : (List) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Set<String> getContextLabels() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashSet hashSet = new HashSet();
            for (Pair<String, Object> pair : this.contextValues) {
                hashSet.add(pair.getKey());
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Object> getContextValues(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Pair<String, Object> pair : this.contextValues) {
                if (StringUtils.equals(str, pair.getKey())) {
                    arrayList.add(pair.getValue());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Object getFirstContextValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            for (Pair<String, Object> pair : this.contextValues) {
                if (StringUtils.equals(str, pair.getKey())) {
                    return pair.getValue();
                }
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public String getFormattedExceptionMessage(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            StringBuilder sb = new StringBuilder(256);
            if (str != null) {
                sb.append(str);
            }
            if (this.contextValues.size() > 0) {
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                sb.append("Exception Context:\n");
                int i2 = 0;
                for (Pair<String, Object> pair : this.contextValues) {
                    sb.append("\t[");
                    i2++;
                    sb.append(i2);
                    sb.append(':');
                    sb.append(pair.getKey());
                    sb.append("=");
                    Object value = pair.getValue();
                    if (value == null) {
                        sb.append(StringUtil.NULL_STRING);
                    } else {
                        try {
                            str2 = value.toString();
                        } catch (Exception e2) {
                            str2 = "Exception thrown on toString(): " + ExceptionUtils.getStackTrace(e2);
                        }
                        sb.append(str2);
                    }
                    sb.append("]\n");
                }
                sb.append("---------------------------------");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public DefaultExceptionContext addContextValue(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
            this.contextValues.add(new ImmutablePair(str, obj));
            return this;
        }
        return (DefaultExceptionContext) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public DefaultExceptionContext setContextValue(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, obj)) == null) {
            Iterator<Pair<String, Object>> it = this.contextValues.iterator();
            while (it.hasNext()) {
                if (StringUtils.equals(str, it.next().getKey())) {
                    it.remove();
                }
            }
            addContextValue(str, obj);
            return this;
        }
        return (DefaultExceptionContext) invokeLL.objValue;
    }
}
