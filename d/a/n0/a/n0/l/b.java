package d.a.n0.a.n0.l;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface b {
    public static final boolean e0 = k.f45831a;

    /* loaded from: classes7.dex */
    public interface a {
        String a();

        JSONObject b();

        boolean isValid();
    }

    /* renamed from: d.a.n0.a.n0.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0831b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, a> f46312a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f46313b;

        /* renamed from: c  reason: collision with root package name */
        public int f46314c;

        /* renamed from: d  reason: collision with root package name */
        public int f46315d;

        public C0831b() {
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
            this.f46312a = new HashMap();
            this.f46313b = true;
            this.f46314c = 0;
            this.f46315d = 0;
        }
    }
}
