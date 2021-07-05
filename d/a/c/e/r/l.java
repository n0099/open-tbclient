package d.a.c.e.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes8.dex */
public class l extends r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f44552a;

    /* renamed from: b  reason: collision with root package name */
    public String f44553b;

    /* renamed from: c  reason: collision with root package name */
    public String f44554c;

    /* renamed from: d  reason: collision with root package name */
    public String f44555d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f44556e;

    /* renamed from: f  reason: collision with root package name */
    public List<BasicNameValuePair> f44557f;

    public l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44552a = str;
        this.f44553b = "/";
        this.f44555d = null;
        this.f44556e = null;
        this.f44557f = null;
    }
}
