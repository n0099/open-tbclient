package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes6.dex */
public class qs0 implements zr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public qs0() {
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
        this.a = 0;
        this.b = 0;
    }

    @Override // com.repackage.zr0
    public void a(su0 su0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, su0Var) == null) || su0Var == null || TextUtils.isEmpty(su0Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        if (!TextUtils.isEmpty(su0Var.f)) {
            clogBuilder.t(su0Var.f);
        }
        clogBuilder.n(su0Var.g);
        String c = su0Var.a.c();
        char c2 = 65535;
        switch (c.hashCode()) {
            case -1530009462:
                if (c.equals(ControlEvent.ACTION_SYNC_PROGRESS)) {
                    c2 = 5;
                    break;
                }
                break;
            case 154871702:
                if (c.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                    c2 = 4;
                    break;
                }
                break;
            case 720027695:
                if (c.equals(ControlEvent.ACTION_PAUSE)) {
                    c2 = 1;
                    break;
                }
                break;
            case 723345051:
                if (c.equals(ControlEvent.ACTION_START)) {
                    c2 = 0;
                    break;
                }
                break;
            case 906917140:
                if (c.equals(ControlEvent.ACTION_RESUME)) {
                    c2 = 2;
                    break;
                }
                break;
            case 2145795460:
                if (c.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            clogBuilder.w(ClogBuilder.LogType.VIDEO_START).i(su0Var.b).k(su0Var.d);
            this.b = 0;
            this.a++;
            rx0.c(clogBuilder);
        } else if (c2 == 1) {
            boolean d = su0Var.a.d(7);
            clogBuilder.j(su0Var.c).k(su0Var.d).l(su0Var.e);
            if (d) {
                clogBuilder.w(ClogBuilder.LogType.VIDEO_PAUSE);
            } else {
                clogBuilder.w(ClogBuilder.LogType.VIDEO_COMPLETED).m("1");
            }
            rx0.c(clogBuilder);
        } else if (c2 == 2) {
            clogBuilder.w(ClogBuilder.LogType.VIDEO_RESUME).i(su0Var.b).k(su0Var.d);
            rx0.c(clogBuilder);
        } else if (c2 == 3 || c2 == 4) {
            if (this.a < 1) {
                return;
            }
            try {
                if (this.b > Integer.parseInt(su0Var.c)) {
                    clogBuilder.j(su0Var.d);
                } else {
                    clogBuilder.j(su0Var.c);
                }
            } catch (NumberFormatException unused) {
                clogBuilder.j(su0Var.c);
            }
            clogBuilder.w(ClogBuilder.LogType.VIDEO_COMPLETED).k(su0Var.d).l(su0Var.e).m("0");
            this.a--;
            rx0.c(clogBuilder);
        } else if (c2 != 5) {
        } else {
            int g = su0Var.a.g(1);
            int g2 = su0Var.a.g(2);
            if (g == 0 && g2 != 0 && (i = this.b) != 0 && i >= g2 - 2) {
                clogBuilder.w(ClogBuilder.LogType.VIDEO_COMPLETED).j(String.valueOf(g2)).k(String.valueOf(g2)).l(su0Var.e);
                rx0.c(clogBuilder);
                ClogBuilder n = new ClogBuilder().w(ClogBuilder.LogType.VIDEO_START).i(su0Var.b).k(su0Var.d).n(su0Var.g);
                if (!TextUtils.isEmpty(su0Var.f)) {
                    n.t(su0Var.f);
                }
                rx0.c(n);
            }
            this.b = g;
        }
    }

    @Override // com.repackage.zr0
    public void b(su0 su0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, su0Var) == null) || su0Var == null || su0Var.a == null || TextUtils.isEmpty(su0Var.g)) {
            return;
        }
        String c = su0Var.a.c();
        char c2 = 65535;
        int hashCode = c.hashCode();
        if (hashCode != 154871702) {
            if (hashCode != 1370689931) {
                if (hashCode == 2145795460 && c.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                    c2 = 1;
                }
            } else if (c.equals(PlayerEvent.ACTION_ON_INFO)) {
                c2 = 0;
            }
        } else if (c.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
            c2 = 2;
        }
        if (c2 != 0) {
            if (c2 == 1 || c2 == 2) {
                tu0.b.b();
                return;
            }
            return;
        }
        yu0 a = tu0.b.a();
        if (a != null) {
            a.c(su0Var.g);
            a.e(su0Var.b);
            a.d(su0Var.h);
            a.b(su0Var.d);
            tu0.b.c(a);
        }
    }
}
