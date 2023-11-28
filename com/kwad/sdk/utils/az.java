package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes10.dex */
public final class az {
    public static Context aOe;
    public static Map<String, j> aOf = new HashMap();

    /* loaded from: classes10.dex */
    public static class a extends j<com.kwad.sdk.k.a.b> {
        public static com.kwad.sdk.k.a.b aOg;

        public a(boolean z) {
            super(z);
        }

        @RequiresApi(api = 17)
        @SuppressLint({"BlockedPrivateApi"})
        public static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) s.callMethod(cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.j
        /* renamed from: cQ */
        public com.kwad.sdk.k.a.b bP(Context context) {
            int i;
            int i2;
            if (!au.KF() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(64L)) {
                com.kwad.sdk.k.a.b bVar = aOg;
                if (bVar != null) {
                    return bVar;
                }
                CellInfo cellInfo = null;
                if (context == null || au.KF()) {
                    return null;
                }
                int i3 = -1;
                if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == -1) {
                    return null;
                }
                if (bi.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        i2 = cdmaCellLocation.getBaseStationId();
                        i = cdmaCellLocation.getNetworkId();
                    } else if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        i2 = gsmCellLocation.getCid();
                        i = gsmCellLocation.getLac();
                    } else {
                        i = -1;
                        i2 = -1;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        Iterator<CellInfo> it = telephonyManager.getAllCellInfo().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            CellInfo next = it.next();
                            if (next != null && next.isRegistered()) {
                                cellInfo = next;
                                break;
                            }
                        }
                        if (cellInfo != null) {
                            i3 = a(cellInfo);
                        }
                    }
                    aOg = new com.kwad.sdk.k.a.b(i2, i, i3);
                }
                return aOg;
            }
            return aOg;
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends j<com.kwad.sdk.k.a.f> {
        public b(boolean z) {
            super(z);
        }

        @Nullable
        public static com.kwad.sdk.k.a.f cR(Context context) {
            com.kwad.sdk.k.a.f fVar = new com.kwad.sdk.k.a.f();
            fVar.aLu = av.cE(context);
            fVar.aLt = av.cC(context);
            return fVar;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.kwad.sdk.utils.j
        @Nullable
        public final /* synthetic */ com.kwad.sdk.k.a.f bP(Context context) {
            return cR(context);
        }
    }

    @Nullable
    public static com.kwad.sdk.k.a.b IV() {
        if (!KY()) {
            return null;
        }
        return (com.kwad.sdk.k.a.b) gd("baseStationEnable");
    }

    @Nullable
    public static com.kwad.sdk.k.a.f IW() {
        if (!KY()) {
            return null;
        }
        return (com.kwad.sdk.k.a.f) gd("simCardInfoEnable");
    }

    public static boolean KY() {
        if (aOe != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public static <T> j<T> gc(String str) {
        try {
            return aOf.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static <T> T gd(String str) {
        j gc = gc(str);
        if (gc != null) {
            return (T) gc.bO(aOe);
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.e.c.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
        } else if (KY()) {
            if (aOf.containsKey("baseStationEnable")) {
                boolean ym = hVar.ym();
                j gc = gc("baseStationEnable");
                if (gc != null) {
                    gc.bN(ym);
                }
            }
            if (aOf.containsKey("simCardInfoEnable")) {
                boolean yk = hVar.yk();
                j gc2 = gc("simCardInfoEnable");
                if (gc2 != null) {
                    gc2.bN(yk);
                }
            }
        } else {
            aOe = context.getApplicationContext();
            aOf.put("baseStationEnable", new a(hVar.ym()));
            aOf.put("simCardInfoEnable", new b(hVar.yk()));
        }
    }
}
