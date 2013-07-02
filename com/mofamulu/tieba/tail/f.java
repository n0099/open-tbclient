package com.mofamulu.tieba.tail;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    final /* synthetic */ FAQActivity a;
    private final /* synthetic */ JSONArray b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FAQActivity fAQActivity, JSONArray jSONArray) {
        this.a = fAQActivity;
        this.b = jSONArray;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.length();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.tbhp_faq_item, (ViewGroup) null);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.faq_title_container);
        ViewGroup viewGroup3 = (ViewGroup) inflate.findViewById(R.id.faq_content_container);
        TextView textView = (TextView) inflate.findViewById(R.id.faq_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.faq_content);
        viewGroup3.setVisibility(8);
        viewGroup2.setBackgroundResource(R.drawable.more_all);
        g gVar = new g(this, viewGroup3, viewGroup2);
        viewGroup2.setOnClickListener(gVar);
        viewGroup3.setOnClickListener(gVar);
        try {
            JSONObject jSONObject = this.b.getJSONObject(i);
            textView.setText(jSONObject.optString("title", "Untitled"));
            textView2.setText(jSONObject.optString(PushConstants.EXTRA_CONTENT, "......"));
            if (jSONObject.optString("color1", "").length() > 0) {
                textView.setTextColor(Color.parseColor(jSONObject.optString("color1", "#000000")));
            }
            if (jSONObject.optString("color2", "").length() > 0) {
                textView2.setTextColor(Color.parseColor(jSONObject.optString("color2", "#000000")));
            }
        } catch (Exception e) {
            Log.e("tbhp_help", "parse faq failed.", e);
        }
        return inflate;
    }
}
