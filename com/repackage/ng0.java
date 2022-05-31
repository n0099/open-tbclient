package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class ng0 implements og0 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements rg0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean[] a;
        public final /* synthetic */ pg0 b;

        public a(ng0 ng0Var, boolean[] zArr, pg0 pg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng0Var, zArr, pg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zArr;
            this.b = pg0Var;
        }

        @Override // com.repackage.rg0
        public void onResult(boolean z) {
            pg0 pg0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a[0] = z;
                if (!z || (pg0Var = this.b) == null) {
                    return;
                }
                pg0Var.a(z, null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755470598, "Lcom/repackage/ng0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755470598, "Lcom/repackage/ng0;");
                return;
            }
        }
        c = new String[]{BaseWebViewActivity.SHOUBAI_SCHEME, "com.baidu.nani", "com.baidu.tieba", "bdminivideo", "xifan", "baidumap", "bdnetdisk", "askmybaby", "baiduboxmission", ThirdPartyUtil.TYPE_WEIXIN, "baiduboxlite", "baiduhaokan", "market", "samsungapps", "duxiaomanloan", "bdbook", "baiduime", "bdwenku", "iqiyi", "bdvideo", "zhidao", "mimarket", "appmarket", "oppomarket", "vivomarket", "youa", "com.tencent.mm", "gamenow", "flowlocal", "yykiwi", "baiduboxvision", "lemon", "duxiaoxiaoapp", "youjia", "bdwkst", "alipays", "bddrama", "comjia", "ctrip", "imeituan", "lianjia", "lianjiabeike", "meituanwaimai", "momochat", "openanjuke", "openapp.jdmobile", "openapp.jdpingou", "openjdlite", "pddopen", "pinduoduo", "qunaraphone", "suning", "tbopen", "vipshop", "vmall", "wbmain", "youku", "miyabaobei", "mogujie", "taobao"};
    }

    public ng0() {
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

    @Override // com.repackage.og0
    public boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable pg0 pg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, str, map, pg0Var)) == null) {
            boolean[] zArr = new boolean[1];
            tg0.a(context, str, null, new a(this, zArr, pg0Var), true);
            return zArr[0];
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.og0
    public void b(String str, String str2, rg0 rg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, rg0Var) == null) || rg0Var == null) {
            return;
        }
        rg0Var.onResult(true);
    }

    @Override // com.repackage.og0
    public String[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String[]) invokeV.objValue;
    }

    @Override // com.repackage.og0
    public boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String str2 : c) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
