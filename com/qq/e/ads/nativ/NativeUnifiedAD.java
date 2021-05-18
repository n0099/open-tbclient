package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
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

    /* renamed from: a  reason: collision with root package name */
    public AdListenerAdapter f35355a;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f35356b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<String> f35357c;

    /* renamed from: d  reason: collision with root package name */
    public String f35358d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f35359e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f35360f;

    /* renamed from: g  reason: collision with root package name */
    public String f35361g;

    /* loaded from: classes6.dex */
    public static class AdListenerAdapter implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        public NativeADUnifiedListener f35365a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f35365a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.f35365a == null) {
                GDTLogger.i("not bind NativeADUnifiedListener");
                return;
            }
            Object[] paras = aDEvent.getParas();
            int type = aDEvent.getType();
            if (type != 1) {
                if (type == 2 && paras.length > 0 && (paras[0] instanceof Integer)) {
                    this.f35365a.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                }
            } else if (paras.length == 1 && (paras[0] instanceof List)) {
                List<NativeUnifiedADData> list = (List) paras[0];
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    for (NativeUnifiedADData nativeUnifiedADData : list) {
                        arrayList.add(new NativeUnifiedADDataAdapter(nativeUnifiedADData));
                    }
                }
                this.f35365a.onADLoaded(arrayList);
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

    private void a(int i2, boolean z) {
        if (!c()) {
            GDTLogger.e("Parameters or context error, details in init NativeUnifiedAD log");
        } else if (!b()) {
            if (z) {
                this.f35356b.add(Integer.valueOf(i2));
            }
        } else {
            NUADI a2 = a();
            if (a2 != null) {
                a2.loadData(i2);
            }
        }
    }

    private void a(Context context, String str, String str2, NativeADUnifiedListener nativeADUnifiedListener) {
        if (context == null || StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            GDTLogger.e(String.format("NativeUnifiedAD constructor parameters error, appId=%s, posId=%s, context=%s", str, str2, context));
            a(nativeADUnifiedListener, 2001);
            return;
        }
        this.f35355a = new AdListenerAdapter(nativeADUnifiedListener);
        this.f35358d = str2;
        a(context, str, str2, (AbstractAD.BasicADListener) nativeADUnifiedListener);
    }

    /* JADX DEBUG: Return type fixed from 'com.qq.e.comm.pi.ADI' to match base method */
    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ NUADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, this.f35355a);
    }

    @Override // com.qq.e.ads.AbstractAD
    public final void a(final AbstractAD.BasicADListener basicADListener, final int i2) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.nativ.NativeUnifiedAD.1
            @Override // java.lang.Runnable
            public void run() {
                NativeUnifiedAD.super.a(basicADListener, i2);
            }
        });
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.qq.e.comm.pi.ADI] */
    @Override // com.qq.e.ads.AbstractAD
    public final /* synthetic */ void a(NUADI nuadi) {
        NUADI nuadi2 = nuadi;
        nuadi2.setMinVideoDuration(this.f35359e);
        nuadi2.setMaxVideoDuration(this.f35360f);
        nuadi2.setVastClassName(this.f35361g);
        List<String> list = this.f35357c;
        if (list != null) {
            setCategories(list);
        }
        for (Integer num : this.f35356b) {
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

    public void loadData(int i2) {
        a(i2, true);
    }

    public void loadData(int i2, LoadAdParams loadAdParams) {
        loadData(i2);
    }

    public void setCategories(List<String> list) {
        this.f35357c = list;
        NUADI a2 = a();
        if (a2 == null || list == null) {
            return;
        }
        a2.setCategories(list);
    }

    public void setMaxVideoDuration(int i2) {
        this.f35360f = i2;
        if (this.f35360f > 0 && this.f35359e > this.f35360f) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        NUADI a2 = a();
        if (a2 != null) {
            a2.setMaxVideoDuration(this.f35360f);
        }
    }

    public void setMinVideoDuration(int i2) {
        this.f35359e = i2;
        if (this.f35360f > 0 && this.f35359e > this.f35360f) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        NUADI a2 = a();
        if (a2 != null) {
            a2.setMinVideoDuration(this.f35359e);
        }
    }

    public void setTag(Map map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), this.f35358d);
        } catch (Exception e2) {
            GDTLogger.e("NativeUnifiedAD#setTag Exception");
            e2.printStackTrace();
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name can't be null");
            return;
        }
        this.f35361g = str;
        NUADI a2 = a();
        if (a2 != null) {
            a2.setVastClassName(str);
        }
    }

    @Deprecated
    public void setVideoADContainerRender(int i2) {
    }

    @Deprecated
    public void setVideoPlayPolicy(int i2) {
    }
}
