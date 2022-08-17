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
import com.repackage.cp1;
import com.repackage.d03;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class up1 extends sp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements cp1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up1 a;

        /* renamed from: com.repackage.up1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0596a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ z03 a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ a e;

            /* renamed from: com.repackage.up1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class DialogInterface$OnClickListenerC0597a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0596a a;

                public DialogInterface$OnClickListenerC0597a(RunnableC0596a runnableC0596a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0596a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0596a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "cancel");
                            RunnableC0596a runnableC0596a = this.a;
                            runnableC0596a.e.a.d(runnableC0596a.c, new zs1(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0596a runnableC0596a2 = this.a;
                            runnableC0596a2.e.a.d(runnableC0596a2.c, new zs1(201));
                        }
                    }
                }
            }

            /* renamed from: com.repackage.up1$a$a$b */
            /* loaded from: classes7.dex */
            public class b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RunnableC0596a a;

                public b(RunnableC0596a runnableC0596a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0596a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = runnableC0596a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0596a runnableC0596a = this.a;
                            runnableC0596a.e.a.d(runnableC0596a.c, new zs1(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0596a runnableC0596a2 = this.a;
                            runnableC0596a2.e.a.d(runnableC0596a2.c, new zs1(201));
                        }
                    }
                }
            }

            public RunnableC0596a(a aVar, z03 z03Var, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, z03Var, jSONObject, str, str2};
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
                this.a = z03Var;
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
                d03.a aVar = new d03.a(this.e.a.getContext());
                aVar.V(this.b.optString("title"));
                aVar.x(this.b.optString("content"));
                aVar.n(new hg3());
                aVar.m(false);
                if (this.b.optBoolean("showCancel", true)) {
                    aVar.E(this.b.optString("cancelColor"), R.color.obfuscated_res_0x7f0603d8);
                    String optString = this.b.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.e.a.getContext().getString(R.string.obfuscated_res_0x7f0f0110);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0597a(this));
                }
                aVar.R(this.b.optString("confirmColor"), R.color.obfuscated_res_0x7f0603d9);
                aVar.P(this.d, new b(this));
                aVar.X();
            }
        }

        public a(up1 up1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up1Var;
        }

        @Override // com.repackage.cp1.a
        public zs1 a(z03 z03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, z03Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0118);
                }
                te3.e0(new RunnableC0596a(this, z03Var, jSONObject, str, optString));
                return zs1.f();
            }
            return (zs1) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public up1(@NonNull ap1 ap1Var) {
        super(ap1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ap1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ap1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public zs1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#showModal", false);
            return l(str, true, new a(this));
        }
        return (zs1) invokeL.objValue;
    }

    @Override // com.repackage.cp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ModalApi" : (String) invokeV.objValue;
    }
}
