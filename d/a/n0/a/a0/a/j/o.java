package d.a.n0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Typeface;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class o extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f43280a;

    /* renamed from: b  reason: collision with root package name */
    public float f43281b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43282c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43283d;

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
        this.f43280a = TypefaceCompatApi28Impl.DEFAULT_FAMILY;
        this.f43281b = d.a.n0.a.v2.n0.g(10.0f);
        this.f43282c = false;
        this.f43283d = false;
    }

    @Override // d.a.n0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (this.f43282c && this.f43283d) {
                i2 = 3;
            } else if (this.f43282c) {
                i2 = 1;
            } else {
                i2 = this.f43283d ? 2 : 0;
            }
            bVar.f43222i.setTypeface(Typeface.create(this.f43280a, i2));
            bVar.f43222i.setTextSize(this.f43281b);
        }
    }

    @Override // d.a.n0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 0) {
                    for (String str : jSONArray.optString(0).split(" ")) {
                        if (str.contains("italic")) {
                            this.f43283d = true;
                        } else if (str.contains("oblique")) {
                            this.f43283d = true;
                        } else if (str.contains("bold")) {
                            this.f43282c = true;
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
                                this.f43281b = d.a.n0.a.v2.n0.g(Float.parseFloat(str.substring(0, length)));
                            } else {
                                this.f43280a = str;
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                if (d.a.n0.a.k.f45831a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
