package com.qq.e.ads.nativ;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.pi.POFactory;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class NativeExpressADCore extends LiteAbstractAD<NEADVI> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean g;
    public volatile boolean h;
    public NativeExpressMediaListener i;
    public volatile boolean j;
    public final NEADI k;
    public final NEADVI l;
    public final NativeExpressADData2 m;
    public ADSize n;
    public final JSONObject o;
    public final HashMap<String, Object> p;
    public NativeExpressADView q;

    /* JADX DEBUG: Incorrect args count in method signature: (Lcom/qq/e/ads/nativ/NativeExpressADView;Lcom/qq/e/comm/pi/NEADI;Lcom/qq/e/comm/pi/NEADVI;Lcom/qq/e/ads/nativ/express2/NativeExpressADData2;Landroid/content/Context;Lcom/qq/e/ads/nativ/ADSize;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;)V */
    public NativeExpressADCore(NativeExpressADView nativeExpressADView, NEADI neadi, NEADVI neadvi, NativeExpressADData2 nativeExpressADData2, Context context, ADSize aDSize, String str, JSONObject jSONObject, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nativeExpressADView, neadi, neadvi, nativeExpressADData2, context, aDSize, str, jSONObject, hashMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.h = false;
        this.j = false;
        this.q = nativeExpressADView;
        this.k = neadi;
        this.l = neadvi;
        this.m = nativeExpressADData2;
        this.n = aDSize;
        this.o = jSONObject;
        this.p = hashMap;
        a(context, str);
    }

    public NEADVI a(Context context, POFactory pOFactory, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, pOFactory, str, str2)) == null) ? pOFactory.getNativeExpressADView(this.k, this.l, this.m, context, this.q, this.n, str, str2, this.o, this.p) : (NEADVI) invokeLLLL.objValue;
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(context, pOFactory, str, str2);
    }

    public void a(NativeExpressMediaListener nativeExpressMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nativeExpressMediaListener) == null) {
            this.i = nativeExpressMediaListener;
            T t = this.a;
            if (t == 0 || nativeExpressMediaListener == null) {
                return;
            }
            ((NEADVI) t).setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        NEADVI neadvi = (NEADVI) obj;
        d();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            NativeExpressMediaListener nativeExpressMediaListener = this.i;
            if (nativeExpressMediaListener != null) {
                this.i = nativeExpressMediaListener;
                T t = this.a;
                if (t != 0 && nativeExpressMediaListener != null) {
                    ((NEADVI) t).setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
                }
            }
            if (this.g) {
                preloadVideo();
            }
            if (this.h) {
                render();
            }
            if (this.j) {
                negativeFeedback();
            }
        }
    }

    public void destroy() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (t = this.a) == 0) {
            return;
        }
        ((NEADVI) t).destroy();
    }

    public void negativeFeedback() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (b()) {
                T t = this.a;
                if (t == 0) {
                    a("negativeFeedback");
                    return;
                } else {
                    ((NEADVI) t).reportAdNegative();
                    z = false;
                }
            } else {
                z = true;
            }
            this.j = z;
        }
    }

    public void preloadVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!b()) {
                this.g = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((NEADVI) t).preloadVideo();
            } else {
                a("preloadVideo");
            }
        }
    }

    public void render() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!b()) {
                this.h = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((NEADVI) t).render();
            } else {
                a("render");
            }
        }
    }

    @Deprecated
    public void setAdSize(ADSize aDSize) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aDSize) == null) || (t = this.a) == 0) {
            return;
        }
        ((NEADVI) t).setAdSize(aDSize);
    }
}
