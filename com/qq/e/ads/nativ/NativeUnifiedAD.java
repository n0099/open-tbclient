package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public AdListenerAdapter g;
    public NativeADUnifiedListener h;
    public List<Integer> i;
    public List<String> j;
    public volatile int k;
    public volatile int l;
    public String m;
    public LoadAdParams n;

    /* loaded from: classes10.dex */
    public static class AdListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NativeADUnifiedListener a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nativeADUnifiedListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) || this.a == null) {
                return;
            }
            int type = aDEvent.getType();
            if (type != 100) {
                if (type == 101 && (num = (Integer) aDEvent.getParam(Integer.class)) != null) {
                    this.a.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                    return;
                }
                return;
            }
            List<NativeUnifiedADData> list = (List) aDEvent.getParam(List.class);
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (NativeUnifiedADData nativeUnifiedADData : list) {
                arrayList.add(new NativeUnifiedADDataAdapter(nativeUnifiedADData));
            }
            this.a.onADLoaded(arrayList);
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, nativeADUnifiedListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.h = nativeADUnifiedListener;
        this.g = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, nativeADUnifiedListener, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.h = nativeADUnifiedListener;
        this.g = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    private void a(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && a()) {
            if (!b()) {
                if (z) {
                    this.i.add(Integer.valueOf(i));
                    return;
                }
                return;
            }
            T t = this.a;
            if (t != 0) {
                LoadAdParams loadAdParams = this.n;
                NUADI nuadi = (NUADI) t;
                if (loadAdParams != null) {
                    nuadi.loadData(i, loadAdParams);
                } else {
                    nuadi.loadData(i);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NUADI nuadi) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nuadi) == null) {
            super.a((NativeUnifiedAD) nuadi);
            nuadi.setMinVideoDuration(this.k);
            nuadi.setMaxVideoDuration(this.l);
            nuadi.setVastClassName(this.m);
            List<String> list = this.j;
            if (list != null) {
                setCategories(list);
            }
            for (Integer num : this.i) {
                a(num.intValue(), false);
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        NativeADUnifiedListener nativeADUnifiedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (nativeADUnifiedListener = this.h) == null) {
            return;
        }
        nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
    }

    public String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.a;
            if (t != 0) {
                return ((NUADI) t).getAdNetWorkName();
            }
            a("getAdNetWorkName");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void loadData(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            a(i, true);
        }
    }

    public void loadData(int i, LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, loadAdParams) == null) {
            this.n = loadAdParams;
            loadData(i);
        }
    }

    public void setCategories(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.j = list;
            T t = this.a;
            if (t == 0 || list == null) {
                return;
            }
            ((NUADI) t).setCategories(list);
        }
    }

    public void setMaxVideoDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.l = i;
            if (this.l > 0 && this.k > this.l) {
                GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
            }
            T t = this.a;
            if (t != 0) {
                ((NUADI) t).setMaxVideoDuration(this.l);
            }
        }
    }

    public void setMinVideoDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.k = i;
            if (this.l > 0 && this.k > this.l) {
                GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
            }
            T t = this.a;
            if (t != 0) {
                ((NUADI) t).setMinVideoDuration(this.k);
            }
        }
    }

    public void setVastClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                GDTLogger.e("Vast class name 不能为空");
                return;
            }
            this.m = str;
            T t = this.a;
            if (t != 0) {
                ((NUADI) t).setVastClassName(str);
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, pOFactory, str, str2, str3)) == null) {
            return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.g);
        }
        return invokeLLLLL.objValue;
    }
}
