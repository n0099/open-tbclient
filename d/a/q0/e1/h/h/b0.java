package d.a.q0.e1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b0 extends d.a.d.k.e.a<d.a.q0.e1.h.j.h, CardViewHolder<b>> {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;

    /* loaded from: classes8.dex */
    public class a implements d.a.d.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f56085e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b0 f56086f;

        public a(b0 b0Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56086f = b0Var;
            this.f56085e = bVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, d.a.d.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) || view == null || (bVar = this.f56085e) == null || d.a.d.e.p.k.isEmpty(bVar.p)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12885"));
            UrlManager.getInstance().dealOneLink(this.f56086f.m, new String[]{this.f56085e.p});
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends d.a.q0.a0.b<d.a.q0.e1.h.j.h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView m;
        public ImageView n;
        public View o;
        public String p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            TbImageView tbImageView = (TbImageView) k().findViewById(R.id.quiz_entrance_img);
            this.m = tbImageView;
            tbImageView.setAutoChangeStyle(true);
            this.m.setRadiusById(R.string.J_X06);
            this.m.setConrers(15);
            this.m.setScaleType(ImageView.ScaleType.FIT_XY);
            this.m.setPlaceHolder(2);
            this.o = k().findViewById(R.id.close_layout);
            this.n = (ImageView) k().findViewById(R.id.close);
            this.o.setOnClickListener(this);
            k().setOnClickListener(this);
            WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, null);
            m(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // d.a.q0.a0.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_quiz_entrance : invokeV.intValue;
        }

        @Override // d.a.q0.a0.b
        public void m(TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
                SkinManager.setBackgroundColor(k(), R.color.transparent);
                WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, null);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.o) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016569));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b
        /* renamed from: s */
        public void l(d.a.q0.e1.h.j.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
                if (hVar != null) {
                    t(hVar.f56176f, hVar.f56175e);
                    this.m.setPlaceHolder(2);
                    this.m.M(hVar.f56177g, 10, false);
                    this.p = hVar.f56178h;
                }
                m(j(), TbadkCoreApplication.getInst().getSkinType());
            }
        }

        public final void t(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) || this.m == null) {
                return;
            }
            Context context = TbadkCoreApplication.getInst().getContext();
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            if (context == null || layoutParams == null) {
                return;
            }
            int i4 = b0.n;
            int i5 = (i2 <= 0 || i3 <= 0) ? (int) (((i4 * 1.0f) * 182.0f) / 988.0f) : (int) (((i4 * 1.0f) * i3) / i2);
            layoutParams.width = -1;
            layoutParams.height = i5;
            this.m.setLayoutParams(layoutParams);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2107317433, "Ld/a/q0/e1/h/h/b0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2107317433, "Ld/a/q0/e1/h/h/b0;");
                return;
            }
        }
        n = d.a.d.e.p.l.k(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: g0 */
    public CardViewHolder<b> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b bVar = new b(this.m, viewGroup);
            bVar.k().setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
            a0(new a(this, bVar));
            return new CardViewHolder<>(bVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.e1.h.j.h hVar, CardViewHolder<b> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, hVar, cardViewHolder})) == null) {
            if (hVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
                return null;
            }
            TiebaStatic.log(new StatisticItem("c12884"));
            cardViewHolder.b().l(hVar);
            return cardViewHolder.b().k();
        }
        return (View) invokeCommon.objValue;
    }
}
