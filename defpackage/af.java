package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.assets.DrawableUtils;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.restapi.SocialRestAPIImpl;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.cloudsdk.social.share.ui.MediaIconManager;
import java.util.List;
/* renamed from: af  reason: default package */
/* loaded from: classes.dex */
public class af extends ArrayAdapter {

    /* renamed from: a  reason: collision with root package name */
    private aj f265a;
    private SocialShareConfig b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(Context context, List list, aj ajVar) {
        super(context, 0, list);
        int i = 0;
        this.f265a = ajVar;
        this.b = SocialShareConfig.getInstance(context);
        String string = this.b.getString("unbind");
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            at atVar = (at) list.get(i2);
            if (atVar.d() && !TextUtils.isEmpty(atVar.b())) {
                a(context, atVar);
            } else if (!atVar.d()) {
                atVar.a(string);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(at atVar, boolean z) {
        atVar.b(z);
        atVar.a(z);
        if (z) {
            a(getContext(), atVar);
            if (atVar.a() == MediaType.QZONE) {
                this.f265a.onCheckStatusChanged(true);
            }
        }
        notifyDataSetChanged();
    }

    protected void a(Context context, at atVar) {
        new SocialRestAPIImpl(context).getUserInfo(atVar.a().toString(), new as(this, atVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0020, code lost:
        if (r0 == null) goto L8;
     */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        RelativeLayout relativeLayout;
        Context context = getContext();
        at atVar = (at) getItem(i);
        String mediaType = atVar.a().toString();
        MediaIconManager mediaIconManager = MediaIconManager.getInstance(getContext());
        if (view != null) {
            Object tag = view.getTag();
            relativeLayout = view;
        }
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, DrawableUtils.fix720px(context, 96)));
        ImageView imageView = new ImageView(context);
        imageView.setId(200);
        imageView.setImageDrawable(atVar.c() ? mediaIconManager.getNormalIcon(mediaType) : mediaIconManager.getDisabledIcon(mediaType));
        int fix720px = DrawableUtils.fix720px(context, 96);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(fix720px, fix720px);
        layoutParams.rightMargin = DrawableUtils.fix720px(context, 18);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        relativeLayout2.addView(imageView, layoutParams);
        TextView textView = new TextView(context);
        textView.setId(201);
        textView.setText(this.b.getString(mediaType));
        textView.setTextColor(-12829636);
        textView.setTextSize(0, DrawableUtils.fix720px(context, 28));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, 200);
        layoutParams2.topMargin = DrawableUtils.fix720px(context, 14);
        relativeLayout2.addView(textView, layoutParams2);
        TextView textView2 = new TextView(context);
        textView2.setId(202);
        textView2.setText(atVar.b());
        textView2.setTextColor(-6052957);
        textView2.setTextSize(0, DrawableUtils.fix720px(context, 24));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(1, 200);
        layoutParams3.addRule(3, 201);
        relativeLayout2.addView(textView2, layoutParams3);
        ba baVar = new ba(context);
        baVar.setChecked(atVar.c());
        baVar.setOnCheckedChangeListener(new an(this, atVar, mediaIconManager, mediaType, imageView, context, baVar));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(DrawableUtils.fix720px(context, 126), DrawableUtils.fix720px(context, 60));
        layoutParams4.addRule(11);
        layoutParams4.addRule(15, -1);
        layoutParams4.rightMargin = DrawableUtils.fix720px(context, 6);
        relativeLayout2.addView(baVar, layoutParams4);
        relativeLayout = relativeLayout2;
        ((TextView) relativeLayout.findViewById(202)).setText(atVar.b());
        return relativeLayout;
    }
}
