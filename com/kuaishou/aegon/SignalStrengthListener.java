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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SignalStrengthListener extends PhoneStateListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f34011a;

    /* renamed from: b  reason: collision with root package name */
    public TelephonyManager f34012b;

    public SignalStrengthListener(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34012b = null;
        this.f34011a = context;
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            this.f34012b = telephonyManager;
            if (telephonyManager != null) {
                telephonyManager.listen(this, 256);
            }
        } catch (Exception unused) {
        }
    }

    @RequiresApi(api = 23)
    private void a() {
        CellInfo cellInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            CellSignalStrengthLte cellSignalStrengthLte = null;
            if (PermissionChecker.checkSelfPermission(this.f34011a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                cellInfo = null;
                for (CellInfo cellInfo2 : this.f34012b.getAllCellInfo()) {
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
    }

    private void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, this, i2, i3) == null) {
            com.kuaishou.aegon.a.a.b(e.a(this, i2, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSignalStrengthChanged();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSignalStrengthValueUpdate(int i2, int i3);

    @Keep
    private void performSignalStrengthMetricsUpdate() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            a();
        } catch (Exception unused) {
        }
    }

    @Override // android.telephony.PhoneStateListener
    @RequiresApi(api = 23)
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, signalStrength) == null) {
            com.kuaishou.aegon.a.a.b(f.a(this));
        }
    }
}
