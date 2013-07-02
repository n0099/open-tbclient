package com.mofamulu.tieba.tail;

import android.app.Dialog;
import android.widget.SeekBar;
import android.widget.TextView;
/* loaded from: classes.dex */
class ab implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ MoreOthersActivity a;
    private final /* synthetic */ Dialog b;
    private final /* synthetic */ TextView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MoreOthersActivity moreOthersActivity, Dialog dialog, TextView textView) {
        this.a = moreOthersActivity;
        this.b = dialog;
        this.c = textView;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.a.y.g(seekBar.getProgress());
        this.a.c();
        this.b.dismiss();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.c.setText(String.valueOf(i) + "分钟");
    }
}
