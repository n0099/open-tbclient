package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.CustomPushPremissionDialogView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ur4;
import java.util.Date;
/* loaded from: classes6.dex */
public class g05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ int[] b;
        public final /* synthetic */ ur4 c;

        public a(TbPageContext tbPageContext, int[] iArr, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, iArr, ur4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = iArr;
            this.c = ur4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g05.e(this.a);
                this.b[0] = 1;
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int[] a;
        public final /* synthetic */ ur4 b;

        public b(int[] iArr, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iArr, ur4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iArr;
            this.b = ur4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a[0] = 2;
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int[] b;

        public c(int i, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = iArr;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                StatisticItem statisticItem = new StatisticItem("c13673");
                statisticItem.param("obj_source", this.a);
                statisticItem.param("obj_type", this.b[0]);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static ur4 a(TbPageContext<?> tbPageContext, int i, int i2, int i3, int i4, ur4.e eVar, ur4.e eVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{tbPageContext, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, eVar2})) == null) {
            return b(tbPageContext, i >= 0 ? TbadkCoreApplication.getInst().getContext().getString(i) : null, TbadkCoreApplication.getInst().getContext().getString(i2), TbadkCoreApplication.getInst().getContext().getString(i3), TbadkCoreApplication.getInst().getContext().getString(i4), eVar, eVar2);
        }
        return (ur4) invokeCommon.objValue;
    }

    public static ur4 b(TbPageContext<?> tbPageContext, String str, String str2, String str3, String str4, ur4.e eVar, ur4.e eVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{tbPageContext, str, str2, str3, str4, eVar, eVar2})) == null) {
            if (tbPageContext == null) {
                return null;
            }
            ur4 ur4Var = new ur4(tbPageContext.getPageActivity());
            ur4Var.setTitle(str);
            ur4Var.setMessage(str2);
            ur4Var.setPositiveButton(str3, eVar);
            ur4Var.setNegativeButton(str4, eVar2);
            ur4Var.create(tbPageContext);
            return ur4Var;
        }
        return (ur4) invokeCommon.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String systemProperty = UtilHelper.getSystemProperty("ro.miui.ui.version.name");
            return !StringUtils.isNull(systemProperty) && og.e(systemProperty.replace("V", ""), 0) < 10;
        }
        return invokeV.booleanValue;
    }

    public static void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, activity) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = activity instanceof BaseActivity ? ((BaseActivity) activity).getPageContext() : null;
            if (activity instanceof BaseFragmentActivity) {
                pageContext = ((BaseFragmentActivity) activity).getPageContext();
            }
            if (pageContext != null) {
                e(pageContext);
            }
        }
    }

    public static void e(d9 d9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, d9Var) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 26 && !c()) {
                    Intent intent = new Intent();
                    intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent.putExtra("android.provider.extra.APP_PACKAGE", d9Var.getPageActivity().getPackageName());
                    intent.putExtra("android.provider.extra.CHANNEL_ID", d9Var.getPageActivity().getApplicationInfo().uid);
                    intent.putExtra("app_package", d9Var.getPageActivity().getPackageName());
                    intent.putExtra("app_uid", d9Var.getPageActivity().getApplicationInfo().uid);
                    d9Var.getPageActivity().startActivity(intent);
                } else {
                    Intent intent2 = new Intent("android.settings.APPLICATION_SETTINGS");
                    intent2.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    intent2.setData(Uri.fromParts("package", d9Var.getPageActivity().getPackageName(), null));
                    d9Var.getPageActivity().startActivity(intent2);
                }
            } catch (Exception unused) {
                Intent intent3 = new Intent();
                intent3.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent3.setData(Uri.fromParts("package", d9Var.getPageActivity().getPackageName(), null));
                d9Var.getPageActivity().startActivity(intent3);
            }
        }
    }

    public static ur4 f(TbPageContext<?> tbPageContext, ur4.e eVar, ur4.e eVar2, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, tbPageContext, eVar, eVar2, str)) == null) {
            if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                return null;
            }
            ur4 create = new ur4(tbPageContext.getPageActivity()).setTitle(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0439)).setMessage(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f14d6), str)).setPositiveButton(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0265), eVar).setNegativeButton(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0370), eVar2).create(tbPageContext);
            create.show();
            return create;
        }
        return (ur4) invokeLLLL.objValue;
    }

    public static boolean g(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, context, i)) == null) {
            boolean z = false;
            if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                return false;
            }
            Date date = new Date(ru4.k().m("push_permission_dialog_scene_cold_start_key", 0L));
            Date date2 = new Date(ru4.k().m("push_permission_dialog_scene_interaction_key", 0L));
            long currentTimeMillis = System.currentTimeMillis();
            Date date3 = new Date(currentTimeMillis);
            if (i == 0 && TimeHelper.getDayDifference(date3, date2) >= 7 && !TimeHelper.isSameDay(date3, date)) {
                z = true;
            }
            if (i == 1 && TimeHelper.getDayDifference(date3, date) >= 7 && !TimeHelper.isSameDay(date3, date2)) {
                z = true;
            }
            if (z) {
                if (i == 0) {
                    ru4.k().x("push_permission_dialog_scene_interaction_key", currentTimeMillis);
                } else if (i == 1) {
                    ru4.k().x("push_permission_dialog_scene_cold_start_key", currentTimeMillis);
                }
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    public static void h(TbPageContext<?> tbPageContext, boolean[] zArr, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65543, null, tbPageContext, zArr, i) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || zArr == null || zArr.length != 2) {
            return;
        }
        i(tbPageContext, i, 0L);
    }

    public static void i(TbPageContext<?> tbPageContext, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{tbPageContext, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ur4 ur4Var = new ur4(tbPageContext.getPageActivity());
            ur4Var.setCancelable(false);
            ur4Var.setPositiveButton((String) null, (ur4.e) null);
            ur4Var.setNegativeButton((String) null, (ur4.e) null);
            ur4Var.setContentViewSize(4);
            CustomPushPremissionDialogView customPushPremissionDialogView = new CustomPushPremissionDialogView(tbPageContext.getPageActivity());
            ur4Var.setContentView(customPushPremissionDialogView);
            int[] iArr = {-1};
            customPushPremissionDialogView.getPushPermissionDialogConfirmButton().setOnClickListener(new a(tbPageContext, iArr, ur4Var));
            customPushPremissionDialogView.getPushPermissionDialogCancelButton().setOnClickListener(new b(iArr, ur4Var));
            ur4Var.setOnDismissListener(new c(i, iArr));
            if (j > 0) {
                ur4Var.create(tbPageContext).show(j);
            } else {
                ur4Var.create(tbPageContext).show();
            }
            StatisticItem statisticItem = new StatisticItem("c13674");
            statisticItem.param("obj_source", i);
            TiebaStatic.log(statisticItem);
        }
    }
}
