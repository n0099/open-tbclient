package d.a.n0.a.u.e.g;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.n0.a.u.c.d;
import d.a.n0.a.v2.q0;
import d.a.n0.a.z1.b.b.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47544a;

        /* renamed from: d.a.n0.a.u.e.g.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0909a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.a.a2.e f47545e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f47546f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f47547g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f47548h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f47549i;

            /* renamed from: d.a.n0.a.u.e.g.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class DialogInterface$OnClickListenerC0910a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0909a f47550e;

                public DialogInterface$OnClickListenerC0910a(RunnableC0909a runnableC0909a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0909a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f47550e = runnableC0909a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", QueryResponse.Options.CANCEL);
                            RunnableC0909a runnableC0909a = this.f47550e;
                            runnableC0909a.f47549i.f47544a.d(runnableC0909a.f47547g, new d.a.n0.a.u.h.b(0, jSONObject));
                        } catch (JSONException e2) {
                            if (d.a.n0.a.u.c.d.f47438c) {
                                e2.printStackTrace();
                            }
                            RunnableC0909a runnableC0909a2 = this.f47550e;
                            runnableC0909a2.f47549i.f47544a.d(runnableC0909a2.f47547g, new d.a.n0.a.u.h.b(201));
                        }
                    }
                }
            }

            /* renamed from: d.a.n0.a.u.e.g.b$a$a$b  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class DialogInterface$OnClickListenerC0911b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0909a f47551e;

                public DialogInterface$OnClickListenerC0911b(RunnableC0909a runnableC0909a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0909a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f47551e = runnableC0909a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0909a runnableC0909a = this.f47551e;
                            runnableC0909a.f47549i.f47544a.d(runnableC0909a.f47547g, new d.a.n0.a.u.h.b(0, jSONObject));
                        } catch (JSONException e2) {
                            if (d.a.n0.a.u.c.d.f47438c) {
                                e2.printStackTrace();
                            }
                            RunnableC0909a runnableC0909a2 = this.f47551e;
                            runnableC0909a2.f47549i.f47544a.d(runnableC0909a2.f47547g, new d.a.n0.a.u.h.b(201));
                        }
                    }
                }
            }

            public RunnableC0909a(a aVar, d.a.n0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, eVar, jSONObject, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47549i = aVar;
                this.f47545e = eVar;
                this.f47546f = jSONObject;
                this.f47547g = str;
                this.f47548h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47545e.x() == null || this.f47545e.x().isFinishing() || this.f47545e.x().isDestroyed()) {
                    return;
                }
                h.a aVar = new h.a(this.f47549i.f47544a.i());
                aVar.V(this.f47546f.optString("title"));
                aVar.x(this.f47546f.optString("content"));
                aVar.n(new d.a.n0.a.w2.h.a());
                aVar.m(false);
                if (this.f47546f.optBoolean("showCancel", true)) {
                    aVar.E(this.f47546f.optString("cancelColor"), d.a.n0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f47546f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.f47549i.f47544a.i().getString(d.a.n0.a.h.aiapps_cancel);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0910a(this));
                }
                aVar.R(this.f47546f.optString("confirmColor"), d.a.n0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f47548h, new DialogInterface$OnClickListenerC0911b(this));
                aVar.X();
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47544a = bVar;
        }

        @Override // d.a.n0.a.u.c.d.b
        public d.a.n0.a.u.h.b a(d.a.n0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.f47544a.i().getString(d.a.n0.a.h.aiapps_confirm);
                }
                q0.b0(new RunnableC0909a(this, eVar, jSONObject, str, optString));
                return new d.a.n0.a.u.h.b(0);
            }
            return (d.a.n0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull d.a.n0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d.a.n0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-Modal", "start show modal");
            }
            return j(str, true, new a(this));
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }
}
