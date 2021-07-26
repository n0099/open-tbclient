package d.a.q0.h2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.x1;
/* loaded from: classes8.dex */
public class g implements d.a.d.k.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f57446e;

    /* renamed from: f  reason: collision with root package name */
    public String f57447f;

    /* renamed from: g  reason: collision with root package name */
    public int f57448g;

    /* renamed from: h  reason: collision with root package name */
    public int f57449h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57450i;
    public String j;
    public String k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2069408565, "Ld/a/q0/h2/h/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2069408565, "Ld/a/q0/h2/h/g;");
                return;
            }
        }
        m = BdUniqueId.gen();
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
        this.f57450i = false;
        if (forumData == null) {
            return;
        }
        this.f57446e = forumData.getName();
        this.f57447f = forumData.getImage_url();
        this.f57448g = forumData.getPost_num();
        this.f57449h = forumData.getMember_num();
        this.j = forumData.getId();
        this.l = forumData.isLike() == 1;
    }

    @Override // d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? m : (BdUniqueId) invokeV.objValue;
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
        this.f57450i = false;
        if (x1Var == null) {
            return;
        }
        this.f57446e = x1Var.f53479b;
        this.f57447f = x1Var.f53480c;
        this.f57448g = x1Var.f53485h;
        this.f57449h = x1Var.f53486i;
        this.j = x1Var.f53478a;
        this.l = x1Var.getIsLike();
    }
}
