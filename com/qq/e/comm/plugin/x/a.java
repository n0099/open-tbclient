package com.qq.e.comm.plugin.x;

import android.content.Context;
import android.os.Build;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.t.b;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.al;
import com.qq.e.comm.plugin.util.av;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.services.RetCodeService;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
public class a {
    private ExecutorService e = Executors.newSingleThreadExecutor();
    private AtomicLong f = new AtomicLong();
    private int g = 69;
    private long h = 0;
    private long i = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final String f12987b = String.format("http://%s/%s", "sdk.e.qq.com", IMTrack.DbBuilder.ACTION_UPDATE);

    /* renamed from: a  reason: collision with root package name */
    public static String f12986a = "";
    private static String c = "";
    private static final a d = new a();

    /* renamed from: com.qq.e.comm.plugin.x.a$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(a.this);
            a.b(a.this);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.x.a$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ JSONObject f12989a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f12990b;

        AnonymousClass2(JSONObject jSONObject, boolean z) {
            this.f12989a = jSONObject;
            this.f12990b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(a.this, this.f12989a, this.f12990b);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.x.a$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass3 implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f12991a;

        AnonymousClass3(long j) {
            this.f12991a = j;
        }

        @Override // com.qq.e.comm.plugin.t.b
        public void a(e eVar, f fVar) {
            try {
                if (fVar.e() == 200) {
                    String d = fVar.d();
                    GDTLogger.d("Config response:" + d);
                    if (StringUtil.isEmpty(d)) {
                        GDTLogger.report("SDK Server response empty string, maybe zip or tea format error");
                    } else {
                        a.a(a.this, new JSONObject(d));
                    }
                } else {
                    GDTLogger.e("SDK server response code error while launch or activate, code:" + fVar.e());
                }
            } catch (JSONException e) {
                GDTLogger.e("Parse config response exception", e);
            } catch (IOException e2) {
                GDTLogger.e("Config request error", e2);
            } finally {
                RetCodeService.getInstance().send(new RetCodeService.RetCodeInfo("sdk.e.qq.com", IMTrack.DbBuilder.ACTION_UPDATE, "", fVar.e(), (int) (System.currentTimeMillis() - this.f12991a), 0, 0, 1));
            }
        }

        @Override // com.qq.e.comm.plugin.t.b
        public void a(Exception exc) {
            GDTLogger.e("Config request error: ", exc);
            RetCodeService.getInstance().send(new RetCodeService.RetCodeInfo("sdk.e.qq.com", IMTrack.DbBuilder.ACTION_UPDATE, "", -1, (int) (System.currentTimeMillis() - this.f12991a), 0, 0, 1));
        }
    }

    /* renamed from: com.qq.e.comm.plugin.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C1185a {
        public static JSONObject a(PM pm) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("sdkv", SDKStatus.getSDKVersion());
            jSONObject.putOpt("pv", Integer.valueOf(pm.getPluginVersion()));
            jSONObject.putOpt("sdk_st", Integer.valueOf(aj.a()));
            jSONObject.putOpt("sdk_pt", 1);
            return jSONObject;
        }

        public static JSONObject a(SM sm) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            if (sm != null) {
                jSONObject.putOpt("suid", sm.getSuid());
                jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_SID, sm.getSid());
            }
            return jSONObject;
        }

        public static JSONObject a(SM sm, PM pm) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            if (sm != null) {
                jSONObject.putOpt("app", sm.getDevCloudSettingSig());
                jSONObject.putOpt(CashierData.SDK, sm.getSdkCloudSettingSig());
            }
            if (pm != null) {
                jSONObject.putOpt("jar", pm.getLocalSig());
                jSONObject.putOpt(Constants.KEYS.PLUGIN_VERSION, Integer.valueOf(pm.getPluginVersion()));
            }
            return jSONObject;
        }

        public static JSONObject a(APPStatus aPPStatus) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            if (aPPStatus != null) {
                jSONObject.putOpt("an", aPPStatus.getAPPName());
                jSONObject.putOpt("appkey", aPPStatus.getAPPID());
                jSONObject.putOpt("appv", aPPStatus.getAPPVersion());
                jSONObject.putOpt("appn", aPPStatus.getAPPRealName());
            }
            return jSONObject;
        }

        public static JSONObject a(DeviceStatus deviceStatus) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            if (deviceStatus != null) {
                jSONObject.putOpt("so", deviceStatus.getScreenOrientation());
                jSONObject.putOpt(Config.DEVICE_NAME, deviceStatus.getDataNet());
                String a2 = ab.a();
                if (!StringUtil.isEmpty(a2)) {
                    jSONObject.putOpt("cell_native", a2);
                }
                jSONObject.putOpt("lat", deviceStatus.getLat());
                jSONObject.putOpt("lng", deviceStatus.getLng());
                for (Map.Entry<String, String> entry : deviceStatus.getLacAndCeilId().entrySet()) {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                }
            }
            return jSONObject;
        }

        public static JSONObject a(DeviceStatus deviceStatus, Context context) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            if (deviceStatus != null) {
                String b2 = o.b();
                if (b2 == null) {
                    b2 = "";
                }
                jSONObject.putOpt("did", b2);
                SM sm = GDTADManager.getInstance().getSM();
                if (sm != null && 1 == sm.getInteger("support_servers_upload_qadid", 0)) {
                    jSONObject.putOpt("qaid", al.a(context));
                }
                jSONObject.putOpt(IXAdRequestInfo.TEST_MODE, deviceStatus.model);
                jSONObject.putOpt("lg", deviceStatus.getLanguage());
                jSONObject.putOpt("w", Integer.valueOf(deviceStatus.getDeviceWidth()));
                jSONObject.putOpt("h", Integer.valueOf(deviceStatus.getDeviceHeight()));
                jSONObject.putOpt(Config.DEVICE_ID_SEC, Integer.valueOf(deviceStatus.getDeviceDensity()));
                jSONObject.putOpt("apil", Integer.valueOf(deviceStatus.getVersion()));
                jSONObject.putOpt("os", deviceStatus.getOS());
                jSONObject.putOpt("op", deviceStatus.getOperator());
                jSONObject.putOpt("mf", Build.MANUFACTURER);
                av.a(jSONObject, "/update");
            }
            return jSONObject;
        }
    }

    public static a a() {
        return (a) gdtadv.getobjresult(173, 1, new Object[0]);
    }

    private String a(SM sm, PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, Context context) {
        return (String) gdtadv.getobjresult(174, 0, this, sm, pm, deviceStatus, aPPStatus, context);
    }

    static /* synthetic */ void a(a aVar) {
        gdtadv.getVresult(175, 1, aVar);
    }

