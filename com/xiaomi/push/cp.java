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
public class cp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f42933a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<co> f195a;

    public cp() {
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
        this.f195a = new ArrayList<>();
    }

    public cp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f195a = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f42933a = str;
    }

    public synchronized co a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                for (int size = this.f195a.size() - 1; size >= 0; size--) {
                    co coVar = this.f195a.get(size);
                    if (coVar.m222a()) {
                        cs.a().m232a(coVar.a());
                        return coVar;
                    }
                }
                return null;
            }
        }
        return (co) invokeV.objValue;
    }

    public synchronized cp a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            synchronized (this) {
                this.f42933a = jSONObject.getString("host");
                JSONArray jSONArray = jSONObject.getJSONArray("fbs");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f195a.add(new co(this.f42933a).a(jSONArray.getJSONObject(i2)));
                }
            }
            return this;
        }
        return (cp) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m223a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f42933a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<co> m224a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f195a : (ArrayList) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m225a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                jSONObject = new JSONObject();
                jSONObject.put("host", this.f42933a);
                JSONArray jSONArray = new JSONArray();
                Iterator<co> it = this.f195a.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().m220a());
                }
                jSONObject.put("fbs", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public synchronized void a(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, coVar) == null) {
            synchronized (this) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f195a.size()) {
                        break;
                    } else if (this.f195a.get(i2).a(coVar)) {
                        this.f195a.set(i2, coVar);
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= this.f195a.size()) {
                    this.f195a.add(coVar);
                }
            }
        }
    }

    public synchronized void a(boolean z) {
        ArrayList<co> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            synchronized (this) {
                for (int size = this.f195a.size() - 1; size >= 0; size--) {
                    co coVar = this.f195a.get(size);
                    if (z) {
                        if (coVar.c()) {
                            arrayList = this.f195a;
                            arrayList.remove(size);
                        }
                    } else if (!coVar.b()) {
                        arrayList = this.f195a;
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
            sb.append(this.f42933a);
            sb.append("\n");
            Iterator<co> it = this.f195a.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
