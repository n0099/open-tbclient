package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.tencent.mm.sdk.platformtools.PhoneUtil;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
class PhoneUtil20Impl {
    private static int aK = VersionUtils.CUR_DEVELOPMENT;
    private static int aL = VersionUtils.CUR_DEVELOPMENT;
    private TelephonyManager aM;
    private PhoneStateListener aN = new PhoneStateListener() { // from class: com.tencent.mm.sdk.platformtools.PhoneUtil20Impl.1
        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            if (PhoneUtil20Impl.this.aP == 2) {
                int unused = PhoneUtil20Impl.aL = signalStrength.getCdmaDbm();
            }
            if (PhoneUtil20Impl.this.aP == 1) {
                int unused2 = PhoneUtil20Impl.aL = (signalStrength.getGsmSignalStrength() * 2) - 113;
            }
            if (PhoneUtil20Impl.this.aM != null) {
                PhoneUtil20Impl.this.aM.listen(PhoneUtil20Impl.this.aN, 0);
            }
        }
    };
    private int aP;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0067: INVOKE  (r9v2 int A[REMOVE]) = (r0v1 android.telephony.cdma.CdmaCellLocation) type: VIRTUAL call: android.telephony.cdma.CdmaCellLocation.getBaseStationId():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0078: INVOKE  (r13v0 int A[REMOVE]) = (r0v1 android.telephony.cdma.CdmaCellLocation) type: VIRTUAL call: android.telephony.cdma.CdmaCellLocation.getNetworkId():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0089: INVOKE  (r10v3 int A[REMOVE]) = (r0v1 android.telephony.cdma.CdmaCellLocation) type: VIRTUAL call: android.telephony.cdma.CdmaCellLocation.getSystemId():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x00c5: SGET  (r4v17 int A[REMOVE]) =  com.tencent.mm.sdk.platformtools.PhoneUtil20Impl.aL int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0157: INVOKE  (r7v0 int A[REMOVE]) = (r5v1 android.telephony.NeighboringCellInfo) type: VIRTUAL call: android.telephony.NeighboringCellInfo.getLac():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0168: INVOKE  (r5v2 int A[REMOVE]) = (r5v1 android.telephony.NeighboringCellInfo) type: VIRTUAL call: android.telephony.NeighboringCellInfo.getCid():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x023c: INVOKE  (r7v10 int A[REMOVE]) = (r5v9 android.telephony.NeighboringCellInfo) type: VIRTUAL call: android.telephony.NeighboringCellInfo.getLac():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x024d: INVOKE  (r5v10 int A[REMOVE]) = (r5v9 android.telephony.NeighboringCellInfo) type: VIRTUAL call: android.telephony.NeighboringCellInfo.getCid():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x026e: SGET  (r6v7 int A[REMOVE]) =  com.tencent.mm.sdk.platformtools.PhoneUtil20Impl.aL int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : ?: ARITH  null = (wrap: int : 0x0144: ARITH  (r4v9 int A[REMOVE]) = (wrap: int : 0x0140: INVOKE  (r4v8 int A[REMOVE]) = (r5v1 android.telephony.NeighboringCellInfo) type: VIRTUAL call: android.telephony.NeighboringCellInfo.getRssi():int) * (2 int)) - (113 int))] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : ?: ARITH  null = (wrap: int : 0x01f9: ARITH  (r4v26 int A[REMOVE]) = (wrap: int : 0x01f5: INVOKE  (r4v25 int A[REMOVE]) = (r5v9 android.telephony.NeighboringCellInfo) type: VIRTUAL call: android.telephony.NeighboringCellInfo.getRssi():int) * (2 int)) - (113 int))] */
    public List<PhoneUtil.CellInfo> getCellInfoList(Context context) {
        String str;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        LinkedList linkedList = new LinkedList();
        String str2 = "460";
        String str3 = "";
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            if (networkOperator == null || networkOperator.equals("")) {
                String simOperator = telephonyManager.getSimOperator();
                if (simOperator != null && !simOperator.equals("")) {
                    str2 = simOperator.substring(0, 3);
                    str3 = simOperator.substring(3, 5);
                }
                str = str3;
            } else {
                str2 = networkOperator.substring(0, 3);
                str = networkOperator.substring(3, 5);
            }
            if (telephonyManager.getPhoneType() == 2) {
                try {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                    if (cdmaCellLocation != null) {
                        String sb = aL == aK ? "" : new StringBuilder().append(aL).toString();
                        if (cdmaCellLocation.getBaseStationId() != -1 && cdmaCellLocation.getNetworkId() != -1 && cdmaCellLocation.getSystemId() != -1) {
                            linkedList.add(new PhoneUtil.CellInfo(str2, str, "", "", sb, PhoneUtil.CELL_CDMA, new StringBuilder().append(cdmaCellLocation.getBaseStationId()).toString(), new StringBuilder().append(cdmaCellLocation.getNetworkId()).toString(), new StringBuilder().append(cdmaCellLocation.getSystemId()).toString()));
                        }
                    }
                } catch (Exception e) {
                    try {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                        if (gsmCellLocation != null) {
                            int cid = gsmCellLocation.getCid();
                            int lac = gsmCellLocation.getLac();
                            if (lac < 65535 && lac != -1 && cid != -1) {
                                linkedList.add(new PhoneUtil.CellInfo(str2, str, String.valueOf(lac), String.valueOf(cid), "", PhoneUtil.CELL_GSM, "", "", ""));
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    List<NeighboringCellInfo> neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
                    if (neighboringCellInfo != null && neighboringCellInfo.size() > 0) {
                        for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                            if (neighboringCellInfo2.getCid() != -1 && neighboringCellInfo2.getLac() <= 65535 && neighboringCellInfo2.getLac() != -1) {
                                linkedList.add(new PhoneUtil.CellInfo(str2, str, new StringBuilder().append(neighboringCellInfo2.getLac()).toString(), new StringBuilder().append(neighboringCellInfo2.getCid()).toString(), new StringBuilder().append((neighboringCellInfo2.getRssi() * 2) - 113).toString(), PhoneUtil.CELL_GSM, "", "", ""));
                            }
                        }
                    }
                }
            } else {
                try {
                    GsmCellLocation gsmCellLocation2 = (GsmCellLocation) telephonyManager.getCellLocation();
                    if (gsmCellLocation2 != null) {
                        int cid2 = gsmCellLocation2.getCid();
                        int lac2 = gsmCellLocation2.getLac();
                        if (lac2 < 65535 && lac2 != -1 && cid2 != -1) {
                            linkedList.add(new PhoneUtil.CellInfo(str2, str, String.valueOf(lac2), String.valueOf(cid2), aL == aK ? "" : new StringBuilder().append(aL).toString(), PhoneUtil.CELL_GSM, "", "", ""));
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                List<NeighboringCellInfo> neighboringCellInfo3 = telephonyManager.getNeighboringCellInfo();
                if (neighboringCellInfo3 != null && neighboringCellInfo3.size() > 0) {
                    for (NeighboringCellInfo neighboringCellInfo4 : neighboringCellInfo3) {
                        if (neighboringCellInfo4.getCid() != -1 && neighboringCellInfo4.getLac() <= 65535) {
                            String sb2 = new StringBuilder().append((neighboringCellInfo4.getRssi() * 2) - 113).toString();
                            Log.v("checked", "lac:" + neighboringCellInfo4.getLac() + "  cid:" + neighboringCellInfo4.getCid() + " dbm:" + sb2);
                            linkedList.add(new PhoneUtil.CellInfo(str2, str, new StringBuilder().append(neighboringCellInfo4.getLac()).toString(), new StringBuilder().append(neighboringCellInfo4.getCid()).toString(), sb2, PhoneUtil.CELL_GSM, "", "", ""));
                        }
                    }
                }
            }
            return linkedList;
        } catch (Exception e4) {
            e4.printStackTrace();
            return linkedList;
        }
    }

    public void getSignalStrength(Context context) {
        this.aM = (TelephonyManager) context.getSystemService("phone");
        this.aM.listen(this.aN, 256);
        this.aP = this.aM.getPhoneType();
    }
}
