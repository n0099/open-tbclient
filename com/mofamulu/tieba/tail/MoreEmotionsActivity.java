package com.mofamulu.tieba.tail;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.hp.DragSortListView;
import com.mofamulu.tieba.ch.bg;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MoreEmotionsActivity extends com.mofamulu.tieba.ch.aa {
    TextView g;
    DragSortListView j;
    Button k;
    protected bg l;
    protected LinkedList m;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = bg.c();
        setContentView(R.layout.tbhp_em_group_list);
        b();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.ch.aa, com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        b.a().a(this.m);
    }

    protected void b() {
        this.k = (Button) findViewById(R.id.add);
        this.g = (TextView) findViewById(R.id.content_text);
        this.j = (DragSortListView) findViewById(R.id.list);
        this.j.setAdapter((ListAdapter) new n(this));
    }

    protected void c() {
        this.k.setOnClickListener(new m(this));
    }
}
