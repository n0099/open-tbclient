package d.a.q0.a.z1.b.b;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.z1.b.b.h;
/* loaded from: classes8.dex */
public class g extends h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Context f52018f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context) {
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
        this.f52018f = context;
    }

    @Override // d.a.q0.a.z1.b.b.h.a
    public h c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f52025e = this.f52018f.getResources().getDimensionPixelSize(d.a.q0.a.d.aiapps_action_sheet_list_item);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f52025e);
            layoutParams.addRule(12);
            this.f52021a.t.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f52018f.getResources().getDimensionPixelSize(d.a.q0.a.d.aiapps_action_sheet_bottom_divider));
            layoutParams2.addRule(2, this.f52021a.t.getId());
            this.f52021a.f52042h.setLayoutParams(layoutParams2);
            o(d.a.q0.a.c.aiapps_action_sheet_split_color);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(2, this.f52021a.f52042h.getId());
            this.f52021a.u.setLayoutParams(layoutParams3);
            return super.c();
        }
        return (h) invokeV.objValue;
    }
}
