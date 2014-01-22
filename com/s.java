package com;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.cloudsdk.social.restapi.SocialRestAPIImpl;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
import com.baidu.cloudsdk.social.share.uiwithlayout.SwitchButton;
import java.util.List;
/* loaded from: classes.dex */
public class s extends ArrayAdapter {
    private t a;
    private SocialShareConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Context context, List list, t tVar) {
        super(context, 0, list);
        int i = 0;
        this.a = tVar;
        this.b = SocialShareConfig.getInstance(context);
        String string = this.b.getString("unbind");
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            ShareMediaItem shareMediaItem = (ShareMediaItem) list.get(i2);
            if (shareMediaItem.isAuthorized() && !TextUtils.isEmpty(shareMediaItem.getUserName())) {
                a(context, shareMediaItem);
            } else if (!shareMediaItem.isAuthorized()) {
                shareMediaItem.setUserName(string);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareMediaItem shareMediaItem, boolean z) {
        shareMediaItem.setAuthorized(z);
        shareMediaItem.setChecked(z);
        if (z) {
            a(getContext(), shareMediaItem);
            this.a.onCheckStatusChanged(true, shareMediaItem.getMediaType());
        }
        notifyDataSetChanged();
    }

    protected void a(Context context, ShareMediaItem shareMediaItem) {
        new SocialRestAPIImpl(context).getUserInfo(shareMediaItem.getMediaType().toString(), new ac(this, shareMediaItem));
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        v vVar;
        TextView textView;
        TextView textView2;
        ImageView imageView;
        TextView textView3;
        TextView textView4;
        SwitchButton switchButton;
        SwitchButton switchButton2;
        SwitchButton switchButton3;
        if (view == null || view.getTag() == null) {
            vVar = new v(this, null);
            view = LayoutInflater.from(getContext()).inflate(i.a(getContext(), "bdsocialshare_sharedialogmediaitemlayout"), (ViewGroup) null);
            vVar.b = (ImageView) view.findViewById(i.d(getContext(), "sharedialog_mediaitem_iconview"));
            vVar.c = (TextView) view.findViewById(i.d(getContext(), "sharedialog_mediaitem_nameview"));
            textView = vVar.c;
            textView.setTextColor(Color.parseColor(i.a(getContext())));
            vVar.d = (TextView) view.findViewById(i.d(getContext(), "sharedialog_mediaitem_desview"));
            textView2 = vVar.d;
            textView2.setTextColor(Color.parseColor(i.i(getContext())));
            vVar.e = (SwitchButton) view.findViewById(i.d(getContext(), "sharedialog_mediaitem_switchbutton"));
            view.setTag(vVar);
        } else {
            vVar = (v) view.getTag();
        }
        ShareMediaItem shareMediaItem = (ShareMediaItem) getItem(i);
        int c = shareMediaItem.isChecked() ? i.c(getContext(), "bdsocialshare_" + shareMediaItem.getMediaType().toString()) : i.c(getContext(), "bdsocialshare_" + shareMediaItem.getMediaType().toString() + "_gray");
        imageView = vVar.b;
        imageView.setImageResource(c);
        textView3 = vVar.c;
        textView3.setText(this.b.getString(shareMediaItem.getMediaType().toString()));
        textView4 = vVar.d;
        textView4.setText(shareMediaItem.getUserName());
        switchButton = vVar.e;
        switchButton.setTag(shareMediaItem);
        switchButton2 = vVar.e;
        switchButton2.setOnCheckedChangeListener(new w(this, vVar));
        switchButton3 = vVar.e;
        switchButton3.setChecked(shareMediaItem.isChecked());
        return view;
    }
}
