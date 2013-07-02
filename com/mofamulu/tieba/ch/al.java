package com.mofamulu.tieba.ch;

import android.app.Dialog;
import android.widget.SeekBar;
import android.widget.TextView;
/* loaded from: classes.dex */
class al implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ MoreNickActivity a;
    private final /* synthetic */ Dialog b;
    private final /* synthetic */ TextView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(MoreNickActivity moreNickActivity, Dialog dialog, TextView textView) {
        this.a = moreNickActivity;
        this.b = dialog;
        this.c = textView;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.a.g.a(seekBar.getProgress());
        this.a.m();
        this.b.dismiss();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (i == 0) {
            this.c.setText("无需更新频率限制");
        } else {
            this.c.setText(String.valueOf(i) + "分钟1次");
        }
    }
}
