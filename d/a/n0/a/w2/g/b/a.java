package d.a.n0.a.w2.g.b;

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
import d.a.n0.a.k;
import d.a.n0.a.v2.n0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48326f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f48327a;

    /* renamed from: b  reason: collision with root package name */
    public long f48328b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f48329c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f48330d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f48331e;

    /* renamed from: d.a.n0.a.w2.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C0967a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f48332a;

        /* renamed from: b  reason: collision with root package name */
        public float f48333b;

        /* renamed from: c  reason: collision with root package name */
        public float f48334c;

        /* renamed from: d  reason: collision with root package name */
        public float f48335d;

        /* renamed from: e  reason: collision with root package name */
        public float f48336e;

        /* renamed from: f  reason: collision with root package name */
        public float f48337f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f48338g;

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
            this.f48338g = aVar;
        }

        public JSONObject i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("x", n0.L(this.f48333b));
                    jSONObject.put("y", n0.L(this.f48334c));
                    jSONObject.put("clientX", n0.L(this.f48335d - this.f48338g.f48331e[0]));
                    jSONObject.put("clientY", n0.L(this.f48336e - this.f48338g.f48331e[1]));
                    jSONObject.put("identifier", this.f48332a);
                    jSONObject.put("force", this.f48337f);
                } catch (JSONException e2) {
                    if (a.f48326f) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar, C0967a c0967a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1333566163, "Ld/a/n0/a/w2/g/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1333566163, "Ld/a/n0/a/w2/g/b/a;");
                return;
            }
        }
        f48326f = k.f45831a;
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
        this.f48327a = "error";
        this.f48328b = 0L;
        this.f48329c = new ArrayList();
        this.f48330d = new ArrayList();
        this.f48331e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                if (!this.f48329c.isEmpty()) {
                    for (b bVar : this.f48329c) {
                        if (bVar != null) {
                            jSONArray.put(bVar.i());
                        }
                    }
                }
                JSONArray jSONArray2 = new JSONArray();
                if (!this.f48330d.isEmpty()) {
                    for (b bVar2 : this.f48330d) {
                        if (bVar2 != null) {
                            jSONArray2.put(bVar2.i());
                        }
                    }
                }
                jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f48328b);
                jSONObject.put("touches", jSONArray);
                jSONObject.put("changedTouches", jSONArray2);
            } catch (JSONException e2) {
                if (f48326f) {
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
            bVar.f48332a = pointerId;
            bVar.f48333b = motionEvent.getX(i2);
            bVar.f48334c = motionEvent.getY(i2);
            bVar.f48335d = (motionEvent.getRawX() + bVar.f48333b) - motionEvent.getX();
            bVar.f48336e = (motionEvent.getRawY() + bVar.f48334c) - motionEvent.getY();
            bVar.f48337f = motionEvent.getPressure(i2);
            return bVar;
        }
        return (b) invokeLI.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48327a : (String) invokeV.objValue;
    }

    public final void f(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
            try {
                if (!(motionEvent.getActionMasked() == 2)) {
                    this.f48330d.add(d(motionEvent, motionEvent.getActionIndex()));
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                for (int i2 = 0; i2 < pointerCount; i2++) {
                    this.f48330d.add(d(motionEvent, i2));
                }
            } catch (Exception e2) {
                if (f48326f) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) || TextUtils.equals(this.f48327a, "touchend") || TextUtils.equals(this.f48327a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i2) {
                    this.f48329c.add(d(motionEvent, i2));
                }
            }
        } catch (Exception e2) {
            if (f48326f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, motionEvent, str) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f48327a = "touchstart";
                f(motionEvent);
            } else if (actionMasked == 1) {
                this.f48327a = "touchend";
                f(motionEvent);
            } else if (actionMasked == 2) {
                this.f48327a = "touchmove";
                f(motionEvent);
            } else if (actionMasked == 3) {
                this.f48327a = "touchcancel";
                f(motionEvent);
            } else if (actionMasked == 5) {
                this.f48327a = "touchpointerdown";
                f(motionEvent);
            } else if (actionMasked != 6) {
                this.f48327a = "error";
            } else {
                this.f48327a = "touchpointerup";
                f(motionEvent);
            }
            this.f48328b = motionEvent.getEventTime();
            if (!TextUtils.isEmpty(str)) {
                this.f48327a = str;
            }
            g(motionEvent);
            if (TextUtils.equals(this.f48327a, "touchpointerdown")) {
                this.f48327a = "touchstart";
            }
            if (TextUtils.equals(this.f48327a, "touchpointerup")) {
                this.f48327a = "touchend";
            }
        }
    }

    public void i(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iArr) == null) {
            this.f48331e = iArr;
            if (f48326f) {
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
        this.f48327a = "error";
        this.f48328b = 0L;
        this.f48329c = new ArrayList();
        this.f48330d = new ArrayList();
        this.f48331e = new int[2];
        h(motionEvent, str);
    }
}
