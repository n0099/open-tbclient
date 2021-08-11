package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
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
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdListenerAdapter f74825b;

    /* renamed from: c  reason: collision with root package name */
    public NativeADUnifiedListener f74826c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f74827d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f74828e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f74829f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f74830g;

    /* renamed from: h  reason: collision with root package name */
    public String f74831h;

    /* renamed from: i  reason: collision with root package name */
    public LoadAdParams f74832i;

    /* loaded from: classes10.dex */
    public static class AdListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NativeADUnifiedListener f74833a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nativeADUnifiedListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74833a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) || this.f74833a == null) {
                return;
            }
            Object[] paras = aDEvent.getParas();
            int type = aDEvent.getType();
            if (type != 1) {
                if (type != 2) {
                    return;
                }
                if (paras.length <= 0 || !(paras[0] instanceof Integer)) {
                    AbstractAD.a(NativeUnifiedAD.class, aDEvent);
                } else {
                    this.f74833a.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                }
            } else if (paras.length == 1 && (paras[0] instanceof List)) {
                List<NativeUnifiedADData> list = (List) paras[0];
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    for (NativeUnifiedADData nativeUnifiedADData : list) {
                        arrayList.add(new NativeUnifiedADDataAdapter(nativeUnifiedADData));
                    }
                }
                this.f74833a.onADLoaded(arrayList);
            } else {
                AbstractAD.a(NativeUnifiedAD.class, aDEvent);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, nativeADUnifiedListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f74827d = new ArrayList();
        this.f74826c = nativeADUnifiedListener;
        this.f74825b = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public NativeUnifiedAD(Context context, String str, String str2, NativeADUnifiedListener nativeADUnifiedListener) {
        this(context, str2, nativeADUnifiedListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, nativeADUnifiedListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (NativeADUnifiedListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c();
    }

    private void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && b()) {
            if (!a()) {
                if (z) {
                    this.f74827d.add(Integer.valueOf(i2));
                    return;
                }
                return;
            }
            T t = this.f74712a;
            if (t != 0) {
                LoadAdParams loadAdParams = this.f74832i;
                NUADI nuadi = (NUADI) t;
                if (loadAdParams != null) {
                    nuadi.loadData(i2, loadAdParams);
                } else {
                    nuadi.loadData(i2);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NUADI nuadi) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, nuadi) == null) {
            super.a((NativeUnifiedAD) nuadi);
            nuadi.setMinVideoDuration(this.f74829f);
            nuadi.setMaxVideoDuration(this.f74830g);
            nuadi.setVastClassName(this.f74831h);
            List<String> list = this.f74828e;
            if (list != null) {
                setCategories(list);
            }
            for (Integer num : this.f74827d) {
                a(num.intValue(), false);
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ Object a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, this.f74825b);
    }

    @Override // com.qq.e.ads.AbstractAD
    public final void b(int i2) {
        NativeADUnifiedListener nativeADUnifiedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (nativeADUnifiedListener = this.f74826c) == null) {
            return;
        }
        nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
    }

    public String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            T t = this.f74712a;
            if (t != 0) {
                return ((NUADI) t).getAdNetWorkName();
            }
            a("getAdNetWorkName");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void loadData(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            a(i2, true);
        }
    }

    public void loadData(int i2, LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, loadAdParams) == null) {
            this.f74832i = loadAdParams;
            loadData(i2);
        }
    }

    public void setCategories(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f74828e = list;
            T t = this.f74712a;
            if (t == 0 || list == null) {
                return;
            }
            ((NUADI) t).setCategories(list);
        }
    }

    public void setMaxVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f74830g = i2;
            if (this.f74830g > 0 && this.f74829f > this.f74830g) {
                GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
            }
            T t = this.f74712a;
            if (t != 0) {
                ((NUADI) t).setMaxVideoDuration(this.f74830g);
            }
        }
    }

    public void setMinVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f74829f = i2;
            if (this.f74830g > 0 && this.f74829f > this.f74830g) {
                GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
            }
            T t = this.f74712a;
            if (t != 0) {
                ((NUADI) t).setMinVideoDuration(this.f74829f);
            }
        }
    }

    public void setVastClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                GDTLogger.e("Vast class name 不能为空");
                return;
            }
            this.f74831h = str;
            T t = this.f74712a;
            if (t != 0) {
                ((NUADI) t).setVastClassName(str);
            }
        }
    }

    @Deprecated
    public void setVideoADContainerRender(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }

    @Deprecated
    public void setVideoPlayPolicy(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }
}
