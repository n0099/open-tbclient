package d.a.q0.h2.k.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
/* loaded from: classes8.dex */
public class h extends u0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57878c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragmentActivity) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57878c = null;
    }

    @Override // d.a.q0.h2.k.e.u0
    public void c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
            TextView textView = (TextView) this.f58090b.findViewById(R.id.icon_push);
            this.f57878c = textView;
            textView.setVisibility(8);
        }
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57878c : (TextView) invokeV.objValue;
    }

    public void f(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) || b2Var == null || b2Var.K0() == null) {
            return;
        }
        int status = b2Var.K0().getStatus();
        if (status == 1) {
            g(true);
        } else if (status == 2) {
            g(false);
        }
    }

    public void g(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (textView = this.f57878c) == null) {
            return;
        }
        if (z) {
            textView.setText(R.string.push);
            SkinManager.setViewTextColor(this.f57878c, R.drawable.push_text_selector);
            SkinManager.setBackgroundResource(this.f57878c, R.drawable.push_bg_selector);
            this.f57878c.setClickable(true);
        } else {
            textView.setText(R.string.already_push);
            SkinManager.setBackgroundResource(this.f57878c, R.drawable.label_bg_gray80);
            SkinManager.setViewTextColor(this.f57878c, R.color.CAM_X0109);
            this.f57878c.setClickable(false);
        }
        this.f57878c.setVisibility(0);
    }
}
