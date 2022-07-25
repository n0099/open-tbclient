package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class ho {
    public static /* synthetic */ Interceptable $ic;
    public static final ho A;
    public static final ho B;
    public static final ho C;
    public static final ho D;
    public static final ho E;
    public static final ho F;
    public static final ho G;
    public static final ho H;
    public static final ho I;
    public static final ho J;
    public static final ho K;
    public static final ho L;
    public static final ho M;
    public static final ho N;
    public static final ho O;
    public static final ho P;
    public static final ho Q;
    public static final ho R;
    public static final ho S;
    public static final ho T;
    public static final ho U;
    public static final ho V;
    public static final ho W;
    public static final ho X;
    public static final ho Y;
    public static final ho Z;
    public static final ho a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ ho[] f488a;
    public static final ho aA;
    public static final ho aB;
    public static final ho aC;
    public static final ho aD;
    public static final ho aE;
    public static final ho aF;
    public static final ho aG;
    public static final ho aH;
    public static final ho aI;
    public static final ho aJ;
    public static final ho aK;
    public static final ho aL;
    public static final ho aM;
    public static final ho aN;
    public static final ho aO;
    public static final ho aP;
    public static final ho aQ;
    public static final ho aR;
    public static final ho aS;
    public static final ho aT;
    public static final ho aU;
    public static final ho aV;
    public static final ho aW;
    public static final ho aX;
    public static final ho aY;
    public static final ho aZ;
    public static final ho aa;
    public static final ho ab;
    public static final ho ac;
    public static final ho ad;
    public static final ho ae;
    public static final ho af;
    public static final ho ag;
    public static final ho ah;
    public static final ho ai;
    public static final ho aj;
    public static final ho ak;
    public static final ho al;
    public static final ho am;
    public static final ho an;
    public static final ho ao;
    public static final ho ap;
    public static final ho aq;
    public static final ho ar;
    public static final ho as;
    public static final ho at;
    public static final ho au;
    public static final ho av;
    public static final ho aw;
    public static final ho ax;
    public static final ho ay;
    public static final ho az;
    public static final ho b;
    public static final ho ba;
    public static final ho bb;
    public static final ho bc;
    public static final ho bd;
    public static final ho be;
    public static final ho bf;
    public static final ho bg;
    public static final ho bh;
    public static final ho bi;
    public static final ho bj;
    public static final ho bk;
    public static final ho bl;
    public static final ho bm;
    public static final ho bn;
    public static final ho bo;
    public static final ho bp;
    public static final ho bq;
    public static final ho br;
    public static final ho bs;
    public static final ho bt;
    public static final ho bu;
    public static final ho bv;
    public static final ho c;
    public static final ho d;
    public static final ho e;
    public static final ho f;
    public static final ho g;
    public static final ho h;
    public static final ho i;
    public static final ho j;
    public static final ho k;
    public static final ho l;
    public static final ho m;
    public static final ho n;
    public static final ho o;
    public static final ho p;
    public static final ho q;
    public static final ho r;
    public static final ho s;
    public static final ho t;
    public static final ho u;
    public static final ho v;
    public static final ho w;
    public static final ho x;
    public static final ho y;
    public static final ho z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final int f489a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372711, "Lcom/xiaomi/push/ho;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372711, "Lcom/xiaomi/push/ho;");
                return;
            }
        }
        a = new ho("UploadSwitch", 0, 1);
        b = new ho("UploadFrequency", 1, 2);
        c = new ho("ScreenSizeCollectionSwitch", 2, 3);
        d = new ho("MacCollectionSwitch", 3, 4);
        e = new ho("IMSICollectionSwitch", 4, 5);
        f = new ho("AndroidVnCollectionSwitch", 5, 6);
        g = new ho("AndroidVcCollectionSwitch", 6, 7);
        h = new ho("AndroidIdCollectionSwitch", 7, 8);
        i = new ho("DeviceInfoCollectionFrequency", 8, 9);
        j = new ho("AppInstallListCollectionSwitch", 9, 10);
        k = new ho("AppInstallListCollectionFrequency", 10, 11);
        l = new ho("AppActiveListCollectionSwitch", 11, 12);
        m = new ho("AppActiveListCollectionFrequency", 12, 13);
        n = new ho("BluetoothCollectionSwitch", 13, 14);
        o = new ho("BluetoothCollectionFrequency", 14, 15);
        p = new ho("LocationCollectionSwitch", 15, 16);
        q = new ho("LocationCollectionFrequency", 16, 17);
        r = new ho("AccountCollectionSwitch", 17, 18);
        s = new ho("AccountCollectionFrequency", 18, 19);
        t = new ho("WifiCollectionSwitch", 19, 20);
        u = new ho("WifiCollectionFrequency", 20, 21);
        v = new ho("CellularCollectionSwitch", 21, 22);
        w = new ho("CellularCollectionFrequency", 22, 23);
        x = new ho("TopAppCollectionSwitch", 23, 24);
        y = new ho("TopAppCollectionFrequency", 24, 25);
        z = new ho("DataCollectionSwitch", 25, 26);
        A = new ho("OcVersionCheckFrequency", 26, 27);
        B = new ho("SyncInfoFrequency", 27, 28);
        C = new ho("UploadNotificationInfoFrequency", 28, 29);
        D = new ho("UploadNotificationInfoMaxNum", 29, 30);
        E = new ho("CollectionNotificationInfoBaseSwitch", 30, 31);
        F = new ho("CollectionNotificationInfoAppSwitch", 31, 32);
        G = new ho("CollectionNotificationInfoRemovedSwitch", 32, 33);
        H = new ho("ForegroundServiceSwitch", 33, 34);
        I = new ho("SyncMIIDFrequency", 34, 35);
        J = new ho("Upload4GSwitch", 35, 36);
        K = new ho("Upload4GFrequency", 36, 37);
        L = new ho("Upload3GSwitch", 37, 38);
        M = new ho("Upload3GFrequency", 38, 39);
        N = new ho("ShieldTypeConfig", 39, 40);
        O = new ho("UploadWIFIGeoLocFrequency", 40, 41);
        P = new ho("UploadNOWIFIGeoLocFrequency", 41, 42);
        Q = new ho("BroadcastActionCollectionSwitch", 42, 43);
        R = new ho("BroadcastActionCollectionFrequency", 43, 44);
        S = new ho("UploadGeoLocSwitch", 44, 45);
        T = new ho("ServiceBootMode", 45, 46);
        U = new ho("AppPermissionCollectionSwitch", 46, 47);
        V = new ho("AppPermissionCollectionFrequency", 47, 48);
        W = new ho("WifiDevicesMacCollectionSwitch", 48, 49);
        X = new ho("WifiDevicesMacCollectionFrequency", 49, 50);
        Y = new ho("WifiDevicesMacWifiUnchangedCollectionFrequency", 50, 51);
        Z = new ho("AggregationSdkMonitorSwitch", 51, 52);
        aa = new ho("AggregationSdkMonitorFrequency", 52, 53);
        ab = new ho("AggregationSdkMonitorDepth", 53, 54);
        ac = new ho("UploadGeoAppLocSwitch", 54, 55);
        ad = new ho("ThirdPushControlSwitch", 55, 56);
        ae = new ho("ThirdPushComponentKeyWords", 56, 57);
        af = new ho("ThirdPushWhiteList", 57, 58);
        ag = new ho("XmsfScanWhitelist", 58, 59);
        ah = new ho("IccidCollectionSwitch", 59, 60);
        ai = new ho("LimitThridPushStrategyMode", 60, 61);
        aj = new ho("GlobalPushChannelException", 61, 62);
        ak = new ho("TinyDataUploadSwitch", 62, 63);
        al = new ho("TinyDataUploadFrequency", 63, 64);
        am = new ho("GlobalRegionIOSwitch", 64, 65);
        an = new ho("GlobalRegionIOWait", 65, 66);
        ao = new ho("AggregatePushSwitch", 66, 67);
        ap = new ho("ActivityTSSwitch", 67, 68);
        aq = new ho("OperatorSwitch", 68, 69);
        ar = new ho("DeviceIdSwitch", 69, 70);
        as = new ho("DeviceBaseInfoCollectionFrequency", 70, 71);
        at = new ho("UsageStatsCollectionFrequency", 71, 72);
        au = new ho("UsageStatsCollectionWhiteList", 72, 73);
        av = new ho("ForceHandleCrashSwitch", 73, 74);
        aw = new ho("Crash4GUploadSwitch", 74, 75);
        ax = new ho("Crash4GUploadFrequency", 75, 76);
        ay = new ho("CrashWIFIUploadFrequency", 76, 77);
        az = new ho("EventUploadSwitch", 77, 78);
        aA = new ho("PerfUploadSwitch", 78, 79);
        aB = new ho("EventUploadFrequency", 79, 80);
        aC = new ho("PerfUploadFrequency", 80, 81);
        aD = new ho("BatteryCollectionSwitch", 81, 82);
        aE = new ho("BatteryCollectionFrequency", 82, 83);
        aF = new ho("AwakeInfoUploadWaySwitch", 83, 84);
        aG = new ho("AwakeAppPingSwitch", 84, 85);
        aH = new ho("AwakeAppPingFrequency", 85, 86);
        aI = new ho("StorageCollectionSwitch", 86, 87);
        aJ = new ho("StorageCollectionFrequency", 87, 88);
        aK = new ho("PopupDialogWhiteList", 88, 94);
        aL = new ho("PopupDialogContent", 89, 95);
        aM = new ho("PopupDialogSwitch", 90, 96);
        aN = new ho("FallDownTimeRange", 91, 97);
        aO = new ho("AppIsInstalledCollectionSwitch", 92, 98);
        aP = new ho("AppIsInstalledCollectionFrequency", 93, 99);
        aQ = new ho("AppIsInstalledList", 94, 100);
        aR = new ho("TopNotificationUpdateFrequency", 95, 101);
        aS = new ho("TopNotificationUpdatePeriod", 96, 102);
        aT = new ho("TopNotificationUpdateSwitch", 97, 103);
        aU = new ho("EventUploadNewSwitch", 98, 104);
        aV = new ho("ScreenOnOrChargingTinyDataUploadSwitch", 99, 105);
        aW = new ho("NotificationAutoGroupSwitch", 100, 106);
        aX = new ho("LatestNotificationNotIntoGroupSwitch", 101, 107);
        aY = new ho("DCJobMutualSwitch", 102, 108);
        aZ = new ho("NotificationBelongToAppSwitch", 103, 109);
        ba = new ho("DCJobUploadRepeatedInterval", 104, 110);
        bb = new ho("LauncherAppListCollectionSwitch", 105, 111);
        bc = new ho("LauncherAppListCollectionFrequency", 106, 112);
        bd = new ho("ScenePushForegroundDuration", 107, 113);
        be = new ho("ScenePushForegroundDurationLong", 108, 114);
        bf = new ho("ExceptionMonitorSwitch", 109, 115);
        bg = new ho("IntelligentHeartbeatSwitchBoolean", 110, 116);
        bh = new ho("IntelligentHeartbeatDataCollectSwitchBoolean", 111, 117);
        bi = new ho("IntelligentHeartbeatNATCountInt", 112, 118);
        bj = new ho("IntelligentHeartbeatUseInMobileNetworkBoolean", 113, 119);
        bk = new ho("StatDataUploadFrequency", 114, 120);
        bl = new ho("StatDataUploadNum", 115, 121);
        bm = new ho("StatDataProcessFrequency", 116, 122);
        bn = new ho("StatDataSwitch", 117, 123);
        bo = new ho("StatDataUploadWay", 118, 124);
        bp = new ho("StatDataDeleteFrequency", 119, 125);
        bq = new ho("SdkExceptionMonitorSwitch", 120, 126);
        br = new ho("ShortHeartbeatEffectivePeriodMsLong", 121, 130);
        bs = new ho("CollectionDataPluginVersion", 122, 1001);
        bt = new ho("CollectionPluginDownloadUrl", 123, 1002);
        bu = new ho("CollectionPluginMd5", 124, 1003);
        ho hoVar = new ho("CollectionPluginForceStop", 125, 1004);
        bv = hoVar;
        f488a = new ho[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az, aA, aB, aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, aM, aN, aO, aP, aQ, aR, aS, aT, aU, aV, aW, aX, aY, aZ, ba, bb, bc, bd, be, bf, bg, bh, bi, bj, bk, bl, bm, bn, bo, bp, bq, br, bs, bt, bu, hoVar};
    }

    public ho(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f489a = i3;
    }

    public static ho valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ho) Enum.valueOf(ho.class, str) : (ho) invokeL.objValue;
    }

    public static ho[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ho[]) f488a.clone() : (ho[]) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f489a : invokeV.intValue;
    }
}
