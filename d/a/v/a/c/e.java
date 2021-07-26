package d.a.v.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f68373a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f68374b;

    /* renamed from: c  reason: collision with root package name */
    public Socket f68375c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f68376d;

    /* renamed from: e  reason: collision with root package name */
    public OutputStream f68377e;

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
        this.f68373a = bool;
        this.f68374b = bool;
        this.f68375c = null;
        this.f68376d = null;
        this.f68377e = null;
    }
}
