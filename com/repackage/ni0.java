package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ii0;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ni0 extends mi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final ei0 f;
    public HashMap<String, b> g;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-155943649, "Lcom/repackage/ni0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-155943649, "Lcom/repackage/ni0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadStatus.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdDownloadStatus.FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ni0(@NonNull ei0 ei0Var) {
        super(ei0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ei0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ei0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new HashMap<>();
        this.f = ei0Var;
        this.c = new ri0(this);
    }

    @NonNull
    public ei0 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (ei0) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = a.a[this.f.c.ordinal()];
            if (i == 1) {
                ei0 ei0Var = this.f;
                ei0Var.i = 0.0f;
                ei0Var.j = 0.0f;
                return "0";
            } else if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return i != 5 ? "0" : "4";
                    }
                    ei0 ei0Var2 = this.f;
                    ei0Var2.i = 1.0f;
                    ei0Var2.j = 1.0f;
                    return "3";
                }
                return "2";
            } else {
                return "1";
            }
        }
        return (String) invokeV.objValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            m(this.c);
        }
    }

    public void w(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, str4) == null) {
            ii0 ii0Var = new ii0();
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            String a2 = dj0.a(str, str2, str3, str4);
            hx0.f(jSONObject, "status", "0");
            hx0.f(jSONObject, "message", "");
            hx0.f(jSONObject, "data", a2);
            for (String str5 : this.g.keySet()) {
                b bVar = (b) ix0.b(this.g, str5);
                if (bVar != null && !TextUtils.isEmpty(bVar.a)) {
                    ii0.a aVar = new ii0.a();
                    aVar.b = bVar.b;
                    aVar.a = bVar.a;
                    aVar.c = jSONObject.toString();
                    gx0.b(arrayList, aVar);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ii0Var.a = arrayList;
            nj0.a().a(ii0Var);
        }
    }

    public void x(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, str3, str4) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String str5 = str + "_" + str4 + "_" + str3 + "_" + str2;
        this.g.remove(str5);
        b bVar = new b();
        bVar.b = str;
        bVar.a = str2;
        this.g.put(str5, bVar);
    }

    public void y(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return;
        }
        this.g.remove(str + "_" + str4 + "_" + str3 + "_" + str2);
    }
}
