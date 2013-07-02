package com.mofamulu.tieba.sign;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.be;
import com.mofamulu.tieba.tail.LovedBarListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BaseAdapter {
    final /* synthetic */ AccountSelectBarsToSignActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(AccountSelectBarsToSignActivity accountSelectBarsToSignActivity) {
        this.a = accountSelectBarsToSignActivity;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.tbhp_select_bar_item, (ViewGroup) null);
            be.a(view);
        }
        TextView textView = (TextView) view.findViewById(R.id.name);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.item_choosed);
        if (this.a.l != null && this.a.l.size() > i) {
            au auVar = (au) this.a.l.get(i);
            textView.setText(String.valueOf(auVar.b) + " (" + auVar.d + "级[" + LovedBarListActivity.b(auVar.c) + "])");
            checkBox.setOnCheckedChangeListener(null);
            checkBox.setChecked(auVar.e);
            checkBox.setOnCheckedChangeListener(new w(this, auVar));
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
        if (this.a.l == null) {
            return 0;
        }
        return this.a.l.size();
    }
}
