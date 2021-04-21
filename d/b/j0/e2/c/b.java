package d.b.j0.e2.c;

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
    public View f56069a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f56070b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56071c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56072d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f56073e;

    public b(Context context) {
        this.f56069a = null;
        this.f56070b = null;
        this.f56071c = null;
        this.f56072d = null;
        this.f56073e = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.f56069a = inflate;
        this.f56070b = (HeadImageView) inflate.findViewById(R.id.zan_list_item_head);
        this.f56071c = (TextView) this.f56069a.findViewById(R.id.zan_list_item_name);
        this.f56072d = (TextView) this.f56069a.findViewById(R.id.zan_list_item_time);
        ImageView imageView = (ImageView) this.f56069a.findViewById(R.id.zan_list_item_line_bottom);
        this.f56073e = imageView;
        imageView.setVisibility(0);
        this.f56069a.setTag(this);
    }

    public static b b(Context context, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
            return (b) view.getTag();
        }
        return new b(context);
    }

    public View a() {
        return this.f56069a;
    }

    public void c(String str, String str2, long j, boolean z) {
        this.f56071c.setText(str);
        this.f56070b.setImageDrawable(null);
        this.f56072d.setText(StringHelper.getFormatTime(j));
        this.f56070b.W(str2, 28, false);
    }
}
