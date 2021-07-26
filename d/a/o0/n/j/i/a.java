package d.a.o0.n.j.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f51257a;

    /* renamed from: b  reason: collision with root package name */
    public int f51258b;

    /* renamed from: c  reason: collision with root package name */
    public int f51259c;

    /* renamed from: d  reason: collision with root package name */
    public int f51260d;

    /* renamed from: e  reason: collision with root package name */
    public int f51261e;

    public a(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51257a = i2;
        this.f51258b = i3;
        this.f51259c = i4;
        this.f51260d = i6;
        this.f51261e = i5;
    }

    @NonNull
    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new a(24, 70, 1440, 720, 30) : (a) invokeV.objValue;
    }

    @NonNull
    public static a b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return a();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.optInt("clean_check_hour", 24), jSONObject.optInt("hold_history_max_count", 70), jSONObject.optInt("history_force_clean_hour", 1440), jSONObject.optInt("force_clean_hour", 720), jSONObject.optInt("hold_max_count", 30));
            } catch (JSONException e2) {
                if (d.a.o0.n.c.f51112a) {
                    e2.printStackTrace();
                }
                return a();
            }
        }
        return (a) invokeL.objValue;
    }
}
