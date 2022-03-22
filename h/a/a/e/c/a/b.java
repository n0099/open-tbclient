package h.a.a.e.c.a;

import android.database.ContentObserver;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import tv.athena.revenue.payui.activity.immersion.BarHide;
/* loaded from: classes7.dex */
public class b implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ContentObserver A;
    @ColorInt
    public int a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    public int f45093b;
    @FloatRange(from = 0.0d, to = 1.0d)

    /* renamed from: c  reason: collision with root package name */
    public float f45094c;
    @FloatRange(from = 0.0d, to = 1.0d)

    /* renamed from: d  reason: collision with root package name */
    public float f45095d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45096e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45097f;

    /* renamed from: g  reason: collision with root package name */
    public BarHide f45098g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45099h;
    public boolean i;
    @ColorInt
    public int j;
    @ColorInt
    public int k;
    public Map<View, Map<Integer, Integer>> l;
    @FloatRange(from = 0.0d, to = 1.0d)
    public float m;
    public boolean n;
    public View o;
    public View p;
    public View q;
    @ColorInt
    public int r;
    public boolean s;
    public boolean t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public e y;
    public g z;

    public b() {
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
        this.a = 0;
        this.f45093b = -16777216;
        this.f45094c = 0.0f;
        this.f45095d = 0.0f;
        this.f45096e = false;
        this.f45097f = false;
        this.f45098g = BarHide.FLAG_SHOW_BAR;
        this.f45099h = false;
        this.i = true;
        this.j = -16777216;
        this.k = -16777216;
        this.l = new HashMap();
        this.m = 0.0f;
        this.n = false;
        this.s = false;
        this.t = false;
        this.u = 18;
        this.v = true;
        this.w = true;
        this.x = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public b clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (b) super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (b) invokeV.objValue;
    }
}
