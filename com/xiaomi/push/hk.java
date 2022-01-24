package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class hk {
    public static /* synthetic */ Interceptable $ic;
    public static final hk A;
    public static final hk B;
    public static final hk C;
    public static final hk D;
    public static final hk E;
    public static final hk F;
    public static final hk G;
    public static final hk H;
    public static final hk I;
    public static final hk J;
    public static final hk K;
    public static final hk L;
    public static final hk M;
    public static final hk N;
    public static final hk O;
    public static final hk P;
    public static final hk Q;
    public static final hk R;
    public static final hk S;
    public static final hk T;
    public static final hk U;
    public static final hk V;
    public static final hk W;
    public static final hk X;
    public static final hk Y;
    public static final hk Z;
    public static final hk a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ hk[] f497a;
    public static final hk aA;
    public static final hk aB;
    public static final hk aC;
    public static final hk aD;
    public static final hk aE;
    public static final hk aF;
    public static final hk aG;
    public static final hk aH;
    public static final hk aI;
    public static final hk aJ;
    public static final hk aK;
    public static final hk aL;
    public static final hk aM;
    public static final hk aN;
    public static final hk aO;
    public static final hk aP;
    public static final hk aQ;
    public static final hk aR;
    public static final hk aS;
    public static final hk aT;
    public static final hk aU;
    public static final hk aV;
    public static final hk aW;
    public static final hk aX;
    public static final hk aY;
    public static final hk aZ;
    public static final hk aa;
    public static final hk ab;
    public static final hk ac;
    public static final hk ad;
    public static final hk ae;
    public static final hk af;
    public static final hk ag;
    public static final hk ah;
    public static final hk ai;
    public static final hk aj;
    public static final hk ak;
    public static final hk al;
    public static final hk am;
    public static final hk an;
    public static final hk ao;
    public static final hk ap;
    public static final hk aq;
    public static final hk ar;
    public static final hk as;
    public static final hk at;
    public static final hk au;
    public static final hk av;
    public static final hk aw;
    public static final hk ax;
    public static final hk ay;
    public static final hk az;

    /* renamed from: b  reason: collision with root package name */
    public static final hk f61232b;
    public static final hk ba;
    public static final hk bb;
    public static final hk bc;
    public static final hk bd;
    public static final hk be;
    public static final hk bf;
    public static final hk bg;
    public static final hk bh;
    public static final hk bi;
    public static final hk bj;
    public static final hk bk;
    public static final hk bl;
    public static final hk bm;
    public static final hk bn;
    public static final hk bo;

    /* renamed from: c  reason: collision with root package name */
    public static final hk f61233c;

    /* renamed from: d  reason: collision with root package name */
    public static final hk f61234d;

    /* renamed from: e  reason: collision with root package name */
    public static final hk f61235e;

    /* renamed from: f  reason: collision with root package name */
    public static final hk f61236f;

    /* renamed from: g  reason: collision with root package name */
    public static final hk f61237g;

    /* renamed from: h  reason: collision with root package name */
    public static final hk f61238h;

    /* renamed from: i  reason: collision with root package name */
    public static final hk f61239i;

    /* renamed from: j  reason: collision with root package name */
    public static final hk f61240j;
    public static final hk k;
    public static final hk l;
    public static final hk m;
    public static final hk n;
    public static final hk o;
    public static final hk p;
    public static final hk q;
    public static final hk r;
    public static final hk s;
    public static final hk t;
    public static final hk u;
    public static final hk v;
    public static final hk w;
    public static final hk x;
    public static final hk y;
    public static final hk z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final int f498a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372835, "Lcom/xiaomi/push/hk;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372835, "Lcom/xiaomi/push/hk;");
                return;
            }
        }
        a = new hk("UploadSwitch", 0, 1);
        f61232b = new hk("UploadFrequency", 1, 2);
        f61233c = new hk("ScreenSizeCollectionSwitch", 2, 3);
        f61234d = new hk("MacCollectionSwitch", 3, 4);
        f61235e = new hk("IMSICollectionSwitch", 4, 5);
        f61236f = new hk("AndroidVnCollectionSwitch", 5, 6);
        f61237g = new hk("AndroidVcCollectionSwitch", 6, 7);
        f61238h = new hk("AndroidIdCollectionSwitch", 7, 8);
        f61239i = new hk("DeviceInfoCollectionFrequency", 8, 9);
        f61240j = new hk("AppInstallListCollectionSwitch", 9, 10);
        k = new hk("AppInstallListCollectionFrequency", 10, 11);
        l = new hk("AppActiveListCollectionSwitch", 11, 12);
        m = new hk("AppActiveListCollectionFrequency", 12, 13);
        n = new hk("BluetoothCollectionSwitch", 13, 14);
        o = new hk("BluetoothCollectionFrequency", 14, 15);
        p = new hk("LocationCollectionSwitch", 15, 16);
        q = new hk("LocationCollectionFrequency", 16, 17);
        r = new hk("AccountCollectionSwitch", 17, 18);
        s = new hk("AccountCollectionFrequency", 18, 19);
        t = new hk("WifiCollectionSwitch", 19, 20);
        u = new hk("WifiCollectionFrequency", 20, 21);
        v = new hk("CellularCollectionSwitch", 21, 22);
        w = new hk("CellularCollectionFrequency", 22, 23);
        x = new hk("TopAppCollectionSwitch", 23, 24);
        y = new hk("TopAppCollectionFrequency", 24, 25);
        z = new hk("DataCollectionSwitch", 25, 26);
        A = new hk("OcVersionCheckFrequency", 26, 27);
        B = new hk("SyncInfoFrequency", 27, 28);
        C = new hk("UploadNotificationInfoFrequency", 28, 29);
        D = new hk("UploadNotificationInfoMaxNum", 29, 30);
        E = new hk("CollectionNotificationInfoBaseSwitch", 30, 31);
        F = new hk("CollectionNotificationInfoAppSwitch", 31, 32);
        G = new hk("CollectionNotificationInfoRemovedSwitch", 32, 33);
        H = new hk("ForegroundServiceSwitch", 33, 34);
        I = new hk("SyncMIIDFrequency", 34, 35);
        J = new hk("Upload4GSwitch", 35, 36);
        K = new hk("Upload4GFrequency", 36, 37);
        L = new hk("Upload3GSwitch", 37, 38);
        M = new hk("Upload3GFrequency", 38, 39);
        N = new hk("ShieldTypeConfig", 39, 40);
        O = new hk("UploadWIFIGeoLocFrequency", 40, 41);
        P = new hk("UploadNOWIFIGeoLocFrequency", 41, 42);
        Q = new hk("BroadcastActionCollectionSwitch", 42, 43);
        R = new hk("BroadcastActionCollectionFrequency", 43, 44);
        S = new hk("UploadGeoLocSwitch", 44, 45);
        T = new hk("ServiceBootMode", 45, 46);
        U = new hk("AppPermissionCollectionSwitch", 46, 47);
        V = new hk("AppPermissionCollectionFrequency", 47, 48);
        W = new hk("WifiDevicesMacCollectionSwitch", 48, 49);
        X = new hk("WifiDevicesMacCollectionFrequency", 49, 50);
        Y = new hk("WifiDevicesMacWifiUnchangedCollectionFrequency", 50, 51);
        Z = new hk("AggregationSdkMonitorSwitch", 51, 52);
        aa = new hk("AggregationSdkMonitorFrequency", 52, 53);
        ab = new hk("AggregationSdkMonitorDepth", 53, 54);
        ac = new hk("UploadGeoAppLocSwitch", 54, 55);
        ad = new hk("ThirdPushControlSwitch", 55, 56);
        ae = new hk("ThirdPushComponentKeyWords", 56, 57);
        af = new hk("ThirdPushWhiteList", 57, 58);
        ag = new hk("XmsfScanWhitelist", 58, 59);
        ah = new hk("IccidCollectionSwitch", 59, 60);
        ai = new hk("LimitThridPushStrategyMode", 60, 61);
        aj = new hk("GlobalPushChannelException", 61, 62);
        ak = new hk("TinyDataUploadSwitch", 62, 63);
        al = new hk("TinyDataUploadFrequency", 63, 64);
        am = new hk("GlobalRegionIOSwitch", 64, 65);
        an = new hk("GlobalRegionIOWait", 65, 66);
        ao = new hk("AggregatePushSwitch", 66, 67);
        ap = new hk("ActivityTSSwitch", 67, 68);
        aq = new hk("OperatorSwitch", 68, 69);
        ar = new hk("DeviceIdSwitch", 69, 70);
        as = new hk("DeviceBaseInfoCollectionFrequency", 70, 71);
        at = new hk("UsageStatsCollectionFrequency", 71, 72);
        au = new hk("UsageStatsCollectionWhiteList", 72, 73);
        av = new hk("ForceHandleCrashSwitch", 73, 74);
        aw = new hk("Crash4GUploadSwitch", 74, 75);
        ax = new hk("Crash4GUploadFrequency", 75, 76);
        ay = new hk("CrashWIFIUploadFrequency", 76, 77);
        az = new hk("EventUploadSwitch", 77, 78);
        aA = new hk("PerfUploadSwitch", 78, 79);
        aB = new hk("EventUploadFrequency", 79, 80);
        aC = new hk("PerfUploadFrequency", 80, 81);
        aD = new hk("BatteryCollectionSwitch", 81, 82);
        aE = new hk("BatteryCollectionFrequency", 82, 83);
        aF = new hk("AwakeInfoUploadWaySwitch", 83, 84);
        aG = new hk("AwakeAppPingSwitch", 84, 85);
        aH = new hk("AwakeAppPingFrequency", 85, 86);
        aI = new hk("StorageCollectionSwitch", 86, 87);
        aJ = new hk("StorageCollectionFrequency", 87, 88);
        aK = new hk("PopupDialogWhiteList", 88, 94);
        aL = new hk("PopupDialogContent", 89, 95);
        aM = new hk("PopupDialogSwitch", 90, 96);
        aN = new hk("FallDownTimeRange", 91, 97);
        aO = new hk("AppIsInstalledCollectionSwitch", 92, 98);
        aP = new hk("AppIsInstalledCollectionFrequency", 93, 99);
        aQ = new hk("AppIsInstalledList", 94, 100);
        aR = new hk("TopNotificationUpdateFrequency", 95, 101);
        aS = new hk("TopNotificationUpdatePeriod", 96, 102);
        aT = new hk("TopNotificationUpdateSwitch", 97, 103);
        aU = new hk("EventUploadNewSwitch", 98, 104);
        aV = new hk("ScreenOnOrChargingTinyDataUploadSwitch", 99, 105);
        aW = new hk("NotificationAutoGroupSwitch", 100, 106);
        aX = new hk("LatestNotificationNotIntoGroupSwitch", 101, 107);
        aY = new hk("DCJobMutualSwitch", 102, 108);
        aZ = new hk("NotificationBelongToAppSwitch", 103, 109);
        ba = new hk("DCJobUploadRepeatedInterval", 104, 110);
        bb = new hk("LauncherAppListCollectionSwitch", 105, 111);
        bc = new hk("LauncherAppListCollectionFrequency", 106, 112);
        bd = new hk("ScenePushForegroundDuration", 107, 113);
        be = new hk("ScenePushForegroundDurationLong", 108, 114);
        bf = new hk("StatDataUploadFrequency", 109, 120);
        bg = new hk("StatDataUploadNum", 110, 121);
        bh = new hk("StatDataProcessFrequency", 111, 122);
        bi = new hk("StatDataSwitch", 112, 123);
        bj = new hk("StatDataUploadWay", 113, 124);
        bk = new hk("StatDataDeleteFrequency", 114, 125);
        bl = new hk("CollectionDataPluginVersion", 115, 1001);
        bm = new hk("CollectionPluginDownloadUrl", 116, 1002);
        bn = new hk("CollectionPluginMd5", 117, 1003);
        hk hkVar = new hk("CollectionPluginForceStop", 118, 1004);
        bo = hkVar;
        f497a = new hk[]{a, f61232b, f61233c, f61234d, f61235e, f61236f, f61237g, f61238h, f61239i, f61240j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az, aA, aB, aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, aM, aN, aO, aP, aQ, aR, aS, aT, aU, aV, aW, aX, aY, aZ, ba, bb, bc, bd, be, bf, bg, bh, bi, bj, bk, bl, bm, bn, hkVar};
    }

    public hk(String str, int i2, int i3) {
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
        this.f498a = i3;
    }

    public static hk valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (hk) Enum.valueOf(hk.class, str) : (hk) invokeL.objValue;
    }

    public static hk[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (hk[]) f497a.clone() : (hk[]) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f498a : invokeV.intValue;
    }
}
