package d.a.j;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u0 extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext l;
    public int m;
    public VoteView n;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.q.a f45807e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ u0 f45808f;

        public a(u0 u0Var, d.a.r0.r.q.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45808f = u0Var;
            this.f45807e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadCardUtils.jumpToPB(this.f45807e, (Context) this.f45808f.l.getPageActivity(), this.f45808f.m, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new VoteView(context);
        r(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    @Override // d.a.j.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    @Override // d.a.j.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.n.C(i2);
        }
    }

    public final boolean u(d.a.r0.r.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().D0() == null || aVar.getThreadData().D0().getOptions() == null || aVar.getThreadData().D0().getOptions().size() <= 0 || aVar.getThreadData().q2()) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: v */
    public void a(d.a.r0.r.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (u(aVar)) {
                this.n.setVisibility(0);
                this.n.setData(aVar.getThreadData().D0(), aVar.getThreadData().n1(), aVar.getThreadData().Q());
                this.n.setOnItemClickListener(new a(this, aVar));
                return;
            }
            this.n.setVisibility(8);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.m = i2;
        }
    }

    public void x(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.l = tbPageContext;
            this.n.setPageContext(tbPageContext);
        }
    }
}
