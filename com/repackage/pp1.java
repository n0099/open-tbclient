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
import com.repackage.xo1;
import com.repackage.yz2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class pp1 extends np1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements xo1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pp1 a;

        /* renamed from: com.repackage.pp1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0492a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ u03 a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ a e;

            /* renamed from: com.repackage.pp1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class DialogInterface$OnClickListenerC0493a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0492a a;

                public DialogInterface$OnClickListenerC0493a(RunnableC0492a runnableC0492a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0492a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0492a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "cancel");
                            RunnableC0492a runnableC0492a = this.a;
                            runnableC0492a.e.a.d(runnableC0492a.c, new us1(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0492a runnableC0492a2 = this.a;
                            runnableC0492a2.e.a.d(runnableC0492a2.c, new us1(201));
                        }
                    }
                }
            }

            /* renamed from: com.repackage.pp1$a$a$b */
            /* loaded from: classes6.dex */
            public class b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0492a a;

                public b(RunnableC0492a runnableC0492a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0492a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0492a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0492a runnableC0492a = this.a;
                            runnableC0492a.e.a.d(runnableC0492a.c, new us1(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0492a runnableC0492a2 = this.a;
                            runnableC0492a2.e.a.d(runnableC0492a2.c, new us1(201));
                        }
                    }
                }
            }

            public RunnableC0492a(a aVar, u03 u03Var, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, u03Var, jSONObject, str, str2};
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
                this.a = u03Var;
                this.b = jSONObject;
                this.c = str;
                this.d = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.x() == null || this.a.x().isFinishing() || this.a.x().isDestroyed()) {
                    return;
                }
                yz2.a aVar = new yz2.a(this.e.a.getContext());
                aVar.V(this.b.optString("title"));
                aVar.x(this.b.optString("content"));
                aVar.n(new cg3());
                aVar.m(false);
                if (this.b.optBoolean("showCancel", true)) {
                    aVar.E(this.b.optString("cancelColor"), R.color.obfuscated_res_0x7f0603c6);
                    String optString = this.b.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.e.a.getContext().getString(R.string.obfuscated_res_0x7f0f010a);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0493a(this));
                }
                aVar.R(this.b.optString("confirmColor"), R.color.obfuscated_res_0x7f0603c7);
                aVar.P(this.d, new b(this));
                aVar.X();
            }
        }

        public a(pp1 pp1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pp1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pp1Var;
        }

        @Override // com.repackage.xo1.a
        public us1 a(u03 u03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, u03Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0112);
                }
                oe3.e0(new RunnableC0492a(this, u03Var, jSONObject, str, optString));
                return us1.f();
            }
            return (us1) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pp1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public us1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#showModal", false);
            return l(str, true, new a(this));
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ModalApi" : (String) invokeV.objValue;
    }
}
