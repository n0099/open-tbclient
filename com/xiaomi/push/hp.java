package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class hp {
    public static /* synthetic */ Interceptable $ic;
    public static final hp A;
    public static final hp B;
    public static final hp C;
    public static final hp D;
    public static final hp E;
    public static final hp F;
    public static final hp G;
    public static final hp H;
    public static final hp I;
    public static final hp J;
    public static final hp K;
    public static final hp L;
    public static final hp M;
    public static final hp N;
    public static final hp O;
    public static final hp P;
    public static final hp Q;
    public static final hp R;
    public static final hp S;
    public static final hp T;
    public static final hp U;
    public static final hp V;
    public static final hp W;
    public static final hp X;

    /* renamed from: a  reason: collision with root package name */
    public static final hp f77637a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ hp[] f512a;

    /* renamed from: b  reason: collision with root package name */
    public static final hp f77638b;

    /* renamed from: c  reason: collision with root package name */
    public static final hp f77639c;

    /* renamed from: d  reason: collision with root package name */
    public static final hp f77640d;

    /* renamed from: e  reason: collision with root package name */
    public static final hp f77641e;

    /* renamed from: f  reason: collision with root package name */
    public static final hp f77642f;

    /* renamed from: g  reason: collision with root package name */
    public static final hp f77643g;

    /* renamed from: h  reason: collision with root package name */
    public static final hp f77644h;

    /* renamed from: i  reason: collision with root package name */
    public static final hp f77645i;

    /* renamed from: j  reason: collision with root package name */
    public static final hp f77646j;
    public static final hp k;
    public static final hp l;
    public static final hp m;
    public static final hp n;
    public static final hp o;
    public static final hp p;
    public static final hp q;
    public static final hp r;
    public static final hp s;
    public static final hp t;
    public static final hp u;
    public static final hp v;
    public static final hp w;
    public static final hp x;
    public static final hp y;
    public static final hp z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final String f513a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372680, "Lcom/xiaomi/push/hp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372680, "Lcom/xiaomi/push/hp;");
                return;
            }
        }
        f77637a = new hp("Invalid", 0, "INVALID");
        f77638b = new hp("BarClick", 1, "bar:click");
        f77639c = new hp("BarCancel", 2, "bar:cancel");
        f77640d = new hp("AppOpen", 3, "app:open");
        f77641e = new hp("PackageUninstall", 4, "package uninstalled");
        f77642f = new hp("AppUninstall", 5, "app_uninstalled");
        f77643g = new hp("ClientInfoUpdate", 6, "client_info_update");
        f77644h = new hp("ClientInfoUpdateOk", 7, "client_info_update_ok");
        f77645i = new hp("ClientMIIDUpdate", 8, "client_miid_update");
        f77646j = new hp("PullOfflineMessage", 9, "pull");
        k = new hp("IosSleep", 10, "ios_sleep");
        l = new hp("IosWakeUp", 11, "ios_wakeup");
        m = new hp("AwakeApp", 12, "awake_app");
        n = new hp("NormalClientConfigUpdate", 13, "normal_client_config_update");
        o = new hp("CustomClientConfigUpdate", 14, "custom_client_config_update");
        p = new hp("DailyCheckClientConfig", 15, "daily_check_client_config");
        q = new hp("DataCollection", 16, "data_collection");
        r = new hp("RegIdExpired", 17, "registration id expired");
        s = new hp("ConnectionDisabled", 18, "!!!MILINK CONNECTION DISABLED!!!");
        t = new hp("PackageUnregistered", 19, "package_unregistered");
        u = new hp("DecryptMessageFail", 20, "decrypt_msg_fail");
        v = new hp("SyncInfo", 21, "sync_info");
        w = new hp("SyncInfoResult", 22, "sync_info_result");
        x = new hp("ForceSync", 23, "force_sync");
        y = new hp("UploadClientLog", 24, "upload_client_log");
        z = new hp("NotificationBarInfo", 25, "notification_bar_info");
        A = new hp("SyncMIID", 26, "sync_miid");
        B = new hp("UploadTinyData", 27, "upload");
        C = new hp("CancelPushMessage", 28, "clear_push_message");
        D = new hp("CancelPushMessageACK", 29, "clear_push_message_ack");
        E = new hp("DisablePushMessage", 30, "disable_push");
        F = new hp("EnablePushMessage", 31, "enable_push");
        G = new hp("ClientABTest", 32, "client_ab_test");
        H = new hp("AwakeSystemApp", 33, "awake_system_app");
        I = new hp("AwakeAppResponse", 34, "awake_app_response");
        J = new hp("HybridRegister", 35, "hb_register");
        K = new hp("HybridRegisterResult", 36, "hb_register_res");
        L = new hp("HybridUnregister", 37, "hb_unregister");
        M = new hp("HybridUnregisterResult", 38, "hb_unregister_res");
        N = new hp("ThirdPartyRegUpdate", 39, "3rd_party_reg_update");
        O = new hp("VRUpload", 40, "vr_upload");
        P = new hp("PushLogUpload", 41, "log_upload");
        Q = new hp("APP_WAKEUP", 42, "app_wakeup");
        R = new hp("APP_SLEEP", 43, "app_sleep");
        S = new hp("NOTIFICATION_SWITCH", 44, "notification_switch");
        T = new hp("ACTIVITY_RESUMED", 45, "activity_resumed");
        U = new hp("HeadsUpReporter", 46, "headsup_reporter");
        V = new hp("ScenePushRuleUpdate", 47, "scene_push_rule_update");
        W = new hp("ScenePushRuleDelete", 48, "scene_push_rule_delete");
        hp hpVar = new hp("ScenePushRuleTrigger", 49, "scene_push_rule_trigger");
        X = hpVar;
        f512a = new hp[]{f77637a, f77638b, f77639c, f77640d, f77641e, f77642f, f77643g, f77644h, f77645i, f77646j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, hpVar};
    }

    public hp(String str, int i2, String str2) {
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
        this.f513a = str2;
    }

    public static hp valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (hp) Enum.valueOf(hp.class, str) : (hp) invokeL.objValue;
    }

    public static hp[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (hp[]) f512a.clone() : (hp[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f513a : (String) invokeV.objValue;
    }
}
