package d.a.t.f.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i f70297a;

    /* renamed from: b  reason: collision with root package name */
    public l f70298b;

    /* renamed from: c  reason: collision with root package name */
    public h f70299c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f70300d;

    /* renamed from: e  reason: collision with root package name */
    public Context f70301e;

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70297a = new f();
        this.f70298b = new p();
        this.f70299c = new e();
        if (this.f70300d == null) {
            c(context);
        }
    }

    @Override // d.a.t.f.a.c
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f70300d == null) {
                c(this.f70301e);
            }
            return this.f70300d;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ver", 1);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                jSONObject.put("aid", this.f70297a.a(this.f70301e));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                jSONObject.put("uid", this.f70299c.a(this.f70301e));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            try {
                jSONObject.put("adrid", this.f70298b.c(this.f70301e));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                jSONObject.put("network", this.f70298b.d(this.f70301e));
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            try {
                jSONObject.put("pkg", this.f70298b.b(this.f70301e));
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            try {
                jSONObject.put("ctime", this.f70298b.b());
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            try {
                jSONObject.put("ua", this.f70298b.a(this.f70301e));
            } catch (Exception e9) {
                e9.printStackTrace();
            }
            try {
                jSONObject.put("ut", this.f70298b.a());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            try {
                jSONObject.put(CommonUrlParamManager.PARAM_IID, this.f70297a.e(this.f70301e));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            try {
                jSONObject.put("sids", this.f70297a.b(this.f70301e));
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            try {
                jSONObject.put("oid", this.f70297a.c(this.f70301e));
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            try {
                jSONObject.put("gaid", this.f70297a.d(this.f70301e));
            } catch (Exception e14) {
                e14.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            if (context == null) {
                throw new NullPointerException("ctx should not be null");
            }
            if (this.f70301e == null) {
                this.f70301e = context.getApplicationContext();
            }
            this.f70300d = b();
        }
    }
}
