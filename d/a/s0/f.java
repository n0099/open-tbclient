package d.a.s0;

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
    public HashSet<String> f68077a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f68078b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f68079c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f68080d;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f68081e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f68082f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f68083g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, m> f68084h;

    /* renamed from: i  reason: collision with root package name */
    public HashSet<String> f68085i;
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
        this.f68077a = new HashSet<>();
        this.f68078b = new HashSet<>();
        this.f68079c = new HashSet<>();
        this.f68080d = new HashSet<>();
        this.f68081e = new HashSet<>();
        this.f68082f = new HashMap<>();
        this.f68083g = new HashMap<>();
        this.f68084h = new HashMap<>();
        this.f68085i = new HashSet<>();
        this.j = new HashSet<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.m = new HashMap<>();
    }
}
