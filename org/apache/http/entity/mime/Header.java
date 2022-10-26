package org.apache.http.entity.mime;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes8.dex */
public class Header implements Iterable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map fieldMap;
    public final List fields;

    public Header() {
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
        this.fields = new LinkedList();
        this.fieldMap = new HashMap();
    }

    public List getFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new ArrayList(this.fields);
        }
        return (List) invokeV.objValue;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return Collections.unmodifiableList(this.fields).iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.fields.toString();
        }
        return (String) invokeV.objValue;
    }

    public void addField(MinimalField minimalField) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, minimalField) != null) || minimalField == null) {
            return;
        }
        String lowerCase = minimalField.getName().toLowerCase(Locale.US);
        List list = (List) this.fieldMap.get(lowerCase);
        if (list == null) {
            list = new LinkedList();
            this.fieldMap.put(lowerCase, list);
        }
        list.add(minimalField);
        this.fields.add(minimalField);
    }

    public MinimalField getField(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null) {
                return null;
            }
            List list = (List) this.fieldMap.get(str.toLowerCase(Locale.US));
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (MinimalField) list.get(0);
        }
        return (MinimalField) invokeL.objValue;
    }

    public List getFields(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str == null) {
                return null;
            }
            List list = (List) this.fieldMap.get(str.toLowerCase(Locale.US));
            if (list != null && !list.isEmpty()) {
                return new ArrayList(list);
            }
            return Collections.emptyList();
        }
        return (List) invokeL.objValue;
    }

    public int removeFields(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                return 0;
            }
            List list = (List) this.fieldMap.remove(str.toLowerCase(Locale.US));
            if (list == null || list.isEmpty()) {
                return 0;
            }
            this.fields.removeAll(list);
            return list.size();
        }
        return invokeL.intValue;
    }

    public void setField(MinimalField minimalField) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, minimalField) != null) || minimalField == null) {
            return;
        }
        List list = (List) this.fieldMap.get(minimalField.getName().toLowerCase(Locale.US));
        if (list != null && !list.isEmpty()) {
            list.clear();
            list.add(minimalField);
            int i = 0;
            Iterator it = this.fields.iterator();
            int i2 = -1;
            while (it.hasNext()) {
                if (((MinimalField) it.next()).getName().equalsIgnoreCase(minimalField.getName())) {
                    it.remove();
                    if (i2 == -1) {
                        i2 = i;
                    }
                }
                i++;
            }
            this.fields.add(i2, minimalField);
            return;
        }
        addField(minimalField);
    }
}
