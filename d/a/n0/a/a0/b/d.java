package d.a.n0.a.a0.b;

import androidx.core.graphics.TypefaceCompatApi28Impl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import d.a.n0.a.v2.n0;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String o;
    public String p;
    public float q;
    public boolean r;
    public boolean s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str) {
        super(str);
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = TypefaceCompatApi28Impl.DEFAULT_FAMILY;
        this.q = n0.g(10.0f);
        this.r = false;
        this.s = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.o = jSONObject.optString("text");
            String optString = jSONObject.optString("font");
            if (optString == null || optString.length() <= 0) {
                return;
            }
            for (String str2 : optString.split(" ")) {
                if (str2.contains("italic")) {
                    this.s = true;
                } else if (str2.contains("oblique")) {
                    this.s = true;
                } else if (str2.contains("bold")) {
                    this.r = true;
                } else if (!str2.contains("normal")) {
                    if (Character.isDigit(str2.charAt(0))) {
                        int length = str2.length();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= str2.length()) {
                                break;
                            } else if (!Character.isDigit(str2.charAt(i4))) {
                                length = i4;
                                break;
                            } else {
                                i4++;
                            }
                        }
                        this.q = n0.g(Float.parseFloat(str2.substring(0, length)));
                    } else {
                        this.p = str2;
                    }
                }
            }
        } catch (Exception e2) {
            if (k.f45831a) {
                e2.printStackTrace();
            }
        }
    }
}
