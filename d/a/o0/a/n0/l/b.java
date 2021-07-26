package d.a.o0.a.n0.l;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface b {
    public static final boolean e0 = k.f46335a;

    /* loaded from: classes7.dex */
    public interface a {
        String a();

        JSONObject b();

        boolean isValid();
    }

    /* renamed from: d.a.o0.a.n0.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0840b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, a> f46816a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f46817b;

        /* renamed from: c  reason: collision with root package name */
        public int f46818c;

        /* renamed from: d  reason: collision with root package name */
        public int f46819d;

        public C0840b() {
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
            this.f46816a = new HashMap();
            this.f46817b = true;
            this.f46818c = 0;
            this.f46819d = 0;
        }
    }
}
