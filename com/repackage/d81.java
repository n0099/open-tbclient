package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.SdkException;
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.na1;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d81 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* loaded from: classes5.dex */
    public class a extends e81<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d81 d81Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d81Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.repackage.e81
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                k91 k91Var = new k91("1");
                k91Var.b(new SdkException("gatewaylist error --> " + str, th).getStackMessage());
                n91.e(k91Var);
                w91.g("requestChannelList onError result=" + str);
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onError(str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e81
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                w91.g("requestChannelList onSuccess result=" + jSONObject.toString());
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onSuccess(jSONObject.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Context b;
        public boolean c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 1;
            this.c = false;
        }

        public d81 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new d81(this, null) : (d81) invokeV.objValue;
        }

        public b e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                this.b = context;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.c = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b g(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.a = i;
                return this;
            }
            return (b) invokeI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract void a(int i, String str);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onError(String str);

        void onSuccess(String str);
    }

    public /* synthetic */ d81(b bVar, c81 c81Var) {
        this(bVar);
    }

    public void a(Bundle bundle, fa1 fa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bundle, fa1Var) == null) {
            ga1.a(bundle, fa1Var);
        }
    }

    public void b(Context context, Bundle bundle, IChannelPay iChannelPay, IChannelAuth iChannelAuth, ka1 ka1Var, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, bundle, iChannelPay, iChannelAuth, ka1Var, cVar}) == null) {
            if (context == null) {
                throw new IllegalArgumentException("context can not be null");
            }
            if (bundle == null) {
                throw new IllegalArgumentException("arguments can not be null");
            }
            if (iChannelPay != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.a < 1000) {
                    w91.g("cashier pay time interval less than 1s");
                    return;
                }
                this.a = currentTimeMillis;
                w91.g("cashier pay");
                String str = "1";
                j91.a("1", currentTimeMillis);
                String string = bundle.getString(PolyActivity.CHOSEN_CHANNEL_KEY);
                String string2 = bundle.getString(PolyActivity.PANEL_TYPE_KEY);
                if (TextUtils.equals(string2, "NONE") && !TextUtils.isEmpty(string)) {
                    str = "0";
                } else if (!TextUtils.equals(string2, PolyActivity.HALF_PANEL_TYPE) && TextUtils.equals(string2, PolyActivity.FULL_PANEL_TYPE)) {
                    str = "2";
                }
                k91 k91Var = new k91("0");
                k91Var.a(PolyActivity.PANEL_TYPE_KEY, str);
                n91.e(k91Var);
                PolyActivity.startPay(context, iChannelPay, iChannelAuth, ka1Var, cVar, bundle);
                return;
            }
            throw new IllegalArgumentException("channelPay can not be null");
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            m91.g().h();
        }
    }

    public void d(Bundle bundle, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bundle, dVar) == null) {
            j91.a("1.01", System.currentTimeMillis());
            m81.j().f(z91.b(aa1.a(), bundle), true, new a(this, dVar));
        }
    }

    public void e(int i, JSONObject jSONObject, h91 h91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, jSONObject, h91Var) == null) {
            if (i == 1) {
                l81.c(jSONObject, h91Var);
            } else if (i == 2) {
                p81.f(h91Var);
            } else if (h91Var != null) {
                h91Var.a(1, "unknown command");
            }
        }
    }

    public void f(Activity activity, pa1 pa1Var, na1.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, pa1Var, dVar) == null) {
            if (activity == null) {
                w91.d("couponEntity is null!");
            } else if (pa1Var != null && pa1Var.b != null) {
                na1 na1Var = new na1(activity);
                na1Var.d(dVar);
                na1Var.update(pa1Var.b);
                na1Var.show();
            } else {
                w91.d("couponEntity || couponItemList is null!");
            }
        }
    }

    public d81(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        if (bVar != null) {
            if (bVar.b != null) {
                l81.b(bVar.a);
                r81.c(q81.d(bVar.b.getApplicationContext()));
                aa1.b(bVar.b.getApplicationContext());
                w91.d = bVar.c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}
