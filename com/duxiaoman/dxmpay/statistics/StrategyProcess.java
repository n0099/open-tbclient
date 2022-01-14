package com.duxiaoman.dxmpay.statistics;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.dxmpay.statistics.internal.IStatConfig;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes2.dex */
public class StrategyProcess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Context f53473b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f53474c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f53475d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f53476e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f53477f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f53478g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f53479h;

    /* renamed from: i  reason: collision with root package name */
    public String f53480i;

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final StrategyProcess a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(694674029, "Lcom/duxiaoman/dxmpay/statistics/StrategyProcess$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(694674029, "Lcom/duxiaoman/dxmpay/statistics/StrategyProcess$a;");
                    return;
                }
            }
            a = new StrategyProcess(null);
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ StrategyProcess(b bVar) {
        this();
    }

    public static StrategyProcess getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (StrategyProcess) invokeV.objValue;
    }

    public final void a() {
        IStatConfig settings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (settings = StatApi.getInstance().getSettings()) == null) {
            return;
        }
        b(settings.loadStrategy());
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            jSONObject.put("strategy_timestamp", System.currentTimeMillis());
            c.d.a.a.a.b.a().f(this.f53473b, jSONObject.toString());
            this.f53474c = jSONObject;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            JSONObject jSONObject = this.f53474c;
            if (jSONObject != null && jSONObject.has("strategy_timestamp")) {
                synchronized (this.f53475d) {
                    JSONObject optJSONObject = this.f53474c.optJSONObject("content");
                    if (optJSONObject == null) {
                        optJSONObject = this.f53474c;
                    }
                    boolean z = true;
                    if (optJSONObject != null) {
                        this.f53476e = optJSONObject.optInt("wifi", 3);
                        this.f53477f = optJSONObject.optInt("3G", 5);
                        if (1 == optJSONObject.optInt(PackageTable.DISABLE, 0)) {
                            z = false;
                        }
                        this.a = z;
                        JSONArray optJSONArray = optJSONObject.optJSONArray("now");
                        this.f53478g = new String[optJSONArray == null ? 0 : optJSONArray.length()];
                        if (optJSONArray != null) {
                            for (int i2 = 0; i2 < this.f53478g.length; i2++) {
                                this.f53478g[i2] = optJSONArray.optString(i2);
                            }
                        }
                        Arrays.sort(this.f53478g);
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("never");
                        this.f53479h = new String[optJSONArray2 == null ? 0 : optJSONArray2.length()];
                        for (int i3 = 0; i3 < this.f53479h.length; i3++) {
                            this.f53479h[i3] = optJSONArray2.optString(i3);
                        }
                        Arrays.sort(this.f53479h);
                    } else {
                        getDefaultStrategy(1);
                    }
                }
                return;
            }
            getDefaultStrategy(3);
        }
    }

    public int get3GSendingInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f53477f : invokeV.intValue;
    }

    public void getDefaultStrategy(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            synchronized (this.f53475d) {
                if ((i2 & 1) != 0) {
                    this.f53478g = new String[0];
                    this.f53479h = new String[0];
                    this.a = true;
                    this.f53477f = 5;
                    this.f53476e = 3;
                }
            }
            if (3 == (i2 & 3)) {
                try {
                    this.f53474c = (JSONObject) new JSONTokener(this.f53480i).nextValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public int getWifiSendingInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f53476e : invokeV.intValue;
    }

    public boolean isDataItemEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public boolean isForceToSend(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this.f53475d) {
                z = false;
                if (!TextUtils.isEmpty(str) && this.f53478g != null && this.f53478g.length > 0) {
                    try {
                        if (Arrays.binarySearch(this.f53478g, str) >= 0) {
                            z = true;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:
        if (java.util.Arrays.binarySearch(r4.f53479h, r5) >= 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isIgnoreToSend(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            boolean z = true;
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            synchronized (this.f53475d) {
                if (this.f53479h != null && this.f53479h.length > 0) {
                    try {
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                z = false;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void loadCachedStrategy(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            if (this.f53473b == null && context != null) {
                this.f53473b = context.getApplicationContext();
            }
            if (this.f53473b == null) {
                return;
            }
            IStatConfig settings = StatApi.getInstance().getSettings();
            if (settings != null) {
                this.f53480i = settings.loadDefaultStrategy();
            }
            String g2 = c.d.a.a.a.b.a().g(this.f53473b);
            if (TextUtils.isEmpty(g2) && !TextUtils.isEmpty(this.f53480i)) {
                g2 = this.f53480i;
            }
            try {
                this.f53474c = (JSONObject) new JSONTokener(g2).nextValue();
                if (c.d.a.a.a.a.h(this.f53473b) && needDownloadStrategy()) {
                    a();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c();
        }
    }

    public boolean needDownloadStrategy() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONObject jSONObject = this.f53474c;
            if (jSONObject == null || !jSONObject.has("strategy_timestamp")) {
                return true;
            }
            try {
                j2 = this.f53474c.getLong("strategy_timestamp");
            } catch (Exception e2) {
                e2.printStackTrace();
                j2 = 0;
            }
            long currentTimeMillis = System.currentTimeMillis() - j2;
            return 86400000 < currentTimeMillis || 0 > currentTimeMillis;
        }
        return invokeV.booleanValue;
    }

    public StrategyProcess() {
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
        this.f53475d = new byte[0];
        this.f53476e = 3;
        this.f53477f = 5;
        this.a = true;
    }
}
