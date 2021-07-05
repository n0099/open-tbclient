package d.a.q0.a.c2.f.f0;

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
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.k2.g.h;
import d.a.q0.a.u.e.d.b;
import d.a.q0.a.v2.q;
import d.a.q0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g extends a0 implements b.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f46941c;

    /* renamed from: d  reason: collision with root package name */
    public CallbackHandler f46942d;

    /* renamed from: e  reason: collision with root package name */
    public long f46943e;

    /* renamed from: f  reason: collision with root package name */
    public long f46944f;

    /* renamed from: g  reason: collision with root package name */
    public long f46945g;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46946e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f46947f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46948g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f46949h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f46950i;

        /* renamed from: d.a.q0.a.c2.f.f0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0699a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShowFavoriteGuideApi.GuideType f46951e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f46952f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f46953g;

            public RunnableC0699a(a aVar, ShowFavoriteGuideApi.GuideType guideType, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, guideType, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46953g = aVar;
                this.f46951e = guideType;
                this.f46952f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.a.u.e.d.b l = d.a.q0.a.u.e.d.b.l();
                    a aVar = this.f46953g;
                    d.a.q0.a.a2.e eVar = aVar.f46949h;
                    l.p(aVar.f46950i, (Activity) aVar.f46947f, eVar, this.f46951e, this.f46952f, eVar.L().Q(), this.f46953g.f46950i.f46943e);
                }
            }
        }

        public a(g gVar, String str, Context context, JSONObject jSONObject, d.a.q0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, context, jSONObject, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46950i = gVar;
            this.f46946e = str;
            this.f46947f = context;
            this.f46948g = jSONObject;
            this.f46949h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.k2.g.b a2 = h.a();
                ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(this.f46946e);
                String string = this.f46947f.getString(parse.defaultText);
                this.f46950i.f46941c = this.f46948g.optString("cb");
                String str = this.f46949h.f46683f;
                String str2 = "favorite_guide_count_" + str;
                if (d.a.q0.a.j0.b.a.n(str)) {
                    d.a.q0.a.e0.d.g("ShowFavoriteGuideAction", "favorite already");
                    h.a().putString(str2, "-1");
                    return;
                }
                String string2 = h.a().getString(str2, "");
                if (TextUtils.equals("-1", string2)) {
                    d.a.q0.a.e0.d.g("ShowFavoriteGuideAction", "favorite at one time");
                    return;
                }
                String[] split = string2.split("#");
                long j = 0;
                int i2 = 0;
                if (split.length == 2 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1])) {
                    i2 = Integer.parseInt(split[0]);
                    j = Long.parseLong(split[1]);
                }
                long currentTimeMillis = System.currentTimeMillis();
                int i3 = i2;
                this.f46950i.f46943e = a2.getLong("swan_favorite_guide_duration", 3L);
                this.f46950i.f46944f = a2.getLong("swan_favorite_guide_intervalDays", 3L);
                this.f46950i.f46945g = a2.getLong("swan_favorite_guide_maxTimes", 3L);
                d.a.q0.a.e0.d.g("ShowFavoriteGuideAction", "duration=" + this.f46950i.f46943e + ", mIntervalDays=" + this.f46950i.f46944f + ", mMaxTimes=" + this.f46950i.f46945g + " ,storageValue=" + string2);
                if (i3 < this.f46950i.f46945g && currentTimeMillis - j > this.f46950i.f46944f * 86400000) {
                    h.a().putString(str2, (i3 + 1) + "#" + currentTimeMillis);
                    q0.b0(new RunnableC0699a(this, parse, string));
                    return;
                }
                d.a.q0.a.e0.d.g("ShowFavoriteGuideAction", "Not satisfying display conditions");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/showFavoriteGuide");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            d.a.q0.a.e0.d.g("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
            if (!q0.G()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support outside baiduboxapp");
                d.a.q0.a.e0.d.g("ShowFavoriteGuideAction", "not support outside baiduboxapp");
                return false;
            }
            this.f46942d = callbackHandler;
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 != null && eVar != null && (context instanceof Activity)) {
                String optString = a2.optString("type");
                if (d.a.q0.a.u.e.d.b.l().n(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                q.f().execute(new a(this, optString, context, a2, eVar), "ShowFavoriteGuideAction");
                JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                unitedSchemeEntity.result = wrapCallbackParams;
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            d.a.q0.a.e0.d.g("ShowFavoriteGuideAction", "params parse error");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // d.a.q0.a.u.e.d.b.j
    @AnyThread
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f46941c == null || this.f46942d == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f46942d.handleSchemeDispatchCallback(this.f46941c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success").toString());
    }
}
