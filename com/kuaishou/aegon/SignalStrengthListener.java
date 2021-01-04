package com.kuaishou.aegon;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.core.content.PermissionChecker;
/* loaded from: classes5.dex */
public class SignalStrengthListener extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f8408a;

    /* renamed from: b  reason: collision with root package name */
    public TelephonyManager f8409b;

    public SignalStrengthListener(Context context) {
        this.f8409b = null;
        this.f8408a = context;
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            this.f8409b = (TelephonyManager) context.getSystemService("phone");
            if (this.f8409b != null) {
                this.f8409b.listen(this, 256);
            }
        } catch (Exception e) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0032 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [android.telephony.CellInfo] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    @RequiresApi(api = 23)
    private void a() {
        CellInfoLte cellInfoLte;
        CellSignalStrengthLte cellSignalStrengthLte = null;
        new StringBuilder();
        if (PermissionChecker.checkSelfPermission(this.f8408a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            CellInfoLte cellInfoLte2 = null;
            for (CellInfo cellInfo : this.f8409b.getAllCellInfo()) {
                if (!cellInfo.isRegistered()) {
                    cellInfo = cellInfoLte2;
                }
                cellInfoLte2 = cellInfo;
            }
            cellInfoLte = cellInfoLte2;
        } else {
            cellInfoLte = null;
        }
        if (cellInfoLte != null) {
            if (cellInfoLte instanceof CellInfoLte) {
                CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                cellSignalStrengthLte = cellSignalStrength;
                if (Build.VERSION.SDK_INT >= 26) {
                    if (cellSignalStrength.getRsrq() < Integer.MAX_VALUE) {
                        a(0, cellSignalStrength.getRsrq());
                    }
                    if (cellSignalStrength.getRsrp() < Integer.MAX_VALUE) {
                        a(1, cellSignalStrength.getRsrp());
                    }
                    int rssnr = cellSignalStrength.getRssnr();
                    cellSignalStrengthLte = cellSignalStrength;
                    if (rssnr < Integer.MAX_VALUE) {
                        a(2, cellSignalStrength.getRssnr());
                        cellSignalStrengthLte = cellSignalStrength;
                    }
                }
            } else if (cellInfoLte instanceof CellInfoGsm) {
                cellSignalStrengthLte = ((CellInfoGsm) cellInfoLte).getCellSignalStrength();
            } else if (cellInfoLte instanceof CellInfoCdma) {
                cellSignalStrengthLte = ((CellInfoCdma) cellInfoLte).getCellSignalStrength();
            } else if (cellInfoLte instanceof CellInfoWcdma) {
                cellSignalStrengthLte = ((CellInfoWcdma) cellInfoLte).getCellSignalStrength();
            }
            if (cellSignalStrengthLte != null) {
                if (cellSignalStrengthLte.getAsuLevel() < Integer.MAX_VALUE) {
                    a(3, cellSignalStrengthLte.getAsuLevel());
                }
                if (cellSignalStrengthLte.getDbm() < Integer.MAX_VALUE) {
                    a(3, cellSignalStrengthLte.getDbm());
                }
            }
        }
    }

    private void a(int i, int i2) {
        com.kuaishou.aegon.a.a.b(j.b(this, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSignalStrengthChanged();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSignalStrengthValueUpdate(int i, int i2);

    @Keep
    private void performSignalStrengthMetricsUpdate() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                a();
            } catch (Exception e) {
            }
        }
    }

    @Override // android.telephony.PhoneStateListener
    @RequiresApi(api = 23)
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        com.kuaishou.aegon.a.a.b(k.b(this));
    }
}
