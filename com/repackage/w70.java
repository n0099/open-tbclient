package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMPushUploadManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class w70 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w70 c;
    public static AtomicBoolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public t70 a;
    public y70 b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ w70 d;

        public a(w70 w70Var, Context context, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w70Var, context, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = w70Var;
            this.a = context;
            this.b = str;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.j(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements IMPushUploadResponseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ List c;
        public final /* synthetic */ int d;
        public final /* synthetic */ w70 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.a;
                    bVar.e.g(bVar.a, bVar.b, bVar.c, bVar.d);
                }
            }
        }

        public b(w70 w70Var, Context context, String str, List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w70Var, context, str, list, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = w70Var;
            this.a = context;
            this.b = str;
            this.c = list;
            this.d = i;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                w70.d.set(false);
                if (i == 0) {
                    this.e.a.f().execute(new a(this));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755248607, "Lcom/repackage/w70;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755248607, "Lcom/repackage/w70;");
                return;
            }
        }
        d = new AtomicBoolean(false);
    }

    public w70(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = t70.h(context);
        this.b = new y70();
    }

    public static w70 h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (c == null) {
                synchronized (w70.class) {
                    if (c == null) {
                        c = new w70(context);
                    }
                }
            }
            return c;
        }
        return (w70) invokeL.objValue;
    }

    public static Boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Boolean.valueOf(d.get()) : (Boolean) invokeV.objValue;
    }

    public synchronized void e(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, context, str, i) == null) {
            synchronized (this) {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!TextUtils.isEmpty(str) && context != null && RequsetNetworkUtils.isConnected(context) && z70.f(context) && z70.e(context, Integer.parseInt(str))) {
                    if (this.a != null) {
                        this.a.f().execute(new a(this, context, str, i));
                    }
                    return;
                }
                b90.a("FlowTrackManager", "flow 无网、参数不对、未命中小流量不上报");
            }
        }
    }

    public void f() {
        t70 t70Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (t70Var = this.a) == null) {
            return;
        }
        t70Var.c();
    }

    public final void g(Context context, String str, List<a80> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, context, str, list, i) == null) || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (a80 a80Var : list) {
            if (a80Var != null) {
                arrayList.add(a80Var.b());
            }
        }
        b90.a("FlowTrackManager", "flow clear上报成功的数据");
        m80.j(context).e(str, arrayList);
        if (m80.j(context).i(str) > 0) {
            j(context, str, i);
        }
    }

    public final void j(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, context, str, i) == null) {
            b90.a("FlowTrackManager", "flow begin uplodFlow~~~");
            d.set(true);
            ArrayList arrayList = new ArrayList();
            y70 y70Var = this.b;
            if (y70Var != null) {
                byte[] c2 = y70Var.c(context, str, arrayList, i);
                if (c2 != null && arrayList.size() > 0) {
                    if (c2.length >= 307200) {
                        b90.a("FlowTrackManager", "flow 上报数据长度超过300k");
                        d.set(false);
                        return;
                    }
                    IMPushUploadManager.getInstance(context).requestUpload(null, c2, "", new b(this, context, str, arrayList, i));
                    return;
                }
                b90.a("FlowTrackManager", "flow 上报数据为空");
                d.set(false);
            }
        }
    }
}
