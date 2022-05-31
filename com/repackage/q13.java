package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.un1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q13 extends e13 implements un1.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public CallbackHandler d;
    public long e;
    public long f;
    public long g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ hz2 d;
        public final /* synthetic */ q13 e;

        /* renamed from: com.repackage.q13$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0499a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ShowFavoriteGuideApi.GuideType a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public RunnableC0499a(a aVar, ShowFavoriteGuideApi.GuideType guideType, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, guideType, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = guideType;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    un1 l = un1.l();
                    a aVar = this.c;
                    hz2 hz2Var = aVar.d;
                    l.p(aVar.e, (Activity) aVar.b, hz2Var, this.a, this.b, hz2Var.V().Q(), this.c.e.e);
                }
            }
        }

        public a(q13 q13Var, String str, Context context, JSONObject jSONObject, hz2 hz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q13Var, str, context, jSONObject, hz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = q13Var;
            this.a = str;
            this.b = context;
            this.c = jSONObject;
            this.d = hz2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p73 a = v73.a();
                ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(this.a);
                String string = this.b.getString(parse.defaultText);
                this.e.c = this.c.optString("cb");
                String str = this.d.b;
                String str2 = "favorite_guide_count_" + str;
                if (f62.n(str)) {
                    hw1.i("ShowFavoriteGuideAction", "favorite already");
                    v73.a().putString(str2, "-1");
                    return;
                }
                String string2 = v73.a().getString(str2, "");
                if (TextUtils.equals("-1", string2)) {
                    hw1.i("ShowFavoriteGuideAction", "favorite at one time");
                    return;
                }
                String[] split = string2.split("#");
                long j = 0;
                int i = 0;
                if (split.length == 2 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1])) {
                    i = Integer.parseInt(split[0]);
                    j = Long.parseLong(split[1]);
                }
                long currentTimeMillis = System.currentTimeMillis();
                int i2 = i;
                this.e.e = a.getLong("swan_favorite_guide_duration", 3L);
                this.e.f = a.getLong("swan_favorite_guide_intervalDays", 3L);
                this.e.g = a.getLong("swan_favorite_guide_maxTimes", 3L);
                hw1.i("ShowFavoriteGuideAction", "duration=" + this.e.e + ", mIntervalDays=" + this.e.f + ", mMaxTimes=" + this.e.g + " ,storageValue=" + string2);
                if (i2 < this.e.g && currentTimeMillis - j > this.e.f * 86400000) {
                    v73.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                    bd3.e0(new RunnableC0499a(this, parse, string));
                    return;
                }
                hw1.i("ShowFavoriteGuideAction", "Not satisfying display conditions");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q13(e03 e03Var) {
        super(e03Var, "/swanAPI/showFavoriteGuide");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            hw1.i("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
            if (!bd3.G()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support outside baiduboxapp");
                hw1.i("ShowFavoriteGuideAction", "not support outside baiduboxapp");
                return false;
            }
            this.d = callbackHandler;
            JSONObject a2 = e13.a(unitedSchemeEntity, "params");
            if (a2 != null && hz2Var != null && (context instanceof Activity)) {
                String optString = a2.optString("type");
                if (un1.l().n(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                bc3.g().execute(new a(this, optString, context, a2, hz2Var), "ShowFavoriteGuideAction");
                JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                unitedSchemeEntity.result = wrapCallbackParams;
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            hw1.i("ShowFavoriteGuideAction", "params parse error");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.un1.j
    @AnyThread
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.c == null || this.d == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.d.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success").toString());
    }
}
