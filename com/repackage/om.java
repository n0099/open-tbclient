package com.repackage;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettingIOService;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class om {
    public static /* synthetic */ Interceptable $ic;
    public static volatile om g;
    public transient /* synthetic */ FieldHolder $fh;
    public PluginSettings a;
    public Messenger b;
    public Messenger c;
    public ServiceConnection d;
    public qm e;
    public ArrayList<Message> f;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(om omVar) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {omVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = omVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Serializable serializable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                try {
                    switch (message.what) {
                        case 5:
                            Bundle data = message.getData();
                            if (data != null && (serializable = data.getSerializable("plugin_settings")) != null && (serializable instanceof PluginSettings)) {
                                this.a.a = (PluginSettings) data.getSerializable("plugin_settings");
                            }
                            if (this.a.e != null) {
                                this.a.e.a(this.a.a);
                                this.a.e = null;
                                return;
                            }
                            return;
                        case 6:
                            Bundle data2 = message.getData();
                            if (data2 != null) {
                                boolean z = data2.getBoolean(PluginSettingIOService.KEY_FORBIDDEN);
                                String string = data2.getString(PluginSettingIOService.KEY_SETTING_NAME);
                                PluginSetting findPluginSetting = this.a.a.findPluginSetting(string);
                                if (findPluginSetting != null && findPluginSetting.forbidden != z) {
                                    findPluginSetting.forbidden = z;
                                }
                                if (z) {
                                    return;
                                }
                                PluginCenter.getInstance().launch(string);
                                return;
                            }
                            return;
                        case 7:
                            Bundle data3 = message.getData();
                            if (data3 != null) {
                                this.a.a.removePluginSetting(data3.getString(PluginSettingIOService.KEY_SETTING_NAME));
                                return;
                            }
                            return;
                        case 8:
                            Bundle data4 = message.getData();
                            if (data4 != null) {
                                this.a.a.setAllPluginEnable(data4.getBoolean(PluginSettingIOService.KEY_ENABLE));
                                return;
                            }
                            return;
                        case 9:
                            Bundle data5 = message.getData();
                            if (data5 != null) {
                                boolean z2 = data5.getBoolean(PluginSettingIOService.KEY_ENABLE);
                                PluginSetting findPluginSetting2 = this.a.a.findPluginSetting(data5.getString(PluginSettingIOService.KEY_SETTING_NAME));
                                if (findPluginSetting2 != null && findPluginSetting2.enable != z2) {
                                    findPluginSetting2.enable = z2;
                                }
                                boolean z3 = false;
                                if (findPluginSetting2 != null && findPluginSetting2.isPatch && TextUtils.isEmpty(findPluginSetting2.replaceMethodClasses)) {
                                    z3 = true;
                                }
                                if (findPluginSetting2 == null || !findPluginSetting2.enable || TextUtils.isEmpty(findPluginSetting2.requireLoad) || !findPluginSetting2.requireLoad.equals("0") || z3) {
                                    return;
                                }
                                PluginCenter.getInstance().launch(findPluginSetting2.packageName);
                                return;
                            }
                            return;
                        case 10:
                            Bundle data6 = message.getData();
                            if (data6 != null) {
                                String string2 = data6.getString("key_version");
                                if ((!TextUtils.isEmpty(string2) || TextUtils.isEmpty(this.a.a.getContainerVersion())) && ((TextUtils.isEmpty(string2) || !TextUtils.isEmpty(this.a.a.getContainerVersion())) && (TextUtils.isEmpty(string2) || TextUtils.isEmpty(this.a.a.getContainerVersion()) || string2.equals(this.a.a.getContainerVersion())))) {
                                    return;
                                }
                                this.a.a.setContainerSetting(string2);
                                return;
                            }
                            return;
                        case 11:
                            Bundle data7 = message.getData();
                            if (data7 != null) {
                                int i = data7.getInt(PluginSettingIOService.KEY_INSTALL_STATUS);
                                PluginSetting findPluginSetting3 = this.a.a.findPluginSetting(data7.getString(PluginSettingIOService.KEY_SETTING_NAME));
                                if (findPluginSetting3 == null || findPluginSetting3.installStatus == i) {
                                    return;
                                }
                                findPluginSetting3.installStatus = i;
                                return;
                            }
                            return;
                        case 12:
                            Bundle data8 = message.getData();
                            if (data8 != null) {
                                this.a.a.setForbiddenFeatures(data8.getString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om a;

        public b(om omVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {omVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = omVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.a.b = new Messenger(iBinder);
                this.a.n();
                if (this.a.f.size() > 0) {
                    Iterator it = this.a.f.iterator();
                    while (it.hasNext()) {
                        try {
                            this.a.b.send((Message) it.next());
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                    this.a.f.clear();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.a.b = null;
                this.a.f.clear();
            }
        }
    }

    public om() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new PluginSettings();
        this.c = new Messenger(new a(this));
        this.d = new b(this);
        this.f = new ArrayList<>();
    }

    public static om h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (g == null) {
                synchronized (om.class) {
                    if (g == null) {
                        g = new om();
                    }
                }
            }
            return g;
        }
        return (om) invokeV.objValue;
    }

    public PluginSetting g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.findPluginSetting(str) : (PluginSetting) invokeL.objValue;
    }

    public PluginSettings i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (PluginSettings) invokeV.objValue;
    }

    public boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            PluginSetting g2 = g(str);
            if (g2 == null) {
                return true;
            }
            return g2.forbidden;
        }
        return invokeL.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        List<ActivityManager.RunningServiceInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                list = ((ActivityManager) BdBaseApplication.getInst().getSystemService("activity")).getRunningServices(100);
            } catch (Exception unused) {
                ug statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("loc", om.class.getName() + "-isPluginIOServiceStart-getRunningServices");
                BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
                list = null;
            }
            if (list != null) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : list) {
                    if (runningServiceInfo != null && runningServiceInfo.service != null && PluginSettingIOService.class.getName().equals(runningServiceInfo.service.getClassName())) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && this.a.removePluginSetting(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            m(7, bundle);
        }
    }

    public final void m(int i, Bundle bundle) {
        Message obtain;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048581, this, i, bundle) == null) || (obtain = Message.obtain((Handler) null, i)) == null) {
            return;
        }
        obtain.setData(bundle);
        try {
            if (this.b != null && k()) {
                this.b.send(obtain);
            }
            this.f.add(obtain);
            qg.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.d, 1);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void n() {
        Message obtain;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (obtain = Message.obtain(null, 1, null)) == null) {
            return;
        }
        try {
            obtain.replyTo = this.c;
            this.b.send(obtain);
        } catch (RemoteException unused) {
        } catch (Throwable unused2) {
            ug statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("loc", om.class.getName() + "-sendMsgConnect");
            BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
        }
    }

    public void o(String str, String str2, boolean z) {
        PluginSetting g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048583, this, str, str2, z) == null) || (g2 = g(str)) == null) {
            return;
        }
        g2.setAbandon_apk_path(str2);
        if (z) {
            nm.b().e(this.a.m27clone(), null);
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(this.a.getContainerVersion()) || !this.a.getContainerVersion().equals(str)) {
                this.a.setContainerSetting(str);
                Bundle bundle = new Bundle();
                bundle.putString("key_version", str);
                m(10, bundle);
            }
        }
    }

    public void q(String str, boolean z) {
        PluginSetting g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) || (g2 = g(str)) == null || g2.enable == z) {
            return;
        }
        g2.enable = z;
        Bundle bundle = new Bundle();
        bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
        bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
        m(9, bundle);
    }

    public void r(String str, PluginSetting pluginSetting, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048586, this, str, pluginSetting, z) == null) && this.a.insertOrUpdatePluginSetting(str, pluginSetting) && z) {
            nm.b().e(this.a.m27clone(), null);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || this.a.findPluginSetting(str) == null) {
            return;
        }
        l(str);
        p("");
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || this.a.findPluginSetting(str) == null) {
            return;
        }
        l(str);
        p("");
    }
}
