package com.mofamulu.tieba.sms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.be;
/* loaded from: classes.dex */
class m extends BaseAdapter {
    final /* synthetic */ SMSChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SMSChatActivity sMSChatActivity) {
        this.a = sMSChatActivity;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.tbhp_sms_chat_item, (ViewGroup) null);
            view.setEnabled(false);
            be.a(view);
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.wrapper);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.chat_message_container);
        TextView textView = (TextView) view.findViewById(R.id.chat_message);
        TextView textView2 = (TextView) view.findViewById(R.id.time);
        if (this.a.p != null && this.a.p.size() > i) {
            a aVar = (a) this.a.p.get(i);
            textView.setText(String.valueOf(aVar.b) + "：" + aVar.c);
            textView2.setText(aVar.d);
            if ("我".equals(aVar.b)) {
                linearLayout.setGravity(5);
                linearLayout2.setBackgroundResource(R.drawable.bubble_right);
            } else {
                linearLayout.setGravity(3);
                linearLayout2.setBackgroundResource(R.drawable.bubble_left);
            }
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
        if (this.a.p == null) {
            return 0;
        }
        return this.a.p.size();
    }
}
