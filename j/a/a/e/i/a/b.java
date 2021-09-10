package j.a.a.e.i.a;

import android.database.ContentObserver;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import tv.athena.revenue.payui.activity.immersion.BarHide;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public e C;
    public g D;
    public ContentObserver E;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    public int f79059e;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    public int f79060f;
    @FloatRange(from = 0.0d, to = 1.0d)

    /* renamed from: g  reason: collision with root package name */
    public float f79061g;
    @FloatRange(from = 0.0d, to = 1.0d)

    /* renamed from: h  reason: collision with root package name */
    public float f79062h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f79063i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f79064j;
    public BarHide k;
    public boolean l;
    public boolean m;
    @ColorInt
    public int n;
    @ColorInt
    public int o;
    public Map<View, Map<Integer, Integer>> p;
    @FloatRange(from = 0.0d, to = 1.0d)
    public float q;
    public boolean r;
    public View s;
    public View t;
    public View u;
    @ColorInt
    public int v;
    public boolean w;
    public boolean x;
    public int y;
    public boolean z;

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
        this.f79059e = 0;
        this.f79060f = -16777216;
        this.f79061g = 0.0f;
        this.f79062h = 0.0f;
        this.f79063i = false;
        this.f79064j = false;
        this.k = BarHide.FLAG_SHOW_BAR;
        this.l = false;
        this.m = true;
        this.n = -16777216;
        this.o = -16777216;
        this.p = new HashMap();
        this.q = 0.0f;
        this.r = false;
        this.w = false;
        this.x = false;
        this.y = 18;
        this.z = true;
        this.A = true;
        this.B = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public b clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
