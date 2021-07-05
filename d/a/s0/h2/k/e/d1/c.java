package d.a.s0.h2.k.e.d1;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.w0;
import d.a.s0.a0.b0;
/* loaded from: classes9.dex */
public class c extends d.a.s0.h2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public OriginalThreadCardView f60455f;

    /* renamed from: g  reason: collision with root package name */
    public int f60456g;

    /* renamed from: h  reason: collision with root package name */
    public int f60457h;

    /* loaded from: classes9.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f60458a;

        /* renamed from: d.a.s0.h2.k.e.d1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1464a extends d.a.r0.r.q.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f60459e;

            public C1464a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f60459e = aVar;
            }

            @Override // d.a.r0.r.q.a
            public w0 getNegFeedBackData() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return null;
                }
                return (w0) invokeV.objValue;
            }

            @Override // d.a.r0.r.q.a
            public b2 getThreadData() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    OriginalThreadInfo originalThreadInfo = this.f60459e.f60458a.f60447d;
                    if (originalThreadInfo != null) {
                        return originalThreadInfo.a();
                    }
                    return null;
                }
                return (b2) invokeV.objValue;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
            public BdUniqueId getType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (BdUniqueId) invokeV.objValue;
            }
        }

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60458a = cVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            c cVar;
            b0 b0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) || (b0Var = (cVar = this.f60458a).f60445b) == null) {
                return;
            }
            b0Var.a(cVar.f60455f, new C1464a(this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60457h = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.f60456g = i2;
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f60455f == null) {
                OriginalThreadCardView originalThreadCardView = new OriginalThreadCardView(this.f60444a.getPageActivity());
                this.f60455f = originalThreadCardView;
                originalThreadCardView.q = this.f60456g;
                originalThreadCardView.setSubClickListener(new a(this));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i2 = this.f60457h;
                layoutParams.bottomMargin = i2;
                layoutParams.leftMargin = i2;
                layoutParams.rightMargin = i2;
                this.f60455f.setLayoutParams(layoutParams);
                this.f60455f.n();
            }
            return this.f60455f;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f60448e == i2) {
            return;
        }
        this.f60448e = i2;
        OriginalThreadCardView originalThreadCardView = this.f60455f;
        if (originalThreadCardView != null) {
            originalThreadCardView.n();
        }
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f60447d = originalThreadInfo;
            OriginalThreadCardView originalThreadCardView = this.f60455f;
            if (originalThreadCardView != null) {
                originalThreadCardView.f(originalThreadInfo);
            }
        }
    }
}
