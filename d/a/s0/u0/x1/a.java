package d.a.s0.u0.x1;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.r0.r.y.l;
import d.a.r0.r.y.n;
import d.a.r0.r.y.o;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public l f67200c;

    /* renamed from: d  reason: collision with root package name */
    public String f67201d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(l lVar, String str) {
        super(lVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((l) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67200c = lVar;
        this.f67201d = str;
    }

    @o(isAsync = false, value = "downloadGame")
    private void downloadGame(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("packageName");
        String optString2 = jSONObject.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
        String optString3 = jSONObject.optString("imageUrl");
        if (StringUtils.isNull(optString)) {
            return;
        }
        if (!j.z()) {
            UtilHelper.showToast(b(), R.string.neterror);
            return;
        }
        if (StringUtils.isNull(optString2)) {
            h(optString);
        } else {
            d.a.s0.w2.c0.e.n().E(optString, optString2, optString, 0, d.a.s0.w2.c0.e.o(optString).intValue(), null, true, false, true, optString3, null, null);
        }
        TiebaStatic.log(new StatisticItem("c12775").param("fid", StringUtils.isNull(this.f67201d) ? "" : this.f67201d));
    }

    @Override // d.a.r0.r.y.n
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_DOWNLOAD_GAME" : (String) invokeV.objValue;
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            try {
                if (!(this.f67200c.f() instanceof Activity)) {
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                }
                this.f67200c.f().startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
