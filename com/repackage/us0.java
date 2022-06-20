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
/* loaded from: classes7.dex */
public class us0 implements ds0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public us0() {
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

    @Override // com.repackage.ds0
    public void a(wu0 wu0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, wu0Var) == null) || wu0Var == null || TextUtils.isEmpty(wu0Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        if (!TextUtils.isEmpty(wu0Var.f)) {
            clogBuilder.t(wu0Var.f);
        }
        clogBuilder.n(wu0Var.g);
        String c = wu0Var.a.c();
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
            clogBuilder.w(ClogBuilder.LogType.VIDEO_START).i(wu0Var.b).k(wu0Var.d);
            this.b = 0;
            this.a++;
            vx0.c(clogBuilder);
        } else if (c2 == 1) {
            boolean d = wu0Var.a.d(7);
            clogBuilder.j(wu0Var.c).k(wu0Var.d).l(wu0Var.e);
            if (d) {
                clogBuilder.w(ClogBuilder.LogType.VIDEO_PAUSE);
            } else {
                clogBuilder.w(ClogBuilder.LogType.VIDEO_COMPLETED).m("1");
            }
            vx0.c(clogBuilder);
        } else if (c2 == 2) {
            clogBuilder.w(ClogBuilder.LogType.VIDEO_RESUME).i(wu0Var.b).k(wu0Var.d);
            vx0.c(clogBuilder);
        } else if (c2 == 3 || c2 == 4) {
            if (this.a < 1) {
                return;
            }
            try {
                if (this.b > Integer.parseInt(wu0Var.c)) {
                    clogBuilder.j(wu0Var.d);
                } else {
                    clogBuilder.j(wu0Var.c);
                }
            } catch (NumberFormatException unused) {
                clogBuilder.j(wu0Var.c);
            }
            clogBuilder.w(ClogBuilder.LogType.VIDEO_COMPLETED).k(wu0Var.d).l(wu0Var.e).m("0");
            this.a--;
            vx0.c(clogBuilder);
        } else if (c2 != 5) {
        } else {
            int g = wu0Var.a.g(1);
            int g2 = wu0Var.a.g(2);
            if (g == 0 && g2 != 0 && (i = this.b) != 0 && i >= g2 - 2) {
                clogBuilder.w(ClogBuilder.LogType.VIDEO_COMPLETED).j(String.valueOf(g2)).k(String.valueOf(g2)).l(wu0Var.e);
                vx0.c(clogBuilder);
                ClogBuilder n = new ClogBuilder().w(ClogBuilder.LogType.VIDEO_START).i(wu0Var.b).k(wu0Var.d).n(wu0Var.g);
                if (!TextUtils.isEmpty(wu0Var.f)) {
                    n.t(wu0Var.f);
                }
                vx0.c(n);
            }
            this.b = g;
        }
    }

    @Override // com.repackage.ds0
    public void b(wu0 wu0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wu0Var) == null) || wu0Var == null || wu0Var.a == null || TextUtils.isEmpty(wu0Var.g)) {
            return;
        }
        String c = wu0Var.a.c();
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
                xu0.b.b();
                return;
            }
            return;
        }
        cv0 a = xu0.b.a();
        if (a != null) {
            a.c(wu0Var.g);
            a.e(wu0Var.b);
            a.d(wu0Var.h);
            a.b(wu0Var.d);
            xu0.b.c(a);
        }
    }
}
