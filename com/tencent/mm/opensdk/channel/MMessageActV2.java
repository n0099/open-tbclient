package com.tencent.mm.opensdk.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
/* loaded from: classes8.dex */
public class MMessageActV2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
    public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
    public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    public static final String TAG = "MicroMsg.SDK.MMessageAct";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class Args {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int INVALID_FLAGS = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public Bundle bundle;
        public String content;
        public int flags;
        public String targetClassName;
        public String targetPkgName;
        public String token;

        public Args() {
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
            this.flags = -1;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
            }
            return (String) invokeV.objValue;
        }
    }

    public MMessageActV2() {
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

    public static boolean send(Context context, Args args) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, args)) == null) {
            if (context == null || args == null) {
                str = "send fail, invalid argument";
            } else if (d.b(args.targetPkgName)) {
                str = "send fail, invalid targetPkgName, targetPkgName = " + args.targetPkgName;
            } else {
                if (d.b(args.targetClassName)) {
                    args.targetClassName = args.targetPkgName + DEFAULT_ENTRY_CLASS_NAME;
                }
                Log.d(TAG, "send, targetPkgName = " + args.targetPkgName + ", targetClassName = " + args.targetClassName);
                Intent intent = new Intent();
                intent.setClassName(args.targetPkgName, args.targetClassName);
                Bundle bundle = args.bundle;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, args.content);
                intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(args.content, Build.SDK_INT, packageName));
                intent.putExtra(ConstantsAPI.TOKEN, args.token);
                int i = args.flags;
                if (i == -1) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS).addFlags(134217728);
                } else {
                    intent.setFlags(i);
                }
                try {
                    context.startActivity(intent);
                    Log.d(TAG, "send mm message, intent=".concat(String.valueOf(intent)));
                    return true;
                } catch (Exception e) {
                    str = "send fail, ex = " + e.getMessage();
                }
            }
            Log.e(TAG, str);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
