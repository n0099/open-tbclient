package d.a.q0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Typeface;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class o extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f46582a;

    /* renamed from: b  reason: collision with root package name */
    public float f46583b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46584c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46585d;

    public o() {
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
        this.f46582a = TypefaceCompatApi28Impl.DEFAULT_FAMILY;
        this.f46583b = d.a.q0.a.v2.n0.g(10.0f);
        this.f46584c = false;
        this.f46585d = false;
    }

    @Override // d.a.q0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (this.f46584c && this.f46585d) {
                i2 = 3;
            } else if (this.f46584c) {
                i2 = 1;
            } else {
                i2 = this.f46585d ? 2 : 0;
            }
            bVar.f46524i.setTypeface(Typeface.create(this.f46582a, i2));
            bVar.f46524i.setTextSize(this.f46583b);
        }
    }

    @Override // d.a.q0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 0) {
                    for (String str : jSONArray.optString(0).split(" ")) {
                        if (str.contains("italic")) {
                            this.f46585d = true;
                        } else if (str.contains("oblique")) {
                            this.f46585d = true;
                        } else if (str.contains("bold")) {
                            this.f46584c = true;
                        } else if (!str.contains("normal")) {
                            if (Character.isDigit(str.charAt(0))) {
                                int length = str.length();
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= str.length()) {
                                        break;
                                    } else if (!Character.isDigit(str.charAt(i2))) {
                                        length = i2;
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                this.f46583b = d.a.q0.a.v2.n0.g(Float.parseFloat(str.substring(0, length)));
                            } else {
                                this.f46582a = str;
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                if (d.a.q0.a.k.f49133a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
