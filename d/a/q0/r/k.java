package d.a.q0.r;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f54334a;

    /* renamed from: b  reason: collision with root package name */
    public int f54335b;

    /* renamed from: c  reason: collision with root package name */
    public String f54336c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f54337d;

    /* renamed from: e  reason: collision with root package name */
    public long f54338e;

    /* renamed from: f  reason: collision with root package name */
    public long f54339f;

    /* renamed from: g  reason: collision with root package name */
    public int f54340g;

    /* renamed from: h  reason: collision with root package name */
    public String f54341h;

    /* renamed from: i  reason: collision with root package name */
    public String f54342i;
    public String j;
    public JSONArray k;
    public boolean l;

    public k() {
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
        this.l = false;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && d.g().a(this.f54334a)) {
            this.f54342i = e.h().h();
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.k = new JSONArray(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public k(String str, int i2, String str2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = false;
        this.f54334a = str;
        this.f54335b = i2;
        this.f54336c = str2;
        this.f54340g = i3;
    }
}
