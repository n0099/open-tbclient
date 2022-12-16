package org.json.alipay;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList a;

    public a() {
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
        this.a = new ArrayList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Object obj) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (!obj.getClass().isArray()) {
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
        int length = Array.getLength(obj);
        for (int i3 = 0; i3 < length; i3++) {
            this.a.add(Array.get(obj, i3));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        this(new c(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public a(Collection collection) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(c cVar) {
        this();
        char c;
        ArrayList arrayList;
        Object d;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        char c2 = cVar.c();
        if (c2 == '[') {
            c = ']';
        } else if (c2 != '(') {
            throw cVar.a("A JSONArray text must start with '['");
        } else {
            c = ')';
        }
        if (cVar.c() == ']') {
            return;
        }
        do {
            cVar.a();
            char c3 = cVar.c();
            cVar.a();
            if (c3 == ',') {
                arrayList = this.a;
                d = null;
            } else {
                arrayList = this.a;
                d = cVar.d();
            }
            arrayList.add(d);
            char c4 = cVar.c();
            if (c4 != ')') {
                if (c4 != ',' && c4 != ';') {
                    if (c4 != ']') {
                        throw cVar.a("Expected a ',' or ']'");
                    }
                }
            }
            if (c == c4) {
                return;
            }
            throw cVar.a("Expected a '" + new Character(c) + "'");
        } while (cVar.c() != ']');
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            int size = this.a.size();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    stringBuffer.append(str);
                }
                stringBuffer.append(b.a(this.a.get(i)));
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    public final Object a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            Object obj = (i < 0 || i >= this.a.size()) ? null : this.a.get(i);
            if (obj != null) {
                return obj;
            }
            throw new JSONException("JSONArray[" + i + "] not found.");
        }
        return invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return PreferencesUtil.LEFT_MOUNT + a(",") + ']';
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
