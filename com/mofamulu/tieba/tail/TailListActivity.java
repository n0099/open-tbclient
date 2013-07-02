package com.mofamulu.tieba.tail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.baidu.tieba.R;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.write.WriteActivity;
import com.mofamulu.tieba.ch.bf;
import com.mofamulu.tieba.ch.bg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class TailListActivity extends com.mofamulu.tieba.ch.aa {
    public static boolean g = false;
    public static boolean j = false;
    public static int k;
    protected bg l;
    protected boolean m;
    private ListView n;
    private Button o;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.m = getIntent().getBooleanExtra("lzl", false);
        setContentView(R.layout.tbhp_tail_list);
        this.l = bg.c();
        b();
        super.onCreate(bundle);
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        g = true;
        j = this.m;
        k = i;
        WriteActivity.a(this, "0", "设置小尾巴", antiData);
    }

    protected void b() {
        this.o = (Button) findViewById(R.id.add);
        this.n = (ListView) findViewById(R.id.list);
        this.o.setOnClickListener(new ao(this));
        this.n.setClickable(true);
        this.n.setOnItemClickListener(new ap(this));
    }

    protected void c() {
        String a = bg.a();
        if (bf.a(a)) {
            this.o.setEnabled(false);
            Toast.makeText(this, "请先登录在添加小尾巴", 1).show();
            return;
        }
        List<an> c = this.m ? this.l.c(a) : this.l.b(a);
        ArrayList arrayList = new ArrayList();
        if (c != null) {
            for (an anVar : c) {
                HashMap hashMap = new HashMap();
                hashMap.put("title", anVar.c);
                hashMap.put("info", anVar.d);
                arrayList.add(hashMap);
            }
        }
        this.n.setAdapter((ListAdapter) new SimpleAdapter(this, arrayList, R.layout.tbhp_tail_item, new String[]{"title", "info"}, new int[]{R.id.title, R.id.info}));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        c();
    }
}
