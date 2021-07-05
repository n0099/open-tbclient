package d.a.q0.a.n0.l;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface b {
    public static final boolean e0 = k.f49133a;

    /* loaded from: classes8.dex */
    public interface a {
        String a();

        JSONObject b();

        boolean isValid();
    }

    /* renamed from: d.a.q0.a.n0.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0882b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, a> f49614a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f49615b;

        /* renamed from: c  reason: collision with root package name */
        public int f49616c;

        /* renamed from: d  reason: collision with root package name */
        public int f49617d;

        public C0882b() {
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
            this.f49614a = new HashMap();
            this.f49615b = true;
            this.f49616c = 0;
            this.f49617d = 0;
        }
    }
}
