package d.a.k;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
/* loaded from: classes7.dex */
public class d0 extends c implements p<b2>, q {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f43143i;
    public ImageView j;
    public FrameLayout k;
    public b2 l;
    public BdUniqueId m;
    public int n;
    public int o;
    public int p;
    public Align q;
    public View.OnClickListener r;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d0 f43144e;

        public a(d0 d0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43144e = d0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f43144e.l == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921428, this.f43144e.m);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, this.f43144e.l);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-464841434, "Ld/a/k/d0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-464841434, "Ld/a/k/d0;");
                return;
            }
        }
        s = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    }

    public d0(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = 0;
        this.o = R.drawable.ic_icon_pure_card_delete_svg;
        this.p = R.color.CAM_X0111;
        this.r = new a(this);
        this.n = i2;
        this.f43143i = new RelativeLayout(context);
        this.j = new ImageView(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.k = frameLayout;
        ImageView imageView = this.j;
        int i5 = s;
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i5, i5));
        this.k.setOnClickListener(this.r);
        m(Align.ALIGN_RIGHT_BOTTOM);
        this.f43143i.addView(this.k);
        g(this.f43143i);
        h(-1);
        i(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void m(Align align) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, align) == null) || align == this.q) {
            return;
        }
        if (align == Align.ALIGN_RIGHT_TOP) {
            int g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds77);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            layoutParams.topMargin = g2;
            layoutParams.bottomMargin = 0;
            this.k.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            this.k.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            layoutParams3.bottomMargin = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds51);
            layoutParams3.topMargin = 0;
            this.k.setLayoutParams(layoutParams3);
        }
        this.q = align;
    }

    public void n(d.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            m(Align.ALIGN_RIGHT_TOP);
        }
    }

    public final boolean o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? (i2 & this.n) > 0 : invokeI.booleanValue;
    }

    @Override // d.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, this.o, this.p, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.p
    /* renamed from: p */
    public void a(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, b2Var) == null) {
            this.l = b2Var;
            if (b2Var == null) {
                this.k.setVisibility(8);
            } else if (!o(4)) {
                this.k.setVisibility(8);
            } else {
                this.k.setVisibility(0);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, this.o, this.p, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.m = bdUniqueId;
        }
    }
}
