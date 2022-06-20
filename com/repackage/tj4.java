package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.buoy.BuoyComponent;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.ui.components.buoy.TaskBuoyView;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tj4 {
    public static /* synthetic */ Interceptable $ic;
    public static int b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* loaded from: classes7.dex */
    public class a implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(tj4 tj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dp
        public void a(TaskInfo taskInfo, TaskStatus taskStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, taskInfo, taskStatus) == null) {
                BdLog.d(taskInfo.getActionId() + " taskStatus onChanged :" + taskStatus);
                if (taskStatus.isRegistered()) {
                    BdLog.d("isRegistered=============>");
                }
                if (taskStatus.isUnRegistered()) {
                    BdLog.d("isUnRegistered=============>");
                }
                if (taskStatus.isRunning()) {
                    BdLog.d("isRunning=============>");
                }
                if (taskStatus.isFinished()) {
                    BdLog.d("isFinished=============>");
                }
            }
        }

        @Override // com.repackage.dp
        public void b(TaskInfo taskInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo, i, str) == null) {
                BdLog.d("[debug]error:" + str + " " + i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends tu {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(tj4 tj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.tu, com.repackage.uu
        public void a(View view2, TaskInfo taskInfo, TaskBuoyViewData taskBuoyViewData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, view2, taskInfo, taskBuoyViewData) == null) {
                super.a(view2, taskInfo, taskBuoyViewData);
                taskBuoyViewData.getTaskStatus().isFinished();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final tj4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(16874004, "Lcom/repackage/tj4$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(16874004, "Lcom/repackage/tj4$c;");
                    return;
                }
            }
            a = new tj4(null);
        }
    }

    public /* synthetic */ tj4(a aVar) {
        this();
    }

    public static tj4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a : (tj4) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || b(str) == null) {
            return;
        }
        BDPTask.m.h(str);
    }

    public TaskInfo b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (BDPTask.m.m(str) == null) {
                return null;
            }
            return BDPTask.m.m(str).getTaskInfo();
        }
        return (TaskInfo) invokeL.objValue;
    }

    public final void c(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri) == null) {
            String queryParameter = uri.getQueryParameter(BdUniDispatchSchemeController.PARAM_EXPAND_DATA);
            if (TextUtils.isEmpty(queryParameter)) {
                return;
            }
            String queryParameter2 = uri.getQueryParameter(BdUniDispatchSchemeController.PARAM_TASK_ACTION_ID);
            if (!TextUtils.isEmpty(queryParameter2)) {
                l(queryParameter2, queryParameter);
            }
            d(uri, queryParameter);
        }
    }

    public final void d(Uri uri, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, uri, str) == null) {
            vh4 vh4Var = new vh4(str);
            int i = StringHelper.equals(uri.getQueryParameter(BdUniDispatchSchemeController.PARAM_SCHEME_FROM), BdUniDispatchSchemeController.SCHEME_FROM_TB_TOKEN) ? 2 : 1;
            String queryParameter = uri.getQueryParameter(BdUniDispatchSchemeController.PARAM_KW);
            String queryParameter2 = uri.getQueryParameter(BdUniDispatchSchemeController.PARAM_TID);
            String queryParameter3 = uri.getQueryParameter(BdUniDispatchSchemeController.PARAM_QUERY);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_NEW_SCHEME_PULL_UP).param("obj_source", vh4Var.e()).param("obj_type", vh4Var.d()).param("obj_param1", vh4Var.q()).param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.OBJ_PARAM3, vh4Var.s()).param("extra", vh4Var.v()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fname", queryParameter).param("tid", queryParameter2).param("query", queryParameter3).param("pid", uri.getQueryParameter("hightlight_anchor_pid")).param(TiebaStatic.Params.REFER, uri.getQueryParameter(TiebaStatic.Params.REFER)).param("obj_locate", TbadkCoreApplication.getInst().getStartType()).param("obj_name", 1));
        }
    }

    public String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            ht4 k = ht4.k();
            String q = k.q("key_sdk_task_expand_data_" + str, "");
            if (TextUtils.isEmpty(q)) {
                return null;
            }
            try {
                return new JSONObject(q).optString(str2);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            rj4.e(context);
            this.a = BdUniqueId.gen();
            sj4.a().b(this.a);
            c = UtilHelper.getDimenPixelSize(R.dimen.tbds340);
            b = UtilHelper.getDimenPixelSize(R.dimen.M_W_X011);
        }
    }

    public void h(BuoyComponent buoyComponent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, buoyComponent) == null) && buoyComponent != null && (buoyComponent instanceof mp)) {
            ((mp) buoyComponent).F();
        }
    }

    public void i(Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, uri) == null) || uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter(BdUniDispatchSchemeController.PARAM_TASK_INFO);
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        j(queryParameter);
        c(uri);
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            BDPTask.m.A(str, new a(this));
        }
    }

    public void k(BuoyComponent buoyComponent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, buoyComponent) == null) && buoyComponent != null && (buoyComponent instanceof mp)) {
            ((mp) buoyComponent).H();
        }
    }

    public void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            ht4 k = ht4.k();
            k.y("key_sdk_task_expand_data_" + str, str2);
        }
    }

    public BuoyComponent m(Activity activity, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLL;
        TaskInfo b2;
        BuoyComponent buoyComponent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, activity, viewGroup, str)) == null) {
            if (activity == null || (b2 = b(str)) == null) {
                return null;
            }
            TaskBuoyView taskBuoyView = new TaskBuoyView(activity);
            taskBuoyView.U(new b(this));
            if (b2.isClickAction()) {
                buoyComponent = fp.b(taskBuoyView, new TaskBuoyViewModel(b2), b2);
            } else {
                buoyComponent = fp.a(taskBuoyView, new np(b2), b2);
            }
            if (viewGroup != null) {
                buoyComponent.l(viewGroup, null);
            } else {
                int statusBarHeight = UtilHelper.getStatusBarHeight();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 5;
                layoutParams.topMargin = c + statusBarHeight;
                layoutParams.rightMargin = b;
                buoyComponent.l((FrameLayout) activity.findViewById(16908290), layoutParams);
            }
            if (buoyComponent instanceof mp) {
                ((mp) buoyComponent).J();
            }
            return buoyComponent;
        }
        return (BuoyComponent) invokeLLL.objValue;
    }

    public void n(BuoyComponent buoyComponent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, buoyComponent) == null) || buoyComponent == null) {
            return;
        }
        buoyComponent.n();
    }

    public tj4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
