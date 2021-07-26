package d.a.p0.u;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f54102a;

    /* renamed from: b  reason: collision with root package name */
    public String f54103b;

    /* renamed from: c  reason: collision with root package name */
    public String f54104c;

    /* renamed from: d  reason: collision with root package name */
    public int f54105d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54106e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54107f;

    /* renamed from: g  reason: collision with root package name */
    public String f54108g;

    /* renamed from: h  reason: collision with root package name */
    public List<FrsTabItemData> f54109h;

    /* renamed from: i  reason: collision with root package name */
    public PostPrefixData f54110i;
    public boolean j;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
