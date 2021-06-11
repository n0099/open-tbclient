package d.a.n0.v3;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes5.dex */
public class b extends TimePickerDialog {

    /* renamed from: e  reason: collision with root package name */
    public int f66074e;

    /* renamed from: f  reason: collision with root package name */
    public int f66075f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66076g;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i2, int i3, boolean z) {
        super(context, onTimeSetListener, i2, i3, z);
        this.f66074e = -1;
        this.f66075f = -1;
        this.f66076g = false;
        this.f66074e = i2;
        this.f66075f = i3;
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        int i3;
        if (i2 == -1) {
            this.f66076g = true;
        } else {
            int i4 = this.f66074e;
            if (i4 >= 0 && (i3 = this.f66075f) >= 0) {
                updateTime(i4, i3);
            }
        }
        super.onClick(dialogInterface, i2);
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.f66074e = bundle.getInt("hour_key");
        int i2 = bundle.getInt("min_key");
        this.f66075f = i2;
        updateTime(this.f66074e, i2);
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
        bundle.putInt("hour_key", this.f66074e);
        bundle.putInt("min_key", this.f66075f);
        return bundle;
    }

    @Override // android.app.Dialog
    public void onStop() {
        if (!this.f66076g) {
            updateTime(this.f66074e, this.f66075f);
        }
        super.onStop();
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i2, int i3) {
        super.updateTime(i2, i3);
        this.f66074e = i2;
        this.f66075f = i3;
        this.f66076g = false;
    }
}
