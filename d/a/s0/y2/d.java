package d.a.s0.y2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f69640a;

    /* renamed from: b  reason: collision with root package name */
    public String f69641b;

    /* renamed from: c  reason: collision with root package name */
    public String f69642c;

    /* renamed from: d  reason: collision with root package name */
    public String f69643d;

    /* renamed from: e  reason: collision with root package name */
    public String f69644e;

    /* renamed from: f  reason: collision with root package name */
    public String f69645f;

    /* renamed from: g  reason: collision with root package name */
    public int f69646g;

    /* renamed from: h  reason: collision with root package name */
    public int f69647h;

    /* renamed from: i  reason: collision with root package name */
    public int f69648i;
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
            dVar.f69648i = 0;
            dVar.f69646g = 4;
            dVar.f69647h = 4;
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
        this.f69643d = msgContent.title;
        this.q = msgContent.url;
        this.f69645f = msgContent.src;
        this.f69644e = msgContent.text;
        a(this);
    }
}
