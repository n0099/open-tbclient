package com.yy.hiidostatis.defs.obj;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public class Info implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIVIDE_ELEM = "|";
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public List elems;

    public Info() {
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
        this.elems = new CopyOnWriteArrayList();
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.elems.clear();
        }
    }

    public int getElemsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.elems.size();
        }
        return invokeV.intValue;
    }

    public Iterator iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.elems.iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, objectInputStream) == null) {
            try {
                this.elems = (List) objectInputStream.readObject();
            } catch (Throwable th) {
                L.debug(this, "Failed to read object from stream for %s", th);
                this.elems = new CopyOnWriteArrayList();
            }
            if (this.elems == null) {
                L.brief("read elements is null, create an empty array list.", new Object[0]);
                this.elems = new ArrayList();
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, objectOutputStream) == null) {
            objectOutputStream.writeObject(this.elems);
        }
    }

    public void add(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, info) == null) {
            Iterator it = info.iterator();
            while (it.hasNext()) {
                addElem((Elem) it.next());
            }
        }
    }

    public void addElem(Elem elem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, elem) != null) || elem == null) {
            return;
        }
        this.elems.add(elem);
    }

    public Elem getElem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (Elem) this.elems.get(i);
        }
        return (Elem) invokeI.objValue;
    }

    public void removeElem(Elem elem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, elem) != null) || elem == null) {
            return;
        }
        this.elems.remove(elem);
    }

    public String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (Util.empty(this.elems)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (Elem elem : this.elems) {
                sb.append(Util.replaceEncode(elem.getStringRep(), "|"));
                sb.append("|");
            }
            String sb2 = sb.toString();
            if (sb2.length() <= 1) {
                return sb2;
            }
            return sb2.substring(0, sb2.length() - 1);
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            for (Elem elem : this.elems) {
                sb.append(elem.toString());
                sb.append(" ");
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
