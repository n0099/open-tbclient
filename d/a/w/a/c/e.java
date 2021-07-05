package d.a.w.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f70802a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f70803b;

    /* renamed from: c  reason: collision with root package name */
    public Socket f70804c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f70805d;

    /* renamed from: e  reason: collision with root package name */
    public OutputStream f70806e;

    public e() {
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
        Boolean bool = Boolean.FALSE;
        this.f70802a = bool;
        this.f70803b = bool;
        this.f70804c = null;
        this.f70805d = null;
        this.f70806e = null;
    }
}
