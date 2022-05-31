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
public class ye8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(List<ne8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return 0;
            }
            int i = 0;
            for (ne8 ne8Var : list) {
                if (ne8Var.a() >= ne8Var.b()) {
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

    public static /* synthetic */ void b(rq4 rq4Var, ne8 ne8Var) {
        sk4.o(TbadkCoreApplication.getInst(), "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount() + "&icon_name=" + ne8Var.e());
        rq4Var.d();
    }

    public static void e(oe8 oe8Var, String str, pe8 pe8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, oe8Var, str, pe8Var) == null) || oe8Var == null || oe8Var.h == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (oe8Var.h.a != null) {
            ne8 ne8Var = new ne8();
            ne8Var.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f063c));
            ne8Var.j(oe8Var.h.a.a);
            ne8Var.i(oe8Var.h.a.b);
            ne8Var.f(me8.r().q(StampMission.Type.FOLLOW_FORUM));
            ne8Var.g(me8.r().s(StampMission.Type.FOLLOW_FORUM));
            arrayList.add(ne8Var);
        }
        if (oe8Var.h.b != null) {
            ne8 ne8Var2 = new ne8();
            ne8Var2.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09ee));
            ne8Var2.j(oe8Var.h.b.a);
            ne8Var2.i(oe8Var.h.b.b);
            ne8Var2.f(me8.r().q(StampMission.Type.LIKE_THREAD));
            ne8Var2.g(me8.r().s(StampMission.Type.LIKE_THREAD));
            arrayList.add(ne8Var2);
        }
        if (oe8Var.h.c != null) {
            ne8 ne8Var3 = new ne8();
            ne8Var3.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fc4));
            ne8Var3.j(oe8Var.h.c.a);
            ne8Var3.i(oe8Var.h.c.b);
            ne8Var3.f(me8.r().q(StampMission.Type.REPLAY_THREAD));
            ne8Var3.g(me8.r().s(StampMission.Type.REPLAY_THREAD));
            arrayList.add(ne8Var3);
        }
        f(arrayList, (oe8Var.b * 1000) - System.currentTimeMillis(), str, pe8Var);
    }

    public static void f(List<ne8> list, long j, String str, pe8 pe8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{list, Long.valueOf(j), str, pe8Var}) == null) || list.isEmpty() || j < 0 || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        if (!UbsABTestHelper.isStampMissionDialogABTestA() || TbadkCoreApplication.getInst().getCurrentActivity().toString().contains("MainTabActivity")) {
            TBAlertConfig.b a = TBAlertConfig.a(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f065b, TBAlertConfig.OperateBtnStyle.FORCE));
            final rq4 rq4Var = new rq4(TbadkCoreApplication.getInst().getCurrentActivity());
            final StampMissionContentView stampMissionContentView = new StampMissionContentView(TbadkCoreApplication.getInst().getCurrentActivity());
            stampMissionContentView.setData(list, j, new SingleStampView.a() { // from class: com.repackage.ve8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.stampmission.view.SingleStampView.a
                public final void a(ne8 ne8Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, ne8Var) == null) {
                        ye8.b(rq4.this, ne8Var);
                    }
                }
            });
            rq4Var.u(R.string.obfuscated_res_0x7f0f11f0);
            rq4Var.l(R.string.obfuscated_res_0x7f0f11f1);
            rq4Var.j(stampMissionContentView);
            rq4Var.i(false);
            rq4Var.t(true);
            rq4Var.g();
            rq4Var.q(new DialogInterface.OnDismissListener() { // from class: com.repackage.xe8
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
            rq4Var.h(new View.OnClickListener() { // from class: com.repackage.we8
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
            rq4Var.s(a);
            rq4Var.x();
            ys4.k().x(str, System.currentTimeMillis());
            if (pe8Var != null) {
                pe8Var.c = a(list);
                qe8.a(pe8Var);
            }
        }
    }
}
