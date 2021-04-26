package d.a.j0.e2.c;

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
    public View f53941a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f53942b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53943c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53944d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f53945e;

    public b(Context context) {
        this.f53941a = null;
        this.f53942b = null;
        this.f53943c = null;
        this.f53944d = null;
        this.f53945e = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.f53941a = inflate;
        this.f53942b = (HeadImageView) inflate.findViewById(R.id.zan_list_item_head);
        this.f53943c = (TextView) this.f53941a.findViewById(R.id.zan_list_item_name);
        this.f53944d = (TextView) this.f53941a.findViewById(R.id.zan_list_item_time);
        ImageView imageView = (ImageView) this.f53941a.findViewById(R.id.zan_list_item_line_bottom);
        this.f53945e = imageView;
        imageView.setVisibility(0);
        this.f53941a.setTag(this);
    }

    public static b b(Context context, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            return (b) view.getTag();
        }
        return new b(context);
    }

    public View a() {
        return this.f53941a;
    }

    public void c(String str, String str2, long j, boolean z) {
        this.f53943c.setText(str);
        this.f53942b.setImageDrawable(null);
        this.f53944d.setText(StringHelper.getFormatTime(j));
        this.f53942b.V(str2, 28, false);
    }
}
