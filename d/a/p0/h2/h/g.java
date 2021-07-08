package d.a.p0.h2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.x1;
/* loaded from: classes8.dex */
public class g implements d.a.c.k.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f56902e;

    /* renamed from: f  reason: collision with root package name */
    public String f56903f;

    /* renamed from: g  reason: collision with root package name */
    public int f56904g;

    /* renamed from: h  reason: collision with root package name */
    public int f56905h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56906i;
    public String j;
    public String k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2029045226, "Ld/a/p0/h2/h/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2029045226, "Ld/a/p0/h2/h/g;");
                return;
            }
        }
        l = BdUniqueId.gen();
    }

    public g(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f56906i = false;
        if (forumData == null) {
            return;
        }
        this.f56902e = forumData.getName();
        this.f56903f = forumData.getImage_url();
        this.f56904g = forumData.getPost_num();
        this.f56905h = forumData.getMember_num();
        this.j = forumData.getId();
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? l : (BdUniqueId) invokeV.objValue;
    }

    public g(x1 x1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x1Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f56906i = false;
        if (x1Var == null) {
            return;
        }
        this.f56902e = x1Var.f52815b;
        this.f56903f = x1Var.f52816c;
        this.f56904g = x1Var.f52821h;
        this.f56905h = x1Var.f52822i;
        this.j = x1Var.f52814a;
    }
}
