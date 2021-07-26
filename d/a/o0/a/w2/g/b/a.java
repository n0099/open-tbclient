package d.a.o0.a.w2.g.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.v2.n0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48830f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f48831a;

    /* renamed from: b  reason: collision with root package name */
    public long f48832b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f48833c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f48834d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f48835e;

    /* renamed from: d.a.o0.a.w2.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C0976a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f48836a;

        /* renamed from: b  reason: collision with root package name */
        public float f48837b;

        /* renamed from: c  reason: collision with root package name */
        public float f48838c;

        /* renamed from: d  reason: collision with root package name */
        public float f48839d;

        /* renamed from: e  reason: collision with root package name */
        public float f48840e;

        /* renamed from: f  reason: collision with root package name */
        public float f48841f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f48842g;

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
            this.f48842g = aVar;
        }

        public JSONObject i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("x", n0.L(this.f48837b));
                    jSONObject.put("y", n0.L(this.f48838c));
                    jSONObject.put("clientX", n0.L(this.f48839d - this.f48842g.f48835e[0]));
                    jSONObject.put("clientY", n0.L(this.f48840e - this.f48842g.f48835e[1]));
                    jSONObject.put("identifier", this.f48836a);
                    jSONObject.put("force", this.f48841f);
                } catch (JSONException e2) {
                    if (a.f48830f) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar, C0976a c0976a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1839124788, "Ld/a/o0/a/w2/g/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1839124788, "Ld/a/o0/a/w2/g/b/a;");
                return;
            }
        }
        f48830f = k.f46335a;
    }

    public a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {motionEvent};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48831a = "error";
        this.f48832b = 0L;
        this.f48833c = new ArrayList();
        this.f48834d = new ArrayList();
        this.f48835e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                if (!this.f48833c.isEmpty()) {
                    for (b bVar : this.f48833c) {
                        if (bVar != null) {
                            jSONArray.put(bVar.i());
                        }
                    }
                }
                JSONArray jSONArray2 = new JSONArray();
                if (!this.f48834d.isEmpty()) {
                    for (b bVar2 : this.f48834d) {
                        if (bVar2 != null) {
                            jSONArray2.put(bVar2.i());
                        }
                    }
                }
                jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f48832b);
                jSONObject.put("touches", jSONArray);
                jSONObject.put("changedTouches", jSONArray2);
            } catch (JSONException e2) {
                if (f48830f) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public b d(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, i2)) == null) {
            int pointerId = motionEvent.getPointerId(i2);
            b bVar = new b(this, null);
            bVar.f48836a = pointerId;
            bVar.f48837b = motionEvent.getX(i2);
            bVar.f48838c = motionEvent.getY(i2);
            bVar.f48839d = (motionEvent.getRawX() + bVar.f48837b) - motionEvent.getX();
            bVar.f48840e = (motionEvent.getRawY() + bVar.f48838c) - motionEvent.getY();
            bVar.f48841f = motionEvent.getPressure(i2);
            return bVar;
        }
        return (b) invokeLI.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48831a : (String) invokeV.objValue;
    }

    public final void f(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
            try {
                if (!(motionEvent.getActionMasked() == 2)) {
                    this.f48834d.add(d(motionEvent, motionEvent.getActionIndex()));
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                for (int i2 = 0; i2 < pointerCount; i2++) {
                    this.f48834d.add(d(motionEvent, i2));
                }
            } catch (Exception e2) {
                if (f48830f) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) || TextUtils.equals(this.f48831a, "touchend") || TextUtils.equals(this.f48831a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i2) {
                    this.f48833c.add(d(motionEvent, i2));
                }
            }
        } catch (Exception e2) {
            if (f48830f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, motionEvent, str) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f48831a = "touchstart";
                f(motionEvent);
            } else if (actionMasked == 1) {
                this.f48831a = "touchend";
                f(motionEvent);
            } else if (actionMasked == 2) {
                this.f48831a = "touchmove";
                f(motionEvent);
            } else if (actionMasked == 3) {
                this.f48831a = "touchcancel";
                f(motionEvent);
            } else if (actionMasked == 5) {
                this.f48831a = "touchpointerdown";
                f(motionEvent);
            } else if (actionMasked != 6) {
                this.f48831a = "error";
            } else {
                this.f48831a = "touchpointerup";
                f(motionEvent);
            }
            this.f48832b = motionEvent.getEventTime();
            if (!TextUtils.isEmpty(str)) {
                this.f48831a = str;
            }
            g(motionEvent);
            if (TextUtils.equals(this.f48831a, "touchpointerdown")) {
                this.f48831a = "touchstart";
            }
            if (TextUtils.equals(this.f48831a, "touchpointerup")) {
                this.f48831a = "touchend";
            }
        }
    }

    public void i(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iArr) == null) {
            this.f48835e = iArr;
            if (f48830f) {
                Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
            }
        }
    }

    public a(MotionEvent motionEvent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {motionEvent, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f48831a = "error";
        this.f48832b = 0L;
        this.f48833c = new ArrayList();
        this.f48834d = new ArrayList();
        this.f48835e = new int[2];
        h(motionEvent, str);
    }
}
