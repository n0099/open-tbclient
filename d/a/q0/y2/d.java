package d.a.q0.y2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f67121a;

    /* renamed from: b  reason: collision with root package name */
    public String f67122b;

    /* renamed from: c  reason: collision with root package name */
    public String f67123c;

    /* renamed from: d  reason: collision with root package name */
    public String f67124d;

    /* renamed from: e  reason: collision with root package name */
    public String f67125e;

    /* renamed from: f  reason: collision with root package name */
    public String f67126f;

    /* renamed from: g  reason: collision with root package name */
    public int f67127g;

    /* renamed from: h  reason: collision with root package name */
    public int f67128h;

    /* renamed from: i  reason: collision with root package name */
    public int f67129i;
    public String j;
    public String k;
    public long l;
    public long m;
    public boolean n;
    public boolean o;
    public int p;
    public String q;
    public String r;
    public long s;
    public long t;

    public d() {
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
        this.k = "";
    }

    public static void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dVar) == null) {
            dVar.f67129i = 0;
            dVar.f67127g = 4;
            dVar.f67128h = 4;
            dVar.l = System.currentTimeMillis();
            dVar.n = true;
        }
    }

    public d(MsgContent msgContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msgContent};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = "";
        this.f67124d = msgContent.title;
        this.q = msgContent.url;
        this.f67126f = msgContent.src;
        this.f67125e = msgContent.text;
        a(this);
    }
}
