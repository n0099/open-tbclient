package d.a.n0.a.z1.b.f.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f48855a;

    /* renamed from: b  reason: collision with root package name */
    public View f48856b;

    /* renamed from: c  reason: collision with root package name */
    public Context f48857c;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48856b = null;
        this.f48857c = context;
    }

    public b a(View view, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, view2)) == null) {
            this.f48855a = view;
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) this.f48855a.getParent();
                int indexOfChild = viewGroup.indexOfChild(this.f48855a);
                View view3 = this.f48856b;
                if (view3 != null) {
                    viewGroup.removeView(view3);
                }
                this.f48856b = view2;
                view2.setLayoutParams(this.f48855a.getLayoutParams());
                viewGroup.addView(this.f48856b, indexOfChild);
                if (viewGroup instanceof RelativeLayout) {
                    this.f48855a.setVisibility(4);
                } else {
                    this.f48855a.setVisibility(8);
                }
                return this;
            }
            return this;
        }
        return (b) invokeLL.objValue;
    }
}
