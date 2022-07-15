package com.repackage;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ko1;
import com.repackage.lz2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cp1 extends ap1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ko1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cp1 a;

        /* renamed from: com.repackage.cp1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0607a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h03 a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ a e;

            /* renamed from: com.repackage.cp1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class DialogInterface$OnClickListenerC0608a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0607a a;

                public DialogInterface$OnClickListenerC0608a(RunnableC0607a runnableC0607a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0607a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0607a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "cancel");
                            RunnableC0607a runnableC0607a = this.a;
                            runnableC0607a.e.a.d(runnableC0607a.c, new hs1(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0607a runnableC0607a2 = this.a;
                            runnableC0607a2.e.a.d(runnableC0607a2.c, new hs1(201));
                        }
                    }
                }
            }

            /* renamed from: com.repackage.cp1$a$a$b */
            /* loaded from: classes5.dex */
            public class b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0607a a;

                public b(RunnableC0607a runnableC0607a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0607a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0607a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0607a runnableC0607a = this.a;
                            runnableC0607a.e.a.d(runnableC0607a.c, new hs1(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0607a runnableC0607a2 = this.a;
                            runnableC0607a2.e.a.d(runnableC0607a2.c, new hs1(201));
                        }
                    }
                }
            }

            public RunnableC0607a(a aVar, h03 h03Var, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, h03Var, jSONObject, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = aVar;
                this.a = h03Var;
                this.b = jSONObject;
                this.c = str;
                this.d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.w() == null || this.a.w().isFinishing() || this.a.w().isDestroyed()) {
                    return;
                }
                lz2.a aVar = new lz2.a(this.e.a.getContext());
                aVar.V(this.b.optString("title"));
                aVar.x(this.b.optString("content"));
                aVar.n(new pf3());
                aVar.m(false);
                if (this.b.optBoolean("showCancel", true)) {
                    aVar.E(this.b.optString("cancelColor"), R.color.obfuscated_res_0x7f0603c9);
                    String optString = this.b.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.e.a.getContext().getString(R.string.obfuscated_res_0x7f0f010d);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0608a(this));
                }
                aVar.R(this.b.optString("confirmColor"), R.color.obfuscated_res_0x7f0603ca);
                aVar.P(this.d, new b(this));
                aVar.X();
            }
        }

        public a(cp1 cp1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cp1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cp1Var;
        }

        @Override // com.repackage.ko1.a
        public hs1 a(h03 h03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, h03Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0115);
                }
                be3.e0(new RunnableC0607a(this, h03Var, jSONObject, str, optString));
                return hs1.f();
            }
            return (hs1) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp1(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public hs1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#showModal", false);
            return l(str, true, new a(this));
        }
        return (hs1) invokeL.objValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ModalApi" : (String) invokeV.objValue;
    }
}
