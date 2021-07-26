package d.a.o0.a.z1.b.b;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.z1.b.b.h;
/* loaded from: classes7.dex */
public class g extends h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Context f49220f;

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
        this.f49220f = context;
    }

    @Override // d.a.o0.a.z1.b.b.h.a
    public h c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f49227e = this.f49220f.getResources().getDimensionPixelSize(d.a.o0.a.d.aiapps_action_sheet_list_item);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f49227e);
            layoutParams.addRule(12);
            this.f49223a.t.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f49220f.getResources().getDimensionPixelSize(d.a.o0.a.d.aiapps_action_sheet_bottom_divider));
            layoutParams2.addRule(2, this.f49223a.t.getId());
            this.f49223a.f49244h.setLayoutParams(layoutParams2);
            o(d.a.o0.a.c.aiapps_action_sheet_split_color);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(2, this.f49223a.f49244h.getId());
            this.f49223a.u.setLayoutParams(layoutParams3);
            return super.c();
        }
        return (h) invokeV.objValue;
    }
}
