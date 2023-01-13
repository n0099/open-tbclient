package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class cs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<cr> f208a;

    public cs() {
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
        this.f208a = new ArrayList<>();
    }

    public cs(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f208a = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.a = str;
    }

    public synchronized cr a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                for (int size = this.f208a.size() - 1; size >= 0; size--) {
                    cr crVar = this.f208a.get(size);
                    if (crVar.m260a()) {
                        cv.a().m270a(crVar.a());
                        return crVar;
                    }
                }
                return null;
            }
        }
        return (cr) invokeV.objValue;
    }

    public synchronized cs a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            synchronized (this) {
                this.a = jSONObject.getString("host");
                JSONArray jSONArray = jSONObject.getJSONArray("fbs");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f208a.add(new cr(this.a).a(jSONArray.getJSONObject(i)));
                }
            }
            return this;
        }
        return (cs) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m261a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<cr> m262a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f208a : (ArrayList) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m263a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                jSONObject = new JSONObject();
                jSONObject.put("host", this.a);
                JSONArray jSONArray = new JSONArray();
                Iterator<cr> it = this.f208a.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().m258a());
                }
                jSONObject.put("fbs", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public synchronized void a(cr crVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, crVar) == null) {
            synchronized (this) {
                int i = 0;
                while (true) {
                    if (i >= this.f208a.size()) {
                        break;
                    } else if (this.f208a.get(i).a(crVar)) {
                        this.f208a.set(i, crVar);
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= this.f208a.size()) {
                    this.f208a.add(crVar);
                }
            }
        }
    }

    public synchronized void a(boolean z) {
        ArrayList<cr> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            synchronized (this) {
                for (int size = this.f208a.size() - 1; size >= 0; size--) {
                    cr crVar = this.f208a.get(size);
                    if (z) {
                        if (crVar.c()) {
                            arrayList = this.f208a;
                            arrayList.remove(size);
                        }
                    } else if (!crVar.b()) {
                        arrayList = this.f208a;
                        arrayList.remove(size);
                    }
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("\n");
            Iterator<cr> it = this.f208a.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
