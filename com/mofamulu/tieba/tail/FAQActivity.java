package com.mofamulu.tieba.tail;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONTokener;
/* loaded from: classes.dex */
public class FAQActivity extends com.mofamulu.tieba.ch.aa {
    ListView g;
    ProgressBar j;
    Handler k = new d(this);

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setContentView(R.layout.tbhp_faq_list);
        b();
        super.onCreate(bundle);
        com.mofamulu.tieba.ch.a.a(new e(this));
    }

    protected void b() {
        this.g = (ListView) findViewById(R.id.list);
        this.j = (ProgressBar) findViewById(R.id.progress);
        this.j.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(JSONArray jSONArray) {
        this.j.setVisibility(8);
        this.g.setAdapter((ListAdapter) new f(this, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        try {
            Message message = new Message();
            message.what = 1;
            message.obj = (JSONArray) new JSONTokener(com.mofamulu.tieba.ch.au.c(this, "http://book.mofamulu.com/api/android/faqs.jsp?v=" + getString(R.string.tbhp_version_num)).trim()).nextValue();
            this.k.sendMessage(message);
        } catch (Throwable th) {
            c("错误：" + th.getMessage());
        }
    }

    protected void c(String str) {
        Message message = new Message();
        message.what = 2;
        message.obj = str;
        this.k.sendMessage(message);
    }
}
