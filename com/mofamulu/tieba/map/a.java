package com.mofamulu.tieba.map;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.mofamulu.tieba.tail.an;
/* loaded from: classes.dex */
class a implements View.OnTouchListener {
    final /* synthetic */ FreeJumpByHandActivity a;
    private final /* synthetic */ TextView b;
    private final /* synthetic */ TextView c;
    private final /* synthetic */ TextView d;
    private final /* synthetic */ EditText e;
    private final /* synthetic */ EditText f;
    private final /* synthetic */ TextView g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FreeJumpByHandActivity freeJumpByHandActivity, TextView textView, TextView textView2, TextView textView3, EditText editText, EditText editText2, TextView textView4) {
        this.a = freeJumpByHandActivity;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = editText;
        this.f = editText2;
        this.g = textView4;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        double d;
        double d2 = 0.0d;
        if (view == this.b) {
            String f = this.a.g.f();
            if (an.a == null) {
                an.a = f;
            } else if (!an.a.contains(f)) {
                an.a = String.valueOf(an.a) + f;
            }
            Toast.makeText(this.a, "已保存：" + f, 0).show();
            return true;
        } else if (view == this.c) {
            this.a.b(100);
            return true;
        } else if (view == this.d) {
            String editable = this.e.getText().toString();
            String editable2 = this.f.getText().toString();
            String str = null;
            try {
                d = Double.parseDouble(editable.trim());
            } catch (Exception e) {
                str = "纬度值无效！";
                d = 0.0d;
            }
            try {
                d2 = Double.parseDouble(editable2.trim());
            } catch (Exception e2) {
                str = "经度值无效！";
            }
            if (str != null) {
                this.g.setVisibility(0);
                this.g.setText(str);
                return true;
            }
            String c = this.a.g.c(d, d2);
            if (c != null) {
                this.g.setVisibility(0);
                this.g.setText(c);
                return true;
            }
            this.g.setVisibility(8);
            this.a.b(-1);
            return true;
        } else {
            return false;
        }
    }
}
