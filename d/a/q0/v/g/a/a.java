package d.a.q0.v.g.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.gamefrslivetab.video.AlaGameFrsLiveTabVideoFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.g0.c;
/* loaded from: classes8.dex */
public class a extends d.a.p0.g0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AlaGameFrsLiveTabVideoFragment f65385a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65385a = new AlaGameFrsLiveTabVideoFragment();
        getFragmentTabStructure().f52618a = this.f65385a;
    }

    public void a(String str) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (alaGameFrsLiveTabVideoFragment = this.f65385a) == null) {
            return;
        }
        alaGameFrsLiveTabVideoFragment.P0(str);
    }

    public void b(String str) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (alaGameFrsLiveTabVideoFragment = this.f65385a) == null) {
            return;
        }
        alaGameFrsLiveTabVideoFragment.Q0(str);
    }

    public void c(boolean z) {
        AlaGameFrsLiveTabVideoFragment alaGameFrsLiveTabVideoFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (alaGameFrsLiveTabVideoFragment = this.f65385a) == null) {
            return;
        }
        alaGameFrsLiveTabVideoFragment.R0(z);
    }

    @Override // d.a.p0.g0.b
    public c createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c cVar = new c();
            cVar.f52622e = 3;
            cVar.f52619b = R.string.ala_live;
            cVar.f52626i = c.k;
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    @Override // d.a.p0.g0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
            this.mIndicator = fragmentTabIndicator;
            fragmentTabIndicator.setTextSize(2.0f);
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // d.a.p0.g0.b
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
