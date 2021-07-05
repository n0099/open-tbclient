package d.a.q0.a.u.e.g;

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
import d.a.q0.a.u.c.d;
import d.a.q0.a.v2.q0;
import d.a.q0.a.z1.b.b.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends d.a.q0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50846a;

        /* renamed from: d.a.q0.a.u.e.g.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0960a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.a2.e f50847e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f50848f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f50849g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f50850h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f50851i;

            /* renamed from: d.a.q0.a.u.e.g.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class DialogInterface$OnClickListenerC0961a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0960a f50852e;

                public DialogInterface$OnClickListenerC0961a(RunnableC0960a runnableC0960a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0960a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f50852e = runnableC0960a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", QueryResponse.Options.CANCEL);
                            RunnableC0960a runnableC0960a = this.f50852e;
                            runnableC0960a.f50851i.f50846a.d(runnableC0960a.f50849g, new d.a.q0.a.u.h.b(0, jSONObject));
                        } catch (JSONException e2) {
                            if (d.a.q0.a.u.c.d.f50740c) {
                                e2.printStackTrace();
                            }
                            RunnableC0960a runnableC0960a2 = this.f50852e;
                            runnableC0960a2.f50851i.f50846a.d(runnableC0960a2.f50849g, new d.a.q0.a.u.h.b(201));
                        }
                    }
                }
            }

            /* renamed from: d.a.q0.a.u.e.g.b$a$a$b  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class DialogInterface$OnClickListenerC0962b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0960a f50853e;

                public DialogInterface$OnClickListenerC0962b(RunnableC0960a runnableC0960a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0960a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f50853e = runnableC0960a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0960a runnableC0960a = this.f50853e;
                            runnableC0960a.f50851i.f50846a.d(runnableC0960a.f50849g, new d.a.q0.a.u.h.b(0, jSONObject));
                        } catch (JSONException e2) {
                            if (d.a.q0.a.u.c.d.f50740c) {
                                e2.printStackTrace();
                            }
                            RunnableC0960a runnableC0960a2 = this.f50853e;
                            runnableC0960a2.f50851i.f50846a.d(runnableC0960a2.f50849g, new d.a.q0.a.u.h.b(201));
                        }
                    }
                }
            }

            public RunnableC0960a(a aVar, d.a.q0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
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
                this.f50851i = aVar;
                this.f50847e = eVar;
                this.f50848f = jSONObject;
                this.f50849g = str;
                this.f50850h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f50847e.x() == null || this.f50847e.x().isFinishing() || this.f50847e.x().isDestroyed()) {
                    return;
                }
                h.a aVar = new h.a(this.f50851i.f50846a.i());
                aVar.V(this.f50848f.optString("title"));
                aVar.x(this.f50848f.optString("content"));
                aVar.n(new d.a.q0.a.w2.h.a());
                aVar.m(false);
                if (this.f50848f.optBoolean("showCancel", true)) {
                    aVar.E(this.f50848f.optString("cancelColor"), d.a.q0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f50848f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.f50851i.f50846a.i().getString(d.a.q0.a.h.aiapps_cancel);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0961a(this));
                }
                aVar.R(this.f50848f.optString("confirmColor"), d.a.q0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f50850h, new DialogInterface$OnClickListenerC0962b(this));
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
            this.f50846a = bVar;
        }

        @Override // d.a.q0.a.u.c.d.b
        public d.a.q0.a.u.h.b a(d.a.q0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.f50846a.i().getString(d.a.q0.a.h.aiapps_confirm);
                }
                q0.b0(new RunnableC0960a(this, eVar, jSONObject, str, optString));
                return new d.a.q0.a.u.h.b(0);
            }
            return (d.a.q0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull d.a.q0.a.u.c.b bVar) {
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
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d.a.q0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.d("Api-Modal", "start show modal");
            }
            return j(str, true, new a(this));
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }
}
