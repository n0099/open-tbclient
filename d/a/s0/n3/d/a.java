package d.a.s0.n3.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetPendantByCategory.ThemePendantInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f64105a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f64106b;

    public a() {
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

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64105a : (String) invokeV.objValue;
    }

    public List<DressItemData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64106b : (List) invokeV.objValue;
    }

    public void c(ThemePendantInMain themePendantInMain) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, themePendantInMain) == null) || themePendantInMain == null) {
            return;
        }
        this.f64105a = themePendantInMain.pendant_category;
        this.f64106b = new ArrayList();
        for (ThemeBgProp themeBgProp : themePendantInMain.props) {
            this.f64106b.add(new DressItemData(themeBgProp));
        }
    }
}
