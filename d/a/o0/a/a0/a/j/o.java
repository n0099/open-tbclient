package d.a.o0.a.a0.a.j;

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
    public String f43784a;

    /* renamed from: b  reason: collision with root package name */
    public float f43785b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43786c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43787d;

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
        this.f43784a = TypefaceCompatApi28Impl.DEFAULT_FAMILY;
        this.f43785b = d.a.o0.a.v2.n0.g(10.0f);
        this.f43786c = false;
        this.f43787d = false;
    }

    @Override // d.a.o0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (this.f43786c && this.f43787d) {
                i2 = 3;
            } else if (this.f43786c) {
                i2 = 1;
            } else {
                i2 = this.f43787d ? 2 : 0;
            }
            bVar.f43726i.setTypeface(Typeface.create(this.f43784a, i2));
            bVar.f43726i.setTextSize(this.f43785b);
        }
    }

    @Override // d.a.o0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 0) {
                    for (String str : jSONArray.optString(0).split(" ")) {
                        if (str.contains("italic")) {
                            this.f43787d = true;
                        } else if (str.contains("oblique")) {
                            this.f43787d = true;
                        } else if (str.contains("bold")) {
                            this.f43786c = true;
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
                                this.f43785b = d.a.o0.a.v2.n0.g(Float.parseFloat(str.substring(0, length)));
                            } else {
                                this.f43784a = str;
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                if (d.a.o0.a.k.f46335a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
