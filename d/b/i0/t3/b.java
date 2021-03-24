package d.b.i0.t3;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes5.dex */
public class b extends TimePickerDialog {

    /* renamed from: e  reason: collision with root package name */
    public int f61145e;

    /* renamed from: f  reason: collision with root package name */
    public int f61146f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61147g;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.f61145e = -1;
        this.f61146f = -1;
        this.f61147g = false;
        this.f61145e = i;
        this.f61146f = i2;
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        if (i == -1) {
            this.f61147g = true;
        } else {
            int i3 = this.f61145e;
            if (i3 >= 0 && (i2 = this.f61146f) >= 0) {
                updateTime(i3, i2);
            }
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.f61145e = bundle.getInt("hour_key");
        int i = bundle.getInt("min_key");
        this.f61146f = i;
        updateTime(this.f61145e, i);
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundle;
        try {
            bundle = super.onSaveInstanceState();
        } catch (Exception unused) {
            bundle = null;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("hour_key", this.f61145e);
        bundle.putInt("min_key", this.f61146f);
        return bundle;
    }

    @Override // android.app.Dialog
    public void onStop() {
        if (!this.f61147g) {
            updateTime(this.f61145e, this.f61146f);
        }
        super.onStop();
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.f61145e = i;
        this.f61146f = i2;
        this.f61147g = false;
    }
}
