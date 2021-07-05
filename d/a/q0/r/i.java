package d.a.q0.r;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f54324a;

    /* renamed from: b  reason: collision with root package name */
    public String f54325b;

    /* renamed from: c  reason: collision with root package name */
    public int f54326c;

    /* renamed from: d  reason: collision with root package name */
    public String f54327d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f54328e;

    /* renamed from: f  reason: collision with root package name */
    public long f54329f;

    /* renamed from: g  reason: collision with root package name */
    public int f54330g;

    /* renamed from: h  reason: collision with root package name */
    public String f54331h;

    /* renamed from: i  reason: collision with root package name */
    public String f54332i;
    public boolean j;
    public String k;

    public i(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54327d = "";
        this.j = false;
        this.k = "";
        this.f54324a = str;
        this.f54325b = str;
        this.f54326c = -1;
        this.f54327d = str2;
        this.f54330g = i2;
        if ((i2 & 2) == 0) {
            this.f54329f = System.currentTimeMillis();
        }
        try {
            this.f54328e = new JSONObject(this.f54327d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = this.f54328e;
            return jSONObject != null ? jSONObject.optString("bizId") : "";
        }
        return (String) invokeV.objValue;
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (str = this.f54324a) != null && str.equals(this.f54325b) && d.g().a(this.f54324a)) {
            this.f54331h = e.h().h();
        }
    }

    public i(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f54327d = "";
        this.j = false;
        this.k = "";
        this.f54324a = str;
        this.f54325b = str;
        this.f54326c = -1;
        this.f54328e = jSONObject;
        this.f54330g = i2;
        if ((i2 & 2) == 0) {
            this.f54329f = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f54327d = "";
        this.j = false;
        this.k = "";
        this.f54324a = str2;
        this.f54325b = str;
        this.f54326c = i2;
        this.f54327d = str3;
        this.f54330g = i3;
        if ((i3 & 2) == 0) {
            this.f54329f = System.currentTimeMillis();
        }
        try {
            this.f54328e = new JSONObject(this.f54327d);
        } catch (JSONException unused) {
        }
    }

    public i(String str, String str2, int i2, String str3, long j, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f54327d = "";
        this.j = false;
        this.k = "";
        this.f54324a = str2;
        this.f54325b = str;
        this.f54326c = i2;
        this.f54327d = str3;
        this.f54330g = i3;
        if ((i3 & 2) == 0) {
            if (j > 0) {
                this.f54329f = j;
            } else {
                this.f54329f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f54327d)) {
            return;
        }
        try {
            this.f54328e = new JSONObject(this.f54327d);
        } catch (JSONException unused) {
        }
    }
}
