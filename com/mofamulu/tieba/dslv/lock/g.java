package com.mofamulu.tieba.dslv.lock;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.dslv.lock.LockPatternActivity;
import java.util.List;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ LockPatternActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LockPatternActivity lockPatternActivity) {
        this.a = lockPatternActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LockPatternActivity.ButtonOkCommand buttonOkCommand;
        boolean z;
        List list;
        String a;
        SharedPreferences sharedPreferences;
        List list2;
        String a2;
        LockPatternView lockPatternView;
        TextView textView;
        Button button;
        Button button2;
        buttonOkCommand = this.a.t;
        if (buttonOkCommand != LockPatternActivity.ButtonOkCommand.Continue) {
            z = this.a.q;
            if (z) {
                sharedPreferences = this.a.o;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                String str = LockPatternActivity.h;
                LockPatternActivity lockPatternActivity = this.a;
                list2 = this.a.B;
                a2 = lockPatternActivity.a(list2);
                edit.putString(str, a2).commit();
            }
            LockPatternActivity lockPatternActivity2 = this.a;
            LockPatternActivity lockPatternActivity3 = this.a;
            list = this.a.B;
            a = lockPatternActivity3.a(list);
            lockPatternActivity2.a(a);
            return;
        }
        this.a.t = LockPatternActivity.ButtonOkCommand.Done;
        lockPatternView = this.a.w;
        lockPatternView.a();
        textView = this.a.v;
        textView.setText(R.string.alp_msg_redraw_pattern_to_confirm);
        button = this.a.z;
        button.setText(R.string.alp_cmd_confirm);
        button2 = this.a.z;
        button2.setEnabled(false);
    }
}
