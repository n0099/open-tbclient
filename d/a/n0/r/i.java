package d.a.n0.r;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f51022a;

    /* renamed from: b  reason: collision with root package name */
    public String f51023b;

    /* renamed from: c  reason: collision with root package name */
    public int f51024c;

    /* renamed from: d  reason: collision with root package name */
    public String f51025d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f51026e;

    /* renamed from: f  reason: collision with root package name */
    public long f51027f;

    /* renamed from: g  reason: collision with root package name */
    public int f51028g;

    /* renamed from: h  reason: collision with root package name */
    public String f51029h;

    /* renamed from: i  reason: collision with root package name */
    public String f51030i;
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
        this.f51025d = "";
        this.j = false;
        this.k = "";
        this.f51022a = str;
        this.f51023b = str;
        this.f51024c = -1;
        this.f51025d = str2;
        this.f51028g = i2;
        if ((i2 & 2) == 0) {
            this.f51027f = System.currentTimeMillis();
        }
        try {
            this.f51026e = new JSONObject(this.f51025d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = this.f51026e;
            return jSONObject != null ? jSONObject.optString("bizId") : "";
        }
        return (String) invokeV.objValue;
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (str = this.f51022a) != null && str.equals(this.f51023b) && d.g().a(this.f51022a)) {
            this.f51029h = e.h().h();
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
        this.f51025d = "";
        this.j = false;
        this.k = "";
        this.f51022a = str;
        this.f51023b = str;
        this.f51024c = -1;
        this.f51026e = jSONObject;
        this.f51028g = i2;
        if ((i2 & 2) == 0) {
            this.f51027f = System.currentTimeMillis();
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
        this.f51025d = "";
        this.j = false;
        this.k = "";
        this.f51022a = str2;
        this.f51023b = str;
        this.f51024c = i2;
        this.f51025d = str3;
        this.f51028g = i3;
        if ((i3 & 2) == 0) {
            this.f51027f = System.currentTimeMillis();
        }
        try {
            this.f51026e = new JSONObject(this.f51025d);
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
        this.f51025d = "";
        this.j = false;
        this.k = "";
        this.f51022a = str2;
        this.f51023b = str;
        this.f51024c = i2;
        this.f51025d = str3;
        this.f51028g = i3;
        if ((i3 & 2) == 0) {
            if (j > 0) {
                this.f51027f = j;
            } else {
                this.f51027f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f51025d)) {
            return;
        }
        try {
            this.f51026e = new JSONObject(this.f51025d);
        } catch (JSONException unused) {
        }
    }
}
