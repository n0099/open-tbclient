package d.a.f0.b.g;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.sdk.container.interfaces.LoadState;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d implements d.a.i0.a.g.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.g.b f42766a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f42767b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.f0.b.d f42768c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f42769d;

    /* renamed from: e  reason: collision with root package name */
    public int f42770e;

    /* renamed from: f  reason: collision with root package name */
    public int f42771f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.f0.b.c f42772g;

    /* loaded from: classes7.dex */
    public class a implements d.a.f0.b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42773a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42773a = dVar;
        }

        @Override // d.a.f0.b.c
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (d.a.f0.a.b.a.f42713a.get().s()) {
                    Log.i("PrologueAd", "onAdFailed: " + th.getMessage());
                }
                if (this.f42773a.f42769d != null) {
                    this.f42773a.f42769d.onFailed();
                } else if (this.f42773a.f42768c != null) {
                    this.f42773a.f42768c.a(th == null ? "unKnow" : th.getMessage());
                }
            }
        }

        @Override // d.a.f0.b.c
        public void b(@NonNull h hVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) || d.a.a.f().h()) {
                return;
            }
            int e2 = f.e(hVar);
            if (d.a.f0.a.b.a.f42713a.get().s()) {
                Log.i("PrologueAd", "onAdSuccess, statusCode: " + e2);
            }
            if (e2 == 0) {
                d.a.i0.a.b a2 = e.a(hVar);
                d.a.i0.a.g.b a3 = new d.a.i0.a.a().a(this.f42773a.f42767b, a2);
                if (a3 != null) {
                    this.f42773a.f42766a = a3;
                    if (this.f42773a.f42768c != null) {
                        d.a.f0.b.e eVar = new d.a.f0.b.e(a3, this.f42773a.f42768c.d(), hVar);
                        eVar.d(this.f42773a.f42768c);
                        a3.d(eVar);
                        a3.b(eVar);
                        eVar.c(this.f42773a);
                        this.f42773a.h(!hVar.g());
                        this.f42773a.j(!hVar.f());
                        this.f42773a.f42768c.c(this.f42773a);
                    }
                    if (this.f42773a.f42769d != null) {
                        this.f42773a.f42769d.onSuccess();
                        return;
                    }
                    return;
                } else if (d.a.f0.a.b.a.f42713a.get().s()) {
                    Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    return;
                } else {
                    return;
                }
            }
            if (d.a.f0.a.b.a.f42713a.get().s()) {
                Log.e("PrologueAd", "query 后物料效验失败");
            }
            if (this.f42773a.f42769d != null) {
                this.f42773a.f42769d.onFailed();
            } else if (this.f42773a.f42768c != null) {
                d.a.f0.b.d dVar = this.f42773a.f42768c;
                dVar.a("query 后物料效验失败: " + e2);
            }
            b.f(e2);
        }
    }

    public d(Context context, String str, RequestParameters requestParameters, d.a.f0.b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, requestParameters, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LoadState loadState = LoadState.INIT;
        this.f42772g = new a(this);
        this.f42767b = context;
        this.f42768c = dVar;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f42766a == null) {
            return;
        }
        this.f42766a = null;
    }

    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("place_id", d.a.f0.a.b.a.f42713a.get().l());
                jSONObject.put("source", "gd");
                jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f42770e);
                jSONObject.put("full_type", this.f42771f);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new d.a.f0.b.a().j(d.a.f0.a.b.a.f42713a.get(), this.f42772g);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f42770e = i2;
        }
    }

    public void i(d.a.i0.a.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f42766a = bVar;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f42771f = i2;
        }
    }

    public void k(ViewGroup viewGroup) {
        d.a.i0.a.g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewGroup) == null) {
            if (viewGroup != null && (bVar = this.f42766a) != null) {
                bVar.a();
                View adView = this.f42766a.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                } else {
                    e();
                    return;
                }
            }
            e();
        }
    }
}
