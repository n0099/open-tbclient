package d.a.s0.h2.k.e.d1;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j.a;
import d.a.s0.a0.b0;
/* loaded from: classes9.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f60460f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60461g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, int i2) {
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
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f60444a.getPageActivity().getLayoutInflater().inflate(R.layout.delete_original_thread_view, (ViewGroup) null);
            this.f60460f = linearLayout;
            this.f60461g = (TextView) linearLayout.findViewById(R.id.text);
            return this.f60460f;
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
        SkinManager.setBackgroundColor(this.f60460f, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f60461g, R.color.CAM_X0105);
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f60461g.setText(new SpannableString(originalThreadInfo.f12236g));
            SkinManager.setViewTextColor(this.f60461g, R.color.CAM_X0105);
        }
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void d(a.InterfaceC0643a interfaceC0643a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0643a) == null) {
            super.d(interfaceC0643a);
        }
    }

    @Override // d.a.s0.h2.k.e.d1.a
    public void e(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            super.e(b0Var);
        }
    }
}
