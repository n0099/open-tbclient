package d.a.w.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMPushUploadManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f70744c;

    /* renamed from: d  reason: collision with root package name */
    public static AtomicBoolean f70745d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.w.a.a.a f70746a;

    /* renamed from: b  reason: collision with root package name */
    public f f70747b;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f70748e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f70749f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f70750g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f70751h;

        public a(d dVar, Context context, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, context, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70751h = dVar;
            this.f70748e = context;
            this.f70749f = str;
            this.f70750g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70751h.j(this.f70748e, this.f70749f, this.f70750g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements IMPushUploadResponseListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f70752a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f70753b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f70754c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f70755d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f70756e;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f70757e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70757e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f70757e;
                    bVar.f70756e.g(bVar.f70752a, bVar.f70753b, bVar.f70754c, bVar.f70755d);
                }
            }
        }

        public b(d dVar, Context context, String str, List list, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, context, str, list, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70756e = dVar;
            this.f70752a = context;
            this.f70753b = str;
            this.f70754c = list;
            this.f70755d = i2;
        }

        @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
        public void uploadResponse(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                d.f70745d.set(false);
                if (i2 == 0) {
                    this.f70756e.f70746a.f().execute(new a(this));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1763341040, "Ld/a/w/a/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1763341040, "Ld/a/w/a/a/d;");
                return;
            }
        }
        f70745d = new AtomicBoolean(false);
    }

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70746a = d.a.w.a.a.a.h(context);
        this.f70747b = new f();
    }

    public static d h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (f70744c == null) {
                synchronized (d.class) {
                    if (f70744c == null) {
                        f70744c = new d(context);
                    }
                }
            }
            return f70744c;
        }
        return (d) invokeL.objValue;
    }

    public static Boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Boolean.valueOf(f70745d.get()) : (Boolean) invokeV.objValue;
    }

    public synchronized void e(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, context, str, i2) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (!TextUtils.isEmpty(str) && context != null && RequsetNetworkUtils.isConnected(context) && g.f(context) && g.e(context, Integer.parseInt(str))) {
                    if (this.f70746a != null) {
                        this.f70746a.f().execute(new a(this, context, str, i2));
                    }
                    return;
                }
                d.a.w.a.h.e.a("FlowTrackManager", "flow 无网、参数不对、未命中小流量不上报");
            }
        }
    }

    public void f() {
        d.a.w.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f70746a) == null) {
            return;
        }
        aVar.c();
    }

    public final void g(Context context, String str, List<h> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, context, str, list, i2) == null) || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (h hVar : list) {
            if (hVar != null) {
                arrayList.add(hVar.b());
            }
        }
        d.a.w.a.h.e.a("FlowTrackManager", "flow clear上报成功的数据");
        d.a.w.a.d.a.i(context).d(str, arrayList);
        if (d.a.w.a.d.a.i(context).h(str) > 0) {
            j(context, str, i2);
        }
    }

    public final void j(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, context, str, i2) == null) {
            d.a.w.a.h.e.a("FlowTrackManager", "flow begin uplodFlow~~~");
            f70745d.set(true);
            ArrayList arrayList = new ArrayList();
            f fVar = this.f70747b;
            if (fVar != null) {
                byte[] c2 = fVar.c(context, str, arrayList, i2);
                if (c2 != null && arrayList.size() > 0) {
                    if (c2.length >= 307200) {
                        d.a.w.a.h.e.a("FlowTrackManager", "flow 上报数据长度超过300k");
                        f70745d.set(false);
                        return;
                    }
                    IMPushUploadManager.getInstance(context).requestUpload(null, c2, "", new b(this, context, str, arrayList, i2));
                    return;
                }
                d.a.w.a.h.e.a("FlowTrackManager", "flow 上报数据为空");
                f70745d.set(false);
            }
        }
    }
}
