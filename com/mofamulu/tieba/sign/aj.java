package com.mofamulu.tieba.sign;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
/* loaded from: classes.dex */
class aj implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MoreSignActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(MoreSignActivity moreSignActivity) {
        this.a = moreSignActivity;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        this.a.x.a(i, i2);
        this.a.c();
    }
}
