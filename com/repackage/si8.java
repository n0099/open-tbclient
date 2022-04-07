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
public class si8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(List<hi8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return 0;
            }
            int i = 0;
            for (hi8 hi8Var : list) {
                if (hi8Var.a() >= hi8Var.b()) {
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

    public static /* synthetic */ void b(rr4 rr4Var, hi8 hi8Var) {
        vl4.m(TbadkCoreApplication.getInst(), "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount() + "&icon_name=" + hi8Var.e());
        rr4Var.d();
    }

    public static void e(ii8 ii8Var, String str, ji8 ji8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ii8Var, str, ji8Var) == null) || ii8Var == null || ii8Var.h == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (ii8Var.h.a != null) {
            hi8 hi8Var = new hi8();
            hi8Var.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f062d));
            hi8Var.j(ii8Var.h.a.a);
            hi8Var.i(ii8Var.h.a.b);
            hi8Var.f(gi8.r().q(StampMission.Type.FOLLOW_FORUM));
            hi8Var.g(gi8.r().s(StampMission.Type.FOLLOW_FORUM));
            arrayList.add(hi8Var);
        }
        if (ii8Var.h.b != null) {
            hi8 hi8Var2 = new hi8();
            hi8Var2.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09e1));
            hi8Var2.j(ii8Var.h.b.a);
            hi8Var2.i(ii8Var.h.b.b);
            hi8Var2.f(gi8.r().q(StampMission.Type.LIKE_THREAD));
            hi8Var2.g(gi8.r().s(StampMission.Type.LIKE_THREAD));
            arrayList.add(hi8Var2);
        }
        if (ii8Var.h.c != null) {
            hi8 hi8Var3 = new hi8();
            hi8Var3.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f9d));
            hi8Var3.j(ii8Var.h.c.a);
            hi8Var3.i(ii8Var.h.c.b);
            hi8Var3.f(gi8.r().q(StampMission.Type.REPLAY_THREAD));
            hi8Var3.g(gi8.r().s(StampMission.Type.REPLAY_THREAD));
            arrayList.add(hi8Var3);
        }
        f(arrayList, (ii8Var.b * 1000) - System.currentTimeMillis(), str, ji8Var);
    }

    public static void f(List<hi8> list, long j, String str, ji8 ji8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{list, Long.valueOf(j), str, ji8Var}) == null) || list.isEmpty() || j < 0 || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        if (!UbsABTestHelper.isStampMissionDialogABTestA() || TbadkCoreApplication.getInst().getCurrentActivity().toString().contains("MainTabActivity")) {
            TBAlertConfig.b a = TBAlertConfig.a(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f064c, TBAlertConfig.OperateBtnStyle.FORCE));
            final rr4 rr4Var = new rr4(TbadkCoreApplication.getInst().getCurrentActivity());
            final StampMissionContentView stampMissionContentView = new StampMissionContentView(TbadkCoreApplication.getInst().getCurrentActivity());
            stampMissionContentView.setData(list, j, new SingleStampView.a() { // from class: com.repackage.qi8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.stampmission.view.SingleStampView.a
                public final void a(hi8 hi8Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, hi8Var) == null) {
                        si8.b(rr4.this, hi8Var);
                    }
                }
            });
            rr4Var.v(R.string.obfuscated_res_0x7f0f11c2);
            rr4Var.l(R.string.obfuscated_res_0x7f0f11c3);
            rr4Var.j(stampMissionContentView);
            rr4Var.i(false);
            rr4Var.t(true);
            rr4Var.g();
            rr4Var.q(new DialogInterface.OnDismissListener() { // from class: com.repackage.ri8
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
            rr4Var.h(new View.OnClickListener() { // from class: com.repackage.pi8
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
            rr4Var.s(a);
            rr4Var.y();
            wt4.k().x(str, System.currentTimeMillis());
            if (ji8Var != null) {
                ji8Var.c = a(list);
                ki8.a(ji8Var);
            }
        }
    }
}
