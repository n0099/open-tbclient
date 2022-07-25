package com.xiaomi.push;

import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class ht {
    public static /* synthetic */ Interceptable $ic;
    public static final ht A;
    public static final ht B;
    public static final ht C;
    public static final ht D;
    public static final ht E;
    public static final ht F;
    public static final ht G;
    public static final ht H;
    public static final ht I;
    public static final ht J;
    public static final ht K;
    public static final ht L;
    public static final ht M;
    public static final ht N;
    public static final ht O;
    public static final ht P;
    public static final ht Q;
    public static final ht R;
    public static final ht S;
    public static final ht T;
    public static final ht U;
    public static final ht V;
    public static final ht W;
    public static final ht X;
    public static final ht Y;
    public static final ht Z;
    public static final ht a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ ht[] f504a;
    public static final ht aa;
    public static final ht ab;
    public static final ht ac;
    public static final ht ad;
    public static final ht ae;
    public static final ht af;
    public static final ht ag;
    public static final ht b;
    public static final ht c;
    public static final ht d;
    public static final ht e;
    public static final ht f;
    public static final ht g;
    public static final ht h;
    public static final ht i;
    public static final ht j;
    public static final ht k;
    public static final ht l;
    public static final ht m;
    public static final ht n;
    public static final ht o;
    public static final ht p;
    public static final ht q;
    public static final ht r;
    public static final ht s;
    public static final ht t;
    public static final ht u;
    public static final ht v;
    public static final ht w;
    public static final ht x;
    public static final ht y;
    public static final ht z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final String f505a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372556, "Lcom/xiaomi/push/ht;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372556, "Lcom/xiaomi/push/ht;");
                return;
            }
        }
        a = new ht("Invalid", 0, "INVALID");
        b = new ht("BarClick", 1, "bar:click");
        c = new ht("BarCancel", 2, "bar:cancel");
        d = new ht("AppOpen", 3, "app:open");
        e = new ht("PackageUninstall", 4, "package uninstalled");
        f = new ht("AppUninstall", 5, "app_uninstalled");
        g = new ht("ClientInfoUpdate", 6, "client_info_update");
        h = new ht("ClientInfoUpdateOk", 7, "client_info_update_ok");
        i = new ht("ClientMIIDUpdate", 8, "client_miid_update");
        j = new ht("PullOfflineMessage", 9, "pull");
        k = new ht("IosSleep", 10, "ios_sleep");
        l = new ht("IosWakeUp", 11, "ios_wakeup");
        m = new ht("AwakeApp", 12, "awake_app");
        n = new ht("NormalClientConfigUpdate", 13, "normal_client_config_update");
        o = new ht("CustomClientConfigUpdate", 14, "custom_client_config_update");
        p = new ht("DailyCheckClientConfig", 15, "daily_check_client_config");
        q = new ht("DataCollection", 16, "data_collection");
        r = new ht("RegIdExpired", 17, "registration id expired");
        s = new ht("ConnectionDisabled", 18, "!!!MILINK CONNECTION DISABLED!!!");
        t = new ht("PackageUnregistered", 19, "package_unregistered");
        u = new ht("DecryptMessageFail", 20, "decrypt_msg_fail");
        v = new ht("SyncInfo", 21, NativeConstants.SYNC_INFO);
        w = new ht("SyncInfoResult", 22, "sync_info_result");
        x = new ht("ForceSync", 23, "force_sync");
        y = new ht("UploadClientLog", 24, "upload_client_log");
        z = new ht("NotificationBarInfo", 25, "notification_bar_info");
        A = new ht("SyncMIID", 26, "sync_miid");
        B = new ht("UploadTinyData", 27, StatConstants.VALUE_TYPE_UPLOAD);
        C = new ht("CancelPushMessage", 28, "clear_push_message");
        D = new ht("CancelPushMessageACK", 29, "clear_push_message_ack");
        E = new ht("DisablePushMessage", 30, "disable_push");
        F = new ht("EnablePushMessage", 31, "enable_push");
        G = new ht("ClientABTest", 32, "client_ab_test");
        H = new ht("AwakeSystemApp", 33, "awake_system_app");
        I = new ht("AwakeAppResponse", 34, "awake_app_response");
        J = new ht("HybridRegister", 35, "hb_register");
        K = new ht("HybridRegisterResult", 36, "hb_register_res");
        L = new ht("HybridUnregister", 37, "hb_unregister");
        M = new ht("HybridUnregisterResult", 38, "hb_unregister_res");
        N = new ht("ThirdPartyRegUpdate", 39, "3rd_party_reg_update");
        O = new ht("VRUpload", 40, "vr_upload");
        P = new ht("PushLogUpload", 41, "log_upload");
        Q = new ht("APP_WAKEUP", 42, "app_wakeup");
        R = new ht("APP_SLEEP", 43, "app_sleep");
        S = new ht("NOTIFICATION_SWITCH", 44, "notification_switch");
        T = new ht("ACTIVITY_RESUMED", 45, "activity_resumed");
        U = new ht("HeadsUpReporter", 46, "headsup_reporter");
        V = new ht("ScenePushRuleUpdate", 47, "scene_push_rule_update");
        W = new ht("ScenePushRuleDelete", 48, "scene_push_rule_delete");
        X = new ht("ScenePushRuleTrigger", 49, "scene_push_rule_trigger");
        Y = new ht("NotificationRemoved", 50, "notification_removed");
        Z = new ht("NotificationArrived", 51, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_ARRIVED);
        aa = new ht("NotificationClicked", 52, "notification_clicked");
        ab = new ht("PullDownPop", 53, "pull_down_pop");
        ac = new ht("AppDataCleared", 54, "app_data_cleared");
        ad = new ht("TtsReporter", 55, "tts_data_reporter");
        ae = new ht("SDK_START_ACTIVITY", 56, "sdk_start_activity");
        af = new ht("DetectAppAlive", 57, "detect_app_alive");
        ht htVar = new ht("DetectAppAliveResult", 58, "detect_app_alive_result");
        ag = htVar;
        f504a = new ht[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, htVar};
    }

    public ht(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f505a = str2;
    }

    public static ht valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ht) Enum.valueOf(ht.class, str) : (ht) invokeL.objValue;
    }

    public static ht[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ht[]) f504a.clone() : (ht[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f505a : (String) invokeV.objValue;
    }
}
