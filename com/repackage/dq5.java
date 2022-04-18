package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dq5 {
    public static /* synthetic */ Interceptable $ic;
    public static dq5 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final dq5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-434698005, "Lcom/repackage/dq5$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-434698005, "Lcom/repackage/dq5$b;");
                    return;
                }
            }
            a = new dq5(null);
        }
    }

    public /* synthetic */ dq5(a aVar) {
        this();
    }

    public static dq5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                a = b.a;
            }
            return a;
        }
        return (dq5) invokeV.objValue;
    }

    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i == 1 ? SkinManager.SKIN_TYPE_STR_NIGHT : i == 4 ? "dark" : Config.TRACE_VISIT_RECENT_DAY : (String) invokeI.objValue;
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            if (!LiveFeedPageSdk.f().l()) {
                u90.a().d(R.raw.lottie_common_pull_refresh, R.raw.obfuscated_res_0x7f11002c, R.raw.obfuscated_res_0x7f11002d, R.raw.obfuscated_res_0x7f11002c, 15, 15, 30, 30);
                u90.a().b("live_feed_page_load_more.json", "live_feed_page_load_more.json", "live_feed_page_load_more.json", "live_feed_page_load_more.json");
                u90.a().c(R.raw.lottie_full_screen_refresh, R.raw.obfuscated_res_0x7f110039, R.raw.obfuscated_res_0x7f11003a, R.raw.obfuscated_res_0x7f110039, "", 67.0f, 67.0f);
                fa0.a().b(R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, 125.0f, 125.0f);
                fa0.a().c(R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, 125.0f, 125.0f);
                fa0.a().d(R.drawable.new_pic_emotion_08, R.drawable.new_pic_emotion_08, R.drawable.new_pic_emotion_08, R.drawable.new_pic_emotion_08, 125.0f, 125.0f);
                fa0.a().e(R.drawable.obfuscated_res_0x7f080d1a, R.drawable.obfuscated_res_0x7f080d1b, R.drawable.obfuscated_res_0x7f080d19, R.drawable.obfuscated_res_0x7f080d1a);
                LiveFeedPageSdk.f().k(new oh7());
                LiveFeedPageSdk.f().i("tieba", b(TbadkCoreApplication.getInst().getSkinType()));
                LiveFeedPageSdk.f().j(new eq5());
                LiveFeedPageSdk.f().p();
            }
            LiveFeedPageSdk.f().o(context);
            if (LiveFeedPageSdk.f().g() == null || TextUtils.isEmpty(LiveFeedPageSdk.f().g().c())) {
                return;
            }
            LiveFeedPageSdk.f().r(LiveFeedPageSdk.f().g().c());
        }
    }

    public dq5() {
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
