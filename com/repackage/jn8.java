package com.repackage;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.tblauncher.SchemaRouteActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public boolean b;

    /* loaded from: classes6.dex */
    public class a implements BdUniDispatchSchemeController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;

        public a(jn8 jn8Var, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn8Var, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = intent;
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void a(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null || this.a == null) {
                return;
            }
            Object obj = hashMap.get(BdUniDispatchSchemeController.NATIVE_PARAM_MAINTAB_LOCATE);
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
            Object obj2 = hashMap.get(BdUniDispatchSchemeController.NATIVE_PARAM_MAINTAB_SUBTAB);
            String str = obj2 instanceof String ? (String) obj2 : null;
            Object obj3 = hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_NAME);
            String str2 = obj3 instanceof String ? (String) obj3 : null;
            Object obj4 = hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_CODE);
            String str3 = obj4 instanceof String ? (String) obj4 : null;
            if (intValue != -1) {
                this.a.putExtra("is_from_scheme", true);
                this.a.putExtra("locate_type", intValue);
                this.a.putExtra("sub_locate_type", str);
                this.a.putExtra("sub_tab_name", str2);
                this.a.putExtra("sub_tab_code", str3);
                du4.b = intValue;
                Object obj5 = hashMap.get(BdUniDispatchSchemeController.PARAM_NEW_GOD_FROM);
                String str4 = obj5 instanceof String ? (String) obj5 : null;
                Object obj6 = hashMap.get(BdUniDispatchSchemeController.PARAM_FIELD_ID);
                String str5 = obj6 instanceof String ? (String) obj6 : null;
                this.a.putExtra(BdUniDispatchSchemeController.PARAM_NEW_GOD_FROM, str4);
                this.a.putExtra(BdUniDispatchSchemeController.PARAM_FIELD_ID, str5);
            }
            zi4.y().N(true);
            if (intValue == 1 && "ForumSquare".equals(str)) {
                du4.c = du4.e;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921528));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ jn8 b;

        public b(jn8 jn8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jn8Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nb.b().d();
                UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{this.a});
            }
        }
    }

    public jn8(MainTabActivity mainTabActivity, tm8 tm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, tm8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.a = mainTabActivity;
    }

    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        String dataString = intent.getDataString();
        UtilHelper.clearClipBoardBySchemaParam(dataString);
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
            String decode = Uri.decode(intent.getData().getEncodedPath());
            if (StringUtils.isNull(decode)) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_type", 1).param(TiebaStatic.Params.OBJ_TO, 1).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
                sj4.a(param, decode);
                TiebaStatic.log(param);
                return;
            }
            if (decode.startsWith("//")) {
                decode = decode.substring(2);
            }
            Map<String, String> paramPair = UrlManager.getParamPair(decode);
            if (paramPair == null) {
                return;
            }
            if ("bpush".equals(paramPair.get("fr"))) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE);
                sj4.b(statisticItem, paramPair);
                statisticItem.param("obj_locate", paramPair.get("obj_locate"));
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_source", paramPair.get("obj_source"));
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
                statisticItem.param(TiebaStatic.Params.OBJ_TO, 1);
                statisticItem.param("obj_id", paramPair.get(TiebaStatic.Params.BDID));
                statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
                if (!li.isEmpty(paramPair.get("ext_log"))) {
                    try {
                        JSONObject jSONObject = new JSONObject(paramPair.get("ext_log"));
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            statisticItem.param(next, jSONObject.getString(next));
                        }
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                }
                TiebaStatic.log(statisticItem);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", dataString);
                MessageManager.getInstance().sendMessage(httpMessage);
            }
            zi4.y().N(true);
        } else if (!StringUtils.isNull(dataString) && (dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || dataString.startsWith(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK))) {
            String dataString2 = intent.getDataString();
            if (!StringUtils.isNull(dataString2) && PermissionUtil.isAgreePrivacyPolicy()) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{dataString2});
                zi4.y().N(true);
            }
        } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(BdUniDispatchSchemeController.SCHEME)) {
            BdUniDispatchSchemeController.getInstance().parseMainTabScheme(intent.getData(), new a(this, intent));
        }
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
        if (!StringUtils.isNull(stringExtra)) {
            ng.a().postDelayed(new b(this, stringExtra), this.b ? 0L : DeviceInfoUtil.getMainTabActJumpOtherDelayTime());
            this.a.getIntent().removeExtra(MainTabActivityConfig.TARGET_SCHEME);
            this.a.getIntent().putExtra(MainTabActivityConfig.TARGET_SCHEME_BAK, stringExtra);
            GrowthStatsUtil.statisticChannel("push", stringExtra);
        } else if (StringUtils.isNull(SchemaRouteActivity.targetSchemeAction)) {
        } else {
            SchemeActionManager.getInstance().doSchemeAction(this.a.getPageContext(), SchemaRouteActivity.targetSchemeAction);
            SchemaRouteActivity.targetSchemeAction = null;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = true;
        }
    }
}
