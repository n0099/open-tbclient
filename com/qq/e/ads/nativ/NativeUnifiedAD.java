package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NativeUnifiedAD extends AbstractAD<NUADI> {

    /* renamed from: a  reason: collision with root package name */
    private AdListenerAdapter f11483a;
    private List<String> c;
    private String d;
    private volatile int e;
    private volatile int f;
    private String i;
    private LoadAdParams j;

    /* renamed from: b  reason: collision with root package name */
    private List<Integer> f11484b = new ArrayList();
    private int g = 0;
    private int h = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class AdListenerAdapter implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private NativeADUnifiedListener f11487a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f11487a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.f11487a == null) {
                GDTLogger.i("not bind NativeADUnifiedListener");
                return;
            }
            Object[] paras = aDEvent.getParas();
            switch (aDEvent.getType()) {
                case 1:
                    if (paras.length == 1 && (paras[0] instanceof List)) {
                        List<NativeUnifiedADData> list = (List) paras[0];
                        ArrayList arrayList = new ArrayList();
                        if (list != null && list.size() > 0) {
                            for (NativeUnifiedADData nativeUnifiedADData : list) {
                                arrayList.add(new NativeUnifiedADDataAdapter(nativeUnifiedADData));
                            }
                        }
                        this.f11487a.onADLoaded(arrayList);
                        return;
                    }
                    return;
                case 2:
                    if (paras.length <= 0 || !(paras[0] instanceof Integer)) {
                        return;
                    }
                    this.f11487a.onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                default:
                    return;
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, nativeADUnifiedListener);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        a(nativeADUnifiedListener, 2003);
    }

    @Deprecated
    public NativeUnifiedAD(Context context, String str, String str2, NativeADUnifiedListener nativeADUnifiedListener) {
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, str, str2, nativeADUnifiedListener);
    }

    private void a(int i, boolean z) {
        if (!c()) {
            GDTLogger.e("Parameters or context error, details in init NativeUnifiedAD log");
        } else if (!b()) {
            if (z) {
                this.f11484b.add(Integer.valueOf(i));
            }
        } else {
            NUADI a2 = a();
            if (a2 != null) {
                if (this.j != null) {
                    a2.loadData(i, this.j);
                } else {
                    a2.loadData(i);
                }
            }
        }
    }

    private void a(Context context, String str, String str2, NativeADUnifiedListener nativeADUnifiedListener) {
        if (context == null || StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            GDTLogger.e(String.format("NativeUnifiedAD constructor parameters error, appId=%s, posId=%s, context=%s", str, str2, context));
            a(nativeADUnifiedListener, 4002);
            return;
        }
        this.f11483a = new AdListenerAdapter(nativeADUnifiedListener);
        this.d = str2;
        a(context, str, str2, (AbstractAD.BasicADListener) nativeADUnifiedListener);
    }

    /* JADX DEBUG: Return type fixed from 'com.qq.e.comm.pi.ADI' to match base method */
    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ NUADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, this.f11483a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    public final void a(final AbstractAD.BasicADListener basicADListener, final int i) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.nativ.NativeUnifiedAD.1
            @Override // java.lang.Runnable
            public void run() {
                NativeUnifiedAD.super.a(basicADListener, i);
            }
        });
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.qq.e.comm.pi.ADI] */
    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ void a(NUADI nuadi) {
        NUADI nuadi2 = nuadi;
        nuadi2.setMinVideoDuration(this.e);
        nuadi2.setMaxVideoDuration(this.f);
        nuadi2.setVideoPlayPolicy(this.g);
        nuadi2.setVideoADContainerRender(this.h);
        nuadi2.setVastClassName(this.i);
        if (this.c != null) {
            setCategories(this.c);
        }
        for (Integer num : this.f11484b) {
            a(num.intValue(), false);
        }
    }

    public String getAdNetWorkName() {
        NUADI a2 = a();
        if (a2 != null) {
            return a2.getAdNetWorkName();
        }
        GDTLogger.e("The ad does not support \"getAdNetWorkName\" or you should call this method after \"onADLoaded\"");
        return null;
    }

    public void loadData(int i) {
        loadData(i, null);
    }

    public void loadData(int i, LoadAdParams loadAdParams) {
        if (loadAdParams != null) {
            this.j = loadAdParams;
            String passThroughInfoJsonString = this.j.getPassThroughInfoJsonString();
            if (passThroughInfoJsonString != null && passThroughInfoJsonString.getBytes().length >= 512) {
                GDTLogger.e("NativeUnifiedAD setAdParams too large ,current size: " + this.j.toString().getBytes().length);
            }
        }
        a(i, true);
        if (this.g == 0) {
            GDTLogger.i("请调用setVideoPlayPolicy()接口，设置“用户感知的视频广告播放策略”，有助于提高视频广告的eCPM值；如果广告位不支持视频广告，请忽略本提示。");
        }
        if (this.h == 0) {
            GDTLogger.i("请调用setVideoADContainerRender()接口，设置“用户首次看到的视频广告容器”渲染策略，有助于提高视频广告的eCPM值；如果广告位不支持视频广告，请忽略本提示。");
        }
    }

    public void setCategories(List<String> list) {
        this.c = list;
        NUADI a2 = a();
        if (a2 == null || list == null) {
            return;
        }
        a2.setCategories(list);
    }

    public void setMaxVideoDuration(int i) {
        this.f = i;
        if (this.f > 0 && this.e > this.f) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        NUADI a2 = a();
        if (a2 != null) {
            a2.setMaxVideoDuration(this.f);
        }
    }

    public void setMinVideoDuration(int i) {
        this.e = i;
        if (this.f > 0 && this.e > this.f) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        NUADI a2 = a();
        if (a2 != null) {
            a2.setMinVideoDuration(this.e);
        }
    }

    public void setTag(Map map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), this.d);
        } catch (Exception e) {
            GDTLogger.e("NativeUnifiedAD#setTag Exception");
            e.printStackTrace();
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name can't be null");
            return;
        }
        this.i = str;
        NUADI a2 = a();
        if (a2 != null) {
            a2.setVastClassName(str);
        }
    }

    public void setVideoADContainerRender(int i) {
        if (i != 1 && i != 2) {
            GDTLogger.e("videoADContainerRender参数有误，只能是VideoADContainerRender.SDK 或 VideoADContainerRender.DEV");
            return;
        }
        this.h = i;
        NUADI a2 = a();
        if (a2 != null) {
            a2.setVideoADContainerRender(i);
        }
    }

    public void setVideoPlayPolicy(int i) {
        if (i != 1 && i != 2) {
            GDTLogger.e("videoPlayPolicy参数有误，只能是VideoPlayPolicy.AUTO 或 VideoPlayPolicy.MANUAL");
            return;
        }
        this.g = i;
        NUADI a2 = a();
        if (a2 != null) {
            a2.setVideoPlayPolicy(i);
        }
    }
}
