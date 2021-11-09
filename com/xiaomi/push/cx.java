package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class cx implements Comparable<cx> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f70777a;

    /* renamed from: a  reason: collision with other field name */
    public long f214a;

    /* renamed from: a  reason: collision with other field name */
    public String f215a;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedList<cn> f216a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cx() {
        this(null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public cx(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f216a = new LinkedList<>();
        this.f214a = 0L;
        this.f215a = str;
        this.f70777a = i2;
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
            return cxVar.f70777a - this.f70777a;
        }
        return invokeL.intValue;
    }

    public synchronized cx a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            synchronized (this) {
                this.f214a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
                this.f70777a = jSONObject.getInt("wt");
                this.f215a = jSONObject.getString("host");
                JSONArray jSONArray = jSONObject.getJSONArray("ah");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f216a.add(new cn().a(jSONArray.getJSONObject(i2)));
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
                jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f214a);
                jSONObject.put("wt", this.f70777a);
                jSONObject.put("host", this.f215a);
                JSONArray jSONArray = new JSONArray();
                Iterator<cn> it = this.f216a.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().m221a());
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
                    this.f216a.add(cnVar);
                    int a2 = cnVar.a();
                    if (a2 > 0) {
                        this.f70777a += cnVar.a();
                    } else {
                        int i2 = 0;
                        for (int size = this.f216a.size() - 1; size >= 0 && this.f216a.get(size).a() < 0; size--) {
                            i2++;
                        }
                        this.f70777a += a2 * i2;
                    }
                    if (this.f216a.size() > 30) {
                        this.f70777a -= this.f216a.remove().a();
                    }
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f215a + ":" + this.f70777a;
        }
        return (String) invokeV.objValue;
    }
}
