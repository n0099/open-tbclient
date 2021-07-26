package d.a.p0.d1.m;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f52387a;

    /* renamed from: b  reason: collision with root package name */
    public int f52388b;

    /* renamed from: c  reason: collision with root package name */
    public int f52389c;

    /* renamed from: d  reason: collision with root package name */
    public int f52390d;

    /* renamed from: e  reason: collision with root package name */
    public int f52391e;

    /* renamed from: f  reason: collision with root package name */
    public int f52392f;

    /* renamed from: g  reason: collision with root package name */
    public int f52393g;

    /* renamed from: h  reason: collision with root package name */
    public int f52394h;

    /* renamed from: i  reason: collision with root package name */
    public int f52395i;
    public String j;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52387a = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.f52388b = R.color.CAM_X0305;
        this.f52389c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.f52390d = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        this.f52391e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
        this.f52392f = 0;
        this.f52393g = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        this.f52394h = 0;
        this.f52395i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds26);
        this.j = str;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (String) invokeV.objValue;
    }
}
