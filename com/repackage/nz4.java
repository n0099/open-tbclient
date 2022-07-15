package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.PushPermissionDialogViewV2;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class nz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz4 a;

        public a(mz4 mz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ cr4 c;

        public b(fm4 fm4Var, int i, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm4Var, Integer.valueOf(i), cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm4Var;
            this.b = i;
            this.c = cr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                fm4 fm4Var = this.a;
                if (fm4Var != null) {
                    fm4Var.a();
                }
                nz4.d(this.b, true);
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ cr4 c;

        public c(fm4 fm4Var, int i, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm4Var, Integer.valueOf(i), cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm4Var;
            this.b = i;
            this.c = cr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                fm4 fm4Var = this.a;
                if (fm4Var != null) {
                    fm4Var.b();
                }
                nz4.d(this.b, false);
                this.c.dismiss();
            }
        }
    }

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i == 2 ? "im" : i == 3 ? "reply_message_bar" : i == 4 ? "forum_sign" : i == 5 ? "sign" : "default" : (String) invokeI.objValue;
    }

    public static int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i == 2) {
                return 12;
            }
            if (i == 3) {
                return 11;
            }
            if (i == 4) {
                return 2;
            }
            return i == 5 ? 5 : 0;
        }
        return invokeI.intValue;
    }

    public static void d(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            TiebaStatic.log(new StatisticItem("c13673").param("obj_type", z ? 1 : 2).param("obj_source", c(i)));
        }
    }

    public static void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            TiebaStatic.log(new StatisticItem("c13674").param("obj_source", c(i)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Map<String, String> f(String str) {
        InterceptResult invokeL;
        char c2;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            HashMap hashMap = new HashMap();
            String string2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f44);
            switch (str.hashCode()) {
                case -1130769265:
                    if (str.equals("forum_follow")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -841017829:
                    if (str.equals("forum_sign")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -429621401:
                    if (str.equals("reply_pb")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -426397178:
                    if (str.equals("reply_message_bar")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3364:
                    if (str.equals("im")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f40);
            } else if (c2 == 1) {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f41);
            } else if (c2 == 2 || c2 == 3) {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f43);
            } else if (c2 != 4) {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f3f);
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f42);
            }
            zx4 zx4Var = null;
            yx4 pushStrategyConfig = TbSingleton.getInstance().getPushStrategyConfig();
            if (pushStrategyConfig != null && pushStrategyConfig.d()) {
                zx4Var = pushStrategyConfig.c(str);
            }
            if (zx4Var != null && !TextUtils.isEmpty(zx4Var.c())) {
                string2 = zx4Var.c();
            }
            if (zx4Var != null && !TextUtils.isEmpty(zx4Var.b())) {
                string = zx4Var.b();
            }
            hashMap.put("view_params_key_title", string2);
            hashMap.put("view_params_key_desc", string);
            hashMap.put("view_params_key_source", str);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static boolean g(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, context, i)) == null) {
            yx4 pushStrategyConfig = TbSingleton.getInstance().getPushStrategyConfig();
            boolean z = false;
            int b2 = (pushStrategyConfig == null || !pushStrategyConfig.d()) ? 0 : pushStrategyConfig.b();
            if (b2 <= 0) {
                b2 = 7;
            }
            Date date = new Date(xt4.k().m("push_permission_dialog_scene_cold_start_key", 0L));
            Date date2 = new Date(xt4.k().m("push_permission_dialog_scene_interaction_key", 0L));
            long currentTimeMillis = System.currentTimeMillis();
            Date date3 = new Date(currentTimeMillis);
            if (i == 0 && TimeHelper.getDayDifference(date3, date2) >= b2 && !TimeHelper.isSameDay(date3, date)) {
                z = true;
            }
            if (i == 1 && TimeHelper.getDayDifference(date3, date) >= b2 && !TimeHelper.isSameDay(date3, date2)) {
                z = true;
            }
            if (z) {
                if (i == 0) {
                    xt4.k().x("push_permission_dialog_scene_interaction_key", currentTimeMillis);
                } else if (i == 1) {
                    xt4.k().x("push_permission_dialog_scene_cold_start_key", currentTimeMillis);
                }
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    public static mz4 h(TbPageContext<?> tbPageContext, Map<String, String> map, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{tbPageContext, map, Long.valueOf(j)})) == null) {
            if (tbPageContext == null || map == null) {
                return null;
            }
            mz4 mz4Var = new mz4(tbPageContext, map);
            if (j <= 0) {
                mz4Var.w();
            } else {
                qg.a().postDelayed(new a(mz4Var), j);
            }
            return mz4Var;
        }
        return (mz4) invokeCommon.objValue;
    }

    public static mz4 i(TbPageContext<?> tbPageContext, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{tbPageContext, str, Long.valueOf(j)})) == null) ? j(tbPageContext, str, j, null) : (mz4) invokeCommon.objValue;
    }

    public static mz4 j(TbPageContext<?> tbPageContext, String str, long j, Map<String, String> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{tbPageContext, str, Long.valueOf(j), map})) == null) {
            if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                return null;
            }
            Map<String, String> f = f(str);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    f.put(entry.getKey(), entry.getValue());
                }
            }
            boolean areNotificationsEnabled = NotificationManagerCompat.from(tbPageContext.getPageActivity()).areNotificationsEnabled();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1130769265:
                    if (str.equals("forum_follow")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -841017829:
                    if (str.equals("forum_sign")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -485371922:
                    if (str.equals("homepage")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -429621401:
                    if (str.equals("reply_pb")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -426397178:
                    if (str.equals("reply_message_bar")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3530173:
                    if (str.equals("sign")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 949444906:
                    if (str.equals("collect")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (UbsABTestHelper.isPushOpenPlan3() || areNotificationsEnabled) {
                        return null;
                    }
                    return h(tbPageContext, f, j);
                case 1:
                    if (UbsABTestHelper.isPushOpenPlan1()) {
                        return null;
                    }
                    boolean x = py4.d().x();
                    if (areNotificationsEnabled && x) {
                        return null;
                    }
                    return h(tbPageContext, f, j);
                case 2:
                    return UbsABTestHelper.isPushOpenPlan1() ? null : null;
                case 3:
                    return UbsABTestHelper.isPushOpenPlan1() ? null : null;
                case 4:
                    return h(tbPageContext, f, j);
                case 5:
                    return h(tbPageContext, f, j);
                case 6:
                    if (areNotificationsEnabled) {
                        return null;
                    }
                    return h(tbPageContext, f, j);
                default:
                    throw new IllegalStateException("Unexpected value: " + str);
            }
        }
        return (mz4) invokeCommon.objValue;
    }

    public static void k(TbPageContext<?> tbPageContext, int i, fm4 fm4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65546, null, tbPageContext, i, fm4Var) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        cr4 cr4Var = new cr4(tbPageContext.getPageActivity());
        cr4Var.setCancelable(false);
        cr4Var.setPositiveButton((String) null, (cr4.e) null);
        cr4Var.setNegativeButton((String) null, (cr4.e) null);
        cr4Var.setContentViewSize(7);
        PushPermissionDialogViewV2 pushPermissionDialogViewV2 = new PushPermissionDialogViewV2(tbPageContext.getPageActivity());
        Map<String, String> f = f(b(i));
        pushPermissionDialogViewV2.setTitle(f.get("view_params_key_title"));
        pushPermissionDialogViewV2.setDescription(f.get("view_params_key_desc"));
        cr4Var.setContentView(pushPermissionDialogViewV2);
        if (pushPermissionDialogViewV2.getConfirmButton() != null) {
            pushPermissionDialogViewV2.getConfirmButton().setOnClickListener(new b(fm4Var, i, cr4Var));
        }
        if (pushPermissionDialogViewV2.getCancelButton() != null) {
            pushPermissionDialogViewV2.getCancelButton().setOnClickListener(new c(fm4Var, i, cr4Var));
        }
        cr4Var.create(tbPageContext).show();
        e(i);
    }

    public static void l(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, activity) == null) || activity == null) {
            return;
        }
        View findViewById = activity.findViewById(16908290);
        if (findViewById instanceof ViewGroup) {
            BdTopToast bdTopToast = new BdTopToast(activity, 3000);
            bdTopToast.i(true);
            bdTopToast.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f3b));
            bdTopToast.j((ViewGroup) findViewById);
        }
    }
}
