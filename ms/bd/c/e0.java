package ms.bd.c;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.JProtect;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
@Keep
@JProtect
/* loaded from: classes10.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CLIENT_TYPE_BUSINESS = 1;
    public static final int CLIENT_TYPE_INHOUSE = 0;
    public static final int CLIENT_TYPE_UNKNOWN = -1;
    public static final int OVREGION_TYPE_SG = 0;
    public static final int OVREGION_TYPE_UNKNOWN = -1;
    public static final int OVREGION_TYPE_VA = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f76047a;

    /* renamed from: b  reason: collision with root package name */
    public String f76048b;

    /* renamed from: c  reason: collision with root package name */
    public String f76049c;

    /* renamed from: d  reason: collision with root package name */
    public String f76050d;

    /* renamed from: e  reason: collision with root package name */
    public String f76051e;

    /* renamed from: f  reason: collision with root package name */
    public String f76052f;

    /* renamed from: g  reason: collision with root package name */
    public String f76053g;

    /* renamed from: h  reason: collision with root package name */
    public String f76054h;

    /* renamed from: i  reason: collision with root package name */
    public String f76055i;
    public int j;
    public int k;
    public Map<String, String> l;
    public Map<String, String> m;

    /* loaded from: classes10.dex */
    public static abstract class a<T extends b> extends e0 implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76053g = str;
            this.f76054h = str2;
            this.f76055i = str3;
            if (TextUtils.isEmpty(str) || "0".equals(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                throw new IllegalArgumentException("sdkID or license must be set.");
            }
        }

        public e0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.j != -1) {
                    return this;
                }
                throw new IllegalArgumentException("MSConfig init error");
            }
            return (e0) invokeV.objValue;
        }

        public T c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.j = i2;
                return this;
            }
            return (T) invokeI.objValue;
        }

        public T d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f76049c = str;
                return this;
            }
            return (T) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
    }

    public e0() {
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
        this.f76047a = "";
        this.f76048b = "";
        this.f76049c = "";
        this.f76050d = "";
        this.f76051e = "";
        this.f76052f = "";
        this.f76053g = "";
        this.f76054h = "";
        this.f76055i = "";
        this.j = -1;
        this.k = -1;
        this.l = new HashMap();
        this.m = new HashMap();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(a(this.f76047a));
            jSONArray.put(a(this.f76054h));
            jSONArray.put(a(this.f76053g));
            jSONArray.put(a(this.f76055i));
            jSONArray.put(a(this.f76048b));
            jSONArray.put(a(this.f76049c));
            jSONArray.put(a(this.f76050d));
            jSONArray.put(a(this.f76051e));
            jSONArray.put(a(this.f76052f));
            jSONArray.put(String.valueOf(this.j));
            jSONArray.put(String.valueOf(this.k));
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, String> entry : this.l.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    jSONArray2.put(a(entry.getKey()));
                    jSONArray2.put(a(entry.getValue()));
                }
            }
            jSONArray.put(jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            for (Map.Entry<String, String> entry2 : this.m.entrySet()) {
                if (!TextUtils.isEmpty(entry2.getKey())) {
                    jSONArray3.put(a(entry2.getKey()));
                    jSONArray3.put(a(entry2.getValue()));
                }
            }
            jSONArray.put(jSONArray3);
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? str == null ? "" : str.trim() : (String) invokeL.objValue;
    }
}
