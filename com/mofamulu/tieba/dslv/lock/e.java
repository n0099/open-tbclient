package com.mofamulu.tieba.dslv.lock;

import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.dslv.lock.LockPatternActivity;
import com.mofamulu.tieba.dslv.lock.LockPatternView;
import java.util.List;
/* loaded from: classes.dex */
class e implements j {
    final /* synthetic */ LockPatternActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LockPatternActivity lockPatternActivity) {
        this.a = lockPatternActivity;
    }

    @Override // com.mofamulu.tieba.dslv.lock.j
    public void a() {
        LockPatternView lockPatternView;
        TextView textView;
        Button button;
        LockPatternActivity.ButtonOkCommand buttonOkCommand;
        lockPatternView = this.a.w;
        lockPatternView.setDisplayMode(LockPatternView.DisplayMode.Correct);
        if (LockPatternActivity.a.equals(this.a.getIntent().getAction())) {
            textView = this.a.v;
            textView.setText(R.string.alp_msg_release_finger_when_done);
            button = this.a.z;
            button.setEnabled(false);
            buttonOkCommand = this.a.t;
            if (buttonOkCommand == LockPatternActivity.ButtonOkCommand.Continue) {
                this.a.B = null;
            }
        }
    }

    @Override // com.mofamulu.tieba.dslv.lock.j
    public void a(List list) {
        if (LockPatternActivity.a.equals(this.a.getIntent().getAction())) {
            this.a.c(list);
        } else if (LockPatternActivity.b.equals(this.a.getIntent().getAction())) {
            this.a.b(list);
        }
    }

    @Override // com.mofamulu.tieba.dslv.lock.j
    public void b() {
        LockPatternView lockPatternView;
        TextView textView;
        Button button;
        LockPatternActivity.ButtonOkCommand buttonOkCommand;
        TextView textView2;
        TextView textView3;
        lockPatternView = this.a.w;
        lockPatternView.setDisplayMode(LockPatternView.DisplayMode.Correct);
        if (LockPatternActivity.a.equals(this.a.getIntent().getAction())) {
            button = this.a.z;
            button.setEnabled(false);
            buttonOkCommand = this.a.t;
            if (buttonOkCommand != LockPatternActivity.ButtonOkCommand.Continue) {
                textView2 = this.a.v;
                textView2.setText(R.string.alp_msg_redraw_pattern_to_confirm);
                return;
            }
            this.a.B = null;
            textView3 = this.a.v;
            textView3.setText(R.string.alp_msg_draw_an_unlock_pattern);
        } else if (LockPatternActivity.b.equals(this.a.getIntent().getAction())) {
            textView = this.a.v;
            textView.setText(R.string.alp_msg_draw_pattern_to_unlock);
        }
    }

    @Override // com.mofamulu.tieba.dslv.lock.j
    public void b(List list) {
    }
}
