package d.a.r0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashSet<String> f67399a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f67400b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f67401c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f67402d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f67403e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f67404f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f67405g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, m> f67406h;

    /* renamed from: i  reason: collision with root package name */
    public HashSet<String> f67407i;
    public HashSet<String> j;
    public HashMap<String, String> k;
    public HashMap<String, String> l;
    public HashMap<String, Integer> m;

    public f() {
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
        this.f67399a = new HashSet<>();
        this.f67400b = new HashSet<>();
        this.f67401c = new HashSet<>();
        this.f67402d = new HashSet<>();
        this.f67403e = new HashSet<>();
        this.f67404f = new HashMap<>();
        this.f67405g = new HashMap<>();
        this.f67406h = new HashMap<>();
        this.f67407i = new HashSet<>();
        this.j = new HashSet<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.m = new HashMap<>();
    }
}
