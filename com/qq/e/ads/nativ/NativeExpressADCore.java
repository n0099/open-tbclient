package com.qq.e.ads.nativ;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
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
/* loaded from: classes10.dex */
public class NativeExpressADCore extends LiteAbstractAD<NEADVI> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f75548b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f75549c;

    /* renamed from: d  reason: collision with root package name */
    public NativeExpressMediaListener f75550d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f75551e;

    /* renamed from: f  reason: collision with root package name */
    public final NEADI f75552f;

    /* renamed from: g  reason: collision with root package name */
    public final NEADVI f75553g;

    /* renamed from: h  reason: collision with root package name */
    public final NativeExpressADData2 f75554h;

    /* renamed from: i  reason: collision with root package name */
    public ADSize f75555i;

    /* renamed from: j  reason: collision with root package name */
    public JSONObject f75556j;
    public HashMap<String, Object> k;
    public NativeExpressADView l;

    public NativeExpressADCore(NativeExpressADView nativeExpressADView, NEADI neadi, NEADVI neadvi, NativeExpressADData2 nativeExpressADData2, Context context, ADSize aDSize, String str, JSONObject jSONObject, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nativeExpressADView, neadi, neadvi, nativeExpressADData2, context, aDSize, str, jSONObject, hashMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75548b = false;
        this.f75549c = false;
        this.f75551e = false;
        this.l = nativeExpressADView;
        this.f75552f = neadi;
        this.f75553g = neadvi;
        this.f75554h = nativeExpressADData2;
        this.f75555i = aDSize;
        this.f75556j = jSONObject;
        this.k = hashMap;
        a(context, str);
    }

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADView(this.f75552f, this.f75553g, this.f75554h, context, this.l, this.f75555i, str, str2, this.f75556j, this.k);
    }

    @Deprecated
    public final void a(ADSize aDSize) {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aDSize) == null) || (t = this.f75446a) == 0) {
            return;
        }
        ((NEADVI) t).setAdSize(aDSize);
    }

    public final void a(NativeExpressMediaListener nativeExpressMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nativeExpressMediaListener) == null) {
            this.f75550d = nativeExpressMediaListener;
            T t = this.f75446a;
            if (t == 0 || nativeExpressMediaListener == null) {
                return;
            }
            ((NEADVI) t).setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ void a(Object obj) {
        NativeExpressMediaListener nativeExpressMediaListener = this.f75550d;
        if (nativeExpressMediaListener != null) {
            a(nativeExpressMediaListener);
        }
        if (this.f75548b) {
            d();
        }
        if (this.f75549c) {
            e();
        }
        if (this.f75551e) {
            f();
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!a()) {
                this.f75548b = true;
                return;
            }
            T t = this.f75446a;
            if (t != 0) {
                ((NEADVI) t).preloadVideo();
            } else {
                a("preloadVideo");
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!a()) {
                this.f75549c = true;
                return;
            }
            T t = this.f75446a;
            if (t != 0) {
                ((NEADVI) t).render();
            } else {
                a("render");
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!a()) {
                this.f75551e = true;
                return;
            }
            T t = this.f75446a;
            if (t == 0) {
                a("negativeFeedback");
                return;
            }
            ((NEADVI) t).reportAdNegative();
            this.f75551e = false;
        }
    }

    public final void g() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (t = this.f75446a) == 0) {
            return;
        }
        ((NEADVI) t).destroy();
    }
}
