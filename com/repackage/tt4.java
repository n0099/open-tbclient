package com.repackage;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserTropicGiftBagActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uj4;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes7.dex */
public class tt4 {
    public static /* synthetic */ Interceptable $ic;
    public static tt4 i;
    public static CustomMessageListener j;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public NewUserRedPackageData f;
    public CustomMessageListener g;
    public final hg<fo> h;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tt4 tt4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ShareEvent) && ((ShareEvent) customResponsedMessage.getData()).status == 1) {
                qy4.c(((ShareEvent) customResponsedMessage.getData()).channel);
                this.a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                TbSingleton.getInstance().setCanWebViewActivityShowProgress(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends hg<fo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt4 a;

        public c(tt4 tt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            Activity currentActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, foVar, str, i) == null) || foVar == null || this.a.f == null || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || this.a.d(currentActivity) == null) {
                return;
            }
            TbSingleton.getInstance().setNewUserRedPackageData(this.a.f);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921532));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755279235, "Lcom/repackage/tt4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755279235, "Lcom/repackage/tt4;");
                return;
            }
        }
        j = new b(2921440);
    }

    public tt4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new a(this, 2921406);
        this.h = new c(this);
    }

    public static tt4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (i == null) {
                synchronized (tt4.class) {
                    if (i == null) {
                        i = new tt4();
                    }
                }
            }
            return i;
        }
        return (tt4) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            vt4.k().D("task_share_thread_success_data_total_limit");
            vt4.k().D("task_share_thread_success_data_mission_id");
            vt4.k().D("task_share_thread_success_data_action_id");
            vt4.k().D("task_share_thread_success_data_specific_clear_time");
        }
    }

    public final TbPageContext d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(this.g);
            MessageManager.getInstance().registerListener(j);
        }
    }

    public void g(MissionInfo missionInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, missionInfo) == null) || missionInfo == null || missionInfo.activityid.intValue() == 0 || missionInfo.missionid.intValue() == 0) {
            return;
        }
        this.c = missionInfo.activityid.intValue();
        this.a = missionInfo.missionid.intValue();
        this.b = missionInfo.total_limit.intValue();
        this.e = missionInfo.cleartype.intValue();
        this.d = missionInfo.cleartime.intValue();
        ni4 ni4Var = new ni4();
        ni4Var.X(this.d);
        ni4Var.Y(this.e);
        vt4.k().w("task_share_thread_success_data_total_limit", this.b);
        vt4.k().w("task_share_thread_success_data_mission_id", this.a);
        vt4.k().w("task_share_thread_success_data_action_id", this.c);
        vt4.k().x("task_share_thread_success_data_specific_clear_time", ni4Var.c());
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(5);
            completeTaskReqMsg.completeId = str;
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            completeTaskReqMsg.extra = new uj4.g();
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    public void i() {
        Activity currentActivity;
        TbPageContext d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (d = d(currentActivity)) == null || !x8.f().h("MainTabActivity")) {
            return;
        }
        d.sendMessage(new CustomMessage(2002001, new UserTropicGiftBagActivityConfig(d.getPageActivity())));
    }

    public void j(nj4 nj4Var) {
        Activity currentActivity;
        TbPageContext d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, nj4Var) == null) || nj4Var == null) {
            return;
        }
        ActiveCenterData activeCenterData = nj4Var.g;
        if (activeCenterData == null || !activeCenterData.is_new_window) {
            if ((vt4.k().l("app_restart_times", 0) <= 1 && UbsABTestHelper.isRedPackageShowSecondTime()) || !nj4Var.b || StringUtils.isNull(nj4Var.c) || TbSingleton.getInstance().isNewUserRedPackageShowed() || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (d = d(currentActivity)) == null) {
                return;
            }
            this.f = nj4Var.f;
            ig.h().k(this.f.topPicUrl, 10, this.h, 0, 0, d.getUniqueId(), new Object[0]);
        }
    }

    public void k() {
        int l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && TbadkCoreApplication.isLogin()) {
            int l2 = vt4.k().l("task_share_thread_success_data_mission_id", 0);
            int l3 = vt4.k().l("task_share_thread_success_data_action_id", 0);
            long m = vt4.k().m("task_share_thread_success_data_specific_clear_time", 0L);
            ni4 ni4Var = new ni4();
            ni4Var.d0(m);
            if (ni4Var.M()) {
                c();
            } else if (l3 == 0 || l2 == 0 || (l = vt4.k().l("task_share_thread_success_data_total_limit", 0)) <= 0) {
            } else {
                vt4.k().w("task_share_thread_success_data_total_limit", l - 1);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(String.valueOf(l3), String.valueOf(l2));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                h(jSONObject.toString());
            }
        }
    }
}
