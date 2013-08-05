package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.tencent.mm.sdk.platformtools.PhoneUtil;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
class PhoneUtil16Impl {
    private static int aK = VersionUtils.CUR_DEVELOPMENT;
    private static int aL = VersionUtils.CUR_DEVELOPMENT;
    private TelephonyManager aM;
    private PhoneStateListener aN = new PhoneStateListener() { // from class: com.tencent.mm.sdk.platformtools.PhoneUtil16Impl.1
        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthChanged(int i) {
            super.onSignalStrengthChanged(i);
            int unused = PhoneUtil16Impl.aL = (i * 2) - 113;
            if (PhoneUtil16Impl.this.aM != null) {
                PhoneUtil16Impl.this.aM.listen(PhoneUtil16Impl.this.aN, 0);
            }
        }
    };

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0093: INVOKE  (r4v3 int A[REMOVE]) = (r4v2 android.telephony.NeighboringCellInfo) type: VIRTUAL call: android.telephony.NeighboringCellInfo.getCid():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x00bb: SGET  (r5v3 int A[REMOVE]) =  com.tencent.mm.sdk.platformtools.PhoneUtil16Impl.aL int)] */
    public List getCellInfoList(Context context) {
        LinkedList linkedList = new LinkedList();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        if (networkOperator == null || networkOperator.equals("")) {
            return linkedList;
        }
        String str = "460";
        String str2 = "";
        try {
            str = networkOperator.substring(0, 3);
            str2 = networkOperator.substring(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
            if (gsmCellLocation != null) {
                int cid = gsmCellLocation.getCid();
                int lac = gsmCellLocation.getLac();
                if (lac < 65535 && lac != -1 && cid != -1) {
                    linkedList.add(new PhoneUtil.CellInfo(str, str2, String.valueOf(lac), String.valueOf(cid), aL == aK ? "" : new StringBuilder().append(aL).toString(), PhoneUtil.CELL_GSM, "", "", ""));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        List<NeighboringCellInfo> neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
        if (neighboringCellInfo != null && neighboringCellInfo.size() > 0) {
            for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                if (neighboringCellInfo2.getCid() != -1) {
                    linkedList.add(new PhoneUtil.CellInfo(str, str2, "", new StringBuilder().append(neighboringCellInfo2.getCid()).toString(), "", PhoneUtil.CELL_GSM, "", "", ""));
                }
            }
        }
        return linkedList;
    }

    public void getSignalStrength(Context context) {
        this.aM = (TelephonyManager) context.getSystemService("phone");
        this.aM.listen(this.aN, 256);
    }
}
