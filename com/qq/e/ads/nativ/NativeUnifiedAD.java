package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class NativeUnifiedAD extends AbstractAD<NUADI> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdListenerAdapter f38017a;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f38018b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f38019c;

    /* renamed from: d  reason: collision with root package name */
    public String f38020d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f38021e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f38022f;

    /* renamed from: g  reason: collision with root package name */
    public String f38023g;

    /* loaded from: classes6.dex */
    public static class AdListenerAdapter implements ADListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NativeADUnifiedListener f38027a;

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
            this.f38027a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aDEvent) == null) {
                if (this.f38027a == null) {
                    GDTLogger.i("not bind NativeADUnifiedListener");
                    return;
                }
                Object[] paras = aDEvent.getParas();
                int type = aDEvent.getType();
                if (type != 1) {
                    if (type == 2 && paras.length > 0 && (paras[0] instanceof Integer)) {
                        this.f38027a.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    }
                } else if (paras.length == 1 && (paras[0] instanceof List)) {
                    List<NativeUnifiedADData> list = (List) paras[0];
                    ArrayList arrayList = new ArrayList();
                    if (list != null && list.size() > 0) {
                        for (NativeUnifiedADData nativeUnifiedADData : list) {
                            arrayList.add(new NativeUnifiedADDataAdapter(nativeUnifiedADData));
                        }
                    }
                    this.f38027a.onADLoaded(arrayList);
                }
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
        this.f38018b = new ArrayList();
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, nativeADUnifiedListener);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        a(nativeADUnifiedListener, 2003);
    }

    @Deprecated
    public NativeUnifiedAD(Context context, String str, String str2, NativeADUnifiedListener nativeADUnifiedListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, nativeADUnifiedListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38018b = new ArrayList();
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, str, str2, nativeADUnifiedListener);
    }

    private void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (!c()) {
                GDTLogger.e("Parameters or context error, details in init NativeUnifiedAD log");
            } else if (!b()) {
                if (z) {
                    this.f38018b.add(Integer.valueOf(i2));
                }
            } else {
                NUADI a2 = a();
                if (a2 != null) {
                    a2.loadData(i2);
                }
            }
        }
    }

    private void a(Context context, String str, String str2, NativeADUnifiedListener nativeADUnifiedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, this, context, str, str2, nativeADUnifiedListener) == null) {
            if (context == null || StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
                GDTLogger.e(String.format("NativeUnifiedAD constructor parameters error, appId=%s, posId=%s, context=%s", str, str2, context));
                a(nativeADUnifiedListener, 2001);
                return;
            }
            this.f38017a = new AdListenerAdapter(nativeADUnifiedListener);
            this.f38020d = str2;
            a(context, str, str2, (AbstractAD.BasicADListener) nativeADUnifiedListener);
        }
    }

    /* JADX DEBUG: Return type fixed from 'com.qq.e.comm.pi.ADI' to match base method */
    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ NUADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, this.f38017a);
    }

    @Override // com.qq.e.ads.AbstractAD
    public final void a(AbstractAD.BasicADListener basicADListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, basicADListener, i2) == null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, basicADListener, i2) { // from class: com.qq.e.ads.nativ.NativeUnifiedAD.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ AbstractAD.BasicADListener f38024a;

                /* renamed from: b  reason: collision with root package name */
                public /* synthetic */ int f38025b;

                /* renamed from: c  reason: collision with root package name */
                public /* synthetic */ NativeUnifiedAD f38026c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, basicADListener, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38026c = this;
                    this.f38024a = basicADListener;
                    this.f38025b = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        NativeUnifiedAD.super.a(this.f38024a, this.f38025b);
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.qq.e.comm.pi.ADI] */
    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ void a(NUADI nuadi) {
        NUADI nuadi2 = nuadi;
        nuadi2.setMinVideoDuration(this.f38021e);
        nuadi2.setMaxVideoDuration(this.f38022f);
        nuadi2.setVastClassName(this.f38023g);
        List<String> list = this.f38019c;
        if (list != null) {
            setCategories(list);
        }
        for (Integer num : this.f38018b) {
            a(num.intValue(), false);
        }
    }

    public String getAdNetWorkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            NUADI a2 = a();
            if (a2 != null) {
                return a2.getAdNetWorkName();
            }
            GDTLogger.e("The ad does not support \"getAdNetWorkName\" or you should call this method after \"onADLoaded\"");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void loadData(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            a(i2, true);
        }
    }

    public void loadData(int i2, LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, loadAdParams) == null) {
            loadData(i2);
        }
    }

    public void setCategories(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f38019c = list;
            NUADI a2 = a();
            if (a2 == null || list == null) {
                return;
            }
            a2.setCategories(list);
        }
    }

    public void setMaxVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f38022f = i2;
            if (this.f38022f > 0 && this.f38021e > this.f38022f) {
                GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
            }
            NUADI a2 = a();
            if (a2 != null) {
                a2.setMaxVideoDuration(this.f38022f);
            }
        }
    }

    public void setMinVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f38021e = i2;
            if (this.f38022f > 0 && this.f38021e > this.f38022f) {
                GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
            }
            NUADI a2 = a();
            if (a2 != null) {
                a2.setMinVideoDuration(this.f38021e);
            }
        }
    }

    public void setTag(Map map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, map) == null) || map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), this.f38020d);
        } catch (Exception e2) {
            GDTLogger.e("NativeUnifiedAD#setTag Exception");
            e2.printStackTrace();
        }
    }

    public void setVastClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                GDTLogger.e("Vast class name can't be null");
                return;
            }
            this.f38023g = str;
            NUADI a2 = a();
            if (a2 != null) {
                a2.setVastClassName(str);
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
