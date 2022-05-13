package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishGuideActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.switchs.PublishVideoThreadSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yr4;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class hy8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ForumWriteData c;

        public a(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, str, forumWriteData};
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
            this.b = str;
            this.c = forumWriteData;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hy8.i(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements yr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ Boolean f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ wr4 j;

        public b(String str, String str2, String str3, String str4, int i, Boolean bool, String str5, String str6, String str7, wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, Integer.valueOf(i), bool, str5, str6, str7, wr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = i;
            this.f = bool;
            this.g = str5;
            this.h = str6;
            this.i = str7;
            this.j = wr4Var;
        }

        @Override // com.repackage.yr4.e
        public void onItemClick(yr4 yr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                if (i == 0) {
                    hy8.k(true, true, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
                } else if (i == 1) {
                    hy8.k(true, false, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
                }
                wr4 wr4Var = this.j;
                if (wr4Var != null) {
                    wr4Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements yr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4 a;

        public c(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr4Var;
        }

        @Override // com.repackage.yr4.c
        public void onClick() {
            wr4 wr4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (wr4Var = this.a) == null) {
                return;
            }
            wr4Var.dismiss();
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? iu4.k().l("key_work_video_guide_pop", -1) : invokeV.intValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? !TextUtils.isEmpty(cj8.z()) : invokeV.booleanValue;
    }

    public static boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 1 || i == 2 : invokeI.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? SwitchManager.getInstance().findType(PublishVideoThreadSwitch.PUBLISH_VIDEO_THREAD_KEY) != 1 : invokeV.booleanValue;
    }

    public static boolean e(Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i, i2)) == null) {
            WorkPublishGuideActivityConfig workPublishGuideActivityConfig = new WorkPublishGuideActivityConfig(context);
            workPublishGuideActivityConfig.setRequestCode(25064);
            workPublishGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            if (c(i)) {
                workPublishGuideActivityConfig.setPopStatus(i);
                workPublishGuideActivityConfig.setFrom(i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishGuideActivityConfig));
                return true;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public static void f(b9 b9Var, String str, String str2, String str3, String str4, int i, Boolean bool, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{b9Var, str, str2, str3, str4, Integer.valueOf(i), bool, str5, str6, str7}) == null) || b9Var == null || b9Var.getPageActivity() == null) {
            return;
        }
        String string = b9Var.getString(R.string.obfuscated_res_0x7f0f159f);
        wr4 wr4Var = new wr4(b9Var);
        yr4 yr4Var = new yr4(b9Var.getPageActivity());
        yr4Var.q(string);
        ArrayList arrayList = new ArrayList();
        ur4 ur4Var = new ur4(0, b9Var.getString(R.string.obfuscated_res_0x7f0f159e), yr4Var);
        ur4Var.q(R.color.CAM_X0105);
        ur4Var.o(R.color.CAM_X0204);
        arrayList.add(ur4Var);
        ur4 ur4Var2 = new ur4(1, b9Var.getString(R.string.obfuscated_res_0x7f0f159d), yr4Var);
        ur4Var2.q(R.color.CAM_X0105);
        ur4Var2.o(R.color.CAM_X0204);
        arrayList.add(ur4Var2);
        b bVar = new b(str, str2, str3, str4, i, bool, str5, str6, str7, wr4Var);
        c cVar = new c(wr4Var);
        yr4Var.j(arrayList);
        yr4Var.n(bVar);
        yr4Var.m(cVar);
        wr4Var.setCanceledOnTouchOutside(true);
        wr4Var.i(yr4Var);
        wr4Var.m();
    }

    public static void g(String str, String str2, String str3, String str4, int i, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), bool}) == null) {
            h(str, str2, str3, str4, i, bool, "", "", "");
        }
    }

    public static void h(String str, String str2, String str3, String str4, int i, Boolean bool, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), bool, str5, str6, str7}) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                f(((TbPageContextSupport) currentActivity).getPageContext(), str, str2, str3, str4, i, bool, str5, str6, str7);
            }
        }
    }

    public static void i(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, tbPageContext, str, forumWriteData) == null) || forumWriteData == null || tbPageContext == null || !d()) {
            return;
        }
        RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), 1, forumWriteData, null, str, 0);
        recordVideoActivityConfig.setShowType(0);
        if (forumWriteData != null) {
            recordVideoActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921615, recordVideoActivityConfig));
    }

    public static void j(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, str, forumWriteData) == null) || forumWriteData == null || tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.CAMERA");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.RECORD_AUDIO");
        permissionJudgePolicy.setOnPermissionsGrantedListener(new a(tbPageContext, str, forumWriteData));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public static void k(boolean z, boolean z2, String str, String str2, String str3, String str4, int i, Boolean bool, String str5, String str6, String str7) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4, Integer.valueOf(i), bool, str5, str6, str7}) == null) {
            if (!z) {
                i2 = 0;
            } else if (z2) {
                i2 = 2;
            } else {
                cj8.v("");
                i2 = 1;
            }
            WorkPublishOpenHelper.Companion.c(i2, TbadkCoreApplication.getInst().getCurrentActivity(), str, str2, str3, str4, Integer.valueOf(i), bool.booleanValue(), str5, str6, str7);
        }
    }

    public static void l(EditText editText, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, editText, i) == null) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(editText, Integer.valueOf(i));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
