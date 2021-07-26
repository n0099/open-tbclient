package d.a.q0.k3.f;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.clientConfig.ClientConfigModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.tblauncher.alarmRemind.AlarmReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static b f60111g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ClientConfigModel f60112a;

    /* renamed from: b  reason: collision with root package name */
    public d f60113b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60114c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.p0.q.a f60115d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f60116e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f60117f;

    /* loaded from: classes8.dex */
    public class a implements d.a.p0.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60118a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60118a = bVar;
        }

        @Override // d.a.p0.q.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f60118a.f60114c = false;
                if (obj == null || !(obj instanceof DataRes)) {
                    return;
                }
                DataRes dataRes = (DataRes) obj;
                if (dataRes.local_dialog != null) {
                    String g2 = d.a.q0.k3.f.a.g(dataRes);
                    if (TextUtils.isEmpty(g2)) {
                        return;
                    }
                    TbadkSettings.getInst().saveString(this.f60118a.h("remind_recommend_info"), g2);
                    TbadkSettings.getInst().saveInt(this.f60118a.h("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                    TbadkSettings.getInst().saveString(this.f60118a.h("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                    this.f60118a.k(true);
                    TbadkSettings.getInst().saveLong(this.f60118a.h("remind_recommend_data_time"), System.currentTimeMillis());
                }
            }
        }

        @Override // d.a.p0.q.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f60118a.f60114c = false;
            }
        }
    }

    /* renamed from: d.a.q0.k3.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1520b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60119a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1520b(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60119a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.z() && this.f60119a.f()) {
                this.f60119a.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60120a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60120a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.f60120a.f()) {
                this.f60120a.k(true);
                this.f60120a.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60121a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar) {
            super(2001011);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
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
            this.f60121a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage) || (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) == null || data.booleanValue()) {
                return;
            }
            d.a.p0.s.d0.b.j().w("tieba_last_active_time", System.currentTimeMillis());
            if (this.f60121a.f()) {
                this.f60121a.k(true);
                this.f60121a.g();
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60114c = false;
        this.f60115d = new a(this);
        this.f60116e = new C1520b(this, 2000994);
        this.f60117f = new c(this, 2005016);
    }

    public static b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f60111g == null) {
                synchronized (b.class) {
                    if (f60111g == null) {
                        f60111g = new b();
                    }
                }
            }
            return f60111g;
        }
        return (b) invokeV.objValue;
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, baseFragmentActivity) == null) {
            d dVar = new d(this);
            this.f60113b = dVar;
            baseFragmentActivity.registerListener(dVar);
            baseFragmentActivity.registerListener(this.f60116e);
            baseFragmentActivity.registerListener(this.f60117f);
            this.f60112a = new ClientConfigModel(baseFragmentActivity, this.f60115d);
            d.a.p0.s.d0.b.j().w("tieba_last_active_time", System.currentTimeMillis());
            if (f()) {
                k(true);
                g();
            }
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                k(false);
                return false;
            } else if (!d.a.q0.k3.f.a.e()) {
                k(false);
                return false;
            } else if (d.a.q0.k3.f.a.d()) {
                return true;
            } else {
                k(false);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d.a.q0.k3.f.a.f(TbadkSettings.getInst().loadLong(h("remind_recommend_data_time"), 0L)) || TbadkCoreApplication.getInst().checkInterrupt()) {
                return;
            }
            j();
        }
    }

    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + str;
        }
        return (String) invokeL.objValue;
    }

    public final void j() {
        ClientConfigModel clientConfigModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (clientConfigModel = this.f60112a) == null || this.f60114c) {
            return;
        }
        this.f60114c = true;
        clientConfigModel.B("local_dialog");
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
            PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), 134217728);
            try {
                if (z) {
                    alarmManager.setRepeating(0, d.a.q0.k3.f.a.b() + 86400000, 86400000L, broadcast);
                } else {
                    alarmManager.cancel(broadcast);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
