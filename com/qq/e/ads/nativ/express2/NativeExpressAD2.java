package com.qq.e.ads.nativ.express2;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.NEIADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Deprecated
/* loaded from: classes8.dex */
public class NativeExpressAD2 extends NativeAbstractAD<NEIADI> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int g;
    public int h;
    public VideoOption2 i;
    public AdLoadListener j;
    public List<Integer> k;

    /* loaded from: classes8.dex */
    public interface AdLoadListener extends NativeAbstractAD.BasicADListener {
        void onLoadSuccess(List<NativeExpressADData2> list);
    }

    /* loaded from: classes8.dex */
    public static class AdLoadListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AdLoadListener a;

        public AdLoadListenerAdapter(AdLoadListener adLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adLoadListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) || this.a == null) {
                return;
            }
            int type = aDEvent.getType();
            if (type != 1) {
                if (type != 2) {
                    return;
                }
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    this.a.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                } else {
                    AbstractAD.a(NativeExpressAD2.class, aDEvent);
                }
            }
            if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                this.a.onLoadSuccess((List) aDEvent.getParas()[0]);
            } else {
                AbstractAD.a(NativeExpressAD2.class, aDEvent);
            }
        }
    }

    public NativeExpressAD2(Context context, String str, AdLoadListener adLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, adLoadListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = Collections.synchronizedList(new ArrayList());
        GDTLogger.e("NativeExpressAD2 接口即将被移除，请使用 NativeExpressAD 接口");
        this.j = adLoadListener;
        a(context, str);
    }

    public NEIADI a(Context context, POFactory pOFactory, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, pOFactory, str, str2)) == null) ? pOFactory.getNativeExpressADDelegate2(context, str, str2, new AdLoadListenerAdapter(this.j)) : (NEIADI) invokeLLLL.objValue;
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(context, pOFactory, str, str2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NEIADI neiadi) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, neiadi) == null) {
            super.a((NativeExpressAD2) neiadi);
            neiadi.setAdSize(this.g, this.h);
            neiadi.setVideoOption(this.i);
            synchronized (this.k) {
                for (Integer num : this.k) {
                    loadAd(num.intValue());
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        AdLoadListener adLoadListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (adLoadListener = this.j) == null) {
            return;
        }
        adLoadListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
    }

    public void loadAd(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && a()) {
            if (!b()) {
                this.k.add(Integer.valueOf(i));
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((NEIADI) t).loadAd(i);
            } else {
                a("loadAd");
            }
        }
    }

    public void setAdSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            this.g = i;
            this.h = i2;
            T t = this.a;
            if (t != 0) {
                ((NEIADI) t).setAdSize(i, i2);
            }
        }
    }

    public void setVideoOption2(VideoOption2 videoOption2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoOption2) == null) {
            this.i = videoOption2;
            T t = this.a;
            if (t != 0) {
                ((NEIADI) t).setVideoOption(videoOption2);
            }
        }
    }
}
