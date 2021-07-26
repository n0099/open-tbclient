package d.a.o0.a.u.e.g;

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
import d.a.o0.a.u.c.d;
import d.a.o0.a.v2.q0;
import d.a.o0.a.z1.b.b.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f48048a;

        /* renamed from: d.a.o0.a.u.e.g.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0918a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.a2.e f48049e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f48050f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f48051g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f48052h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f48053i;

            /* renamed from: d.a.o0.a.u.e.g.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class DialogInterface$OnClickListenerC0919a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0918a f48054e;

                public DialogInterface$OnClickListenerC0919a(RunnableC0918a runnableC0918a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0918a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f48054e = runnableC0918a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", QueryResponse.Options.CANCEL);
                            RunnableC0918a runnableC0918a = this.f48054e;
                            runnableC0918a.f48053i.f48048a.d(runnableC0918a.f48051g, new d.a.o0.a.u.h.b(0, jSONObject));
                        } catch (JSONException e2) {
                            if (d.a.o0.a.u.c.d.f47942c) {
                                e2.printStackTrace();
                            }
                            RunnableC0918a runnableC0918a2 = this.f48054e;
                            runnableC0918a2.f48053i.f48048a.d(runnableC0918a2.f48051g, new d.a.o0.a.u.h.b(201));
                        }
                    }
                }
            }

            /* renamed from: d.a.o0.a.u.e.g.b$a$a$b  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class DialogInterface$OnClickListenerC0920b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0918a f48055e;

                public DialogInterface$OnClickListenerC0920b(RunnableC0918a runnableC0918a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0918a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f48055e = runnableC0918a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0918a runnableC0918a = this.f48055e;
                            runnableC0918a.f48053i.f48048a.d(runnableC0918a.f48051g, new d.a.o0.a.u.h.b(0, jSONObject));
                        } catch (JSONException e2) {
                            if (d.a.o0.a.u.c.d.f47942c) {
                                e2.printStackTrace();
                            }
                            RunnableC0918a runnableC0918a2 = this.f48055e;
                            runnableC0918a2.f48053i.f48048a.d(runnableC0918a2.f48051g, new d.a.o0.a.u.h.b(201));
                        }
                    }
                }
            }

            public RunnableC0918a(a aVar, d.a.o0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
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
                this.f48053i = aVar;
                this.f48049e = eVar;
                this.f48050f = jSONObject;
                this.f48051g = str;
                this.f48052h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48049e.x() == null || this.f48049e.x().isFinishing() || this.f48049e.x().isDestroyed()) {
                    return;
                }
                h.a aVar = new h.a(this.f48053i.f48048a.i());
                aVar.V(this.f48050f.optString("title"));
                aVar.x(this.f48050f.optString("content"));
                aVar.n(new d.a.o0.a.w2.h.a());
                aVar.m(false);
                if (this.f48050f.optBoolean("showCancel", true)) {
                    aVar.E(this.f48050f.optString("cancelColor"), d.a.o0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f48050f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.f48053i.f48048a.i().getString(d.a.o0.a.h.aiapps_cancel);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0919a(this));
                }
                aVar.R(this.f48050f.optString("confirmColor"), d.a.o0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f48052h, new DialogInterface$OnClickListenerC0920b(this));
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
            this.f48048a = bVar;
        }

        @Override // d.a.o0.a.u.c.d.b
        public d.a.o0.a.u.h.b a(d.a.o0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.f48048a.i().getString(d.a.o0.a.h.aiapps_confirm);
                }
                q0.b0(new RunnableC0918a(this, eVar, jSONObject, str, optString));
                return new d.a.o0.a.u.h.b(0);
            }
            return (d.a.o0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull d.a.o0.a.u.c.b bVar) {
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
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d.a.o0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-Modal", "start show modal");
            }
            return j(str, true, new a(this));
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
