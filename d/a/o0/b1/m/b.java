package d.a.o0.b1.m;

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
    public int f51724a;

    /* renamed from: b  reason: collision with root package name */
    public int f51725b;

    /* renamed from: c  reason: collision with root package name */
    public int f51726c;

    /* renamed from: d  reason: collision with root package name */
    public int f51727d;

    /* renamed from: e  reason: collision with root package name */
    public int f51728e;

    /* renamed from: f  reason: collision with root package name */
    public int f51729f;

    /* renamed from: g  reason: collision with root package name */
    public int f51730g;

    /* renamed from: h  reason: collision with root package name */
    public int f51731h;

    /* renamed from: i  reason: collision with root package name */
    public int f51732i;
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
        this.f51724a = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.f51725b = R.color.CAM_X0305;
        this.f51726c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.f51727d = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        this.f51728e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
        this.f51729f = 0;
        this.f51730g = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        this.f51731h = 0;
        this.f51732i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds26);
        this.j = str;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (String) invokeV.objValue;
    }
}
