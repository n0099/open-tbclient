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
    public View f58527a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f58528b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58529c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58530d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f58531e;

    public b(Context context) {
        this.f58527a = null;
        this.f58528b = null;
        this.f58529c = null;
        this.f58530d = null;
        this.f58531e = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.f58527a = inflate;
        this.f58528b = (HeadImageView) inflate.findViewById(R.id.zan_list_item_head);
        this.f58529c = (TextView) this.f58527a.findViewById(R.id.zan_list_item_name);
        this.f58530d = (TextView) this.f58527a.findViewById(R.id.zan_list_item_time);
        ImageView imageView = (ImageView) this.f58527a.findViewById(R.id.zan_list_item_line_bottom);
        this.f58531e = imageView;
        imageView.setVisibility(0);
        this.f58527a.setTag(this);
    }

    public static b b(Context context, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            return (b) view.getTag();
        }
        return new b(context);
    }

    public View a() {
        return this.f58527a;
    }

    public void c(String str, String str2, long j, boolean z) {
        this.f58529c.setText(str);
        this.f58528b.setImageDrawable(null);
        this.f58530d.setText(StringHelper.getFormatTime(j));
        this.f58528b.U(str2, 28, false);
    }
}
