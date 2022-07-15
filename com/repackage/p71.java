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
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.repackage.z91;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* loaded from: classes6.dex */
    public class a extends q71<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(p71 p71Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p71Var, dVar};
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

        @Override // com.repackage.q71
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                w81 w81Var = new w81("1");
                w81Var.b(new SdkException("gatewaylist error --> " + str, th).getStackMessage());
                z81.e(w81Var);
                i91.g("requestChannelList onError result=" + str);
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onError(str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q71
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                i91.g("requestChannelList onSuccess result=" + jSONObject.toString());
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onSuccess(jSONObject.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

        public p71 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new p71(this, null) : (p71) invokeV.objValue;
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public interface d {
        void onError(String str);

        void onSuccess(String str);
    }

    public /* synthetic */ p71(b bVar, o71 o71Var) {
        this(bVar);
    }

    public void a(Bundle bundle, r91 r91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bundle, r91Var) == null) {
            s91.a(bundle, r91Var);
        }
    }

    public void b(Context context, Bundle bundle, IChannelPay iChannelPay, IChannelAuth iChannelAuth, w91 w91Var, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, bundle, iChannelPay, iChannelAuth, w91Var, cVar}) == null) {
            if (context == null) {
                throw new IllegalArgumentException("context can not be null");
            }
            if (bundle == null) {
                throw new IllegalArgumentException("arguments can not be null");
            }
            if (iChannelPay != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.a < 1000) {
                    i91.g("cashier pay time interval less than 1s");
                    return;
                }
                this.a = currentTimeMillis;
                i91.g("cashier pay");
                String str = "1";
                v81.a("1", currentTimeMillis);
                String string = bundle.getString("chosenChannel");
                String string2 = bundle.getString("panelType");
                if (TextUtils.equals(string2, HlsPlaylistParser.METHOD_NONE) && !TextUtils.isEmpty(string)) {
                    str = "0";
                } else if (!TextUtils.equals(string2, "HALF") && TextUtils.equals(string2, "FULL")) {
                    str = "2";
                }
                w81 w81Var = new w81("0");
                w81Var.a("panelType", str);
                z81.e(w81Var);
                PolyActivity.n(context, iChannelPay, iChannelAuth, w91Var, cVar, bundle);
                return;
            }
            throw new IllegalArgumentException("channelPay can not be null");
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            y81.g().h();
        }
    }

    public void d(Bundle bundle, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bundle, dVar) == null) {
            v81.a("1.01", System.currentTimeMillis());
            y71.j().f(l91.b(m91.a(), bundle), true, new a(this, dVar));
        }
    }

    public void e(int i, JSONObject jSONObject, t81 t81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, jSONObject, t81Var) == null) {
            if (i == 1) {
                x71.c(jSONObject, t81Var);
            } else if (i == 2) {
                b81.f(t81Var);
            } else if (t81Var != null) {
                t81Var.a(1, "unknown command");
            }
        }
    }

    public void f(Activity activity, ba1 ba1Var, z91.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, ba1Var, dVar) == null) {
            if (activity == null) {
                i91.d("couponEntity is null!");
            } else if (ba1Var != null && ba1Var.b != null) {
                z91 z91Var = new z91(activity);
                z91Var.d(dVar);
                z91Var.update(ba1Var.b);
                z91Var.show();
            } else {
                i91.d("couponEntity || couponItemList is null!");
            }
        }
    }

    public p71(b bVar) {
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
                x71.b(bVar.a);
                d81.c(c81.d(bVar.b.getApplicationContext()));
                m91.b(bVar.b.getApplicationContext());
                i91.d = bVar.c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}
