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
/* loaded from: classes6.dex */
public class SignalStrengthListener extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f31608a;

    /* renamed from: b  reason: collision with root package name */
    public TelephonyManager f31609b;

    public SignalStrengthListener(Context context) {
        this.f31609b = null;
        this.f31608a = context;
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            this.f31609b = telephonyManager;
            if (telephonyManager != null) {
                telephonyManager.listen(this, 256);
            }
        } catch (Exception unused) {
        }
    }

    @RequiresApi(api = 23)
    private void a() {
        CellInfo cellInfo;
        CellSignalStrengthLte cellSignalStrengthLte = null;
        if (PermissionChecker.checkSelfPermission(this.f31608a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            cellInfo = null;
            for (CellInfo cellInfo2 : this.f31609b.getAllCellInfo()) {
                if (cellInfo2.isRegistered()) {
                    cellInfo = cellInfo2;
                }
            }
        } else {
            cellInfo = null;
        }
        if (cellInfo != null) {
            if (cellInfo instanceof CellInfoLte) {
                CellSignalStrengthLte cellSignalStrength = ((CellInfoLte) cellInfo).getCellSignalStrength();
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
            } else if (cellInfo instanceof CellInfoGsm) {
                cellSignalStrengthLte = ((CellInfoGsm) cellInfo).getCellSignalStrength();
            } else if (cellInfo instanceof CellInfoCdma) {
                cellSignalStrengthLte = ((CellInfoCdma) cellInfo).getCellSignalStrength();
            } else if (cellInfo instanceof CellInfoWcdma) {
                cellSignalStrengthLte = ((CellInfoWcdma) cellInfo).getCellSignalStrength();
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
        com.kuaishou.aegon.a.a.b(e.a(this, i, i2));
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
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.telephony.PhoneStateListener
    @RequiresApi(api = 23)
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        com.kuaishou.aegon.a.a.b(f.a(this));
    }
}
