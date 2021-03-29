package d.b.h0.s.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ICDNProblemUploader;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoSwitchManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.BannerData;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.switchs.CrabSdkSwitch;
import com.baidu.tbadk.switchs.CustomPlayerSwitch;
import com.baidu.tbadk.switchs.FunAdSdkSwitch;
import com.baidu.tbadk.switchs.JPushSdkSwitch;
import com.baidu.tbadk.switchs.LoginPassV6Switch;
import com.baidu.tbadk.switchs.PicReqSwitch;
import com.baidu.tbadk.switchs.StatSdkSwitch;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class r {
    public long i;
    public HashMap<String, Integer> k;
    public String p;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51219f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51220g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f51221h = 100000;
    public int j = 100;
    public boolean m = false;
    public int o = 1;

    /* renamed from: b  reason: collision with root package name */
    public String f51215b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f51216c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f51217d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f51218e = null;

    /* renamed from: a  reason: collision with root package name */
    public final BannerData f51214a = new BannerData();
    public d.b.h0.r.q.r l = new d.b.h0.r.q.r();
    public e0 n = new e0();

    public r() {
        this.k = null;
        this.k = new HashMap<>();
    }

    public final String a(JSONArray jSONArray) throws Exception {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(jSONArray.get(i));
            if (i < length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public int b() {
        return this.j;
    }

    public long c() {
        return this.i;
    }

    public int d() {
        return this.f51221h;
    }

    public e0 e() {
        return this.n;
    }

    public void f(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51214a.parserJson(jSONObject.optJSONObject("banner"));
            this.f51215b = jSONObject.optString("big_head_image_host");
            this.f51216c = jSONObject.optString("small_head_image_host");
            this.f51217d = jSONObject.optString("yijianfankui_fname");
            this.f51218e = jSONObject.optString("yijianfankui_fid");
            this.j = jSONObject.optInt("crash_limit_count", 100);
            int optInt = jSONObject.optInt("app_recommend", -1);
            this.i = jSONObject.optLong("vip_new_task", 0L);
            this.n.b(jSONObject.optJSONObject("webview_checkurl"));
            JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
            if (optJSONObject != null) {
                d.b.h0.u.a.l().w(optJSONObject.optInt("distance", 60));
                d.b.h0.u.a.l().x(optJSONObject.optInt("items_num", 10));
                d.b.h0.u.a.l().y(1 == optJSONObject.optInt("ad_show", 1));
            }
            TbadkCoreApplication.getInst().setYijianfankuiFname(this.f51217d);
            if (this.l == null) {
                this.l = new d.b.h0.r.q.r();
            }
            this.l.h(jSONObject.optString("photo_strategy"));
            if (ICDNProblemUploader.getInstance() != null) {
                ICDNProblemUploader.getInstance().setmCdnLogData(this.l);
            }
            d.b.h0.n.a aVar = new d.b.h0.n.a();
            aVar.a(jSONObject.optJSONObject("photo_cdn_time"));
            if (ICDNIPDirectConnect.getInstance() != null) {
                if (!ICDNIPDirectConnect.getInstance().isAlreadyInit) {
                    ICDNIPDirectConnect.getInstance().init();
                }
                ICDNIPDirectConnect.getInstance().setCDNImageTimeData(aVar);
                ICDNIPDirectConnect.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
            if (optJSONObject2 != null) {
                d.b.i0.c3.o0.a.c(optJSONObject2.optInt("chunk_size"));
                d.b.i0.c3.o0.a.b(optJSONObject2.optInt("block_size"));
                d.b.i0.c3.o0.a.d(optJSONObject2.optInt("data_size"));
            }
            d.b.h0.m0.k.d().i(jSONObject.optLong("small_flow_time_out"));
            TbadkCoreApplication.getInst().setInterviewLivePollingInterval(jSONObject.optLong("interview_pulling_interval"));
            JSONArray optJSONArray = jSONObject.optJSONArray(SetImageWatermarkTypeReqMsg.SWITCH);
            if (optJSONArray != null) {
                int i = 0;
                while (i < optJSONArray.length()) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("name");
                        Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                        jSONArray = optJSONArray;
                        this.k.put(optString, valueOf);
                        if ("netlib_type".equals(optString)) {
                            TbadkCoreApplication.getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                        } else if (LoginPassV6Switch.KEY.equals(optString)) {
                            SwitchManager.getInstance().turn(optString, valueOf.intValue());
                            d.b.h0.s.a.a.a();
                        } else if ("auto_play_video_homepage".equals(optString)) {
                            if (valueOf.intValue() <= 0) {
                                valueOf = 0;
                            }
                            d.b.h0.r.d0.b.i().u("auto_play_video_homepage", valueOf.intValue());
                        } else if ("auto_play_video_frs".equals(optString)) {
                            if (valueOf.intValue() <= 0) {
                                valueOf = 0;
                            }
                            d.b.h0.r.d0.b.i().u("auto_play_video_frs", valueOf.intValue());
                        } else if ("android_safe_sdk_open".equals(optString)) {
                            d.b.h0.r.d0.b.i().u("android_safe_sdk_open", valueOf.intValue());
                        } else if ("android_new_log_upload_switch".equals(optString)) {
                            d.b.h0.r.d0.b.i().u("KEY_LOG_REAL_TIME_UPLOAD_SWITCH", valueOf.intValue());
                        } else if ("android_splash_video_switch".equals(optString)) {
                            d.b.h0.r.d0.b.i().u("key_video_splash_switch", valueOf.intValue());
                        } else if ("android_abtest_channel_switch".equals(optString)) {
                            d.b.h0.r.d0.b.i().u("key_abtest_channel", valueOf.intValue());
                        } else if (CrabSdkSwitch.CRAB_SDK_KEY.equals(optString)) {
                            d.b.h0.r.d0.b.i().u("pref_key_crab_sdk_enable", valueOf.intValue());
                        } else if (BigdaySwitch.BIGDAY_KEY.equals(optString)) {
                            d.b.h0.r.d0.b.i().u("key_bigday_sync_switch", valueOf.intValue());
                        } else if (StatSdkSwitch.STAT_SDK_KEY.equals(optString)) {
                            d.b.h0.r.d0.b.i().u("pref_key_stat_sdk_enable", valueOf.intValue());
                        } else if (JPushSdkSwitch.JPUSH_SDK_KEY.equals(optString)) {
                            d.b.h0.r.d0.b.i().u("pref_key_jpush_sdk_enable", valueOf.intValue());
                        } else if ("lcslog_upload_switch".equals(optString)) {
                            d.b.h0.r.d0.b.i().u("key_lcs_log_switch", valueOf.intValue());
                        } else if ("android_slide_anim_switch".equals(optString)) {
                            d.b.h0.r.d0.b.i().u("sync_slide_animation__switch", valueOf.intValue());
                        } else if ("auto_play_video_homepage_have_4g".equals(optString)) {
                            if (valueOf.intValue() <= 0) {
                                valueOf = 0;
                            }
                            d.b.h0.r.d0.b.i().u("auto_play_video_homepage_have_4g", valueOf.intValue());
                        } else if ("auto_play_video_frs_have_4g".equals(optString)) {
                            if (valueOf.intValue() <= 0) {
                                valueOf = 0;
                            }
                            d.b.h0.r.d0.b.i().u("auto_play_video_frs_have_4g", valueOf.intValue());
                        } else if ("image_header_no_cache_enable".equals(optString)) {
                            d.b.h0.r.d0.b.i().u("image_no_cache_switch", valueOf.intValue());
                        } else if ("profile_usercenter_open".equals(optString)) {
                            d.b.h0.r.d0.b.i().u("key_create_center_entrance_switch", valueOf.intValue());
                        } else if (FunAdSdkSwitch.KEY_SWITCH.equals(optString)) {
                            d.b.h0.r.d0.b.i().u("pref_key_fun_ad_sdk_enable", valueOf.intValue());
                        } else if (PicReqSwitch.PIC_REQ_SWITCH_KEY.equals(optString)) {
                            d.b.h0.r.d0.b.i().u("key_pic_req_switch", valueOf.intValue());
                        }
                    } else {
                        jSONArray = optJSONArray;
                    }
                    i++;
                    optJSONArray = jSONArray;
                }
            }
            if (this.k != null && this.k.size() > 0) {
                SwitchManager.getInstance().refreshSwitchManager(this.k);
            }
            int optInt2 = jSONObject.optInt("force_update_auto_play_video", -1);
            int j = d.b.h0.r.d0.b.i().j("force_update_auto_play_video", 0);
            if (j != 0 && optInt2 >= 1 && optInt2 <= 10 && optInt2 != j) {
                TbConfig.FORCE_UPDATE = true;
            }
            d.b.h0.r.d0.b.i().u("force_update_auto_play_video", optInt2);
            CustomPlayerSwitch.setSwitchStatus(SwitchManager.getInstance().findType(CustomPlayerSwitch.CUSTOM_PLAYER_SWITCH));
            this.f51220g = jSONObject.optInt("is_pushservice_open", 1) == 1;
            TbadkCoreApplication.getInst().setIsPushServiceOpen(this.f51220g);
            if (!this.f51220g) {
                UtilHelper.stopPushService(TbadkCoreApplication.getInst().getApp().getApplicationContext());
            }
            TbadkCoreApplication.getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
            this.f51219f = jSONObject.optInt("gpu_open", 1) == 1;
            TbadkCoreApplication.getInst().setGpuOpen(this.f51219f);
            TbadkCoreApplication.getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
            TbadkCoreApplication.getInst().setHttpAutoSwitch(jSONObject.optInt("http_client_auto", 1) == 1);
            boolean z = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
            this.m = z;
            VoiceManager.setVoiceUseSoftDecoder(z);
            if (TbadkCoreApplication.getInst().getFirstSyncImageQuality()) {
                int optInt3 = jSONObject.optInt("open_abstract", 0);
                if (!(optInt3 == 0 || TbadkCoreApplication.getInst().getIsAbstractStatus() != 0)) {
                    TbadkCoreApplication.getInst().setIsAbstractOn(optInt3);
                }
                TbadkCoreApplication.getInst().setFirstSyncImageQuality(false);
            }
            if (optInt == 1) {
                TbadkCoreApplication.getInst().setIsAppOn(true);
            } else if (optInt == 0) {
                TbadkCoreApplication.getInst().setIsAppOn(false);
            }
            this.f51221h = jSONObject.optInt("perform_sample_param", 100000);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("keepalive");
            if (optJSONObject3 != null) {
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("wifi");
                if (optJSONObject4 != null) {
                    TbadkCoreApplication.getInst().setKeepaliveWifi(optJSONObject4.optInt(SetImageWatermarkTypeReqMsg.SWITCH));
                }
                JSONObject optJSONObject5 = optJSONObject3.optJSONObject("nonwifi");
                if (optJSONObject5 != null) {
                    TbadkCoreApplication.getInst().setKeepaliveNonWifi(optJSONObject5.optInt(SetImageWatermarkTypeReqMsg.SWITCH));
                }
            }
            TbadkCoreApplication.getInst().setHybridBridgeTimeout(jSONObject.optInt("hybrid_bridge_timeout", -1));
            TbadkCoreApplication.getInst().setSocketReconnStratgy(a(jSONObject.optJSONArray("lcsReconStrategy")));
            TbadkCoreApplication.getInst().setSocketHeartBeatStratgy(a(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
            TbadkCoreApplication.getInst().setSocketGetMsgStratgy(a(jSONObject.optJSONArray("imGetMsgStrategy")));
            JSONObject optJSONObject6 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject6 != null) {
                TbadkCoreApplication.getInst().setImTimeOut(new int[]{optJSONObject6.optInt("2gTo", 0) * 1000, optJSONObject6.optInt("3gTo", 0) * 1000, optJSONObject6.optInt("wifiTo", 0) * 1000});
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("imNotifyRecordStrategy");
            d.b.h0.t.e a2 = d.b.h0.t.e.a();
            if (optJSONObject7 != null) {
                a2.b(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
            if (optJSONObject8 != null) {
                this.o = optJSONObject8.optInt("local_dialog_android", 1);
                d.b.h0.r.d0.b.i().u("sync_local_dialog", this.o);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("benchmark");
            if (optJSONObject9 != null) {
                int optInt4 = optJSONObject9.optInt("android_flops_dur", Integer.MAX_VALUE);
                int optInt5 = optJSONObject9.optInt("android_anim_avg_fps", 0);
                TbSingleton.getInstance().setCpuThreshold(optInt4);
                TbSingleton.getInstance().setAnimAverageFpsThreshold(optInt5);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008017));
            TbConfig.setBigPhotoAdress(this.f51215b);
            TbConfig.setSmallPhotoAdress(this.f51216c);
            TbConfig.setFeedBack(this.f51217d, this.f51218e);
            PreLoadVideoSwitchManager.getInstance().setSyncSwitchJson(jSONObject.optString("android_preload_conf"));
            JSONObject optJSONObject10 = jSONObject.optJSONObject("duxiaoman_url");
            if (optJSONObject10 != null) {
                this.p = optJSONObject10.optString("cash_pay");
                d.b.h0.r.d0.b.i().w("baidu_finance", optJSONObject10.optString("finance"));
            }
            if (TextUtils.isEmpty(this.p) && TextUtils.isEmpty(d.b.h0.r.d0.b.i().o("cash_pay", null))) {
                this.p = "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=solely_bdbar_and&hideShare=1";
            }
            if (StringUtils.isNull(this.p)) {
                return;
            }
            d.b.h0.r.d0.b.i().w("cash_pay", this.p);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
