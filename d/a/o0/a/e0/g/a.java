package d.a.o0.a.e0.g;

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
import d.a.o0.a.a2.e;
import d.a.o0.a.k;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f44614a;

    /* renamed from: b  reason: collision with root package name */
    public int f44615b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f44616c;

    /* renamed from: d  reason: collision with root package name */
    public b f44617d;

    /* renamed from: e  reason: collision with root package name */
    public BufferedWriter f44618e;

    /* renamed from: d.a.o0.a.e0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C0679a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes7.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f44619a;

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
            this.f44619a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.f44619a.f44616c == null) {
                return;
            }
            this.f44619a.f44616c.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : this.f44619a.f44616c.entrySet()) {
                try {
                    jSONObject.putOpt((String) entry.getKey(), entry.getValue());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.f44619a.e(jSONObject.toString());
            d.a.o0.a.e0.d.g("PropertyLogcat", jSONObject.toString());
            if (this.f44619a.f44617d != null) {
                this.f44619a.f44617d.sendEmptyMessageDelayed(100, this.f44619a.f44615b);
            }
        }

        public /* synthetic */ b(a aVar, C0679a c0679a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2079708015, "Ld/a/o0/a/e0/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2079708015, "Ld/a/o0/a/e0/g/a;");
                return;
            }
        }
        boolean z = k.f46335a;
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
        this.f44614a = "performance_" + System.currentTimeMillis();
        this.f44615b = 3000;
    }

    public final void e(String str) {
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bufferedWriter = this.f44618e) == null) {
            return;
        }
        try {
            bufferedWriter.write(str);
            this.f44618e.write(10);
            d.a.o0.a.e0.d.g("PropertyLogcat", "Export logcat success");
        } catch (IOException e2) {
            d.a.o0.a.e0.d.c("PropertyLogcat", "Logcat write fail", e2);
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.o0.a.k2.b.n(e.V(), this.f44614a, TbConfig.TMP_LOG_DIR_NAME) : (String) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 < 1000) {
            return;
        }
        this.f44615b = i2;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f44616c == null) {
                this.f44616c = d.a.o0.a.e0.g.b.h().i();
                d.a.o0.a.e0.d.g("PropertyLogcat", "Start monitor logcat");
            }
            if (this.f44617d == null) {
                this.f44617d = new b(this, null);
            }
            if (this.f44618e == null) {
                File file = new File(f());
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    this.f44618e = new BufferedWriter(new FileWriter(file, true));
                } catch (IOException e2) {
                    d.a.o0.a.e0.d.c("PropertyLogcat", "Create log file fail", e2);
                }
            }
            this.f44617d.removeMessages(100);
            this.f44617d.sendEmptyMessage(100);
        }
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f44616c != null) {
                d.a.o0.a.e0.g.b.h().j();
                this.f44616c = null;
                d.a.o0.a.e0.d.g("PropertyLogcat", "Stop monitor logcat");
            }
            d.a.o0.t.d.d(this.f44618e);
            this.f44618e = null;
            return d.a.o0.a.k2.b.I(f(), e.V());
        }
        return (String) invokeV.objValue;
    }
}
