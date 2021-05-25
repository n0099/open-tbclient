package d.a.n0.f2.c;

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
    public View f54838a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f54839b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54840c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54841d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f54842e;

    public b(Context context) {
        this.f54838a = null;
        this.f54839b = null;
        this.f54840c = null;
        this.f54841d = null;
        this.f54842e = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.f54838a = inflate;
        this.f54839b = (HeadImageView) inflate.findViewById(R.id.zan_list_item_head);
        this.f54840c = (TextView) this.f54838a.findViewById(R.id.zan_list_item_name);
        this.f54841d = (TextView) this.f54838a.findViewById(R.id.zan_list_item_time);
        ImageView imageView = (ImageView) this.f54838a.findViewById(R.id.zan_list_item_line_bottom);
        this.f54842e = imageView;
        imageView.setVisibility(0);
        this.f54838a.setTag(this);
    }

    public static b b(Context context, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            return (b) view.getTag();
        }
        return new b(context);
    }

    public View a() {
        return this.f54838a;
    }

    public void c(String str, String str2, long j, boolean z) {
        this.f54840c.setText(str);
        this.f54839b.setImageDrawable(null);
        this.f54841d.setText(StringHelper.getFormatTime(j));
        this.f54839b.V(str2, 28, false);
    }
}
