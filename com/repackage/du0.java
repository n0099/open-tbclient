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
/* loaded from: classes5.dex */
public class du0 implements mt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public du0() {
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

    @Override // com.repackage.mt0
    public void a(fw0 fw0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fw0Var) == null) || fw0Var == null || TextUtils.isEmpty(fw0Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        if (!TextUtils.isEmpty(fw0Var.f)) {
            clogBuilder.t(fw0Var.f);
        }
        clogBuilder.n(fw0Var.g);
        String c = fw0Var.a.c();
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
            clogBuilder.w(ClogBuilder.LogType.VIDEO_START).i(fw0Var.b).k(fw0Var.d);
            this.b = 0;
            this.a++;
            ez0.c(clogBuilder);
        } else if (c2 == 1) {
            boolean d = fw0Var.a.d(7);
            clogBuilder.j(fw0Var.c).k(fw0Var.d).l(fw0Var.e);
            if (d) {
                clogBuilder.w(ClogBuilder.LogType.VIDEO_PAUSE);
            } else {
                clogBuilder.w(ClogBuilder.LogType.VIDEO_COMPLETED).m("1");
            }
            ez0.c(clogBuilder);
        } else if (c2 == 2) {
            clogBuilder.w(ClogBuilder.LogType.VIDEO_RESUME).i(fw0Var.b).k(fw0Var.d);
            ez0.c(clogBuilder);
        } else if (c2 == 3 || c2 == 4) {
            if (this.a < 1) {
                return;
            }
            try {
                if (this.b > Integer.parseInt(fw0Var.c)) {
                    clogBuilder.j(fw0Var.d);
                } else {
                    clogBuilder.j(fw0Var.c);
                }
            } catch (NumberFormatException unused) {
                clogBuilder.j(fw0Var.c);
            }
            clogBuilder.w(ClogBuilder.LogType.VIDEO_COMPLETED).k(fw0Var.d).l(fw0Var.e).m("0");
            this.a--;
            ez0.c(clogBuilder);
        } else if (c2 != 5) {
        } else {
            int g = fw0Var.a.g(1);
            int g2 = fw0Var.a.g(2);
            if (g == 0 && g2 != 0 && (i = this.b) != 0 && i >= g2 - 2) {
                clogBuilder.w(ClogBuilder.LogType.VIDEO_COMPLETED).j(String.valueOf(g2)).k(String.valueOf(g2)).l(fw0Var.e);
                ez0.c(clogBuilder);
                ClogBuilder n = new ClogBuilder().w(ClogBuilder.LogType.VIDEO_START).i(fw0Var.b).k(fw0Var.d).n(fw0Var.g);
                if (!TextUtils.isEmpty(fw0Var.f)) {
                    n.t(fw0Var.f);
                }
                ez0.c(n);
            }
            this.b = g;
        }
    }

    @Override // com.repackage.mt0
    public void b(fw0 fw0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fw0Var) == null) || fw0Var == null || fw0Var.a == null || TextUtils.isEmpty(fw0Var.g)) {
            return;
        }
        String c = fw0Var.a.c();
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
                gw0.b.b();
                return;
            }
            return;
        }
        lw0 a = gw0.b.a();
        if (a != null) {
            a.c(fw0Var.g);
            a.e(fw0Var.b);
            a.d(fw0Var.h);
            a.b(fw0Var.d);
            gw0.b.c(a);
        }
    }
}
