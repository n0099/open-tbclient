package d.a.o0.f2.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f58652a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f58653b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58654c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58655d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f58656e;

    public b(Context context) {
        this.f58652a = null;
        this.f58653b = null;
        this.f58654c = null;
        this.f58655d = null;
        this.f58656e = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.f58652a = inflate;
        this.f58653b = (HeadImageView) inflate.findViewById(R.id.zan_list_item_head);
        this.f58654c = (TextView) this.f58652a.findViewById(R.id.zan_list_item_name);
        this.f58655d = (TextView) this.f58652a.findViewById(R.id.zan_list_item_time);
        ImageView imageView = (ImageView) this.f58652a.findViewById(R.id.zan_list_item_line_bottom);
        this.f58656e = imageView;
        imageView.setVisibility(0);
        this.f58652a.setTag(this);
    }

    public static b b(Context context, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            return (b) view.getTag();
        }
        return new b(context);
    }

    public View a() {
        return this.f58652a;
    }

    public void c(String str, String str2, long j, boolean z) {
        this.f58654c.setText(str);
        this.f58653b.setImageDrawable(null);
        this.f58655d.setText(StringHelper.getFormatTime(j));
        this.f58653b.U(str2, 28, false);
    }
}
