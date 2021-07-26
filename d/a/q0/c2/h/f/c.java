package d.a.q0.c2.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.q.h;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f55365a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f55366b;

    /* renamed from: c  reason: collision with root package name */
    public View f55367c;

    /* renamed from: d  reason: collision with root package name */
    public View f55368d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f55369e;

    public c(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.f55368d = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.emotion_manage_header_content);
        this.f55369e = linearLayout;
        linearLayout.setVisibility(8);
        this.f55365a = this.f55368d.findViewById(R.id.emotion_manage_item_header);
        this.f55366b = (TextView) this.f55368d.findViewById(R.id.emotion_manage_total_title);
        View findViewById = this.f55368d.findViewById(R.id.emotion_manage_edit_lable);
        this.f55367c = findViewById;
        findViewById.setVisibility(8);
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55368d : (View) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            View view = this.f55365a;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i2);
            }
            LinearLayout linearLayout = this.f55369e;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0204, i2);
            }
            TextView textView = this.f55366b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i2);
                SkinManager.setBackgroundColor(this.f55366b, R.color.CAM_X0204, i2);
            }
            View view2 = this.f55367c;
            if (view2 != null) {
                SkinManager.setViewTextColor(view2, R.color.CAM_X0107, i2);
                SkinManager.setBackgroundColor(this.f55367c, R.color.CAM_X0204, i2);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d.a.q0.c2.h.a.b().a()) {
                this.f55367c.setVisibility(0);
            } else {
                this.f55367c.setVisibility(8);
            }
        }
    }

    public void d(Integer num) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, num) == null) || num == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.f55369e.setVisibility(8);
        } else {
            this.f55366b.setText(String.format(h.a(R.string.emotion_manage_local_number), num));
            this.f55369e.setVisibility(0);
        }
        if (d.a.q0.c2.h.a.b().a()) {
            this.f55367c.setVisibility(0);
        } else {
            this.f55367c.setVisibility(8);
        }
    }
}
