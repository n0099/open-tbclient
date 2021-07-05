package d.a.q0.a.w2.j;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.view.menu.SwanImageMenuView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends d.a.q0.a.z1.b.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        s(-1);
        p(true);
        q(true);
    }

    @Override // d.a.q0.a.z1.b.e.a
    public void l(View view, List<d.a.q0.a.z1.b.e.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, list) == null) {
            ((SwanImageMenuView) view).d(list);
        }
    }

    @Override // d.a.q0.a.z1.b.e.a
    public View m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            SwanImageMenuView swanImageMenuView = new SwanImageMenuView(context);
            swanImageMenuView.setMenu(this);
            return swanImageMenuView;
        }
        return (View) invokeL.objValue;
    }

    @Override // d.a.q0.a.z1.b.e.a
    public void u(PopupWindow popupWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, popupWindow) == null) {
            popupWindow.showAtLocation(this.f52075a, 80, 0, 0);
        }
    }
}
