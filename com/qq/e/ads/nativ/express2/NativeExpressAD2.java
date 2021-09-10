package com.qq.e.ads.nativ.express2;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.NEIADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Deprecated
/* loaded from: classes10.dex */
public class NativeExpressAD2 extends NativeAbstractAD<NEIADI> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f75220b;

    /* renamed from: c  reason: collision with root package name */
    public int f75221c;

    /* renamed from: d  reason: collision with root package name */
    public VideoOption2 f75222d;

    /* renamed from: e  reason: collision with root package name */
    public AdLoadListener f75223e;

    /* renamed from: f  reason: collision with root package name */
    public List<Integer> f75224f;

    /* loaded from: classes10.dex */
    public interface AdLoadListener extends NativeAbstractAD.BasicADListener {
        void onLoadSuccess(List<NativeExpressADData2> list);
    }

    /* loaded from: classes10.dex */
    public static class AdLoadListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AdLoadListener f75225a;

        public AdLoadListenerAdapter(AdLoadListener adLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adLoadListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75225a = adLoadListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) || this.f75225a == null) {
                return;
            }
            int type = aDEvent.getType();
            if (type != 1) {
                if (type != 2) {
                    return;
                }
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    this.f75225a.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                } else {
                    AbstractAD.a(NativeExpressAD2.class, aDEvent);
                }
            }
            if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                this.f75225a.onLoadSuccess((List) aDEvent.getParas()[0]);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75224f = Collections.synchronizedList(new ArrayList());
        this.f75223e = adLoadListener;
        a(context, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NEIADI neiadi) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, neiadi) == null) {
            super.a((NativeExpressAD2) neiadi);
            neiadi.setAdSize(this.f75220b, this.f75221c);
            neiadi.setVideoOption(this.f75222d);
            synchronized (this.f75224f) {
                for (Integer num : this.f75224f) {
                    loadAd(num.intValue());
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADDelegate2(context, str, str2, new AdLoadListenerAdapter(this.f75223e));
    }

    @Override // com.qq.e.ads.AbstractAD
    public final void b(int i2) {
        AdLoadListener adLoadListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (adLoadListener = this.f75223e) == null) {
            return;
        }
        adLoadListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
    }

    public void loadAd(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && b()) {
            if (!a()) {
                this.f75224f.add(Integer.valueOf(i2));
                return;
            }
            T t = this.f75092a;
            if (t != 0) {
                ((NEIADI) t).loadAd(i2);
            } else {
                a("loadAd");
            }
        }
    }

    public void setAdSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.f75220b = i2;
            this.f75221c = i3;
            T t = this.f75092a;
            if (t != 0) {
                ((NEIADI) t).setAdSize(i2, i3);
            }
        }
    }

    public void setVideoOption2(VideoOption2 videoOption2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, videoOption2) == null) {
            this.f75222d = videoOption2;
            T t = this.f75092a;
            if (t != 0) {
                ((NEIADI) t).setVideoOption(videoOption2);
            }
        }
    }
}
