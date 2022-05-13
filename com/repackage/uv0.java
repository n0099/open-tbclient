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
public class uv0 extends mv0 {
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
        public final uv0 h;

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

        public b(@NonNull Context context, @NonNull uv0 uv0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, uv0Var};
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
            this.h = uv0Var;
            e();
        }

        @Override // com.repackage.uv0.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        @Override // com.repackage.uv0.a
        public void b(@NonNull BdVideoSeries bdVideoSeries) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries) == null) {
                String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bb7);
                int a2 = jw0.a(bdVideoSeries);
                ClarityUrlList clarityList = bdVideoSeries.getClarityList();
                if (a2 >= 0 && clarityList != null && clarityList.size() > 0) {
                    String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bf6, String.valueOf(clarityList.get(0).k()));
                    this.c.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bf2) + i11.a(a2, false));
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

        @Override // com.repackage.uv0.a
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (View) invokeV.objValue;
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d058a, (ViewGroup) null);
                this.b = viewGroup;
                this.c = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09221a);
                this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09221b);
                this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0914fe);
                this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09221c);
                this.g = (Button) this.b.findViewById(R.id.obfuscated_res_0x7f0903f5);
            }
        }
    }

    public uv0() {
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
            String h1 = v().h1();
            StringBuilder sb = new StringBuilder(u().getString(R.string.obfuscated_res_0x7f0f0bc3));
            if (!h1.isEmpty()) {
                sb.append("，\n");
                sb.append(str);
                sb.append(h1);
                sb.append("MB");
            }
            u01.a().a(u(), sb.toString());
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            G(hs0.w(LayerEvent.ACTION_CLICK_NET_TIP));
            this.e.setVisibility(8);
            O(true);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            G(hs0.w(LayerEvent.ACTION_HIDE_CACHE_LOADING));
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            j21.a().b(z);
        }
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void d(@NonNull rs0 rs0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rs0Var) == null) {
            String c2 = rs0Var.c();
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
            int g = rs0Var.g(1);
            if (g == 904 || g == 956) {
                this.e.setVisibility(8);
            }
        }
    }

    @Override // com.repackage.rv0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    @Override // com.repackage.st0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new int[]{2, 4, 1, 3} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.e.setVisibility(8);
            }
        }
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void k(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rs0Var) == null) || this.f == null) {
            return;
        }
        if (LayerEvent.ACTION_SWITCH_FULL.equals(rs0Var.c())) {
            this.f.a(true);
        } else if (LayerEvent.ACTION_SWITCH_HALF.equals(rs0Var.c())) {
            this.f.a(false);
        }
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void n(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, rs0Var) == null) && SystemEvent.ACTION_CONNECT_CHANGED.equals(rs0Var.c())) {
            BdNetUtils.NetStatus a2 = BdNetUtils.a();
            if (a2 == BdNetUtils.NetStatus.NET_MOBILE && !BdNetUtils.h() && this.h != BdNetUtils.NetStatus.NET_MOBILE) {
                if (v().Y() && v().r() > 0 && v().S()) {
                    L(this.c.getString(R.string.obfuscated_res_0x7f0f0bf5));
                }
            } else {
                BdNetUtils.NetStatus netStatus = BdNetUtils.NetStatus.NET_WIFI;
                if (a2 == netStatus && this.h != netStatus) {
                    this.e.setVisibility(8);
                    if (v().S() && !v().a0()) {
                        if (v().R()) {
                            v().m0();
                        } else if (v().C() == 0) {
                            v().K0();
                        } else {
                            v().l0();
                        }
                        u01.a().b(u(), R.string.obfuscated_res_0x7f0f0bc5);
                    }
                }
            }
            this.h = a2;
        }
    }

    @Override // com.repackage.mv0, com.repackage.ev0, com.repackage.rv0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onLayerRelease();
            this.g = null;
            this.f = null;
        }
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void r(@NonNull rs0 rs0Var) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, rs0Var) == null) || !ControlEvent.ACTION_SHOW_TIP.equals(rs0Var.c()) || v().U0() || (o1 = v().o1()) == null) {
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
        v().y().y(true);
        v().y().j(this);
        N();
    }
}
