package com.mofamulu.tieba.tail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.hp.DragSortListView;
import com.mofamulu.tieba.ch.be;
/* loaded from: classes.dex */
class n extends BaseAdapter implements DragSortListView.DropListener {
    final /* synthetic */ MoreEmotionsActivity a;

    public n(MoreEmotionsActivity moreEmotionsActivity) {
        this.a = moreEmotionsActivity;
        moreEmotionsActivity.m = b.a().c();
    }

    @Override // com.baidu.tieba.hp.DragSortListView.DropListener
    public void a_(int i, int i2) {
        if (i != i2) {
            c cVar = (c) this.a.m.get(i);
            this.a.m.remove(cVar);
            this.a.m.add(i2, cVar);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.tbhp_em_group_item, (ViewGroup) null);
            be.a(view);
        }
        TextView textView = (TextView) view.findViewById(R.id.name);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.item_choosed);
        c cVar = (c) this.a.m.get(i);
        StringBuilder sb = new StringBuilder(32);
        sb.append(cVar.a);
        if (cVar.b) {
            sb.append("[隐藏组]");
        }
        sb.append("/").append(cVar.d.length).append("个");
        textView.setText(sb.toString());
        checkBox.setOnCheckedChangeListener(null);
        checkBox.setChecked(cVar.c);
        checkBox.setOnCheckedChangeListener(new o(this, i));
        return view;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return ((c) this.a.m.get(i)).hashCode();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.a.m.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.m.size();
    }
}
