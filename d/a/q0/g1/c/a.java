package d.a.q0.g1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes8.dex */
public class a implements d.a.d.k.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f56936e;

    /* renamed from: f  reason: collision with root package name */
    public int f56937f;

    /* renamed from: g  reason: collision with root package name */
    public long f56938g;

    /* renamed from: h  reason: collision with root package name */
    public long f56939h;

    /* renamed from: i  reason: collision with root package name */
    public int f56940i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1153126592, "Ld/a/q0/g1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1153126592, "Ld/a/q0/g1/c/a;");
                return;
            }
        }
        j = BdUniqueId.gen();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void b(CommonInteraction commonInteraction) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, commonInteraction) == null) || commonInteraction == null) {
            return;
        }
        String str = commonInteraction.module_name;
        String str2 = commonInteraction.ques_desc;
        this.f56936e = commonInteraction.total_num.longValue();
        this.f56937f = commonInteraction.has_clicked.intValue();
        String str3 = commonInteraction.before_click_pic;
        String str4 = commonInteraction.after_click_pic;
        this.f56938g = commonInteraction.pk_id.longValue();
        this.f56939h = commonInteraction.user_pk_id.longValue();
    }

    @Override // d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? j : (BdUniqueId) invokeV.objValue;
    }
}
