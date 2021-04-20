package d.b.i0.e2.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f55648a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f55649b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55650c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55651d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f55652e;

    public b(Context context) {
        this.f55648a = null;
        this.f55649b = null;
        this.f55650c = null;
        this.f55651d = null;
        this.f55652e = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.f55648a = inflate;
        this.f55649b = (HeadImageView) inflate.findViewById(R.id.zan_list_item_head);
        this.f55650c = (TextView) this.f55648a.findViewById(R.id.zan_list_item_name);
        this.f55651d = (TextView) this.f55648a.findViewById(R.id.zan_list_item_time);
        ImageView imageView = (ImageView) this.f55648a.findViewById(R.id.zan_list_item_line_bottom);
        this.f55652e = imageView;
        imageView.setVisibility(0);
        this.f55648a.setTag(this);
    }

    public static b b(Context context, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            return (b) view.getTag();
        }
        return new b(context);
    }

    public View a() {
        return this.f55648a;
    }

    public void c(String str, String str2, long j, boolean z) {
        this.f55650c.setText(str);
        this.f55649b.setImageDrawable(null);
        this.f55651d.setText(StringHelper.getFormatTime(j));
        this.f55649b.W(str2, 28, false);
    }
}
