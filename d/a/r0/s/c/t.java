package d.a.r0.s.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.switchs.CsjPrivacySwitch;
import com.baidu.tbadk.switchs.CustomPlayerSwitch;
import com.baidu.tbadk.switchs.FunAdSdkSwitch;
import com.baidu.tbadk.switchs.FunAdServerRecordSwitch;
import com.baidu.tbadk.switchs.GdtPrivacySwitch;
import com.baidu.tbadk.switchs.JPushSdkSwitch;
import com.baidu.tbadk.switchs.KsPrivacySwitch;
import com.baidu.tbadk.switchs.LoginPassV6Switch;
import com.baidu.tbadk.switchs.PicReqSwitch;
import com.baidu.tbadk.switchs.SplashDealyTimeoutSwitch;
import com.baidu.tbadk.switchs.StatSdkSwitch;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BannerData f56440a;

    /* renamed from: b  reason: collision with root package name */
    public String f56441b;

    /* renamed from: c  reason: collision with root package name */
    public String f56442c;

    /* renamed from: d  reason: collision with root package name */
    public String f56443d;

    /* renamed from: e  reason: collision with root package name */
    public String f56444e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56445f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56446g;

    /* renamed from: h  reason: collision with root package name */
    public int f56447h;

    /* renamed from: i  reason: collision with root package name */
    public long f56448i;
    public int j;
    public HashMap<String, Integer> k;
    public d.a.r0.r.q.s l;
    public boolean m;
    public h0 n;
    public int o;
    public String p;

    public t() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56445f = true;
        this.f56446g = true;
        this.f56447h = 100000;
        this.j = 100;
        this.k = null;
        this.m = false;
        this.o = 1;
        this.f56441b = null;
        this.f56442c = null;
        this.f56443d = null;
        this.f56444e = null;
        this.f56440a = new BannerData();
        this.k = new HashMap<>();
        this.l = new d.a.r0.r.q.s();
        this.n = new h0();
    }

    public final String a(JSONArray jSONArray) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(jSONArray.get(i2));
                if (i2 < length - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : invokeV.intValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56448i : invokeV.longValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56447h : invokeV.intValue;
    }

    public h0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (h0) invokeV.objValue;
    }

    public void f(JSONObject jSONObject) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f56440a.parserJson(jSONObject.optJSONObject("banner"));
            this.f56441b = jSONObject.optString("big_head_image_host");
            this.f56442c = jSONObject.optString("small_head_image_host");
            this.f56443d = jSONObject.optString("yijianfankui_fname");
            this.f56444e = jSONObject.optString("yijianfankui_fid");
            this.j = jSONObject.optInt("crash_limit_count", 100);
            int optInt = jSONObject.optInt("app_recommend", -1);
            this.f56448i = jSONObject.optLong("vip_new_task", 0L);
            this.n.b(jSONObject.optJSONObject("webview_checkurl"));
            JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
            if (optJSONObject != null) {
                d.a.r0.u.a.k().u(optJSONObject.optInt("distance", 60));
                d.a.r0.u.a.k().v(optJSONObject.optInt("items_num", 10));
                d.a.r0.u.a.k().w(1 == optJSONObject.optInt("ad_show", 1));
            }
            TbadkCoreApplication.getInst().setYijianfankuiFname(this.f56443d);
            if (this.l == null) {
                this.l = new d.a.r0.r.q.s();
            }
            this.l.h(jSONObject.optString("photo_strategy"));
            if (ICDNProblemUploader.getInstance() != null) {
                ICDNProblemUploader.getInstance().setmCdnLogData(this.l);
            }
            d.a.r0.n.a aVar = new d.a.r0.n.a();
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
                d.a.s0.h3.o0.a.c(optJSONObject2.optInt("chunk_size"));
                d.a.s0.h3.o0.a.b(optJSONObject2.optInt("block_size"));
                d.a.s0.h3.o0.a.d(optJSONObject2.optInt("data_size"));
            }
            d.a.r0.m0.k.d().i(jSONObject.optLong("small_flow_time_out"));
            TbadkCoreApplication.getInst().setInterviewLivePollingInterval(jSONObject.optLong("interview_pulling_interval"));
            JSONArray optJSONArray = jSONObject.optJSONArray(SetImageWatermarkTypeReqMsg.SWITCH);
            if (optJSONArray != null) {
                int i2 = 0;
                while (i2 < optJSONArray.length()) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("name");
                        Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                        jSONArray = optJSONArray;
                        this.k.put(optString, valueOf);
                        if ("netlib_type".equals(optString)) {
                            TbadkCoreApplication.getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                        } else if (LoginPassV6Switch.KEY.equals(optString)) {
                            SwitchManager.getInstance().turn(optString, valueOf.intValue());
                            d.a.r0.s.a.a.a();
                        } else if ("auto_play_video_homepage".equals(optString)) {
                            if (valueOf.intValue() <= 0) {
                                valueOf = 0;
                            }
                            d.a.r0.r.d0.b.j().v("auto_play_video_homepage", valueOf.intValue());
                        } else if ("auto_play_video_frs".equals(optString)) {
                            if (valueOf.intValue() <= 0) {
                                valueOf = 0;
                            }
                            d.a.r0.r.d0.b.j().v("auto_play_video_frs", valueOf.intValue());
                        } else if ("android_safe_sdk_open".equals(optString)) {
                            d.a.r0.r.d0.b.j().v("android_safe_sdk_open", valueOf.intValue());
                        } else if ("android_new_log_upload_switch".equals(optString)) {
                            d.a.r0.r.d0.b.j().v("KEY_LOG_REAL_TIME_UPLOAD_SWITCH", valueOf.intValue());
                        } else if ("android_splash_video_switch".equals(optString)) {
                            d.a.r0.r.d0.b.j().v("key_video_splash_switch", valueOf.intValue());
                        } else if ("android_abtest_channel_switch".equals(optString)) {
                            d.a.r0.r.d0.b.j().v("key_abtest_channel", valueOf.intValue());
                        } else if (CrabSdkSwitch.CRAB_SDK_KEY.equals(optString)) {
                            d.a.r0.r.d0.b.j().v("pref_key_crab_sdk_enable", valueOf.intValue());
                        } else if (BigdaySwitch.BIGDAY_KEY.equals(optString)) {
                            d.a.r0.r.d0.b.j().v("key_bigday_sync_switch", valueOf.intValue());
                        } else if (StatSdkSwitch.STAT_SDK_KEY.equals(optString)) {
                            d.a.r0.r.d0.b.j().v("pref_key_stat_sdk_enable", valueOf.intValue());
                        } else if (JPushSdkSwitch.JPUSH_SDK_KEY.equals(optString)) {
                            d.a.r0.r.d0.b.j().v("pref_key_jpush_sdk_enable", valueOf.intValue());
                        } else if ("lcslog_upload_switch".equals(optString)) {
                            d.a.r0.r.d0.b.j().v("key_lcs_log_switch", valueOf.intValue());
                        } else if ("android_slide_anim_switch".equals(optString)) {
                            d.a.r0.r.d0.b.j().v("sync_slide_animation__switch", valueOf.intValue());
                        } else if ("auto_play_video_homepage_have_4g".equals(optString)) {
                            if (valueOf.intValue() <= 0) {
                                valueOf = 0;
                            }
                            d.a.r0.r.d0.b.j().v("auto_play_video_homepage_have_4g", valueOf.intValue());
                        } else if ("auto_play_video_frs_have_4g".equals(optString)) {
                            if (valueOf.intValue() <= 0) {
                                valueOf = 0;
                            }
                            d.a.r0.r.d0.b.j().v("auto_play_video_frs_have_4g", valueOf.intValue());
                        } else if ("image_header_no_cache_enable".equals(optString)) {
                            d.a.r0.r.d0.b.j().v("image_no_cache_switch", valueOf.intValue());
                        } else if ("profile_usercenter_open".equals(optString)) {
                            d.a.r0.r.d0.b.j().v("key_create_center_entrance_switch", valueOf.intValue());
                        } else if (FunAdSdkSwitch.KEY_SWITCH.equals(optString)) {
                            d.a.r0.r.d0.b.j().v("pref_key_fun_ad_sdk_enable", valueOf.intValue());
                        } else if (PicReqSwitch.PIC_REQ_SWITCH_KEY.equals(optString)) {
                            d.a.r0.r.d0.b.j().v("key_pic_req_switch", valueOf.intValue());
                        } else if (SplashDealyTimeoutSwitch.KEY_SWITCH.equals(optString)) {
                            d.a.r0.r.d0.b.j().v("pref_key_splash_timeout_enable", valueOf.intValue());
                        } else if (FunAdServerRecordSwitch.KEY_SWITCH.equals(optString)) {
                            d.a.r0.r.d0.b.j().v("pref_key_fun_ad_server_record_enable", valueOf.intValue());
                        } else if (GdtPrivacySwitch.KEY_SWITCH.equals(optString)) {
                            d.a.r0.r.d0.b.j().v("pref_key_splash_gdt_privacy_enable", valueOf.intValue());
                        } else if (CsjPrivacySwitch.KEY_SWITCH.equals(optString)) {
                            d.a.r0.r.d0.b.j().v("pref_key_splash_csj_privacy_enable", valueOf.intValue());
                        } else if (KsPrivacySwitch.KEY_SWITCH.equals(optString)) {
                            d.a.r0.r.d0.b.j().v("pref_key_splash_ks_privacy_enable", valueOf.intValue());
                        }
                    } else {
                        jSONArray = optJSONArray;
                    }
                    i2++;
                    optJSONArray = jSONArray;
                }
            }
            if (this.k != null && this.k.size() > 0) {
                SwitchManager.getInstance().refreshSwitchManager(this.k);
            }
            int optInt2 = jSONObject.optInt("force_update_auto_play_video", -1);
            int k = d.a.r0.r.d0.b.j().k("force_update_auto_play_video", 0);
            if (k != 0 && optInt2 >= 1 && optInt2 <= 10 && optInt2 != k) {
                TbConfig.FORCE_UPDATE = true;
            }
            d.a.r0.r.d0.b.j().v("force_update_auto_play_video", optInt2);
            CustomPlayerSwitch.setSwitchStatus(SwitchManager.getInstance().findType(CustomPlayerSwitch.CUSTOM_PLAYER_SWITCH));
            this.f56446g = jSONObject.optInt("is_pushservice_open", 1) == 1;
            TbadkCoreApplication.getInst().setIsPushServiceOpen(this.f56446g);
            if (!this.f56446g) {
                UtilHelper.stopPushService(TbadkCoreApplication.getInst().getApp().getApplicationContext());
            }
            TbadkCoreApplication.getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
            this.f56445f = jSONObject.optInt("gpu_open", 1) == 1;
            TbadkCoreApplication.getInst().setGpuOpen(this.f56445f);
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
            this.f56447h = jSONObject.optInt("perform_sample_param", 100000);
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
            d.a.r0.t.f a2 = d.a.r0.t.f.a();
            if (optJSONObject7 != null) {
                a2.b(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
            if (optJSONObject8 != null) {
                this.o = optJSONObject8.optInt("local_dialog_android", 1);
                d.a.r0.r.d0.b.j().v("sync_local_dialog", this.o);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("benchmark");
            if (optJSONObject9 != null) {
                int optInt4 = optJSONObject9.optInt("android_flops_dur", Integer.MAX_VALUE);
                int optInt5 = optJSONObject9.optInt("android_anim_avg_fps", 0);
                TbSingleton.getInstance().setCpuThreshold(optInt4);
                TbSingleton.getInstance().setAnimAverageFpsThreshold(optInt5);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008017));
            TbConfig.setBigPhotoAdress(this.f56441b);
            TbConfig.setSmallPhotoAdress(this.f56442c);
            TbConfig.setFeedBack(this.f56443d, this.f56444e);
            PreLoadVideoSwitchManager.getInstance().setSyncSwitchJson(jSONObject.optString("android_preload_conf"));
            JSONObject optJSONObject10 = jSONObject.optJSONObject("duxiaoman_url");
            if (optJSONObject10 != null) {
                this.p = optJSONObject10.optString("cash_pay");
                d.a.r0.r.d0.b.j().x("baidu_finance", optJSONObject10.optString("finance"));
            }
            if (TextUtils.isEmpty(this.p) && TextUtils.isEmpty(d.a.r0.r.d0.b.j().p("cash_pay", null))) {
                this.p = "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=solely_bdbar_and&hideShare=1";
            }
            if (StringUtils.isNull(this.p)) {
                return;
            }
            d.a.r0.r.d0.b.j().x("cash_pay", this.p);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
