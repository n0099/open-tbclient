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
public class ht0 implements qs0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public ht0() {
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

    @Override // com.repackage.qs0
    public void a(jv0 jv0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jv0Var) == null) || jv0Var == null || TextUtils.isEmpty(jv0Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        if (!TextUtils.isEmpty(jv0Var.f)) {
            clogBuilder.v(jv0Var.f);
        }
        clogBuilder.p(jv0Var.g);
        String c = jv0Var.a.c();
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
            clogBuilder.y(ClogBuilder.LogType.VIDEO_START).k(jv0Var.b).m(jv0Var.d);
            this.b = 0;
            this.a++;
            iy0.b(clogBuilder);
        } else if (c2 == 1) {
            boolean d = jv0Var.a.d(7);
            clogBuilder.l(jv0Var.c).m(jv0Var.d).n(jv0Var.e);
            if (d) {
                clogBuilder.y(ClogBuilder.LogType.VIDEO_PAUSE);
            } else {
                clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).o("1");
            }
            iy0.b(clogBuilder);
        } else if (c2 == 2) {
            clogBuilder.y(ClogBuilder.LogType.VIDEO_RESUME).k(jv0Var.b).m(jv0Var.d);
            iy0.b(clogBuilder);
        } else if (c2 == 3 || c2 == 4) {
            if (this.a < 1) {
                return;
            }
            try {
                if (this.b > Integer.parseInt(jv0Var.c)) {
                    clogBuilder.l(jv0Var.d);
                } else {
                    clogBuilder.l(jv0Var.c);
                }
            } catch (NumberFormatException unused) {
                clogBuilder.l(jv0Var.c);
            }
            clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).m(jv0Var.d).n(jv0Var.e).o("0");
            this.a--;
            iy0.b(clogBuilder);
        } else if (c2 != 5) {
        } else {
            int g = jv0Var.a.g(1);
            int g2 = jv0Var.a.g(2);
            if (g == 0 && g2 != 0 && (i = this.b) != 0 && i >= g2 - 2) {
                clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).l(String.valueOf(g2)).m(String.valueOf(g2)).n(jv0Var.e);
                iy0.b(clogBuilder);
                ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.VIDEO_START).k(jv0Var.b).m(jv0Var.d).p(jv0Var.g);
                if (!TextUtils.isEmpty(jv0Var.f)) {
                    p.v(jv0Var.f);
                }
                iy0.b(p);
            }
            this.b = g;
        }
    }

    @Override // com.repackage.qs0
    public void b(jv0 jv0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jv0Var) == null) || jv0Var == null || jv0Var.a == null || TextUtils.isEmpty(jv0Var.g)) {
            return;
        }
        String c = jv0Var.a.c();
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
                kv0.b.b();
                return;
            }
            return;
        }
        pv0 a = kv0.b.a();
        if (a != null) {
            a.c(jv0Var.g);
            a.e(jv0Var.b);
            a.d(jv0Var.h);
            a.b(jv0Var.d);
            kv0.b.c(a);
        }
    }
}
