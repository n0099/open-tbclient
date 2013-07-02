package com.mofamulu.tieba.sms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.be;
/* loaded from: classes.dex */
class q extends BaseAdapter {
    final /* synthetic */ SMSOutlineActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(SMSOutlineActivity sMSOutlineActivity) {
        this.a = sMSOutlineActivity;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.tbhp_sms_item, (ViewGroup) null);
            be.a(view);
        }
        TextView textView = (TextView) view.findViewById(R.id.message_person);
        f fVar = (f) this.a.l.b.get(i);
        ((TextView) view.findViewById(R.id.title)).setText(String.valueOf(fVar.b) + "：" + fVar.g);
        ((TextView) view.findViewById(R.id.info)).setText(fVar.h);
        if (fVar.j > 0) {
            textView.setText(String.valueOf(fVar.j));
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
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
        return this.a.l.b.size();
    }
}
