package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.Packer;
/* loaded from: classes8.dex */
public class InstallController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IStatisAPI statisAPI;

    /* loaded from: classes8.dex */
    public static class InstUtil {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String INVALID_VERSIONNAME = "";
        public static final int INVALID_VERSIONNO = -1;
        public static final Object KEY;
        public static final String PREF_KEY_VERSION_NAME = "PREF_KEY_VERSION_NAME";
        public static final String PREF_KEY_VERSION_NO = "PREF_KEY_VERSION_NO";
        public static final int TYPE_INSTALL = 1;
        public static final int TYPE_UPDATE = 0;
        public static InstInfo instInfo;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes8.dex */
        public static class InstInfo {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean isReport;
            public int type;

            public InstInfo() {
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

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2118005985, "Lcom/yy/hiidostatis/defs/controller/InstallController$InstUtil;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2118005985, "Lcom/yy/hiidostatis/defs/controller/InstallController$InstUtil;");
                    return;
                }
            }
            KEY = InstUtil.class;
        }

        public InstUtil() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static InstInfo getInstInfo(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
                InstInfo instInfo2 = instInfo;
                if (instInfo2 != null) {
                    return instInfo2;
                }
                synchronized (KEY) {
                    if (instInfo != null) {
                        return instInfo;
                    }
                    InstInfo init = init(context);
                    instInfo = init;
                    return init;
                }
            }
            return (InstInfo) invokeL.objValue;
        }

        public static InstInfo init(Context context) {
            InterceptResult invokeL;
            boolean z;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
                InstInfo instInfo2 = new InstInfo();
                try {
                    int prefInt = DefaultPreference.getPreference().getPrefInt(context, PREF_KEY_VERSION_NO, -1);
                    String prefString = DefaultPreference.getPreference().getPrefString(context, PREF_KEY_VERSION_NAME, "");
                    int versionNo = ArdUtil.getVersionNo(context);
                    String versionName = ArdUtil.getVersionName(context);
                    if (prefInt != -1 && !prefString.equals("") && prefInt == versionNo && prefString.equals(versionName)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    instInfo2.isReport = z;
                    if (prefInt == -1 && prefString.equals("")) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    instInfo2.type = i;
                } catch (Throwable th) {
                    L.debug("InstallController", "init exception = %s", th);
                }
                return instInfo2;
            }
            return (InstInfo) invokeL.objValue;
        }

        public static void save(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
                getInstInfo(context).isReport = true;
                int versionNo = ArdUtil.getVersionNo(context);
                String versionName = ArdUtil.getVersionName(context);
                DefaultPreference.getPreference().setPrefInt(context, PREF_KEY_VERSION_NO, versionNo);
                DefaultPreference.getPreference().setPrefString(context, PREF_KEY_VERSION_NAME, versionName);
            }
        }
    }

    public InstallController(IStatisAPI iStatisAPI) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iStatisAPI};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.statisAPI = iStatisAPI;
    }

    public void sendInstallationReportIfNotYet(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            InstUtil.InstInfo instInfo = InstUtil.getInstInfo(context);
            if (!instInfo.isReport) {
                this.statisAPI.reportInstall(instInfo.type, new Packer.OnSavedListener(this, context) { // from class: com.yy.hiidostatis.defs.controller.InstallController.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ InstallController this$0;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                    }

                    @Override // com.yy.hiidostatis.message.Packer.OnSavedListener
                    public void onSaved(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            L.debug("InstallController", "report Install %b", Boolean.valueOf(z));
                            if (z) {
                                InstUtil.save(this.val$context);
                            }
                        }
                    }
                });
            }
        }
    }
}
