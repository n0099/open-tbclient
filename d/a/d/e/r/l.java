package d.a.d.e.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes7.dex */
public class l extends r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f42072a;

    /* renamed from: b  reason: collision with root package name */
    public String f42073b;

    /* renamed from: c  reason: collision with root package name */
    public String f42074c;

    /* renamed from: d  reason: collision with root package name */
    public String f42075d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f42076e;

    /* renamed from: f  reason: collision with root package name */
    public List<BasicNameValuePair> f42077f;

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
        this.f42072a = str;
        this.f42073b = "/";
        this.f42075d = null;
        this.f42076e = null;
        this.f42077f = null;
    }
}
