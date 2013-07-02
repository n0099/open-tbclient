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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ List b;
    private final /* synthetic */ EditText c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(Activity activity, List list, EditText editText) {
        this.a = activity;
        this.b = list;
        this.c = editText;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog = new Dialog(this.a);
        View inflate = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.tbhp_tail_choser, (ViewGroup) null);
        dialog.setContentView(inflate);
        ListView listView = (ListView) inflate.findViewById(R.id.list);
        listView.setOnItemClickListener(new as(this, this.b, this.c, dialog, this.a));
        ArrayList arrayList = new ArrayList();
        for (String str : this.b) {
            HashMap hashMap = new HashMap();
            hashMap.put("title", str);
            arrayList.add(hashMap);
        }
        listView.setAdapter((ListAdapter) new SimpleAdapter(this.a, arrayList, R.layout.tbhp_tail_choser_item, new String[]{"title"}, new int[]{R.id.title}));
        dialog.setTitle("选择自定义表情");
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }
}
