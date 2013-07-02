package com.mofamulu.tieba.sign;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.be;
/* loaded from: classes.dex */
class n extends BaseAdapter {
    final /* synthetic */ AccountListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AccountListActivity accountListActivity) {
        this.a = accountListActivity;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.tbhp_sign_item, (ViewGroup) null);
            be.a(view);
        }
        TextView textView = (TextView) view.findViewById(R.id.title);
        TextView textView2 = (TextView) view.findViewById(R.id.info);
        if (this.a.k != null && this.a.k.size() > i) {
            al alVar = (al) this.a.k.get(i);
            String str = alVar.a;
            if (this.a.l.a(str, false)) {
                if (this.a.l.v()) {
                    str = String.valueOf(str) + "[VIP--第二签到]";
                } else {
                    str = String.valueOf(str) + "[VIP--手机签到]";
                }
            }
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            textView2.setText(alVar.i());
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
