package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h79 a;
    public Timer b;
    public TimerTask c;
    public int d;
    public Vector<Integer> e;
    public long f;
    public boolean g;
    public boolean h;
    public g79 i;
    public int j;
    public float k;
    public long l;
    public Vector<Integer> m;

    /* loaded from: classes6.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f79 a;

        public a(f79 f79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f79Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.h) {
                    this.a.j();
                } else {
                    this.a.q();
                }
                f79 f79Var = this.a;
                f79Var.h = f79Var.l(f79Var.j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f79 a;

        public b(f79 f79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f79Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g = false;
                if (this.a.c != null) {
                    this.a.c.cancel();
                }
                if (this.a.b != null) {
                    this.a.b.purge();
                }
            }
        }
    }

    public f79() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0;
        this.e = new Vector<>();
        this.g = false;
        this.h = false;
        this.i = new g79();
        this.j = 0;
        this.k = 0.0f;
        this.l = 0L;
        this.m = new Vector<>();
        this.b = new Timer();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d++;
            this.i.a = k(this.m);
            this.i.b = k(this.e);
            this.i.c = this.m.size() + "";
            this.i.f = Float.toString(hb9.a());
            this.i.d = this.k;
            va9.b("report ar frame data");
            d79.a(String.valueOf(this.d), this.a, this.i);
            q();
        }
    }

    public final String k(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ab9.e(list)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            float f = 0.0f;
            float f2 = 0.0f;
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num != null) {
                    f2 += num.intValue();
                    jSONArray.put(num);
                }
            }
            float size = f2 / list.size();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num2 = list.get(i2);
                if (num2 != null) {
                    f = (float) (f + Math.pow(num2.intValue() - size, 2.0d));
                }
            }
            float size2 = f / list.size();
            try {
                jSONObject.put("avg", size);
                jSONObject.put("vari", size2);
                jSONObject.put("val", jSONArray.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return i > 0 && i <= 100 && new Random().nextInt(100) <= i;
        }
        return invokeI.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g = false;
            Timer timer = this.b;
            if (timer != null) {
                timer.cancel();
                this.b = null;
            }
            TimerTask timerTask = this.c;
            if (timerTask != null) {
                timerTask.cancel();
                this.c = null;
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.h && this.g) {
            if (this.f <= 0) {
                this.f = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i = (int) (currentTimeMillis - this.f);
            if (i < 0) {
                return;
            }
            this.e.add(Integer.valueOf(i));
            this.f = currentTimeMillis;
        }
    }

    public void o() {
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.h && this.g && this.l > 0 && (currentTimeMillis = (int) (System.currentTimeMillis() - this.l)) >= 0) {
            this.m.add(Integer.valueOf(currentTimeMillis));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = System.currentTimeMillis();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f = 0L;
            this.l = 0L;
            this.e.clear();
            this.m.clear();
            this.i.a();
            this.k = 0.0f;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.g || this.b == null) {
            return;
        }
        va9.b("startTimer");
        this.g = true;
        this.c = new a(this);
        this.b.purge();
        this.b.schedule(this.c, 0L, 1000L);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            va9.b("stopTimer");
            nb9.a().postDelayed(new b(this), 1000L);
        }
    }
}
