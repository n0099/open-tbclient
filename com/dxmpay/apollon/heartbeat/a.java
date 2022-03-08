package com.dxmpay.apollon.heartbeat;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.restnet.rest.d;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.FileCopyUtils;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.utils.NetworkUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";

    /* renamed from: c  reason: collision with root package name */
    public static a f52217c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f52218b;

    /* renamed from: d  reason: collision with root package name */
    public HeartBeatCfgEntity f52219d;

    /* renamed from: e  reason: collision with root package name */
    public Context f52220e;

    /* renamed from: f  reason: collision with root package name */
    public String f52221f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52222g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-619927165, "Lcom/dxmpay/apollon/heartbeat/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-619927165, "Lcom/dxmpay/apollon/heartbeat/a;");
        }
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
        this.f52218b = "https://www.baifubao.com";
        this.f52219d = null;
        this.f52220e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (NetworkUtils.isNetworkAvailable(this.f52220e)) {
                try {
                    String d2 = d();
                    if (!TextUtils.isEmpty(d2)) {
                        String str = a;
                        LogUtil.i(str, a + " execute success,response:" + d2);
                        try {
                            String optString = new JSONObject(d2).optString("content");
                            if (!TextUtils.isEmpty(optString)) {
                                a(HeartBeatCfgEntity.build(optString));
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        String str2 = a;
                        LogUtil.w(str2, a + " the response is null.");
                    }
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            String str3 = a;
            LogUtil.d(str3, a + " loadCfg current network is't available.");
        }
    }

    private String d() throws RestRuntimeException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            Context context = this.f52220e;
            RestTemplate restTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "dxm stastics bean http request");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("ua", this.f52221f));
            arrayList.add(new RestNameValuePair("nettype", new com.dxmpay.apollon.restnet.rest.b(this.f52220e).a()));
            arrayList.add(new RestNameValuePair("cate[heartbeat]", ""));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new RestHttpRequestInterceptor(this) { // from class: com.dxmpay.apollon.heartbeat.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor
                public void a(Context context2, d dVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, dVar) == null) {
                        dVar.a().a("Accept-Encoding", "gzip");
                    }
                }
            });
            restTemplate.setMessageConverter(new com.dxmpay.apollon.restnet.converter.b());
            restTemplate.setRequestInterceptor(arrayList2);
            return (String) restTemplate.a(this.f52218b + com.baidu.apollon.heartbeat.a.f31091f, arrayList, "utf-8", String.class);
        }
        return (String) invokeV.objValue;
    }

    public static synchronized a b() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            synchronized (a.class) {
                if (f52217c == null) {
                    f52217c = new a();
                }
                aVar = f52217c;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f52222g = z;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f52218b = str;
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || context == null) {
            return;
        }
        this.f52220e = context;
        new Thread(new Runnable(this) { // from class: com.dxmpay.apollon.heartbeat.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    HeartBeatCfgEntity c2 = aVar.c(aVar.f52220e);
                    if (c2 != null) {
                        long b2 = c.b(this.a.f52220e, com.baidu.apollon.heartbeat.c.f31104b, 300L);
                        if (!c2.isValidRequestTime(b2)) {
                            this.a.a(c2);
                            return;
                        }
                        String str = a.a;
                        LogUtil.i(str, a.a + " onChange lastRequestTime:" + b2 + " execute tryLoadCfg.");
                        this.a.c();
                        return;
                    }
                    this.a.c();
                }
            }
        }).start();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52218b : (String) invokeV.objValue;
    }

    public HeartBeatCfgEntity a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (context == null) {
                return null;
            }
            if (this.f52219d == null) {
                this.f52219d = c(context);
            }
            return this.f52219d;
        }
        return (HeartBeatCfgEntity) invokeL.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f52221f = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(HeartBeatCfgEntity heartBeatCfgEntity) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, heartBeatCfgEntity) != null) {
            return;
        }
        if (heartBeatCfgEntity != null) {
            HeartBeatCfgEntity heartBeatCfgEntity2 = this.f52219d;
            if ((heartBeatCfgEntity2 == null || (heartBeatCfgEntity2 != null && !TextUtils.equals(heartBeatCfgEntity2.toString(), heartBeatCfgEntity.toString()))) && heartBeatCfgEntity.checkResponseValidity()) {
                this.f52219d = heartBeatCfgEntity;
                heartBeatCfgEntity.storeResponse(this.f52220e);
                z = true;
                String str = a;
                LogUtil.i(str, a + " refreshHeartBeatCfg mResponse.");
                if (z) {
                    return;
                }
                HeartBeatManager.getInstance().applyBeating();
                return;
            }
        } else {
            String str2 = a;
            LogUtil.w(str2, a + " refreshHeartBeatCfg resp is null || mResponse = resp.");
        }
        z = false;
        if (z) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x00bd */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public HeartBeatCfgEntity c(Context context) {
        InterceptResult invokeL;
        FileReader fileReader;
        HeartBeatCfgEntity heartBeatCfgEntity;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65544, this, context)) != null) {
            return (HeartBeatCfgEntity) invokeL.objValue;
        }
        ?? sb = new StringBuilder();
        sb.append(context.getCacheDir());
        sb.append(File.separator);
        sb.append("dxmheartbeatcfg.cfg");
        File file = new File(sb.toString());
        FileReader fileReader2 = null;
        HeartBeatCfgEntity heartBeatCfgEntity2 = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                if (file.exists() && file.isFile()) {
                    fileReader = new FileReader(file);
                    try {
                        String copyToString = FileCopyUtils.copyToString(fileReader);
                        if (!TextUtils.isEmpty(copyToString)) {
                            heartBeatCfgEntity2 = HeartBeatCfgEntity.build(copyToString);
                        } else {
                            LogUtil.w(a, a + " cache:" + file.getPath() + " content json is empty.");
                        }
                        heartBeatCfgEntity = heartBeatCfgEntity2;
                        fileReader2 = fileReader;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (fileReader != null) {
                            fileReader.close();
                            return null;
                        }
                        return null;
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (fileReader != null) {
                            fileReader.close();
                            return null;
                        }
                        return null;
                    }
                } else {
                    LogUtil.w(a, a + " cache:" + file.getPath() + " isn't exist.");
                    heartBeatCfgEntity = null;
                }
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return heartBeatCfgEntity;
            } catch (IOException e5) {
                e5.printStackTrace();
                return null;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileReader = null;
        } catch (IOException e7) {
            e = e7;
            fileReader = null;
        } catch (Throwable th2) {
            sb = 0;
            th = th2;
            if (sb != 0) {
                try {
                    sb.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            throw th;
        }
    }
}
