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
public class xh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(List<mh8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return 0;
            }
            int i = 0;
            for (mh8 mh8Var : list) {
                if (mh8Var.a() >= mh8Var.b()) {
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

    public static /* synthetic */ void b(bs4 bs4Var, mh8 mh8Var) {
        fm4.m(TbadkCoreApplication.getInst(), "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount() + "&icon_name=" + mh8Var.e());
        bs4Var.d();
    }

    public static void e(nh8 nh8Var, String str, oh8 oh8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, nh8Var, str, oh8Var) == null) || nh8Var == null || nh8Var.h == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (nh8Var.h.a != null) {
            mh8 mh8Var = new mh8();
            mh8Var.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0635));
            mh8Var.j(nh8Var.h.a.a);
            mh8Var.i(nh8Var.h.a.b);
            mh8Var.f(lh8.r().q(StampMission.Type.FOLLOW_FORUM));
            mh8Var.g(lh8.r().s(StampMission.Type.FOLLOW_FORUM));
            arrayList.add(mh8Var);
        }
        if (nh8Var.h.b != null) {
            mh8 mh8Var2 = new mh8();
            mh8Var2.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09e7));
            mh8Var2.j(nh8Var.h.b.a);
            mh8Var2.i(nh8Var.h.b.b);
            mh8Var2.f(lh8.r().q(StampMission.Type.LIKE_THREAD));
            mh8Var2.g(lh8.r().s(StampMission.Type.LIKE_THREAD));
            arrayList.add(mh8Var2);
        }
        if (nh8Var.h.c != null) {
            mh8 mh8Var3 = new mh8();
            mh8Var3.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fb4));
            mh8Var3.j(nh8Var.h.c.a);
            mh8Var3.i(nh8Var.h.c.b);
            mh8Var3.f(lh8.r().q(StampMission.Type.REPLAY_THREAD));
            mh8Var3.g(lh8.r().s(StampMission.Type.REPLAY_THREAD));
            arrayList.add(mh8Var3);
        }
        f(arrayList, (nh8Var.b * 1000) - System.currentTimeMillis(), str, oh8Var);
    }

    public static void f(List<mh8> list, long j, String str, oh8 oh8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{list, Long.valueOf(j), str, oh8Var}) == null) || list.isEmpty() || j < 0 || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        if (!UbsABTestHelper.isStampMissionDialogABTestA() || TbadkCoreApplication.getInst().getCurrentActivity().toString().contains("MainTabActivity")) {
            TBAlertConfig.b a = TBAlertConfig.a(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0654, TBAlertConfig.OperateBtnStyle.FORCE));
            final bs4 bs4Var = new bs4(TbadkCoreApplication.getInst().getCurrentActivity());
            final StampMissionContentView stampMissionContentView = new StampMissionContentView(TbadkCoreApplication.getInst().getCurrentActivity());
            stampMissionContentView.setData(list, j, new SingleStampView.a() { // from class: com.repackage.uh8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.stampmission.view.SingleStampView.a
                public final void a(mh8 mh8Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mh8Var) == null) {
                        xh8.b(bs4.this, mh8Var);
                    }
                }
            });
            bs4Var.v(R.string.obfuscated_res_0x7f0f11de);
            bs4Var.l(R.string.obfuscated_res_0x7f0f11df);
            bs4Var.j(stampMissionContentView);
            bs4Var.i(false);
            bs4Var.t(true);
            bs4Var.g();
            bs4Var.q(new DialogInterface.OnDismissListener() { // from class: com.repackage.wh8
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
            bs4Var.h(new View.OnClickListener() { // from class: com.repackage.vh8
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
            bs4Var.s(a);
            bs4Var.y();
            iu4.k().x(str, System.currentTimeMillis());
            if (oh8Var != null) {
                oh8Var.c = a(list);
                ph8.a(oh8Var);
            }
        }
    }
}
