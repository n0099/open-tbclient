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
import com.repackage.sj4;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes7.dex */
public class wt4 {
    public static /* synthetic */ Interceptable $ic;
    public static wt4 i;
    public static CustomMessageListener j;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public NewUserRedPackageData f;
    public CustomMessageListener g;
    public final ig<ym> h;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wt4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(wt4 wt4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wt4Var, Integer.valueOf(i)};
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
            this.a = wt4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ShareEvent) && ((ShareEvent) customResponsedMessage.getData()).status == 1) {
                jz4.d(((ShareEvent) customResponsedMessage.getData()).channel);
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
    public class c extends ig<ym> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wt4 a;

        public c(wt4 wt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wt4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ig
        public void onLoaded(ym ymVar, String str, int i) {
            Activity currentActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, ymVar, str, i) == null) || ymVar == null || this.a.f == null || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || this.a.d(currentActivity) == null) {
                return;
            }
            TbSingleton.getInstance().setNewUserRedPackageData(this.a.f);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921532));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755189862, "Lcom/repackage/wt4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755189862, "Lcom/repackage/wt4;");
                return;
            }
        }
        j = new b(2921440);
    }

    public wt4() {
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

    public static wt4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (i == null) {
                synchronized (wt4.class) {
                    if (i == null) {
                        i = new wt4();
                    }
                }
            }
            return i;
        }
        return (wt4) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            yt4.k().D("task_share_thread_success_data_total_limit");
            yt4.k().D("task_share_thread_success_data_mission_id");
            yt4.k().D("task_share_thread_success_data_action_id");
            yt4.k().D("task_share_thread_success_data_specific_clear_time");
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
        li4 li4Var = new li4();
        li4Var.Y(this.d);
        li4Var.Z(this.e);
        yt4.k().w("task_share_thread_success_data_total_limit", this.b);
        yt4.k().w("task_share_thread_success_data_mission_id", this.a);
        yt4.k().w("task_share_thread_success_data_action_id", this.c);
        yt4.k().x("task_share_thread_success_data_specific_clear_time", li4Var.c());
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(5);
            completeTaskReqMsg.completeId = str;
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            completeTaskReqMsg.extra = new sj4.g();
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    public void i() {
        Activity currentActivity;
        TbPageContext d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (d = d(currentActivity)) == null || !z8.g().i("MainTabActivity")) {
            return;
        }
        d.sendMessage(new CustomMessage(2002001, new UserTropicGiftBagActivityConfig(d.getPageActivity())));
    }

    public void j(lj4 lj4Var) {
        Activity currentActivity;
        TbPageContext d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, lj4Var) == null) || lj4Var == null) {
            return;
        }
        ActiveCenterData activeCenterData = lj4Var.g;
        if ((activeCenterData != null && activeCenterData.is_new_window) || yt4.k().l("app_restart_times", 0) <= 1 || !lj4Var.b || StringUtils.isNull(lj4Var.c) || TbSingleton.getInstance().isNewUserRedPackageShowed() || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (d = d(currentActivity)) == null) {
            return;
        }
        this.f = lj4Var.f;
        jg.h().k(this.f.topPicUrl, 10, this.h, 0, 0, d.getUniqueId(), new Object[0]);
    }

    public void k() {
        int l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && TbadkCoreApplication.isLogin()) {
            int l2 = yt4.k().l("task_share_thread_success_data_mission_id", 0);
            int l3 = yt4.k().l("task_share_thread_success_data_action_id", 0);
            long m = yt4.k().m("task_share_thread_success_data_specific_clear_time", 0L);
            li4 li4Var = new li4();
            li4Var.e0(m);
            if (li4Var.N()) {
                c();
            } else if (l3 == 0 || l2 == 0 || (l = yt4.k().l("task_share_thread_success_data_total_limit", 0)) <= 0) {
            } else {
                yt4.k().w("task_share_thread_success_data_total_limit", l - 1);
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
