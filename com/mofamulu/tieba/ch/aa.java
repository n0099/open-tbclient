package com.mofamulu.tieba.ch;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class aa extends com.baidu.tieba.g {
    protected ViewGroup a = null;
    protected View b = null;
    protected ImageView c = null;
    protected TextView d = null;
    protected ListView e = null;
    protected Button f = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        if (this.a == null) {
            this.a = (ViewGroup) findViewById(R.id.container);
            if (this.a == null) {
                this.a = (ViewGroup) findViewById(R.id.parent);
            }
            this.b = findViewById(R.id.title);
            this.c = (ImageView) findViewById(R.id.back);
            if (this.c != null) {
                this.c.setOnClickListener(new ab(this));
            }
            this.d = (TextView) findViewById(R.id.title_text);
            this.e = (ListView) findViewById(R.id.list);
        }
        com.baidu.tieba.util.x.a(this.c, i);
        com.baidu.tieba.util.x.d(this.b, i);
        com.baidu.tieba.util.x.f(this.d, i);
        if (this.a != null) {
            com.baidu.tieba.util.x.b(this.a, i);
            this.f = (Button) this.a.findViewWithTag("top_more_button");
            com.baidu.tieba.util.x.g((TextView) this.f, i);
        }
        if (this.e != null) {
            if (i == 1) {
                this.e.setBackgroundColor(getResources().getColor(R.color.skin_1_common_bg));
                this.e.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
                this.e.setSelector(R.drawable.list_selector_1);
            } else {
                this.e.setBackgroundColor(getResources().getColor(R.color.backgroundcolor));
                this.e.setDivider(getResources().getDrawable(R.drawable.list_divider));
                this.e.setSelector(R.drawable.list_selector);
            }
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.body_container);
        if (viewGroup != null) {
            be.a(viewGroup, i);
        }
    }
}
