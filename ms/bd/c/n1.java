package ms.bd.c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.JProtect;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public final class n1 implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n1 j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SensorManager f73103e;

    /* renamed from: f  reason: collision with root package name */
    public int f73104f;

    /* renamed from: g  reason: collision with root package name */
    public int f73105g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f73106h;

    /* renamed from: i  reason: collision with root package name */
    public List<JSONArray> f73107i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1737201116, "Lms/bd/c/n1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1737201116, "Lms/bd/c/n1;");
                return;
            }
        }
        new DecimalFormat((String) h.a(16777217, 0, 0L, "04aa7f", new byte[]{113, 120, 66}));
        j = null;
    }

    @JProtect
    public n1(Context context) {
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
        this.f73103e = null;
        this.f73105g = 0;
        this.f73106h = new float[3];
        this.f73107i = new ArrayList();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.f73103e = (SensorManager) applicationContext.getSystemService((String) h.a(16777217, 0, 0L, "a7381f", new byte[]{99, 48, 78, 95, 1, 99}));
        }
    }

    public static n1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (j == null) {
                synchronized (n1.class) {
                    try {
                        if (j == null) {
                            j = new n1(context);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return j;
        }
        return (n1) invokeL.objValue;
    }

    @Keep
    @JProtect
    public JSONArray a() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        BigDecimal bigDecimal;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c0.b() != 1) {
                return null;
            }
            d();
            try {
                try {
                    synchronized (this) {
                        int i2 = 0;
                        while (this.f73105g == 0 && i2 < 10) {
                            i2++;
                            wait(1000L);
                        }
                    }
                    jSONArray = new JSONArray();
                    jSONArray.put(new BigDecimal(this.f73106h[0]).setScale(2, 4));
                    jSONArray.put(new BigDecimal(this.f73106h[1]).setScale(2, 4));
                    bigDecimal = new BigDecimal(this.f73106h[2]);
                } catch (Exception unused) {
                    String str = (String) h.a(16777217, 0, 0L, "7f7d73", new byte[]{53, 119, 71, 47, 15});
                    jSONArray = new JSONArray();
                    jSONArray.put(new BigDecimal(this.f73106h[0]).setScale(2, 4));
                    jSONArray.put(new BigDecimal(this.f73106h[1]).setScale(2, 4));
                    bigDecimal = new BigDecimal(this.f73106h[2]);
                }
                jSONArray.put(bigDecimal.setScale(2, 4));
                e();
                this.f73105g = 0;
                return jSONArray;
            } catch (Throwable th) {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(new BigDecimal(this.f73106h[0]).setScale(2, 4));
                jSONArray2.put(new BigDecimal(this.f73106h[1]).setScale(2, 4));
                jSONArray2.put(new BigDecimal(this.f73106h[2]).setScale(2, 4));
                e();
                this.f73105g = 0;
                throw th;
            }
        }
        return (JSONArray) invokeV.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                JSONArray a2 = a();
                if (a2 == null) {
                    return;
                }
                this.f73107i.add(a2);
                try {
                    int size = this.f73107i.size();
                    if (size > 100) {
                        ArrayList arrayList = new ArrayList(this.f73107i.subList(size - 50, size));
                        this.f73107i.clear();
                        this.f73107i = arrayList;
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public synchronized String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                StringBuilder sb = new StringBuilder();
                int size = this.f73107i.size();
                if (size <= 0) {
                    return null;
                }
                List<JSONArray> list = this.f73107i;
                int i2 = size - 50;
                if (i2 <= 0) {
                    i2 = 0;
                }
                try {
                    List<JSONArray> subList = list.subList(i2, size);
                    if (subList.size() > 0) {
                        for (JSONArray jSONArray : subList) {
                            if (jSONArray != null) {
                                sb.append(jSONArray.get(0).toString());
                                sb.append((String) h.a(16777217, 0, 0L, "b04ce5", new byte[]{63}));
                                sb.append(jSONArray.get(1).toString());
                                sb.append((String) h.a(16777217, 0, 0L, "55f3ce", new byte[]{104}));
                                sb.append(jSONArray.get(2).toString());
                                sb.append((String) h.a(16777217, 0, 0L, "80c43e", new byte[]{53}));
                            }
                        }
                    }
                    if (sb.length() > 0) {
                        sb.delete(sb.length() - 1, sb.length());
                    }
                } catch (Throwable unused) {
                }
                return sb.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public final synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                try {
                    if (this.f73103e != null) {
                        if (this.f73104f == 0) {
                            if (!this.f73103e.registerListener(this, this.f73103e.getDefaultSensor(1), 3)) {
                                return;
                            }
                        }
                        this.f73104f++;
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                try {
                    if (this.f73103e != null) {
                        int i2 = this.f73104f - 1;
                        this.f73104f = i2;
                        if (i2 == 0) {
                            this.f73103e.unregisterListener(this);
                        }
                    }
                } catch (Exception unused) {
                    String str = (String) h.a(16777217, 0, 0L, "407238", new byte[]{54, PublicSuffixDatabase.EXCEPTION_MARKER, 71, 121, 25});
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sensorEvent) == null) {
            this.f73106h = sensorEvent.values;
            this.f73105g = 1;
        }
    }
}
