package d.a.q0.u0.m2;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes8.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f63886a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f63887b;

    /* renamed from: c  reason: collision with root package name */
    public int f63888c;

    /* renamed from: d  reason: collision with root package name */
    public a f63889d;

    /* loaded from: classes8.dex */
    public interface a {
        void onStateChanged(int i2);
    }

    public b(g gVar, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63888c = 0;
        this.f63886a = gVar;
        this.f63887b = intent;
        e c2 = d.d().c(this.f63887b.getStringExtra("info_forum_name_text"));
        c2.b();
        c2.a();
        if (c2.c()) {
            ((RelativeLayout.LayoutParams) this.f63886a.f63913g.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f63888c : invokeV.intValue;
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f63889d = aVar;
        }
    }

    public abstract void c();

    public abstract void d();
}
