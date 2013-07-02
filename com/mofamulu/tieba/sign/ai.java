package com.mofamulu.tieba.sign;

import android.app.Dialog;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class ai implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ MoreSignActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ Dialog c;
    private final /* synthetic */ TextView d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(MoreSignActivity moreSignActivity, int i, Dialog dialog, TextView textView) {
        this.a = moreSignActivity;
        this.b = i;
        this.c = dialog;
        this.d = textView;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (this.b == R.id.sign_more_fix_delay) {
            this.a.x.b(seekBar.getProgress());
        } else if (this.b == R.id.sign_more_rand_delay) {
            this.a.x.c(seekBar.getProgress());
        }
        this.a.c();
        this.c.dismiss();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.d.setText(String.valueOf(i) + "秒");
    }
}
