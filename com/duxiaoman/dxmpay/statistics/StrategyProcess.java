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
/* loaded from: classes11.dex */
public class StrategyProcess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f62011a;

    /* renamed from: b  reason: collision with root package name */
    public Context f62012b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f62013c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f62014d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f62015e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f62016f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f62017g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f62018h;

    /* renamed from: i  reason: collision with root package name */
    public String f62019i;

    /* loaded from: classes11.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final StrategyProcess f62020a;
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
            f62020a = new StrategyProcess(null);
        }
    }

    /* loaded from: classes11.dex */
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f62020a : (StrategyProcess) invokeV.objValue;
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
            b.d.a.a.a.b.a().f(this.f62012b, jSONObject.toString());
            this.f62013c = jSONObject;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            JSONObject jSONObject = this.f62013c;
            if (jSONObject != null && jSONObject.has("strategy_timestamp")) {
                synchronized (this.f62014d) {
                    JSONObject optJSONObject = this.f62013c.optJSONObject("content");
                    if (optJSONObject == null) {
                        optJSONObject = this.f62013c;
                    }
                    boolean z = true;
                    if (optJSONObject != null) {
                        this.f62015e = optJSONObject.optInt("wifi", 3);
                        this.f62016f = optJSONObject.optInt("3G", 5);
                        if (1 == optJSONObject.optInt(PackageTable.DISABLE, 0)) {
                            z = false;
                        }
                        this.f62011a = z;
                        JSONArray optJSONArray = optJSONObject.optJSONArray("now");
                        this.f62017g = new String[optJSONArray == null ? 0 : optJSONArray.length()];
                        if (optJSONArray != null) {
                            for (int i2 = 0; i2 < this.f62017g.length; i2++) {
                                this.f62017g[i2] = optJSONArray.optString(i2);
                            }
                        }
                        Arrays.sort(this.f62017g);
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("never");
                        this.f62018h = new String[optJSONArray2 == null ? 0 : optJSONArray2.length()];
                        for (int i3 = 0; i3 < this.f62018h.length; i3++) {
                            this.f62018h[i3] = optJSONArray2.optString(i3);
                        }
                        Arrays.sort(this.f62018h);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62016f : invokeV.intValue;
    }

    public void getDefaultStrategy(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            synchronized (this.f62014d) {
                if ((i2 & 1) != 0) {
                    this.f62017g = new String[0];
                    this.f62018h = new String[0];
                    this.f62011a = true;
                    this.f62016f = 5;
                    this.f62015e = 3;
                }
            }
            if (3 == (i2 & 3)) {
                try {
                    this.f62013c = (JSONObject) new JSONTokener(this.f62019i).nextValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public int getWifiSendingInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f62015e : invokeV.intValue;
    }

    public boolean isDataItemEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f62011a : invokeV.booleanValue;
    }

    public boolean isForceToSend(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this.f62014d) {
                z = false;
                if (!TextUtils.isEmpty(str) && this.f62017g != null && this.f62017g.length > 0) {
                    try {
                        if (Arrays.binarySearch(this.f62017g, str) >= 0) {
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
        if (java.util.Arrays.binarySearch(r4.f62018h, r5) >= 0) goto L17;
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
            synchronized (this.f62014d) {
                if (this.f62018h != null && this.f62018h.length > 0) {
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
            if (this.f62012b == null && context != null) {
                this.f62012b = context.getApplicationContext();
            }
            if (this.f62012b == null) {
                return;
            }
            IStatConfig settings = StatApi.getInstance().getSettings();
            if (settings != null) {
                this.f62019i = settings.loadDefaultStrategy();
            }
            String g2 = b.d.a.a.a.b.a().g(this.f62012b);
            if (TextUtils.isEmpty(g2) && !TextUtils.isEmpty(this.f62019i)) {
                g2 = this.f62019i;
            }
            try {
                this.f62013c = (JSONObject) new JSONTokener(g2).nextValue();
                if (b.d.a.a.a.a.h(this.f62012b) && needDownloadStrategy()) {
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
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONObject jSONObject = this.f62013c;
            if (jSONObject == null || !jSONObject.has("strategy_timestamp")) {
                return true;
            }
            try {
                j = this.f62013c.getLong("strategy_timestamp");
            } catch (Exception e2) {
                e2.printStackTrace();
                j = 0;
            }
            long currentTimeMillis = System.currentTimeMillis() - j;
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
        this.f62014d = new byte[0];
        this.f62015e = 3;
        this.f62016f = 5;
        this.f62011a = true;
    }
}
