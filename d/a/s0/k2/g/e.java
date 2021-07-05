package d.a.s0.k2.g;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.view.AutoBannerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.k2.e.n;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends d.a.s0.a0.b<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public LinearLayout n;
    public AutoBannerView o;
    public d.a.r0.r.w.b.d<d.a.s0.k2.e.a> p;

    /* loaded from: classes9.dex */
    public class a implements d.a.r0.r.w.b.d<d.a.s0.k2.e.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f62683a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62683a = eVar;
        }

        @Override // d.a.r0.r.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f62683a.o == null || str == null) {
                return;
            }
            if (this.f62683a.o.a(i2)) {
                TiebaStatic.log(new StatisticItem("c13247").param("obj_locate", i2).param("obj_param1", str));
            }
            this.f62683a.o.f();
            this.f62683a.o.b(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, d.a.s0.k2.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) || this.f62683a.o == null || aVar == null || aVar.c() == null || !this.f62683a.o.a(i2)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13246").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", i2).param("obj_param1", aVar.c()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 3;
        this.p = new a(this);
        View l = l();
        this.n = (LinearLayout) l.findViewById(R.id.viewpager);
        AutoBannerView autoBannerView = (AutoBannerView) l.findViewById(R.id.person_center_auto_banner_view);
        this.o = autoBannerView;
        autoBannerView.setMarqueenTime(3000L);
        this.o.getCoverFlowView().setCallback(this.p);
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.person_center_viewpager_layout : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        AutoBannerView autoBannerView = this.o;
        if (autoBannerView != null) {
            autoBannerView.e(i2);
        }
        SkinManager.setBackgroundColor(l(), R.color.CAM_X0205);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: t */
    public void m(n nVar) {
        List<d.a.s0.k2.e.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nVar) == null) {
            n(this.f57032f, TbadkCoreApplication.getInst().getSkinType());
            if (this.n == null || nVar == null || (list = nVar.f62670e) == null || this.o == null || list.size() == 0) {
                return;
            }
            this.o.d(nVar.f62670e);
        }
    }
}
