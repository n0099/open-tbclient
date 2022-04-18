package com.repackage;

import android.content.DialogInterface;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.stampmission.mission.StampMission;
import com.baidu.tieba.stampmission.view.SingleStampView;
import com.baidu.tieba.stampmission.view.StampMissionContentView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(List<oi8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return 0;
            }
            int i = 0;
            for (oi8 oi8Var : list) {
                if (oi8Var.a() >= oi8Var.b()) {
                    i++;
                }
            }
            if (i == 0) {
                return 1;
            }
            if (i == 1) {
                return 2;
            }
            if (i == 2) {
                return 3;
            }
            return i == list.size() ? 4 : 0;
        }
        return invokeL.intValue;
    }

    public static /* synthetic */ void b(qr4 qr4Var, oi8 oi8Var) {
        ul4.m(TbadkCoreApplication.getInst(), "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount() + "&icon_name=" + oi8Var.e());
        qr4Var.d();
    }

    public static void e(pi8 pi8Var, String str, qi8 qi8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pi8Var, str, qi8Var) == null) || pi8Var == null || pi8Var.h == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (pi8Var.h.a != null) {
            oi8 oi8Var = new oi8();
            oi8Var.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f062d));
            oi8Var.j(pi8Var.h.a.a);
            oi8Var.i(pi8Var.h.a.b);
            oi8Var.f(ni8.r().q(StampMission.Type.FOLLOW_FORUM));
            oi8Var.g(ni8.r().s(StampMission.Type.FOLLOW_FORUM));
            arrayList.add(oi8Var);
        }
        if (pi8Var.h.b != null) {
            oi8 oi8Var2 = new oi8();
            oi8Var2.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09e1));
            oi8Var2.j(pi8Var.h.b.a);
            oi8Var2.i(pi8Var.h.b.b);
            oi8Var2.f(ni8.r().q(StampMission.Type.LIKE_THREAD));
            oi8Var2.g(ni8.r().s(StampMission.Type.LIKE_THREAD));
            arrayList.add(oi8Var2);
        }
        if (pi8Var.h.c != null) {
            oi8 oi8Var3 = new oi8();
            oi8Var3.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f9c));
            oi8Var3.j(pi8Var.h.c.a);
            oi8Var3.i(pi8Var.h.c.b);
            oi8Var3.f(ni8.r().q(StampMission.Type.REPLAY_THREAD));
            oi8Var3.g(ni8.r().s(StampMission.Type.REPLAY_THREAD));
            arrayList.add(oi8Var3);
        }
        f(arrayList, (pi8Var.b * 1000) - System.currentTimeMillis(), str, qi8Var);
    }

    public static void f(List<oi8> list, long j, String str, qi8 qi8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{list, Long.valueOf(j), str, qi8Var}) == null) || list.isEmpty() || j < 0 || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        if (!UbsABTestHelper.isStampMissionDialogABTestA() || TbadkCoreApplication.getInst().getCurrentActivity().toString().contains("MainTabActivity")) {
            TBAlertConfig.b a = TBAlertConfig.a(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f064c, TBAlertConfig.OperateBtnStyle.FORCE));
            final qr4 qr4Var = new qr4(TbadkCoreApplication.getInst().getCurrentActivity());
            final StampMissionContentView stampMissionContentView = new StampMissionContentView(TbadkCoreApplication.getInst().getCurrentActivity());
            stampMissionContentView.setData(list, j, new SingleStampView.a() { // from class: com.repackage.xi8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.stampmission.view.SingleStampView.a
                public final void a(oi8 oi8Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, oi8Var) == null) {
                        zi8.b(qr4.this, oi8Var);
                    }
                }
            });
            qr4Var.v(R.string.obfuscated_res_0x7f0f11c1);
            qr4Var.l(R.string.obfuscated_res_0x7f0f11c2);
            qr4Var.j(stampMissionContentView);
            qr4Var.i(false);
            qr4Var.t(true);
            qr4Var.g();
            qr4Var.q(new DialogInterface.OnDismissListener() { // from class: com.repackage.yi8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        StampMissionContentView.this.a();
                    }
                }
            });
            qr4Var.h(new View.OnClickListener() { // from class: com.repackage.wi8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        StampMissionContentView.this.a();
                    }
                }
            });
            qr4Var.s(a);
            qr4Var.y();
            vt4.k().x(str, System.currentTimeMillis());
            if (qi8Var != null) {
                qi8Var.c = a(list);
                ri8.a(qi8Var);
            }
        }
    }
}
