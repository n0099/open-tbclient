package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class cx implements Comparable<cx> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f190a;

    /* renamed from: a  reason: collision with other field name */
    public String f191a;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedList<cn> f192a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cx() {
        this(null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cx(String str) {
        this(str, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public cx(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f192a = new LinkedList<>();
        this.f190a = 0L;
        this.f191a = str;
        this.a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(cx cxVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cxVar)) == null) {
            if (cxVar == null) {
                return 1;
            }
            return cxVar.a - this.a;
        }
        return invokeL.intValue;
    }

    public synchronized cx a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            synchronized (this) {
                this.f190a = jSONObject.getLong("tt");
                this.a = jSONObject.getInt("wt");
                this.f191a = jSONObject.getString("host");
                JSONArray jSONArray = jSONObject.getJSONArray("ah");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f192a.add(new cn().a(jSONArray.getJSONObject(i)));
                }
            }
            return this;
        }
        return (cx) invokeL.objValue;
    }

    public synchronized JSONObject a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                jSONObject = new JSONObject();
                jSONObject.put("tt", this.f190a);
                jSONObject.put("wt", this.a);
                jSONObject.put("host", this.f191a);
                JSONArray jSONArray = new JSONArray();
                Iterator<cn> it = this.f192a.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().m256a());
                }
                jSONObject.put("ah", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public synchronized void a(cn cnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cnVar) == null) {
            synchronized (this) {
                if (cnVar != null) {
                    this.f192a.add(cnVar);
                    int a = cnVar.a();
                    if (a > 0) {
                        this.a += cnVar.a();
                    } else {
                        int i = 0;
                        for (int size = this.f192a.size() - 1; size >= 0 && this.f192a.get(size).a() < 0; size--) {
                            i++;
                        }
                        this.a += a * i;
                    }
                    if (this.f192a.size() > 30) {
                        this.a -= this.f192a.remove().a();
                    }
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f191a + ":" + this.a;
        }
        return (String) invokeV.objValue;
    }
}
