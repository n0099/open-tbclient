package com.repackage;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ch8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final zg8 a;
    @NonNull
    public final ah8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ch8(@NonNull zg8 zg8Var, @NonNull ah8 ah8Var) {
        super(2016311);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zg8Var, ah8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zg8Var;
        this.b = ah8Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                    Intent intent = new Intent();
                    int indexOf = str.indexOf("&extInfo=");
                    String substring = indexOf > 0 ? str.substring(0, indexOf) : str;
                    String substring2 = str.substring(substring.length() + 9, str.length());
                    if (substring.startsWith("https://") || substring.startsWith("http://")) {
                        intent.putExtra("gd_ad", true);
                        intent.putExtra("ext_info", substring2);
                    }
                    if (!this.a.i() && ((StringUtils.isNull(substring) || !substring.startsWith("bdtiebalive")) && this.a.h() != 2)) {
                        intent.putExtra(DealIntentService.KEY_CLASS, 30);
                        intent.putExtra(BigdayActivityConfig.JUMP_URL, substring);
                        intent.putExtra("is_ad", true);
                        TbadkCoreApplication.setIntent(intent);
                    } else {
                        intent.putExtra(DealIntentService.KEY_CLASS, 30);
                        intent.putExtra(BigdayActivityConfig.JUMP_URL, substring);
                        intent.putExtra("is_ad", true);
                        UtilHelper.commenDealIntent(this.a.getActivity(), intent);
                    }
                }
                this.a.f();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getActivity().getClass().getSimpleName()).param("obj_param1", 5).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(this.a.e())));
                if (!this.a.e() && !DeviceInfoUtil.isHuaWeiP40Pro()) {
                    SpeedStatsManager.getInstance().setStatsFlag(false);
                    if (this.a.i()) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("ignore_speed").param("obj_source", "click"));
                    return;
                }
                this.b.a();
            }
        }
    }
}
