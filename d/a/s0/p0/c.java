package d.a.s0.p0;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.faceshop.EmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class c extends d.a.r0.w.p.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f64385e;

    /* renamed from: f  reason: collision with root package name */
    public String f64386f;

    /* renamed from: g  reason: collision with root package name */
    public int f64387g;

    /* renamed from: h  reason: collision with root package name */
    public int f64388h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<String> f64389i;

    public c(EmotionGroupData emotionGroupData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {emotionGroupData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64389i = new ArrayList<>();
        this.f64385e = emotionGroupData.getGroupId();
        this.f64386f = emotionGroupData.getGroupName();
        this.f64387g = emotionGroupData.getWidth();
        this.f64388h = emotionGroupData.getHeight();
        t();
    }

    @Override // d.a.r0.w.p.c
    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 >= this.f64389i.size()) {
                return null;
            }
            return this.f64389i.get(i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // d.a.r0.w.p.c
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64389i.size() : invokeV.intValue;
    }

    @Override // d.a.r0.w.p.c
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64385e : (String) invokeV.objValue;
    }

    @Override // d.a.r0.w.p.c
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64386f : (String) invokeV.objValue;
    }

    @Override // d.a.r0.w.p.c
    public EmotionGroupType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? EmotionGroupType.BIG_EMOTION : (EmotionGroupType) invokeV.objValue;
    }

    @Override // d.a.r0.w.p.c
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64388h : invokeV.intValue;
    }

    @Override // d.a.r0.w.p.c
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.r0.w.p.c
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64387g : invokeV.intValue;
    }

    @Override // d.a.r0.w.p.c
    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? this.f64389i.contains(str) : invokeL.booleanValue;
    }

    @Override // d.a.r0.w.p.c
    public d.a.c.k.d.a n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return null;
        }
        return (d.a.c.k.d.a) invokeL.objValue;
    }

    @Override // d.a.r0.w.p.c
    public d.a.c.k.d.a o(String str) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (u(str)) {
                b2 = b.c(str, true, false);
            } else {
                b2 = b.b(str, false);
            }
            Bitmap f2 = b.f(this.f64385e, b2);
            if (f2 == null) {
                return null;
            }
            return new d.a.c.k.d.a(f2, false, str);
        }
        return (d.a.c.k.d.a) invokeL.objValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            s(2);
            p(4);
            Bitmap f2 = b.f(this.f64385e, "panel.png");
            Bitmap f3 = b.f(this.f64385e, "panel_momo.png");
            if (f2 != null) {
                q(new d.a.c.k.d.a(f2, false));
            }
            if (f3 != null) {
                r(new d.a.c.k.d.a(f3, false));
            }
            this.f64389i.clear();
            for (EmotionData emotionData : g.k().m(this.f64385e)) {
                this.f64389i.add(emotionData.getSharpText());
            }
        }
    }

    public boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("_") && !substring.contains("collect_")) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
