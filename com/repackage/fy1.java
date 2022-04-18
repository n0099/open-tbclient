package com.repackage;

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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public int b;
    public Map<String, Object> c;
    public b d;
    public BufferedWriter e;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy1 a;

        public b(fy1 fy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fy1Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.a.c == null) {
                return;
            }
            this.a.c.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : this.a.c.entrySet()) {
                try {
                    jSONObject.putOpt((String) entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.a.e(jSONObject.toString());
            jx1.i("PropertyLogcat", jSONObject.toString());
            if (this.a.d != null) {
                this.a.d.sendEmptyMessageDelayed(100, this.a.b);
            }
        }

        public /* synthetic */ b(fy1 fy1Var, a aVar) {
            this(fy1Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755691597, "Lcom/repackage/fy1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755691597, "Lcom/repackage/fy1;");
                return;
            }
        }
        boolean z = tg1.a;
    }

    public fy1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "performance_" + System.currentTimeMillis();
        this.b = 3000;
    }

    public final void e(String str) {
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bufferedWriter = this.e) == null) {
            return;
        }
        try {
            bufferedWriter.write(str);
            this.e.write(10);
            jx1.i("PropertyLogcat", "Export logcat success");
        } catch (IOException e) {
            jx1.d("PropertyLogcat", "Logcat write fail", e);
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? r73.n(j03.f0(), this.a, TbConfig.TMP_LOG_DIR_NAME) : (String) invokeV.objValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || i < 1000) {
            return;
        }
        this.b = i;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.c == null) {
                this.c = gy1.g().h();
                jx1.i("PropertyLogcat", "Start monitor logcat");
            }
            if (this.d == null) {
                this.d = new b(this, null);
            }
            if (this.e == null) {
                File file = new File(f());
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    this.e = new BufferedWriter(new FileWriter(file, true));
                } catch (IOException e) {
                    jx1.d("PropertyLogcat", "Create log file fail", e);
                }
            }
            this.d.removeMessages(100);
            this.d.sendEmptyMessage(100);
        }
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c != null) {
                gy1.g().i();
                this.c = null;
                jx1.i("PropertyLogcat", "Stop monitor logcat");
            }
            mg4.d(this.e);
            this.e = null;
            return r73.I(f(), j03.f0());
        }
        return (String) invokeV.objValue;
    }
}
