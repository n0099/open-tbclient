package d.a.k0.e2.c;

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
    public View f54648a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f54649b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54650c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54651d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f54652e;

    public b(Context context) {
        this.f54648a = null;
        this.f54649b = null;
        this.f54650c = null;
        this.f54651d = null;
        this.f54652e = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.f54648a = inflate;
        this.f54649b = (HeadImageView) inflate.findViewById(R.id.zan_list_item_head);
        this.f54650c = (TextView) this.f54648a.findViewById(R.id.zan_list_item_name);
        this.f54651d = (TextView) this.f54648a.findViewById(R.id.zan_list_item_time);
        ImageView imageView = (ImageView) this.f54648a.findViewById(R.id.zan_list_item_line_bottom);
        this.f54652e = imageView;
        imageView.setVisibility(0);
        this.f54648a.setTag(this);
    }

    public static b b(Context context, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            return (b) view.getTag();
        }
        return new b(context);
    }

    public View a() {
        return this.f54648a;
    }

    public void c(String str, String str2, long j, boolean z) {
        this.f54650c.setText(str);
        this.f54649b.setImageDrawable(null);
        this.f54651d.setText(StringHelper.getFormatTime(j));
        this.f54649b.V(str2, 28, false);
    }
}
