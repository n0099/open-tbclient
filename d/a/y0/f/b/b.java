package d.a.y0.f.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.y0.t.c;
import d.a.y0.t.h;
import d.a.y0.t.o;
import d.a.y0.t.u;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.y0.f.b.c.b f71011a;

    /* renamed from: b  reason: collision with root package name */
    public Timer f71012b;

    /* renamed from: c  reason: collision with root package name */
    public TimerTask f71013c;

    /* renamed from: d  reason: collision with root package name */
    public int f71014d;

    /* renamed from: e  reason: collision with root package name */
    public Vector<Integer> f71015e;

    /* renamed from: f  reason: collision with root package name */
    public long f71016f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71017g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f71018h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.y0.f.b.c.a f71019i;
    public int j;
    public float k;
    public long l;
    public Vector<Integer> m;

    /* loaded from: classes9.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f71020e;

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
            this.f71020e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f71020e.f71018h) {
                    this.f71020e.j();
                } else {
                    this.f71020e.q();
                }
                b bVar = this.f71020e;
                bVar.f71018h = bVar.l(bVar.j);
            }
        }
    }

    /* renamed from: d.a.y0.f.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1966b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f71021e;

        public RunnableC1966b(b bVar) {
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
            this.f71021e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f71021e.f71017g = false;
                if (this.f71021e.f71013c != null) {
                    this.f71021e.f71013c.cancel();
                }
                if (this.f71021e.f71012b != null) {
                    this.f71021e.f71012b.purge();
                }
            }
        }
    }

    public b() {
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
        this.f71014d = 0;
        this.f71015e = new Vector<>();
        this.f71017g = false;
        this.f71018h = false;
        this.f71019i = new d.a.y0.f.b.c.a();
        this.j = 0;
        this.k = 0.0f;
        this.l = 0L;
        this.m = new Vector<>();
        this.f71012b = new Timer();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f71014d++;
            this.f71019i.f71022a = k(this.m);
            this.f71019i.f71023b = k(this.f71015e);
            this.f71019i.f71024c = this.m.size() + "";
            this.f71019i.f71027f = Float.toString(o.a());
            this.f71019i.f71025d = this.k;
            c.b("report ar frame data");
            d.a.y0.f.a.a(String.valueOf(this.f71014d), this.f71011a, this.f71019i);
            q();
        }
    }

    public final String k(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (h.e(list)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = list.get(i2);
                if (num != null) {
                    f3 += num.intValue();
                    jSONArray.put(num);
                }
            }
            float size = f3 / list.size();
            for (int i3 = 0; i3 < list.size(); i3++) {
                Integer num2 = list.get(i3);
                if (num2 != null) {
                    f2 = (float) (f2 + Math.pow(num2.intValue() - size, 2.0d));
                }
            }
            float size2 = f2 / list.size();
            try {
                jSONObject.put("avg", size);
                jSONObject.put("vari", size2);
                jSONObject.put("val", jSONArray.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            return i2 > 0 && i2 <= 100 && new Random().nextInt(100) <= i2;
        }
        return invokeI.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f71017g = false;
            Timer timer = this.f71012b;
            if (timer != null) {
                timer.cancel();
                this.f71012b = null;
            }
            TimerTask timerTask = this.f71013c;
            if (timerTask != null) {
                timerTask.cancel();
                this.f71013c = null;
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f71018h && this.f71017g) {
            if (this.f71016f <= 0) {
                this.f71016f = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = (int) (currentTimeMillis - this.f71016f);
            if (i2 < 0) {
                return;
            }
            this.f71015e.add(Integer.valueOf(i2));
            this.f71016f = currentTimeMillis;
        }
    }

    public void o() {
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f71018h && this.f71017g && this.l > 0 && (currentTimeMillis = (int) (System.currentTimeMillis() - this.l)) >= 0) {
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
            this.f71016f = 0L;
            this.l = 0L;
            this.f71015e.clear();
            this.m.clear();
            this.f71019i.a();
            this.k = 0.0f;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f71017g || this.f71012b == null) {
            return;
        }
        c.b("startTimer");
        this.f71017g = true;
        this.f71013c = new a(this);
        this.f71012b.purge();
        this.f71012b.schedule(this.f71013c, 0L, 1000L);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.b("stopTimer");
            u.a().postDelayed(new RunnableC1966b(this), 1000L);
        }
    }
}
