package com.yy.hiidostatis.message.sender;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.message.AppInfo;
import com.yy.hiidostatis.provider.MessageConfig;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Locale;
/* loaded from: classes6.dex */
public class AppInfoManager implements AppInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String appkey;
    public Context context;
    public boolean init;
    public long preFetchTime;
    public String ver;

    public AppInfoManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDir() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                File file = new File(getDir(this.context));
                file.mkdirs();
                File[] listFiles = file.listFiles(getFileFilter());
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                for (File file2 : listFiles) {
                    file2.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDir(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) ? String.format(Locale.CHINA, "%s/hiido", context.getFilesDir().getAbsolutePath()) : (String) invokeL.objValue;
    }

    private FilenameFilter getFileFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? new FilenameFilter(this) { // from class: com.yy.hiidostatis.message.sender.AppInfoManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AppInfoManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file, str)) == null) ? str.endsWith(".appinfo") : invokeLL.booleanValue;
            }
        } : (FilenameFilter) invokeV.objValue;
    }

    private synchronized void load() {
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.preFetchTime == 0 || System.currentTimeMillis() - this.preFetchTime >= 3000) {
                    if (this.preFetchTime > 0) {
                        this.init = true;
                    }
                    this.preFetchTime = System.currentTimeMillis();
                    String[] list = new File(getDir(this.context)).list(getFileFilter());
                    if (list != null && list.length > 0 && (indexOf = list[0].indexOf("_")) > 0) {
                        String substring = list[0].substring(0, indexOf);
                        String substring2 = list[0].substring(indexOf + 1, list[0].length() - 8);
                        this.appkey = substring;
                        this.ver = substring2;
                        this.init = true;
                    }
                }
            }
        }
    }

    private void updateLocalRecord(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, context, str, str2) == null) {
            ThreadPool.getPool().execute(new Runnable(this, context, str, str2) { // from class: com.yy.hiidostatis.message.sender.AppInfoManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AppInfoManager this$0;
                public final /* synthetic */ String val$appkey;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$ver;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                    this.val$appkey = str;
                    this.val$ver = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        File file = new File(String.format(Locale.CHINA, "%s/%s_%s.appinfo", this.this$0.getDir(this.val$context), this.val$appkey, this.val$ver));
                        if (file.exists()) {
                            return;
                        }
                        try {
                            this.this$0.clearDir();
                            file.createNewFile();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.message.AppInfo
    public String getAppAppkey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.init) {
                load();
            }
            return this.appkey;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.message.AppInfo
    public String getAppVer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.init) {
                load();
            }
            return this.ver;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.message.AppInfo
    public synchronized void updateAppInfo(MessageConfig messageConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, messageConfig) == null) {
            synchronized (this) {
                this.init = true;
                if (!messageConfig.getAppkey().equals(this.appkey) || !messageConfig.getVer().equals(this.ver)) {
                    this.appkey = messageConfig.getAppkey();
                    this.ver = messageConfig.getVer();
                    updateLocalRecord(messageConfig.getApplicationContext(), this.appkey, this.ver);
                }
            }
        }
    }
}
