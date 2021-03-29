package d.b.i0.d2.c;

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
    public View f54126a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f54127b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54128c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54129d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f54130e;

    public b(Context context) {
        this.f54126a = null;
        this.f54127b = null;
        this.f54128c = null;
        this.f54129d = null;
        this.f54130e = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.f54126a = inflate;
        this.f54127b = (HeadImageView) inflate.findViewById(R.id.zan_list_item_head);
        this.f54128c = (TextView) this.f54126a.findViewById(R.id.zan_list_item_name);
        this.f54129d = (TextView) this.f54126a.findViewById(R.id.zan_list_item_time);
        ImageView imageView = (ImageView) this.f54126a.findViewById(R.id.zan_list_item_line_bottom);
        this.f54130e = imageView;
        imageView.setVisibility(0);
        this.f54126a.setTag(this);
    }

    public static b b(Context context, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            return (b) view.getTag();
        }
        return new b(context);
    }

    public View a() {
        return this.f54126a;
    }

    public void c(String str, String str2, long j, boolean z) {
        this.f54128c.setText(str);
        this.f54127b.setImageDrawable(null);
        this.f54129d.setText(StringHelper.getFormatTime(j));
        this.f54127b.W(str2, 28, false);
    }
}
