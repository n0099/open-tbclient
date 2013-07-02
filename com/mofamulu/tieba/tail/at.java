package com.mofamulu.tieba.tail;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
class at implements View.OnClickListener {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ List b;
    private final /* synthetic */ TextView c;
    private final /* synthetic */ EditText d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(Activity activity, List list, TextView textView, EditText editText) {
        this.a = activity;
        this.b = list;
        this.c = textView;
        this.d = editText;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog = new Dialog(this.a);
        View inflate = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.tbhp_tail_choser, (ViewGroup) null);
        dialog.setContentView(inflate);
        ListView listView = (ListView) inflate.findViewById(R.id.list);
        listView.setOnItemClickListener(new au(this, this.c, this.b, dialog, this.d, this.a));
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("title", "不使用");
        arrayList.add(hashMap);
        for (an anVar : this.b) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("title", anVar.c);
            arrayList.add(hashMap2);
        }
        listView.setAdapter((ListAdapter) new SimpleAdapter(this.a, arrayList, R.layout.tbhp_tail_choser_item, new String[]{"title"}, new int[]{R.id.title}));
        dialog.setTitle("选择要使用的小尾巴");
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }
}
