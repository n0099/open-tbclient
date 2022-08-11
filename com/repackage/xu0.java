package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"InflateParams"})
/* loaded from: classes7.dex */
public class xu0 extends pu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout e;
    public a f;
    public b g;
    public BdNetUtils.NetStatus h;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z);

        void b(@NonNull BdVideoSeries bdVideoSeries);

        View c();
    }

    /* loaded from: classes7.dex */
    public static class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public ViewGroup b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public Button g;
        public final xu0 h;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.h.M();
                }
            }
        }

        public b(@NonNull Context context, @NonNull xu0 xu0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, xu0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.h = xu0Var;
            e();
        }

        @Override // com.repackage.xu0.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        @Override // com.repackage.xu0.a
        public void b(@NonNull BdVideoSeries bdVideoSeries) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries) == null) {
                String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bc6);
                int a2 = mv0.a(bdVideoSeries);
                ClarityUrlList clarityList = bdVideoSeries.getClarityList();
                if (a2 >= 0 && clarityList != null && clarityList.size() > 0) {
                    String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c05, String.valueOf(clarityList.get(0).k()));
                    this.c.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c01) + l01.a(a2, false));
                    this.d.setText(string2);
                    this.e.setVisibility(0);
                    this.d.setVisibility(0);
                    this.c.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                    this.d.setVisibility(8);
                    this.c.setVisibility(8);
                }
                this.f.setText(string);
                this.g.setOnClickListener(new a(this));
            }
        }

        @Override // com.repackage.xu0.a
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (View) invokeV.objValue;
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d05be, (ViewGroup) null);
                this.b = viewGroup;
                this.c = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09236d);
                this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09236e);
                this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0915ee);
                this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09236f);
                this.g = (Button) this.b.findViewById(R.id.obfuscated_res_0x7f090406);
            }
        }
    }

    public xu0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = BdNetUtils.NetStatus.NET_DOWN;
        FrameLayout frameLayout = new FrameLayout(this.c);
        this.e = frameLayout;
        frameLayout.setVisibility(8);
    }

    public final void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            String h1 = u().h1();
            StringBuilder sb = new StringBuilder(t().getString(R.string.obfuscated_res_0x7f0f0bd2));
            if (!h1.isEmpty()) {
                sb.append("，\n");
                sb.append(str);
                sb.append(h1);
                sb.append("MB");
            }
            xz0.a().showToast(t(), sb.toString());
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            F(kr0.w(LayerEvent.ACTION_CLICK_NET_TIP));
            this.e.setVisibility(8);
            O(true);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            F(kr0.w(LayerEvent.ACTION_HIDE_CACHE_LOADING));
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            u11.a().b(z);
        }
    }

    @Override // com.repackage.hu0, com.repackage.vs0
    public void d(@NonNull ur0 ur0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ur0Var) == null) {
            String c2 = ur0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != 154871702) {
                if (hashCode == 1370689931 && c2.equals(PlayerEvent.ACTION_ON_INFO)) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (c2.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    return;
                }
                this.e.setVisibility(8);
                return;
            }
            int g = ur0Var.g(1);
            if (g == 904 || g == 956) {
                this.e.setVisibility(8);
            }
        }
    }

    @Override // com.repackage.uu0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    @Override // com.repackage.vs0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new int[]{2, 4, 1, 3} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.hu0, com.repackage.vs0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.e.setVisibility(8);
            }
        }
    }

    @Override // com.repackage.hu0, com.repackage.vs0
    public void k(@NonNull ur0 ur0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ur0Var) == null) || this.f == null) {
            return;
        }
        if (LayerEvent.ACTION_SWITCH_FULL.equals(ur0Var.c())) {
            this.f.a(true);
        } else if (LayerEvent.ACTION_SWITCH_HALF.equals(ur0Var.c())) {
            this.f.a(false);
        }
    }

    @Override // com.repackage.hu0, com.repackage.vs0
    public void n(@NonNull ur0 ur0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, ur0Var) == null) && SystemEvent.ACTION_CONNECT_CHANGED.equals(ur0Var.c())) {
            BdNetUtils.NetStatus a2 = BdNetUtils.a();
            if (a2 == BdNetUtils.NetStatus.NET_MOBILE && !BdNetUtils.h() && this.h != BdNetUtils.NetStatus.NET_MOBILE) {
                if (u().Y() && u().r() > 0 && u().S()) {
                    L(this.c.getString(R.string.obfuscated_res_0x7f0f0c04));
                }
            } else {
                BdNetUtils.NetStatus netStatus = BdNetUtils.NetStatus.NET_WIFI;
                if (a2 == netStatus && this.h != netStatus) {
                    this.e.setVisibility(8);
                    if (u().S() && !u().a0()) {
                        if (u().R()) {
                            u().m0();
                        } else if (u().C() == 0) {
                            u().K0();
                        } else {
                            u().l0();
                        }
                        xz0.a().a(t(), R.string.obfuscated_res_0x7f0f0bd4);
                    }
                }
            }
            this.h = a2;
        }
    }

    @Override // com.repackage.pu0, com.repackage.hu0, com.repackage.uu0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onLayerRelease();
            this.g = null;
            this.f = null;
        }
    }

    @Override // com.repackage.hu0, com.repackage.vs0
    public void q(@NonNull ur0 ur0Var) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, ur0Var) == null) || !ControlEvent.ACTION_SHOW_TIP.equals(ur0Var.c()) || u().U0() || (o1 = u().o1()) == null) {
            return;
        }
        if (this.g == null) {
            this.g = new b(this.c, this);
        }
        b bVar = this.g;
        this.f = bVar;
        if (bVar == null) {
            this.e.removeAllViews();
            this.e.setVisibility(8);
            return;
        }
        if (this.e.getChildAt(0) != this.f.c()) {
            this.e.removeAllViews();
            this.e.addView(this.f.c());
        }
        this.f.c().setVisibility(0);
        this.f.b(o1);
        this.e.setVisibility(0);
        u().y().y(true);
        u().y().j(this);
        N();
    }
}
