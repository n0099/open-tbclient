package d.a.s0.u0.a2.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.u0.k2.e;
/* loaded from: classes9.dex */
public class a extends d.a.c.k.e.a<d.a.s0.u0.a2.g.a, C1704a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.s0.u0.a2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1704a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public EMTextView f65755a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f65756b;

        /* renamed from: c  reason: collision with root package name */
        public int f65757c;

        /* renamed from: d  reason: collision with root package name */
        public int f65758d;

        /* renamed from: d.a.s0.u0.a2.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC1705a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1704a f65759e;

            public View$OnClickListenerC1705a(C1704a c1704a, a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1704a, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65759e = c1704a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f65759e.f65757c <= 0) {
                    return;
                }
                e eVar = new e();
                eVar.f66235e = 16;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, eVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new d.a.s0.u0.a2.h.a(4, this.f65759e.f65758d, 2)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1704a(a aVar, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f65755a = (EMTextView) view.findViewById(R.id.frs_item_comment_bottom_text);
            this.f65756b = (ImageView) view.findViewById(R.id.frs_item_comment_bottom_icon);
            this.f65755a.setOnClickListener(new View$OnClickListenerC1705a(this, aVar));
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.r0.r.u.c.d(this.f65755a).t(R.color.CAM_X0304);
                d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.itemView);
                d2.m(2);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0205);
                WebPManager.setPureDrawable(this.f65756b, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0304, null);
            }
        }

        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f65757c = i2;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44825i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: f0 */
    public C1704a Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new C1704a(this, LayoutInflater.from(this.f44821e).inflate(R.layout.frs_item_comment_bottom_view, (ViewGroup) null)) : (C1704a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.s0.u0.a2.g.a aVar, C1704a c1704a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, c1704a})) == null) {
            c1704a.f(aVar.c());
            c1704a.f65758d = aVar.d();
            c1704a.e();
            return c1704a.a();
        }
        return (View) invokeCommon.objValue;
    }
}
