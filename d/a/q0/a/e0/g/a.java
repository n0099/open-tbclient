package d.a.q0.a.e0.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.k;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f47412a;

    /* renamed from: b  reason: collision with root package name */
    public int f47413b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f47414c;

    /* renamed from: d  reason: collision with root package name */
    public b f47415d;

    /* renamed from: e  reason: collision with root package name */
    public BufferedWriter f47416e;

    /* renamed from: d.a.q0.a.e0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C0721a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes8.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47417a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47417a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.f47417a.f47414c == null) {
                return;
            }
            this.f47417a.f47414c.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : this.f47417a.f47414c.entrySet()) {
                try {
                    jSONObject.putOpt((String) entry.getKey(), entry.getValue());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.f47417a.e(jSONObject.toString());
            d.a.q0.a.e0.d.g("PropertyLogcat", jSONObject.toString());
            if (this.f47417a.f47415d != null) {
                this.f47417a.f47415d.sendEmptyMessageDelayed(100, this.f47417a.f47413b);
            }
        }

        public /* synthetic */ b(a aVar, C0721a c0721a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1957093843, "Ld/a/q0/a/e0/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1957093843, "Ld/a/q0/a/e0/g/a;");
                return;
            }
        }
        boolean z = k.f49133a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47412a = "performance_" + System.currentTimeMillis();
        this.f47413b = 3000;
    }

    public final void e(String str) {
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bufferedWriter = this.f47416e) == null) {
            return;
        }
        try {
            bufferedWriter.write(str);
            this.f47416e.write(10);
            d.a.q0.a.e0.d.g("PropertyLogcat", "Export logcat success");
        } catch (IOException e2) {
            d.a.q0.a.e0.d.c("PropertyLogcat", "Logcat write fail", e2);
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.q0.a.k2.b.n(e.V(), this.f47412a, TbConfig.TMP_LOG_DIR_NAME) : (String) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 < 1000) {
            return;
        }
        this.f47413b = i2;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f47414c == null) {
                this.f47414c = d.a.q0.a.e0.g.b.h().i();
                d.a.q0.a.e0.d.g("PropertyLogcat", "Start monitor logcat");
            }
            if (this.f47415d == null) {
                this.f47415d = new b(this, null);
            }
            if (this.f47416e == null) {
                File file = new File(f());
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    this.f47416e = new BufferedWriter(new FileWriter(file, true));
                } catch (IOException e2) {
                    d.a.q0.a.e0.d.c("PropertyLogcat", "Create log file fail", e2);
                }
            }
            this.f47415d.removeMessages(100);
            this.f47415d.sendEmptyMessage(100);
        }
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f47414c != null) {
                d.a.q0.a.e0.g.b.h().j();
                this.f47414c = null;
                d.a.q0.a.e0.d.g("PropertyLogcat", "Stop monitor logcat");
            }
            d.a.q0.t.d.d(this.f47416e);
            this.f47416e = null;
            return d.a.q0.a.k2.b.I(f(), e.V());
        }
        return (String) invokeV.objValue;
    }
}
