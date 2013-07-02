package com.mofamulu.tieba.tail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.be;
/* loaded from: classes.dex */
class h extends BaseAdapter {
    final /* synthetic */ LovedBarListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LovedBarListActivity lovedBarListActivity) {
        this.a = lovedBarListActivity;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.edit_bar_item, (ViewGroup) null);
            be.a(view);
        }
        TextView textView = (TextView) view.findViewById(R.id.name);
        TextView textView2 = (TextView) view.findViewById(R.id.degree);
        if (this.a.k != null && this.a.k.size() > i) {
            com.mofamulu.tieba.sign.au auVar = (com.mofamulu.tieba.sign.au) this.a.k.get(i);
            textView.setText(auVar.b);
            textView2.setText(String.valueOf(auVar.d) + "级[" + LovedBarListActivity.b(auVar.c) + "]");
        }
        return view;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a.k == null) {
            return 0;
        }
        return this.a.k.size();
    }
}
