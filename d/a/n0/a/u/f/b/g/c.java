package d.a.n0.a.u.f.b.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.e;
import d.a.n0.a.u.e.j.g;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends BasePendingOperation {
    public static /* synthetic */ Interceptable $ic;
    public static final CopyOnWriteArrayList<String> j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public g f47853e;

    /* renamed from: f  reason: collision with root package name */
    public e f47854f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f47855g;

    /* renamed from: h  reason: collision with root package name */
    public String f47856h;

    /* renamed from: i  reason: collision with root package name */
    public String f47857i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-841091578, "Ld/a/n0/a/u/f/b/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-841091578, "Ld/a/n0/a/u/f/b/g/c;");
                return;
            }
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        j = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        j.add("https://dxp.baidu.com/mini");
        j.add("https://mbd.baidu.com/smtapp/recordhandler/getrecordinfo");
        j.add("https://eclick.baidu.com/se.jpg");
        j.add("https://miniapp-ad.cdn.bcebos.com/miniapp_ad/config/cg.json");
    }

    public c(@NonNull g gVar, @NonNull e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, eVar, jSONObject, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47853e = gVar;
        this.f47854f = eVar;
        this.f47855g = jSONObject;
        this.f47856h = str;
        this.f47857i = str2;
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? e(this.f47855g.optString("url")) : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "request" : (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? String.format("%s : %s", this.f47854f.getAppId(), this.f47855g.optString("url")) : (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public BasePendingOperation.OperationType d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? BasePendingOperation.OperationType.OPERATION_TYPE_REQUEST : (BasePendingOperation.OperationType) invokeV.objValue;
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int size = j.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = j.get(i2);
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f47853e.A(this.f47854f, this.f47855g, this.f47856h, this.f47857i);
        }
    }
}
