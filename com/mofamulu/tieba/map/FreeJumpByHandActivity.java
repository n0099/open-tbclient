package com.mofamulu.tieba.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FreeJumpByHandActivity extends com.mofamulu.tieba.ch.aa {
    FreeLocationService g;

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, FreeJumpByHandActivity.class), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tbhp_jump_by_hand);
        this.g = FreeLocationService.a(this);
        b();
    }

    protected void b() {
        EditText editText = (EditText) findViewById(R.id.map_x);
        EditText editText2 = (EditText) findViewById(R.id.map_y);
        ((TextView) findViewById(R.id.map_pos_now)).setText("当前设定的位置：" + this.g.f());
        editText.setText(new StringBuilder(String.valueOf(this.g.c())).toString());
        editText2.setText(new StringBuilder(String.valueOf(this.g.d())).toString());
        TextView textView = (TextView) findViewById(R.id.text_copy_pos);
        TextView textView2 = (TextView) findViewById(R.id.text_jump_current);
        TextView textView3 = (TextView) findViewById(R.id.text_jump);
        a aVar = new a(this, textView, textView2, textView3, editText, editText2, (TextView) findViewById(R.id.text_error));
        textView.setOnTouchListener(aVar);
        textView2.setOnTouchListener(aVar);
        textView3.setOnTouchListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        setResult(i);
        finish();
    }
}