    static /* synthetic */ void a(a aVar, JSONObject jSONObject) {
        gdtadv.getVresult(Opcodes.ARETURN, 1, aVar, jSONObject);
    }

    static /* synthetic */ void a(a aVar, JSONObject jSONObject, boolean z) {
        gdtadv.getVresult(Opcodes.RETURN, 1, aVar, jSONObject, Boolean.valueOf(z));
    }

    private void a(String str) {
        gdtadv.getVresult(Opcodes.GETSTATIC, 0, this, str);
    }

    private void a(String str, String str2) {
        gdtadv.getVresult(179, 0, this, str, str2);
    }

    private void a(JSONObject jSONObject) {
        gdtadv.getVresult(180, 0, this, jSONObject);
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2) {
        gdtadv.getVresult(Opcodes.PUTFIELD, 0, this, jSONObject, jSONObject2);
    }

    private void a(JSONObject jSONObject, boolean z) {
        gdtadv.getVresult(Opcodes.INVOKEVIRTUAL, 0, this, jSONObject, Boolean.valueOf(z));
    }

    private static boolean a(Context context, String str, String str2) {
        return gdtadv.getZresult(183, 1, context, str, str2);
    }

    private void b(int i) {
        gdtadv.getVresult(Opcodes.INVOKESTATIC, 0, this, Integer.valueOf(i));
    }

    static /* synthetic */ void b(a aVar) {
        gdtadv.getVresult(185, 1, aVar);
    }

    private void b(String str) {
        gdtadv.getVresult(186, 0, this, str);
    }

    private void b(String str, String str2) {
        gdtadv.getVresult(Opcodes.NEW, 0, this, str, str2);
    }

    private void b(JSONObject jSONObject) {
        gdtadv.getVresult(Opcodes.NEWARRAY, 0, this, jSONObject);
    }

    private void b(JSONObject jSONObject, boolean z) {
        gdtadv.getVresult(189, 0, this, jSONObject, Boolean.valueOf(z));
    }

    private void c(int i) {
        gdtadv.getVresult(190, 0, this, Integer.valueOf(i));
    }

    private void c(String str) {
        gdtadv.getVresult(191, 0, this, str);
    }

    private void c(String str, String str2) {
        gdtadv.getVresult(192, 0, this, str, str2);
    }

    private void d(String str) {
        gdtadv.getVresult(193, 0, this, str);
    }

    private boolean d(int i) {
        return gdtadv.getZresult(DownloadConstants.STATUS_WAITING_TO_RETRY, 0, this, Integer.valueOf(i));
    }

    private void e(String str) {
        gdtadv.getVresult(DownloadConstants.STATUS_WAITING_FOR_NETWORK, 0, this, str);
    }

    private void f() {
        gdtadv.getVresult(196, 0, this);
    }

    private void g() {
        gdtadv.getVresult(com.baidu.android.imsdk.internal.Constants.METHOD_IM_DELIVER_CONFIG_MSG, 0, this);
    }

    private void h() {
        gdtadv.getVresult(Opcodes.IFNULL, 0, this);
    }

    private void i() {
        gdtadv.getVresult(Opcodes.IFNONNULL, 0, this);
    }

    private void j() {
        gdtadv.getVresult(200, 0, this);
    }

    private long k() {
        return gdtadv.getJresult(201, 0, this);
    }

    private int l() {
        return gdtadv.getIresult(202, 0, this);
    }

    public void a(int i) {
        gdtadv.getVresult(203, 0, this, Integer.valueOf(i));
    }

    public void a(int i, String str) {
        gdtadv.getVresult(204, 0, this, Integer.valueOf(i), str);
    }

    public void b() {
        gdtadv.getVresult(205, 0, this);
    }

    public boolean c() {
        return gdtadv.getZresult(206, 0, this);
    }

    public long d() {
        return gdtadv.getJresult(207, 0, this);
    }

    public long e() {
        return gdtadv.getJresult(208, 0, this);
    }
}
